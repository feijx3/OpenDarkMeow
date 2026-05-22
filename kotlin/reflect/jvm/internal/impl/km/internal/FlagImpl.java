/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.km.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import org.jetbrains.annotations.NotNull;

public final class FlagImpl {
    private final int offset;
    private final int bitWidth;
    private final int value;

    public FlagImpl(int offset, int bitWidth, int value) {
        this.offset = offset;
        this.bitWidth = bitWidth;
        this.value = value;
    }

    public final int getOffset$kotlin_metadata() {
        return this.offset;
    }

    public final int getBitWidth$kotlin_metadata() {
        return this.bitWidth;
    }

    public final int getValue$kotlin_metadata() {
        return this.value;
    }

    public FlagImpl(@NotNull Flags.FlagField<?> field, int value) {
        Intrinsics.checkNotNullParameter(field, "field");
        this(field.offset, field.bitWidth, value);
    }

    public FlagImpl(@NotNull Flags.BooleanFlagField field) {
        Intrinsics.checkNotNullParameter(field, "field");
        this(field, 1);
    }

    public final boolean invoke(int flags) {
        return (flags >>> this.offset & (1 << this.bitWidth) - 1) == this.value;
    }
}

