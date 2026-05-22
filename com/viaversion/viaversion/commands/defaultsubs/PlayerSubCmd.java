/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.commands.defaultsubs;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.command.ViaCommandSender;
import com.viaversion.viaversion.api.command.ViaSubCommand;
import com.viaversion.viaversion.api.connection.ProtocolInfo;
import com.viaversion.viaversion.api.connection.UserConnection;
import java.util.ArrayList;
import java.util.List;

public class PlayerSubCmd
implements ViaSubCommand {
    @Override
    public String name() {
        return "player";
    }

    @Override
    public String description() {
        return "Shows connection information about one or all players.";
    }

    @Override
    public String usage() {
        return "player <name|*>";
    }

    @Override
    public boolean execute(ViaCommandSender sender, String[] args) {
        if (args.length == 0) {
            return false;
        }
        boolean all = args[0].equals("*");
        boolean any = false;
        for (UserConnection connection : Via.getManager().getConnectionManager().getConnections()) {
            ProtocolInfo info = connection.getProtocolInfo();
            if (!args[0].equalsIgnoreCase(info.getUsername()) && !all) continue;
            this.sendMessage(sender, PlayerSubCmd.jvmdowngrader$concat$execute$1(info.getUsername(), String.valueOf(info.getUuid()), info.protocolVersion().getName(), info.serverProtocolVersion().getName(), connection.isClientSide()), new Object[0]);
            any = true;
        }
        if (!any) {
            this.sendMessage(sender, all ? "&cNo players found!" : PlayerSubCmd.jvmdowngrader$concat$execute$1(args[0]), new Object[0]);
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(ViaCommandSender sender, String[] args) {
        if (args.length == 1) {
            String input = args[0].toLowerCase();
            ArrayList<String> matches = new ArrayList<String>();
            for (UserConnection connection : Via.getManager().getConnectionManager().getConnections()) {
                String name = connection.getProtocolInfo().getUsername();
                if (!input.isEmpty() && !name.toLowerCase().startsWith(input)) continue;
                matches.add(name);
            }
            matches.add("*");
            return matches;
        }
        return ViaSubCommand.super.onTabComplete(sender, args);
    }

    private static String jvmdowngrader$concat$execute$1(String string, String string2, String string3, String string4, boolean bl2) {
        return "&7[&6" + string + "&7] UUID: &2" + string2 + " &7Client protocol: &2" + string3 + " &7Server protocol: &2" + string4 + " &7Client: &2" + bl2;
    }

    private static String jvmdowngrader$concat$execute$1(String string) {
        return "&cNo player found with the name: " + string;
    }
}

