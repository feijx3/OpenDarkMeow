/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nPackagePartScopeCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PackagePartScopeCache.kt\norg/jetbrains/kotlin/descriptors/runtime/components/PackagePartScopeCache\n+ 2 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,41:1\n72#2,2:42\n1617#3,9:44\n1869#3:53\n1870#3:55\n1626#3:56\n1617#3,9:57\n1869#3:66\n1870#3:68\n1626#3:69\n1#4:54\n1#4:67\n1#4:70\n*S KotlinDebug\n*F\n+ 1 PackagePartScopeCache.kt\norg/jetbrains/kotlin/descriptors/runtime/components/PackagePartScopeCache\n*L\n21#1:42,2\n26#1:44,9\n26#1:53\n26#1:55\n26#1:56\n34#1:57,9\n34#1:66\n34#1:68\n34#1:69\n26#1:54\n34#1:67\n21#1:70\n*E\n"})
public final class PackagePartScopeCache {
    @NotNull
    private final DeserializedDescriptorResolver resolver;
    @NotNull
    private final ReflectKotlinClassFinder kotlinClassFinder;
    @NotNull
    private final ConcurrentHashMap<ClassId, MemberScope> cache;

    public PackagePartScopeCache(@NotNull DeserializedDescriptorResolver resolver, @NotNull ReflectKotlinClassFinder kotlinClassFinder) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        this.resolver = resolver;
        this.kotlinClassFinder = kotlinClassFinder;
        this.cache = new ConcurrentHashMap();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final MemberScope getPackagePartScope(@NotNull ReflectKotlinClass fileClass) {
        void $this$getOrPut$iv;
        Intrinsics.checkNotNullParameter(fileClass, "fileClass");
        ConcurrentMap concurrentMap = this.cache;
        ClassId key$iv = fileClass.getClassId();
        boolean $i$f$getOrPut = false;
        Object object = $this$getOrPut$iv.get(key$iv);
        if (object == null) {
            void $this$mapNotNullTo$iv$iv;
            List list;
            boolean bl2 = false;
            FqName fqName = fileClass.getClassId().getPackageFqName();
            if (fileClass.getClassHeader().getKind() == KotlinClassHeader.Kind.MULTIFILE_CLASS) {
                void $this$mapNotNullTo$iv$iv2;
                Iterable $this$mapNotNull$iv = fileClass.getClassHeader().getMultifilePartNames();
                boolean $i$f$mapNotNull = false;
                Iterable iterable = $this$mapNotNull$iv;
                Collection destination$iv$iv = new ArrayList();
                boolean $i$f$mapNotNullTo = false;
                void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv2;
                boolean $i$f$forEach = false;
                Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
                while (iterator2.hasNext()) {
                    KotlinJvmBinaryClass it$iv$iv;
                    Object element$iv$iv$iv;
                    Object element$iv$iv = element$iv$iv$iv = iterator2.next();
                    boolean bl3 = false;
                    String partName = (String)element$iv$iv;
                    boolean bl4 = false;
                    FqName fqName2 = JvmClassName.byInternalName(partName).getFqNameForTopLevelClassMaybeWithDollars();
                    Intrinsics.checkNotNullExpressionValue(fqName2, "getFqNameForTopLevelClassMaybeWithDollars(...)");
                    ClassId classId = ClassId.Companion.topLevel(fqName2);
                    if (KotlinClassFinderKt.findKotlinClass((KotlinClassFinder)this.kotlinClassFinder, classId, this.resolver.getComponents().getConfiguration().getMetadataVersion()) == null) continue;
                    boolean bl5 = false;
                    destination$iv$iv.add(it$iv$iv);
                }
                list = (List)destination$iv$iv;
            } else {
                list = CollectionsKt.listOf(fileClass);
            }
            List parts = list;
            EmptyPackageFragmentDescriptor packageFragment = new EmptyPackageFragmentDescriptor(this.resolver.getComponents().getModuleDescriptor(), fqName);
            Iterable $this$mapNotNull$iv = parts;
            boolean $i$f$mapNotNull = false;
            Iterable $i$f$mapNotNullTo = $this$mapNotNull$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$mapNotNullTo2 = false;
            void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
            boolean $i$f$forEach = false;
            Iterator iterator3 = $this$forEach$iv$iv$iv.iterator();
            while (iterator3.hasNext()) {
                MemberScope it$iv$iv;
                Object element$iv$iv$iv;
                Object element$iv$iv = element$iv$iv$iv = iterator3.next();
                boolean bl6 = false;
                KotlinJvmBinaryClass part = (KotlinJvmBinaryClass)element$iv$iv;
                boolean bl7 = false;
                if (this.resolver.createKotlinPackagePartScope(packageFragment, part) == null) continue;
                boolean bl8 = false;
                destination$iv$iv.add(it$iv$iv);
            }
            List scopes = CollectionsKt.toList((List)destination$iv$iv);
            MemberScope default$iv = ChainedMemberScope.Companion.create("package " + fqName + " (" + fileClass + ')', scopes);
            boolean bl9 = false;
            object = $this$getOrPut$iv.putIfAbsent(key$iv, default$iv);
            if (object == null) {
                object = default$iv;
            }
        }
        Intrinsics.checkNotNullExpressionValue(object, "getOrPut(...)");
        return (MemberScope)object;
    }
}

