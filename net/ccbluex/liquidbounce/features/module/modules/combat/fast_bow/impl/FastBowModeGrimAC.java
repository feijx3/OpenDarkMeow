/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.fast_bow.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.move.PlayerSPUpdateWalkingEvent;
import net.ccbluex.liquidbounce.features.module.modules.combat.fast_bow.FastBowMode;
import net.ccbluex.liquidbounce.injection.extend.entity.ExtendEntityLivingBase;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/fast_bow/impl/FastBowModeGrimAC;", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/fast_bow/FastBowMode;", "<init>", "()V", "onPlayerSPUpdateWalkingPost", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPUpdateWalkingEvent$POST;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nFastBowModeGrimAC.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastBowModeGrimAC.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/fast_bow/impl/FastBowModeGrimAC\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,25:1\n1#2:26\n*E\n"})
public final class FastBowModeGrimAC
extends FastBowMode {
    public FastBowModeGrimAC() {
        super("GrimAC");
    }

    @EventTarget
    public final void onPlayerSPUpdateWalkingPost(@NotNull PlayerSPUpdateWalkingEvent.POST event) {
        block2: {
            EntityPlayerSP entityPlayerSP;
            EntityPlayerSP entityPlayerSP2;
            EntityPlayerSP entityPlayerSP3;
            Intrinsics.checkNotNullParameter(event, "event");
            EntityPlayerSP it = entityPlayerSP3 = event.player;
            boolean bl2 = false;
            Object object = entityPlayerSP2 = this.getInstance().shouldLaunch(it) ? entityPlayerSP3 : null;
            if (entityPlayerSP2 == null) break block2;
            EntityPlayerSP it2 = entityPlayerSP = entityPlayerSP2;
            boolean bl3 = false;
            Object object2 = entityPlayerSP3 = event.lastSyncPositionType == PlayerSPUpdateWalkingEvent.SyncPositionType.NONE ? entityPlayerSP : null;
            if (entityPlayerSP3 != null) {
                EntityPlayerSP entityPlayerSP4;
                EntityPlayerSP it3 = entityPlayerSP4 = entityPlayerSP3;
                boolean bl4 = false;
                Object object3 = entityPlayerSP = !event.isCancelled ? entityPlayerSP4 : null;
                if (entityPlayerSP != null) {
                    EntityPlayerSP $this$onPlayerSPUpdateWalkingPost_u24lambda_u243 = entityPlayerSP4 = entityPlayerSP;
                    boolean bl5 = false;
                    $this$onPlayerSPUpdateWalkingPost_u24lambda_u243.field_71174_a.func_147297_a((Packet)new CPacketPlayer($this$onPlayerSPUpdateWalkingPost_u24lambda_u243.field_70122_E));
                    int n2 = ExtendEntityLivingBase.INSTANCE.getActiveItemStackUseCount((EntityLivingBase)$this$onPlayerSPUpdateWalkingPost_u24lambda_u243);
                    ExtendEntityLivingBase.INSTANCE.setActiveItemStackUseCount((EntityLivingBase)$this$onPlayerSPUpdateWalkingPost_u24lambda_u243, n2 + -1);
                }
            }
        }
    }
}

