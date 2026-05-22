/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class Java16RecordComponentsLoader {
    @NotNull
    public static final Java16RecordComponentsLoader INSTANCE = new Java16RecordComponentsLoader();
    @Nullable
    private static Cache _cache;

    private Java16RecordComponentsLoader() {
    }

    private final Cache buildCache(Object recordComponent) {
        Cache cache2;
        Class<?> classOfComponent = recordComponent.getClass();
        try {
            cache2 = new Cache(classOfComponent.getMethod("getType", new Class[0]), classOfComponent.getMethod("getAccessor", new Class[0]));
        }
        catch (NoSuchMethodException e2) {
            cache2 = new Cache(null, null);
        }
        return cache2;
    }

    private final Cache initCache(Object recordComponent) {
        Cache cache2 = _cache;
        if (cache2 == null) {
            _cache = cache2 = this.buildCache(recordComponent);
        }
        return cache2;
    }

    @Nullable
    public final Class<?> loadGetType(@NotNull Object recordComponent) {
        Intrinsics.checkNotNullParameter(recordComponent, "recordComponent");
        Cache cache2 = this.initCache(recordComponent);
        Method method = cache2.getGetType();
        if (method == null) {
            return null;
        }
        Method getType = method;
        Object object = getType.invoke(recordComponent, new Object[0]);
        Intrinsics.checkNotNull(object, "null cannot be cast to non-null type java.lang.Class<*>");
        return (Class)object;
    }

    @Nullable
    public final Method loadGetAccessor(@NotNull Object recordComponent) {
        Intrinsics.checkNotNullParameter(recordComponent, "recordComponent");
        Cache cache2 = this.initCache(recordComponent);
        Method method = cache2.getGetAccessor();
        if (method == null) {
            return null;
        }
        Method getType = method;
        Object object = getType.invoke(recordComponent, new Object[0]);
        Intrinsics.checkNotNull(object, "null cannot be cast to non-null type java.lang.reflect.Method");
        return (Method)object;
    }

    public static final class Cache {
        @Nullable
        private final Method getType;
        @Nullable
        private final Method getAccessor;

        public Cache(@Nullable Method getType, @Nullable Method getAccessor) {
            this.getType = getType;
            this.getAccessor = getAccessor;
        }

        @Nullable
        public final Method getGetType() {
            return this.getType;
        }

        @Nullable
        public final Method getGetAccessor() {
            return this.getAccessor;
        }
    }
}

