/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.network.play.server.SPacketPlayerPosLook
 *  net.minecraft.util.MovementInput
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.handler.movement.stuck;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.Listenable;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.event.events.player.move.MoveEvent;
import net.ccbluex.liquidbounce.event.events.player.move.PlayerSPUpdateWalkingEvent;
import net.ccbluex.liquidbounce.event.events.player.move.PlayerSPVelocityEvent;
import net.ccbluex.liquidbounce.features.module.modules.movement.Sprint;
import net.ccbluex.liquidbounce.handler.movement.stuck.MovementStuckInfo;
import net.ccbluex.liquidbounce.injection.extend.entity.ExtendEntityPlayerSP;
import net.ccbluex.liquidbounce.utils.MovementUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.util.MovementInput;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 .2\u00020\u0001:\u0001.B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001b\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u0019J\u0006\u0010\u001d\u001a\u00020\u0019J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020 H\u0003J\u0012\u0010!\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020\"H\u0003J\u0012\u0010#\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020$H\u0003J\u0012\u0010%\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020&H\u0003J\u0012\u0010'\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020(H\u0003J\u0014\u0010)\u001a\u00020**\u00020+2\u0006\u0010,\u001a\u00020\u0007H\u0002J\b\u0010-\u001a\u00020\u0019H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u000b@BX\u0086\u000e\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u000b@BX\u0086\u000e\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2={"Lnet/ccbluex/liquidbounce/handler/movement/stuck/MovementStuckManager;", "Lnet/ccbluex/liquidbounce/event/Listenable;", "mc", "Lnet/minecraft/client/Minecraft;", "<init>", "(Lnet/minecraft/client/Minecraft;)V", "value", "Lnet/ccbluex/liquidbounce/handler/movement/stuck/MovementStuckInfo;", "stuckInfo", "getStuckInfo", "()Lnet/ccbluex/liquidbounce/handler/movement/stuck/MovementStuckInfo;", "", "lastStuckStartUpdateId", "getLastStuckStartUpdateId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "lastStuckStopUpdateId", "getLastStuckStopUpdateId", "cancelPlayerSPUpdateWalkingCount", "", "getCancelPlayerSPUpdateWalkingCount", "()I", "setCancelPlayerSPUpdateWalkingCount", "(I)V", "allowMoving", "", "allowUpdatingWalking", "start", "stop", "isInStuck", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onPlayerSPVelocity", "Lnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPVelocityEvent;", "onMovementInputPre", "Lnet/ccbluex/liquidbounce/event/events/input/MovementInputEvent$PRE;", "onMove", "Lnet/ccbluex/liquidbounce/event/events/player/move/MoveEvent;", "onPlayerSPUpdateWalkingPre", "Lnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPUpdateWalkingEvent$PRE;", "updatePlayerMotionOnStuck", "", "Lnet/minecraft/client/entity/EntityPlayerSP;", "info", "handleEvents", "Companion", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nMovementStuckManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovementStuckManager.kt\nnet/ccbluex/liquidbounce/handler/movement/stuck/MovementStuckManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,183:1\n1#2:184\n*E\n"})
public final class MovementStuckManager
implements Listenable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Minecraft mc;
    @Nullable
    private MovementStuckInfo stuckInfo;
    @Nullable
    private Long lastStuckStartUpdateId;
    @Nullable
    private Long lastStuckStopUpdateId;
    private int cancelPlayerSPUpdateWalkingCount;
    @JvmField
    public boolean allowMoving;
    @JvmField
    public boolean allowUpdatingWalking;
    @NotNull
    public static final String LOCK_SPRINT_NAME = "MovementStuckManager";

    public MovementStuckManager(@NotNull Minecraft mc) {
        Intrinsics.checkNotNullParameter(mc, "mc");
        this.mc = mc;
        EventManager.registerListener$default(DarkMeow.INSTANCE.getEventManager(), this, false, false, 6, null);
    }

    @Nullable
    public final MovementStuckInfo getStuckInfo() {
        return this.stuckInfo;
    }

    @Nullable
    public final Long getLastStuckStartUpdateId() {
        return this.lastStuckStartUpdateId;
    }

    @Nullable
    public final Long getLastStuckStopUpdateId() {
        return this.lastStuckStopUpdateId;
    }

    public final int getCancelPlayerSPUpdateWalkingCount() {
        return this.cancelPlayerSPUpdateWalkingCount;
    }

    public final void setCancelPlayerSPUpdateWalkingCount(int n2) {
        this.cancelPlayerSPUpdateWalkingCount = n2;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean start() {
        EntityPlayerSP entityPlayerSP;
        void it;
        MovementStuckInfo movementStuckInfo;
        EntityPlayerSP entityPlayerSP2;
        EntityPlayerSP entityPlayerSP3;
        EntityPlayerSP entityPlayerSP4;
        EntityPlayerSP entityPlayerSP5 = this.mc.field_71439_g;
        if (entityPlayerSP5 == null) return false;
        EntityPlayerSP it2 = entityPlayerSP4 = entityPlayerSP5;
        boolean bl2 = false;
        if (this.stuckInfo != null) return false;
        boolean bl3 = true;
        if (!bl3) return false;
        EntityPlayerSP entityPlayerSP6 = entityPlayerSP4;
        EntityPlayerSP entityPlayerSP7 = entityPlayerSP6;
        if (entityPlayerSP7 == null) return false;
        EntityPlayerSP it3 = entityPlayerSP3 = entityPlayerSP7;
        boolean bl4 = false;
        this.cancelPlayerSPUpdateWalkingCount = 0;
        this.allowMoving = false;
        this.allowUpdatingWalking = false;
        EntityPlayerSP player = entityPlayerSP2 = entityPlayerSP3;
        boolean bl5 = false;
        MovementStuckInfo movementStuckInfo2 = movementStuckInfo = new MovementStuckInfo(player);
        MovementStuckManager movementStuckManager = this;
        boolean bl6 = false;
        if (!it.getBeforeSprintingStatus()) {
            Sprint.unlockNoSprint(LOCK_SPRINT_NAME);
        }
        movementStuckManager.stuckInfo = movementStuckInfo;
        MovementInput movementInput = player.field_71158_b;
        Intrinsics.checkNotNullExpressionValue(movementInput, "movementInput");
        MovementUtils.INSTANCE.resetMove(movementInput);
        EntityPlayerSP it4 = entityPlayerSP = entityPlayerSP2;
        boolean bl7 = false;
        this.lastStuckStartUpdateId = DarkMeow.INSTANCE.getUpdateManager().getUpdateId();
        this.lastStuckStopUpdateId = null;
        EntityPlayerSP it5 = entityPlayerSP;
        return true;
    }

    public final boolean stop() {
        boolean bl2;
        MovementStuckInfo movementStuckInfo = this.stuckInfo;
        if (movementStuckInfo != null) {
            MovementStuckInfo movementStuckInfo2;
            MovementStuckInfo movementStuckInfo3;
            MovementStuckInfo info = movementStuckInfo3 = movementStuckInfo;
            boolean bl3 = false;
            EntityPlayerSP entityPlayerSP = this.mc.field_71439_g;
            if (entityPlayerSP != null) {
                EntityPlayerSP entityPlayerSP2;
                EntityPlayerSP player = entityPlayerSP2 = entityPlayerSP;
                boolean bl4 = false;
                player.field_71174_a.func_147297_a((Packet)new CPacketPlayer(player.field_70122_E));
                int n2 = ExtendEntityPlayerSP.INSTANCE.getPositionUpdateTicks(player);
                ExtendEntityPlayerSP.INSTANCE.setPositionUpdateTicks(player, n2 + 1);
                this.updatePlayerMotionOnStuck(player, info);
            }
            Sprint.unlockNoSprint(LOCK_SPRINT_NAME);
            this.stuckInfo = null;
            MovementStuckInfo it = movementStuckInfo2 = movementStuckInfo3;
            boolean bl5 = false;
            this.lastStuckStopUpdateId = DarkMeow.INSTANCE.getUpdateManager().getUpdateId();
            MovementStuckInfo it2 = movementStuckInfo2;
            boolean bl6 = false;
            bl2 = true;
        } else {
            bl2 = false;
        }
        return bl2;
    }

    public final boolean isInStuck() {
        return this.stuckInfo != null;
    }

    @EventTarget(ignoreCanceled=true, priority=2000)
    private final MovementStuckInfo onPacket(PacketEvent event) {
        MovementStuckInfo movementStuckInfo;
        MovementStuckInfo movementStuckInfo2 = this.stuckInfo;
        if (movementStuckInfo2 != null) {
            MovementStuckInfo movementStuckInfo3;
            MovementStuckInfo info = movementStuckInfo3 = movementStuckInfo2;
            boolean bl2 = false;
            if (event.getPacket() instanceof SPacketPlayerPosLook) {
                info.setFallDistance(0.0f);
            }
            movementStuckInfo = movementStuckInfo3;
        } else {
            movementStuckInfo = null;
        }
        return movementStuckInfo;
    }

    @EventTarget(ignoreCanceled=true, priority=0)
    private final MovementStuckInfo onPlayerSPVelocity(PlayerSPVelocityEvent event) {
        MovementStuckInfo movementStuckInfo;
        MovementStuckInfo movementStuckInfo2 = this.stuckInfo;
        if (movementStuckInfo2 != null) {
            MovementStuckInfo movementStuckInfo3;
            MovementStuckInfo info = movementStuckInfo3 = movementStuckInfo2;
            boolean bl2 = false;
            info.setMotionX(event.motionX);
            info.setMotionY(event.motionY);
            info.setMotionZ(event.motionZ);
            event.cancelEvent();
            movementStuckInfo = movementStuckInfo3;
        } else {
            movementStuckInfo = null;
        }
        return movementStuckInfo;
    }

    @EventTarget(ignoreCanceled=true, priority=0)
    private final MovementStuckInfo onMovementInputPre(MovementInputEvent.PRE event) {
        MovementStuckInfo movementStuckInfo;
        MovementStuckInfo movementStuckInfo2 = this.stuckInfo;
        if (movementStuckInfo2 != null) {
            MovementStuckInfo movementStuckInfo3;
            MovementStuckInfo info = movementStuckInfo3 = movementStuckInfo2;
            boolean bl2 = false;
            event.setKeyStateSneak(info.getBeforeSneakingStatus());
            event.shouldApplySneakSlow = info.getBeforeSneakingStatus();
            event.setKeyStateForward(info.getBeforeMovementInputForward());
            event.setKeyStateBack(info.getBeforeMovementInputBack());
            event.setKeyStateLeft(info.getBeforeMovementInputLeft());
            event.setKeyStateRight(info.getBeforeMovementInputRight());
            EntityPlayerSP entityPlayerSP = this.mc.field_71439_g;
            if (entityPlayerSP != null) {
                this.updatePlayerMotionOnStuck(entityPlayerSP, info);
            }
            movementStuckInfo = movementStuckInfo3;
        } else {
            movementStuckInfo = null;
        }
        return movementStuckInfo;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @EventTarget(priority=2000)
    private final MovementStuckInfo onMove(MoveEvent event) {
        MovementStuckInfo movementStuckInfo;
        MovementStuckInfo movementStuckInfo2 = this.stuckInfo;
        if (movementStuckInfo2 == null) return null;
        MovementStuckInfo it = movementStuckInfo = movementStuckInfo2;
        boolean bl2 = false;
        if (this.allowMoving) return null;
        boolean bl3 = true;
        if (!bl3) return null;
        MovementStuckInfo movementStuckInfo3 = movementStuckInfo;
        MovementStuckInfo movementStuckInfo4 = movementStuckInfo3;
        if (movementStuckInfo4 == null) return null;
        it = movementStuckInfo = movementStuckInfo4;
        boolean bl4 = false;
        event.zero();
        event.cancelEvent();
        MovementStuckInfo movementStuckInfo5 = movementStuckInfo;
        return movementStuckInfo5;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @EventTarget(priority=2000)
    private final MovementStuckInfo onPlayerSPUpdateWalkingPre(PlayerSPUpdateWalkingEvent.PRE event) {
        MovementStuckInfo movementStuckInfo;
        MovementStuckInfo movementStuckInfo2;
        MovementStuckInfo movementStuckInfo3 = this.stuckInfo;
        if (movementStuckInfo3 == null) return null;
        MovementStuckInfo it = movementStuckInfo2 = movementStuckInfo3;
        boolean bl2 = false;
        if (this.allowUpdatingWalking) return null;
        boolean bl3 = true;
        if (!bl3) return null;
        MovementStuckInfo movementStuckInfo4 = movementStuckInfo2;
        MovementStuckInfo movementStuckInfo5 = movementStuckInfo4;
        if (movementStuckInfo5 == null) return null;
        MovementStuckInfo it2 = movementStuckInfo = movementStuckInfo5;
        boolean bl4 = false;
        event.cancelEvent();
        it2 = movementStuckInfo;
        boolean bl5 = false;
        int n2 = this.cancelPlayerSPUpdateWalkingCount;
        this.cancelPlayerSPUpdateWalkingCount = n2 + 1;
        MovementStuckInfo movementStuckInfo6 = movementStuckInfo;
        return movementStuckInfo6;
    }

    private final void updatePlayerMotionOnStuck(EntityPlayerSP $this$updatePlayerMotionOnStuck, MovementStuckInfo info) {
        $this$updatePlayerMotionOnStuck.field_70159_w = info.getMotionX();
        $this$updatePlayerMotionOnStuck.field_70181_x = info.getMotionY();
        $this$updatePlayerMotionOnStuck.field_70179_y = info.getMotionZ();
        $this$updatePlayerMotionOnStuck.field_70143_R = info.getFallDistance();
    }

    @Override
    public boolean handleEvents() {
        return true;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/ccbluex/liquidbounce/handler/movement/stuck/MovementStuckManager$Companion;", "", "<init>", "()V", "LOCK_SPRINT_NAME", "", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

