/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedType;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.DelegatedTypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.IndexedParametersSubstitution;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nCapturedTypeConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CapturedTypeConstructor.kt\norg/jetbrains/kotlin/resolve/calls/inference/CapturedTypeConstructorKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,153:1\n1563#2:154\n1634#2,3:155\n37#3:158\n36#3,3:159\n*S KotlinDebug\n*F\n+ 1 CapturedTypeConstructor.kt\norg/jetbrains/kotlin/resolve/calls/inference/CapturedTypeConstructorKt\n*L\n125#1:154\n125#1:155,3\n127#1:158\n127#1:159,3\n*E\n"})
public final class CapturedTypeConstructorKt {
    @NotNull
    public static final KotlinType createCapturedType(@NotNull TypeProjection typeProjection) {
        Intrinsics.checkNotNullParameter(typeProjection, "typeProjection");
        return new CapturedType(typeProjection, null, false, null, 14, null);
    }

    public static final boolean isCaptured(@NotNull KotlinType $this$isCaptured) {
        Intrinsics.checkNotNullParameter($this$isCaptured, "<this>");
        return $this$isCaptured.getConstructor() instanceof CapturedTypeConstructor;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final TypeSubstitution wrapWithCapturingSubstitution(@NotNull TypeSubstitution $this$wrapWithCapturingSubstitution, boolean needApproximation) {
        TypeSubstitution typeSubstitution;
        Intrinsics.checkNotNullParameter($this$wrapWithCapturingSubstitution, "<this>");
        if ($this$wrapWithCapturingSubstitution instanceof IndexedParametersSubstitution) {
            void $this$mapTo$iv$iv;
            void $this$map$iv;
            Iterable iterable = ArraysKt.zip(((IndexedParametersSubstitution)$this$wrapWithCapturingSubstitution).getArguments(), ((IndexedParametersSubstitution)$this$wrapWithCapturingSubstitution).getParameters());
            TypeParameterDescriptor[] typeParameterDescriptorArray = ((IndexedParametersSubstitution)$this$wrapWithCapturingSubstitution).getParameters();
            boolean $i$f$map = false;
            void var4_5 = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it;
                Pair pair = (Pair)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl2 = false;
                collection.add(CapturedTypeConstructorKt.createCapturedIfNeeded((TypeProjection)it.getFirst(), (TypeParameterDescriptor)it.getSecond()));
            }
            Collection $this$toTypedArray$iv = (List)destination$iv$iv;
            boolean $i$f$toTypedArray = false;
            Collection thisCollection$iv = $this$toTypedArray$iv;
            boolean bl3 = needApproximation;
            TypeProjection[] typeProjectionArray = thisCollection$iv.toArray(new TypeProjection[0]);
            TypeParameterDescriptor[] typeParameterDescriptorArray2 = typeParameterDescriptorArray;
            typeSubstitution = new IndexedParametersSubstitution(typeParameterDescriptorArray2, typeProjectionArray, bl3);
        } else {
            typeSubstitution = new DelegatedTypeSubstitution($this$wrapWithCapturingSubstitution, needApproximation){
                final /* synthetic */ boolean $needApproximation;
                {
                    this.$needApproximation = $needApproximation;
                    super($receiver);
                }

                public boolean approximateContravariantCapturedTypes() {
                    return this.$needApproximation;
                }

                public TypeProjection get(KotlinType key) {
                    ClassifierDescriptor classifierDescriptor;
                    Intrinsics.checkNotNullParameter(key, "key");
                    TypeProjection typeProjection = super.get(key);
                    return typeProjection != null ? CapturedTypeConstructorKt.access$createCapturedIfNeeded(typeProjection, (classifierDescriptor = key.getConstructor().getDeclarationDescriptor()) instanceof TypeParameterDescriptor ? (TypeParameterDescriptor)classifierDescriptor : null) : null;
                }
            };
        }
        return typeSubstitution;
    }

    public static /* synthetic */ TypeSubstitution wrapWithCapturingSubstitution$default(TypeSubstitution typeSubstitution, boolean bl2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            bl2 = true;
        }
        return CapturedTypeConstructorKt.wrapWithCapturingSubstitution(typeSubstitution, bl2);
    }

    private static final TypeProjection createCapturedIfNeeded(TypeProjection $this$createCapturedIfNeeded, TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor == null || $this$createCapturedIfNeeded.getProjectionKind() == Variance.INVARIANT) {
            return $this$createCapturedIfNeeded;
        }
        if (typeParameterDescriptor.getVariance() == $this$createCapturedIfNeeded.getProjectionKind()) {
            TypeProjection typeProjection;
            if ($this$createCapturedIfNeeded.isStarProjection()) {
                StorageManager storageManager = LockBasedStorageManager.NO_LOCKS;
                Intrinsics.checkNotNullExpressionValue(storageManager, "NO_LOCKS");
                TypeProjection typeProjection2 = $this$createCapturedIfNeeded;
                typeProjection = new TypeProjectionImpl(new LazyWrappedType(storageManager, new CapturedTypeConstructorKt$$Lambda$0(typeProjection2)));
            } else {
                typeProjection = new TypeProjectionImpl($this$createCapturedIfNeeded.getType());
            }
            return typeProjection;
        }
        return new TypeProjectionImpl(CapturedTypeConstructorKt.createCapturedType($this$createCapturedIfNeeded));
    }

    private static final KotlinType createCapturedIfNeeded$lambda$1(TypeProjection $this_createCapturedIfNeeded) {
        KotlinType kotlinType = $this_createCapturedIfNeeded.getType();
        Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
        return kotlinType;
    }

    public static final /* synthetic */ TypeProjection access$createCapturedIfNeeded(TypeProjection $receiver, TypeParameterDescriptor typeParameterDescriptor) {
        return CapturedTypeConstructorKt.createCapturedIfNeeded($receiver, typeParameterDescriptor);
    }

    static /* synthetic */ KotlinType accessor$CapturedTypeConstructorKt$lambda0(TypeProjection typeProjection) {
        return CapturedTypeConstructorKt.createCapturedIfNeeded$lambda$1(typeProjection);
    }
}

