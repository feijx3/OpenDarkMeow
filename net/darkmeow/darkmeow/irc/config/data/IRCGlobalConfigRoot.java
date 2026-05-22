/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.darkmeow.irc.config.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.darkmeow.irc.config.data.IRCGlobalConfigProxy;
import net.darkmeow.darkmeow.irc.config.data.IRCGlobalConfigRedirectServer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0019\u001a\u00020\u001aJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\bH\u00c6\u0003J5\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u00c6\u0001J\u0013\u0010 \u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020#H\u00d6\u0001J\t\u0010$\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006%"}, d2={"Lnet/darkmeow/darkmeow/irc/config/data/IRCGlobalConfigRoot;", "", "user", "", "password", "proxy", "Lnet/darkmeow/darkmeow/irc/config/data/IRCGlobalConfigProxy;", "redirectServer", "Lnet/darkmeow/darkmeow/irc/config/data/IRCGlobalConfigRedirectServer;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lnet/darkmeow/darkmeow/irc/config/data/IRCGlobalConfigProxy;Lnet/darkmeow/darkmeow/irc/config/data/IRCGlobalConfigRedirectServer;)V", "getUser", "()Ljava/lang/String;", "setUser", "(Ljava/lang/String;)V", "getPassword", "setPassword", "getProxy", "()Lnet/darkmeow/darkmeow/irc/config/data/IRCGlobalConfigProxy;", "setProxy", "(Lnet/darkmeow/darkmeow/irc/config/data/IRCGlobalConfigProxy;)V", "getRedirectServer", "()Lnet/darkmeow/darkmeow/irc/config/data/IRCGlobalConfigRedirectServer;", "setRedirectServer", "(Lnet/darkmeow/darkmeow/irc/config/data/IRCGlobalConfigRedirectServer;)V", "isToken", "", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "DarkMeow"})
public final class IRCGlobalConfigRoot {
    @NotNull
    private String user;
    @NotNull
    private String password;
    @Nullable
    private IRCGlobalConfigProxy proxy;
    @Nullable
    private IRCGlobalConfigRedirectServer redirectServer;

    public IRCGlobalConfigRoot(@NotNull String user, @NotNull String password, @Nullable IRCGlobalConfigProxy proxy, @Nullable IRCGlobalConfigRedirectServer redirectServer) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(password, "password");
        this.user = user;
        this.password = password;
        this.proxy = proxy;
        this.redirectServer = redirectServer;
    }

    public /* synthetic */ IRCGlobalConfigRoot(String string, String string2, IRCGlobalConfigProxy iRCGlobalConfigProxy, IRCGlobalConfigRedirectServer iRCGlobalConfigRedirectServer, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            string = "";
        }
        if ((n2 & 2) != 0) {
            string2 = "";
        }
        if ((n2 & 4) != 0) {
            iRCGlobalConfigProxy = null;
        }
        if ((n2 & 8) != 0) {
            iRCGlobalConfigRedirectServer = null;
        }
        this(string, string2, iRCGlobalConfigProxy, iRCGlobalConfigRedirectServer);
    }

    @NotNull
    public final String getUser() {
        return this.user;
    }

    public final void setUser(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<set-?>");
        this.user = string;
    }

    @NotNull
    public final String getPassword() {
        return this.password;
    }

    public final void setPassword(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<set-?>");
        this.password = string;
    }

    @Nullable
    public final IRCGlobalConfigProxy getProxy() {
        return this.proxy;
    }

    public final void setProxy(@Nullable IRCGlobalConfigProxy iRCGlobalConfigProxy) {
        this.proxy = iRCGlobalConfigProxy;
    }

    @Nullable
    public final IRCGlobalConfigRedirectServer getRedirectServer() {
        return this.redirectServer;
    }

    public final void setRedirectServer(@Nullable IRCGlobalConfigRedirectServer iRCGlobalConfigRedirectServer) {
        this.redirectServer = iRCGlobalConfigRedirectServer;
    }

    public final boolean isToken() {
        return ((CharSequence)this.user).length() > 0 && this.password.length() == 128;
    }

    @NotNull
    public final String component1() {
        return this.user;
    }

    @NotNull
    public final String component2() {
        return this.password;
    }

    @Nullable
    public final IRCGlobalConfigProxy component3() {
        return this.proxy;
    }

    @Nullable
    public final IRCGlobalConfigRedirectServer component4() {
        return this.redirectServer;
    }

    @NotNull
    public final IRCGlobalConfigRoot copy(@NotNull String user, @NotNull String password, @Nullable IRCGlobalConfigProxy proxy, @Nullable IRCGlobalConfigRedirectServer redirectServer) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(password, "password");
        return new IRCGlobalConfigRoot(user, password, proxy, redirectServer);
    }

    public static /* synthetic */ IRCGlobalConfigRoot copy$default(IRCGlobalConfigRoot iRCGlobalConfigRoot, String string, String string2, IRCGlobalConfigProxy iRCGlobalConfigProxy, IRCGlobalConfigRedirectServer iRCGlobalConfigRedirectServer, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string = iRCGlobalConfigRoot.user;
        }
        if ((n2 & 2) != 0) {
            string2 = iRCGlobalConfigRoot.password;
        }
        if ((n2 & 4) != 0) {
            iRCGlobalConfigProxy = iRCGlobalConfigRoot.proxy;
        }
        if ((n2 & 8) != 0) {
            iRCGlobalConfigRedirectServer = iRCGlobalConfigRoot.redirectServer;
        }
        return iRCGlobalConfigRoot.copy(string, string2, iRCGlobalConfigProxy, iRCGlobalConfigRedirectServer);
    }

    @NotNull
    public String toString() {
        return "IRCGlobalConfigRoot(user=" + this.user + ", password=" + this.password + ", proxy=" + this.proxy + ", redirectServer=" + this.redirectServer + ')';
    }

    public int hashCode() {
        int result = this.user.hashCode();
        result = result * 31 + this.password.hashCode();
        result = result * 31 + (this.proxy == null ? 0 : this.proxy.hashCode());
        result = result * 31 + (this.redirectServer == null ? 0 : this.redirectServer.hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IRCGlobalConfigRoot)) {
            return false;
        }
        IRCGlobalConfigRoot iRCGlobalConfigRoot = (IRCGlobalConfigRoot)other;
        if (!Intrinsics.areEqual(this.user, iRCGlobalConfigRoot.user)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.password, iRCGlobalConfigRoot.password)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.proxy, iRCGlobalConfigRoot.proxy)) {
            return false;
        }
        return Intrinsics.areEqual(this.redirectServer, iRCGlobalConfigRoot.redirectServer);
    }

    public IRCGlobalConfigRoot() {
        this(null, null, null, null, 15, null);
    }
}

