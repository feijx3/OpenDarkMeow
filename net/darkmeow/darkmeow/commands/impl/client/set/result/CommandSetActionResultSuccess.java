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

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b\u00a8\u0006\u0014"}, d2={"Lnet/darkmeow/darkmeow/commands/impl/client/set/result/CommandSetActionResultSuccess;", "Lnet/darkmeow/darkmeow/commands/impl/client/set/result/CommandSetActionResult;", "oldValue", "", "newValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getOldValue", "()Ljava/lang/String;", "getNewValue", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "DarkMeow"})
public final class CommandSetActionResultSuccess
implements CommandSetActionResult {
    @NotNull
    private final String oldValue;
    @NotNull
    private final String newValue;

    public CommandSetActionResultSuccess(@NotNull String oldValue, @NotNull String newValue) {
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    @NotNull
    public final String getOldValue() {
        return this.oldValue;
    }

    @NotNull
    public final String getNewValue() {
        return this.newValue;
    }

    @NotNull
    public final String component1() {
        return this.oldValue;
    }

    @NotNull
    public final String component2() {
        return this.newValue;
    }

    @NotNull
    public final CommandSetActionResultSuccess copy(@NotNull String oldValue, @NotNull String newValue) {
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        return new CommandSetActionResultSuccess(oldValue, newValue);
    }

    public static /* synthetic */ CommandSetActionResultSuccess copy$default(CommandSetActionResultSuccess commandSetActionResultSuccess, String string, String string2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string = commandSetActionResultSuccess.oldValue;
        }
        if ((n2 & 2) != 0) {
            string2 = commandSetActionResultSuccess.newValue;
        }
        return commandSetActionResultSuccess.copy(string, string2);
    }

    @NotNull
    public String toString() {
        return "CommandSetActionResultSuccess(oldValue=" + this.oldValue + ", newValue=" + this.newValue + ')';
    }

    public int hashCode() {
        int result = this.oldValue.hashCode();
        result = result * 31 + this.newValue.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommandSetActionResultSuccess)) {
            return false;
        }
        CommandSetActionResultSuccess commandSetActionResultSuccess = (CommandSetActionResultSuccess)other;
        if (!Intrinsics.areEqual(this.oldValue, commandSetActionResultSuccess.oldValue)) {
            return false;
        }
        return Intrinsics.areEqual(this.newValue, commandSetActionResultSuccess.newValue);
    }
}

