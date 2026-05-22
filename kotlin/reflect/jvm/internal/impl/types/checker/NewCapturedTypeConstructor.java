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
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor$$Lambda$3;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nNewCapturedType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NewCapturedType.kt\norg/jetbrains/kotlin/types/checker/NewCapturedTypeConstructor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,290:1\n1563#2:291\n1634#2,3:292\n*S KotlinDebug\n*F\n+ 1 NewCapturedType.kt\norg/jetbrains/kotlin/types/checker/NewCapturedTypeConstructor\n*L\n271#1:291\n271#1:292,3\n*E\n"})
public final class NewCapturedTypeConstructor
implements CapturedTypeConstructor {
    @NotNull
    private final TypeProjection projection;
    @Nullable
    private Function0<? extends List<? extends UnwrappedType>> supertypesComputation;
    @Nullable
    private final NewCapturedTypeConstructor original;
    @Nullable
    private final TypeParameterDescriptor typeParameter;
    @NotNull
    private final Lazy _supertypes$delegate;

    public NewCapturedTypeConstructor(@NotNull TypeProjection projection, @Nullable Function0<? extends List<? extends UnwrappedType>> supertypesComputation, @Nullable NewCapturedTypeConstructor original, @Nullable TypeParameterDescriptor typeParameter) {
        Intrinsics.checkNotNullParameter(projection, "projection");
        this.projection = projection;
        this.supertypesComputation = supertypesComputation;
        this.original = original;
        this.typeParameter = typeParameter;
        NewCapturedTypeConstructor newCapturedTypeConstructor = this;
        this._supertypes$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new NewCapturedTypeConstructor$$Lambda$0(newCapturedTypeConstructor));
    }

    public /* synthetic */ NewCapturedTypeConstructor(TypeProjection typeProjection, Function0 function0, NewCapturedTypeConstructor newCapturedTypeConstructor, TypeParameterDescriptor typeParameterDescriptor, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            function0 = null;
        }
        if ((n2 & 4) != 0) {
            newCapturedTypeConstructor = null;
        }
        if ((n2 & 8) != 0) {
            typeParameterDescriptor = null;
        }
        this(typeProjection, function0, newCapturedTypeConstructor, typeParameterDescriptor);
    }

    @Override
    @NotNull
    public TypeProjection getProjection() {
        return this.projection;
    }

    public NewCapturedTypeConstructor(@NotNull TypeProjection projection, @NotNull List<? extends UnwrappedType> supertypes, @Nullable NewCapturedTypeConstructor original) {
        Intrinsics.checkNotNullParameter(projection, "projection");
        Intrinsics.checkNotNullParameter(supertypes, "supertypes");
        List<? extends UnwrappedType> list = supertypes;
        this(projection, new NewCapturedTypeConstructor$$Lambda$1(list), original, null, 8, null);
    }

    public /* synthetic */ NewCapturedTypeConstructor(TypeProjection typeProjection, List list, NewCapturedTypeConstructor newCapturedTypeConstructor, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 4) != 0) {
            newCapturedTypeConstructor = null;
        }
        this(typeProjection, list, newCapturedTypeConstructor);
    }

    private final List<UnwrappedType> get_supertypes() {
        Lazy lazy = this._supertypes$delegate;
        return (List)lazy.getValue();
    }

    public final void initializeSupertypes(@NotNull List<? extends UnwrappedType> supertypes) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(supertypes, "supertypes");
        boolean bl3 = bl2 = this.supertypesComputation == null;
        if (_Assertions.ENABLED && !bl2) {
            boolean bl4 = false;
            String string = "Already initialized! oldValue = " + this.supertypesComputation + ", newValue = " + supertypes;
            throw new AssertionError((Object)string);
        }
        List<? extends UnwrappedType> list = supertypes;
        this.supertypesComputation = new NewCapturedTypeConstructor$$Lambda$2(list);
    }

    @NotNull
    public List<UnwrappedType> getSupertypes() {
        List<UnwrappedType> list = this.get_supertypes();
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return list;
    }

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getParameters() {
        return CollectionsKt.emptyList();
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
        KotlinType kotlinType = this.getProjection().getType();
        Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
        return TypeUtilsKt.getBuiltIns(kotlinType);
    }

    @Override
    @NotNull
    public NewCapturedTypeConstructor refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        NewCapturedTypeConstructor newCapturedTypeConstructor;
        NewCapturedTypeConstructor$$Lambda$3 newCapturedTypeConstructor$$Lambda$3;
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        TypeProjection typeProjection = this.getProjection().refine(kotlinTypeRefiner);
        TypeProjection typeProjection2 = typeProjection;
        Intrinsics.checkNotNullExpressionValue(typeProjection, "refine(...)");
        Function0<? extends List<? extends UnwrappedType>> function0 = this.supertypesComputation;
        if (function0 != null) {
            Function0<? extends List<? extends UnwrappedType>> function02 = function0;
            TypeProjection typeProjection3 = typeProjection2;
            boolean bl2 = false;
            KotlinTypeRefiner kotlinTypeRefiner2 = kotlinTypeRefiner;
            NewCapturedTypeConstructor newCapturedTypeConstructor2 = this;
            newCapturedTypeConstructor$$Lambda$3 = new NewCapturedTypeConstructor$$Lambda$3(newCapturedTypeConstructor2, kotlinTypeRefiner2);
            typeProjection2 = typeProjection3;
        } else {
            newCapturedTypeConstructor$$Lambda$3 = null;
        }
        if ((newCapturedTypeConstructor = this.original) == null) {
            newCapturedTypeConstructor = this;
        }
        TypeParameterDescriptor typeParameterDescriptor = this.typeParameter;
        NewCapturedTypeConstructor newCapturedTypeConstructor3 = newCapturedTypeConstructor;
        NewCapturedTypeConstructor$$Lambda$3 newCapturedTypeConstructor$$Lambda$32 = newCapturedTypeConstructor$$Lambda$3;
        TypeProjection typeProjection4 = typeProjection2;
        return new NewCapturedTypeConstructor(typeProjection4, newCapturedTypeConstructor$$Lambda$32, newCapturedTypeConstructor3, typeParameterDescriptor);
    }

    public boolean equals(@Nullable Object other) {
        Object object;
        if (this == other) {
            return true;
        }
        Object object2 = other;
        if (!Intrinsics.areEqual(this.getClass(), object2 != null ? object2.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
        NewCapturedTypeConstructor cfr_ignored_0 = (NewCapturedTypeConstructor)other;
        NewCapturedTypeConstructor newCapturedTypeConstructor = this.original;
        if (newCapturedTypeConstructor == null) {
            newCapturedTypeConstructor = this;
        }
        if ((object = ((NewCapturedTypeConstructor)other).original) == null) {
            object = other;
        }
        return newCapturedTypeConstructor == object;
    }

    public int hashCode() {
        NewCapturedTypeConstructor newCapturedTypeConstructor = this.original;
        return newCapturedTypeConstructor != null ? newCapturedTypeConstructor.hashCode() : super.hashCode();
    }

    @NotNull
    public String toString() {
        return "CapturedType(" + this.getProjection() + ')';
    }

    private static final List _init_$lambda$0(List $supertypes) {
        return $supertypes;
    }

    private static final List _supertypes_delegate$lambda$1(NewCapturedTypeConstructor this$0) {
        Function0<? extends List<? extends UnwrappedType>> function0 = this$0.supertypesComputation;
        return function0 != null ? function0.invoke() : null;
    }

    private static final List initializeSupertypes$lambda$3(List $supertypes) {
        return $supertypes;
    }

    /*
     * WARNING - void declaration
     */
    private static final List refine$lambda$6$lambda$5(NewCapturedTypeConstructor this$0, KotlinTypeRefiner $kotlinTypeRefiner) {
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv = this$0.getSupertypes();
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            UnwrappedType unwrappedType = (UnwrappedType)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(it.refine($kotlinTypeRefiner));
        }
        return (List)destination$iv$iv;
    }

    static /* synthetic */ List accessor$NewCapturedTypeConstructor$lambda0(NewCapturedTypeConstructor newCapturedTypeConstructor) {
        return NewCapturedTypeConstructor._supertypes_delegate$lambda$1(newCapturedTypeConstructor);
    }

    static /* synthetic */ List accessor$NewCapturedTypeConstructor$lambda1(List list) {
        return NewCapturedTypeConstructor._init_$lambda$0(list);
    }

    static /* synthetic */ List accessor$NewCapturedTypeConstructor$lambda2(List list) {
        return NewCapturedTypeConstructor.initializeSupertypes$lambda$3(list);
    }

    static /* synthetic */ List accessor$NewCapturedTypeConstructor$lambda3(NewCapturedTypeConstructor newCapturedTypeConstructor, KotlinTypeRefiner kotlinTypeRefiner) {
        return NewCapturedTypeConstructor.refine$lambda$6$lambda$5(newCapturedTypeConstructor, kotlinTypeRefiner);
    }
}

