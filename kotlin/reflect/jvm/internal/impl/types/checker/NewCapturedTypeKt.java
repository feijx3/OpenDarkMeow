/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nNewCapturedType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NewCapturedType.kt\norg/jetbrains/kotlin/types/checker/NewCapturedTypeKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,290:1\n1#2:291\n1#2:310\n1669#3,8:292\n1617#3,9:300\n1869#3:309\n1870#3:311\n1626#3:312\n1740#3,3:313\n1563#3:316\n1634#3,3:317\n1634#3,3:320\n1563#3:323\n1634#3,3:324\n*S KotlinDebug\n*F\n+ 1 NewCapturedType.kt\norg/jetbrains/kotlin/types/checker/NewCapturedTypeKt\n*L\n122#1:310\n117#1:292,8\n122#1:300,9\n122#1:309\n122#1:311\n122#1:312\n154#1:313,3\n156#1:316\n156#1:317,3\n176#1:320,3\n81#1:323\n81#1:324,3\n*E\n"})
public final class NewCapturedTypeKt {
    @Nullable
    public static final SimpleType captureFromArguments(@NotNull SimpleType type, @NotNull CaptureStatus status) {
        SimpleType simpleType;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter((Object)status, "status");
        List<TypeProjection> list = NewCapturedTypeKt.captureArguments(type, status);
        if (list != null) {
            List<TypeProjection> it = list;
            boolean bl2 = false;
            simpleType = NewCapturedTypeKt.replaceArguments(type, it);
        } else {
            simpleType = null;
        }
        return simpleType;
    }

    private static final SimpleType replaceArguments(UnwrappedType $this$replaceArguments, List<? extends TypeProjection> arguments) {
        return KotlinTypeFactory.simpleType$default($this$replaceArguments.getAttributes(), $this$replaceArguments.getConstructor(), arguments, $this$replaceArguments.isMarkedNullable(), null, 16, null);
    }

    /*
     * WARNING - void declaration
     */
    private static final List<TypeProjection> captureArguments(UnwrappedType type, CaptureStatus status) {
        KotlinType lowerType;
        Collection collection;
        Object object;
        void $this$mapTo$iv$iv;
        Object element$iv2;
        boolean bl2;
        List<TypeProjection> arguments;
        block11: {
            if (type.getArguments().size() != type.getConstructor().getParameters().size()) {
                return null;
            }
            arguments = type.getArguments();
            Iterable $this$all$iv = arguments;
            boolean $i$f$all = false;
            if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                bl2 = true;
            } else {
                for (Object element$iv2 : $this$all$iv) {
                    TypeProjection it = (TypeProjection)element$iv2;
                    boolean bl3 = false;
                    if (it.getProjectionKind() == Variance.INVARIANT) continue;
                    bl2 = false;
                    break block11;
                }
                bl2 = true;
            }
        }
        if (bl2) {
            return null;
        }
        Iterable iterable = arguments;
        List<TypeParameterDescriptor> list = type.getConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(list, "getParameters(...)");
        Iterable $this$map$iv = CollectionsKt.zip(iterable, (Iterable)list);
        boolean $i$f$map = false;
        element$iv2 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            TypeProjection typeProjection;
            object = (Pair)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl4 = false;
            TypeProjection projection = (TypeProjection)((Pair)object).component1();
            TypeParameterDescriptor parameter = (TypeParameterDescriptor)((Pair)object).component2();
            if (projection.getProjectionKind() == Variance.INVARIANT) {
                typeProjection = projection;
            } else {
                lowerType = !projection.isStarProjection() && projection.getProjectionKind() == Variance.IN_VARIANCE ? projection.getType().unwrap() : null;
                Intrinsics.checkNotNull(parameter);
                typeProjection = TypeUtilsKt.asTypeProjection(new NewCapturedType(status, (UnwrappedType)lowerType, projection, parameter));
            }
            collection.add(typeProjection);
        }
        List capturedArguments = (List)destination$iv$iv;
        TypeSubstitutor substitutor = TypeConstructorSubstitution.Companion.create(type.getConstructor(), capturedArguments).buildSubstitutor();
        int n2 = ((Collection)arguments).size();
        for (int index = 0; index < n2; ++index) {
            void destination$iv;
            void $this$mapTo$iv;
            Object item$iv$iv;
            TypeProjection oldProjection = arguments.get(index);
            TypeProjection newProjection = (TypeProjection)capturedArguments.get(index);
            if (oldProjection.getProjectionKind() == Variance.INVARIANT) continue;
            List<KotlinType> list2 = type.getConstructor().getParameters().get(index).getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(list2, "getUpperBounds(...)");
            item$iv$iv = list2;
            object = new ArrayList();
            boolean $i$f$mapTo2 = false;
            for (Object item$iv : $this$mapTo$iv) {
                void it;
                lowerType = (KotlinType)item$iv;
                collection = destination$iv;
                boolean bl5 = false;
                collection.add(KotlinTypePreparator.Default.INSTANCE.prepareType(substitutor.safeSubstitute((KotlinType)it, Variance.INVARIANT).unwrap()));
            }
            List capturedTypeSupertypes = (List)destination$iv;
            if (!oldProjection.isStarProjection() && oldProjection.getProjectionKind() == Variance.OUT_VARIANCE) {
                ((Collection)capturedTypeSupertypes).add(KotlinTypePreparator.Default.INSTANCE.prepareType(oldProjection.getType().unwrap()));
            }
            KotlinType kotlinType = newProjection.getType();
            Intrinsics.checkNotNull(kotlinType, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedType");
            NewCapturedType capturedType = (NewCapturedType)kotlinType;
            capturedType.getConstructor().initializeSupertypes(capturedTypeSupertypes);
        }
        return capturedArguments;
    }
}

