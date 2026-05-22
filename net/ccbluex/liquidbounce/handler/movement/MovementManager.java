/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.util.math.AxisAlignedBB
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.handler.movement;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.handler.ManagerBase;
import net.ccbluex.liquidbounce.handler.movement.MovementJumpManager;
import net.ccbluex.liquidbounce.handler.movement.stuck.MovementStuckManager;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0017\u001a\u00020\u00132\b\b\u0002\u0010\u0018\u001a\u00020\u0013J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0013J\u0006\u0010\u001c\u001a\u00020\u0013J\u0010\u0010\u001f\u001a\u00020\u001a2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010$\u001a\u00020\u001aJ\b\u0010%\u001a\u00020!H\u0002J\u000e\u0010&\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u001d\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u0011R\u0011\u0010 \u001a\u00020!8F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#\u00a8\u0006'"}, d2={"Lnet/ccbluex/liquidbounce/handler/movement/MovementManager;", "Lnet/ccbluex/liquidbounce/handler/ManagerBase;", "system", "Lnet/ccbluex/liquidbounce/DarkMeow;", "<init>", "(Lnet/ccbluex/liquidbounce/DarkMeow;)V", "jumpManager", "Lnet/ccbluex/liquidbounce/handler/movement/MovementJumpManager;", "getJumpManager", "()Lnet/ccbluex/liquidbounce/handler/movement/MovementJumpManager;", "stuckManager", "Lnet/ccbluex/liquidbounce/handler/movement/stuck/MovementStuckManager;", "getStuckManager", "()Lnet/ccbluex/liquidbounce/handler/movement/stuck/MovementStuckManager;", "speed", "", "getSpeed", "()F", "isSafeWalk", "", "()Z", "setSafeWalk", "(Z)V", "isMoving", "jump", "resetMotion", "", "y", "hasMotion", "movingYaw", "getMovingYaw", "strafe", "direction", "", "getDirection", "()D", "handleVanillaKickBypass", "calculateGround", "move", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nMovementManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovementManager.kt\nnet/ccbluex/liquidbounce/handler/movement/MovementManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,131:1\n1#2:132\n*E\n"})
public class MovementManager
extends ManagerBase {
    @NotNull
    private final MovementJumpManager jumpManager;
    @NotNull
    private final MovementStuckManager stuckManager;
    private boolean isSafeWalk;

    public MovementManager(@NotNull DarkMeow system) {
        Intrinsics.checkNotNullParameter(system, "system");
        super(system);
        this.jumpManager = new MovementJumpManager();
        this.stuckManager = new MovementStuckManager(DarkMeow.mc);
        EventManager.registerListener$default(system.getEventManager(), this.jumpManager, false, false, 6, null);
    }

    @NotNull
    public final MovementJumpManager getJumpManager() {
        return this.jumpManager;
    }

    @NotNull
    public final MovementStuckManager getStuckManager() {
        return this.stuckManager;
    }

    public final float getSpeed() {
        EntityPlayerSP entityPlayerSP = this.mc.field_71439_g;
        if (entityPlayerSP == null) {
            return 0.0f;
        }
        EntityPlayerSP player = entityPlayerSP;
        return (float)Math.sqrt(player.field_70159_w * player.field_70159_w + player.field_70179_y * player.field_70179_y);
    }

    public final boolean isSafeWalk() {
        return this.isSafeWalk;
    }

    public final void setSafeWalk(boolean bl2) {
        this.isSafeWalk = bl2;
    }

    public final boolean isMoving(boolean jump) {
        boolean bl2;
        EntityPlayerSP entityPlayerSP = this.mc.field_71439_g;
        if (entityPlayerSP != null) {
            EntityPlayerSP it = entityPlayerSP;
            boolean bl3 = false;
            bl2 = !(it.field_71158_b.field_192832_b == 0.0f) || !(it.field_71158_b.field_78902_a == 0.0f) || it.field_71158_b.field_78901_c && jump;
        } else {
            bl2 = false;
        }
        return bl2;
    }

    public static /* synthetic */ boolean isMoving$default(MovementManager movementManager, boolean bl2, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isMoving");
        }
        if ((n2 & 1) != 0) {
            bl2 = false;
        }
        return movementManager.isMoving(bl2);
    }

    public final void resetMotion(boolean y2) {
        block1: {
            EntityPlayerSP entityPlayerSP = this.mc.field_71439_g;
            if (entityPlayerSP == null) break block1;
            EntityPlayerSP it = entityPlayerSP;
            boolean bl2 = false;
            it.field_70159_w = 0.0;
            it.field_70179_y = 0.0;
            if (y2) {
                it.field_70181_x = 0.0;
            }
        }
    }

    public final boolean hasMotion() {
        boolean bl2;
        EntityPlayerSP entityPlayerSP = this.mc.field_71439_g;
        if (entityPlayerSP != null) {
            EntityPlayerSP it = entityPlayerSP;
            boolean bl3 = false;
            bl2 = !(it.field_70159_w == 0.0 || it.field_70179_y == 0.0 || it.field_70179_y == 0.0);
        } else {
            bl2 = false;
        }
        return bl2;
    }

    public final float getMovingYaw() {
        return (float)(this.getDirection() * (double)180.0f / Math.PI);
    }

    public final void strafe(float speed) {
        if (!MovementManager.isMoving$default(this, false, 1, null)) {
            return;
        }
        double yaw = this.getDirection();
        EntityPlayerSP entityPlayerSP = this.mc.field_71439_g;
        Intrinsics.checkNotNull(entityPlayerSP);
        EntityPlayerSP thePlayer = entityPlayerSP;
        thePlayer.field_70159_w = -Math.sin(yaw) * (double)speed;
        thePlayer.field_70179_y = Math.cos(yaw) * (double)speed;
    }

    public static /* synthetic */ void strafe$default(MovementManager movementManager, float f2, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: strafe");
        }
        if ((n2 & 1) != 0) {
            f2 = movementManager.getSpeed();
        }
        movementManager.strafe(f2);
    }

    public final double getDirection() {
        EntityPlayerSP entityPlayerSP = this.mc.field_71439_g;
        Intrinsics.checkNotNull(entityPlayerSP);
        EntityPlayerSP thePlayer = entityPlayerSP;
        float rotationYaw = thePlayer.field_70177_z;
        if (thePlayer.field_191988_bg < 0.0f) {
            rotationYaw += 180.0f;
        }
        float forward = 1.0f;
        if (thePlayer.field_191988_bg < 0.0f) {
            forward = -0.5f;
        } else if (thePlayer.field_191988_bg > 0.0f) {
            forward = 0.5f;
        }
        if (thePlayer.field_70702_br > 0.0f) {
            rotationYaw -= 90.0f * forward;
        }
        if (thePlayer.field_70702_br < 0.0f) {
            rotationYaw += 90.0f * forward;
        }
        return Math.toRadians(rotationYaw);
    }

    public final void handleVanillaKickBypass() {
        EntityPlayerSP entityPlayerSP = this.mc.field_71439_g;
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        NetHandlerPlayClient netHandlerPlayClient = this.mc.func_147114_u();
        if (netHandlerPlayClient == null) {
            return;
        }
        NetHandlerPlayClient connection = netHandlerPlayClient;
        double ground = this.calculateGround();
        MovementManager $this$handleVanillaKickBypass_u24lambda_u243 = this;
        boolean bl2 = false;
        for (double posY = player.field_70163_u; posY > ground; posY -= 8.0) {
            connection.func_147297_a((Packet)new CPacketPlayer.Position(player.field_70165_t, posY, player.field_70161_v, true));
            if (posY - 8.0 < ground) break;
        }
        connection.func_147297_a((Packet)new CPacketPlayer.Position(player.field_70165_t, ground, player.field_70161_v, true));
        for (double posY = ground; posY < player.field_70163_u; posY += 8.0) {
            connection.func_147297_a((Packet)new CPacketPlayer.Position(player.field_70165_t, posY, player.field_70161_v, true));
            if (posY + 8.0 > player.field_70163_u) break;
        }
        connection.func_147297_a((Packet)new CPacketPlayer.Position(player.field_70165_t, player.field_70163_u, player.field_70161_v, true));
    }

    private final double calculateGround() {
        EntityPlayerSP entityPlayerSP = this.mc.field_71439_g;
        if (entityPlayerSP == null) {
            return 0.0;
        }
        EntityPlayerSP player = entityPlayerSP;
        WorldClient worldClient = this.mc.field_71441_e;
        if (worldClient == null) {
            return 0.0;
        }
        WorldClient world = worldClient;
        AxisAlignedBB playerBoundingBox = player.func_174813_aQ();
        double blockHeight = 1.0;
        for (double ground = player.field_70163_u; ground > 0.0; ground -= blockHeight) {
            AxisAlignedBB customBox = new AxisAlignedBB(playerBoundingBox.field_72336_d, ground + blockHeight, playerBoundingBox.field_72334_f, playerBoundingBox.field_72340_a, ground, playerBoundingBox.field_72339_c);
            if (!world.func_72829_c(customBox)) continue;
            if (blockHeight <= 0.05) {
                return ground + blockHeight;
            }
            ground += blockHeight;
            blockHeight = 0.05;
        }
        return 0.0;
    }

    public final void move(float speed) {
        EntityPlayerSP entityPlayerSP = this.mc.field_71439_g;
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        if (!MovementManager.isMoving$default(this, false, 1, null)) {
            return;
        }
        double yaw = this.getDirection();
        player.field_70159_w += -Math.sin(yaw) * (double)speed;
        player.field_70179_y += Math.cos(yaw) * (double)speed;
    }
}

