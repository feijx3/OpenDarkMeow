/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.MathHelper
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.world.scaffolds.extend;

import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.Event;
import net.ccbluex.liquidbounce.event.events.render.in_game_2d.Render2DItemInFirstPersonEvent;
import net.ccbluex.liquidbounce.event.events.render.math.RenderUpdateArmSwingAnimationSpeedEvent;
import net.ccbluex.liquidbounce.features.module.modules.world.scaffolds.ScaffoldExtend;
import net.ccbluex.liquidbounce.features.module.modules.world.scaffolds.ScaffoldStatic;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookOwnerCheck;
import net.darkmeow.darkmeow.event.hook.EventHookSafeOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/extend/ScaffoldExtendSwingTweak;", "Lnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/ScaffoldExtend;", "<init>", "()V", "heldBlockValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "heldSwordValue", "heldOtherValue", "swingSpeedValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "Companion", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nScaffoldExtendSwingTweak.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScaffoldExtendSwingTweak.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/extend/ScaffoldExtendSwingTweak\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n*L\n1#1,84:1\n37#2:85\n36#2,3:86\n37#2:89\n36#2,3:90\n37#2:93\n36#2,3:94\n20#3,3:97\n12#3,3:100\n*S KotlinDebug\n*F\n+ 1 ScaffoldExtendSwingTweak.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/extend/ScaffoldExtendSwingTweak\n*L\n44#1:85\n44#1:86,3\n47#1:89\n47#1:90,3\n50#1:93\n50#1:94,3\n61#1:97,3\n79#1:100,3\n*E\n"})
public final class ScaffoldExtendSwingTweak
extends ScaffoldExtend {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public final ListValue heldBlockValue;
    @JvmField
    @NotNull
    public final ListValue heldSwordValue;
    @JvmField
    @NotNull
    public final ListValue heldOtherValue;
    @JvmField
    @NotNull
    public final FloatValue swingSpeedValue;
    @NotNull
    private static final Map<String, Function2<EnumHand, Render2DItemInFirstPersonEvent.PRE, Unit>> swingTweakModes;

    public ScaffoldExtendSwingTweak() {
        super("SwingTweak", false);
        ListenableOwner $receiver$iv;
        Object $this$toTypedArray$iv = swingTweakModes.keySet();
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        this.heldBlockValue = new ListValue("HeldBlock", thisCollection$iv.toArray(new String[0]), "Equipped");
        $this$toTypedArray$iv = swingTweakModes.keySet();
        $i$f$toTypedArray = false;
        thisCollection$iv = $this$toTypedArray$iv;
        this.heldSwordValue = new ListValue("HeldSword", thisCollection$iv.toArray(new String[0]), "Swing");
        $this$toTypedArray$iv = swingTweakModes.keySet();
        $i$f$toTypedArray = false;
        thisCollection$iv = $this$toTypedArray$iv;
        this.heldOtherValue = new ListValue("HeldOther", thisCollection$iv.toArray(new String[0]), "Swing");
        this.swingSpeedValue = new FloatValue("SwingSpeed", 1.0f, (ClosedRange<Float>)RangesKt.rangeTo(0.1f, 10.0f));
        $this$toTypedArray$iv = ListenableOwnerExtends.INSTANCE;
        ListenableOwner $i$f$toTypedArray2 = this;
        Function2<ListenerBase, Event, Unit> function$iv = (arg_0, arg_1) -> ScaffoldExtendSwingTweak._init_$lambda$2(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookSafeOwnerCheck<Render2DItemInFirstPersonEvent.PRE>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(Render2DItemInFirstPersonEvent.PRE.class), $receiver$iv));
        ListenableOwnerExtends $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        function$iv = (arg_0, arg_1) -> ScaffoldExtendSwingTweak._init_$lambda$3(this, arg_0, arg_1);
        priority$iv = 0;
        boolean $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookOwnerCheck<Render2DItemInFirstPersonEvent.PRE>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(RenderUpdateArmSwingAnimationSpeedEvent.class), $receiver$iv));
    }

    private static final Unit _init_$lambda$2(ScaffoldExtendSwingTweak this$0, SafeListenerBase $this$safeListener, Render2DItemInFirstPersonEvent.PRE event) {
        block5: {
            String string;
            ItemStack itemStack;
            Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
            Intrinsics.checkNotNullParameter(event, "event");
            EnumHand enumHand = ScaffoldStatic.INSTANCE.getScaffoldPlaceHand($this$safeListener.getPlayer());
            if (enumHand == null) {
                return Unit.INSTANCE;
            }
            EnumHand hand = enumHand;
            switch (WhenMappings.$EnumSwitchMapping$0[hand.ordinal()]) {
                case 1: {
                    Integer n2 = DarkMeow.INSTANCE.getInventoryManager().currentSpoofSlot;
                    itemStack = (ItemStack)$this$safeListener.getPlayer().field_71069_bz.func_75138_a().get(36 + (n2 != null ? n2 : $this$safeListener.getPlayer().field_71071_by.field_70461_c));
                    break;
                }
                case 2: {
                    itemStack = $this$safeListener.getPlayer().func_184586_b(EnumHand.OFF_HAND);
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
            ItemStack stack = itemStack;
            boolean bl2 = false;
            Item item = stack.func_77973_b();
            String mode = string = item instanceof ItemBlock ? (String)this$0.heldBlockValue.get() : (item instanceof ItemSword ? (String)this$0.heldSwordValue.get() : (String)this$0.heldOtherValue.get());
            boolean bl3 = false;
            Function2<EnumHand, Render2DItemInFirstPersonEvent.PRE, Unit> function2 = swingTweakModes.get(mode);
            if (function2 == null) break block5;
            function2.invoke(hand, event);
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$3(ScaffoldExtendSwingTweak this$0, ListenerBase $this$listener, RenderUpdateArmSwingAnimationSpeedEvent event) {
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(event, "event");
        event.setReturnValue(MathHelper.func_76141_d((float)(((Number)event.getReturnValue()).floatValue() * ((Number)this$0.swingSpeedValue.get()).floatValue())));
        return Unit.INSTANCE;
    }

    private static final Unit swingTweakModes$lambda$4(EnumHand enumHand, Render2DItemInFirstPersonEvent.PRE event) {
        Intrinsics.checkNotNullParameter(enumHand, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        event.setSwingProgress(0.0f);
        event.removeEquippedProgressMainHand();
        event.removeEquippedProgressOffHand();
        return Unit.INSTANCE;
    }

    private static final Unit swingTweakModes$lambda$5(EnumHand enumHand, Render2DItemInFirstPersonEvent.PRE event) {
        Intrinsics.checkNotNullParameter(enumHand, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        event.removeEquippedProgressMainHand();
        event.removeEquippedProgressOffHand();
        return Unit.INSTANCE;
    }

    private static final Unit swingTweakModes$lambda$6(EnumHand hand, Render2DItemInFirstPersonEvent.PRE event) {
        Intrinsics.checkNotNullParameter(hand, "hand");
        Intrinsics.checkNotNullParameter(event, "event");
        switch (WhenMappings.$EnumSwitchMapping$0[hand.ordinal()]) {
            case 1: {
                event.setEquippedProgressMainHand(event.getSwingProgress());
                break;
            }
            case 2: {
                event.setEquippedProgressOffHand(event.getSwingProgress());
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        event.setSwingProgress(0.0f);
        return Unit.INSTANCE;
    }

    private static final Unit swingTweakModes$lambda$7(EnumHand enumHand, Render2DItemInFirstPersonEvent.PRE pRE) {
        Intrinsics.checkNotNullParameter(enumHand, "<unused var>");
        Intrinsics.checkNotNullParameter(pRE, "<unused var>");
        return Unit.INSTANCE;
    }

    static {
        Pair[] pairArray = new Pair[]{TuplesKt.to("None", ScaffoldExtendSwingTweak::swingTweakModes$lambda$4), TuplesKt.to("Swing", ScaffoldExtendSwingTweak::swingTweakModes$lambda$5), TuplesKt.to("Equipped", ScaffoldExtendSwingTweak::swingTweakModes$lambda$6), TuplesKt.to("Ignore", ScaffoldExtendSwingTweak::swingTweakModes$lambda$7)};
        swingTweakModes = MapsKt.mutableMapOf(pairArray);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003RM\u0010\u0004\u001a>\u0012\u0004\u0012\u00020\u0006\u00124\u00122\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u00070\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/extend/ScaffoldExtendSwingTweak$Companion;", "", "<init>", "()V", "swingTweakModes", "", "", "Lkotlin/Function2;", "Lnet/minecraft/util/EnumHand;", "Lkotlin/ParameterName;", "name", "hand", "Lnet/ccbluex/liquidbounce/event/events/render/in_game_2d/Render2DItemInFirstPersonEvent$PRE;", "even", "", "getSwingTweakModes", "()Ljava/util/Map;", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Map<String, Function2<EnumHand, Render2DItemInFirstPersonEvent.PRE, Unit>> getSwingTweakModes() {
            return swingTweakModes;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[EnumHand.values().length];
            try {
                nArray[EnumHand.MAIN_HAND.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[EnumHand.OFF_HAND.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

