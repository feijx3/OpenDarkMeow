/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.handler.network.proxy;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/handler/network/proxy/ProxyType;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "HTTP", "SOCKS5", "SOCKS4", "DarkMeow"})
public final class ProxyType
extends Enum<ProxyType> {
    @JvmField
    public final int id;
    public static final /* enum */ ProxyType HTTP = new ProxyType(0);
    public static final /* enum */ ProxyType SOCKS5 = new ProxyType(1);
    public static final /* enum */ ProxyType SOCKS4 = new ProxyType(2);
    private static final /* synthetic */ ProxyType[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private ProxyType(int id) {
        this.id = id;
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

    static {
        $VALUES = proxyTypeArray = new ProxyType[]{ProxyType.HTTP, ProxyType.SOCKS5, ProxyType.SOCKS4};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

