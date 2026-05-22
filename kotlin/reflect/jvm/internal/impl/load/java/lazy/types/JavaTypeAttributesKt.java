/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nJavaTypeAttributes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaTypeAttributes.kt\norg/jetbrains/kotlin/load/java/lazy/types/JavaTypeAttributesKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,57:1\n1#2:58\n*E\n"})
public final class JavaTypeAttributesKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final JavaTypeAttributes toAttributes(@NotNull TypeUsage $this$toAttributes, boolean isForAnnotationParameter, boolean isRaw, @Nullable TypeParameterDescriptor upperBoundForTypeParameter) {
        Set<void> set;
        Intrinsics.checkNotNullParameter((Object)$this$toAttributes, "<this>");
        TypeUsage typeUsage = $this$toAttributes;
        JavaTypeFlexibility javaTypeFlexibility = null;
        boolean bl2 = isRaw;
        boolean bl3 = isForAnnotationParameter;
        TypeParameterDescriptor typeParameterDescriptor = upperBoundForTypeParameter;
        if (typeParameterDescriptor != null) {
            void p0;
            TypeParameterDescriptor typeParameterDescriptor2 = typeParameterDescriptor;
            boolean bl4 = bl3;
            boolean bl5 = bl2;
            JavaTypeFlexibility javaTypeFlexibility2 = javaTypeFlexibility;
            TypeUsage typeUsage2 = typeUsage;
            boolean bl6 = false;
            Set<void> set2 = SetsKt.setOf(p0);
            typeUsage = typeUsage2;
            javaTypeFlexibility = javaTypeFlexibility2;
            bl2 = bl5;
            bl3 = bl4;
            set = set2;
        } else {
            set = null;
        }
        DefaultConstructorMarker defaultConstructorMarker = null;
        int n2 = 34;
        SimpleType simpleType = null;
        Set<void> set3 = set;
        boolean bl7 = bl3;
        boolean bl8 = bl2;
        JavaTypeFlexibility javaTypeFlexibility3 = javaTypeFlexibility;
        TypeUsage typeUsage3 = typeUsage;
        return new JavaTypeAttributes(typeUsage3, javaTypeFlexibility3, bl8, bl7, set3, simpleType, n2, defaultConstructorMarker);
    }

    public static /* synthetic */ JavaTypeAttributes toAttributes$default(TypeUsage typeUsage, boolean bl2, boolean bl3, TypeParameterDescriptor typeParameterDescriptor, int n2, Object object) {
        if ((n2 & 1) != 0) {
            bl2 = false;
        }
        if ((n2 & 2) != 0) {
            bl3 = false;
        }
        if ((n2 & 4) != 0) {
            typeParameterDescriptor = null;
        }
        return JavaTypeAttributesKt.toAttributes(typeUsage, bl2, bl3, typeParameterDescriptor);
    }
}

