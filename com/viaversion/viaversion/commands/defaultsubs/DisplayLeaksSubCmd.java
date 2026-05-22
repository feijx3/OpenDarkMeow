/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.util.ResourceLeakDetector
 *  io.netty.util.ResourceLeakDetector$Level
 */
package com.viaversion.viaversion.commands.defaultsubs;

import com.viaversion.viaversion.api.command.ViaCommandSender;
import com.viaversion.viaversion.api.command.ViaSubCommand;
import io.netty.util.ResourceLeakDetector;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DisplayLeaksSubCmd
implements ViaSubCommand {
    @Override
    public String name() {
        return "displayleaks";
    }

    @Override
    public String description() {
        return "Try to hunt memory leaks!";
    }

    @Override
    public String usage() {
        return "displayleaks <level>";
    }

    @Override
    public boolean execute(ViaCommandSender sender, String[] args) {
        if (args.length == 1) {
            try {
                ResourceLeakDetector.Level level = ResourceLeakDetector.Level.valueOf((String)args[0]);
                ResourceLeakDetector.setLevel((ResourceLeakDetector.Level)level);
                this.sendMessage(sender, DisplayLeaksSubCmd.jvmdowngrader$concat$execute$1(String.valueOf(level)), new Object[0]);
            }
            catch (IllegalArgumentException e2) {
                this.sendMessage(sender, DisplayLeaksSubCmd.jvmdowngrader$concat$execute$2(Arrays.toString(ResourceLeakDetector.Level.values())), new Object[0]);
            }
        } else {
            this.sendMessage(sender, DisplayLeaksSubCmd.jvmdowngrader$concat$execute$3(String.valueOf(ResourceLeakDetector.getLevel())), new Object[0]);
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(ViaCommandSender sender, String[] args) {
        if (args.length == 1) {
            return Arrays.stream(ResourceLeakDetector.Level.values()).map(Enum::name).filter(it -> it.startsWith(args[0])).collect(Collectors.toList());
        }
        return ViaSubCommand.super.onTabComplete(sender, args);
    }

    private static String jvmdowngrader$concat$execute$1(String string) {
        return "&6Set leak detector level to &2" + string;
    }

    private static String jvmdowngrader$concat$execute$2(String string) {
        return "&cInvalid level (" + string + ")";
    }

    private static String jvmdowngrader$concat$execute$3(String string) {
        return "&6Current leak detection level is &2" + string;
    }
}

