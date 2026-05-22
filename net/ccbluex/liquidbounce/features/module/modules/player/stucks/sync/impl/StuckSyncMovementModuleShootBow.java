/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemBow
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player.stucks.sync.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.controller.ControllerStoppedUsingItemEvent;
import net.ccbluex.liquidbounce.features.module.modules.player.stucks.sync.StuckSyncMovementModule;
import net.minecraft.item.ItemBow;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/stucks/sync/impl/StuckSyncMovementModuleShootBow;", "Lnet/ccbluex/liquidbounce/features/module/modules/player/stucks/sync/StuckSyncMovementModule;", "<init>", "()V", "onControllerStoppedUsingItem", "", "event", "Lnet/ccbluex/liquidbounce/event/events/controller/ControllerStoppedUsingItemEvent;", "DarkMeow"})
public final class StuckSyncMovementModuleShootBow
extends StuckSyncMovementModule {
    public StuckSyncMovementModuleShootBow() {
        super("ShootBow");
    }

    @EventTarget
    public final void onControllerStoppedUsingItem(@NotNull ControllerStoppedUsingItemEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getPlayer().func_184607_cu().func_77973_b() instanceof ItemBow) {
            this.getInstance().tryDoSyncMovement(event, this.getLinkedStatValue());
        }
    }
}

