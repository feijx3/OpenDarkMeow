/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.commands.defaultsubs;

import com.viaversion.viaversion.api.command.ViaCommandSender;
import com.viaversion.viaversion.api.command.ViaSubCommand;
import com.viaversion.viaversion.util.DumpUtil;

public class DumpSubCmd
implements ViaSubCommand {
    @Override
    public String name() {
        return "dump";
    }

    @Override
    public String description() {
        return "Dump information about your platform implementation, this is helpful if you report bugs.";
    }

    @Override
    public boolean execute(ViaCommandSender sender, String[] args) {
        DumpUtil.postDump(sender.getUUID()).whenComplete((url, e2) -> {
            if (e2 != null) {
                sender.sendMessage(DumpSubCmd.jvmdowngrader$concat$lambda$execute$0$1(e2.getMessage()));
                return;
            }
            sender.sendMessage(DumpSubCmd.jvmdowngrader$concat$lambda$execute$0$2(url));
        });
        return true;
    }

    private static String jvmdowngrader$concat$lambda$execute$0$1(String string) {
        return "\u00a74" + string;
    }

    private static String jvmdowngrader$concat$lambda$execute$0$2(String string) {
        return "\u00a72We've made a dump with useful information, report your issue and provide this url: " + string;
    }
}

