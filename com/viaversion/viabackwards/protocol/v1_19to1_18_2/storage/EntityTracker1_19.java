/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_19to1_18_2.storage;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_19;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.libs.fastutil.ints.IntArrayList;
import com.viaversion.viaversion.libs.fastutil.ints.IntList;

public final class EntityTracker1_19
extends EntityTrackerBase {
    private final IntList affectedByBlindness = new IntArrayList();
    private final IntList affectedByDarkness = new IntArrayList();

    public EntityTracker1_19(UserConnection connection) {
        super(connection, EntityTypes1_19.PLAYER);
    }

    @Override
    public void removeEntity(int id) {
        super.removeEntity(id);
        this.affectedByBlindness.rem(id);
        this.affectedByDarkness.rem(id);
    }

    public IntList getAffectedByBlindness() {
        return this.affectedByBlindness;
    }

    public IntList getAffectedByDarkness() {
        return this.affectedByDarkness;
    }
}

