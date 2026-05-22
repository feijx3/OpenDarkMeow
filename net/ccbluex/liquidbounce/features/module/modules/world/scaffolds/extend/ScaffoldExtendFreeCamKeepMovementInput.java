/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package net.ccbluex.liquidbounce.features.module.modules.world.scaffolds.extend;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.features.module.modules.world.scaffolds.ScaffoldExtend;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/extend/ScaffoldExtendFreeCamKeepMovementInput;", "Lnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/ScaffoldExtend;", "<init>", "()V", "lastInputForward", "", "lastInputStrafe", "isKeepWalking", "", "Lnet/darkmeow/darkmeow/event/listenable/ListenerBase;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nScaffoldExtendFreeCamKeepMovementInput.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScaffoldExtendFreeCamKeepMovementInput.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/extend/ScaffoldExtendFreeCamKeepMovementInput\n+ 2 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n*L\n1#1,37:1\n13#2,2:38\n*S KotlinDebug\n*F\n+ 1 ScaffoldExtendFreeCamKeepMovementInput.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/extend/ScaffoldExtendFreeCamKeepMovementInput\n*L\n17#1:38,2\n*E\n"})
public final class ScaffoldExtendFreeCamKeepMovementInput
extends ScaffoldExtend {
    private int lastInputForward;
    private int lastInputStrafe;

    /*
     * WARNING - void declaration
     */
    public ScaffoldExtendFreeCamKeepMovementInput() {
        super("FreeCamKeepMovementInput", true);
        void priority$iv;
        void $this$listener$iv;
        ListenableOwnerExtends listenableOwnerExtends = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = this;
        int n2 = 5000;
        Function2<ListenerBase, MovementInputEvent.PRE, Unit> function$iv = (arg_0, arg_1) -> ScaffoldExtendFreeCamKeepMovementInput._init_$lambda$0(this, arg_0, arg_1);
        boolean $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get((ListenableOwner)$this$listener$iv).add(new EventHookOwnerCheck<MovementInputEvent.PRE>((int)priority$iv, function$iv, Reflection.getOrCreateKotlinClass(MovementInputEvent.PRE.class), (ListenableOwner)$this$listener$iv));
    }

    private final boolean isKeepWalking(ListenerBase $this$isKeepWalking) {
        return !Intrinsics.areEqual($this$isKeepWalking.getRenderViewEntity(), $this$isKeepWalking.getPlayer());
    }

    private static final Unit _init_$lambda$0(ScaffoldExtendFreeCamKeepMovementInput this$0, ListenerBase $this$listener, MovementInputEvent.PRE event) {
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(event, "event");
        if (this$0.isKeepWalking($this$listener)) {
            event.setKeyStateForward(this$0.lastInputForward == 1);
            event.setKeyStateBack(this$0.lastInputForward == -1);
            event.setKeyStateLeft(this$0.lastInputStrafe == 1);
            event.setKeyStateRight(this$0.lastInputStrafe == -1);
        } else {
            int n2;
            this$0.lastInputForward = 0;
            this$0.lastInputStrafe = 0;
            if (event.getKeyStateForward()) {
                n2 = this$0.lastInputForward;
                this$0.lastInputForward = n2 + 1;
            }
            if (event.getKeyStateBack()) {
                n2 = this$0.lastInputForward;
                this$0.lastInputForward = n2 + -1;
            }
            if (event.getKeyStateLeft()) {
                n2 = this$0.lastInputStrafe;
                this$0.lastInputStrafe = n2 + 1;
            }
            if (event.getKeyStateRight()) {
                n2 = this$0.lastInputStrafe;
                this$0.lastInputStrafe = n2 + -1;
            }
        }
        return Unit.INSTANCE;
    }
}

