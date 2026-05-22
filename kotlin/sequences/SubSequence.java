/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.DropTakeSequence;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0096\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2={"Lkotlin/sequences/SubSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "startIndex", "", "endIndex", "<init>", "(Lkotlin/sequences/Sequence;II)V", "count", "getCount", "()I", "drop", "n", "take", "iterator", "", "kotlin-stdlib"})
@SourceDebugExtension(value={"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SubSequence\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,731:1\n1#2:732\n*E\n"})
public final class SubSequence<T>
implements Sequence<T>,
DropTakeSequence<T> {
    @NotNull
    private final Sequence<T> sequence;
    private final int startIndex;
    private final int endIndex;

    public SubSequence(@NotNull Sequence<? extends T> sequence, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.sequence = sequence;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        if (!(this.startIndex >= 0)) {
            boolean $i$a$-require-SubSequence$42 = false;
            String $i$a$-require-SubSequence$42 = "startIndex should be non-negative, but is " + this.startIndex;
            throw new IllegalArgumentException($i$a$-require-SubSequence$42.toString());
        }
        if (!(this.endIndex >= 0)) {
            boolean $i$a$-require-SubSequence$52 = false;
            String $i$a$-require-SubSequence$52 = "endIndex should be non-negative, but is " + this.endIndex;
            throw new IllegalArgumentException($i$a$-require-SubSequence$52.toString());
        }
        if (!(this.endIndex >= this.startIndex)) {
            boolean bl2 = false;
            String string = "endIndex should be not less than startIndex, but was " + this.endIndex + " < " + this.startIndex;
            throw new IllegalArgumentException(string.toString());
        }
    }

    private final int getCount() {
        return this.endIndex - this.startIndex;
    }

    @Override
    @NotNull
    public Sequence<T> drop(int n2) {
        return n2 >= this.getCount() ? SequencesKt.emptySequence() : (Sequence)new SubSequence<T>(this.sequence, this.startIndex + n2, this.endIndex);
    }

    @Override
    @NotNull
    public Sequence<T> take(int n2) {
        return n2 >= this.getCount() ? (Sequence)this : (Sequence)new SubSequence<T>(this.sequence, this.startIndex, this.startIndex + n2);
    }

    @Override
    @NotNull
    public Iterator<T> iterator() {
        return new Iterator<T>(this){
            private final Iterator<T> iterator;
            private int position;
            final /* synthetic */ SubSequence<T> this$0;
            {
                this.this$0 = $receiver;
                this.iterator = SubSequence.access$getSequence$p($receiver).iterator();
            }

            public final Iterator<T> getIterator() {
                return this.iterator;
            }

            public final int getPosition() {
                return this.position;
            }

            public final void setPosition(int n2) {
                this.position = n2;
            }

            private final void drop() {
                while (this.position < SubSequence.access$getStartIndex$p(this.this$0) && this.iterator.hasNext()) {
                    this.iterator.next();
                    int n2 = this.position;
                    this.position = n2 + 1;
                }
            }

            public boolean hasNext() {
                this.drop();
                return this.position < SubSequence.access$getEndIndex$p(this.this$0) && this.iterator.hasNext();
            }

            public T next() {
                this.drop();
                if (this.position >= SubSequence.access$getEndIndex$p(this.this$0)) {
                    throw new NoSuchElementException();
                }
                int n2 = this.position;
                this.position = n2 + 1;
                return this.iterator.next();
            }

            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        };
    }

    public static final /* synthetic */ Sequence access$getSequence$p(SubSequence $this) {
        return $this.sequence;
    }

    public static final /* synthetic */ int access$getStartIndex$p(SubSequence $this) {
        return $this.startIndex;
    }

    public static final /* synthetic */ int access$getEndIndex$p(SubSequence $this) {
        return $this.endIndex;
    }
}

