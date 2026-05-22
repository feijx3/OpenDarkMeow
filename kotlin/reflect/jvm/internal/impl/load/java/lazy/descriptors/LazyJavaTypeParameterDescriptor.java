/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractLazyTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nLazyJavaTypeParameterDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyJavaTypeParameterDescriptor.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaTypeParameterDescriptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,75:1\n1563#2:76\n1634#2,3:77\n*S KotlinDebug\n*F\n+ 1 LazyJavaTypeParameterDescriptor.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaTypeParameterDescriptor\n*L\n62#1:76\n62#1:77,3\n*E\n"})
public final class LazyJavaTypeParameterDescriptor
extends AbstractLazyTypeParameterDescriptor {
    @NotNull
    private final LazyJavaResolverContext c;
    @NotNull
    private final JavaTypeParameter javaTypeParameter;

    public LazyJavaTypeParameterDescriptor(@NotNull LazyJavaResolverContext c2, @NotNull JavaTypeParameter javaTypeParameter, int index, @NotNull DeclarationDescriptor containingDeclaration) {
        Intrinsics.checkNotNullParameter(c2, "c");
        Intrinsics.checkNotNullParameter(javaTypeParameter, "javaTypeParameter");
        Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
        super(c2.getStorageManager(), containingDeclaration, new LazyJavaAnnotations(c2, javaTypeParameter, false, 4, null), javaTypeParameter.getName(), Variance.INVARIANT, false, index, SourceElement.NO_SOURCE, c2.getComponents().getSupertypeLoopChecker());
        this.c = c2;
        this.javaTypeParameter = javaTypeParameter;
    }

    @Override
    @NotNull
    protected List<KotlinType> resolveUpperBounds() {
        return this.computeNotEnhancedBounds();
    }

    /*
     * WARNING - void declaration
     */
    private final List<KotlinType> computeNotEnhancedBounds() {
        void $this$mapTo$iv$iv;
        Collection<JavaClassifierType> bounds = this.javaTypeParameter.getUpperBounds();
        if (bounds.isEmpty()) {
            SimpleType simpleType = this.c.getModule().getBuiltIns().getAnyType();
            Intrinsics.checkNotNullExpressionValue(simpleType, "getAnyType(...)");
            SimpleType simpleType2 = this.c.getModule().getBuiltIns().getNullableAnyType();
            Intrinsics.checkNotNullExpressionValue(simpleType2, "getNullableAnyType(...)");
            return CollectionsKt.listOf(KotlinTypeFactory.flexibleType(simpleType, simpleType2));
        }
        Iterable $this$map$iv = bounds;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            JavaClassifierType javaClassifierType = (JavaClassifierType)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(this.c.getTypeResolver().transformJavaType((JavaType)it, JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, this, 3, null)));
        }
        return (List)destination$iv$iv;
    }

    @NotNull
    protected List<KotlinType> processBoundsWithoutCycles(@NotNull List<? extends KotlinType> bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        return this.c.getComponents().getSignatureEnhancement().enhanceTypeParameterBounds(this, bounds, this.c);
    }

    @Override
    protected void reportSupertypeLoopError(@NotNull KotlinType type) {
        Intrinsics.checkNotNullParameter(type, "type");
    }
}

