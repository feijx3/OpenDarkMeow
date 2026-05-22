/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.commands.impl.client.set.impl;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.TextValue;
import net.darkmeow.darkmeow.commands.impl.client.set.CommandSetAction;
import net.darkmeow.darkmeow.commands.impl.client.set.result.CommandSetActionResult;
import net.darkmeow.darkmeow.commands.impl.client.set.result.CommandSetActionResultFailed;
import net.darkmeow.darkmeow.commands.impl.client.set.result.CommandSetActionResultSuccess;
import net.darkmeow.darkmeow.commands.impl.client.set.result.CommandSetActionResultSyntax;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0016J'\u0010\b\u001a\u00020\t2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000e"}, d2={"Lnet/darkmeow/darkmeow/commands/impl/client/set/impl/CommandSetActionText;", "Lnet/darkmeow/darkmeow/commands/impl/client/set/CommandSetAction;", "<init>", "()V", "canExecute", "", "key", "Lnet/ccbluex/liquidbounce/value/Value;", "execute", "Lnet/darkmeow/darkmeow/commands/impl/client/set/result/CommandSetActionResult;", "args", "", "", "(Lnet/ccbluex/liquidbounce/value/Value;[Ljava/lang/String;)Lnet/darkmeow/darkmeow/commands/impl/client/set/result/CommandSetActionResult;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nCommandSetActionText.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommandSetActionText.kt\nnet/darkmeow/darkmeow/commands/impl/client/set/impl/CommandSetActionText\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,27:1\n1#2:28\n*E\n"})
public final class CommandSetActionText
extends CommandSetAction {
    @Override
    public boolean canExecute(@NotNull Value<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return key instanceof TextValue;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public CommandSetActionResult execute(@NotNull Value<?> key, @NotNull String[] args) {
        CommandSetActionResult commandSetActionResult;
        TextValue textValue;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(args, "args");
        TextValue textValue2 = textValue = key instanceof TextValue ? (TextValue)key : null;
        if (textValue != null) {
            void it;
            Object[] objectArray;
            Object object;
            TextValue k2 = textValue;
            boolean bl2 = false;
            String oldValue = (String)k2.getValue();
            Object[] objectArray2 = object = args;
            TextValue textValue3 = k2;
            boolean bl3 = false;
            Object object2 = objectArray = Boolean.valueOf(!(((void)it).length == 0)) != false ? object : null;
            if (objectArray == null || (object = ArraysKt.joinToString$default(objectArray, (CharSequence)" ", null, null, 0, null, null, 62, null)) == null) {
                CommandSetActionResult commandSetActionResult2;
                commandSetActionResult = commandSetActionResult2 = (CommandSetActionResult)new CommandSetActionResultSyntax("<value>");
            } else {
                textValue3.setValue(object);
                commandSetActionResult = new CommandSetActionResultSuccess(oldValue, (String)k2.getValue());
            }
        } else {
            commandSetActionResult = new CommandSetActionResultFailed("\u8f6c\u6362\u7c7b\u578b\u5931\u8d25");
        }
        return commandSetActionResult;
    }
}

