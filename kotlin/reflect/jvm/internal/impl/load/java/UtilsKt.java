/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationSettingsKt;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.load.java.ReportLevel;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nutils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 utils.kt\norg/jetbrains/kotlin/load/java/UtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,49:1\n1#2:50\n12637#3,2:51\n*S KotlinDebug\n*F\n+ 1 utils.kt\norg/jetbrains/kotlin/load/java/UtilsKt\n*L\n47#1:51,2\n*E\n"})
public final class UtilsKt {
    @NotNull
    public static final DescriptorVisibility toDescriptorVisibility(@NotNull Visibility $this$toDescriptorVisibility) {
        Intrinsics.checkNotNullParameter($this$toDescriptorVisibility, "<this>");
        DescriptorVisibility descriptorVisibility = JavaDescriptorVisibilities.toDescriptorVisibility($this$toDescriptorVisibility);
        Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "toDescriptorVisibility(...)");
        return descriptorVisibility;
    }

    public static final boolean isJspecifyEnabledInStrictMode(@NotNull JavaTypeEnhancementState javaTypeEnhancementState) {
        Intrinsics.checkNotNullParameter(javaTypeEnhancementState, "javaTypeEnhancementState");
        return javaTypeEnhancementState.getGetReportLevelForAnnotation().invoke(JavaNullabilityAnnotationSettingsKt.getJSPECIFY_ANNOTATIONS_PACKAGE()) == ReportLevel.STRICT;
    }

    public static final boolean hasErasedValueParameters(@NotNull CallableMemberDescriptor memberDescriptor) {
        Intrinsics.checkNotNullParameter(memberDescriptor, "memberDescriptor");
        return memberDescriptor instanceof FunctionDescriptor && Intrinsics.areEqual(memberDescriptor.getUserData(JavaMethodDescriptor.HAS_ERASED_VALUE_PARAMETERS), true);
    }

    @Nullable
    public static final AnnotationDescriptor extractNullabilityAnnotationOnBoundedWildcard(@NotNull LazyJavaResolverContext c2, @NotNull JavaWildcardType wildcardType) {
        Object v1;
        block4: {
            Intrinsics.checkNotNullParameter(c2, "c");
            Intrinsics.checkNotNullParameter(wildcardType, "wildcardType");
            if (!(wildcardType.getBound() != null)) {
                boolean bl2 = false;
                String string = "Nullability annotations on unbounded wildcards aren't supported";
                throw new IllegalArgumentException(string.toString());
            }
            Iterable iterable = new LazyJavaAnnotations(c2, wildcardType, false, 4, null);
            for (Object t2 : iterable) {
                boolean bl3;
                block3: {
                    AnnotationDescriptor annotation = (AnnotationDescriptor)t2;
                    boolean bl4 = false;
                    FqName[] $this$any$iv = JavaNullabilityAnnotationSettingsKt.getRXJAVA3_ANNOTATIONS();
                    boolean $i$f$any = false;
                    int n2 = $this$any$iv.length;
                    for (int i2 = 0; i2 < n2; ++i2) {
                        FqName element$iv;
                        FqName it = element$iv = $this$any$iv[i2];
                        boolean bl5 = false;
                        if (!Intrinsics.areEqual(annotation.getFqName(), it)) continue;
                        bl3 = true;
                        break block3;
                    }
                    bl3 = false;
                }
                if (!bl3) continue;
                v1 = t2;
                break block4;
            }
            v1 = null;
        }
        return v1;
    }
}

