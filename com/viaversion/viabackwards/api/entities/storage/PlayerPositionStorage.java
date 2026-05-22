/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.entities.storage;

import com.viaversion.viaversion.api.connection.StorableObject;

public abstract class PlayerPositionStorage
implements StorableObject {
    private double x;
    private double y;
    private double z;

    protected PlayerPositionStorage() {
    }

    public double x() {
        return this.x;
    }

    public double y() {
        return this.y;
    }

    public double z() {
        return this.z;
    }

    public void setX(double x2) {
        this.x = x2;
    }

    public void setY(double y2) {
        this.y = y2;
    }

    public void setZ(double z2) {
        this.z = z2;
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

