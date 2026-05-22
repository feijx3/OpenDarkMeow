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

public final class Java16SealedRecordLoader {
    @NotNull
    public static final Java16SealedRecordLoader INSTANCE = new Java16SealedRecordLoader();
    @Nullable
    private static Cache _cache;

    private Java16SealedRecordLoader() {
    }

    private final Cache buildCache() {
        Cache cache2;
        Class<Class> clazz = Class.class;
        try {
            cache2 = new Cache(clazz.getMethod("isSealed", new Class[0]), clazz.getMethod("getPermittedSubclasses", new Class[0]), clazz.getMethod("isRecord", new Class[0]), clazz.getMethod("getRecordComponents", new Class[0]));
        }
        catch (NoSuchMethodException e2) {
            cache2 = new Cache(null, null, null, null);
        }
        return cache2;
    }

    private final Cache initCache() {
        Cache cache2 = _cache;
        if (cache2 == null) {
            _cache = cache2 = this.buildCache();
        }
        return cache2;
    }

    @Nullable
    public final Boolean loadIsSealed(@NotNull Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Cache cache2 = this.initCache();
        Method method = cache2.isSealed();
        if (method == null) {
            return null;
        }
        Method isSealed = method;
        Object object = isSealed.invoke(clazz, new Object[0]);
        Intrinsics.checkNotNull(object, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean)object;
    }

    @Nullable
    public final Class<?>[] loadGetPermittedSubclasses(@NotNull Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Cache cache2 = this.initCache();
        Method method = cache2.getGetPermittedSubclasses();
        if (method == null) {
            return null;
        }
        Method getPermittedSubclasses = method;
        Object object = getPermittedSubclasses.invoke(clazz, new Object[0]);
        Intrinsics.checkNotNull(object, "null cannot be cast to non-null type kotlin.Array<java.lang.Class<*>>");
        return (Class[])object;
    }

    @Nullable
    public final Boolean loadIsRecord(@NotNull Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Cache cache2 = this.initCache();
        Method method = cache2.isRecord();
        if (method == null) {
            return null;
        }
        Method isRecord = method;
        Object object = isRecord.invoke(clazz, new Object[0]);
        Intrinsics.checkNotNull(object, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean)object;
    }

    @Nullable
    public final Object[] loadGetRecordComponents(@NotNull Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Cache cache2 = this.initCache();
        Method method = cache2.getGetRecordComponents();
        if (method == null) {
            return null;
        }
        Method getRecordComponents = method;
        return (Object[])getRecordComponents.invoke(clazz, new Object[0]);
    }

    public static final class Cache {
        @Nullable
        private final Method isSealed;
        @Nullable
        private final Method getPermittedSubclasses;
        @Nullable
        private final Method isRecord;
        @Nullable
        private final Method getRecordComponents;

        public Cache(@Nullable Method isSealed, @Nullable Method getPermittedSubclasses, @Nullable Method isRecord, @Nullable Method getRecordComponents) {
            this.isSealed = isSealed;
            this.getPermittedSubclasses = getPermittedSubclasses;
            this.isRecord = isRecord;
            this.getRecordComponents = getRecordComponents;
        }

        @Nullable
        public final Method isSealed() {
            return this.isSealed;
        }

        @Nullable
        public final Method getGetPermittedSubclasses() {
            return this.getPermittedSubclasses;
        }

        @Nullable
        public final Method isRecord() {
            return this.isRecord;
        }

        @Nullable
        public final Method getGetRecordComponents() {
            return this.getRecordComponents;
        }
    }
}

