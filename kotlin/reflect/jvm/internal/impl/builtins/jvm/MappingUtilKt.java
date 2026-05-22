/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nmappingUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 mappingUtil.kt\norg/jetbrains/kotlin/builtins/jvm/MappingUtilKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,24:1\n1563#2:25\n1634#2,3:26\n1563#2:29\n1634#2,3:30\n*S KotlinDebug\n*F\n+ 1 mappingUtil.kt\norg/jetbrains/kotlin/builtins/jvm/MappingUtilKt\n*L\n20#1:25\n20#1:26,3\n21#1:29\n21#1:30,3\n*E\n"})
public final class MappingUtilKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final TypeConstructorSubstitution createMappedTypeParametersSubstitution(@NotNull ClassDescriptor from, @NotNull ClassDescriptor to) {
        Collection<TypeProjection> collection;
        TypeParameterDescriptor p0;
        Iterable iterable;
        Iterable $this$mapTo$iv$iv;
        Iterable $this$map$iv;
        boolean bl2;
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        boolean bl3 = bl2 = from.getDeclaredTypeParameters().size() == to.getDeclaredTypeParameters().size();
        if (_Assertions.ENABLED && !bl2) {
            boolean $i$a$-assert-MappingUtilKt$createMappedTypeParametersSubstitution$22 = false;
            String $i$a$-assert-MappingUtilKt$createMappedTypeParametersSubstitution$22 = from + " and " + to + " should have same number of type parameters, but " + from.getDeclaredTypeParameters().size() + " / " + to.getDeclaredTypeParameters().size() + " found";
            throw new AssertionError((Object)$i$a$-assert-MappingUtilKt$createMappedTypeParametersSubstitution$22);
        }
        List<TypeParameterDescriptor> list = from.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(list, "getDeclaredTypeParameters(...)");
        Iterable iterable2 = list;
        TypeConstructorSubstitution.Companion companion = TypeConstructorSubstitution.Companion;
        boolean $i$f$map = false;
        void var4_8 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor)item$iv$iv;
            iterable = destination$iv$iv;
            boolean bl4 = false;
            iterable.add(p0.getTypeConstructor());
        }
        Iterable iterable3 = (List)destination$iv$iv;
        List<TypeParameterDescriptor> list2 = to.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(list2, "getDeclaredTypeParameters(...)");
        $this$map$iv = list2;
        iterable = iterable3;
        $i$f$map = false;
        $this$mapTo$iv$iv = $this$map$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            p0 = (TypeParameterDescriptor)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl5 = false;
            SimpleType simpleType = it.getDefaultType();
            Intrinsics.checkNotNullExpressionValue(simpleType, "getDefaultType(...)");
            collection.add(TypeUtilsKt.asTypeProjection(simpleType));
        }
        collection = (List)destination$iv$iv;
        return TypeConstructorSubstitution.Companion.createByConstructorsMap$default(companion, MapsKt.toMap(CollectionsKt.zip(iterable, (Iterable)collection)), false, 2, null);
    }
}

