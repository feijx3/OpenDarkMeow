/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ReflectProperties {
    @NotNull
    public static <T> LazySoftVal<T> lazySoft(@Nullable T initialValue, @NotNull Function0<T> initializer) {
        if (initializer == null) {
            ReflectProperties.$$$reportNull$$$0(0);
        }
        return new LazySoftVal<T>(initialValue, initializer);
    }

    @NotNull
    public static <T> LazySoftVal<T> lazySoft(@NotNull Function0<T> initializer) {
        if (initializer == null) {
            ReflectProperties.$$$reportNull$$$0(1);
        }
        return ReflectProperties.lazySoft(null, initializer);
    }

    private static /* synthetic */ void $$$reportNull$$$0(int n2) {
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties", "lazySoft"));
    }

    public static class LazySoftVal<T>
    extends Val<T>
    implements Function0<T> {
        private final Function0<T> initializer;
        private volatile SoftReference<Object> value;

        public LazySoftVal(@Nullable T initialValue, @NotNull Function0<T> initializer) {
            if (initializer == null) {
                LazySoftVal.$$$reportNull$$$0(0);
            }
            this.value = null;
            this.initializer = initializer;
            if (initialValue != null) {
                this.value = new SoftReference<Object>(this.escape(initialValue));
            }
        }

        @Override
        public T invoke() {
            Object result;
            SoftReference<Object> cached = this.value;
            if (cached != null && (result = cached.get()) != null) {
                return this.unescape(result);
            }
            result = this.initializer.invoke();
            this.value = new SoftReference<Object>(this.escape(result));
            return (T)result;
        }

        private static /* synthetic */ void $$$reportNull$$$0(int n2) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"));
        }
    }

    public static abstract class Val<T> {
        private static final Object NULL_VALUE = new Object(){};

        public final T getValue(Object instance, Object metadata) {
            return this.invoke();
        }

        public abstract T invoke();

        protected Object escape(T value) {
            return value == null ? NULL_VALUE : value;
        }

        protected T unescape(Object value) {
            return (T)(value == NULL_VALUE ? null : value);
        }
    }
}

