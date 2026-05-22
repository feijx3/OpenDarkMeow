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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.Ref;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeRefinementSupport;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nKotlinTypeRefiner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KotlinTypeRefiner.kt\norg/jetbrains/kotlin/types/checker/KotlinTypeRefinerKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,90:1\n1563#2:91\n1634#2,3:92\n*S KotlinDebug\n*F\n+ 1 KotlinTypeRefiner.kt\norg/jetbrains/kotlin/types/checker/KotlinTypeRefinerKt\n*L\n78#1:91\n78#1:92,3\n*E\n"})
public final class KotlinTypeRefinerKt {
    @NotNull
    private static final ModuleCapability<Ref<TypeRefinementSupport>> REFINER_CAPABILITY = new ModuleCapability("KotlinTypeRefiner");

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<KotlinType> refineTypes(@NotNull KotlinTypeRefiner $this$refineTypes, @NotNull Iterable<? extends KotlinType> types) {
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter($this$refineTypes, "<this>");
        Intrinsics.checkNotNullParameter(types, "types");
        Iterable<? extends KotlinType> $this$map$iv = types;
        boolean $i$f$map = false;
        Iterable<? extends KotlinType> iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            KotlinType kotlinType = (KotlinType)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add($this$refineTypes.refineType((KotlinTypeMarker)it));
        }
        return (List)destination$iv$iv;
    }

    @NotNull
    public static final ModuleCapability<Ref<TypeRefinementSupport>> getREFINER_CAPABILITY() {
        return REFINER_CAPABILITY;
    }
}

