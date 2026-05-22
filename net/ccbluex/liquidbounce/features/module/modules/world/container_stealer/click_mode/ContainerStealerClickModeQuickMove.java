/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.inventory.ClickType
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.world.container_stealer.click_mode;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.world.container_stealer.ContainerStealerClickMode;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\r"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/click_mode/ContainerStealerClickModeQuickMove;", "Lnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/ContainerStealerClickMode;", "<init>", "()V", "click", "", "playerController", "Lnet/minecraft/client/multiplayer/PlayerControllerMP;", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "windowId", "", "slotId", "DarkMeow"})
public final class ContainerStealerClickModeQuickMove
extends ContainerStealerClickMode {
    public ContainerStealerClickModeQuickMove() {
        super("QuickMove");
    }

    @Override
    public boolean click(@NotNull PlayerControllerMP playerController, @NotNull EntityPlayerSP player, int windowId, int slotId) {
        Intrinsics.checkNotNullParameter(playerController, "playerController");
        Intrinsics.checkNotNullParameter(player, "player");
        playerController.func_187098_a(windowId, slotId, 0, ClickType.QUICK_MOVE, (EntityPlayer)player);
        return true;
    }
}

