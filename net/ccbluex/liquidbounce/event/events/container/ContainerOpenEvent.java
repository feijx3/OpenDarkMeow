/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.container;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.Event;
import net.minecraft.client.gui.inventory.GuiContainer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/event/events/container/ContainerOpenEvent;", "Lnet/ccbluex/liquidbounce/event/Event;", "gui", "Lnet/minecraft/client/gui/inventory/GuiContainer;", "<init>", "(Lnet/minecraft/client/gui/inventory/GuiContainer;)V", "getGui", "()Lnet/minecraft/client/gui/inventory/GuiContainer;", "silent", "", "getSilent", "()Z", "setSilent", "(Z)V", "DarkMeow"})
public final class ContainerOpenEvent
extends Event {
    @NotNull
    private final GuiContainer gui;
    private boolean silent;

    public ContainerOpenEvent(@NotNull GuiContainer gui) {
        Intrinsics.checkNotNullParameter(gui, "gui");
        this.gui = gui;
    }

    @NotNull
    public final GuiContainer getGui() {
        return this.gui;
    }

    public final boolean getSilent() {
        return this.silent;
    }

    public final void setSilent(boolean bl2) {
        this.silent = bl2;
    }
}

