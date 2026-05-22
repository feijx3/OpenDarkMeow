/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.criticals.grim;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.controller.ControllerUseEntityAttackEvent;
import net.ccbluex.liquidbounce.features.module.modules.combat.criticals.CriticalsMode;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/criticals/grim/GrimOldPacketCriticals;", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/criticals/CriticalsMode;", "<init>", "()V", "attacks", "", "getAttacks", "()I", "setAttacks", "(I)V", "onEnable", "", "onControllerUseEntityAttack", "event", "Lnet/ccbluex/liquidbounce/event/events/controller/ControllerUseEntityAttackEvent;", "DarkMeow"})
public final class GrimOldPacketCriticals
extends CriticalsMode {
    private int attacks;

    public GrimOldPacketCriticals() {
        super("GrimOldPacket");
    }

    public final int getAttacks() {
        return this.attacks;
    }

    public final void setAttacks(int n2) {
        this.attacks = n2;
    }

    @Override
    public void onEnable() {
        this.attacks = 0;
    }

    @EventTarget
    public final void onControllerUseEntityAttack(@NotNull ControllerUseEntityAttackEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getTarget() instanceof EntityLivingBase) {
            int n2 = this.attacks;
            this.attacks = n2 + 1;
            if (this.attacks > 6) {
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
                connection.func_147297_a((Packet)new CPacketPlayer.Position(player.field_70165_t, player.field_70163_u + 0.01, player.field_70161_v, false));
                connection.func_147297_a((Packet)new CPacketPlayer.Position(player.field_70165_t, player.field_70163_u + 1.0E-10, player.field_70161_v, false));
                connection.func_147297_a((Packet)new CPacketPlayer.Position(player.field_70165_t, player.field_70163_u, player.field_70161_v, false));
                this.attacks = 0;
            }
        }
    }
}

