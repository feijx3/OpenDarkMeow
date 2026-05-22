/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.collections.builders;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u00008\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a!\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u00a2\u0006\u0002\u0010\u0005\u001a=\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b*\n\u0012\u0006\b\u0001\u0012\u0002H\b0\u00012\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\fH\u0002\u00a2\u0006\u0002\u0010\r\u001a-\u0010\u000e\u001a\u00020\u0004\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00012\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002\u00a2\u0006\u0002\u0010\u000f\u001a9\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00012\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0002\u00a2\u0006\u0002\u0010\u0014\u001a+\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00012\u0006\u0010\u0016\u001a\u00020\u0004H\u0000\u00a2\u0006\u0002\u0010\u0017\u001a%\u0010\u0018\u001a\u00020\u0019\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0004H\u0000\u00a2\u0006\u0002\u0010\u001b\u001a-\u0010\u001c\u001a\u00020\u0019\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0000\u00a2\u0006\u0002\u0010\u001f\u00a8\u0006 "}, d2={"arrayOfUninitializedElements", "", "E", "size", "", "(I)[Ljava/lang/Object;", "subarrayContentToString", "", "T", "offset", "length", "thisCollection", "", "([Ljava/lang/Object;IILjava/util/Collection;)Ljava/lang/String;", "subarrayContentHashCode", "([Ljava/lang/Object;II)I", "subarrayContentEquals", "", "other", "", "([Ljava/lang/Object;IILjava/util/List;)Z", "copyOfUninitializedElements", "newSize", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "resetAt", "", "index", "([Ljava/lang/Object;I)V", "resetRange", "fromIndex", "toIndex", "([Ljava/lang/Object;II)V", "kotlin-stdlib"})
@SourceDebugExtension(value={"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/ListBuilderKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,722:1\n1#2:723\n*E\n"})
public final class ListBuilderKt {
    @NotNull
    public static final <E> E[] arrayOfUninitializedElements(int size) {
        if (!(size >= 0)) {
            boolean bl2 = false;
            String string = "capacity must be non-negative.";
            throw new IllegalArgumentException(string.toString());
        }
        return new Object[size];
    }

    private static final <T> String subarrayContentToString(T[] $this$subarrayContentToString, int offset, int length, Collection<? extends T> thisCollection) {
        StringBuilder sb = new StringBuilder(2 + length * 3);
        sb.append("[");
        for (int i2 = 0; i2 < length; ++i2) {
            T nextElement;
            if (i2 > 0) {
                sb.append(", ");
            }
            StringBuilder stringBuilder = (nextElement = $this$subarrayContentToString[offset + i2]) == thisCollection ? sb.append("(this Collection)") : sb.append(nextElement);
        }
        sb.append("]");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private static final <T> int subarrayContentHashCode(T[] $this$subarrayContentHashCode, int offset, int length) {
        int result = 1;
        for (int i2 = 0; i2 < length; ++i2) {
            T nextElement;
            T t2 = nextElement = $this$subarrayContentHashCode[offset + i2];
            result = result * 31 + (t2 != null ? t2.hashCode() : 0);
        }
        return result;
    }

    private static final <T> boolean subarrayContentEquals(T[] $this$subarrayContentEquals, int offset, int length, List<?> other) {
        if (length != other.size()) {
            return false;
        }
        for (int i2 = 0; i2 < length; ++i2) {
            if (Intrinsics.areEqual($this$subarrayContentEquals[offset + i2], other.get(i2))) continue;
            return false;
        }
        return true;
    }

    @NotNull
    public static final <T> T[] copyOfUninitializedElements(@NotNull T[] $this$copyOfUninitializedElements, int newSize) {
        Intrinsics.checkNotNullParameter($this$copyOfUninitializedElements, "<this>");
        T[] TArray = Arrays.copyOf($this$copyOfUninitializedElements, newSize);
        Intrinsics.checkNotNullExpressionValue(TArray, "copyOf(...)");
        return TArray;
    }

    public static final <E> void resetAt(@NotNull E[] $this$resetAt, int index) {
        Intrinsics.checkNotNullParameter($this$resetAt, "<this>");
        $this$resetAt[index] = null;
    }

    public static final <E> void resetRange(@NotNull E[] $this$resetRange, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter($this$resetRange, "<this>");
        for (int index = fromIndex; index < toIndex; ++index) {
            ListBuilderKt.resetAt($this$resetRange, index);
        }
    }

    public static final /* synthetic */ int access$subarrayContentHashCode(Object[] $receiver, int offset, int length) {
        return ListBuilderKt.subarrayContentHashCode($receiver, offset, length);
    }

    public static final /* synthetic */ String access$subarrayContentToString(Object[] $receiver, int offset, int length, Collection thisCollection) {
        return ListBuilderKt.subarrayContentToString($receiver, offset, length, thisCollection);
    }

    public static final /* synthetic */ boolean access$subarrayContentEquals(Object[] $receiver, int offset, int length, List other) {
        return ListBuilderKt.subarrayContentEquals($receiver, offset, length, other);
    }
}

