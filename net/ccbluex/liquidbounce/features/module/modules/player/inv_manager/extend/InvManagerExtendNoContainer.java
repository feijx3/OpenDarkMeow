/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  net.minecraft.client.entity.EntityPlayerSP
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.extend;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.InvManagerExtend;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.enums.InvManagerEnumPreExecuteAction;
import net.ccbluex.liquidbounce.utils.timer.delay.MSDelay;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0012"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/extend/InvManagerExtendNoContainer;", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/InvManagerExtend;", "<init>", "()V", "extendDelayValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "timer", "Lnet/ccbluex/liquidbounce/utils/timer/delay/MSDelay;", "getTimer", "()Lnet/ccbluex/liquidbounce/utils/timer/delay/MSDelay;", "onMovementInput", "", "event", "Lnet/ccbluex/liquidbounce/event/events/input/MovementInputEvent$PRE;", "preExecute", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/enums/InvManagerEnumPreExecuteAction;", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "DarkMeow"})
public final class InvManagerExtendNoContainer
extends InvManagerExtend {
    @JvmField
    @NotNull
    public final IntegerValue extendDelayValue = new IntegerValue("ExtendDelay", 100, new IntRange(0, 2000));
    @NotNull
    private final MSDelay timer = new MSDelay();

    public InvManagerExtendNoContainer() {
        super("NoContainer", true);
    }

    @NotNull
    public final MSDelay getTimer() {
        return this.timer;
    }

    @EventTarget
    public final void onMovementInput(@NotNull MovementInputEvent.PRE event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (DarkMeow.INSTANCE.getInventoryManager().getContainerManager().hasOpenContainer()) {
            this.timer.reset(this.extendDelayValue);
        }
    }

    @Override
    @Nullable
    public InvManagerEnumPreExecuteAction preExecute(@NotNull EntityPlayerSP player) {
        Intrinsics.checkNotNullParameter(player, "player");
        if (!MSDelay.hasPassed$default(this.timer, 0L, 1, null)) {
            return InvManagerEnumPreExecuteAction.CANCEL;
        }
        return null;
    }
}

