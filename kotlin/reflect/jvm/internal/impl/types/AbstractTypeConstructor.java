/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$3;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$4;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$5;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$6;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$ModuleViewTypeConstructor$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nAbstractTypeConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractTypeConstructor.kt\norg/jetbrains/kotlin/types/AbstractTypeConstructor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,133:1\n1#2:134\n*E\n"})
public abstract class AbstractTypeConstructor
extends ClassifierBasedTypeConstructor {
    @NotNull
    private final NotNullLazyValue<Supertypes> supertypes;
    private final boolean shouldReportCyclicScopeWithCompanionWarning;

    public AbstractTypeConstructor(@NotNull StorageManager storageManager) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        AbstractTypeConstructor abstractTypeConstructor = this;
        AbstractTypeConstructor$$Lambda$0 abstractTypeConstructor$$Lambda$0 = new AbstractTypeConstructor$$Lambda$0(abstractTypeConstructor);
        abstractTypeConstructor = this;
        this.supertypes = storageManager.createLazyValueWithPostCompute(abstractTypeConstructor$$Lambda$0, AbstractTypeConstructor$$Lambda$1.INSTANCE, new AbstractTypeConstructor$$Lambda$2(abstractTypeConstructor));
    }

    @NotNull
    public List<KotlinType> getSupertypes() {
        return ((Supertypes)this.supertypes.invoke()).getSupertypesWithoutCycles();
    }

    @Override
    @NotNull
    public TypeConstructor refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new ModuleViewTypeConstructor(kotlinTypeRefiner);
    }

    /*
     * Enabled aggressive block sorting
     */
    private final Collection<KotlinType> computeNeighbours(TypeConstructor $this$computeNeighbours, boolean useCompanions) {
        Collection collection;
        Object object = $this$computeNeighbours instanceof AbstractTypeConstructor ? (AbstractTypeConstructor)$this$computeNeighbours : null;
        if (object != null) {
            AbstractTypeConstructor abstractClassifierDescriptor = object;
            boolean bl2 = false;
            List<KotlinType> list = CollectionsKt.plus(((Supertypes)abstractClassifierDescriptor.supertypes.invoke()).getAllSupertypes(), (Iterable)abstractClassifierDescriptor.getAdditionalNeighboursInSupertypeGraph(useCompanions));
            object = list;
            if (list != null) {
                collection = (Collection)object;
                return collection;
            }
        }
        Collection collection2 = $this$computeNeighbours.getSupertypes();
        collection = collection2;
        Intrinsics.checkNotNullExpressionValue(collection2, "getSupertypes(...)");
        return collection;
    }

    @NotNull
    protected abstract Collection<KotlinType> computeSupertypes();

    @NotNull
    protected abstract SupertypeLoopChecker getSupertypeLoopChecker();

    protected void reportSupertypeLoopError(@NotNull KotlinType type) {
        Intrinsics.checkNotNullParameter(type, "type");
    }

    @NotNull
    protected List<KotlinType> processSupertypesWithoutCycles(@NotNull List<KotlinType> supertypes) {
        Intrinsics.checkNotNullParameter(supertypes, "supertypes");
        return supertypes;
    }

    protected void reportScopesLoopError(@NotNull KotlinType type) {
        Intrinsics.checkNotNullParameter(type, "type");
    }

    protected boolean getShouldReportCyclicScopeWithCompanionWarning() {
        return this.shouldReportCyclicScopeWithCompanionWarning;
    }

    @NotNull
    protected Collection<KotlinType> getAdditionalNeighboursInSupertypeGraph(boolean useCompanions) {
        return CollectionsKt.emptyList();
    }

    @Nullable
    protected KotlinType defaultSupertypeIfEmpty() {
        return null;
    }

    private static final Supertypes supertypes$lambda$0(AbstractTypeConstructor this$0) {
        return new Supertypes(this$0.computeSupertypes());
    }

    private static final Supertypes supertypes$lambda$1(boolean it) {
        return new Supertypes((Collection<? extends KotlinType>)CollectionsKt.listOf(ErrorUtils.INSTANCE.getErrorTypeForLoopInSupertypes()));
    }

    private static final Iterable supertypes$lambda$7$lambda$2(AbstractTypeConstructor this$0, TypeConstructor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.computeNeighbours(it, false);
    }

    private static final Unit supertypes$lambda$7$lambda$3(AbstractTypeConstructor this$0, KotlinType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.reportSupertypeLoopError(it);
        return Unit.INSTANCE;
    }

    private static final Iterable supertypes$lambda$7$lambda$5(AbstractTypeConstructor this$0, TypeConstructor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.computeNeighbours(it, true);
    }

    private static final Unit supertypes$lambda$7$lambda$6(AbstractTypeConstructor this$0, KotlinType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.reportScopesLoopError(it);
        return Unit.INSTANCE;
    }

    private static final Unit supertypes$lambda$7(AbstractTypeConstructor this$0, Supertypes supertypes) {
        Collection collection;
        List list;
        Intrinsics.checkNotNullParameter(supertypes, "supertypes");
        AbstractTypeConstructor abstractTypeConstructor = this$0;
        AbstractTypeConstructor$$Lambda$3 abstractTypeConstructor$$Lambda$3 = new AbstractTypeConstructor$$Lambda$3(abstractTypeConstructor);
        abstractTypeConstructor = this$0;
        Collection resultWithoutCycles = this$0.getSupertypeLoopChecker().findLoopsInSupertypesAndDisconnect(this$0, supertypes.getAllSupertypes(), abstractTypeConstructor$$Lambda$3, new AbstractTypeConstructor$$Lambda$4(abstractTypeConstructor));
        if (resultWithoutCycles.isEmpty()) {
            List<KotlinType> list2;
            List<KotlinType> list3;
            KotlinType kotlinType = this$0.defaultSupertypeIfEmpty();
            if (kotlinType != null) {
                KotlinType it = kotlinType;
                boolean bl2 = false;
                list3 = CollectionsKt.listOf(it);
            } else {
                list3 = list2 = null;
            }
            if (list3 == null) {
                list2 = CollectionsKt.emptyList();
            }
            resultWithoutCycles = list2;
        }
        if (this$0.getShouldReportCyclicScopeWithCompanionWarning()) {
            abstractTypeConstructor = this$0;
            AbstractTypeConstructor$$Lambda$5 abstractTypeConstructor$$Lambda$5 = new AbstractTypeConstructor$$Lambda$5(abstractTypeConstructor);
            abstractTypeConstructor = this$0;
            this$0.getSupertypeLoopChecker().findLoopsInSupertypesAndDisconnect(this$0, resultWithoutCycles, abstractTypeConstructor$$Lambda$5, new AbstractTypeConstructor$$Lambda$6(abstractTypeConstructor));
        }
        if ((list = (collection = resultWithoutCycles) instanceof List ? (List)collection : null) == null) {
            list = CollectionsKt.toList(resultWithoutCycles);
        }
        supertypes.setSupertypesWithoutCycles(this$0.processSupertypesWithoutCycles(list));
        return Unit.INSTANCE;
    }

    static /* synthetic */ Supertypes accessor$AbstractTypeConstructor$lambda0(AbstractTypeConstructor abstractTypeConstructor) {
        return AbstractTypeConstructor.supertypes$lambda$0(abstractTypeConstructor);
    }

    static /* synthetic */ Supertypes accessor$AbstractTypeConstructor$lambda1(boolean bl2) {
        return AbstractTypeConstructor.supertypes$lambda$1(bl2);
    }

    static /* synthetic */ Unit accessor$AbstractTypeConstructor$lambda2(AbstractTypeConstructor abstractTypeConstructor, Supertypes supertypes) {
        return AbstractTypeConstructor.supertypes$lambda$7(abstractTypeConstructor, supertypes);
    }

    static /* synthetic */ Iterable accessor$AbstractTypeConstructor$lambda3(AbstractTypeConstructor abstractTypeConstructor, TypeConstructor typeConstructor2) {
        return AbstractTypeConstructor.supertypes$lambda$7$lambda$2(abstractTypeConstructor, typeConstructor2);
    }

    static /* synthetic */ Unit accessor$AbstractTypeConstructor$lambda4(AbstractTypeConstructor abstractTypeConstructor, KotlinType kotlinType) {
        return AbstractTypeConstructor.supertypes$lambda$7$lambda$3(abstractTypeConstructor, kotlinType);
    }

    static /* synthetic */ Iterable accessor$AbstractTypeConstructor$lambda5(AbstractTypeConstructor abstractTypeConstructor, TypeConstructor typeConstructor2) {
        return AbstractTypeConstructor.supertypes$lambda$7$lambda$5(abstractTypeConstructor, typeConstructor2);
    }

    static /* synthetic */ Unit accessor$AbstractTypeConstructor$lambda6(AbstractTypeConstructor abstractTypeConstructor, KotlinType kotlinType) {
        return AbstractTypeConstructor.supertypes$lambda$7$lambda$6(abstractTypeConstructor, kotlinType);
    }

    private final class ModuleViewTypeConstructor
    implements TypeConstructor {
        @NotNull
        private final KotlinTypeRefiner kotlinTypeRefiner;
        @NotNull
        private final Lazy refinedSupertypes$delegate;

        public ModuleViewTypeConstructor(KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            this.kotlinTypeRefiner = kotlinTypeRefiner;
            AbstractTypeConstructor abstractTypeConstructor = AbstractTypeConstructor.this;
            ModuleViewTypeConstructor moduleViewTypeConstructor = this;
            this.refinedSupertypes$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new AbstractTypeConstructor$ModuleViewTypeConstructor$$Lambda$0(moduleViewTypeConstructor, abstractTypeConstructor));
        }

        private final List<KotlinType> getRefinedSupertypes() {
            Lazy lazy = this.refinedSupertypes$delegate;
            return (List)lazy.getValue();
        }

        @Override
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> list = AbstractTypeConstructor.this.getParameters();
            Intrinsics.checkNotNullExpressionValue(list, "getParameters(...)");
            return list;
        }

        @NotNull
        public List<KotlinType> getSupertypes() {
            return this.getRefinedSupertypes();
        }

        @Override
        public boolean isDenotable() {
            return AbstractTypeConstructor.this.isDenotable();
        }

        @Override
        @NotNull
        public ClassifierDescriptor getDeclarationDescriptor() {
            return AbstractTypeConstructor.this.getDeclarationDescriptor();
        }

        @Override
        @NotNull
        public KotlinBuiltIns getBuiltIns() {
            KotlinBuiltIns kotlinBuiltIns = AbstractTypeConstructor.this.getBuiltIns();
            Intrinsics.checkNotNullExpressionValue(kotlinBuiltIns, "getBuiltIns(...)");
            return kotlinBuiltIns;
        }

        @Override
        @NotNull
        public TypeConstructor refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            return AbstractTypeConstructor.this.refine(kotlinTypeRefiner);
        }

        public boolean equals(@Nullable Object other) {
            return AbstractTypeConstructor.this.equals(other);
        }

        public int hashCode() {
            return AbstractTypeConstructor.this.hashCode();
        }

        @NotNull
        public String toString() {
            return AbstractTypeConstructor.this.toString();
        }

        private static final List refinedSupertypes_delegate$lambda$0(ModuleViewTypeConstructor this$0, AbstractTypeConstructor this$1) {
            return KotlinTypeRefinerKt.refineTypes(this$0.kotlinTypeRefiner, this$1.getSupertypes());
        }

        static /* synthetic */ List accessor$AbstractTypeConstructor$ModuleViewTypeConstructor$lambda0(ModuleViewTypeConstructor moduleViewTypeConstructor, AbstractTypeConstructor abstractTypeConstructor) {
            return ModuleViewTypeConstructor.refinedSupertypes_delegate$lambda$0(moduleViewTypeConstructor, abstractTypeConstructor);
        }
    }

    private static final class Supertypes {
        @NotNull
        private final Collection<KotlinType> allSupertypes;
        @NotNull
        private List<? extends KotlinType> supertypesWithoutCycles;

        public Supertypes(@NotNull Collection<? extends KotlinType> allSupertypes2) {
            Intrinsics.checkNotNullParameter(allSupertypes2, "allSupertypes");
            this.allSupertypes = allSupertypes2;
            this.supertypesWithoutCycles = CollectionsKt.listOf(ErrorUtils.INSTANCE.getErrorTypeForLoopInSupertypes());
        }

        @NotNull
        public final Collection<KotlinType> getAllSupertypes() {
            return this.allSupertypes;
        }

        @NotNull
        public final List<KotlinType> getSupertypesWithoutCycles() {
            return this.supertypesWithoutCycles;
        }

        public final void setSupertypesWithoutCycles(@NotNull List<? extends KotlinType> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.supertypesWithoutCycles = list;
        }
    }
}

