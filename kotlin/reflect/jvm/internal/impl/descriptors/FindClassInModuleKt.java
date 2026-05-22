/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProviderKt;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nfindClassInModule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 findClassInModule.kt\norg/jetbrains/kotlin/descriptors/FindClassInModuleKt\n*L\n1#1,66:1\n43#1,2:67\n*S KotlinDebug\n*F\n+ 1 findClassInModule.kt\norg/jetbrains/kotlin/descriptors/FindClassInModuleKt\n*L\n23#1:67,2\n*E\n"})
public final class FindClassInModuleKt {
    @Nullable
    public static final ClassifierDescriptor findClassifierAcrossModuleDependencies(@NotNull ModuleDescriptor $this$findClassifierAcrossModuleDependencies, @NotNull ClassId classId) {
        ClassifierDescriptor classifierDescriptor;
        block18: {
            ModuleDescriptor anchor$iv;
            Intrinsics.checkNotNullParameter($this$findClassifierAcrossModuleDependencies, "<this>");
            Intrinsics.checkNotNullParameter(classId, "classId");
            ModuleDescriptor $this$withResolutionAnchor$iv = $this$findClassifierAcrossModuleDependencies;
            boolean $i$f$withResolutionAnchor = false;
            ModuleDescriptor moduleDescriptor = anchor$iv = ResolutionAnchorProviderKt.getResolutionAnchorIfAny($this$withResolutionAnchor$iv);
            if (moduleDescriptor == null) {
                ModuleDescriptor $this$findClassifierAcrossModuleDependencies_u24lambda_u240 = $this$withResolutionAnchor$iv;
                boolean bl2 = false;
                PackageViewDescriptor packageViewDescriptor = $this$findClassifierAcrossModuleDependencies_u24lambda_u240.getPackage(classId.getPackageFqName());
                List<Name> segments = classId.getRelativeClassName().pathSegments();
                ClassifierDescriptor classifierDescriptor2 = packageViewDescriptor.getMemberScope().getContributedClassifier(CollectionsKt.first(segments), NoLookupLocation.FROM_DESERIALIZATION);
                if (classifierDescriptor2 == null) {
                    classifierDescriptor = null;
                } else {
                    ClassifierDescriptor topLevelClass;
                    ClassifierDescriptor result = topLevelClass = classifierDescriptor2;
                    for (Name name : segments.subList(1, segments.size())) {
                        if (!(result instanceof ClassDescriptor)) {
                            classifierDescriptor = null;
                            break block18;
                        }
                        ClassifierDescriptor classifierDescriptor3 = ((ClassDescriptor)result).getUnsubstitutedInnerClassesScope().getContributedClassifier(name, NoLookupLocation.FROM_DESERIALIZATION);
                        ClassDescriptor classDescriptor = classifierDescriptor3 instanceof ClassDescriptor ? (ClassDescriptor)classifierDescriptor3 : null;
                        if (classDescriptor == null) {
                            classifierDescriptor = null;
                            break block18;
                        }
                        result = classDescriptor;
                    }
                    classifierDescriptor = result;
                }
            } else {
                ClassifierDescriptor classifierDescriptor4;
                ClassifierDescriptor result;
                ClassifierDescriptor topLevelClass;
                ClassifierDescriptor classifierDescriptor5;
                List<Name> segments;
                PackageViewDescriptor packageViewDescriptor;
                boolean bl3;
                ModuleDescriptor $this$findClassifierAcrossModuleDependencies_u24lambda_u240;
                block19: {
                    $this$findClassifierAcrossModuleDependencies_u24lambda_u240 = moduleDescriptor;
                    bl3 = false;
                    packageViewDescriptor = $this$findClassifierAcrossModuleDependencies_u24lambda_u240.getPackage(classId.getPackageFqName());
                    segments = classId.getRelativeClassName().pathSegments();
                    ClassifierDescriptor classifierDescriptor6 = packageViewDescriptor.getMemberScope().getContributedClassifier(CollectionsKt.first(segments), NoLookupLocation.FROM_DESERIALIZATION);
                    if (classifierDescriptor6 == null) {
                        classifierDescriptor5 = null;
                    } else {
                        result = topLevelClass = classifierDescriptor6;
                        for (Name name : segments.subList(1, segments.size())) {
                            if (!(result instanceof ClassDescriptor)) {
                                classifierDescriptor5 = null;
                                break block19;
                            }
                            classifierDescriptor4 = ((ClassDescriptor)result).getUnsubstitutedInnerClassesScope().getContributedClassifier(name, NoLookupLocation.FROM_DESERIALIZATION);
                            ClassDescriptor classDescriptor = classifierDescriptor4 instanceof ClassDescriptor ? (ClassDescriptor)classifierDescriptor4 : null;
                            if (classDescriptor == null) {
                                classifierDescriptor5 = null;
                                break block19;
                            }
                            result = classDescriptor;
                        }
                        classifierDescriptor5 = classifierDescriptor = result;
                    }
                }
                if (classifierDescriptor5 == null) {
                    $this$findClassifierAcrossModuleDependencies_u24lambda_u240 = $this$withResolutionAnchor$iv;
                    bl3 = false;
                    packageViewDescriptor = $this$findClassifierAcrossModuleDependencies_u24lambda_u240.getPackage(classId.getPackageFqName());
                    segments = classId.getRelativeClassName().pathSegments();
                    ClassifierDescriptor classifierDescriptor7 = packageViewDescriptor.getMemberScope().getContributedClassifier(CollectionsKt.first(segments), NoLookupLocation.FROM_DESERIALIZATION);
                    if (classifierDescriptor7 == null) {
                        classifierDescriptor = null;
                    } else {
                        result = topLevelClass = classifierDescriptor7;
                        for (Name name : segments.subList(1, segments.size())) {
                            if (!(result instanceof ClassDescriptor)) {
                                classifierDescriptor = null;
                                break block18;
                            }
                            classifierDescriptor4 = ((ClassDescriptor)result).getUnsubstitutedInnerClassesScope().getContributedClassifier(name, NoLookupLocation.FROM_DESERIALIZATION);
                            ClassDescriptor classDescriptor = classifierDescriptor4 instanceof ClassDescriptor ? (ClassDescriptor)classifierDescriptor4 : null;
                            if (classDescriptor == null) {
                                classifierDescriptor = null;
                                break block18;
                            }
                            result = classDescriptor;
                        }
                        classifierDescriptor = result;
                    }
                }
            }
        }
        return classifierDescriptor;
    }

    @Nullable
    public static final ClassDescriptor findClassAcrossModuleDependencies(@NotNull ModuleDescriptor $this$findClassAcrossModuleDependencies, @NotNull ClassId classId) {
        Intrinsics.checkNotNullParameter($this$findClassAcrossModuleDependencies, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ClassifierDescriptor classifierDescriptor = FindClassInModuleKt.findClassifierAcrossModuleDependencies($this$findClassAcrossModuleDependencies, classId);
        return classifierDescriptor instanceof ClassDescriptor ? (ClassDescriptor)classifierDescriptor : null;
    }

    @NotNull
    public static final ClassDescriptor findNonGenericClassAcrossDependencies(@NotNull ModuleDescriptor $this$findNonGenericClassAcrossDependencies, @NotNull ClassId classId, @NotNull NotFoundClasses notFoundClasses) {
        Intrinsics.checkNotNullParameter($this$findNonGenericClassAcrossDependencies, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        ClassDescriptor existingClass = FindClassInModuleKt.findClassAcrossModuleDependencies($this$findNonGenericClassAcrossDependencies, classId);
        if (existingClass != null) {
            return existingClass;
        }
        List<Integer> typeParametersCount2 = SequencesKt.toList(SequencesKt.map(SequencesKt.generateSequence(classId, (Function1)findNonGenericClassAcrossDependencies.typeParametersCount.1.INSTANCE), FindClassInModuleKt$$Lambda$0.INSTANCE));
        return notFoundClasses.getClass(classId, typeParametersCount2);
    }

    @Nullable
    public static final TypeAliasDescriptor findTypeAliasAcrossModuleDependencies(@NotNull ModuleDescriptor $this$findTypeAliasAcrossModuleDependencies, @NotNull ClassId classId) {
        Intrinsics.checkNotNullParameter($this$findTypeAliasAcrossModuleDependencies, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ClassifierDescriptor classifierDescriptor = FindClassInModuleKt.findClassifierAcrossModuleDependencies($this$findTypeAliasAcrossModuleDependencies, classId);
        return classifierDescriptor instanceof TypeAliasDescriptor ? (TypeAliasDescriptor)classifierDescriptor : null;
    }

    private static final int findNonGenericClassAcrossDependencies$lambda$1(ClassId it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return 0;
    }

    static /* synthetic */ int accessor$FindClassInModuleKt$lambda0(ClassId classId) {
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies$lambda$1(classId);
    }
}

