/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes;
import kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class KotlinBuiltIns {
    private ModuleDescriptorImpl builtInsModule;
    private NotNullLazyValue<ModuleDescriptorImpl> postponedBuiltInsModule;
    private final NotNullLazyValue<Primitives> primitives;
    private final NotNullLazyValue<Collection<PackageViewDescriptor>> builtInPackagesImportedByDefault;
    private final MemoizedFunctionToNotNull<Name, ClassDescriptor> builtInClassesByName;
    private final StorageManager storageManager;
    public static final Name BUILTINS_MODULE_NAME = Name.special("<built-ins module>");

    protected KotlinBuiltIns(@NotNull StorageManager storageManager) {
        if (storageManager == null) {
            KotlinBuiltIns.$$$reportNull$$$0(0);
        }
        this.storageManager = storageManager;
        this.builtInPackagesImportedByDefault = storageManager.createLazyValue(new Function0<Collection<PackageViewDescriptor>>(){

            @Override
            public Collection<PackageViewDescriptor> invoke() {
                return Arrays.asList(KotlinBuiltIns.this.getBuiltInsModule().getPackage(StandardNames.BUILT_INS_PACKAGE_FQ_NAME), KotlinBuiltIns.this.getBuiltInsModule().getPackage(StandardNames.COLLECTIONS_PACKAGE_FQ_NAME), KotlinBuiltIns.this.getBuiltInsModule().getPackage(StandardNames.RANGES_PACKAGE_FQ_NAME), KotlinBuiltIns.this.getBuiltInsModule().getPackage(StandardNames.ANNOTATION_PACKAGE_FQ_NAME));
            }
        });
        this.primitives = storageManager.createLazyValue(new Function0<Primitives>(){

            @Override
            public Primitives invoke() {
                EnumMap<PrimitiveType, SimpleType> primitiveTypeToArrayKotlinType = new EnumMap<PrimitiveType, SimpleType>(PrimitiveType.class);
                HashMap<SimpleType, SimpleType> primitiveKotlinTypeToKotlinArrayType = new HashMap<SimpleType, SimpleType>();
                HashMap<SimpleType, SimpleType> kotlinArrayTypeToPrimitiveKotlinType = new HashMap<SimpleType, SimpleType>();
                for (PrimitiveType primitive : PrimitiveType.values()) {
                    SimpleType type = KotlinBuiltIns.this.getBuiltInTypeByClassName(primitive.getTypeName().asString());
                    SimpleType arrayType = KotlinBuiltIns.this.getBuiltInTypeByClassName(primitive.getArrayTypeName().asString());
                    primitiveTypeToArrayKotlinType.put(primitive, arrayType);
                    primitiveKotlinTypeToKotlinArrayType.put(type, arrayType);
                    kotlinArrayTypeToPrimitiveKotlinType.put(arrayType, type);
                }
                return new Primitives(primitiveTypeToArrayKotlinType, primitiveKotlinTypeToKotlinArrayType, kotlinArrayTypeToPrimitiveKotlinType);
            }
        });
        this.builtInClassesByName = storageManager.createMemoizedFunction(new Function1<Name, ClassDescriptor>(){

            @Override
            public ClassDescriptor invoke(Name name) {
                ClassifierDescriptor classifier = KotlinBuiltIns.this.getBuiltInsPackageScope().getContributedClassifier(name, NoLookupLocation.FROM_BUILTINS);
                if (classifier == null) {
                    throw new AssertionError((Object)("Built-in class " + StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(name) + " is not found"));
                }
                if (!(classifier instanceof ClassDescriptor)) {
                    throw new AssertionError((Object)("Must be a class descriptor " + name + ", but was " + classifier));
                }
                return (ClassDescriptor)classifier;
            }
        });
    }

    protected void createBuiltInsModule(boolean isFallback) {
        this.builtInsModule = new ModuleDescriptorImpl(BUILTINS_MODULE_NAME, this.storageManager, this, null);
        this.builtInsModule.initialize(BuiltInsLoader.Companion.getInstance().createPackageFragmentProvider(this.storageManager, this.builtInsModule, this.getClassDescriptorFactories(), this.getPlatformDependentDeclarationFilter(), this.getAdditionalClassPartsProvider(), isFallback));
        this.builtInsModule.setDependencies(this.builtInsModule);
    }

    public void setBuiltInsModule(final @NotNull ModuleDescriptorImpl module) {
        if (module == null) {
            KotlinBuiltIns.$$$reportNull$$$0(1);
        }
        this.storageManager.compute(new Function0<Void>(){

            @Override
            public Void invoke() {
                if (KotlinBuiltIns.this.builtInsModule != null) {
                    throw new AssertionError((Object)("Built-ins module is already set: " + KotlinBuiltIns.this.builtInsModule + " (attempting to reset to " + module + ")"));
                }
                KotlinBuiltIns.this.builtInsModule = module;
                return null;
            }
        });
    }

    @NotNull
    protected AdditionalClassPartsProvider getAdditionalClassPartsProvider() {
        AdditionalClassPartsProvider.None none = AdditionalClassPartsProvider.None.INSTANCE;
        if (none == null) {
            KotlinBuiltIns.$$$reportNull$$$0(3);
        }
        return none;
    }

    @NotNull
    protected PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        PlatformDependentDeclarationFilter.NoPlatformDependent noPlatformDependent = PlatformDependentDeclarationFilter.NoPlatformDependent.INSTANCE;
        if (noPlatformDependent == null) {
            KotlinBuiltIns.$$$reportNull$$$0(4);
        }
        return noPlatformDependent;
    }

    @NotNull
    protected Iterable<ClassDescriptorFactory> getClassDescriptorFactories() {
        List<ClassDescriptorFactory> list = Collections.singletonList(new BuiltInFictitiousFunctionClassFactory(this.storageManager, this.getBuiltInsModule()));
        if (list == null) {
            KotlinBuiltIns.$$$reportNull$$$0(5);
        }
        return list;
    }

    @NotNull
    protected StorageManager getStorageManager() {
        StorageManager storageManager = this.storageManager;
        if (storageManager == null) {
            KotlinBuiltIns.$$$reportNull$$$0(6);
        }
        return storageManager;
    }

    @NotNull
    public ModuleDescriptorImpl getBuiltInsModule() {
        assert (this.builtInsModule != null || this.postponedBuiltInsModule != null) : "Uninitialized built-ins module";
        if (this.builtInsModule == null) {
            this.builtInsModule = (ModuleDescriptorImpl)this.postponedBuiltInsModule.invoke();
        }
        ModuleDescriptorImpl moduleDescriptorImpl = this.builtInsModule;
        if (moduleDescriptorImpl == null) {
            KotlinBuiltIns.$$$reportNull$$$0(7);
        }
        return moduleDescriptorImpl;
    }

    public static boolean isBuiltIn(@NotNull DeclarationDescriptor descriptor2) {
        if (descriptor2 == null) {
            KotlinBuiltIns.$$$reportNull$$$0(9);
        }
        return DescriptorUtils.getParentOfType(descriptor2, BuiltInsPackageFragment.class, false) != null;
    }

    public static boolean isUnderKotlinPackage(@NotNull DeclarationDescriptor descriptor2) {
        if (descriptor2 == null) {
            KotlinBuiltIns.$$$reportNull$$$0(10);
        }
        for (DeclarationDescriptor current = descriptor2; current != null; current = current.getContainingDeclaration()) {
            if (!(current instanceof PackageFragmentDescriptor)) continue;
            return ((PackageFragmentDescriptor)current).getFqName().startsWith(StandardNames.BUILT_INS_PACKAGE_NAME);
        }
        return false;
    }

    @NotNull
    public MemberScope getBuiltInsPackageScope() {
        MemberScope memberScope = this.getBuiltInsModule().getPackage(StandardNames.BUILT_INS_PACKAGE_FQ_NAME).getMemberScope();
        if (memberScope == null) {
            KotlinBuiltIns.$$$reportNull$$$0(11);
        }
        return memberScope;
    }

    @NotNull
    public ClassDescriptor getBuiltInClassByFqName(@NotNull FqName fqName) {
        if (fqName == null) {
            KotlinBuiltIns.$$$reportNull$$$0(12);
        }
        ClassDescriptor descriptor2 = DescriptorUtilKt.resolveClassByFqName(this.getBuiltInsModule(), fqName, NoLookupLocation.FROM_BUILTINS);
        assert (descriptor2 != null) : "Can't find built-in class " + fqName;
        ClassDescriptor classDescriptor = descriptor2;
        if (classDescriptor == null) {
            KotlinBuiltIns.$$$reportNull$$$0(13);
        }
        return classDescriptor;
    }

    @NotNull
    private ClassDescriptor getBuiltInClassByName(@NotNull String simpleName) {
        if (simpleName == null) {
            KotlinBuiltIns.$$$reportNull$$$0(14);
        }
        ClassDescriptor classDescriptor = (ClassDescriptor)this.builtInClassesByName.invoke(Name.identifier(simpleName));
        if (classDescriptor == null) {
            KotlinBuiltIns.$$$reportNull$$$0(15);
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getAny() {
        return this.getBuiltInClassByName("Any");
    }

    @NotNull
    public ClassDescriptor getNothing() {
        return this.getBuiltInClassByName("Nothing");
    }

    @NotNull
    private ClassDescriptor getPrimitiveClassDescriptor(@NotNull PrimitiveType type) {
        if (type == null) {
            KotlinBuiltIns.$$$reportNull$$$0(16);
        }
        return this.getBuiltInClassByName(type.getTypeName().asString());
    }

    @NotNull
    public ClassDescriptor getArray() {
        return this.getBuiltInClassByName("Array");
    }

    @NotNull
    public ClassDescriptor getNumber() {
        return this.getBuiltInClassByName("Number");
    }

    @NotNull
    public ClassDescriptor getUnit() {
        return this.getBuiltInClassByName("Unit");
    }

    @NotNull
    public ClassDescriptor getFunction(int parameterCount) {
        return this.getBuiltInClassByName(StandardNames.getFunctionName(parameterCount));
    }

    @NotNull
    public ClassDescriptor getSuspendFunction(int parameterCount) {
        ClassDescriptor classDescriptor = this.getBuiltInClassByFqName(StandardNames.COROUTINES_PACKAGE_FQ_NAME.child(Name.identifier(StandardNames.getSuspendFunctionName(parameterCount))));
        if (classDescriptor == null) {
            KotlinBuiltIns.$$$reportNull$$$0(18);
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getString() {
        return this.getBuiltInClassByName("String");
    }

    @NotNull
    public ClassDescriptor getComparable() {
        return this.getBuiltInClassByName("Comparable");
    }

    @NotNull
    public ClassDescriptor getKClass() {
        ClassDescriptor classDescriptor = this.getBuiltInClassByFqName(StandardNames.FqNames.kClass.toSafe());
        if (classDescriptor == null) {
            KotlinBuiltIns.$$$reportNull$$$0(21);
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getCollection() {
        ClassDescriptor classDescriptor = this.getBuiltInClassByFqName(StandardNames.FqNames.collection);
        if (classDescriptor == null) {
            KotlinBuiltIns.$$$reportNull$$$0(35);
        }
        return classDescriptor;
    }

    @NotNull
    private SimpleType getBuiltInTypeByClassName(@NotNull String classSimpleName) {
        if (classSimpleName == null) {
            KotlinBuiltIns.$$$reportNull$$$0(47);
        }
        SimpleType simpleType = this.getBuiltInClassByName(classSimpleName).getDefaultType();
        if (simpleType == null) {
            KotlinBuiltIns.$$$reportNull$$$0(48);
        }
        return simpleType;
    }

    @NotNull
    public SimpleType getNothingType() {
        SimpleType simpleType = this.getNothing().getDefaultType();
        if (simpleType == null) {
            KotlinBuiltIns.$$$reportNull$$$0(49);
        }
        return simpleType;
    }

    @NotNull
    public SimpleType getNullableNothingType() {
        SimpleType simpleType = this.getNothingType().makeNullableAsSpecified(true);
        if (simpleType == null) {
            KotlinBuiltIns.$$$reportNull$$$0(50);
        }
        return simpleType;
    }

    @NotNull
    public SimpleType getAnyType() {
        SimpleType simpleType = this.getAny().getDefaultType();
        if (simpleType == null) {
            KotlinBuiltIns.$$$reportNull$$$0(51);
        }
        return simpleType;
    }

    @NotNull
    public SimpleType getNullableAnyType() {
        SimpleType simpleType = this.getAnyType().makeNullableAsSpecified(true);
        if (simpleType == null) {
            KotlinBuiltIns.$$$reportNull$$$0(52);
        }
        return simpleType;
    }

    @NotNull
    public SimpleType getDefaultBound() {
        SimpleType simpleType = this.getNullableAnyType();
        if (simpleType == null) {
            KotlinBuiltIns.$$$reportNull$$$0(53);
        }
        return simpleType;
    }

    @NotNull
    public SimpleType getPrimitiveKotlinType(@NotNull PrimitiveType type) {
        if (type == null) {
            KotlinBuiltIns.$$$reportNull$$$0(54);
        }
        SimpleType simpleType = this.getPrimitiveClassDescriptor(type).getDefaultType();
        if (simpleType == null) {
            KotlinBuiltIns.$$$reportNull$$$0(55);
        }
        return simpleType;
    }

    @NotNull
    public SimpleType getNumberType() {
        SimpleType simpleType = this.getNumber().getDefaultType();
        if (simpleType == null) {
            KotlinBuiltIns.$$$reportNull$$$0(56);
        }
        return simpleType;
    }

    @NotNull
    public SimpleType getByteType() {
        SimpleType simpleType = this.getPrimitiveKotlinType(PrimitiveType.BYTE);
        if (simpleType == null) {
            KotlinBuiltIns.$$$reportNull$$$0(57);
        }
        return simpleType;
    }

    @NotNull
    public SimpleType getShortType() {
        SimpleType simpleType = this.getPrimitiveKotlinType(PrimitiveType.SHORT);
        if (simpleType == null) {
            KotlinBuiltIns.$$$reportNull$$$0(58);
        }
        return simpleType;
    }

    @NotNull
    public SimpleType getIntType() {
        SimpleType simpleType = this.getPrimitiveKotlinType(PrimitiveType.INT);
        if (simpleType == null) {
            KotlinBuiltIns.$$$reportNull$$$0(59);
        }
        return simpleType;
    }

    @NotNull
    public SimpleType getLongType() {
        SimpleType simpleType = this.getPrimitiveKotlinType(PrimitiveType.LONG);
        if (simpleType == null) {
            KotlinBuiltIns.$$$reportNull$$$0(60);
        }
        return simpleType;
    }

    @NotNull
    public SimpleType getFloatType() {
        SimpleType simpleType = this.getPrimitiveKotlinType(PrimitiveType.FLOAT);
        if (simpleType == null) {
            KotlinBuiltIns.$$$reportNull$$$0(61);
        }
        return simpleType;
    }

    @NotNull
    public SimpleType getDoubleType() {
        SimpleType simpleType = this.getPrimitiveKotlinType(PrimitiveType.DOUBLE);
        if (simpleType == null) {
            KotlinBuiltIns.$$$reportNull$$$0(62);
        }
        return simpleType;
    }

    @NotNull
    public SimpleType getCharType() {
        SimpleType simpleType = this.getPrimitiveKotlinType(PrimitiveType.CHAR);
        if (simpleType == null) {
            KotlinBuiltIns.$$$reportNull$$$0(63);
        }
        return simpleType;
    }

    @NotNull
    public SimpleType getBooleanType() {
        SimpleType simpleType = this.getPrimitiveKotlinType(PrimitiveType.BOOLEAN);
        if (simpleType == null) {
            KotlinBuiltIns.$$$reportNull$$$0(64);
        }
        return simpleType;
    }

    @NotNull
    public SimpleType getUnitType() {
        SimpleType simpleType = this.getUnit().getDefaultType();
        if (simpleType == null) {
            KotlinBuiltIns.$$$reportNull$$$0(65);
        }
        return simpleType;
    }

    @NotNull
    public SimpleType getStringType() {
        SimpleType simpleType = this.getString().getDefaultType();
        if (simpleType == null) {
            KotlinBuiltIns.$$$reportNull$$$0(66);
        }
        return simpleType;
    }

    @NotNull
    public KotlinType getArrayElementType(@NotNull KotlinType arrayType) {
        KotlinType result;
        if (arrayType == null) {
            KotlinBuiltIns.$$$reportNull$$$0(68);
        }
        if ((result = this.getArrayElementTypeOrNull(arrayType)) == null) {
            throw new IllegalStateException("not array: " + arrayType);
        }
        KotlinType kotlinType = result;
        if (kotlinType == null) {
            KotlinBuiltIns.$$$reportNull$$$0(69);
        }
        return kotlinType;
    }

    @Nullable
    public KotlinType getArrayElementTypeOrNull(@NotNull KotlinType arrayType) {
        KotlinType unsignedType;
        if (arrayType == null) {
            KotlinBuiltIns.$$$reportNull$$$0(70);
        }
        if (KotlinBuiltIns.isArray(arrayType)) {
            if (arrayType.getArguments().size() != 1) {
                return null;
            }
            return arrayType.getArguments().get(0).getType();
        }
        KotlinType notNullArrayType = TypeUtils.makeNotNullable(arrayType);
        KotlinType primitiveType = ((Primitives)this.primitives.invoke()).kotlinArrayTypeToPrimitiveKotlinType.get(notNullArrayType);
        if (primitiveType != null) {
            return primitiveType;
        }
        ModuleDescriptor module = DescriptorUtils.getContainingModuleOrNull(notNullArrayType);
        if (module != null && (unsignedType = KotlinBuiltIns.getElementTypeForUnsignedArray(notNullArrayType, module)) != null) {
            return unsignedType;
        }
        return null;
    }

    @Nullable
    private static KotlinType getElementTypeForUnsignedArray(@NotNull KotlinType notNullArrayType, @NotNull ModuleDescriptor module) {
        ClassifierDescriptor descriptor2;
        if (notNullArrayType == null) {
            KotlinBuiltIns.$$$reportNull$$$0(71);
        }
        if (module == null) {
            KotlinBuiltIns.$$$reportNull$$$0(72);
        }
        if ((descriptor2 = notNullArrayType.getConstructor().getDeclarationDescriptor()) == null) {
            return null;
        }
        if (!UnsignedTypes.INSTANCE.isShortNameOfUnsignedArray(descriptor2.getName())) {
            return null;
        }
        ClassId arrayClassId = DescriptorUtilsKt.getClassId(descriptor2);
        if (arrayClassId == null) {
            return null;
        }
        ClassId elementClassId = UnsignedTypes.INSTANCE.getUnsignedClassIdByArrayClassId(arrayClassId);
        if (elementClassId == null) {
            return null;
        }
        ClassDescriptor elementClassDescriptor = FindClassInModuleKt.findClassAcrossModuleDependencies(module, elementClassId);
        if (elementClassDescriptor == null) {
            return null;
        }
        return elementClassDescriptor.getDefaultType();
    }

    @NotNull
    public SimpleType getPrimitiveArrayKotlinType(@NotNull PrimitiveType primitiveType) {
        if (primitiveType == null) {
            KotlinBuiltIns.$$$reportNull$$$0(73);
        }
        SimpleType simpleType = ((Primitives)this.primitives.invoke()).primitiveTypeToArrayKotlinType.get((Object)primitiveType);
        if (simpleType == null) {
            KotlinBuiltIns.$$$reportNull$$$0(74);
        }
        return simpleType;
    }

    @Nullable
    public static PrimitiveType getPrimitiveType(@NotNull DeclarationDescriptor descriptor2) {
        if (descriptor2 == null) {
            KotlinBuiltIns.$$$reportNull$$$0(76);
        }
        return StandardNames.FqNames.primitiveTypeShortNames.contains(descriptor2.getName()) ? StandardNames.FqNames.fqNameToPrimitiveType.get(DescriptorUtils.getFqName(descriptor2)) : null;
    }

    @Nullable
    public static PrimitiveType getPrimitiveArrayType(@NotNull DeclarationDescriptor descriptor2) {
        if (descriptor2 == null) {
            KotlinBuiltIns.$$$reportNull$$$0(77);
        }
        return StandardNames.FqNames.primitiveArrayTypeShortNames.contains(descriptor2.getName()) ? StandardNames.FqNames.arrayClassFqNameToPrimitiveType.get(DescriptorUtils.getFqName(descriptor2)) : null;
    }

    @NotNull
    public SimpleType getArrayType(@NotNull Variance projectionType, @NotNull KotlinType argument, @NotNull Annotations annotations) {
        if (projectionType == null) {
            KotlinBuiltIns.$$$reportNull$$$0(78);
        }
        if (argument == null) {
            KotlinBuiltIns.$$$reportNull$$$0(79);
        }
        if (annotations == null) {
            KotlinBuiltIns.$$$reportNull$$$0(80);
        }
        List<TypeProjectionImpl> types = Collections.singletonList(new TypeProjectionImpl(projectionType, argument));
        SimpleType simpleType = KotlinTypeFactory.simpleNotNullType(TypeAttributesKt.toDefaultAttributes(annotations), this.getArray(), types);
        if (simpleType == null) {
            KotlinBuiltIns.$$$reportNull$$$0(81);
        }
        return simpleType;
    }

    @NotNull
    public SimpleType getArrayType(@NotNull Variance projectionType, @NotNull KotlinType argument) {
        if (projectionType == null) {
            KotlinBuiltIns.$$$reportNull$$$0(82);
        }
        if (argument == null) {
            KotlinBuiltIns.$$$reportNull$$$0(83);
        }
        SimpleType simpleType = this.getArrayType(projectionType, argument, Annotations.Companion.getEMPTY());
        if (simpleType == null) {
            KotlinBuiltIns.$$$reportNull$$$0(84);
        }
        return simpleType;
    }

    public static boolean isArray(@NotNull KotlinType type) {
        if (type == null) {
            KotlinBuiltIns.$$$reportNull$$$0(88);
        }
        return KotlinBuiltIns.isConstructedFromGivenClass(type, StandardNames.FqNames.array);
    }

    public static boolean isArrayOrPrimitiveArray(@NotNull ClassDescriptor descriptor2) {
        if (descriptor2 == null) {
            KotlinBuiltIns.$$$reportNull$$$0(89);
        }
        return KotlinBuiltIns.classFqNameEquals(descriptor2, StandardNames.FqNames.array) || KotlinBuiltIns.getPrimitiveArrayType(descriptor2) != null;
    }

    public static boolean isArrayOrPrimitiveArray(@NotNull KotlinType type) {
        if (type == null) {
            KotlinBuiltIns.$$$reportNull$$$0(90);
        }
        return KotlinBuiltIns.isArray(type) || KotlinBuiltIns.isPrimitiveArray(type);
    }

    public static boolean isPrimitiveArray(@NotNull KotlinType type) {
        ClassifierDescriptor descriptor2;
        if (type == null) {
            KotlinBuiltIns.$$$reportNull$$$0(91);
        }
        return (descriptor2 = type.getConstructor().getDeclarationDescriptor()) != null && KotlinBuiltIns.getPrimitiveArrayType(descriptor2) != null;
    }

    @Nullable
    public static PrimitiveType getPrimitiveArrayElementType(@NotNull KotlinType type) {
        ClassifierDescriptor descriptor2;
        if (type == null) {
            KotlinBuiltIns.$$$reportNull$$$0(92);
        }
        return (descriptor2 = type.getConstructor().getDeclarationDescriptor()) == null ? null : KotlinBuiltIns.getPrimitiveArrayType(descriptor2);
    }

    public static boolean isPrimitiveType(@NotNull KotlinType type) {
        if (type == null) {
            KotlinBuiltIns.$$$reportNull$$$0(94);
        }
        return !type.isMarkedNullable() && KotlinBuiltIns.isPrimitiveTypeOrNullablePrimitiveType(type);
    }

    public static boolean isPrimitiveTypeOrNullablePrimitiveType(@NotNull KotlinType type) {
        ClassifierDescriptor descriptor2;
        if (type == null) {
            KotlinBuiltIns.$$$reportNull$$$0(95);
        }
        return (descriptor2 = type.getConstructor().getDeclarationDescriptor()) instanceof ClassDescriptor && KotlinBuiltIns.isPrimitiveClass((ClassDescriptor)descriptor2);
    }

    public static boolean isPrimitiveClass(@NotNull ClassDescriptor descriptor2) {
        if (descriptor2 == null) {
            KotlinBuiltIns.$$$reportNull$$$0(96);
        }
        return KotlinBuiltIns.getPrimitiveType(descriptor2) != null;
    }

    private static boolean isConstructedFromGivenClass(@NotNull KotlinType type, @NotNull FqNameUnsafe fqName) {
        if (type == null) {
            KotlinBuiltIns.$$$reportNull$$$0(97);
        }
        if (fqName == null) {
            KotlinBuiltIns.$$$reportNull$$$0(98);
        }
        return KotlinBuiltIns.isTypeConstructorForGivenClass(type.getConstructor(), fqName);
    }

    public static boolean isTypeConstructorForGivenClass(@NotNull TypeConstructor typeConstructor2, @NotNull FqNameUnsafe fqName) {
        ClassifierDescriptor descriptor2;
        if (typeConstructor2 == null) {
            KotlinBuiltIns.$$$reportNull$$$0(101);
        }
        if (fqName == null) {
            KotlinBuiltIns.$$$reportNull$$$0(102);
        }
        return (descriptor2 = typeConstructor2.getDeclarationDescriptor()) instanceof ClassDescriptor && KotlinBuiltIns.classFqNameEquals(descriptor2, fqName);
    }

    private static boolean classFqNameEquals(@NotNull ClassifierDescriptor descriptor2, @NotNull FqNameUnsafe fqName) {
        if (descriptor2 == null) {
            KotlinBuiltIns.$$$reportNull$$$0(103);
        }
        if (fqName == null) {
            KotlinBuiltIns.$$$reportNull$$$0(104);
        }
        return descriptor2.getName().equals(fqName.shortName()) && fqName.equals(DescriptorUtils.getFqName(descriptor2));
    }

    private static boolean isNotNullConstructedFromGivenClass(@NotNull KotlinType type, @NotNull FqNameUnsafe fqName) {
        if (type == null) {
            KotlinBuiltIns.$$$reportNull$$$0(105);
        }
        if (fqName == null) {
            KotlinBuiltIns.$$$reportNull$$$0(106);
        }
        return !type.isMarkedNullable() && KotlinBuiltIns.isConstructedFromGivenClass(type, fqName);
    }

    public static boolean isSpecialClassWithNoSupertypes(@NotNull ClassDescriptor descriptor2) {
        if (descriptor2 == null) {
            KotlinBuiltIns.$$$reportNull$$$0(107);
        }
        return KotlinBuiltIns.classFqNameEquals(descriptor2, StandardNames.FqNames.any) || KotlinBuiltIns.classFqNameEquals(descriptor2, StandardNames.FqNames.nothing);
    }

    public static boolean isAny(@NotNull ClassDescriptor descriptor2) {
        if (descriptor2 == null) {
            KotlinBuiltIns.$$$reportNull$$$0(108);
        }
        return KotlinBuiltIns.classFqNameEquals(descriptor2, StandardNames.FqNames.any);
    }

    public static boolean isBoolean(@NotNull KotlinType type) {
        if (type == null) {
            KotlinBuiltIns.$$$reportNull$$$0(110);
        }
        return KotlinBuiltIns.isConstructedFromGivenClassAndNotNullable(type, StandardNames.FqNames._boolean);
    }

    public static boolean isUByteArray(@NotNull KotlinType type) {
        if (type == null) {
            KotlinBuiltIns.$$$reportNull$$$0(128);
        }
        return KotlinBuiltIns.isConstructedFromGivenClassAndNotNullable(type, StandardNames.FqNames.uByteArrayFqName.toUnsafe());
    }

    public static boolean isUShortArray(@NotNull KotlinType type) {
        if (type == null) {
            KotlinBuiltIns.$$$reportNull$$$0(129);
        }
        return KotlinBuiltIns.isConstructedFromGivenClassAndNotNullable(type, StandardNames.FqNames.uShortArrayFqName.toUnsafe());
    }

    public static boolean isUIntArray(@NotNull KotlinType type) {
        if (type == null) {
            KotlinBuiltIns.$$$reportNull$$$0(130);
        }
        return KotlinBuiltIns.isConstructedFromGivenClassAndNotNullable(type, StandardNames.FqNames.uIntArrayFqName.toUnsafe());
    }

    public static boolean isULongArray(@NotNull KotlinType type) {
        if (type == null) {
            KotlinBuiltIns.$$$reportNull$$$0(131);
        }
        return KotlinBuiltIns.isConstructedFromGivenClassAndNotNullable(type, StandardNames.FqNames.uLongArrayFqName.toUnsafe());
    }

    public static boolean isUnsignedArrayType(@NotNull KotlinType type) {
        if (type == null) {
            KotlinBuiltIns.$$$reportNull$$$0(132);
        }
        return KotlinBuiltIns.isUByteArray(type) || KotlinBuiltIns.isUShortArray(type) || KotlinBuiltIns.isUIntArray(type) || KotlinBuiltIns.isULongArray(type);
    }

    private static boolean isConstructedFromGivenClassAndNotNullable(@NotNull KotlinType type, @NotNull FqNameUnsafe fqName) {
        if (type == null) {
            KotlinBuiltIns.$$$reportNull$$$0(134);
        }
        if (fqName == null) {
            KotlinBuiltIns.$$$reportNull$$$0(135);
        }
        return KotlinBuiltIns.isConstructedFromGivenClass(type, fqName) && !type.isMarkedNullable();
    }

    public static boolean isNothing(@NotNull KotlinType type) {
        if (type == null) {
            KotlinBuiltIns.$$$reportNull$$$0(136);
        }
        return KotlinBuiltIns.isNothingOrNullableNothing(type) && !TypeUtils.isNullableType(type);
    }

    public static boolean isNothingOrNullableNothing(@NotNull KotlinType type) {
        if (type == null) {
            KotlinBuiltIns.$$$reportNull$$$0(138);
        }
        return KotlinBuiltIns.isConstructedFromGivenClass(type, StandardNames.FqNames.nothing);
    }

    public static boolean isAnyOrNullableAny(@NotNull KotlinType type) {
        if (type == null) {
            KotlinBuiltIns.$$$reportNull$$$0(139);
        }
        return KotlinBuiltIns.isConstructedFromGivenClass(type, StandardNames.FqNames.any);
    }

    public static boolean isNullableAny(@NotNull KotlinType type) {
        if (type == null) {
            KotlinBuiltIns.$$$reportNull$$$0(140);
        }
        return KotlinBuiltIns.isAnyOrNullableAny(type) && type.isMarkedNullable();
    }

    public static boolean isDefaultBound(@NotNull KotlinType type) {
        if (type == null) {
            KotlinBuiltIns.$$$reportNull$$$0(141);
        }
        return KotlinBuiltIns.isNullableAny(type);
    }

    public static boolean isUnit(@NotNull KotlinType type) {
        if (type == null) {
            KotlinBuiltIns.$$$reportNull$$$0(142);
        }
        return KotlinBuiltIns.isNotNullConstructedFromGivenClass(type, StandardNames.FqNames.unit);
    }

    public static boolean isString(@Nullable KotlinType type) {
        return type != null && KotlinBuiltIns.isNotNullConstructedFromGivenClass(type, StandardNames.FqNames.string);
    }

    public static boolean isKClass(@NotNull ClassDescriptor descriptor2) {
        if (descriptor2 == null) {
            KotlinBuiltIns.$$$reportNull$$$0(158);
        }
        return KotlinBuiltIns.classFqNameEquals(descriptor2, StandardNames.FqNames.kClass);
    }

    public static boolean isDeprecated(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            KotlinBuiltIns.$$$reportNull$$$0(160);
        }
        if (declarationDescriptor.getOriginal().getAnnotations().hasAnnotation(StandardNames.FqNames.deprecated)) {
            return true;
        }
        if (declarationDescriptor instanceof PropertyDescriptor) {
            boolean isVar = ((PropertyDescriptor)declarationDescriptor).isVar();
            PropertyGetterDescriptor getter = ((PropertyDescriptor)declarationDescriptor).getGetter();
            PropertySetterDescriptor setter = ((PropertyDescriptor)declarationDescriptor).getSetter();
            return getter != null && KotlinBuiltIns.isDeprecated(getter) && (!isVar || setter != null && KotlinBuiltIns.isDeprecated(setter));
        }
        return false;
    }

    private static /* synthetic */ void $$$reportNull$$$0(int n2) {
        RuntimeException runtimeException;
        Object[] objectArray;
        Object[] objectArray2;
        int n3;
        String string;
        switch (n2) {
            default: {
                string = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
            }
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 11: 
            case 13: 
            case 15: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 30: 
            case 31: 
            case 32: 
            case 33: 
            case 34: 
            case 35: 
            case 36: 
            case 37: 
            case 38: 
            case 39: 
            case 40: 
            case 41: 
            case 42: 
            case 43: 
            case 44: 
            case 45: 
            case 46: 
            case 48: 
            case 49: 
            case 50: 
            case 51: 
            case 52: 
            case 53: 
            case 55: 
            case 56: 
            case 57: 
            case 58: 
            case 59: 
            case 60: 
            case 61: 
            case 62: 
            case 63: 
            case 64: 
            case 65: 
            case 66: 
            case 67: 
            case 69: 
            case 74: 
            case 81: 
            case 84: 
            case 86: 
            case 87: {
                string = "@NotNull method %s.%s must not return null";
                break;
            }
        }
        switch (n2) {
            default: {
                n3 = 3;
                break;
            }
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 11: 
            case 13: 
            case 15: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 30: 
            case 31: 
            case 32: 
            case 33: 
            case 34: 
            case 35: 
            case 36: 
            case 37: 
            case 38: 
            case 39: 
            case 40: 
            case 41: 
            case 42: 
            case 43: 
            case 44: 
            case 45: 
            case 46: 
            case 48: 
            case 49: 
            case 50: 
            case 51: 
            case 52: 
            case 53: 
            case 55: 
            case 56: 
            case 57: 
            case 58: 
            case 59: 
            case 60: 
            case 61: 
            case 62: 
            case 63: 
            case 64: 
            case 65: 
            case 66: 
            case 67: 
            case 69: 
            case 74: 
            case 81: 
            case 84: 
            case 86: 
            case 87: {
                n3 = 2;
                break;
            }
        }
        Object[] objectArray3 = new Object[n3];
        switch (n2) {
            default: {
                objectArray2 = objectArray3;
                objectArray3[0] = "storageManager";
                break;
            }
            case 1: 
            case 72: {
                objectArray2 = objectArray3;
                objectArray3[0] = "module";
                break;
            }
            case 2: {
                objectArray2 = objectArray3;
                objectArray3[0] = "computation";
                break;
            }
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 11: 
            case 13: 
            case 15: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 30: 
            case 31: 
            case 32: 
            case 33: 
            case 34: 
            case 35: 
            case 36: 
            case 37: 
            case 38: 
            case 39: 
            case 40: 
            case 41: 
            case 42: 
            case 43: 
            case 44: 
            case 45: 
            case 46: 
            case 48: 
            case 49: 
            case 50: 
            case 51: 
            case 52: 
            case 53: 
            case 55: 
            case 56: 
            case 57: 
            case 58: 
            case 59: 
            case 60: 
            case 61: 
            case 62: 
            case 63: 
            case 64: 
            case 65: 
            case 66: 
            case 67: 
            case 69: 
            case 74: 
            case 81: 
            case 84: 
            case 86: 
            case 87: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            }
            case 9: 
            case 10: 
            case 76: 
            case 77: 
            case 89: 
            case 96: 
            case 103: 
            case 107: 
            case 108: 
            case 143: 
            case 146: 
            case 147: 
            case 149: 
            case 157: 
            case 158: 
            case 159: {
                objectArray2 = objectArray3;
                objectArray3[0] = "descriptor";
                break;
            }
            case 12: 
            case 98: 
            case 100: 
            case 102: 
            case 104: 
            case 106: 
            case 135: {
                objectArray2 = objectArray3;
                objectArray3[0] = "fqName";
                break;
            }
            case 14: {
                objectArray2 = objectArray3;
                objectArray3[0] = "simpleName";
                break;
            }
            case 16: 
            case 17: 
            case 54: 
            case 88: 
            case 90: 
            case 91: 
            case 92: 
            case 93: 
            case 94: 
            case 95: 
            case 97: 
            case 99: 
            case 105: 
            case 109: 
            case 110: 
            case 111: 
            case 113: 
            case 114: 
            case 115: 
            case 116: 
            case 117: 
            case 118: 
            case 119: 
            case 120: 
            case 121: 
            case 122: 
            case 123: 
            case 124: 
            case 125: 
            case 126: 
            case 127: 
            case 128: 
            case 129: 
            case 130: 
            case 131: 
            case 132: 
            case 133: 
            case 134: 
            case 136: 
            case 137: 
            case 138: 
            case 139: 
            case 140: 
            case 141: 
            case 142: 
            case 144: 
            case 145: 
            case 148: 
            case 150: 
            case 151: 
            case 152: 
            case 153: 
            case 154: 
            case 155: 
            case 156: 
            case 161: {
                objectArray2 = objectArray3;
                objectArray3[0] = "type";
                break;
            }
            case 47: {
                objectArray2 = objectArray3;
                objectArray3[0] = "classSimpleName";
                break;
            }
            case 68: 
            case 70: {
                objectArray2 = objectArray3;
                objectArray3[0] = "arrayType";
                break;
            }
            case 71: {
                objectArray2 = objectArray3;
                objectArray3[0] = "notNullArrayType";
                break;
            }
            case 73: {
                objectArray2 = objectArray3;
                objectArray3[0] = "primitiveType";
                break;
            }
            case 75: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kotlinType";
                break;
            }
            case 78: 
            case 82: {
                objectArray2 = objectArray3;
                objectArray3[0] = "projectionType";
                break;
            }
            case 79: 
            case 83: 
            case 85: {
                objectArray2 = objectArray3;
                objectArray3[0] = "argument";
                break;
            }
            case 80: {
                objectArray2 = objectArray3;
                objectArray3[0] = "annotations";
                break;
            }
            case 101: {
                objectArray2 = objectArray3;
                objectArray3[0] = "typeConstructor";
                break;
            }
            case 112: {
                objectArray2 = objectArray3;
                objectArray3[0] = "classDescriptor";
                break;
            }
            case 160: {
                objectArray2 = objectArray3;
                objectArray3[0] = "declarationDescriptor";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray2;
                objectArray2[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            }
            case 3: {
                objectArray = objectArray2;
                objectArray2[1] = "getAdditionalClassPartsProvider";
                break;
            }
            case 4: {
                objectArray = objectArray2;
                objectArray2[1] = "getPlatformDependentDeclarationFilter";
                break;
            }
            case 5: {
                objectArray = objectArray2;
                objectArray2[1] = "getClassDescriptorFactories";
                break;
            }
            case 6: {
                objectArray = objectArray2;
                objectArray2[1] = "getStorageManager";
                break;
            }
            case 7: {
                objectArray = objectArray2;
                objectArray2[1] = "getBuiltInsModule";
                break;
            }
            case 8: {
                objectArray = objectArray2;
                objectArray2[1] = "getBuiltInPackagesImportedByDefault";
                break;
            }
            case 11: {
                objectArray = objectArray2;
                objectArray2[1] = "getBuiltInsPackageScope";
                break;
            }
            case 13: {
                objectArray = objectArray2;
                objectArray2[1] = "getBuiltInClassByFqName";
                break;
            }
            case 15: {
                objectArray = objectArray2;
                objectArray2[1] = "getBuiltInClassByName";
                break;
            }
            case 18: {
                objectArray = objectArray2;
                objectArray2[1] = "getSuspendFunction";
                break;
            }
            case 19: {
                objectArray = objectArray2;
                objectArray2[1] = "getKFunction";
                break;
            }
            case 20: {
                objectArray = objectArray2;
                objectArray2[1] = "getKSuspendFunction";
                break;
            }
            case 21: {
                objectArray = objectArray2;
                objectArray2[1] = "getKClass";
                break;
            }
            case 22: {
                objectArray = objectArray2;
                objectArray2[1] = "getKType";
                break;
            }
            case 23: {
                objectArray = objectArray2;
                objectArray2[1] = "getKCallable";
                break;
            }
            case 24: {
                objectArray = objectArray2;
                objectArray2[1] = "getKProperty";
                break;
            }
            case 25: {
                objectArray = objectArray2;
                objectArray2[1] = "getKProperty0";
                break;
            }
            case 26: {
                objectArray = objectArray2;
                objectArray2[1] = "getKProperty1";
                break;
            }
            case 27: {
                objectArray = objectArray2;
                objectArray2[1] = "getKProperty2";
                break;
            }
            case 28: {
                objectArray = objectArray2;
                objectArray2[1] = "getKMutableProperty0";
                break;
            }
            case 29: {
                objectArray = objectArray2;
                objectArray2[1] = "getKMutableProperty1";
                break;
            }
            case 30: {
                objectArray = objectArray2;
                objectArray2[1] = "getKMutableProperty2";
                break;
            }
            case 31: {
                objectArray = objectArray2;
                objectArray2[1] = "getIterator";
                break;
            }
            case 32: {
                objectArray = objectArray2;
                objectArray2[1] = "getIterable";
                break;
            }
            case 33: {
                objectArray = objectArray2;
                objectArray2[1] = "getMutableIterable";
                break;
            }
            case 34: {
                objectArray = objectArray2;
                objectArray2[1] = "getMutableIterator";
                break;
            }
            case 35: {
                objectArray = objectArray2;
                objectArray2[1] = "getCollection";
                break;
            }
            case 36: {
                objectArray = objectArray2;
                objectArray2[1] = "getMutableCollection";
                break;
            }
            case 37: {
                objectArray = objectArray2;
                objectArray2[1] = "getList";
                break;
            }
            case 38: {
                objectArray = objectArray2;
                objectArray2[1] = "getMutableList";
                break;
            }
            case 39: {
                objectArray = objectArray2;
                objectArray2[1] = "getSet";
                break;
            }
            case 40: {
                objectArray = objectArray2;
                objectArray2[1] = "getMutableSet";
                break;
            }
            case 41: {
                objectArray = objectArray2;
                objectArray2[1] = "getMap";
                break;
            }
            case 42: {
                objectArray = objectArray2;
                objectArray2[1] = "getMutableMap";
                break;
            }
            case 43: {
                objectArray = objectArray2;
                objectArray2[1] = "getMapEntry";
                break;
            }
            case 44: {
                objectArray = objectArray2;
                objectArray2[1] = "getMutableMapEntry";
                break;
            }
            case 45: {
                objectArray = objectArray2;
                objectArray2[1] = "getListIterator";
                break;
            }
            case 46: {
                objectArray = objectArray2;
                objectArray2[1] = "getMutableListIterator";
                break;
            }
            case 48: {
                objectArray = objectArray2;
                objectArray2[1] = "getBuiltInTypeByClassName";
                break;
            }
            case 49: {
                objectArray = objectArray2;
                objectArray2[1] = "getNothingType";
                break;
            }
            case 50: {
                objectArray = objectArray2;
                objectArray2[1] = "getNullableNothingType";
                break;
            }
            case 51: {
                objectArray = objectArray2;
                objectArray2[1] = "getAnyType";
                break;
            }
            case 52: {
                objectArray = objectArray2;
                objectArray2[1] = "getNullableAnyType";
                break;
            }
            case 53: {
                objectArray = objectArray2;
                objectArray2[1] = "getDefaultBound";
                break;
            }
            case 55: {
                objectArray = objectArray2;
                objectArray2[1] = "getPrimitiveKotlinType";
                break;
            }
            case 56: {
                objectArray = objectArray2;
                objectArray2[1] = "getNumberType";
                break;
            }
            case 57: {
                objectArray = objectArray2;
                objectArray2[1] = "getByteType";
                break;
            }
            case 58: {
                objectArray = objectArray2;
                objectArray2[1] = "getShortType";
                break;
            }
            case 59: {
                objectArray = objectArray2;
                objectArray2[1] = "getIntType";
                break;
            }
            case 60: {
                objectArray = objectArray2;
                objectArray2[1] = "getLongType";
                break;
            }
            case 61: {
                objectArray = objectArray2;
                objectArray2[1] = "getFloatType";
                break;
            }
            case 62: {
                objectArray = objectArray2;
                objectArray2[1] = "getDoubleType";
                break;
            }
            case 63: {
                objectArray = objectArray2;
                objectArray2[1] = "getCharType";
                break;
            }
            case 64: {
                objectArray = objectArray2;
                objectArray2[1] = "getBooleanType";
                break;
            }
            case 65: {
                objectArray = objectArray2;
                objectArray2[1] = "getUnitType";
                break;
            }
            case 66: {
                objectArray = objectArray2;
                objectArray2[1] = "getStringType";
                break;
            }
            case 67: {
                objectArray = objectArray2;
                objectArray2[1] = "getIterableType";
                break;
            }
            case 69: {
                objectArray = objectArray2;
                objectArray2[1] = "getArrayElementType";
                break;
            }
            case 74: {
                objectArray = objectArray2;
                objectArray2[1] = "getPrimitiveArrayKotlinType";
                break;
            }
            case 81: 
            case 84: {
                objectArray = objectArray2;
                objectArray2[1] = "getArrayType";
                break;
            }
            case 86: {
                objectArray = objectArray2;
                objectArray2[1] = "getEnumType";
                break;
            }
            case 87: {
                objectArray = objectArray2;
                objectArray2[1] = "getAnnotationType";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray;
                objectArray[2] = "<init>";
                break;
            }
            case 1: {
                objectArray = objectArray;
                objectArray[2] = "setBuiltInsModule";
                break;
            }
            case 2: {
                objectArray = objectArray;
                objectArray[2] = "setPostponedBuiltinsModuleComputation";
                break;
            }
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 11: 
            case 13: 
            case 15: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 30: 
            case 31: 
            case 32: 
            case 33: 
            case 34: 
            case 35: 
            case 36: 
            case 37: 
            case 38: 
            case 39: 
            case 40: 
            case 41: 
            case 42: 
            case 43: 
            case 44: 
            case 45: 
            case 46: 
            case 48: 
            case 49: 
            case 50: 
            case 51: 
            case 52: 
            case 53: 
            case 55: 
            case 56: 
            case 57: 
            case 58: 
            case 59: 
            case 60: 
            case 61: 
            case 62: 
            case 63: 
            case 64: 
            case 65: 
            case 66: 
            case 67: 
            case 69: 
            case 74: 
            case 81: 
            case 84: 
            case 86: 
            case 87: {
                break;
            }
            case 9: {
                objectArray = objectArray;
                objectArray[2] = "isBuiltIn";
                break;
            }
            case 10: {
                objectArray = objectArray;
                objectArray[2] = "isUnderKotlinPackage";
                break;
            }
            case 12: {
                objectArray = objectArray;
                objectArray[2] = "getBuiltInClassByFqName";
                break;
            }
            case 14: {
                objectArray = objectArray;
                objectArray[2] = "getBuiltInClassByName";
                break;
            }
            case 16: {
                objectArray = objectArray;
                objectArray[2] = "getPrimitiveClassDescriptor";
                break;
            }
            case 17: {
                objectArray = objectArray;
                objectArray[2] = "getPrimitiveArrayClassDescriptor";
                break;
            }
            case 47: {
                objectArray = objectArray;
                objectArray[2] = "getBuiltInTypeByClassName";
                break;
            }
            case 54: {
                objectArray = objectArray;
                objectArray[2] = "getPrimitiveKotlinType";
                break;
            }
            case 68: {
                objectArray = objectArray;
                objectArray[2] = "getArrayElementType";
                break;
            }
            case 70: {
                objectArray = objectArray;
                objectArray[2] = "getArrayElementTypeOrNull";
                break;
            }
            case 71: 
            case 72: {
                objectArray = objectArray;
                objectArray[2] = "getElementTypeForUnsignedArray";
                break;
            }
            case 73: {
                objectArray = objectArray;
                objectArray[2] = "getPrimitiveArrayKotlinType";
                break;
            }
            case 75: {
                objectArray = objectArray;
                objectArray[2] = "getPrimitiveArrayKotlinTypeByPrimitiveKotlinType";
                break;
            }
            case 76: 
            case 93: {
                objectArray = objectArray;
                objectArray[2] = "getPrimitiveType";
                break;
            }
            case 77: {
                objectArray = objectArray;
                objectArray[2] = "getPrimitiveArrayType";
                break;
            }
            case 78: 
            case 79: 
            case 80: 
            case 82: 
            case 83: {
                objectArray = objectArray;
                objectArray[2] = "getArrayType";
                break;
            }
            case 85: {
                objectArray = objectArray;
                objectArray[2] = "getEnumType";
                break;
            }
            case 88: {
                objectArray = objectArray;
                objectArray[2] = "isArray";
                break;
            }
            case 89: 
            case 90: {
                objectArray = objectArray;
                objectArray[2] = "isArrayOrPrimitiveArray";
                break;
            }
            case 91: {
                objectArray = objectArray;
                objectArray[2] = "isPrimitiveArray";
                break;
            }
            case 92: {
                objectArray = objectArray;
                objectArray[2] = "getPrimitiveArrayElementType";
                break;
            }
            case 94: {
                objectArray = objectArray;
                objectArray[2] = "isPrimitiveType";
                break;
            }
            case 95: {
                objectArray = objectArray;
                objectArray[2] = "isPrimitiveTypeOrNullablePrimitiveType";
                break;
            }
            case 96: {
                objectArray = objectArray;
                objectArray[2] = "isPrimitiveClass";
                break;
            }
            case 97: 
            case 98: 
            case 99: 
            case 100: {
                objectArray = objectArray;
                objectArray[2] = "isConstructedFromGivenClass";
                break;
            }
            case 101: 
            case 102: {
                objectArray = objectArray;
                objectArray[2] = "isTypeConstructorForGivenClass";
                break;
            }
            case 103: 
            case 104: {
                objectArray = objectArray;
                objectArray[2] = "classFqNameEquals";
                break;
            }
            case 105: 
            case 106: {
                objectArray = objectArray;
                objectArray[2] = "isNotNullConstructedFromGivenClass";
                break;
            }
            case 107: {
                objectArray = objectArray;
                objectArray[2] = "isSpecialClassWithNoSupertypes";
                break;
            }
            case 108: 
            case 109: {
                objectArray = objectArray;
                objectArray[2] = "isAny";
                break;
            }
            case 110: 
            case 112: {
                objectArray = objectArray;
                objectArray[2] = "isBoolean";
                break;
            }
            case 111: {
                objectArray = objectArray;
                objectArray[2] = "isBooleanOrNullableBoolean";
                break;
            }
            case 113: {
                objectArray = objectArray;
                objectArray[2] = "isNumber";
                break;
            }
            case 114: {
                objectArray = objectArray;
                objectArray[2] = "isChar";
                break;
            }
            case 115: {
                objectArray = objectArray;
                objectArray[2] = "isCharOrNullableChar";
                break;
            }
            case 116: {
                objectArray = objectArray;
                objectArray[2] = "isInt";
                break;
            }
            case 117: {
                objectArray = objectArray;
                objectArray[2] = "isByte";
                break;
            }
            case 118: {
                objectArray = objectArray;
                objectArray[2] = "isLong";
                break;
            }
            case 119: {
                objectArray = objectArray;
                objectArray[2] = "isLongOrNullableLong";
                break;
            }
            case 120: {
                objectArray = objectArray;
                objectArray[2] = "isShort";
                break;
            }
            case 121: {
                objectArray = objectArray;
                objectArray[2] = "isFloat";
                break;
            }
            case 122: {
                objectArray = objectArray;
                objectArray[2] = "isFloatOrNullableFloat";
                break;
            }
            case 123: {
                objectArray = objectArray;
                objectArray[2] = "isDouble";
                break;
            }
            case 124: {
                objectArray = objectArray;
                objectArray[2] = "isUByte";
                break;
            }
            case 125: {
                objectArray = objectArray;
                objectArray[2] = "isUShort";
                break;
            }
            case 126: {
                objectArray = objectArray;
                objectArray[2] = "isUInt";
                break;
            }
            case 127: {
                objectArray = objectArray;
                objectArray[2] = "isULong";
                break;
            }
            case 128: {
                objectArray = objectArray;
                objectArray[2] = "isUByteArray";
                break;
            }
            case 129: {
                objectArray = objectArray;
                objectArray[2] = "isUShortArray";
                break;
            }
            case 130: {
                objectArray = objectArray;
                objectArray[2] = "isUIntArray";
                break;
            }
            case 131: {
                objectArray = objectArray;
                objectArray[2] = "isULongArray";
                break;
            }
            case 132: {
                objectArray = objectArray;
                objectArray[2] = "isUnsignedArrayType";
                break;
            }
            case 133: {
                objectArray = objectArray;
                objectArray[2] = "isDoubleOrNullableDouble";
                break;
            }
            case 134: 
            case 135: {
                objectArray = objectArray;
                objectArray[2] = "isConstructedFromGivenClassAndNotNullable";
                break;
            }
            case 136: {
                objectArray = objectArray;
                objectArray[2] = "isNothing";
                break;
            }
            case 137: {
                objectArray = objectArray;
                objectArray[2] = "isNullableNothing";
                break;
            }
            case 138: {
                objectArray = objectArray;
                objectArray[2] = "isNothingOrNullableNothing";
                break;
            }
            case 139: {
                objectArray = objectArray;
                objectArray[2] = "isAnyOrNullableAny";
                break;
            }
            case 140: {
                objectArray = objectArray;
                objectArray[2] = "isNullableAny";
                break;
            }
            case 141: {
                objectArray = objectArray;
                objectArray[2] = "isDefaultBound";
                break;
            }
            case 142: {
                objectArray = objectArray;
                objectArray[2] = "isUnit";
                break;
            }
            case 143: {
                objectArray = objectArray;
                objectArray[2] = "mayReturnNonUnitValue";
                break;
            }
            case 144: {
                objectArray = objectArray;
                objectArray[2] = "isUnitOrNullableUnit";
                break;
            }
            case 145: {
                objectArray = objectArray;
                objectArray[2] = "isBooleanOrSubtype";
                break;
            }
            case 146: {
                objectArray = objectArray;
                objectArray[2] = "isMemberOfAny";
                break;
            }
            case 147: 
            case 148: {
                objectArray = objectArray;
                objectArray[2] = "isEnum";
                break;
            }
            case 149: 
            case 150: {
                objectArray = objectArray;
                objectArray[2] = "isComparable";
                break;
            }
            case 151: {
                objectArray = objectArray;
                objectArray[2] = "isCollectionOrNullableCollection";
                break;
            }
            case 152: {
                objectArray = objectArray;
                objectArray[2] = "isListOrNullableList";
                break;
            }
            case 153: {
                objectArray = objectArray;
                objectArray[2] = "isSetOrNullableSet";
                break;
            }
            case 154: {
                objectArray = objectArray;
                objectArray[2] = "isMapOrNullableMap";
                break;
            }
            case 155: {
                objectArray = objectArray;
                objectArray[2] = "isIterableOrNullableIterable";
                break;
            }
            case 156: {
                objectArray = objectArray;
                objectArray[2] = "isThrowableOrNullableThrowable";
                break;
            }
            case 157: {
                objectArray = objectArray;
                objectArray[2] = "isThrowable";
                break;
            }
            case 158: {
                objectArray = objectArray;
                objectArray[2] = "isKClass";
                break;
            }
            case 159: {
                objectArray = objectArray;
                objectArray[2] = "isNonPrimitiveArray";
                break;
            }
            case 160: {
                objectArray = objectArray;
                objectArray[2] = "isDeprecated";
                break;
            }
            case 161: {
                objectArray = objectArray;
                objectArray[2] = "isNotNullOrNullableFunctionSupertype";
                break;
            }
        }
        String string2 = String.format(string, objectArray);
        switch (n2) {
            default: {
                runtimeException = new IllegalArgumentException(string2);
                break;
            }
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 11: 
            case 13: 
            case 15: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 30: 
            case 31: 
            case 32: 
            case 33: 
            case 34: 
            case 35: 
            case 36: 
            case 37: 
            case 38: 
            case 39: 
            case 40: 
            case 41: 
            case 42: 
            case 43: 
            case 44: 
            case 45: 
            case 46: 
            case 48: 
            case 49: 
            case 50: 
            case 51: 
            case 52: 
            case 53: 
            case 55: 
            case 56: 
            case 57: 
            case 58: 
            case 59: 
            case 60: 
            case 61: 
            case 62: 
            case 63: 
            case 64: 
            case 65: 
            case 66: 
            case 67: 
            case 69: 
            case 74: 
            case 81: 
            case 84: 
            case 86: 
            case 87: {
                runtimeException = new IllegalStateException(string2);
                break;
            }
        }
        throw runtimeException;
    }

    private static class Primitives {
        public final Map<PrimitiveType, SimpleType> primitiveTypeToArrayKotlinType;
        public final Map<KotlinType, SimpleType> primitiveKotlinTypeToKotlinArrayType;
        public final Map<SimpleType, SimpleType> kotlinArrayTypeToPrimitiveKotlinType;

        private Primitives(@NotNull Map<PrimitiveType, SimpleType> primitiveTypeToArrayKotlinType, @NotNull Map<KotlinType, SimpleType> primitiveKotlinTypeToKotlinArrayType, @NotNull Map<SimpleType, SimpleType> kotlinArrayTypeToPrimitiveKotlinType) {
            if (primitiveTypeToArrayKotlinType == null) {
                Primitives.$$$reportNull$$$0(0);
            }
            if (primitiveKotlinTypeToKotlinArrayType == null) {
                Primitives.$$$reportNull$$$0(1);
            }
            if (kotlinArrayTypeToPrimitiveKotlinType == null) {
                Primitives.$$$reportNull$$$0(2);
            }
            this.primitiveTypeToArrayKotlinType = primitiveTypeToArrayKotlinType;
            this.primitiveKotlinTypeToKotlinArrayType = primitiveKotlinTypeToKotlinArrayType;
            this.kotlinArrayTypeToPrimitiveKotlinType = kotlinArrayTypeToPrimitiveKotlinType;
        }

        private static /* synthetic */ void $$$reportNull$$$0(int n2) {
            Object[] objectArray;
            Object[] objectArray2 = new Object[3];
            switch (n2) {
                default: {
                    objectArray = objectArray2;
                    objectArray2[0] = "primitiveTypeToArrayKotlinType";
                    break;
                }
                case 1: {
                    objectArray = objectArray2;
                    objectArray2[0] = "primitiveKotlinTypeToKotlinArrayType";
                    break;
                }
                case 2: {
                    objectArray = objectArray2;
                    objectArray2[0] = "kotlinArrayTypeToPrimitiveKotlinType";
                    break;
                }
            }
            objectArray[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$Primitives";
            objectArray[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objectArray));
        }
    }
}

