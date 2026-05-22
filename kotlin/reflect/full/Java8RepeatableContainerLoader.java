/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.full;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u00c2\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0005H\u0002J \u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\f2\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u0010"}, d2={"Lkotlin/reflect/full/Java8RepeatableContainerLoader;", "", "<init>", "()V", "cache", "Lkotlin/reflect/full/Java8RepeatableContainerLoader$Cache;", "getCache", "()Lkotlin/reflect/full/Java8RepeatableContainerLoader$Cache;", "setCache", "(Lkotlin/reflect/full/Java8RepeatableContainerLoader$Cache;)V", "buildCache", "loadRepeatableContainer", "Ljava/lang/Class;", "", "klass", "Cache", "kotlin-reflection"})
@SourceDebugExtension(value={"SMAP\nKAnnotatedElements.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KAnnotatedElements.kt\nkotlin/reflect/full/Java8RepeatableContainerLoader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,102:1\n1#2:103\n*E\n"})
final class Java8RepeatableContainerLoader {
    @NotNull
    public static final Java8RepeatableContainerLoader INSTANCE = new Java8RepeatableContainerLoader();
    @Nullable
    private static Cache cache;

    private Java8RepeatableContainerLoader() {
    }

    private final Cache buildCache() {
        Class<?> clazz;
        try {
            Class<?> clazz2 = Class.forName("java.lang.annotation.Repeatable");
            Intrinsics.checkNotNull(clazz2, "null cannot be cast to non-null type java.lang.Class<out kotlin.Annotation>");
            clazz = clazz2;
        }
        catch (ClassNotFoundException e2) {
            return new Cache(null, null);
        }
        Class<?> repeatableClass = clazz;
        return new Cache(repeatableClass, repeatableClass.getMethod("value", new Class[0]));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    public final Class<? extends Annotation> loadRepeatableContainer(@NotNull Class<? extends Annotation> klass) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        Cache cache2 = cache;
        if (cache2 == null) {
            Java8RepeatableContainerLoader java8RepeatableContainerLoader = this;
            synchronized (java8RepeatableContainerLoader) {
                boolean $i$a$-synchronized-Java8RepeatableContainerLoader$loadRepeatableContainer$cache$22 = false;
                Cache cache3 = cache;
                if (cache3 == null) {
                    Cache cache4;
                    Cache it = cache4 = INSTANCE.buildCache();
                    boolean bl2 = false;
                    cache = it;
                    cache3 = cache4;
                }
                Cache $i$a$-synchronized-Java8RepeatableContainerLoader$loadRepeatableContainer$cache$22 = cache3;
                // MONITOREXIT @DISABLED, blocks:[0, 1, 7] lbl19 : MonitorExitStatement: MONITOREXIT : var4_2
                cache2 = $i$a$-synchronized-Java8RepeatableContainerLoader$loadRepeatableContainer$cache$22;
            }
        }
        Cache cache5 = cache2;
        Class<? extends Annotation> clazz = cache5.getRepeatableClass();
        if (clazz == null) {
            return null;
        }
        Class<? extends Annotation> repeatableClass = clazz;
        Annotation annotation = klass.getAnnotation(repeatableClass);
        if (annotation == null) {
            return null;
        }
        Annotation repeatable = annotation;
        Method method = cache5.getValueMethod();
        if (method == null) {
            return null;
        }
        Method valueMethod = method;
        Object object = valueMethod.invoke(repeatable, new Object[0]);
        Intrinsics.checkNotNull(object, "null cannot be cast to non-null type java.lang.Class<out kotlin.Annotation>");
        return (Class)object;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0002\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2={"Lkotlin/reflect/full/Java8RepeatableContainerLoader$Cache;", "", "repeatableClass", "Ljava/lang/Class;", "", "valueMethod", "Ljava/lang/reflect/Method;", "<init>", "(Ljava/lang/Class;Ljava/lang/reflect/Method;)V", "getRepeatableClass", "()Ljava/lang/Class;", "getValueMethod", "()Ljava/lang/reflect/Method;", "kotlin-reflection"})
    public static final class Cache {
        @Nullable
        private final Class<? extends Annotation> repeatableClass;
        @Nullable
        private final Method valueMethod;

        public Cache(@Nullable Class<? extends Annotation> repeatableClass, @Nullable Method valueMethod) {
            this.repeatableClass = repeatableClass;
            this.valueMethod = valueMethod;
        }

        @Nullable
        public final Class<? extends Annotation> getRepeatableClass() {
            return this.repeatableClass;
        }

        @Nullable
        public final Method getValueMethod() {
            return this.valueMethod;
        }
    }
}

