/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandler
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.viamcp.injection.mixin.network;

import com.viaversion.viaversion.connection.UserConnectionImpl;
import com.viaversion.viaversion.protocol.ProtocolPipelineImpl;
import de.florianmichael.vialoadingbase.ViaLoadingBase;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import net.darkmeow.viamcp.MCPVLBPipeline;
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
        if (ViaLoadingBase.getInstance().getTargetVersion().getVersion() != 340) {
            UserConnectionImpl user = new UserConnectionImpl(channel, true);
            new ProtocolPipelineImpl(user);
            channel.pipeline().addLast(new ChannelHandler[]{new MCPVLBPipeline(user)});
        }
    }
}

