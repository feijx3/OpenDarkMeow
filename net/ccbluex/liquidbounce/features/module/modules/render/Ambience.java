/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.server.SPacketChangeGameState
 *  net.minecraft.network.play.server.SPacketTimeUpdate
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketChangeGameState;
import net.minecraft.network.play.server.SPacketTimeUpdate;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="Ambience", description="\u4fee\u6539\u672c\u5730\u5ba2\u6237\u7aef\u65f6\u95f4\u548c\u5929\u6c14", category=ModuleCategory.RENDER)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0019H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001a"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/Ambience;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "timeModeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "customWorldTimeValue", "Lnet/ccbluex/liquidbounce/value/Value;", "", "changeWorldTimeSpeedValue", "weatherModeValue", "weatherStrengthValue", "", "i", "", "getI", "()J", "setI", "(J)V", "onDisable", "", "onUpdate", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "DarkMeow"})
public final class Ambience
extends Module {
    @NotNull
    public static final Ambience INSTANCE = new Ambience();
    @NotNull
    private static final ListValue timeModeValue;
    @NotNull
    private static final Value<Integer> customWorldTimeValue;
    @NotNull
    private static final Value<Integer> changeWorldTimeSpeedValue;
    @NotNull
    private static final ListValue weatherModeValue;
    @NotNull
    private static final Value<Float> weatherStrengthValue;
    private static long i;

    private Ambience() {
        super(null, null, null, null, 15, null);
    }

    public final long getI() {
        return i;
    }

    public final void setI(long l2) {
        i = l2;
    }

    @Override
    public void onDisable() {
        i = 0L;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        WorldClient world;
        block10: {
            Intrinsics.checkNotNullParameter(event, "event");
            WorldClient worldClient = MinecraftInstance.mc.getWorld();
            if (worldClient == null) {
                return;
            }
            world = worldClient;
            String string = ((String)timeModeValue.get()).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(string, "toLowerCase(...)");
            String string2 = string;
            if (Intrinsics.areEqual(string2, "normal")) {
                i = i < 24000L ? (i += ((Number)changeWorldTimeSpeedValue.get()).longValue()) : 0L;
                world.func_72877_b(i);
            } else if (Intrinsics.areEqual(string2, "custom")) {
                world.func_72877_b((long)((Number)customWorldTimeValue.get()).intValue() * (long)1000);
            }
            String string3 = ((String)weatherModeValue.get()).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(string3, "toLowerCase(...)");
            string2 = string3;
            switch (string2.hashCode()) {
                case 3492756: {
                    if (string2.equals("rain")) break;
                    return;
                }
                case -1334895388: {
                    if (!string2.equals("thunder")) {
                        return;
                    }
                    break block10;
                }
                case 114252: {
                    if (!string2.equals("sun")) return;
                    world.func_72894_k(0.0f);
                    world.func_147442_i(0.0f);
                    return;
                }
            }
            world.func_72894_k(((Number)weatherStrengthValue.get()).floatValue());
            world.func_147442_i(0.0f);
            return;
        }
        world.func_72894_k(((Number)weatherStrengthValue.get()).floatValue());
        world.func_147442_i(((Number)weatherStrengthValue.get()).floatValue());
    }

    @EventTarget
    public final void onPacket(@NotNull PacketEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Packet<?> packet = event.getPacket();
        if (!timeModeValue.equals("none") && packet instanceof SPacketTimeUpdate) {
            event.cancelEvent();
        }
        if (!weatherModeValue.equals("none") && packet instanceof SPacketChangeGameState) {
            int n2 = ((SPacketChangeGameState)packet).func_149138_c();
            boolean bl2 = 7 <= n2 ? n2 < 9 : false;
            if (bl2) {
                event.cancelEvent();
            }
        }
    }

    private static final boolean customWorldTimeValue$lambda$0() {
        return timeModeValue.equals("Custom");
    }

    private static final boolean changeWorldTimeSpeedValue$lambda$1() {
        return timeModeValue.equals("Normal");
    }

    private static final boolean weatherStrengthValue$lambda$2() {
        return !weatherModeValue.equals("None");
    }

    static {
        String[] stringArray = new String[]{"None", "Normal", "Custom"};
        timeModeValue = new ListValue("TimeMode", stringArray, "Custom");
        customWorldTimeValue = new IntegerValue("CustomTime", 19, 0, 24).displayable(Ambience::customWorldTimeValue$lambda$0);
        changeWorldTimeSpeedValue = new IntegerValue("ChangeWorldTimeSpeed", 150, 10, 500).displayable(Ambience::changeWorldTimeSpeedValue$lambda$1);
        stringArray = new String[]{"None", "Sun", "Rain", "Thunder"};
        weatherModeValue = new ListValue("WeatherMode", stringArray, "None");
        weatherStrengthValue = new FloatValue("WeatherStrength", 1.0f, 0.0f, 1.0f).displayable(Ambience::weatherStrengthValue$lambda$2);
    }
}

