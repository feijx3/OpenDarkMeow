/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmInline
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.Segment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@JvmInline
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081@\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\u00028\u00008F\u00a2\u0006\f\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u0088\u0001\u0004\u0092\u0001\u0004\u0018\u00010\u0003\u00a8\u0006\u0016"}, d2={"Lkotlinx/coroutines/internal/SegmentOrClosed;", "S", "Lkotlinx/coroutines/internal/Segment;", "", "value", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "isClosed", "", "isClosed-impl", "(Ljava/lang/Object;)Z", "segment", "getSegment$annotations", "()V", "getSegment-impl", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/Segment;", "equals", "other", "hashCode", "", "toString", "", "kotlinx-coroutines-core"})
public final class SegmentOrClosed<S extends Segment<S>> {
    @Nullable
    private final Object value;

    public static final boolean isClosed-impl(Object arg0) {
        return arg0 == ConcurrentLinkedListKt.access$getCLOSED$p();
    }

    @NotNull
    public static final S getSegment-impl(Object arg0) {
        if (arg0 == ConcurrentLinkedListKt.access$getCLOSED$p()) {
            throw new IllegalStateException("Does not contain segment".toString());
        }
        Object object = arg0;
        Intrinsics.checkNotNull(object, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (Segment)object;
    }

    public static /* synthetic */ void getSegment$annotations() {
    }

    public static String toString-impl(Object arg0) {
        return "SegmentOrClosed(value=" + arg0 + ')';
    }

    public String toString() {
        return SegmentOrClosed.toString-impl(this.value);
    }

    public static int hashCode-impl(Object arg0) {
        Object object = arg0;
        return object == null ? 0 : object.hashCode();
    }

    public int hashCode() {
        return SegmentOrClosed.hashCode-impl(this.value);
    }

    public static boolean equals-impl(Object arg0, Object other) {
        if (!(other instanceof SegmentOrClosed)) {
            return false;
        }
        return Intrinsics.areEqual(arg0, ((SegmentOrClosed)other).unbox-impl());
    }

    public boolean equals(Object other) {
        return SegmentOrClosed.equals-impl(this.value, other);
    }

    private /* synthetic */ SegmentOrClosed(Object value) {
        this.value = value;
    }

    @NotNull
    public static <S extends Segment<S>> Object constructor-impl(@Nullable Object value) {
        return value;
    }

    public static final /* synthetic */ SegmentOrClosed box-impl(Object v2) {
        return new SegmentOrClosed(v2);
    }

    public final /* synthetic */ Object unbox-impl() {
        return this.value;
    }

    public static final boolean equals-impl0(Object p1, Object p2) {
        return Intrinsics.areEqual(p1, p2);
    }
}

