/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.server.SPacketEntityStatus
 *  net.minecraft.util.Timer
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement;

import java.awt.Color;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.JumpEvent;
import net.ccbluex.liquidbounce.event.MotionEvent;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.event.Render3DEvent;
import net.ccbluex.liquidbounce.event.StepEvent;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.event.events.player.move.MoveEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.features.module.modules.movement.flys.FlyMode;
import net.ccbluex.liquidbounce.injection.extend.ExtendTimer;
import net.ccbluex.liquidbounce.injection.extend.entity.ExtendEntityPlayer;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.utils.render.RenderUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.darkmeow.darkmeow.utils.network.PacketSide;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.util.Timer;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="Fly", category=ModuleCategory.MOVEMENT, keyBind=33)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u000203H\u0016J\u0010\u00105\u001a\u0002032\u0006\u00106\u001a\u000207H\u0007J\u0010\u00108\u001a\u0002032\u0006\u00106\u001a\u000209H\u0007J\u0010\u0010:\u001a\u0002032\u0006\u00106\u001a\u00020;H\u0007J\u0010\u0010<\u001a\u0002032\u0006\u00106\u001a\u00020=H\u0007J\u0010\u0010>\u001a\u0002032\u0006\u00106\u001a\u00020?H\u0007J\u0010\u0010@\u001a\u0002032\u0006\u00106\u001a\u00020AH\u0007J\u0010\u0010B\u001a\u0002032\u0006\u00106\u001a\u00020CH\u0007J\u0010\u0010D\u001a\u0002032\u0006\u00106\u001a\u00020EH\u0007R\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001a\u0010!\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u001a\u0010)\u001a\u00020*X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020*X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R\u0014\u0010F\u001a\u00020G8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bH\u0010I\u00a8\u0006J"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/Fly;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modes", "", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/flys/FlyMode;", "kotlin.jvm.PlatformType", "mode", "getMode", "()Lnet/ccbluex/liquidbounce/features/module/modules/movement/flys/FlyMode;", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "motionResetValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "markValue", "fakeDamageValue", "viewBobbingValue", "viewBobbingYawValue", "Lnet/ccbluex/liquidbounce/value/Value;", "", "launchX", "", "getLaunchX", "()D", "setLaunchX", "(D)V", "launchY", "getLaunchY", "setLaunchY", "launchZ", "getLaunchZ", "setLaunchZ", "launchYaw", "getLaunchYaw", "()F", "setLaunchYaw", "(F)V", "launchPitch", "getLaunchPitch", "setLaunchPitch", "antiDesync", "", "getAntiDesync", "()Z", "setAntiDesync", "(Z)V", "needReset", "getNeedReset", "setNeedReset", "onEnable", "", "onDisable", "onRender3d", "event", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "onMotion", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onWorld", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "onMove", "Lnet/ccbluex/liquidbounce/event/events/player/move/MoveEvent;", "onJump", "Lnet/ccbluex/liquidbounce/event/JumpEvent;", "onStep", "Lnet/ccbluex/liquidbounce/event/StepEvent;", "tag", "", "getTag", "()Ljava/lang/String;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nFly.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Fly.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/Fly\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,181:1\n1#2:182\n1563#3:183\n1634#3,3:184\n1056#3:187\n1563#3:188\n1634#3,3:189\n1563#3:196\n1634#3,2:197\n1869#3,2:199\n1636#3:201\n37#4:192\n36#4,3:193\n*S KotlinDebug\n*F\n+ 1 Fly.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/Fly\n*L\n28#1:183\n28#1:184,3\n29#1:187\n35#1:188\n35#1:189,3\n169#1:196\n169#1:197,2\n170#1:199,2\n169#1:201\n35#1:192\n35#1:193,3\n*E\n"})
public final class Fly
extends Module {
    @NotNull
    public static final Fly INSTANCE = new Fly();
    @NotNull
    private static final List<FlyMode> modes;
    @NotNull
    private static final ListValue modeValue;
    @NotNull
    private static final BoolValue motionResetValue;
    @NotNull
    private static final ListValue markValue;
    @NotNull
    private static final BoolValue fakeDamageValue;
    @NotNull
    private static final BoolValue viewBobbingValue;
    @NotNull
    private static final Value<Float> viewBobbingYawValue;
    private static double launchX;
    private static double launchY;
    private static double launchZ;
    private static float launchYaw;
    private static float launchPitch;
    private static boolean antiDesync;
    private static boolean needReset;

    private Fly() {
        super(null, null, null, null, 15, null);
    }

    private final FlyMode getMode() {
        FlyMode flyMode;
        Object v0;
        block2: {
            Iterable iterable = modes;
            for (Object t2 : iterable) {
                FlyMode it = (FlyMode)t2;
                boolean bl2 = false;
                if (!Intrinsics.areEqual(it.getModeName(), modeValue.get())) continue;
                v0 = t2;
                break block2;
            }
            v0 = null;
        }
        if ((flyMode = (FlyMode)v0) == null) {
            FlyMode flyMode2 = modes.get(0);
            Intrinsics.checkNotNullExpressionValue(flyMode2, "get(...)");
            flyMode = flyMode2;
        }
        return flyMode;
    }

    public final double getLaunchX() {
        return launchX;
    }

    public final void setLaunchX(double d2) {
        launchX = d2;
    }

    public final double getLaunchY() {
        return launchY;
    }

    public final void setLaunchY(double d2) {
        launchY = d2;
    }

    public final double getLaunchZ() {
        return launchZ;
    }

    public final void setLaunchZ(double d2) {
        launchZ = d2;
    }

    public final float getLaunchYaw() {
        return launchYaw;
    }

    public final void setLaunchYaw(float f2) {
        launchYaw = f2;
    }

    public final float getLaunchPitch() {
        return launchPitch;
    }

    public final void setLaunchPitch(float f2) {
        launchPitch = f2;
    }

    public final boolean getAntiDesync() {
        return antiDesync;
    }

    public final void setAntiDesync(boolean bl2) {
        antiDesync = bl2;
    }

    public final boolean getNeedReset() {
        return needReset;
    }

    public final void setNeedReset(boolean bl2) {
        needReset = bl2;
    }

    @Override
    public void onEnable() {
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        antiDesync = false;
        needReset = true;
        if (player.field_70122_E && ((Boolean)fakeDamageValue.get()).booleanValue()) {
            PacketEvent event = new PacketEvent((Packet)new SPacketEntityStatus((Entity)player, 2), PacketSide.SERVER);
            EventManager.callEvent$default(DarkMeow.INSTANCE.getEventManager(), event, null, 2, null);
            if (!event.isCancelled()) {
                player.func_70103_a((byte)2);
            }
        }
        launchX = player.field_70165_t;
        launchY = player.field_70163_u;
        launchZ = player.field_70161_v;
        launchYaw = player.field_70177_z;
        launchPitch = player.field_70125_A;
        if (this.getMode() == null) {
            return;
        }
        this.getMode().onEnable();
    }

    @Override
    public void onDisable() {
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        Timer timer = MinecraftInstance.mc.getTimer();
        antiDesync = false;
        player.field_71075_bZ.field_75100_b = false;
        player.field_71075_bZ.func_75092_a(0.05f);
        player.field_70145_X = false;
        ExtendTimer.INSTANCE.setTimerSpeed(timer, 1.0f);
        ExtendEntityPlayer.INSTANCE.setSpeedInAir((EntityPlayer)player, 0.02f);
        if (((Boolean)motionResetValue.get()).booleanValue() && needReset) {
            DarkMeow.INSTANCE.getMovementManager().resetMotion(true);
        }
        this.getMode().onDisable();
    }

    @EventTarget
    public final void onRender3d(@NotNull Render3DEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        if (markValue.equals("Off")) {
            return;
        }
        RenderUtils.drawPlatform(markValue.equals("Up") ? launchY + 2.0 : launchY, player.func_174813_aQ().field_72337_e < launchY + 2.0 ? new Color(0, 255, 0, 90) : new Color(255, 0, 0, 90), 1.0);
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.getMode().onUpdate(event);
    }

    @EventTarget
    public final void onMotion(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        if (((Boolean)viewBobbingValue.get()).booleanValue()) {
            player.field_71109_bG = ((Number)viewBobbingYawValue.get()).floatValue();
            player.field_71107_bF = ((Number)viewBobbingYawValue.get()).floatValue();
            float cfr_ignored_0 = MinecraftInstance.mc_nowarp.field_71439_g.field_71107_bF;
        }
        this.getMode().onMotion(event);
    }

    @EventTarget
    public final void onPacket(@NotNull PacketEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.getMode().onPacket(event);
    }

    @EventTarget
    public final void onWorld(@NotNull WorldEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.getMode().onWorld(event);
    }

    @EventTarget
    public final void onMove(@NotNull MoveEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.getMode().onMove(event);
    }

    @EventTarget
    public final void onJump(@NotNull JumpEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.getMode().onJump(event);
    }

    @EventTarget
    public final void onStep(@NotNull StepEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.getMode().onStep(event);
    }

    @Override
    @NotNull
    public String getTag() {
        return (String)modeValue.get();
    }

    private static final boolean viewBobbingYawValue$lambda$5() {
        return (Boolean)viewBobbingValue.get();
    }

    private static final boolean lambda$8$lambda$7$lambda$6(FlyMode $mode) {
        return Intrinsics.areEqual($mode.getModeName(), modeValue.get());
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    static {
        it = var1 = ClassUtils.INSTANCE.resolvePackage(Fly.INSTANCE.getClass().getPackage().getName() + ".flys", FlyMode.class);
        $i$a$-takeIf-Fly$modes$1 = false;
        v0 /* !! */  = var0_8 = !((Collection)it).isEmpty() != false ? var1 : null;
        if (var0_8 == null) ** GOTO lbl-1000
        $this$map$iv = (List<T>)var0_8;
        $i$f$map = false;
        var4_9 = $this$map$iv;
        destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        $i$f$mapTo = false;
        for (T item$iv$iv : $this$mapTo$iv$iv) {
            var9_21 = (Class)item$iv$iv /* !! */ ;
            var15_25 = destination$iv$iv;
            $i$a$-map-Fly$modes$2 = false;
            var15_25.add((FlyMode)it.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        $this$sortedBy$iv = (List)destination$iv$iv;
        $i$f$sortedBy = false;
        $this$map$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

            public final int compare(T a2, T b2) {
                FlyMode it = (FlyMode)a2;
                boolean bl2 = false;
                Comparable comparable = (Comparable)((Object)it.getModeName());
                it = (FlyMode)b2;
                Comparable comparable2 = comparable;
                bl2 = false;
                return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getModeName()));
            }
        });
        if ($this$map$iv != null) {
            v1 = $this$map$iv;
        } else lbl-1000:
        // 2 sources

        {
            v1 = CollectionsKt.emptyList();
        }
        Fly.modes = v1;
        $this$map$iv = Fly.modes;
        $i$f$map = false;
        $this$sortedBy$iv = $this$map$iv;
        destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        $i$f$mapTo = false;
        for (T item$iv$iv : $this$mapTo$iv$iv) {
            item$iv$iv /* !! */  = (FlyMode)item$iv$iv /* !! */ ;
            var15_25 = destination$iv$iv;
            $i$a$-map-Fly$modeValue$2 = false;
            var15_25.add(it.getModeName());
        }
        $this$toTypedArray$iv = (List)destination$iv$iv;
        $i$f$toTypedArray = false;
        thisCollection$iv = $this$toTypedArray$iv;
        var0_8 = thisCollection$iv.toArray(new String[0]);
        Fly.modeValue = new ListValue((String[])var0_8){

            protected void onChange(String oldValue, String newValue) {
                Intrinsics.checkNotNullParameter(oldValue, "oldValue");
                Intrinsics.checkNotNullParameter(newValue, "newValue");
                if (Fly.INSTANCE.getState()) {
                    Fly.INSTANCE.onDisable();
                }
            }

            protected void onChanged(String oldValue, String newValue) {
                Intrinsics.checkNotNullParameter(oldValue, "oldValue");
                Intrinsics.checkNotNullParameter(newValue, "newValue");
                if (Fly.INSTANCE.getState()) {
                    Fly.INSTANCE.onEnable();
                }
            }
        };
        Fly.motionResetValue = new BoolValue("MotionReset", false);
        var0_8 = new String[]{"Up", "Down", "Off"};
        Fly.markValue = new ListValue("Mark", (String[])var0_8, "Up");
        Fly.fakeDamageValue = new BoolValue("FakeDamage", false);
        Fly.viewBobbingValue = new BoolValue("ViewBobbing", false);
        Fly.viewBobbingYawValue = new FloatValue("ViewBobbingYaw", 0.1f, 0.0f, 0.5f).displayable((Function0<Boolean>)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, viewBobbingYawValue$lambda$5(), ()Ljava/lang/Boolean;)());
        Fly.needReset = true;
        Fly.INSTANCE.getValues().add(Fly.modeValue);
        $this$map$iv = Fly.modes;
        $i$f$map = false;
        $i$f$toTypedArray = $this$map$iv;
        destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        $i$f$mapTo = false;
        for (T item$iv$iv : $this$mapTo$iv$iv) {
            item$iv$iv /* !! */  = (FlyMode)item$iv$iv;
            var15_25 = destination$iv$iv;
            $i$a$-map-Fly$1 = false;
            $this$forEach$iv = mode.getValues();
            $i$f$forEach = false;
            for (T element$iv : $this$forEach$iv) {
                value = (Value)element$iv;
                $i$a$-forEach-Fly$1$1 = false;
                Fly.INSTANCE.getValues().add(value.displayable((Function0<Boolean>)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, lambda$8$lambda$7$lambda$6(net.ccbluex.liquidbounce.features.module.modules.movement.flys.FlyMode ), ()Ljava/lang/Boolean;)((FlyMode)mode)));
            }
            var15_25.add(Unit.INSTANCE);
        }
        (List)var3_7;
        var0_8 = new Value[]{Fly.motionResetValue, Fly.markValue, Fly.fakeDamageValue, Fly.viewBobbingValue, Fly.viewBobbingYawValue};
        Fly.INSTANCE.getValues().addAll((Collection)CollectionsKt.mutableListOf(var0_8));
    }
}

