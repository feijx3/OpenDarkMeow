/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.inventory.GuiInventory
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketCloseWindow
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.features.module.modules.exploit.Kick;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.ccbluex.liquidbounce.value.impl.TextValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketCloseWindow;
import net.minecraft.network.play.client.CPacketEntityAction;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="AutoLeave", category=ModuleCategory.COMBAT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/AutoLeave;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "healthValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "cmdValue", "Lnet/ccbluex/liquidbounce/value/Value;", "", "chatValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "chat", "removeArmor", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "DarkMeow"})
public final class AutoLeave
extends Module {
    @NotNull
    private final FloatValue healthValue = new FloatValue("Health", 8.0f, 0.0f, 20.0f);
    @NotNull
    private final ListValue modeValue;
    @NotNull
    private final Value<String> cmdValue;
    @NotNull
    private final BoolValue chatValue;
    @NotNull
    private final Value<String> chat;
    @NotNull
    private final BoolValue removeArmor;

    public AutoLeave() {
        super(null, null, null, null, 15, null);
        String[] stringArray = new String[]{"ChatCommand", "Kick"};
        this.modeValue = new ListValue("Mode", stringArray, "ChatCommand");
        this.cmdValue = new TextValue("Command", "/hub").displayable(() -> AutoLeave.cmdValue$lambda$0(this));
        this.chatValue = new BoolValue("LeaveChat", false);
        this.chat = new TextValue("ChatText", "\u54c8...\u60c5\u51b5\u4e0d\u5bf9...\u5f00\u6e9c!").displayable(() -> AutoLeave.chat$lambda$1(this));
        this.removeArmor = new BoolValue("RemoveArmor", false);
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        if (player.func_110143_aJ() <= ((Number)this.healthValue.get()).floatValue() && !player.field_71075_bZ.field_75098_d && !MinecraftInstance.mc.isIntegratedServerRunning()) {
            if (((Boolean)this.removeArmor.get()).booleanValue()) {
                if (!(MinecraftInstance.mc.getCurrentScreen() instanceof GuiInventory)) {
                    NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc.getConnection();
                    if (netHandlerPlayClient != null) {
                        netHandlerPlayClient.func_147297_a((Packet)new CPacketEntityAction((Entity)player, CPacketEntityAction.Action.OPEN_INVENTORY));
                    }
                }
                for (int slot = 5; slot < 9; ++slot) {
                    MinecraftInstance.mc.getPlayerController().func_187098_a(player.field_71069_bz.field_75152_c, slot, 0, ClickType.SWAP, (EntityPlayer)player);
                }
                if (!(MinecraftInstance.mc.getCurrentScreen() instanceof GuiInventory)) {
                    NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc.getConnection();
                    if (netHandlerPlayClient != null) {
                        netHandlerPlayClient.func_147297_a((Packet)new CPacketCloseWindow());
                    }
                }
            }
            if (((Boolean)this.chatValue.get()).booleanValue()) {
                player.func_71165_d(this.chat.get());
            }
            String string = ((String)this.modeValue.get()).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(string, "toLowerCase(...)");
            String string2 = string;
            if (Intrinsics.areEqual(string2, "chatcommand")) {
                player.func_71165_d(this.cmdValue.get());
            } else if (Intrinsics.areEqual(string2, "kick")) {
                Kick kick = DarkMeow.INSTANCE.getModuleManager().get(Kick.class);
                Intrinsics.checkNotNull(kick);
                kick.onEnable();
            }
        }
    }

    private static final boolean cmdValue$lambda$0(AutoLeave this$0) {
        return Intrinsics.areEqual(this$0.modeValue.get(), "ChatCommand");
    }

    private static final boolean chat$lambda$1(AutoLeave this$0) {
        return (Boolean)this$0.chatValue.get();
    }
}

