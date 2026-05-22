/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.client.irc.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.modules.client.irc.IRCCommand;
import net.darkmeow.irc.client.interfaces.data.IRCDataOtherSessionInfo;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/irc/commands/IRCCommandPrivate;", "Lnet/ccbluex/liquidbounce/features/module/modules/client/irc/IRCCommand;", "<init>", "()V", "execute", "", "args", "", "", "complete", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nIRCCommandPrivate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IRCCommandPrivate.kt\nnet/ccbluex/liquidbounce/features/module/modules/client/irc/commands/IRCCommandPrivate\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,27:1\n1563#2:28\n1634#2,3:29\n774#2:32\n865#2,2:33\n*S KotlinDebug\n*F\n+ 1 IRCCommandPrivate.kt\nnet/ccbluex/liquidbounce/features/module/modules/client/irc/commands/IRCCommandPrivate\n*L\n22#1:28\n22#1:29,3\n23#1:32\n23#1:33,2\n*E\n"})
public final class IRCCommandPrivate
extends IRCCommand {
    public IRCCommandPrivate() {
        String[] stringArray = new String[]{"private"};
        super(stringArray, true);
    }

    @Override
    public void execute(@NotNull List<String> args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (args.size() < 2) {
            DarkMeow.INSTANCE.getMessageManager().displayChatMessage("\u6307\u4ee4\u7528\u6cd5: /irc:private <\u63a5\u6536\u65b9> <\u5185\u5bb9>");
            return;
        }
        this.getInstance().irc.sendMessageToPrivate(args.get(0), CollectionsKt.joinToString$default(CollectionsKt.drop((Iterable)args, 1), " ", null, null, 0, null, null, 62, null));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<String> complete(@NotNull List<String> args) {
        List list;
        Intrinsics.checkNotNullParameter(args, "args");
        if (args.size() == 1) {
            void $this$filterTo$iv$iv;
            String it;
            Iterable $this$mapTo$iv$iv;
            Collection<? extends IRCDataOtherSessionInfo> collection = this.getInstance().irc.getSessionManager().getSessions().values();
            Intrinsics.checkNotNullExpressionValue(collection, "<get-values>(...)");
            Iterable $this$map$iv = collection;
            boolean $i$f$map = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                IRCDataOtherSessionInfo iRCDataOtherSessionInfo = (IRCDataOtherSessionInfo)item$iv$iv;
                Collection collection2 = destination$iv$iv;
                boolean bl2 = false;
                collection2.add(it.getInfo().getName());
            }
            Iterable $this$filter$iv = (List)destination$iv$iv;
            boolean $i$f$filter = false;
            $this$mapTo$iv$iv = $this$filter$iv;
            destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                it = (String)element$iv$iv;
                boolean bl3 = false;
                if (!StringsKt.startsWith$default(it, CollectionsKt.first(args), false, 2, null)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            list = (List)destination$iv$iv;
        } else {
            list = CollectionsKt.emptyList();
        }
        return list;
    }
}

