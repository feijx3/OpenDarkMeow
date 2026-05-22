/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.server.SPacketTitle
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.misc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.features.module.modules.combat.Criticals;
import net.ccbluex.liquidbounce.features.module.modules.combat.KillAura;
import net.ccbluex.liquidbounce.features.module.modules.exploit.PUBGDisabler;
import net.ccbluex.liquidbounce.features.module.modules.movement.Fly;
import net.ccbluex.liquidbounce.features.module.modules.movement.NoClip;
import net.ccbluex.liquidbounce.features.module.modules.movement.Speed;
import net.ccbluex.liquidbounce.features.module.modules.movement.Step;
import net.ccbluex.liquidbounce.features.module.modules.player.AntiAim;
import net.ccbluex.liquidbounce.features.module.modules.player.InvManager;
import net.ccbluex.liquidbounce.features.module.modules.world.ContainerAura;
import net.ccbluex.liquidbounce.features.module.modules.world.ContainerStealer;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.ClientUtils;
import net.ccbluex.liquidbounce.utils.ModuleUtils;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.server.SPacketTitle;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="PUBGHelper", description="\u82b1\u96e8\u5ead\u4ee3\u53f7\u5403\u9e21\u52a9\u624b \u9002\u7528\u4e8elowiq\u7684\u81ea\u52a8\u8df3\u4f1e\u548c\u81ea\u52a8\u5f00\u65e0\u654c | by CatX_feitu", category=ModuleCategory.MISC)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0014H\u0007J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/PUBGHelper;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "autoParachuteValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "autoDisableValue", "autoDisableTicketValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "lowIQFix", "autoToggleCriticals", "autoToggleAntiAim", "autoToggleFly", "parachuteTicket", "", "onPacket", "", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "onWorld", "worldEvent", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "DarkMeow"})
public final class PUBGHelper
extends Module {
    @NotNull
    private final BoolValue autoParachuteValue = new BoolValue("AutoParachute", false);
    @NotNull
    private final BoolValue autoDisableValue = new BoolValue("AutoDisable", false);
    @NotNull
    private final IntegerValue autoDisableTicketValue = new IntegerValue("AutoDisableTicket", 20, 0, 200);
    @NotNull
    private final BoolValue lowIQFix = new BoolValue("LowIQFix", false);
    @NotNull
    private final BoolValue autoToggleCriticals = new BoolValue("AutoToggleCriticals", false);
    @NotNull
    private final BoolValue autoToggleAntiAim = new BoolValue("AutoToggleAntiAim", false);
    @NotNull
    private final BoolValue autoToggleFly = new BoolValue("AutoToggleFly", false);
    private int parachuteTicket = -1;

    public PUBGHelper() {
        super(null, null, null, null, 15, null);
    }

    @EventTarget
    public final void onPacket(@NotNull PacketEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        Packet<?> packet = event.getPacket();
        if (packet instanceof SPacketTitle && ((SPacketTitle)packet).func_179805_b() != null) {
            if (Intrinsics.areEqual(((SPacketTitle)packet).func_179805_b().func_150260_c(), "\u00a7a\u00a7l\u6309Shift\u8df3\u4f1e") && ((Boolean)this.autoParachuteValue.get()).booleanValue()) {
                ClientUtils.displayChatMessage("\u00a7d" + DarkMeow.INSTANCE.getCLIENT_NAME() + " \u00a78>> \u00a7a\u81ea\u52a8\u8df3\u4f1e");
                NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc.getConnection();
                Intrinsics.checkNotNull(netHandlerPlayClient);
                netHandlerPlayClient.func_147297_a((Packet)new CPacketEntityAction((Entity)player, CPacketEntityAction.Action.START_SNEAKING));
                NetHandlerPlayClient netHandlerPlayClient2 = MinecraftInstance.mc.getConnection();
                Intrinsics.checkNotNull(netHandlerPlayClient2);
                netHandlerPlayClient2.func_147297_a((Packet)new CPacketEntityAction((Entity)player, CPacketEntityAction.Action.STOP_SNEAKING));
            }
            if (Intrinsics.areEqual(((SPacketTitle)packet).func_179805_b().func_150260_c(), "\u00a7a\u8df3\u4f1e\u6210\u529f") && ((Boolean)this.autoDisableValue.get()).booleanValue()) {
                this.parachuteTicket = 0;
            }
        }
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.parachuteTicket >= 0) {
            int n2 = this.parachuteTicket;
            this.parachuteTicket = n2 + 1;
            if (this.parachuteTicket >= ((Number)this.autoDisableTicketValue.get()).intValue()) {
                ModuleUtils.setModuleState(PUBGDisabler.class, true);
                if (((Boolean)this.autoToggleAntiAim.get()).booleanValue()) {
                    ModuleUtils.setModuleState(AntiAim.class, true);
                }
                if (((Boolean)this.autoToggleCriticals.get()).booleanValue()) {
                    ModuleUtils.setModuleState(Criticals.class, true);
                }
                if (((Boolean)this.autoToggleFly.get()).booleanValue()) {
                    ModuleUtils.setModuleState(Fly.class, true);
                }
                ClientUtils.displayChatMessage("\u00a7d" + DarkMeow.INSTANCE.getCLIENT_NAME() + " \u00a78>> \u00a7a\u6e38\u620f\u5f00\u59cb~\u52a9\u541b\u98d8\u5f97\u6109\u5feb~");
                this.parachuteTicket = -1;
            }
        }
    }

    @EventTarget
    public final void onWorld(@NotNull WorldEvent worldEvent) {
        Intrinsics.checkNotNullParameter(worldEvent, "worldEvent");
        if (((Boolean)this.autoDisableValue.get()).booleanValue()) {
            ModuleUtils.setModuleState(PUBGDisabler.class, false);
        }
        if (((Boolean)this.lowIQFix.get()).booleanValue()) {
            ModuleUtils.setModuleState(KillAura.class, false);
            ModuleUtils.setModuleState(Fly.class, false);
            ModuleUtils.setModuleState(Speed.class, false);
            ModuleUtils.setModuleState(Criticals.class, false);
            ModuleUtils.setModuleState(AntiAim.class, false);
            ModuleUtils.setModuleState(ContainerAura.class, false);
            ModuleUtils.setModuleState(ContainerStealer.class, false);
            ModuleUtils.setModuleState(InvManager.class, false);
            ModuleUtils.setModuleState(NoClip.class, false);
            ModuleUtils.setModuleState(Step.class, false);
        }
    }
}

