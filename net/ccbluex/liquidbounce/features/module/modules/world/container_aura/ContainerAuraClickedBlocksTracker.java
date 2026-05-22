/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.BlockChest
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.world.container_aura;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.Event;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.event.events.world.WorldSetBlockActionEvent;
import net.ccbluex.liquidbounce.event.events.world.WorldSetBlockStateEvent;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHook;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockChest;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/container_aura/ContainerAuraClickedBlocksTracker;", "Lnet/darkmeow/darkmeow/event/ListenableOwner;", "<init>", "()V", "clickedBlocks", "", "Lnet/minecraft/util/math/BlockPos;", "getClickedBlocks", "()Ljava/util/Set;", "addClicked", "", "pos", "isClicked", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nContainerAuraClickedBlocksTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContainerAuraClickedBlocksTracker.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/container_aura/ContainerAuraClickedBlocksTracker\n+ 2 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n*L\n1#1,31:1\n16#2,3:32\n16#2,3:35\n16#2,3:38\n*S KotlinDebug\n*F\n+ 1 ContainerAuraClickedBlocksTracker.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/container_aura/ContainerAuraClickedBlocksTracker\n*L\n17#1:32,3\n20#1:35,3\n23#1:38,3\n*E\n"})
public final class ContainerAuraClickedBlocksTracker
implements ListenableOwner {
    @NotNull
    private final Set<BlockPos> clickedBlocks = new LinkedHashSet();

    public ContainerAuraClickedBlocksTracker() {
        ListenableOwner $receiver$iv;
        ListenableOwnerExtends listenableOwnerExtends = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = this;
        Function2<ListenerBase, Event, Unit> function$iv = (arg_0, arg_1) -> ContainerAuraClickedBlocksTracker._init_$lambda$0(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$listenerAlways = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHook<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(WorldEvent.class), $receiver$iv));
        ListenableOwnerExtends $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        function$iv = (arg_0, arg_1) -> ContainerAuraClickedBlocksTracker._init_$lambda$1(this, arg_0, arg_1);
        priority$iv = 0;
        $i$f$listenerAlways = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHook<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(WorldSetBlockActionEvent.class), $receiver$iv));
        $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        function$iv = (arg_0, arg_1) -> ContainerAuraClickedBlocksTracker._init_$lambda$2(this, arg_0, arg_1);
        priority$iv = 0;
        $i$f$listenerAlways = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHook<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(WorldSetBlockStateEvent.class), $receiver$iv));
    }

    @NotNull
    public final Set<BlockPos> getClickedBlocks() {
        return this.clickedBlocks;
    }

    public final boolean addClicked(@NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter(pos, "pos");
        return this.clickedBlocks.add(pos);
    }

    public final boolean isClicked(@NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter(pos, "pos");
        return this.clickedBlocks.contains(pos);
    }

    private static final Unit _init_$lambda$0(ContainerAuraClickedBlocksTracker this$0, ListenerBase $this$listenerAlways, WorldEvent it) {
        Intrinsics.checkNotNullParameter($this$listenerAlways, "$this$listenerAlways");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.clickedBlocks.clear();
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$1(ContainerAuraClickedBlocksTracker this$0, ListenerBase $this$listenerAlways, WorldSetBlockActionEvent event) {
        Intrinsics.checkNotNullParameter($this$listenerAlways, "$this$listenerAlways");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getBlock() instanceof BlockChest) {
            this$0.clickedBlocks.add(event.getPos());
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$2(ContainerAuraClickedBlocksTracker this$0, ListenerBase $this$listenerAlways, WorldSetBlockStateEvent event) {
        Intrinsics.checkNotNullParameter($this$listenerAlways, "$this$listenerAlways");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getState().func_177230_c() instanceof BlockAir) {
            this$0.clickedBlocks.remove(event.getPos());
        }
        return Unit.INSTANCE;
    }
}

