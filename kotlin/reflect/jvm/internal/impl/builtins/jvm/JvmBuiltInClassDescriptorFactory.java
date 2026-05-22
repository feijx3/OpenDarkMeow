/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nJvmBuiltInClassDescriptorFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmBuiltInClassDescriptorFactory.kt\norg/jetbrains/kotlin/builtins/jvm/JvmBuiltInClassDescriptorFactory\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,57:1\n808#2,11:58\n*S KotlinDebug\n*F\n+ 1 JvmBuiltInClassDescriptorFactory.kt\norg/jetbrains/kotlin/builtins/jvm/JvmBuiltInClassDescriptorFactory\n*L\n23#1:58,11\n*E\n"})
public final class JvmBuiltInClassDescriptorFactory
implements ClassDescriptorFactory {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final ModuleDescriptor moduleDescriptor;
    @NotNull
    private final Function1<ModuleDescriptor, DeclarationDescriptor> computeContainingDeclaration;
    @NotNull
    private final NotNullLazyValue cloneable$delegate;
    @NotNull
    private static final FqName KOTLIN_FQ_NAME;
    @NotNull
    private static final Name CLONEABLE_NAME;
    @NotNull
    private static final ClassId CLONEABLE_CLASS_ID;

    public JvmBuiltInClassDescriptorFactory(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor, @NotNull Function1<? super ModuleDescriptor, ? extends DeclarationDescriptor> computeContainingDeclaration) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(moduleDescriptor, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(computeContainingDeclaration, "computeContainingDeclaration");
        this.moduleDescriptor = moduleDescriptor;
        this.computeContainingDeclaration = computeContainingDeclaration;
        StorageManager storageManager2 = storageManager;
        JvmBuiltInClassDescriptorFactory jvmBuiltInClassDescriptorFactory = this;
        this.cloneable$delegate = storageManager.createLazyValue(new JvmBuiltInClassDescriptorFactory$$Lambda$0(jvmBuiltInClassDescriptorFactory, storageManager2));
    }

    public /* synthetic */ JvmBuiltInClassDescriptorFactory(StorageManager storageManager, ModuleDescriptor moduleDescriptor, Function1 function1, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 4) != 0) {
            function1 = JvmBuiltInClassDescriptorFactory$$Lambda$1.INSTANCE;
        }
        this(storageManager, moduleDescriptor, function1);
    }

    private final ClassDescriptorImpl getCloneable() {
        return (ClassDescriptorImpl)StorageKt.getValue(this.cloneable$delegate, (Object)this, $$delegatedProperties[0]);
    }

    @Override
    public boolean shouldCreateClass(@NotNull FqName packageFqName, @NotNull Name name) {
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        Intrinsics.checkNotNullParameter(name, "name");
        return Intrinsics.areEqual(name, CLONEABLE_NAME) && Intrinsics.areEqual(packageFqName, KOTLIN_FQ_NAME);
    }

    @Override
    @Nullable
    public ClassDescriptor createClass(@NotNull ClassId classId) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        return Intrinsics.areEqual(classId, CLONEABLE_CLASS_ID) ? (ClassDescriptor)this.getCloneable() : null;
    }

    @Override
    @NotNull
    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(@NotNull FqName packageFqName) {
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        return Intrinsics.areEqual(packageFqName, KOTLIN_FQ_NAME) ? (Collection)SetsKt.setOf(this.getCloneable()) : (Collection)SetsKt.emptySet();
    }

    /*
     * WARNING - void declaration
     */
    private static final BuiltInsPackageFragment _init_$lambda$0(ModuleDescriptor module) {
        void $this$filterIsInstanceTo$iv$iv;
        Intrinsics.checkNotNullParameter(module, "module");
        Iterable $this$filterIsInstance$iv = module.getPackage(KOTLIN_FQ_NAME).getFragments();
        boolean $i$f$filterIsInstance = false;
        Iterable iterable = $this$filterIsInstance$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterIsInstanceTo = false;
        for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
            if (!(element$iv$iv instanceof BuiltInsPackageFragment)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (BuiltInsPackageFragment)CollectionsKt.first((List)destination$iv$iv);
    }

    private static final ClassDescriptorImpl cloneable_delegate$lambda$2(JvmBuiltInClassDescriptorFactory this$0, StorageManager $storageManager) {
        ClassDescriptorImpl classDescriptorImpl;
        ClassDescriptorImpl $this$cloneable_delegate_u24lambda_u242_u24lambda_u241 = classDescriptorImpl = new ClassDescriptorImpl(this$0.computeContainingDeclaration.invoke(this$0.moduleDescriptor), CLONEABLE_NAME, Modality.ABSTRACT, ClassKind.INTERFACE, (Collection<KotlinType>)CollectionsKt.listOf(this$0.moduleDescriptor.getBuiltIns().getAnyType()), SourceElement.NO_SOURCE, false, $storageManager);
        boolean bl2 = false;
        $this$cloneable_delegate_u24lambda_u242_u24lambda_u241.initialize(new CloneableClassScope($storageManager, $this$cloneable_delegate_u24lambda_u242_u24lambda_u241), SetsKt.<ClassConstructorDescriptor>emptySet(), null);
        return classDescriptorImpl;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1(new PropertyReference1Impl(JvmBuiltInClassDescriptorFactory.class, "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;", 0))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        KOTLIN_FQ_NAME = StandardNames.BUILT_INS_PACKAGE_FQ_NAME;
        CLONEABLE_NAME = StandardNames.FqNames.cloneable.shortName();
        CLONEABLE_CLASS_ID = ClassId.Companion.topLevel(StandardNames.FqNames.cloneable.toSafe());
    }

    static /* synthetic */ ClassDescriptorImpl accessor$JvmBuiltInClassDescriptorFactory$lambda0(JvmBuiltInClassDescriptorFactory jvmBuiltInClassDescriptorFactory, StorageManager storageManager) {
        return JvmBuiltInClassDescriptorFactory.cloneable_delegate$lambda$2(jvmBuiltInClassDescriptorFactory, storageManager);
    }

    static /* synthetic */ BuiltInsPackageFragment accessor$JvmBuiltInClassDescriptorFactory$lambda1(ModuleDescriptor moduleDescriptor) {
        return JvmBuiltInClassDescriptorFactory._init_$lambda$0(moduleDescriptor);
    }

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final ClassId getCLONEABLE_CLASS_ID() {
            return CLONEABLE_CLASS_ID;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

