/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmOverloads
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$$Lambda$3;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DescriptorEquivalenceForOverrides {
    @NotNull
    public static final DescriptorEquivalenceForOverrides INSTANCE = new DescriptorEquivalenceForOverrides();

    private DescriptorEquivalenceForOverrides() {
    }

    public final boolean areEquivalent(@Nullable DeclarationDescriptor a2, @Nullable DeclarationDescriptor b2, boolean allowCopiesFromTheSameDeclaration, boolean distinguishExpectsAndNonExpects) {
        return a2 instanceof ClassDescriptor && b2 instanceof ClassDescriptor ? this.areClassesEquivalent((ClassDescriptor)a2, (ClassDescriptor)b2) : (a2 instanceof TypeParameterDescriptor && b2 instanceof TypeParameterDescriptor ? DescriptorEquivalenceForOverrides.areTypeParametersEquivalent$default(this, (TypeParameterDescriptor)a2, (TypeParameterDescriptor)b2, allowCopiesFromTheSameDeclaration, null, 8, null) : (a2 instanceof CallableDescriptor && b2 instanceof CallableDescriptor ? DescriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent$default(this, (CallableDescriptor)a2, (CallableDescriptor)b2, allowCopiesFromTheSameDeclaration, distinguishExpectsAndNonExpects, false, KotlinTypeRefiner.Default.INSTANCE, 16, null) : (a2 instanceof PackageFragmentDescriptor && b2 instanceof PackageFragmentDescriptor ? Intrinsics.areEqual(((PackageFragmentDescriptor)a2).getFqName(), ((PackageFragmentDescriptor)b2).getFqName()) : Intrinsics.areEqual(a2, b2))));
    }

    public static /* synthetic */ boolean areEquivalent$default(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2, boolean bl2, boolean bl3, int n2, Object object) {
        if ((n2 & 8) != 0) {
            bl3 = true;
        }
        return descriptorEquivalenceForOverrides.areEquivalent(declarationDescriptor, declarationDescriptor2, bl2, bl3);
    }

    private final boolean areClassesEquivalent(ClassDescriptor a2, ClassDescriptor b2) {
        return Intrinsics.areEqual(a2.getTypeConstructor(), b2.getTypeConstructor());
    }

    @JvmOverloads
    public final boolean areTypeParametersEquivalent(@NotNull TypeParameterDescriptor a2, @NotNull TypeParameterDescriptor b2, boolean allowCopiesFromTheSameDeclaration, @NotNull Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> equivalentCallables) {
        Intrinsics.checkNotNullParameter(a2, "a");
        Intrinsics.checkNotNullParameter(b2, "b");
        Intrinsics.checkNotNullParameter(equivalentCallables, "equivalentCallables");
        if (Intrinsics.areEqual(a2, b2)) {
            return true;
        }
        if (Intrinsics.areEqual(a2.getContainingDeclaration(), b2.getContainingDeclaration())) {
            return false;
        }
        if (!this.ownersEquivalent(a2, b2, equivalentCallables, allowCopiesFromTheSameDeclaration)) {
            return false;
        }
        return a2.getIndex() == b2.getIndex();
    }

    public static /* synthetic */ boolean areTypeParametersEquivalent$default(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, boolean bl2, Function2 function2, int n2, Object object) {
        if ((n2 & 8) != 0) {
            function2 = DescriptorEquivalenceForOverrides$$Lambda$0.INSTANCE;
        }
        return descriptorEquivalenceForOverrides.areTypeParametersEquivalent(typeParameterDescriptor, typeParameterDescriptor2, bl2, function2);
    }

    private final SourceElement singleSource(CallableDescriptor $this$singleSource) {
        DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides = this;
        while (true) {
            if (!($this$singleSource instanceof CallableMemberDescriptor) || ((CallableMemberDescriptor)$this$singleSource).getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
                return $this$singleSource.getSource();
            }
            Collection<? extends CallableMemberDescriptor> collection = ((CallableMemberDescriptor)$this$singleSource).getOverriddenDescriptors();
            Intrinsics.checkNotNullExpressionValue(collection, "getOverriddenDescriptors(...)");
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor)CollectionsKt.singleOrNull((Iterable)collection);
            if (callableMemberDescriptor == null) break;
            $this$singleSource = callableMemberDescriptor;
        }
        return null;
    }

    public final boolean areCallableDescriptorsEquivalent(@NotNull CallableDescriptor a2, @NotNull CallableDescriptor b2, boolean allowCopiesFromTheSameDeclaration, boolean distinguishExpectsAndNonExpects, boolean ignoreReturnType, @NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(a2, "a");
        Intrinsics.checkNotNullParameter(b2, "b");
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (Intrinsics.areEqual(a2, b2)) {
            return true;
        }
        if (!Intrinsics.areEqual(a2.getName(), b2.getName())) {
            return false;
        }
        if (distinguishExpectsAndNonExpects && a2 instanceof MemberDescriptor && b2 instanceof MemberDescriptor && ((MemberDescriptor)((Object)a2)).isExpect() != ((MemberDescriptor)((Object)b2)).isExpect()) {
            return false;
        }
        if (Intrinsics.areEqual(a2.getContainingDeclaration(), b2.getContainingDeclaration())) {
            if (!allowCopiesFromTheSameDeclaration) {
                return false;
            }
            if (!Intrinsics.areEqual(this.singleSource(a2), this.singleSource(b2))) {
                return false;
            }
        }
        if (DescriptorUtils.isLocal(a2) || DescriptorUtils.isLocal(b2)) {
            return false;
        }
        if (!this.ownersEquivalent(a2, b2, DescriptorEquivalenceForOverrides$$Lambda$1.INSTANCE, allowCopiesFromTheSameDeclaration)) {
            return false;
        }
        CallableDescriptor callableDescriptor = b2;
        CallableDescriptor callableDescriptor2 = a2;
        boolean bl2 = allowCopiesFromTheSameDeclaration;
        OverridingUtil overridingUtil = OverridingUtil.create(kotlinTypeRefiner, new DescriptorEquivalenceForOverrides$$Lambda$2(bl2, callableDescriptor2, callableDescriptor));
        Intrinsics.checkNotNullExpressionValue(overridingUtil, "create(...)");
        OverridingUtil overridingUtil2 = overridingUtil;
        return overridingUtil2.isOverridableBy(a2, b2, null, !ignoreReturnType).getResult() == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE && overridingUtil2.isOverridableBy(b2, a2, null, !ignoreReturnType).getResult() == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
    }

    public static /* synthetic */ boolean areCallableDescriptorsEquivalent$default(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, boolean bl2, boolean bl3, boolean bl4, KotlinTypeRefiner kotlinTypeRefiner, int n2, Object object) {
        if ((n2 & 8) != 0) {
            bl3 = true;
        }
        if ((n2 & 0x10) != 0) {
            bl4 = false;
        }
        return descriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent(callableDescriptor, callableDescriptor2, bl2, bl3, bl4, kotlinTypeRefiner);
    }

    private final boolean ownersEquivalent(DeclarationDescriptor a2, DeclarationDescriptor b2, Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> equivalentCallables, boolean allowCopiesFromTheSameDeclaration) {
        DeclarationDescriptor aOwner = a2.getContainingDeclaration();
        DeclarationDescriptor bOwner = b2.getContainingDeclaration();
        return aOwner instanceof CallableMemberDescriptor || bOwner instanceof CallableMemberDescriptor ? equivalentCallables.invoke(aOwner, bOwner) : DescriptorEquivalenceForOverrides.areEquivalent$default(this, aOwner, bOwner, allowCopiesFromTheSameDeclaration, false, 8, null);
    }

    @JvmOverloads
    public final boolean areTypeParametersEquivalent(@NotNull TypeParameterDescriptor a2, @NotNull TypeParameterDescriptor b2, boolean allowCopiesFromTheSameDeclaration) {
        Intrinsics.checkNotNullParameter(a2, "a");
        Intrinsics.checkNotNullParameter(b2, "b");
        return DescriptorEquivalenceForOverrides.areTypeParametersEquivalent$default(this, a2, b2, allowCopiesFromTheSameDeclaration, null, 8, null);
    }

    private static final boolean areTypeParametersEquivalent$lambda$0(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        return false;
    }

    private static final boolean areCallableDescriptorsEquivalent$lambda$1(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        return false;
    }

    private static final boolean areCallableDescriptorsEquivalent$lambda$3$lambda$2(CallableDescriptor $a, CallableDescriptor $b, DeclarationDescriptor x2, DeclarationDescriptor y2) {
        return Intrinsics.areEqual(x2, $a) && Intrinsics.areEqual(y2, $b);
    }

    private static final boolean areCallableDescriptorsEquivalent$lambda$3(boolean $allowCopiesFromTheSameDeclaration, CallableDescriptor $a, CallableDescriptor $b, TypeConstructor c1, TypeConstructor c2) {
        Intrinsics.checkNotNullParameter(c1, "c1");
        Intrinsics.checkNotNullParameter(c2, "c2");
        if (Intrinsics.areEqual(c1, c2)) {
            return true;
        }
        ClassifierDescriptor d1 = c1.getDeclarationDescriptor();
        ClassifierDescriptor d2 = c2.getDeclarationDescriptor();
        if (!(d1 instanceof TypeParameterDescriptor) || !(d2 instanceof TypeParameterDescriptor)) {
            return false;
        }
        CallableDescriptor callableDescriptor = $b;
        CallableDescriptor callableDescriptor2 = $a;
        return INSTANCE.areTypeParametersEquivalent((TypeParameterDescriptor)d1, (TypeParameterDescriptor)d2, $allowCopiesFromTheSameDeclaration, new DescriptorEquivalenceForOverrides$$Lambda$3(callableDescriptor2, callableDescriptor));
    }

    static /* synthetic */ boolean accessor$DescriptorEquivalenceForOverrides$lambda0(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        return DescriptorEquivalenceForOverrides.areTypeParametersEquivalent$lambda$0(declarationDescriptor, declarationDescriptor2);
    }

    static /* synthetic */ boolean accessor$DescriptorEquivalenceForOverrides$lambda1(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        return DescriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent$lambda$1(declarationDescriptor, declarationDescriptor2);
    }

    static /* synthetic */ boolean accessor$DescriptorEquivalenceForOverrides$lambda2(boolean bl2, CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, TypeConstructor typeConstructor2, TypeConstructor typeConstructor3) {
        return DescriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent$lambda$3(bl2, callableDescriptor, callableDescriptor2, typeConstructor2, typeConstructor3);
    }

    static /* synthetic */ boolean accessor$DescriptorEquivalenceForOverrides$lambda3(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        return DescriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent$lambda$3$lambda$2(callableDescriptor, callableDescriptor2, declarationDescriptor, declarationDescriptor2);
    }
}

