/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.entities.storage.EntityObjectData;
import com.viaversion.viabackwards.api.entities.storage.EntityReplacement;
import com.viaversion.viabackwards.api.entities.storage.WrappedEntityData;
import com.viaversion.viabackwards.api.rewriters.EntityRewriterBase;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.ObjectType;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityDataType;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_9;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={ObjectTypeGetter.class, IdSetter.class, 2.class, 1.class})
public abstract class LegacyEntityRewriter<C extends ClientboundPacketType, T extends BackwardsProtocol<C, ?, ?, ?>>
extends EntityRewriterBase<C, T> {
    private final Map<ObjectType, EntityReplacement> objectTypes = new HashMap<ObjectType, EntityReplacement>();

    protected LegacyEntityRewriter(T protocol) {
        this(protocol, EntityDataTypes1_9.STRING, EntityDataTypes1_9.BOOLEAN);
    }

    protected LegacyEntityRewriter(T protocol, EntityDataType displayType, EntityDataType displayVisibilityType) {
        super(protocol, displayType, 2, displayVisibilityType, 3);
    }

    protected EntityObjectData mapObjectType(ObjectType oldObjectType, ObjectType replacement, int data) {
        EntityObjectData entData = new EntityObjectData((BackwardsProtocol)this.protocol, oldObjectType.getType().name(), oldObjectType.getId(), replacement.getId(), data);
        this.objectTypes.put(oldObjectType, entData);
        return entData;
    }

    protected @Nullable EntityReplacement getObjectData(ObjectType type) {
        return this.objectTypes.get(type);
    }

    protected void registerRespawn(C packetType) {
        ((BackwardsProtocol)this.protocol).registerClientbound(packetType, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.handler(wrapper -> {
                    Object clientWorld = wrapper.user().getClientWorld(((BackwardsProtocol)LegacyEntityRewriter.this.protocol).getClass());
                    if (((ClientWorld)clientWorld).setEnvironment(wrapper.get(Types.INT, 0))) {
                        LegacyEntityRewriter.this.tracker(wrapper.user()).clearEntities();
                    }
                });
            }
        });
    }

    protected void registerJoinGame(C packetType, final EntityType playerType) {
        ((BackwardsProtocol)this.protocol).registerClientbound(packetType, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.INT);
                this.handler(wrapper -> {
                    Object clientWorld = wrapper.user().getClientWorld(((BackwardsProtocol)LegacyEntityRewriter.this.protocol).getClass());
                    ((ClientWorld)clientWorld).setEnvironment(wrapper.get(Types.INT, 1));
                    int entityId = wrapper.get(Types.INT, 0);
                    LegacyEntityRewriter.this.addTrackedEntity(wrapper, entityId, playerType);
                    LegacyEntityRewriter.this.tracker(wrapper.user()).setClientEntityId(entityId);
                });
            }
        });
    }

    protected PacketHandler getMobSpawnRewriter(Type<List<EntityData>> dataType, IdSetter idSetter) {
        return wrapper -> {
            int entityId = wrapper.get(Types.VAR_INT, 0);
            EntityType type = this.tracker(wrapper.user()).entityType(entityId);
            if (type == null) {
                return;
            }
            List entityDataList = (List)wrapper.get(dataType, 0);
            this.handleEntityData(entityId, entityDataList, wrapper.user());
            EntityReplacement entityReplacement = this.entityDataForType(type);
            if (entityReplacement != null) {
                idSetter.setId(wrapper, entityReplacement.replacementId());
                if (entityReplacement.hasBaseData()) {
                    entityReplacement.defaultData().createData(new WrappedEntityData(entityDataList));
                }
            }
        };
    }

    public PacketHandler getMobSpawnRewriter(Type<List<EntityData>> dataType) {
        return this.getMobSpawnRewriter(dataType, (wrapper, id) -> wrapper.set(Types.UNSIGNED_BYTE, 0, (short)id));
    }

    public PacketHandler getMobSpawnRewriter1_11(Type<List<EntityData>> dataType) {
        return this.getMobSpawnRewriter(dataType, (wrapper, id) -> wrapper.set(Types.VAR_INT, 1, id));
    }

    protected PacketHandler getObjectTrackerHandler() {
        return wrapper -> {
            int data;
            byte id = wrapper.get(Types.BYTE, 0);
            EntityType type = this.objectTypeFromId(id, data = wrapper.get(Types.INT, 0).intValue());
            if (type == null) {
                return;
            }
            this.addTrackedEntity(wrapper, wrapper.get(Types.VAR_INT, 0), type);
        };
    }

    protected PacketHandler getTrackerAndDataHandler(Type<List<EntityData>> dataType, EntityType entityType) {
        return wrapper -> {
            this.addTrackedEntity(wrapper, wrapper.get(Types.VAR_INT, 0), entityType);
            List entityDataList = (List)wrapper.get(dataType, 0);
            this.handleEntityData(wrapper.get(Types.VAR_INT, 0), entityDataList, wrapper.user());
        };
    }

    protected PacketHandler getObjectRewriter(ObjectTypeGetter objectGetter) {
        return wrapper -> {
            int data;
            byte id = wrapper.get(Types.BYTE, 0);
            ObjectType type = objectGetter.get(id, data = wrapper.get(Types.INT, 0).intValue());
            if (type == null) {
                return;
            }
            EntityReplacement replacement = this.getObjectData(type);
            if (replacement != null) {
                wrapper.set(Types.BYTE, 0, (byte)replacement.replacementId());
                if (replacement.objectData() != -1) {
                    wrapper.set(Types.INT, 0, replacement.objectData());
                }
            }
        };
    }

    @Deprecated
    protected void addTrackedEntity(PacketWrapper wrapper, int entityId, EntityType type) {
        this.tracker(wrapper.user()).addEntity(entityId, type);
    }

    @FunctionalInterface
    @NestHost(value=LegacyEntityRewriter.class)
    protected static interface IdSetter {
        public void setId(PacketWrapper var1, int var2);
    }

    @FunctionalInterface
    @NestHost(value=LegacyEntityRewriter.class)
    protected static interface ObjectTypeGetter {
        public ObjectType get(int var1, int var2);
    }
}

