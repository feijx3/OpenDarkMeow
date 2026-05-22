/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.commands.impl.client.set.impl;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.darkmeow.darkmeow.commands.impl.client.set.CommandSetAction;
import net.darkmeow.darkmeow.commands.impl.client.set.result.CommandSetActionResult;
import net.darkmeow.darkmeow.commands.impl.client.set.result.CommandSetActionResultFailed;
import net.darkmeow.darkmeow.commands.impl.client.set.result.CommandSetActionResultSuccess;
import net.darkmeow.darkmeow.commands.impl.client.set.result.CommandSetActionResultSyntax;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0016J'\u0010\b\u001a\u00020\t2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000e"}, d2={"Lnet/darkmeow/darkmeow/commands/impl/client/set/impl/CommandSetActionInteger;", "Lnet/darkmeow/darkmeow/commands/impl/client/set/CommandSetAction;", "<init>", "()V", "canExecute", "", "key", "Lnet/ccbluex/liquidbounce/value/Value;", "execute", "Lnet/darkmeow/darkmeow/commands/impl/client/set/result/CommandSetActionResult;", "args", "", "", "(Lnet/ccbluex/liquidbounce/value/Value;[Ljava/lang/String;)Lnet/darkmeow/darkmeow/commands/impl/client/set/result/CommandSetActionResult;", "DarkMeow"})
public final class CommandSetActionInteger
extends CommandSetAction {
    @Override
    public boolean canExecute(@NotNull Value<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return key instanceof IntegerValue;
    }

    @Override
    @NotNull
    public CommandSetActionResult execute(@NotNull Value<?> key, @NotNull String[] args) {
        CommandSetActionResult commandSetActionResult;
        IntegerValue integerValue;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(args, "args");
        IntegerValue integerValue2 = integerValue = key instanceof IntegerValue ? (IntegerValue)key : null;
        if (integerValue != null) {
            IntegerValue k2 = integerValue;
            boolean bl2 = false;
            int oldValue = ((Number)k2.getValue()).intValue();
            String string = ArraysKt.getOrNull(args, 0);
            if (string == null) {
                commandSetActionResult = new CommandSetActionResultSyntax("<value>");
            } else {
                String newValue = string;
                Integer n2 = StringsKt.toIntOrNull(newValue);
                if (n2 == null) {
                    CommandSetActionResult commandSetActionResult2;
                    commandSetActionResult = commandSetActionResult2 = (CommandSetActionResult)new CommandSetActionResultFailed("\u63d0\u4f9b\u53c2\u6570\u4e0d\u662f\u4e00\u4e2a\u6709\u6548\u7684 Int \u7c7b\u578b");
                } else {
                    k2.setValue(Integer.valueOf(n2));
                    commandSetActionResult = new CommandSetActionResultSuccess(String.valueOf(oldValue), String.valueOf(((Number)k2.getValue()).intValue()));
                }
            }
        } else {
            commandSetActionResult = new CommandSetActionResultFailed("\u8f6c\u6362\u7c7b\u578b\u5931\u8d25");
        }
        return commandSetActionResult;
    }
}

