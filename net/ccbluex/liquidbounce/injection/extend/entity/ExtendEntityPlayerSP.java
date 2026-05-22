/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.injection.extend.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.injection.access.player.AccessorEntityPlayerSP;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\"\u001a\u00020#*\u00020\u0006R\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR(\u0010\u000b\u001a\u00020\n*\u00020\u00062\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0010\u001a\u00020\n*\u00020\u00062\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR(\u0010\u0014\u001a\u00020\u0013*\u00020\u00062\u0006\u0010\t\u001a\u00020\u00138F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u0019\u001a\u00020\u0013*\u00020\u00062\u0006\u0010\t\u001a\u00020\u00138F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R(\u0010\u001d\u001a\u00020\u001c*\u00020\u00062\u0006\u0010\t\u001a\u00020\u001c8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006$"}, d2={"Lnet/ccbluex/liquidbounce/injection/extend/entity/ExtendEntityPlayerSP;", "", "<init>", "()V", "mc", "Lnet/minecraft/client/Minecraft;", "Lnet/minecraft/client/entity/EntityPlayerSP;", "getMc", "(Lnet/minecraft/client/entity/EntityPlayerSP;)Lnet/minecraft/client/Minecraft;", "value", "", "serverSneakState", "getServerSneakState", "(Lnet/minecraft/client/entity/EntityPlayerSP;)Z", "setServerSneakState", "(Lnet/minecraft/client/entity/EntityPlayerSP;Z)V", "serverSprintState", "getServerSprintState", "setServerSprintState", "", "positionUpdateTicks", "getPositionUpdateTicks", "(Lnet/minecraft/client/entity/EntityPlayerSP;)I", "setPositionUpdateTicks", "(Lnet/minecraft/client/entity/EntityPlayerSP;I)V", "horseJumpPowerCounter", "getHorseJumpPowerCounter", "setHorseJumpPowerCounter", "", "horseJumpPowerI", "getHorseJumpPowerI", "(Lnet/minecraft/client/entity/EntityPlayerSP;)F", "setHorseJumpPowerI", "(Lnet/minecraft/client/entity/EntityPlayerSP;F)V", "onUpdateWalkingPlayer", "", "DarkMeow"})
public final class ExtendEntityPlayerSP {
    @NotNull
    public static final ExtendEntityPlayerSP INSTANCE = new ExtendEntityPlayerSP();

    private ExtendEntityPlayerSP() {
    }

    @NotNull
    public final Minecraft getMc(@NotNull EntityPlayerSP $this$mc) {
        Intrinsics.checkNotNullParameter($this$mc, "<this>");
        Minecraft minecraft = ((AccessorEntityPlayerSP)$this$mc).getMinecraft();
        Intrinsics.checkNotNullExpressionValue(minecraft, "getMinecraft(...)");
        return minecraft;
    }

    public final boolean getServerSneakState(@NotNull EntityPlayerSP $this$serverSneakState) {
        Intrinsics.checkNotNullParameter($this$serverSneakState, "<this>");
        return ((AccessorEntityPlayerSP)$this$serverSneakState).getServerSneakState();
    }

    public final void setServerSneakState(@NotNull EntityPlayerSP $this$serverSneakState, boolean value) {
        Intrinsics.checkNotNullParameter($this$serverSneakState, "<this>");
        ((AccessorEntityPlayerSP)$this$serverSneakState).setServerSneakState(value);
    }

    public final boolean getServerSprintState(@NotNull EntityPlayerSP $this$serverSprintState) {
        Intrinsics.checkNotNullParameter($this$serverSprintState, "<this>");
        return ((AccessorEntityPlayerSP)$this$serverSprintState).getServerSprintState();
    }

    public final void setServerSprintState(@NotNull EntityPlayerSP $this$serverSprintState, boolean value) {
        Intrinsics.checkNotNullParameter($this$serverSprintState, "<this>");
        ((AccessorEntityPlayerSP)$this$serverSprintState).setServerSprintState(value);
    }

    public final int getPositionUpdateTicks(@NotNull EntityPlayerSP $this$positionUpdateTicks) {
        Intrinsics.checkNotNullParameter($this$positionUpdateTicks, "<this>");
        return ((AccessorEntityPlayerSP)$this$positionUpdateTicks).getPositionUpdateTicks();
    }

    public final void setPositionUpdateTicks(@NotNull EntityPlayerSP $this$positionUpdateTicks, int value) {
        Intrinsics.checkNotNullParameter($this$positionUpdateTicks, "<this>");
        ((AccessorEntityPlayerSP)$this$positionUpdateTicks).setPositionUpdateTicks(value);
    }

    public final int getHorseJumpPowerCounter(@NotNull EntityPlayerSP $this$horseJumpPowerCounter) {
        Intrinsics.checkNotNullParameter($this$horseJumpPowerCounter, "<this>");
        return ((AccessorEntityPlayerSP)$this$horseJumpPowerCounter).getHorseJumpPowerCounter();
    }

    public final void setHorseJumpPowerCounter(@NotNull EntityPlayerSP $this$horseJumpPowerCounter, int value) {
        Intrinsics.checkNotNullParameter($this$horseJumpPowerCounter, "<this>");
        ((AccessorEntityPlayerSP)$this$horseJumpPowerCounter).setHorseJumpPowerCounter(value);
    }

    public final float getHorseJumpPowerI(@NotNull EntityPlayerSP $this$horseJumpPowerI) {
        Intrinsics.checkNotNullParameter($this$horseJumpPowerI, "<this>");
        return ((AccessorEntityPlayerSP)$this$horseJumpPowerI).func_110319_bJ();
    }

    public final void setHorseJumpPowerI(@NotNull EntityPlayerSP $this$horseJumpPowerI, float value) {
        Intrinsics.checkNotNullParameter($this$horseJumpPowerI, "<this>");
        ((AccessorEntityPlayerSP)$this$horseJumpPowerI).setHorseJumpPower(value);
    }

    public final void onUpdateWalkingPlayer(@NotNull EntityPlayerSP $this$onUpdateWalkingPlayer) {
        Intrinsics.checkNotNullParameter($this$onUpdateWalkingPlayer, "<this>");
        ((AccessorEntityPlayerSP)$this$onUpdateWalkingPlayer).invokeOnUpdateWalkingPlayer();
    }
}

