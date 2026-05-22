/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.player.control;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/event/events/player/control/UpdateRotationStateEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "yaw", "", "pitch", "<init>", "(Lnet/minecraft/client/entity/EntityPlayerSP;FF)V", "getPlayer", "()Lnet/minecraft/client/entity/EntityPlayerSP;", "getYaw", "()F", "getPitch", "DarkMeow"})
public final class UpdateRotationStateEvent
extends CancellableEvent {
    @NotNull
    private final EntityPlayerSP player;
    private final float yaw;
    private final float pitch;

    public UpdateRotationStateEvent(@NotNull EntityPlayerSP player, float yaw, float pitch) {
        Intrinsics.checkNotNullParameter(player, "player");
        this.player = player;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    @NotNull
    public final EntityPlayerSP getPlayer() {
        return this.player;
    }

    public final float getYaw() {
        return this.yaw;
    }

    public final float getPitch() {
        return this.pitch;
    }
}

