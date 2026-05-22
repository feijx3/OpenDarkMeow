/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  gw
 *  ht
 *  hu
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.util.concurrent.Future
 *  io.netty.util.concurrent.GenericFutureListener
 */
package baritone.launch.mixins;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.event.events.PacketEvent;
import baritone.api.event.events.type.EventState;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={gw.class})
public class MixinNetworkManager {
    @Shadow
    private Channel k;
    @Shadow
    @Final
    private hu h;

    @Inject(method={"dispatchPacket"}, at={@At(value="HEAD")})
    private void preDispatchPacket(ht<?> ht2, GenericFutureListener<? extends Future<? super Void>>[] object, CallbackInfo object22) {
        if (this.h != hu.b) {
            return;
        }
        for (IBaritone iBaritone : BaritoneAPI.getProvider().getAllBaritones()) {
            if (iBaritone.getPlayerContext().player() == null || iBaritone.getPlayerContext().player().d.a() != (gw)this) continue;
            iBaritone.getGameEventHandler().onSendPacket(new PacketEvent((gw)this, EventState.PRE, ht2));
        }
    }

    @Inject(method={"dispatchPacket"}, at={@At(value="RETURN")})
    private void postDispatchPacket(ht<?> ht2, GenericFutureListener<? extends Future<? super Void>>[] object, CallbackInfo object22) {
        if (this.h != hu.b) {
            return;
        }
        for (IBaritone iBaritone : BaritoneAPI.getProvider().getAllBaritones()) {
            if (iBaritone.getPlayerContext().player() == null || iBaritone.getPlayerContext().player().d.a() != (gw)this) continue;
            iBaritone.getGameEventHandler().onSendPacket(new PacketEvent((gw)this, EventState.POST, ht2));
        }
    }

    @Inject(method={"channelRead0"}, at={@At(value="INVOKE", target="net/minecraft/network/Packet.processPacket(Lnet/minecraft/network/INetHandler;)V")})
    private void preProcessPacket(ChannelHandlerContext object, ht<?> ht2, CallbackInfo object22) {
        if (this.h != hu.b) {
            return;
        }
        for (IBaritone iBaritone : BaritoneAPI.getProvider().getAllBaritones()) {
            if (iBaritone.getPlayerContext().player() == null || iBaritone.getPlayerContext().player().d.a() != (gw)this) continue;
            iBaritone.getGameEventHandler().onReceivePacket(new PacketEvent((gw)this, EventState.PRE, ht2));
        }
    }

    @Inject(method={"channelRead0"}, at={@At(value="RETURN")})
    private void postProcessPacket(ChannelHandlerContext object, ht<?> ht2, CallbackInfo object22) {
        if (!this.k.isOpen() || this.h != hu.b) {
            return;
        }
        for (IBaritone iBaritone : BaritoneAPI.getProvider().getAllBaritones()) {
            if (iBaritone.getPlayerContext().player() == null || iBaritone.getPlayerContext().player().d.a() != (gw)this) continue;
            iBaritone.getGameEventHandler().onReceivePacket(new PacketEvent((gw)this, EventState.POST, ht2));
        }
    }
}

