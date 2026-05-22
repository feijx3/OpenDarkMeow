/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.velocity.command.subs;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.command.ViaCommandSender;
import com.viaversion.viaversion.api.command.ViaSubCommand;
import com.viaversion.viaversion.velocity.platform.VelocityViaConfig;

public class ProbeSubCmd
implements ViaSubCommand {
    @Override
    public String name() {
        return "probe";
    }

    @Override
    public String description() {
        return ProbeSubCmd.jvmdowngrader$concat$description$1(((VelocityViaConfig)Via.getConfig()).getVelocityPingInterval() == -1 ? "" : "(Also happens at an interval)");
    }

    @Override
    public boolean execute(ViaCommandSender sender, String[] args) {
        Via.proxyPlatform().protocolDetectorService().probeAllServers();
        this.sendMessage(sender, "&6Started searching for protocol versions", new Object[0]);
        return true;
    }

    private static String jvmdowngrader$concat$description$1(String string) {
        return "Forces ViaVersion to scan server protocol versions " + string;
    }
}

