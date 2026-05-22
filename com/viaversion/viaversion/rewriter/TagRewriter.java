/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.rewriter;

import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.minecraft.RegistryType;
import com.viaversion.viaversion.api.minecraft.TagData;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.fastutil.ints.IntArrayList;
import com.viaversion.viaversion.rewriter.IdRewriteFunction;
import com.viaversion.viaversion.util.Key;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={1.class})
public class TagRewriter<C extends ClientboundPacketType>
implements com.viaversion.viaversion.api.rewriter.TagRewriter {
    private static final int[] EMPTY_ARRAY = new int[0];
    private final Map<RegistryType, List<TagData>> toAdd = new EnumMap<RegistryType, List<TagData>>(RegistryType.class);
    private final Map<RegistryType, Map<String, String>> toRename = new EnumMap<RegistryType, Map<String, String>>(RegistryType.class);
    private final Map<RegistryType, Set<String>> toRemove = new EnumMap<RegistryType, Set<String>>(RegistryType.class);
    private final Set<String> toRemoveRegistries = new HashSet<String>();
    private final Protocol<C, ?, ?, ?> protocol;

    public TagRewriter(Protocol<C, ?, ?, ?> protocol) {
        this.protocol = protocol;
    }

    @Override
    public void onMappingDataLoaded() {
        if (this.protocol.getMappingData() == null) {
            return;
        }
        for (RegistryType type : RegistryType.getValues()) {
            List<TagData> tags = this.protocol.getMappingData().getTags(type);
            if (tags == null) continue;
            this.getOrComputeNewTags(type).addAll(tags);
        }
    }

    @Override
    public void removeTags(String registryKey) {
        this.toRemoveRegistries.add(Key.stripMinecraftNamespace(registryKey));
    }

    @Override
    public void removeTag(RegistryType type, String tagId) {
        this.toRemove.computeIfAbsent(type, t2 -> new HashSet()).add(Key.stripMinecraftNamespace(tagId));
    }

    @Override
    public void renameTag(RegistryType type, String tagId, String renameTo) {
        this.toRename.computeIfAbsent(type, t2 -> new HashMap()).put(Key.stripMinecraftNamespace(tagId), renameTo);
    }

    @Override
    public void addEmptyTag(RegistryType tagType, String tagId) {
        this.getOrComputeNewTags(tagType).add(new TagData(tagId, EMPTY_ARRAY));
    }

    @Override
    public void addEmptyTags(RegistryType tagType, String ... tagIds) {
        List<TagData> tagList = this.getOrComputeNewTags(tagType);
        for (String id : tagIds) {
            tagList.add(new TagData(id, EMPTY_ARRAY));
        }
    }

    @Override
    public void addEntityTag(String tagId, EntityType ... entities) {
        int[] ids = new int[entities.length];
        for (int i2 = 0; i2 < entities.length; ++i2) {
            ids[i2] = entities[i2].getId();
        }
        this.addTagRaw(RegistryType.ENTITY, tagId, ids);
    }

    @Override
    public void addTag(RegistryType tagType, String tagId, int ... unmappedIds) {
        List<TagData> newTags = this.getOrComputeNewTags(tagType);
        IdRewriteFunction rewriteFunction = this.getRewriter(tagType);
        if (rewriteFunction != null) {
            for (int i2 = 0; i2 < unmappedIds.length; ++i2) {
                int unmappedId = unmappedIds[i2];
                unmappedIds[i2] = rewriteFunction.rewrite(unmappedId);
            }
        }
        newTags.add(new TagData(tagId, unmappedIds));
    }

    @Override
    public void addTagRaw(RegistryType tagType, String tagId, int ... ids) {
        this.getOrComputeNewTags(tagType).add(new TagData(tagId, ids));
    }

    public void register(C packetType, @Nullable RegistryType readUntilType) {
        this.protocol.registerClientbound(packetType, this.getHandler(readUntilType));
    }

    public void registerGeneric(C packetType) {
        this.protocol.registerClientbound(packetType, this::handleGeneric);
    }

    public PacketHandler getHandler(@Nullable RegistryType readUntilType) {
        return wrapper -> {
            for (RegistryType type : RegistryType.getValues()) {
                this.handle(wrapper, type);
                if (type == readUntilType) break;
            }
        };
    }

    public void handleGeneric(PacketWrapper wrapper) {
        int length;
        int finalLength = length = wrapper.passthrough(Types.VAR_INT).intValue();
        EnumSet<RegistryType> readTypes = EnumSet.noneOf(RegistryType.class);
        for (int i2 = 0; i2 < length; ++i2) {
            String registryKey = wrapper.read(Types.STRING);
            String strippedKey = Key.stripMinecraftNamespace(registryKey);
            if (this.toRemoveRegistries.contains(strippedKey)) {
                --finalLength;
                int tagsSize = wrapper.read(Types.VAR_INT);
                for (int j2 = 0; j2 < tagsSize; ++j2) {
                    wrapper.read(Types.STRING);
                    wrapper.read(Types.VAR_INT_ARRAY_PRIMITIVE);
                }
                continue;
            }
            wrapper.write(Types.STRING, registryKey);
            RegistryType type = RegistryType.getByKey(strippedKey);
            if (type != null) {
                this.handle(wrapper, type);
                readTypes.add(type);
                continue;
            }
            this.handle(wrapper, null, null, null, null);
        }
        for (Map.Entry<RegistryType, List<TagData>> entry : this.toAdd.entrySet()) {
            if (readTypes.contains((Object)entry.getKey())) continue;
            wrapper.write(Types.STRING, entry.getKey().resourceLocation());
            this.appendNewTags(wrapper, entry.getKey());
            ++finalLength;
        }
        if (length != finalLength) {
            wrapper.set(Types.VAR_INT, 0, finalLength);
        }
    }

    public void handle(PacketWrapper wrapper, String registryKey) {
        RegistryType type = RegistryType.getByKey(registryKey);
        if (type != null) {
            this.handle(wrapper, type);
        } else {
            this.handle(wrapper, null, null, null, null);
        }
    }

    public void handle(PacketWrapper wrapper, RegistryType registryType) {
        this.handle(wrapper, this.getRewriter(registryType), this.getNewTags(registryType), this.toRename.get((Object)registryType), this.toRemove.get((Object)registryType));
    }

    protected void handle(PacketWrapper wrapper, @Nullable IdRewriteFunction rewriteFunction, @Nullable List<TagData> newTags, @Nullable Map<String, String> tagsToRename, @Nullable Set<String> tagsToRemove) {
        int tagsSize = wrapper.read(Types.VAR_INT);
        ArrayList<TagData> tags = new ArrayList<TagData>(newTags != null ? tagsSize + newTags.size() : tagsSize);
        HashSet<String> currentTags = new HashSet<String>(tagsSize);
        for (int i2 = 0; i2 < tagsSize; ++i2) {
            String renamedKey;
            String key = wrapper.read(Types.STRING);
            if (tagsToRename != null && (renamedKey = tagsToRename.get(Key.stripMinecraftNamespace(key))) != null) {
                key = renamedKey;
            }
            int[] ids = wrapper.read(Types.VAR_INT_ARRAY_PRIMITIVE);
            if (rewriteFunction != null) {
                IntArrayList idList = new IntArrayList(ids.length);
                for (int id : ids) {
                    int mappedId = rewriteFunction.rewrite(id);
                    if (mappedId == -1) continue;
                    idList.add(mappedId);
                }
                ids = idList.toArray(EMPTY_ARRAY);
            }
            tags.add(new TagData(key, ids));
            currentTags.add(Key.stripMinecraftNamespace(key));
        }
        if (tagsToRemove != null) {
            tags.removeIf(tag -> tagsToRemove.contains(Key.stripMinecraftNamespace(tag.identifier())));
        }
        if (newTags != null) {
            for (TagData tag2 : newTags) {
                if (currentTags.contains(Key.stripMinecraftNamespace(tag2.identifier()))) continue;
                tags.add(tag2);
            }
        }
        wrapper.write(Types.VAR_INT, tags.size());
        for (TagData tag2 : tags) {
            wrapper.write(Types.STRING, tag2.identifier());
            wrapper.write(Types.VAR_INT_ARRAY_PRIMITIVE, tag2.entries());
        }
    }

    public void appendNewTags(PacketWrapper wrapper, RegistryType type) {
        List<TagData> newTags = this.getNewTags(type);
        if (newTags != null) {
            wrapper.write(Types.VAR_INT, newTags.size());
            for (TagData tag : newTags) {
                wrapper.write(Types.STRING, tag.identifier());
                wrapper.write(Types.VAR_INT_ARRAY_PRIMITIVE, (int[])tag.entries().clone());
            }
        } else {
            wrapper.write(Types.VAR_INT, 0);
        }
    }

    @Override
    public @Nullable List<TagData> getNewTags(RegistryType tagType) {
        return this.toAdd.get((Object)tagType);
    }

    @Override
    public List<TagData> getOrComputeNewTags(RegistryType tagType) {
        return this.toAdd.computeIfAbsent(tagType, type -> new ArrayList());
    }

    public @Nullable IdRewriteFunction getRewriter(RegistryType tagType) {
        IdRewriteFunction idRewriteFunction;
        MappingData mappingData = this.protocol.getMappingData();
        switch (tagType) {
            default: {
                throw new IncompatibleClassChangeError();
            }
            case BLOCK: {
                if (mappingData != null && mappingData.getBlockMappings() != null) {
                    idRewriteFunction = mappingData::getNewBlockId;
                    break;
                }
                idRewriteFunction = null;
                break;
            }
            case ITEM: {
                if (mappingData != null && mappingData.getItemMappings() != null) {
                    idRewriteFunction = mappingData::getNewItemId;
                    break;
                }
                idRewriteFunction = null;
                break;
            }
            case ENTITY: {
                if (this.protocol.getEntityRewriter() != null) {
                    idRewriteFunction = id -> this.protocol.getEntityRewriter().newEntityId(id);
                    break;
                }
                idRewriteFunction = null;
                break;
            }
            case ENCHANTMENT: {
                if (mappingData != null && mappingData.getEnchantmentMappings() != null) {
                    idRewriteFunction = id -> mappingData.getEnchantmentMappings().getNewId(id);
                    break;
                }
                idRewriteFunction = null;
                break;
            }
            case FLUID: 
            case GAME_EVENT: {
                idRewriteFunction = null;
            }
        }
        return idRewriteFunction;
    }
}

