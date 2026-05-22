/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import org.jetbrains.annotations.NotNull;

public final class ReflectJavaArrayType
extends ReflectJavaType
implements JavaArrayType {
    @NotNull
    private final Type reflectType;
    @NotNull
    private final ReflectJavaType componentType;
    @NotNull
    private final Collection<JavaAnnotation> annotations;
    private final boolean isDeprecatedInJavaDoc;

    /*
     * WARNING - void declaration
     */
    public ReflectJavaArrayType(@NotNull Type reflectType) {
        ReflectJavaType reflectJavaType;
        void $this$componentType_u24lambda_u240;
        Intrinsics.checkNotNullParameter(reflectType, "reflectType");
        this.reflectType = reflectType;
        Type type = this.getReflectType();
        ReflectJavaArrayType reflectJavaArrayType = this;
        boolean bl2 = false;
        if ($this$componentType_u24lambda_u240 instanceof GenericArrayType) {
            Type type2 = ((GenericArrayType)$this$componentType_u24lambda_u240).getGenericComponentType();
            Intrinsics.checkNotNullExpressionValue(type2, "getGenericComponentType(...)");
            reflectJavaType = ReflectJavaType.Factory.create(type2);
        } else if ($this$componentType_u24lambda_u240 instanceof Class && ((Class)$this$componentType_u24lambda_u240).isArray()) {
            Class<?> clazz = ((Class)$this$componentType_u24lambda_u240).getComponentType();
            Intrinsics.checkNotNullExpressionValue(clazz, "getComponentType(...)");
            reflectJavaType = ReflectJavaType.Factory.create(clazz);
        } else {
            throw new IllegalArgumentException("Not an array type (" + this.getReflectType().getClass() + "): " + this.getReflectType());
        }
        reflectJavaArrayType.componentType = reflectJavaType;
        this.annotations = CollectionsKt.emptyList();
    }

    @Override
    @NotNull
    protected Type getReflectType() {
        return this.reflectType;
    }

    @Override
    @NotNull
    public ReflectJavaType getComponentType() {
        return this.componentType;
    }

    @Override
    @NotNull
    public Collection<JavaAnnotation> getAnnotations() {
        return this.annotations;
    }

    @Override
    public boolean isDeprecatedInJavaDoc() {
        return this.isDeprecatedInJavaDoc;
    }
}

