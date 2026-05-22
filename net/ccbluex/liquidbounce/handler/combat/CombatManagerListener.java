/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.handler.combat;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.Listenable;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.event.events.controller.ControllerUseEntityAttackEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.handler.combat.CombatManager;
import net.ccbluex.liquidbounce.handler.combat.LastAttackInfo;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0010H\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0013"}, d2={"Lnet/ccbluex/liquidbounce/handler/combat/CombatManagerListener;", "Lnet/ccbluex/liquidbounce/event/Listenable;", "Lnet/ccbluex/liquidbounce/injection/forge/MinecraftInstance;", "manager", "Lnet/ccbluex/liquidbounce/handler/combat/CombatManager;", "<init>", "(Lnet/ccbluex/liquidbounce/handler/combat/CombatManager;)V", "getManager", "()Lnet/ccbluex/liquidbounce/handler/combat/CombatManager;", "onAttack", "", "event", "Lnet/ccbluex/liquidbounce/event/events/controller/ControllerUseEntityAttackEvent;", "onWorld", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "handleEvents", "", "DarkMeow"})
public final class CombatManagerListener
extends MinecraftInstance
implements Listenable {
    @NotNull
    private final CombatManager manager;

    public CombatManagerListener(@NotNull CombatManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        this.manager = manager;
    }

    @NotNull
    public final CombatManager getManager() {
        return this.manager;
    }

    @EventTarget(ignoreCanceled=true, priority=0)
    public final void onAttack(@NotNull ControllerUseEntityAttackEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        long currentUpdateId = DarkMeow.INSTANCE.getUpdateManager().getUpdateId();
        this.manager.setLastAttack(new LastAttackInfo(event.getTarget(), currentUpdateId));
    }

    @EventTarget(priority=2000)
    public final void onWorld(@NotNull WorldEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.manager.setLastAttack(null);
        this.manager.getTargetsManager().clearCache();
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.manager.getTargetsManager().onUpdate(event);
    }

    @Override
    public boolean handleEvents() {
        return true;
    }
}

