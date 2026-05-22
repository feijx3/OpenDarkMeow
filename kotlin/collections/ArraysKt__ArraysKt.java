/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.PublishedApi
 *  kotlin.SinceKotlin
 *  kotlin.internal.InlineOnly
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt__ArraysJVMKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.unsigned.UArraysKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=5, xi=49, d1={"\u0000H\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00030\u0003\u00a2\u0006\u0002\u0010\u0004\u001aG\u0010\u0005\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00010\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0007*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00070\u00060\u0003\u00a2\u0006\u0002\u0010\b\u001a)\u0010\t\u001a\u00020\n*\b\u0012\u0002\b\u0003\u0018\u00010\u0003H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u00a2\u0006\u0002\u0010\u000b\u001aH\u0010\f\u001a\u0002H\u0007\"\u0010\b\u0000\u0010\r*\u0006\u0012\u0002\b\u00030\u0003*\u0002H\u0007\"\u0004\b\u0001\u0010\u0007*\u0002H\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00070\u000fH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\u00a2\u0006\u0002\u0010\u0010\u001a5\u0010\u0011\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u00032\u0010\u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001a#\u0010\u0015\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\u0001\u00a2\u0006\u0004\b\u0017\u0010\u0018\u001a?\u0010\u0019\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\n\u0010\u001b\u001a\u00060\u001cj\u0002`\u001d2\u0010\u0010\u001e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u001fH\u0002\u00a2\u0006\u0004\b \u0010!\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\""}, d2={"flatten", "", "T", "", "([[Ljava/lang/Object;)Ljava/util/List;", "unzip", "Lkotlin/Pair;", "R", "([Lkotlin/Pair;)Lkotlin/Pair;", "isNullOrEmpty", "", "([Ljava/lang/Object;)Z", "ifEmpty", "C", "defaultValue", "Lkotlin/Function0;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "contentDeepEqualsImpl", "other", "contentDeepEquals", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "contentDeepToStringImpl", "", "contentDeepToString", "([Ljava/lang/Object;)Ljava/lang/String;", "contentDeepToStringInternal", "", "result", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "processed", "", "contentDeepToStringInternal$ArraysKt__ArraysKt", "([Ljava/lang/Object;Ljava/lang/StringBuilder;Ljava/util/List;)V", "kotlin-stdlib"}, xs="kotlin/collections/ArraysKt")
@SourceDebugExtension(value={"SMAP\nArrays.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Arrays.kt\nkotlin/collections/ArraysKt__ArraysKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,165:1\n1#2:166\n*E\n"})
class ArraysKt__ArraysKt
extends ArraysKt__ArraysJVMKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> List<T> flatten(@NotNull T[][] $this$flatten) {
        Intrinsics.checkNotNullParameter($this$flatten, "<this>");
        Object[] objectArray = (Object[])$this$flatten;
        int n2 = 0;
        for (Object object : objectArray) {
            void it;
            Object[] objectArray2 = (Object[])object;
            int n3 = n2;
            boolean bl2 = false;
            int n4 = ((void)it).length;
            n2 = n3 + n4;
        }
        int n5 = n2;
        ArrayList result = new ArrayList(n5);
        n2 = ((Object[])$this$flatten).length;
        for (int i2 = 0; i2 < n2; ++i2) {
            T[] element = $this$flatten[i2];
            CollectionsKt.addAll((Collection)result, element);
        }
        return result;
    }

    @NotNull
    public static final <T, R> Pair<List<T>, List<R>> unzip(@NotNull Pair<? extends T, ? extends R>[] $this$unzip) {
        Intrinsics.checkNotNullParameter($this$unzip, "<this>");
        ArrayList<T> listT = new ArrayList<T>($this$unzip.length);
        ArrayList<R> listR = new ArrayList<R>($this$unzip.length);
        for (Pair<T, R> pair : $this$unzip) {
            listT.add(pair.getFirst());
            listR.add(pair.getSecond());
        }
        return TuplesKt.to(listT, listR);
    }

    @SinceKotlin(version="1.3")
    @InlineOnly
    private static final boolean isNullOrEmpty(Object[] $this$isNullOrEmpty) {
        return $this$isNullOrEmpty == null || $this$isNullOrEmpty.length == 0;
    }

    @SinceKotlin(version="1.3")
    @InlineOnly
    private static final <C extends Object[], R> R ifEmpty(C $this$ifEmpty, Function0<? extends R> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (R)(((C)$this$ifEmpty).length == 0 ? defaultValue.invoke() : $this$ifEmpty);
    }

    @SinceKotlin(version="1.3")
    @PublishedApi
    @JvmName(name="contentDeepEquals")
    public static final <T> boolean contentDeepEquals(@Nullable T[] $this$contentDeepEqualsImpl, @Nullable T[] other) {
        if ($this$contentDeepEqualsImpl == other) {
            return true;
        }
        if ($this$contentDeepEqualsImpl == null || other == null || $this$contentDeepEqualsImpl.length != other.length) {
            return false;
        }
        int n2 = $this$contentDeepEqualsImpl.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            T v1 = $this$contentDeepEqualsImpl[i2];
            T v2 = other[i2];
            if (v1 == v2) continue;
            if (v1 == null || v2 == null) {
                return false;
            }
            if (!(v1 instanceof Object[] && v2 instanceof Object[] ? !ArraysKt.contentDeepEquals((Object[])v1, (Object[])v2) : (v1 instanceof byte[] && v2 instanceof byte[] ? !Arrays.equals((byte[])v1, (byte[])v2) : (v1 instanceof short[] && v2 instanceof short[] ? !Arrays.equals((short[])v1, (short[])v2) : (v1 instanceof int[] && v2 instanceof int[] ? !Arrays.equals((int[])v1, (int[])v2) : (v1 instanceof long[] && v2 instanceof long[] ? !Arrays.equals((long[])v1, (long[])v2) : (v1 instanceof float[] && v2 instanceof float[] ? !Arrays.equals((float[])v1, (float[])v2) : (v1 instanceof double[] && v2 instanceof double[] ? !Arrays.equals((double[])v1, (double[])v2) : (v1 instanceof char[] && v2 instanceof char[] ? !Arrays.equals((char[])v1, (char[])v2) : (v1 instanceof boolean[] && v2 instanceof boolean[] ? !Arrays.equals((boolean[])v1, (boolean[])v2) : (v1 instanceof UByteArray && v2 instanceof UByteArray ? !UArraysKt.contentEquals-kV0jMPg(((UByteArray)v1).unbox-impl(), ((UByteArray)v2).unbox-impl()) : (v1 instanceof UShortArray && v2 instanceof UShortArray ? !UArraysKt.contentEquals-FGO6Aew(((UShortArray)v1).unbox-impl(), ((UShortArray)v2).unbox-impl()) : (v1 instanceof UIntArray && v2 instanceof UIntArray ? !UArraysKt.contentEquals-KJPZfPQ(((UIntArray)v1).unbox-impl(), ((UIntArray)v2).unbox-impl()) : (v1 instanceof ULongArray && v2 instanceof ULongArray ? !UArraysKt.contentEquals-lec5QzE(((ULongArray)v1).unbox-impl(), ((ULongArray)v2).unbox-impl()) : !Intrinsics.areEqual(v1, v2))))))))))))))) continue;
            return false;
        }
        return true;
    }

    @SinceKotlin(version="1.3")
    @PublishedApi
    @JvmName(name="contentDeepToString")
    @NotNull
    public static final <T> String contentDeepToString(@Nullable T[] $this$contentDeepToStringImpl) {
        StringBuilder stringBuilder;
        if ($this$contentDeepToStringImpl == null) {
            return "null";
        }
        int length = RangesKt.coerceAtMost($this$contentDeepToStringImpl.length, 0x19999999) * 5 + 2;
        StringBuilder $this$contentDeepToStringImpl_u24lambda_u241 = stringBuilder = new StringBuilder(length);
        boolean bl2 = false;
        ArraysKt__ArraysKt.contentDeepToStringInternal$ArraysKt__ArraysKt($this$contentDeepToStringImpl, $this$contentDeepToStringImpl_u24lambda_u241, new ArrayList());
        return stringBuilder.toString();
    }

    private static final <T> void contentDeepToStringInternal$ArraysKt__ArraysKt(T[] $this$contentDeepToStringInternal, StringBuilder result, List<Object[]> processed) {
        if (processed.contains($this$contentDeepToStringInternal)) {
            result.append("[...]");
            return;
        }
        processed.add($this$contentDeepToStringInternal);
        result.append('[');
        int n2 = $this$contentDeepToStringInternal.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object;
            T element;
            T t2;
            if (i2 != 0) {
                result.append(", ");
            }
            if ((t2 = (element = $this$contentDeepToStringInternal[i2])) == null) {
                object = result.append("null");
                continue;
            }
            if (t2 instanceof Object[]) {
                ArraysKt__ArraysKt.contentDeepToStringInternal$ArraysKt__ArraysKt((Object[])element, result, processed);
                object = Unit.INSTANCE;
                continue;
            }
            if (t2 instanceof byte[]) {
                String string = Arrays.toString((byte[])element);
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                object = result.append(string);
                continue;
            }
            if (t2 instanceof short[]) {
                String string = Arrays.toString((short[])element);
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                object = result.append(string);
                continue;
            }
            if (t2 instanceof int[]) {
                String string = Arrays.toString((int[])element);
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                object = result.append(string);
                continue;
            }
            if (t2 instanceof long[]) {
                String string = Arrays.toString((long[])element);
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                object = result.append(string);
                continue;
            }
            if (t2 instanceof float[]) {
                String string = Arrays.toString((float[])element);
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                object = result.append(string);
                continue;
            }
            if (t2 instanceof double[]) {
                String string = Arrays.toString((double[])element);
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                object = result.append(string);
                continue;
            }
            if (t2 instanceof char[]) {
                String string = Arrays.toString((char[])element);
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                object = result.append(string);
                continue;
            }
            if (t2 instanceof boolean[]) {
                String string = Arrays.toString((boolean[])element);
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                object = result.append(string);
                continue;
            }
            if (t2 instanceof UByteArray) {
                UByteArray uByteArray = (UByteArray)element;
                object = result.append(UArraysKt.contentToString-2csIQuQ((byte[])(uByteArray != null ? uByteArray.unbox-impl() : null)));
                continue;
            }
            if (t2 instanceof UShortArray) {
                UShortArray uShortArray = (UShortArray)element;
                object = result.append(UArraysKt.contentToString-d-6D3K8((short[])(uShortArray != null ? uShortArray.unbox-impl() : null)));
                continue;
            }
            if (t2 instanceof UIntArray) {
                UIntArray uIntArray = (UIntArray)element;
                object = result.append(UArraysKt.contentToString-XUkPCBk((int[])(uIntArray != null ? uIntArray.unbox-impl() : null)));
                continue;
            }
            if (t2 instanceof ULongArray) {
                ULongArray uLongArray = (ULongArray)element;
                object = result.append(UArraysKt.contentToString-uLth9ew((long[])(uLongArray != null ? uLongArray.unbox-impl() : null)));
                continue;
            }
            object = result.append(element.toString());
        }
        result.append(']');
        processed.remove(CollectionsKt.getLastIndex(processed));
    }
}

