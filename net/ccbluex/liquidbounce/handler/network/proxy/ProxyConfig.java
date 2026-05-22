/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.handler.network.proxy;

import java.net.InetSocketAddress;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.handler.network.proxy.ProxyType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bJ\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lnet/ccbluex/liquidbounce/handler/network/proxy/ProxyConfig;", "", "address", "", "port", "", "type", "Lnet/ccbluex/liquidbounce/handler/network/proxy/ProxyType;", "<init>", "(Ljava/lang/String;ILnet/ccbluex/liquidbounce/handler/network/proxy/ProxyType;)V", "getAddress", "Ljava/net/InetSocketAddress;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "DarkMeow"})
public final class ProxyConfig {
    @JvmField
    @NotNull
    public final String address;
    @JvmField
    public final int port;
    @JvmField
    @NotNull
    public final ProxyType type;

    public ProxyConfig(@NotNull String address, int port, @NotNull ProxyType type) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter((Object)type, "type");
        this.address = address;
        this.port = port;
        this.type = type;
    }

    public /* synthetic */ ProxyConfig(String string, int n2, ProxyType proxyType, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 1) != 0) {
            string = "127.0.0.1";
        }
        if ((n3 & 2) != 0) {
            n2 = 10808;
        }
        if ((n3 & 4) != 0) {
            proxyType = ProxyType.HTTP;
        }
        this(string, n2, proxyType);
    }

    @NotNull
    public final InetSocketAddress getAddress() {
        return new InetSocketAddress(this.address, this.port);
    }

    @NotNull
    public final String component1() {
        return this.address;
    }

    public final int component2() {
        return this.port;
    }

    @NotNull
    public final ProxyType component3() {
        return this.type;
    }

    @NotNull
    public final ProxyConfig copy(@NotNull String address, int port, @NotNull ProxyType type) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter((Object)type, "type");
        return new ProxyConfig(address, port, type);
    }

    public static /* synthetic */ ProxyConfig copy$default(ProxyConfig proxyConfig, String string, int n2, ProxyType proxyType, int n3, Object object) {
        if ((n3 & 1) != 0) {
            string = proxyConfig.address;
        }
        if ((n3 & 2) != 0) {
            n2 = proxyConfig.port;
        }
        if ((n3 & 4) != 0) {
            proxyType = proxyConfig.type;
        }
        return proxyConfig.copy(string, n2, proxyType);
    }

    @NotNull
    public String toString() {
        return "ProxyConfig(address=" + this.address + ", port=" + this.port + ", type=" + (Object)((Object)this.type) + ')';
    }

    public int hashCode() {
        int result = this.address.hashCode();
        result = result * 31 + Integer.hashCode(this.port);
        result = result * 31 + this.type.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProxyConfig)) {
            return false;
        }
        ProxyConfig proxyConfig = (ProxyConfig)other;
        if (!Intrinsics.areEqual(this.address, proxyConfig.address)) {
            return false;
        }
        if (this.port != proxyConfig.port) {
            return false;
        }
        return this.type == proxyConfig.type;
    }

    public ProxyConfig() {
        this(null, 0, null, 7, null);
    }
}

