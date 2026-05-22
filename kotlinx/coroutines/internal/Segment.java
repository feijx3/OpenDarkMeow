/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.NotCompleted;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nJ\r\u0010\u0013\u001a\u00020\u0011H\u0000\u00a2\u0006\u0002\b\u0014J\r\u0010\u0015\u001a\u00020\u0011H\u0000\u00a2\u0006\u0002\b\u0016J\"\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0006\u0010\u001e\u001a\u00020\u0018R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\t\u0010\u000e\u001a\u00020\u000fX\u0082\u0004R\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012\u00a8\u0006\u001f"}, d2={"Lkotlinx/coroutines/internal/Segment;", "S", "Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "Lkotlinx/coroutines/NotCompleted;", "id", "", "prev", "pointers", "", "<init>", "(JLkotlinx/coroutines/internal/Segment;I)V", "numberOfSlots", "getNumberOfSlots", "()I", "cleanedAndPointers", "Lkotlinx/atomicfu/AtomicInt;", "isRemoved", "", "()Z", "tryIncPointers", "tryIncPointers$kotlinx_coroutines_core", "decPointers", "decPointers$kotlinx_coroutines_core", "onCancellation", "", "index", "cause", "", "context", "Lkotlin/coroutines/CoroutineContext;", "onSlotCleaned", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nConcurrentLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/Segment\n+ 2 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n*L\n1#1,265:1\n248#2,4:266\n*S KotlinDebug\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/Segment\n*L\n221#1:266,4\n*E\n"})
public abstract class Segment<S extends Segment<S>>
extends ConcurrentLinkedListNode<S>
implements NotCompleted {
    @JvmField
    public final long id;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;
    private static final /* synthetic */ AtomicIntegerFieldUpdater cleanedAndPointers$volatile$FU;

    public Segment(long id, @Nullable S prev, int pointers) {
        super((ConcurrentLinkedListNode)prev);
        this.id = id;
        this.cleanedAndPointers$volatile = pointers << 16;
    }

    public abstract int getNumberOfSlots();

    private final /* synthetic */ int getCleanedAndPointers$volatile() {
        return this.cleanedAndPointers$volatile;
    }

    private final /* synthetic */ void setCleanedAndPointers$volatile(int value) {
        this.cleanedAndPointers$volatile = value;
    }

    @Override
    public boolean isRemoved() {
        return Segment.cleanedAndPointers$volatile$FU.get(this) == this.getNumberOfSlots() && !this.isTail();
    }

    /*
     * WARNING - void declaration
     */
    public final boolean tryIncPointers$kotlinx_coroutines_core() {
        boolean bl2;
        block1: {
            int cur$iv;
            void handler$atomicfu$iv;
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = Segment.cleanedAndPointers$volatile$FU;
            int delta$iv = 65536;
            do {
                int it = cur$iv = handler$atomicfu$iv.get(this);
                boolean bl3 = false;
                if (it != this.getNumberOfSlots() || this.isTail()) continue;
                bl2 = false;
                break block1;
            } while (!handler$atomicfu$iv.compareAndSet(this, cur$iv, cur$iv + delta$iv));
            bl2 = true;
        }
        return bl2;
    }

    public final boolean decPointers$kotlinx_coroutines_core() {
        return Segment.cleanedAndPointers$volatile$FU.addAndGet(this, -65536) == this.getNumberOfSlots() && !this.isTail();
    }

    public abstract void onCancellation(int var1, @Nullable Throwable var2, @NotNull CoroutineContext var3);

    public final void onSlotCleaned() {
        if (Segment.cleanedAndPointers$volatile$FU.incrementAndGet(this) == this.getNumberOfSlots()) {
            this.remove();
        }
    }

    static {
        cleanedAndPointers$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(Segment.class, "cleanedAndPointers$volatile");
    }
}

