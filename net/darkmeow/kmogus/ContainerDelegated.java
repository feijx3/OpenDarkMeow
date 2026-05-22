/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package net.darkmeow.kmogus;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import net.darkmeow.kmogus.MemoryTracker;
import net.darkmeow.kmogus.Ptr;
import net.darkmeow.kmogus.UtilsKt;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0010R\u001c\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b\u00a8\u0006\u0015"}, d2={"Lnet/darkmeow/kmogus/ContainerDelegated;", "", "ptr", "Lnet/darkmeow/kmogus/Ptr;", "length", "", "<init>", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPtr-hthgLag", "()J", "setPtr-4d6bxmI", "(J)V", "J", "getLength", "setLength", "realloc", "", "newLength", "init", "", "free", "kmogus-core"})
@SourceDebugExtension(value={"SMAP\nArr.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Arr.kt\nnet/darkmeow/kmogus/ContainerDelegated\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,111:1\n1#2:112\n*E\n"})
public final class ContainerDelegated {
    private volatile long ptr;
    private volatile long length;

    private ContainerDelegated(long ptr, long length) {
        this.ptr = ptr;
        this.length = length;
    }

    public final long getPtr-hthgLag() {
        return this.ptr;
    }

    public final void setPtr-4d6bxmI(long l2) {
        this.ptr = l2;
    }

    public final long getLength() {
        return this.length;
    }

    public final void setLength(long l2) {
        this.length = l2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void realloc(long newLength, boolean init) {
        if (!(newLength >= 0L)) {
            boolean $i$a$-require-ContainerDelegated$realloc$22 = false;
            String $i$a$-require-ContainerDelegated$realloc$22 = "Length must be positive or zero";
            throw new IllegalArgumentException($i$a$-require-ContainerDelegated$realloc$22.toString());
        }
        ContainerDelegated containerDelegated = this;
        synchronized (containerDelegated) {
            boolean bl2 = false;
            if (newLength == this.length) {
                return;
            }
            this.ptr = MemoryTracker.INSTANCE.reallocate-23RDmD8$kmogus_core(this.ptr, this.length, newLength);
            if (init && newLength > this.length) {
                UtilsKt.getUNSAFE().setMemory(this.ptr + this.length, newLength - this.length, (byte)0);
            }
            this.length = newLength;
            Unit unit = Unit.INSTANCE;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void free() {
        ContainerDelegated containerDelegated = this;
        synchronized (containerDelegated) {
            boolean bl2 = false;
            MemoryTracker.INSTANCE.free-FPr3vG0$kmogus_core(this.ptr, this.length);
            this.ptr = Ptr.Companion.getNULL-hthgLag();
            this.length = 0L;
            Unit unit = Unit.INSTANCE;
        }
    }

    public /* synthetic */ ContainerDelegated(long ptr, long length, DefaultConstructorMarker $constructor_marker) {
        this(ptr, length);
    }
}

