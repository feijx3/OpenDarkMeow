/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmOverloads
 *  net.minecraft.client.entity.EntityPlayerSP
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.player.move;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u0005H\u0007R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPVelocityEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "originMotionX", "", "originMotionY", "originMotionZ", "<init>", "(Lnet/minecraft/client/entity/EntityPlayerSP;DDD)V", "motionX", "motionY", "motionZ", "setReduceMotion", "", "xz", "y", "DarkMeow"})
public final class PlayerSPVelocityEvent
extends CancellableEvent {
    @JvmField
    @NotNull
    public final EntityPlayerSP player;
    @JvmField
    public final double originMotionX;
    @JvmField
    public final double originMotionY;
    @JvmField
    public final double originMotionZ;
    @JvmField
    public double motionX;
    @JvmField
    public double motionY;
    @JvmField
    public double motionZ;

    public PlayerSPVelocityEvent(@NotNull EntityPlayerSP player, double originMotionX, double originMotionY, double originMotionZ) {
        Intrinsics.checkNotNullParameter(player, "player");
        this.player = player;
        this.originMotionX = originMotionX;
        this.originMotionY = originMotionY;
        this.originMotionZ = originMotionZ;
        this.motionX = this.originMotionX;
        this.motionY = this.originMotionY;
        this.motionZ = this.originMotionZ;
    }

    @JvmOverloads
    public final void setReduceMotion(double xz, double y2) {
        this.motionX *= xz;
        this.motionZ *= xz;
        this.motionY *= y2;
    }

    public static /* synthetic */ void setReduceMotion$default(PlayerSPVelocityEvent playerSPVelocityEvent, double d2, double d3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            d2 = 1.0;
        }
        if ((n2 & 2) != 0) {
            d3 = 1.0;
        }
        playerSPVelocityEvent.setReduceMotion(d2, d3);
    }

    @JvmOverloads
    public final void setReduceMotion(double xz) {
        PlayerSPVelocityEvent.setReduceMotion$default(this, xz, 0.0, 2, null);
    }

    @JvmOverloads
    public final void setReduceMotion() {
        PlayerSPVelocityEvent.setReduceMotion$default(this, 0.0, 0.0, 3, null);
    }
}

