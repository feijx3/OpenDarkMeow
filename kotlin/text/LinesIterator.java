/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\f\u001a\u00020\rH\u0096\u0002J\t\u0010\u000e\u001a\u00020\u0002H\u0096\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lkotlin/text/LinesIterator;", "", "", "string", "", "<init>", "(Ljava/lang/CharSequence;)V", "state", "", "tokenStartIndex", "delimiterStartIndex", "delimiterLength", "hasNext", "", "next", "State", "kotlin-stdlib"})
final class LinesIterator
implements Iterator<String>,
KMappedMarker {
    @NotNull
    private static final State State = new State(null);
    @NotNull
    private final CharSequence string;
    private int state;
    private int tokenStartIndex;
    private int delimiterStartIndex;
    private int delimiterLength;
    @Deprecated
    public static final int UNKNOWN = 0;
    @Deprecated
    public static final int HAS_NEXT = 1;
    @Deprecated
    public static final int EXHAUSTED = 2;

    public LinesIterator(@NotNull CharSequence string) {
        Intrinsics.checkNotNullParameter(string, "string");
        this.string = string;
    }

    @Override
    public boolean hasNext() {
        if (this.state != 0) {
            return this.state == 1;
        }
        if (this.delimiterLength < 0) {
            this.state = 2;
            return false;
        }
        int _delimiterLength = -1;
        int _delimiterStartIndex = this.string.length();
        int n2 = this.string.length();
        block3: for (int idx = this.tokenStartIndex; idx < n2; ++idx) {
            char c2 = this.string.charAt(idx);
            switch (c2) {
                case '\n': 
                case '\r': {
                    _delimiterLength = c2 == '\r' && idx + 1 < this.string.length() && this.string.charAt(idx + 1) == '\n' ? 2 : 1;
                    _delimiterStartIndex = idx;
                    break block3;
                }
                default: {
                    continue block3;
                }
            }
        }
        this.state = 1;
        this.delimiterLength = _delimiterLength;
        this.delimiterStartIndex = _delimiterStartIndex;
        return true;
    }

    @Override
    @NotNull
    public String next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        this.state = 0;
        int lastIndex = this.delimiterStartIndex;
        int firstIndex = this.tokenStartIndex;
        this.tokenStartIndex = this.delimiterStartIndex + this.delimiterLength;
        return ((Object)this.string.subSequence(firstIndex, lastIndex)).toString();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Lkotlin/text/LinesIterator$State;", "", "<init>", "()V", "UNKNOWN", "", "HAS_NEXT", "EXHAUSTED", "kotlin-stdlib"})
    private static final class State {
        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

