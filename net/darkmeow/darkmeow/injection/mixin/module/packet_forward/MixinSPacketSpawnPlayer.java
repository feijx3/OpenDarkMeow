/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  net.minecraft.network.PacketBuffer
 *  net.minecraft.network.play.server.SPacketSpawnPlayer
 */
package net.darkmeow.darkmeow.injection.mixin.module.packet_forward;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.SPacketSpawnPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={SPacketSpawnPlayer.class})
public class MixinSPacketSpawnPlayer {
    @Unique
    byte[] darkMeow$backupData;

    @Inject(method={"readPacketData"}, at={@At(value="HEAD")})
    public void readPacketData$backupBuf(PacketBuffer buf, CallbackInfo ci2) {
        ByteBuf duplicateBuf = buf.duplicate();
        this.darkMeow$backupData = new byte[duplicateBuf.readableBytes()];
        duplicateBuf.getBytes(duplicateBuf.readerIndex(), this.darkMeow$backupData);
    }

    @Inject(method={"writePacketData"}, at={@At(value="HEAD")}, cancellable=true)
    public void writePacketData$restoreBuf(PacketBuffer buf, CallbackInfo ci2) {
        if (this.darkMeow$backupData != null) {
            buf.writeBytes(this.darkMeow$backupData);
            ci2.cancel();
        }
    }
}

