/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaTypeParameterResolver$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaTypeParameterResolver
implements TypeParameterResolver {
    @NotNull
    private final LazyJavaResolverContext c;
    @NotNull
    private final DeclarationDescriptor containingDeclaration;
    private final int typeParametersIndexOffset;
    @NotNull
    private final Map<JavaTypeParameter, Integer> typeParameters;
    @NotNull
    private final MemoizedFunctionToNullable<JavaTypeParameter, LazyJavaTypeParameterDescriptor> resolve;

    public LazyJavaTypeParameterResolver(@NotNull LazyJavaResolverContext c2, @NotNull DeclarationDescriptor containingDeclaration, @NotNull JavaTypeParameterListOwner typeParameterOwner, int typeParametersIndexOffset) {
        Intrinsics.checkNotNullParameter(c2, "c");
        Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
        Intrinsics.checkNotNullParameter(typeParameterOwner, "typeParameterOwner");
        this.c = c2;
        this.containingDeclaration = containingDeclaration;
        this.typeParametersIndexOffset = typeParametersIndexOffset;
        this.typeParameters = CollectionsKt.mapToIndex((Iterable)typeParameterOwner.getTypeParameters());
        LazyJavaTypeParameterResolver lazyJavaTypeParameterResolver = this;
        this.resolve = this.c.getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaTypeParameterResolver$$Lambda$0(lazyJavaTypeParameterResolver));
    }

    @Override
    @Nullable
    public TypeParameterDescriptor resolveTypeParameter(@NotNull JavaTypeParameter javaTypeParameter) {
        Intrinsics.checkNotNullParameter(javaTypeParameter, "javaTypeParameter");
        LazyJavaTypeParameterDescriptor lazyJavaTypeParameterDescriptor = (LazyJavaTypeParameterDescriptor)this.resolve.invoke(javaTypeParameter);
        return lazyJavaTypeParameterDescriptor != null ? (TypeParameterDescriptor)lazyJavaTypeParameterDescriptor : this.c.getTypeParameterResolver().resolveTypeParameter(javaTypeParameter);
    }

    private static final LazyJavaTypeParameterDescriptor resolve$lambda$1(LazyJavaTypeParameterResolver this$0, JavaTypeParameter typeParameter) {
        LazyJavaTypeParameterDescriptor lazyJavaTypeParameterDescriptor;
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        Integer n2 = this$0.typeParameters.get(typeParameter);
        if (n2 != null) {
            int index = ((Number)n2).intValue();
            boolean bl2 = false;
            lazyJavaTypeParameterDescriptor = new LazyJavaTypeParameterDescriptor(ContextKt.copyWithNewDefaultTypeQualifiers(ContextKt.child(this$0.c, this$0), this$0.containingDeclaration.getAnnotations()), typeParameter, this$0.typeParametersIndexOffset + index, this$0.containingDeclaration);
        } else {
            lazyJavaTypeParameterDescriptor = null;
        }
        return lazyJavaTypeParameterDescriptor;
    }

    static /* synthetic */ LazyJavaTypeParameterDescriptor accessor$LazyJavaTypeParameterResolver$lambda0(LazyJavaTypeParameterResolver lazyJavaTypeParameterResolver, JavaTypeParameter javaTypeParameter) {
        return LazyJavaTypeParameterResolver.resolve$lambda$1(lazyJavaTypeParameterResolver, javaTypeParameter);
    }
}

