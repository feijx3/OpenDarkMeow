/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketKeepAlive
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.flys.default;

import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.modules.movement.flys.FlyMode;
import net.ccbluex.liquidbounce.injection.access.network.AccessorCPacketPlayer;
import net.ccbluex.liquidbounce.injection.extend.ExtendKeyBinding;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.EntityUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketKeepAlive;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/flys/default/VanillaFly;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/flys/FlyMode;", "<init>", "()V", "smoothValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "speedValue", "Lnet/ccbluex/liquidbounce/value/Value;", "", "vSpeedValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "kickBypassValue", "kickBypassModeValue", "", "kickBypassMotionSpeedValue", "keepAliveValue", "noClipValue", "spoofValue", "smartSpeedValue", "smartSpeedModeValue", "smartSpeedEntityDistanceValue", "", "smartSpeedEntityOnlyTargetValue", "", "smartSpeedNormalSpeedValue", "smartSpeedActiveSpeedValue", "packets", "kickBypassMotion", "calcTicket", "onEnable", "", "onUpdate", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "smartSpeed", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nVanillaFly.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VanillaFly.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/flys/default/VanillaFly\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,141:1\n1869#2,2:142\n*S KotlinDebug\n*F\n+ 1 VanillaFly.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/flys/default/VanillaFly\n*L\n130#1:142,2\n*E\n"})
public final class VanillaFly
extends FlyMode {
    @NotNull
    private final BoolValue smoothValue = new BoolValue(this.getValuePrefix() + "Smooth", false);
    @NotNull
    private final Value<Float> speedValue = new FloatValue(this.getValuePrefix() + "Speed", 2.0f, 0.0f, 5.0f).displayable(() -> VanillaFly.speedValue$lambda$0(this));
    @NotNull
    private final FloatValue vSpeedValue = new FloatValue(this.getValuePrefix() + "Vertical", 2.0f, 0.0f, 5.0f);
    @NotNull
    private final BoolValue kickBypassValue = new BoolValue(this.getValuePrefix() + "KickBypass", false);
    @NotNull
    private final Value<String> kickBypassModeValue;
    @NotNull
    private final Value<Float> kickBypassMotionSpeedValue;
    @NotNull
    private final BoolValue keepAliveValue;
    @NotNull
    private final BoolValue noClipValue;
    @NotNull
    private final BoolValue spoofValue;
    @NotNull
    private final BoolValue smartSpeedValue;
    @NotNull
    private final Value<String> smartSpeedModeValue;
    @NotNull
    private final Value<Integer> smartSpeedEntityDistanceValue;
    @NotNull
    private final Value<Boolean> smartSpeedEntityOnlyTargetValue;
    @NotNull
    private final FloatValue smartSpeedNormalSpeedValue;
    @NotNull
    private final FloatValue smartSpeedActiveSpeedValue;
    private int packets;
    private float kickBypassMotion;
    private int calcTicket;

    public VanillaFly() {
        super("Vanilla");
        String[] stringArray = new String[]{"Motion", "Packet"};
        this.kickBypassModeValue = new ListValue(this.getValuePrefix() + "KickBypassMode", stringArray, "Packet").displayable(() -> VanillaFly.kickBypassModeValue$lambda$1(this));
        this.kickBypassMotionSpeedValue = new FloatValue(this.getValuePrefix() + "KickBypass-MotionSpeed", 0.0626f, 0.05f, 0.1f).displayable(() -> VanillaFly.kickBypassMotionSpeedValue$lambda$2(this));
        this.keepAliveValue = new BoolValue(this.getValuePrefix() + "KeepAlive", false);
        this.noClipValue = new BoolValue(this.getValuePrefix() + "NoClip", false);
        this.spoofValue = new BoolValue(this.getValuePrefix() + "SpoofGround", false);
        this.smartSpeedValue = new BoolValue(this.getValuePrefix() + "SmartSpeed", false);
        stringArray = new String[]{"NoEntityNear"};
        this.smartSpeedModeValue = new ListValue(this.getValuePrefix() + "SmartSpeedMode", stringArray, "NoEntityNear").displayable(() -> VanillaFly.smartSpeedModeValue$lambda$3(this));
        this.smartSpeedEntityDistanceValue = new IntegerValue(this.getValuePrefix() + "EntityDistance", 255, 0, 255).displayable(() -> VanillaFly.smartSpeedEntityDistanceValue$lambda$4(this)).displayable(() -> VanillaFly.smartSpeedEntityDistanceValue$lambda$5(this));
        this.smartSpeedEntityOnlyTargetValue = new BoolValue(this.getValuePrefix() + "EntityOnlyTarget", false).displayable(() -> VanillaFly.smartSpeedEntityOnlyTargetValue$lambda$6(this)).displayable(() -> VanillaFly.smartSpeedEntityOnlyTargetValue$lambda$7(this));
        this.smartSpeedNormalSpeedValue = new FloatValue("SpeedNormal", 2.0f, 0.0f, 10.0f);
        this.smartSpeedActiveSpeedValue = new FloatValue("SpeedActive", 10.0f, 0.0f, 10.0f);
    }

    @Override
    public void onEnable() {
        this.packets = 0;
        this.kickBypassMotion = 0.0f;
    }

    @Override
    public void onUpdate(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        if (((Boolean)this.smartSpeedValue.get()).booleanValue()) {
            int n2 = this.calcTicket;
            this.calcTicket = n2 + 1;
            if (this.calcTicket >= 10) {
                this.calcTicket = 0;
                Value.set$default(this.speedValue, Float.valueOf(this.smartSpeed() ? ((Number)this.smartSpeedActiveSpeedValue.get()).floatValue() : ((Number)this.smartSpeedNormalSpeedValue.get()).floatValue()), false, 2, null);
            }
        }
        if (((Boolean)this.keepAliveValue.get()).booleanValue()) {
            NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc.getConnection();
            if (netHandlerPlayClient != null) {
                netHandlerPlayClient.func_147297_a((Packet)new CPacketKeepAlive());
            }
        }
        if (((Boolean)this.noClipValue.get()).booleanValue()) {
            player.field_70145_X = true;
        }
        if (((Boolean)this.kickBypassValue.get()).booleanValue() && this.kickBypassModeValue.get() == "Motion") {
            this.kickBypassMotion = ((Number)this.kickBypassMotionSpeedValue.get()).floatValue();
            if (player.field_70173_aa % 2 == 0) {
                this.kickBypassMotion = -this.kickBypassMotion;
            }
            KeyBinding keyBinding = MinecraftInstance.mc.getGameSettings().field_74314_A;
            Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindJump");
            if (!ExtendKeyBinding.INSTANCE.getPressed(keyBinding)) {
                KeyBinding keyBinding2 = MinecraftInstance.mc.getGameSettings().field_74311_E;
                Intrinsics.checkNotNullExpressionValue(keyBinding2, "keyBindSneak");
                if (!ExtendKeyBinding.INSTANCE.getPressed(keyBinding2)) {
                    player.field_70181_x = this.kickBypassMotion;
                }
            }
        }
        if (((Boolean)this.smoothValue.get()).booleanValue()) {
            player.field_71075_bZ.field_75100_b = true;
            player.field_71075_bZ.func_75092_a(((Number)this.speedValue.get()).floatValue() * 0.05f);
        } else {
            player.field_71075_bZ.field_75100_b = false;
            DarkMeow.INSTANCE.getMovementManager().resetMotion(true);
            if (MinecraftInstance.mc.getGameSettings().field_74314_A.func_151470_d()) {
                player.field_70181_x += ((Number)this.vSpeedValue.get()).doubleValue();
            }
            if (MinecraftInstance.mc.getGameSettings().field_74311_E.func_151470_d()) {
                player.field_70181_x -= ((Number)this.vSpeedValue.get()).doubleValue();
            }
            DarkMeow.INSTANCE.getMovementManager().strafe(((Number)this.speedValue.get()).floatValue());
        }
    }

    @Override
    public void onPacket(@NotNull PacketEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Packet<?> packet = event.getPacket();
        if (packet instanceof AccessorCPacketPlayer) {
            if (((Boolean)this.spoofValue.get()).booleanValue()) {
                ((AccessorCPacketPlayer)packet).setOnGround(true);
            }
            int n2 = this.packets;
            this.packets = n2 + 1;
            if (n2 >= 40 && ((Boolean)this.kickBypassValue.get()).booleanValue()) {
                this.packets = 0;
                if (this.kickBypassModeValue.get() == "Packet") {
                    DarkMeow.INSTANCE.getMovementManager().handleVanillaKickBypass();
                }
            }
        }
    }

    private final boolean smartSpeed() {
        WorldClient worldClient = MinecraftInstance.mc.getWorld();
        if (worldClient == null) {
            return false;
        }
        WorldClient world = worldClient;
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return false;
        }
        EntityPlayerSP player = entityPlayerSP;
        boolean active = false;
        String string = this.smartSpeedModeValue.get().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(string, "toLowerCase(...)");
        if (Intrinsics.areEqual(string, "noentitynear")) {
            List list = world.field_72996_f;
            Intrinsics.checkNotNullExpressionValue(list, "loadedEntityList");
            Iterable $this$forEach$iv = list;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Entity entity = (Entity)element$iv;
                boolean bl2 = false;
                if (Intrinsics.areEqual(entity, MinecraftInstance.mc.getPlayer()) || this.smartSpeedEntityOnlyTargetValue.get().booleanValue() && !EntityUtils.isSelected(entity, false) || !(entity.func_70032_d((Entity)player) <= (float)((Number)this.smartSpeedEntityDistanceValue.get()).intValue())) continue;
                active = true;
            }
        }
        return active;
    }

    private static final boolean speedValue$lambda$0(VanillaFly this$0) {
        return (Boolean)this$0.smartSpeedValue.get() == false;
    }

    private static final boolean kickBypassModeValue$lambda$1(VanillaFly this$0) {
        return (Boolean)this$0.kickBypassValue.get();
    }

    private static final boolean kickBypassMotionSpeedValue$lambda$2(VanillaFly this$0) {
        return Intrinsics.areEqual(this$0.kickBypassModeValue.get(), "Motion") && (Boolean)this$0.kickBypassValue.get() != false;
    }

    private static final boolean smartSpeedModeValue$lambda$3(VanillaFly this$0) {
        return (Boolean)this$0.smartSpeedValue.get();
    }

    private static final boolean smartSpeedEntityDistanceValue$lambda$4(VanillaFly this$0) {
        return (Boolean)this$0.smartSpeedValue.get();
    }

    private static final boolean smartSpeedEntityDistanceValue$lambda$5(VanillaFly this$0) {
        String string = this$0.smartSpeedModeValue.get().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(string, "toLowerCase(...)");
        return Intrinsics.areEqual(string, "noentitynear");
    }

    private static final boolean smartSpeedEntityOnlyTargetValue$lambda$6(VanillaFly this$0) {
        return (Boolean)this$0.smartSpeedValue.get();
    }

    private static final boolean smartSpeedEntityOnlyTargetValue$lambda$7(VanillaFly this$0) {
        String string = this$0.smartSpeedModeValue.get().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(string, "toLowerCase(...)");
        return Intrinsics.areEqual(string, "noentitynear");
    }
}

