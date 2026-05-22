/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.darkmeow.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.handler.ManagerBase;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.utils.ClientUtils;
import net.darkmeow.darkmeow.commands.Command;
import net.darkmeow.darkmeow.commands.CommandManagerListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J#\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0015\u00a2\u0006\u0002\u0010\u0016J$\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00152\u0006\u0010\u0013\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0015J\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0010J\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0010J\u0006\u0010\u001d\u001a\u00020\u0019R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2={"Lnet/darkmeow/darkmeow/commands/CommandManager;", "Lnet/ccbluex/liquidbounce/handler/ManagerBase;", "system", "Lnet/ccbluex/liquidbounce/DarkMeow;", "<init>", "(Lnet/ccbluex/liquidbounce/DarkMeow;)V", "listener", "Lnet/darkmeow/darkmeow/commands/CommandManagerListener;", "prefix", "", "getPrefix", "()Ljava/lang/String;", "setPrefix", "(Ljava/lang/String;)V", "commands", "", "Lnet/darkmeow/darkmeow/commands/Command;", "handleCommandExecute", "", "root", "args", "", "(Ljava/lang/String;Ljava/util/List;)Ljava/lang/Boolean;", "handleCommandComplete", "registerAllCommands", "", "registerCommand", "command", "unregisterCommand", "unregisterAllCommands", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nCommandManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommandManager.kt\nnet/darkmeow/darkmeow/commands/CommandManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,85:1\n295#2:86\n296#2:89\n295#2:95\n296#2:98\n1374#2:103\n1460#2,5:104\n1563#2:109\n1634#2,3:110\n774#2:113\n865#2,2:114\n1056#2:116\n1563#2:117\n1634#2,3:118\n1869#2,2:121\n12637#3,2:87\n12637#3,2:96\n1#4:90\n37#5:91\n36#5,3:92\n37#5:99\n36#5,3:100\n*S KotlinDebug\n*F\n+ 1 CommandManager.kt\nnet/darkmeow/darkmeow/commands/CommandManager\n*L\n27#1:86\n27#1:89\n36#1:95\n36#1:98\n45#1:103\n45#1:104,5\n46#1:109\n46#1:110,3\n47#1:113\n47#1:114,2\n48#1:116\n56#1:117\n56#1:118,3\n57#1:121,2\n27#1:87,2\n36#1:96,2\n28#1:91\n28#1:92,3\n37#1:99\n37#1:100,3\n*E\n"})
public final class CommandManager
extends ManagerBase {
    @JvmField
    @NotNull
    public final CommandManagerListener listener;
    @NotNull
    private String prefix;
    @JvmField
    @NotNull
    public final Set<Command> commands;

    public CommandManager(@NotNull DarkMeow system) {
        Intrinsics.checkNotNullParameter(system, "system");
        super(system);
        this.listener = new CommandManagerListener(this);
        this.prefix = ".";
        this.commands = new LinkedHashSet();
        EventManager.registerListener$default(system.getEventManager(), this.listener, false, false, 6, null);
        this.registerAllCommands();
    }

    @NotNull
    public final String getPrefix() {
        return this.prefix;
    }

    public final void setPrefix(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<set-?>");
        this.prefix = string;
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public final Boolean handleCommandExecute(@NotNull String root, @NotNull List<String> args) {
        Boolean bl2;
        Object v1;
        Object it;
        block8: {
            void $this$firstOrNull$iv;
            Intrinsics.checkNotNullParameter(root, "root");
            Intrinsics.checkNotNullParameter(args, "args");
            Iterable iterable = this.commands;
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                boolean bl3;
                block7: {
                    it = (Command)element$iv;
                    boolean bl4 = false;
                    String[] $this$any$iv = ((Command)it).root;
                    boolean $i$f$any = false;
                    int n2 = $this$any$iv.length;
                    for (int i2 = 0; i2 < n2; ++i2) {
                        String element$iv2;
                        String r2 = element$iv2 = $this$any$iv[i2];
                        boolean bl5 = false;
                        if (!StringsKt.equals(r2, root, true)) continue;
                        bl3 = true;
                        break block7;
                    }
                    bl3 = false;
                }
                if (!bl3) continue;
                v1 = element$iv;
                break block8;
            }
            v1 = null;
        }
        Command command = v1;
        if (command != null) {
            Object object;
            Command command2 = command;
            try {
                Command $this$handleCommandExecute_u24lambda_u242 = command2;
                boolean bl6 = false;
                Collection $this$toTypedArray$iv = args;
                boolean $i$f$toTypedArray = false;
                Collection thisCollection$iv = $this$toTypedArray$iv;
                $this$handleCommandExecute_u24lambda_u242.execute(this.getSystem(), DarkMeow.mc, thisCollection$iv.toArray(new String[0]));
                object = Result.constructor-impl(Unit.INSTANCE);
            }
            catch (Throwable throwable) {
                object = Result.constructor-impl(ResultKt.createFailure(throwable));
            }
            Throwable throwable = Result.exceptionOrNull-impl(object);
            if (throwable != null) {
                Throwable throwable2 = throwable;
                it = throwable2;
                boolean bl7 = false;
                ClientUtils.INSTANCE.logError("Failed to execute command: " + root + ' ' + CollectionsKt.joinToString$default(args, " ", null, null, 0, null, null, 62, null), (Throwable)it);
            }
            bl2 = Result.isSuccess-impl(object);
        } else {
            bl2 = null;
        }
        return bl2;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Nullable
    public final List<String> handleCommandComplete(@NotNull String root, @NotNull List<String> args) {
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv;
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        void $this$flatMapTo$iv$iv;
        Set<Command> set;
        List list;
        List list2;
        Set<Command> set2;
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(args, "args");
        Object object = this.commands;
        Set<Command> set3 = object;
        boolean bl2 = false;
        Set<Command> set4 = set2 = !((Collection)args).isEmpty() ? object : null;
        if (set2 != null) {
            Object it;
            Object v1;
            List list3;
            block16: {
                Object element$iv;
                boolean bl3;
                Iterable iterable = set2;
                boolean $i$f$firstOrNull = false;
                list3 = iterable.iterator();
                block2: do {
                    if (!list3.hasNext()) {
                        v1 = null;
                        break block16;
                    }
                    element$iv = list3.next();
                    it = (Command)element$iv;
                    boolean bl4 = false;
                    String[] $this$any$iv = ((Command)it).root;
                    boolean $i$f$any = false;
                    int n2 = $this$any$iv.length;
                    for (int i2 = 0; i2 < n2; ++i2) {
                        Object element$iv2;
                        Object r2 = element$iv2 = $this$any$iv[i2];
                        boolean bl5 = false;
                        if (!StringsKt.equals((String)r2, root, true)) continue;
                        bl3 = true;
                        continue block2;
                    }
                    bl3 = false;
                } while (!bl3);
                v1 = element$iv;
            }
            object = v1;
            if (object != null) {
                List list4;
                Object object2 = object;
                try {
                    Object $this$handleCommandComplete_u24lambda_u247 = object2;
                    boolean bl6 = false;
                    Collection $this$toTypedArray$iv = args;
                    boolean bl7 = false;
                    Collection thisCollection$iv = $this$toTypedArray$iv;
                    list3 = Result.constructor-impl(((Command)$this$handleCommandComplete_u24lambda_u247).complete(this.getSystem(), DarkMeow.mc, thisCollection$iv.toArray(new String[0])));
                }
                catch (Throwable throwable) {
                    list3 = Result.constructor-impl(ResultKt.createFailure(throwable));
                }
                Throwable throwable = Result.exceptionOrNull-impl(list3);
                if (throwable != null) {
                    Throwable throwable2 = throwable;
                    it = throwable2;
                    boolean bl8 = false;
                    ClientUtils.INSTANCE.logError("Failed to complete command: " + root + ' ' + CollectionsKt.joinToString$default(args, " ", null, null, 0, null, null, 62, null), (Throwable)it);
                }
                list2 = list3;
                Throwable throwable3 = Result.exceptionOrNull-impl(list2);
                if (throwable3 == null) {
                    list4 = list2;
                } else {
                    it = throwable3;
                    boolean bl9 = false;
                    list4 = CollectionsKt.emptyList();
                }
                list3 = list4;
                if (list3 != null) {
                    list = list3;
                    return list;
                }
            }
        }
        Set<Command> set5 = set = this.commands;
        boolean bl10 = false;
        if (!args.isEmpty()) return null;
        Set<Command> set6 = set;
        list2 = set6;
        if (list2 == null) {
            return null;
        }
        Iterable iterable = list2;
        boolean $i$f$flatMap22 = false;
        Iterable $i$f$any = iterable;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
            Command it = (Command)element$iv$iv;
            boolean bl11 = false;
            Iterable list$iv$iv = ArraysKt.toList(it.root);
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        Iterable $i$f$flatMap22 = (List)destination$iv$iv;
        boolean $i$f$map22 = false;
        destination$iv$iv = $this$map$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            String bl11 = (String)item$iv$iv;
            Collection collection = destination$iv$iv2;
            boolean bl12 = false;
            StringBuilder stringBuilder = new StringBuilder().append('.');
            String string = it.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(string, "toLowerCase(...)");
            collection.add(stringBuilder.append(string).toString());
        }
        Iterable $i$f$map22 = (List)destination$iv$iv2;
        boolean $i$f$filter = false;
        destination$iv$iv2 = $this$filter$iv;
        Collection destination$iv$iv3 = new ArrayList();
        boolean $i$f$filterTo = false;
        Iterator iterator2 = $this$filterTo$iv$iv.iterator();
        while (true) {
            if (!iterator2.hasNext()) {
                void $this$sortedBy$iv;
                $this$filter$iv = (List)destination$iv$iv3;
                boolean $i$f$sortedBy = false;
                list = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                    /*
                     * WARNING - void declaration
                     */
                    public final int compare(T a2, T b2) {
                        void var3_3;
                        String it = (String)a2;
                        boolean bl2 = false;
                        Comparable comparable = (Comparable)((Object)it);
                        it = (String)b2;
                        Comparable comparable2 = comparable;
                        bl2 = false;
                        return ComparisonsKt.compareValues(comparable2, (Comparable)var3_3);
                    }
                });
                return list;
            }
            Object element$iv$iv = iterator2.next();
            String it = (String)element$iv$iv;
            boolean bl13 = false;
            if (!StringsKt.startsWith(it, '.' + root, true)) continue;
            destination$iv$iv3.add(element$iv$iv);
        }
    }

    /*
     * WARNING - void declaration
     */
    public final void registerAllCommands() {
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".impl", Command.class);
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            Class clazz = (Class)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add((Command)it.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        Iterable $this$forEach$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Command it = (Command)element$iv;
            boolean bl3 = false;
            Intrinsics.checkNotNull(it);
            this.registerCommand(it);
        }
    }

    public final void registerCommand(@NotNull Command command) {
        Intrinsics.checkNotNullParameter(command, "command");
        this.commands.add(command);
        EventManager.registerListener$default(this.getSystem().getEventManager(), command, false, false, 6, null);
    }

    public final void unregisterCommand(@NotNull Command command) {
        Intrinsics.checkNotNullParameter(command, "command");
        this.commands.remove(command);
        this.getSystem().getEventManager().unregisterListener(command);
    }

    public final void unregisterAllCommands() {
        this.commands.clear();
    }
}

