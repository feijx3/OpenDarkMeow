/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.Unpooled
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.item.ItemBow
 *  net.minecraft.network.Packet
 *  net.minecraft.network.PacketBuffer
 *  net.minecraft.network.play.client.CPacketCustomPayload
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.noslows.modules.bow;

import io.netty.buffer.Unpooled;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.move.PlayerSPUpdateWalkingEvent;
import net.ccbluex.liquidbounce.features.module.modules.movement.noslows.NoSlowSubMode;
import net.ccbluex.liquidbounce.injection.extend.ExtendKeyBinding;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.ItemBow;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.CPacketCustomPayload;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH\u0007\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/bow/NoSlowBowModeQuickMarco;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/NoSlowSubMode;", "<init>", "()V", "onSlowDown", "", "event", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "onPlayerSPUpdateWalkingPre", "Lnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPUpdateWalkingEvent$PRE;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nNoSlowBowModeQuickMarco.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoSlowBowModeQuickMarco.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/bow/NoSlowBowModeQuickMarco\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,34:1\n1#2:35\n*E\n"})
public final class NoSlowBowModeQuickMarco
extends NoSlowSubMode {
    public NoSlowBowModeQuickMarco() {
        super("QuickMarco");
    }

    @Override
    public void onSlowDown(@NotNull CancellableEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        event.cancelEvent();
    }

    @EventTarget(ignoreCanceled=true, priority=0)
    public final void onPlayerSPUpdateWalkingPre(@NotNull PlayerSPUpdateWalkingEvent.PRE event) {
        block3: {
            EntityPlayerSP entityPlayerSP;
            EntityPlayerSP entityPlayerSP2;
            Intrinsics.checkNotNullParameter(event, "event");
            EntityPlayerSP entityPlayerSP3 = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP3 == null) break block3;
            EntityPlayerSP it = entityPlayerSP2 = entityPlayerSP3;
            boolean bl2 = false;
            Object object = entityPlayerSP = event.getSyncPositionType().getPosition() ? entityPlayerSP2 : null;
            if (entityPlayerSP != null) {
                EntityPlayerSP entityPlayerSP4;
                EntityPlayerSP it2 = entityPlayerSP4 = entityPlayerSP;
                boolean bl3 = false;
                KeyBinding keyBinding = MinecraftInstance.mc.getGameSettings().field_74313_G;
                Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindUseItem");
                Object object2 = entityPlayerSP2 = ExtendKeyBinding.INSTANCE.getPressed(keyBinding) ? entityPlayerSP4 : null;
                if (entityPlayerSP2 != null) {
                    EntityPlayerSP entityPlayerSP5;
                    EntityPlayerSP it3 = entityPlayerSP5 = entityPlayerSP2;
                    boolean bl4 = false;
                    Object object3 = entityPlayerSP4 = it3.func_184614_ca().func_77973_b() instanceof ItemBow ? entityPlayerSP5 : null;
                    if (entityPlayerSP4 != null) {
                        EntityPlayerSP $this$onPlayerSPUpdateWalkingPre_u24lambda_u243 = entityPlayerSP5 = entityPlayerSP4;
                        boolean bl5 = false;
                        $this$onPlayerSPUpdateWalkingPre_u24lambda_u243.field_71174_a.func_147297_a((Packet)new CPacketHeldItemChange($this$onPlayerSPUpdateWalkingPre_u24lambda_u243.field_71071_by.field_70461_c % 8 + 1));
                        $this$onPlayerSPUpdateWalkingPre_u24lambda_u243.field_71174_a.func_147297_a((Packet)new CPacketCustomPayload("L", new PacketBuffer(Unpooled.buffer())));
                        $this$onPlayerSPUpdateWalkingPre_u24lambda_u243.field_71174_a.func_147297_a((Packet)new CPacketCustomPayload("L", new PacketBuffer(Unpooled.buffer())));
                        $this$onPlayerSPUpdateWalkingPre_u24lambda_u243.field_71174_a.func_147297_a((Packet)new CPacketHeldItemChange($this$onPlayerSPUpdateWalkingPre_u24lambda_u243.field_71071_by.field_70461_c));
                    }
                }
            }
        }
    }
}

