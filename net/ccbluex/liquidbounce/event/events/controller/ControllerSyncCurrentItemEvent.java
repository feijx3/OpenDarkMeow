/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.controller;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0010\u001a\u00020\bJ\u0014\u0010\u0011\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2={"Lnet/ccbluex/liquidbounce/event/events/controller/ControllerSyncCurrentItemEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "clientSide", "", "serverSide", "postActions", "", "Lkotlin/Function0;", "", "<init>", "(IILjava/util/List;)V", "getClientSide", "()I", "getServerSide", "getPostActions", "()Ljava/util/List;", "invokePostAction", "postAction", "block", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nControllerSyncCurrentItemEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ControllerSyncCurrentItemEvent.kt\nnet/ccbluex/liquidbounce/event/events/controller/ControllerSyncCurrentItemEvent\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,24:1\n1869#2,2:25\n*S KotlinDebug\n*F\n+ 1 ControllerSyncCurrentItemEvent.kt\nnet/ccbluex/liquidbounce/event/events/controller/ControllerSyncCurrentItemEvent\n*L\n17#1:25,2\n*E\n"})
public final class ControllerSyncCurrentItemEvent
extends CancellableEvent {
    private final int clientSide;
    private final int serverSide;
    @NotNull
    private final List<Function0<Unit>> postActions;

    public ControllerSyncCurrentItemEvent(int clientSide, int serverSide, @NotNull List<Function0<Unit>> postActions) {
        Intrinsics.checkNotNullParameter(postActions, "postActions");
        this.clientSide = clientSide;
        this.serverSide = serverSide;
        this.postActions = postActions;
    }

    public /* synthetic */ ControllerSyncCurrentItemEvent(int n2, int n3, List list, int n4, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n4 & 4) != 0) {
            list = new ArrayList();
        }
        this(n2, n3, list);
    }

    public final int getClientSide() {
        return this.clientSide;
    }

    public final int getServerSide() {
        return this.serverSide;
    }

    @NotNull
    public final List<Function0<Unit>> getPostActions() {
        return this.postActions;
    }

    public final void invokePostAction() {
        Iterable $this$forEach$iv = this.postActions;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Function0 it = (Function0)element$iv;
            boolean bl2 = false;
            it.invoke();
        }
        this.postActions.clear();
    }

    public final void postAction(@NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.postActions.add(block);
    }
}

