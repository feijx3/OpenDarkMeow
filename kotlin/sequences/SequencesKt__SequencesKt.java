/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.SinceKotlin
 *  kotlin.internal.InlineOnly
 *  kotlin.internal.LowPriorityInOverloadResolution
 *  kotlin.jvm.JvmName
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.sequences;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.internal.InlineOnly;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.sequences.ConstrainedOnceSequence;
import kotlin.sequences.EmptySequence;
import kotlin.sequences.FlatteningSequence;
import kotlin.sequences.GeneratorSequence;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.SequencesKt__SequencesJVMKt;
import kotlin.sequences.TransformingSequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=5, xi=49, d1={"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u0087\b\u00f8\u0001\u0000\u001a\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a+\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\t\"\u0002H\u0002\u00a2\u0006\u0002\u0010\n\u001a!\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000b\u001a\u0002H\u0002H\u0007\u00a2\u0006\u0002\u0010\f\u001a\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u0087\b\u001a\u0012\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001a!\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0087\b\u001a2\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0004H\u0007\u001a\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a)\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00120\u0001H\u0007\u00a2\u0006\u0002\b\u0013\u001aC\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u00050\u0015H\u0002\u00a2\u0006\u0002\b\u0016\u001a@\u0010\u0017\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u00190\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0014*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00140\u00180\u0001\u001a\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001a&\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001cH\u0007\u001ab\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u001e\"\u0004\b\u0002\u0010\u00142\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u001e0!2\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u00050\u0015H\u0000\u001a\u001c\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a&\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020%2\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0004\u001a=\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020%2\b\u0010'\u001a\u0004\u0018\u0001H\u00022\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0015H\u0007\u00a2\u0006\u0002\u0010(\u001a<\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020%2\u000e\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00042\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0015\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006*"}, d2={"Sequence", "Lkotlin/sequences/Sequence;", "T", "iterator", "Lkotlin/Function0;", "", "asSequence", "sequenceOf", "elements", "", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "element", "(Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "emptySequence", "orEmpty", "ifEmpty", "defaultValue", "flatten", "", "flattenSequenceOfIterable", "R", "Lkotlin/Function1;", "flatten$SequencesKt__SequencesKt", "unzip", "Lkotlin/Pair;", "", "shuffled", "random", "Lkotlin/random/Random;", "flatMapIndexed", "C", "source", "transform", "Lkotlin/Function2;", "", "constrainOnce", "generateSequence", "", "nextFunction", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "seedFunction", "kotlin-stdlib"}, xs="kotlin/sequences/SequencesKt")
class SequencesKt__SequencesKt
extends SequencesKt__SequencesJVMKt {
    @InlineOnly
    private static final <T> Sequence<T> Sequence(Function0<? extends Iterator<? extends T>> iterator2) {
        Intrinsics.checkNotNullParameter(iterator2, "iterator");
        return new Sequence<T>(iterator2){
            final /* synthetic */ Function0<Iterator<T>> $iterator;
            {
                this.$iterator = $iterator;
            }

            public Iterator<T> iterator() {
                return this.$iterator.invoke();
            }
        };
    }

    @NotNull
    public static final <T> Sequence<T> asSequence(@NotNull Iterator<? extends T> $this$asSequence) {
        Intrinsics.checkNotNullParameter($this$asSequence, "<this>");
        return SequencesKt.constrainOnce(new Sequence<T>($this$asSequence){
            final /* synthetic */ Iterator $this_asSequence$inlined;
            {
                this.$this_asSequence$inlined = iterator2;
            }

            public Iterator<T> iterator() {
                boolean bl2 = false;
                return this.$this_asSequence$inlined;
            }
        });
    }

    @NotNull
    public static final <T> Sequence<T> sequenceOf(T ... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ArraysKt.asSequence(elements);
    }

    @SinceKotlin(version="2.2")
    @NotNull
    public static final <T> Sequence<T> sequenceOf(T element) {
        return new Sequence<T>(element){
            final /* synthetic */ Object $element$inlined;
            {
                this.$element$inlined = object;
            }

            public Iterator<T> iterator() {
                boolean bl2 = false;
                return new Iterator<T>(this.$element$inlined){
                    private boolean _hasNext;
                    final /* synthetic */ T $element;
                    {
                        this.$element = $element;
                        this._hasNext = true;
                    }

                    public T next() {
                        if (!this._hasNext) {
                            throw new NoSuchElementException();
                        }
                        this._hasNext = false;
                        return this.$element;
                    }

                    public boolean hasNext() {
                        return this._hasNext;
                    }

                    public void remove() {
                        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                    }
                };
            }
        };
    }

    @SinceKotlin(version="2.2")
    @InlineOnly
    private static final <T> Sequence<T> sequenceOf() {
        return SequencesKt.emptySequence();
    }

    @NotNull
    public static final <T> Sequence<T> emptySequence() {
        return EmptySequence.INSTANCE;
    }

    @SinceKotlin(version="1.3")
    @InlineOnly
    private static final <T> Sequence<T> orEmpty(Sequence<? extends T> $this$orEmpty) {
        Sequence<Object> sequence = $this$orEmpty;
        if (sequence == null) {
            sequence = SequencesKt.emptySequence();
        }
        return sequence;
    }

    @SinceKotlin(version="1.3")
    @NotNull
    public static final <T> Sequence<T> ifEmpty(@NotNull Sequence<? extends T> $this$ifEmpty, @NotNull Function0<? extends Sequence<? extends T>> defaultValue) {
        Intrinsics.checkNotNullParameter($this$ifEmpty, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return SequencesKt.sequence(new Function2<SequenceScope<? super T>, Continuation<? super Unit>, Object>($this$ifEmpty, defaultValue, null){
            Object L$1;
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ Sequence<T> $this_ifEmpty;
            final /* synthetic */ Function0<Sequence<T>> $defaultValue;
            {
                this.$this_ifEmpty = $receiver;
                this.$defaultValue = $defaultValue;
                super(2, $completion);
            }

            /*
             * WARNING - void declaration
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object $result) {
                void $this$sequence;
                Iterator<T> iterator2;
                SequenceScope sequenceScope = (SequenceScope)this.L$0;
                Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure($result);
                        iterator2 = this.$this_ifEmpty.iterator();
                        if (!iterator2.hasNext()) break;
                        this.L$0 = SpillingKt.nullOutSpilledVariable($this$sequence);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(iterator2);
                        this.label = 1;
                        Object object2 = $this$sequence.yieldAll(iterator2, (Continuation<? super Unit>)this);
                        if (object2 != object) return Unit.INSTANCE;
                        return object;
                    }
                    case 1: {
                        Iterator iterator3 = (Iterator)this.L$1;
                        ResultKt.throwOnFailure($result);
                        Object object2 = $result;
                        return Unit.INSTANCE;
                    }
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$sequence);
                this.L$1 = SpillingKt.nullOutSpilledVariable(iterator2);
                this.label = 2;
                Object object3 = $this$sequence.yieldAll(this.$defaultValue.invoke(), (Continuation<? super Unit>)this);
                if (object3 != object) return Unit.INSTANCE;
                return object;
                {
                    case 2: {
                        Iterator iterator4 = (Iterator)this.L$1;
                        ResultKt.throwOnFailure($result);
                        object3 = $result;
                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
                Function2<SequenceScope<? super T>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)((Object)function2);
            }

            public final Object invoke(SequenceScope<? super T> p1, Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        });
    }

    @NotNull
    public static final <T> Sequence<T> flatten(@NotNull Sequence<? extends Sequence<? extends T>> $this$flatten) {
        Intrinsics.checkNotNullParameter($this$flatten, "<this>");
        return SequencesKt__SequencesKt.flatten$SequencesKt__SequencesKt($this$flatten, SequencesKt__SequencesKt::flatten$lambda$2$SequencesKt__SequencesKt);
    }

    @JvmName(name="flattenSequenceOfIterable")
    @NotNull
    public static final <T> Sequence<T> flattenSequenceOfIterable(@NotNull Sequence<? extends Iterable<? extends T>> $this$flatten) {
        Intrinsics.checkNotNullParameter($this$flatten, "<this>");
        return SequencesKt__SequencesKt.flatten$SequencesKt__SequencesKt($this$flatten, SequencesKt__SequencesKt::flatten$lambda$3$SequencesKt__SequencesKt);
    }

    private static final <T, R> Sequence<R> flatten$SequencesKt__SequencesKt(Sequence<? extends T> $this$flatten, Function1<? super T, ? extends Iterator<? extends R>> iterator2) {
        if ($this$flatten instanceof TransformingSequence) {
            return ((TransformingSequence)$this$flatten).flatten$kotlin_stdlib(iterator2);
        }
        return new FlatteningSequence($this$flatten, SequencesKt__SequencesKt::flatten$lambda$4$SequencesKt__SequencesKt, iterator2);
    }

    @NotNull
    public static final <T, R> Pair<List<T>, List<R>> unzip(@NotNull Sequence<? extends Pair<? extends T, ? extends R>> $this$unzip) {
        Intrinsics.checkNotNullParameter($this$unzip, "<this>");
        ArrayList<T> listT = new ArrayList<T>();
        ArrayList<R> listR = new ArrayList<R>();
        Iterator<Pair<T, R>> iterator2 = $this$unzip.iterator();
        while (iterator2.hasNext()) {
            Pair<T, R> pair = iterator2.next();
            listT.add(pair.getFirst());
            listR.add(pair.getSecond());
        }
        return TuplesKt.to(listT, listR);
    }

    @SinceKotlin(version="1.4")
    @NotNull
    public static final <T> Sequence<T> shuffled(@NotNull Sequence<? extends T> $this$shuffled) {
        Intrinsics.checkNotNullParameter($this$shuffled, "<this>");
        return SequencesKt.shuffled($this$shuffled, Random.Default);
    }

    @SinceKotlin(version="1.4")
    @NotNull
    public static final <T> Sequence<T> shuffled(@NotNull Sequence<? extends T> $this$shuffled, @NotNull Random random) {
        Intrinsics.checkNotNullParameter($this$shuffled, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        return SequencesKt.sequence(new Function2<SequenceScope<? super T>, Continuation<? super Unit>, Object>($this$shuffled, random, null){
            Object L$1;
            Object L$2;
            Object L$3;
            int I$0;
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ Sequence<T> $this_shuffled;
            final /* synthetic */ Random $random;
            {
                this.$this_shuffled = $receiver;
                this.$random = $random;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            public final Object invokeSuspend(Object $result) {
                var2_2 = (SequenceScope)this.L$0;
                var7_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure($result);
                        buffer = SequencesKt.toMutableList(this.$this_shuffled);
lbl7:
                        // 3 sources

                        while (((Collection)buffer).isEmpty() == false) {
                            j = this.$random.nextInt(buffer.size());
                            last = CollectionsKt.removeLast(buffer);
                            value = j < buffer.size() ? buffer.set(j, last) : last;
                            this.L$0 = $this$sequence;
                            this.L$1 = buffer;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(last);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(value);
                            this.I$0 = j;
                            this.label = 1;
                            v0 = $this$sequence.yield(value, this);
                            if (v0 != var7_3) continue;
                            return var7_3;
                        }
                        break;
                    }
                    case 1: {
                        j = this.I$0;
                        value = this.L$3;
                        last = this.L$2;
                        buffer = (List)this.L$1;
                        ResultKt.throwOnFailure($result);
                        v0 = $result;
                        ** GOTO lbl7
                    }
                }
                return Unit.INSTANCE;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
                Function2<SequenceScope<? super T>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)((Object)function2);
            }

            public final Object invoke(SequenceScope<? super T> p1, Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        });
    }

    @NotNull
    public static final <T, C, R> Sequence<R> flatMapIndexed(@NotNull Sequence<? extends T> source, @NotNull Function2<? super Integer, ? super T, ? extends C> transform, @NotNull Function1<? super C, ? extends Iterator<? extends R>> iterator2) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Intrinsics.checkNotNullParameter(iterator2, "iterator");
        return SequencesKt.sequence(new Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object>(source, transform, iterator2, null){
            Object L$1;
            Object L$2;
            Object L$3;
            int I$0;
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ Sequence<T> $source;
            final /* synthetic */ Function2<Integer, T, C> $transform;
            final /* synthetic */ Function1<C, Iterator<R>> $iterator;
            {
                this.$source = $source;
                this.$transform = $transform;
                this.$iterator = $iterator;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            public final Object invokeSuspend(Object $result) {
                var2_2 = (SequenceScope)this.L$0;
                var8_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure($result);
                        index = 0;
                        var4_5 = this.$source.iterator();
lbl8:
                        // 3 sources

                        while (var4_5.hasNext()) {
                            element = var4_5.next();
                            if ((var7_8 = index++) < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            result = this.$transform.invoke(Boxing.boxInt(var7_8), element);
                            this.L$0 = $this$sequence;
                            this.L$1 = var4_5;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(element);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(result);
                            this.I$0 = index;
                            this.label = 1;
                            v0 = $this$sequence.yieldAll(this.$iterator.invoke(result), (Continuation<? super Unit>)this);
                            if (v0 != var8_3) continue;
                            return var8_3;
                        }
                        break;
                    }
                    case 1: {
                        index = this.I$0;
                        result = this.L$3;
                        element = this.L$2;
                        var4_5 = (Iterator)this.L$1;
                        ResultKt.throwOnFailure($result);
                        v0 = $result;
                        ** GOTO lbl8
                    }
                }
                return Unit.INSTANCE;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
                Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)((Object)function2);
            }

            public final Object invoke(SequenceScope<? super R> p1, Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        });
    }

    @NotNull
    public static final <T> Sequence<T> constrainOnce(@NotNull Sequence<? extends T> $this$constrainOnce) {
        Intrinsics.checkNotNullParameter($this$constrainOnce, "<this>");
        return $this$constrainOnce instanceof ConstrainedOnceSequence ? $this$constrainOnce : (Sequence)new ConstrainedOnceSequence<T>($this$constrainOnce);
    }

    @NotNull
    public static final <T> Sequence<T> generateSequence(@NotNull Function0<? extends T> nextFunction) {
        Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        return SequencesKt.constrainOnce((Sequence)new GeneratorSequence<Object>(nextFunction, arg_0 -> SequencesKt__SequencesKt.generateSequence$lambda$5$SequencesKt__SequencesKt(nextFunction, arg_0)));
    }

    @LowPriorityInOverloadResolution
    @NotNull
    public static final <T> Sequence<T> generateSequence(@Nullable T seed, @NotNull Function1<? super T, ? extends T> nextFunction) {
        Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        return seed == null ? (Sequence)EmptySequence.INSTANCE : (Sequence)new GeneratorSequence<T>(() -> SequencesKt__SequencesKt.generateSequence$lambda$6$SequencesKt__SequencesKt(seed), nextFunction);
    }

    @NotNull
    public static final <T> Sequence<T> generateSequence(@NotNull Function0<? extends T> seedFunction, @NotNull Function1<? super T, ? extends T> nextFunction) {
        Intrinsics.checkNotNullParameter(seedFunction, "seedFunction");
        Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        return new GeneratorSequence<T>(seedFunction, nextFunction);
    }

    private static final Iterator flatten$lambda$2$SequencesKt__SequencesKt(Sequence it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.iterator();
    }

    private static final Iterator flatten$lambda$3$SequencesKt__SequencesKt(Iterable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.iterator();
    }

    private static final Object flatten$lambda$4$SequencesKt__SequencesKt(Object it) {
        return it;
    }

    private static final Object generateSequence$lambda$5$SequencesKt__SequencesKt(Function0 $nextFunction, Object it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return $nextFunction.invoke();
    }

    private static final Object generateSequence$lambda$6$SequencesKt__SequencesKt(Object $seed) {
        return $seed;
    }
}

