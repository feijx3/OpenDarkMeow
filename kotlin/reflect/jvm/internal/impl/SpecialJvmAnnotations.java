/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nSpecialJvmAnnotations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpecialJvmAnnotations.kt\norg/jetbrains/kotlin/SpecialJvmAnnotations\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,42:1\n1634#2,3:43\n*S KotlinDebug\n*F\n+ 1 SpecialJvmAnnotations.kt\norg/jetbrains/kotlin/SpecialJvmAnnotations\n*L\n22#1:43,3\n*E\n"})
public final class SpecialJvmAnnotations {
    @NotNull
    public static final SpecialJvmAnnotations INSTANCE;
    @NotNull
    private static final Set<ClassId> SPECIAL_ANNOTATIONS;
    @NotNull
    private static final ClassId JAVA_LANG_ANNOTATION_REPEATABLE;

    private SpecialJvmAnnotations() {
    }

    @NotNull
    public final Set<ClassId> getSPECIAL_ANNOTATIONS() {
        return SPECIAL_ANNOTATIONS;
    }

    @NotNull
    public final ClassId getJAVA_LANG_ANNOTATION_REPEATABLE() {
        return JAVA_LANG_ANNOTATION_REPEATABLE;
    }

    public final boolean isAnnotatedWithContainerMetaAnnotation(@NotNull KotlinJvmBinaryClass klass) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        Ref.BooleanRef result = new Ref.BooleanRef();
        klass.loadClassAnnotations(new KotlinJvmBinaryClass.AnnotationVisitor(result){
            final /* synthetic */ Ref.BooleanRef $result;
            {
                this.$result = $result;
            }

            public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(ClassId classId, SourceElement source) {
                Intrinsics.checkNotNullParameter(classId, "classId");
                Intrinsics.checkNotNullParameter(source, "source");
                if (Intrinsics.areEqual(classId, JvmAbi.INSTANCE.getREPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION())) {
                    this.$result.element = true;
                }
                return null;
            }

            public void visitEnd() {
            }
        }, null);
        return result.element;
    }

    /*
     * WARNING - void declaration
     */
    static {
        void $this$mapTo$iv;
        INSTANCE = new SpecialJvmAnnotations();
        Object object = new FqName[]{JvmAnnotationNames.METADATA_FQ_NAME, JvmAnnotationNames.JETBRAINS_NOT_NULL_ANNOTATION, JvmAnnotationNames.JETBRAINS_NULLABLE_ANNOTATION, JvmAnnotationNames.TARGET_ANNOTATION, JvmAnnotationNames.RETENTION_ANNOTATION, JvmAnnotationNames.DOCUMENTED_ANNOTATION};
        object = CollectionsKt.listOf(object);
        Collection collection = new LinkedHashSet();
        ClassId.Companion companion = ClassId.Companion;
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            void p0;
            void destination$iv;
            FqName fqName = (FqName)item$iv;
            void var8_8 = destination$iv;
            boolean bl2 = false;
            var8_8.add(companion.topLevel((FqName)p0));
        }
        SPECIAL_ANNOTATIONS = (Set)collection;
        FqName fqName = JvmAnnotationNames.REPEATABLE_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(fqName, "REPEATABLE_ANNOTATION");
        JAVA_LANG_ANNOTATION_REPEATABLE = ClassId.Companion.topLevel(fqName);
    }
}

