/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viabackwards.api.entities.storage;

import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.entities.storage.WrappedEntityData;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.util.ComponentUtil;
import java.util.Locale;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={ComponentType.class, EntityDataCreator.class})
public class EntityReplacement {
    private final BackwardsProtocol<?, ?, ?, ?> protocol;
    private final int id;
    private final int replacementId;
    private final String key;
    private ComponentType componentType = ComponentType.NONE;
    private EntityDataCreator defaultData;

    public EntityReplacement(BackwardsProtocol<?, ?, ?, ?> protocol, EntityType type, int replacementId) {
        this(protocol, type.name(), type.getId(), replacementId);
    }

    public EntityReplacement(BackwardsProtocol<?, ?, ?, ?> protocol, String key, int id, int replacementId) {
        this.protocol = protocol;
        this.id = id;
        this.replacementId = replacementId;
        this.key = key.toLowerCase(Locale.ROOT);
    }

    public EntityReplacement jsonName() {
        this.componentType = ComponentType.JSON;
        return this;
    }

    public EntityReplacement tagName() {
        this.componentType = ComponentType.TAG;
        return this;
    }

    public EntityReplacement plainName() {
        this.componentType = ComponentType.PLAIN;
        return this;
    }

    public EntityReplacement spawnEntityData(EntityDataCreator handler) {
        this.defaultData = handler;
        return this;
    }

    public boolean hasBaseData() {
        return this.defaultData != null;
    }

    public int typeId() {
        return this.id;
    }

    public @Nullable Object entityName() {
        if (this.componentType == ComponentType.NONE) {
            return null;
        }
        String name = this.protocol.getMappingData().mappedEntityName(this.key);
        if (name == null) {
            return null;
        }
        if (this.componentType == ComponentType.JSON) {
            return ComponentUtil.legacyToJson(name);
        }
        if (this.componentType == ComponentType.TAG) {
            return new StringTag(name);
        }
        return name;
    }

    public int replacementId() {
        return this.replacementId;
    }

    public @Nullable EntityDataCreator defaultData() {
        return this.defaultData;
    }

    public boolean isObjectType() {
        return false;
    }

    public int objectData() {
        return -1;
    }

    public String toString() {
        return EntityReplacement.jvmdowngrader$concat$toString$1(String.valueOf(this.protocol), this.id, this.replacementId, this.key, String.valueOf((Object)this.componentType), String.valueOf(this.defaultData));
    }

    private static String jvmdowngrader$concat$toString$1(String string, int n2, int n3, String string2, String string3, String string4) {
        return "EntityReplacement{protocol=" + string + ", id=" + n2 + ", replacementId=" + n3 + ", key='" + string2 + "', componentType=" + string3 + ", defaultData=" + string4 + "}";
    }

    @NestHost(value=EntityReplacement.class)
    private static enum ComponentType {
        PLAIN,
        JSON,
        TAG,
        NONE;

    }

    @FunctionalInterface
    @NestHost(value=EntityReplacement.class)
    public static interface EntityDataCreator {
        public void createData(WrappedEntityData var1);
    }
}

