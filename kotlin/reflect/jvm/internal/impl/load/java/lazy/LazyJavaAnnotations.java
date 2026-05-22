/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaAnnotations
implements Annotations {
    @NotNull
    private final LazyJavaResolverContext c;
    @NotNull
    private final JavaAnnotationOwner annotationOwner;
    private final boolean areAnnotationsFreshlySupported;
    @NotNull
    private final MemoizedFunctionToNullable<JavaAnnotation, AnnotationDescriptor> annotationDescriptors;

    public LazyJavaAnnotations(@NotNull LazyJavaResolverContext c2, @NotNull JavaAnnotationOwner annotationOwner, boolean areAnnotationsFreshlySupported) {
        Intrinsics.checkNotNullParameter(c2, "c");
        Intrinsics.checkNotNullParameter(annotationOwner, "annotationOwner");
        this.c = c2;
        this.annotationOwner = annotationOwner;
        this.areAnnotationsFreshlySupported = areAnnotationsFreshlySupported;
        LazyJavaAnnotations lazyJavaAnnotations = this;
        this.annotationDescriptors = this.c.getComponents().getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaAnnotations$$Lambda$0(lazyJavaAnnotations));
    }

    public /* synthetic */ LazyJavaAnnotations(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotationOwner javaAnnotationOwner, boolean bl2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 4) != 0) {
            bl2 = false;
        }
        this(lazyJavaResolverContext, javaAnnotationOwner, bl2);
    }

    @Override
    @Nullable
    public AnnotationDescriptor findAnnotation(@NotNull FqName fqName) {
        JavaAnnotation javaAnnotation;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Object object = this.annotationOwner.findAnnotation(fqName);
        if (object == null || (object = (AnnotationDescriptor)((Function1)this.annotationDescriptors).invoke(javaAnnotation = object)) == null) {
            object = JavaAnnotationMapper.INSTANCE.findMappedJavaAnnotation(fqName, this.annotationOwner, this.c);
        }
        return object;
    }

    @Override
    @NotNull
    public Iterator<AnnotationDescriptor> iterator() {
        return SequencesKt.filterNotNull(SequencesKt.plus(SequencesKt.map(CollectionsKt.asSequence((Iterable)this.annotationOwner.getAnnotations()), (Function1)this.annotationDescriptors), JavaAnnotationMapper.INSTANCE.findMappedJavaAnnotation(StandardNames.FqNames.deprecated, this.annotationOwner, this.c))).iterator();
    }

    @Override
    public boolean isEmpty() {
        return this.annotationOwner.getAnnotations().isEmpty() && !this.annotationOwner.isDeprecatedInJavaDoc();
    }

    @Override
    public boolean hasAnnotation(@NotNull FqName fqName) {
        return Annotations.DefaultImpls.hasAnnotation(this, fqName);
    }

    private static final AnnotationDescriptor annotationDescriptors$lambda$0(LazyJavaAnnotations this$0, JavaAnnotation annotation) {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        return JavaAnnotationMapper.INSTANCE.mapOrResolveJavaAnnotation(annotation, this$0.c, this$0.areAnnotationsFreshlySupported);
    }

    static /* synthetic */ AnnotationDescriptor accessor$LazyJavaAnnotations$lambda0(LazyJavaAnnotations lazyJavaAnnotations, JavaAnnotation javaAnnotation) {
        return LazyJavaAnnotations.annotationDescriptors$lambda$0(lazyJavaAnnotations, javaAnnotation);
    }
}

