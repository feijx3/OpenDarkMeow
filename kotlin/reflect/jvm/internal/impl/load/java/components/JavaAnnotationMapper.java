/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaDeprecatedAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaRetentionAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaTargetAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaAnnotationMapper {
    @NotNull
    public static final JavaAnnotationMapper INSTANCE = new JavaAnnotationMapper();
    @NotNull
    private static final Name DEPRECATED_ANNOTATION_MESSAGE;
    @NotNull
    private static final Name TARGET_ANNOTATION_ALLOWED_TARGETS;
    @NotNull
    private static final Name RETENTION_ANNOTATION_VALUE;
    @NotNull
    private static final Map<FqName, FqName> kotlinToJavaNameMap;

    private JavaAnnotationMapper() {
    }

    @NotNull
    public final Name getDEPRECATED_ANNOTATION_MESSAGE$descriptors_jvm() {
        return DEPRECATED_ANNOTATION_MESSAGE;
    }

    @NotNull
    public final Name getTARGET_ANNOTATION_ALLOWED_TARGETS$descriptors_jvm() {
        return TARGET_ANNOTATION_ALLOWED_TARGETS;
    }

    @NotNull
    public final Name getRETENTION_ANNOTATION_VALUE$descriptors_jvm() {
        return RETENTION_ANNOTATION_VALUE;
    }

    @Nullable
    public final AnnotationDescriptor mapOrResolveJavaAnnotation(@NotNull JavaAnnotation annotation, @NotNull LazyJavaResolverContext c2, boolean isFreshlySupportedAnnotation) {
        AnnotationDescriptor annotationDescriptor;
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        Intrinsics.checkNotNullParameter(c2, "c");
        ClassId classId = annotation.getClassId();
        FqName fqName = JvmAnnotationNames.TARGET_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(fqName, "TARGET_ANNOTATION");
        if (Intrinsics.areEqual(classId, ClassId.Companion.topLevel(fqName))) {
            annotationDescriptor = new JavaTargetAnnotationDescriptor(annotation, c2);
        } else {
            FqName fqName2 = JvmAnnotationNames.RETENTION_ANNOTATION;
            Intrinsics.checkNotNullExpressionValue(fqName2, "RETENTION_ANNOTATION");
            if (Intrinsics.areEqual(classId, ClassId.Companion.topLevel(fqName2))) {
                annotationDescriptor = new JavaRetentionAnnotationDescriptor(annotation, c2);
            } else {
                FqName fqName3 = JvmAnnotationNames.DOCUMENTED_ANNOTATION;
                Intrinsics.checkNotNullExpressionValue(fqName3, "DOCUMENTED_ANNOTATION");
                if (Intrinsics.areEqual(classId, ClassId.Companion.topLevel(fqName3))) {
                    annotationDescriptor = new JavaAnnotationDescriptor(c2, annotation, StandardNames.FqNames.mustBeDocumented);
                } else {
                    FqName fqName4 = JvmAnnotationNames.DEPRECATED_ANNOTATION;
                    Intrinsics.checkNotNullExpressionValue(fqName4, "DEPRECATED_ANNOTATION");
                    annotationDescriptor = Intrinsics.areEqual(classId, ClassId.Companion.topLevel(fqName4)) ? null : (AnnotationDescriptor)new LazyJavaAnnotationDescriptor(c2, annotation, isFreshlySupportedAnnotation);
                }
            }
        }
        return annotationDescriptor;
    }

    public static /* synthetic */ AnnotationDescriptor mapOrResolveJavaAnnotation$default(JavaAnnotationMapper javaAnnotationMapper, JavaAnnotation javaAnnotation, LazyJavaResolverContext lazyJavaResolverContext, boolean bl2, int n2, Object object) {
        if ((n2 & 4) != 0) {
            bl2 = false;
        }
        return javaAnnotationMapper.mapOrResolveJavaAnnotation(javaAnnotation, lazyJavaResolverContext, bl2);
    }

    @Nullable
    public final AnnotationDescriptor findMappedJavaAnnotation(@NotNull FqName kotlinName, @NotNull JavaAnnotationOwner annotationOwner, @NotNull LazyJavaResolverContext c2) {
        AnnotationDescriptor annotationDescriptor;
        Intrinsics.checkNotNullParameter(kotlinName, "kotlinName");
        Intrinsics.checkNotNullParameter(annotationOwner, "annotationOwner");
        Intrinsics.checkNotNullParameter(c2, "c");
        if (Intrinsics.areEqual(kotlinName, StandardNames.FqNames.deprecated)) {
            FqName fqName = JvmAnnotationNames.DEPRECATED_ANNOTATION;
            Intrinsics.checkNotNullExpressionValue(fqName, "DEPRECATED_ANNOTATION");
            JavaAnnotation javaAnnotation = annotationOwner.findAnnotation(fqName);
            if (javaAnnotation != null || annotationOwner.isDeprecatedInJavaDoc()) {
                return new JavaDeprecatedAnnotationDescriptor(javaAnnotation, c2);
            }
        }
        FqName fqName = kotlinToJavaNameMap.get(kotlinName);
        if (fqName != null) {
            FqName javaName = fqName;
            boolean bl2 = false;
            JavaAnnotation javaAnnotation = annotationOwner.findAnnotation(javaName);
            if (javaAnnotation != null) {
                JavaAnnotation annotation = javaAnnotation;
                boolean bl3 = false;
                annotationDescriptor = JavaAnnotationMapper.mapOrResolveJavaAnnotation$default(INSTANCE, annotation, c2, false, 4, null);
            } else {
                annotationDescriptor = null;
            }
        } else {
            annotationDescriptor = null;
        }
        return annotationDescriptor;
    }

    static {
        Name name = Name.identifier("message");
        Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
        DEPRECATED_ANNOTATION_MESSAGE = name;
        Name name2 = Name.identifier("allowedTargets");
        Intrinsics.checkNotNullExpressionValue(name2, "identifier(...)");
        TARGET_ANNOTATION_ALLOWED_TARGETS = name2;
        Name name3 = Name.identifier("value");
        Intrinsics.checkNotNullExpressionValue(name3, "identifier(...)");
        RETENTION_ANNOTATION_VALUE = name3;
        Pair[] pairArray = new Pair[]{TuplesKt.to(StandardNames.FqNames.target, JvmAnnotationNames.TARGET_ANNOTATION), TuplesKt.to(StandardNames.FqNames.retention, JvmAnnotationNames.RETENTION_ANNOTATION), TuplesKt.to(StandardNames.FqNames.mustBeDocumented, JvmAnnotationNames.DOCUMENTED_ANNOTATION)};
        kotlinToJavaNameMap = MapsKt.mapOf(pairArray);
    }
}

