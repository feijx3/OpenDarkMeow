/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocol;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.ProtocolInfo;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;

public abstract class ProtocolRunnable
implements Runnable {
    private final Class<? extends AbstractProtocol<?, ?, ?, ?>> protocolClass;

    public ProtocolRunnable(Class<? extends AbstractProtocol<?, ?, ?, ?>> protocolClass) {
        this.protocolClass = protocolClass;
    }

    public abstract void run(UserConnection var1);

    @Override
    public void run() {
        for (UserConnection connection : Via.getManager().getConnectionManager().getConnections()) {
            ProtocolInfo protocolInfo = connection.getProtocolInfo();
            if (!connection.isActive() || !protocolInfo.getPipeline().contains(this.protocolClass)) continue;
            this.run(connection);
        }
    }
}

