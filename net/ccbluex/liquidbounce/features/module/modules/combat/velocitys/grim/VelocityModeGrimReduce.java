/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.velocitys.grim;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.event.events.player.move.PlayerSPVelocityEvent;
import net.ccbluex.liquidbounce.features.module.modules.combat.velocitys.VelocityMode;
import net.ccbluex.liquidbounce.handler.rotation.data.Rotation;
import net.ccbluex.liquidbounce.handler.rotation.data.RotationTask;
import net.ccbluex.liquidbounce.handler.rotation.movements.mode.impl.MovementModeSilent;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u001bH\u0007J\u0018\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/grim/VelocityModeGrimReduce;", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/VelocityMode;", "<init>", "()V", "autoRotationValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "moveForward", "", "moveBack", "moveLeft", "moveRight", "jump", "moveTicks", "", "lastMotionX", "", "lastMotionZ", "targetRotation", "Lnet/ccbluex/liquidbounce/handler/rotation/data/Rotation;", "onVelocity", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPVelocityEvent;", "setRotation", "motionX", "motionZ", "onMovementInputPre", "Lnet/ccbluex/liquidbounce/event/events/input/MovementInputEvent$PRE;", "determineDirection", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nVelocityModeGrimReduce.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VelocityModeGrimReduce.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/grim/VelocityModeGrimReduce\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,132:1\n1#2:133\n*E\n"})
public final class VelocityModeGrimReduce
extends VelocityMode {
    @JvmField
    @NotNull
    public final BoolValue autoRotationValue = new BoolValue("GrimReduce-AutoRotation", true);
    private boolean moveForward;
    private boolean moveBack;
    private boolean moveLeft;
    private boolean moveRight;
    private boolean jump;
    private int moveTicks;
    private double lastMotionX;
    private double lastMotionZ;
    @Nullable
    private Rotation targetRotation;

    public VelocityModeGrimReduce() {
        super("GrimReduce");
    }

    @EventTarget(ignoreCanceled=true)
    public final void onVelocity(@NotNull PlayerSPVelocityEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        if (event.isCancelled() || player.func_70093_af() || player.func_70027_ad() || DarkMeow.INSTANCE.getMovementManager().getStuckManager().isInStuck() || player.func_70090_H() || player.func_180799_ab() || Math.abs(event.motionX) < 0.1 && Math.abs(event.motionZ) < 0.1) {
            return;
        }
        this.lastMotionX = event.motionX;
        this.lastMotionZ = event.motionZ;
        if (player.field_70737_aN >= 8) {
            this.jump = true;
        }
        if (player.field_70737_aN >= 7) {
            if (((Boolean)this.autoRotationValue.get()).booleanValue()) {
                this.setRotation(event.motionX, event.motionZ);
            }
            this.moveTicks = 4;
        }
    }

    private final void setRotation(double motionX, double motionZ) {
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        float offset = motionX > 0.0 && motionZ < 0.0 || motionX < 0.0 && motionZ > 0.0 ? 90.0f : -90.0f;
        float yaw = (float)Math.toDegrees(Math.atan2(-motionX, -motionZ)) + offset;
        this.targetRotation = new Rotation(yaw, player.field_70125_A);
        Rotation rotation = this.targetRotation;
        if (rotation == null) {
            rotation = new Rotation(player.field_70177_z, player.field_70125_A);
        }
        Rotation rotation2 = rotation;
        DarkMeow.INSTANCE.getRotationManager().addTask(new RotationTask(this.getName(), rotation2, MovementModeSilent.INSTANCE, 3));
    }

    @EventTarget
    public final void onMovementInputPre(@NotNull MovementInputEvent.PRE event) {
        int n2;
        Intrinsics.checkNotNullParameter(event, "event");
        int n3 = n2 = this.jump;
        boolean bl2 = event.getKeyStateJump();
        MovementInputEvent.PRE pRE = event;
        boolean bl3 = false;
        this.jump = false;
        Unit unit = Unit.INSTANCE;
        pRE.setKeyStateJump(bl2 | n2);
        if (this.moveTicks > 0) {
            if (!(this.lastMotionX == 0.0) && !(this.lastMotionZ == 0.0)) {
                this.determineDirection(this.lastMotionX, this.lastMotionZ);
            }
            event.setKeyStateForward(false);
            event.setKeyStateBack(false);
            event.setKeyStateLeft(false);
            event.setKeyStateRight(false);
            if (this.moveForward) {
                event.setKeyStateForward(true);
            }
            if (this.moveBack) {
                event.setKeyStateBack(true);
            }
            if (this.moveLeft) {
                event.setKeyStateLeft(true);
            }
            if (this.moveRight) {
                event.setKeyStateRight(true);
            }
            n2 = this.moveTicks;
            this.moveTicks = n2 + -1;
        } else {
            this.moveForward = false;
            this.moveBack = false;
            this.moveLeft = false;
            this.moveRight = false;
        }
    }

    private final void determineDirection(double motionX, double motionZ) {
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        this.moveForward = false;
        this.moveBack = false;
        this.moveLeft = false;
        this.moveRight = false;
        double playerYaw = Math.toRadians(player.field_70177_z);
        double localX = motionX * Math.cos(playerYaw) + motionZ * Math.sin(playerYaw);
        double localZ = -motionX * Math.sin(playerYaw) + motionZ * Math.cos(playerYaw);
        this.moveForward = localZ < -0.141;
        this.moveBack = localZ > 0.141;
        this.moveLeft = localX < -0.141;
        this.moveRight = localX > 0.141;
    }
}

