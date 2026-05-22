/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.handler.update;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lnet/ccbluex/liquidbounce/handler/update/UpdateManager;", "", "<init>", "()V", "scheduledTasks", "", "Ljava/lang/Runnable;", "getScheduledTasks", "()Ljava/util/Set;", "addScheduledTask", "", "runnable", "updateId", "", "getUpdateId", "getUpdateIdNext", "callUpdateEvent", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nUpdateManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UpdateManager.kt\nnet/ccbluex/liquidbounce/handler/update/UpdateManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,28:1\n2756#2:29\n1#3:30\n*S KotlinDebug\n*F\n+ 1 UpdateManager.kt\nnet/ccbluex/liquidbounce/handler/update/UpdateManager\n*L\n20#1:29\n20#1:30\n*E\n"})
public final class UpdateManager {
    @NotNull
    private final Set<Runnable> scheduledTasks = new LinkedHashSet();
    private long updateId;

    @NotNull
    public final Set<Runnable> getScheduledTasks() {
        return this.scheduledTasks;
    }

    public final boolean addScheduledTask(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        return this.scheduledTasks.add(runnable);
    }

    public final long getUpdateId() {
        return this.updateId;
    }

    public final long getUpdateIdNext() {
        long l2 = this.updateId;
        this.updateId = l2 + 1L;
        return l2;
    }

    public final boolean callUpdateEvent(@NotNull EntityPlayerSP player) {
        Iterable iterable;
        Intrinsics.checkNotNullParameter(player, "player");
        Iterable $this$onEach$iv = this.scheduledTasks;
        boolean $i$f$onEach = false;
        Iterable $this$onEach_u24lambda_u2418$iv = iterable = $this$onEach$iv;
        boolean bl2 = false;
        for (Object element$iv : $this$onEach_u24lambda_u2418$iv) {
            Runnable it = (Runnable)element$iv;
            boolean bl3 = false;
            it.run();
        }
        this.scheduledTasks.clear();
        UpdateEvent event = new UpdateEvent(this.getUpdateIdNext(), player);
        EventManager.callEvent$default(DarkMeow.INSTANCE.getEventManager(), event, null, 2, null);
        return event.isCancelled();
    }
}

