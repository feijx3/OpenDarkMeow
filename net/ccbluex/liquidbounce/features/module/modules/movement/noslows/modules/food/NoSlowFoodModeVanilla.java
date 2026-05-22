/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.noslows.modules.food;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.events.player.move.SlowDownEvent;
import net.ccbluex.liquidbounce.features.module.modules.movement.noslows.NoSlowSubMode;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookSafeOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/food/NoSlowFoodModeVanilla;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/NoSlowSubMode;", "<init>", "()V", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nNoSlowFoodModeVanilla.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoSlowFoodModeVanilla.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/food/NoSlowFoodModeVanilla\n+ 2 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n*L\n1#1,16:1\n20#2,3:17\n*S KotlinDebug\n*F\n+ 1 NoSlowFoodModeVanilla.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/food/NoSlowFoodModeVanilla\n*L\n10#1:17,3\n*E\n"})
public class NoSlowFoodModeVanilla
extends NoSlowSubMode {
    /*
     * WARNING - void declaration
     */
    public NoSlowFoodModeVanilla() {
        super("Vanilla");
        void $receiver$iv;
        ListenableOwnerExtends listenableOwnerExtends = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = this;
        Function2<SafeListenerBase, SlowDownEvent, Unit> function$iv = NoSlowFoodModeVanilla::_init_$lambda$0;
        int priority$iv = 0;
        boolean $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get((ListenableOwner)$receiver$iv).add(new EventHookSafeOwnerCheck<SlowDownEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(SlowDownEvent.class), (ListenableOwner)$receiver$iv));
    }

    private static final Unit _init_$lambda$0(SafeListenerBase $this$safeListener, SlowDownEvent event) {
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(event, "event");
        event.cancelEvent();
        return Unit.INSTANCE;
    }
}

