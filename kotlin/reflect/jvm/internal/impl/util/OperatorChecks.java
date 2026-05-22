/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitClassReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.AbstractModifierChecks;
import kotlin.reflect.jvm.internal.impl.util.Check;
import kotlin.reflect.jvm.internal.impl.util.Checks;
import kotlin.reflect.jvm.internal.impl.util.IsKPropertyCheck;
import kotlin.reflect.jvm.internal.impl.util.MemberKindCheck;
import kotlin.reflect.jvm.internal.impl.util.NoDefaultAndVarargsCheck;
import kotlin.reflect.jvm.internal.impl.util.OperatorChecks$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.util.OperatorChecks$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.util.OperatorChecks$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions;
import kotlin.reflect.jvm.internal.impl.util.ReturnsCheck;
import kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nmodifierChecks.kt\nKotlin\n*S Kotlin\n*F\n+ 1 modifierChecks.kt\norg/jetbrains/kotlin/util/OperatorChecks\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 modifierChecks.kt\norg/jetbrains/kotlin/util/AbstractModifierChecks\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,264:1\n1#2:265\n171#3:266\n171#3:270\n171#3:271\n1761#4,3:267\n*S KotlinDebug\n*F\n+ 1 modifierChecks.kt\norg/jetbrains/kotlin/util/OperatorChecks\n*L\n189#1:266\n203#1:270\n220#1:271\n203#1:267,3\n*E\n"})
public final class OperatorChecks
extends AbstractModifierChecks {
    @NotNull
    public static final OperatorChecks INSTANCE = new OperatorChecks();
    @NotNull
    private static final List<Checks> checks;

    private OperatorChecks() {
    }

    @Override
    @NotNull
    public List<Checks> getChecks$descriptors() {
        return checks;
    }

    private final boolean incDecCheckForExpectClass(FunctionDescriptor $this$incDecCheckForExpectClass, ReceiverParameterDescriptor receiver) {
        ReceiverValue receiverValue = receiver.getValue();
        Intrinsics.checkNotNullExpressionValue(receiverValue, "getValue(...)");
        ReceiverValue receiverValue2 = receiverValue;
        if (!(receiverValue2 instanceof ImplicitClassReceiver)) {
            return false;
        }
        ClassDescriptor classDescriptor = ((ImplicitClassReceiver)receiverValue2).getClassDescriptor();
        if (!classDescriptor.isExpect()) {
            return false;
        }
        ClassId classId = DescriptorUtilsKt.getClassId(classDescriptor);
        if (classId == null) {
            return false;
        }
        ClassId potentialActualAliasId = classId;
        ClassifierDescriptor classifierDescriptor = FindClassInModuleKt.findClassifierAcrossModuleDependencies(DescriptorUtilsKt.getModule(classDescriptor), potentialActualAliasId);
        TypeAliasDescriptor typeAliasDescriptor = classifierDescriptor instanceof TypeAliasDescriptor ? (TypeAliasDescriptor)classifierDescriptor : null;
        if (typeAliasDescriptor == null) {
            return false;
        }
        TypeAliasDescriptor actualReceiverTypeAlias = typeAliasDescriptor;
        KotlinType kotlinType = $this$incDecCheckForExpectClass.getReturnType();
        if (kotlinType != null) {
            KotlinType returnType = kotlinType;
            boolean bl2 = false;
            return TypeUtilsKt.isSubtypeOf(returnType, actualReceiverTypeAlias.getExpandedType());
        }
        return false;
    }

    private static final String checks$lambda$2(FunctionDescriptor $this$Checks) {
        String string;
        boolean bl2;
        Intrinsics.checkNotNullParameter($this$Checks, "$this$Checks");
        List<ValueParameterDescriptor> list = $this$Checks.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(list, "getValueParameters(...)");
        ValueParameterDescriptor valueParameterDescriptor = CollectionsKt.lastOrNull(list);
        if (valueParameterDescriptor != null) {
            ValueParameterDescriptor it = valueParameterDescriptor;
            boolean bl3 = false;
            bl2 = !DescriptorUtilsKt.declaresOrInheritsDefaultValue(it) && it.getVarargElementType() == null;
        } else {
            bl2 = false;
        }
        boolean lastIsOk = bl2;
        AbstractModifierChecks this_$iv = INSTANCE;
        boolean $i$f$ensure = false;
        if (!lastIsOk) {
            boolean bl4 = false;
            string = "last parameter should not have a default value or be a vararg";
        } else {
            string = null;
        }
        return string;
    }

    private static final boolean checks$lambda$6$isAny(DeclarationDescriptor $this$checks_u24lambda_u246_u24isAny) {
        return $this$checks_u24lambda_u246_u24isAny instanceof ClassDescriptor && KotlinBuiltIns.isAny((ClassDescriptor)$this$checks_u24lambda_u246_u24isAny);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final String checks$lambda$6(FunctionDescriptor $this$Checks) {
        StringBuilder stringBuilder;
        boolean bl2;
        Intrinsics.checkNotNullParameter($this$Checks, "$this$Checks");
        AbstractModifierChecks abstractModifierChecks = INSTANCE;
        DeclarationDescriptor declarationDescriptor = $this$Checks.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(declarationDescriptor, "getContainingDeclaration(...)");
        if (OperatorChecks.checks$lambda$6$isAny(declarationDescriptor)) return null;
        Collection<? extends FunctionDescriptor> collection = $this$Checks.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(collection, "getOverriddenDescriptors(...)");
        Iterable $this$any$iv = collection;
        boolean $i$f$any = false;
        if (((Collection)$this$any$iv).isEmpty()) {
            bl2 = false;
        } else {
            for (Object element$iv : $this$any$iv) {
                FunctionDescriptor it = (FunctionDescriptor)element$iv;
                boolean bl3 = false;
                DeclarationDescriptor declarationDescriptor2 = it.getContainingDeclaration();
                Intrinsics.checkNotNullExpressionValue(declarationDescriptor2, "getContainingDeclaration(...)");
                if (!OperatorChecks.checks$lambda$6$isAny(declarationDescriptor2)) continue;
                return null;
            }
            bl2 = false;
        }
        if (bl2) return null;
        if (DescriptorUtilKt.isTypedEqualsInValueClass($this$Checks)) {
            return null;
        }
        boolean bl4 = false;
        boolean cond$iv = bl4;
        boolean $i$f$ensure = false;
        if (cond$iv) return null;
        boolean bl5 = false;
        StringBuilder $this$checks_u24lambda_u246_u24lambda_u245_u24lambda_u244 = stringBuilder = new StringBuilder();
        boolean bl6 = false;
        $this$checks_u24lambda_u246_u24lambda_u245_u24lambda_u244.append("must override ''equals()'' in Any");
        DeclarationDescriptor declarationDescriptor3 = $this$Checks.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(declarationDescriptor3, "getContainingDeclaration(...)");
        if (InlineClassesUtilsKt.isValueClass(declarationDescriptor3)) {
            DeclarationDescriptor declarationDescriptor4 = $this$Checks.getContainingDeclaration();
            Intrinsics.checkNotNull(declarationDescriptor4, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            SimpleType simpleType = ((ClassDescriptor)declarationDescriptor4).getDefaultType();
            Intrinsics.checkNotNullExpressionValue(simpleType, "getDefaultType(...)");
            String expectedParameterTypeRendered = DescriptorRenderer.SHORT_NAMES_IN_TYPES.renderType(TypeUtilsKt.replaceArgumentsWithStarProjections(simpleType));
            $this$checks_u24lambda_u246_u24lambda_u245_u24lambda_u244.append(" or define ''equals(other: " + expectedParameterTypeRendered + "): Boolean''");
        }
        String string = stringBuilder.toString();
        return string;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final String checks$lambda$8(FunctionDescriptor $this$Checks) {
        boolean bl2;
        Intrinsics.checkNotNullParameter($this$Checks, "$this$Checks");
        ReceiverParameterDescriptor receiverParameterDescriptor = $this$Checks.getDispatchReceiverParameter();
        if (receiverParameterDescriptor == null) {
            receiverParameterDescriptor = $this$Checks.getExtensionReceiverParameter();
        }
        ReceiverParameterDescriptor receiver = receiverParameterDescriptor;
        AbstractModifierChecks abstractModifierChecks = INSTANCE;
        if (receiver == null) return "receiver must be a supertype of the return type";
        KotlinType kotlinType = $this$Checks.getReturnType();
        if (kotlinType != null) {
            KotlinType kotlinType2 = receiver.getType();
            Intrinsics.checkNotNullExpressionValue(kotlinType2, "getType(...)");
            bl2 = TypeUtilsKt.isSubtypeOf(kotlinType, kotlinType2);
        } else {
            bl2 = false;
        }
        if (bl2) return null;
        if (!INSTANCE.incDecCheckForExpectClass($this$Checks, receiver)) return "receiver must be a supertype of the return type";
        return null;
    }

    static {
        Checks[] checksArray = new Checks[19];
        Object[] objectArray = new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, new ValueParameterCountCheck.AtLeast(1)};
        checksArray[0] = new Checks(OperatorNameConventions.GET, (Check[])objectArray, null, 4, null);
        objectArray = new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, new ValueParameterCountCheck.AtLeast(2)};
        checksArray[1] = new Checks(OperatorNameConventions.SET, (Check[])objectArray, (Function1<? super FunctionDescriptor, String>)OperatorChecks$$Lambda$0.INSTANCE);
        objectArray = new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE, new ValueParameterCountCheck.AtLeast(2), IsKPropertyCheck.INSTANCE};
        checksArray[2] = new Checks(OperatorNameConventions.GET_VALUE, (Check[])objectArray, null, 4, null);
        objectArray = new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE, new ValueParameterCountCheck.AtLeast(3), IsKPropertyCheck.INSTANCE};
        checksArray[3] = new Checks(OperatorNameConventions.SET_VALUE, (Check[])objectArray, null, 4, null);
        objectArray = new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE, new ValueParameterCountCheck.Equals(2), IsKPropertyCheck.INSTANCE};
        checksArray[4] = new Checks(OperatorNameConventions.PROVIDE_DELEGATE, (Check[])objectArray, null, 4, null);
        objectArray = new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE};
        checksArray[5] = new Checks(OperatorNameConventions.INVOKE, (Check[])objectArray, null, 4, null);
        objectArray = new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE, ReturnsCheck.ReturnsBoolean.INSTANCE};
        checksArray[6] = new Checks(OperatorNameConventions.CONTAINS, (Check[])objectArray, null, 4, null);
        objectArray = new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.NoValueParameters.INSTANCE};
        checksArray[7] = new Checks(OperatorNameConventions.ITERATOR, (Check[])objectArray, null, 4, null);
        objectArray = new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.NoValueParameters.INSTANCE};
        checksArray[8] = new Checks(OperatorNameConventions.NEXT, (Check[])objectArray, null, 4, null);
        objectArray = new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.NoValueParameters.INSTANCE, ReturnsCheck.ReturnsBoolean.INSTANCE};
        checksArray[9] = new Checks(OperatorNameConventions.HAS_NEXT, (Check[])objectArray, null, 4, null);
        objectArray = new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE};
        checksArray[10] = new Checks(OperatorNameConventions.RANGE_TO, (Check[])objectArray, null, 4, null);
        objectArray = new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE};
        checksArray[11] = new Checks(OperatorNameConventions.RANGE_UNTIL, (Check[])objectArray, null, 4, null);
        objectArray = new Check[]{MemberKindCheck.Member.INSTANCE};
        checksArray[12] = new Checks(OperatorNameConventions.EQUALS, (Check[])objectArray, (Function1<? super FunctionDescriptor, String>)OperatorChecks$$Lambda$1.INSTANCE);
        objectArray = new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ReturnsCheck.ReturnsInt.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE};
        checksArray[13] = new Checks(OperatorNameConventions.COMPARE_TO, (Check[])objectArray, null, 4, null);
        objectArray = new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE};
        checksArray[14] = new Checks(OperatorNameConventions.BINARY_OPERATION_NAMES, (Check[])objectArray, null, 4, null);
        objectArray = new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.NoValueParameters.INSTANCE};
        checksArray[15] = new Checks(OperatorNameConventions.SIMPLE_UNARY_OPERATION_NAMES, (Check[])objectArray, null, 4, null);
        objectArray = new Name[]{OperatorNameConventions.INC, OperatorNameConventions.DEC};
        Collection collection = CollectionsKt.listOf(objectArray);
        objectArray = new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE};
        checksArray[16] = new Checks(collection, (Check[])objectArray, (Function1<? super FunctionDescriptor, String>)OperatorChecks$$Lambda$2.INSTANCE);
        objectArray = new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ReturnsCheck.ReturnsUnit.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE};
        checksArray[17] = new Checks(OperatorNameConventions.ASSIGNMENT_OPERATIONS, (Check[])objectArray, null, 4, null);
        objectArray = new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.NoValueParameters.INSTANCE};
        checksArray[18] = new Checks(OperatorNameConventions.COMPONENT_REGEX, (Check[])objectArray, null, 4, null);
        checks = CollectionsKt.listOf(checksArray);
    }

    static /* synthetic */ String accessor$OperatorChecks$lambda0(FunctionDescriptor functionDescriptor) {
        return OperatorChecks.checks$lambda$2(functionDescriptor);
    }

    static /* synthetic */ String accessor$OperatorChecks$lambda1(FunctionDescriptor functionDescriptor) {
        return OperatorChecks.checks$lambda$6(functionDescriptor);
    }

    static /* synthetic */ String accessor$OperatorChecks$lambda2(FunctionDescriptor functionDescriptor) {
        return OperatorChecks.checks$lambda$8(functionDescriptor);
    }
}

