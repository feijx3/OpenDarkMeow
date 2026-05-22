/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.ClassDeclaredMemberIndex;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$$Lambda$3;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$$Lambda$4;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticScope;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nLazyJavaStaticClassScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyJavaStaticClassScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaStaticClassScope\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,171:1\n1491#2:172\n1516#2,3:173\n1519#2,3:183\n1563#2:192\n1634#2,3:193\n382#3,7:176\n77#4:186\n97#4,5:187\n*S KotlinDebug\n*F\n+ 1 LazyJavaStaticClassScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaStaticClassScope\n*L\n112#1:172\n112#1:173,3\n112#1:183,3\n168#1:192\n168#1:193,3\n112#1:176,7\n114#1:186\n114#1:187,5\n*E\n"})
public final class LazyJavaStaticClassScope
extends LazyJavaStaticScope {
    @NotNull
    private final JavaClass jClass;
    @NotNull
    private final JavaClassDescriptor ownerDescriptor;

    public LazyJavaStaticClassScope(@NotNull LazyJavaResolverContext c2, @NotNull JavaClass jClass, @NotNull JavaClassDescriptor ownerDescriptor) {
        Intrinsics.checkNotNullParameter(c2, "c");
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        Intrinsics.checkNotNullParameter(ownerDescriptor, "ownerDescriptor");
        super(c2);
        this.jClass = jClass;
        this.ownerDescriptor = ownerDescriptor;
    }

    @Override
    @NotNull
    protected JavaClassDescriptor getOwnerDescriptor() {
        return this.ownerDescriptor;
    }

    @Override
    @NotNull
    protected ClassDeclaredMemberIndex computeMemberIndex() {
        return new ClassDeclaredMemberIndex(this.jClass, LazyJavaStaticClassScope$$Lambda$0.INSTANCE);
    }

    @Override
    @NotNull
    protected Set<Name> computeFunctionNames(@NotNull DescriptorKindFilter kindFilter, @Nullable Function1<? super Name, Boolean> nameFilter) {
        Set<Name> set;
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Set<Name> $this$computeFunctionNames_u24lambda_u241 = set = CollectionsKt.toMutableSet((Iterable)((DeclaredMemberIndex)this.getDeclaredMemberIndex().invoke()).getMethodNames());
        boolean bl2 = false;
        LazyJavaStaticClassScope lazyJavaStaticClassScope = UtilKt.getParentJavaStaticClassScope(this.getOwnerDescriptor());
        Set<Name> set2 = lazyJavaStaticClassScope != null ? lazyJavaStaticClassScope.getFunctionNames() : null;
        if (set2 == null) {
            set2 = SetsKt.emptySet();
        }
        $this$computeFunctionNames_u24lambda_u241.addAll((Collection)set2);
        if (this.jClass.isEnum()) {
            Name[] nameArray = new Name[]{StandardNames.ENUM_VALUE_OF, StandardNames.ENUM_VALUES};
            $this$computeFunctionNames_u24lambda_u241.addAll((Collection)CollectionsKt.listOf(nameArray));
        }
        $this$computeFunctionNames_u24lambda_u241.addAll((Collection)this.getC().getComponents().getSyntheticPartsProvider().getStaticFunctionNames(this.getOwnerDescriptor(), this.getC()));
        return set;
    }

    @Override
    @NotNull
    protected Set<Name> computePropertyNames(@NotNull DescriptorKindFilter kindFilter, @Nullable Function1<? super Name, Boolean> nameFilter) {
        Set<Name> set;
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Set<Name> $this$computePropertyNames_u24lambda_u243 = set = CollectionsKt.toMutableSet((Iterable)((DeclaredMemberIndex)this.getDeclaredMemberIndex().invoke()).getFieldNames());
        boolean bl2 = false;
        this.flatMapJavaStaticSupertypesScopes(this.getOwnerDescriptor(), $this$computePropertyNames_u24lambda_u243, LazyJavaStaticClassScope$$Lambda$1.INSTANCE);
        if (this.jClass.isEnum()) {
            $this$computePropertyNames_u24lambda_u243.add(StandardNames.ENUM_ENTRIES);
        }
        return set;
    }

    @Override
    @NotNull
    protected Set<Name> computeClassNames(@NotNull DescriptorKindFilter kindFilter, @Nullable Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        return SetsKt.emptySet();
    }

    @Override
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        return null;
    }

    @Override
    protected void computeNonDeclaredFunctions(@NotNull Collection<SimpleFunctionDescriptor> result, @NotNull Name name) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(name, "name");
        Set<SimpleFunctionDescriptor> functionsFromSupertypes = this.getStaticFunctionsFromJavaSuperClasses(name, this.getOwnerDescriptor());
        Collection<SimpleFunctionDescriptor> collection = DescriptorResolverUtils.resolveOverridesForStaticMembers(name, (Collection)functionsFromSupertypes, result, this.getOwnerDescriptor(), this.getC().getComponents().getErrorReporter(), this.getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(collection, "resolveOverridesForStaticMembers(...)");
        result.addAll(collection);
        if (this.jClass.isEnum()) {
            Name name2 = name;
            if (Intrinsics.areEqual(name2, StandardNames.ENUM_VALUE_OF)) {
                SimpleFunctionDescriptor simpleFunctionDescriptor = DescriptorFactory.createEnumValueOfMethod(this.getOwnerDescriptor());
                Intrinsics.checkNotNullExpressionValue(simpleFunctionDescriptor, "createEnumValueOfMethod(...)");
                result.add(simpleFunctionDescriptor);
            } else if (Intrinsics.areEqual(name2, StandardNames.ENUM_VALUES)) {
                SimpleFunctionDescriptor simpleFunctionDescriptor = DescriptorFactory.createEnumValuesMethod(this.getOwnerDescriptor());
                Intrinsics.checkNotNullExpressionValue(simpleFunctionDescriptor, "createEnumValuesMethod(...)");
                result.add(simpleFunctionDescriptor);
            }
        }
    }

    @Override
    protected void computeImplicitlyDeclaredFunctions(@NotNull Collection<SimpleFunctionDescriptor> result, @NotNull Name name) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(name, "name");
        this.getC().getComponents().getSyntheticPartsProvider().generateStaticFunctions(this.getOwnerDescriptor(), name, result, this.getC());
    }

    /*
     * WARNING - void declaration
     */
    @Override
    protected void computeNonDeclaredProperties(@NotNull Name name, @NotNull Collection<PropertyDescriptor> result) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(result, "result");
        Name name2 = name;
        Set propertiesFromSupertypes = this.flatMapJavaStaticSupertypesScopes(this.getOwnerDescriptor(), new LinkedHashSet(), new LazyJavaStaticClassScope$$Lambda$2(name2));
        if (!result.isEmpty()) {
            Collection<PropertyDescriptor> collection = DescriptorResolverUtils.resolveOverridesForStaticMembers(name, propertiesFromSupertypes, result, this.getOwnerDescriptor(), this.getC().getComponents().getErrorReporter(), this.getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
            Intrinsics.checkNotNullExpressionValue(collection, "resolveOverridesForStaticMembers(...)");
            bl2 = result.addAll(collection);
        } else {
            void $this$flatMapTo$iv$iv;
            void $this$flatMap$iv;
            Object it;
            void $this$groupByTo$iv$iv;
            Map $this$groupBy$iv;
            Iterable iterable = propertiesFromSupertypes;
            Collection<PropertyDescriptor> collection = result;
            boolean $i$f$groupBy = false;
            void var6_8 = $this$groupBy$iv;
            Object destination$iv$iv = new LinkedHashMap();
            boolean $i$f$groupByTo = false;
            for (Object t2 : $this$groupByTo$iv$iv) {
                Object object;
                it = (PropertyDescriptor)t2;
                boolean bl3 = false;
                PropertyDescriptor key$iv$iv = this.getRealOriginal((PropertyDescriptor)it);
                Map $this$getOrPut$iv$iv$iv = destination$iv$iv;
                boolean $i$f$getOrPut = false;
                Object value$iv$iv$iv = $this$getOrPut$iv$iv$iv.get(key$iv$iv);
                if (value$iv$iv$iv == null) {
                    boolean bl4 = false;
                    List answer$iv$iv$iv = new ArrayList();
                    $this$getOrPut$iv$iv$iv.put(key$iv$iv, answer$iv$iv$iv);
                    object = answer$iv$iv$iv;
                } else {
                    object = value$iv$iv$iv;
                }
                List list$iv$iv = (List)object;
                list$iv$iv.add(t2);
            }
            $this$groupBy$iv = destination$iv$iv;
            boolean $i$f$flatMap = false;
            $this$groupByTo$iv$iv = $this$flatMap$iv;
            destination$iv$iv = new ArrayList();
            boolean $i$f$flatMapTo = false;
            for (Map.Entry entry : $this$flatMapTo$iv$iv.entrySet()) {
                it = entry;
                boolean bl5 = false;
                Collection<PropertyDescriptor> collection2 = DescriptorResolverUtils.resolveOverridesForStaticMembers(name, (Collection)it.getValue(), result, this.getOwnerDescriptor(), this.getC().getComponents().getErrorReporter(), this.getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
                Intrinsics.checkNotNullExpressionValue(collection2, "resolveOverridesForStaticMembers(...)");
                Iterable list$iv$iv = collection2;
                CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            }
            bl2 = collection.addAll((List)destination$iv$iv);
        }
        if (this.jClass.isEnum() && Intrinsics.areEqual(name, StandardNames.ENUM_ENTRIES)) {
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(result, DescriptorFactory.createEnumEntriesProperty(this.getOwnerDescriptor()));
        }
    }

    private final Set<SimpleFunctionDescriptor> getStaticFunctionsFromJavaSuperClasses(Name name, ClassDescriptor descriptor2) {
        LazyJavaStaticClassScope lazyJavaStaticClassScope = UtilKt.getParentJavaStaticClassScope(descriptor2);
        if (lazyJavaStaticClassScope == null) {
            return SetsKt.emptySet();
        }
        LazyJavaStaticClassScope staticScope = lazyJavaStaticClassScope;
        return CollectionsKt.toSet((Iterable)staticScope.getContributedFunctions(name, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
    }

    private final <R> Set<R> flatMapJavaStaticSupertypesScopes(ClassDescriptor root, Set<R> result, Function1<? super MemberScope, ? extends Collection<? extends R>> onJavaStaticScope) {
        DFS.dfs((Collection)CollectionsKt.listOf(root), LazyJavaStaticClassScope$$Lambda$3.INSTANCE, new DFS.AbstractNodeHandler<ClassDescriptor, Unit>(root, result, onJavaStaticScope){
            final /* synthetic */ ClassDescriptor $root;
            final /* synthetic */ Set<R> $result;
            final /* synthetic */ Function1<MemberScope, Collection<R>> $onJavaStaticScope;
            {
                this.$root = $root;
                this.$result = $result;
                this.$onJavaStaticScope = $onJavaStaticScope;
            }

            public boolean beforeChildren(ClassDescriptor current) {
                Intrinsics.checkNotNullParameter(current, "current");
                if (current == this.$root) {
                    return true;
                }
                MemberScope memberScope = current.getStaticScope();
                Intrinsics.checkNotNullExpressionValue(memberScope, "getStaticScope(...)");
                MemberScope staticScope = memberScope;
                if (staticScope instanceof LazyJavaStaticScope) {
                    this.$result.addAll(this.$onJavaStaticScope.invoke(staticScope));
                    return false;
                }
                return true;
            }

            public void result() {
            }
        });
        return result;
    }

    /*
     * WARNING - void declaration
     */
    private final PropertyDescriptor getRealOriginal(PropertyDescriptor $this$realOriginal) {
        void $this$mapTo$iv$iv;
        if ($this$realOriginal.getKind().isReal()) {
            return $this$realOriginal;
        }
        Collection<? extends PropertyDescriptor> collection = $this$realOriginal.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(collection, "getOverriddenDescriptors(...)");
        Iterable $this$map$iv = collection;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            PropertyDescriptor propertyDescriptor = (PropertyDescriptor)item$iv$iv;
            Collection collection2 = destination$iv$iv;
            boolean bl2 = false;
            Intrinsics.checkNotNull(it);
            collection2.add(this.getRealOriginal((PropertyDescriptor)it));
        }
        return (PropertyDescriptor)CollectionsKt.single(CollectionsKt.distinct((List)destination$iv$iv));
    }

    private static final boolean computeMemberIndex$lambda$0(JavaMember it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.isStatic();
    }

    private static final Collection computePropertyNames$lambda$3$lambda$2(MemberScope it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getVariableNames();
    }

    private static final Collection computeNonDeclaredProperties$lambda$4(Name $name, MemberScope it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getContributedVariables($name, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
    }

    private static final ClassDescriptor flatMapJavaStaticSupertypesScopes$lambda$8$lambda$7(KotlinType supertype) {
        ClassifierDescriptor classifierDescriptor = supertype.getConstructor().getDeclarationDescriptor();
        return classifierDescriptor instanceof ClassDescriptor ? (ClassDescriptor)classifierDescriptor : null;
    }

    private static final Iterable flatMapJavaStaticSupertypesScopes$lambda$8(ClassDescriptor it) {
        Collection<KotlinType> collection = it.getTypeConstructor().getSupertypes();
        Intrinsics.checkNotNullExpressionValue(collection, "getSupertypes(...)");
        return SequencesKt.asIterable(SequencesKt.mapNotNull(CollectionsKt.asSequence((Iterable)collection), LazyJavaStaticClassScope$$Lambda$4.INSTANCE));
    }

    static /* synthetic */ boolean accessor$LazyJavaStaticClassScope$lambda0(JavaMember javaMember) {
        return LazyJavaStaticClassScope.computeMemberIndex$lambda$0(javaMember);
    }

    static /* synthetic */ Collection accessor$LazyJavaStaticClassScope$lambda1(MemberScope memberScope) {
        return LazyJavaStaticClassScope.computePropertyNames$lambda$3$lambda$2(memberScope);
    }

    static /* synthetic */ Collection accessor$LazyJavaStaticClassScope$lambda2(Name name, MemberScope memberScope) {
        return LazyJavaStaticClassScope.computeNonDeclaredProperties$lambda$4(name, memberScope);
    }

    static /* synthetic */ Iterable accessor$LazyJavaStaticClassScope$lambda3(ClassDescriptor classDescriptor) {
        return LazyJavaStaticClassScope.flatMapJavaStaticSupertypesScopes$lambda$8(classDescriptor);
    }

    static /* synthetic */ ClassDescriptor accessor$LazyJavaStaticClassScope$lambda4(KotlinType kotlinType) {
        return LazyJavaStaticClassScope.flatMapJavaStaticSupertypesScopes$lambda$8$lambda$7(kotlinType);
    }
}

