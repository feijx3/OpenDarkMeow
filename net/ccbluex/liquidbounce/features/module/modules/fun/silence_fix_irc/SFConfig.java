/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.SFConnection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\u0015\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u00c6\u0003J=\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001d"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/SFConfig;", "", "username", "", "password", "hardwareUniqueId", "blockNettyChannelInject", "Lkotlin/Function1;", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/SFConnection;", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getUsername", "()Ljava/lang/String;", "getPassword", "getHardwareUniqueId", "getBlockNettyChannelInject", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "DarkMeow"})
public final class SFConfig {
    @NotNull
    private final String username;
    @NotNull
    private final String password;
    @NotNull
    private final String hardwareUniqueId;
    @NotNull
    private final Function1<SFConnection, Unit> blockNettyChannelInject;

    public SFConfig(@NotNull String username, @NotNull String password, @NotNull String hardwareUniqueId, @NotNull Function1<? super SFConnection, Unit> blockNettyChannelInject) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(hardwareUniqueId, "hardwareUniqueId");
        Intrinsics.checkNotNullParameter(blockNettyChannelInject, "blockNettyChannelInject");
        this.username = username;
        this.password = password;
        this.hardwareUniqueId = hardwareUniqueId;
        this.blockNettyChannelInject = blockNettyChannelInject;
    }

    @NotNull
    public final String getUsername() {
        return this.username;
    }

    @NotNull
    public final String getPassword() {
        return this.password;
    }

    @NotNull
    public final String getHardwareUniqueId() {
        return this.hardwareUniqueId;
    }

    @NotNull
    public final Function1<SFConnection, Unit> getBlockNettyChannelInject() {
        return this.blockNettyChannelInject;
    }

    @NotNull
    public final String component1() {
        return this.username;
    }

    @NotNull
    public final String component2() {
        return this.password;
    }

    @NotNull
    public final String component3() {
        return this.hardwareUniqueId;
    }

    @NotNull
    public final Function1<SFConnection, Unit> component4() {
        return this.blockNettyChannelInject;
    }

    @NotNull
    public final SFConfig copy(@NotNull String username, @NotNull String password, @NotNull String hardwareUniqueId, @NotNull Function1<? super SFConnection, Unit> blockNettyChannelInject) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(hardwareUniqueId, "hardwareUniqueId");
        Intrinsics.checkNotNullParameter(blockNettyChannelInject, "blockNettyChannelInject");
        return new SFConfig(username, password, hardwareUniqueId, blockNettyChannelInject);
    }

    public static /* synthetic */ SFConfig copy$default(SFConfig sFConfig, String string, String string2, String string3, Function1 function1, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string = sFConfig.username;
        }
        if ((n2 & 2) != 0) {
            string2 = sFConfig.password;
        }
        if ((n2 & 4) != 0) {
            string3 = sFConfig.hardwareUniqueId;
        }
        if ((n2 & 8) != 0) {
            function1 = sFConfig.blockNettyChannelInject;
        }
        return sFConfig.copy(string, string2, string3, function1);
    }

    @NotNull
    public String toString() {
        return "SFConfig(username=" + this.username + ", password=" + this.password + ", hardwareUniqueId=" + this.hardwareUniqueId + ", blockNettyChannelInject=" + this.blockNettyChannelInject + ')';
    }

    public int hashCode() {
        int result = this.username.hashCode();
        result = result * 31 + this.password.hashCode();
        result = result * 31 + this.hardwareUniqueId.hashCode();
        result = result * 31 + this.blockNettyChannelInject.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SFConfig)) {
            return false;
        }
        SFConfig sFConfig = (SFConfig)other;
        if (!Intrinsics.areEqual(this.username, sFConfig.username)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.password, sFConfig.password)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.hardwareUniqueId, sFConfig.hardwareUniqueId)) {
            return false;
        }
        return Intrinsics.areEqual(this.blockNettyChannelInject, sFConfig.blockNettyChannelInject);
    }
}

