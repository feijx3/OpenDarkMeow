/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viabackwards.protocol.v1_14to1_13_2.rewriter;

import com.viaversion.viabackwards.api.entities.storage.EntityPositionHandler;
import com.viaversion.viabackwards.api.entities.storage.EntityReplacement;
import com.viaversion.viabackwards.api.rewriters.LegacyEntityRewriter;
import com.viaversion.viabackwards.protocol.v1_14to1_13_2.Protocol1_14To1_13_2;
import com.viaversion.viabackwards.protocol.v1_14to1_13_2.storage.ChunkLightStorage;
import com.viaversion.viabackwards.protocol.v1_14to1_13_2.storage.DifficultyStorage;
import com.viaversion.viabackwards.protocol.v1_14to1_13_2.storage.EntityPositionStorage1_14;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.VillagerData;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_13;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_14;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_13_2;
import com.viaversion.viaversion.api.type.types.version.Types1_14;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.packet.ClientboundPackets1_14;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.entitydata.EntityDataHandler;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={11.class, 10.class, 9.class, 8.class, 7.class, 6.class, 5.class, 4.class, 3.class, 2.class, 1.class})
public class EntityPacketRewriter1_14
extends LegacyEntityRewriter<ClientboundPackets1_14, Protocol1_14To1_13_2> {
    private EntityPositionHandler positionHandler;

    public EntityPacketRewriter1_14(Protocol1_14To1_13_2 protocol) {
        super(protocol, Types1_13_2.ENTITY_DATA_TYPES.optionalComponentType, Types1_13_2.ENTITY_DATA_TYPES.booleanType);
    }

    @Override
    protected void addTrackedEntity(PacketWrapper wrapper, int entityId, EntityType type) {
        super.addTrackedEntity(wrapper, entityId, type);
        if (type == EntityTypes1_14.PAINTING) {
            BlockPosition position = wrapper.get(Types.BLOCK_POSITION1_8, 0);
            this.positionHandler.cacheEntityPosition(wrapper, position.x(), position.y(), position.z(), true, false);
        } else if (wrapper.getId() != ClientboundPackets1_14.LOGIN.getId()) {
            this.positionHandler.cacheEntityPosition(wrapper, true, false);
        }
    }

    @Override
    protected void registerPackets() {
        this.positionHandler = new EntityPositionHandler(this, EntityPositionStorage1_14.class, EntityPositionStorage1_14::new);
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.ENTITY_EVENT, wrapper -> {
            int entityId = wrapper.passthrough(Types.INT);
            byte status = wrapper.passthrough(Types.BYTE);
            if (status != 3) {
                return;
            }
            Object tracker = this.tracker(wrapper.user());
            EntityType entityType = tracker.entityType(entityId);
            if (entityType != EntityTypes1_14.PLAYER) {
                return;
            }
            for (int i2 = 0; i2 <= 5; ++i2) {
                PacketWrapper equipmentPacket = wrapper.create(ClientboundPackets1_13.SET_EQUIPPED_ITEM);
                equipmentPacket.write(Types.VAR_INT, entityId);
                equipmentPacket.write(Types.VAR_INT, i2);
                equipmentPacket.write(Types.ITEM1_13_2, null);
                equipmentPacket.send(Protocol1_14To1_13_2.class);
            }
        });
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.TELEPORT_ENTITY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.handler(wrapper -> EntityPacketRewriter1_14.this.jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_14to1_13_2_rewriter_EntityPacketRewriter1_14$get$positionHandler().cacheEntityPosition(wrapper, false, false));
            }
        });
        PacketHandlers relativeMoveHandler = new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.handler(wrapper -> {
                    double x2 = (double)wrapper.get(Types.SHORT, 0).shortValue() / 4096.0;
                    double y2 = (double)wrapper.get(Types.SHORT, 1).shortValue() / 4096.0;
                    double z2 = (double)wrapper.get(Types.SHORT, 2).shortValue() / 4096.0;
                    EntityPacketRewriter1_14.this.jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_14to1_13_2_rewriter_EntityPacketRewriter1_14$get$positionHandler().cacheEntityPosition(wrapper, x2, y2, z2, false, true);
                });
            }
        };
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.MOVE_ENTITY_POS, relativeMoveHandler);
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.MOVE_ENTITY_POS_ROT, relativeMoveHandler);
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.ADD_ENTITY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.map(Types.VAR_INT, Types.BYTE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.INT);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.handler(EntityPacketRewriter1_14.this.getObjectTrackerHandler());
                this.handler(wrapper -> {
                    int data;
                    EntityTypes1_13.ObjectType objectType;
                    EntityTypes1_13.EntityType entityType;
                    block16: {
                        block15: {
                            byte id = wrapper.get(Types.BYTE, 0);
                            int mappedId = EntityPacketRewriter1_14.this.newEntityId(id);
                            entityType = EntityTypes1_13.EntityType.findById(mappedId);
                            if (entityType == null) {
                                return;
                            }
                            objectType = null;
                            if (!entityType.isOrHasParent(EntityTypes1_13.EntityType.ABSTRACT_MINECART)) break block15;
                            objectType = EntityTypes1_13.ObjectType.MINECART;
                            switch (entityType) {
                                case CHEST_MINECART: {
                                    int n2 = 1;
                                    break;
                                }
                                case FURNACE_MINECART: {
                                    int n2 = 2;
                                    break;
                                }
                                case TNT_MINECART: {
                                    int n2 = 3;
                                    break;
                                }
                                case SPAWNER_MINECART: {
                                    int n2 = 4;
                                    break;
                                }
                                case HOPPER_MINECART: {
                                    int n2 = 5;
                                    break;
                                }
                                case COMMAND_BLOCK_MINECART: {
                                    int n2 = 6;
                                    break;
                                }
                                default: {
                                    int n2 = data = 0;
                                }
                            }
                            if (data == 0) break block16;
                            wrapper.set(Types.INT, 0, data);
                            break block16;
                        }
                        if (entityType.is(EntityTypes1_13.EntityType.EXPERIENCE_ORB)) {
                            wrapper.cancel();
                            int entityId = wrapper.get(Types.VAR_INT, 0);
                            PacketWrapper addExperienceOrb = PacketWrapper.create(ClientboundPackets1_13.ADD_EXPERIENCE_ORB, wrapper.user());
                            addExperienceOrb.write(Types.VAR_INT, entityId);
                            addExperienceOrb.write(Types.DOUBLE, wrapper.get(Types.DOUBLE, 0));
                            addExperienceOrb.write(Types.DOUBLE, wrapper.get(Types.DOUBLE, 1));
                            addExperienceOrb.write(Types.DOUBLE, wrapper.get(Types.DOUBLE, 2));
                            addExperienceOrb.write(Types.SHORT, (short)0);
                            addExperienceOrb.send(Protocol1_14To1_13_2.class);
                            PacketWrapper setEntityMotion = PacketWrapper.create(ClientboundPackets1_13.SET_ENTITY_MOTION, wrapper.user());
                            setEntityMotion.write(Types.VAR_INT, entityId);
                            setEntityMotion.write(Types.SHORT, wrapper.get(Types.SHORT, 0));
                            setEntityMotion.write(Types.SHORT, wrapper.get(Types.SHORT, 1));
                            setEntityMotion.write(Types.SHORT, wrapper.get(Types.SHORT, 2));
                            setEntityMotion.send(Protocol1_14To1_13_2.class);
                            return;
                        }
                        for (EntityTypes1_13.ObjectType type : EntityTypes1_13.ObjectType.values()) {
                            if (type.getType() != entityType) continue;
                            objectType = type;
                            break;
                        }
                    }
                    if (objectType == null) {
                        return;
                    }
                    wrapper.set(Types.BYTE, 0, (byte)objectType.getId());
                    data = wrapper.get(Types.INT, 0);
                    if (objectType == EntityTypes1_13.ObjectType.FALLING_BLOCK) {
                        int blockState = wrapper.get(Types.INT, 0);
                        int combined = ((Protocol1_14To1_13_2)EntityPacketRewriter1_14.this.protocol).getMappingData().getNewBlockStateId(blockState);
                        wrapper.set(Types.INT, 0, combined);
                    } else if (entityType.isOrHasParent(EntityTypes1_13.EntityType.ABSTRACT_ARROW)) {
                        wrapper.set(Types.INT, 0, data + 1);
                    }
                });
            }
        });
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.ADD_MOB, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.map(Types.VAR_INT);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.map(Types1_14.ENTITY_DATA_LIST, Types1_13_2.ENTITY_DATA_LIST);
                this.handler(wrapper -> {
                    int type = wrapper.get(Types.VAR_INT, 1);
                    EntityType entityType = EntityTypes1_14.getTypeFromId(type);
                    EntityPacketRewriter1_14.this.addTrackedEntity(wrapper, wrapper.get(Types.VAR_INT, 0), entityType);
                    int oldId = EntityPacketRewriter1_14.this.newEntityId(type);
                    if (oldId == -1) {
                        EntityReplacement entityReplacement = EntityPacketRewriter1_14.this.entityDataForType(entityType);
                        if (entityReplacement == null) {
                            ((Protocol1_14To1_13_2)EntityPacketRewriter1_14.this.protocol).getLogger().warning(4.jvmdowngrader$concat$lambda$register$0$1(type, String.valueOf(entityType)));
                            wrapper.cancel();
                        } else {
                            wrapper.set(Types.VAR_INT, 1, entityReplacement.replacementId());
                        }
                    } else {
                        wrapper.set(Types.VAR_INT, 1, oldId);
                    }
                });
                this.handler(EntityPacketRewriter1_14.this.getMobSpawnRewriter1_11(Types1_13_2.ENTITY_DATA_LIST));
            }

            private static String jvmdowngrader$concat$lambda$register$0$1(int n2, String string) {
                return "Could not find entity type mapping " + n2 + "/" + string;
            }
        });
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.ADD_EXPERIENCE_ORB, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.handler(wrapper -> EntityPacketRewriter1_14.this.addTrackedEntity(wrapper, wrapper.get(Types.VAR_INT, 0), EntityTypes1_14.EXPERIENCE_ORB));
            }
        });
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.ADD_GLOBAL_ENTITY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BYTE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.handler(wrapper -> EntityPacketRewriter1_14.this.addTrackedEntity(wrapper, wrapper.get(Types.VAR_INT, 0), EntityTypes1_14.LIGHTNING_BOLT));
            }
        });
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.ADD_PAINTING, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.map(Types.VAR_INT);
                this.map(Types.BLOCK_POSITION1_14, Types.BLOCK_POSITION1_8);
                this.map(Types.BYTE);
                this.handler(wrapper -> EntityPacketRewriter1_14.this.addTrackedEntity(wrapper, wrapper.get(Types.VAR_INT, 0), EntityTypes1_14.PAINTING));
            }
        });
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.ADD_PLAYER, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types1_14.ENTITY_DATA_LIST, Types1_13_2.ENTITY_DATA_LIST);
                this.handler(EntityPacketRewriter1_14.this.getTrackerAndDataHandler(Types1_13_2.ENTITY_DATA_LIST, EntityTypes1_14.PLAYER));
                this.handler(wrapper -> EntityPacketRewriter1_14.this.jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_14to1_13_2_rewriter_EntityPacketRewriter1_14$get$positionHandler().cacheEntityPosition(wrapper, true, false));
            }
        });
        this.registerRemoveEntities(ClientboundPackets1_14.REMOVE_ENTITIES);
        this.registerSetEntityData(ClientboundPackets1_14.SET_ENTITY_DATA, Types1_14.ENTITY_DATA_LIST, Types1_13_2.ENTITY_DATA_LIST);
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.INT);
                this.handler(EntityPacketRewriter1_14.this.getDimensionHandler(1));
                this.handler(EntityPacketRewriter1_14.this.getPlayerTrackerHandler());
                this.handler(wrapper -> {
                    short difficulty = wrapper.user().get(DifficultyStorage.class).getDifficulty();
                    wrapper.write(Types.UNSIGNED_BYTE, difficulty);
                    wrapper.passthrough(Types.UNSIGNED_BYTE);
                    wrapper.passthrough(Types.STRING);
                    wrapper.read(Types.VAR_INT);
                });
            }
        });
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.handler(wrapper -> {
                    int dimensionId;
                    Object clientWorld = wrapper.user().getClientWorld(Protocol1_14To1_13_2.class);
                    if (((ClientWorld)clientWorld).setEnvironment(dimensionId = wrapper.get(Types.INT, 0).intValue())) {
                        EntityPacketRewriter1_14.this.tracker(wrapper.user()).clearEntities();
                        wrapper.user().get(ChunkLightStorage.class).clear();
                    }
                    short difficulty = wrapper.user().get(DifficultyStorage.class).getDifficulty();
                    wrapper.write(Types.UNSIGNED_BYTE, difficulty);
                });
            }
        });
    }

    @Override
    protected void registerRewrites() {
        this.filter().handler((event, data) -> {
            int typeId = data.dataType().typeId();
            if (typeId <= 15) {
                data.setDataType(Types1_13_2.ENTITY_DATA_TYPES.byId(typeId));
            }
        });
        this.registerEntityDataTypeHandler(Types1_13_2.ENTITY_DATA_TYPES.itemType, null, Types1_13_2.ENTITY_DATA_TYPES.optionalBlockStateType, null, Types1_13_2.ENTITY_DATA_TYPES.componentType, Types1_13_2.ENTITY_DATA_TYPES.optionalComponentType);
        this.filter().type(EntityTypes1_14.PILLAGER).cancel(15);
        this.filter().type(EntityTypes1_14.FOX).cancel(15);
        this.filter().type(EntityTypes1_14.FOX).cancel(16);
        this.filter().type(EntityTypes1_14.FOX).cancel(17);
        this.filter().type(EntityTypes1_14.FOX).cancel(18);
        this.filter().type(EntityTypes1_14.PANDA).cancel(15);
        this.filter().type(EntityTypes1_14.PANDA).cancel(16);
        this.filter().type(EntityTypes1_14.PANDA).cancel(17);
        this.filter().type(EntityTypes1_14.PANDA).cancel(18);
        this.filter().type(EntityTypes1_14.PANDA).cancel(19);
        this.filter().type(EntityTypes1_14.PANDA).cancel(20);
        this.filter().type(EntityTypes1_14.CAT).cancel(18);
        this.filter().type(EntityTypes1_14.CAT).cancel(19);
        this.filter().type(EntityTypes1_14.CAT).cancel(20);
        this.filter().type(EntityTypes1_14.ABSTRACT_RAIDER).removeIndex(14);
        this.filter().type(EntityTypes1_14.AREA_EFFECT_CLOUD).index(10).handler((event, data) -> ((ParticleRewriter)((Protocol1_14To1_13_2)this.protocol).getParticleRewriter()).rewriteParticle(event.user(), (Particle)data.getValue()));
        this.filter().type(EntityTypes1_14.FIREWORK_ROCKET).index(8).handler((event, data) -> {
            data.setDataType(Types1_13_2.ENTITY_DATA_TYPES.varIntType);
            Integer value = (Integer)data.getValue();
            if (value == null) {
                data.setValue(0);
            }
        });
        this.filter().type(EntityTypes1_14.ABSTRACT_ARROW).removeIndex(9);
        this.filter().type(EntityTypes1_14.VILLAGER).cancel(15);
        EntityDataHandler villagerDataHandler = (event, data) -> {
            VillagerData villagerData = (VillagerData)data.getValue();
            data.setTypeAndValue(Types1_13_2.ENTITY_DATA_TYPES.varIntType, this.villagerDataToProfession(villagerData));
            if (data.id() == 16) {
                event.setIndex(15);
            }
        };
        this.filter().type(EntityTypes1_14.ZOMBIE_VILLAGER).index(18).handler(villagerDataHandler);
        this.filter().type(EntityTypes1_14.VILLAGER).index(16).handler(villagerDataHandler);
        this.filter().type(EntityTypes1_14.ABSTRACT_SKELETON).index(13).handler((event, data) -> {
            byte value = (Byte)data.getValue();
            if ((value & 4) != 0) {
                event.createExtraData(new EntityData(14, Types1_13_2.ENTITY_DATA_TYPES.booleanType, true));
            }
        });
        this.filter().type(EntityTypes1_14.ZOMBIE).index(13).handler((event, data) -> {
            byte value = (Byte)data.getValue();
            if ((value & 4) != 0) {
                event.createExtraData(new EntityData(16, Types1_13_2.ENTITY_DATA_TYPES.booleanType, true));
            }
        });
        this.filter().type(EntityTypes1_14.ZOMBIE).addIndex(16);
        this.filter().type(EntityTypes1_14.LIVING_ENTITY).handler((event, data) -> {
            int index = event.index();
            if (index == 12) {
                BlockPosition position = (BlockPosition)data.getValue();
                if (position != null) {
                    PacketWrapper wrapper = PacketWrapper.create(ClientboundPackets1_13.PLAYER_SLEEP, null, event.user());
                    wrapper.write(Types.VAR_INT, event.entityId());
                    wrapper.write(Types.BLOCK_POSITION1_8, position);
                    try {
                        wrapper.scheduleSend(Protocol1_14To1_13_2.class);
                    }
                    catch (Exception ex2) {
                        ex2.printStackTrace();
                    }
                }
                event.cancel();
            } else if (index > 12) {
                event.setIndex(index - 1);
            }
        });
        this.filter().removeIndex(6);
        this.filter().type(EntityTypes1_14.OCELOT).index(13).handler((event, data) -> {
            event.setIndex(15);
            data.setTypeAndValue(Types1_13_2.ENTITY_DATA_TYPES.varIntType, 0);
        });
        this.filter().type(EntityTypes1_14.CAT).handler((event, data) -> {
            if (event.index() == 15) {
                data.setValue(1);
            } else if (event.index() == 13) {
                data.setValue((byte)((Byte)data.getValue() & 4));
            }
        });
        this.filter().handler((event, data) -> {
            if (data.dataType().typeId() > 15) {
                throw new IllegalArgumentException(EntityPacketRewriter1_14.jvmdowngrader$concat$lambda$registerRewrites$10$1(String.valueOf(data)));
            }
        });
    }

    public int villagerDataToProfession(VillagerData data) {
        switch (data.profession()) {
            case 1: 
            case 10: 
            case 13: 
            case 14: {
                return 3;
            }
            case 2: 
            case 8: {
                return 4;
            }
            case 3: 
            case 9: {
                return 1;
            }
            case 4: {
                return 2;
            }
            case 5: 
            case 6: 
            case 7: 
            case 12: {
                return 0;
            }
        }
        return 5;
    }

    @Override
    public void onMappingDataLoaded() {
        this.mapTypes();
        this.mapEntityTypeWithData(EntityTypes1_14.CAT, EntityTypes1_14.OCELOT).jsonName();
        this.mapEntityTypeWithData(EntityTypes1_14.TRADER_LLAMA, EntityTypes1_14.LLAMA).jsonName();
        this.mapEntityTypeWithData(EntityTypes1_14.FOX, EntityTypes1_14.WOLF).jsonName();
        this.mapEntityTypeWithData(EntityTypes1_14.PANDA, EntityTypes1_14.POLAR_BEAR).jsonName();
        this.mapEntityTypeWithData(EntityTypes1_14.PILLAGER, EntityTypes1_14.VILLAGER).jsonName();
        this.mapEntityTypeWithData(EntityTypes1_14.WANDERING_TRADER, EntityTypes1_14.VILLAGER).jsonName();
        this.mapEntityTypeWithData(EntityTypes1_14.RAVAGER, EntityTypes1_14.COW).jsonName();
    }

    @Override
    public EntityType typeFromId(int typeId) {
        return EntityTypes1_14.getTypeFromId(typeId);
    }

    public EntityPositionHandler jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_14to1_13_2_rewriter_EntityPacketRewriter1_14$get$positionHandler() {
        return this.positionHandler;
    }

    public void jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_14to1_13_2_rewriter_EntityPacketRewriter1_14$set$positionHandler(EntityPositionHandler entityPositionHandler) {
        this.positionHandler = entityPositionHandler;
    }

    private static String jvmdowngrader$concat$lambda$registerRewrites$10$1(String string) {
        return "Unhandled entity data: " + string;
    }
}

