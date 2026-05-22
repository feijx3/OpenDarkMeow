/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.render.gui;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/event/events/render/gui/RenderGuiOverlayDebugEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "left", "", "", "right", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getLeft", "()Ljava/util/List;", "getRight", "DarkMeow"})
public final class RenderGuiOverlayDebugEvent
extends CancellableEvent {
    @NotNull
    private final List<String> left;
    @NotNull
    private final List<String> right;

    public RenderGuiOverlayDebugEvent(@NotNull List<String> left, @NotNull List<String> right) {
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(right, "right");
        this.left = left;
        this.right = right;
    }

    @NotNull
    public final List<String> getLeft() {
        return this.left;
    }

    @NotNull
    public final List<String> getRight() {
        return this.right;
    }
}

