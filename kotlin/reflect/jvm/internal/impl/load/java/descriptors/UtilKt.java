/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nutil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 util.kt\norg/jetbrains/kotlin/load/java/descriptors/UtilKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,65:1\n1563#2:66\n1634#2,3:67\n*S KotlinDebug\n*F\n+ 1 util.kt\norg/jetbrains/kotlin/load/java/descriptors/UtilKt\n*L\n40#1:66\n40#1:67,3\n*E\n"})
public final class UtilKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<ValueParameterDescriptor> copyValueParameters(@NotNull Collection<? extends KotlinType> newValueParameterTypes, @NotNull Collection<? extends ValueParameterDescriptor> oldValueParameters, @NotNull CallableDescriptor newOwner) {
        void $this$mapTo$iv$iv;
        boolean bl2;
        Intrinsics.checkNotNullParameter(newValueParameterTypes, "newValueParameterTypes");
        Intrinsics.checkNotNullParameter(oldValueParameters, "oldValueParameters");
        Intrinsics.checkNotNullParameter(newOwner, "newOwner");
        boolean bl3 = bl2 = newValueParameterTypes.size() == oldValueParameters.size();
        if (_Assertions.ENABLED && !bl2) {
            boolean $i$a$-assert-UtilKt$copyValueParameters$22 = false;
            String $i$a$-assert-UtilKt$copyValueParameters$22 = "Different value parameters sizes: Enhanced = " + newValueParameterTypes.size() + ", Old = " + oldValueParameters.size();
            throw new AssertionError((Object)$i$a$-assert-UtilKt$copyValueParameters$22);
        }
        Iterable $this$map$iv = CollectionsKt.zip((Iterable)newValueParameterTypes, (Iterable)oldValueParameters);
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            Pair pair = (Pair)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl4 = false;
            KotlinType newParameterType = (KotlinType)pair.component1();
            ValueParameterDescriptor oldParameter = (ValueParameterDescriptor)pair.component2();
            int n2 = oldParameter.getIndex();
            Annotations annotations = oldParameter.getAnnotations();
            Name name = oldParameter.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            boolean bl5 = oldParameter.declaresDefaultValue();
            boolean bl6 = oldParameter.isCrossinline();
            boolean bl7 = oldParameter.isNoinline();
            KotlinType kotlinType = oldParameter.getVarargElementType() != null ? DescriptorUtilsKt.getModule(newOwner).getBuiltIns().getArrayElementType(newParameterType) : null;
            SourceElement sourceElement = oldParameter.getSource();
            Intrinsics.checkNotNullExpressionValue(sourceElement, "getSource(...)");
            collection.add(new ValueParameterDescriptorImpl(newOwner, null, n2, annotations, name, newParameterType, bl5, bl6, bl7, kotlinType, sourceElement));
        }
        return (List)destination$iv$iv;
    }

    @Nullable
    public static final LazyJavaStaticClassScope getParentJavaStaticClassScope(@NotNull ClassDescriptor $this$getParentJavaStaticClassScope) {
        Intrinsics.checkNotNullParameter($this$getParentJavaStaticClassScope, "<this>");
        ClassDescriptor classDescriptor = DescriptorUtilsKt.getSuperClassNotAny($this$getParentJavaStaticClassScope);
        if (classDescriptor == null) {
            return null;
        }
        ClassDescriptor superClassDescriptor = classDescriptor;
        MemberScope memberScope = superClassDescriptor.getStaticScope();
        LazyJavaStaticClassScope lazyJavaStaticClassScope = memberScope instanceof LazyJavaStaticClassScope ? (LazyJavaStaticClassScope)memberScope : null;
        if (lazyJavaStaticClassScope == null) {
            lazyJavaStaticClassScope = UtilKt.getParentJavaStaticClassScope(superClassDescriptor);
        }
        return lazyJavaStaticClassScope;
    }
}

