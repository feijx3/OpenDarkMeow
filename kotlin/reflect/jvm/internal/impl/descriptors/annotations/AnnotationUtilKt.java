/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

public final class AnnotationUtilKt {
    @NotNull
    private static final Name DEPRECATED_MESSAGE_NAME;
    @NotNull
    private static final Name DEPRECATED_REPLACE_WITH_NAME;
    @NotNull
    private static final Name DEPRECATED_LEVEL_NAME;
    @NotNull
    private static final Name REPLACE_WITH_EXPRESSION_NAME;
    @NotNull
    private static final Name REPLACE_WITH_IMPORTS_NAME;

    @NotNull
    public static final AnnotationDescriptor createDeprecatedAnnotation(@NotNull KotlinBuiltIns $this$createDeprecatedAnnotation, @NotNull String message, @NotNull String replaceWith, @NotNull String level, boolean forcePropagationDeprecationToOverrides) {
        Intrinsics.checkNotNullParameter($this$createDeprecatedAnnotation, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(replaceWith, "replaceWith");
        Intrinsics.checkNotNullParameter(level, "level");
        Pair[] pairArray = new Pair[2];
        pairArray[0] = TuplesKt.to(REPLACE_WITH_EXPRESSION_NAME, new StringValue(replaceWith));
        KotlinBuiltIns kotlinBuiltIns = $this$createDeprecatedAnnotation;
        pairArray[1] = TuplesKt.to(REPLACE_WITH_IMPORTS_NAME, new ArrayValue(CollectionsKt.emptyList(), new AnnotationUtilKt$$Lambda$0(kotlinBuiltIns)));
        BuiltInAnnotationDescriptor replaceWithAnnotation = new BuiltInAnnotationDescriptor($this$createDeprecatedAnnotation, StandardNames.FqNames.replaceWith, MapsKt.mapOf(pairArray), false, 8, null);
        pairArray = new Pair[3];
        pairArray[0] = TuplesKt.to(DEPRECATED_MESSAGE_NAME, new StringValue(message));
        pairArray[1] = TuplesKt.to(DEPRECATED_REPLACE_WITH_NAME, new AnnotationValue(replaceWithAnnotation));
        ClassId classId = ClassId.Companion.topLevel(StandardNames.FqNames.deprecationLevel);
        Name name = Name.identifier(level);
        Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
        pairArray[2] = TuplesKt.to(DEPRECATED_LEVEL_NAME, new EnumValue(classId, name));
        return new BuiltInAnnotationDescriptor($this$createDeprecatedAnnotation, StandardNames.FqNames.deprecated, MapsKt.mapOf(pairArray), forcePropagationDeprecationToOverrides);
    }

    public static /* synthetic */ AnnotationDescriptor createDeprecatedAnnotation$default(KotlinBuiltIns kotlinBuiltIns, String string, String string2, String string3, boolean bl2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            string2 = "";
        }
        if ((n2 & 4) != 0) {
            string3 = "WARNING";
        }
        if ((n2 & 8) != 0) {
            bl2 = false;
        }
        return AnnotationUtilKt.createDeprecatedAnnotation(kotlinBuiltIns, string, string2, string3, bl2);
    }

    private static final KotlinType createDeprecatedAnnotation$lambda$0(KotlinBuiltIns $this_createDeprecatedAnnotation, ModuleDescriptor module) {
        Intrinsics.checkNotNullParameter(module, "module");
        SimpleType simpleType = module.getBuiltIns().getArrayType(Variance.INVARIANT, $this_createDeprecatedAnnotation.getStringType());
        Intrinsics.checkNotNullExpressionValue(simpleType, "getArrayType(...)");
        return simpleType;
    }

    static {
        Name name = Name.identifier("message");
        Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
        DEPRECATED_MESSAGE_NAME = name;
        Name name2 = Name.identifier("replaceWith");
        Intrinsics.checkNotNullExpressionValue(name2, "identifier(...)");
        DEPRECATED_REPLACE_WITH_NAME = name2;
        Name name3 = Name.identifier("level");
        Intrinsics.checkNotNullExpressionValue(name3, "identifier(...)");
        DEPRECATED_LEVEL_NAME = name3;
        Name name4 = Name.identifier("expression");
        Intrinsics.checkNotNullExpressionValue(name4, "identifier(...)");
        REPLACE_WITH_EXPRESSION_NAME = name4;
        Name name5 = Name.identifier("imports");
        Intrinsics.checkNotNullExpressionValue(name5, "identifier(...)");
        REPLACE_WITH_IMPORTS_NAME = name5;
    }

    static /* synthetic */ KotlinType accessor$AnnotationUtilKt$lambda0(KotlinBuiltIns kotlinBuiltIns, ModuleDescriptor moduleDescriptor) {
        return AnnotationUtilKt.createDeprecatedAnnotation$lambda$0(kotlinBuiltIns, moduleDescriptor);
    }
}

