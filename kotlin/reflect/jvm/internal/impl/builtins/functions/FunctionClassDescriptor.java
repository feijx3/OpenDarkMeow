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
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassScope;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.utils.addToStdlib.AddToStdlibKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nFunctionClassDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FunctionClassDescriptor.kt\norg/jetbrains/kotlin/builtins/functions/FunctionClassDescriptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,146:1\n1563#2:147\n1634#2,3:148\n*S KotlinDebug\n*F\n+ 1 FunctionClassDescriptor.kt\norg/jetbrains/kotlin/builtins/functions/FunctionClassDescriptor\n*L\n54#1:147\n54#1:148,3\n*E\n"})
public final class FunctionClassDescriptor
extends AbstractClassDescriptor {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final StorageManager storageManager;
    @NotNull
    private final PackageFragmentDescriptor containingDeclaration;
    @NotNull
    private final FunctionTypeKind functionTypeKind;
    private final int arity;
    @NotNull
    private final FunctionTypeConstructor typeConstructor;
    @NotNull
    private final FunctionClassScope memberScope;
    @NotNull
    private final List<TypeParameterDescriptor> parameters;
    @NotNull
    private final FunctionClassKind functionKind;
    @NotNull
    private static final ClassId functionClassId;
    @NotNull
    private static final ClassId kFunctionClassId;

    /*
     * WARNING - void declaration
     */
    public FunctionClassDescriptor(@NotNull StorageManager storageManager, @NotNull PackageFragmentDescriptor containingDeclaration, @NotNull FunctionTypeKind functionTypeKind, int arity) {
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
        Intrinsics.checkNotNullParameter(functionTypeKind, "functionTypeKind");
        super(storageManager, functionTypeKind.numberedClassName(arity));
        this.storageManager = storageManager;
        this.containingDeclaration = containingDeclaration;
        this.functionTypeKind = functionTypeKind;
        this.arity = arity;
        this.typeConstructor = new FunctionTypeConstructor();
        this.memberScope = new FunctionClassScope(this.storageManager, this);
        ArrayList<TypeParameterDescriptor> result = new ArrayList<TypeParameterDescriptor>();
        Iterable $this$map$iv = new IntRange(1, this.arity);
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        Iterator iterator2 = $this$mapTo$iv$iv.iterator();
        while (iterator2.hasNext()) {
            void i2;
            int item$iv$iv;
            int n2 = item$iv$iv = ((IntIterator)iterator2).nextInt();
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            FunctionClassDescriptor._init_$typeParameter(result, this, Variance.IN_VARIANCE, "" + 'P' + (int)i2);
            collection.add(Unit.INSTANCE);
        }
        List cfr_ignored_0 = (List)destination$iv$iv;
        FunctionClassDescriptor._init_$typeParameter(result, this, Variance.OUT_VARIANCE, "R");
        this.parameters = CollectionsKt.toList((Iterable)result);
        this.functionKind = FunctionClassKind.Companion.getFunctionClassKind(this.functionTypeKind);
    }

    @NotNull
    public final FunctionTypeKind getFunctionTypeKind() {
        return this.functionTypeKind;
    }

    public final int getArity() {
        return this.arity;
    }

    @Override
    @NotNull
    public PackageFragmentDescriptor getContainingDeclaration() {
        return this.containingDeclaration;
    }

    @Override
    @NotNull
    public MemberScope.Empty getStaticScope() {
        return MemberScope.Empty.INSTANCE;
    }

    @Override
    @NotNull
    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    @Override
    @NotNull
    protected FunctionClassScope getUnsubstitutedMemberScope(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.memberScope;
    }

    @Nullable
    public Void getCompanionObjectDescriptor() {
        return null;
    }

    @NotNull
    public List<ClassConstructorDescriptor> getConstructors() {
        return CollectionsKt.emptyList();
    }

    @Override
    @NotNull
    public ClassKind getKind() {
        return ClassKind.INTERFACE;
    }

    @Override
    @NotNull
    public Modality getModality() {
        return Modality.ABSTRACT;
    }

    @Nullable
    public Void getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override
    @NotNull
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = DescriptorVisibilities.PUBLIC;
        Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "PUBLIC");
        return descriptorVisibility;
    }

    @Override
    public boolean isCompanionObject() {
        return false;
    }

    @Override
    public boolean isInner() {
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
    public SourceElement getSource() {
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        Intrinsics.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
        return sourceElement;
    }

    @Override
    @Nullable
    public ValueClassRepresentation<SimpleType> getValueClassRepresentation() {
        return null;
    }

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.parameters;
    }

    @NotNull
    public String toString() {
        String string = this.getName().asString();
        Intrinsics.checkNotNullExpressionValue(string, "asString(...)");
        return string;
    }

    private static final void _init_$typeParameter(ArrayList<TypeParameterDescriptor> result, FunctionClassDescriptor this$0, Variance variance, String name) {
        result.add(TypeParameterDescriptorImpl.createWithDefaultBound(this$0, Annotations.Companion.getEMPTY(), false, variance, Name.identifier(name), result.size(), this$0.storageManager));
    }

    static {
        Name name = Name.identifier("Function");
        Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
        functionClassId = new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, name);
        Name name2 = Name.identifier("KFunction");
        Intrinsics.checkNotNullExpressionValue(name2, "identifier(...)");
        kFunctionClassId = new ClassId(StandardNames.KOTLIN_REFLECT_FQ_NAME, name2);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @SourceDebugExtension(value={"SMAP\nFunctionClassDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FunctionClassDescriptor.kt\norg/jetbrains/kotlin/builtins/functions/FunctionClassDescriptor$FunctionTypeConstructor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,146:1\n1563#2:147\n1634#2,2:148\n1563#2:150\n1634#2,3:151\n1636#2:154\n*S KotlinDebug\n*F\n+ 1 FunctionClassDescriptor.kt\norg/jetbrains/kotlin/builtins/functions/FunctionClassDescriptor$FunctionTypeConstructor\n*L\n113#1:147\n113#1:148,2\n117#1:150\n117#1:151,3\n113#1:154\n*E\n"})
    private final class FunctionTypeConstructor
    extends AbstractClassTypeConstructor {
        public FunctionTypeConstructor() {
            super(FunctionClassDescriptor.this.storageManager);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        @NotNull
        protected Collection<KotlinType> computeSupertypes() {
            void $this$mapTo$iv$iv;
            ClassId[] classIdArray;
            List<ClassId> list;
            FunctionTypeKind functionTypeKind = FunctionClassDescriptor.this.getFunctionTypeKind();
            if (Intrinsics.areEqual(functionTypeKind, FunctionTypeKind.Function.INSTANCE)) {
                list = CollectionsKt.listOf(functionClassId);
            } else if (Intrinsics.areEqual(functionTypeKind, FunctionTypeKind.KFunction.INSTANCE)) {
                classIdArray = new ClassId[]{kFunctionClassId, new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, FunctionTypeKind.Function.INSTANCE.numberedClassName(FunctionClassDescriptor.this.getArity()))};
                list = CollectionsKt.listOf(classIdArray);
            } else if (Intrinsics.areEqual(functionTypeKind, FunctionTypeKind.SuspendFunction.INSTANCE)) {
                list = CollectionsKt.listOf(functionClassId);
            } else if (Intrinsics.areEqual(functionTypeKind, FunctionTypeKind.KSuspendFunction.INSTANCE)) {
                classIdArray = new ClassId[]{kFunctionClassId, new ClassId(StandardNames.COROUTINES_PACKAGE_FQ_NAME, FunctionTypeKind.SuspendFunction.INSTANCE.numberedClassName(FunctionClassDescriptor.this.getArity()))};
                list = CollectionsKt.listOf(classIdArray);
            } else {
                AddToStdlibKt.shouldNotBeCalled$default(null, 1, null);
                throw new KotlinNothingValueException();
            }
            List<ClassId> supertypes = list;
            ModuleDescriptor moduleDescriptor = FunctionClassDescriptor.this.containingDeclaration.getContainingDeclaration();
            Iterable $this$map$iv = supertypes;
            boolean $i$f$map = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void $this$mapTo$iv$iv2;
                ClassDescriptor descriptor2;
                void id;
                ClassId classId = (ClassId)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl2 = false;
                if (FindClassInModuleKt.findClassAcrossModuleDependencies(moduleDescriptor, (ClassId)id) == null) {
                    throw new IllegalStateException(("Built-in class " + id + " not found").toString());
                }
                Iterable $this$map$iv2 = CollectionsKt.takeLast(this.getParameters(), descriptor2.getTypeConstructor().getParameters().size());
                boolean $i$f$map2 = false;
                Iterable iterable2 = $this$map$iv2;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                boolean $i$f$mapTo2 = false;
                for (Object item$iv$iv2 : $this$mapTo$iv$iv2) {
                    void it;
                    TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor)item$iv$iv2;
                    Collection collection2 = destination$iv$iv2;
                    boolean bl3 = false;
                    collection2.add(new TypeProjectionImpl(it.getDefaultType()));
                }
                List arguments = (List)destination$iv$iv2;
                collection.add(KotlinTypeFactory.simpleNotNullType(TypeAttributes.Companion.getEmpty(), descriptor2, arguments));
            }
            return CollectionsKt.toList((List)destination$iv$iv);
        }

        @Override
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            return FunctionClassDescriptor.this.parameters;
        }

        @Override
        @NotNull
        public FunctionClassDescriptor getDeclarationDescriptor() {
            return FunctionClassDescriptor.this;
        }

        @Override
        public boolean isDenotable() {
            return true;
        }

        @NotNull
        public String toString() {
            return this.getDeclarationDescriptor().toString();
        }

        @Override
        @NotNull
        protected SupertypeLoopChecker getSupertypeLoopChecker() {
            return SupertypeLoopChecker.EMPTY.INSTANCE;
        }
    }
}

