/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.ErasedOverridabilityCondition$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nErasedOverridabilityCondition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ErasedOverridabilityCondition.kt\norg/jetbrains/kotlin/load/java/ErasedOverridabilityCondition\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,63:1\n1255#2,2:64\n*S KotlinDebug\n*F\n+ 1 ErasedOverridabilityCondition.kt\norg/jetbrains/kotlin/load/java/ErasedOverridabilityCondition\n*L\n44#1:64,2\n*E\n"})
public final class ErasedOverridabilityCondition
implements ExternalOverridabilityCondition {
    @Override
    @NotNull
    public ExternalOverridabilityCondition.Result isOverridable(@NotNull CallableDescriptor superDescriptor, @NotNull CallableDescriptor subDescriptor, @Nullable ClassDescriptor subClassDescriptor) {
        boolean bl2;
        block9: {
            Sequence<KotlinType> signatureTypes;
            OverridingUtil.OverrideCompatibilityInfo.Result basicOverridability;
            block11: {
                block10: {
                    Intrinsics.checkNotNullParameter(superDescriptor, "superDescriptor");
                    Intrinsics.checkNotNullParameter(subDescriptor, "subDescriptor");
                    if (!(subDescriptor instanceof JavaMethodDescriptor)) break block10;
                    List<TypeParameterDescriptor> list = ((JavaMethodDescriptor)subDescriptor).getTypeParameters();
                    Intrinsics.checkNotNullExpressionValue(list, "getTypeParameters(...)");
                    if (!(!((Collection)list).isEmpty())) break block11;
                }
                return ExternalOverridabilityCondition.Result.UNKNOWN;
            }
            OverridingUtil.OverrideCompatibilityInfo overrideCompatibilityInfo = OverridingUtil.getBasicOverridabilityProblem(superDescriptor, subDescriptor);
            OverridingUtil.OverrideCompatibilityInfo.Result result = basicOverridability = overrideCompatibilityInfo != null ? overrideCompatibilityInfo.getResult() : null;
            if (basicOverridability != null) {
                return ExternalOverridabilityCondition.Result.UNKNOWN;
            }
            List<ValueParameterDescriptor> list = ((JavaMethodDescriptor)subDescriptor).getValueParameters();
            Intrinsics.checkNotNullExpressionValue(list, "getValueParameters(...)");
            Sequence sequence = SequencesKt.map(CollectionsKt.asSequence((Iterable)list), ErasedOverridabilityCondition$$Lambda$0.INSTANCE);
            KotlinType kotlinType = ((JavaMethodDescriptor)subDescriptor).getReturnType();
            Intrinsics.checkNotNull(kotlinType);
            ReceiverParameterDescriptor receiverParameterDescriptor = ((JavaMethodDescriptor)subDescriptor).getExtensionReceiverParameter();
            Sequence<KotlinType> $this$any$iv = signatureTypes = SequencesKt.plus(SequencesKt.plus(sequence, kotlinType), (Iterable)CollectionsKt.listOfNotNull(receiverParameterDescriptor != null ? receiverParameterDescriptor.getType() : null));
            boolean $i$f$any = false;
            Iterator<KotlinType> iterator2 = $this$any$iv.iterator();
            while (iterator2.hasNext()) {
                KotlinType element$iv;
                KotlinType it = element$iv = iterator2.next();
                boolean bl3 = false;
                if (!(!((Collection)it.getArguments()).isEmpty() && !(it.unwrap() instanceof RawTypeImpl))) continue;
                bl2 = true;
                break block9;
            }
            bl2 = false;
        }
        if (bl2) {
            return ExternalOverridabilityCondition.Result.UNKNOWN;
        }
        CallableDescriptor callableDescriptor = (CallableDescriptor)superDescriptor.substitute(new RawSubstitution(null, 1, null).buildSubstitutor());
        if (callableDescriptor == null) {
            return ExternalOverridabilityCondition.Result.UNKNOWN;
        }
        CallableDescriptor erasedSuper = callableDescriptor;
        if (erasedSuper instanceof SimpleFunctionDescriptor) {
            List<TypeParameterDescriptor> list = ((SimpleFunctionDescriptor)erasedSuper).getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(list, "getTypeParameters(...)");
            if (!((Collection)list).isEmpty()) {
                SimpleFunctionDescriptor simpleFunctionDescriptor = ((SimpleFunctionDescriptor)erasedSuper).newCopyBuilder().setTypeParameters(CollectionsKt.<TypeParameterDescriptor>emptyList()).build();
                Intrinsics.checkNotNull(simpleFunctionDescriptor);
                erasedSuper = simpleFunctionDescriptor;
            }
        }
        OverridingUtil.OverrideCompatibilityInfo.Result result = OverridingUtil.DEFAULT.isOverridableByWithoutExternalConditions(erasedSuper, subDescriptor, false).getResult();
        Intrinsics.checkNotNullExpressionValue((Object)result, "getResult(...)");
        OverridingUtil.OverrideCompatibilityInfo.Result overridabilityResult = result;
        return WhenMappings.$EnumSwitchMapping$0[overridabilityResult.ordinal()] == 1 ? ExternalOverridabilityCondition.Result.OVERRIDABLE : ExternalOverridabilityCondition.Result.UNKNOWN;
    }

    @Override
    @NotNull
    public ExternalOverridabilityCondition.Contract getContract() {
        return ExternalOverridabilityCondition.Contract.SUCCESS_ONLY;
    }

    private static final KotlinType isOverridable$lambda$0(ValueParameterDescriptor it) {
        return it.getType();
    }

    static /* synthetic */ KotlinType accessor$ErasedOverridabilityCondition$lambda0(ValueParameterDescriptor valueParameterDescriptor) {
        return ErasedOverridabilityCondition.isOverridable$lambda$0(valueParameterDescriptor);
    }

    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[OverridingUtil.OverrideCompatibilityInfo.Result.values().length];
            try {
                nArray[OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

