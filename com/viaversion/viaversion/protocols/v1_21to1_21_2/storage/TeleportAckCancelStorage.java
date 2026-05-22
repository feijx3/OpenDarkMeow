/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21to1_21_2.storage;

import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.libs.fastutil.ints.IntOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;

public class TeleportAckCancelStorage
implements StorableObject {
    private final IntSet cancelTeleportIds = new IntOpenHashSet();
    private boolean cancelNextPlayerPositionPacket;

    public boolean checkShouldCancelTeleportAck(int teleportId) {
        boolean shouldCancel = this.cancelTeleportIds.remove(teleportId);
        if (shouldCancel) {
            this.cancelNextPlayerPositionPacket = true;
        }
        return shouldCancel;
    }

    public boolean checkShouldCancelPlayerPositionPacket() {
        if (this.cancelNextPlayerPositionPacket) {
            this.cancelNextPlayerPositionPacket = false;
            return true;
        }
        return false;
    }

    public void cancelTeleportId(int teleportId) {
        this.cancelTeleportIds.add(teleportId);
    }
}

