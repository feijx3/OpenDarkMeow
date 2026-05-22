/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NotFoundClasses {
    @NotNull
    private final StorageManager storageManager;
    @NotNull
    private final ModuleDescriptor module;
    @NotNull
    private final MemoizedFunctionToNotNull<FqName, PackageFragmentDescriptor> packageFragments;
    @NotNull
    private final MemoizedFunctionToNotNull<ClassRequest, ClassDescriptor> classes;

    public NotFoundClasses(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor module) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(module, "module");
        this.storageManager = storageManager;
        this.module = module;
        NotFoundClasses notFoundClasses = this;
        this.packageFragments = this.storageManager.createMemoizedFunction(new NotFoundClasses$$Lambda$0(notFoundClasses));
        notFoundClasses = this;
        this.classes = this.storageManager.createMemoizedFunction(new NotFoundClasses$$Lambda$1(notFoundClasses));
    }

    @NotNull
    public final ClassDescriptor getClass(@NotNull ClassId classId, @NotNull List<Integer> typeParametersCount2) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(typeParametersCount2, "typeParametersCount");
        return (ClassDescriptor)this.classes.invoke(new ClassRequest(classId, typeParametersCount2));
    }

    private static final PackageFragmentDescriptor packageFragments$lambda$0(NotFoundClasses this$0, FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return new EmptyPackageFragmentDescriptor(this$0.module, fqName);
    }

    /*
     * Unable to fully structure code
     */
    private static final ClassDescriptor classes$lambda$2(NotFoundClasses this$0, ClassRequest var1_1) {
        Intrinsics.checkNotNullParameter(var1_1, "<destruct>");
        classId = var1_1.component1();
        typeParametersCount = var1_1.component2();
        if (classId.isLocal()) {
            throw new UnsupportedOperationException("Unresolved local class: " + classId);
        }
        v0 = classId.getOuterClassId();
        if (v0 == null) ** GOTO lbl-1000
        outerClassId = v0;
        $i$a$-let-NotFoundClasses$classes$1$container$1 = false;
        v1 = this$0.getClass(outerClassId, CollectionsKt.drop((Iterable)typeParametersCount, 1));
        v0 = v1;
        if (v1 != null) {
            v2 = (ClassOrPackageFragmentDescriptor)v0;
        } else lbl-1000:
        // 2 sources

        {
            v2 = (ClassOrPackageFragmentDescriptor)this$0.packageFragments.invoke(classId.getPackageFqName());
        }
        container = v2;
        isInner = classId.isNestedClass();
        v3 = CollectionsKt.firstOrNull(typeParametersCount);
        return new MockClassDescriptor(this$0.storageManager, (DeclarationDescriptor)container, classId.getShortClassName(), isInner, v3 != null ? v3 : 0);
    }

    static /* synthetic */ PackageFragmentDescriptor accessor$NotFoundClasses$lambda0(NotFoundClasses notFoundClasses, FqName fqName) {
        return NotFoundClasses.packageFragments$lambda$0(notFoundClasses, fqName);
    }

    static /* synthetic */ ClassDescriptor accessor$NotFoundClasses$lambda1(NotFoundClasses notFoundClasses, ClassRequest classRequest) {
        return NotFoundClasses.classes$lambda$2(notFoundClasses, classRequest);
    }

    private static final class ClassRequest {
        @NotNull
        private final ClassId classId;
        @NotNull
        private final List<Integer> typeParametersCount;

        public ClassRequest(@NotNull ClassId classId, @NotNull List<Integer> typeParametersCount2) {
            Intrinsics.checkNotNullParameter(classId, "classId");
            Intrinsics.checkNotNullParameter(typeParametersCount2, "typeParametersCount");
            this.classId = classId;
            this.typeParametersCount = typeParametersCount2;
        }

        @NotNull
        public final ClassId component1() {
            return this.classId;
        }

        @NotNull
        public final List<Integer> component2() {
            return this.typeParametersCount;
        }

        @NotNull
        public String toString() {
            return "ClassRequest(classId=" + this.classId + ", typeParametersCount=" + this.typeParametersCount + ')';
        }

        public int hashCode() {
            int result = this.classId.hashCode();
            result = result * 31 + ((Object)this.typeParametersCount).hashCode();
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClassRequest)) {
                return false;
            }
            ClassRequest classRequest = (ClassRequest)other;
            if (!Intrinsics.areEqual(this.classId, classRequest.classId)) {
                return false;
            }
            return Intrinsics.areEqual(this.typeParametersCount, classRequest.typeParametersCount);
        }
    }

    @SourceDebugExtension(value={"SMAP\nNotFoundClasses.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NotFoundClasses.kt\norg/jetbrains/kotlin/descriptors/NotFoundClasses$MockClassDescriptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,100:1\n1563#2:101\n1634#2,3:102\n*S KotlinDebug\n*F\n+ 1 NotFoundClasses.kt\norg/jetbrains/kotlin/descriptors/NotFoundClasses$MockClassDescriptor\n*L\n55#1:101\n55#1:102,3\n*E\n"})
    public static final class MockClassDescriptor
    extends ClassDescriptorBase {
        private final boolean isInner;
        @NotNull
        private final List<TypeParameterDescriptor> declaredTypeParameters;
        @NotNull
        private final ClassTypeConstructorImpl typeConstructor;

        /*
         * WARNING - void declaration
         */
        public MockClassDescriptor(@NotNull StorageManager storageManager, @NotNull DeclarationDescriptor container, @NotNull Name name, boolean isInner, int numberOfDeclaredTypeParameters) {
            void $this$mapTo$iv$iv;
            void $this$map$iv;
            Intrinsics.checkNotNullParameter(storageManager, "storageManager");
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(name, "name");
            super(storageManager, container, name, SourceElement.NO_SOURCE, false);
            this.isInner = isInner;
            Iterable iterable = RangesKt.until(0, numberOfDeclaredTypeParameters);
            MockClassDescriptor mockClassDescriptor = this;
            boolean $i$f$map = false;
            void var8_9 = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            Iterator iterator2 = $this$mapTo$iv$iv.iterator();
            while (iterator2.hasNext()) {
                void index;
                int item$iv$iv;
                int n2 = item$iv$iv = ((IntIterator)iterator2).nextInt();
                Collection collection = destination$iv$iv;
                boolean bl2 = false;
                collection.add(TypeParameterDescriptorImpl.createWithDefaultBound(this, Annotations.Companion.getEMPTY(), false, Variance.INVARIANT, Name.identifier("" + 'T' + (int)index), (int)index, storageManager));
            }
            mockClassDescriptor.declaredTypeParameters = (List)destination$iv$iv;
            this.typeConstructor = new ClassTypeConstructorImpl(this, TypeParameterUtilsKt.computeConstructorTypeParameters(this), (Collection<KotlinType>)SetsKt.setOf(DescriptorUtilsKt.getModule(this).getBuiltIns().getAnyType()), storageManager);
        }

        @Override
        @NotNull
        public ClassKind getKind() {
            return ClassKind.CLASS;
        }

        @Override
        @NotNull
        public Modality getModality() {
            return Modality.FINAL;
        }

        @Override
        @NotNull
        public DescriptorVisibility getVisibility() {
            DescriptorVisibility descriptorVisibility = DescriptorVisibilities.PUBLIC;
            Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "PUBLIC");
            return descriptorVisibility;
        }

        @Override
        @NotNull
        public ClassTypeConstructorImpl getTypeConstructor() {
            return this.typeConstructor;
        }

        @Override
        @NotNull
        public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
            return this.declaredTypeParameters;
        }

        @Override
        public boolean isInner() {
            return this.isInner;
        }

        @Override
        public boolean isCompanionObject() {
            return false;
        }

        @Override
        public boolean isData() {
            return false;
        }

        @Override
        public boolean isInline() {
            return false;
        }

        @Override
        public boolean isFun() {
            return false;
        }

        @Override
        public boolean isValue() {
            return false;
        }

        @Override
        public boolean isExpect() {
            return false;
        }

        @Override
        public boolean isActual() {
            return false;
        }

        @Override
        public boolean isExternal() {
            return false;
        }

        @Override
        @NotNull
        public Annotations getAnnotations() {
            return Annotations.Companion.getEMPTY();
        }

        @Override
        @NotNull
        protected MemberScope.Empty getUnsubstitutedMemberScope(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            return MemberScope.Empty.INSTANCE;
        }

        @Override
        @NotNull
        public MemberScope.Empty getStaticScope() {
            return MemberScope.Empty.INSTANCE;
        }

        @Override
        @NotNull
        public Collection<ClassConstructorDescriptor> getConstructors() {
            return SetsKt.emptySet();
        }

        @Override
        @Nullable
        public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
            return null;
        }

        @Override
        @Nullable
        public ClassDescriptor getCompanionObjectDescriptor() {
            return null;
        }

        @Override
        @Nullable
        public ValueClassRepresentation<SimpleType> getValueClassRepresentation() {
            return null;
        }

        @NotNull
        public String toString() {
            return "class " + this.getName() + " (not found)";
        }
    }
}

