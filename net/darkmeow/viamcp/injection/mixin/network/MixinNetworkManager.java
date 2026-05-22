/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  net.minecraft.network.NetworkManager
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.viamcp.injection.mixin.network;

import de.florianmichael.vialoadingbase.netty.event.CompressionReorderEvent;
import io.netty.channel.Channel;
import net.minecraft.network.NetworkManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={NetworkManager.class})
public class MixinNetworkManager {
    @Shadow
    private Channel field_150746_k;

    @Inject(method={"setCompressionThreshold"}, at={@At(value="RETURN")})
    private void setCompressionThreshold$RETURN$fixCompression(int threshold, CallbackInfo ci2) {
        this.field_150746_k.pipeline().fireUserEventTriggered((Object)new CompressionReorderEvent());
    }
}

