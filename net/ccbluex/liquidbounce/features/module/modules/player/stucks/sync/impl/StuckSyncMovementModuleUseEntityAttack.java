/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player.stucks.sync.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.controller.ControllerUseEntityAttackEvent;
import net.ccbluex.liquidbounce.features.module.modules.player.stucks.sync.StuckModuleSyncMovement;
import net.ccbluex.liquidbounce.features.module.modules.player.stucks.sync.StuckSyncMovementModule;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/stucks/sync/impl/StuckSyncMovementModuleUseEntityAttack;", "Lnet/ccbluex/liquidbounce/features/module/modules/player/stucks/sync/StuckSyncMovementModule;", "<init>", "()V", "onControllerUseEntityAttack", "", "event", "Lnet/ccbluex/liquidbounce/event/events/controller/ControllerUseEntityAttackEvent;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nStuckSyncMovementModuleUseEntityAttack.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StuckSyncMovementModuleUseEntityAttack.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/stucks/sync/impl/StuckSyncMovementModuleUseEntityAttack\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,17:1\n1#2:18\n*E\n"})
public final class StuckSyncMovementModuleUseEntityAttack
extends StuckSyncMovementModule {
    public StuckSyncMovementModuleUseEntityAttack() {
        super("UseEntityAttack");
    }

    @EventTarget
    public final void onControllerUseEntityAttack(@NotNull ControllerUseEntityAttackEvent event) {
        StuckModuleSyncMovement stuckModuleSyncMovement;
        StuckModuleSyncMovement stuckModuleSyncMovement2;
        Intrinsics.checkNotNullParameter(event, "event");
        StuckModuleSyncMovement it = stuckModuleSyncMovement2 = this.getInstance();
        boolean bl2 = false;
        StuckModuleSyncMovement stuckModuleSyncMovement3 = stuckModuleSyncMovement = DarkMeow.INSTANCE.getCombatManager().getAllowAttackManager().lastAllow != event.getTarget() ? stuckModuleSyncMovement2 : null;
        if (stuckModuleSyncMovement != null) {
            stuckModuleSyncMovement.tryDoSyncMovement(event, this.getLinkedStatValue());
        }
    }
}

