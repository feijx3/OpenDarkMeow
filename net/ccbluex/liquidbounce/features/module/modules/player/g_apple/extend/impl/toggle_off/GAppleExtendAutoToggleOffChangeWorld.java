/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.impl.toggle_off;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.GAppleExtend;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/impl/toggle_off/GAppleExtendAutoToggleOffChangeWorld;", "Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/GAppleExtend;", "<init>", "()V", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nGAppleExtendAutoToggleOffChangeWorld.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GAppleExtendAutoToggleOffChangeWorld.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/impl/toggle_off/GAppleExtendAutoToggleOffChangeWorld\n+ 2 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n*L\n1#1,16:1\n12#2,3:17\n*S KotlinDebug\n*F\n+ 1 GAppleExtendAutoToggleOffChangeWorld.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/impl/toggle_off/GAppleExtendAutoToggleOffChangeWorld\n*L\n12#1:17,3\n*E\n"})
public final class GAppleExtendAutoToggleOffChangeWorld
extends GAppleExtend {
    /*
     * WARNING - void declaration
     */
    public GAppleExtendAutoToggleOffChangeWorld() {
        super("AutoToggleOffChangeWorld", true);
        void $receiver$iv;
        ListenableOwnerExtends listenableOwnerExtends = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = this;
        Function2<ListenerBase, WorldEvent, Unit> function$iv = (arg_0, arg_1) -> GAppleExtendAutoToggleOffChangeWorld._init_$lambda$0(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get((ListenableOwner)$receiver$iv).add(new EventHookOwnerCheck<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(WorldEvent.class), (ListenableOwner)$receiver$iv));
    }

    private static final Unit _init_$lambda$0(GAppleExtendAutoToggleOffChangeWorld this$0, ListenerBase $this$listener, WorldEvent it) {
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.getInstance().setState(false);
        return Unit.INSTANCE;
    }
}

