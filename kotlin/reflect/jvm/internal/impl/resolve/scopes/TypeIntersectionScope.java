/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nTypeIntersectionScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeIntersectionScope.kt\norg/jetbrains/kotlin/resolve/scopes/TypeIntersectionScope\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,59:1\n3301#2,10:60\n*S KotlinDebug\n*F\n+ 1 TypeIntersectionScope.kt\norg/jetbrains/kotlin/resolve/scopes/TypeIntersectionScope\n*L\n36#1:60,10\n*E\n"})
public final class TypeIntersectionScope
extends AbstractScopeAdapter {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String debugName;
    @NotNull
    private final MemberScope workerScope;

    private TypeIntersectionScope(String debugName, MemberScope workerScope) {
        this.debugName = debugName;
        this.workerScope = workerScope;
    }

    @Override
    @NotNull
    protected MemberScope getWorkerScope() {
        return this.workerScope;
    }

    @Override
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        return OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(super.getContributedFunctions(name, location), TypeIntersectionScope$$Lambda$0.INSTANCE);
    }

    @Override
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        return OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(super.getContributedVariables(name, location), TypeIntersectionScope$$Lambda$1.INSTANCE);
    }

    @Override
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        Iterable $this$partition$iv = super.getContributedDescriptors(kindFilter, nameFilter);
        boolean $i$f$partition = false;
        ArrayList first$iv = new ArrayList();
        ArrayList second$iv = new ArrayList();
        for (Object element$iv : $this$partition$iv) {
            DeclarationDescriptor it = (DeclarationDescriptor)element$iv;
            boolean bl2 = false;
            boolean bl3 = it instanceof CallableDescriptor ? first$iv.add(element$iv) : second$iv.add(element$iv);
        }
        Pair pair = new Pair(first$iv, second$iv);
        List callables = pair.component1();
        List other = pair.component2();
        Intrinsics.checkNotNull(callables, "null cannot be cast to non-null type kotlin.collections.Collection<org.jetbrains.kotlin.descriptors.CallableDescriptor>");
        return CollectionsKt.plus(OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(callables, TypeIntersectionScope$$Lambda$2.INSTANCE), (Iterable)other);
    }

    private static final CallableDescriptor getContributedFunctions$lambda$0(SimpleFunctionDescriptor $this$selectMostSpecificInEachOverridableGroup) {
        Intrinsics.checkNotNullParameter($this$selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
        return $this$selectMostSpecificInEachOverridableGroup;
    }

    private static final CallableDescriptor getContributedVariables$lambda$1(PropertyDescriptor $this$selectMostSpecificInEachOverridableGroup) {
        Intrinsics.checkNotNullParameter($this$selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
        return $this$selectMostSpecificInEachOverridableGroup;
    }

    private static final CallableDescriptor getContributedDescriptors$lambda$3(CallableDescriptor $this$selectMostSpecificInEachOverridableGroup) {
        Intrinsics.checkNotNullParameter($this$selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
        return $this$selectMostSpecificInEachOverridableGroup;
    }

    @JvmStatic
    @NotNull
    public static final MemberScope create(@NotNull String message, @NotNull Collection<? extends KotlinType> types) {
        return Companion.create(message, types);
    }

    public /* synthetic */ TypeIntersectionScope(String debugName, MemberScope workerScope, DefaultConstructorMarker $constructor_marker) {
        this(debugName, workerScope);
    }

    static /* synthetic */ CallableDescriptor accessor$TypeIntersectionScope$lambda0(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        return TypeIntersectionScope.getContributedFunctions$lambda$0(simpleFunctionDescriptor);
    }

    static /* synthetic */ CallableDescriptor accessor$TypeIntersectionScope$lambda1(PropertyDescriptor propertyDescriptor) {
        return TypeIntersectionScope.getContributedVariables$lambda$1(propertyDescriptor);
    }

    static /* synthetic */ CallableDescriptor accessor$TypeIntersectionScope$lambda2(CallableDescriptor callableDescriptor) {
        return TypeIntersectionScope.getContributedDescriptors$lambda$3(callableDescriptor);
    }

    @SourceDebugExtension(value={"SMAP\nTypeIntersectionScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeIntersectionScope.kt\norg/jetbrains/kotlin/resolve/scopes/TypeIntersectionScope$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,59:1\n1563#2:60\n1634#2,3:61\n*S KotlinDebug\n*F\n+ 1 TypeIntersectionScope.kt\norg/jetbrains/kotlin/resolve/scopes/TypeIntersectionScope$Companion\n*L\n50#1:60\n50#1:61,3\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        /*
         * WARNING - void declaration
         */
        @JvmStatic
        @NotNull
        public final MemberScope create(@NotNull String message, @NotNull Collection<? extends KotlinType> types) {
            void $this$mapTo$iv$iv;
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(types, "types");
            Iterable $this$map$iv = types;
            boolean $i$f$map = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it;
                KotlinType kotlinType = (KotlinType)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl2 = false;
                collection.add(it.getMemberScope());
            }
            SmartList<MemberScope> nonEmptyScopes = ScopeUtilsKt.listOfNonEmptyScopes((List)destination$iv$iv);
            MemberScope chainedOrSingle = ChainedMemberScope.Companion.createOrSingle$descriptors(message, (List<? extends MemberScope>)nonEmptyScopes);
            if (nonEmptyScopes.size() <= 1) {
                return chainedOrSingle;
            }
            return new TypeIntersectionScope(message, chainedOrSingle, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

