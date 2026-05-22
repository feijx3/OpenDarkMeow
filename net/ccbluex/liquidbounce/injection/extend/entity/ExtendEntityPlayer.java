/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.injection.extend.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.injection.access.entity.AccessorEntityPlayer;
import net.minecraft.entity.player.EntityPlayer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R(\u0010\u0006\u001a\u00020\u0005*\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\r\u001a\u00020\f*\u00020\u00072\u0006\u0010\u0004\u001a\u00020\f8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2={"Lnet/ccbluex/liquidbounce/injection/extend/entity/ExtendEntityPlayer;", "", "<init>", "()V", "value", "", "speedInAir", "Lnet/minecraft/entity/player/EntityPlayer;", "getSpeedInAir", "(Lnet/minecraft/entity/player/EntityPlayer;)F", "setSpeedInAir", "(Lnet/minecraft/entity/player/EntityPlayer;F)V", "", "flyToggleTimer", "getFlyToggleTimer", "(Lnet/minecraft/entity/player/EntityPlayer;)I", "setFlyToggleTimer", "(Lnet/minecraft/entity/player/EntityPlayer;I)V", "DarkMeow"})
public final class ExtendEntityPlayer {
    @NotNull
    public static final ExtendEntityPlayer INSTANCE = new ExtendEntityPlayer();

    private ExtendEntityPlayer() {
    }

    public final float getSpeedInAir(@NotNull EntityPlayer $this$speedInAir) {
        Intrinsics.checkNotNullParameter($this$speedInAir, "<this>");
        return ((AccessorEntityPlayer)$this$speedInAir).getSpeedInAir();
    }

    public final void setSpeedInAir(@NotNull EntityPlayer $this$speedInAir, float value) {
        Intrinsics.checkNotNullParameter($this$speedInAir, "<this>");
        ((AccessorEntityPlayer)$this$speedInAir).setSpeedInAir(value);
    }

    public final int getFlyToggleTimer(@NotNull EntityPlayer $this$flyToggleTimer) {
        Intrinsics.checkNotNullParameter($this$flyToggleTimer, "<this>");
        return ((AccessorEntityPlayer)$this$flyToggleTimer).getFlyToggleTimer();
    }

    public final void setFlyToggleTimer(@NotNull EntityPlayer $this$flyToggleTimer, int value) {
        Intrinsics.checkNotNullParameter($this$flyToggleTimer, "<this>");
        ((AccessorEntityPlayer)$this$flyToggleTimer).setFlyToggleTimer(value);
    }
}

