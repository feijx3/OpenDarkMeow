/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandler
 *  io.netty.handler.proxy.HttpProxyHandler
 *  io.netty.handler.proxy.Socks4ProxyHandler
 *  io.netty.handler.proxy.Socks5ProxyHandler
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.network;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.handler.proxy.HttpProxyHandler;
import io.netty.handler.proxy.Socks4ProxyHandler;
import io.netty.handler.proxy.Socks5ProxyHandler;
import java.net.SocketAddress;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.handler.network.proxy.ProxyConfig;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(targets={"net.minecraft.network.NetworkManager$5"}, remap=false)
public class MixinNetworkManager$5 {
    @Inject(method={"initChannel"}, at={@At(value="TAIL")})
    private void initChannel$TAIL$injectViaMCP(Channel channel, CallbackInfo ci2) {
        if (DarkMeow.networkManager.proxyManager.isEnable) {
            ProxyConfig config = DarkMeow.networkManager.proxyManager.config;
            switch (config.type.id) {
                case 0: {
                    channel.pipeline().addFirst(new ChannelHandler[]{new HttpProxyHandler((SocketAddress)config.getAddress())});
                    break;
                }
                case 1: {
                    channel.pipeline().addFirst(new ChannelHandler[]{new Socks5ProxyHandler((SocketAddress)config.getAddress())});
                    break;
                }
                case 2: {
                    channel.pipeline().addFirst(new ChannelHandler[]{new Socks4ProxyHandler((SocketAddress)config.getAddress())});
                }
            }
        }
    }
}

