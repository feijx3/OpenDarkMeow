/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlin.reflect.jvm.internal.impl.name;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.StandardClassIds;

@SourceDebugExtension(value={"SMAP\nStandardClassIds.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StandardClassIds.kt\norg/jetbrains/kotlin/name/StandardClassIdsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,341:1\n1193#2,2:342\n1267#2,4:344\n*S KotlinDebug\n*F\n+ 1 StandardClassIds.kt\norg/jetbrains/kotlin/name/StandardClassIdsKt\n*L\n340#1:342,2\n340#1:344,4\n*E\n"})
public final class StandardClassIdsKt {
    private static final ClassId baseId(String $this$baseId) {
        FqName fqName = StandardClassIds.INSTANCE.getBASE_KOTLIN_PACKAGE();
        Name name = Name.identifier($this$baseId);
        Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
        return new ClassId(fqName, name);
    }

    private static final ClassId unsignedId(ClassId $this$unsignedId) {
        FqName fqName = StandardClassIds.INSTANCE.getBASE_KOTLIN_PACKAGE();
        Name name = Name.identifier('U' + $this$unsignedId.getShortClassName().getIdentifier());
        Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
        return new ClassId(fqName, name);
    }

    private static final ClassId reflectId(String $this$reflectId) {
        FqName fqName = StandardClassIds.INSTANCE.getBASE_REFLECT_PACKAGE();
        Name name = Name.identifier($this$reflectId);
        Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
        return new ClassId(fqName, name);
    }

    private static final ClassId primitiveArrayId(Name $this$primitiveArrayId) {
        FqName fqName = StandardClassIds.INSTANCE.getArray().getPackageFqName();
        Name name = Name.identifier($this$primitiveArrayId.getIdentifier() + StandardClassIds.INSTANCE.getArray().getShortClassName().getIdentifier());
        Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
        return new ClassId(fqName, name);
    }

    private static final ClassId collectionsId(String $this$collectionsId) {
        FqName fqName = StandardClassIds.INSTANCE.getBASE_COLLECTIONS_PACKAGE();
        Name name = Name.identifier($this$collectionsId);
        Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
        return new ClassId(fqName, name);
    }

    private static final ClassId rangesId(String $this$rangesId) {
        FqName fqName = StandardClassIds.INSTANCE.getBASE_RANGES_PACKAGE();
        Name name = Name.identifier($this$rangesId);
        Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
        return new ClassId(fqName, name);
    }

    private static final ClassId annotationId(String $this$annotationId) {
        FqName fqName = StandardClassIds.INSTANCE.getBASE_ANNOTATION_PACKAGE();
        Name name = Name.identifier($this$annotationId);
        Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
        return new ClassId(fqName, name);
    }

    private static final ClassId coroutinesId(String $this$coroutinesId) {
        FqName fqName = StandardClassIds.INSTANCE.getBASE_COROUTINES_PACKAGE();
        Name name = Name.identifier($this$coroutinesId);
        Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
        return new ClassId(fqName, name);
    }

    private static final ClassId enumsId(String $this$enumsId) {
        FqName fqName = StandardClassIds.INSTANCE.getBASE_ENUMS_PACKAGE();
        Name name = Name.identifier($this$enumsId);
        Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
        return new ClassId(fqName, name);
    }

    private static final ClassId atomicsId(String $this$atomicsId) {
        FqName fqName = StandardClassIds.INSTANCE.getBASE_CONCURRENT_ATOMICS_PACKAGE();
        Name name = Name.identifier($this$atomicsId);
        Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
        return new ClassId(fqName, name);
    }

    /*
     * WARNING - void declaration
     */
    private static final <K, V> Map<V, K> inverseMap(Map<K, ? extends V> $this$inverseMap) {
        void $this$associateTo$iv$iv;
        Iterable $this$associate$iv = $this$inverseMap.entrySet();
        boolean $i$f$associate = false;
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
        Iterable iterable = $this$associate$iv;
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        boolean $i$f$associateTo = false;
        for (Object element$iv$iv : $this$associateTo$iv$iv) {
            Map map = destination$iv$iv;
            Object object = (Map.Entry)element$iv$iv;
            boolean bl2 = false;
            Object k2 = object.getKey();
            Object v2 = object.getValue();
            object = TuplesKt.to(v2, k2);
            map.put(((Pair)object).getFirst(), ((Pair)object).getSecond());
        }
        return destination$iv$iv;
    }

    public static final /* synthetic */ ClassId access$baseId(String $receiver) {
        return StandardClassIdsKt.baseId($receiver);
    }

    public static final /* synthetic */ ClassId access$reflectId(String $receiver) {
        return StandardClassIdsKt.reflectId($receiver);
    }

    public static final /* synthetic */ ClassId access$coroutinesId(String $receiver) {
        return StandardClassIdsKt.coroutinesId($receiver);
    }

    public static final /* synthetic */ ClassId access$annotationId(String $receiver) {
        return StandardClassIdsKt.annotationId($receiver);
    }

    public static final /* synthetic */ ClassId access$primitiveArrayId(Name $receiver) {
        return StandardClassIdsKt.primitiveArrayId($receiver);
    }

    public static final /* synthetic */ ClassId access$unsignedId(ClassId $receiver) {
        return StandardClassIdsKt.unsignedId($receiver);
    }

    public static final /* synthetic */ Map access$inverseMap(Map $receiver) {
        return StandardClassIdsKt.inverseMap($receiver);
    }

    public static final /* synthetic */ ClassId access$collectionsId(String $receiver) {
        return StandardClassIdsKt.collectionsId($receiver);
    }

    public static final /* synthetic */ ClassId access$rangesId(String $receiver) {
        return StandardClassIdsKt.rangesId($receiver);
    }

    public static final /* synthetic */ ClassId access$enumsId(String $receiver) {
        return StandardClassIdsKt.enumsId($receiver);
    }

    public static final /* synthetic */ ClassId access$atomicsId(String $receiver) {
        return StandardClassIdsKt.atomicsId($receiver);
    }
}

