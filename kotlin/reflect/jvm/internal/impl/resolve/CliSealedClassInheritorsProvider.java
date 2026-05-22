/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.SealedClassInheritorsProvider;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nSealedClassInheritorsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SealedClassInheritorsProvider.kt\norg/jetbrains/kotlin/resolve/CliSealedClassInheritorsProvider\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,86:1\n183#2,2:87\n1056#3:89\n*S KotlinDebug\n*F\n+ 1 SealedClassInheritorsProvider.kt\norg/jetbrains/kotlin/resolve/CliSealedClassInheritorsProvider\n*L\n73#1:87,2\n82#1:89\n*E\n"})
public final class CliSealedClassInheritorsProvider
extends SealedClassInheritorsProvider {
    @NotNull
    public static final CliSealedClassInheritorsProvider INSTANCE = new CliSealedClassInheritorsProvider();

    private CliSealedClassInheritorsProvider() {
    }

    @NotNull
    public Collection<ClassDescriptor> computeSealedSubclasses(@NotNull ClassDescriptor sealedClass, boolean allowSealedInheritorsInDifferentFilesOfSamePackage) {
        DeclarationDescriptor container;
        DeclarationDescriptor declarationDescriptor;
        Intrinsics.checkNotNullParameter(sealedClass, "sealedClass");
        if (sealedClass.getModality() != Modality.SEALED) {
            return CollectionsKt.emptyList();
        }
        LinkedHashSet<ClassDescriptor> result = new LinkedHashSet<ClassDescriptor>();
        if (!allowSealedInheritorsInDifferentFilesOfSamePackage) {
            declarationDescriptor = sealedClass.getContainingDeclaration();
        } else {
            DeclarationDescriptor declarationDescriptor2;
            block5: {
                Sequence<DeclarationDescriptor> $this$firstOrNull$iv = DescriptorUtilsKt.getParents(sealedClass);
                boolean $i$f$firstOrNull = false;
                Iterator<DeclarationDescriptor> iterator2 = $this$firstOrNull$iv.iterator();
                while (iterator2.hasNext()) {
                    DeclarationDescriptor element$iv;
                    DeclarationDescriptor it = element$iv = iterator2.next();
                    boolean bl2 = false;
                    if (!(it instanceof PackageFragmentDescriptor)) continue;
                    declarationDescriptor2 = element$iv;
                    break block5;
                }
                declarationDescriptor2 = null;
            }
            declarationDescriptor = container = (DeclarationDescriptor)declarationDescriptor2;
        }
        if (container instanceof PackageFragmentDescriptor) {
            CliSealedClassInheritorsProvider.computeSealedSubclasses$collectSubclasses(sealedClass, result, ((PackageFragmentDescriptor)container).getMemberScope(), allowSealedInheritorsInDifferentFilesOfSamePackage);
        }
        MemberScope memberScope = sealedClass.getUnsubstitutedInnerClassesScope();
        Intrinsics.checkNotNullExpressionValue(memberScope, "getUnsubstitutedInnerClassesScope(...)");
        CliSealedClassInheritorsProvider.computeSealedSubclasses$collectSubclasses(sealedClass, result, memberScope, true);
        Iterable $this$sortedBy$iv = result;
        boolean $i$f$sortedBy = false;
        return CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

            public final int compare(T a2, T b2) {
                ClassDescriptor it = (ClassDescriptor)a2;
                boolean bl2 = false;
                Comparable comparable = (Comparable)((Object)DescriptorUtilsKt.getFqNameSafe(it).asString());
                it = (ClassDescriptor)b2;
                Comparable comparable2 = comparable;
                bl2 = false;
                return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)DescriptorUtilsKt.getFqNameSafe(it).asString()));
            }
        });
    }

    private static final void computeSealedSubclasses$collectSubclasses(ClassDescriptor $sealedClass, LinkedHashSet<ClassDescriptor> result, MemberScope scope, boolean collectNested) {
        for (DeclarationDescriptor descriptor2 : ResolutionScope.DefaultImpls.getContributedDescriptors$default(scope, DescriptorKindFilter.CLASSIFIERS, null, 2, null)) {
            ClassDescriptor classDescriptor;
            if (!(descriptor2 instanceof ClassDescriptor)) continue;
            if (((ClassDescriptor)descriptor2).isExpect()) {
                Name name = ((ClassDescriptor)descriptor2).getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                ClassifierDescriptor actualDescriptor = scope.getContributedClassifier(name, NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
                classDescriptor = actualDescriptor instanceof ClassDescriptor ? (ClassDescriptor)actualDescriptor : (actualDescriptor instanceof TypeAliasDescriptor ? ((TypeAliasDescriptor)actualDescriptor).getClassDescriptor() : null);
            } else {
                classDescriptor = (ClassDescriptor)descriptor2;
            }
            if (classDescriptor == null) continue;
            ClassDescriptor refinedDescriptor = classDescriptor;
            if (DescriptorUtils.isDirectSubclass(refinedDescriptor, $sealedClass)) {
                result.add(refinedDescriptor);
            }
            if (!collectNested) continue;
            MemberScope memberScope = refinedDescriptor.getUnsubstitutedInnerClassesScope();
            Intrinsics.checkNotNullExpressionValue(memberScope, "getUnsubstitutedInnerClassesScope(...)");
            CliSealedClassInheritorsProvider.computeSealedSubclasses$collectSubclasses($sealedClass, result, memberScope, collectNested);
        }
    }
}

