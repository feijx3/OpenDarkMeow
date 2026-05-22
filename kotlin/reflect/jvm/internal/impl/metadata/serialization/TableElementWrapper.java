/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.metadata.serialization;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class TableElementWrapper<Element extends GeneratedMessageLite.Builder<?, Element>> {
    @NotNull
    private final Element builder;
    @NotNull
    private final byte[] bytes;
    private final int hashCode;

    public TableElementWrapper(@NotNull Element builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
        byte[] byArray = ((MessageLite.Builder)this.builder).build().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byArray, "toByteArray(...)");
        this.bytes = byArray;
        this.hashCode = Arrays.hashCode(this.bytes);
    }

    public int hashCode() {
        return this.hashCode;
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof TableElementWrapper && Arrays.equals(this.bytes, ((TableElementWrapper)other).bytes);
    }
}

