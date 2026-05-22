/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.debug;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.protocol.packet.Direction;
import com.viaversion.viaversion.api.protocol.packet.PacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import java.util.logging.Level;

public interface DebugHandler {
    public boolean enabled();

    public void setEnabled(boolean var1);

    public void addPacketTypeNameToLog(String var1);

    public void addPacketTypeToLog(PacketType var1);

    public boolean removePacketTypeNameToLog(String var1);

    public void clearPacketTypesToLog();

    default public void setLogPacketTransform(boolean logPacketTransform) {
        this.setLogPrePacketTransform(logPacketTransform);
        this.setLogPostPacketTransform(logPacketTransform);
    }

    public boolean logPrePacketTransform();

    public void setLogPrePacketTransform(boolean var1);

    public boolean logPostPacketTransform();

    public void setLogPostPacketTransform(boolean var1);

    public boolean shouldLog(PacketWrapper var1, Direction var2);

    default public void enableAndLogIds(PacketType ... packetTypes) {
        this.setEnabled(true);
        for (PacketType packetType : packetTypes) {
            this.addPacketTypeToLog(packetType);
        }
    }

    default public void error(String error, Throwable t2) {
        if (!Via.getConfig().isSuppressConversionWarnings() || this.enabled()) {
            Via.getPlatform().getLogger().log(Level.SEVERE, error, t2);
        }
    }
}

