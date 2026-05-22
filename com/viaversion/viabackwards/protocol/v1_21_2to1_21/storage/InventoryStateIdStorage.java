/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_2to1_21.storage;

import com.viaversion.viaversion.api.connection.StorableObject;

public final class InventoryStateIdStorage
implements StorableObject {
    private boolean smithingTableOpen;
    private int stateId = -1;

    public int stateId() {
        return this.stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public boolean smithingTableOpen() {
        return this.smithingTableOpen;
    }

    public void setSmithingTableOpen(boolean smithingTableOpen) {
        this.smithingTableOpen = smithingTableOpen;
    }
}

