/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.AnnotationsTypeAttribute;
import kotlin.reflect.jvm.internal.impl.types.AnnotationsTypeAttributeKt;
import kotlin.reflect.jvm.internal.impl.types.DefaultTypeAttributeTranslator;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nTypeAttributes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeAttributes.kt\norg/jetbrains/kotlin/types/TypeAttributesKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,133:1\n1#2:134\n*E\n"})
public final class TypeAttributesKt {
    @NotNull
    public static final TypeAttributes toDefaultAttributes(@NotNull Annotations $this$toDefaultAttributes) {
        Intrinsics.checkNotNullParameter($this$toDefaultAttributes, "<this>");
        return TypeAttributeTranslator.DefaultImpls.toAttributes$default(DefaultTypeAttributeTranslator.INSTANCE, $this$toDefaultAttributes, null, null, 6, null);
    }

    @NotNull
    public static final TypeAttributes replaceAnnotations(@NotNull TypeAttributes $this$replaceAnnotations, @NotNull Annotations newAnnotations) {
        Object withoutAnnotations;
        block6: {
            Object object;
            block5: {
                Intrinsics.checkNotNullParameter($this$replaceAnnotations, "<this>");
                Intrinsics.checkNotNullParameter(newAnnotations, "newAnnotations");
                if (AnnotationsTypeAttributeKt.getAnnotations($this$replaceAnnotations) == newAnnotations) {
                    return $this$replaceAnnotations;
                }
                object = AnnotationsTypeAttributeKt.getAnnotationsAttribute($this$replaceAnnotations);
                if (object == null) break block5;
                AnnotationsTypeAttribute it = object;
                boolean bl2 = false;
                TypeAttributes typeAttributes = $this$replaceAnnotations.remove(it);
                object = typeAttributes;
                if (typeAttributes != null) break block6;
            }
            object = withoutAnnotations = $this$replaceAnnotations;
        }
        if (!newAnnotations.iterator().hasNext() && newAnnotations.isEmpty()) {
            return withoutAnnotations;
        }
        return ((TypeAttributes)withoutAnnotations).plus(new AnnotationsTypeAttribute(newAnnotations));
    }
}

