/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyAccessorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.resolve.VisibilityUtilKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class OverridingUtil {
    private static final List<ExternalOverridabilityCondition> EXTERNAL_CONDITIONS = CollectionsKt.toList(ServiceLoader.load(ExternalOverridabilityCondition.class, ExternalOverridabilityCondition.class.getClassLoader()));
    public static final OverridingUtil DEFAULT;
    private static final KotlinTypeChecker.TypeConstructorEquality DEFAULT_TYPE_CONSTRUCTOR_EQUALITY;
    private final KotlinTypeRefiner kotlinTypeRefiner;
    private final KotlinTypePreparator kotlinTypePreparator;
    private final KotlinTypeChecker.TypeConstructorEquality equalityAxioms;
    private final Function2<KotlinType, KotlinType, Boolean> customSubtype;

    @NotNull
    public static OverridingUtil createWithTypeRefiner(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner == null) {
            OverridingUtil.$$$reportNull$$$0(0);
        }
        return new OverridingUtil(DEFAULT_TYPE_CONSTRUCTOR_EQUALITY, kotlinTypeRefiner, KotlinTypePreparator.Default.INSTANCE, null);
    }

    @NotNull
    public static OverridingUtil create(@NotNull KotlinTypeRefiner kotlinTypeRefiner, @NotNull KotlinTypeChecker.TypeConstructorEquality equalityAxioms) {
        if (kotlinTypeRefiner == null) {
            OverridingUtil.$$$reportNull$$$0(3);
        }
        if (equalityAxioms == null) {
            OverridingUtil.$$$reportNull$$$0(4);
        }
        return new OverridingUtil(equalityAxioms, kotlinTypeRefiner, KotlinTypePreparator.Default.INSTANCE, null);
    }

    private OverridingUtil(@NotNull KotlinTypeChecker.TypeConstructorEquality axioms, @NotNull KotlinTypeRefiner kotlinTypeRefiner, @NotNull KotlinTypePreparator kotlinTypePreparator, @Nullable Function2<KotlinType, KotlinType, Boolean> customSubtype) {
        if (axioms == null) {
            OverridingUtil.$$$reportNull$$$0(5);
        }
        if (kotlinTypeRefiner == null) {
            OverridingUtil.$$$reportNull$$$0(6);
        }
        if (kotlinTypePreparator == null) {
            OverridingUtil.$$$reportNull$$$0(7);
        }
        this.equalityAxioms = axioms;
        this.kotlinTypeRefiner = kotlinTypeRefiner;
        this.kotlinTypePreparator = kotlinTypePreparator;
        this.customSubtype = customSubtype;
    }

    @NotNull
    public static <D extends CallableDescriptor> Set<D> filterOutOverridden(@NotNull Set<D> candidateSet) {
        if (candidateSet == null) {
            OverridingUtil.$$$reportNull$$$0(8);
        }
        boolean allowDescriptorCopies = !candidateSet.isEmpty() && DescriptorUtilsKt.isTypeRefinementEnabled(DescriptorUtilsKt.getModule((DeclarationDescriptor)candidateSet.iterator().next()));
        return OverridingUtil.filterOverrides(candidateSet, allowDescriptorCopies, null, new Function2<D, D, Pair<CallableDescriptor, CallableDescriptor>>(){

            @Override
            public Pair<CallableDescriptor, CallableDescriptor> invoke(D a2, D b2) {
                return new Pair<CallableDescriptor, CallableDescriptor>((CallableDescriptor)a2, (CallableDescriptor)b2);
            }
        });
    }

    @NotNull
    public static <D> Set<D> filterOverrides(@NotNull Set<D> candidateSet, boolean allowDescriptorCopies, @Nullable Function0<?> cancellationCallback, @NotNull Function2<? super D, ? super D, Pair<CallableDescriptor, CallableDescriptor>> transformFirst) {
        if (candidateSet == null) {
            OverridingUtil.$$$reportNull$$$0(9);
        }
        if (transformFirst == null) {
            OverridingUtil.$$$reportNull$$$0(10);
        }
        if (candidateSet.size() <= 1) {
            Set<D> set = candidateSet;
            if (set == null) {
                OverridingUtil.$$$reportNull$$$0(11);
            }
            return set;
        }
        LinkedHashSet<D> result = new LinkedHashSet<D>();
        block0: for (D meD : candidateSet) {
            if (cancellationCallback != null) {
                cancellationCallback.invoke();
            }
            Iterator iterator2 = result.iterator();
            while (iterator2.hasNext()) {
                CallableDescriptor other;
                Object otherD = iterator2.next();
                Pair<CallableDescriptor, CallableDescriptor> meAndOther = transformFirst.invoke(meD, otherD);
                CallableDescriptor me = meAndOther.component1();
                if (OverridingUtil.overrides(me, other = meAndOther.component2(), allowDescriptorCopies, true)) {
                    iterator2.remove();
                    continue;
                }
                if (!OverridingUtil.overrides(other, me, allowDescriptorCopies, true)) continue;
                continue block0;
            }
            result.add(meD);
        }
        assert (!result.isEmpty()) : "All candidates filtered out from " + candidateSet;
        LinkedHashSet<D> linkedHashSet = result;
        if (linkedHashSet == null) {
            OverridingUtil.$$$reportNull$$$0(12);
        }
        return linkedHashSet;
    }

    public static <D extends CallableDescriptor> boolean overrides(@NotNull D f2, @NotNull D g2, boolean allowDeclarationCopies, boolean distinguishExpectsAndNonExpects) {
        if (f2 == null) {
            OverridingUtil.$$$reportNull$$$0(13);
        }
        if (g2 == null) {
            OverridingUtil.$$$reportNull$$$0(14);
        }
        if (!f2.equals(g2) && DescriptorEquivalenceForOverrides.INSTANCE.areEquivalent(f2.getOriginal(), g2.getOriginal(), allowDeclarationCopies, distinguishExpectsAndNonExpects)) {
            return true;
        }
        CallableDescriptor originalG = g2.getOriginal();
        for (D overriddenFunction : DescriptorUtils.getAllOverriddenDescriptors(f2)) {
            if (!DescriptorEquivalenceForOverrides.INSTANCE.areEquivalent(originalG, overriddenFunction, allowDeclarationCopies, distinguishExpectsAndNonExpects)) continue;
            return true;
        }
        return false;
    }

    @NotNull
    public static Set<CallableMemberDescriptor> getOverriddenDeclarations(@NotNull CallableMemberDescriptor descriptor2) {
        if (descriptor2 == null) {
            OverridingUtil.$$$reportNull$$$0(15);
        }
        LinkedHashSet<CallableMemberDescriptor> result = new LinkedHashSet<CallableMemberDescriptor>();
        OverridingUtil.collectOverriddenDeclarations(descriptor2, result);
        LinkedHashSet<CallableMemberDescriptor> linkedHashSet = result;
        if (linkedHashSet == null) {
            OverridingUtil.$$$reportNull$$$0(16);
        }
        return linkedHashSet;
    }

    private static void collectOverriddenDeclarations(@NotNull CallableMemberDescriptor descriptor2, @NotNull Set<CallableMemberDescriptor> result) {
        if (descriptor2 == null) {
            OverridingUtil.$$$reportNull$$$0(17);
        }
        if (result == null) {
            OverridingUtil.$$$reportNull$$$0(18);
        }
        if (descriptor2.getKind().isReal()) {
            result.add(descriptor2);
        } else {
            if (descriptor2.getOverriddenDescriptors().isEmpty()) {
                throw new IllegalStateException("No overridden descriptors found for (fake override) " + descriptor2);
            }
            for (CallableMemberDescriptor callableMemberDescriptor : descriptor2.getOverriddenDescriptors()) {
                OverridingUtil.collectOverriddenDeclarations(callableMemberDescriptor, result);
            }
        }
    }

    @NotNull
    public OverrideCompatibilityInfo isOverridableBy(@NotNull CallableDescriptor superDescriptor, @NotNull CallableDescriptor subDescriptor, @Nullable ClassDescriptor subClassDescriptor) {
        if (superDescriptor == null) {
            OverridingUtil.$$$reportNull$$$0(19);
        }
        if (subDescriptor == null) {
            OverridingUtil.$$$reportNull$$$0(20);
        }
        OverrideCompatibilityInfo overrideCompatibilityInfo = this.isOverridableBy(superDescriptor, subDescriptor, subClassDescriptor, false);
        if (overrideCompatibilityInfo == null) {
            OverridingUtil.$$$reportNull$$$0(21);
        }
        return overrideCompatibilityInfo;
    }

    @NotNull
    public OverrideCompatibilityInfo isOverridableBy(@NotNull CallableDescriptor superDescriptor, @NotNull CallableDescriptor subDescriptor, @Nullable ClassDescriptor subClassDescriptor, boolean checkReturnType) {
        ExternalOverridabilityCondition.Result result;
        OverrideCompatibilityInfo basicResult;
        if (superDescriptor == null) {
            OverridingUtil.$$$reportNull$$$0(22);
        }
        if (subDescriptor == null) {
            OverridingUtil.$$$reportNull$$$0(23);
        }
        boolean wasSuccess = (basicResult = this.isOverridableByWithoutExternalConditions(superDescriptor, subDescriptor, checkReturnType)).getResult() == OverrideCompatibilityInfo.Result.OVERRIDABLE;
        for (ExternalOverridabilityCondition externalCondition : EXTERNAL_CONDITIONS) {
            if (externalCondition.getContract() == ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY || wasSuccess && externalCondition.getContract() == ExternalOverridabilityCondition.Contract.SUCCESS_ONLY) continue;
            result = externalCondition.isOverridable(superDescriptor, subDescriptor, subClassDescriptor);
            switch (result) {
                case OVERRIDABLE: {
                    wasSuccess = true;
                    break;
                }
                case INCOMPATIBLE: {
                    OverrideCompatibilityInfo overrideCompatibilityInfo = OverrideCompatibilityInfo.incompatible("External condition");
                    if (overrideCompatibilityInfo == null) {
                        OverridingUtil.$$$reportNull$$$0(24);
                    }
                    return overrideCompatibilityInfo;
                }
            }
        }
        if (!wasSuccess) {
            OverrideCompatibilityInfo overrideCompatibilityInfo = basicResult;
            if (overrideCompatibilityInfo == null) {
                OverridingUtil.$$$reportNull$$$0(25);
            }
            return overrideCompatibilityInfo;
        }
        for (ExternalOverridabilityCondition externalCondition : EXTERNAL_CONDITIONS) {
            if (externalCondition.getContract() != ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY) continue;
            result = externalCondition.isOverridable(superDescriptor, subDescriptor, subClassDescriptor);
            switch (result) {
                case INCOMPATIBLE: {
                    OverrideCompatibilityInfo overrideCompatibilityInfo = OverrideCompatibilityInfo.incompatible("External condition");
                    if (overrideCompatibilityInfo == null) {
                        OverridingUtil.$$$reportNull$$$0(26);
                    }
                    return overrideCompatibilityInfo;
                }
                case OVERRIDABLE: {
                    throw new IllegalStateException("Contract violation in " + externalCondition.getClass().getName() + " condition. It's not supposed to end with success");
                }
            }
        }
        OverrideCompatibilityInfo overrideCompatibilityInfo = OverrideCompatibilityInfo.success();
        if (overrideCompatibilityInfo == null) {
            OverridingUtil.$$$reportNull$$$0(27);
        }
        return overrideCompatibilityInfo;
    }

    @NotNull
    public OverrideCompatibilityInfo isOverridableByWithoutExternalConditions(@NotNull CallableDescriptor superDescriptor, @NotNull CallableDescriptor subDescriptor, boolean checkReturnType) {
        int i2;
        OverrideCompatibilityInfo basicOverridability;
        if (superDescriptor == null) {
            OverridingUtil.$$$reportNull$$$0(28);
        }
        if (subDescriptor == null) {
            OverridingUtil.$$$reportNull$$$0(29);
        }
        if ((basicOverridability = OverridingUtil.getBasicOverridabilityProblem(superDescriptor, subDescriptor)) != null) {
            OverrideCompatibilityInfo overrideCompatibilityInfo = basicOverridability;
            if (overrideCompatibilityInfo == null) {
                OverridingUtil.$$$reportNull$$$0(30);
            }
            return overrideCompatibilityInfo;
        }
        List<KotlinType> superValueParameters = OverridingUtil.compiledValueParameters(superDescriptor);
        List<KotlinType> subValueParameters = OverridingUtil.compiledValueParameters(subDescriptor);
        List<TypeParameterDescriptor> superTypeParameters = superDescriptor.getTypeParameters();
        List<TypeParameterDescriptor> subTypeParameters = subDescriptor.getTypeParameters();
        if (superTypeParameters.size() != subTypeParameters.size()) {
            for (int i3 = 0; i3 < superValueParameters.size(); ++i3) {
                if (KotlinTypeChecker.DEFAULT.equalTypes(superValueParameters.get(i3), subValueParameters.get(i3))) continue;
                OverrideCompatibilityInfo overrideCompatibilityInfo = OverrideCompatibilityInfo.incompatible("Type parameter number mismatch");
                if (overrideCompatibilityInfo == null) {
                    OverridingUtil.$$$reportNull$$$0(31);
                }
                return overrideCompatibilityInfo;
            }
            OverrideCompatibilityInfo overrideCompatibilityInfo = OverrideCompatibilityInfo.conflict("Type parameter number mismatch");
            if (overrideCompatibilityInfo == null) {
                OverridingUtil.$$$reportNull$$$0(32);
            }
            return overrideCompatibilityInfo;
        }
        TypeCheckerState typeCheckerState = this.createTypeCheckerState(superTypeParameters, subTypeParameters);
        for (i2 = 0; i2 < superTypeParameters.size(); ++i2) {
            if (OverridingUtil.areTypeParametersEquivalent(superTypeParameters.get(i2), subTypeParameters.get(i2), typeCheckerState)) continue;
            OverrideCompatibilityInfo overrideCompatibilityInfo = OverrideCompatibilityInfo.incompatible("Type parameter bounds mismatch");
            if (overrideCompatibilityInfo == null) {
                OverridingUtil.$$$reportNull$$$0(33);
            }
            return overrideCompatibilityInfo;
        }
        for (i2 = 0; i2 < superValueParameters.size(); ++i2) {
            if (OverridingUtil.areTypesEquivalent(superValueParameters.get(i2), subValueParameters.get(i2), typeCheckerState)) continue;
            OverrideCompatibilityInfo overrideCompatibilityInfo = OverrideCompatibilityInfo.incompatible("Value parameter type mismatch");
            if (overrideCompatibilityInfo == null) {
                OverridingUtil.$$$reportNull$$$0(34);
            }
            return overrideCompatibilityInfo;
        }
        if (superDescriptor instanceof FunctionDescriptor && subDescriptor instanceof FunctionDescriptor && ((FunctionDescriptor)superDescriptor).isSuspend() != ((FunctionDescriptor)subDescriptor).isSuspend()) {
            OverrideCompatibilityInfo overrideCompatibilityInfo = OverrideCompatibilityInfo.conflict("Incompatible suspendability");
            if (overrideCompatibilityInfo == null) {
                OverridingUtil.$$$reportNull$$$0(35);
            }
            return overrideCompatibilityInfo;
        }
        if (checkReturnType) {
            KotlinType superReturnType = superDescriptor.getReturnType();
            KotlinType subReturnType = subDescriptor.getReturnType();
            if (superReturnType != null && subReturnType != null) {
                boolean bothErrors;
                boolean bl2 = bothErrors = KotlinTypeKt.isError(subReturnType) && KotlinTypeKt.isError(superReturnType);
                if (!bothErrors && !AbstractTypeChecker.INSTANCE.isSubtypeOf(typeCheckerState, subReturnType.unwrap(), superReturnType.unwrap())) {
                    OverrideCompatibilityInfo overrideCompatibilityInfo = OverrideCompatibilityInfo.conflict("Return type mismatch");
                    if (overrideCompatibilityInfo == null) {
                        OverridingUtil.$$$reportNull$$$0(36);
                    }
                    return overrideCompatibilityInfo;
                }
            }
        }
        OverrideCompatibilityInfo overrideCompatibilityInfo = OverrideCompatibilityInfo.success();
        if (overrideCompatibilityInfo == null) {
            OverridingUtil.$$$reportNull$$$0(37);
        }
        return overrideCompatibilityInfo;
    }

    @Nullable
    public static OverrideCompatibilityInfo getBasicOverridabilityProblem(@NotNull CallableDescriptor superDescriptor, @NotNull CallableDescriptor subDescriptor) {
        if (superDescriptor == null) {
            OverridingUtil.$$$reportNull$$$0(38);
        }
        if (subDescriptor == null) {
            OverridingUtil.$$$reportNull$$$0(39);
        }
        if (superDescriptor instanceof FunctionDescriptor && !(subDescriptor instanceof FunctionDescriptor) || superDescriptor instanceof PropertyDescriptor && !(subDescriptor instanceof PropertyDescriptor)) {
            return OverrideCompatibilityInfo.incompatible("Member kind mismatch");
        }
        if (!(superDescriptor instanceof FunctionDescriptor) && !(superDescriptor instanceof PropertyDescriptor)) {
            throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + superDescriptor);
        }
        if (!superDescriptor.getName().equals(subDescriptor.getName())) {
            return OverrideCompatibilityInfo.incompatible("Name mismatch");
        }
        OverrideCompatibilityInfo receiverAndParameterResult = OverridingUtil.checkReceiverAndParameterCount(superDescriptor, subDescriptor);
        if (receiverAndParameterResult != null) {
            return receiverAndParameterResult;
        }
        return null;
    }

    @NotNull
    private TypeCheckerState createTypeCheckerState(@NotNull List<TypeParameterDescriptor> firstParameters, @NotNull List<TypeParameterDescriptor> secondParameters) {
        if (firstParameters == null) {
            OverridingUtil.$$$reportNull$$$0(40);
        }
        if (secondParameters == null) {
            OverridingUtil.$$$reportNull$$$0(41);
        }
        assert (firstParameters.size() == secondParameters.size()) : "Should be the same number of type parameters: " + firstParameters + " vs " + secondParameters;
        if (firstParameters.isEmpty()) {
            TypeCheckerState typeCheckerState = new OverridingUtilTypeSystemContext(null, this.equalityAxioms, this.kotlinTypeRefiner, this.kotlinTypePreparator, this.customSubtype).newTypeCheckerState(true, true, false);
            if (typeCheckerState == null) {
                OverridingUtil.$$$reportNull$$$0(42);
            }
            return typeCheckerState;
        }
        HashMap<TypeConstructor, TypeConstructor> matchingTypeConstructors = new HashMap<TypeConstructor, TypeConstructor>();
        for (int i2 = 0; i2 < firstParameters.size(); ++i2) {
            matchingTypeConstructors.put(firstParameters.get(i2).getTypeConstructor(), secondParameters.get(i2).getTypeConstructor());
        }
        TypeCheckerState typeCheckerState = new OverridingUtilTypeSystemContext(matchingTypeConstructors, this.equalityAxioms, this.kotlinTypeRefiner, this.kotlinTypePreparator, this.customSubtype).newTypeCheckerState(true, true, false);
        if (typeCheckerState == null) {
            OverridingUtil.$$$reportNull$$$0(43);
        }
        return typeCheckerState;
    }

    @Nullable
    private static OverrideCompatibilityInfo checkReceiverAndParameterCount(CallableDescriptor superDescriptor, CallableDescriptor subDescriptor) {
        if (superDescriptor.getExtensionReceiverParameter() == null != (subDescriptor.getExtensionReceiverParameter() == null)) {
            return OverrideCompatibilityInfo.incompatible("Receiver presence mismatch");
        }
        if (superDescriptor.getValueParameters().size() != subDescriptor.getValueParameters().size()) {
            return OverrideCompatibilityInfo.incompatible("Value parameter number mismatch");
        }
        return null;
    }

    private static boolean areTypesEquivalent(@NotNull KotlinType typeInSuper, @NotNull KotlinType typeInSub, @NotNull TypeCheckerState typeCheckerState) {
        boolean bothErrors;
        if (typeInSuper == null) {
            OverridingUtil.$$$reportNull$$$0(44);
        }
        if (typeInSub == null) {
            OverridingUtil.$$$reportNull$$$0(45);
        }
        if (typeCheckerState == null) {
            OverridingUtil.$$$reportNull$$$0(46);
        }
        boolean bl2 = bothErrors = KotlinTypeKt.isError(typeInSuper) && KotlinTypeKt.isError(typeInSub);
        if (bothErrors) {
            return true;
        }
        return AbstractTypeChecker.INSTANCE.equalTypes(typeCheckerState, typeInSuper.unwrap(), typeInSub.unwrap());
    }

    private static boolean areTypeParametersEquivalent(@NotNull TypeParameterDescriptor superTypeParameter, @NotNull TypeParameterDescriptor subTypeParameter, @NotNull TypeCheckerState typeCheckerState) {
        if (superTypeParameter == null) {
            OverridingUtil.$$$reportNull$$$0(47);
        }
        if (subTypeParameter == null) {
            OverridingUtil.$$$reportNull$$$0(48);
        }
        if (typeCheckerState == null) {
            OverridingUtil.$$$reportNull$$$0(49);
        }
        List<KotlinType> superBounds = superTypeParameter.getUpperBounds();
        ArrayList<KotlinType> subBounds = new ArrayList<KotlinType>(subTypeParameter.getUpperBounds());
        if (superBounds.size() != subBounds.size()) {
            return false;
        }
        block0: for (KotlinType superBound : superBounds) {
            ListIterator it = subBounds.listIterator();
            while (it.hasNext()) {
                KotlinType subBound = (KotlinType)it.next();
                if (!OverridingUtil.areTypesEquivalent(superBound, subBound, typeCheckerState)) continue;
                it.remove();
                continue block0;
            }
            return false;
        }
        return true;
    }

    private static List<KotlinType> compiledValueParameters(CallableDescriptor callableDescriptor) {
        ReceiverParameterDescriptor receiverParameter = callableDescriptor.getExtensionReceiverParameter();
        ArrayList<KotlinType> parameters = new ArrayList<KotlinType>();
        if (receiverParameter != null) {
            parameters.add(receiverParameter.getType());
        }
        for (ValueParameterDescriptor valueParameterDescriptor : callableDescriptor.getValueParameters()) {
            parameters.add(valueParameterDescriptor.getType());
        }
        return parameters;
    }

    public void generateOverridesInFunctionGroup(@NotNull Name name, @NotNull Collection<? extends CallableMemberDescriptor> membersFromSupertypes, @NotNull Collection<? extends CallableMemberDescriptor> membersFromCurrent, @NotNull ClassDescriptor current, @NotNull OverridingStrategy strategy) {
        if (name == null) {
            OverridingUtil.$$$reportNull$$$0(50);
        }
        if (membersFromSupertypes == null) {
            OverridingUtil.$$$reportNull$$$0(51);
        }
        if (membersFromCurrent == null) {
            OverridingUtil.$$$reportNull$$$0(52);
        }
        if (current == null) {
            OverridingUtil.$$$reportNull$$$0(53);
        }
        if (strategy == null) {
            OverridingUtil.$$$reportNull$$$0(54);
        }
        LinkedHashSet<CallableMemberDescriptor> notOverridden = new LinkedHashSet<CallableMemberDescriptor>(membersFromSupertypes);
        for (CallableMemberDescriptor callableMemberDescriptor : membersFromCurrent) {
            Collection<CallableMemberDescriptor> bound = this.extractAndBindOverridesForMember(callableMemberDescriptor, membersFromSupertypes, current, strategy);
            notOverridden.removeAll(bound);
        }
        OverridingUtil.createAndBindFakeOverrides(current, notOverridden, strategy);
    }

    public static boolean isVisibleForOverride(@NotNull MemberDescriptor overriding, @NotNull MemberDescriptor fromSuper, boolean useSpecialRulesForPrivateSealedConstructors) {
        if (overriding == null) {
            OverridingUtil.$$$reportNull$$$0(55);
        }
        if (fromSuper == null) {
            OverridingUtil.$$$reportNull$$$0(56);
        }
        return !DescriptorVisibilities.isPrivate(fromSuper.getVisibility()) && DescriptorVisibilities.isVisibleIgnoringReceiver(fromSuper, overriding, useSpecialRulesForPrivateSealedConstructors);
    }

    private Collection<CallableMemberDescriptor> extractAndBindOverridesForMember(@NotNull CallableMemberDescriptor fromCurrent, @NotNull Collection<? extends CallableMemberDescriptor> descriptorsFromSuper, @NotNull ClassDescriptor current, @NotNull OverridingStrategy strategy) {
        if (fromCurrent == null) {
            OverridingUtil.$$$reportNull$$$0(57);
        }
        if (descriptorsFromSuper == null) {
            OverridingUtil.$$$reportNull$$$0(58);
        }
        if (current == null) {
            OverridingUtil.$$$reportNull$$$0(59);
        }
        if (strategy == null) {
            OverridingUtil.$$$reportNull$$$0(60);
        }
        ArrayList<CallableMemberDescriptor> bound = new ArrayList<CallableMemberDescriptor>(descriptorsFromSuper.size());
        SmartSet overridden = SmartSet.create();
        for (CallableMemberDescriptor callableMemberDescriptor : descriptorsFromSuper) {
            OverrideCompatibilityInfo.Result result = this.isOverridableBy(callableMemberDescriptor, fromCurrent, current).getResult();
            boolean isVisibleForOverride = OverridingUtil.isVisibleForOverride(fromCurrent, callableMemberDescriptor, false);
            switch (result) {
                case OVERRIDABLE: {
                    if (isVisibleForOverride) {
                        overridden.add(callableMemberDescriptor);
                    }
                    bound.add(callableMemberDescriptor);
                    break;
                }
                case CONFLICT: {
                    if (isVisibleForOverride) {
                        strategy.overrideConflict(callableMemberDescriptor, fromCurrent);
                    }
                    bound.add(callableMemberDescriptor);
                    break;
                }
            }
        }
        strategy.setOverriddenDescriptors(fromCurrent, overridden);
        return bound;
    }

    private static boolean allHasSameContainingDeclaration(@NotNull Collection<CallableMemberDescriptor> notOverridden) {
        if (notOverridden == null) {
            OverridingUtil.$$$reportNull$$$0(61);
        }
        if (notOverridden.size() < 2) {
            return true;
        }
        final DeclarationDescriptor containingDeclaration = notOverridden.iterator().next().getContainingDeclaration();
        return CollectionsKt.all(notOverridden, new Function1<CallableMemberDescriptor, Boolean>(){

            @Override
            public Boolean invoke(CallableMemberDescriptor descriptor2) {
                return descriptor2.getContainingDeclaration() == containingDeclaration;
            }
        });
    }

    private static void createAndBindFakeOverrides(@NotNull ClassDescriptor current, @NotNull Collection<CallableMemberDescriptor> notOverridden, @NotNull OverridingStrategy strategy) {
        if (current == null) {
            OverridingUtil.$$$reportNull$$$0(62);
        }
        if (notOverridden == null) {
            OverridingUtil.$$$reportNull$$$0(63);
        }
        if (strategy == null) {
            OverridingUtil.$$$reportNull$$$0(64);
        }
        if (OverridingUtil.allHasSameContainingDeclaration(notOverridden)) {
            for (CallableMemberDescriptor descriptor2 : notOverridden) {
                OverridingUtil.createAndBindFakeOverride(Collections.singleton(descriptor2), current, strategy);
            }
            return;
        }
        LinkedList<CallableMemberDescriptor> fromSuperQueue = new LinkedList<CallableMemberDescriptor>(notOverridden);
        while (!fromSuperQueue.isEmpty()) {
            CallableMemberDescriptor notOverriddenFromSuper = VisibilityUtilKt.findMemberWithMaxVisibility(fromSuperQueue);
            Collection<CallableMemberDescriptor> overridables = OverridingUtil.extractMembersOverridableInBothWays(notOverriddenFromSuper, fromSuperQueue, strategy);
            OverridingUtil.createAndBindFakeOverride(overridables, current, strategy);
        }
    }

    public static boolean isMoreSpecific(@NotNull CallableDescriptor a2, @NotNull CallableDescriptor b2) {
        if (a2 == null) {
            OverridingUtil.$$$reportNull$$$0(65);
        }
        if (b2 == null) {
            OverridingUtil.$$$reportNull$$$0(66);
        }
        KotlinType aReturnType = a2.getReturnType();
        KotlinType bReturnType = b2.getReturnType();
        assert (aReturnType != null) : "Return type of " + a2 + " is null";
        assert (bReturnType != null) : "Return type of " + b2 + " is null";
        if (!OverridingUtil.isVisibilityMoreSpecific(a2, b2)) {
            return false;
        }
        TypeCheckerState checkerState = DEFAULT.createTypeCheckerState(a2.getTypeParameters(), b2.getTypeParameters());
        if (a2 instanceof FunctionDescriptor) {
            assert (b2 instanceof FunctionDescriptor) : "b is " + b2.getClass();
            return OverridingUtil.isReturnTypeMoreSpecific(a2, aReturnType, b2, bReturnType, checkerState);
        }
        if (a2 instanceof PropertyDescriptor) {
            assert (b2 instanceof PropertyDescriptor) : "b is " + b2.getClass();
            PropertyDescriptor pa = (PropertyDescriptor)a2;
            PropertyDescriptor pb = (PropertyDescriptor)b2;
            if (!OverridingUtil.isAccessorMoreSpecific(pa.getSetter(), pb.getSetter())) {
                return false;
            }
            if (pa.isVar() && pb.isVar()) {
                return AbstractTypeChecker.INSTANCE.equalTypes(checkerState, aReturnType.unwrap(), bReturnType.unwrap());
            }
            return (pa.isVar() || !pb.isVar()) && OverridingUtil.isReturnTypeMoreSpecific(a2, aReturnType, b2, bReturnType, checkerState);
        }
        throw new IllegalArgumentException("Unexpected callable: " + a2.getClass());
    }

    private static boolean isVisibilityMoreSpecific(@NotNull DeclarationDescriptorWithVisibility a2, @NotNull DeclarationDescriptorWithVisibility b2) {
        Integer result;
        if (a2 == null) {
            OverridingUtil.$$$reportNull$$$0(67);
        }
        if (b2 == null) {
            OverridingUtil.$$$reportNull$$$0(68);
        }
        return (result = DescriptorVisibilities.compare(a2.getVisibility(), b2.getVisibility())) == null || result >= 0;
    }

    private static boolean isAccessorMoreSpecific(@Nullable PropertyAccessorDescriptor a2, @Nullable PropertyAccessorDescriptor b2) {
        if (a2 == null || b2 == null) {
            return true;
        }
        return OverridingUtil.isVisibilityMoreSpecific(a2, b2);
    }

    private static boolean isMoreSpecificThenAllOf(@NotNull CallableDescriptor candidate, @NotNull Collection<CallableDescriptor> descriptors) {
        if (candidate == null) {
            OverridingUtil.$$$reportNull$$$0(69);
        }
        if (descriptors == null) {
            OverridingUtil.$$$reportNull$$$0(70);
        }
        for (CallableDescriptor descriptor2 : descriptors) {
            if (OverridingUtil.isMoreSpecific(candidate, descriptor2)) continue;
            return false;
        }
        return true;
    }

    private static boolean isReturnTypeMoreSpecific(@NotNull CallableDescriptor a2, @NotNull KotlinType aReturnType, @NotNull CallableDescriptor b2, @NotNull KotlinType bReturnType, @NotNull TypeCheckerState typeCheckerState) {
        if (a2 == null) {
            OverridingUtil.$$$reportNull$$$0(71);
        }
        if (aReturnType == null) {
            OverridingUtil.$$$reportNull$$$0(72);
        }
        if (b2 == null) {
            OverridingUtil.$$$reportNull$$$0(73);
        }
        if (bReturnType == null) {
            OverridingUtil.$$$reportNull$$$0(74);
        }
        if (typeCheckerState == null) {
            OverridingUtil.$$$reportNull$$$0(75);
        }
        return AbstractTypeChecker.INSTANCE.isSubtypeOf(typeCheckerState, aReturnType.unwrap(), bReturnType.unwrap());
    }

    @NotNull
    public static <H> H selectMostSpecificMember(@NotNull Collection<H> overridables, @NotNull Function1<H, CallableDescriptor> descriptorByHandle) {
        if (overridables == null) {
            OverridingUtil.$$$reportNull$$$0(76);
        }
        if (descriptorByHandle == null) {
            OverridingUtil.$$$reportNull$$$0(77);
        }
        assert (!overridables.isEmpty()) : "Should have at least one overridable descriptor";
        if (overridables.size() == 1) {
            H h2 = CollectionsKt.first(overridables);
            if (h2 == null) {
                OverridingUtil.$$$reportNull$$$0(78);
            }
            return h2;
        }
        ArrayList<H> candidates = new ArrayList<H>(2);
        List<CallableDescriptor> callableMemberDescriptors = CollectionsKt.map(overridables, descriptorByHandle);
        H transitivelyMostSpecific = CollectionsKt.first(overridables);
        CallableDescriptor transitivelyMostSpecificDescriptor = descriptorByHandle.invoke(transitivelyMostSpecific);
        for (H overridable : overridables) {
            CallableDescriptor descriptor2 = descriptorByHandle.invoke(overridable);
            if (OverridingUtil.isMoreSpecificThenAllOf(descriptor2, callableMemberDescriptors)) {
                candidates.add(overridable);
            }
            if (!OverridingUtil.isMoreSpecific(descriptor2, transitivelyMostSpecificDescriptor) || OverridingUtil.isMoreSpecific(transitivelyMostSpecificDescriptor, descriptor2)) continue;
            transitivelyMostSpecific = overridable;
        }
        if (candidates.isEmpty()) {
            H h3 = transitivelyMostSpecific;
            if (h3 == null) {
                OverridingUtil.$$$reportNull$$$0(79);
            }
            return h3;
        }
        if (candidates.size() == 1) {
            Object e2 = CollectionsKt.first(candidates);
            if (e2 == null) {
                OverridingUtil.$$$reportNull$$$0(80);
            }
            return (H)e2;
        }
        H firstNonFlexible = null;
        for (Object candidate : candidates) {
            if (FlexibleTypesKt.isFlexible(descriptorByHandle.invoke(candidate).getReturnType())) continue;
            firstNonFlexible = (H)candidate;
            break;
        }
        if (firstNonFlexible != null) {
            H h4 = firstNonFlexible;
            if (h4 == null) {
                OverridingUtil.$$$reportNull$$$0(81);
            }
            return h4;
        }
        Object e3 = CollectionsKt.first(candidates);
        if (e3 == null) {
            OverridingUtil.$$$reportNull$$$0(82);
        }
        return (H)e3;
    }

    private static void createAndBindFakeOverride(@NotNull Collection<CallableMemberDescriptor> overridables, @NotNull ClassDescriptor current, @NotNull OverridingStrategy strategy) {
        Collection<CallableMemberDescriptor> visibleOverridables;
        boolean allInvisible;
        if (overridables == null) {
            OverridingUtil.$$$reportNull$$$0(83);
        }
        if (current == null) {
            OverridingUtil.$$$reportNull$$$0(84);
        }
        if (strategy == null) {
            OverridingUtil.$$$reportNull$$$0(85);
        }
        Collection<CallableMemberDescriptor> effectiveOverridden = (allInvisible = (visibleOverridables = OverridingUtil.filterVisibleFakeOverrides(current, overridables)).isEmpty()) ? overridables : visibleOverridables;
        Modality modality2 = OverridingUtil.determineModalityForFakeOverride(effectiveOverridden, current);
        DescriptorVisibility visibility2 = allInvisible ? DescriptorVisibilities.INVISIBLE_FAKE : DescriptorVisibilities.INHERITED;
        CallableMemberDescriptor mostSpecific = OverridingUtil.selectMostSpecificMember(effectiveOverridden, new Function1<CallableMemberDescriptor, CallableDescriptor>(){

            @Override
            public CallableMemberDescriptor invoke(CallableMemberDescriptor descriptor2) {
                return descriptor2;
            }
        });
        CallableMemberDescriptor fakeOverride = mostSpecific.copy(current, modality2, visibility2, CallableMemberDescriptor.Kind.FAKE_OVERRIDE, false);
        strategy.setOverriddenDescriptors(fakeOverride, effectiveOverridden);
        assert (!fakeOverride.getOverriddenDescriptors().isEmpty()) : "Overridden descriptors should be set for " + (Object)((Object)CallableMemberDescriptor.Kind.FAKE_OVERRIDE);
        strategy.addFakeOverride(fakeOverride);
    }

    @NotNull
    private static Modality determineModalityForFakeOverride(@NotNull Collection<CallableMemberDescriptor> descriptors, @NotNull ClassDescriptor current) {
        boolean transformAbstractToClassModality;
        if (descriptors == null) {
            OverridingUtil.$$$reportNull$$$0(86);
        }
        if (current == null) {
            OverridingUtil.$$$reportNull$$$0(87);
        }
        boolean hasOpen = false;
        boolean hasAbstract = false;
        for (CallableMemberDescriptor descriptor2 : descriptors) {
            switch (descriptor2.getModality()) {
                case FINAL: {
                    Modality modality2 = Modality.FINAL;
                    if (modality2 == null) {
                        OverridingUtil.$$$reportNull$$$0(88);
                    }
                    return modality2;
                }
                case SEALED: {
                    throw new IllegalStateException("Member cannot have SEALED modality: " + descriptor2);
                }
                case OPEN: {
                    hasOpen = true;
                    break;
                }
                case ABSTRACT: {
                    hasAbstract = true;
                }
            }
        }
        boolean bl2 = transformAbstractToClassModality = current.isExpect() && current.getModality() != Modality.ABSTRACT && current.getModality() != Modality.SEALED;
        if (hasOpen && !hasAbstract) {
            Modality modality3 = Modality.OPEN;
            if (modality3 == null) {
                OverridingUtil.$$$reportNull$$$0(89);
            }
            return modality3;
        }
        if (!hasOpen && hasAbstract) {
            Modality modality4 = transformAbstractToClassModality ? current.getModality() : Modality.ABSTRACT;
            if (modality4 == null) {
                OverridingUtil.$$$reportNull$$$0(90);
            }
            return modality4;
        }
        HashSet<CallableMemberDescriptor> allOverriddenDeclarations = new HashSet<CallableMemberDescriptor>();
        for (CallableMemberDescriptor descriptor3 : descriptors) {
            allOverriddenDeclarations.addAll(OverridingUtil.getOverriddenDeclarations(descriptor3));
        }
        return OverridingUtil.getMinimalModality(OverridingUtil.filterOutOverridden(allOverriddenDeclarations), transformAbstractToClassModality, current.getModality());
    }

    @NotNull
    private static Modality getMinimalModality(@NotNull Collection<CallableMemberDescriptor> descriptors, boolean transformAbstractToClassModality, @NotNull Modality classModality) {
        if (descriptors == null) {
            OverridingUtil.$$$reportNull$$$0(91);
        }
        if (classModality == null) {
            OverridingUtil.$$$reportNull$$$0(92);
        }
        Modality result = Modality.ABSTRACT;
        for (CallableMemberDescriptor descriptor2 : descriptors) {
            Modality effectiveModality = transformAbstractToClassModality && descriptor2.getModality() == Modality.ABSTRACT ? classModality : descriptor2.getModality();
            if (effectiveModality.compareTo(result) >= 0) continue;
            result = effectiveModality;
        }
        Modality modality2 = result;
        if (modality2 == null) {
            OverridingUtil.$$$reportNull$$$0(93);
        }
        return modality2;
    }

    @NotNull
    public static Collection<CallableMemberDescriptor> filterVisibleFakeOverrides(final @NotNull ClassDescriptor current, @NotNull Collection<CallableMemberDescriptor> toFilter) {
        if (current == null) {
            OverridingUtil.$$$reportNull$$$0(94);
        }
        if (toFilter == null) {
            OverridingUtil.$$$reportNull$$$0(95);
        }
        List<CallableMemberDescriptor> list = CollectionsKt.filter(toFilter, new Function1<CallableMemberDescriptor, Boolean>(){

            @Override
            public Boolean invoke(CallableMemberDescriptor descriptor2) {
                return !DescriptorVisibilities.isPrivate(descriptor2.getVisibility()) && DescriptorVisibilities.isVisibleIgnoringReceiver(descriptor2, current, false);
            }
        });
        if (list == null) {
            OverridingUtil.$$$reportNull$$$0(96);
        }
        return list;
    }

    @NotNull
    public static <H> Collection<H> extractMembersOverridableInBothWays(@NotNull H overrider, @NotNull Collection<H> extractFrom, @NotNull Function1<H, CallableDescriptor> descriptorByHandle, @NotNull Function1<H, Unit> onConflict) {
        if (overrider == null) {
            OverridingUtil.$$$reportNull$$$0(97);
        }
        if (extractFrom == null) {
            OverridingUtil.$$$reportNull$$$0(98);
        }
        if (descriptorByHandle == null) {
            OverridingUtil.$$$reportNull$$$0(99);
        }
        if (onConflict == null) {
            OverridingUtil.$$$reportNull$$$0(100);
        }
        ArrayList<H> overridable = new ArrayList<H>();
        overridable.add(overrider);
        CallableDescriptor overriderDescriptor = descriptorByHandle.invoke(overrider);
        Iterator<H> iterator2 = extractFrom.iterator();
        while (iterator2.hasNext()) {
            H candidate = iterator2.next();
            CallableDescriptor candidateDescriptor = descriptorByHandle.invoke(candidate);
            if (overrider == candidate) {
                iterator2.remove();
                continue;
            }
            OverrideCompatibilityInfo.Result finalResult = OverridingUtil.getBothWaysOverridability(overriderDescriptor, candidateDescriptor);
            if (finalResult == OverrideCompatibilityInfo.Result.OVERRIDABLE) {
                overridable.add(candidate);
                iterator2.remove();
                continue;
            }
            if (finalResult != OverrideCompatibilityInfo.Result.CONFLICT) continue;
            onConflict.invoke(candidate);
            iterator2.remove();
        }
        ArrayList<H> arrayList = overridable;
        if (arrayList == null) {
            OverridingUtil.$$$reportNull$$$0(101);
        }
        return arrayList;
    }

    @Nullable
    public static OverrideCompatibilityInfo.Result getBothWaysOverridability(CallableDescriptor overriderDescriptor, CallableDescriptor candidateDescriptor) {
        OverrideCompatibilityInfo.Result result1 = DEFAULT.isOverridableBy(candidateDescriptor, overriderDescriptor, null).getResult();
        OverrideCompatibilityInfo.Result result2 = DEFAULT.isOverridableBy(overriderDescriptor, candidateDescriptor, null).getResult();
        return result1 == OverrideCompatibilityInfo.Result.OVERRIDABLE && result2 == OverrideCompatibilityInfo.Result.OVERRIDABLE ? OverrideCompatibilityInfo.Result.OVERRIDABLE : (result1 == OverrideCompatibilityInfo.Result.CONFLICT || result2 == OverrideCompatibilityInfo.Result.CONFLICT ? OverrideCompatibilityInfo.Result.CONFLICT : OverrideCompatibilityInfo.Result.INCOMPATIBLE);
    }

    @NotNull
    private static Collection<CallableMemberDescriptor> extractMembersOverridableInBothWays(final @NotNull CallableMemberDescriptor overrider, @NotNull Queue<CallableMemberDescriptor> extractFrom, final @NotNull OverridingStrategy strategy) {
        if (overrider == null) {
            OverridingUtil.$$$reportNull$$$0(102);
        }
        if (extractFrom == null) {
            OverridingUtil.$$$reportNull$$$0(103);
        }
        if (strategy == null) {
            OverridingUtil.$$$reportNull$$$0(104);
        }
        return OverridingUtil.extractMembersOverridableInBothWays(overrider, extractFrom, new Function1<CallableMemberDescriptor, CallableDescriptor>(){

            @Override
            public CallableDescriptor invoke(CallableMemberDescriptor descriptor2) {
                return descriptor2;
            }
        }, new Function1<CallableMemberDescriptor, Unit>(){

            @Override
            public Unit invoke(CallableMemberDescriptor descriptor2) {
                strategy.inheritanceConflict(overrider, descriptor2);
                return Unit.INSTANCE;
            }
        });
    }

    /*
     * WARNING - void declaration
     */
    public static void resolveUnknownVisibilityForMember(@NotNull CallableMemberDescriptor memberDescriptor, @Nullable Function1<CallableMemberDescriptor, Unit> cannotInferVisibility) {
        void var3_6;
        if (memberDescriptor == null) {
            OverridingUtil.$$$reportNull$$$0(105);
        }
        for (CallableMemberDescriptor callableMemberDescriptor : memberDescriptor.getOverriddenDescriptors()) {
            if (callableMemberDescriptor.getVisibility() != DescriptorVisibilities.INHERITED) continue;
            OverridingUtil.resolveUnknownVisibilityForMember(callableMemberDescriptor, cannotInferVisibility);
        }
        if (memberDescriptor.getVisibility() != DescriptorVisibilities.INHERITED) {
            return;
        }
        DescriptorVisibility maxVisibility = OverridingUtil.computeVisibilityToInherit(memberDescriptor);
        if (maxVisibility == null) {
            if (cannotInferVisibility != null) {
                cannotInferVisibility.invoke(memberDescriptor);
            }
            DescriptorVisibility descriptorVisibility = DescriptorVisibilities.PUBLIC;
        } else {
            DescriptorVisibility descriptorVisibility = maxVisibility;
        }
        if (memberDescriptor instanceof PropertyDescriptorImpl) {
            ((PropertyDescriptorImpl)memberDescriptor).setVisibility((DescriptorVisibility)var3_6);
            for (PropertyAccessorDescriptor accessor : ((PropertyDescriptor)memberDescriptor).getAccessors()) {
                OverridingUtil.resolveUnknownVisibilityForMember(accessor, maxVisibility == null ? null : cannotInferVisibility);
            }
        } else if (memberDescriptor instanceof FunctionDescriptorImpl) {
            ((FunctionDescriptorImpl)memberDescriptor).setVisibility((DescriptorVisibility)var3_6);
        } else {
            assert (memberDescriptor instanceof PropertyAccessorDescriptorImpl);
            PropertyAccessorDescriptorImpl propertyAccessorDescriptor = (PropertyAccessorDescriptorImpl)memberDescriptor;
            propertyAccessorDescriptor.setVisibility((DescriptorVisibility)var3_6);
            if (var3_6 != propertyAccessorDescriptor.getCorrespondingProperty().getVisibility()) {
                propertyAccessorDescriptor.setDefault(false);
            }
        }
    }

    @Nullable
    private static DescriptorVisibility computeVisibilityToInherit(@NotNull CallableMemberDescriptor memberDescriptor) {
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors;
        DescriptorVisibility maxVisibility;
        if (memberDescriptor == null) {
            OverridingUtil.$$$reportNull$$$0(106);
        }
        if ((maxVisibility = OverridingUtil.findMaxVisibility(overriddenDescriptors = memberDescriptor.getOverriddenDescriptors())) == null) {
            return null;
        }
        if (memberDescriptor.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            for (CallableMemberDescriptor callableMemberDescriptor : overriddenDescriptors) {
                if (callableMemberDescriptor.getModality() == Modality.ABSTRACT || callableMemberDescriptor.getVisibility().equals(maxVisibility)) continue;
                return null;
            }
            return maxVisibility;
        }
        return maxVisibility.normalize();
    }

    @Nullable
    public static DescriptorVisibility findMaxVisibility(@NotNull Collection<? extends CallableMemberDescriptor> descriptors) {
        if (descriptors == null) {
            OverridingUtil.$$$reportNull$$$0(107);
        }
        if (descriptors.isEmpty()) {
            return DescriptorVisibilities.DEFAULT_VISIBILITY;
        }
        DescriptorVisibility maxVisibility = null;
        for (CallableMemberDescriptor callableMemberDescriptor : descriptors) {
            DescriptorVisibility visibility2 = callableMemberDescriptor.getVisibility();
            assert (visibility2 != DescriptorVisibilities.INHERITED) : "Visibility should have been computed for " + callableMemberDescriptor;
            if (maxVisibility == null) {
                maxVisibility = visibility2;
                continue;
            }
            Integer compareResult = DescriptorVisibilities.compare(visibility2, maxVisibility);
            if (compareResult == null) {
                maxVisibility = null;
                continue;
            }
            if (compareResult <= 0) continue;
            maxVisibility = visibility2;
        }
        if (maxVisibility == null) {
            return null;
        }
        for (CallableMemberDescriptor callableMemberDescriptor : descriptors) {
            Integer compareResult = DescriptorVisibilities.compare(maxVisibility, callableMemberDescriptor.getVisibility());
            if (compareResult != null && compareResult >= 0) continue;
            return null;
        }
        return maxVisibility;
    }

    static {
        DEFAULT_TYPE_CONSTRUCTOR_EQUALITY = new KotlinTypeChecker.TypeConstructorEquality(){

            @Override
            public boolean equals(@NotNull TypeConstructor a2, @NotNull TypeConstructor b2) {
                if (a2 == null) {
                    1.$$$reportNull$$$0(0);
                }
                if (b2 == null) {
                    1.$$$reportNull$$$0(1);
                }
                return a2.equals(b2);
            }

            private static /* synthetic */ void $$$reportNull$$$0(int n2) {
                Object[] objectArray;
                Object[] objectArray2 = new Object[3];
                switch (n2) {
                    default: {
                        objectArray = objectArray2;
                        objectArray2[0] = "a";
                        break;
                    }
                    case 1: {
                        objectArray = objectArray2;
                        objectArray2[0] = "b";
                        break;
                    }
                }
                objectArray[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
                objectArray[2] = "equals";
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objectArray));
            }
        };
        DEFAULT = new OverridingUtil(DEFAULT_TYPE_CONSTRUCTOR_EQUALITY, KotlinTypeRefiner.Default.INSTANCE, KotlinTypePreparator.Default.INSTANCE, null);
    }

    private static /* synthetic */ void $$$reportNull$$$0(int n2) {
        RuntimeException runtimeException;
        Object[] objectArray;
        Object[] objectArray2;
        int n3;
        String string;
        switch (n2) {
            default: {
                string = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
            }
            case 11: 
            case 12: 
            case 16: 
            case 21: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 30: 
            case 31: 
            case 32: 
            case 33: 
            case 34: 
            case 35: 
            case 36: 
            case 37: 
            case 42: 
            case 43: 
            case 78: 
            case 79: 
            case 80: 
            case 81: 
            case 82: 
            case 88: 
            case 89: 
            case 90: 
            case 93: 
            case 96: 
            case 101: {
                string = "@NotNull method %s.%s must not return null";
                break;
            }
        }
        switch (n2) {
            default: {
                n3 = 3;
                break;
            }
            case 11: 
            case 12: 
            case 16: 
            case 21: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 30: 
            case 31: 
            case 32: 
            case 33: 
            case 34: 
            case 35: 
            case 36: 
            case 37: 
            case 42: 
            case 43: 
            case 78: 
            case 79: 
            case 80: 
            case 81: 
            case 82: 
            case 88: 
            case 89: 
            case 90: 
            case 93: 
            case 96: 
            case 101: {
                n3 = 2;
                break;
            }
        }
        Object[] objectArray3 = new Object[n3];
        switch (n2) {
            default: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kotlinTypeRefiner";
                break;
            }
            case 1: 
            case 7: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kotlinTypePreparator";
                break;
            }
            case 2: {
                objectArray2 = objectArray3;
                objectArray3[0] = "customSubtype";
                break;
            }
            case 4: {
                objectArray2 = objectArray3;
                objectArray3[0] = "equalityAxioms";
                break;
            }
            case 5: {
                objectArray2 = objectArray3;
                objectArray3[0] = "axioms";
                break;
            }
            case 8: 
            case 9: {
                objectArray2 = objectArray3;
                objectArray3[0] = "candidateSet";
                break;
            }
            case 10: {
                objectArray2 = objectArray3;
                objectArray3[0] = "transformFirst";
                break;
            }
            case 11: 
            case 12: 
            case 16: 
            case 21: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 30: 
            case 31: 
            case 32: 
            case 33: 
            case 34: 
            case 35: 
            case 36: 
            case 37: 
            case 42: 
            case 43: 
            case 78: 
            case 79: 
            case 80: 
            case 81: 
            case 82: 
            case 88: 
            case 89: 
            case 90: 
            case 93: 
            case 96: 
            case 101: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                break;
            }
            case 13: {
                objectArray2 = objectArray3;
                objectArray3[0] = "f";
                break;
            }
            case 14: {
                objectArray2 = objectArray3;
                objectArray3[0] = "g";
                break;
            }
            case 15: 
            case 17: {
                objectArray2 = objectArray3;
                objectArray3[0] = "descriptor";
                break;
            }
            case 18: {
                objectArray2 = objectArray3;
                objectArray3[0] = "result";
                break;
            }
            case 19: 
            case 22: 
            case 28: 
            case 38: {
                objectArray2 = objectArray3;
                objectArray3[0] = "superDescriptor";
                break;
            }
            case 20: 
            case 23: 
            case 29: 
            case 39: {
                objectArray2 = objectArray3;
                objectArray3[0] = "subDescriptor";
                break;
            }
            case 40: {
                objectArray2 = objectArray3;
                objectArray3[0] = "firstParameters";
                break;
            }
            case 41: {
                objectArray2 = objectArray3;
                objectArray3[0] = "secondParameters";
                break;
            }
            case 44: {
                objectArray2 = objectArray3;
                objectArray3[0] = "typeInSuper";
                break;
            }
            case 45: {
                objectArray2 = objectArray3;
                objectArray3[0] = "typeInSub";
                break;
            }
            case 46: 
            case 49: 
            case 75: {
                objectArray2 = objectArray3;
                objectArray3[0] = "typeCheckerState";
                break;
            }
            case 47: {
                objectArray2 = objectArray3;
                objectArray3[0] = "superTypeParameter";
                break;
            }
            case 48: {
                objectArray2 = objectArray3;
                objectArray3[0] = "subTypeParameter";
                break;
            }
            case 50: {
                objectArray2 = objectArray3;
                objectArray3[0] = "name";
                break;
            }
            case 51: {
                objectArray2 = objectArray3;
                objectArray3[0] = "membersFromSupertypes";
                break;
            }
            case 52: {
                objectArray2 = objectArray3;
                objectArray3[0] = "membersFromCurrent";
                break;
            }
            case 53: 
            case 59: 
            case 62: 
            case 84: 
            case 87: 
            case 94: {
                objectArray2 = objectArray3;
                objectArray3[0] = "current";
                break;
            }
            case 54: 
            case 60: 
            case 64: 
            case 85: 
            case 104: {
                objectArray2 = objectArray3;
                objectArray3[0] = "strategy";
                break;
            }
            case 55: {
                objectArray2 = objectArray3;
                objectArray3[0] = "overriding";
                break;
            }
            case 56: {
                objectArray2 = objectArray3;
                objectArray3[0] = "fromSuper";
                break;
            }
            case 57: {
                objectArray2 = objectArray3;
                objectArray3[0] = "fromCurrent";
                break;
            }
            case 58: {
                objectArray2 = objectArray3;
                objectArray3[0] = "descriptorsFromSuper";
                break;
            }
            case 61: 
            case 63: {
                objectArray2 = objectArray3;
                objectArray3[0] = "notOverridden";
                break;
            }
            case 65: 
            case 67: 
            case 71: {
                objectArray2 = objectArray3;
                objectArray3[0] = "a";
                break;
            }
            case 66: 
            case 68: 
            case 73: {
                objectArray2 = objectArray3;
                objectArray3[0] = "b";
                break;
            }
            case 69: {
                objectArray2 = objectArray3;
                objectArray3[0] = "candidate";
                break;
            }
            case 70: 
            case 86: 
            case 91: 
            case 107: {
                objectArray2 = objectArray3;
                objectArray3[0] = "descriptors";
                break;
            }
            case 72: {
                objectArray2 = objectArray3;
                objectArray3[0] = "aReturnType";
                break;
            }
            case 74: {
                objectArray2 = objectArray3;
                objectArray3[0] = "bReturnType";
                break;
            }
            case 76: 
            case 83: {
                objectArray2 = objectArray3;
                objectArray3[0] = "overridables";
                break;
            }
            case 77: 
            case 99: {
                objectArray2 = objectArray3;
                objectArray3[0] = "descriptorByHandle";
                break;
            }
            case 92: {
                objectArray2 = objectArray3;
                objectArray3[0] = "classModality";
                break;
            }
            case 95: {
                objectArray2 = objectArray3;
                objectArray3[0] = "toFilter";
                break;
            }
            case 97: 
            case 102: {
                objectArray2 = objectArray3;
                objectArray3[0] = "overrider";
                break;
            }
            case 98: 
            case 103: {
                objectArray2 = objectArray3;
                objectArray3[0] = "extractFrom";
                break;
            }
            case 100: {
                objectArray2 = objectArray3;
                objectArray3[0] = "onConflict";
                break;
            }
            case 105: 
            case 106: {
                objectArray2 = objectArray3;
                objectArray3[0] = "memberDescriptor";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray2;
                objectArray2[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                break;
            }
            case 11: 
            case 12: {
                objectArray = objectArray2;
                objectArray2[1] = "filterOverrides";
                break;
            }
            case 16: {
                objectArray = objectArray2;
                objectArray2[1] = "getOverriddenDeclarations";
                break;
            }
            case 21: 
            case 24: 
            case 25: 
            case 26: 
            case 27: {
                objectArray = objectArray2;
                objectArray2[1] = "isOverridableBy";
                break;
            }
            case 30: 
            case 31: 
            case 32: 
            case 33: 
            case 34: 
            case 35: 
            case 36: 
            case 37: {
                objectArray = objectArray2;
                objectArray2[1] = "isOverridableByWithoutExternalConditions";
                break;
            }
            case 42: 
            case 43: {
                objectArray = objectArray2;
                objectArray2[1] = "createTypeCheckerState";
                break;
            }
            case 78: 
            case 79: 
            case 80: 
            case 81: 
            case 82: {
                objectArray = objectArray2;
                objectArray2[1] = "selectMostSpecificMember";
                break;
            }
            case 88: 
            case 89: 
            case 90: {
                objectArray = objectArray2;
                objectArray2[1] = "determineModalityForFakeOverride";
                break;
            }
            case 93: {
                objectArray = objectArray2;
                objectArray2[1] = "getMinimalModality";
                break;
            }
            case 96: {
                objectArray = objectArray2;
                objectArray2[1] = "filterVisibleFakeOverrides";
                break;
            }
            case 101: {
                objectArray = objectArray2;
                objectArray2[1] = "extractMembersOverridableInBothWays";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray;
                objectArray[2] = "createWithTypeRefiner";
                break;
            }
            case 1: 
            case 2: {
                objectArray = objectArray;
                objectArray[2] = "createWithTypePreparatorAndCustomSubtype";
                break;
            }
            case 3: 
            case 4: {
                objectArray = objectArray;
                objectArray[2] = "create";
                break;
            }
            case 5: 
            case 6: 
            case 7: {
                objectArray = objectArray;
                objectArray[2] = "<init>";
                break;
            }
            case 8: {
                objectArray = objectArray;
                objectArray[2] = "filterOutOverridden";
                break;
            }
            case 9: 
            case 10: {
                objectArray = objectArray;
                objectArray[2] = "filterOverrides";
                break;
            }
            case 11: 
            case 12: 
            case 16: 
            case 21: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 30: 
            case 31: 
            case 32: 
            case 33: 
            case 34: 
            case 35: 
            case 36: 
            case 37: 
            case 42: 
            case 43: 
            case 78: 
            case 79: 
            case 80: 
            case 81: 
            case 82: 
            case 88: 
            case 89: 
            case 90: 
            case 93: 
            case 96: 
            case 101: {
                break;
            }
            case 13: 
            case 14: {
                objectArray = objectArray;
                objectArray[2] = "overrides";
                break;
            }
            case 15: {
                objectArray = objectArray;
                objectArray[2] = "getOverriddenDeclarations";
                break;
            }
            case 17: 
            case 18: {
                objectArray = objectArray;
                objectArray[2] = "collectOverriddenDeclarations";
                break;
            }
            case 19: 
            case 20: 
            case 22: 
            case 23: {
                objectArray = objectArray;
                objectArray[2] = "isOverridableBy";
                break;
            }
            case 28: 
            case 29: {
                objectArray = objectArray;
                objectArray[2] = "isOverridableByWithoutExternalConditions";
                break;
            }
            case 38: 
            case 39: {
                objectArray = objectArray;
                objectArray[2] = "getBasicOverridabilityProblem";
                break;
            }
            case 40: 
            case 41: {
                objectArray = objectArray;
                objectArray[2] = "createTypeCheckerState";
                break;
            }
            case 44: 
            case 45: 
            case 46: {
                objectArray = objectArray;
                objectArray[2] = "areTypesEquivalent";
                break;
            }
            case 47: 
            case 48: 
            case 49: {
                objectArray = objectArray;
                objectArray[2] = "areTypeParametersEquivalent";
                break;
            }
            case 50: 
            case 51: 
            case 52: 
            case 53: 
            case 54: {
                objectArray = objectArray;
                objectArray[2] = "generateOverridesInFunctionGroup";
                break;
            }
            case 55: 
            case 56: {
                objectArray = objectArray;
                objectArray[2] = "isVisibleForOverride";
                break;
            }
            case 57: 
            case 58: 
            case 59: 
            case 60: {
                objectArray = objectArray;
                objectArray[2] = "extractAndBindOverridesForMember";
                break;
            }
            case 61: {
                objectArray = objectArray;
                objectArray[2] = "allHasSameContainingDeclaration";
                break;
            }
            case 62: 
            case 63: 
            case 64: {
                objectArray = objectArray;
                objectArray[2] = "createAndBindFakeOverrides";
                break;
            }
            case 65: 
            case 66: {
                objectArray = objectArray;
                objectArray[2] = "isMoreSpecific";
                break;
            }
            case 67: 
            case 68: {
                objectArray = objectArray;
                objectArray[2] = "isVisibilityMoreSpecific";
                break;
            }
            case 69: 
            case 70: {
                objectArray = objectArray;
                objectArray[2] = "isMoreSpecificThenAllOf";
                break;
            }
            case 71: 
            case 72: 
            case 73: 
            case 74: 
            case 75: {
                objectArray = objectArray;
                objectArray[2] = "isReturnTypeMoreSpecific";
                break;
            }
            case 76: 
            case 77: {
                objectArray = objectArray;
                objectArray[2] = "selectMostSpecificMember";
                break;
            }
            case 83: 
            case 84: 
            case 85: {
                objectArray = objectArray;
                objectArray[2] = "createAndBindFakeOverride";
                break;
            }
            case 86: 
            case 87: {
                objectArray = objectArray;
                objectArray[2] = "determineModalityForFakeOverride";
                break;
            }
            case 91: 
            case 92: {
                objectArray = objectArray;
                objectArray[2] = "getMinimalModality";
                break;
            }
            case 94: 
            case 95: {
                objectArray = objectArray;
                objectArray[2] = "filterVisibleFakeOverrides";
                break;
            }
            case 97: 
            case 98: 
            case 99: 
            case 100: 
            case 102: 
            case 103: 
            case 104: {
                objectArray = objectArray;
                objectArray[2] = "extractMembersOverridableInBothWays";
                break;
            }
            case 105: {
                objectArray = objectArray;
                objectArray[2] = "resolveUnknownVisibilityForMember";
                break;
            }
            case 106: {
                objectArray = objectArray;
                objectArray[2] = "computeVisibilityToInherit";
                break;
            }
            case 107: {
                objectArray = objectArray;
                objectArray[2] = "findMaxVisibility";
                break;
            }
        }
        String string2 = String.format(string, objectArray);
        switch (n2) {
            default: {
                runtimeException = new IllegalArgumentException(string2);
                break;
            }
            case 11: 
            case 12: 
            case 16: 
            case 21: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 30: 
            case 31: 
            case 32: 
            case 33: 
            case 34: 
            case 35: 
            case 36: 
            case 37: 
            case 42: 
            case 43: 
            case 78: 
            case 79: 
            case 80: 
            case 81: 
            case 82: 
            case 88: 
            case 89: 
            case 90: 
            case 93: 
            case 96: 
            case 101: {
                runtimeException = new IllegalStateException(string2);
                break;
            }
        }
        throw runtimeException;
    }

    public static class OverrideCompatibilityInfo {
        private static final OverrideCompatibilityInfo SUCCESS = new OverrideCompatibilityInfo(Result.OVERRIDABLE, "SUCCESS");
        private final Result overridable;
        private final String debugMessage;

        @NotNull
        public static OverrideCompatibilityInfo success() {
            OverrideCompatibilityInfo overrideCompatibilityInfo = SUCCESS;
            if (overrideCompatibilityInfo == null) {
                OverrideCompatibilityInfo.$$$reportNull$$$0(0);
            }
            return overrideCompatibilityInfo;
        }

        @NotNull
        public static OverrideCompatibilityInfo incompatible(@NotNull String debugMessage) {
            if (debugMessage == null) {
                OverrideCompatibilityInfo.$$$reportNull$$$0(1);
            }
            return new OverrideCompatibilityInfo(Result.INCOMPATIBLE, debugMessage);
        }

        @NotNull
        public static OverrideCompatibilityInfo conflict(@NotNull String debugMessage) {
            if (debugMessage == null) {
                OverrideCompatibilityInfo.$$$reportNull$$$0(2);
            }
            return new OverrideCompatibilityInfo(Result.CONFLICT, debugMessage);
        }

        public OverrideCompatibilityInfo(@NotNull Result success, @NotNull String debugMessage) {
            if (success == null) {
                OverrideCompatibilityInfo.$$$reportNull$$$0(3);
            }
            if (debugMessage == null) {
                OverrideCompatibilityInfo.$$$reportNull$$$0(4);
            }
            this.overridable = success;
            this.debugMessage = debugMessage;
        }

        @NotNull
        public Result getResult() {
            Result result = this.overridable;
            if (result == null) {
                OverrideCompatibilityInfo.$$$reportNull$$$0(5);
            }
            return result;
        }

        public String toString() {
            return (Object)((Object)this.overridable) + ": " + this.debugMessage;
        }

        private static /* synthetic */ void $$$reportNull$$$0(int n2) {
            RuntimeException runtimeException;
            Object[] objectArray;
            Object[] objectArray2;
            int n3;
            String string;
            switch (n2) {
                default: {
                    string = "@NotNull method %s.%s must not return null";
                    break;
                }
                case 1: 
                case 2: 
                case 3: 
                case 4: {
                    string = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
                }
            }
            switch (n2) {
                default: {
                    n3 = 2;
                    break;
                }
                case 1: 
                case 2: 
                case 3: 
                case 4: {
                    n3 = 3;
                    break;
                }
            }
            Object[] objectArray3 = new Object[n3];
            switch (n2) {
                default: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
                    break;
                }
                case 1: 
                case 2: 
                case 4: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "debugMessage";
                    break;
                }
                case 3: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "success";
                    break;
                }
            }
            switch (n2) {
                default: {
                    objectArray = objectArray2;
                    objectArray2[1] = "success";
                    break;
                }
                case 1: 
                case 2: 
                case 3: 
                case 4: {
                    objectArray = objectArray2;
                    objectArray2[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
                    break;
                }
                case 5: {
                    objectArray = objectArray2;
                    objectArray2[1] = "getResult";
                    break;
                }
                case 6: {
                    objectArray = objectArray2;
                    objectArray2[1] = "getDebugMessage";
                    break;
                }
            }
            switch (n2) {
                default: {
                    break;
                }
                case 1: {
                    objectArray = objectArray;
                    objectArray[2] = "incompatible";
                    break;
                }
                case 2: {
                    objectArray = objectArray;
                    objectArray[2] = "conflict";
                    break;
                }
                case 3: 
                case 4: {
                    objectArray = objectArray;
                    objectArray[2] = "<init>";
                    break;
                }
            }
            String string2 = String.format(string, objectArray);
            switch (n2) {
                default: {
                    runtimeException = new IllegalStateException(string2);
                    break;
                }
                case 1: 
                case 2: 
                case 3: 
                case 4: {
                    runtimeException = new IllegalArgumentException(string2);
                    break;
                }
            }
            throw runtimeException;
        }

        public static enum Result {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT;

        }
    }
}

