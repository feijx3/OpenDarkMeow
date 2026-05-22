/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaTypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ContextKt {
    @NotNull
    public static final LazyJavaResolverContext child(@NotNull LazyJavaResolverContext $this$child, @NotNull TypeParameterResolver typeParameterResolver) {
        Intrinsics.checkNotNullParameter($this$child, "<this>");
        Intrinsics.checkNotNullParameter(typeParameterResolver, "typeParameterResolver");
        return new LazyJavaResolverContext($this$child.getComponents(), typeParameterResolver, $this$child.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
    }

    @Nullable
    public static final JavaTypeQualifiersByElementType computeNewDefaultTypeQualifiers(@NotNull LazyJavaResolverContext $this$computeNewDefaultTypeQualifiers, @NotNull Annotations additionalAnnotations) {
        Intrinsics.checkNotNullParameter($this$computeNewDefaultTypeQualifiers, "<this>");
        Intrinsics.checkNotNullParameter(additionalAnnotations, "additionalAnnotations");
        return $this$computeNewDefaultTypeQualifiers.getComponents().getAnnotationTypeQualifierResolver().extractAndMergeDefaultQualifiers($this$computeNewDefaultTypeQualifiers.getDefaultTypeQualifiers(), additionalAnnotations);
    }

    @NotNull
    public static final LazyJavaResolverContext replaceComponents(@NotNull LazyJavaResolverContext $this$replaceComponents, @NotNull JavaResolverComponents components) {
        Intrinsics.checkNotNullParameter($this$replaceComponents, "<this>");
        Intrinsics.checkNotNullParameter(components, "components");
        return new LazyJavaResolverContext(components, $this$replaceComponents.getTypeParameterResolver(), $this$replaceComponents.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
    }

    /*
     * WARNING - void declaration
     */
    private static final LazyJavaResolverContext child(LazyJavaResolverContext $this$child, DeclarationDescriptor containingDeclaration, JavaTypeParameterListOwner typeParameterOwner, int typeParametersIndexOffset, Lazy<JavaTypeQualifiersByElementType> delegateForTypeQualifiers) {
        TypeParameterResolver typeParameterResolver;
        JavaResolverComponents javaResolverComponents2 = $this$child.getComponents();
        JavaTypeParameterListOwner javaTypeParameterListOwner = typeParameterOwner;
        if (javaTypeParameterListOwner != null) {
            void it;
            JavaTypeParameterListOwner javaTypeParameterListOwner2 = javaTypeParameterListOwner;
            JavaResolverComponents javaResolverComponents3 = javaResolverComponents2;
            boolean bl2 = false;
            javaResolverComponents2 = javaResolverComponents3;
            typeParameterResolver = new LazyJavaTypeParameterResolver($this$child, containingDeclaration, (JavaTypeParameterListOwner)it, typeParametersIndexOffset);
        } else {
            typeParameterResolver = $this$child.getTypeParameterResolver();
        }
        Lazy<JavaTypeQualifiersByElementType> lazy = delegateForTypeQualifiers;
        TypeParameterResolver typeParameterResolver2 = typeParameterResolver;
        JavaResolverComponents javaResolverComponents4 = javaResolverComponents2;
        return new LazyJavaResolverContext(javaResolverComponents4, typeParameterResolver2, lazy);
    }

    @NotNull
    public static final LazyJavaResolverContext childForMethod(@NotNull LazyJavaResolverContext $this$childForMethod, @NotNull DeclarationDescriptor containingDeclaration, @NotNull JavaTypeParameterListOwner typeParameterOwner, int typeParametersIndexOffset) {
        Intrinsics.checkNotNullParameter($this$childForMethod, "<this>");
        Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
        Intrinsics.checkNotNullParameter(typeParameterOwner, "typeParameterOwner");
        return ContextKt.child($this$childForMethod, containingDeclaration, typeParameterOwner, typeParametersIndexOffset, $this$childForMethod.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
    }

    public static /* synthetic */ LazyJavaResolverContext childForMethod$default(LazyJavaResolverContext lazyJavaResolverContext, DeclarationDescriptor declarationDescriptor, JavaTypeParameterListOwner javaTypeParameterListOwner, int n2, int n3, Object object) {
        if ((n3 & 4) != 0) {
            n2 = 0;
        }
        return ContextKt.childForMethod(lazyJavaResolverContext, declarationDescriptor, javaTypeParameterListOwner, n2);
    }

    @NotNull
    public static final LazyJavaResolverContext childForClassOrPackage(@NotNull LazyJavaResolverContext $this$childForClassOrPackage, @NotNull ClassOrPackageFragmentDescriptor containingDeclaration, @Nullable JavaTypeParameterListOwner typeParameterOwner, int typeParametersIndexOffset) {
        Intrinsics.checkNotNullParameter($this$childForClassOrPackage, "<this>");
        Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
        ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor = containingDeclaration;
        LazyJavaResolverContext lazyJavaResolverContext = $this$childForClassOrPackage;
        return ContextKt.child($this$childForClassOrPackage, containingDeclaration, typeParameterOwner, typeParametersIndexOffset, LazyKt.lazy(LazyThreadSafetyMode.NONE, new ContextKt$$Lambda$0(lazyJavaResolverContext, classOrPackageFragmentDescriptor)));
    }

    public static /* synthetic */ LazyJavaResolverContext childForClassOrPackage$default(LazyJavaResolverContext lazyJavaResolverContext, ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor, JavaTypeParameterListOwner javaTypeParameterListOwner, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            javaTypeParameterListOwner = null;
        }
        if ((n3 & 4) != 0) {
            n2 = 0;
        }
        return ContextKt.childForClassOrPackage(lazyJavaResolverContext, classOrPackageFragmentDescriptor, javaTypeParameterListOwner, n2);
    }

    @NotNull
    public static final LazyJavaResolverContext copyWithNewDefaultTypeQualifiers(@NotNull LazyJavaResolverContext $this$copyWithNewDefaultTypeQualifiers, @NotNull Annotations additionalAnnotations) {
        LazyJavaResolverContext lazyJavaResolverContext;
        Intrinsics.checkNotNullParameter($this$copyWithNewDefaultTypeQualifiers, "<this>");
        Intrinsics.checkNotNullParameter(additionalAnnotations, "additionalAnnotations");
        if (additionalAnnotations.isEmpty()) {
            lazyJavaResolverContext = $this$copyWithNewDefaultTypeQualifiers;
        } else {
            Annotations annotations = additionalAnnotations;
            LazyJavaResolverContext lazyJavaResolverContext2 = $this$copyWithNewDefaultTypeQualifiers;
            LazyJavaResolverContext lazyJavaResolverContext3 = new LazyJavaResolverContext($this$copyWithNewDefaultTypeQualifiers.getComponents(), $this$copyWithNewDefaultTypeQualifiers.getTypeParameterResolver(), LazyKt.lazy(LazyThreadSafetyMode.NONE, new ContextKt$$Lambda$1(lazyJavaResolverContext2, annotations)));
            lazyJavaResolverContext = lazyJavaResolverContext3;
        }
        return lazyJavaResolverContext;
    }

    private static final JavaTypeQualifiersByElementType childForClassOrPackage$lambda$1(LazyJavaResolverContext $this_childForClassOrPackage, ClassOrPackageFragmentDescriptor $containingDeclaration) {
        return ContextKt.computeNewDefaultTypeQualifiers($this_childForClassOrPackage, $containingDeclaration.getAnnotations());
    }

    private static final JavaTypeQualifiersByElementType copyWithNewDefaultTypeQualifiers$lambda$2(LazyJavaResolverContext $this_copyWithNewDefaultTypeQualifiers, Annotations $additionalAnnotations) {
        return ContextKt.computeNewDefaultTypeQualifiers($this_copyWithNewDefaultTypeQualifiers, $additionalAnnotations);
    }

    static /* synthetic */ JavaTypeQualifiersByElementType accessor$ContextKt$lambda0(LazyJavaResolverContext lazyJavaResolverContext, ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor) {
        return ContextKt.childForClassOrPackage$lambda$1(lazyJavaResolverContext, classOrPackageFragmentDescriptor);
    }

    static /* synthetic */ JavaTypeQualifiersByElementType accessor$ContextKt$lambda1(LazyJavaResolverContext lazyJavaResolverContext, Annotations annotations) {
        return ContextKt.copyWithNewDefaultTypeQualifiers$lambda$2(lazyJavaResolverContext, annotations);
    }
}

