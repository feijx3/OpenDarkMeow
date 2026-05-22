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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JvmPackageScope;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryPackageSourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nLazyJavaPackageFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyJavaPackageFragment.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaPackageFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,96:1\n1617#2,9:97\n1869#2:106\n1870#2:109\n1626#2:110\n1563#2:111\n1634#2,3:112\n1#3:107\n1#3:108\n*S KotlinDebug\n*F\n+ 1 LazyJavaPackageFragment.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaPackageFragment\n*L\n46#1:97,9\n46#1:106\n46#1:109\n46#1:110\n55#1:111\n55#1:112,3\n46#1:108\n*E\n"})
public final class LazyJavaPackageFragment
extends PackageFragmentDescriptorImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final JavaPackage jPackage;
    @NotNull
    private final LazyJavaResolverContext c;
    @NotNull
    private final MetadataVersion metadataVersion;
    @NotNull
    private final NotNullLazyValue binaryClasses$delegate;
    @NotNull
    private final JvmPackageScope scope;
    @NotNull
    private final NotNullLazyValue<List<FqName>> subPackages;
    @NotNull
    private final Annotations annotations;
    @NotNull
    private final NotNullLazyValue partToFacade$delegate;

    public LazyJavaPackageFragment(@NotNull LazyJavaResolverContext outerContext, @NotNull JavaPackage jPackage) {
        Intrinsics.checkNotNullParameter(outerContext, "outerContext");
        Intrinsics.checkNotNullParameter(jPackage, "jPackage");
        super(outerContext.getModule(), jPackage.getFqName());
        this.jPackage = jPackage;
        this.c = ContextKt.childForClassOrPackage$default(outerContext, this, null, 0, 6, null);
        this.metadataVersion = outerContext.getComponents().getDeserializedDescriptorResolver().getComponents().getConfiguration().getMetadataVersion();
        LazyJavaPackageFragment lazyJavaPackageFragment = this;
        this.binaryClasses$delegate = this.c.getStorageManager().createLazyValue(new LazyJavaPackageFragment$$Lambda$0(lazyJavaPackageFragment));
        this.scope = new JvmPackageScope(this.c, this.jPackage, this);
        lazyJavaPackageFragment = this;
        this.subPackages = this.c.getStorageManager().createRecursionTolerantLazyValue(new LazyJavaPackageFragment$$Lambda$1(lazyJavaPackageFragment), CollectionsKt.emptyList());
        this.annotations = this.c.getComponents().getJavaTypeEnhancementState().getDisabledDefaultAnnotations() ? Annotations.Companion.getEMPTY() : LazyJavaAnnotationsKt.resolveAnnotations(this.c, this.jPackage);
        lazyJavaPackageFragment = this;
        this.partToFacade$delegate = this.c.getStorageManager().createLazyValue(new LazyJavaPackageFragment$$Lambda$2(lazyJavaPackageFragment));
    }

    @NotNull
    public final Map<String, KotlinJvmBinaryClass> getBinaryClasses$descriptors_jvm() {
        return (Map)StorageKt.getValue(this.binaryClasses$delegate, (Object)this, $$delegatedProperties[0]);
    }

    @Override
    @NotNull
    public Annotations getAnnotations() {
        return this.annotations;
    }

    @NotNull
    public final List<FqName> getSubPackageFqNames$descriptors_jvm() {
        return (List)this.subPackages.invoke();
    }

    @Nullable
    public final ClassDescriptor findClassifierByJavaClass$descriptors_jvm(@NotNull JavaClass jClass) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        return this.scope.getJavaScope$descriptors_jvm().findClassifierByJavaClass$descriptors_jvm(jClass);
    }

    @Override
    @NotNull
    public JvmPackageScope getMemberScope() {
        return this.scope;
    }

    @Override
    @NotNull
    public String toString() {
        return "Lazy Java package fragment: " + this.getFqName() + " of module " + this.c.getComponents().getModule();
    }

    @Override
    @NotNull
    public SourceElement getSource() {
        return new KotlinJvmBinaryPackageSourceElement(this);
    }

    /*
     * WARNING - void declaration
     */
    private static final Map binaryClasses_delegate$lambda$2(LazyJavaPackageFragment this$0) {
        void $this$mapNotNullTo$iv$iv;
        Iterable $this$mapNotNull$iv = this$0.c.getComponents().getPackagePartProvider().findPackageParts(this$0.getFqName().asString());
        boolean $i$f$mapNotNull = false;
        Iterable iterable = $this$mapNotNull$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
        while (iterator2.hasNext()) {
            Pair<String, KotlinJvmBinaryClass> pair;
            Object element$iv$iv$iv;
            Object element$iv$iv = element$iv$iv$iv = iterator2.next();
            boolean bl2 = false;
            String partName = (String)element$iv$iv;
            boolean bl3 = false;
            FqName fqName = JvmClassName.byInternalName(partName).getFqNameForTopLevelClassMaybeWithDollars();
            Intrinsics.checkNotNullExpressionValue(fqName, "getFqNameForTopLevelClassMaybeWithDollars(...)");
            ClassId classId = ClassId.Companion.topLevel(fqName);
            if (KotlinClassFinderKt.findKotlinClass(this$0.c.getComponents().getKotlinClassFinder(), classId, this$0.metadataVersion) != null) {
                KotlinJvmBinaryClass it;
                boolean bl4 = false;
                pair = TuplesKt.to(partName, it);
            } else {
                pair = null;
            }
            if (pair == null) continue;
            Pair<String, KotlinJvmBinaryClass> it$iv$iv = pair;
            boolean bl5 = false;
            destination$iv$iv.add(it$iv$iv);
        }
        return MapsKt.toMap((List)destination$iv$iv);
    }

    /*
     * WARNING - void declaration
     */
    private static final List subPackages$lambda$3(LazyJavaPackageFragment this$0) {
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv = this$0.jPackage.getSubPackages();
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void p0;
            JavaPackage javaPackage = (JavaPackage)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(p0.getFqName());
        }
        return (List)destination$iv$iv;
    }

    private static final HashMap partToFacade_delegate$lambda$4(LazyJavaPackageFragment this$0) {
        HashMap result = new HashMap();
        for (Map.Entry<String, KotlinJvmBinaryClass> entry : this$0.getBinaryClasses$descriptors_jvm().entrySet()) {
            String partInternalName = entry.getKey();
            KotlinJvmBinaryClass kotlinClass = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(JvmClassName.byInternalName(partInternalName), "byInternalName(...)");
            KotlinClassHeader header = kotlinClass.getClassHeader();
            switch (WhenMappings.$EnumSwitchMapping$0[header.getKind().ordinal()]) {
                case 1: {
                    JvmClassName partName;
                    Map map = result;
                    String string = header.getMultifileClassName();
                    if (string == null) break;
                    JvmClassName jvmClassName = JvmClassName.byInternalName(string);
                    map.put(partName, jvmClassName);
                    break;
                }
                case 2: {
                    JvmClassName partName;
                    ((Map)result).put(partName, partName);
                }
            }
        }
        return result;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1(new PropertyReference1Impl(LazyJavaPackageFragment.class, "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;", 0)), Reflection.property1(new PropertyReference1Impl(LazyJavaPackageFragment.class, "partToFacade", "getPartToFacade()Ljava/util/HashMap;", 0))};
        $$delegatedProperties = kPropertyArray;
    }

    static /* synthetic */ Map accessor$LazyJavaPackageFragment$lambda0(LazyJavaPackageFragment lazyJavaPackageFragment) {
        return LazyJavaPackageFragment.binaryClasses_delegate$lambda$2(lazyJavaPackageFragment);
    }

    static /* synthetic */ List accessor$LazyJavaPackageFragment$lambda1(LazyJavaPackageFragment lazyJavaPackageFragment) {
        return LazyJavaPackageFragment.subPackages$lambda$3(lazyJavaPackageFragment);
    }

    static /* synthetic */ HashMap accessor$LazyJavaPackageFragment$lambda2(LazyJavaPackageFragment lazyJavaPackageFragment) {
        return LazyJavaPackageFragment.partToFacade_delegate$lambda$4(lazyJavaPackageFragment);
    }

    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[KotlinClassHeader.Kind.values().length];
            try {
                nArray[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

