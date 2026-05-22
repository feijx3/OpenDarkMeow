/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmStatic
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.irc;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import net.darkmeow.darkmeow.irc.config.IRCGlobalConfigManager;
import net.darkmeow.darkmeow.irc.config.IRCStaticConfigs;
import net.darkmeow.darkmeow.irc.ui.IRCVerifyMainMenu;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007\u00a8\u0006\u0006"}, d2={"Lnet/darkmeow/darkmeow/irc/IRCVerify;", "", "<init>", "()V", "isAllowLoad", "", "DarkMeow"})
public final class IRCVerify {
    @NotNull
    public static final IRCVerify INSTANCE = new IRCVerify();

    private IRCVerify() {
    }

    @JvmStatic
    public static final boolean isAllowLoad() {
        if (IRCStaticConfigs.INSTANCE.getVERIFY_ON_LAUNCH() == IRCStaticConfigs.IRCVerify.DISABLE) {
            return true;
        }
        IRCGlobalConfigManager.INSTANCE.read();
        if (IRCStaticConfigs.INSTANCE.getVERIFY_ON_LAUNCH() == IRCStaticConfigs.IRCVerify.LITE && IRCGlobalConfigManager.INSTANCE.getConfig().isToken()) {
            return true;
        }
        return new IRCVerifyMainMenu().waitForClose();
    }
}

