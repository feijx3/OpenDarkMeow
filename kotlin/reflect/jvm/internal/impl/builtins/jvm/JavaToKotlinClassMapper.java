/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nJavaToKotlinClassMapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaToKotlinClassMapper.kt\norg/jetbrains/kotlin/builtins/jvm/JavaToKotlinClassMapper\n*L\n1#1,80:1\n75#1,3:81\n75#1,3:84\n*S KotlinDebug\n*F\n+ 1 JavaToKotlinClassMapper.kt\norg/jetbrains/kotlin/builtins/jvm/JavaToKotlinClassMapper\n*L\n59#1:81,3\n65#1:84,3\n*E\n"})
public final class JavaToKotlinClassMapper {
    @NotNull
    public static final JavaToKotlinClassMapper INSTANCE = new JavaToKotlinClassMapper();

    private JavaToKotlinClassMapper() {
    }

    @NotNull
    public final Collection<ClassDescriptor> mapPlatformClass(@NotNull FqName fqName, @NotNull KotlinBuiltIns builtIns) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        ClassDescriptor classDescriptor = JavaToKotlinClassMapper.mapJavaToKotlin$default(this, fqName, builtIns, null, 4, null);
        if (classDescriptor == null) {
            return SetsKt.emptySet();
        }
        ClassDescriptor kotlinAnalog = classDescriptor;
        FqName fqName2 = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(DescriptorUtilsKt.getFqNameUnsafe(kotlinAnalog));
        if (fqName2 == null) {
            return SetsKt.setOf(kotlinAnalog);
        }
        FqName kotlinMutableAnalogFqName = fqName2;
        ClassDescriptor[] classDescriptorArray = new ClassDescriptor[]{kotlinAnalog, builtIns.getBuiltInClassByFqName(kotlinMutableAnalogFqName)};
        return CollectionsKt.listOf(classDescriptorArray);
    }

    @Nullable
    public final ClassDescriptor mapJavaToKotlin(@NotNull FqName fqName, @NotNull KotlinBuiltIns builtIns, @Nullable Integer functionTypeArity) {
        ClassId kotlinClassId;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        ClassId classId = kotlinClassId = functionTypeArity != null && Intrinsics.areEqual(fqName, JavaToKotlinClassMap.INSTANCE.getFUNCTION_N_FQ_NAME()) ? StandardNames.getFunctionClassId(functionTypeArity) : JavaToKotlinClassMap.INSTANCE.mapJavaToKotlin(fqName);
        return classId != null ? builtIns.getBuiltInClassByFqName(classId.asSingleFqName()) : null;
    }

    public static /* synthetic */ ClassDescriptor mapJavaToKotlin$default(JavaToKotlinClassMapper javaToKotlinClassMapper, FqName fqName, KotlinBuiltIns kotlinBuiltIns, Integer n2, int n3, Object object) {
        if ((n3 & 4) != 0) {
            n2 = null;
        }
        return javaToKotlinClassMapper.mapJavaToKotlin(fqName, kotlinBuiltIns, n2);
    }

    public final boolean isMutable(@NotNull ClassDescriptor mutable) {
        Intrinsics.checkNotNullParameter(mutable, "mutable");
        return JavaToKotlinClassMap.INSTANCE.isMutable(DescriptorUtils.getFqName(mutable));
    }

    public final boolean isReadOnly(@NotNull ClassDescriptor readOnly) {
        Intrinsics.checkNotNullParameter(readOnly, "readOnly");
        return JavaToKotlinClassMap.INSTANCE.isReadOnly(DescriptorUtils.getFqName(readOnly));
    }

    @NotNull
    public final ClassDescriptor convertMutableToReadOnly(@NotNull ClassDescriptor mutable) {
        Intrinsics.checkNotNullParameter(mutable, "mutable");
        JavaToKotlinClassMapper javaToKotlinClassMapper = this;
        String mutabilityKindName$iv = "mutable";
        boolean $i$f$convertToOppositeMutability = false;
        FqNameUnsafe it = DescriptorUtils.getFqName(mutable);
        boolean bl2 = false;
        FqName fqName = JavaToKotlinClassMap.INSTANCE.mutableToReadOnly(it);
        if (fqName == null) {
            throw new IllegalArgumentException("Given class " + mutable + " is not a " + mutabilityKindName$iv + " collection");
        }
        FqName oppositeClassFqName$iv = fqName;
        ClassDescriptor classDescriptor = DescriptorUtilsKt.getBuiltIns(mutable).getBuiltInClassByFqName(oppositeClassFqName$iv);
        Intrinsics.checkNotNullExpressionValue(classDescriptor, "getBuiltInClassByFqName(...)");
        return classDescriptor;
    }

    @NotNull
    public final ClassDescriptor convertReadOnlyToMutable(@NotNull ClassDescriptor readOnly) {
        Intrinsics.checkNotNullParameter(readOnly, "readOnly");
        JavaToKotlinClassMapper javaToKotlinClassMapper = this;
        String mutabilityKindName$iv = "read-only";
        boolean $i$f$convertToOppositeMutability = false;
        FqNameUnsafe it = DescriptorUtils.getFqName(readOnly);
        boolean bl2 = false;
        FqName fqName = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(it);
        if (fqName == null) {
            throw new IllegalArgumentException("Given class " + readOnly + " is not a " + mutabilityKindName$iv + " collection");
        }
        FqName oppositeClassFqName$iv = fqName;
        ClassDescriptor classDescriptor = DescriptorUtilsKt.getBuiltIns(readOnly).getBuiltInClassByFqName(oppositeClassFqName$iv);
        Intrinsics.checkNotNullExpressionValue(classDescriptor, "getBuiltInClassByFqName(...)");
        return classDescriptor;
    }
}

