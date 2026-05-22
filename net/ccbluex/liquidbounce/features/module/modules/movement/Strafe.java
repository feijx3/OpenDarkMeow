/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.entity.Entity
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.JumpEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.event.events.player.move.PlayerSPMoveRelativeEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.extend.ExtendKeyBinding;
import net.ccbluex.liquidbounce.injection.extend.entity.ExtendEntity;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="Strafe", description="Allows you to freely move in mid air.", category=ModuleCategory.MOVEMENT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0015H\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/Strafe;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "strengthValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "noMoveStopValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "onGroundStrafeValue", "allDirectionsJumpValue", "wasDown", "", "jump", "onJump", "", "event", "Lnet/ccbluex/liquidbounce/event/JumpEvent;", "onEnable", "onUpdate", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "onStrafe", "Lnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPMoveRelativeEvent;", "getMoveYaw", "", "DarkMeow"})
public final class Strafe
extends Module {
    @NotNull
    private FloatValue strengthValue = new FloatValue("Strength", 0.5f, 0.0f, 1.0f);
    @NotNull
    private BoolValue noMoveStopValue = new BoolValue("NoMoveStop", false);
    @NotNull
    private BoolValue onGroundStrafeValue = new BoolValue("OnGroundStrafe", false);
    @NotNull
    private BoolValue allDirectionsJumpValue = new BoolValue("AllDirectionsJump", false);
    private boolean wasDown;
    private boolean jump;

    public Strafe() {
        super(null, null, null, null, 15, null);
    }

    @EventTarget
    public final void onJump(@NotNull JumpEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.jump) {
            event.cancelEvent();
        }
    }

    @Override
    public void onEnable() {
        this.wasDown = false;
    }

    /*
     * Enabled aggressive block sorting
     */
    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        block8: {
            block9: {
                Intrinsics.checkNotNullParameter(event, "event");
                EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
                Intrinsics.checkNotNull(entityPlayerSP);
                if (!entityPlayerSP.field_70122_E || !MinecraftInstance.mc.getGameSettings().field_74314_A.func_151470_d() || !((Boolean)this.allDirectionsJumpValue.get()).booleanValue()) break block8;
                EntityPlayerSP entityPlayerSP2 = MinecraftInstance.mc.getPlayer();
                Intrinsics.checkNotNull(entityPlayerSP2);
                if (!(entityPlayerSP2.field_71158_b.field_192832_b == 0.0f)) break block9;
                EntityPlayerSP entityPlayerSP3 = MinecraftInstance.mc.getPlayer();
                Intrinsics.checkNotNull(entityPlayerSP3);
                if (entityPlayerSP3.field_71158_b.field_78902_a == 0.0f) break block8;
            }
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            Intrinsics.checkNotNull(entityPlayerSP);
            if (!entityPlayerSP.func_70090_H()) {
                EntityPlayerSP entityPlayerSP4 = MinecraftInstance.mc.getPlayer();
                Intrinsics.checkNotNull(entityPlayerSP4);
                if (!entityPlayerSP4.func_180799_ab()) {
                    EntityPlayerSP entityPlayerSP5 = MinecraftInstance.mc.getPlayer();
                    Intrinsics.checkNotNull(entityPlayerSP5);
                    if (!entityPlayerSP5.func_70617_f_()) {
                        EntityPlayerSP entityPlayerSP6 = MinecraftInstance.mc.getPlayer();
                        Intrinsics.checkNotNull(entityPlayerSP6);
                        if (!ExtendEntity.INSTANCE.isInWeb((Entity)entityPlayerSP6)) {
                            if (MinecraftInstance.mc.getGameSettings().field_74314_A.func_151470_d()) {
                                KeyBinding keyBinding = MinecraftInstance.mc.getGameSettings().field_74314_A;
                                Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindJump");
                                ExtendKeyBinding.INSTANCE.setPressed(keyBinding, false);
                                this.wasDown = true;
                            }
                            EntityPlayerSP entityPlayerSP7 = MinecraftInstance.mc.getPlayer();
                            Intrinsics.checkNotNull(entityPlayerSP7);
                            float yaw = entityPlayerSP7.field_70177_z;
                            Intrinsics.checkNotNull(MinecraftInstance.mc.getPlayer());
                            MinecraftInstance.mc.getPlayer().field_70177_z = this.getMoveYaw();
                            EntityPlayerSP entityPlayerSP8 = MinecraftInstance.mc.getPlayer();
                            Intrinsics.checkNotNull(entityPlayerSP8);
                            entityPlayerSP8.func_70664_aZ();
                            Intrinsics.checkNotNull(MinecraftInstance.mc.getPlayer());
                            MinecraftInstance.mc.getPlayer().field_70177_z = yaw;
                            this.jump = true;
                            if (!this.wasDown) return;
                            KeyBinding keyBinding = MinecraftInstance.mc.getGameSettings().field_74314_A;
                            Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindJump");
                            ExtendKeyBinding.INSTANCE.setPressed(keyBinding, true);
                            this.wasDown = false;
                            return;
                        }
                    }
                }
            }
        }
        this.jump = false;
    }

    @EventTarget
    public final void onStrafe(@NotNull PlayerSPMoveRelativeEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        Intrinsics.checkNotNull(entityPlayerSP);
        double d2 = entityPlayerSP.field_70159_w;
        EntityPlayerSP entityPlayerSP2 = MinecraftInstance.mc.getPlayer();
        Intrinsics.checkNotNull(entityPlayerSP2);
        double d3 = d2 * entityPlayerSP2.field_70159_w;
        EntityPlayerSP entityPlayerSP3 = MinecraftInstance.mc.getPlayer();
        Intrinsics.checkNotNull(entityPlayerSP3);
        double d4 = entityPlayerSP3.field_70179_y;
        EntityPlayerSP entityPlayerSP4 = MinecraftInstance.mc.getPlayer();
        Intrinsics.checkNotNull(entityPlayerSP4);
        double shotSpeed = Math.sqrt(d3 + d4 * entityPlayerSP4.field_70179_y);
        double speed = shotSpeed * ((Number)this.strengthValue.get()).doubleValue();
        EntityPlayerSP entityPlayerSP5 = MinecraftInstance.mc.getPlayer();
        Intrinsics.checkNotNull(entityPlayerSP5);
        double motionX = entityPlayerSP5.field_70159_w * (double)(1.0f - ((Number)this.strengthValue.get()).floatValue());
        EntityPlayerSP entityPlayerSP6 = MinecraftInstance.mc.getPlayer();
        Intrinsics.checkNotNull(entityPlayerSP6);
        double motionZ = entityPlayerSP6.field_70179_y * (double)(1.0f - ((Number)this.strengthValue.get()).floatValue());
        EntityPlayerSP entityPlayerSP7 = MinecraftInstance.mc.getPlayer();
        Intrinsics.checkNotNull(entityPlayerSP7);
        if (entityPlayerSP7.field_71158_b.field_192832_b == 0.0f) {
            EntityPlayerSP entityPlayerSP8 = MinecraftInstance.mc.getPlayer();
            Intrinsics.checkNotNull(entityPlayerSP8);
            if (entityPlayerSP8.field_71158_b.field_78902_a == 0.0f) {
                if (((Boolean)this.noMoveStopValue.get()).booleanValue()) {
                    Intrinsics.checkNotNull(MinecraftInstance.mc.getPlayer());
                    MinecraftInstance.mc.getPlayer().field_70159_w = 0.0;
                    Intrinsics.checkNotNull(MinecraftInstance.mc.getPlayer());
                    MinecraftInstance.mc.getPlayer().field_70179_y = 0.0;
                }
                return;
            }
        }
        EntityPlayerSP entityPlayerSP9 = MinecraftInstance.mc.getPlayer();
        Intrinsics.checkNotNull(entityPlayerSP9);
        if (!entityPlayerSP9.field_70122_E || ((Boolean)this.onGroundStrafeValue.get()).booleanValue()) {
            float yaw = this.getMoveYaw();
            Intrinsics.checkNotNull(MinecraftInstance.mc.getPlayer());
            MinecraftInstance.mc.getPlayer().field_70159_w = -Math.sin(Math.toRadians(yaw)) * speed + motionX;
            Intrinsics.checkNotNull(MinecraftInstance.mc.getPlayer());
            MinecraftInstance.mc.getPlayer().field_70179_y = Math.cos(Math.toRadians(yaw)) * speed + motionZ;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private final float getMoveYaw() {
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        Intrinsics.checkNotNull(entityPlayerSP);
        float moveYaw = entityPlayerSP.field_70177_z;
        EntityPlayerSP entityPlayerSP2 = MinecraftInstance.mc.getPlayer();
        Intrinsics.checkNotNull(entityPlayerSP2);
        if (!(entityPlayerSP2.field_191988_bg == 0.0f)) {
            EntityPlayerSP entityPlayerSP3 = MinecraftInstance.mc.getPlayer();
            Intrinsics.checkNotNull(entityPlayerSP3);
            if (entityPlayerSP3.field_70702_br == 0.0f) {
                EntityPlayerSP entityPlayerSP4 = MinecraftInstance.mc.getPlayer();
                Intrinsics.checkNotNull(entityPlayerSP4);
                return moveYaw += (float)(entityPlayerSP4.field_191988_bg > 0.0f ? 0 : 180);
            }
        }
        EntityPlayerSP entityPlayerSP5 = MinecraftInstance.mc.getPlayer();
        Intrinsics.checkNotNull(entityPlayerSP5);
        if (!(entityPlayerSP5.field_191988_bg == 0.0f)) {
            EntityPlayerSP entityPlayerSP6 = MinecraftInstance.mc.getPlayer();
            Intrinsics.checkNotNull(entityPlayerSP6);
            if (!(entityPlayerSP6.field_70702_br == 0.0f)) {
                EntityPlayerSP entityPlayerSP7 = MinecraftInstance.mc.getPlayer();
                Intrinsics.checkNotNull(entityPlayerSP7);
                if (entityPlayerSP7.field_191988_bg > 0.0f) {
                    EntityPlayerSP entityPlayerSP8 = MinecraftInstance.mc.getPlayer();
                    Intrinsics.checkNotNull(entityPlayerSP8);
                    moveYaw += (float)(entityPlayerSP8.field_70702_br > 0.0f ? -45 : 45);
                } else {
                    EntityPlayerSP entityPlayerSP9 = MinecraftInstance.mc.getPlayer();
                    Intrinsics.checkNotNull(entityPlayerSP9);
                    moveYaw -= (float)(entityPlayerSP9.field_70702_br > 0.0f ? -45 : 45);
                }
                EntityPlayerSP entityPlayerSP10 = MinecraftInstance.mc.getPlayer();
                Intrinsics.checkNotNull(entityPlayerSP10);
                return moveYaw += (float)(entityPlayerSP10.field_191988_bg > 0.0f ? 0 : 180);
            }
        }
        EntityPlayerSP entityPlayerSP11 = MinecraftInstance.mc.getPlayer();
        Intrinsics.checkNotNull(entityPlayerSP11);
        if (entityPlayerSP11.field_70702_br == 0.0f) return moveYaw;
        EntityPlayerSP entityPlayerSP12 = MinecraftInstance.mc.getPlayer();
        Intrinsics.checkNotNull(entityPlayerSP12);
        if (!(entityPlayerSP12.field_191988_bg == 0.0f)) return moveYaw;
        EntityPlayerSP entityPlayerSP13 = MinecraftInstance.mc.getPlayer();
        Intrinsics.checkNotNull(entityPlayerSP13);
        moveYaw += (float)(entityPlayerSP13.field_70702_br > 0.0f ? -90 : 90);
        return moveYaw;
    }
}

