/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.INetHandlerPlayServer
 *  net.minecraft.network.play.client.CPacketConfirmTransaction
 *  net.minecraft.network.play.client.CPacketPlayer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.criticals.grim;

import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.features.module.modules.combat.criticals.CriticalsMode;
import net.ccbluex.liquidbounce.handler.combat.LastAttackInfo;
import net.ccbluex.liquidbounce.handler.movement.MovementManager;
import net.ccbluex.liquidbounce.handler.network.packet.PacketManager;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.BlinkUtils;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.play.client.CPacketConfirmTransaction;
import net.minecraft.network.play.client.CPacketPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\b\u0010\u0015\u001a\u00020\tH\u0002J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000bH\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/criticals/grim/GrimBlinkCriticals;", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/criticals/CriticalsMode;", "<init>", "()V", "activeTickBeforeAttackValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "getActiveTickBeforeAttackValue", "()Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "pausing", "", "firstGroundPlayerPacket", "Lnet/minecraft/network/play/client/CPacketPlayer;", "packets", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lnet/minecraft/network/Packet;", "Lnet/minecraft/network/play/INetHandlerPlayServer;", "onDisable", "", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "isInCombat", "canPause", "packet", "stopPause", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nGrimBlinkCriticals.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GrimBlinkCriticals.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/criticals/grim/GrimBlinkCriticals\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,66:1\n1869#2,2:67\n*S KotlinDebug\n*F\n+ 1 GrimBlinkCriticals.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/criticals/grim/GrimBlinkCriticals\n*L\n62#1:67,2\n*E\n"})
public final class GrimBlinkCriticals
extends CriticalsMode {
    @NotNull
    private final IntegerValue activeTickBeforeAttackValue = new IntegerValue(this.getValuePrefix() + "ActiveTickBeforeAttack", 40, 1, 100);
    private boolean pausing;
    @Nullable
    private CPacketPlayer firstGroundPlayerPacket;
    @NotNull
    private final LinkedBlockingQueue<Packet<INetHandlerPlayServer>> packets = new LinkedBlockingQueue();

    public GrimBlinkCriticals() {
        super("GrimBlink");
    }

    @NotNull
    public final IntegerValue getActiveTickBeforeAttackValue() {
        return this.activeTickBeforeAttackValue;
    }

    @Override
    public void onDisable() {
        this.stopPause();
    }

    @EventTarget
    public final void onPacket(@NotNull PacketEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.isCancelled() || BlinkUtils.INSTANCE.getState()) {
            return;
        }
        Packet<?> packet = event.getPacket();
        Object object = packet instanceof Packet ? packet : null;
        if (object == null) {
            return;
        }
        Packet<?> packet2 = object;
        if (packet2 instanceof CPacketConfirmTransaction) {
            if (this.pausing) {
                this.packets.add(packet2);
                event.cancelEvent();
            }
        } else if (packet2 instanceof CPacketPlayer) {
            if (!this.pausing && this.canPause((CPacketPlayer)packet2)) {
                this.pausing = true;
            }
            if (this.pausing) {
                if (!this.canPause((CPacketPlayer)packet2)) {
                    this.stopPause();
                    return;
                }
                this.packets.add(packet2);
                event.cancelEvent();
            }
        }
    }

    private final boolean isInCombat() {
        LastAttackInfo lastAttackInfo = DarkMeow.INSTANCE.getCombatManager().getLastAttack();
        return (lastAttackInfo != null ? lastAttackInfo.getUpdateId() : 0L) + (long)((Number)this.activeTickBeforeAttackValue.get()).intValue() > DarkMeow.INSTANCE.getUpdateManager().getUpdateId();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean canPause(CPacketPlayer packet) {
        if (MovementManager.isMoving$default(DarkMeow.INSTANCE.getMovementManager(), false, 1, null)) return false;
        if (!packet.func_149465_i()) {
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (!Intrinsics.areEqual(entityPlayerSP != null ? Float.valueOf(entityPlayerSP.field_70143_R) : null, 0.0f)) return false;
        }
        if (!this.isInCombat()) return false;
        return true;
    }

    private final void stopPause() {
        Iterable $this$forEach$iv = this.packets;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Packet it = (Packet)element$iv;
            boolean bl2 = false;
            PacketManager packetManager = DarkMeow.INSTANCE.getNetworkManager().packetManager;
            Intrinsics.checkNotNull(it);
            PacketManager.sendPacket$default(packetManager, it, true, null, 4, null);
        }
        this.packets.clear();
        this.pausing = false;
    }
}

