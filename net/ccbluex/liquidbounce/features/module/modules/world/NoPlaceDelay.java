/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.world;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.tick.TickProcessKeyBindsEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="NoPlaceDelay", category=ModuleCategory.WORLD)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/NoPlaceDelay;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "onTickProcessKeyBinds", "", "event", "Lnet/ccbluex/liquidbounce/event/events/tick/TickProcessKeyBindsEvent;", "DarkMeow"})
public final class NoPlaceDelay
extends Module {
    public NoPlaceDelay() {
        super(null, null, null, null, 15, null);
    }

    @EventTarget
    public final void onTickProcessKeyBinds(@NotNull TickProcessKeyBindsEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        event.setAllowProcessRightClickBypassDelay(true);
    }
}

