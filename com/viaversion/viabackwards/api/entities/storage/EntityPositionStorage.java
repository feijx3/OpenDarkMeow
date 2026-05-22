/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.entities.storage;

public abstract class EntityPositionStorage {
    private double x;
    private double y;
    private double z;

    public double x() {
        return this.x;
    }

    public double y() {
        return this.y;
    }

    public double z() {
        return this.z;
    }

    public void setPosition(double x2, double y2, double z2) {
        this.x = x2;
        this.y = y2;
        this.z = z2;
    }

    public void addRelativePosition(double relX, double relY, double relZ) {
        this.x += relX;
        this.y += relY;
        this.z += relZ;
    }
}

