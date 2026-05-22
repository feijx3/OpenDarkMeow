/*
 * Decompiled with CFR 0.152.
 */
package net.ccbluex.liquidbounce.event.events.render;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.event.CancellableEvent;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\f\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0016"}, d2={"Lnet/ccbluex/liquidbounce/event/events/render/RenderCameraEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "partialTick", "", "distance", "noClip", "", "thirdPersonView", "", "<init>", "(FFZI)V", "getPartialTick", "()F", "getDistance", "setDistance", "(F)V", "getNoClip", "()Z", "setNoClip", "(Z)V", "getThirdPersonView", "()I", "DarkMeow"})
public final class RenderCameraEvent
extends CancellableEvent {
    private final float partialTick;
    private float distance;
    private boolean noClip;
    private final int thirdPersonView;

    public RenderCameraEvent(float partialTick, float distance, boolean noClip, int thirdPersonView) {
        this.partialTick = partialTick;
        this.distance = distance;
        this.noClip = noClip;
        this.thirdPersonView = thirdPersonView;
    }

    public final float getPartialTick() {
        return this.partialTick;
    }

    public final float getDistance() {
        return this.distance;
    }

    public final void setDistance(float f2) {
        this.distance = f2;
    }

    public final boolean getNoClip() {
        return this.noClip;
    }

    public final void setNoClip(boolean bl2) {
        this.noClip = bl2;
    }

    public final int getThirdPersonView() {
        return this.thirdPersonView;
    }
}

