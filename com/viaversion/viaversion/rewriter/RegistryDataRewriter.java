/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.rewriter;

import ViaVersion.xyz.wagyourtail.jvmdg.j9.stub.java_base.J_U_List;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.data.entity.DimensionData;
import com.viaversion.viaversion.api.minecraft.RegistryEntry;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.data.entity.DimensionDataImpl;
import com.viaversion.viaversion.libs.fastutil.objects.Object2ObjectArrayMap;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.TagUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class RegistryDataRewriter {
    private final Map<String, BiConsumer<String, CompoundTag>> registryEntryHandlers = new Object2ObjectArrayMap<String, BiConsumer<String, CompoundTag>>();
    private final Map<String, Consumer<CompoundTag>> enchantmentEffectHandlers = new Object2ObjectArrayMap<String, Consumer<CompoundTag>>();
    private final Map<String, List<RegistryEntry>> toAdd = new Object2ObjectArrayMap<String, List<RegistryEntry>>();
    private final Set<String> toRemove = new HashSet<String>();
    protected final Protocol<?, ?, ?, ?> protocol;

    public RegistryDataRewriter(Protocol<?, ?, ?, ?> protocol) {
        this.protocol = protocol;
    }

    public void handle(PacketWrapper wrapper) {
        String registryKey = Key.stripMinecraftNamespace(wrapper.passthrough(Types.STRING));
        RegistryEntry[] entries = wrapper.read(Types.REGISTRY_ENTRY_ARRAY);
        entries = this.handle(wrapper.user(), registryKey, entries);
        wrapper.write(Types.REGISTRY_ENTRY_ARRAY, entries);
        if (this.toRemove.contains(registryKey)) {
            wrapper.cancel();
        }
    }

    public RegistryEntry[] handle(UserConnection connection, String key, RegistryEntry[] entries) {
        List<RegistryEntry> toAdd;
        if ((key = Key.stripMinecraftNamespace(key)).equals("enchantment")) {
            this.updateEnchantments(connection, entries);
        } else if (key.equals("trim_material")) {
            this.updateTrimMaterials(entries);
        } else if (key.equals("jukebox_song")) {
            this.updateJukeboxSongs(entries);
        }
        BiConsumer<String, CompoundTag> registryEntryHandler = this.registryEntryHandlers.get(key);
        if (registryEntryHandler != null) {
            for (RegistryEntry entry : entries) {
                if (entry.tag() == null) continue;
                CompoundTag tag = (CompoundTag)entry.tag();
                registryEntryHandler.accept(entry.key(), tag);
            }
        }
        if ((toAdd = this.toAdd.get(key)) != null) {
            HashSet<String> existingKeys = new HashSet<String>();
            RegistryEntry[] updatedEntries = new RegistryEntry[entries.length + toAdd.size()];
            int index = 0;
            for (RegistryEntry entry : entries) {
                updatedEntries[index++] = entry;
                existingKeys.add(entry.key());
            }
            for (RegistryEntry entry : toAdd) {
                if (existingKeys.contains(entry.key())) continue;
                updatedEntries[index++] = entry.copy();
            }
            entries = index < updatedEntries.length ? Arrays.copyOf(updatedEntries, index) : updatedEntries;
        }
        this.trackDimensionAndBiomes(connection, key, entries);
        return entries;
    }

    public void addEntries(String registryKey, RegistryEntry ... entries) {
        this.toAdd.computeIfAbsent(Key.stripMinecraftNamespace(registryKey), $ -> new ArrayList()).addAll(J_U_List.of(entries));
    }

    public void remove(String registryKey) {
        this.toRemove.add(Key.stripMinecraftNamespace(registryKey));
    }

    public void addHandler(String registryKey, BiConsumer<String, CompoundTag> handler) {
        this.registryEntryHandlers.put(Key.stripMinecraftNamespace(registryKey), handler);
    }

    public void addEnchantmentEffectRewriter(String key, Consumer<CompoundTag> rewriter) {
        this.enchantmentEffectHandlers.put(Key.stripMinecraftNamespace(key), rewriter);
    }

    public void trackDimensionAndBiomes(UserConnection connection, String registryKey, RegistryEntry[] entries) {
        if (registryKey.equals("worldgen/biome")) {
            this.protocol.getEntityRewriter().tracker(connection).setBiomesSent(entries.length);
        } else if (registryKey.equals("dimension_type")) {
            HashMap<String, DimensionData> dimensionDataMap = new HashMap<String, DimensionData>(entries.length);
            for (int i2 = 0; i2 < entries.length; ++i2) {
                RegistryEntry entry = entries[i2];
                String key = Key.stripMinecraftNamespace(entry.key());
                DimensionData dimensionData = entry.tag() != null ? new DimensionDataImpl(i2, (CompoundTag)entry.tag()) : DimensionDataImpl.withDefaultsFor(key, i2);
                dimensionDataMap.put(key, dimensionData);
            }
            this.protocol.getEntityRewriter().tracker(connection).setDimensions(dimensionDataMap);
        }
    }

    public void updateEnchantments(UserConnection connection, RegistryEntry[] entries) {
        ArrayList<String> identifiers = new ArrayList<String>(entries.length);
        for (RegistryEntry entry : entries) {
            CompoundTag effects;
            identifiers.add(entry.key());
            if (entry.tag() == null) continue;
            CompoundTag tag = (CompoundTag)entry.tag();
            if (this.protocol.getMappingData().getFullItemMappings() != null) {
                this.updateItemList(tag.getListTag("supported_items", StringTag.class));
                this.updateItemList(tag.getListTag("primary_items", StringTag.class));
            }
            if ((effects = tag.getCompoundTag("effects")) == null) continue;
            for (Map.Entry<String, Tag> effectEntry : effects.entrySet()) {
                ListTag listTag;
                Object object = effectEntry.getValue();
                if (object instanceof CompoundTag) {
                    CompoundTag compoundTag = (CompoundTag)object;
                    this.updateNestedEffect(compoundTag);
                    continue;
                }
                object = effectEntry.getValue();
                if (!(object instanceof ListTag) || (listTag = (ListTag)object).getElementType() != CompoundTag.class) continue;
                for (Tag effectTag : listTag) {
                    this.updateNestedEffect((CompoundTag)effectTag);
                }
            }
            this.updateAttributesFields(effects);
        }
        Object itemHasher = connection.getItemHasher(this.protocol.getClass());
        if (itemHasher != null) {
            itemHasher.setEnchantments(identifiers);
        }
    }

    public void updateTrimMaterials(RegistryEntry[] entries) {
        if (this.protocol.getMappingData().getFullItemMappings() == null) {
            return;
        }
        for (RegistryEntry entry : entries) {
            if (entry.tag() == null) continue;
            StringTag ingredientTag = ((CompoundTag)entry.tag()).getStringTag("ingredient");
            if (ingredientTag == null) {
                return;
            }
            this.updateItem(ingredientTag);
        }
    }

    public void updateJukeboxSongs(RegistryEntry[] entries) {
    }

    private void updateNestedEffect(CompoundTag effectsTag) {
        CompoundTag effect = effectsTag.getCompoundTag("effect");
        if (effect == null) {
            return;
        }
        this.runEffectRewriters(effect);
        ListTag<CompoundTag> innerEffects = effect.getListTag("effects", CompoundTag.class);
        if (innerEffects == null) {
            return;
        }
        for (CompoundTag innerEffect : innerEffects) {
            this.runEffectRewriters(innerEffect);
        }
    }

    private void updateAttributesFields(CompoundTag effects) {
        if (!this.hasAttributeMappings()) {
            return;
        }
        ListTag<CompoundTag> attributesList = TagUtil.getNamespacedCompoundTagList(effects, "attributes");
        if (attributesList == null) {
            return;
        }
        for (CompoundTag attributeData : attributesList) {
            this.updateAttributeField(attributeData);
        }
    }

    private void runEffectRewriters(CompoundTag effectTag) {
        String effect = effectTag.getString("type");
        if (effect == null) {
            return;
        }
        this.updateAttributeField(effectTag);
        Consumer<CompoundTag> rewriter = this.enchantmentEffectHandlers.get(Key.stripMinecraftNamespace(effect));
        if (rewriter != null) {
            rewriter.accept(effectTag);
        }
    }

    private void updateAttributeField(CompoundTag attributeData) {
        String attribute;
        StringTag attributeTag = attributeData.getStringTag("attribute");
        if (attributeTag == null) {
            return;
        }
        FullMappings mappings = this.protocol.getMappingData().getAttributeMappings();
        String mappedAttribute = mappings.mappedIdentifier(attribute = Key.stripMinecraftNamespace(attributeTag.getValue()));
        if (mappedAttribute == null) {
            mappedAttribute = mappings.mappedIdentifier(0);
        }
        attributeTag.setValue(mappedAttribute);
    }

    private boolean hasAttributeMappings() {
        return this.protocol.getMappingData() != null && this.protocol.getMappingData().getAttributeMappings() != null;
    }

    private void updateItemList(ListTag<StringTag> listTag) {
        if (listTag == null) {
            return;
        }
        for (StringTag tag : listTag) {
            this.updateItem(tag);
        }
    }

    private void updateItem(StringTag tag) {
        String mapped = this.protocol.getMappingData().getFullItemMappings().mappedIdentifier(tag.getValue());
        if (mapped != null) {
            tag.setValue(mapped);
        }
    }
}

