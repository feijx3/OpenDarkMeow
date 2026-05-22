/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nAbstractTypeAliasDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractTypeAliasDescriptor.kt\norg/jetbrains/kotlin/descriptors/impl/AbstractTypeAliasDescriptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,129:1\n1617#2,9:130\n1869#2:139\n1870#2:141\n1626#2:142\n1#3:140\n*S KotlinDebug\n*F\n+ 1 AbstractTypeAliasDescriptor.kt\norg/jetbrains/kotlin/descriptors/impl/AbstractTypeAliasDescriptor\n*L\n69#1:130,9\n69#1:139\n69#1:141\n69#1:142\n69#1:140\n*E\n"})
public abstract class AbstractTypeAliasDescriptor
extends DeclarationDescriptorNonRootImpl
implements TypeAliasDescriptor {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final StorageManager storageManager;
    @NotNull
    private final DescriptorVisibility visibilityImpl;
    @NotNull
    private final NotNullLazyValue constructors$delegate;
    private List<? extends TypeParameterDescriptor> declaredTypeParametersImpl;
    @NotNull
    private final typeConstructor.1 typeConstructor;

    public AbstractTypeAliasDescriptor(@NotNull StorageManager storageManager, @NotNull DeclarationDescriptor containingDeclaration, @NotNull Annotations annotations, @NotNull Name name, @NotNull SourceElement sourceElement, @NotNull DescriptorVisibility visibilityImpl) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(sourceElement, "sourceElement");
        Intrinsics.checkNotNullParameter(visibilityImpl, "visibilityImpl");
        super(containingDeclaration, annotations, name, sourceElement);
        this.storageManager = storageManager;
        this.visibilityImpl = visibilityImpl;
        AbstractTypeAliasDescriptor abstractTypeAliasDescriptor = this;
        this.constructors$delegate = this.storageManager.createLazyValue(new AbstractTypeAliasDescriptor$$Lambda$0(abstractTypeAliasDescriptor));
        this.typeConstructor = new TypeConstructor(this){
            final /* synthetic */ AbstractTypeAliasDescriptor this$0;
            {
                this.this$0 = $receiver;
            }

            public TypeAliasDescriptor getDeclarationDescriptor() {
                return this.this$0;
            }

            public List<TypeParameterDescriptor> getParameters() {
                return this.this$0.getTypeConstructorTypeParameters();
            }

            public Collection<KotlinType> getSupertypes() {
                Collection<KotlinType> collection = this.getDeclarationDescriptor().getUnderlyingType().getConstructor().getSupertypes();
                Intrinsics.checkNotNullExpressionValue(collection, "getSupertypes(...)");
                return collection;
            }

            public boolean isDenotable() {
                return true;
            }

            public KotlinBuiltIns getBuiltIns() {
                return DescriptorUtilsKt.getBuiltIns(this.getDeclarationDescriptor());
            }

            public String toString() {
                return "[typealias " + this.getDeclarationDescriptor().getName().asString() + ']';
            }

            public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
                Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
                return this;
            }
        };
    }

    @NotNull
    protected final StorageManager getStorageManager() {
        return this.storageManager;
    }

    public final void initialize(@NotNull List<? extends TypeParameterDescriptor> declaredTypeParameters) {
        Intrinsics.checkNotNullParameter(declaredTypeParameters, "declaredTypeParameters");
        this.declaredTypeParametersImpl = declaredTypeParameters;
    }

    @Override
    public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> visitor2, D data) {
        Intrinsics.checkNotNullParameter(visitor2, "visitor");
        return visitor2.visitTypeAliasDescriptor(this, data);
    }

    @Override
    public boolean isInner() {
        AbstractTypeAliasDescriptor abstractTypeAliasDescriptor = this;
        return TypeUtils.contains(this.getUnderlyingType(), new AbstractTypeAliasDescriptor$$Lambda$1(abstractTypeAliasDescriptor));
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final Collection<TypeAliasConstructorDescriptor> getTypeAliasConstructors() {
        void $this$mapNotNullTo$iv$iv;
        ClassDescriptor classDescriptor = this.getClassDescriptor();
        if (classDescriptor == null) {
            return CollectionsKt.emptyList();
        }
        ClassDescriptor classDescriptor2 = classDescriptor;
        Collection<ClassConstructorDescriptor> collection = classDescriptor2.getConstructors();
        Intrinsics.checkNotNullExpressionValue(collection, "getConstructors(...)");
        Iterable $this$mapNotNull$iv = collection;
        boolean $i$f$mapNotNull = false;
        Iterable iterable = $this$mapNotNull$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
        while (iterator2.hasNext()) {
            TypeAliasConstructorDescriptor it$iv$iv;
            Object element$iv$iv$iv;
            Object element$iv$iv = element$iv$iv$iv = iterator2.next();
            boolean bl2 = false;
            ClassConstructorDescriptor it = (ClassConstructorDescriptor)element$iv$iv;
            boolean bl3 = false;
            TypeAliasDescriptor typeAliasDescriptor = this;
            Intrinsics.checkNotNull(it);
            if (TypeAliasConstructorDescriptorImpl.Companion.createIfAvailable(this.storageManager, typeAliasDescriptor, it) == null) continue;
            boolean bl4 = false;
            destination$iv$iv.add(it$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        List<TypeParameterDescriptor> list = this.declaredTypeParametersImpl;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("declaredTypeParametersImpl");
            list = null;
        }
        return list;
    }

    @Override
    @NotNull
    public Modality getModality() {
        return Modality.FINAL;
    }

    @Override
    @NotNull
    public DescriptorVisibility getVisibility() {
        return this.visibilityImpl;
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
    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    @Override
    @NotNull
    public String toString() {
        return "typealias " + this.getName().asString();
    }

    @Override
    @NotNull
    public TypeAliasDescriptor getOriginal() {
        DeclarationDescriptorWithSource declarationDescriptorWithSource = super.getOriginal();
        Intrinsics.checkNotNull(declarationDescriptorWithSource, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeAliasDescriptor");
        return (TypeAliasDescriptor)declarationDescriptorWithSource;
    }

    @NotNull
    protected abstract List<TypeParameterDescriptor> getTypeConstructorTypeParameters();

    @NotNull
    protected final SimpleType computeDefaultType() {
        ClassifierDescriptor classifierDescriptor = this;
        Object object = this.getClassDescriptor();
        if (object == null || (object = object.getUnsubstitutedMemberScope()) == null) {
            object = MemberScope.Empty.INSTANCE;
        }
        AbstractTypeAliasDescriptor abstractTypeAliasDescriptor = this;
        SimpleType simpleType = TypeUtils.makeUnsubstitutedType(classifierDescriptor, (MemberScope)object, (Function1<KotlinTypeRefiner, SimpleType>)new AbstractTypeAliasDescriptor$$Lambda$2(abstractTypeAliasDescriptor));
        Intrinsics.checkNotNullExpressionValue(simpleType, "makeUnsubstitutedType(...)");
        return simpleType;
    }

    private static final Collection constructors_delegate$lambda$0(AbstractTypeAliasDescriptor this$0) {
        return this$0.getTypeAliasConstructors();
    }

    /*
     * Enabled aggressive block sorting
     */
    private static final Boolean isInner$lambda$2(AbstractTypeAliasDescriptor this$0, UnwrappedType type) {
        boolean bl2;
        Intrinsics.checkNotNull(type);
        if (!KotlinTypeKt.isError(type)) {
            AbstractTypeAliasDescriptor $this$isInner_u24lambda_u242_u24lambda_u241 = this$0;
            boolean bl3 = false;
            ClassifierDescriptor constructorDescriptor = type.getConstructor().getDeclarationDescriptor();
            boolean bl4 = constructorDescriptor instanceof TypeParameterDescriptor && !Intrinsics.areEqual(((TypeParameterDescriptor)constructorDescriptor).getContainingDeclaration(), this$0);
            if (bl4) {
                bl2 = true;
                return bl2;
            }
        }
        bl2 = false;
        return bl2;
    }

    private static final SimpleType computeDefaultType$lambda$4(AbstractTypeAliasDescriptor this$0, KotlinTypeRefiner kotlinTypeRefiner) {
        ClassifierDescriptor classifierDescriptor = kotlinTypeRefiner.refineDescriptor(this$0);
        return classifierDescriptor != null ? classifierDescriptor.getDefaultType() : null;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1(new PropertyReference1Impl(AbstractTypeAliasDescriptor.class, "constructors", "getConstructors()Ljava/util/Collection;", 0))};
        $$delegatedProperties = kPropertyArray;
    }

    static /* synthetic */ Collection accessor$AbstractTypeAliasDescriptor$lambda0(AbstractTypeAliasDescriptor abstractTypeAliasDescriptor) {
        return AbstractTypeAliasDescriptor.constructors_delegate$lambda$0(abstractTypeAliasDescriptor);
    }

    static /* synthetic */ Boolean accessor$AbstractTypeAliasDescriptor$lambda1(AbstractTypeAliasDescriptor abstractTypeAliasDescriptor, UnwrappedType unwrappedType) {
        return AbstractTypeAliasDescriptor.isInner$lambda$2(abstractTypeAliasDescriptor, unwrappedType);
    }

    static /* synthetic */ SimpleType accessor$AbstractTypeAliasDescriptor$lambda2(AbstractTypeAliasDescriptor abstractTypeAliasDescriptor, KotlinTypeRefiner kotlinTypeRefiner) {
        return AbstractTypeAliasDescriptor.computeDefaultType$lambda$4(abstractTypeAliasDescriptor, kotlinTypeRefiner);
    }
}

