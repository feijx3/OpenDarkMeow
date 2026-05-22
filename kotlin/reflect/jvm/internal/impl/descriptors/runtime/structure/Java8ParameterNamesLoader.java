/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nReflectJavaMember.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJavaMember.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/Java8ParameterNamesLoader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,105:1\n1#2:106\n11228#3:107\n11563#3,3:108\n*S KotlinDebug\n*F\n+ 1 ReflectJavaMember.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/Java8ParameterNamesLoader\n*L\n100#1:107\n100#1:108,3\n*E\n"})
final class Java8ParameterNamesLoader {
    @NotNull
    public static final Java8ParameterNamesLoader INSTANCE = new Java8ParameterNamesLoader();
    @Nullable
    private static Cache cache;

    private Java8ParameterNamesLoader() {
    }

    @NotNull
    public final Cache buildCache(@NotNull Member member) {
        Method method;
        Intrinsics.checkNotNullParameter(member, "member");
        Class<?> methodOrConstructorClass = member.getClass();
        try {
            method = methodOrConstructorClass.getMethod("getParameters", new Class[0]);
        }
        catch (NoSuchMethodException e2) {
            return new Cache(null, null);
        }
        Method getParameters = method;
        Class<?> parameterClass = ReflectClassUtilKt.getSafeClassLoader(methodOrConstructorClass).loadClass("java.lang.reflect.Parameter");
        return new Cache(getParameters, parameterClass.getMethod("getName", new Class[0]));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    @Nullable
    public final List<String> loadParameterNames(@NotNull Member member) {
        void $this$mapTo$iv$iv;
        Object[] it;
        Intrinsics.checkNotNullParameter(member, "member");
        Cache cache2 = cache;
        if (cache2 == null) {
            Java8ParameterNamesLoader java8ParameterNamesLoader = this;
            synchronized (java8ParameterNamesLoader) {
                boolean $i$a$-synchronized-Java8ParameterNamesLoader$loadParameterNames$cache$22 = false;
                Object[] objectArray = cache;
                if (cache == null) {
                    Object[] objectArray2;
                    it = objectArray2 = INSTANCE.buildCache(member);
                    boolean bl2 = false;
                    cache = it;
                    objectArray = objectArray2;
                }
                Object[] $i$a$-synchronized-Java8ParameterNamesLoader$loadParameterNames$cache$22 = objectArray;
                // MONITOREXIT @DISABLED, blocks:[0, 1, 7] lbl19 : MonitorExitStatement: MONITOREXIT : var4_2
                cache2 = $i$a$-synchronized-Java8ParameterNamesLoader$loadParameterNames$cache$22;
            }
        }
        Cache cache3 = cache2;
        Method method = cache3.getGetParameters();
        if (method == null) {
            return null;
        }
        Method getParameters = method;
        Method method2 = cache3.getGetName();
        if (method2 == null) {
            return null;
        }
        Method getName = method2;
        Object object = getParameters.invoke(member, new Object[0]);
        Intrinsics.checkNotNull(object, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] $this$map$iv = (Object[])object;
        boolean $i$f$map = false;
        it = $this$map$iv;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length);
        boolean $i$f$mapTo = false;
        int n2 = ((void)$this$mapTo$iv$iv).length;
        for (int i2 = 0; i2 < n2; ++i2) {
            void param;
            void item$iv$iv;
            void var13_17 = item$iv$iv = $this$mapTo$iv$iv[i2];
            Collection collection = destination$iv$iv;
            boolean bl3 = false;
            Object object2 = getName.invoke(param, new Object[0]);
            Intrinsics.checkNotNull(object2, "null cannot be cast to non-null type kotlin.String");
            collection.add((String)object2);
        }
        return (List)destination$iv$iv;
    }

    public static final class Cache {
        @Nullable
        private final Method getParameters;
        @Nullable
        private final Method getName;

        public Cache(@Nullable Method getParameters, @Nullable Method getName) {
            this.getParameters = getParameters;
            this.getName = getName;
        }

        @Nullable
        public final Method getGetParameters() {
            return this.getParameters;
        }

        @Nullable
        public final Method getGetName() {
            return this.getName;
        }
    }
}

