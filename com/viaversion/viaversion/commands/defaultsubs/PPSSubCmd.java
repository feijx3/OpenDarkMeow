/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.commands.defaultsubs;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.command.ViaCommandSender;
import com.viaversion.viaversion.api.command.ViaSubCommand;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PPSSubCmd
implements ViaSubCommand {
    @Override
    public String name() {
        return "pps";
    }

    @Override
    public String description() {
        return "Shows the packets per second of online players.";
    }

    @Override
    public String usage() {
        return "pps";
    }

    @Override
    public boolean execute(ViaCommandSender sender, String[] args) {
        TreeMap playerVersions = new TreeMap(ProtocolVersion::compareTo);
        int totalPackets = 0;
        int clients = 0;
        long max = 0L;
        for (UserConnection userConnection : Via.getManager().getConnectionManager().getConnections()) {
            ProtocolVersion playerVersion = userConnection.getProtocolInfo().protocolVersion();
            if (!playerVersions.containsKey(playerVersion)) {
                playerVersions.put(playerVersion, new HashSet());
            }
            if (userConnection.getPacketTracker().getPacketsPerSecond() <= -1L) continue;
            ((Set)playerVersions.get(playerVersion)).add(PPSSubCmd.jvmdowngrader$concat$execute$1(userConnection.getProtocolInfo().getUsername(), userConnection.getPacketTracker().getPacketsPerSecond()));
            totalPackets = (int)((long)totalPackets + userConnection.getPacketTracker().getPacketsPerSecond());
            if (userConnection.getPacketTracker().getPacketsPerSecond() > max) {
                max = userConnection.getPacketTracker().getPacketsPerSecond();
            }
            ++clients;
        }
        this.sendMessage(sender, "&4Live Packets Per Second", new Object[0]);
        if (clients > 1) {
            this.sendMessage(sender, PPSSubCmd.jvmdowngrader$concat$execute$1(totalPackets / clients), new Object[0]);
            this.sendMessage(sender, PPSSubCmd.jvmdowngrader$concat$execute$1(max), new Object[0]);
        }
        if (clients == 0) {
            this.sendMessage(sender, "&cNo clients to display.", new Object[0]);
        }
        for (Map.Entry entry : playerVersions.entrySet()) {
            this.sendMessage(sender, "&8[&6%s&8]: &b%s", ((ProtocolVersion)entry.getKey()).getName(), entry.getValue());
        }
        playerVersions.clear();
        return true;
    }

    private static String jvmdowngrader$concat$execute$1(String string, long l2) {
        return string + " (" + l2 + " PPS)";
    }

    private static String jvmdowngrader$concat$execute$1(int n2) {
        return "&cAverage: &f" + n2;
    }

    private static String jvmdowngrader$concat$execute$1(long l2) {
        return "&cHighest: &f" + l2;
    }
}

