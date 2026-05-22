/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.connection;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.ProtocolInfo;
import com.viaversion.viaversion.api.protocol.ProtocolPipeline;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import java.util.UUID;

public class ProtocolInfoImpl
implements ProtocolInfo {
    private State clientState = State.HANDSHAKE;
    private State serverState = State.HANDSHAKE;
    private ProtocolVersion serverProtocolVersion = ProtocolVersion.unknown;
    private ProtocolVersion protocolVersion = ProtocolVersion.unknown;
    private String username;
    private UUID uuid;
    private ProtocolPipeline pipeline;

    @Override
    public State getClientState() {
        return this.clientState;
    }

    @Override
    public void setClientState(State clientState) {
        if (Via.getManager().debugHandler().enabled()) {
            Via.getPlatform().getLogger().info(ProtocolInfoImpl.jvmdowngrader$concat$setClientState$1(String.valueOf((Object)this.clientState), String.valueOf((Object)clientState), String.valueOf(this.uuid)));
        }
        this.clientState = clientState;
    }

    @Override
    public State getServerState() {
        return this.serverState;
    }

    @Override
    public void setServerState(State serverState) {
        if (Via.getManager().debugHandler().enabled()) {
            Via.getPlatform().getLogger().info(ProtocolInfoImpl.jvmdowngrader$concat$setServerState$1(String.valueOf((Object)this.serverState), String.valueOf((Object)serverState), String.valueOf(this.uuid)));
        }
        this.serverState = serverState;
    }

    @Override
    public ProtocolVersion protocolVersion() {
        return this.protocolVersion;
    }

    @Override
    public void setProtocolVersion(ProtocolVersion protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    @Override
    public ProtocolVersion serverProtocolVersion() {
        return this.serverProtocolVersion;
    }

    @Override
    public void setServerProtocolVersion(ProtocolVersion serverProtocolVersion) {
        this.serverProtocolVersion = serverProtocolVersion;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public UUID getUuid() {
        return this.uuid;
    }

    @Override
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public ProtocolPipeline getPipeline() {
        return this.pipeline;
    }

    @Override
    public void setPipeline(ProtocolPipeline pipeline) {
        this.pipeline = pipeline;
    }

    public String toString() {
        return ProtocolInfoImpl.jvmdowngrader$concat$toString$1(String.valueOf((Object)this.clientState), String.valueOf((Object)this.serverState), String.valueOf(this.protocolVersion), String.valueOf(this.serverProtocolVersion), this.username, String.valueOf(this.uuid));
    }

    private static String jvmdowngrader$concat$setClientState$1(String string, String string2, String string3) {
        return "Client state changed from " + string + " to " + string2 + " for " + string3;
    }

    private static String jvmdowngrader$concat$setServerState$1(String string, String string2, String string3) {
        return "Server state changed from " + string + " to " + string2 + " for " + string3;
    }

    private static String jvmdowngrader$concat$toString$1(String string, String string2, String string3, String string4, String string5, String string6) {
        return "ProtocolInfo{clientState=" + string + ", serverState=" + string2 + ", protocolVersion=" + string3 + ", serverProtocolVersion=" + string4 + ", username='" + string5 + "', uuid=" + string6 + "}";
    }
}

