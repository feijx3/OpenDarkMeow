/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.settings.KeyBinding
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.autoblocks.scripts;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.controller.ControllerTryUseItemOnBlockEvent;
import net.ccbluex.liquidbounce.event.events.controller.ControllerUseEntityInteractAtEvent;
import net.ccbluex.liquidbounce.event.events.controller.ControllerUseEntityInteractEvent;
import net.ccbluex.liquidbounce.event.events.player.control.UpdateMouseOverEvent;
import net.ccbluex.liquidbounce.features.module.modules.combat.autoblocks.AutoBlockScript;
import net.ccbluex.liquidbounce.handler.combat.targets.TargetsManager;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.KeyUtils;
import net.minecraft.client.settings.KeyBinding;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH\u0007\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/autoblocks/scripts/AutoBlockScriptNoInteract;", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/autoblocks/AutoBlockScript;", "<init>", "()V", "onUpdateMouseOver", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/control/UpdateMouseOverEvent$PRE;", "onControllerTryUseItemOnBlock", "Lnet/ccbluex/liquidbounce/event/events/controller/ControllerTryUseItemOnBlockEvent;", "onControllerUseEntityInteract", "Lnet/ccbluex/liquidbounce/event/events/controller/ControllerUseEntityInteractEvent;", "onControllerUseEntityInteractAt", "Lnet/ccbluex/liquidbounce/event/events/controller/ControllerUseEntityInteractAtEvent;", "DarkMeow"})
public final class AutoBlockScriptNoInteract
extends AutoBlockScript {
    public AutoBlockScriptNoInteract() {
        super("NoInteract", false, 2, null);
    }

    @EventTarget
    public final void onUpdateMouseOver(@NotNull UpdateMouseOverEvent.PRE event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.getInstance().getBlocking()) {
            event.setNoBlockInteract(true);
        }
    }

    @EventTarget
    public final void onControllerTryUseItemOnBlock(@NotNull ControllerTryUseItemOnBlockEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.getInstance().getBlocking()) {
            event.cancelEvent();
        }
    }

    @EventTarget
    public final void onControllerUseEntityInteract(@NotNull ControllerUseEntityInteractEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.getInstance().getBlocking()) {
            KeyBinding keyBinding = MinecraftInstance.mc.getGameSettings().field_74313_G;
            Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindUseItem");
            if (!KeyUtils.INSTANCE.isKeyDownSystem(keyBinding) || !TargetsManager.isSelected$default(DarkMeow.INSTANCE.getCombatManager().getTargetsManager(), event.getTarget(), true, false, 4, null)) {
                event.cancelEvent();
            }
        }
    }

    @EventTarget
    public final void onControllerUseEntityInteractAt(@NotNull ControllerUseEntityInteractAtEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.getInstance().getBlocking()) {
            KeyBinding keyBinding = MinecraftInstance.mc.getGameSettings().field_74313_G;
            Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindUseItem");
            if (!KeyUtils.INSTANCE.isKeyDownSystem(keyBinding) || !TargetsManager.isSelected$default(DarkMeow.INSTANCE.getCombatManager().getTargetsManager(), event.getTarget(), true, false, 4, null)) {
                event.cancelEvent();
            }
        }
    }
}

