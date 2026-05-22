/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.command;

import com.viaversion.viaversion.api.command.ViaCommandSender;
import com.viaversion.viaversion.util.ChatColorUtil;
import java.util.Collections;
import java.util.List;

public interface ViaSubCommand {
    public String name();

    public String description();

    default public String usage() {
        return this.name();
    }

    default public String permission() {
        return ViaSubCommand.jvmdowngrader$concat$permission$1(this.name());
    }

    public boolean execute(ViaCommandSender var1, String[] var2);

    default public List<String> onTabComplete(ViaCommandSender sender, String[] args) {
        return Collections.emptyList();
    }

    public static String color(String s2) {
        return ChatColorUtil.translateAlternateColorCodes(s2);
    }

    default public void sendMessage(ViaCommandSender sender, String message, Object ... args) {
        sender.sendMessage(ViaSubCommand.color(args == null ? message : String.format(message, args)));
    }

    private static String jvmdowngrader$concat$permission$1(String string) {
        return "viaversion.admin." + string;
    }
}

