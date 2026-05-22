/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.criticals.other;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.controller.ControllerUseEntityAttackEvent;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.features.module.modules.combat.criticals.CriticalsMode;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000fH\u0007R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u0010"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/criticals/other/JumpCriticals;", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/criticals/CriticalsMode;", "<init>", "()V", "jump", "", "getJump", "()Z", "setJump", "(Z)V", "onControllerUseEntityAttack", "", "event", "Lnet/ccbluex/liquidbounce/event/events/controller/ControllerUseEntityAttackEvent;", "onUpdateMoveState", "Lnet/ccbluex/liquidbounce/event/events/input/MovementInputEvent$PRE;", "DarkMeow"})
public final class JumpCriticals
extends CriticalsMode {
    private boolean jump;

    public JumpCriticals() {
        super("Jump");
    }

    public final boolean getJump() {
        return this.jump;
    }

    public final void setJump(boolean bl2) {
        this.jump = bl2;
    }

    @EventTarget
    public final void onControllerUseEntityAttack(@NotNull ControllerUseEntityAttackEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.jump = true;
        this.getInstance().doRenderCriticals(event.getTarget());
    }

    @EventTarget
    public final void onUpdateMoveState(@NotNull MovementInputEvent.PRE event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.jump) {
            event.setKeyStateJump(true);
            this.jump = false;
        }
    }
}

