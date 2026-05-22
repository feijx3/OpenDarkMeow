/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.noslows.modules.food;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.movement.noslows.modules.base.NoSlowBaseModeGrimACLegacy;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/food/NoSlowFoodModeGrimLegacyDrop;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/base/NoSlowBaseModeGrimACLegacy;", "<init>", "()V", "applyNoSlow", "", "Lnet/darkmeow/darkmeow/event/listenable/SafeListenerBase;", "DarkMeow"})
public class NoSlowFoodModeGrimLegacyDrop
extends NoSlowBaseModeGrimACLegacy {
    public NoSlowFoodModeGrimLegacyDrop() {
        super("GrimLegacyDrop");
    }

    @Override
    public void applyNoSlow(@NotNull SafeListenerBase $this$applyNoSlow) {
        Intrinsics.checkNotNullParameter($this$applyNoSlow, "<this>");
        if ($this$applyNoSlow.getPlayer().func_184600_cs() != EnumHand.MAIN_HAND) {
            return;
        }
        if ($this$applyNoSlow.getPlayer().func_184586_b($this$applyNoSlow.getPlayer().func_184600_cs()).func_190916_E() <= 1) {
            return;
        }
        $this$applyNoSlow.getConnection().func_147297_a((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.DROP_ITEM, BlockPos.field_177992_a, EnumFacing.DOWN));
    }
}

