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
package net.ccbluex.liquidbounce.handler.rotation;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.JumpEvent;
import net.ccbluex.liquidbounce.event.Listenable;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.event.events.player.PlayerSPLookEvent;
import net.ccbluex.liquidbounce.event.events.player.move.PlayerSPMoveRelativeEvent;
import net.ccbluex.liquidbounce.event.events.player.move.PlayerSPUpdateWalkingEvent;
import net.ccbluex.liquidbounce.handler.rotation.RotationManager;
import net.ccbluex.liquidbounce.handler.rotation.data.Rotation;
import net.ccbluex.liquidbounce.handler.rotation.data.RotationTask;
import net.ccbluex.liquidbounce.handler.rotation.movements.mode.MovementMode;
import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0003J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0010H\u0003J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0012H\u0003J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0014H\u0003J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0016H\u0003J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0018H\u0003J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u001aH\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\n\u00a8\u0006\u001d"}, d2={"Lnet/ccbluex/liquidbounce/handler/rotation/RotationManagerApply;", "Lnet/ccbluex/liquidbounce/event/Listenable;", "manager", "Lnet/ccbluex/liquidbounce/handler/rotation/RotationManager;", "<init>", "(Lnet/ccbluex/liquidbounce/handler/rotation/RotationManager;)V", "getManager", "()Lnet/ccbluex/liquidbounce/handler/rotation/RotationManager;", "movementYaw", "", "Ljava/lang/Float;", "onMovementInputPost", "", "event", "Lnet/ccbluex/liquidbounce/event/events/input/MovementInputEvent$POST;", "onPlayerSPUpdateWalkingPre", "Lnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPUpdateWalkingEvent$PRE;", "onPlayerSPUpdateWalkingPost", "Lnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPUpdateWalkingEvent$POST;", "onPlayerSPLook", "Lnet/ccbluex/liquidbounce/event/events/player/PlayerSPLookEvent;", "onJump", "Lnet/ccbluex/liquidbounce/event/JumpEvent;", "onPlayerSPMoveRelative", "Lnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPMoveRelativeEvent;", "onWorld", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "handleEvents", "", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nRotationManagerApply.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RotationManagerApply.kt\nnet/ccbluex/liquidbounce/handler/rotation/RotationManagerApply\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,93:1\n1#2:94\n*E\n"})
public final class RotationManagerApply
implements Listenable {
    @NotNull
    private final RotationManager manager;
    @JvmField
    @Nullable
    public Float movementYaw;

    public RotationManagerApply(@NotNull RotationManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        this.manager = manager;
    }

    @NotNull
    public final RotationManager getManager() {
        return this.manager;
    }

    @EventTarget(priority=0)
    private final void onMovementInputPost(MovementInputEvent.POST event) {
        block4: {
            RotationTask rotationTask;
            EntityPlayerSP entityPlayerSP = this.manager.mc.field_71439_g;
            if (entityPlayerSP == null) {
                return;
            }
            EntityPlayerSP player = entityPlayerSP;
            RotationTask rotationTask2 = this.manager.getTask();
            if (rotationTask2 == null) break block4;
            RotationTask task = rotationTask = rotationTask2;
            boolean bl2 = false;
            if (task.getKeepTicks() < 0) {
                this.manager.setTask(null);
                this.movementYaw = null;
            } else {
                MovementMode movementMode = task.getMode();
                if (movementMode != null) {
                    movementMode.apply(this, task, event.getMovementInput(), player);
                }
                int n2 = task.getKeepTicks();
                task.setKeepTicks(n2 + -1);
            }
        }
    }

    @EventTarget(priority=2000)
    private final void onPlayerSPUpdateWalkingPre(PlayerSPUpdateWalkingEvent.PRE event) {
        block0: {
            Object object;
            Object object2 = this.manager.getTask();
            if (object2 == null || (object2 = ((RotationTask)object2).getSmoothRotation(this.manager.serverRotation)) == null) break block0;
            Object rotation = object = object2;
            boolean bl2 = false;
            event.rotationYaw = ((Rotation)rotation).yaw;
            event.rotationPitch = ((Rotation)rotation).pitch;
        }
    }

    @EventTarget(priority=2000)
    private final void onPlayerSPUpdateWalkingPost(PlayerSPUpdateWalkingEvent.POST event) {
        block0: {
            PlayerSPUpdateWalkingEvent.POST pOST;
            PlayerSPUpdateWalkingEvent.POST pOST2;
            PlayerSPUpdateWalkingEvent.POST it = pOST2 = event;
            boolean bl2 = false;
            PlayerSPUpdateWalkingEvent.POST pOST3 = pOST = !it.isCancelled ? pOST2 : null;
            if (pOST == null) break block0;
            it = pOST2 = pOST;
            boolean bl3 = false;
            this.manager.serverRotation.yaw = it.rotationYaw;
            this.manager.serverRotation.pitch = it.rotationPitch;
        }
    }

    @EventTarget
    private final void onPlayerSPLook(PlayerSPLookEvent event) {
        block0: {
            Object object;
            Object object2 = this.manager.getTask();
            if (object2 == null || (object2 = ((RotationTask)object2).getSmoothRotation(this.manager.serverRotation)) == null) break block0;
            Object rotation = object = object2;
            boolean bl2 = false;
            event.setReturnValue(rotation);
        }
    }

    @EventTarget(priority=2000)
    private final void onJump(JumpEvent event) {
        block1: {
            RotationTask rotationTask;
            RotationTask rotationTask2 = this.manager.getTask();
            if (rotationTask2 == null) break block1;
            RotationTask it = rotationTask = rotationTask2;
            boolean bl2 = false;
            Float f2 = this.movementYaw;
            if (f2 != null) {
                Float f3 = f2;
                float yaw = ((Number)f3).floatValue();
                boolean bl3 = false;
                event.setMovementYaw(yaw);
            }
        }
    }

    @EventTarget(priority=2000)
    private final void onPlayerSPMoveRelative(PlayerSPMoveRelativeEvent event) {
        block1: {
            RotationTask rotationTask;
            RotationTask rotationTask2 = this.manager.getTask();
            if (rotationTask2 == null) break block1;
            RotationTask it = rotationTask = rotationTask2;
            boolean bl2 = false;
            Float f2 = this.movementYaw;
            if (f2 != null) {
                Float f3 = f2;
                float yaw = ((Number)f3).floatValue();
                boolean bl3 = false;
                event.setMovementYaw(yaw);
            }
        }
    }

    @EventTarget
    private final void onWorld(WorldEvent event) {
        this.manager.setTask(null);
    }

    @Override
    public boolean handleEvents() {
        return true;
    }
}

