/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.ranges;

import kotlin.Metadata;
import kotlin.ranges.ClosedFloatingPointRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0011\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u0012\u001a\u00020\rH\u0016J\u0013\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\n\u00a8\u0006\u001a"}, d2={"Lkotlin/ranges/ClosedFloatRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "start", "endInclusive", "<init>", "(FF)V", "_start", "_endInclusive", "getStart", "()Ljava/lang/Float;", "getEndInclusive", "lessThanOrEquals", "", "a", "b", "contains", "value", "isEmpty", "equals", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"})
final class ClosedFloatRange
implements ClosedFloatingPointRange<Float> {
    private final float _start;
    private final float _endInclusive;

    public ClosedFloatRange(float start, float endInclusive) {
        this._start = start;
        this._endInclusive = endInclusive;
    }

    @Override
    @NotNull
    public Float getStart() {
        return Float.valueOf(this._start);
    }

    @Override
    @NotNull
    public Float getEndInclusive() {
        return Float.valueOf(this._endInclusive);
    }

    @Override
    public boolean lessThanOrEquals(float a2, float b2) {
        return a2 <= b2;
    }

    @Override
    public boolean contains(float value) {
        return value >= this._start && value <= this._endInclusive;
    }

    @Override
    public boolean isEmpty() {
        return !(this._start <= this._endInclusive);
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof ClosedFloatRange && (this.isEmpty() && ((ClosedFloatRange)other).isEmpty() || this._start == ((ClosedFloatRange)other)._start && this._endInclusive == ((ClosedFloatRange)other)._endInclusive);
    }

    public int hashCode() {
        return this.isEmpty() ? -1 : 31 * Float.hashCode(this._start) + Float.hashCode(this._endInclusive);
    }

    @NotNull
    public String toString() {
        return this._start + ".." + this._endInclusive;
    }
}

