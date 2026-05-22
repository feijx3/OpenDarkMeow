/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.types.DynamicTypesKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nIntersectionType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntersectionType.kt\norg/jetbrains/kotlin/types/checker/IntersectionTypeKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,183:1\n1563#2:184\n1634#2,3:185\n1563#2:188\n1634#2,3:189\n1563#2:192\n1634#2,3:193\n*S KotlinDebug\n*F\n+ 1 IntersectionType.kt\norg/jetbrains/kotlin/types/checker/IntersectionTypeKt\n*L\n26#1:184\n26#1:185,3\n38#1:188\n38#1:189,3\n58#1:192\n58#1:193,3\n*E\n"})
public final class IntersectionTypeKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final UnwrappedType intersectTypes(@NotNull Collection<? extends UnwrappedType> types) {
        void $this$mapTo$iv$iv;
        Collection collection;
        void $this$mapTo$iv$iv2;
        Intrinsics.checkNotNullParameter(types, "types");
        switch (types.size()) {
            case 0: {
                throw new IllegalStateException("Expected some types".toString());
            }
            case 1: {
                return (UnwrappedType)CollectionsKt.single((Iterable)types);
            }
        }
        boolean hasFlexibleTypes = false;
        boolean hasErrorType = false;
        String[] $this$map$iv = (String[])types;
        boolean $i$f$map = false;
        String[] stringArray = $this$map$iv;
        Iterable destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv2) {
            SimpleType simpleType;
            void it;
            UnwrappedType unwrappedType = (UnwrappedType)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl2 = false;
            hasErrorType = hasErrorType || KotlinTypeKt.isError((KotlinType)it);
            void var13_17 = it;
            if (var13_17 instanceof SimpleType) {
                simpleType = (SimpleType)it;
            } else if (var13_17 instanceof FlexibleType) {
                if (DynamicTypesKt.isDynamic((KotlinType)it)) {
                    return it;
                }
                hasFlexibleTypes = true;
                simpleType = ((FlexibleType)it).getLowerBound();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            collection.add(simpleType);
        }
        List lowerBounds = (List)destination$iv$iv;
        if (hasErrorType) {
            $this$map$iv = new String[]{types.toString()};
            return ErrorUtils.createErrorType(ErrorTypeKind.INTERSECTION_OF_ERROR_TYPES, $this$map$iv);
        }
        if (!hasFlexibleTypes) {
            return TypeIntersector.INSTANCE.intersectTypes$descriptors(lowerBounds);
        }
        Iterable $this$map$iv2 = types;
        boolean $i$f$map2 = false;
        destination$iv$iv = $this$map$iv2;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        boolean $i$f$mapTo2 = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            UnwrappedType bl2 = (UnwrappedType)item$iv$iv;
            collection = destination$iv$iv2;
            boolean bl3 = false;
            collection.add(FlexibleTypesKt.upperIfFlexible((KotlinType)it));
        }
        List upperBounds = (List)destination$iv$iv2;
        return KotlinTypeFactory.flexibleType(TypeIntersector.INSTANCE.intersectTypes$descriptors(lowerBounds), TypeIntersector.INSTANCE.intersectTypes$descriptors(upperBounds));
    }
}

