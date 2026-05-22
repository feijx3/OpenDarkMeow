/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21to1_21_2.storage;

import com.viaversion.viaversion.api.connection.StorableObject;

public final class GroundFlagTracker
implements StorableObject {
    private boolean onGround;
    private boolean horizontalCollision;

    public boolean onGround() {
        return this.onGround;
    }

    public boolean setOnGround(boolean onGround) {
        this.onGround = onGround;
        return this.onGround;
    }

    public boolean horizontalCollision() {
        return this.horizontalCollision;
    }

    public void setHorizontalCollision(boolean horizontalCollision) {
        this.horizontalCollision = horizontalCollision;
    }
}

