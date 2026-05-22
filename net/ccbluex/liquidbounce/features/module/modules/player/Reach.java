/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.control.UpdateMouseOverEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="Reach", category=ModuleCategory.PLAYER)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/Reach;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "entityRangeValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "blockRangeValue", "stuckEntityRangeValue", "stuckBlockRangeValue", "onUpdateMouseOver", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/control/UpdateMouseOverEvent$PRE;", "DarkMeow"})
public final class Reach
extends Module {
    @NotNull
    private final FloatValue entityRangeValue = new FloatValue("EntityRange", 3.04f, 0.0f, 8.0f);
    @NotNull
    private final FloatValue blockRangeValue = new FloatValue("BlockRange", 4.6f, 0.0f, 8.0f);
    @NotNull
    private final FloatValue stuckEntityRangeValue = new FloatValue("StuckEntityRange", 3.0f, 0.0f, 8.0f);
    @NotNull
    private final FloatValue stuckBlockRangeValue = new FloatValue("StuckBlockRange", 5.0f, 0.0f, 8.0f);

    public Reach() {
        super(null, null, null, null, 15, null);
    }

    @EventTarget(priority=2000)
    public final void onUpdateMouseOver(@NotNull UpdateMouseOverEvent.PRE event) {
        Intrinsics.checkNotNullParameter(event, "event");
        event.setEntityRange(DarkMeow.INSTANCE.getMovementManager().getStuckManager().isInStuck() ? ((Number)this.stuckEntityRangeValue.get()).floatValue() : ((Number)this.entityRangeValue.get()).floatValue());
        event.setBlockRange(DarkMeow.INSTANCE.getMovementManager().getStuckManager().isInStuck() ? ((Number)this.stuckBlockRangeValue.get()).floatValue() : ((Number)this.blockRangeValue.get()).floatValue());
    }
}

