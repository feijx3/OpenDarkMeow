/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nFunctionTypeKindExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FunctionTypeKindExtractor.kt\norg/jetbrains/kotlin/builtins/functions/FunctionTypeKindExtractor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,70:1\n1491#2:71\n1516#2,3:72\n1519#2,3:82\n1761#2,3:85\n382#3,7:75\n*S KotlinDebug\n*F\n+ 1 FunctionTypeKindExtractor.kt\norg/jetbrains/kotlin/builtins/functions/FunctionTypeKindExtractor\n*L\n32#1:71\n32#1:72,3\n32#1:82,3\n54#1:85,3\n32#1:75,7\n*E\n"})
public final class FunctionTypeKindExtractor {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final List<FunctionTypeKind> kinds;
    @NotNull
    private final Map<FqName, List<FunctionTypeKind>> knownKindsByPackageFqName;
    @NotNull
    private static final FunctionTypeKindExtractor Default;

    /*
     * WARNING - void declaration
     */
    public FunctionTypeKindExtractor(@NotNull List<? extends FunctionTypeKind> kinds) {
        void $this$groupByTo$iv$iv;
        void $this$groupBy$iv;
        Intrinsics.checkNotNullParameter(kinds, "kinds");
        this.kinds = kinds;
        Iterable iterable = this.kinds;
        FunctionTypeKindExtractor functionTypeKindExtractor = this;
        boolean $i$f$groupBy = false;
        void var4_5 = $this$groupBy$iv;
        Map destination$iv$iv = new LinkedHashMap();
        boolean $i$f$groupByTo = false;
        for (Object element$iv$iv : $this$groupByTo$iv$iv) {
            Object object;
            FunctionTypeKind it = (FunctionTypeKind)element$iv$iv;
            boolean bl2 = false;
            FqName key$iv$iv = it.getPackageFqName();
            Map $this$getOrPut$iv$iv$iv = destination$iv$iv;
            boolean $i$f$getOrPut = false;
            Object value$iv$iv$iv = $this$getOrPut$iv$iv$iv.get(key$iv$iv);
            if (value$iv$iv$iv == null) {
                boolean bl3 = false;
                List answer$iv$iv$iv = new ArrayList();
                $this$getOrPut$iv$iv$iv.put(key$iv$iv, answer$iv$iv$iv);
                object = answer$iv$iv$iv;
            } else {
                object = value$iv$iv$iv;
            }
            List list$iv$iv = (List)object;
            list$iv$iv.add(element$iv$iv);
        }
        functionTypeKindExtractor.knownKindsByPackageFqName = destination$iv$iv;
    }

    @Nullable
    public final FunctionTypeKind getFunctionalClassKind(@NotNull FqName packageFqName, @NotNull String className) {
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        Intrinsics.checkNotNullParameter(className, "className");
        KindWithArity kindWithArity = this.getFunctionalClassKindWithArity(packageFqName, className);
        return kindWithArity != null ? kindWithArity.getKind() : null;
    }

    @Nullable
    public final KindWithArity getFunctionalClassKindWithArity(@NotNull FqName packageFqName, @NotNull String className) {
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        Intrinsics.checkNotNullParameter(className, "className");
        List<FunctionTypeKind> list = this.knownKindsByPackageFqName.get(packageFqName);
        if (list == null) {
            return null;
        }
        List<FunctionTypeKind> kinds = list;
        for (FunctionTypeKind kind2 : kinds) {
            if (!StringsKt.startsWith$default(className, kind2.getClassNamePrefix(), false, 2, null)) continue;
            String string = className.substring(kind2.getClassNamePrefix().length());
            Intrinsics.checkNotNullExpressionValue(string, "substring(...)");
            Integer n2 = this.toInt(string);
            if (n2 == null) {
                continue;
            }
            int arity = n2;
            return new KindWithArity(kind2, arity);
        }
        return null;
    }

    private final Integer toInt(String s2) {
        if (((CharSequence)s2).length() == 0) {
            return null;
        }
        int result = 0;
        int n2 = s2.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            char c2 = s2.charAt(i2);
            int d2 = c2 - 48;
            if (!(0 <= d2 ? d2 < 10 : false)) {
                return null;
            }
            result = result * 10 + d2;
        }
        return result;
    }

    static {
        FunctionTypeKind[] functionTypeKindArray = new FunctionTypeKind[]{FunctionTypeKind.Function.INSTANCE, FunctionTypeKind.SuspendFunction.INSTANCE, FunctionTypeKind.KFunction.INSTANCE, FunctionTypeKind.KSuspendFunction.INSTANCE};
        Default = new FunctionTypeKindExtractor(CollectionsKt.listOf(functionTypeKindArray));
    }

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final FunctionTypeKindExtractor getDefault() {
            return Default;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    public static final class KindWithArity {
        @NotNull
        private final FunctionTypeKind kind;
        private final int arity;

        public KindWithArity(@NotNull FunctionTypeKind kind2, int arity) {
            Intrinsics.checkNotNullParameter(kind2, "kind");
            this.kind = kind2;
            this.arity = arity;
        }

        @NotNull
        public final FunctionTypeKind getKind() {
            return this.kind;
        }

        @NotNull
        public final FunctionTypeKind component1() {
            return this.kind;
        }

        public final int component2() {
            return this.arity;
        }

        @NotNull
        public String toString() {
            return "KindWithArity(kind=" + this.kind + ", arity=" + this.arity + ')';
        }

        public int hashCode() {
            int result = this.kind.hashCode();
            result = result * 31 + Integer.hashCode(this.arity);
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof KindWithArity)) {
                return false;
            }
            KindWithArity kindWithArity = (KindWithArity)other;
            if (!Intrinsics.areEqual(this.kind, kindWithArity.kind)) {
                return false;
            }
            return this.arity == kindWithArity.arity;
        }
    }
}

