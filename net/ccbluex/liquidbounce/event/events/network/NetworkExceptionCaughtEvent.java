/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelHandlerContext
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.network;

import io.netty.channel.ChannelHandlerContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/event/events/network/NetworkExceptionCaughtEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "channelHandlerContext", "Lio/netty/channel/ChannelHandlerContext;", "e", "", "<init>", "(Lio/netty/channel/ChannelHandlerContext;Ljava/lang/Throwable;)V", "getChannelHandlerContext", "()Lio/netty/channel/ChannelHandlerContext;", "getE", "()Ljava/lang/Throwable;", "DarkMeow"})
public final class NetworkExceptionCaughtEvent
extends CancellableEvent {
    @NotNull
    private final ChannelHandlerContext channelHandlerContext;
    @NotNull
    private final Throwable e;

    public NetworkExceptionCaughtEvent(@NotNull ChannelHandlerContext channelHandlerContext, @NotNull Throwable e2) {
        Intrinsics.checkNotNullParameter(channelHandlerContext, "channelHandlerContext");
        Intrinsics.checkNotNullParameter(e2, "e");
        this.channelHandlerContext = channelHandlerContext;
        this.e = e2;
    }

    @NotNull
    public final ChannelHandlerContext getChannelHandlerContext() {
        return this.channelHandlerContext;
    }

    @NotNull
    public final Throwable getE() {
        return this.e;
    }
}

