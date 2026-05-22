/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.RayTraceResult
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.controller;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2={"Lnet/ccbluex/liquidbounce/event/events/controller/ControllerUseEntityInteractAtEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "target", "Lnet/minecraft/entity/Entity;", "ray", "Lnet/minecraft/util/math/RayTraceResult;", "hand", "Lnet/minecraft/util/EnumHand;", "<init>", "(Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/entity/Entity;Lnet/minecraft/util/math/RayTraceResult;Lnet/minecraft/util/EnumHand;)V", "getPlayer", "()Lnet/minecraft/entity/player/EntityPlayer;", "getTarget", "()Lnet/minecraft/entity/Entity;", "getRay", "()Lnet/minecraft/util/math/RayTraceResult;", "getHand", "()Lnet/minecraft/util/EnumHand;", "DarkMeow"})
public final class ControllerUseEntityInteractAtEvent
extends CancellableEvent {
    @NotNull
    private final EntityPlayer player;
    @NotNull
    private final Entity target;
    @NotNull
    private final RayTraceResult ray;
    @NotNull
    private final EnumHand hand;

    public ControllerUseEntityInteractAtEvent(@NotNull EntityPlayer player, @NotNull Entity target, @NotNull RayTraceResult ray, @NotNull EnumHand hand) {
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(ray, "ray");
        Intrinsics.checkNotNullParameter(hand, "hand");
        this.player = player;
        this.target = target;
        this.ray = ray;
        this.hand = hand;
    }

    @NotNull
    public final EntityPlayer getPlayer() {
        return this.player;
    }

    @NotNull
    public final Entity getTarget() {
        return this.target;
    }

    @NotNull
    public final RayTraceResult getRay() {
        return this.ray;
    }

    @NotNull
    public final EnumHand getHand() {
        return this.hand;
    }
}

