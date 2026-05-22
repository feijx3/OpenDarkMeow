/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.commands.impl.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.darkmeow.darkmeow.commands.Command;
import net.darkmeow.darkmeow.commands.impl.client.set.CommandSetAction;
import net.darkmeow.darkmeow.commands.impl.client.set.result.CommandSetActionResult;
import net.darkmeow.darkmeow.commands.impl.client.set.result.CommandSetActionResultFailed;
import net.darkmeow.darkmeow.commands.impl.client.set.result.CommandSetActionResultSuccess;
import net.darkmeow.darkmeow.commands.impl.client.set.result.CommandSetActionResultSyntax;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016\u00a2\u0006\u0002\u0010\u0010J1\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016\u00a2\u0006\u0002\u0010\u0013R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lnet/darkmeow/darkmeow/commands/impl/client/CommandSet;", "Lnet/darkmeow/darkmeow/commands/Command;", "<init>", "()V", "actions", "", "Lnet/darkmeow/darkmeow/commands/impl/client/set/CommandSetAction;", "execute", "", "system", "Lnet/ccbluex/liquidbounce/DarkMeow;", "mc", "Lnet/minecraft/client/Minecraft;", "args", "", "", "(Lnet/ccbluex/liquidbounce/DarkMeow;Lnet/minecraft/client/Minecraft;[Ljava/lang/String;)V", "complete", "", "(Lnet/ccbluex/liquidbounce/DarkMeow;Lnet/minecraft/client/Minecraft;[Ljava/lang/String;)Ljava/util/List;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nCommandSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommandSet.kt\nnet/darkmeow/darkmeow/commands/impl/client/CommandSet\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,79:1\n1563#2:80\n1634#2,3:81\n2756#2:84\n295#2,2:90\n1563#2:93\n1634#2,3:94\n774#2:97\n865#2,2:98\n1563#2:100\n1634#2,3:101\n774#2:104\n865#2,2:105\n295#2,2:107\n1#3:85\n1#3:92\n37#4:86\n36#4,3:87\n37#4:109\n36#4,3:110\n*S KotlinDebug\n*F\n+ 1 CommandSet.kt\nnet/darkmeow/darkmeow/commands/impl/client/CommandSet\n*L\n19#1:80\n19#1:81,3\n20#1:84\n32#1:90,2\n62#1:93\n62#1:94,3\n63#1:97\n63#1:98,2\n67#1:100\n67#1:101,3\n68#1:104\n68#1:105,2\n74#1:107,2\n20#1:85\n29#1:86\n29#1:87,3\n74#1:109\n74#1:110,3\n*E\n"})
public final class CommandSet
extends Command {
    @JvmField
    @NotNull
    public final Set<CommandSetAction> actions;

    /*
     * WARNING - void declaration
     */
    public CommandSet() {
        CommandSetAction it;
        void $this$mapTo$iv$iv;
        String[] stringArray = new String[]{"Set", "S"};
        super(stringArray);
        this.actions = new LinkedHashSet();
        Iterable $this$map$iv = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".set", CommandSetAction.class);
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            Class clazz = (Class)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add((CommandSetAction)((Class)((Object)it)).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        Iterable $this$onEach$iv = (List)destination$iv$iv;
        boolean $i$f$onEach = false;
        Iterable $this$onEach_u24lambda_u2418$iv = iterable = $this$onEach$iv;
        boolean bl3 = false;
        for (Object element$iv : $this$onEach_u24lambda_u2418$iv) {
            it = (CommandSetAction)element$iv;
            boolean bl4 = false;
            Intrinsics.checkNotNull(it);
            this.actions.add(it);
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void execute(@NotNull DarkMeow system, @NotNull Minecraft mc, @NotNull String[] args) {
        block14: {
            Object object;
            CommandSetActionResult it;
            Object object2;
            Intrinsics.checkNotNullParameter(system, "system");
            Intrinsics.checkNotNullParameter(mc, "mc");
            Intrinsics.checkNotNullParameter(args, "args");
            Object object3 = this;
            try {
                Object v2;
                String[] value;
                Value<?> key;
                Module module;
                block13: {
                    void $this$firstOrNull$iv;
                    CommandSet $this$execute_u24lambda_u244 = object3;
                    boolean bl2 = false;
                    if (args.length < 2) {
                        throw new Exception("");
                    }
                    Module module2 = DarkMeow.INSTANCE.getModuleManager().getModule(args[0]);
                    if (module2 == null) {
                        throw new Exception("\u6a21\u5757 " + args[0] + " \u4e0d\u5b58\u5728");
                    }
                    module = module2;
                    Value<?> value2 = module.getValue(args[1]);
                    if (value2 == null) {
                        throw new Exception("\u6a21\u5757 " + args[0] + " \u914d\u7f6e " + args[1] + " \u4e0d\u5b58\u5728");
                    }
                    key = value2;
                    Collection $this$toTypedArray$iv = ArraysKt.drop(args, 2);
                    boolean $i$f$toTypedArray22 = false;
                    Collection thisCollection$iv = $this$toTypedArray$iv;
                    value = thisCollection$iv.toArray(new String[0]);
                    Iterable $i$f$toTypedArray22 = $this$execute_u24lambda_u244.actions;
                    boolean $i$f$firstOrNull = false;
                    for (Object element$iv : $this$firstOrNull$iv) {
                        CommandSetAction it2 = (CommandSetAction)element$iv;
                        boolean bl3 = false;
                        if (!it2.canExecute(key)) continue;
                        v2 = element$iv;
                        break block13;
                    }
                    v2 = null;
                }
                object2 = v2;
                it = object2 != null ? ((CommandSetAction)object2).execute(key, value) : null;
                boolean bl4 = false;
                object = Result.constructor-impl(new Pair(new Pair(module, key), it));
            }
            catch (Throwable bl2) {
                object = Result.constructor-impl(ResultKt.createFailure(bl2));
            }
            object3 = object;
            Throwable throwable = Result.exceptionOrNull-impl(object3);
            if (throwable != null) {
                Unit unit;
                Object e2 = object = throwable;
                boolean bl5 = false;
                boolean key = Intrinsics.areEqual(((Throwable)e2).getMessage(), "");
                if (key) {
                    unit = system.getMessageManager().display.displayDarkCommandSyntax("set <module> <key> [..]");
                } else if (!key) {
                    unit = system.getMessageManager().display.displayError("\u53c2\u6570\u6709\u8bef: " + ((Throwable)e2).getMessage());
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            Pair pair = (Pair)(Result.isFailure-impl(object3) ? null : object3);
            if (pair == null) break block14;
            object = object3 = pair;
            boolean bl6 = false;
            Pair module = (Pair)((Pair)object).component1();
            CommandSetActionResult update = (CommandSetActionResult)((Pair)object).component2();
            if (update != null) {
                object2 = update;
                it = object2;
                boolean bl7 = false;
                CommandSetActionResult state = it;
                Unit unit = state instanceof CommandSetActionResultSuccess ? system.getMessageManager().display.displaySuccess(((Module)module.getFirst()).getName() + '/' + ((Value)module.getSecond()).getName() + "  " + ((CommandSetActionResultSuccess)state).getOldValue() + " -> " + ((CommandSetActionResultSuccess)state).getNewValue()) : (state instanceof CommandSetActionResultFailed ? system.getMessageManager().display.displayError(((Module)module.getFirst()).getName() + '/' + ((Value)module.getSecond()).getName() + "  " + ((CommandSetActionResultFailed)state).getText()) : (state instanceof CommandSetActionResultSyntax ? system.getMessageManager().display.displayDarkCommandSyntax("set <module> <key> " + ((CommandSetActionResultSyntax)state).getSyntax()) : system.getMessageManager().display.displayError(((Module)module.getFirst()).getName() + '/' + ((Value)module.getSecond()).getName() + "  \u8fd4\u56de\u9519\u8bef")));
            } else {
                CommandSet $this$execute_u24lambda_u248_u24lambda_u247 = this;
                boolean bl8 = false;
                system.getMessageManager().display.displayError("\u6682\u4e0d\u652f\u6301\u4fee\u6539\u6b64\u7c7b\u578b\u914d\u7f6e(" + ((Module)module.getFirst()).getName() + '/' + ((Value)module.getSecond()).getName() + ')');
            }
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    @Override
    @NotNull
    public List<String> complete(@NotNull DarkMeow system, @NotNull Minecraft mc, @NotNull String[] args) {
        Value<?> value;
        List<String> list;
        Intrinsics.checkNotNullParameter(system, "system");
        Intrinsics.checkNotNullParameter(mc, "mc");
        Intrinsics.checkNotNullParameter(args, "args");
        int n2 = args.length;
        if (n2 == 1) {
            void $this$filterTo$iv$iv;
            void $this$filter$iv;
            String it;
            void $this$mapTo$iv$iv;
            Iterable $this$map$iv;
            Iterable iterable = system.getModuleManager().getModules();
            boolean $i$f$map = false;
            void var7_11 = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                Module module = (Module)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl2 = false;
                collection.add(((Module)((Object)it)).getName());
            }
            $this$map$iv = (List)destination$iv$iv;
            boolean $i$f$filter = false;
            $this$mapTo$iv$iv = $this$filter$iv;
            destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            Iterator iterator2 = $this$filterTo$iv$iv.iterator();
            while (true) {
                if (!iterator2.hasNext()) {
                    list = CollectionsKt.toList((List)destination$iv$iv);
                    return list;
                }
                Object element$iv$iv = iterator2.next();
                it = (String)element$iv$iv;
                boolean bl3 = false;
                if (!StringsKt.startsWith(it, ArraysKt.last(args), true)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
        }
        if (n2 == 2) {
            List<Value<?>> list2;
            Module module = system.getModuleManager().getModule(args[0]);
            if (module != null && (list2 = module.getValues()) != null) {
                void $this$filterTo$iv$iv;
                List $this$filter$iv;
                void $this$mapTo$iv$iv;
                void $this$map$iv;
                Iterable destination$iv$iv = list2;
                boolean $i$f$map22 = false;
                void var10_20 = $this$map$iv;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                boolean $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    void it;
                    Value value2 = (Value)item$iv$iv;
                    Collection collection = destination$iv$iv2;
                    boolean bl4 = false;
                    collection.add(it.getName());
                }
                Iterable $i$f$map22 = (List)destination$iv$iv2;
                boolean $i$f$filter = false;
                destination$iv$iv2 = $this$filter$iv;
                Collection destination$iv$iv3 = new ArrayList();
                boolean $i$f$filterTo = false;
                for (Object element$iv$iv : $this$filterTo$iv$iv) {
                    String it = (String)element$iv$iv;
                    boolean bl5 = false;
                    if (!StringsKt.startsWith(it, ArraysKt.last(args), true)) continue;
                    destination$iv$iv3.add(element$iv$iv);
                }
                $this$filter$iv = CollectionsKt.toList((List)destination$iv$iv3);
                if ($this$filter$iv != null) {
                    list = $this$filter$iv;
                    return list;
                }
            }
            list = CollectionsKt.emptyList();
            return list;
        }
        if (!(3 <= n2 ? n2 <= Integer.MAX_VALUE : false)) {
            list = CollectionsKt.emptyList();
            return list;
        }
        Module module = system.getModuleManager().getModule(args[0]);
        if (module != null && (value = module.getValue(args[1])) != null) {
            List<String> list3;
            List<String> list4;
            Object v1;
            Value<?> key;
            block15: {
                key = value;
                boolean bl6 = false;
                Iterable $this$firstOrNull$iv = this.actions;
                boolean $i$f$firstOrNull = false;
                for (Object element$iv : $this$firstOrNull$iv) {
                    CommandSetAction it = (CommandSetAction)element$iv;
                    boolean bl7 = false;
                    if (!it.canExecute(key)) continue;
                    v1 = element$iv;
                    break block15;
                }
                v1 = null;
            }
            CommandSetAction commandSetAction = v1;
            if (commandSetAction != null) {
                Collection $this$toTypedArray$iv = ArraysKt.drop(args, 2);
                boolean $i$f$toTypedArray = false;
                Collection thisCollection$iv = $this$toTypedArray$iv;
                list4 = commandSetAction.complete(key, thisCollection$iv.toArray(new String[0]));
            } else {
                list4 = null;
            }
            if ((list3 = list4) != null) {
                list = list3;
                return list;
            }
        }
        list = CollectionsKt.emptyList();
        return list;
    }
}

