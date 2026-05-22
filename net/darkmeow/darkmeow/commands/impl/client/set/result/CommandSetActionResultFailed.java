/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.darkmeow.commands.impl.client.set.result;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.darkmeow.commands.impl.client.set.result.CommandSetActionResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0011"}, d2={"Lnet/darkmeow/darkmeow/commands/impl/client/set/result/CommandSetActionResultFailed;", "Lnet/darkmeow/darkmeow/commands/impl/client/set/result/CommandSetActionResult;", "text", "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "DarkMeow"})
public final class CommandSetActionResultFailed
implements CommandSetActionResult {
    @NotNull
    private final String text;

    public CommandSetActionResultFailed(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @NotNull
    public final String component1() {
        return this.text;
    }

    @NotNull
    public final CommandSetActionResultFailed copy(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new CommandSetActionResultFailed(text);
    }

    public static /* synthetic */ CommandSetActionResultFailed copy$default(CommandSetActionResultFailed commandSetActionResultFailed, String string, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string = commandSetActionResultFailed.text;
        }
        return commandSetActionResultFailed.copy(string);
    }

    @NotNull
    public String toString() {
        return "CommandSetActionResultFailed(text=" + this.text + ')';
    }

    public int hashCode() {
        return this.text.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommandSetActionResultFailed)) {
            return false;
        }
        CommandSetActionResultFailed commandSetActionResultFailed = (CommandSetActionResultFailed)other;
        return Intrinsics.areEqual(this.text, commandSetActionResultFailed.text);
    }
}

