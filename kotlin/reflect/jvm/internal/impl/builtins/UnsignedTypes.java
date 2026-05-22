/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedArrayType;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedType;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nUnsignedType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UnsignedType.kt\norg/jetbrains/kotlin/builtins/UnsignedTypes\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,122:1\n11228#2:123\n11563#2,3:124\n11228#2:127\n11563#2,3:128\n11563#2,3:131\n*S KotlinDebug\n*F\n+ 1 UnsignedType.kt\norg/jetbrains/kotlin/builtins/UnsignedTypes\n*L\n36#1:123\n36#1:124,3\n37#1:127\n37#1:128,3\n47#1:131,3\n*E\n"})
public final class UnsignedTypes {
    @NotNull
    public static final UnsignedTypes INSTANCE;
    @NotNull
    private static final Set<Name> unsignedTypeNames;
    @NotNull
    private static final Set<Name> unsignedArrayTypeNames;
    @NotNull
    private static final HashMap<ClassId, ClassId> arrayClassIdToUnsignedClassId;
    @NotNull
    private static final HashMap<ClassId, ClassId> unsignedClassIdToArrayClassId;
    @NotNull
    private static final HashMap<UnsignedArrayType, Name> unsignedArrayTypeToArrayCall;
    @NotNull
    private static final Set<Name> arrayClassesShortNames;

    private UnsignedTypes() {
    }

    public final boolean isShortNameOfUnsignedArray(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return arrayClassesShortNames.contains(name);
    }

    @Nullable
    public final ClassId getUnsignedClassIdByArrayClassId(@NotNull ClassId arrayClassId) {
        Intrinsics.checkNotNullParameter(arrayClassId, "arrayClassId");
        return arrayClassIdToUnsignedClassId.get(arrayClassId);
    }

    @JvmStatic
    public static final boolean isUnsignedType(@NotNull KotlinType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (TypeUtils.noExpectedType(type)) {
            return false;
        }
        ClassifierDescriptor classifierDescriptor = type.getConstructor().getDeclarationDescriptor();
        if (classifierDescriptor == null) {
            return false;
        }
        ClassifierDescriptor descriptor2 = classifierDescriptor;
        return INSTANCE.isUnsignedClass(descriptor2);
    }

    public final boolean isUnsignedClass(@NotNull DeclarationDescriptor descriptor2) {
        Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
        DeclarationDescriptor container = descriptor2.getContainingDeclaration();
        return container instanceof PackageFragmentDescriptor && Intrinsics.areEqual(((PackageFragmentDescriptor)container).getFqName(), StandardNames.BUILT_INS_PACKAGE_FQ_NAME) && unsignedTypeNames.contains(descriptor2.getName());
    }

    /*
     * WARNING - void declaration
     */
    static {
        void var1_2;
        void $this$mapTo$iv;
        Enum it;
        Collection collection;
        Enum[] $this$mapTo$iv$iv;
        INSTANCE = new UnsignedTypes();
        Object[] $this$map$iv = UnsignedType.values();
        boolean $i$f$map = false;
        UnsignedType[] unsignedTypeArray = $this$map$iv;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length);
        boolean $i$f$mapTo = false;
        for (Enum item$iv$iv : $this$mapTo$iv$iv) {
            void var8_16 = item$iv$iv;
            collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(((UnsignedType)it).getTypeName());
        }
        unsignedTypeNames = CollectionsKt.toSet((List)destination$iv$iv);
        $this$map$iv = UnsignedArrayType.values();
        $i$f$map = false;
        $this$mapTo$iv$iv = $this$map$iv;
        destination$iv$iv = new ArrayList($this$map$iv.length);
        $i$f$mapTo = false;
        int n2 = $this$mapTo$iv$iv.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            Enum item$iv$iv;
            it = item$iv$iv = $this$mapTo$iv$iv[i2];
            collection = destination$iv$iv;
            boolean bl3 = false;
            collection.add(((UnsignedArrayType)it).getTypeName());
        }
        unsignedArrayTypeNames = CollectionsKt.toSet((List)destination$iv$iv);
        arrayClassIdToUnsignedClassId = new HashMap();
        unsignedClassIdToArrayClassId = new HashMap();
        $this$map$iv = new Pair[]{TuplesKt.to(UnsignedArrayType.UBYTEARRAY, Name.identifier("ubyteArrayOf")), TuplesKt.to(UnsignedArrayType.USHORTARRAY, Name.identifier("ushortArrayOf")), TuplesKt.to(UnsignedArrayType.UINTARRAY, Name.identifier("uintArrayOf")), TuplesKt.to(UnsignedArrayType.ULONGARRAY, Name.identifier("ulongArrayOf"))};
        unsignedArrayTypeToArrayCall = MapsKt.hashMapOf($this$map$iv);
        $this$map$iv = UnsignedType.values();
        Collection destination$iv = new LinkedHashSet();
        boolean $i$f$mapTo2 = false;
        int n3 = ((void)$this$mapTo$iv).length;
        for (int destination$iv$iv2 = 0; destination$iv$iv2 < n3; ++destination$iv$iv2) {
            void it2;
            void item$iv;
            void var6_13 = item$iv = $this$mapTo$iv[destination$iv$iv2];
            collection = destination$iv;
            boolean bl4 = false;
            collection.add(it2.getArrayClassId().getShortClassName());
        }
        arrayClassesShortNames = (Set)var1_2;
        for (UnsignedType unsignedType : UnsignedType.values()) {
            ((Map)arrayClassIdToUnsignedClassId).put(unsignedType.getArrayClassId(), unsignedType.getClassId());
            ((Map)unsignedClassIdToArrayClassId).put(unsignedType.getClassId(), unsignedType.getArrayClassId());
        }
    }
}

