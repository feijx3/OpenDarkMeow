/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandlerContext
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.network.NetworkManager
 *  net.minecraft.network.Packet
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.network;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.events.network.NetworkExceptionCaughtEvent;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.darkmeow.darkmeow.utils.network.PacketSide;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={NetworkManager.class})
public class MixinNetworkManager {
    @Shadow
    private Channel field_150746_k;
    @Shadow
    private boolean field_179297_n;

    @Inject(method={"channelRead0(Lio/netty/channel/ChannelHandlerContext;Lnet/minecraft/network/Packet;)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void read(ChannelHandlerContext context, Packet<?> packet, CallbackInfo ci2) {
        try {
            if (!this.field_150746_k.isOpen() || !this.darkMeow$isClient()) {
                return;
            }
            if (DarkMeow.networkManager.packetManager.callPacketEvent(packet, PacketSide.SERVER, null)) {
                ci2.cancel();
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @Inject(method={"sendPacket(Lnet/minecraft/network/Packet;)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void sendPacket$HEAD(Packet<?> packet, CallbackInfo callback) {
        try {
            if (!this.field_150746_k.isOpen() || !this.darkMeow$isClient()) {
                return;
            }
            if (DarkMeow.networkManager.packetManager.callPacketEvent(packet, PacketSide.CLIENT, null)) {
                callback.cancel();
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @Inject(method={"handleDisconnection"}, at={@At(value="HEAD")}, cancellable=true)
    private void handleDisconnection$removeWarn(CallbackInfo ci2) {
        if (this.field_179297_n) {
            ci2.cancel();
        }
    }

    @Inject(method={"exceptionCaught"}, at={@At(value="HEAD")}, cancellable=true)
    private void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable, CallbackInfo ci2) {
        if (!this.darkMeow$isClient()) {
            return;
        }
        NetworkExceptionCaughtEvent event = new NetworkExceptionCaughtEvent(channelHandlerContext, throwable);
        DarkMeow.eventManager.callEvent(event);
        if (event.isCancelled()) {
            ci2.cancel();
        }
    }

    @Unique
    private boolean darkMeow$isClient() {
        NetworkManager casted = (NetworkManager)this;
        NetHandlerPlayClient connection = MinecraftInstance.mc.getConnection();
        return connection != null && casted == connection.func_147298_b();
    }
}

