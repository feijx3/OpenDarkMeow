/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayDeque;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.SubtypePathNode;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedureCallbacks;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nutils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 utils.kt\norg/jetbrains/kotlin/types/checker/UtilsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,108:1\n1761#2,3:109\n*S KotlinDebug\n*F\n+ 1 utils.kt\norg/jetbrains/kotlin/types/checker/UtilsKt\n*L\n51#1:109,3\n*E\n"})
public final class UtilsKt {
    @Nullable
    public static final KotlinType findCorrespondingSupertype(@NotNull KotlinType subtype, @NotNull KotlinType supertype, @NotNull TypeCheckingProcedureCallbacks typeCheckingProcedureCallbacks) {
        Intrinsics.checkNotNullParameter(subtype, "subtype");
        Intrinsics.checkNotNullParameter(supertype, "supertype");
        Intrinsics.checkNotNullParameter(typeCheckingProcedureCallbacks, "typeCheckingProcedureCallbacks");
        ArrayDeque<SubtypePathNode> queue = new ArrayDeque<SubtypePathNode>();
        queue.add(new SubtypePathNode(subtype, null));
        TypeConstructor supertypeConstructor = supertype.getConstructor();
        while (!queue.isEmpty()) {
            SubtypePathNode lastPathNode = (SubtypePathNode)queue.poll();
            KotlinType currentSubtype = lastPathNode.getType();
            TypeConstructor constructor = currentSubtype.getConstructor();
            if (typeCheckingProcedureCallbacks.assertEqualTypeConstructors(constructor, supertypeConstructor)) {
                KotlinType substituted = currentSubtype;
                boolean isAnyMarkedNullable = currentSubtype.isMarkedNullable();
                for (SubtypePathNode currentPathNode = lastPathNode.getPrevious(); currentPathNode != null; currentPathNode = currentPathNode.getPrevious()) {
                    KotlinType kotlinType;
                    boolean bl2;
                    KotlinType currentType;
                    block10: {
                        currentType = currentPathNode.getType();
                        Iterable $this$any$iv = currentType.getArguments();
                        boolean $i$f$any = false;
                        if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                            bl2 = false;
                        } else {
                            for (Object element$iv : $this$any$iv) {
                                TypeProjection it = (TypeProjection)element$iv;
                                boolean bl3 = false;
                                if (!(it.getProjectionKind() != Variance.INVARIANT)) continue;
                                bl2 = true;
                                break block10;
                            }
                            bl2 = false;
                        }
                    }
                    if (bl2) {
                        KotlinType kotlinType2 = CapturedTypeConstructorKt.wrapWithCapturingSubstitution$default(TypeConstructorSubstitution.Companion.create(currentType), false, 1, null).buildSubstitutor().safeSubstitute(substituted, Variance.INVARIANT);
                        Intrinsics.checkNotNullExpressionValue(kotlinType2, "safeSubstitute(...)");
                        kotlinType = UtilsKt.approximate(kotlinType2);
                    } else {
                        KotlinType kotlinType3 = TypeConstructorSubstitution.Companion.create(currentType).buildSubstitutor().safeSubstitute(substituted, Variance.INVARIANT);
                        Intrinsics.checkNotNull(kotlinType3);
                        kotlinType = kotlinType3;
                    }
                    substituted = kotlinType;
                    isAnyMarkedNullable = isAnyMarkedNullable || currentType.isMarkedNullable();
                }
                TypeConstructor substitutedConstructor = substituted.getConstructor();
                if (!typeCheckingProcedureCallbacks.assertEqualTypeConstructors(substitutedConstructor, supertypeConstructor)) {
                    throw new AssertionError((Object)("Type constructors should be equals!\nsubstitutedSuperType: " + UtilsKt.debugInfo(substitutedConstructor) + ", \n\nsupertype: " + UtilsKt.debugInfo(supertypeConstructor) + " \n" + typeCheckingProcedureCallbacks.assertEqualTypeConstructors(substitutedConstructor, supertypeConstructor)));
                }
                return TypeUtils.makeNullableAsSpecified(substituted, isAnyMarkedNullable);
            }
            for (KotlinType immediateSupertype : constructor.getSupertypes()) {
                Intrinsics.checkNotNull(immediateSupertype);
                queue.add(new SubtypePathNode(immediateSupertype, lastPathNode));
            }
        }
        return null;
    }

    private static final KotlinType approximate(KotlinType $this$approximate) {
        return CapturedTypeApproximationKt.approximateCapturedTypes($this$approximate).getUpper();
    }

    private static final String debugInfo(TypeConstructor $this$debugInfo) {
        StringBuilder stringBuilder;
        StringBuilder $this$debugInfo_u24lambda_u241 = stringBuilder = new StringBuilder();
        boolean bl2 = false;
        UtilsKt.debugInfo$lambda$1$unaryPlus("type: " + $this$debugInfo, $this$debugInfo_u24lambda_u241);
        UtilsKt.debugInfo$lambda$1$unaryPlus("hashCode: " + $this$debugInfo.hashCode(), $this$debugInfo_u24lambda_u241);
        UtilsKt.debugInfo$lambda$1$unaryPlus("javaClass: " + $this$debugInfo.getClass().getCanonicalName(), $this$debugInfo_u24lambda_u241);
        for (DeclarationDescriptor declarationDescriptor = (DeclarationDescriptor)$this$debugInfo.getDeclarationDescriptor(); declarationDescriptor != null; declarationDescriptor = declarationDescriptor.getContainingDeclaration()) {
            UtilsKt.debugInfo$lambda$1$unaryPlus("fqName: " + DescriptorRenderer.FQ_NAMES_IN_TYPES.render(declarationDescriptor), $this$debugInfo_u24lambda_u241);
            UtilsKt.debugInfo$lambda$1$unaryPlus("javaClass: " + declarationDescriptor.getClass().getCanonicalName(), $this$debugInfo_u24lambda_u241);
        }
        return stringBuilder.toString();
    }

    private static final StringBuilder debugInfo$lambda$1$unaryPlus(String $this$debugInfo_u24lambda_u241_u24unaryPlus, StringBuilder $this_buildString) {
        Intrinsics.checkNotNullParameter($this$debugInfo_u24lambda_u241_u24unaryPlus, "<this>");
        return $this_buildString.append($this$debugInfo_u24lambda_u241_u24unaryPlus).append('\n');
    }
}

