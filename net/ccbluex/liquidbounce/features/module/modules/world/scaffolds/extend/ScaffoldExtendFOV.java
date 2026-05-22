/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.world.scaffolds.extend;

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
import net.ccbluex.liquidbounce.features.module.modules.world.scaffolds.ScaffoldExtend;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/extend/ScaffoldExtendFOV;", "Lnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/ScaffoldExtend;", "<init>", "()V", "sizeValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nScaffoldExtendFOV.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScaffoldExtendFOV.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/extend/ScaffoldExtendFOV\n+ 2 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n*L\n1#1,22:1\n12#2,3:23\n*S KotlinDebug\n*F\n+ 1 ScaffoldExtendFOV.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/extend/ScaffoldExtendFOV\n*L\n17#1:23,3\n*E\n"})
public final class ScaffoldExtendFOV
extends ScaffoldExtend {
    @JvmField
    @NotNull
    public final FloatValue sizeValue = new FloatValue("Size", 1.4f, (ClosedRange<Float>)RangesKt.rangeTo(0.0f, 1.5f));

    /*
     * WARNING - void declaration
     */
    public ScaffoldExtendFOV() {
        super("FOV", true);
        void $receiver$iv;
        ListenableOwnerExtends listenableOwnerExtends = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = this;
        Function2<ListenerBase, RenderFovModifierEvent, Unit> function$iv = (arg_0, arg_1) -> ScaffoldExtendFOV._init_$lambda$0(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get((ListenableOwner)$receiver$iv).add(new EventHookOwnerCheck<RenderFovModifierEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(RenderFovModifierEvent.class), (ListenableOwner)$receiver$iv));
    }

    private static final Unit _init_$lambda$0(ScaffoldExtendFOV this$0, ListenerBase $this$listener, RenderFovModifierEvent event) {
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(event, "event");
        event.setReturnValue(Float.valueOf(((Number)event.getReturnValue()).floatValue() * ((Number)this$0.sizeValue.get()).floatValue()));
        return Unit.INSTANCE;
    }
}

