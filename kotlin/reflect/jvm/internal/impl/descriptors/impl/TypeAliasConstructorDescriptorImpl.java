/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitContextReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nTypeAliasConstructorDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeAliasConstructorDescriptor.kt\norg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptorImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,238:1\n1#2:239\n1563#3:240\n1634#3,3:241\n*S KotlinDebug\n*F\n+ 1 TypeAliasConstructorDescriptor.kt\norg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptorImpl\n*L\n87#1:240\n87#1:241,3\n*E\n"})
public final class TypeAliasConstructorDescriptorImpl
extends FunctionDescriptorImpl
implements TypeAliasConstructorDescriptor {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final StorageManager storageManager;
    @NotNull
    private final TypeAliasDescriptor typeAliasDescriptor;
    @NotNull
    private final NullableLazyValue withDispatchReceiver$delegate;
    @NotNull
    private ClassConstructorDescriptor underlyingConstructorDescriptor;

    private TypeAliasConstructorDescriptorImpl(StorageManager storageManager, TypeAliasDescriptor typeAliasDescriptor, ClassConstructorDescriptor underlyingConstructorDescriptor, TypeAliasConstructorDescriptor original, Annotations annotations, CallableMemberDescriptor.Kind kind2, SourceElement source) {
        super(typeAliasDescriptor, original, annotations, SpecialNames.INIT, kind2, source);
        this.storageManager = storageManager;
        this.typeAliasDescriptor = typeAliasDescriptor;
        this.setActual(this.getTypeAliasDescriptor().isActual());
        ClassConstructorDescriptor classConstructorDescriptor = underlyingConstructorDescriptor;
        TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl = this;
        this.withDispatchReceiver$delegate = this.storageManager.createNullableLazyValue(new TypeAliasConstructorDescriptorImpl$$Lambda$0(typeAliasConstructorDescriptorImpl, classConstructorDescriptor));
        this.underlyingConstructorDescriptor = underlyingConstructorDescriptor;
    }

    @NotNull
    public TypeAliasDescriptor getTypeAliasDescriptor() {
        return this.typeAliasDescriptor;
    }

    @Override
    @NotNull
    public ClassConstructorDescriptor getUnderlyingConstructorDescriptor() {
        return this.underlyingConstructorDescriptor;
    }

    @Override
    public boolean isPrimary() {
        return this.getUnderlyingConstructorDescriptor().isPrimary();
    }

    @Override
    @NotNull
    public TypeAliasDescriptor getContainingDeclaration() {
        return this.getTypeAliasDescriptor();
    }

    @Override
    @NotNull
    public ClassDescriptor getConstructedClass() {
        ClassDescriptor classDescriptor = this.getUnderlyingConstructorDescriptor().getConstructedClass();
        Intrinsics.checkNotNullExpressionValue(classDescriptor, "getConstructedClass(...)");
        return classDescriptor;
    }

    @Override
    @NotNull
    public KotlinType getReturnType() {
        KotlinType kotlinType = super.getReturnType();
        Intrinsics.checkNotNull(kotlinType);
        return kotlinType;
    }

    @Override
    @NotNull
    public TypeAliasConstructorDescriptor getOriginal() {
        FunctionDescriptor functionDescriptor = super.getOriginal();
        Intrinsics.checkNotNull(functionDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (TypeAliasConstructorDescriptor)functionDescriptor;
    }

    @Override
    @Nullable
    public TypeAliasConstructorDescriptor substitute(@NotNull TypeSubstitutor substitutor) {
        ClassConstructorDescriptor substitutedUnderlyingConstructor;
        Intrinsics.checkNotNullParameter(substitutor, "substitutor");
        FunctionDescriptor functionDescriptor = super.substitute(substitutor);
        Intrinsics.checkNotNull(functionDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        TypeAliasConstructorDescriptorImpl substitutedTypeAliasConstructor = (TypeAliasConstructorDescriptorImpl)functionDescriptor;
        TypeSubstitutor typeSubstitutor2 = TypeSubstitutor.create(substitutedTypeAliasConstructor.getReturnType());
        Intrinsics.checkNotNullExpressionValue(typeSubstitutor2, "create(...)");
        TypeSubstitutor underlyingConstructorSubstitutor = typeSubstitutor2;
        ClassConstructorDescriptor classConstructorDescriptor = this.getUnderlyingConstructorDescriptor().getOriginal().substitute(underlyingConstructorSubstitutor);
        if (classConstructorDescriptor == null) {
            return null;
        }
        substitutedTypeAliasConstructor.underlyingConstructorDescriptor = substitutedUnderlyingConstructor = classConstructorDescriptor;
        return substitutedTypeAliasConstructor;
    }

    @Override
    @NotNull
    public TypeAliasConstructorDescriptor copy(@NotNull DeclarationDescriptor newOwner, @NotNull Modality modality2, @NotNull DescriptorVisibility visibility2, @NotNull CallableMemberDescriptor.Kind kind2, boolean copyOverrides) {
        Intrinsics.checkNotNullParameter(newOwner, "newOwner");
        Intrinsics.checkNotNullParameter((Object)modality2, "modality");
        Intrinsics.checkNotNullParameter(visibility2, "visibility");
        Intrinsics.checkNotNullParameter((Object)kind2, "kind");
        FunctionDescriptor functionDescriptor = this.newCopyBuilder().setOwner(newOwner).setModality(modality2).setVisibility(visibility2).setKind(kind2).setCopyOverrides(copyOverrides).build();
        Intrinsics.checkNotNull(functionDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (TypeAliasConstructorDescriptor)functionDescriptor;
    }

    @Override
    @NotNull
    protected TypeAliasConstructorDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor newOwner, @Nullable FunctionDescriptor original, @NotNull CallableMemberDescriptor.Kind kind2, @Nullable Name newName, @NotNull Annotations annotations, @NotNull SourceElement source) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(newOwner, "newOwner");
        Intrinsics.checkNotNullParameter((Object)kind2, "kind");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(source, "source");
        boolean bl3 = bl2 = kind2 == CallableMemberDescriptor.Kind.DECLARATION || kind2 == CallableMemberDescriptor.Kind.SYNTHESIZED;
        if (_Assertions.ENABLED && !bl2) {
            boolean $i$a$-assert-TypeAliasConstructorDescriptorImpl$createSubstitutedCopy$32 = false;
            String $i$a$-assert-TypeAliasConstructorDescriptorImpl$createSubstitutedCopy$32 = "Creating a type alias constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + newOwner + "\nkind: " + (Object)((Object)kind2);
            throw new AssertionError((Object)$i$a$-assert-TypeAliasConstructorDescriptorImpl$createSubstitutedCopy$32);
        }
        boolean bl4 = bl2 = newName == null;
        if (_Assertions.ENABLED && !bl2) {
            boolean bl5 = false;
            String string = "Renaming type alias constructor: " + this;
            throw new AssertionError((Object)string);
        }
        return new TypeAliasConstructorDescriptorImpl(this.storageManager, this.getTypeAliasDescriptor(), this.getUnderlyingConstructorDescriptor(), this, annotations, CallableMemberDescriptor.Kind.DECLARATION, source);
    }

    /*
     * WARNING - void declaration
     */
    private static final TypeAliasConstructorDescriptorImpl withDispatchReceiver_delegate$lambda$2(TypeAliasConstructorDescriptorImpl this$0, ClassConstructorDescriptor $underlyingConstructorDescriptor) {
        Collection<ReceiverParameterDescriptor> collection;
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl;
        StorageManager storageManager = this$0.storageManager;
        TypeAliasDescriptor typeAliasDescriptor = this$0.getTypeAliasDescriptor();
        TypeAliasConstructorDescriptor typeAliasConstructorDescriptor = this$0;
        Annotations annotations = $underlyingConstructorDescriptor.getAnnotations();
        CallableMemberDescriptor.Kind kind2 = $underlyingConstructorDescriptor.getKind();
        Intrinsics.checkNotNullExpressionValue((Object)kind2, "getKind(...)");
        SourceElement sourceElement = this$0.getTypeAliasDescriptor().getSource();
        Intrinsics.checkNotNullExpressionValue(sourceElement, "getSource(...)");
        TypeAliasConstructorDescriptorImpl typeAliasConstructor = typeAliasConstructorDescriptorImpl = new TypeAliasConstructorDescriptorImpl(storageManager, typeAliasDescriptor, $underlyingConstructorDescriptor, typeAliasConstructorDescriptor, annotations, kind2, sourceElement);
        boolean bl2 = false;
        TypeSubstitutor typeSubstitutor2 = TypeAliasConstructorDescriptorImpl.Companion.getTypeSubstitutorForUnderlyingClass(this$0.getTypeAliasDescriptor());
        if (typeSubstitutor2 == null) {
            return null;
        }
        TypeSubstitutor substitutorForUnderlyingClass = typeSubstitutor2;
        ReceiverParameterDescriptor receiverParameterDescriptor = $underlyingConstructorDescriptor.getDispatchReceiverParameter();
        ReceiverParameterDescriptor receiverParameterDescriptor2 = receiverParameterDescriptor != null ? receiverParameterDescriptor.substitute(substitutorForUnderlyingClass) : null;
        List<ReceiverParameterDescriptor> list = $underlyingConstructorDescriptor.getContextReceiverParameters();
        Intrinsics.checkNotNullExpressionValue(list, "getContextReceiverParameters(...)");
        Iterable iterable = list;
        ReceiverParameterDescriptor receiverParameterDescriptor3 = receiverParameterDescriptor2;
        ReceiverParameterDescriptor receiverParameterDescriptor4 = null;
        TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl2 = typeAliasConstructor;
        boolean $i$f$map = false;
        void var11_11 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            ReceiverParameterDescriptor receiverParameterDescriptor5 = (ReceiverParameterDescriptor)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl3 = false;
            collection.add(it.substitute(substitutorForUnderlyingClass));
        }
        collection = (List)destination$iv$iv;
        typeAliasConstructorDescriptorImpl2.initialize(receiverParameterDescriptor4, receiverParameterDescriptor3, (List<ReceiverParameterDescriptor>)collection, (List<? extends TypeParameterDescriptor>)this$0.getTypeAliasDescriptor().getDeclaredTypeParameters(), this$0.getValueParameters(), this$0.getReturnType(), Modality.FINAL, this$0.getTypeAliasDescriptor().getVisibility());
        return typeAliasConstructorDescriptorImpl;
    }

    public /* synthetic */ TypeAliasConstructorDescriptorImpl(StorageManager storageManager, TypeAliasDescriptor typeAliasDescriptor, ClassConstructorDescriptor underlyingConstructorDescriptor, TypeAliasConstructorDescriptor original, Annotations annotations, CallableMemberDescriptor.Kind kind2, SourceElement source, DefaultConstructorMarker $constructor_marker) {
        this(storageManager, typeAliasDescriptor, underlyingConstructorDescriptor, original, annotations, kind2, source);
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1(new PropertyReference1Impl(TypeAliasConstructorDescriptorImpl.class, "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;", 0))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
    }

    static /* synthetic */ TypeAliasConstructorDescriptorImpl accessor$TypeAliasConstructorDescriptorImpl$lambda0(TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl, ClassConstructorDescriptor classConstructorDescriptor) {
        return TypeAliasConstructorDescriptorImpl.withDispatchReceiver_delegate$lambda$2(typeAliasConstructorDescriptorImpl, classConstructorDescriptor);
    }

    @SourceDebugExtension(value={"SMAP\nTypeAliasConstructorDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeAliasConstructorDescriptor.kt\norg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptorImpl$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,238:1\n1573#2:239\n1604#2,4:240\n*S KotlinDebug\n*F\n+ 1 TypeAliasConstructorDescriptor.kt\norg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptorImpl$Companion\n*L\n209#1:239\n209#1:240,4\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        private final TypeSubstitutor getTypeSubstitutorForUnderlyingClass(TypeAliasDescriptor $this$getTypeSubstitutorForUnderlyingClass) {
            if ($this$getTypeSubstitutorForUnderlyingClass.getClassDescriptor() == null) {
                return null;
            }
            return TypeSubstitutor.create($this$getTypeSubstitutorForUnderlyingClass.getExpandedType());
        }

        /*
         * WARNING - void declaration
         */
        @Nullable
        public final TypeAliasConstructorDescriptor createIfAvailable(@NotNull StorageManager storageManager, @NotNull TypeAliasDescriptor typeAliasDescriptor, @NotNull ClassConstructorDescriptor constructor) {
            List list;
            ClassDescriptor classDescriptor;
            ReceiverParameterDescriptor receiverParameterDescriptor;
            Intrinsics.checkNotNullParameter(storageManager, "storageManager");
            Intrinsics.checkNotNullParameter(typeAliasDescriptor, "typeAliasDescriptor");
            Intrinsics.checkNotNullParameter(constructor, "constructor");
            TypeSubstitutor typeSubstitutor2 = this.getTypeSubstitutorForUnderlyingClass(typeAliasDescriptor);
            if (typeSubstitutor2 == null) {
                return null;
            }
            TypeSubstitutor substitutorForUnderlyingClass = typeSubstitutor2;
            ClassConstructorDescriptor classConstructorDescriptor = constructor.substitute(substitutorForUnderlyingClass);
            if (classConstructorDescriptor == null) {
                return null;
            }
            ClassConstructorDescriptor substitutedConstructor = classConstructorDescriptor;
            Annotations annotations = constructor.getAnnotations();
            CallableMemberDescriptor.Kind kind2 = constructor.getKind();
            Intrinsics.checkNotNullExpressionValue((Object)kind2, "getKind(...)");
            SourceElement sourceElement = typeAliasDescriptor.getSource();
            Intrinsics.checkNotNullExpressionValue(sourceElement, "getSource(...)");
            TypeAliasConstructorDescriptorImpl typeAliasConstructor = new TypeAliasConstructorDescriptorImpl(storageManager, typeAliasDescriptor, substitutedConstructor, null, annotations, kind2, sourceElement, null);
            List<ValueParameterDescriptor> list2 = FunctionDescriptorImpl.getSubstitutedValueParameters(typeAliasConstructor, constructor.getValueParameters(), substitutorForUnderlyingClass);
            if (list2 == null) {
                return null;
            }
            List<ValueParameterDescriptor> valueParameters = list2;
            SimpleType simpleType = FlexibleTypesKt.lowerIfFlexible(substitutedConstructor.getReturnType().unwrap());
            SimpleType simpleType2 = typeAliasDescriptor.getDefaultType();
            Intrinsics.checkNotNullExpressionValue(simpleType2, "getDefaultType(...)");
            SimpleType returnType = SpecialTypesKt.withAbbreviation(simpleType, simpleType2);
            ReceiverParameterDescriptor receiverParameterDescriptor2 = constructor.getDispatchReceiverParameter();
            if (receiverParameterDescriptor2 != null) {
                ReceiverParameterDescriptor it = receiverParameterDescriptor2;
                boolean bl2 = false;
                receiverParameterDescriptor = DescriptorFactory.createExtensionReceiverParameterForCallable(typeAliasConstructor, substitutorForUnderlyingClass.safeSubstitute(it.getType(), Variance.INVARIANT), Annotations.Companion.getEMPTY());
            } else {
                receiverParameterDescriptor = null;
            }
            ReceiverParameterDescriptor receiverParameter = receiverParameterDescriptor;
            ClassDescriptor classDescriptor2 = classDescriptor = typeAliasDescriptor.getClassDescriptor();
            if (classDescriptor2 != null) {
                void $this$mapIndexedTo$iv$iv;
                ClassDescriptor it = classDescriptor2;
                boolean bl3 = false;
                List<ReceiverParameterDescriptor> list3 = constructor.getContextReceiverParameters();
                Intrinsics.checkNotNullExpressionValue(list3, "getContextReceiverParameters(...)");
                Iterable $this$mapIndexed$iv = list3;
                boolean $i$f$mapIndexed = false;
                Iterable iterable = $this$mapIndexed$iv;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                boolean $i$f$mapIndexedTo = false;
                int index$iv$iv = 0;
                for (Object item$iv$iv : $this$mapIndexedTo$iv$iv) {
                    void index;
                    void contextReceiver;
                    int n2;
                    if ((n2 = index$iv$iv++) < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    ReceiverParameterDescriptor receiverParameterDescriptor3 = (ReceiverParameterDescriptor)item$iv$iv;
                    int n3 = n2;
                    Collection collection = destination$iv$iv;
                    boolean bl4 = false;
                    KotlinType kotlinType = substitutorForUnderlyingClass.safeSubstitute(contextReceiver.getType(), Variance.INVARIANT);
                    ReceiverValue receiverValue = contextReceiver.getValue();
                    Intrinsics.checkNotNull(receiverValue, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.receivers.ImplicitContextReceiver");
                    collection.add(DescriptorFactory.createContextReceiverParameterForClass(classDescriptor, kotlinType, ((ImplicitContextReceiver)receiverValue).getCustomLabelName(), Annotations.Companion.getEMPTY(), (int)index));
                }
                list = (List)destination$iv$iv;
            } else {
                list = CollectionsKt.emptyList();
            }
            List contextReceiverParameters = list;
            typeAliasConstructor.initialize(receiverParameter, null, contextReceiverParameters, typeAliasDescriptor.getDeclaredTypeParameters(), valueParameters, returnType, Modality.FINAL, typeAliasDescriptor.getVisibility());
            return typeAliasConstructor;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

