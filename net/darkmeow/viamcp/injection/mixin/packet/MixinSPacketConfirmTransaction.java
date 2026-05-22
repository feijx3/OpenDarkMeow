/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.PacketBuffer
 *  net.minecraft.network.play.server.SPacketConfirmTransaction
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.viamcp.injection.mixin.packet;

import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import de.florianmichael.vialoadingbase.ViaLoadingBase;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.SPacketConfirmTransaction;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={SPacketConfirmTransaction.class})
public class MixinSPacketConfirmTransaction {
    @Shadow
    private int field_148894_a;
    @Shadow
    private short field_148892_b;
    @Shadow
    private boolean field_148893_c;

    @Inject(method={"readPacketData"}, at={@At(value="HEAD")}, cancellable=true)
    public void readPacketData$Inject$fix1_17(PacketBuffer buf, CallbackInfo ci2) {
        if (ViaLoadingBase.getInstance().getTargetVersion().newerThanOrEqualTo(ProtocolVersion.v1_17)) {
            this.field_148894_a = buf.readInt();
            this.field_148892_b = (short)1000;
            this.field_148893_c = false;
            ci2.cancel();
        }
    }
}

