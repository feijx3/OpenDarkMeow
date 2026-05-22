/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.JvmPropertySignature;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaConstructor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaField;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u00052\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001a*\u0006\u0012\u0002\b\u00030\u00188BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001d"}, d2={"Lkotlin/reflect/jvm/internal/RuntimeTypeMapper;", "", "<init>", "()V", "JAVA_LANG_VOID", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "mapSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "possiblySubstitutedFunction", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "mapPropertySignature", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "possiblyOverriddenProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "isKnownBuiltInFunction", "", "descriptor", "mapJvmFunctionSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "mapName", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "mapJvmClassToKotlinClassId", "klass", "Ljava/lang/Class;", "primitiveType", "Lkotlin/reflect/jvm/internal/impl/builtins/PrimitiveType;", "getPrimitiveType", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "kotlin-reflection"})
@SourceDebugExtension(value={"SMAP\nRuntimeTypeMapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RuntimeTypeMapper.kt\nkotlin/reflect/jvm/internal/RuntimeTypeMapper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,302:1\n1#2:303\n*E\n"})
public final class RuntimeTypeMapper {
    @NotNull
    public static final RuntimeTypeMapper INSTANCE = new RuntimeTypeMapper();
    @NotNull
    private static final ClassId JAVA_LANG_VOID = ClassId.Companion.topLevel(new FqName("java.lang.Void"));

    private RuntimeTypeMapper() {
    }

    @NotNull
    public final JvmFunctionSignature mapSignature(@NotNull FunctionDescriptor possiblySubstitutedFunction) {
        FunctionDescriptor function;
        Intrinsics.checkNotNullParameter(possiblySubstitutedFunction, "possiblySubstitutedFunction");
        FunctionDescriptor functionDescriptor = ((FunctionDescriptor)DescriptorUtils.unwrapFakeOverride((CallableMemberDescriptor)possiblySubstitutedFunction)).getOriginal();
        Intrinsics.checkNotNullExpressionValue(functionDescriptor, "getOriginal(...)");
        FunctionDescriptor functionDescriptor2 = function = functionDescriptor;
        if (functionDescriptor2 instanceof DeserializedCallableMemberDescriptor) {
            JvmMemberSignature.Method method;
            MessageLite proto = ((DeserializedMemberDescriptor)((Object)function)).getProto();
            if (proto instanceof ProtoBuf.Function && (method = JvmProtoBufUtil.INSTANCE.getJvmMethodSignature((ProtoBuf.Function)proto, ((DeserializedMemberDescriptor)((Object)function)).getNameResolver(), ((DeserializedMemberDescriptor)((Object)function)).getTypeTable())) != null) {
                JvmMemberSignature.Method signature = method;
                boolean bl2 = false;
                return new JvmFunctionSignature.KotlinFunction(signature);
            }
            if (proto instanceof ProtoBuf.Constructor && (method = JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature((ProtoBuf.Constructor)proto, ((DeserializedMemberDescriptor)((Object)function)).getNameResolver(), ((DeserializedMemberDescriptor)((Object)function)).getTypeTable())) != null) {
                JvmFunctionSignature jvmFunctionSignature;
                JvmMemberSignature.Method signature = method;
                boolean bl3 = false;
                DeclarationDescriptor declarationDescriptor = possiblySubstitutedFunction.getContainingDeclaration();
                Intrinsics.checkNotNullExpressionValue(declarationDescriptor, "getContainingDeclaration(...)");
                if (InlineClassesUtilsKt.isInlineClass(declarationDescriptor)) {
                    jvmFunctionSignature = new JvmFunctionSignature.KotlinFunction(signature);
                } else {
                    DeclarationDescriptor declarationDescriptor2 = possiblySubstitutedFunction.getContainingDeclaration();
                    Intrinsics.checkNotNullExpressionValue(declarationDescriptor2, "getContainingDeclaration(...)");
                    if (InlineClassesUtilsKt.isMultiFieldValueClass(declarationDescriptor2)) {
                        JvmMemberSignature.Method method2;
                        if (((ConstructorDescriptor)possiblySubstitutedFunction).isPrimary()) {
                            if (!(Intrinsics.areEqual(signature.getName(), "constructor-impl") && StringsKt.endsWith$default(signature.getDesc(), ")V", false, 2, null))) {
                                boolean $i$a$-require-RuntimeTypeMapper$mapSignature$2$realSignature$42 = false;
                                String $i$a$-require-RuntimeTypeMapper$mapSignature$2$realSignature$42 = "Invalid signature: " + signature;
                                throw new IllegalArgumentException($i$a$-require-RuntimeTypeMapper$mapSignature$2$realSignature$42.toString());
                            }
                            method2 = signature;
                        } else {
                            if (!Intrinsics.areEqual(signature.getName(), "constructor-impl")) {
                                boolean bl4 = false;
                                String string = "Invalid signature: " + signature;
                                throw new IllegalArgumentException(string.toString());
                            }
                            ClassDescriptor classDescriptor = ((ConstructorDescriptor)possiblySubstitutedFunction).getConstructedClass();
                            Intrinsics.checkNotNullExpressionValue(classDescriptor, "getConstructedClass(...)");
                            String constructedClass = ValueClassAwareCallerKt.toJvmDescriptor(classDescriptor);
                            if (StringsKt.endsWith$default(signature.getDesc(), ")V", false, 2, null)) {
                                method2 = JvmMemberSignature.Method.copy$default(signature, null, StringsKt.removeSuffix(signature.getDesc(), (CharSequence)"V") + constructedClass, 1, null);
                            } else {
                                if (!StringsKt.endsWith$default(signature.getDesc(), constructedClass, false, 2, null)) {
                                    boolean bl5 = false;
                                    String string = "Invalid signature: " + signature;
                                    throw new IllegalArgumentException(string.toString());
                                }
                                method2 = signature;
                            }
                        }
                        JvmMemberSignature.Method realSignature = method2;
                        jvmFunctionSignature = new JvmFunctionSignature.KotlinFunction(realSignature);
                    } else {
                        jvmFunctionSignature = new JvmFunctionSignature.KotlinConstructor(signature);
                    }
                }
                return jvmFunctionSignature;
            }
            return this.mapJvmFunctionSignature(function);
        }
        if (functionDescriptor2 instanceof JavaMethodDescriptor) {
            SourceElement sourceElement = ((JavaMethodDescriptor)function).getSource();
            JavaSourceElement javaSourceElement = sourceElement instanceof JavaSourceElement ? (JavaSourceElement)sourceElement : null;
            JavaElement javaElement = javaSourceElement != null ? javaSourceElement.getJavaElement() : null;
            Object object = javaElement instanceof ReflectJavaMethod ? (ReflectJavaMethod)javaElement : null;
            if (object == null || (object = ((ReflectJavaMethod)object).getMember()) == null) {
                throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java method " + function);
            }
            Object method = object;
            return new JvmFunctionSignature.JavaMethod((Method)method);
        }
        if (functionDescriptor2 instanceof JavaClassConstructorDescriptor) {
            JvmFunctionSignature jvmFunctionSignature;
            SourceElement sourceElement = ((JavaClassConstructorDescriptor)function).getSource();
            JavaSourceElement javaSourceElement = sourceElement instanceof JavaSourceElement ? (JavaSourceElement)sourceElement : null;
            JavaElement element = javaSourceElement != null ? javaSourceElement.getJavaElement() : null;
            if (element instanceof ReflectJavaConstructor) {
                jvmFunctionSignature = new JvmFunctionSignature.JavaConstructor((Constructor<?>)((ReflectJavaConstructor)element).getMember());
            } else if (element instanceof ReflectJavaClass && ((ReflectJavaClass)element).isAnnotationType()) {
                jvmFunctionSignature = new JvmFunctionSignature.FakeJavaAnnotationConstructor((Class<?>)((ReflectJavaClass)element).getElement());
            } else {
                throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java constructor " + function + " (" + element + ')');
            }
            return jvmFunctionSignature;
        }
        if (this.isKnownBuiltInFunction(function)) {
            return this.mapJvmFunctionSignature(function);
        }
        throw new KotlinReflectionInternalError("Unknown origin of " + function + " (" + function.getClass() + ')');
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final JvmPropertySignature mapPropertySignature(@NotNull PropertyDescriptor possiblyOverriddenProperty) {
        JvmFunctionSignature.KotlinFunction kotlinFunction;
        PropertyDescriptor property;
        Intrinsics.checkNotNullParameter(possiblyOverriddenProperty, "possiblyOverriddenProperty");
        PropertyDescriptor propertyDescriptor = ((PropertyDescriptor)DescriptorUtils.unwrapFakeOverride((CallableMemberDescriptor)possiblyOverriddenProperty)).getOriginal();
        Intrinsics.checkNotNullExpressionValue(propertyDescriptor, "getOriginal(...)");
        PropertyDescriptor propertyDescriptor2 = property = propertyDescriptor;
        if (propertyDescriptor2 instanceof DeserializedPropertyDescriptor) {
            ProtoBuf.Property proto = ((DeserializedPropertyDescriptor)property).getProto();
            GeneratedMessageLite.ExtendableMessage extendableMessage = proto;
            GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> generatedExtension = JvmProtoBuf.propertySignature;
            Intrinsics.checkNotNullExpressionValue(generatedExtension, "propertySignature");
            JvmProtoBuf.JvmPropertySignature signature = ProtoBufUtilKt.getExtensionOrNull(extendableMessage, generatedExtension);
            if (signature != null) {
                return new JvmPropertySignature.KotlinProperty(property, proto, signature, ((DeserializedPropertyDescriptor)property).getNameResolver(), ((DeserializedPropertyDescriptor)property).getTypeTable());
            }
        } else if (propertyDescriptor2 instanceof JavaPropertyDescriptor) {
            JvmPropertySignature jvmPropertySignature;
            JavaElement element;
            Object object = ((JavaPropertyDescriptor)property).getSource();
            JavaSourceElement javaSourceElement = object instanceof JavaSourceElement ? (JavaSourceElement)object : null;
            JavaElement javaElement = element = javaSourceElement != null ? javaSourceElement.getJavaElement() : null;
            if (element instanceof ReflectJavaField) {
                jvmPropertySignature = new JvmPropertySignature.JavaField(((ReflectJavaField)element).getMember());
            } else if (element instanceof ReflectJavaMethod) {
                PropertySetterDescriptor propertySetterDescriptor = ((JavaPropertyDescriptor)property).getSetter();
                SourceElement sourceElement = propertySetterDescriptor != null ? propertySetterDescriptor.getSource() : null;
                JavaSourceElement javaSourceElement2 = sourceElement instanceof JavaSourceElement ? (JavaSourceElement)sourceElement : null;
                object = javaSourceElement2 != null ? javaSourceElement2.getJavaElement() : null;
                ReflectJavaMethod reflectJavaMethod = object instanceof ReflectJavaMethod ? (ReflectJavaMethod)object : null;
                jvmPropertySignature = new JvmPropertySignature.JavaMethodProperty(((ReflectJavaMethod)element).getMember(), reflectJavaMethod != null ? reflectJavaMethod.getMember() : null);
            } else {
                throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java field " + property + " (source = " + element + ')');
            }
            return jvmPropertySignature;
        }
        PropertyGetterDescriptor propertyGetterDescriptor = property.getGetter();
        Intrinsics.checkNotNull(propertyGetterDescriptor);
        FunctionDescriptor p0 = propertyGetterDescriptor;
        boolean bl22 = false;
        JvmFunctionSignature.KotlinFunction kotlinFunction2 = this.mapJvmFunctionSignature(p0);
        PropertySetterDescriptor propertySetterDescriptor = property.getSetter();
        if (propertySetterDescriptor != null) {
            void p02;
            FunctionDescriptor bl22 = propertySetterDescriptor;
            JvmFunctionSignature.KotlinFunction kotlinFunction3 = kotlinFunction2;
            boolean bl3 = false;
            kotlinFunction = this.mapJvmFunctionSignature((FunctionDescriptor)p02);
            kotlinFunction2 = kotlinFunction3;
        } else {
            kotlinFunction = null;
        }
        JvmFunctionSignature.KotlinFunction kotlinFunction4 = kotlinFunction;
        JvmFunctionSignature.KotlinFunction kotlinFunction5 = kotlinFunction2;
        return new JvmPropertySignature.MappedKotlinProperty(kotlinFunction5, kotlinFunction4);
    }

    private final boolean isKnownBuiltInFunction(FunctionDescriptor descriptor2) {
        if (DescriptorFactory.isEnumValueOfMethod(descriptor2) || DescriptorFactory.isEnumValuesMethod(descriptor2)) {
            return true;
        }
        return Intrinsics.areEqual(descriptor2.getName(), CloneableClassScope.Companion.getCLONE_NAME()) && descriptor2.getValueParameters().isEmpty();
    }

    private final JvmFunctionSignature.KotlinFunction mapJvmFunctionSignature(FunctionDescriptor descriptor2) {
        return new JvmFunctionSignature.KotlinFunction(new JvmMemberSignature.Method(this.mapName(descriptor2), MethodSignatureMappingKt.computeJvmDescriptor$default(descriptor2, false, false, 1, null)));
    }

    private final String mapName(CallableMemberDescriptor descriptor2) {
        String string = SpecialBuiltinMembers.getJvmMethodNameIfSpecial(descriptor2);
        if (string == null) {
            CallableMemberDescriptor callableMemberDescriptor = descriptor2;
            if (callableMemberDescriptor instanceof PropertyGetterDescriptor) {
                String string2 = DescriptorUtilsKt.getPropertyIfAccessor(descriptor2).getName().asString();
                Intrinsics.checkNotNullExpressionValue(string2, "asString(...)");
                string = JvmAbi.getterName(string2);
            } else if (callableMemberDescriptor instanceof PropertySetterDescriptor) {
                String string3 = DescriptorUtilsKt.getPropertyIfAccessor(descriptor2).getName().asString();
                Intrinsics.checkNotNullExpressionValue(string3, "asString(...)");
                string = JvmAbi.setterName(string3);
            } else {
                String string4 = descriptor2.getName().asString();
                string = string4;
                Intrinsics.checkNotNullExpressionValue(string4, "asString(...)");
            }
        }
        return string;
    }

    @NotNull
    public final ClassId mapJvmClassToKotlinClassId(@NotNull Class<?> klass) {
        ClassId classId;
        Intrinsics.checkNotNullParameter(klass, "klass");
        if (klass.isArray()) {
            Class<?> clazz = klass.getComponentType();
            Intrinsics.checkNotNullExpressionValue(clazz, "getComponentType(...)");
            PrimitiveType primitiveType = this.getPrimitiveType(clazz);
            if (primitiveType != null) {
                PrimitiveType it = primitiveType;
                boolean bl2 = false;
                return new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, it.getArrayTypeName());
            }
            return ClassId.Companion.topLevel(StandardNames.FqNames.array.toSafe());
        }
        if (Intrinsics.areEqual(klass, Void.TYPE)) {
            return JAVA_LANG_VOID;
        }
        PrimitiveType primitiveType = this.getPrimitiveType(klass);
        if (primitiveType != null) {
            PrimitiveType it = primitiveType;
            boolean bl3 = false;
            return new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, it.getTypeName());
        }
        ClassId classId2 = ReflectClassUtilKt.getClassId(klass);
        if (!classId2.isLocal() && (classId = JavaToKotlinClassMap.INSTANCE.mapJavaToKotlin(classId2.asSingleFqName())) != null) {
            ClassId it = classId;
            boolean bl4 = false;
            return it;
        }
        return classId2;
    }

    private final PrimitiveType getPrimitiveType(Class<?> $this$primitiveType) {
        return $this$primitiveType.isPrimitive() ? JvmPrimitiveType.get($this$primitiveType.getSimpleName()).getPrimitiveType() : null;
    }
}

