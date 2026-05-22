/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementUtilsKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory;
import kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\ntypeSignatureMapping.kt\nKotlin\n*S Kotlin\n*F\n+ 1 typeSignatureMapping.kt\norg/jetbrains/kotlin/load/kotlin/TypeSignatureMappingKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,103:1\n1#2:104\n1761#3,3:105\n*S KotlinDebug\n*F\n+ 1 typeSignatureMapping.kt\norg/jetbrains/kotlin/load/kotlin/TypeSignatureMappingKt\n*L\n55#1:105,3\n*E\n"})
public final class TypeSignatureMappingKt {
    @NotNull
    public static final <T> T boxTypeIfNeeded(@NotNull JvmTypeFactory<T> $this$boxTypeIfNeeded, @NotNull T possiblyPrimitiveType, boolean needBoxedType) {
        Intrinsics.checkNotNullParameter($this$boxTypeIfNeeded, "<this>");
        Intrinsics.checkNotNullParameter(possiblyPrimitiveType, "possiblyPrimitiveType");
        return needBoxedType ? $this$boxTypeIfNeeded.boxType(possiblyPrimitiveType) : possiblyPrimitiveType;
    }

    @Nullable
    public static final <T> T mapBuiltInType(@NotNull TypeSystemCommonBackendContext $this$mapBuiltInType, @NotNull KotlinTypeMarker type, @NotNull JvmTypeFactory<T> typeFactory, @NotNull TypeMappingMode mode) {
        Intrinsics.checkNotNullParameter($this$mapBuiltInType, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(typeFactory, "typeFactory");
        Intrinsics.checkNotNullParameter(mode, "mode");
        TypeConstructorMarker constructor = $this$mapBuiltInType.typeConstructor(type);
        if (!$this$mapBuiltInType.isClassTypeConstructor(constructor)) {
            return null;
        }
        PrimitiveType primitiveType = $this$mapBuiltInType.getPrimitiveType(constructor);
        if (primitiveType != null) {
            T jvmType = typeFactory.createPrimitiveType(primitiveType);
            boolean isNullableInJava = $this$mapBuiltInType.isNullableType(type) || TypeEnhancementUtilsKt.hasEnhancedNullability($this$mapBuiltInType, type);
            return TypeSignatureMappingKt.boxTypeIfNeeded(typeFactory, jvmType, isNullableInJava);
        }
        PrimitiveType arrayElementType = $this$mapBuiltInType.getPrimitiveArrayType(constructor);
        if (arrayElementType != null) {
            return typeFactory.createFromString('[' + JvmPrimitiveType.get(arrayElementType).getDesc());
        }
        if ($this$mapBuiltInType.isUnderKotlinPackage(constructor)) {
            ClassId classId;
            ClassId classId2;
            FqNameUnsafe fqNameUnsafe = $this$mapBuiltInType.getClassFqNameUnsafe(constructor);
            if (fqNameUnsafe != null) {
                FqNameUnsafe fqNameUnsafe2 = fqNameUnsafe;
                JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
                FqNameUnsafe p0 = fqNameUnsafe2;
                boolean bl2 = false;
                classId2 = javaToKotlinClassMap.mapKotlinToJava(p0);
            } else {
                classId2 = classId = null;
            }
            if (classId != null) {
                if (!mode.getKotlinCollectionsToJavaCollections()) {
                    boolean bl3;
                    block12: {
                        Iterable $this$any$iv = JavaToKotlinClassMap.INSTANCE.getMutabilityMappings();
                        boolean $i$f$any = false;
                        if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                            bl3 = false;
                        } else {
                            for (Object element$iv : $this$any$iv) {
                                JavaToKotlinClassMap.PlatformMutabilityMapping it = (JavaToKotlinClassMap.PlatformMutabilityMapping)element$iv;
                                boolean bl4 = false;
                                if (!Intrinsics.areEqual(it.getJavaClass(), classId)) continue;
                                bl3 = true;
                                break block12;
                            }
                            bl3 = false;
                        }
                    }
                    if (bl3) {
                        return null;
                    }
                }
                String string = JvmClassName.internalNameByClassId(classId);
                Intrinsics.checkNotNullExpressionValue(string, "internalNameByClassId(...)");
                return typeFactory.createObjectType(string);
            }
        }
        return null;
    }
}

