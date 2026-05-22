/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.anti_cobweb.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.modules.movement.anti_cobweb.AntiCobwebMode;
import net.ccbluex.liquidbounce.injection.extend.entity.ExtendEntity;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/anti_cobweb/impl/AntiCobwebModeAAC5;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/anti_cobweb/AntiCobwebMode;", "<init>", "()V", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "DarkMeow"})
public final class AntiCobwebModeAAC5
extends AntiCobwebMode {
    public AntiCobwebModeAAC5() {
        super("AAC5");
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (ExtendEntity.INSTANCE.isInWeb((Entity)event.getPlayer())) {
            event.getPlayer().field_70747_aH = 0.42f;
            DarkMeow.INSTANCE.getMovementManager().getJumpManager().jump();
        }
    }
}

