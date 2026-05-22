/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.misc.record_query.state;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.misc.record_query.state.RecordQueryState;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/record_query/state/RecordQueryStateWorking;", "Lnet/ccbluex/liquidbounce/features/module/modules/misc/record_query/state/RecordQueryState;", "name", "", "thread", "Ljava/lang/Thread;", "isInvalid", "", "<init>", "(Ljava/lang/String;Ljava/lang/Thread;Z)V", "getThread", "()Ljava/lang/Thread;", "()Z", "setInvalid", "(Z)V", "DarkMeow"})
public final class RecordQueryStateWorking
extends RecordQueryState {
    @NotNull
    private final Thread thread;
    private boolean isInvalid;

    public RecordQueryStateWorking(@NotNull String name, @NotNull Thread thread2, boolean isInvalid) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(thread2, "thread");
        super(name);
        this.thread = thread2;
        this.isInvalid = isInvalid;
    }

    public /* synthetic */ RecordQueryStateWorking(String string, Thread thread2, boolean bl2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 4) != 0) {
            bl2 = false;
        }
        this(string, thread2, bl2);
    }

    @NotNull
    public final Thread getThread() {
        return this.thread;
    }

    public final boolean isInvalid() {
        return this.isInvalid;
    }

    public final void setInvalid(boolean bl2) {
        this.isInvalid = bl2;
    }
}

