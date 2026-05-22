/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.data.entity;

import com.viaversion.viaversion.api.data.entity.StoredEntityData;
import com.viaversion.viaversion.api.data.entity.TrackedEntity;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.data.entity.StoredEntityDataImpl;

public final class TrackedEntityImpl
implements TrackedEntity {
    private final EntityType entityType;
    private StoredEntityData data;
    private boolean sentEntityData;

    public TrackedEntityImpl(EntityType entityType) {
        this.entityType = entityType;
    }

    @Override
    public EntityType entityType() {
        return this.entityType;
    }

    @Override
    public StoredEntityData data() {
        if (this.data == null) {
            this.data = new StoredEntityDataImpl(this.entityType);
        }
        return this.data;
    }

    @Override
    public boolean hasData() {
        return this.data != null;
    }

    @Override
    public boolean hasSentEntityData() {
        return this.sentEntityData;
    }

    @Override
    public void sentEntityData(boolean sentEntityData) {
        this.sentEntityData = sentEntityData;
    }

    public String toString() {
        return TrackedEntityImpl.jvmdowngrader$concat$toString$1(String.valueOf(this.entityType), String.valueOf(this.data), this.sentEntityData);
    }

    private static String jvmdowngrader$concat$toString$1(String string, String string2, boolean bl2) {
        return "TrackedEntityImpl{entityType=" + string + ", data=" + string2 + ", sentEntityData=" + bl2 + "}";
    }
}

