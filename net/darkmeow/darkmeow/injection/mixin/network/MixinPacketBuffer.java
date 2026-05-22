/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.PacketBuffer
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.network;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.events.network.buffer.PacketBufferWriteEnumValueEvent;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SideOnly(value=Side.CLIENT)
@Mixin(value={PacketBuffer.class})
public class MixinPacketBuffer {
    @Inject(method={"writeEnumValue"}, at={@At(value="HEAD")}, cancellable=true)
    private void writeEnumValue$callEvent(Enum<?> value, CallbackInfoReturnable<PacketBuffer> cir) {
        PacketBufferWriteEnumValueEvent event = new PacketBufferWriteEnumValueEvent((PacketBuffer)this, value);
        DarkMeow.eventManager.callEvent(event);
        if (event.isCancelled()) {
            cir.setReturnValue(event.getBuffer());
            cir.cancel();
        }
    }
}

