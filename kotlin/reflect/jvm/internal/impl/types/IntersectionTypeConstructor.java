/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nIntersectionTypeConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntersectionTypeConstructor.kt\norg/jetbrains/kotlin/types/IntersectionTypeConstructor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 IntersectionTypeConstructor.kt\norg/jetbrains/kotlin/types/IntersectionTypeConstructorKt\n+ 5 IntersectionTypeConstructor.kt\norg/jetbrains/kotlin/types/IntersectionTypeConstructorKt$transformComponents$1\n*L\n1#1,120:1\n1#2:121\n1056#3:122\n1563#3:129\n1634#3,2:130\n1636#3:139\n98#4,6:123\n104#4:132\n105#4,5:134\n112#4,7:140\n99#5:133\n*S KotlinDebug\n*F\n+ 1 IntersectionTypeConstructor.kt\norg/jetbrains/kotlin/types/IntersectionTypeConstructor\n*L\n66#1:122\n89#1:129\n89#1:130,2\n89#1:139\n89#1:123,6\n89#1:132\n89#1:134,5\n89#1:140,7\n89#1:133\n*E\n"})
public final class IntersectionTypeConstructor
implements TypeConstructor,
IntersectionTypeConstructorMarker {
    @Nullable
    private KotlinType alternative;
    @NotNull
    private final LinkedHashSet<KotlinType> intersectedTypes;
    private final int hashCode;

    public IntersectionTypeConstructor(@NotNull Collection<? extends KotlinType> typesToIntersect) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(typesToIntersect, "typesToIntersect");
        boolean bl3 = bl2 = !typesToIntersect.isEmpty();
        if (_Assertions.ENABLED && !bl2) {
            boolean bl4 = false;
            String string = "Attempt to create an empty intersection";
            throw new AssertionError((Object)string);
        }
        this.intersectedTypes = new LinkedHashSet<KotlinType>(typesToIntersect);
        this.hashCode = this.intersectedTypes.hashCode();
    }

    private IntersectionTypeConstructor(Collection<? extends KotlinType> typesToIntersect, KotlinType alternative) {
        this(typesToIntersect);
        this.alternative = alternative;
    }

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getParameters() {
        return CollectionsKt.emptyList();
    }

    @Override
    @NotNull
    public Collection<KotlinType> getSupertypes() {
        return this.intersectedTypes;
    }

    @NotNull
    public final MemberScope createScopeForKotlinType() {
        return TypeIntersectionScope.Companion.create("member scope for intersection type", (Collection<? extends KotlinType>)this.intersectedTypes);
    }

    @Override
    public boolean isDenotable() {
        return false;
    }

    @Override
    @Nullable
    public ClassifierDescriptor getDeclarationDescriptor() {
        return null;
    }

    @Override
    @NotNull
    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns kotlinBuiltIns = ((KotlinType)this.intersectedTypes.iterator().next()).getConstructor().getBuiltIns();
        Intrinsics.checkNotNullExpressionValue(kotlinBuiltIns, "getBuiltIns(...)");
        return kotlinBuiltIns;
    }

    @NotNull
    public String toString() {
        return IntersectionTypeConstructor.makeDebugNameForIntersectionType$default(this, null, 1, null);
    }

    @NotNull
    public final String makeDebugNameForIntersectionType(@NotNull Function1<? super KotlinType, ? extends Object> getProperTypeRelatedToStringify) {
        Intrinsics.checkNotNullParameter(getProperTypeRelatedToStringify, "getProperTypeRelatedToStringify");
        Iterable $this$sortedBy$iv = this.intersectedTypes;
        boolean $i$f$sortedBy = false;
        Function1<? super KotlinType, ? extends Object> function1 = getProperTypeRelatedToStringify;
        return CollectionsKt.joinToString$default(CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(getProperTypeRelatedToStringify){
            final /* synthetic */ Function1 $getProperTypeRelatedToStringify$inlined;
            {
                this.$getProperTypeRelatedToStringify$inlined = function1;
            }

            public final int compare(T a2, T b2) {
                KotlinType it = (KotlinType)a2;
                boolean bl2 = false;
                Intrinsics.checkNotNull(it);
                Comparable comparable = (Comparable)((Object)this.$getProperTypeRelatedToStringify$inlined.invoke(it).toString());
                it = (KotlinType)b2;
                Comparable comparable2 = comparable;
                bl2 = false;
                Intrinsics.checkNotNull(it);
                return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)this.$getProperTypeRelatedToStringify$inlined.invoke(it).toString()));
            }
        }), " & ", "{", "}", 0, null, new IntersectionTypeConstructor$$Lambda$0(function1), 24, null);
    }

    public static /* synthetic */ String makeDebugNameForIntersectionType$default(IntersectionTypeConstructor intersectionTypeConstructor, Function1 function1, int n2, Object object) {
        if ((n2 & 1) != 0) {
            function1 = IntersectionTypeConstructor$$Lambda$1.INSTANCE;
        }
        return intersectionTypeConstructor.makeDebugNameForIntersectionType(function1);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IntersectionTypeConstructor)) {
            return false;
        }
        return Intrinsics.areEqual(this.intersectedTypes, ((IntersectionTypeConstructor)other).intersectedTypes);
    }

    @NotNull
    public final SimpleType createType() {
        IntersectionTypeConstructor intersectionTypeConstructor = this;
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(TypeAttributes.Companion.getEmpty(), this, CollectionsKt.emptyList(), false, this.createScopeForKotlinType(), new IntersectionTypeConstructor$$Lambda$2(intersectionTypeConstructor));
    }

    public int hashCode() {
        return this.hashCode;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public IntersectionTypeConstructor refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        IntersectionTypeConstructor intersectionTypeConstructor;
        IntersectionTypeConstructor intersectionTypeConstructor2;
        boolean bl2;
        KotlinType it;
        boolean bl3;
        void $this$mapTo$iv$iv$iv;
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        IntersectionTypeConstructor $this$transformComponents_u24default$iv = this;
        boolean $i$f$transformComponents = false;
        boolean changed$iv = false;
        Iterable $this$map$iv$iv = $this$transformComponents_u24default$iv.getSupertypes();
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv$iv;
        Collection destination$iv$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv$iv : $this$mapTo$iv$iv$iv) {
            KotlinType kotlinType;
            void it$iv;
            KotlinType kotlinType2 = (KotlinType)item$iv$iv$iv;
            Collection collection = destination$iv$iv$iv;
            boolean bl4 = false;
            void var15_15 = it$iv;
            bl3 = false;
            it = var15_15;
            if (true) {
                changed$iv = true;
                it = it$iv;
                bl2 = false;
                kotlinType = it.refine(kotlinTypeRefiner);
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
                boolean bl5 = false;
                it = alternative$iv;
                bl3 = false;
                if (true) {
                    it = alternative$iv;
                    bl2 = false;
                    kotlinType = it.refine(kotlinTypeRefiner);
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
            intersectionTypeConstructor = this;
        }
        return intersectionTypeConstructor;
    }

    @NotNull
    public final IntersectionTypeConstructor setAlternative(@Nullable KotlinType alternative) {
        return new IntersectionTypeConstructor((Collection<? extends KotlinType>)this.intersectedTypes, alternative);
    }

    @Nullable
    public final KotlinType getAlternativeType() {
        return this.alternative;
    }

    private static final String makeDebugNameForIntersectionType$lambda$1(KotlinType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.toString();
    }

    private static final CharSequence makeDebugNameForIntersectionType$lambda$3(Function1 $getProperTypeRelatedToStringify, KotlinType it) {
        Intrinsics.checkNotNull(it);
        return $getProperTypeRelatedToStringify.invoke(it).toString();
    }

    private static final SimpleType createType$lambda$4(IntersectionTypeConstructor this$0, KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this$0.refine(kotlinTypeRefiner).createType();
    }

    static /* synthetic */ CharSequence accessor$IntersectionTypeConstructor$lambda0(Function1 function1, KotlinType kotlinType) {
        return IntersectionTypeConstructor.makeDebugNameForIntersectionType$lambda$3(function1, kotlinType);
    }

    static /* synthetic */ String accessor$IntersectionTypeConstructor$lambda1(KotlinType kotlinType) {
        return IntersectionTypeConstructor.makeDebugNameForIntersectionType$lambda$1(kotlinType);
    }

    static /* synthetic */ SimpleType accessor$IntersectionTypeConstructor$lambda2(IntersectionTypeConstructor intersectionTypeConstructor, KotlinTypeRefiner kotlinTypeRefiner) {
        return IntersectionTypeConstructor.createType$lambda$4(intersectionTypeConstructor, kotlinTypeRefiner);
    }
}

