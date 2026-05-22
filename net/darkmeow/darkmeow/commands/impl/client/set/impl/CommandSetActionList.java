/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.commands.impl.client.set.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.darkmeow.darkmeow.commands.impl.client.set.CommandSetAction;
import net.darkmeow.darkmeow.commands.impl.client.set.result.CommandSetActionResult;
import net.darkmeow.darkmeow.commands.impl.client.set.result.CommandSetActionResultFailed;
import net.darkmeow.darkmeow.commands.impl.client.set.result.CommandSetActionResultSuccess;
import net.darkmeow.darkmeow.commands.impl.client.set.result.CommandSetActionResultSyntax;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0016J'\u0010\b\u001a\u00020\t2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016\u00a2\u0006\u0002\u0010\rJ-\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0011"}, d2={"Lnet/darkmeow/darkmeow/commands/impl/client/set/impl/CommandSetActionList;", "Lnet/darkmeow/darkmeow/commands/impl/client/set/CommandSetAction;", "<init>", "()V", "canExecute", "", "key", "Lnet/ccbluex/liquidbounce/value/Value;", "execute", "Lnet/darkmeow/darkmeow/commands/impl/client/set/result/CommandSetActionResult;", "args", "", "", "(Lnet/ccbluex/liquidbounce/value/Value;[Ljava/lang/String;)Lnet/darkmeow/darkmeow/commands/impl/client/set/result/CommandSetActionResult;", "complete", "", "(Lnet/ccbluex/liquidbounce/value/Value;[Ljava/lang/String;)Ljava/util/List;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nCommandSetActionList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommandSetActionList.kt\nnet/darkmeow/darkmeow/commands/impl/client/set/impl/CommandSetActionList\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,35:1\n1310#2,2:36\n3829#2:39\n4344#2,2:40\n1#3:38\n*S KotlinDebug\n*F\n+ 1 CommandSetActionList.kt\nnet/darkmeow/darkmeow/commands/impl/client/set/impl/CommandSetActionList\n*L\n20#1:36,2\n30#1:39\n30#1:40,2\n*E\n"})
public final class CommandSetActionList
extends CommandSetAction {
    @Override
    public boolean canExecute(@NotNull Value<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return key instanceof ListValue;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public CommandSetActionResult execute(@NotNull Value<?> key, @NotNull String[] args) {
        CommandSetActionResult commandSetActionResult;
        ListValue listValue;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(args, "args");
        ListValue listValue2 = listValue = key instanceof ListValue ? (ListValue)key : null;
        if (listValue != null) {
            ListValue k2 = listValue;
            boolean bl2 = false;
            String string = ArraysKt.getOrNull(args, 0);
            if (string == null) {
                commandSetActionResult = new CommandSetActionResultSyntax("<value>");
            } else {
                Object t2;
                String oldValue;
                String newValueText;
                block7: {
                    Object t3;
                    void $this$firstOrNull$iv;
                    newValueText = string;
                    oldValue = (String)k2.getValue();
                    String[] stringArray = k2.getValues();
                    boolean $i$f$firstOrNull = false;
                    int n2 = ((void)$this$firstOrNull$iv).length;
                    for (int i2 = 0; i2 < n2; ++i2) {
                        void element$iv;
                        void it = element$iv = $this$firstOrNull$iv[i2];
                        boolean bl3 = false;
                        if (!StringsKt.equals(newValueText, (String)it, true)) continue;
                        t3 = element$iv;
                        break block7;
                    }
                    t3 = t2 = null;
                }
                if (t2 != null) {
                    Object t4;
                    Object it = t4 = t2;
                    boolean bl4 = false;
                    k2.setValue(it);
                    Object it2 = t4;
                    boolean bl5 = false;
                    commandSetActionResult = new CommandSetActionResultSuccess(oldValue, (String)k2.getValue());
                } else {
                    commandSetActionResult = new CommandSetActionResultFailed(newValueText + " \u4e0d\u662f\u4e00\u4e2a\u6709\u6548\u7684\u914d\u7f6e");
                }
            }
        } else {
            commandSetActionResult = new CommandSetActionResultFailed("\u8f6c\u6362\u7c7b\u578b\u5931\u8d25");
        }
        return commandSetActionResult;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    @Override
    @NotNull
    public List<String> complete(@NotNull Value<?> key, @NotNull String[] args) {
        String[] stringArray;
        ListValue listValue;
        List<String> list;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(args, "args");
        if (args.length != 1) {
            list = CollectionsKt.emptyList();
            return list;
        }
        ListValue listValue2 = listValue = key instanceof ListValue ? (ListValue)key : null;
        if (listValue != null && (stringArray = listValue.getValues()) != null) {
            void $this$filterTo$iv$iv;
            String[] stringArray2 = stringArray;
            boolean $i$f$filter = false;
            String[] stringArray3 = stringArray2;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            int n2 = ((void)$this$filterTo$iv$iv).length;
            for (int i2 = 0; i2 < n2; ++i2) {
                void element$iv$iv;
                void it = element$iv$iv = $this$filterTo$iv$iv[i2];
                boolean bl2 = false;
                if (!StringsKt.startsWith((String)it, ArraysKt.last(args), true)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            List list2 = CollectionsKt.toList((List)destination$iv$iv);
            if (list2 != null) {
                list = list2;
                return list;
            }
        }
        list = CollectionsKt.emptyList();
        return list;
    }
}

