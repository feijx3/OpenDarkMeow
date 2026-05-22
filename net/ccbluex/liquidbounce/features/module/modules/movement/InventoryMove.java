/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.gui.GuiChat
 *  net.minecraft.client.gui.GuiCommandBlock
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.inventory.GuiEditSign
 *  net.minecraft.client.gui.inventory.GuiEditStructure
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.input.Keyboard
 */
package net.ccbluex.liquidbounce.features.module.modules.movement;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.utils.KeyUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookSafeOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.darkmeow.darkmeow.ui.IDarkGui;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiCommandBlock;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiEditSign;
import net.minecraft.client.gui.inventory.GuiEditStructure;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.input.Keyboard;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0007R!\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00060\u0005\u00a2\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/InventoryMove;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "excludeScreen", "", "Ljava/lang/Class;", "Lnet/minecraft/client/gui/GuiScreen;", "getExcludeScreen", "()[Ljava/lang/Class;", "[Ljava/lang/Class;", "jumpValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "sneakValue", "rotateValue", "rotateSpeedValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "check", "", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nInventoryMove.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InventoryMove.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/InventoryMove\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n*L\n1#1,75:1\n1#2:76\n21#3,2:77\n*S KotlinDebug\n*F\n+ 1 InventoryMove.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/InventoryMove\n*L\n44#1:77,2\n*E\n"})
public final class InventoryMove
extends Module {
    @NotNull
    public static final InventoryMove INSTANCE;
    @NotNull
    private static final Class<? extends GuiScreen>[] excludeScreen;
    @JvmField
    @NotNull
    public static final BoolValue jumpValue;
    @JvmField
    @NotNull
    public static final BoolValue sneakValue;
    @JvmField
    @NotNull
    public static final BoolValue rotateValue;
    @JvmField
    @NotNull
    public static final FloatValue rotateSpeedValue;

    private InventoryMove() {
        super("InventoryMove", ModuleCategory.MOVEMENT, null, null, 12, null);
    }

    @NotNull
    public final Class<? extends GuiScreen>[] getExcludeScreen() {
        return excludeScreen;
    }

    public final boolean check(@NotNull GuiScreen $this$check) {
        Intrinsics.checkNotNullParameter($this$check, "<this>");
        return $this$check instanceof IDarkGui || ArraysKt.contains(excludeScreen, $this$check.getClass());
    }

    /*
     * Unable to fully structure code
     */
    private static final Unit _init_$lambda$2(SafeListenerBase $this$safeListener, MovementInputEvent.PRE event) {
        block18: {
            Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
            Intrinsics.checkNotNullParameter(event, "event");
            v0 = $this$safeListener.getMc().field_71462_r;
            v1 = v0 != null ? InventoryMove.INSTANCE.check(v0) : false;
            if (v1) {
                return Unit.INSTANCE;
            }
            if (!$this$safeListener.getPlayer().func_70089_S() || $this$safeListener.getPlayer().field_70173_aa < 2) {
                return Unit.INSTANCE;
            }
            if (event.getKeyStateForward()) ** GOTO lbl-1000
            v2 = $this$safeListener.getMc().field_71474_y.field_74351_w;
            Intrinsics.checkNotNullExpressionValue(v2, "keyBindForward");
            if (KeyUtils.INSTANCE.isKeyDownSystem(v2)) lbl-1000:
            // 2 sources

            {
                v3 = true;
            } else {
                v3 = false;
            }
            event.setKeyStateForward(v3);
            if (event.getKeyStateBack()) ** GOTO lbl-1000
            v4 = $this$safeListener.getMc().field_71474_y.field_74368_y;
            Intrinsics.checkNotNullExpressionValue(v4, "keyBindBack");
            if (KeyUtils.INSTANCE.isKeyDownSystem(v4)) lbl-1000:
            // 2 sources

            {
                v5 = true;
            } else {
                v5 = false;
            }
            event.setKeyStateBack(v5);
            if (event.getKeyStateLeft()) ** GOTO lbl-1000
            v6 = $this$safeListener.getMc().field_71474_y.field_74370_x;
            Intrinsics.checkNotNullExpressionValue(v6, "keyBindLeft");
            if (KeyUtils.INSTANCE.isKeyDownSystem(v6)) lbl-1000:
            // 2 sources

            {
                v7 = true;
            } else {
                v7 = false;
            }
            event.setKeyStateLeft(v7);
            if (event.getKeyStateRight()) ** GOTO lbl-1000
            v8 = $this$safeListener.getMc().field_71474_y.field_74366_z;
            Intrinsics.checkNotNullExpressionValue(v8, "keyBindRight");
            if (KeyUtils.INSTANCE.isKeyDownSystem(v8)) lbl-1000:
            // 2 sources

            {
                v9 = true;
            } else {
                v9 = false;
            }
            event.setKeyStateRight(v9);
            if (!((Boolean)InventoryMove.jumpValue.get()).booleanValue()) break block18;
            if (event.getKeyStateJump()) ** GOTO lbl-1000
            v10 = $this$safeListener.getMc().field_71474_y.field_74314_A;
            Intrinsics.checkNotNullExpressionValue(v10, "keyBindJump");
            if (KeyUtils.INSTANCE.isKeyDownSystem(v10)) lbl-1000:
            // 2 sources

            {
                v11 = true;
            } else {
                v11 = false;
            }
            event.setKeyStateJump(v11);
        }
        if (((Boolean)InventoryMove.sneakValue.get()).booleanValue()) {
            v12 = $this$safeListener.getMc().field_71474_y.field_74311_E;
            Intrinsics.checkNotNullExpressionValue(v12, "keyBindSneak");
            state = var2_2 = KeyUtils.INSTANCE.isKeyDownSystem(v12);
            $i$a$-also-InventoryMove$1$1 = false;
            event.setKeyStateSneak(state);
            event.shouldApplySneakSlow = state;
        }
        if (((Boolean)InventoryMove.rotateValue.get()).booleanValue()) {
            rotateSpeed = ((Number)InventoryMove.rotateSpeedValue.get()).floatValue();
            if (Keyboard.isKeyDown((int)203)) {
                var3_5 = $this$safeListener.getPlayer();
                var3_5.field_70177_z -= rotateSpeed;
            }
            if (Keyboard.isKeyDown((int)205)) {
                var3_6 = $this$safeListener.getPlayer();
                var3_6.field_70177_z += rotateSpeed;
            }
            if (Keyboard.isKeyDown((int)200)) {
                $this$safeListener.getPlayer().field_70125_A = RangesKt.coerceAtLeast($this$safeListener.getPlayer().field_70125_A - rotateSpeed, -90.0f);
            }
            if (Keyboard.isKeyDown((int)208)) {
                $this$safeListener.getPlayer().field_70125_A = RangesKt.coerceAtMost($this$safeListener.getPlayer().field_70125_A + rotateSpeed, 90.0f);
            }
        }
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    static {
        void priority$iv;
        void $this$safeListener$iv;
        INSTANCE = new InventoryMove();
        Object object = new Class[]{GuiChat.class, GuiEditSign.class, GuiEditStructure.class, GuiCommandBlock.class};
        excludeScreen = object;
        jumpValue = new BoolValue("Jump", true);
        sneakValue = new BoolValue("Sneak", true);
        rotateValue = new BoolValue("Rotate", true);
        Object $this$rotateSpeedValue_u24lambda_u240 = object = new FloatValue("RotateSpeed", 10.0f, (ClosedRange<Float>)RangesKt.rangeTo(1.0f, 90.0f));
        int n2 = 0;
        ((Value)$this$rotateSpeedValue_u24lambda_u240).setSuperValue(rotateValue);
        rotateSpeedValue = object;
        object = ListenableOwnerExtends.INSTANCE;
        $this$rotateSpeedValue_u24lambda_u240 = INSTANCE;
        n2 = 9999;
        Function2<SafeListenerBase, MovementInputEvent.PRE, Unit> function$iv = InventoryMove::_init_$lambda$2;
        boolean $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get((ListenableOwner)$this$safeListener$iv).add(new EventHookSafeOwnerCheck<MovementInputEvent.PRE>((int)priority$iv, function$iv, Reflection.getOrCreateKotlinClass(MovementInputEvent.PRE.class), (ListenableOwner)$this$safeListener$iv));
    }
}

