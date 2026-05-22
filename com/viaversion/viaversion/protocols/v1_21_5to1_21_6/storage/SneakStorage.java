/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_5to1_21_6.storage;

import com.viaversion.viaversion.api.connection.StorableObject;

public final class SneakStorage
implements StorableObject {
    private boolean sneaking;

    public boolean sneaking() {
        return this.sneaking;
    }

    public boolean setSneaking(boolean sneaking) {
        boolean previous = this.sneaking;
        this.sneaking = sneaking;
        return previous != sneaking;
    }
}

