/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.ranges;

import kotlin.Metadata;
import kotlin.ranges.OpenEndRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0011\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u0012\u001a\u00020\rH\u0016J\u0013\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\n\u00a8\u0006\u001a"}, d2={"Lkotlin/ranges/OpenEndDoubleRange;", "Lkotlin/ranges/OpenEndRange;", "", "start", "endExclusive", "<init>", "(DD)V", "_start", "_endExclusive", "getStart", "()Ljava/lang/Double;", "getEndExclusive", "lessThanOrEquals", "", "a", "b", "contains", "value", "isEmpty", "equals", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"})
final class OpenEndDoubleRange
implements OpenEndRange<Double> {
    private final double _start;
    private final double _endExclusive;

    public OpenEndDoubleRange(double start, double endExclusive) {
        this._start = start;
        this._endExclusive = endExclusive;
    }

    @Override
    @NotNull
    public Double getStart() {
        return this._start;
    }

    @Override
    @NotNull
    public Double getEndExclusive() {
        return this._endExclusive;
    }

    private final boolean lessThanOrEquals(double a2, double b2) {
        return a2 <= b2;
    }

    @Override
    public boolean contains(double value) {
        return value >= this._start && value < this._endExclusive;
    }

    @Override
    public boolean isEmpty() {
        return !(this._start < this._endExclusive);
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof OpenEndDoubleRange && (this.isEmpty() && ((OpenEndDoubleRange)other).isEmpty() || this._start == ((OpenEndDoubleRange)other)._start && this._endExclusive == ((OpenEndDoubleRange)other)._endExclusive);
    }

    public int hashCode() {
        return this.isEmpty() ? -1 : 31 * Double.hashCode(this._start) + Double.hashCode(this._endExclusive);
    }

    @NotNull
    public String toString() {
        return this._start + "..<" + this._endExclusive;
    }
}

