/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viabackwards.protocol.v1_21to1_20_5.rewriter;

import ViaBackwards.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.rewriters.EntityRewriter;
import com.viaversion.viabackwards.protocol.v1_21to1_20_5.Protocol1_21To1_20_5;
import com.viaversion.viabackwards.protocol.v1_21to1_20_5.storage.EnchantmentsPaintingsStorage;
import com.viaversion.viabackwards.protocol.v1_21to1_20_5.storage.PlayerRotationStorage;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.PaintingVariant;
import com.viaversion.viaversion.api.minecraft.RegistryEntry;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_20_5;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityDataType;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_20_5;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_20_5;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.data.Paintings1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundConfigurationPackets1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPacket1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPackets1_21;
import com.viaversion.viaversion.rewriter.RegistryDataRewriter;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.KeyMappings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@NestMembers(value={PaintingData.class, 1.class})
public final class EntityPacketRewriter1_21
extends EntityRewriter<ClientboundPacket1_21, Protocol1_21To1_20_5> {
    private final Map<String, PaintingData> oldPaintings = new HashMap<String, PaintingData>();

    public EntityPacketRewriter1_21(Protocol1_21To1_20_5 protocol) {
        super(protocol, ((EntityDataTypes1_20_5)((Types1_20_5)protocol.mappedTypes()).entityDataTypes()).optionalComponentType, ((EntityDataTypes1_20_5)((Types1_20_5)protocol.mappedTypes()).entityDataTypes()).booleanType);
        for (int i2 = 0; i2 < Paintings1_20_5.PAINTINGS.length; ++i2) {
            PaintingVariant painting = Paintings1_20_5.PAINTINGS[i2];
            this.oldPaintings.put(painting.assetId(), new PaintingData(painting, i2));
        }
    }

    @Override
    public void registerPackets() {
        this.registerTrackerWithData1_19(ClientboundPackets1_21.ADD_ENTITY, EntityTypes1_20_5.FALLING_BLOCK);
        this.registerSetEntityData(ClientboundPackets1_21.SET_ENTITY_DATA);
        this.registerRemoveEntities(ClientboundPackets1_21.REMOVE_ENTITIES);
        RegistryDataRewriter registryDataRewriter = new RegistryDataRewriter(this.protocol);
        ((Protocol1_21To1_20_5)this.protocol).registerClientbound(ClientboundConfigurationPackets1_21.REGISTRY_DATA, wrapper -> {
            String key = Key.stripMinecraftNamespace(wrapper.passthrough(Types.STRING));
            RegistryEntry[] entries = wrapper.passthrough(Types.REGISTRY_ENTRY_ARRAY);
            boolean paintingVariant = key.equals("painting_variant");
            boolean enchantment = key.equals("enchantment");
            if (paintingVariant || enchantment || key.equals("jukebox_song")) {
                String[] keys = new String[entries.length];
                for (int i2 = 0; i2 < entries.length; ++i2) {
                    keys[i2] = Key.stripMinecraftNamespace(entries[i2].key());
                }
                EnchantmentsPaintingsStorage storage = wrapper.user().get(EnchantmentsPaintingsStorage.class);
                if (paintingVariant) {
                    storage.setPaintings(new KeyMappings(keys), this.paintingMappingsForEntries(entries));
                } else if (enchantment) {
                    Tag[] descriptions = new Tag[entries.length];
                    int[] maxLevels = new int[entries.length];
                    for (int i3 = 0; i3 < entries.length; ++i3) {
                        RegistryEntry entry = entries[i3];
                        Tag patt5182$temp = entry.tag();
                        if (!(patt5182$temp instanceof CompoundTag)) continue;
                        CompoundTag tag = (CompoundTag)patt5182$temp;
                        descriptions[i3] = tag.get("description");
                        maxLevels[i3] = tag.getInt("max_level");
                    }
                    storage.setEnchantments(new KeyMappings(keys), descriptions, maxLevels);
                } else {
                    int[] jukeboxSongMappings = new int[keys.length];
                    for (int i4 = 0; i4 < keys.length; ++i4) {
                        int itemId;
                        jukeboxSongMappings[i4] = itemId = ((Protocol1_21To1_20_5)this.protocol).getMappingData().getFullItemMappings().mappedId(EntityPacketRewriter1_21.jvmdowngrader$concat$lambda$registerPackets$0$1(keys[i4]));
                    }
                    storage.setJubeboxSongsToItems(jukeboxSongMappings);
                }
                wrapper.cancel();
            } else {
                registryDataRewriter.trackDimensionAndBiomes(wrapper.user(), key, entries);
            }
        });
        ((Protocol1_21To1_20_5)this.protocol).registerClientbound(ClientboundPackets1_21.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.map(Types.STRING_ARRAY);
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.map(Types.VAR_INT);
                this.map(Types.STRING);
                this.handler(EntityPacketRewriter1_21.this.worldDataTrackerHandlerByKey1_20_5(3));
            }
        });
        ((Protocol1_21To1_20_5)this.protocol).registerClientbound(ClientboundPackets1_21.RESPAWN, wrapper -> {
            int dimensionId = wrapper.passthrough(Types.VAR_INT);
            String world = wrapper.passthrough(Types.STRING);
            this.trackWorldDataByKey1_20_5(wrapper.user(), dimensionId, world);
        });
        ((Protocol1_21To1_20_5)this.protocol).registerServerbound(ServerboundPackets1_20_5.MOVE_PLAYER_POS_ROT, wrapper -> {
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.DOUBLE);
            this.storePlayerRotation(wrapper);
        });
        ((Protocol1_21To1_20_5)this.protocol).registerServerbound(ServerboundPackets1_20_5.MOVE_PLAYER_ROT, this::storePlayerRotation);
    }

    private void storePlayerRotation(PacketWrapper wrapper) {
        float yaw = wrapper.passthrough(Types.FLOAT).floatValue();
        float pitch = wrapper.passthrough(Types.FLOAT).floatValue();
        wrapper.user().get(PlayerRotationStorage.class).setRotation(yaw, pitch);
    }

    private int[] paintingMappingsForEntries(RegistryEntry[] entries) {
        int[] mappings = new int[entries.length];
        block0: for (int i2 = 0; i2 < entries.length; ++i2) {
            RegistryEntry entry = entries[i2];
            PaintingData paintingData = this.oldPaintings.get(Key.stripMinecraftNamespace(entry.key()));
            if (paintingData != null) {
                mappings[i2] = paintingData.jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_21to1_20_5_rewriter_EntityPacketRewriter1_21$PaintingData$get$id();
                continue;
            }
            if (entry.tag() == null) continue;
            CompoundTag tag = (CompoundTag)entry.tag();
            for (int j2 = 0; j2 < Paintings1_20_5.PAINTINGS.length; ++j2) {
                PaintingVariant painting = Paintings1_20_5.PAINTINGS[j2];
                if (painting.width() != tag.getInt("width") || painting.height() != tag.getInt("height")) continue;
                mappings[i2] = j2;
                continue block0;
            }
        }
        return mappings;
    }

    @Override
    protected void registerRewrites() {
        EntityDataTypes1_20_5 mappedEntityDataTypes = (EntityDataTypes1_20_5)VersionedTypes.V1_20_5.entityDataTypes;
        this.filter().handler((event, data) -> {
            EntityDataType type = data.dataType();
            if (type == ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).wolfVariantType) {
                Holder variant = (Holder)data.value();
                if (variant.hasId()) {
                    data.setTypeAndValue(mappedEntityDataTypes.wolfVariantType, variant.id());
                } else {
                    event.cancel();
                }
            } else if (type == ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).paintingVariantType) {
                Holder variant = (Holder)data.value();
                if (variant.hasId()) {
                    EnchantmentsPaintingsStorage storage = event.user().get(EnchantmentsPaintingsStorage.class);
                    int mappedId = storage.mappedPainting(variant.id());
                    data.setTypeAndValue(mappedEntityDataTypes.paintingVariantType, mappedId);
                } else {
                    event.cancel();
                }
            } else {
                data.setDataType(mappedEntityDataTypes.byId(type.typeId()));
            }
        });
        this.registerEntityDataTypeHandler1_20_3(mappedEntityDataTypes.itemType, mappedEntityDataTypes.blockStateType, mappedEntityDataTypes.optionalBlockStateType, mappedEntityDataTypes.particleType, mappedEntityDataTypes.particlesType, mappedEntityDataTypes.componentType, mappedEntityDataTypes.optionalComponentType);
        this.registerBlockStateHandler(EntityTypes1_20_5.ABSTRACT_MINECART, 11);
    }

    @Override
    public EntityType typeFromId(int type) {
        return EntityTypes1_20_5.getTypeFromId(type);
    }

    private static String jvmdowngrader$concat$lambda$registerPackets$0$1(String string) {
        return "music_disc_" + string;
    }

    @RecordComponents(value={@RecordComponents.Value(name="painting", type=PaintingVariant.class), @RecordComponents.Value(name="id", type=int.class)})
    @NestHost(value=EntityPacketRewriter1_21.class)
    private static final class PaintingData
    extends J_L_Record {
        private final PaintingVariant painting;
        private final int id;

        PaintingData(PaintingVariant painting, int id) {
            this.painting = painting;
            this.id = id;
        }

        @Override
        public final String toString() {
            return PaintingData.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return PaintingData.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return PaintingData.jvmdowngrader$equals$equals(this, o2);
        }

        public PaintingVariant painting() {
            return this.painting;
        }

        public int id() {
            return this.id;
        }

        private static String jvmdowngrader$toString$toString(PaintingData paintingData) {
            PaintingData paintingData2 = paintingData;
            return "EntityPacketRewriter1_21$PaintingData[" + "painting=" + paintingData.painting + ", " + "id=" + paintingData.id + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(PaintingData paintingData) {
            Object[] objectArray = new Object[]{paintingData.painting, paintingData.id};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(PaintingData paintingData, Object object) {
            if (paintingData == object) {
                return true;
            }
            if (object != null && object instanceof PaintingData) {
                PaintingData paintingData2 = (PaintingData)object;
                if (Objects.equals(paintingData.painting, paintingData2.painting) && paintingData.id == paintingData2.id) {
                    return true;
                }
            }
            return false;
        }

        public int jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_21to1_20_5_rewriter_EntityPacketRewriter1_21$PaintingData$get$id() {
            return this.id;
        }

        public void jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_21to1_20_5_rewriter_EntityPacketRewriter1_21$PaintingData$set$id(int n2) {
            this.id = n2;
        }
    }
}

