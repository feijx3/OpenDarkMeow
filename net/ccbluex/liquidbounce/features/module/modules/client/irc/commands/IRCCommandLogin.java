/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.client.irc.commands;

import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.modules.client.irc.IRCCommand;
import net.darkmeow.darkmeow.irc.config.IRCGlobalConfigManager;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/irc/commands/IRCCommandLogin;", "Lnet/ccbluex/liquidbounce/features/module/modules/client/irc/IRCCommand;", "<init>", "()V", "execute", "", "args", "", "", "DarkMeow"})
public final class IRCCommandLogin
extends IRCCommand {
    public IRCCommandLogin() {
        String[] stringArray = new String[]{"login"};
        super(stringArray, false);
    }

    @Override
    public void execute(@NotNull List<String> args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (args.size() < 2) {
            DarkMeow.INSTANCE.getMessageManager().displayChatMessage("\u6307\u4ee4\u7528\u6cd5: /irc:login <\u7528\u6237\u540d> <\u5bc6\u7801>");
            return;
        }
        this.getInstance().onDisable();
        IRCGlobalConfigManager.INSTANCE.reset();
        IRCGlobalConfigManager.INSTANCE.getConfig().setUser(args.get(0));
        IRCGlobalConfigManager.INSTANCE.getConfig().setPassword(args.get(1));
        IRCGlobalConfigManager.INSTANCE.save();
        boolean bl2 = this.getInstance().getState();
        if (bl2) {
            this.getInstance().onEnable();
        } else if (!bl2) {
            this.getInstance().setState(true);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}

