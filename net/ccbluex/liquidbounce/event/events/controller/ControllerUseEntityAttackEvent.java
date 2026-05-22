/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.controller;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001BL\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012)\b\u0002\u0010\b\u001a#\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\r0\n0\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u001a\u001a\u00020\rJ)\u0010\u001b\u001a\u00020\r2!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\r0\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R2\u0010\b\u001a#\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\r0\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2={"Lnet/ccbluex/liquidbounce/event/events/controller/ControllerUseEntityAttackEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "target", "Lnet/minecraft/entity/Entity;", "cancelSyncCurrentItem", "", "postActions", "", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "<init>", "(Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/entity/Entity;ZLjava/util/List;)V", "getPlayer", "()Lnet/minecraft/entity/player/EntityPlayer;", "getTarget", "()Lnet/minecraft/entity/Entity;", "getCancelSyncCurrentItem", "()Z", "setCancelSyncCurrentItem", "(Z)V", "getPostActions", "()Ljava/util/List;", "invokePostAction", "postAction", "block", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nControllerUseEntityAttackEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ControllerUseEntityAttackEvent.kt\nnet/ccbluex/liquidbounce/event/events/controller/ControllerUseEntityAttackEvent\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,20:1\n1869#2,2:21\n*S KotlinDebug\n*F\n+ 1 ControllerUseEntityAttackEvent.kt\nnet/ccbluex/liquidbounce/event/events/controller/ControllerUseEntityAttackEvent\n*L\n14#1:21,2\n*E\n"})
public final class ControllerUseEntityAttackEvent
extends CancellableEvent {
    @NotNull
    private final EntityPlayer player;
    @NotNull
    private final Entity target;
    private boolean cancelSyncCurrentItem;
    @NotNull
    private final List<Function1<Entity, Unit>> postActions;

    public ControllerUseEntityAttackEvent(@NotNull EntityPlayer player, @NotNull Entity target, boolean cancelSyncCurrentItem, @NotNull List<Function1<Entity, Unit>> postActions) {
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(postActions, "postActions");
        this.player = player;
        this.target = target;
        this.cancelSyncCurrentItem = cancelSyncCurrentItem;
        this.postActions = postActions;
    }

    public /* synthetic */ ControllerUseEntityAttackEvent(EntityPlayer entityPlayer, Entity entity, boolean bl2, List list, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 4) != 0) {
            bl2 = false;
        }
        if ((n2 & 8) != 0) {
            list = new ArrayList();
        }
        this(entityPlayer, entity, bl2, list);
    }

    @NotNull
    public final EntityPlayer getPlayer() {
        return this.player;
    }

    @NotNull
    public final Entity getTarget() {
        return this.target;
    }

    public final boolean getCancelSyncCurrentItem() {
        return this.cancelSyncCurrentItem;
    }

    public final void setCancelSyncCurrentItem(boolean bl2) {
        this.cancelSyncCurrentItem = bl2;
    }

    @NotNull
    public final List<Function1<Entity, Unit>> getPostActions() {
        return this.postActions;
    }

    public final void invokePostAction() {
        Iterable $this$forEach$iv = this.postActions;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Function1 it = (Function1)element$iv;
            boolean bl2 = false;
            it.invoke(this.target);
        }
    }

    public final void postAction(@NotNull Function1<? super Entity, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.postActions.add(block);
    }
}

