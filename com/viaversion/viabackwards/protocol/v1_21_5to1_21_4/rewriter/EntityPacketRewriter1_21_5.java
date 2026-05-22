/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.version.Ref
 *  xyz.wagyourtail.jvmdg.version.Stub
 */
package com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viabackwards.api.rewriters.EntityRewriter;
import com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.Protocol1_21_5To1_21_4;
import com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.storage.HashedItemConverterStorage;
import com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.storage.HorseDataStorage;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.entity.TrackedEntity;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.RegistryEntry;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_5;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_2;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_5;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_20_5;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundConfigurationPackets1_21;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPacket1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.rewriter.RegistryDataRewriter;
import com.viaversion.viaversion.util.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.version.Ref;
import xyz.wagyourtail.jvmdg.version.Stub;

@NestMembers(value={1.class})
public final class EntityPacketRewriter1_21_5
extends EntityRewriter<ClientboundPacket1_21_5, Protocol1_21_5To1_21_4> {
    private static final Set<String> NEW_REGISTRIES = EntityPacketRewriter1_21_5.jvmdg$inlined$of("pig_variant", "cow_variant", "frog_variant", "cat_variant", "chicken_variant", "test_environment", "test_instance", "wolf_sound_variant");

    public EntityPacketRewriter1_21_5(Protocol1_21_5To1_21_4 protocol) {
        super(protocol, ((EntityDataTypes1_21_2)((Types1_20_5)protocol.mappedTypes()).entityDataTypes()).optionalComponentType, ((EntityDataTypes1_21_2)((Types1_20_5)protocol.mappedTypes()).entityDataTypes()).booleanType);
    }

    @Override
    public void registerPackets() {
        this.registerSetEntityData(ClientboundPackets1_21_5.SET_ENTITY_DATA);
        this.registerRemoveEntities(ClientboundPackets1_21_5.REMOVE_ENTITIES);
        ((Protocol1_21_5To1_21_4)this.protocol).appendClientbound(ClientboundPackets1_21_5.ADD_ENTITY, wrapper -> {
            int entityId = wrapper.passthrough(Types.VAR_INT);
            UUID uuid = wrapper.read(Types.UUID);
            int entityType = wrapper.read(Types.VAR_INT);
            if (entityType != EntityTypes1_21_5.EXPERIENCE_ORB.getId()) {
                wrapper.write(Types.UUID, uuid);
                wrapper.write(Types.VAR_INT, entityType);
                wrapper.passthrough(Types.DOUBLE);
                wrapper.passthrough(Types.DOUBLE);
                wrapper.passthrough(Types.DOUBLE);
                wrapper.passthrough(Types.BYTE);
                wrapper.passthrough(Types.BYTE);
                wrapper.passthrough(Types.BYTE);
                wrapper.passthrough(Types.VAR_INT);
                this.getSpawnTrackerWithDataHandler1_19(EntityTypes1_21_5.FALLING_BLOCK).handle(wrapper);
                return;
            }
            this.tracker(wrapper.user()).addEntity(entityId, EntityTypes1_21_5.EXPERIENCE_ORB);
            wrapper.setPacketType(ClientboundPackets1_21_2.ADD_EXPERIENCE_ORB);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.read(Types.BYTE);
            wrapper.read(Types.BYTE);
            wrapper.read(Types.BYTE);
            int data = wrapper.read(Types.VAR_INT);
            wrapper.write(Types.SHORT, (short)data);
            short velocityX = wrapper.read(Types.SHORT);
            short velocityY = wrapper.read(Types.SHORT);
            short velocityZ = wrapper.read(Types.SHORT);
            if (velocityX != 0 || velocityY != 0 || velocityZ != 0) {
                PacketWrapper motionPacket = wrapper.create(ClientboundPackets1_21_2.SET_ENTITY_MOTION);
                motionPacket.write(Types.VAR_INT, entityId);
                motionPacket.write(Types.SHORT, velocityX);
                motionPacket.write(Types.SHORT, velocityY);
                motionPacket.write(Types.SHORT, velocityZ);
                wrapper.send(Protocol1_21_5To1_21_4.class);
                motionPacket.send(Protocol1_21_5To1_21_4.class);
                wrapper.cancel();
            }
        });
        RegistryDataRewriter registryDataRewriter = new RegistryDataRewriter(this.protocol){

            @Override
            public RegistryEntry[] handle(UserConnection connection, String key, RegistryEntry[] entries) {
                boolean trimPatternRegistry = key.equals("trim_pattern");
                if (trimPatternRegistry || key.equals("trim_material")) {
                    this.updateTrim(entries, trimPatternRegistry ? "template_item" : "ingredient");
                    return super.handle(connection, key, entries);
                }
                if (key.equals("enchantment")) {
                    EntityPacketRewriter1_21_5.this.jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_21_5to1_21_4_rewriter_EntityPacketRewriter1_21_5$updateEnchantment(entries);
                    return super.handle(connection, key, entries);
                }
                if (!key.equals("wolf_variant")) {
                    return super.handle(connection, key, entries);
                }
                for (RegistryEntry entry : entries) {
                    if (entry.tag() == null) continue;
                    CompoundTag variant = (CompoundTag)entry.tag();
                    CompoundTag assets = (CompoundTag)variant.remove("assets");
                    variant.put("wild_texture", assets.get("wild"));
                    variant.put("tame_texture", assets.get("tame"));
                    variant.put("angry_texture", assets.get("angry"));
                    variant.put("biomes", new ListTag<StringTag>(StringTag.class));
                }
                return entries;
            }

            private void updateTrim(RegistryEntry[] entries, String itemKey) {
                for (RegistryEntry entry : entries) {
                    if (entry.tag() == null) continue;
                    CompoundTag tag = (CompoundTag)entry.tag();
                    tag.putString(itemKey, "stone");
                }
            }
        };
        ((Protocol1_21_5To1_21_4)this.protocol).registerClientbound(ClientboundConfigurationPackets1_21.REGISTRY_DATA, wrapper -> {
            String registryKey = Key.stripMinecraftNamespace(wrapper.passthrough(Types.STRING));
            if (NEW_REGISTRIES.contains(registryKey)) {
                wrapper.cancel();
                return;
            }
            RegistryEntry[] entries = wrapper.read(Types.REGISTRY_ENTRY_ARRAY);
            if (registryKey.equals("enchantment")) {
                ArrayList<String> identifiers = new ArrayList<String>(entries.length);
                for (RegistryEntry entry : entries) {
                    identifiers.add(entry.key());
                }
                wrapper.user().get(HashedItemConverterStorage.class).setEnchantments(identifiers);
            }
            wrapper.write(Types.REGISTRY_ENTRY_ARRAY, registryDataRewriter.handle(wrapper.user(), registryKey, entries));
        });
        ((Protocol1_21_5To1_21_4)this.protocol).registerClientbound(ClientboundPackets1_21_5.LOGIN, wrapper -> {
            int entityId = wrapper.passthrough(Types.INT);
            wrapper.passthrough(Types.BOOLEAN);
            wrapper.passthrough(Types.STRING_ARRAY);
            wrapper.passthrough(Types.VAR_INT);
            wrapper.passthrough(Types.VAR_INT);
            wrapper.passthrough(Types.VAR_INT);
            wrapper.passthrough(Types.BOOLEAN);
            wrapper.passthrough(Types.BOOLEAN);
            wrapper.passthrough(Types.BOOLEAN);
            int dimensionId = wrapper.passthrough(Types.VAR_INT);
            String world = wrapper.passthrough(Types.STRING);
            this.trackWorldDataByKey1_20_5(wrapper.user(), dimensionId, world);
            this.trackPlayer(wrapper.user(), entityId);
        });
        ((Protocol1_21_5To1_21_4)this.protocol).registerClientbound(ClientboundPackets1_21_5.RESPAWN, wrapper -> {
            int dimensionId = wrapper.passthrough(Types.VAR_INT);
            String world = wrapper.passthrough(Types.STRING);
            this.trackWorldDataByKey1_20_5(wrapper.user(), dimensionId, world);
        });
        ((Protocol1_21_5To1_21_4)this.protocol).registerClientbound(ClientboundPackets1_21_5.SET_PLAYER_TEAM, wrapper -> {
            wrapper.passthrough(Types.STRING);
            byte action = wrapper.passthrough(Types.BYTE);
            if (action == 0 || action == 2) {
                wrapper.passthrough(Types.TAG);
                wrapper.passthrough(Types.BYTE);
                int nametagVisibility = wrapper.read(Types.VAR_INT);
                int collisionRule = wrapper.read(Types.VAR_INT);
                wrapper.write(Types.STRING, this.visibility(nametagVisibility));
                wrapper.write(Types.STRING, this.collision(collisionRule));
                wrapper.passthrough(Types.VAR_INT);
                wrapper.passthrough(Types.TAG);
                wrapper.passthrough(Types.TAG);
            }
        });
    }

    private void updateEnchantment(RegistryEntry[] entries) {
        for (RegistryEntry entry : entries) {
            CompoundTag enchantment;
            ListTag<StringTag> slots;
            if (entry.tag() == null || (slots = (enchantment = (CompoundTag)entry.tag()).getListTag("slots", StringTag.class)) == null) continue;
            slots.getValue().removeIf(tag -> tag.getValue().equals("saddle"));
        }
    }

    private String visibility(int id) {
        String string;
        switch (id) {
            case 0: {
                string = "always";
                break;
            }
            case 1: {
                string = "never";
                break;
            }
            case 2: {
                string = "hideForOtherTeams";
                break;
            }
            case 3: {
                string = "hideForOwnTeam";
                break;
            }
            default: {
                string = "always";
            }
        }
        return string;
    }

    private String collision(int id) {
        String string;
        switch (id) {
            case 0: {
                string = "always";
                break;
            }
            case 1: {
                string = "never";
                break;
            }
            case 2: {
                string = "pushOtherTeams";
                break;
            }
            case 3: {
                string = "pushOwnTeam";
                break;
            }
            default: {
                string = "always";
            }
        }
        return string;
    }

    @Override
    protected void registerRewrites() {
        EntityDataTypes1_21_5 entityDataTypes = (EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes;
        EntityDataTypes1_21_2 mappedEntityDataTypes = (EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes;
        this.filter().handler((event, data) -> {
            int id = data.dataType().typeId();
            if (id == entityDataTypes.wolfVariantType.typeId()) {
                int type = (Integer)data.value();
                Holder<int> variant = Holder.of(type);
                data.setTypeAndValue(mappedEntityDataTypes.wolfVariantType, variant);
                return;
            }
            int mappedId = id;
            if (id == entityDataTypes.cowVariantType.typeId() || id == entityDataTypes.pigVariantType.typeId() || id == entityDataTypes.chickenVariantType.typeId() || id == entityDataTypes.wolfSoundVariantType.typeId()) {
                event.cancel();
                return;
            }
            if (id > entityDataTypes.chickenVariantType.typeId()) {
                mappedId -= 4;
            } else if (id > entityDataTypes.pigVariantType.typeId()) {
                mappedId -= 3;
            } else if (id > entityDataTypes.wolfSoundVariantType.typeId()) {
                mappedId -= 2;
            } else if (id > entityDataTypes.cowVariantType.typeId()) {
                --mappedId;
            }
            data.setDataType(mappedEntityDataTypes.byId(mappedId));
        });
        this.registerEntityDataTypeHandler1_20_3(mappedEntityDataTypes.itemType, mappedEntityDataTypes.blockStateType, mappedEntityDataTypes.optionalBlockStateType, mappedEntityDataTypes.particleType, mappedEntityDataTypes.particlesType, mappedEntityDataTypes.componentType, mappedEntityDataTypes.optionalComponentType);
        this.filter().type(EntityTypes1_21_5.ABSTRACT_MINECART).addIndex(13);
        this.filter().type(EntityTypes1_21_5.ABSTRACT_MINECART).index(11).handler((event, data) -> {
            int state = (Integer)data.getValue();
            if (state == 0) {
                event.cancel();
                return;
            }
            int mappedBlockState = ((Protocol1_21_5To1_21_4)this.protocol).getMappingData().getNewBlockStateId(state);
            data.setTypeAndValue(entityDataTypes.varIntType, mappedBlockState);
            event.createExtraData(new EntityData(13, mappedEntityDataTypes.booleanType, true));
        });
        this.filter().type(EntityTypes1_21_5.MOOSHROOM).index(17).handler((event, data) -> {
            int typeId = (Integer)data.value();
            String typeName = typeId == 0 ? "red" : "brown";
            data.setTypeAndValue(entityDataTypes.stringType, typeName);
        });
        this.filter().type(EntityTypes1_21_5.ABSTRACT_HORSE).index(17).handler((event, data) -> {
            HorseDataStorage horseDataStorage;
            TrackedEntity entity = event.trackedEntity();
            byte horseData = (Byte)data.value();
            boolean saddled = false;
            if (entity.hasData() && (horseDataStorage = entity.data().get(HorseDataStorage.class)) != null && horseDataStorage.saddled()) {
                saddled = true;
                data.setValue((byte)(horseData | 4));
            }
            entity.data().put(new HorseDataStorage(horseData, saddled));
        });
        this.filter().type(EntityTypes1_21_5.CHICKEN).cancel(17);
        this.filter().type(EntityTypes1_21_5.COW).cancel(17);
        this.filter().type(EntityTypes1_21_5.PIG).cancel(19);
        this.filter().type(EntityTypes1_21_5.WOLF).cancel(23);
        this.filter().type(EntityTypes1_21_5.EXPERIENCE_ORB).cancel(8);
        this.filter().type(EntityTypes1_21_5.DOLPHIN).addIndex(17);
        this.filter().type(EntityTypes1_21_5.TURTLE).addIndex(17);
        this.filter().type(EntityTypes1_21_5.PIG).addIndex(17);
        this.filter().type(EntityTypes1_21_5.STRIDER).addIndex(19);
    }

    @Override
    public void onMappingDataLoaded() {
        this.mapTypes();
    }

    @Override
    public EntityType typeFromId(int type) {
        return EntityTypes1_21_5.getTypeFromId(type);
    }

    public void jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_21_5to1_21_4_rewriter_EntityPacketRewriter1_21_5$updateEnchantment(RegistryEntry[] registryEntryArray) {
        this.updateEnchantment(registryEntryArray);
    }

    @Stub(ref=@Ref(value="Ljava/util/Set;"))
    private static <E> Set<E> jvmdg$inlined$of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
        return Collections.unmodifiableSet(new HashSet<Object>(Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8)));
    }
}

