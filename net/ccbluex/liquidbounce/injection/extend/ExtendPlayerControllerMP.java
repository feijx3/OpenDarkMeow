/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.injection.extend;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.injection.access.player.AccessorPlayerControllerMP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0012\u001a\u00020\u0013*\u00020\u0007R(\u0010\u0006\u001a\u00020\u0005*\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\r\u001a\u00020\f*\u00020\u00072\u0006\u0010\u0004\u001a\u00020\f8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2={"Lnet/ccbluex/liquidbounce/injection/extend/ExtendPlayerControllerMP;", "", "<init>", "()V", "value", "", "blockHitDelay", "Lnet/minecraft/client/multiplayer/PlayerControllerMP;", "getBlockHitDelay", "(Lnet/minecraft/client/multiplayer/PlayerControllerMP;)I", "setBlockHitDelay", "(Lnet/minecraft/client/multiplayer/PlayerControllerMP;I)V", "", "curBlockDamageMP", "getCurBlockDamageMP", "(Lnet/minecraft/client/multiplayer/PlayerControllerMP;)F", "setCurBlockDamageMP", "(Lnet/minecraft/client/multiplayer/PlayerControllerMP;F)V", "syncCurrentPlayItem", "", "DarkMeow"})
public final class ExtendPlayerControllerMP {
    @NotNull
    public static final ExtendPlayerControllerMP INSTANCE = new ExtendPlayerControllerMP();

    private ExtendPlayerControllerMP() {
    }

    public final int getBlockHitDelay(@NotNull PlayerControllerMP $this$blockHitDelay) {
        Intrinsics.checkNotNullParameter($this$blockHitDelay, "<this>");
        return ((AccessorPlayerControllerMP)$this$blockHitDelay).getBlockHitDelay();
    }

    public final void setBlockHitDelay(@NotNull PlayerControllerMP $this$blockHitDelay, int value) {
        Intrinsics.checkNotNullParameter($this$blockHitDelay, "<this>");
        ((AccessorPlayerControllerMP)$this$blockHitDelay).setBlockHitDelay(value);
    }

    public final float getCurBlockDamageMP(@NotNull PlayerControllerMP $this$curBlockDamageMP) {
        Intrinsics.checkNotNullParameter($this$curBlockDamageMP, "<this>");
        return ((AccessorPlayerControllerMP)$this$curBlockDamageMP).getCurBlockDamageMP();
    }

    public final void setCurBlockDamageMP(@NotNull PlayerControllerMP $this$curBlockDamageMP, float value) {
        Intrinsics.checkNotNullParameter($this$curBlockDamageMP, "<this>");
        ((AccessorPlayerControllerMP)$this$curBlockDamageMP).setCurBlockDamageMP(value);
    }

    public final void syncCurrentPlayItem(@NotNull PlayerControllerMP $this$syncCurrentPlayItem) {
        Intrinsics.checkNotNullParameter($this$syncCurrentPlayItem, "<this>");
        ((AccessorPlayerControllerMP)$this$syncCurrentPlayItem).darkMeow_syncCurrentPlayItem();
    }
}

