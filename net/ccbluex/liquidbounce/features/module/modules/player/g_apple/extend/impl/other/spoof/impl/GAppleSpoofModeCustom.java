/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.inventory.ClickType
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.impl.other.spoof.impl;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.impl.other.spoof.impl.GAppleSpoofModeInventoryClickBase;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0014\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/impl/other/spoof/impl/GAppleSpoofModeCustom;", "Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/impl/other/spoof/impl/GAppleSpoofModeInventoryClickBase;", "<init>", "()V", "countValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "minStartCount", "", "pre", "", "Lnet/darkmeow/darkmeow/event/listenable/SafeListenerBase;", "slot", "DarkMeow"})
public final class GAppleSpoofModeCustom
extends GAppleSpoofModeInventoryClickBase {
    @JvmField
    @NotNull
    public final IntegerValue countValue = new IntegerValue("Count", 0, new IntRange(0, 5));

    public GAppleSpoofModeCustom() {
        super("Custom");
    }

    @Override
    public int minStartCount() {
        return ((Number)this.countValue.get()).intValue() + 1;
    }

    @Override
    public void pre(@NotNull SafeListenerBase $this$pre, int slot) {
        Intrinsics.checkNotNullParameter($this$pre, "<this>");
        $this$pre.getPlayerController().func_187098_a(0, slot + 36, 0, ClickType.PICKUP, (EntityPlayer)$this$pre.getPlayer());
        int n2 = RangesKt.coerceAtMost(((Number)this.countValue.get()).intValue() + 1, $this$pre.getPlayer().field_71071_by.func_70445_o().func_190916_E());
        int n3 = 0;
        while (n3 < n2) {
            int it = n3++;
            boolean bl2 = false;
            $this$pre.getPlayerController().func_187098_a(0, slot + 36, 1, ClickType.PICKUP, (EntityPlayer)$this$pre.getPlayer());
        }
    }
}

