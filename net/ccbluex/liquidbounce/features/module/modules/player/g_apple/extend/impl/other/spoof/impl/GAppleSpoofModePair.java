/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.inventory.ClickType
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.impl.other.spoof.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.impl.other.spoof.impl.GAppleSpoofModeInventoryClickBase;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/impl/other/spoof/impl/GAppleSpoofModePair;", "Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/impl/other/spoof/impl/GAppleSpoofModeInventoryClickBase;", "<init>", "()V", "minStartCount", "", "pre", "", "Lnet/darkmeow/darkmeow/event/listenable/SafeListenerBase;", "slot", "DarkMeow"})
public final class GAppleSpoofModePair
extends GAppleSpoofModeInventoryClickBase {
    public GAppleSpoofModePair() {
        super("Pair");
    }

    @Override
    public int minStartCount() {
        return 1;
    }

    @Override
    public void pre(@NotNull SafeListenerBase $this$pre, int slot) {
        Intrinsics.checkNotNullParameter($this$pre, "<this>");
        $this$pre.getPlayerController().func_187098_a(0, slot + 36, 1, ClickType.PICKUP, (EntityPlayer)$this$pre.getPlayer());
    }
}

