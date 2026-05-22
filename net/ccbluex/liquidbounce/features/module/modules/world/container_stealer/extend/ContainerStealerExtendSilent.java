/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package net.ccbluex.liquidbounce.features.module.modules.world.container_stealer.extend;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.events.container.ContainerOpenEvent;
import net.ccbluex.liquidbounce.features.module.modules.world.container_stealer.ContainerStealerExtend;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0006"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/extend/ContainerStealerExtendSilent;", "Lnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/ContainerStealerExtend;", "<init>", "()V", "onDisable", "", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nContainerStealerExtendSilent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContainerStealerExtendSilent.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/extend/ContainerStealerExtendSilent\n+ 2 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n*L\n1#1,22:1\n12#2,3:23\n*S KotlinDebug\n*F\n+ 1 ContainerStealerExtendSilent.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/extend/ContainerStealerExtendSilent\n*L\n18#1:23,3\n*E\n"})
public final class ContainerStealerExtendSilent
extends ContainerStealerExtend {
    /*
     * WARNING - void declaration
     */
    public ContainerStealerExtendSilent() {
        super("Silent", true);
        void $receiver$iv;
        ListenableOwnerExtends listenableOwnerExtends = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = this;
        Function2<ListenerBase, ContainerOpenEvent, Unit> function$iv = (arg_0, arg_1) -> ContainerStealerExtendSilent._init_$lambda$0(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get((ListenableOwner)$receiver$iv).add(new EventHookOwnerCheck<ContainerOpenEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(ContainerOpenEvent.class), (ListenableOwner)$receiver$iv));
    }

    @Override
    public void onDisable() {
        DarkMeow.INSTANCE.getInventoryManager().getContainerManager().closeContainer();
    }

    private static final Unit _init_$lambda$0(ContainerStealerExtendSilent this$0, ListenerBase $this$listener, ContainerOpenEvent event) {
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(event, "event");
        if (this$0.getInstance().allowStealer(event.getGui())) {
            event.setSilent(true);
        }
        return Unit.INSTANCE;
    }
}

