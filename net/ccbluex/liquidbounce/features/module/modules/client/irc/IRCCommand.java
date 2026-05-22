/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.client.irc;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.client.IRC;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B%\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016H&J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/irc/IRCCommand;", "", "root", "", "", "onlyLogin", "", "<init>", "([Ljava/lang/String;Z)V", "getOnlyLogin", "()Z", "roots", "", "instance", "Lnet/ccbluex/liquidbounce/features/module/modules/client/IRC;", "getInstance", "()Lnet/ccbluex/liquidbounce/features/module/modules/client/IRC;", "setInstance", "(Lnet/ccbluex/liquidbounce/features/module/modules/client/IRC;)V", "execute", "", "args", "", "complete", "DarkMeow"})
public abstract class IRCCommand {
    private final boolean onlyLogin;
    @JvmField
    @NotNull
    public final Set<String> roots;
    public IRC instance;

    public IRCCommand(@NotNull String[] root, boolean onlyLogin) {
        Intrinsics.checkNotNullParameter(root, "root");
        this.onlyLogin = onlyLogin;
        this.roots = ArraysKt.toMutableSet(root);
    }

    public /* synthetic */ IRCCommand(String[] stringArray, boolean bl2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            bl2 = true;
        }
        this(stringArray, bl2);
    }

    public final boolean getOnlyLogin() {
        return this.onlyLogin;
    }

    @NotNull
    public final IRC getInstance() {
        IRC iRC = this.instance;
        if (iRC != null) {
            return iRC;
        }
        Intrinsics.throwUninitializedPropertyAccessException("instance");
        return null;
    }

    public final void setInstance(@NotNull IRC iRC) {
        Intrinsics.checkNotNullParameter(iRC, "<set-?>");
        this.instance = iRC;
    }

    public abstract void execute(@NotNull List<String> var1);

    @NotNull
    public List<String> complete(@NotNull List<String> args) {
        Intrinsics.checkNotNullParameter(args, "args");
        return CollectionsKt.emptyList();
    }
}

