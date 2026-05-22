/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.event.events.render.RenderFovModifierEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.KeyValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0002R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/FOVTweaks;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "fovValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "keyDownValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "keyDownIdValue", "Lnet/ccbluex/liquidbounce/value/impl/KeyValue;", "keyDownFovValue", "getFovSize", "", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nFOVTweaks.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FOVTweaks.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/FOVTweaks\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n*L\n1#1,50:1\n1#2:51\n13#3,2:52\n*S KotlinDebug\n*F\n+ 1 FOVTweaks.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/FOVTweaks\n*L\n34#1:52,2\n*E\n"})
public final class FOVTweaks
extends Module {
    @JvmField
    @NotNull
    public final ListValue modeValue;
    @JvmField
    @NotNull
    public final FloatValue fovValue;
    @JvmField
    @NotNull
    public final BoolValue keyDownValue;
    @JvmField
    @NotNull
    public final KeyValue keyDownIdValue;
    @JvmField
    @NotNull
    public final FloatValue keyDownFovValue;

    /*
     * WARNING - void declaration
     */
    public FOVTweaks() {
        super("FOVTweaks", ModuleCategory.RENDER, null, null, 12, null);
        void priority$iv;
        void $this$listener$iv;
        ListenableOwner $this$keyDownFovValue_u24lambda_u241;
        Object $this$keyDownIdValue_u24lambda_u240;
        Object object = new String[]{"Override", "Multiply"};
        this.modeValue = new ListValue("Mode", (String[])object, "Multiply");
        this.fovValue = new FloatValue("Fov", 1.2f, (ClosedRange<Float>)RangesKt.rangeTo(0.0f, 1.5f));
        this.keyDownValue = new BoolValue("KeyDown", true);
        Object object2 = object = new KeyValue("KeyDownId", "C");
        FOVTweaks fOVTweaks = this;
        boolean bl2 = false;
        $this$keyDownIdValue_u24lambda_u240.setSuperValue(this.keyDownValue);
        fOVTweaks.keyDownIdValue = object;
        $this$keyDownIdValue_u24lambda_u240 = object = new FloatValue("KeyDownFov", 0.2f, (ClosedRange<Float>)RangesKt.rangeTo(0.0f, 1.5f));
        fOVTweaks = this;
        int n2 = 0;
        ((Value)((Object)$this$keyDownFovValue_u24lambda_u241)).setSuperValue(this.keyDownValue);
        fOVTweaks.keyDownFovValue = object;
        object = ListenableOwnerExtends.INSTANCE;
        $this$keyDownFovValue_u24lambda_u241 = this;
        n2 = 1000;
        Function2<ListenerBase, RenderFovModifierEvent, Unit> function$iv = (arg_0, arg_1) -> FOVTweaks._init_$lambda$2(this, arg_0, arg_1);
        boolean $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get((ListenableOwner)$this$listener$iv).add(new EventHookOwnerCheck<RenderFovModifierEvent>((int)priority$iv, function$iv, Reflection.getOrCreateKotlinClass(RenderFovModifierEvent.class), (ListenableOwner)$this$listener$iv));
    }

    private final float getFovSize() {
        if (((Boolean)this.keyDownValue.get()).booleanValue() && this.keyDownIdValue.isKeyDown()) {
            return ((Number)this.keyDownFovValue.get()).floatValue();
        }
        return ((Number)this.fovValue.get()).floatValue();
    }

    private static final Unit _init_$lambda$2(FOVTweaks this$0, ListenerBase $this$listener, RenderFovModifierEvent event) {
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(event, "event");
        String string = (String)this$0.modeValue.get();
        event.setReturnValue(Float.valueOf(Intrinsics.areEqual(string, "Override") ? this$0.getFovSize() : (Intrinsics.areEqual(string, "Multiply") ? ((Number)event.getReturnValue()).floatValue() * this$0.getFovSize() : ((Number)event.getReturnValue()).floatValue())));
        return Unit.INSTANCE;
    }
}

