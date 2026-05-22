/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.server.SPacketEntityVelocity
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.velocitys.vanilla;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.modules.combat.velocitys.VelocityMode;
import net.ccbluex.liquidbounce.injection.access.network.AccessorSPacketEntityVelocity;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0019H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/vanilla/JumpVelocity;", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/VelocityMode;", "<init>", "()V", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "jumpReductionValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "jumpReductionAmountValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "motionValue", "failValue", "failRateValue", "Lnet/ccbluex/liquidbounce/value/Value;", "", "failJumpValue", "doJump", "", "failJump", "skipVeloc", "onVelocity", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "onVelocityPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "DarkMeow"})
public final class JumpVelocity
extends VelocityMode {
    @NotNull
    private final ListValue modeValue;
    @NotNull
    private final BoolValue jumpReductionValue;
    @NotNull
    private final FloatValue jumpReductionAmountValue;
    @NotNull
    private final FloatValue motionValue;
    @NotNull
    private final BoolValue failValue;
    @NotNull
    private final Value<Float> failRateValue;
    @NotNull
    private final Value<Float> failJumpValue;
    private boolean doJump;
    private boolean failJump;
    private boolean skipVeloc;

    public JumpVelocity() {
        super("Jump");
        String[] stringArray = new String[]{"Motion", "Jump", "Both"};
        this.modeValue = new ListValue(this.getValuePrefix() + "Mode", stringArray, "Jump");
        this.jumpReductionValue = new BoolValue(this.getValuePrefix() + "ExtraReduction", false);
        this.jumpReductionAmountValue = new FloatValue(this.getValuePrefix() + "ExtraReductionAmount", 1.0f, 0.1f, 1.0f);
        this.motionValue = new FloatValue(this.getValuePrefix() + "Motion", 0.42f, 0.4f, 0.5f);
        this.failValue = new BoolValue(this.getValuePrefix() + "SmartFail", true);
        this.failRateValue = new FloatValue(this.getValuePrefix() + "FailRate", 0.3f, 0.0f, 1.0f).displayable(() -> JumpVelocity.failRateValue$lambda$0(this));
        this.failJumpValue = new FloatValue(this.getValuePrefix() + "FailJumpRate", 0.25f, 0.0f, 1.0f).displayable(() -> JumpVelocity.failJumpValue$lambda$1(this));
        this.doJump = true;
    }

    @EventTarget
    public final void onVelocity(@NotNull UpdateEvent event) {
        block21: {
            Intrinsics.checkNotNullParameter(event, "event");
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null) {
                return;
            }
            EntityPlayerSP player = entityPlayerSP;
            if (!this.failJump && player.field_70737_aN <= 7 || !player.field_70122_E) break block21;
            if (this.failJump) {
                this.failJump = false;
            }
            if (!this.doJump) {
                this.skipVeloc = true;
            }
            if (Math.random() <= (double)((Number)this.failRateValue.get()).floatValue() && ((Boolean)this.failValue.get()).booleanValue()) {
                if (Math.random() <= (double)((Number)this.failJumpValue.get()).floatValue()) {
                    this.doJump = true;
                    this.failJump = true;
                } else {
                    this.doJump = false;
                    this.failJump = false;
                }
            } else {
                this.doJump = true;
                this.failJump = false;
            }
            if (this.skipVeloc) {
                this.skipVeloc = false;
                return;
            }
            String string = ((String)this.modeValue.get()).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(string, "toLowerCase(...)");
            switch (string) {
                case "motion": {
                    player.field_70181_x = ((Number)this.motionValue.get()).floatValue();
                    break;
                }
                case "jump": {
                    player.func_70664_aZ();
                    break;
                }
                case "both": {
                    player.func_70664_aZ();
                    player.field_70181_x = ((Number)this.motionValue.get()).floatValue();
                }
            }
        }
    }

    @EventTarget
    public final void onVelocityPacket(@NotNull PacketEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Packet<?> packet = event.getPacket();
        if (packet instanceof SPacketEntityVelocity && ((Boolean)this.jumpReductionValue.get()).booleanValue()) {
            ((AccessorSPacketEntityVelocity)packet).setMotionX((int)((double)((SPacketEntityVelocity)packet).func_149411_d() * (double)((Number)this.jumpReductionAmountValue.get()).floatValue()));
            ((AccessorSPacketEntityVelocity)packet).setMotionZ((int)((double)((SPacketEntityVelocity)packet).func_149409_f() * (double)((Number)this.jumpReductionAmountValue.get()).floatValue()));
        }
    }

    private static final boolean failRateValue$lambda$0(JumpVelocity this$0) {
        return (Boolean)this$0.failValue.get();
    }

    private static final boolean failJumpValue$lambda$1(JumpVelocity this$0) {
        return (Boolean)this$0.failValue.get();
    }
}

