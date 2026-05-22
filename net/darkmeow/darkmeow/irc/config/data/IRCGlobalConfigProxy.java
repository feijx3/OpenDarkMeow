/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.darkmeow.irc.config.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.irc.client.options.proxy.IRCOptionsProxy;
import net.darkmeow.irc.client.options.proxy.IRCOptionsProxyHttp;
import net.darkmeow.irc.client.options.proxy.IRCOptionsProxySocks4;
import net.darkmeow.irc.client.options.proxy.IRCOptionsProxySocks5;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001'B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J?\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010%\u001a\u00020\u0007H\u00d6\u0001J\t\u0010&\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013\u00a8\u0006("}, d2={"Lnet/darkmeow/darkmeow/irc/config/data/IRCGlobalConfigProxy;", "", "type", "Lnet/darkmeow/darkmeow/irc/config/data/IRCGlobalConfigProxy$ProxyType;", "host", "", "port", "", "username", "password", "<init>", "(Lnet/darkmeow/darkmeow/irc/config/data/IRCGlobalConfigProxy$ProxyType;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getType", "()Lnet/darkmeow/darkmeow/irc/config/data/IRCGlobalConfigProxy$ProxyType;", "setType", "(Lnet/darkmeow/darkmeow/irc/config/data/IRCGlobalConfigProxy$ProxyType;)V", "getHost", "()Ljava/lang/String;", "setHost", "(Ljava/lang/String;)V", "getPort", "()I", "setPort", "(I)V", "getUsername", "setUsername", "getPassword", "setPassword", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "ProxyType", "DarkMeow"})
public final class IRCGlobalConfigProxy {
    @NotNull
    private ProxyType type;
    @NotNull
    private String host;
    private int port;
    @Nullable
    private String username;
    @Nullable
    private String password;

    public IRCGlobalConfigProxy(@NotNull ProxyType type, @NotNull String host, int port, @Nullable String username, @Nullable String password) {
        Intrinsics.checkNotNullParameter((Object)type, "type");
        Intrinsics.checkNotNullParameter(host, "host");
        this.type = type;
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public /* synthetic */ IRCGlobalConfigProxy(ProxyType proxyType, String string, int n2, String string2, String string3, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 1) != 0) {
            proxyType = ProxyType.SOCKS5;
        }
        if ((n3 & 2) != 0) {
            string = "localhost";
        }
        if ((n3 & 4) != 0) {
            n2 = 8080;
        }
        if ((n3 & 8) != 0) {
            string2 = null;
        }
        if ((n3 & 0x10) != 0) {
            string3 = null;
        }
        this(proxyType, string, n2, string2, string3);
    }

    @NotNull
    public final ProxyType getType() {
        return this.type;
    }

    public final void setType(@NotNull ProxyType proxyType) {
        Intrinsics.checkNotNullParameter((Object)proxyType, "<set-?>");
        this.type = proxyType;
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

    @Nullable
    public final String getUsername() {
        return this.username;
    }

    public final void setUsername(@Nullable String string) {
        this.username = string;
    }

    @Nullable
    public final String getPassword() {
        return this.password;
    }

    public final void setPassword(@Nullable String string) {
        this.password = string;
    }

    @NotNull
    public final ProxyType component1() {
        return this.type;
    }

    @NotNull
    public final String component2() {
        return this.host;
    }

    public final int component3() {
        return this.port;
    }

    @Nullable
    public final String component4() {
        return this.username;
    }

    @Nullable
    public final String component5() {
        return this.password;
    }

    @NotNull
    public final IRCGlobalConfigProxy copy(@NotNull ProxyType type, @NotNull String host, int port, @Nullable String username, @Nullable String password) {
        Intrinsics.checkNotNullParameter((Object)type, "type");
        Intrinsics.checkNotNullParameter(host, "host");
        return new IRCGlobalConfigProxy(type, host, port, username, password);
    }

    public static /* synthetic */ IRCGlobalConfigProxy copy$default(IRCGlobalConfigProxy iRCGlobalConfigProxy, ProxyType proxyType, String string, int n2, String string2, String string3, int n3, Object object) {
        if ((n3 & 1) != 0) {
            proxyType = iRCGlobalConfigProxy.type;
        }
        if ((n3 & 2) != 0) {
            string = iRCGlobalConfigProxy.host;
        }
        if ((n3 & 4) != 0) {
            n2 = iRCGlobalConfigProxy.port;
        }
        if ((n3 & 8) != 0) {
            string2 = iRCGlobalConfigProxy.username;
        }
        if ((n3 & 0x10) != 0) {
            string3 = iRCGlobalConfigProxy.password;
        }
        return iRCGlobalConfigProxy.copy(proxyType, string, n2, string2, string3);
    }

    @NotNull
    public String toString() {
        return "IRCGlobalConfigProxy(type=" + (Object)((Object)this.type) + ", host=" + this.host + ", port=" + this.port + ", username=" + this.username + ", password=" + this.password + ')';
    }

    public int hashCode() {
        int result = this.type.hashCode();
        result = result * 31 + this.host.hashCode();
        result = result * 31 + Integer.hashCode(this.port);
        result = result * 31 + (this.username == null ? 0 : this.username.hashCode());
        result = result * 31 + (this.password == null ? 0 : this.password.hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IRCGlobalConfigProxy)) {
            return false;
        }
        IRCGlobalConfigProxy iRCGlobalConfigProxy = (IRCGlobalConfigProxy)other;
        if (this.type != iRCGlobalConfigProxy.type) {
            return false;
        }
        if (!Intrinsics.areEqual(this.host, iRCGlobalConfigProxy.host)) {
            return false;
        }
        if (this.port != iRCGlobalConfigProxy.port) {
            return false;
        }
        if (!Intrinsics.areEqual(this.username, iRCGlobalConfigProxy.username)) {
            return false;
        }
        return Intrinsics.areEqual(this.password, iRCGlobalConfigProxy.password);
    }

    public IRCGlobalConfigProxy() {
        this(null, null, 0, null, null, 31, null);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u007f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012d\u0010\u0005\u001a`\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u0006\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013Ro\u0010\u0005\u001a`\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019\u00a8\u0006\u001a"}, d2={"Lnet/darkmeow/darkmeow/irc/config/data/IRCGlobalConfigProxy$ProxyType;", "", "allowUsername", "", "allowPassword", "exec", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "host", "", "port", "username", "password", "Lnet/darkmeow/irc/client/options/proxy/IRCOptionsProxy;", "<init>", "(Ljava/lang/String;IZZLkotlin/jvm/functions/Function4;)V", "getAllowUsername", "()Z", "getAllowPassword", "getExec", "()Lkotlin/jvm/functions/Function4;", "SOCKS5", "SOCKS4", "HTTP", "DarkMeow"})
    public static final class ProxyType
    extends Enum<ProxyType> {
        private final boolean allowUsername;
        private final boolean allowPassword;
        @NotNull
        private final Function4<String, Integer, String, String, IRCOptionsProxy> exec;
        public static final /* enum */ ProxyType SOCKS5 = new ProxyType(true, true, ProxyType::_init_$lambda$0);
        public static final /* enum */ ProxyType SOCKS4 = new ProxyType(true, false, ProxyType::_init_$lambda$1);
        public static final /* enum */ ProxyType HTTP = new ProxyType(false, false, ProxyType::_init_$lambda$2);
        private static final /* synthetic */ ProxyType[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        private ProxyType(boolean allowUsername, boolean allowPassword, Function4<? super String, ? super Integer, ? super String, ? super String, ? extends IRCOptionsProxy> exec) {
            this.allowUsername = allowUsername;
            this.allowPassword = allowPassword;
            this.exec = exec;
        }

        public final boolean getAllowUsername() {
            return this.allowUsername;
        }

        public final boolean getAllowPassword() {
            return this.allowPassword;
        }

        @NotNull
        public final Function4<String, Integer, String, String, IRCOptionsProxy> getExec() {
            return this.exec;
        }

        public static ProxyType[] values() {
            return (ProxyType[])$VALUES.clone();
        }

        public static ProxyType valueOf(String value) {
            return Enum.valueOf(ProxyType.class, value);
        }

        @NotNull
        public static EnumEntries<ProxyType> getEntries() {
            return $ENTRIES;
        }

        private static final IRCOptionsProxy _init_$lambda$0(String host, int port, String username, String password) {
            Intrinsics.checkNotNullParameter(host, "host");
            return new IRCOptionsProxySocks5(host, port, username, password);
        }

        private static final IRCOptionsProxy _init_$lambda$1(String host, int port, String username, String string) {
            Intrinsics.checkNotNullParameter(host, "host");
            return new IRCOptionsProxySocks4(host, port, username);
        }

        private static final IRCOptionsProxy _init_$lambda$2(String host, int port, String string, String string2) {
            Intrinsics.checkNotNullParameter(host, "host");
            return new IRCOptionsProxyHttp(host, port);
        }

        static {
            $VALUES = proxyTypeArray = new ProxyType[]{ProxyType.SOCKS5, ProxyType.SOCKS4, ProxyType.HTTP};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

