/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.move.BlockSlimeBounceEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="AntiBounce", category=ModuleCategory.MOVEMENT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/AntiBounce;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "onBlockSlimeBounce", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/move/BlockSlimeBounceEvent;", "DarkMeow"})
public final class AntiBounce
extends Module {
    public AntiBounce() {
        super(null, null, null, null, 15, null);
    }

    @EventTarget
    public final void onBlockSlimeBounce(@NotNull BlockSlimeBounceEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        event.cancelEvent();
    }
}

