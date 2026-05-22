/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.velocitys.grim;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.move.PlayerSPVelocityEvent;
import net.ccbluex.liquidbounce.features.module.modules.combat.velocitys.VelocityMode;
import net.ccbluex.liquidbounce.handler.movement.MovementManager;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/grim/VelocityModeGrimAirBorne;", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/VelocityMode;", "<init>", "()V", "forward", "", "jump", "onVelocity", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPVelocityEvent;", "DarkMeow"})
public final class VelocityModeGrimAirBorne
extends VelocityMode {
    private boolean forward;
    private boolean jump;

    public VelocityModeGrimAirBorne() {
        super("GrimAirBorne");
    }

    @EventTarget(ignoreCanceled=true)
    public final void onVelocity(@NotNull PlayerSPVelocityEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        if (!MovementManager.isMoving$default(DarkMeow.INSTANCE.getMovementManager(), false, 1, null) || player.func_70093_af() || player.func_70027_ad() || DarkMeow.INSTANCE.getMovementManager().getStuckManager().isInStuck() || player.func_70090_H() || player.func_180799_ab()) {
            return;
        }
        if (player.field_70737_aN > 0) {
            player.field_70159_w += -1.0E-7;
            player.field_70181_x += -1.0E-7;
            player.field_70179_y += -1.0E-7;
            player.field_70160_al = true;
        }
    }
}

