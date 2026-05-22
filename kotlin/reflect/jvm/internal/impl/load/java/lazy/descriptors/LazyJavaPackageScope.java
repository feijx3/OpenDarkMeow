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
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticScope;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nLazyJavaPackageScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyJavaPackageScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaPackageScope\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,188:1\n1634#2,3:189\n1625#2:192\n1869#2:193\n1870#2:195\n1626#2:196\n774#2:197\n865#2,2:198\n1#3:194\n1#3:200\n*S KotlinDebug\n*F\n+ 1 LazyJavaPackageScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaPackageScope\n*L\n159#1:189,3\n161#1:192\n161#1:193\n161#1:195\n161#1:196\n184#1:197\n184#1:198,2\n161#1:194\n*E\n"})
public final class LazyJavaPackageScope
extends LazyJavaStaticScope {
    @NotNull
    private final JavaPackage jPackage;
    @NotNull
    private final LazyJavaPackageFragment ownerDescriptor;
    @NotNull
    private final NullableLazyValue<Set<String>> knownClassNamesInPackage;
    @NotNull
    private final MemoizedFunctionToNullable<FindClassRequest, ClassDescriptor> classes;

    public LazyJavaPackageScope(@NotNull LazyJavaResolverContext c2, @NotNull JavaPackage jPackage, @NotNull LazyJavaPackageFragment ownerDescriptor) {
        Intrinsics.checkNotNullParameter(c2, "c");
        Intrinsics.checkNotNullParameter(jPackage, "jPackage");
        Intrinsics.checkNotNullParameter(ownerDescriptor, "ownerDescriptor");
        super(c2);
        this.jPackage = jPackage;
        this.ownerDescriptor = ownerDescriptor;
        Object object = this;
        Object object2 = c2;
        this.knownClassNamesInPackage = c2.getStorageManager().createNullableLazyValue(new LazyJavaPackageScope$$Lambda$0((LazyJavaResolverContext)object2, (LazyJavaPackageScope)object));
        object = c2;
        object2 = this;
        this.classes = c2.getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaPackageScope$$Lambda$1((LazyJavaPackageScope)object2, (LazyJavaResolverContext)object));
    }

    @Override
    @NotNull
    protected LazyJavaPackageFragment getOwnerDescriptor() {
        return this.ownerDescriptor;
    }

    private final MetadataVersion getMetadataVersion() {
        return this.getC().getComponents().getDeserializedDescriptorResolver().getComponents().getConfiguration().getMetadataVersion();
    }

    private final KotlinClassLookupResult resolveKotlinBinaryClass(KotlinJvmBinaryClass kotlinClass) {
        ClassDescriptor descriptor2;
        KotlinClassLookupResult kotlinClassLookupResult = kotlinClass == null ? (KotlinClassLookupResult)KotlinClassLookupResult.NotFound.INSTANCE : (kotlinClass.getClassHeader().getKind() == KotlinClassHeader.Kind.CLASS ? ((descriptor2 = this.getC().getComponents().getDeserializedDescriptorResolver().resolveClass(kotlinClass)) != null ? (KotlinClassLookupResult)new KotlinClassLookupResult.Found(descriptor2) : (KotlinClassLookupResult)KotlinClassLookupResult.NotFound.INSTANCE) : (KotlinClassLookupResult)KotlinClassLookupResult.SyntheticClass.INSTANCE);
        return kotlinClassLookupResult;
    }

    @Override
    @Nullable
    public ClassDescriptor getContributedClassifier(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        return this.findClassifier(name, null);
    }

    private final ClassDescriptor findClassifier(Name name, JavaClass javaClass) {
        if (!SpecialNames.INSTANCE.isSafeIdentifier(name)) {
            return null;
        }
        Set knownClassNamesInPackage = (Set)this.knownClassNamesInPackage.invoke();
        if (javaClass == null && knownClassNamesInPackage != null && !knownClassNamesInPackage.contains(name.asString())) {
            return null;
        }
        return (ClassDescriptor)this.classes.invoke(new FindClassRequest(name, javaClass));
    }

    @Nullable
    public final ClassDescriptor findClassifierByJavaClass$descriptors_jvm(@NotNull JavaClass javaClass) {
        Intrinsics.checkNotNullParameter(javaClass, "javaClass");
        return this.findClassifier(javaClass.getName(), javaClass);
    }

    @Override
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        return CollectionsKt.emptyList();
    }

    @Override
    @NotNull
    protected DeclaredMemberIndex computeMemberIndex() {
        return DeclaredMemberIndex.Empty.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    protected Set<Name> computeClassNames(@NotNull DescriptorKindFilter kindFilter, @Nullable Function1<? super Name, Boolean> nameFilter) {
        void $this$mapNotNullTo$iv;
        Set knownClassNamesInPackage;
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        if (!kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getNON_SINGLETON_CLASSIFIERS_MASK())) {
            return SetsKt.emptySet();
        }
        Set set = knownClassNamesInPackage = (Set)this.knownClassNamesInPackage.invoke();
        if (set != null) {
            void $this$mapTo$iv;
            Iterable iterable = set;
            Collection destination$iv = new HashSet();
            boolean $i$f$mapTo = false;
            for (Object item$iv : $this$mapTo$iv) {
                void it;
                String string = (String)item$iv;
                Collection collection = destination$iv;
                boolean bl2 = false;
                collection.add(Name.identifier((String)it));
            }
            return (Set)destination$iv;
        }
        Function1<Name, Boolean> function1 = nameFilter;
        if (function1 == null) {
            function1 = FunctionsKt.alwaysTrue();
        }
        Iterable $this$mapTo$iv = this.jPackage.getClasses(function1);
        Collection destination$iv = new LinkedHashSet();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv = $this$mapNotNullTo$iv;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv$iv.iterator();
        while (iterator2.hasNext()) {
            Name it$iv;
            Object element$iv$iv;
            Object element$iv = element$iv$iv = iterator2.next();
            boolean bl3 = false;
            JavaClass klass = (JavaClass)element$iv;
            boolean bl4 = false;
            if ((klass.getLightClassOriginKind() == LightClassOriginKind.SOURCE ? null : klass.getName()) == null) continue;
            it$iv = it$iv;
            boolean bl5 = false;
            destination$iv.add(it$iv);
        }
        return (Set)destination$iv;
    }

    @Override
    @NotNull
    protected Set<Name> computeFunctionNames(@NotNull DescriptorKindFilter kindFilter, @Nullable Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        return SetsKt.emptySet();
    }

    @Override
    protected void computeNonDeclaredFunctions(@NotNull Collection<SimpleFunctionDescriptor> result, @NotNull Name name) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(name, "name");
    }

    @Override
    @NotNull
    protected Set<Name> computePropertyNames(@NotNull DescriptorKindFilter kindFilter, @Nullable Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        return SetsKt.emptySet();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
        block4: {
            block3: {
                Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
                Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
                if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK() | DescriptorKindFilter.Companion.getNON_SINGLETON_CLASSIFIERS_MASK())) break block3;
                v0 = CollectionsKt.emptyList();
                break block4;
            }
            $this$filter$iv = (Iterable)this.getAllDescriptors().invoke();
            $i$f$filter = false;
            var5_5 = $this$filter$iv;
            destination$iv$iv = new ArrayList<E>();
            $i$f$filterTo = false;
            for (T element$iv$iv : $this$filterTo$iv$iv) {
                it = (DeclarationDescriptor)element$iv$iv;
                $i$a$-filter-LazyJavaPackageScope$getContributedDescriptors$1 = false;
                if (!(it instanceof ClassDescriptor)) ** GOTO lbl-1000
                v1 = ((ClassDescriptor)it).getName();
                Intrinsics.checkNotNullExpressionValue(v1, "getName(...)");
                if (nameFilter.invoke(v1).booleanValue()) {
                    v2 = true;
                } else lbl-1000:
                // 2 sources

                {
                    v2 = false;
                }
                if (!v2) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            v0 = (List)destination$iv$iv;
        }
        return v0;
    }

    private static final Set knownClassNamesInPackage$lambda$0(LazyJavaResolverContext $c, LazyJavaPackageScope this$0) {
        return $c.getComponents().getFinder().knownClassNamesInPackage(this$0.getOwnerDescriptor().getFqName());
    }

    private static final ClassDescriptor classes$lambda$1(LazyJavaPackageScope this$0, LazyJavaResolverContext $c, FindClassRequest request) {
        ClassDescriptor classDescriptor;
        ClassId classId;
        KotlinJvmBinaryClass kotlinBinaryClass;
        KotlinClassFinder.Result kotlinClassOrClassFileContent;
        Intrinsics.checkNotNullParameter(request, "request");
        ClassId requestClassId = new ClassId(this$0.getOwnerDescriptor().getFqName(), request.getName());
        KotlinClassFinder.Result result = kotlinClassOrClassFileContent = request.getJavaClass() != null ? $c.getComponents().getKotlinClassFinder().findKotlinClassOrContent(request.getJavaClass(), this$0.getMetadataVersion()) : $c.getComponents().getKotlinClassFinder().findKotlinClassOrContent(requestClassId, this$0.getMetadataVersion());
        KotlinJvmBinaryClass kotlinJvmBinaryClass = kotlinBinaryClass = result != null ? result.toKotlinJvmBinaryClass() : null;
        ClassId classId2 = classId = kotlinJvmBinaryClass != null ? kotlinJvmBinaryClass.getClassId() : null;
        if (classId != null && (classId.isNestedClass() || classId.isLocal())) {
            return null;
        }
        KotlinClassLookupResult kotlinResult = this$0.resolveKotlinBinaryClass(kotlinBinaryClass);
        if (kotlinResult instanceof KotlinClassLookupResult.Found) {
            classDescriptor = ((KotlinClassLookupResult.Found)kotlinResult).getDescriptor();
        } else if (kotlinResult instanceof KotlinClassLookupResult.SyntheticClass) {
            classDescriptor = null;
        } else if (kotlinResult instanceof KotlinClassLookupResult.NotFound) {
            LazyJavaClassDescriptor lazyJavaClassDescriptor;
            FqName actualFqName;
            JavaClass javaClass;
            JavaClass javaClass2 = request.getJavaClass();
            if (javaClass2 == null) {
                KotlinClassFinder.Result.ClassFileContent classFileContent = kotlinClassOrClassFileContent instanceof KotlinClassFinder.Result.ClassFileContent ? (KotlinClassFinder.Result.ClassFileContent)kotlinClassOrClassFileContent : null;
                javaClass2 = $c.getComponents().getFinder().findClass(new JavaClassFinder.Request(requestClassId, (byte[])(classFileContent != null ? classFileContent.getContent() : null), null, 4, null));
            }
            JavaClass javaClass3 = javaClass = javaClass2;
            if ((javaClass3 != null ? javaClass3.getLightClassOriginKind() : null) == LightClassOriginKind.BINARY) {
                throw new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + javaClass + "\nClassId: " + requestClassId + "\nfindKotlinClass(JavaClass) = " + KotlinClassFinderKt.findKotlinClass($c.getComponents().getKotlinClassFinder(), javaClass, this$0.getMetadataVersion()) + "\nfindKotlinClass(ClassId) = " + KotlinClassFinderKt.findKotlinClass($c.getComponents().getKotlinClassFinder(), requestClassId, this$0.getMetadataVersion()) + '\n');
            }
            JavaClass javaClass4 = javaClass;
            FqName fqName = actualFqName = javaClass4 != null ? javaClass4.getFqName() : null;
            if (actualFqName == null || actualFqName.isRoot() || !Intrinsics.areEqual(actualFqName.parent(), this$0.getOwnerDescriptor().getFqName())) {
                lazyJavaClassDescriptor = null;
            } else {
                LazyJavaClassDescriptor lazyJavaClassDescriptor2 = new LazyJavaClassDescriptor($c, this$0.getOwnerDescriptor(), javaClass, null, 8, null);
                JavaClassesTracker javaClassesTracker = $c.getComponents().getJavaClassesTracker();
                JavaClassDescriptor p0 = lazyJavaClassDescriptor2;
                boolean bl2 = false;
                javaClassesTracker.reportClass(p0);
                lazyJavaClassDescriptor = lazyJavaClassDescriptor2;
            }
            classDescriptor = lazyJavaClassDescriptor;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return classDescriptor;
    }

    static /* synthetic */ Set accessor$LazyJavaPackageScope$lambda0(LazyJavaResolverContext lazyJavaResolverContext, LazyJavaPackageScope lazyJavaPackageScope) {
        return LazyJavaPackageScope.knownClassNamesInPackage$lambda$0(lazyJavaResolverContext, lazyJavaPackageScope);
    }

    static /* synthetic */ ClassDescriptor accessor$LazyJavaPackageScope$lambda1(LazyJavaPackageScope lazyJavaPackageScope, LazyJavaResolverContext lazyJavaResolverContext, FindClassRequest findClassRequest) {
        return LazyJavaPackageScope.classes$lambda$1(lazyJavaPackageScope, lazyJavaResolverContext, findClassRequest);
    }

    private static final class FindClassRequest {
        @NotNull
        private final Name name;
        @Nullable
        private final JavaClass javaClass;

        public FindClassRequest(@NotNull Name name, @Nullable JavaClass javaClass) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.javaClass = javaClass;
        }

        @NotNull
        public final Name getName() {
            return this.name;
        }

        @Nullable
        public final JavaClass getJavaClass() {
            return this.javaClass;
        }

        public boolean equals(@Nullable Object other) {
            return other instanceof FindClassRequest && Intrinsics.areEqual(this.name, ((FindClassRequest)other).name);
        }

        public int hashCode() {
            return this.name.hashCode();
        }
    }

    private static abstract class KotlinClassLookupResult {
        private KotlinClassLookupResult() {
        }

        public /* synthetic */ KotlinClassLookupResult(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public static final class Found
        extends KotlinClassLookupResult {
            @NotNull
            private final ClassDescriptor descriptor;

            public Found(@NotNull ClassDescriptor descriptor2) {
                Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
                super(null);
                this.descriptor = descriptor2;
            }

            @NotNull
            public final ClassDescriptor getDescriptor() {
                return this.descriptor;
            }
        }

        public static final class NotFound
        extends KotlinClassLookupResult {
            @NotNull
            public static final NotFound INSTANCE = new NotFound();

            private NotFound() {
                super(null);
            }
        }

        public static final class SyntheticClass
        extends KotlinClassLookupResult {
            @NotNull
            public static final SyntheticClass INSTANCE = new SyntheticClass();

            private SyntheticClass() {
                super(null);
            }
        }
    }
}

