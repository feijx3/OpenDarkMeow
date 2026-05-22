/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.name;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.State;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nFqNamesUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FqNamesUtil.kt\norg/jetbrains/kotlin/name/FqNamesUtilKt\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,86:1\n536#2:87\n521#2,6:88\n1#3:94\n*S KotlinDebug\n*F\n+ 1 FqNamesUtil.kt\norg/jetbrains/kotlin/name/FqNamesUtilKt\n*L\n73#1:87\n73#1:88,6\n*E\n"})
public final class FqNamesUtilKt {
    public static final boolean isSubpackageOf(@NotNull FqName $this$isSubpackageOf, @NotNull FqName packageName) {
        Intrinsics.checkNotNullParameter($this$isSubpackageOf, "<this>");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return Intrinsics.areEqual($this$isSubpackageOf, packageName) ? true : (packageName.isRoot() ? true : FqNamesUtilKt.isSubpackageOf($this$isSubpackageOf.asString(), packageName.asString()));
    }

    public static final boolean isChildOf(@NotNull FqName $this$isChildOf, @NotNull FqName packageName) {
        Intrinsics.checkNotNullParameter($this$isChildOf, "<this>");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return Intrinsics.areEqual(FqNamesUtilKt.parentOrNull($this$isChildOf), packageName);
    }

    private static final boolean isSubpackageOf(String subpackageNameStr, String packageNameStr) {
        return StringsKt.startsWith$default(subpackageNameStr, packageNameStr, false, 2, null) && subpackageNameStr.charAt(packageNameStr.length()) == '.';
    }

    @NotNull
    public static final FqName tail(@NotNull FqName $this$tail, @NotNull FqName prefix) {
        FqName fqName;
        Intrinsics.checkNotNullParameter($this$tail, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!FqNamesUtilKt.isSubpackageOf($this$tail, prefix) || prefix.isRoot()) {
            fqName = $this$tail;
        } else if (Intrinsics.areEqual($this$tail, prefix)) {
            fqName = FqName.ROOT;
        } else {
            String string = $this$tail.asString().substring(prefix.asString().length() + 1);
            Intrinsics.checkNotNullExpressionValue(string, "substring(...)");
            fqName = new FqName(string);
        }
        return fqName;
    }

    @Nullable
    public static final FqName parentOrNull(@NotNull FqName $this$parentOrNull) {
        Intrinsics.checkNotNullParameter($this$parentOrNull, "<this>");
        return $this$parentOrNull.isRoot() ? null : $this$parentOrNull.parent();
    }

    public static final boolean isValidJavaFqName(@Nullable String qualifiedName) {
        if (qualifiedName == null) {
            return false;
        }
        State state = State.BEGINNING;
        block4: for (int i2 = 0; i2 < ((CharSequence)qualifiedName).length(); ++i2) {
            char c2 = ((CharSequence)qualifiedName).charAt(i2);
            switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
                case 1: 
                case 2: {
                    if (!Character.isJavaIdentifierStart(c2)) {
                        return false;
                    }
                    state = State.MIDDLE;
                    continue block4;
                }
                case 3: {
                    if (c2 == '.') {
                        state = State.AFTER_DOT;
                        continue block4;
                    }
                    if (Character.isJavaIdentifierPart(c2)) continue block4;
                    return false;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        return state != State.AFTER_DOT;
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public static final <V> V findValueForMostSpecificFqname(@NotNull FqName $this$findValueForMostSpecificFqname, @NotNull Map<FqName, ? extends V> values) {
        Object v1;
        Map map;
        void $this$filterTo$iv$iv;
        Intrinsics.checkNotNullParameter($this$findValueForMostSpecificFqname, "<this>");
        Intrinsics.checkNotNullParameter(values, "values");
        Map<FqName, ? extends V> $this$filter$iv = values;
        boolean $i$f$filter = false;
        Map<FqName, ? extends V> map2 = $this$filter$iv;
        Map destination$iv$iv = new LinkedHashMap();
        boolean $i$f$filterTo = false;
        Iterator iterator2 = $this$filterTo$iv$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry element$iv$iv;
            Map.Entry entry = element$iv$iv = iterator2.next();
            boolean bl2 = false;
            FqName fqName = (FqName)entry.getKey();
            if (!(Intrinsics.areEqual($this$findValueForMostSpecificFqname, fqName) || FqNamesUtilKt.isChildOf($this$findValueForMostSpecificFqname, fqName))) continue;
            destination$iv$iv.put(element$iv$iv.getKey(), element$iv$iv.getValue());
        }
        Map it = map = destination$iv$iv;
        boolean bl3 = false;
        Map map3 = !it.isEmpty() ? map : null;
        if (map3 == null) {
            return null;
        }
        Map suitableItems = map3;
        Iterable iterable = suitableItems.entrySet();
        Iterator iterator3 = iterable.iterator();
        if (!iterator3.hasNext()) {
            v1 = null;
        } else {
            Object t2 = iterator3.next();
            if (!iterator3.hasNext()) {
                v1 = t2;
            } else {
                Map.Entry entry = (Map.Entry)t2;
                boolean bl4 = false;
                FqName fqName = (FqName)entry.getKey();
                int n2 = FqNamesUtilKt.tail(fqName, $this$findValueForMostSpecificFqname).asString().length();
                do {
                    Object t3 = iterator3.next();
                    Map.Entry entry2 = (Map.Entry)t3;
                    $i$a$-minByOrNull-FqNamesUtilKt$findValueForMostSpecificFqname$1 = false;
                    FqName fqName2 = (FqName)entry2.getKey();
                    int n3 = FqNamesUtilKt.tail(fqName2, $this$findValueForMostSpecificFqname).asString().length();
                    if (n2 <= n3) continue;
                    t2 = t3;
                    n2 = n3;
                } while (iterator3.hasNext());
                v1 = t2;
            }
        }
        Map.Entry entry = v1;
        return (V)(entry != null ? entry.getValue() : null);
    }

    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[State.values().length];
            try {
                nArray[State.BEGINNING.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[State.AFTER_DOT.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[State.MIDDLE.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

