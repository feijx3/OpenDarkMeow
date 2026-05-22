/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.kmogus;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import net.darkmeow.kmogus.Ptr;
import net.darkmeow.kmogus.UtilsKt;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u001b"}, d2={"Lnet/darkmeow/kmogus/MemoryTracker;", "", "<init>", "()V", "counter", "Ljava/util/concurrent/atomic/AtomicLong;", "getCounter$kmogus_core", "()Ljava/util/concurrent/atomic/AtomicLong;", "usedMemory", "", "getUsedMemory", "()J", "allocate", "Lnet/darkmeow/kmogus/Ptr;", "size", "allocate-XvKnLUk$kmogus_core", "(J)J", "reallocate", "ptr", "oldSize", "newSize", "reallocate-23RDmD8$kmogus_core", "(JJJ)J", "free", "", "free-FPr3vG0$kmogus_core", "(JJ)V", "kmogus-core"})
@SourceDebugExtension(value={"SMAP\nMemoryTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MemoryTracker.kt\nnet/darkmeow/kmogus/MemoryTracker\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,50:1\n1#2:51\n*E\n"})
public final class MemoryTracker {
    @NotNull
    public static final MemoryTracker INSTANCE = new MemoryTracker();
    @NotNull
    private static final AtomicLong counter = new AtomicLong();

    private MemoryTracker() {
    }

    @NotNull
    public final AtomicLong getCounter$kmogus_core() {
        return counter;
    }

    public final long getUsedMemory() {
        return counter.get();
    }

    public final long allocate-XvKnLUk$kmogus_core(long size) {
        if (!(size >= 0L)) {
            boolean bl2 = false;
            String string = "Invalid size";
            throw new IllegalArgumentException(string.toString());
        }
        if (size == 0L) {
            return Ptr.Companion.getNULL-hthgLag();
        }
        counter.addAndGet(size);
        return Ptr.constructor-impl(UtilsKt.getUNSAFE().allocateMemory(size));
    }

    public final long reallocate-23RDmD8$kmogus_core(long ptr, long oldSize, long newSize) {
        long l2;
        if (!(ptr >= 0L)) {
            boolean $i$a$-require-MemoryTracker$reallocate$52 = false;
            String $i$a$-require-MemoryTracker$reallocate$52 = "Invalid address";
            throw new IllegalArgumentException($i$a$-require-MemoryTracker$reallocate$52.toString());
        }
        if (!(oldSize >= 0L)) {
            boolean $i$a$-require-MemoryTracker$reallocate$62 = false;
            String $i$a$-require-MemoryTracker$reallocate$62 = "Invalid old size";
            throw new IllegalArgumentException($i$a$-require-MemoryTracker$reallocate$62.toString());
        }
        if (!(newSize >= 0L)) {
            boolean $i$a$-require-MemoryTracker$reallocate$72 = false;
            String $i$a$-require-MemoryTracker$reallocate$72 = "Invalid new size";
            throw new IllegalArgumentException($i$a$-require-MemoryTracker$reallocate$72.toString());
        }
        if (newSize == 0L) {
            this.free-FPr3vG0$kmogus_core(ptr, oldSize);
            l2 = Ptr.Companion.getNULL-hthgLag();
        } else if (ptr == 0L) {
            counter.addAndGet(newSize);
            l2 = Ptr.constructor-impl(UtilsKt.getUNSAFE().allocateMemory(newSize));
        } else {
            if (!(oldSize != 0L)) {
                boolean bl2 = false;
                String string = "Invalid old size";
                throw new IllegalArgumentException(string.toString());
            }
            counter.addAndGet(newSize - oldSize);
            l2 = Ptr.constructor-impl(UtilsKt.getUNSAFE().reallocateMemory(ptr, newSize));
        }
        return l2;
    }

    public final void free-FPr3vG0$kmogus_core(long ptr, long size) {
        if (!(ptr >= 0L)) {
            boolean $i$a$-require-MemoryTracker$free$42 = false;
            String $i$a$-require-MemoryTracker$free$42 = "Invalid address";
            throw new IllegalArgumentException($i$a$-require-MemoryTracker$free$42.toString());
        }
        if (!(size >= 0L)) {
            boolean $i$a$-require-MemoryTracker$free$52 = false;
            String $i$a$-require-MemoryTracker$free$52 = "Invalid size";
            throw new IllegalArgumentException($i$a$-require-MemoryTracker$free$52.toString());
        }
        if (ptr == 0L) {
            return;
        }
        if (!(size != 0L)) {
            boolean bl2 = false;
            String string = "Invalid size";
            throw new IllegalArgumentException(string.toString());
        }
        counter.addAndGet(-size);
        UtilsKt.getUNSAFE().freeMemory(ptr);
    }
}

