/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyIterator;
import kotlin.collections.RingBuffer;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001aD\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u0006\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0000\u001aH\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\r\"\u0004\b\u0000\u0010\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\b0\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0000\u00a8\u0006\u000f"}, d2={"checkWindowSizeStep", "", "size", "", "step", "windowedSequence", "Lkotlin/sequences/Sequence;", "", "T", "partialWindows", "", "reuseBuffer", "windowedIterator", "", "iterator", "kotlin-stdlib"})
public final class SlidingWindowKt {
    public static final void checkWindowSizeStep(int size, int step) {
        if (!(size > 0 && step > 0)) {
            boolean bl2 = false;
            String string = size != step ? "Both size " + size + " and step " + step + " must be greater than zero." : "size " + size + " must be greater than zero.";
            throw new IllegalArgumentException(string.toString());
        }
    }

    @NotNull
    public static final <T> Sequence<List<T>> windowedSequence(@NotNull Sequence<? extends T> $this$windowedSequence, int size, int step, boolean partialWindows, boolean reuseBuffer) {
        Intrinsics.checkNotNullParameter($this$windowedSequence, "<this>");
        SlidingWindowKt.checkWindowSizeStep(size, step);
        return new Sequence<List<? extends T>>($this$windowedSequence, size, step, partialWindows, reuseBuffer){
            final /* synthetic */ Sequence $this_windowedSequence$inlined;
            final /* synthetic */ int $size$inlined;
            final /* synthetic */ int $step$inlined;
            final /* synthetic */ boolean $partialWindows$inlined;
            final /* synthetic */ boolean $reuseBuffer$inlined;
            {
                this.$this_windowedSequence$inlined = sequence;
                this.$size$inlined = n2;
                this.$step$inlined = n3;
                this.$partialWindows$inlined = bl2;
                this.$reuseBuffer$inlined = bl3;
            }

            public Iterator<List<? extends T>> iterator() {
                boolean bl2 = false;
                return SlidingWindowKt.windowedIterator(this.$this_windowedSequence$inlined.iterator(), this.$size$inlined, this.$step$inlined, this.$partialWindows$inlined, this.$reuseBuffer$inlined);
            }
        };
    }

    @NotNull
    public static final <T> Iterator<List<T>> windowedIterator(@NotNull Iterator<? extends T> iterator2, int size, int step, boolean partialWindows, boolean reuseBuffer) {
        Intrinsics.checkNotNullParameter(iterator2, "iterator");
        if (!iterator2.hasNext()) {
            return EmptyIterator.INSTANCE;
        }
        return SequencesKt.iterator(new Function2<SequenceScope<? super List<? extends T>>, Continuation<? super Unit>, Object>(size, step, iterator2, reuseBuffer, partialWindows, null){
            Object L$1;
            Object L$2;
            Object L$3;
            int I$0;
            int I$1;
            int I$2;
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ int $size;
            final /* synthetic */ int $step;
            final /* synthetic */ Iterator<T> $iterator;
            final /* synthetic */ boolean $reuseBuffer;
            final /* synthetic */ boolean $partialWindows;
            {
                this.$size = $size;
                this.$step = $step;
                this.$iterator = $iterator;
                this.$reuseBuffer = $reuseBuffer;
                this.$partialWindows = $partialWindows;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            public final Object invokeSuspend(Object $result) {
                var2_2 = (SequenceScope)this.L$0;
                var9_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure($result);
                        bufferInitialCapacity = RangesKt.coerceAtMost(this.$size, 1024);
                        gap = this.$step - this.$size;
                        if (gap < 0) break;
                        buffer = new ArrayList<Object>(bufferInitialCapacity);
                        skip = 0;
                        var7_17 = this.$iterator;
lbl12:
                        // 4 sources

                        while (var7_17.hasNext()) {
                            e = var7_17.next();
                            if (skip > 0) {
                                --skip;
                                continue;
                            }
                            buffer.add(e);
                            if (buffer.size() != this.$size) continue;
                            this.L$0 = $this$iterator;
                            this.L$1 = buffer;
                            this.L$2 = var7_17;
                            this.L$3 = SpillingKt.nullOutSpilledVariable(e);
                            this.I$0 = bufferInitialCapacity;
                            this.I$1 = gap;
                            this.I$2 = skip;
                            this.label = 1;
                            v0 = $this$iterator.yield(buffer, this);
                            if (v0 == var9_3) {
                                return var9_3;
                            }
                            ** GOTO lbl42
                        }
                        break;
                    }
                    case 1: {
                        skip = this.I$2;
                        gap = this.I$1;
                        bufferInitialCapacity = this.I$0;
                        e = this.L$3;
                        var7_17 = (Iterator<T>)this.L$2;
                        buffer = (ArrayList<Object>)this.L$1;
                        ResultKt.throwOnFailure($result);
                        v0 = $result;
lbl42:
                        // 2 sources

                        if (this.$reuseBuffer) {
                            buffer.clear();
                        } else {
                            buffer = new ArrayList<Object>(this.$size);
                        }
                        skip = gap;
                        ** GOTO lbl12
                    }
                }
                if (((Collection)buffer).isEmpty() == false && (this.$partialWindows || buffer.size() == this.$size)) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$iterator);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(buffer);
                    this.L$2 = null;
                    this.L$3 = null;
                    this.I$0 = bufferInitialCapacity;
                    this.I$1 = gap;
                    this.I$2 = skip;
                    this.label = 2;
                    v1 = $this$iterator.yield(buffer, this);
                    if (v1 == var9_3) {
                        return var9_3;
                    }
                }
                ** GOTO lbl140
                {
                    case 2: {
                        skip = this.I$2;
                        gap = this.I$1;
                        bufferInitialCapacity = this.I$0;
                        buffer = (ArrayList)this.L$1;
                        ResultKt.throwOnFailure($result);
                        v1 = $result;
                        ** GOTO lbl140
                    }
                }
                buffer = new RingBuffer<Object>(bufferInitialCapacity);
                var6_16 = this.$iterator;
lbl71:
                // 4 sources

                while (var6_16.hasNext()) {
                    e = var6_16.next();
                    buffer.add(e);
                    if (!buffer.isFull()) continue;
                    if (buffer.size() < this.$size) {
                        buffer = buffer.expanded(this.$size);
                        continue;
                    }
                    this.L$0 = $this$iterator;
                    this.L$1 = buffer;
                    this.L$2 = var6_16;
                    this.L$3 = SpillingKt.nullOutSpilledVariable(e);
                    this.I$0 = bufferInitialCapacity;
                    this.I$1 = gap;
                    this.label = 3;
                    v2 = $this$iterator.yield(this.$reuseBuffer != false ? (List)buffer : (List)new ArrayList<E>((Collection)buffer), this);
                    if (v2 == var9_3) {
                        return var9_3;
                    }
                    ** GOTO lbl98
                }
                {
                    break;
                    case 3: {
                        gap = this.I$1;
                        bufferInitialCapacity = this.I$0;
                        e = this.L$3;
                        var6_16 = (Iterator<T>)this.L$2;
                        buffer = (RingBuffer)this.L$1;
                        ResultKt.throwOnFailure($result);
                        v2 = $result;
lbl98:
                        // 2 sources

                        buffer.removeFirst(this.$step);
                        ** GOTO lbl71
                    }
                }
                if (!this.$partialWindows) ** GOTO lbl140
lbl101:
                // 2 sources

                while (buffer.size() > this.$step) {
                    this.L$0 = $this$iterator;
                    this.L$1 = buffer;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.I$0 = bufferInitialCapacity;
                    this.I$1 = gap;
                    this.label = 4;
                    v3 = $this$iterator.yield(this.$reuseBuffer != false ? (List)buffer : (List)new ArrayList<E>((Collection)buffer), this);
                    if (v3 == var9_3) {
                        return var9_3;
                    }
                    ** GOTO lbl120
                }
                {
                    break;
                    case 4: {
                        gap = this.I$1;
                        bufferInitialCapacity = this.I$0;
                        buffer = (RingBuffer<Object>)this.L$1;
                        ResultKt.throwOnFailure($result);
                        v3 = $result;
lbl120:
                        // 2 sources

                        buffer.removeFirst(this.$step);
                        ** GOTO lbl101
                    }
                }
                if (((Collection)buffer).isEmpty() == false) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$iterator);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(buffer);
                    this.L$2 = null;
                    this.L$3 = null;
                    this.I$0 = bufferInitialCapacity;
                    this.I$1 = gap;
                    this.label = 5;
                    v4 = $this$iterator.yield(buffer, this);
                    if (v4 == var9_3) {
                        return var9_3;
                    }
                }
                ** GOTO lbl140
                {
                    case 5: {
                        gap = this.I$1;
                        bufferInitialCapacity = this.I$0;
                        buffer = (RingBuffer)this.L$1;
                        ResultKt.throwOnFailure($result);
                        v4 = $result;
lbl140:
                        // 5 sources

                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
                Function2<SequenceScope<? super List<? extends T>>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)((Object)function2);
            }

            public final Object invoke(SequenceScope<? super List<? extends T>> p1, Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        });
    }
}

