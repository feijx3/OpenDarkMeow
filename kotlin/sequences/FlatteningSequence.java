/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u0004:\u0001\fBC\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\tH\u0096\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lkotlin/sequences/FlatteningSequence;", "T", "R", "E", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "iterator", "", "<init>", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "State", "kotlin-stdlib"})
public final class FlatteningSequence<T, R, E>
implements Sequence<E> {
    @NotNull
    private final Sequence<T> sequence;
    @NotNull
    private final Function1<T, R> transformer;
    @NotNull
    private final Function1<R, Iterator<E>> iterator;

    public FlatteningSequence(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> transformer, @NotNull Function1<? super R, ? extends Iterator<? extends E>> iterator2) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        Intrinsics.checkNotNullParameter(transformer, "transformer");
        Intrinsics.checkNotNullParameter(iterator2, "iterator");
        this.sequence = sequence;
        this.transformer = transformer;
        this.iterator = iterator2;
    }

    @Override
    @NotNull
    public Iterator<E> iterator() {
        return new Iterator<E>(this){
            private final Iterator<T> iterator;
            private Iterator<? extends E> itemIterator;
            private int state;
            final /* synthetic */ FlatteningSequence<T, R, E> this$0;
            {
                this.this$0 = $receiver;
                this.iterator = FlatteningSequence.access$getSequence$p($receiver).iterator();
            }

            public final Iterator<T> getIterator() {
                return this.iterator;
            }

            public final Iterator<E> getItemIterator() {
                return this.itemIterator;
            }

            public final void setItemIterator(Iterator<? extends E> iterator2) {
                this.itemIterator = iterator2;
            }

            public final int getState() {
                return this.state;
            }

            public final void setState(int n2) {
                this.state = n2;
            }

            public E next() {
                if (this.state == 2) {
                    throw new NoSuchElementException();
                }
                if (this.state == 0 && !this.ensureItemIterator()) {
                    throw new NoSuchElementException();
                }
                this.state = 0;
                Iterator<E> iterator2 = this.itemIterator;
                Intrinsics.checkNotNull(iterator2);
                return iterator2.next();
            }

            public boolean hasNext() {
                if (this.state == 1) {
                    return true;
                }
                if (this.state == 2) {
                    return false;
                }
                return this.ensureItemIterator();
            }

            private final boolean ensureItemIterator() {
                Iterator<E> itemIterator = this.itemIterator;
                if (itemIterator != null && itemIterator.hasNext()) {
                    this.state = 1;
                    return true;
                }
                while (this.iterator.hasNext()) {
                    T element = this.iterator.next();
                    Iterator nextItemIterator = (Iterator)FlatteningSequence.access$getIterator$p(this.this$0).invoke(FlatteningSequence.access$getTransformer$p(this.this$0).invoke(element));
                    if (!nextItemIterator.hasNext()) continue;
                    this.itemIterator = nextItemIterator;
                    this.state = 1;
                    return true;
                }
                this.state = 2;
                this.itemIterator = null;
                return false;
            }

            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        };
    }

    public static final /* synthetic */ Sequence access$getSequence$p(FlatteningSequence $this) {
        return $this.sequence;
    }

    public static final /* synthetic */ Function1 access$getIterator$p(FlatteningSequence $this) {
        return $this.iterator;
    }

    public static final /* synthetic */ Function1 access$getTransformer$p(FlatteningSequence $this) {
        return $this.transformer;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Lkotlin/sequences/FlatteningSequence$State;", "", "<init>", "()V", "UNDEFINED", "", "READY", "DONE", "kotlin-stdlib"})
    private static final class State {
        @NotNull
        public static final State INSTANCE = new State();
        public static final int UNDEFINED = 0;
        public static final int READY = 1;
        public static final int DONE = 2;

        private State() {
        }
    }
}

