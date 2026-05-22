/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_8to1_9.task;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.protocol.ProtocolRunnable;
import com.viaversion.viaversion.protocols.v1_8to1_9.Protocol1_8To1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.provider.MovementTransmitterProvider;
import com.viaversion.viaversion.protocols.v1_8to1_9.storage.MovementTracker;

public final class IdlePacketTask
extends ProtocolRunnable {
    public IdlePacketTask() {
        super(Protocol1_8To1_9.class);
    }

    @Override
    public void run(UserConnection connection) {
        MovementTracker movementTracker = connection.get(MovementTracker.class);
        if (movementTracker == null) {
            return;
        }
        long nextIdleUpdate = movementTracker.getNextIdlePacket();
        if (nextIdleUpdate <= System.currentTimeMillis()) {
            Via.getManager().getProviders().get(MovementTransmitterProvider.class).sendPlayer(connection);
        }
    }
}

