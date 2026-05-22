/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.AnnotationsTypeAttribute;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.util.NullableArrayMapAccessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nAnnotationsTypeAttribute.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnnotationsTypeAttribute.kt\norg/jetbrains/kotlin/types/AnnotationsTypeAttributeKt\n+ 2 TypeAttributes.kt\norg/jetbrains/kotlin/types/TypeAttributes$Companion\n*L\n1#1,40:1\n42#2:41\n*S KotlinDebug\n*F\n+ 1 AnnotationsTypeAttribute.kt\norg/jetbrains/kotlin/types/AnnotationsTypeAttributeKt\n*L\n-1#1:41\n*E\n"})
public final class AnnotationsTypeAttributeKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private static final ReadOnlyProperty annotationsAttribute$delegate;

    @Nullable
    public static final AnnotationsTypeAttribute getAnnotationsAttribute(@NotNull TypeAttributes $this$annotationsAttribute) {
        Intrinsics.checkNotNullParameter($this$annotationsAttribute, "<this>");
        return (AnnotationsTypeAttribute)annotationsAttribute$delegate.getValue($this$annotationsAttribute, $$delegatedProperties[0]);
    }

    @NotNull
    public static final Annotations getAnnotations(@NotNull TypeAttributes $this$annotations) {
        Intrinsics.checkNotNullParameter($this$annotations, "<this>");
        Object object = AnnotationsTypeAttributeKt.getAnnotationsAttribute($this$annotations);
        if (object == null || (object = ((AnnotationsTypeAttribute)object).getAnnotations()) == null) {
            object = Annotations.Companion.getEMPTY();
        }
        return object;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1(new PropertyReference1Impl(AnnotationsTypeAttributeKt.class, "annotationsAttribute", "getAnnotationsAttribute(Lorg/jetbrains/kotlin/types/TypeAttributes;)Lorg/jetbrains/kotlin/types/AnnotationsTypeAttribute;", 1))};
        $$delegatedProperties = kPropertyArray;
        TypeAttributes.Companion this_$iv = TypeAttributes.Companion;
        boolean $i$f$attributeAccessor = false;
        NullableArrayMapAccessor nullableArrayMapAccessor = this_$iv.generateNullableAccessor(Reflection.getOrCreateKotlinClass(AnnotationsTypeAttribute.class));
        Intrinsics.checkNotNull(nullableArrayMapAccessor, "null cannot be cast to non-null type kotlin.properties.ReadOnlyProperty<org.jetbrains.kotlin.types.TypeAttributes, T of org.jetbrains.kotlin.types.TypeAttributes.Companion.attributeAccessor?>");
        annotationsAttribute$delegate = nullableArrayMapAccessor;
    }
}

