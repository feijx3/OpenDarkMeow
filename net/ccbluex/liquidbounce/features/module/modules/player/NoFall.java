/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.player;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.modules.render.FreeCam;
import net.ccbluex.liquidbounce.injection.access.network.AccessorCPacketPlayer;
import net.ccbluex.liquidbounce.injection.extend.entity.ExtendEntity;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.timer.TickTimer;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rH\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/NoFall;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "spartanTimer", "Lnet/ccbluex/liquidbounce/utils/timer/TickTimer;", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "tag", "", "getTag", "()Ljava/lang/String;", "DarkMeow"})
public final class NoFall
extends Module {
    @JvmField
    @NotNull
    public final ListValue modeValue;
    @NotNull
    private final TickTimer spartanTimer;

    public NoFall() {
        super("NoFall", ModuleCategory.PLAYER, null, null, 12, null);
        String[] stringArray = new String[]{"Packet", "SpoofGround", "NoGround", "Spartan"};
        this.modeValue = new ListValue("Mode", stringArray, "SpoofGround");
        this.spartanTimer = new TickTimer();
    }

    @EventTarget(ignoreCondition=true)
    public final void onUpdate(@Nullable UpdateEvent event) {
        NetHandlerPlayClient connection;
        EntityPlayerSP player;
        block13: {
            block12: {
                EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
                if (entityPlayerSP == null) {
                    return;
                }
                player = entityPlayerSP;
                NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc.getConnection();
                if (netHandlerPlayClient == null) {
                    return;
                }
                connection = netHandlerPlayClient;
                if (!this.getState()) break block12;
                FreeCam freeCam = DarkMeow.INSTANCE.getModuleManager().getModule(FreeCam.class);
                Intrinsics.checkNotNull(freeCam);
                if (!freeCam.getState()) break block13;
            }
            return;
        }
        if (player.func_180799_ab() || player.func_70090_H() || player.func_70617_f_() || player.func_184613_cA() || player.func_184218_aH() || ExtendEntity.INSTANCE.isInWeb((Entity)player)) {
            return;
        }
        String string = ((String)this.modeValue.get()).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(string, "toLowerCase(...)");
        String string2 = string;
        if (Intrinsics.areEqual(string2, "packet")) {
            if (player.field_70143_R > 3.9f) {
                connection.func_147297_a((Packet)new CPacketPlayer(true));
            }
        } else if (Intrinsics.areEqual(string2, "spartan")) {
            this.spartanTimer.update();
            if ((double)player.field_70143_R > 1.5 && this.spartanTimer.hasTimePassed(10)) {
                connection.func_147297_a((Packet)new CPacketPlayer.Position(player.field_70165_t, player.field_70163_u + (double)10, player.field_70161_v, true));
                connection.func_147297_a((Packet)new CPacketPlayer.Position(player.field_70165_t, player.field_70163_u - (double)10, player.field_70161_v, true));
                this.spartanTimer.reset();
            }
        }
    }

    @EventTarget
    public final void onPacket(@NotNull PacketEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Packet<?> packet = event.getPacket();
        String mode = (String)this.modeValue.get();
        if (packet instanceof AccessorCPacketPlayer) {
            Packet<?> playerPacket = packet;
            if (StringsKt.equals(mode, "SpoofGround", true)) {
                ((AccessorCPacketPlayer)playerPacket).setOnGround(true);
            }
            if (StringsKt.equals(mode, "NoGround", true)) {
                ((AccessorCPacketPlayer)playerPacket).setOnGround(false);
            }
        }
    }

    @Override
    @NotNull
    public String getTag() {
        return (String)this.modeValue.get();
    }
}

