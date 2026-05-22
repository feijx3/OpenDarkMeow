/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.network;

import java.net.InetAddress;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/event/events/network/ConnectingEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "ip", "Ljava/net/InetAddress;", "port", "", "<init>", "(Ljava/net/InetAddress;I)V", "getIp", "()Ljava/net/InetAddress;", "getPort", "()I", "DarkMeow"})
public final class ConnectingEvent
extends CancellableEvent {
    @NotNull
    private final InetAddress ip;
    private final int port;

    public ConnectingEvent(@NotNull InetAddress ip, int port) {
        Intrinsics.checkNotNullParameter(ip, "ip");
        this.ip = ip;
        this.port = port;
    }

    @NotNull
    public final InetAddress getIp() {
        return this.ip;
    }

    public final int getPort() {
        return this.port;
    }
}

