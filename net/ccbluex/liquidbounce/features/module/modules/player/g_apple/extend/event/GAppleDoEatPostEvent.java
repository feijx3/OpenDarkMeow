/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.player.GApple;
import net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.event.GAppleDoEatPreEvent;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\b\b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e\u00a8\u0006\u0013"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/event/GAppleDoEatPostEvent;", "", "selectSlot", "", "prevSlot", "travelMode", "Lnet/ccbluex/liquidbounce/features/module/modules/player/GApple$TravelMode;", "eatTick", "<init>", "(IILnet/ccbluex/liquidbounce/features/module/modules/player/GApple$TravelMode;I)V", "event", "Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/event/GAppleDoEatPreEvent;", "(Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/event/GAppleDoEatPreEvent;)V", "getSelectSlot", "()I", "getPrevSlot", "getTravelMode", "()Lnet/ccbluex/liquidbounce/features/module/modules/player/GApple$TravelMode;", "getEatTick", "DarkMeow"})
public final class GAppleDoEatPostEvent {
    private final int selectSlot;
    private final int prevSlot;
    @NotNull
    private final GApple.TravelMode travelMode;
    private final int eatTick;

    public GAppleDoEatPostEvent(int selectSlot, int prevSlot, @NotNull GApple.TravelMode travelMode, int eatTick) {
        Intrinsics.checkNotNullParameter((Object)travelMode, "travelMode");
        this.selectSlot = selectSlot;
        this.prevSlot = prevSlot;
        this.travelMode = travelMode;
        this.eatTick = eatTick;
    }

    public final int getSelectSlot() {
        return this.selectSlot;
    }

    public final int getPrevSlot() {
        return this.prevSlot;
    }

    @NotNull
    public final GApple.TravelMode getTravelMode() {
        return this.travelMode;
    }

    public final int getEatTick() {
        return this.eatTick;
    }

    public GAppleDoEatPostEvent(@NotNull GAppleDoEatPreEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this(event.getSelectSlot(), event.getPrevSlot(), event.getTravelMode(), event.getEatTick());
    }
}

