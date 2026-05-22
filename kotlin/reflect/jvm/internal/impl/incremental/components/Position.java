/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.incremental.components;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Position
implements Serializable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int line;
    private final int column;
    @NotNull
    private static final Position NO_POSITION = new Position(-1, -1);

    public Position(int line, int column) {
        this.line = line;
        this.column = column;
    }

    @NotNull
    public String toString() {
        return "Position(line=" + this.line + ", column=" + this.column + ')';
    }

    public int hashCode() {
        int result = Integer.hashCode(this.line);
        result = result * 31 + Integer.hashCode(this.column);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Position)) {
            return false;
        }
        Position position = (Position)other;
        if (this.line != position.line) {
            return false;
        }
        return this.column == position.column;
    }

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Position getNO_POSITION() {
            return NO_POSITION;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

