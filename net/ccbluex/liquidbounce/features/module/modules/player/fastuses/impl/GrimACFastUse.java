/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player.fastuses.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.event.events.player.control.UpdateMouseOverEvent;
import net.ccbluex.liquidbounce.features.module.modules.player.fastuses.FastUseMode;
import net.ccbluex.liquidbounce.injection.extend.ExtendTimer;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/fastuses/impl/GrimACFastUse;", "Lnet/ccbluex/liquidbounce/features/module/modules/player/fastuses/FastUseMode;", "<init>", "()V", "grimTimerValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "lastUse", "", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "onUpdateMouseOver", "Lnet/ccbluex/liquidbounce/event/events/player/control/UpdateMouseOverEvent$PRE;", "onDisable", "DarkMeow"})
public final class GrimACFastUse
extends FastUseMode {
    @NotNull
    private final FloatValue grimTimerValue = new FloatValue(this.getValuePrefix() + "Timer", 0.5f, 0.1f, 0.5f);
    private boolean lastUse;

    public GrimACFastUse() {
        super("GrimAC");
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc.getConnection();
        if (netHandlerPlayClient == null) {
            return;
        }
        NetHandlerPlayClient connection = netHandlerPlayClient;
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        if (this.getInstance().isActive() && DarkMeow.INSTANCE.getMovementManager().isMoving(true)) {
            ExtendTimer.INSTANCE.setTimerSpeed(MinecraftInstance.mc.getTimer(), ((Number)this.grimTimerValue.get()).floatValue());
            connection.func_147297_a((Packet)new CPacketPlayer(player.field_70122_E));
            this.lastUse = true;
        } else if (this.lastUse) {
            this.onDisable();
            this.lastUse = false;
        }
    }

    @EventTarget
    public final void onUpdateMouseOver(@NotNull UpdateMouseOverEvent.PRE event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (ExtendTimer.INSTANCE.getTimerSpeed(MinecraftInstance.mc.getTimer()) == ((Number)this.grimTimerValue.get()).floatValue()) {
            event.setNoBlockInteract(true);
        }
    }

    @Override
    public void onDisable() {
        ExtendTimer.INSTANCE.setTimerSpeed(MinecraftInstance.mc.getTimer(), 1.0f);
    }
}

