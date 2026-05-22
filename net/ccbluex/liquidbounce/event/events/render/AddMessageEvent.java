/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.text.ITextComponent
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.render;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.minecraft.util.text.ITextComponent;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/event/events/render/AddMessageEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "message", "Lnet/minecraft/util/text/ITextComponent;", "lineId", "", "<init>", "(Lnet/minecraft/util/text/ITextComponent;I)V", "getMessage", "()Lnet/minecraft/util/text/ITextComponent;", "getLineId", "()I", "DarkMeow"})
public final class AddMessageEvent
extends CancellableEvent {
    @NotNull
    private final ITextComponent message;
    private final int lineId;

    public AddMessageEvent(@NotNull ITextComponent message, int lineId) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.message = message;
        this.lineId = lineId;
    }

    @NotNull
    public final ITextComponent getMessage() {
        return this.message;
    }

    public final int getLineId() {
        return this.lineId;
    }
}

