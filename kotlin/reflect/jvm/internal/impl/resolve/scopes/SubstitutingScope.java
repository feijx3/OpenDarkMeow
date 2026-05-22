/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Substitutable;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nSubstitutingScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SubstitutingScope.kt\norg/jetbrains/kotlin/resolve/scopes/SubstitutingScope\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 coreLib.kt\norg/jetbrains/kotlin/utils/CoreLibKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,111:1\n382#2,3:112\n385#2,4:116\n19#3:115\n1#4:120\n*S KotlinDebug\n*F\n+ 1 SubstitutingScope.kt\norg/jetbrains/kotlin/resolve/scopes/SubstitutingScope\n*L\n52#1:112,3\n52#1:116,4\n54#1:115\n*E\n"})
public final class SubstitutingScope
implements MemberScope {
    @NotNull
    private final MemberScope workerScope;
    @NotNull
    private final Lazy substitutor$delegate;
    @NotNull
    private final TypeSubstitutor capturingSubstitutor;
    @Nullable
    private Map<DeclarationDescriptor, DeclarationDescriptor> substitutedDescriptors;
    @NotNull
    private final Lazy _allDescriptors$delegate;

    public SubstitutingScope(@NotNull MemberScope workerScope, @NotNull TypeSubstitutor givenSubstitutor) {
        Intrinsics.checkNotNullParameter(workerScope, "workerScope");
        Intrinsics.checkNotNullParameter(givenSubstitutor, "givenSubstitutor");
        this.workerScope = workerScope;
        Object object = givenSubstitutor;
        this.substitutor$delegate = LazyKt.lazy(new SubstitutingScope$$Lambda$0((TypeSubstitutor)object));
        TypeSubstitution typeSubstitution = givenSubstitutor.getSubstitution();
        Intrinsics.checkNotNullExpressionValue(typeSubstitution, "getSubstitution(...)");
        this.capturingSubstitutor = CapturedTypeConstructorKt.wrapWithCapturingSubstitution$default(typeSubstitution, false, 1, null).buildSubstitutor();
        object = this;
        this._allDescriptors$delegate = LazyKt.lazy(new SubstitutingScope$$Lambda$1((SubstitutingScope)object));
    }

    private final Collection<DeclarationDescriptor> get_allDescriptors() {
        Lazy lazy = this._allDescriptors$delegate;
        return (Collection)lazy.getValue();
    }

    private final <D extends DeclarationDescriptor> D substitute(D descriptor2) {
        DeclarationDescriptor declarationDescriptor;
        if (this.capturingSubstitutor.isEmpty()) {
            return descriptor2;
        }
        if (this.substitutedDescriptors == null) {
            this.substitutedDescriptors = new HashMap();
        }
        Map<DeclarationDescriptor, DeclarationDescriptor> map = this.substitutedDescriptors;
        Intrinsics.checkNotNull(map);
        Map<DeclarationDescriptor, DeclarationDescriptor> $this$getOrPut$iv = map;
        boolean $i$f$getOrPut = false;
        DeclarationDescriptor value$iv = $this$getOrPut$iv.get(descriptor2);
        if (value$iv == null) {
            Object t2;
            boolean bl2 = false;
            if (descriptor2 instanceof Substitutable) {
                Object $this$sure$iv = ((Substitutable)((Object)descriptor2)).substitute(this.capturingSubstitutor);
                boolean $i$f$sure = false;
                t2 = $this$sure$iv;
                if (t2 == null) {
                    boolean bl3 = false;
                    String string = "We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + descriptor2 + " substitution fails";
                    throw new AssertionError((Object)string);
                }
            } else {
                throw new IllegalStateException(("Unknown descriptor in scope: " + descriptor2).toString());
            }
            DeclarationDescriptor answer$iv = (DeclarationDescriptor)t2;
            $this$getOrPut$iv.put(descriptor2, answer$iv);
            declarationDescriptor = answer$iv;
        } else {
            declarationDescriptor = value$iv;
        }
        DeclarationDescriptor substituted = declarationDescriptor;
        Intrinsics.checkNotNull(substituted, "null cannot be cast to non-null type D of org.jetbrains.kotlin.resolve.scopes.SubstitutingScope.substitute");
        return (D)substituted;
    }

    private final <D extends DeclarationDescriptor> Collection<D> substitute(Collection<? extends D> descriptors) {
        if (this.capturingSubstitutor.isEmpty()) {
            return descriptors;
        }
        if (descriptors.isEmpty()) {
            return descriptors;
        }
        LinkedHashSet<DeclarationDescriptor> result = CollectionsKt.newLinkedHashSetWithExpectedSize(descriptors.size());
        for (DeclarationDescriptor descriptor2 : descriptors) {
            DeclarationDescriptor substitute = this.substitute(descriptor2);
            result.add(substitute);
        }
        return result;
    }

    @Override
    @NotNull
    public Collection<? extends PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        return this.substitute(this.workerScope.getContributedVariables(name, location));
    }

    @Override
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name, @NotNull LookupLocation location) {
        ClassifierDescriptor classifierDescriptor;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        ClassifierDescriptor classifierDescriptor2 = this.workerScope.getContributedClassifier(name, location);
        if (classifierDescriptor2 != null) {
            ClassifierDescriptor it = classifierDescriptor2;
            boolean bl2 = false;
            classifierDescriptor = (ClassifierDescriptor)this.substitute((DeclarationDescriptor)it);
        } else {
            classifierDescriptor = null;
        }
        return classifierDescriptor;
    }

    @Override
    @NotNull
    public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        return this.substitute(this.workerScope.getContributedFunctions(name, location));
    }

    @Override
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        return this.get_allDescriptors();
    }

    @Override
    @NotNull
    public Set<Name> getFunctionNames() {
        return this.workerScope.getFunctionNames();
    }

    @Override
    @NotNull
    public Set<Name> getVariableNames() {
        return this.workerScope.getVariableNames();
    }

    @Override
    @Nullable
    public Set<Name> getClassifierNames() {
        return this.workerScope.getClassifierNames();
    }

    @Override
    public void recordLookup(@NotNull Name name, @NotNull LookupLocation location) {
        MemberScope.DefaultImpls.recordLookup(this, name, location);
    }

    private static final TypeSubstitutor substitutor_delegate$lambda$0(TypeSubstitutor $givenSubstitutor) {
        return $givenSubstitutor.getSubstitution().buildSubstitutor();
    }

    private static final Collection _allDescriptors_delegate$lambda$1(SubstitutingScope this$0) {
        return this$0.substitute(ResolutionScope.DefaultImpls.getContributedDescriptors$default(this$0.workerScope, null, null, 3, null));
    }

    static /* synthetic */ TypeSubstitutor accessor$SubstitutingScope$lambda0(TypeSubstitutor typeSubstitutor2) {
        return SubstitutingScope.substitutor_delegate$lambda$0(typeSubstitutor2);
    }

    static /* synthetic */ Collection accessor$SubstitutingScope$lambda1(SubstitutingScope substitutingScope) {
        return SubstitutingScope._allDescriptors_delegate$lambda$1(substitutingScope);
    }
}

