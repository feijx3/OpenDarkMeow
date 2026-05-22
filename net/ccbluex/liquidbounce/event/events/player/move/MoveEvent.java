/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.MoverType
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.player.move;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.minecraft.entity.MoverType;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018\u00a8\u0006\u001f"}, d2={"Lnet/ccbluex/liquidbounce/event/events/player/move/MoveEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "type", "Lnet/minecraft/entity/MoverType;", "x", "", "y", "z", "<init>", "(Lnet/minecraft/entity/MoverType;DDD)V", "getType", "()Lnet/minecraft/entity/MoverType;", "getX", "()D", "setX", "(D)V", "getY", "setY", "getZ", "setZ", "isSafeWalk", "", "()Z", "setSafeWalk", "(Z)V", "noAutoJump", "getNoAutoJump", "setNoAutoJump", "zero", "", "zeroXZ", "DarkMeow"})
public final class MoveEvent
extends CancellableEvent {
    @NotNull
    private final MoverType type;
    private double x;
    private double y;
    private double z;
    private boolean isSafeWalk;
    private boolean noAutoJump;

    public MoveEvent(@NotNull MoverType type, double x2, double y2, double z2) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.x = x2;
        this.y = y2;
        this.z = z2;
    }

    @NotNull
    public final MoverType getType() {
        return this.type;
    }

    public final double getX() {
        return this.x;
    }

    public final void setX(double d2) {
        this.x = d2;
    }

    public final double getY() {
        return this.y;
    }

    public final void setY(double d2) {
        this.y = d2;
    }

    public final double getZ() {
        return this.z;
    }

    public final void setZ(double d2) {
        this.z = d2;
    }

    public final boolean isSafeWalk() {
        return this.isSafeWalk;
    }

    public final void setSafeWalk(boolean bl2) {
        this.isSafeWalk = bl2;
    }

    public final boolean getNoAutoJump() {
        return this.noAutoJump;
    }

    public final void setNoAutoJump(boolean bl2) {
        this.noAutoJump = bl2;
    }

    public final void zero() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }

    public final void zeroXZ() {
        this.x = 0.0;
        this.z = 0.0;
    }
}

