/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nCompanionObjectMapping.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompanionObjectMapping.kt\norg/jetbrains/kotlin/builtins/CompanionObjectMapping\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,20:1\n1563#2:21\n1634#2,3:22\n1634#2,3:25\n*S KotlinDebug\n*F\n+ 1 CompanionObjectMapping.kt\norg/jetbrains/kotlin/builtins/CompanionObjectMapping\n*L\n12#1:21\n12#1:22,3\n16#1:25,3\n*E\n"})
public final class CompanionObjectMapping {
    @NotNull
    public static final CompanionObjectMapping INSTANCE;
    @NotNull
    private static final Set<ClassId> classIds;

    private CompanionObjectMapping() {
    }

    @NotNull
    public final Set<ClassId> getClassIds() {
        return classIds;
    }

    @NotNull
    public final Set<ClassId> allClassesWithIntrinsicCompanions() {
        return classIds;
    }

    /*
     * WARNING - void declaration
     */
    static {
        void var1_2;
        void $this$mapTo$iv;
        Collection collection;
        void $this$mapTo$iv$iv;
        INSTANCE = new CompanionObjectMapping();
        Iterable $this$map$iv = PrimitiveType.NUMBER_TYPES;
        boolean $i$f$map22 = false;
        Object object = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void p0;
            PrimitiveType primitiveType = (PrimitiveType)((Object)item$iv$iv);
            collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(StandardNames.getPrimitiveFqName((PrimitiveType)p0));
        }
        $this$map$iv = CollectionsKt.plus((Collection)CollectionsKt.plus((Collection)CollectionsKt.plus((Collection)((List)destination$iv$iv), StandardNames.FqNames.string.toSafe()), StandardNames.FqNames._boolean.toSafe()), StandardNames.FqNames._enum.toSafe());
        Collection $i$f$map22 = new LinkedHashSet();
        object = ClassId.Companion;
        boolean $i$f$mapTo2 = false;
        for (Object item$iv : $this$mapTo$iv) {
            void p0;
            void destination$iv;
            Object item$iv$iv;
            item$iv$iv = (FqName)item$iv;
            collection = destination$iv;
            boolean bl3 = false;
            collection.add(((ClassId.Companion)object).topLevel((FqName)p0));
        }
        classIds = (Set)var1_2;
    }
}

