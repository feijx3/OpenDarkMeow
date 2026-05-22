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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0018"}, d2={"Lnet/darkmeow/darkmeow/irc/config/data/IRCGlobalConfigRedirectServer;", "", "host", "", "port", "", "<init>", "(Ljava/lang/String;I)V", "getHost", "()Ljava/lang/String;", "setHost", "(Ljava/lang/String;)V", "getPort", "()I", "setPort", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "DarkMeow"})
public final class IRCGlobalConfigRedirectServer {
    @NotNull
    private String host;
    private int port;

    public IRCGlobalConfigRedirectServer(@NotNull String host, int port) {
        Intrinsics.checkNotNullParameter(host, "host");
        this.host = host;
        this.port = port;
    }

    public /* synthetic */ IRCGlobalConfigRedirectServer(String string, int n2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 1) != 0) {
            string = "localhost";
        }
        if ((n3 & 2) != 0) {
            n2 = 45020;
        }
        this(string, n2);
    }

    @NotNull
    public final String getHost() {
        return this.host;
    }

    public final void setHost(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<set-?>");
        this.host = string;
    }

    public final int getPort() {
        return this.port;
    }

    public final void setPort(int n2) {
        this.port = n2;
    }

    @NotNull
    public final String component1() {
        return this.host;
    }

    public final int component2() {
        return this.port;
    }

    @NotNull
    public final IRCGlobalConfigRedirectServer copy(@NotNull String host, int port) {
        Intrinsics.checkNotNullParameter(host, "host");
        return new IRCGlobalConfigRedirectServer(host, port);
    }

    public static /* synthetic */ IRCGlobalConfigRedirectServer copy$default(IRCGlobalConfigRedirectServer iRCGlobalConfigRedirectServer, String string, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            string = iRCGlobalConfigRedirectServer.host;
        }
        if ((n3 & 2) != 0) {
            n2 = iRCGlobalConfigRedirectServer.port;
        }
        return iRCGlobalConfigRedirectServer.copy(string, n2);
    }

    @NotNull
    public String toString() {
        return "IRCGlobalConfigRedirectServer(host=" + this.host + ", port=" + this.port + ')';
    }

    public int hashCode() {
        int result = this.host.hashCode();
        result = result * 31 + Integer.hashCode(this.port);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IRCGlobalConfigRedirectServer)) {
            return false;
        }
        IRCGlobalConfigRedirectServer iRCGlobalConfigRedirectServer = (IRCGlobalConfigRedirectServer)other;
        if (!Intrinsics.areEqual(this.host, iRCGlobalConfigRedirectServer.host)) {
            return false;
        }
        return this.port == iRCGlobalConfigRedirectServer.port;
    }

    public IRCGlobalConfigRedirectServer() {
        this(null, 0, 3, null);
    }
}

