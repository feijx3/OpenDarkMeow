/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nKotlinTypePreparator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KotlinTypePreparator.kt\norg/jetbrains/kotlin/types/checker/KotlinTypePreparator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 IntersectionTypeConstructor.kt\norg/jetbrains/kotlin/types/IntersectionTypeConstructorKt\n+ 5 IntersectionTypeConstructor.kt\norg/jetbrains/kotlin/types/IntersectionTypeConstructorKt$transformComponents$1\n*L\n1#1,76:1\n1#2:77\n1563#3:78\n1634#3,3:79\n1563#3:82\n1634#3,3:83\n1563#3:92\n1634#3,2:93\n1636#3:102\n98#4,6:86\n104#4:95\n105#4,5:97\n112#4,7:103\n99#5:96\n*S KotlinDebug\n*F\n+ 1 KotlinTypePreparator.kt\norg/jetbrains/kotlin/types/checker/KotlinTypePreparator\n*L\n27#1:78\n27#1:79,3\n37#1:82\n37#1:83,3\n48#1:92\n48#1:93,2\n48#1:102\n48#1:86,6\n48#1:95\n48#1:97,5\n48#1:103,7\n48#1:96\n*E\n"})
public abstract class KotlinTypePreparator
extends AbstractTypePreparator {
    /*
     * WARNING - void declaration
     */
    private final SimpleType transformToNewType(SimpleType type) {
        TypeConstructor constructor = type.getConstructor();
        if (constructor instanceof CapturedTypeConstructorImpl) {
            UnwrappedType lowerType;
            TypeProjection typeProjection;
            TypeProjection it = typeProjection = ((CapturedTypeConstructorImpl)constructor).getProjection();
            boolean bl2 = false;
            Object object = it.getProjectionKind() == Variance.IN_VARIANCE ? typeProjection : null;
            UnwrappedType unwrappedType = object != null && (object = object.getType()) != null ? ((KotlinType)object).unwrap() : (lowerType = null);
            if (((CapturedTypeConstructorImpl)constructor).getNewTypeConstructor() == null) {
                Collection<UnwrappedType> collection;
                void $this$mapTo$iv$iv;
                void $this$map$iv;
                Iterable iterable = ((CapturedTypeConstructorImpl)constructor).getSupertypes();
                TypeProjection typeProjection2 = ((CapturedTypeConstructorImpl)constructor).getProjection();
                CapturedTypeConstructorImpl capturedTypeConstructorImpl = (CapturedTypeConstructorImpl)constructor;
                boolean $i$f$map = false;
                it = $this$map$iv;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                boolean $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    void it2;
                    KotlinType kotlinType = (KotlinType)item$iv$iv;
                    collection = destination$iv$iv;
                    boolean bl3 = false;
                    collection.add(it2.unwrap());
                }
                collection = (List)destination$iv$iv;
                DefaultConstructorMarker defaultConstructorMarker = null;
                int n2 = 4;
                NewCapturedTypeConstructor newCapturedTypeConstructor = null;
                List list = collection;
                TypeProjection typeProjection3 = typeProjection2;
                capturedTypeConstructorImpl.setNewTypeConstructor(new NewCapturedTypeConstructor(typeProjection3, list, newCapturedTypeConstructor, n2, defaultConstructorMarker));
            }
            NewCapturedTypeConstructor newCapturedTypeConstructor = ((CapturedTypeConstructorImpl)constructor).getNewTypeConstructor();
            Intrinsics.checkNotNull(newCapturedTypeConstructor);
            return new NewCapturedType(CaptureStatus.FOR_SUBTYPING, newCapturedTypeConstructor, lowerType, type.getAttributes(), type.isMarkedNullable(), false, 32, null);
        }
        if (constructor instanceof IntegerValueTypeConstructor) {
            Iterable $this$map$iv = ((IntegerValueTypeConstructor)constructor).getSupertypes();
            boolean $i$f$map = false;
            Iterable $this$mapTo$iv$iv = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                KotlinType it2 = (KotlinType)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl4 = false;
                KotlinType kotlinType = TypeUtils.makeNullableAsSpecified(it2, type.isMarkedNullable());
                Intrinsics.checkNotNullExpressionValue(kotlinType, "makeNullableAsSpecified(...)");
                collection.add(kotlinType);
            }
            Collection collection = (List)destination$iv$iv;
            IntersectionTypeConstructor newConstructor = new IntersectionTypeConstructor(collection);
            return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(type.getAttributes(), newConstructor, CollectionsKt.emptyList(), false, type.getMemberScope());
        }
        if (constructor instanceof IntersectionTypeConstructor && type.isMarkedNullable()) {
            IntersectionTypeConstructor intersectionTypeConstructor;
            IntersectionTypeConstructor intersectionTypeConstructor2;
            boolean bl5;
            KotlinType it;
            boolean bl6;
            void $this$mapTo$iv$iv$iv;
            IntersectionTypeConstructor $this$transformComponents_u24default$iv = (IntersectionTypeConstructor)constructor;
            boolean $i$f$transformComponents = false;
            boolean changed$iv = false;
            Iterable $this$map$iv$iv = $this$transformComponents_u24default$iv.getSupertypes();
            boolean $i$f$map = false;
            Iterable it3 = $this$map$iv$iv;
            Collection destination$iv$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv$iv : $this$mapTo$iv$iv$iv) {
                KotlinType kotlinType;
                void it$iv;
                KotlinType kotlinType2 = (KotlinType)item$iv$iv$iv;
                Collection collection = destination$iv$iv$iv;
                boolean bl7 = false;
                void var19_49 = it$iv;
                bl6 = false;
                it = var19_49;
                if (true) {
                    changed$iv = true;
                    it = it$iv;
                    bl5 = false;
                    kotlinType = TypeUtilsKt.makeNullable(it);
                } else {
                    kotlinType = it$iv;
                }
                collection.add(kotlinType);
            }
            List newSupertypes$iv = (List)destination$iv$iv$iv;
            if (!changed$iv) {
                intersectionTypeConstructor2 = null;
            } else {
                KotlinType kotlinType;
                KotlinType kotlinType3 = $this$transformComponents_u24default$iv.getAlternativeType();
                if (kotlinType3 != null) {
                    KotlinType alternative$iv = kotlinType3;
                    boolean bl8 = false;
                    it = alternative$iv;
                    bl6 = false;
                    if (true) {
                        it = alternative$iv;
                        bl5 = false;
                        kotlinType = TypeUtilsKt.makeNullable(it);
                    } else {
                        kotlinType = alternative$iv;
                    }
                } else {
                    kotlinType = null;
                }
                KotlinType updatedAlternative$iv = kotlinType;
                intersectionTypeConstructor2 = intersectionTypeConstructor = new IntersectionTypeConstructor(newSupertypes$iv).setAlternative(updatedAlternative$iv);
            }
            if (intersectionTypeConstructor2 == null) {
                intersectionTypeConstructor = (IntersectionTypeConstructor)constructor;
            }
            IntersectionTypeConstructor newConstructor = intersectionTypeConstructor;
            return newConstructor.createType();
        }
        return type;
    }

    @Override
    @NotNull
    public UnwrappedType prepareType(@NotNull KotlinTypeMarker type) {
        UnwrappedType unwrappedType;
        Intrinsics.checkNotNullParameter(type, "type");
        if (!(type instanceof KotlinType)) {
            String string = "Failed requirement.";
            throw new IllegalArgumentException(string.toString());
        }
        UnwrappedType unwrappedType2 = ((KotlinType)type).unwrap();
        UnwrappedType unwrappedType3 = unwrappedType2;
        if (unwrappedType3 instanceof SimpleType) {
            unwrappedType = this.transformToNewType((SimpleType)unwrappedType2);
        } else if (unwrappedType3 instanceof FlexibleType) {
            SimpleType newLower = this.transformToNewType(((FlexibleType)unwrappedType2).getLowerBound());
            SimpleType newUpper = this.transformToNewType(((FlexibleType)unwrappedType2).getUpperBound());
            unwrappedType = newLower != ((FlexibleType)unwrappedType2).getLowerBound() || newUpper != ((FlexibleType)unwrappedType2).getUpperBound() ? KotlinTypeFactory.flexibleType(newLower, newUpper) : unwrappedType2;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return TypeWithEnhancementKt.inheritEnhancement(unwrappedType, unwrappedType2, (Function1<? super KotlinType, ? extends KotlinType>)new Function1<KotlinTypeMarker, UnwrappedType>((Object)this){

            public final UnwrappedType invoke(KotlinTypeMarker p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                return ((KotlinTypePreparator)this.receiver).prepareType(p0);
            }
        });
    }

    public static final class Default
    extends KotlinTypePreparator {
        @NotNull
        public static final Default INSTANCE = new Default();

        private Default() {
        }
    }
}

