/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.inventory.ClickType
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.controller;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2={"Lnet/ccbluex/liquidbounce/event/events/controller/ControllerWindowClickEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "windowId", "", "slotId", "mouseButton", "type", "Lnet/minecraft/inventory/ClickType;", "<init>", "(Lnet/minecraft/entity/player/EntityPlayer;IIILnet/minecraft/inventory/ClickType;)V", "getPlayer", "()Lnet/minecraft/entity/player/EntityPlayer;", "getWindowId", "()I", "getSlotId", "getMouseButton", "getType", "()Lnet/minecraft/inventory/ClickType;", "DarkMeow"})
public final class ControllerWindowClickEvent
extends CancellableEvent {
    @NotNull
    private final EntityPlayer player;
    private final int windowId;
    private final int slotId;
    private final int mouseButton;
    @NotNull
    private final ClickType type;

    public ControllerWindowClickEvent(@NotNull EntityPlayer player, int windowId, int slotId, int mouseButton, @NotNull ClickType type) {
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(type, "type");
        this.player = player;
        this.windowId = windowId;
        this.slotId = slotId;
        this.mouseButton = mouseButton;
        this.type = type;
    }

    @NotNull
    public final EntityPlayer getPlayer() {
        return this.player;
    }

    public final int getWindowId() {
        return this.windowId;
    }

    public final int getSlotId() {
        return this.slotId;
    }

    public final int getMouseButton() {
        return this.mouseButton;
    }

    @NotNull
    public final ClickType getType() {
        return this.type;
    }
}

