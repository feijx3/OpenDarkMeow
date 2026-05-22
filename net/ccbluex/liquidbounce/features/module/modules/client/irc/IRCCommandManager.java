/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.client.irc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.modules.client.IRC;
import net.ccbluex.liquidbounce.features.module.modules.client.irc.IRCCommand;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J \u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0007J&\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\u0006\u0010\f\u001a\u00020\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/irc/IRCCommandManager;", "", "base", "Lnet/ccbluex/liquidbounce/features/module/modules/client/IRC;", "<init>", "(Lnet/ccbluex/liquidbounce/features/module/modules/client/IRC;)V", "getBase", "()Lnet/ccbluex/liquidbounce/features/module/modules/client/IRC;", "commands", "", "Lnet/ccbluex/liquidbounce/features/module/modules/client/irc/IRCCommand;", "execute", "root", "", "args", "", "complete", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nIRCCommandManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IRCCommandManager.kt\nnet/ccbluex/liquidbounce/features/module/modules/client/irc/IRCCommandManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,52:1\n1563#2:53\n1634#2,3:54\n1869#2,2:57\n295#2,2:59\n295#2,2:61\n1374#2:64\n1460#2,5:65\n774#2:70\n865#2,2:71\n1563#2:73\n1634#2,3:74\n1#3:63\n*S KotlinDebug\n*F\n+ 1 IRCCommandManager.kt\nnet/ccbluex/liquidbounce/features/module/modules/client/irc/IRCCommandManager\n*L\n16#1:53\n16#1:54,3\n17#1:57,2\n25#1:59,2\n38#1:61,2\n47#1:64\n47#1:65,5\n48#1:70\n48#1:71,2\n49#1:73\n49#1:74,3\n*E\n"})
public final class IRCCommandManager {
    @NotNull
    private final IRC base;
    @JvmField
    @NotNull
    public final List<IRCCommand> commands;

    /*
     * WARNING - void declaration
     */
    public IRCCommandManager(@NotNull IRC base) {
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter(base, "base");
        this.base = base;
        this.commands = new ArrayList();
        Iterable $this$map$iv = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".commands", IRCCommand.class);
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            Class clazz = (Class)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add((IRCCommand)it.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        Iterable $this$forEach$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            IRCCommand it = (IRCCommand)element$iv;
            boolean bl3 = false;
            it.setInstance(this.base);
            Intrinsics.checkNotNull(it);
            this.commands.add(it);
        }
    }

    @NotNull
    public final IRC getBase() {
        return this.base;
    }

    /*
     * WARNING - void declaration
     */
    @JvmOverloads
    @NotNull
    public final Object execute(@NotNull String root, @NotNull List<String> args) {
        Object object;
        Object v0;
        block5: {
            void $this$firstOrNull$iv;
            Intrinsics.checkNotNullParameter(root, "root");
            Intrinsics.checkNotNullParameter(args, "args");
            Iterable iterable = this.commands;
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                IRCCommand command = (IRCCommand)element$iv;
                boolean bl2 = false;
                if (!command.roots.contains(root)) continue;
                v0 = element$iv;
                break block5;
            }
            v0 = null;
        }
        IRCCommand iRCCommand = v0;
        if (iRCCommand != null) {
            IRCCommand iRCCommand2;
            IRCCommand command = iRCCommand2 = iRCCommand;
            boolean bl3 = false;
            if (command.getOnlyLogin() && !this.base.getState()) {
                DarkMeow.INSTANCE.getMessageManager().displayChatMessage("\u00a7c\u8be5\u547d\u4ee4\u53ea\u80fd\u5728\u767b\u5f55 IRC \u540e\u4f7f\u7528");
            } else {
                command.execute(args);
            }
            object = iRCCommand2;
        } else {
            this.base.irc.sendCommand(root, (ArrayList)CollectionsKt.toCollection((Iterable)args, (Collection)new ArrayList()));
            object = Unit.INSTANCE;
        }
        return object;
    }

    public static /* synthetic */ Object execute$default(IRCCommandManager iRCCommandManager, String string, List list, int n2, Object object) {
        if ((n2 & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        return iRCCommandManager.execute(string, list);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    @JvmOverloads
    @NotNull
    public final List<String> complete(@NotNull String root, @NotNull List<String> args) {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv;
        void $this$flatMapTo$iv$iv;
        void $this$flatMap$iv;
        Object object;
        List<String> list;
        Object v0;
        Object object2;
        block8: {
            Intrinsics.checkNotNullParameter(root, "root");
            Intrinsics.checkNotNullParameter(args, "args");
            Iterable iterable = this.commands;
            boolean $i$f$firstOrNull = false;
            object2 = iterable.iterator();
            while (object2.hasNext()) {
                Object element$iv = object2.next();
                IRCCommand command = (IRCCommand)element$iv;
                boolean bl2 = false;
                if (!command.roots.contains(root)) continue;
                v0 = element$iv;
                break block8;
            }
            v0 = null;
        }
        IRCCommand iRCCommand = v0;
        if (iRCCommand != null) {
            IRCCommand command = iRCCommand;
            boolean bl3 = false;
            List<String> list2 = command.getOnlyLogin() && !this.base.getState() ? CollectionsKt.emptyList() : command.complete(args);
            if (list2 != null) {
                list = list2;
                return list;
            }
        }
        Object it = object2 = this.commands;
        boolean bl4 = false;
        Object object3 = object = args.isEmpty() ? object2 : null;
        if (object == null) {
            list = CollectionsKt.emptyList();
            return list;
        }
        it = (Iterable)object;
        boolean $i$f$flatMap22 = false;
        void bl2 = $this$flatMap$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
            IRCCommand it2 = (IRCCommand)element$iv$iv;
            boolean bl5 = false;
            Iterable list$iv$iv = it2.roots;
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        Iterable $i$f$flatMap22 = (List)destination$iv$iv;
        boolean $i$f$filter = false;
        destination$iv$iv = $this$filter$iv;
        Collection destination$iv$iv2 = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            String it3 = (String)element$iv$iv;
            boolean bl6 = false;
            if (!StringsKt.startsWith(it3, root, true)) continue;
            destination$iv$iv2.add(element$iv$iv);
        }
        $this$filter$iv = (List)destination$iv$iv2;
        boolean $i$f$map = false;
        $this$filterTo$iv$iv = $this$map$iv;
        destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        Iterator iterator2 = $this$mapTo$iv$iv.iterator();
        while (true) {
            if (!iterator2.hasNext()) {
                list = (List)destination$iv$iv2;
                return list;
            }
            Object item$iv$iv = iterator2.next();
            String it3 = (String)item$iv$iv;
            Collection collection = destination$iv$iv2;
            boolean bl7 = false;
            collection.add("/irc:" + it3);
        }
    }

    public static /* synthetic */ List complete$default(IRCCommandManager iRCCommandManager, String string, List list, int n2, Object object) {
        if ((n2 & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        return iRCCommandManager.complete(string, list);
    }

    @JvmOverloads
    @NotNull
    public final Object execute(@NotNull String root) {
        Intrinsics.checkNotNullParameter(root, "root");
        return IRCCommandManager.execute$default(this, root, null, 2, null);
    }

    @JvmOverloads
    @NotNull
    public final List<String> complete(@NotNull String root) {
        Intrinsics.checkNotNullParameter(root, "root");
        return IRCCommandManager.complete$default(this, root, null, 2, null);
    }
}

