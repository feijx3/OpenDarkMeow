/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaArrayType;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClassifierType;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaPrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaWildcardType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ReflectJavaType
implements JavaType {
    @NotNull
    public static final Factory Factory = new Factory(null);

    @NotNull
    protected abstract Type getReflectType();

    public boolean equals(@Nullable Object other) {
        return other instanceof ReflectJavaType && Intrinsics.areEqual(this.getReflectType(), ((ReflectJavaType)other).getReflectType());
    }

    public int hashCode() {
        return this.getReflectType().hashCode();
    }

    @NotNull
    public String toString() {
        return this.getClass().getName() + ": " + this.getReflectType();
    }

    @Override
    @Nullable
    public JavaAnnotation findAnnotation(FqName fqName) {
        Object v1;
        block1: {
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            Iterable iterable = this.getAnnotations();
            for (Object t2 : iterable) {
                JavaAnnotation it = (JavaAnnotation)t2;
                boolean bl2 = false;
                ClassId classId = it.getClassId();
                if (!Intrinsics.areEqual(classId != null ? classId.asSingleFqName() : null, fqName)) continue;
                v1 = t2;
                break block1;
            }
            v1 = null;
        }
        return v1;
    }

    public static final class Factory {
        private Factory() {
        }

        @NotNull
        public final ReflectJavaType create(@NotNull Type type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return type instanceof Class && ((Class)type).isPrimitive() ? (ReflectJavaType)new ReflectJavaPrimitiveType((Class)type) : (type instanceof GenericArrayType || type instanceof Class && ((Class)type).isArray() ? (ReflectJavaType)new ReflectJavaArrayType(type) : (type instanceof WildcardType ? (ReflectJavaType)new ReflectJavaWildcardType((WildcardType)type) : (ReflectJavaType)new ReflectJavaClassifierType(type)));
        }

        public /* synthetic */ Factory(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

