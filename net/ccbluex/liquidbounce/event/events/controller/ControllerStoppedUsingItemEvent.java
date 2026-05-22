/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.controller;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.minecraft.entity.player.EntityPlayer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/event/events/controller/ControllerStoppedUsingItemEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "<init>", "(Lnet/minecraft/entity/player/EntityPlayer;)V", "getPlayer", "()Lnet/minecraft/entity/player/EntityPlayer;", "DarkMeow"})
public final class ControllerStoppedUsingItemEvent
extends CancellableEvent {
    @NotNull
    private final EntityPlayer player;

    public ControllerStoppedUsingItemEvent(@NotNull EntityPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        this.player = player;
    }

    @NotNull
    public final EntityPlayer getPlayer() {
        return this.player;
    }
}

