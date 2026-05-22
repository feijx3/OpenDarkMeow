/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;

final class SignatureSerializer {
    @NotNull
    public static final SignatureSerializer INSTANCE = new SignatureSerializer();

    private SignatureSerializer() {
    }

    @NotNull
    public final String methodDesc(@NotNull Method method) {
        Intrinsics.checkNotNullParameter(method, "method");
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Iterator<Class<?>> iterator2 = ArrayIteratorKt.iterator(method.getParameterTypes());
        while (iterator2.hasNext()) {
            Class<?> parameterType = iterator2.next();
            Intrinsics.checkNotNull(parameterType);
            sb.append(ReflectClassUtilKt.getDesc(parameterType));
        }
        sb.append(")");
        Class<?> clazz = method.getReturnType();
        Intrinsics.checkNotNullExpressionValue(clazz, "getReturnType(...)");
        sb.append(ReflectClassUtilKt.getDesc(clazz));
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @NotNull
    public final String constructorDesc(@NotNull Constructor<?> constructor) {
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Iterator<Class<?>> iterator2 = ArrayIteratorKt.iterator(constructor.getParameterTypes());
        while (iterator2.hasNext()) {
            Class<?> parameterType = iterator2.next();
            Intrinsics.checkNotNull(parameterType);
            sb.append(ReflectClassUtilKt.getDesc(parameterType));
        }
        sb.append(")V");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @NotNull
    public final String fieldDesc(@NotNull Field field) {
        Intrinsics.checkNotNullParameter(field, "field");
        Class<?> clazz = field.getType();
        Intrinsics.checkNotNullExpressionValue(clazz, "getType(...)");
        return ReflectClassUtilKt.getDesc(clazz);
    }
}

