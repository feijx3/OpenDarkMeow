/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmDescriptorTypeWriter;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory;
import kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration;
import kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfigurationImpl;
import kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode;
import kotlin.reflect.jvm.internal.impl.load.kotlin.TypeSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.ExpandedTypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\ndescriptorBasedTypeSignatureMapping.kt\nKotlin\n*S Kotlin\n*F\n+ 1 descriptorBasedTypeSignatureMapping.kt\norg/jetbrains/kotlin/load/kotlin/DescriptorBasedTypeSignatureMappingKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,198:1\n1#2:199\n*E\n"})
public final class DescriptorBasedTypeSignatureMappingKt {
    @NotNull
    public static final <T> T mapType(@NotNull KotlinType kotlinType, @NotNull JvmTypeFactory<T> factory, @NotNull TypeMappingMode mode, @NotNull TypeMappingConfiguration<? extends T> typeMappingConfiguration, @Nullable JvmDescriptorTypeWriter<T> descriptorTypeWriter, @NotNull Function3<? super KotlinType, ? super T, ? super TypeMappingMode, Unit> writeGenericType) {
        T jvmType;
        Intrinsics.checkNotNullParameter(kotlinType, "kotlinType");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(typeMappingConfiguration, "typeMappingConfiguration");
        Intrinsics.checkNotNullParameter(writeGenericType, "writeGenericType");
        KotlinType kotlinType2 = typeMappingConfiguration.preprocessType(kotlinType);
        if (kotlinType2 != null) {
            KotlinType newType = kotlinType2;
            boolean bl2 = false;
            return DescriptorBasedTypeSignatureMappingKt.mapType(newType, factory, mode, typeMappingConfiguration, descriptorTypeWriter, writeGenericType);
        }
        if (FunctionTypesKt.isSuspendFunctionType(kotlinType)) {
            return DescriptorBasedTypeSignatureMappingKt.mapType(SuspendFunctionTypesKt.transformSuspendFunctionToRuntimeFunctionType(kotlinType), factory, mode, typeMappingConfiguration, descriptorTypeWriter, writeGenericType);
        }
        SimpleClassicTypeSystemContext $this$mapType_u24lambda_u241 = SimpleClassicTypeSystemContext.INSTANCE;
        boolean bl3 = false;
        kotlinType2 = TypeSignatureMappingKt.mapBuiltInType($this$mapType_u24lambda_u241, kotlinType, factory, mode);
        if (kotlinType2 != null) {
            KotlinType builtInType = kotlinType2;
            boolean bl4 = false;
            KotlinType jvmType2 = TypeSignatureMappingKt.boxTypeIfNeeded(factory, builtInType, mode.getNeedPrimitiveBoxing());
            writeGenericType.invoke(kotlinType, jvmType2, mode);
            return (T)jvmType2;
        }
        TypeConstructor constructor = kotlinType.getConstructor();
        if (constructor instanceof IntersectionTypeConstructor) {
            KotlinType kotlinType3 = ((IntersectionTypeConstructor)constructor).getAlternativeType();
            if (kotlinType3 == null) {
                kotlinType3 = typeMappingConfiguration.commonSupertype(((IntersectionTypeConstructor)constructor).getSupertypes());
            }
            KotlinType intersectionType = kotlinType3;
            return DescriptorBasedTypeSignatureMappingKt.mapType(TypeUtilsKt.replaceArgumentsWithStarProjections(intersectionType), factory, mode, typeMappingConfiguration, descriptorTypeWriter, writeGenericType);
        }
        ClassifierDescriptor classifierDescriptor = constructor.getDeclarationDescriptor();
        if (classifierDescriptor == null) {
            throw new UnsupportedOperationException("no descriptor for type constructor of " + kotlinType);
        }
        ClassifierDescriptor descriptor2 = classifierDescriptor;
        if (ErrorUtils.isError(descriptor2)) {
            jvmType = factory.createObjectType("error/NonExistentClass");
            typeMappingConfiguration.processErrorType(kotlinType, (ClassDescriptor)descriptor2);
            JvmDescriptorTypeWriter<Object> jvmDescriptorTypeWriter = descriptorTypeWriter;
            if (jvmDescriptorTypeWriter != null) {
                jvmDescriptorTypeWriter.writeClass(jvmType);
            }
            return jvmType;
        }
        if (descriptor2 instanceof ClassDescriptor && KotlinBuiltIns.isArray(kotlinType)) {
            if (kotlinType.getArguments().size() != 1) {
                throw new UnsupportedOperationException("arrays must have one type argument");
            }
            TypeProjection memberProjection = kotlinType.getArguments().get(0);
            KotlinType kotlinType4 = memberProjection.getType();
            Intrinsics.checkNotNullExpressionValue(kotlinType4, "getType(...)");
            KotlinType memberType = kotlinType4;
            Object arrayElementType = null;
            if (memberProjection.getProjectionKind() == Variance.IN_VARIANCE) {
                arrayElementType = factory.createObjectType("java/lang/Object");
                JvmDescriptorTypeWriter<Object> jvmDescriptorTypeWriter = descriptorTypeWriter;
                if (jvmDescriptorTypeWriter != null) {
                    JvmDescriptorTypeWriter<Object> jvmDescriptorTypeWriter2;
                    JvmDescriptorTypeWriter<Object> $this$mapType_u24lambda_u243 = jvmDescriptorTypeWriter2 = jvmDescriptorTypeWriter;
                    boolean bl5 = false;
                    $this$mapType_u24lambda_u243.writeArrayType();
                    $this$mapType_u24lambda_u243.writeClass(arrayElementType);
                    $this$mapType_u24lambda_u243.writeArrayEnd();
                }
            } else {
                JvmDescriptorTypeWriter<Object> jvmDescriptorTypeWriter = descriptorTypeWriter;
                if (jvmDescriptorTypeWriter != null) {
                    jvmDescriptorTypeWriter.writeArrayType();
                }
                Variance variance = memberProjection.getProjectionKind();
                Intrinsics.checkNotNullExpressionValue((Object)variance, "getProjectionKind(...)");
                arrayElementType = DescriptorBasedTypeSignatureMappingKt.mapType(memberType, factory, mode.toGenericArgumentMode(variance, true), typeMappingConfiguration, descriptorTypeWriter, writeGenericType);
                JvmDescriptorTypeWriter<Object> jvmDescriptorTypeWriter3 = descriptorTypeWriter;
                if (jvmDescriptorTypeWriter3 != null) {
                    jvmDescriptorTypeWriter3.writeArrayEnd();
                }
            }
            return factory.createFromString('[' + factory.toString(arrayElementType));
        }
        if (descriptor2 instanceof ClassDescriptor) {
            T t2;
            KotlinType expandedType;
            if (InlineClassesUtilsKt.isInlineClass(descriptor2) && !mode.getNeedInlineClassWrapping() && (expandedType = (KotlinType)ExpandedTypeUtilsKt.computeExpandedTypeForInlineClass(SimpleClassicTypeSystemContext.INSTANCE, kotlinType)) != null) {
                return DescriptorBasedTypeSignatureMappingKt.mapType(expandedType, factory, mode.wrapInlineClassesMode(), typeMappingConfiguration, descriptorTypeWriter, writeGenericType);
            }
            if (mode.isForAnnotationParameter() && KotlinBuiltIns.isKClass((ClassDescriptor)descriptor2)) {
                t2 = factory.getJavaLangClassType();
            } else {
                ClassDescriptor classDescriptor = ((ClassDescriptor)descriptor2).getOriginal();
                Intrinsics.checkNotNullExpressionValue(classDescriptor, "getOriginal(...)");
                t2 = typeMappingConfiguration.getPredefinedTypeForClass(classDescriptor);
                if (t2 == null) {
                    ClassDescriptor classDescriptor2;
                    boolean bl6 = false;
                    if (((ClassDescriptor)descriptor2).getKind() == ClassKind.ENUM_ENTRY) {
                        DeclarationDescriptor declarationDescriptor = ((ClassDescriptor)descriptor2).getContainingDeclaration();
                        Intrinsics.checkNotNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                        classDescriptor2 = (ClassDescriptor)declarationDescriptor;
                    } else {
                        classDescriptor2 = (ClassDescriptor)descriptor2;
                    }
                    ClassDescriptor enumClassIfEnumEntry = classDescriptor2;
                    ClassDescriptor classDescriptor3 = enumClassIfEnumEntry.getOriginal();
                    Intrinsics.checkNotNullExpressionValue(classDescriptor3, "getOriginal(...)");
                    t2 = factory.createObjectType(DescriptorBasedTypeSignatureMappingKt.computeInternalName(classDescriptor3, typeMappingConfiguration));
                }
            }
            jvmType = t2;
            writeGenericType.invoke(kotlinType, jvmType, mode);
            return jvmType;
        }
        if (descriptor2 instanceof TypeParameterDescriptor) {
            KotlinType upperBound = TypeUtilsKt.getRepresentativeUpperBound((TypeParameterDescriptor)descriptor2);
            KotlinType kotlinType5 = kotlinType.isMarkedNullable() ? TypeUtilsKt.makeNullable(upperBound) : upperBound;
            Function3<Object, Object, Object, Unit> function3 = FunctionsKt.getDO_NOTHING_3();
            Object type = DescriptorBasedTypeSignatureMappingKt.mapType(kotlinType5, factory, mode, typeMappingConfiguration, null, function3);
            JvmDescriptorTypeWriter<Object> jvmDescriptorTypeWriter = descriptorTypeWriter;
            if (jvmDescriptorTypeWriter != null) {
                Name name = descriptor2.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                jvmDescriptorTypeWriter.writeTypeVariable(name, type);
            }
            return (T)type;
        }
        if (descriptor2 instanceof TypeAliasDescriptor && mode.getMapTypeAliases()) {
            return DescriptorBasedTypeSignatureMappingKt.mapType(((TypeAliasDescriptor)descriptor2).getExpandedType(), factory, mode, typeMappingConfiguration, descriptorTypeWriter, writeGenericType);
        }
        throw new UnsupportedOperationException("Unknown type " + kotlinType);
    }

    public static /* synthetic */ Object mapType$default(KotlinType kotlinType, JvmTypeFactory jvmTypeFactory, TypeMappingMode typeMappingMode, TypeMappingConfiguration typeMappingConfiguration, JvmDescriptorTypeWriter jvmDescriptorTypeWriter, Function3 function3, int n2, Object object) {
        if ((n2 & 0x20) != 0) {
            function3 = FunctionsKt.getDO_NOTHING_3();
        }
        return DescriptorBasedTypeSignatureMappingKt.mapType(kotlinType, jvmTypeFactory, typeMappingMode, typeMappingConfiguration, jvmDescriptorTypeWriter, function3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final boolean hasVoidReturnType(@NotNull CallableDescriptor descriptor2) {
        Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
        if (descriptor2 instanceof ConstructorDescriptor) {
            return true;
        }
        KotlinType kotlinType = descriptor2.getReturnType();
        Intrinsics.checkNotNull(kotlinType);
        if (!KotlinBuiltIns.isUnit(kotlinType)) return false;
        KotlinType kotlinType2 = descriptor2.getReturnType();
        Intrinsics.checkNotNull(kotlinType2);
        if (TypeUtils.isNullableType(kotlinType2)) return false;
        if (descriptor2 instanceof PropertyGetterDescriptor) return false;
        return true;
    }

    @NotNull
    public static final String computeInternalName(@NotNull ClassDescriptor klass, @NotNull TypeMappingConfiguration<?> typeMappingConfiguration) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        Intrinsics.checkNotNullParameter(typeMappingConfiguration, "typeMappingConfiguration");
        String string = typeMappingConfiguration.getPredefinedFullInternalNameForClass(klass);
        if (string != null) {
            String it = string;
            boolean bl2 = false;
            return it;
        }
        DeclarationDescriptor declarationDescriptor = klass.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(declarationDescriptor, "getContainingDeclaration(...)");
        DeclarationDescriptor container = declarationDescriptor;
        String string2 = SpecialNames.safeIdentifier(klass.getName()).getIdentifier();
        Intrinsics.checkNotNullExpressionValue(string2, "getIdentifier(...)");
        String name = string2;
        if (container instanceof PackageFragmentDescriptor) {
            FqName fqName = ((PackageFragmentDescriptor)container).getFqName();
            return fqName.isRoot() ? name : StringsKt.replace$default(fqName.asString(), '.', '/', false, 4, null) + '/' + name;
        }
        ClassDescriptor classDescriptor = container instanceof ClassDescriptor ? (ClassDescriptor)container : null;
        if (classDescriptor == null) {
            throw new IllegalArgumentException("Unexpected container: " + container + " for " + klass);
        }
        ClassDescriptor containerClass = classDescriptor;
        String string3 = typeMappingConfiguration.getPredefinedInternalNameForClass(containerClass);
        if (string3 == null) {
            string3 = DescriptorBasedTypeSignatureMappingKt.computeInternalName(containerClass, typeMappingConfiguration);
        }
        String containerInternalName = string3;
        return containerInternalName + '$' + name;
    }

    public static /* synthetic */ String computeInternalName$default(ClassDescriptor classDescriptor, TypeMappingConfiguration typeMappingConfiguration, int n2, Object object) {
        if ((n2 & 2) != 0) {
            typeMappingConfiguration = TypeMappingConfigurationImpl.INSTANCE;
        }
        return DescriptorBasedTypeSignatureMappingKt.computeInternalName(classDescriptor, typeMappingConfiguration);
    }
}

