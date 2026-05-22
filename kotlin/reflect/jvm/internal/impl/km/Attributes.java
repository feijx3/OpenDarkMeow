/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.km.Attributes;
import kotlin.reflect.jvm.internal.impl.km.ClassKind;
import kotlin.reflect.jvm.internal.impl.km.KmClass;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmTypeParameter;
import kotlin.reflect.jvm.internal.impl.km.Modality;
import kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate;
import kotlin.reflect.jvm.internal.impl.km.internal.EnumFlagDelegate;
import kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt;
import kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import org.jetbrains.annotations.NotNull;

@JvmName(name="Attributes")
@SourceDebugExtension(value={"SMAP\nAttributes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Attributes.kt\nkotlin/metadata/Attributes\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,475:1\n1563#2:476\n1634#2,3:477\n*S KotlinDebug\n*F\n+ 1 Attributes.kt\nkotlin/metadata/Attributes\n*L\n-1#1:476\n-1#1:477,3\n*E\n"})
public final class Attributes {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private static final BooleanFlagDelegate hasAnnotations$delegate;
    @NotNull
    private static final BooleanFlagDelegate hasAnnotations$delegate$1;
    @NotNull
    private static final BooleanFlagDelegate hasAnnotations$delegate$2;
    @NotNull
    private static final BooleanFlagDelegate hasAnnotations$delegate$3;
    @NotNull
    private static final BooleanFlagDelegate hasAnnotations$delegate$4;
    @NotNull
    private static final BooleanFlagDelegate hasAnnotations$delegate$5;
    @NotNull
    private static final BooleanFlagDelegate hasAnnotations$delegate$6;
    @NotNull
    private static final EnumFlagDelegate modality$delegate;
    @NotNull
    private static final EnumFlagDelegate visibility$delegate;
    @NotNull
    private static final EnumFlagDelegate kind$delegate;
    @NotNull
    private static final BooleanFlagDelegate isInner$delegate;
    @NotNull
    private static final BooleanFlagDelegate isData$delegate;
    @NotNull
    private static final BooleanFlagDelegate isExternal$delegate;
    @NotNull
    private static final BooleanFlagDelegate isExpect$delegate;
    @NotNull
    private static final BooleanFlagDelegate isValue$delegate;
    @NotNull
    private static final BooleanFlagDelegate isFunInterface$delegate;
    @NotNull
    private static final BooleanFlagDelegate hasEnumEntries$delegate;
    @NotNull
    private static final EnumFlagDelegate visibility$delegate$1;
    @NotNull
    private static final BooleanFlagDelegate isSecondary$delegate;
    @NotNull
    private static final BooleanFlagDelegate hasNonStableParameterNames$delegate;
    @NotNull
    private static final EnumFlagDelegate kind$delegate$1;
    @NotNull
    private static final EnumFlagDelegate visibility$delegate$2;
    @NotNull
    private static final EnumFlagDelegate modality$delegate$1;
    @NotNull
    private static final BooleanFlagDelegate isOperator$delegate;
    @NotNull
    private static final BooleanFlagDelegate isInfix$delegate;
    @NotNull
    private static final BooleanFlagDelegate isInline$delegate;
    @NotNull
    private static final BooleanFlagDelegate isTailrec$delegate;
    @NotNull
    private static final BooleanFlagDelegate isExternal$delegate$1;
    @NotNull
    private static final BooleanFlagDelegate isSuspend$delegate;
    @NotNull
    private static final BooleanFlagDelegate isExpect$delegate$1;
    @NotNull
    private static final BooleanFlagDelegate hasNonStableParameterNames$delegate$1;
    @NotNull
    private static final EnumFlagDelegate visibility$delegate$3;
    @NotNull
    private static final EnumFlagDelegate modality$delegate$2;
    @NotNull
    private static final EnumFlagDelegate kind$delegate$2;
    @NotNull
    private static final BooleanFlagDelegate isVar$delegate;
    @NotNull
    private static final BooleanFlagDelegate isConst$delegate;
    @NotNull
    private static final BooleanFlagDelegate isLateinit$delegate;
    @NotNull
    private static final BooleanFlagDelegate hasConstant$delegate;
    @NotNull
    private static final BooleanFlagDelegate isExternal$delegate$2;
    @NotNull
    private static final BooleanFlagDelegate isDelegated$delegate;
    @NotNull
    private static final BooleanFlagDelegate isExpect$delegate$2;
    @NotNull
    private static final EnumFlagDelegate visibility$delegate$4;
    @NotNull
    private static final EnumFlagDelegate modality$delegate$3;
    @NotNull
    private static final BooleanFlagDelegate isNotDefault$delegate;
    @NotNull
    private static final BooleanFlagDelegate isExternal$delegate$3;
    @NotNull
    private static final BooleanFlagDelegate isInline$delegate$1;
    @NotNull
    private static final BooleanFlagDelegate isNullable$delegate;
    @NotNull
    private static final BooleanFlagDelegate isSuspend$delegate$1;
    @NotNull
    private static final BooleanFlagDelegate isDefinitelyNonNull$delegate;
    @NotNull
    private static final BooleanFlagDelegate isReified$delegate;
    @NotNull
    private static final EnumFlagDelegate visibility$delegate$5;
    @NotNull
    private static final BooleanFlagDelegate declaresDefaultValue$delegate;
    @NotNull
    private static final BooleanFlagDelegate isCrossinline$delegate;
    @NotNull
    private static final BooleanFlagDelegate isNoinline$delegate;
    @NotNull
    private static final BooleanFlagDelegate isNegated$delegate;
    @NotNull
    private static final BooleanFlagDelegate isNullCheckPredicate$delegate;

    @NotNull
    public static final Modality getModality(@NotNull KmClass $this$modality) {
        Intrinsics.checkNotNullParameter($this$modality, "<this>");
        return (Modality)((Object)modality$delegate.getValue($this$modality, $$delegatedProperties[7]));
    }

    @NotNull
    public static final ClassKind getKind(@NotNull KmClass $this$kind) {
        Intrinsics.checkNotNullParameter($this$kind, "<this>");
        return (ClassKind)((Object)kind$delegate.getValue($this$kind, $$delegatedProperties[9]));
    }

    public static final boolean isInner(@NotNull KmClass $this$isInner) {
        Intrinsics.checkNotNullParameter($this$isInner, "<this>");
        return isInner$delegate.getValue($this$isInner, $$delegatedProperties[10]);
    }

    public static final boolean isData(@NotNull KmClass $this$isData) {
        Intrinsics.checkNotNullParameter($this$isData, "<this>");
        return isData$delegate.getValue($this$isData, $$delegatedProperties[11]);
    }

    public static final boolean isValue(@NotNull KmClass $this$isValue) {
        Intrinsics.checkNotNullParameter($this$isValue, "<this>");
        return isValue$delegate.getValue($this$isValue, $$delegatedProperties[14]);
    }

    public static final boolean isFunInterface(@NotNull KmClass $this$isFunInterface) {
        Intrinsics.checkNotNullParameter($this$isFunInterface, "<this>");
        return isFunInterface$delegate.getValue($this$isFunInterface, $$delegatedProperties[15]);
    }

    public static final boolean isNullable(@NotNull KmType $this$isNullable) {
        Intrinsics.checkNotNullParameter($this$isNullable, "<this>");
        return isNullable$delegate.getValue($this$isNullable, $$delegatedProperties[46]);
    }

    public static final boolean isReified(@NotNull KmTypeParameter $this$isReified) {
        Intrinsics.checkNotNullParameter($this$isReified, "<this>");
        return isReified$delegate.getValue($this$isReified, $$delegatedProperties[49]);
    }

    /*
     * WARNING - void declaration
     */
    static {
        void var3_6;
        Collection<FlagImpl> collection;
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Object object = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmClass;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmConstructor;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmFunction;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmProperty;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmPropertyAccessorAttributes;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmValueParameter;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmTypeAlias;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "modality", "getModality(Lkotlin/metadata/KmClass;)Lkotlin/metadata/Modality;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "visibility", "getVisibility(Lkotlin/metadata/KmClass;)Lkotlin/metadata/Visibility;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "kind", "getKind(Lkotlin/metadata/KmClass;)Lkotlin/metadata/ClassKind;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isInner", "isInner(Lkotlin/metadata/KmClass;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isData", "isData(Lkotlin/metadata/KmClass;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isExternal", "isExternal(Lkotlin/metadata/KmClass;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isExpect", "isExpect(Lkotlin/metadata/KmClass;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isValue", "isValue(Lkotlin/metadata/KmClass;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isFunInterface", "isFunInterface(Lkotlin/metadata/KmClass;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "hasEnumEntries", "getHasEnumEntries(Lkotlin/metadata/KmClass;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "visibility", "getVisibility(Lkotlin/metadata/KmConstructor;)Lkotlin/metadata/Visibility;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isSecondary", "isSecondary(Lkotlin/metadata/KmConstructor;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "hasNonStableParameterNames", "getHasNonStableParameterNames(Lkotlin/metadata/KmConstructor;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "kind", "getKind(Lkotlin/metadata/KmFunction;)Lkotlin/metadata/MemberKind;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "visibility", "getVisibility(Lkotlin/metadata/KmFunction;)Lkotlin/metadata/Visibility;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "modality", "getModality(Lkotlin/metadata/KmFunction;)Lkotlin/metadata/Modality;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isOperator", "isOperator(Lkotlin/metadata/KmFunction;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isInfix", "isInfix(Lkotlin/metadata/KmFunction;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isInline", "isInline(Lkotlin/metadata/KmFunction;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isTailrec", "isTailrec(Lkotlin/metadata/KmFunction;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isExternal", "isExternal(Lkotlin/metadata/KmFunction;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isSuspend", "isSuspend(Lkotlin/metadata/KmFunction;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isExpect", "isExpect(Lkotlin/metadata/KmFunction;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "hasNonStableParameterNames", "getHasNonStableParameterNames(Lkotlin/metadata/KmFunction;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "visibility", "getVisibility(Lkotlin/metadata/KmProperty;)Lkotlin/metadata/Visibility;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "modality", "getModality(Lkotlin/metadata/KmProperty;)Lkotlin/metadata/Modality;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "kind", "getKind(Lkotlin/metadata/KmProperty;)Lkotlin/metadata/MemberKind;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isVar", "isVar(Lkotlin/metadata/KmProperty;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isConst", "isConst(Lkotlin/metadata/KmProperty;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isLateinit", "isLateinit(Lkotlin/metadata/KmProperty;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "hasConstant", "getHasConstant(Lkotlin/metadata/KmProperty;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isExternal", "isExternal(Lkotlin/metadata/KmProperty;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isDelegated", "isDelegated(Lkotlin/metadata/KmProperty;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isExpect", "isExpect(Lkotlin/metadata/KmProperty;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "visibility", "getVisibility(Lkotlin/metadata/KmPropertyAccessorAttributes;)Lkotlin/metadata/Visibility;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "modality", "getModality(Lkotlin/metadata/KmPropertyAccessorAttributes;)Lkotlin/metadata/Modality;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isNotDefault", "isNotDefault(Lkotlin/metadata/KmPropertyAccessorAttributes;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isExternal", "isExternal(Lkotlin/metadata/KmPropertyAccessorAttributes;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isInline", "isInline(Lkotlin/metadata/KmPropertyAccessorAttributes;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isNullable", "isNullable(Lkotlin/metadata/KmType;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isSuspend", "isSuspend(Lkotlin/metadata/KmType;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isDefinitelyNonNull", "isDefinitelyNonNull(Lkotlin/metadata/KmType;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isReified", "isReified(Lkotlin/metadata/KmTypeParameter;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "visibility", "getVisibility(Lkotlin/metadata/KmTypeAlias;)Lkotlin/metadata/Visibility;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "declaresDefaultValue", "getDeclaresDefaultValue(Lkotlin/metadata/KmValueParameter;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isCrossinline", "isCrossinline(Lkotlin/metadata/KmValueParameter;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isNoinline", "isNoinline(Lkotlin/metadata/KmValueParameter;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isNegated", "isNegated(Lkotlin/metadata/KmEffectExpression;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isNullCheckPredicate", "isNullCheckPredicate(Lkotlin/metadata/KmEffectExpression;)Z", 1))};
        $$delegatedProperties = object;
        Flags.BooleanFlagField booleanFlagField = Flags.HAS_ANNOTATIONS;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField, "HAS_ANNOTATIONS");
        hasAnnotations$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(booleanFlagField));
        Flags.BooleanFlagField booleanFlagField2 = Flags.HAS_ANNOTATIONS;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField2, "HAS_ANNOTATIONS");
        hasAnnotations$delegate$1 = FlagDelegatesImplKt.constructorBooleanFlag(new FlagImpl(booleanFlagField2));
        Flags.BooleanFlagField booleanFlagField3 = Flags.HAS_ANNOTATIONS;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField3, "HAS_ANNOTATIONS");
        hasAnnotations$delegate$2 = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(booleanFlagField3));
        Flags.BooleanFlagField booleanFlagField4 = Flags.HAS_ANNOTATIONS;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField4, "HAS_ANNOTATIONS");
        hasAnnotations$delegate$3 = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(booleanFlagField4));
        Flags.BooleanFlagField booleanFlagField5 = Flags.HAS_ANNOTATIONS;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField5, "HAS_ANNOTATIONS");
        hasAnnotations$delegate$4 = FlagDelegatesImplKt.propertyAccessorBooleanFlag(new FlagImpl(booleanFlagField5));
        Flags.BooleanFlagField booleanFlagField6 = Flags.HAS_ANNOTATIONS;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField6, "HAS_ANNOTATIONS");
        hasAnnotations$delegate$5 = FlagDelegatesImplKt.valueParameterBooleanFlag(new FlagImpl(booleanFlagField6));
        Flags.BooleanFlagField booleanFlagField7 = Flags.HAS_ANNOTATIONS;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField7, "HAS_ANNOTATIONS");
        hasAnnotations$delegate$6 = FlagDelegatesImplKt.typeAliasBooleanFlag(new FlagImpl(booleanFlagField7));
        modality$delegate = FlagDelegatesImplKt.modalityDelegate(modality.2.INSTANCE);
        visibility$delegate = FlagDelegatesImplKt.visibilityDelegate(visibility.2.INSTANCE);
        KMutableProperty1 kMutableProperty1 = kind.2.INSTANCE;
        Flags.FlagField<ProtoBuf.Class.Kind> flagField = Flags.CLASS_KIND;
        Intrinsics.checkNotNullExpressionValue(flagField, "CLASS_KIND");
        object = ClassKind.getEntries();
        EnumEntries<ClassKind> enumEntries = ClassKind.getEntries();
        Flags.FlagField<ProtoBuf.Class.Kind> flagField2 = flagField;
        KMutableProperty1 kMutableProperty12 = kMutableProperty1;
        boolean $i$f$map = false;
        void var2_5 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            ClassKind classKind = (ClassKind)((Object)item$iv$iv);
            collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(it.getFlag$kotlin_metadata());
        }
        Collection<FlagImpl> collection2 = collection = (List)var3_6;
        EnumEntries<ClassKind> enumEntries2 = enumEntries;
        Flags.FlagField<ProtoBuf.Class.Kind> flagField3 = flagField2;
        KMutableProperty1 kMutableProperty13 = kMutableProperty12;
        kind$delegate = new EnumFlagDelegate(kMutableProperty13, (Flags.FlagField<Internal.EnumLite>)flagField3, enumEntries2, (List<FlagImpl>)collection2);
        Flags.BooleanFlagField booleanFlagField8 = Flags.IS_INNER;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField8, "IS_INNER");
        isInner$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(booleanFlagField8));
        Flags.BooleanFlagField booleanFlagField9 = Flags.IS_DATA;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField9, "IS_DATA");
        isData$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(booleanFlagField9));
        Flags.BooleanFlagField booleanFlagField10 = Flags.IS_EXTERNAL_CLASS;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField10, "IS_EXTERNAL_CLASS");
        isExternal$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(booleanFlagField10));
        Flags.BooleanFlagField booleanFlagField11 = Flags.IS_EXPECT_CLASS;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField11, "IS_EXPECT_CLASS");
        isExpect$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(booleanFlagField11));
        Flags.BooleanFlagField booleanFlagField12 = Flags.IS_VALUE_CLASS;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField12, "IS_VALUE_CLASS");
        isValue$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(booleanFlagField12));
        Flags.BooleanFlagField booleanFlagField13 = Flags.IS_FUN_INTERFACE;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField13, "IS_FUN_INTERFACE");
        isFunInterface$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(booleanFlagField13));
        Flags.BooleanFlagField booleanFlagField14 = Flags.HAS_ENUM_ENTRIES;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField14, "HAS_ENUM_ENTRIES");
        hasEnumEntries$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(booleanFlagField14));
        visibility$delegate$1 = FlagDelegatesImplKt.visibilityDelegate(visibility.6.INSTANCE);
        Flags.BooleanFlagField booleanFlagField15 = Flags.IS_SECONDARY;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField15, "IS_SECONDARY");
        isSecondary$delegate = FlagDelegatesImplKt.constructorBooleanFlag(new FlagImpl(booleanFlagField15));
        Flags.BooleanFlagField booleanFlagField16 = Flags.IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField16, "IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES");
        hasNonStableParameterNames$delegate = FlagDelegatesImplKt.constructorBooleanFlag(new FlagImpl(booleanFlagField16));
        kind$delegate$1 = FlagDelegatesImplKt.memberKindDelegate(kind.7.INSTANCE);
        visibility$delegate$2 = FlagDelegatesImplKt.visibilityDelegate(visibility.10.INSTANCE);
        modality$delegate$1 = FlagDelegatesImplKt.modalityDelegate(modality.6.INSTANCE);
        Flags.BooleanFlagField booleanFlagField17 = Flags.IS_OPERATOR;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField17, "IS_OPERATOR");
        isOperator$delegate = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(booleanFlagField17));
        Flags.BooleanFlagField booleanFlagField18 = Flags.IS_INFIX;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField18, "IS_INFIX");
        isInfix$delegate = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(booleanFlagField18));
        Flags.BooleanFlagField booleanFlagField19 = Flags.IS_INLINE;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField19, "IS_INLINE");
        isInline$delegate = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(booleanFlagField19));
        Flags.BooleanFlagField booleanFlagField20 = Flags.IS_TAILREC;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField20, "IS_TAILREC");
        isTailrec$delegate = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(booleanFlagField20));
        Flags.BooleanFlagField booleanFlagField21 = Flags.IS_EXTERNAL_FUNCTION;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField21, "IS_EXTERNAL_FUNCTION");
        isExternal$delegate$1 = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(booleanFlagField21));
        Flags.BooleanFlagField booleanFlagField22 = Flags.IS_SUSPEND;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField22, "IS_SUSPEND");
        isSuspend$delegate = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(booleanFlagField22));
        Flags.BooleanFlagField booleanFlagField23 = Flags.IS_EXPECT_FUNCTION;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField23, "IS_EXPECT_FUNCTION");
        isExpect$delegate$1 = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(booleanFlagField23));
        Flags.BooleanFlagField booleanFlagField24 = Flags.IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField24, "IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES");
        hasNonStableParameterNames$delegate$1 = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(booleanFlagField24));
        visibility$delegate$3 = FlagDelegatesImplKt.visibilityDelegate(visibility.14.INSTANCE);
        modality$delegate$2 = FlagDelegatesImplKt.modalityDelegate(modality.10.INSTANCE);
        kind$delegate$2 = FlagDelegatesImplKt.memberKindDelegate(kind.11.INSTANCE);
        Flags.BooleanFlagField booleanFlagField25 = Flags.IS_VAR;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField25, "IS_VAR");
        isVar$delegate = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(booleanFlagField25));
        Flags.BooleanFlagField booleanFlagField26 = Flags.IS_CONST;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField26, "IS_CONST");
        isConst$delegate = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(booleanFlagField26));
        Flags.BooleanFlagField booleanFlagField27 = Flags.IS_LATEINIT;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField27, "IS_LATEINIT");
        isLateinit$delegate = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(booleanFlagField27));
        Flags.BooleanFlagField booleanFlagField28 = Flags.HAS_CONSTANT;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField28, "HAS_CONSTANT");
        hasConstant$delegate = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(booleanFlagField28));
        Flags.BooleanFlagField booleanFlagField29 = Flags.IS_EXTERNAL_PROPERTY;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField29, "IS_EXTERNAL_PROPERTY");
        isExternal$delegate$2 = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(booleanFlagField29));
        Flags.BooleanFlagField booleanFlagField30 = Flags.IS_DELEGATED;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField30, "IS_DELEGATED");
        isDelegated$delegate = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(booleanFlagField30));
        Flags.BooleanFlagField booleanFlagField31 = Flags.IS_EXPECT_PROPERTY;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField31, "IS_EXPECT_PROPERTY");
        isExpect$delegate$2 = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(booleanFlagField31));
        visibility$delegate$4 = FlagDelegatesImplKt.visibilityDelegate(visibility.18.INSTANCE);
        modality$delegate$3 = FlagDelegatesImplKt.modalityDelegate(modality.14.INSTANCE);
        Flags.BooleanFlagField booleanFlagField32 = Flags.IS_NOT_DEFAULT;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField32, "IS_NOT_DEFAULT");
        isNotDefault$delegate = FlagDelegatesImplKt.propertyAccessorBooleanFlag(new FlagImpl(booleanFlagField32));
        Flags.BooleanFlagField booleanFlagField33 = Flags.IS_EXTERNAL_ACCESSOR;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField33, "IS_EXTERNAL_ACCESSOR");
        isExternal$delegate$3 = FlagDelegatesImplKt.propertyAccessorBooleanFlag(new FlagImpl(booleanFlagField33));
        Flags.BooleanFlagField booleanFlagField34 = Flags.IS_INLINE_ACCESSOR;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField34, "IS_INLINE_ACCESSOR");
        isInline$delegate$1 = FlagDelegatesImplKt.propertyAccessorBooleanFlag(new FlagImpl(booleanFlagField34));
        isNullable$delegate = FlagDelegatesImplKt.typeBooleanFlag(new FlagImpl(0, 1, 1));
        isSuspend$delegate$1 = FlagDelegatesImplKt.typeBooleanFlag(new FlagImpl(Flags.SUSPEND_TYPE.offset + 1, Flags.SUSPEND_TYPE.bitWidth, 1));
        isDefinitelyNonNull$delegate = FlagDelegatesImplKt.typeBooleanFlag(new FlagImpl(Flags.DEFINITELY_NOT_NULL_TYPE.offset + 1, Flags.DEFINITELY_NOT_NULL_TYPE.bitWidth, 1));
        isReified$delegate = new BooleanFlagDelegate(isReified.2.INSTANCE, new FlagImpl(0, 1, 1));
        visibility$delegate$5 = FlagDelegatesImplKt.visibilityDelegate(visibility.22.INSTANCE);
        Flags.BooleanFlagField booleanFlagField35 = Flags.DECLARES_DEFAULT_VALUE;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField35, "DECLARES_DEFAULT_VALUE");
        declaresDefaultValue$delegate = FlagDelegatesImplKt.valueParameterBooleanFlag(new FlagImpl(booleanFlagField35));
        Flags.BooleanFlagField booleanFlagField36 = Flags.IS_CROSSINLINE;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField36, "IS_CROSSINLINE");
        isCrossinline$delegate = FlagDelegatesImplKt.valueParameterBooleanFlag(new FlagImpl(booleanFlagField36));
        Flags.BooleanFlagField booleanFlagField37 = Flags.IS_NOINLINE;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField37, "IS_NOINLINE");
        isNoinline$delegate = FlagDelegatesImplKt.valueParameterBooleanFlag(new FlagImpl(booleanFlagField37));
        KMutableProperty1 kMutableProperty14 = isNegated.2.INSTANCE;
        Flags.BooleanFlagField booleanFlagField38 = Flags.IS_NEGATED;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField38, "IS_NEGATED");
        isNegated$delegate = new BooleanFlagDelegate(kMutableProperty14, new FlagImpl(booleanFlagField38));
        KMutableProperty1 kMutableProperty15 = isNullCheckPredicate.2.INSTANCE;
        Flags.BooleanFlagField booleanFlagField39 = Flags.IS_NULL_CHECK_PREDICATE;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField39, "IS_NULL_CHECK_PREDICATE");
        isNullCheckPredicate$delegate = new BooleanFlagDelegate(kMutableProperty15, new FlagImpl(booleanFlagField39));
    }
}

