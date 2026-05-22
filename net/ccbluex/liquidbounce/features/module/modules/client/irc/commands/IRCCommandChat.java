/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.client.irc.commands;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.modules.client.irc.IRCCommand;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/irc/commands/IRCCommandChat;", "Lnet/ccbluex/liquidbounce/features/module/modules/client/irc/IRCCommand;", "<init>", "()V", "execute", "", "args", "", "", "DarkMeow"})
public final class IRCCommandChat
extends IRCCommand {
    public IRCCommandChat() {
        String[] stringArray = new String[]{"chat"};
        super(stringArray, true);
    }

    @Override
    public void execute(@NotNull List<String> args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (args.isEmpty()) {
            DarkMeow.INSTANCE.getMessageManager().displayChatMessage("\u6307\u4ee4\u7528\u6cd5: /irc:chat <\u8981\u53d1\u9001\u7684\u804a\u5929\u5185\u5bb9>");
            return;
        }
        this.getInstance().irc.sendMessageToPublic(CollectionsKt.joinToString$default(args, " ", null, null, 0, null, null, 62, null));
    }
}

