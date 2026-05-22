/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21to1_21_2.storage;

import com.viaversion.viaversion.api.connection.StorableObject;

public final class ClientVehicleStorage
implements StorableObject {
    private final int vehicleId;
    private float sidewaysMovement;
    private float forwardMovement;
    private byte flags;

    public ClientVehicleStorage(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void storeMovement(float sidewaysMovement, float forwardMovement, byte flags) {
        this.sidewaysMovement = sidewaysMovement;
        this.forwardMovement = forwardMovement;
        this.flags = flags;
    }

    public int vehicleId() {
        return this.vehicleId;
    }

    public float sidewaysMovement() {
        return this.sidewaysMovement;
    }

    public float forwardMovement() {
        return this.forwardMovement;
    }

    public byte flags() {
        return this.flags;
    }
}

