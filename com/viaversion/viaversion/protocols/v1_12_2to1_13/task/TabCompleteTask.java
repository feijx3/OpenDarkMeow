/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.task;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.protocol.ProtocolRunnable;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.Protocol1_12_2To1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.storage.TabCompleteTracker;

public final class TabCompleteTask
extends ProtocolRunnable {
    public TabCompleteTask() {
        super(Protocol1_12_2To1_13.class);
    }

    @Override
    public void run(UserConnection connection) {
        connection.get(TabCompleteTracker.class).sendPacketToServer(connection);
    }
}

