/*
 * Decompiled with CFR 0.152.
 */
package net.ccbluex.liquidbounce.event;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.event.CancellableEvent;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n\u00a8\u0006\r"}, d2={"Lnet/ccbluex/liquidbounce/event/JumpEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "motion", "", "movementYaw", "<init>", "(FF)V", "getMotion", "()F", "setMotion", "(F)V", "getMovementYaw", "setMovementYaw", "DarkMeow"})
public final class JumpEvent
extends CancellableEvent {
    private float motion;
    private float movementYaw;

    public JumpEvent(float motion, float movementYaw) {
        this.motion = motion;
        this.movementYaw = movementYaw;
    }

    public final float getMotion() {
        return this.motion;
    }

    public final void setMotion(float f2) {
        this.motion = f2;
    }

    public final float getMovementYaw() {
        return this.movementYaw;
    }

    public final void setMovementYaw(float f2) {
        this.movementYaw = f2;
    }
}

