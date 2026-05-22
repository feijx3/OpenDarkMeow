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
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\r\u00a8\u0006\u0015"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/event/GAppleDoEatPreEvent;", "", "selectSlot", "", "prevSlot", "travelMode", "Lnet/ccbluex/liquidbounce/features/module/modules/player/GApple$TravelMode;", "eatTick", "<init>", "(IILnet/ccbluex/liquidbounce/features/module/modules/player/GApple$TravelMode;I)V", "getSelectSlot", "()I", "setSelectSlot", "(I)V", "getPrevSlot", "getTravelMode", "()Lnet/ccbluex/liquidbounce/features/module/modules/player/GApple$TravelMode;", "setTravelMode", "(Lnet/ccbluex/liquidbounce/features/module/modules/player/GApple$TravelMode;)V", "getEatTick", "setEatTick", "DarkMeow"})
public final class GAppleDoEatPreEvent {
    private int selectSlot;
    private final int prevSlot;
    @NotNull
    private GApple.TravelMode travelMode;
    private int eatTick;

    public GAppleDoEatPreEvent(int selectSlot, int prevSlot, @NotNull GApple.TravelMode travelMode, int eatTick) {
        Intrinsics.checkNotNullParameter((Object)travelMode, "travelMode");
        this.selectSlot = selectSlot;
        this.prevSlot = prevSlot;
        this.travelMode = travelMode;
        this.eatTick = eatTick;
    }

    public final int getSelectSlot() {
        return this.selectSlot;
    }

    public final void setSelectSlot(int n2) {
        this.selectSlot = n2;
    }

    public final int getPrevSlot() {
        return this.prevSlot;
    }

    @NotNull
    public final GApple.TravelMode getTravelMode() {
        return this.travelMode;
    }

    public final void setTravelMode(@NotNull GApple.TravelMode travelMode) {
        Intrinsics.checkNotNullParameter((Object)travelMode, "<set-?>");
        this.travelMode = travelMode;
    }

    public final int getEatTick() {
        return this.eatTick;
    }

    public final void setEatTick(int n2) {
        this.eatTick = n2;
    }
}

