/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.network.play.server.SPacketEntityVelocity
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.velocitys.aac;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.modules.combat.velocitys.VelocityMode;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0012H\u0007R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/aac/AAC520CombatVelocity;", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/VelocityMode;", "<init>", "()V", "mc", "Lnet/minecraft/client/Minecraft;", "getMc", "()Lnet/minecraft/client/Minecraft;", "templateX", "", "templateY", "templateZ", "onEnable", "", "onVelocity", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "onVelocityPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "DarkMeow"})
public final class AAC520CombatVelocity
extends VelocityMode {
    @NotNull
    private final Minecraft mc;
    private int templateX;
    private int templateY;
    private int templateZ;

    public AAC520CombatVelocity() {
        super("AAC5.2.0Combat");
        Minecraft minecraft = Minecraft.func_71410_x();
        Intrinsics.checkNotNullExpressionValue(minecraft, "getMinecraft(...)");
        this.mc = minecraft;
    }

    @NotNull
    public final Minecraft getMc() {
        return this.mc;
    }

    @Override
    public void onEnable() {
        this.templateX = 0;
        this.templateY = 0;
        this.templateZ = 0;
    }

    @EventTarget
    public final void onVelocity(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.mc.field_71439_g.field_70737_aN > 0 && this.getInstance().getVelocityInput()) {
            this.getInstance().setVelocityInput(false);
            this.mc.field_71439_g.field_70159_w = 0.0;
            this.mc.field_71439_g.field_70179_y = 0.0;
            this.mc.field_71439_g.field_70181_x = 0.0;
            this.mc.field_71439_g.field_70747_aH = -0.002f;
            NetHandlerPlayClient netHandlerPlayClient = this.mc.func_147114_u();
            Intrinsics.checkNotNull(netHandlerPlayClient);
            netHandlerPlayClient.func_147297_a((Packet)new CPacketPlayer.Position(this.mc.field_71439_g.field_70165_t, Double.MAX_VALUE, this.mc.field_71439_g.field_70161_v, true));
        }
        if (this.getInstance().getVelocityTimer().hasTimePassed(80L) && this.getInstance().getVelocityInput()) {
            this.getInstance().setVelocityInput(false);
            this.mc.field_71439_g.field_70159_w = (double)this.templateX / 8000.0;
            this.mc.field_71439_g.field_70179_y = (double)this.templateZ / 8000.0;
            this.mc.field_71439_g.field_70181_x = (double)this.templateY / 8000.0;
            this.mc.field_71439_g.field_70747_aH = -0.002f;
        }
    }

    @EventTarget
    public final void onVelocityPacket(@NotNull PacketEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Packet<?> packet = event.getPacket();
        if (packet instanceof SPacketEntityVelocity) {
            event.cancelEvent();
            this.getInstance().setVelocityInput(true);
            this.templateX = ((SPacketEntityVelocity)packet).func_149411_d();
            this.templateZ = ((SPacketEntityVelocity)packet).func_149409_f();
            this.templateY = ((SPacketEntityVelocity)packet).func_149410_e();
        }
    }
}

