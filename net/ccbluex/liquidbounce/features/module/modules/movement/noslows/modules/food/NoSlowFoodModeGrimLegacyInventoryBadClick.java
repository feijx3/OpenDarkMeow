/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  net.minecraft.init.Blocks
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketClickWindow
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.noslows.modules.food;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.features.module.modules.movement.noslows.modules.base.NoSlowBaseModeGrimACLegacy;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketClickWindow;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/food/NoSlowFoodModeGrimLegacyInventoryBadClick;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/base/NoSlowBaseModeGrimACLegacy;", "<init>", "()V", "stopSprintTick", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "applyNoSlow", "", "Lnet/darkmeow/darkmeow/event/listenable/SafeListenerBase;", "getStopSprintTick", "", "DarkMeow"})
public final class NoSlowFoodModeGrimLegacyInventoryBadClick
extends NoSlowBaseModeGrimACLegacy {
    @JvmField
    @NotNull
    public final IntegerValue stopSprintTick = new IntegerValue("StopSprintTick", 1, new IntRange(0, 10));

    public NoSlowFoodModeGrimLegacyInventoryBadClick() {
        super("GrimLegacyInventoryBadPacket");
    }

    @Override
    public void applyNoSlow(@NotNull SafeListenerBase $this$applyNoSlow) {
        Intrinsics.checkNotNullParameter($this$applyNoSlow, "<this>");
        $this$applyNoSlow.getConnection().func_147297_a((Packet)new CPacketClickWindow(0, 36, 0, ClickType.SWAP, new ItemStack(Blocks.field_180401_cv), $this$applyNoSlow.getPlayer().field_71070_bA.func_75136_a($this$applyNoSlow.getPlayer().field_71071_by)));
    }

    @Override
    public int getStopSprintTick() {
        return ((Number)this.stopSprintTick.get()).intValue();
    }
}

