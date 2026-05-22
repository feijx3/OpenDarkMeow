/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionInterfacePackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKindExtractor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nBuiltInFictitiousFunctionClassFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BuiltInFictitiousFunctionClassFactory.kt\norg/jetbrains/kotlin/builtins/functions/BuiltInFictitiousFunctionClassFactory\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,70:1\n808#2,11:71\n808#2,11:82\n*S KotlinDebug\n*F\n+ 1 BuiltInFictitiousFunctionClassFactory.kt\norg/jetbrains/kotlin/builtins/functions/BuiltInFictitiousFunctionClassFactory\n*L\n55#1:71,11\n59#1:82,11\n*E\n"})
public final class BuiltInFictitiousFunctionClassFactory
implements ClassDescriptorFactory {
    @NotNull
    private final StorageManager storageManager;
    @NotNull
    private final ModuleDescriptor module;

    public BuiltInFictitiousFunctionClassFactory(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor module) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(module, "module");
        this.storageManager = storageManager;
        this.module = module;
    }

    @Override
    public boolean shouldCreateClass(@NotNull FqName packageFqName, @NotNull Name name) {
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        Intrinsics.checkNotNullParameter(name, "name");
        String string = name.asString();
        Intrinsics.checkNotNullExpressionValue(string, "asString(...)");
        String string2 = string;
        return (StringsKt.startsWith$default(string2, "Function", false, 2, null) || StringsKt.startsWith$default(string2, "KFunction", false, 2, null) || StringsKt.startsWith$default(string2, "SuspendFunction", false, 2, null) || StringsKt.startsWith$default(string2, "KSuspendFunction", false, 2, null)) && FunctionTypeKindExtractor.Companion.getDefault().getFunctionalClassKindWithArity(packageFqName, string2) != null;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Nullable
    public ClassDescriptor createClass(@NotNull ClassId classId) {
        void $this$filterIsInstanceTo$iv$iv;
        void $this$filterIsInstanceTo$iv$iv2;
        Intrinsics.checkNotNullParameter(classId, "classId");
        if (classId.isLocal() || classId.isNestedClass()) {
            return null;
        }
        String className = classId.getRelativeClassName().asString();
        if (!StringsKt.contains$default((CharSequence)className, "Function", false, 2, null)) {
            return null;
        }
        FqName packageFqName = classId.getPackageFqName();
        FunctionTypeKindExtractor.KindWithArity kindWithArity = FunctionTypeKindExtractor.Companion.getDefault().getFunctionalClassKindWithArity(packageFqName, className);
        if (kindWithArity == null) {
            return null;
        }
        FunctionTypeKindExtractor.KindWithArity kindWithArity2 = kindWithArity;
        FunctionTypeKind kind2 = kindWithArity2.component1();
        int arity = kindWithArity2.component2();
        Iterable $this$filterIsInstance$iv = this.module.getPackage(packageFqName).getFragments();
        boolean $i$f$filterIsInstance = false;
        Iterable iterable = $this$filterIsInstance$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterIsInstanceTo22 = false;
        for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv2) {
            if (!(element$iv$iv instanceof BuiltInsPackageFragment)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List builtInsFragments = (List)destination$iv$iv;
        Iterable $this$filterIsInstance$iv2 = builtInsFragments;
        boolean $i$f$filterIsInstance2 = false;
        Iterable $i$f$filterIsInstanceTo22 = $this$filterIsInstance$iv2;
        Collection destination$iv$iv2 = new ArrayList();
        boolean $i$f$filterIsInstanceTo = false;
        for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
            if (!(element$iv$iv instanceof FunctionInterfacePackageFragment)) continue;
            destination$iv$iv2.add(element$iv$iv);
        }
        FunctionInterfacePackageFragment functionInterfacePackageFragment = (FunctionInterfacePackageFragment)CollectionsKt.firstOrNull((List)destination$iv$iv2);
        BuiltInsPackageFragment containingPackageFragment = functionInterfacePackageFragment != null ? (BuiltInsPackageFragment)functionInterfacePackageFragment : (BuiltInsPackageFragment)CollectionsKt.first(builtInsFragments);
        return new FunctionClassDescriptor(this.storageManager, containingPackageFragment, kind2, arity);
    }

    @Override
    @NotNull
    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(@NotNull FqName packageFqName) {
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        return SetsKt.emptySet();
    }
}

