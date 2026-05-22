/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.features.module.modules.movement.Sprint;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="HeypixelSprint", category=ModuleCategory.FUN)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/HeypixelSprint;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "onDisable", "", "onUpdate", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "DarkMeow"})
public final class HeypixelSprint
extends Module {
    public HeypixelSprint() {
        super(null, null, null, null, 15, null);
    }

    @Override
    public void onDisable() {
        Sprint.unlockNoSprint(this.getName());
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Integer n2 = event.getUpdateId() % (long)2 == 0L ? Sprint.lockNoSprint$default(this.getName(), null, 2, null) : Sprint.unlockNoSprint(this.getName());
    }
}

