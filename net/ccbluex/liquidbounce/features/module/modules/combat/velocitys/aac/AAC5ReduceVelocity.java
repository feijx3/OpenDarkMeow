/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.velocitys.aac;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.modules.combat.velocitys.VelocityMode;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH\u0007\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/aac/AAC5ReduceVelocity;", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/VelocityMode;", "<init>", "()V", "onVelocity", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "onVelocityPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "DarkMeow"})
public final class AAC5ReduceVelocity
extends VelocityMode {
    public AAC5ReduceVelocity() {
        super("AAC5Reduce");
    }

    @EventTarget
    public final void onVelocity(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        if (player.field_70737_aN > 1 && this.getInstance().getVelocityInput()) {
            player.field_70159_w *= 0.81;
            player.field_70179_y *= 0.81;
        }
        if (this.getInstance().getVelocityInput() && (player.field_70737_aN < 5 || player.field_70122_E) && this.getInstance().getVelocityTimer().hasTimePassed(120L)) {
            this.getInstance().setVelocityInput(false);
        }
    }

    @EventTarget
    public final void onVelocityPacket(@NotNull PacketEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.getInstance().setVelocityInput(true);
    }
}

