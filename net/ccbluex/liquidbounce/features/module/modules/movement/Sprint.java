/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.init.MobEffects
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.movement;

import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.injection.extend.ExtendKeyBinding;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.init.MobEffects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0003J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0010H\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0002J#\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u00152\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0016H\u0007\u00a2\u0006\u0002\u0010\u001aJ\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u0015H\u0007\u00a2\u0006\u0002\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/Sprint;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "checkBlindnessValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "getCheckBlindnessValue", "()Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "checkHungryValue", "getCheckHungryValue", "debugValue", "onMovementInput", "", "event", "Lnet/ccbluex/liquidbounce/event/events/input/MovementInputEvent$PRE;", "onWorld", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "canSprint", "", "noSprintLocks", "", "", "", "lockNoSprint", "name", "keepTick", "(Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Integer;", "unlockNoSprint", "(Ljava/lang/String;)Ljava/lang/Integer;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nSprint.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sprint.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/Sprint\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,84:1\n774#2:85\n865#2,2:86\n2756#2:88\n1#3:89\n19652#4,2:90\n*S KotlinDebug\n*F\n+ 1 Sprint.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/Sprint\n*L\n29#1:85\n29#1:86,2\n30#1:88\n30#1:89\n57#1:90,2\n*E\n"})
public final class Sprint
extends Module {
    @NotNull
    public static final Sprint INSTANCE = new Sprint();
    @NotNull
    private static final BoolValue checkBlindnessValue = new BoolValue("CheckBlindness", false);
    @NotNull
    private static final BoolValue checkHungryValue = new BoolValue("CheckHungry", false);
    @NotNull
    private static final BoolValue debugValue = new BoolValue("Debug", false);
    @JvmField
    @NotNull
    public static final Map<String, Integer> noSprintLocks = new LinkedHashMap();

    private Sprint() {
        super("Sprint", ModuleCategory.MOVEMENT, null, null, 12, null);
    }

    @NotNull
    public final BoolValue getCheckBlindnessValue() {
        return checkBlindnessValue;
    }

    @NotNull
    public final BoolValue getCheckHungryValue() {
        return checkHungryValue;
    }

    /*
     * Unable to fully structure code
     */
    @EventTarget(ignoreCondition=true, priority=2000)
    private final void onMovementInput(MovementInputEvent.PRE event) {
        v0 = MinecraftInstance.mc.getPlayer();
        if (v0 == null) {
            return;
        }
        player = v0;
        $this$filter$iv = Sprint.noSprintLocks.keySet();
        $i$f$filter = false;
        var5_5 = $this$filter$iv;
        destination$iv$iv = new ArrayList<E>();
        $i$f$filterTo = false;
        for (T element$iv$iv : $this$filterTo$iv$iv) {
            key = (String)element$iv$iv;
            $i$a$-filter-Sprint$onMovementInput$1 = false;
            v1 = Sprint.noSprintLocks.get(key);
            if ((v1 != null ? v1 : -1) == -1) ** GOTO lbl-1000
            v2 = Sprint.noSprintLocks.get(key);
            if ((v2 != null ? v2 : -1) - 1 == 0) {
                v3 = true;
            } else lbl-1000:
            // 2 sources

            {
                v3 = false;
            }
            if (!v3) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $this$onEach$iv = (List)destination$iv$iv;
        $i$f$onEach = false;
        $this$onEach_u24lambda_u2418$iv = var5_5 = $this$onEach$iv;
        $i$a$-apply-CollectionsKt___CollectionsKt$onEach$1$iv = false;
        for (T element$iv : $this$onEach_u24lambda_u2418$iv) {
            key = (String)element$iv;
            $i$a$-onEach-Sprint$onMovementInput$2 = false;
            Sprint.noSprintLocks.remove(key);
        }
        Sprint.noSprintLocks.replaceAll((BiFunction<Object, Object, Integer>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;, onMovementInput$lambda$3(kotlin.jvm.functions.Function2 java.lang.Object java.lang.Object ), (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Integer;)((Function2<String, Integer, Integer>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;, onMovementInput$lambda$2(java.lang.String java.lang.Integer ), (Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Integer;)()));
        if (Sprint.noSprintLocks.isEmpty() == false) {
            player.func_70031_b(false);
            v4 = MinecraftInstance.mc.getGameSettings().field_151444_V;
            Intrinsics.checkNotNullExpressionValue(v4, "keyBindSprint");
            ExtendKeyBinding.INSTANCE.unPressKey(v4);
            return;
        }
        if (this.getState()) {
            player.func_70031_b(this.canSprint());
        }
    }

    @EventTarget(ignoreCondition=true, priority=2000)
    private final void onWorld(WorldEvent event) {
        noSprintLocks.clear();
    }

    private final boolean canSprint() {
        boolean bl2;
        block3: {
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP != null) {
                EntityPlayerSP player = entityPlayerSP;
                boolean bl3 = false;
                Boolean[] booleanArray = new Boolean[2];
                booleanArray[0] = (Boolean)checkHungryValue.get() != false && (float)player.func_71024_bL().func_75116_a() <= 6.0f;
                booleanArray[1] = (Boolean)checkBlindnessValue.get() != false && player.func_70644_a(MobEffects.field_76440_q);
                Boolean[] $this$none$iv = booleanArray;
                boolean $i$f$none = false;
                for (Boolean element$iv : $this$none$iv) {
                    boolean it = element$iv;
                    boolean bl4 = false;
                    if (!it) continue;
                    bl2 = false;
                    break block3;
                }
                bl2 = true;
            } else {
                bl2 = true;
            }
        }
        return bl2;
    }

    @JvmStatic
    @Nullable
    public static final Integer lockNoSprint(@NotNull String name, @Nullable Integer keepTick) {
        Integer n2;
        Intrinsics.checkNotNullParameter(name, "name");
        Integer n3 = keepTick;
        Integer it = n2 = noSprintLocks.put(name, n3 != null ? n3 : -1);
        boolean bl2 = false;
        if (((Boolean)debugValue.get()).booleanValue()) {
            Integer n4 = keepTick;
            DarkMeow.INSTANCE.getMessageManager().display.displayInfo("LockNoSprint(name=" + name + ", keepTick=" + (n4 != null ? n4 : -1) + ')');
        }
        return n2;
    }

    public static /* synthetic */ Integer lockNoSprint$default(String string, Integer n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n2 = null;
        }
        return Sprint.lockNoSprint(string, n2);
    }

    @JvmStatic
    @Nullable
    public static final Integer unlockNoSprint(@NotNull String name) {
        Integer n2;
        Intrinsics.checkNotNullParameter(name, "name");
        Integer it = n2 = noSprintLocks.remove(name);
        boolean bl2 = false;
        if (((Boolean)debugValue.get()).booleanValue()) {
            DarkMeow.INSTANCE.getMessageManager().display.displayInfo("UnLockNoSprint(name=" + name + ')');
        }
        return n2;
    }

    private static final Integer onMovementInput$lambda$2(String string, Integer value) {
        Intrinsics.checkNotNullParameter(string, "<unused var>");
        Intrinsics.checkNotNullParameter(value, "value");
        int n2 = -1;
        return value != n2 ? Integer.valueOf(value - 1) : value;
    }

    private static final Integer onMovementInput$lambda$3(Function2 $tmp0, Object p0, Object p1) {
        return (Integer)$tmp0.invoke(p0, p1);
    }
}

