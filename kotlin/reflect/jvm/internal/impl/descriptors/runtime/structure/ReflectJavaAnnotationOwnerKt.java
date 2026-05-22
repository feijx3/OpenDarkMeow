/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nReflectJavaAnnotationOwner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJavaAnnotationOwner.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaAnnotationOwnerKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,43:1\n11228#2:44\n11563#2,3:45\n1310#2,2:48\n1#3:50\n*S KotlinDebug\n*F\n+ 1 ReflectJavaAnnotationOwner.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaAnnotationOwnerKt\n*L\n37#1:44\n37#1:45,3\n41#1:48,2\n*E\n"})
public final class ReflectJavaAnnotationOwnerKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<ReflectJavaAnnotation> getAnnotations(@NotNull Annotation[] $this$getAnnotations) {
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter($this$getAnnotations, "<this>");
        Annotation[] $this$map$iv = $this$getAnnotations;
        boolean $i$f$map = false;
        Annotation[] annotationArray = $this$map$iv;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length);
        boolean $i$f$mapTo = false;
        int n2 = ((void)$this$mapTo$iv$iv).length;
        for (int i2 = 0; i2 < n2; ++i2) {
            void p0;
            void item$iv$iv;
            void var9_9 = item$iv$iv = $this$mapTo$iv$iv[i2];
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(new ReflectJavaAnnotation((Annotation)p0));
        }
        return (List)destination$iv$iv;
    }

    @Nullable
    public static final ReflectJavaAnnotation findAnnotation(@NotNull Annotation[] $this$findAnnotation, @NotNull FqName fqName) {
        ReflectJavaAnnotation reflectJavaAnnotation;
        Annotation annotation;
        block3: {
            Intrinsics.checkNotNullParameter($this$findAnnotation, "<this>");
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            Annotation[] $this$firstOrNull$iv = $this$findAnnotation;
            boolean $i$f$firstOrNull = false;
            int n2 = $this$firstOrNull$iv.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                Annotation element$iv;
                Annotation it = element$iv = $this$firstOrNull$iv[i2];
                boolean bl2 = false;
                if (!Intrinsics.areEqual(ReflectClassUtilKt.getClassId(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(it))).asSingleFqName(), fqName)) continue;
                annotation = element$iv;
                break block3;
            }
            annotation = null;
        }
        if (annotation != null) {
            Annotation p0 = annotation;
            boolean bl3 = false;
            reflectJavaAnnotation = new ReflectJavaAnnotation(p0);
        } else {
            reflectJavaAnnotation = null;
        }
        return reflectJavaAnnotation;
    }
}

