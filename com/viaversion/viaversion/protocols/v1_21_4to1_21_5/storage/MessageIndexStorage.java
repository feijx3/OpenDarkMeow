/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_4to1_21_5.storage;

import com.viaversion.viaversion.api.connection.StorableObject;

public final class MessageIndexStorage
implements StorableObject {
    private int index;

    public int index() {
        return this.index;
    }

    public int getAndIncrease() {
        return this.index++;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

