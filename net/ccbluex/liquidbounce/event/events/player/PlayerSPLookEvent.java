/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.player;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.ChangeValueEvent;
import net.ccbluex.liquidbounce.handler.rotation.data.Rotation;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/event/events/player/PlayerSPLookEvent;", "Lnet/ccbluex/liquidbounce/event/ChangeValueEvent;", "Lnet/ccbluex/liquidbounce/handler/rotation/data/Rotation;", "value", "partialTicks", "", "<init>", "(Lnet/ccbluex/liquidbounce/handler/rotation/data/Rotation;F)V", "getPartialTicks", "()F", "DarkMeow"})
public final class PlayerSPLookEvent
extends ChangeValueEvent<Rotation> {
    private final float partialTicks;

    public PlayerSPLookEvent(@NotNull Rotation value, float partialTicks) {
        Intrinsics.checkNotNullParameter(value, "value");
        super(value);
        this.partialTicks = partialTicks;
    }

    public final float getPartialTicks() {
        return this.partialTicks;
    }
}

