/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.init.MobEffects
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.handler.movement.MovementManager;
import net.ccbluex.liquidbounce.injection.extend.ExtendTimer;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.init.MobEffects;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="Regen", description="Regenerates your health much faster.", category=ModuleCategory.PLAYER)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/Regen;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "healthValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "foodValue", "speedValue", "noAirValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "potionEffectValue", "resetTimer", "", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "DarkMeow"})
public final class Regen
extends Module {
    @NotNull
    private final ListValue modeValue;
    @NotNull
    private final IntegerValue healthValue;
    @NotNull
    private final IntegerValue foodValue;
    @NotNull
    private final IntegerValue speedValue;
    @NotNull
    private final BoolValue noAirValue;
    @NotNull
    private final BoolValue potionEffectValue;
    private boolean resetTimer;

    public Regen() {
        super(null, null, null, null, 15, null);
        String[] stringArray = new String[]{"Vanilla", "Spartan", "NewSpartan", "GrimAC"};
        this.modeValue = new ListValue("Mode", stringArray, "Vanilla");
        this.healthValue = new IntegerValue("Health", 18, 0, 20);
        this.foodValue = new IntegerValue("Food", 18, 0, 20);
        this.speedValue = new IntegerValue("Speed", 100, 1, 100);
        this.noAirValue = new BoolValue("NoAir", false);
        this.potionEffectValue = new BoolValue("PotionEffect", false);
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        block24: {
            Intrinsics.checkNotNullParameter(event, "event");
            if (this.resetTimer) {
                ExtendTimer.INSTANCE.setTimerSpeed(MinecraftInstance.mc.getTimer(), 1.0f);
            }
            this.resetTimer = false;
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null) {
                return;
            }
            EntityPlayerSP player = entityPlayerSP;
            if (((Boolean)this.noAirValue.get()).booleanValue() && !player.field_70122_E || player.field_71075_bZ.field_75098_d || player.func_71024_bL().func_75116_a() <= ((Number)this.foodValue.get()).intValue() || !player.func_70089_S() || !(player.func_110143_aJ() < (float)((Number)this.healthValue.get()).intValue())) break block24;
            if (((Boolean)this.potionEffectValue.get()).booleanValue() && !player.func_70644_a(MobEffects.field_76428_l)) {
                return;
            }
            String string = ((String)this.modeValue.get()).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(string, "toLowerCase(...)");
            switch (string) {
                case "newspartan": {
                    EntityPlayerSP entityPlayerSP2 = MinecraftInstance.mc.getPlayer();
                    Intrinsics.checkNotNull(entityPlayerSP2);
                    if (entityPlayerSP2.field_70173_aa % 5 == 0) {
                        this.resetTimer = true;
                    }
                    ExtendTimer.INSTANCE.setTimerSpeed(MinecraftInstance.mc.getTimer(), 0.98f);
                    NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc.getConnection();
                    Intrinsics.checkNotNull(netHandlerPlayClient);
                    netHandlerPlayClient.func_147297_a((Packet)new CPacketPlayer(true));
                    break;
                }
                case "vanilla": {
                    int n2 = ((Number)this.speedValue.get()).intValue();
                    int n3 = 0;
                    while (n3 < n2) {
                        int it = n3++;
                        boolean bl2 = false;
                        NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc.getConnection();
                        Intrinsics.checkNotNull(netHandlerPlayClient);
                        netHandlerPlayClient.func_147297_a((Packet)new CPacketPlayer(player.field_70122_E));
                    }
                    break;
                }
                case "spartan": {
                    if (MovementManager.isMoving$default(DarkMeow.INSTANCE.getMovementManager(), false, 1, null) || !player.field_70122_E) {
                        return;
                    }
                    int n4 = 9;
                    int n5 = 0;
                    while (n5 < n4) {
                        int it = n5++;
                        boolean bl3 = false;
                        NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc.getConnection();
                        Intrinsics.checkNotNull(netHandlerPlayClient);
                        netHandlerPlayClient.func_147297_a((Packet)new CPacketPlayer(player.field_70122_E));
                    }
                    ExtendTimer.INSTANCE.setTimerSpeed(MinecraftInstance.mc.getTimer(), 0.45f);
                    this.resetTimer = true;
                    break;
                }
                case "grimac": {
                    EntityPlayerSP entityPlayerSP3 = MinecraftInstance.mc.getPlayer();
                    Intrinsics.checkNotNull(entityPlayerSP3);
                    if (entityPlayerSP3.field_70173_aa % 5 == 0) {
                        this.resetTimer = true;
                    }
                    ExtendTimer.INSTANCE.setTimerSpeed(MinecraftInstance.mc.getTimer(), 0.98f);
                    NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc.getConnection();
                    Intrinsics.checkNotNull(netHandlerPlayClient);
                    netHandlerPlayClient.func_147297_a((Packet)new CPacketPlayer(true));
                    ExtendTimer.INSTANCE.setTimerSpeed(MinecraftInstance.mc.getTimer(), 0.45f);
                    this.resetTimer = true;
                }
            }
        }
    }
}

