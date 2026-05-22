/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.world.container_stealer.extend;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.features.module.modules.world.container_stealer.ContainerStealerExtend;
import net.ccbluex.liquidbounce.features.module.modules.world.container_stealer.enums.EnumPreStealerAction;
import net.ccbluex.liquidbounce.utils.MovementUtils;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import net.minecraft.client.gui.inventory.GuiContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u0011"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/extend/ContainerStealerExtendCancelMovementInput;", "Lnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/ContainerStealerExtend;", "<init>", "()V", "active", "", "getActive", "()Z", "setActive", "(Z)V", "onEnable", "", "preStealer", "Lnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/enums/EnumPreStealerAction;", "screen", "Lnet/minecraft/client/gui/inventory/GuiContainer;", "postContainerClose", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nContainerStealerExtendCancelMovementInput.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContainerStealerExtendCancelMovementInput.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/extend/ContainerStealerExtendCancelMovementInput\n+ 2 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n*L\n1#1,35:1\n12#2,3:36\n*S KotlinDebug\n*F\n+ 1 ContainerStealerExtendCancelMovementInput.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/extend/ContainerStealerExtendCancelMovementInput\n*L\n31#1:36,3\n*E\n"})
public final class ContainerStealerExtendCancelMovementInput
extends ContainerStealerExtend {
    private boolean active;

    /*
     * WARNING - void declaration
     */
    public ContainerStealerExtendCancelMovementInput() {
        super("CancelMovementInput", false);
        void $receiver$iv;
        ListenableOwnerExtends listenableOwnerExtends = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = this;
        Function2<ListenerBase, MovementInputEvent.POST, Unit> function$iv = (arg_0, arg_1) -> ContainerStealerExtendCancelMovementInput._init_$lambda$0(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get((ListenableOwner)$receiver$iv).add(new EventHookOwnerCheck<MovementInputEvent.POST>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(MovementInputEvent.POST.class), (ListenableOwner)$receiver$iv));
    }

    public final boolean getActive() {
        return this.active;
    }

    public final void setActive(boolean bl2) {
        this.active = bl2;
    }

    @Override
    public void onEnable() {
        this.active = false;
    }

    @Override
    @Nullable
    public EnumPreStealerAction preStealer(@NotNull GuiContainer screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        this.active = true;
        return null;
    }

    @Override
    public void postContainerClose() {
        this.active = false;
    }

    private static final Unit _init_$lambda$0(ContainerStealerExtendCancelMovementInput this$0, ListenerBase $this$listener, MovementInputEvent.POST event) {
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(event, "event");
        if (this$0.active) {
            MovementUtils.INSTANCE.reset(event.getMovementInput());
        }
        return Unit.INSTANCE;
    }
}

