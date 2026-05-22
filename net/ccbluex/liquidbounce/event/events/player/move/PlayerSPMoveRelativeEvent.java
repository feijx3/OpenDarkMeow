/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.player.move;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0016"}, d2={"Lnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPMoveRelativeEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "strafe", "", "up", "forward", "friction", "movementYaw", "<init>", "(Lnet/minecraft/client/entity/EntityPlayerSP;FFFFF)V", "getPlayer", "()Lnet/minecraft/client/entity/EntityPlayerSP;", "getStrafe", "()F", "getUp", "getForward", "getFriction", "getMovementYaw", "setMovementYaw", "(F)V", "DarkMeow"})
public final class PlayerSPMoveRelativeEvent
extends CancellableEvent {
    @NotNull
    private final EntityPlayerSP player;
    private final float strafe;
    private final float up;
    private final float forward;
    private final float friction;
    private float movementYaw;

    public PlayerSPMoveRelativeEvent(@NotNull EntityPlayerSP player, float strafe, float up, float forward, float friction, float movementYaw) {
        Intrinsics.checkNotNullParameter(player, "player");
        this.player = player;
        this.strafe = strafe;
        this.up = up;
        this.forward = forward;
        this.friction = friction;
        this.movementYaw = movementYaw;
    }

    @NotNull
    public final EntityPlayerSP getPlayer() {
        return this.player;
    }

    public final float getStrafe() {
        return this.strafe;
    }

    public final float getUp() {
        return this.up;
    }

    public final float getForward() {
        return this.forward;
    }

    public final float getFriction() {
        return this.friction;
    }

    public final float getMovementYaw() {
        return this.movementYaw;
    }

    public final void setMovementYaw(float f2) {
        this.movementYaw = f2;
    }
}

