/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.darkmeow.commands;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.Listenable;
import net.ccbluex.liquidbounce.event.events.player.CompleteMessageEvent;
import net.ccbluex.liquidbounce.event.events.player.SendMessageEvent;
import net.darkmeow.darkmeow.commands.CommandManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u001d\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\u000fH\u0007\u00a2\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0013"}, d2={"Lnet/darkmeow/darkmeow/commands/CommandManagerListener;", "Lnet/ccbluex/liquidbounce/event/Listenable;", "manager", "Lnet/darkmeow/darkmeow/commands/CommandManager;", "<init>", "(Lnet/darkmeow/darkmeow/commands/CommandManager;)V", "getManager", "()Lnet/darkmeow/darkmeow/commands/CommandManager;", "onSendMessage", "", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/SendMessageEvent;", "onCompleteMessage", "", "Lnet/ccbluex/liquidbounce/event/events/player/CompleteMessageEvent;", "(Lnet/ccbluex/liquidbounce/event/events/player/CompleteMessageEvent;)[Ljava/lang/String;", "handleEvents", "", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nCommandManagerListener.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommandManagerListener.kt\nnet/darkmeow/darkmeow/commands/CommandManagerListener\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,32:1\n1#2:33\n37#3:34\n36#3,3:35\n*S KotlinDebug\n*F\n+ 1 CommandManagerListener.kt\nnet/darkmeow/darkmeow/commands/CommandManagerListener\n*L\n28#1:34\n28#1:35,3\n*E\n"})
public final class CommandManagerListener
implements Listenable {
    @NotNull
    private final CommandManager manager;

    public CommandManagerListener(@NotNull CommandManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        this.manager = manager;
    }

    @NotNull
    public final CommandManager getManager() {
        return this.manager;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @EventTarget
    @Nullable
    public final List<String> onSendMessage(@NotNull SendMessageEvent event) {
        List list;
        List list2;
        List list3;
        String string;
        Intrinsics.checkNotNullParameter(event, "event");
        String string2 = (String)event.getReturnValue();
        if (string2 == null) return null;
        String it = string = string2;
        boolean bl2 = false;
        if (!StringsKt.startsWith$default(it, this.manager.getPrefix(), false, 2, null)) return null;
        String string3 = string;
        String string4 = string3;
        if (string4 == null) return null;
        string = StringsKt.removePrefix(string4, (CharSequence)this.manager.getPrefix());
        if (string == null) return null;
        String[] stringArray = new String[]{" "};
        List list4 = StringsKt.split$default((CharSequence)string, stringArray, false, 0, 6, null);
        if (list4 == null) return null;
        List list5 = list3 = list4;
        boolean bl3 = false;
        if (((Collection)list5).isEmpty()) return null;
        boolean bl4 = true;
        if (!bl4) return null;
        List list6 = list3;
        List list7 = list6;
        if (list7 == null) return null;
        List list8 = list2 = list7;
        boolean bl5 = false;
        this.manager.handleCommandExecute((String)CollectionsKt.first(list8), CollectionsKt.drop(list8, 1));
        List list9 = list = list2;
        boolean bl6 = false;
        event.cancelEvent();
        List list10 = list;
        return list10;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @EventTarget
    @Nullable
    public final String[] onCompleteMessage(@NotNull CompleteMessageEvent event) {
        String[] stringArray;
        List<String> list;
        String string;
        Intrinsics.checkNotNullParameter(event, "event");
        String it = string = event.getMessage();
        boolean bl2 = false;
        if (!StringsKt.startsWith$default(it, this.manager.getPrefix(), false, 2, null)) return null;
        String string2 = string;
        String string3 = string2;
        if (string3 == null) return null;
        string = StringsKt.removePrefix(string3, (CharSequence)this.manager.getPrefix());
        if (string == null) return null;
        String[] stringArray2 = new String[]{" "};
        List<String> list2 = StringsKt.split$default((CharSequence)string, stringArray2, false, 0, 6, null);
        if (list2 == null) return null;
        List<String> it2 = list = list2;
        boolean bl3 = false;
        if (((Collection)it2).isEmpty()) return null;
        boolean bl4 = true;
        if (!bl4) return null;
        List<String> list3 = list;
        List<String> list4 = list3;
        if (list4 == null) return null;
        List<String> list5 = list4;
        boolean bl5 = false;
        list = this.manager.handleCommandComplete((String)CollectionsKt.first(list5), CollectionsKt.drop((Iterable)list5, 1));
        if (list == null) return null;
        Collection collection = list;
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = collection;
        String[] stringArray3 = thisCollection$iv.toArray(new String[0]);
        if (stringArray3 == null) return null;
        String[] it3 = stringArray = stringArray3;
        boolean bl6 = false;
        event.setReturnValue(it3);
        String[] stringArray4 = stringArray;
        return stringArray4;
    }

    @Override
    public boolean handleEvents() {
        return true;
    }
}

