/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.fast_bow.impl;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.move.PlayerSPUpdateWalkingEvent;
import net.ccbluex.liquidbounce.features.module.modules.combat.fast_bow.FastBowMode;
import net.ccbluex.liquidbounce.injection.extend.entity.ExtendEntityLivingBase;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/fast_bow/impl/FastBowModePacket;", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/fast_bow/FastBowMode;", "<init>", "()V", "countValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "onPlayerSPUpdateWalkingPost", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPUpdateWalkingEvent$POST;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nFastBowModePacket.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastBowModePacket.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/fast_bow/impl/FastBowModePacket\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,29:1\n1#2:30\n*E\n"})
public final class FastBowModePacket
extends FastBowMode {
    @JvmField
    @NotNull
    public final IntegerValue countValue = new IntegerValue("Count", 2, new IntRange(1, 20));

    public FastBowModePacket() {
        super("Packet");
    }

    @EventTarget
    public final void onPlayerSPUpdateWalkingPost(@NotNull PlayerSPUpdateWalkingEvent.POST event) {
        EntityPlayerSP entityPlayerSP;
        EntityPlayerSP entityPlayerSP2;
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP it = entityPlayerSP2 = event.player;
        boolean bl2 = false;
        Object object = entityPlayerSP = this.getInstance().shouldLaunch(it) ? entityPlayerSP2 : null;
        if (entityPlayerSP != null) {
            EntityPlayerSP $this$onPlayerSPUpdateWalkingPost_u24lambda_u242 = entityPlayerSP2 = entityPlayerSP;
            boolean bl3 = false;
            int n2 = ((Number)this.countValue.get()).intValue();
            int n3 = 0;
            while (n3 < n2) {
                int it2 = n3++;
                boolean bl4 = false;
                $this$onPlayerSPUpdateWalkingPost_u24lambda_u242.field_71174_a.func_147297_a((Packet)new CPacketPlayer($this$onPlayerSPUpdateWalkingPost_u24lambda_u242.field_70122_E));
                int n4 = ExtendEntityLivingBase.INSTANCE.getActiveItemStackUseCount((EntityLivingBase)$this$onPlayerSPUpdateWalkingPost_u24lambda_u242);
                ExtendEntityLivingBase.INSTANCE.setActiveItemStackUseCount((EntityLivingBase)$this$onPlayerSPUpdateWalkingPost_u24lambda_u242, n4 + -1);
            }
        }
    }
}

