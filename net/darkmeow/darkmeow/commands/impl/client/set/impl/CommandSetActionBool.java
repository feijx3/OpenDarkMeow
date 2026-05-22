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
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.darkmeow.darkmeow.commands.impl.client.set.CommandSetAction;
import net.darkmeow.darkmeow.commands.impl.client.set.result.CommandSetActionResult;
import net.darkmeow.darkmeow.commands.impl.client.set.result.CommandSetActionResultFailed;
import net.darkmeow.darkmeow.commands.impl.client.set.result.CommandSetActionResultSuccess;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0016J'\u0010\b\u001a\u00020\t2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016\u00a2\u0006\u0002\u0010\rJ-\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0011"}, d2={"Lnet/darkmeow/darkmeow/commands/impl/client/set/impl/CommandSetActionBool;", "Lnet/darkmeow/darkmeow/commands/impl/client/set/CommandSetAction;", "<init>", "()V", "canExecute", "", "key", "Lnet/ccbluex/liquidbounce/value/Value;", "execute", "Lnet/darkmeow/darkmeow/commands/impl/client/set/result/CommandSetActionResult;", "args", "", "", "(Lnet/ccbluex/liquidbounce/value/Value;[Ljava/lang/String;)Lnet/darkmeow/darkmeow/commands/impl/client/set/result/CommandSetActionResult;", "complete", "", "(Lnet/ccbluex/liquidbounce/value/Value;[Ljava/lang/String;)Ljava/util/List;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nCommandSetActionBool.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommandSetActionBool.kt\nnet/darkmeow/darkmeow/commands/impl/client/set/impl/CommandSetActionBool\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,39:1\n3829#2:40\n4344#2,2:41\n*S KotlinDebug\n*F\n+ 1 CommandSetActionBool.kt\nnet/darkmeow/darkmeow/commands/impl/client/set/impl/CommandSetActionBool\n*L\n34#1:40\n34#1:41,2\n*E\n"})
public final class CommandSetActionBool
extends CommandSetAction {
    @Override
    public boolean canExecute(@NotNull Value<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return key instanceof BoolValue;
    }

    @Override
    @NotNull
    public CommandSetActionResult execute(@NotNull Value<?> key, @NotNull String[] args) {
        CommandSetActionResult commandSetActionResult;
        BoolValue boolValue;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(args, "args");
        BoolValue boolValue2 = boolValue = key instanceof BoolValue ? (BoolValue)key : null;
        if (boolValue != null) {
            BoolValue k2 = boolValue;
            boolean bl2 = false;
            boolean oldValue = (Boolean)k2.getValue();
            k2.setValue(args.length == 0 ? !((Boolean)k2.getValue()).booleanValue() : (StringsKt.startsWith$default(args[0], "t", false, 2, null) ? true : (StringsKt.startsWith$default(args[0], "f", false, 2, null) ? false : (Boolean)k2.getValue() == false)));
            commandSetActionResult = new CommandSetActionResultSuccess(String.valueOf(oldValue), String.valueOf((Boolean)k2.getValue()));
        } else {
            commandSetActionResult = new CommandSetActionResultFailed("\u8f6c\u6362\u7c7b\u578b\u5931\u8d25");
        }
        return commandSetActionResult;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<String> complete(@NotNull Value<?> key, @NotNull String[] args) {
        List<String> list;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(args, "args");
        if (args.length == 1) {
            void $this$filterTo$iv$iv;
            String[] stringArray = new String[]{"true", "false"};
            String[] $this$filter$iv = stringArray;
            boolean $i$f$filter = false;
            String[] stringArray2 = $this$filter$iv;
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
            list = CollectionsKt.toList((List)destination$iv$iv);
        } else {
            list = CollectionsKt.emptyList();
        }
        return list;
    }
}

