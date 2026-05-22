/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerKt;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.ClassMapperLite;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000l\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a \u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a(\u0010\u000b\u001a\u00020\f*\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a9\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00042\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00110\u0017\u00a2\u0006\u0002\b\u0019H\u0002\u001a\f\u0010\u001a\u001a\u00020\u0011*\u00020\u0015H\u0002\u001a6\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001c0\r\"\n\b\u0000\u0010\u001c*\u0004\u0018\u00010\u0015*\b\u0012\u0004\u0012\u0002H\u001c0\r2\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0000\u001a\f\u0010\u001d\u001a\u00020\u0011*\u00020\tH\u0002\u001a\u0018\u0010\u001e\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\u001f2\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0018\u0010 \u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\u001f2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u0012\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001f*\u00020\u0013H\u0002\u001a\u0014\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001f*\u0004\u0018\u00010\"H\u0000\u001a\u0018\u0010&\u001a\u0004\u0018\u00010'*\u0004\u0018\u00010'2\u0006\u0010\b\u001a\u00020\tH\u0000\"\u001a\u0010#\u001a\u0004\u0018\u00010\u0013*\u00020\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010%\u00a8\u0006("}, d2={"toJvmDescriptor", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassifierDescriptor;", "getValueClassUnboxMethods", "", "Ljava/lang/reflect/Method;", "type", "Lkotlin/reflect/jvm/internal/impl/types/SimpleType;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getMfvcUnboxMethods", "checkParametersSize", "", "Lkotlin/reflect/jvm/internal/calls/Caller;", "expectedArgsSize", "", "isDefault", "", "makeKotlinParameterTypes", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "member", "Ljava/lang/reflect/Member;", "isSpecificClass", "Lkotlin/Function1;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "Lkotlin/ExtensionFunctionType;", "acceptsBoxedReceiverParameter", "createValueClassAwareCallerIfNeeded", "M", "hasValueClassReceiver", "getInlineClassUnboxMethod", "Ljava/lang/Class;", "getBoxMethod", "toInlineClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;", "expectedReceiverType", "getExpectedReceiverType", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;)Lorg/jetbrains/kotlin/types/KotlinType;", "coerceToExpectedReceiverType", "", "kotlin-reflection"})
@SourceDebugExtension(value={"SMAP\nValueClassAwareCaller.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ValueClassAwareCaller.kt\nkotlin/reflect/jvm/internal/calls/ValueClassAwareCallerKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,392:1\n1#2:393\n1563#3:394\n1634#3,3:395\n1563#3:398\n1634#3,3:399\n1634#3,3:402\n1761#3,3:405\n1761#3,3:408\n1374#3:411\n1460#3,2:412\n1563#3:414\n1634#3,3:415\n1462#3,3:418\n*S KotlinDebug\n*F\n+ 1 ValueClassAwareCaller.kt\nkotlin/reflect/jvm/internal/calls/ValueClassAwareCallerKt\n*L\n262#1:394\n262#1:395,3\n264#1:398\n264#1:399,3\n308#1:402,3\n328#1:405,3\n329#1:408,3\n257#1:411\n257#1:412,2\n258#1:414\n258#1:415,3\n257#1:418,3\n*E\n"})
public final class ValueClassAwareCallerKt {
    @NotNull
    public static final String toJvmDescriptor(@NotNull ClassifierDescriptor $this$toJvmDescriptor) {
        Intrinsics.checkNotNullParameter($this$toJvmDescriptor, "<this>");
        ClassId classId = DescriptorUtilsKt.getClassId($this$toJvmDescriptor);
        Intrinsics.checkNotNull(classId);
        return ClassMapperLite.mapClass(classId.asString());
    }

    private static final List<Method> getValueClassUnboxMethods(SimpleType type, CallableMemberDescriptor descriptor2) {
        List<GenericDeclaration> list = ValueClassAwareCallerKt.getMfvcUnboxMethods(type);
        if (list == null) {
            GenericDeclaration genericDeclaration = ValueClassAwareCallerKt.toInlineClass(type);
            if (genericDeclaration != null && (genericDeclaration = ValueClassAwareCallerKt.getInlineClassUnboxMethod(genericDeclaration, descriptor2)) != null) {
                GenericDeclaration p0 = genericDeclaration;
                boolean bl2 = false;
                list = CollectionsKt.listOf(p0);
            } else {
                list = null;
            }
        }
        return list;
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public static final List<Method> getMfvcUnboxMethods(@NotNull SimpleType type) {
        void $this$mapTo$iv$iv;
        Collection collection;
        Collection destination$iv$iv;
        Intrinsics.checkNotNullParameter(type, "type");
        List<String> list = ValueClassAwareCallerKt.getMfvcUnboxMethods$getUnboxMethodNameSuffixes(TypeSubstitutionKt.asSimpleType(type));
        if (list != null) {
            void $this$mapTo$iv$iv2;
            Iterable $this$map$iv = list;
            boolean $i$f$map2 = false;
            Iterable iterable = $this$map$iv;
            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv2 : $this$mapTo$iv$iv2) {
                void it;
                String string = (String)item$iv$iv2;
                collection = destination$iv$iv;
                boolean bl2 = false;
                collection.add("unbox-impl-" + (String)it);
            }
        } else {
            return null;
        }
        List unboxMethodsNames = (List)destination$iv$iv;
        ClassifierDescriptor classifierDescriptor = type.getConstructor().getDeclarationDescriptor();
        Intrinsics.checkNotNull(classifierDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        Class<?> clazz = UtilKt.toJavaClass((ClassDescriptor)classifierDescriptor);
        Intrinsics.checkNotNull(clazz);
        Class<?> javaClass = clazz;
        Iterable $this$map$iv = unboxMethodsNames;
        boolean $i$f$map = false;
        Iterable $i$f$map2 = $this$map$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            Object item$iv$iv2;
            item$iv$iv2 = (String)item$iv$iv;
            collection = destination$iv$iv2;
            boolean bl3 = false;
            collection.add(javaClass.getDeclaredMethod((String)it, new Class[0]));
        }
        return (List)destination$iv$iv2;
    }

    private static final void checkParametersSize(Caller<?> $this$checkParametersSize, int expectedArgsSize, CallableMemberDescriptor descriptor2, boolean isDefault) {
        if (CallerKt.getArity($this$checkParametersSize) != expectedArgsSize) {
            throw new KotlinReflectionInternalError("Inconsistent number of parameters in the descriptor and Java reflection object: " + CallerKt.getArity($this$checkParametersSize) + " != " + expectedArgsSize + "\nCalling: " + descriptor2 + "\nParameter types: " + $this$checkParametersSize.getParameterTypes() + ")\nDefault: " + isDefault);
        }
    }

    /*
     * WARNING - void declaration
     */
    private static final List<KotlinType> makeKotlinParameterTypes(CallableMemberDescriptor descriptor2, Member member, Function1<? super ClassDescriptor, Boolean> isSpecificClass) {
        KotlinType extensionReceiverType;
        ArrayList<KotlinType> arrayList;
        ArrayList<KotlinType> kotlinParameterTypes = arrayList = new ArrayList<KotlinType>();
        boolean bl2 = false;
        ReceiverParameterDescriptor receiverParameterDescriptor = descriptor2.getExtensionReceiverParameter();
        KotlinType kotlinType = extensionReceiverType = receiverParameterDescriptor != null ? receiverParameterDescriptor.getType() : null;
        if (extensionReceiverType != null) {
            kotlinParameterTypes.add(extensionReceiverType);
        } else if (descriptor2 instanceof ConstructorDescriptor) {
            ClassDescriptor classDescriptor = ((ConstructorDescriptor)descriptor2).getConstructedClass();
            Intrinsics.checkNotNullExpressionValue(classDescriptor, "getConstructedClass(...)");
            ClassDescriptor constructedClass = classDescriptor;
            if (constructedClass.isInner()) {
                DeclarationDescriptor declarationDescriptor = constructedClass.getContainingDeclaration();
                Intrinsics.checkNotNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                kotlinParameterTypes.add(((ClassDescriptor)declarationDescriptor).getDefaultType());
            }
        } else {
            DeclarationDescriptor declarationDescriptor = descriptor2.getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(declarationDescriptor, "getContainingDeclaration(...)");
            DeclarationDescriptor containingDeclaration = declarationDescriptor;
            if (containingDeclaration instanceof ClassDescriptor && isSpecificClass.invoke((ClassDescriptor)containingDeclaration).booleanValue()) {
                boolean bl3;
                Member member2 = member;
                boolean bl4 = member2 != null ? ValueClassAwareCallerKt.acceptsBoxedReceiverParameter(member2) : false;
                if (bl4) {
                    SimpleType simpleType = ((ClassDescriptor)containingDeclaration).getDefaultType();
                    Intrinsics.checkNotNullExpressionValue(simpleType, "getDefaultType(...)");
                    bl3 = kotlinParameterTypes.add(TypeUtilsKt.makeNullable(simpleType));
                } else {
                    bl3 = kotlinParameterTypes.add(((ClassDescriptor)containingDeclaration).getDefaultType());
                }
            }
        }
        List<ValueParameterDescriptor> list = descriptor2.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(list, "getValueParameters(...)");
        Iterable $this$mapTo$iv = list;
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            void p0;
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor)item$iv;
            Collection collection = kotlinParameterTypes;
            boolean bl5 = false;
            collection.add(p0.getType());
        }
        return arrayList;
    }

    private static final boolean acceptsBoxedReceiverParameter(Member $this$acceptsBoxedReceiverParameter) {
        Class<?> clazz = $this$acceptsBoxedReceiverParameter.getDeclaringClass();
        if (clazz == null) {
            return false;
        }
        Class<?> clazz2 = clazz;
        return !JvmClassMappingKt.getKotlinClass(clazz2).isValue();
    }

    /*
     * Unable to fully structure code
     */
    @NotNull
    public static final <M extends Member> Caller<M> createValueClassAwareCallerIfNeeded(@NotNull Caller<? extends M> $this$createValueClassAwareCallerIfNeeded, @NotNull CallableMemberDescriptor descriptor, boolean isDefault) {
        block9: {
            block8: {
                Intrinsics.checkNotNullParameter($this$createValueClassAwareCallerIfNeeded, "<this>");
                Intrinsics.checkNotNullParameter(descriptor, "descriptor");
                if (InlineClassesUtilsKt.isGetterOfUnderlyingPropertyOfValueClass(descriptor)) ** GOTO lbl-1000
                v0 = descriptor.getContextReceiverParameters();
                Intrinsics.checkNotNullExpressionValue(v0, "getContextReceiverParameters(...)");
                $this$any$iv = v0;
                $i$f$any = false;
                if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                    v1 = false;
                } else {
                    for (T element$iv : $this$any$iv) {
                        it = (ReceiverParameterDescriptor)element$iv;
                        $i$a$-any-ValueClassAwareCallerKt$createValueClassAwareCallerIfNeeded$needsValueClassAwareCaller$1 = false;
                        v2 = it.getType();
                        Intrinsics.checkNotNullExpressionValue(v2, "getType(...)");
                        if (!InlineClassesUtilsKt.isValueClassType(v2)) continue;
                        v1 = true;
                        break block8;
                    }
                    v1 = false;
                }
            }
            if (v1) ** GOTO lbl-1000
            v3 = descriptor.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(v3, "getValueParameters(...)");
            $this$any$iv = v3;
            $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                v4 = false;
            } else {
                for (T element$iv : $this$any$iv) {
                    it = (ValueParameterDescriptor)element$iv;
                    $i$a$-any-ValueClassAwareCallerKt$createValueClassAwareCallerIfNeeded$needsValueClassAwareCaller$2 = false;
                    v5 = it.getType();
                    Intrinsics.checkNotNullExpressionValue(v5, "getType(...)");
                    if (!InlineClassesUtilsKt.isValueClassType(v5)) continue;
                    v4 = true;
                    break block9;
                }
                v4 = false;
            }
        }
        if (v4) ** GOTO lbl-1000
        v6 = descriptor.getReturnType();
        v7 = v6 != null ? InlineClassesUtilsKt.isInlineClassType(v6) : false;
        if (v7 || ValueClassAwareCallerKt.hasValueClassReceiver(descriptor)) lbl-1000:
        // 4 sources

        {
            v8 = true;
        } else {
            v8 = false;
        }
        needsValueClassAwareCaller = v8;
        return needsValueClassAwareCaller != false ? (Caller)new ValueClassAwareCaller<M>(descriptor, $this$createValueClassAwareCallerIfNeeded, isDefault) : $this$createValueClassAwareCallerIfNeeded;
    }

    public static /* synthetic */ Caller createValueClassAwareCallerIfNeeded$default(Caller caller, CallableMemberDescriptor callableMemberDescriptor, boolean bl2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        return ValueClassAwareCallerKt.createValueClassAwareCallerIfNeeded(caller, callableMemberDescriptor, bl2);
    }

    private static final boolean hasValueClassReceiver(CallableMemberDescriptor $this$hasValueClassReceiver) {
        KotlinType kotlinType = ValueClassAwareCallerKt.getExpectedReceiverType($this$hasValueClassReceiver);
        return kotlinType != null ? InlineClassesUtilsKt.isValueClassType(kotlinType) : false;
    }

    @NotNull
    public static final Method getInlineClassUnboxMethod(@NotNull Class<?> $this$getInlineClassUnboxMethod, @NotNull CallableMemberDescriptor descriptor2) {
        Method method;
        Intrinsics.checkNotNullParameter($this$getInlineClassUnboxMethod, "<this>");
        Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
        try {
            method = $this$getInlineClassUnboxMethod.getDeclaredMethod("unbox-impl", new Class[0]);
            Intrinsics.checkNotNull(method);
        }
        catch (NoSuchMethodException e2) {
            throw new KotlinReflectionInternalError("No unbox method found in inline class: " + $this$getInlineClassUnboxMethod + " (calling " + descriptor2 + ')');
        }
        return method;
    }

    private static final Method getBoxMethod(Class<?> $this$getBoxMethod, CallableMemberDescriptor descriptor2) {
        Method method;
        try {
            Class[] classArray = new Class[]{ValueClassAwareCallerKt.getInlineClassUnboxMethod($this$getBoxMethod, descriptor2).getReturnType()};
            method = $this$getBoxMethod.getDeclaredMethod("box-impl", classArray);
            Intrinsics.checkNotNull(method);
        }
        catch (NoSuchMethodException e2) {
            throw new KotlinReflectionInternalError("No box method found in inline class: " + $this$getBoxMethod + " (calling " + descriptor2 + ')');
        }
        return method;
    }

    private static final Class<?> toInlineClass(KotlinType $this$toInlineClass) {
        Class<?> clazz = ValueClassAwareCallerKt.toInlineClass($this$toInlineClass.getConstructor().getDeclarationDescriptor());
        if (clazz == null) {
            return null;
        }
        Class<?> klass = clazz;
        if (!TypeUtils.isNullableType($this$toInlineClass)) {
            return klass;
        }
        KotlinType kotlinType = InlineClassesUtilsKt.unsubstitutedUnderlyingType($this$toInlineClass);
        if (kotlinType == null) {
            return null;
        }
        KotlinType expandedUnderlyingType = kotlinType;
        if (!TypeUtils.isNullableType(expandedUnderlyingType) && !KotlinBuiltIns.isPrimitiveType(expandedUnderlyingType)) {
            return klass;
        }
        return null;
    }

    @Nullable
    public static final Class<?> toInlineClass(@Nullable DeclarationDescriptor $this$toInlineClass) {
        Class<?> clazz;
        if ($this$toInlineClass instanceof ClassDescriptor && InlineClassesUtilsKt.isInlineClass($this$toInlineClass)) {
            clazz = UtilKt.toJavaClass((ClassDescriptor)$this$toInlineClass);
            if (clazz == null) {
                throw new KotlinReflectionInternalError("Class object for the class " + ((ClassDescriptor)$this$toInlineClass).getName() + " cannot be found (classId=" + DescriptorUtilsKt.getClassId((ClassifierDescriptor)$this$toInlineClass) + ')');
            }
        } else {
            clazz = null;
        }
        return clazz;
    }

    private static final KotlinType getExpectedReceiverType(CallableMemberDescriptor $this$expectedReceiverType) {
        KotlinType kotlinType;
        ReceiverParameterDescriptor extensionReceiver = $this$expectedReceiverType.getExtensionReceiverParameter();
        ReceiverParameterDescriptor dispatchReceiver = $this$expectedReceiverType.getDispatchReceiverParameter();
        ReceiverParameterDescriptor receiverParameterDescriptor = extensionReceiver;
        if (receiverParameterDescriptor != null) {
            kotlinType = receiverParameterDescriptor.getType();
        } else if (dispatchReceiver == null) {
            kotlinType = null;
        } else if ($this$expectedReceiverType instanceof ConstructorDescriptor) {
            kotlinType = dispatchReceiver.getType();
        } else {
            DeclarationDescriptor declarationDescriptor = $this$expectedReceiverType.getContainingDeclaration();
            ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor)declarationDescriptor : null;
            kotlinType = classDescriptor != null ? classDescriptor.getDefaultType() : null;
        }
        return kotlinType;
    }

    @Nullable
    public static final Object coerceToExpectedReceiverType(@Nullable Object $this$coerceToExpectedReceiverType, @NotNull CallableMemberDescriptor descriptor2) {
        Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
        if (descriptor2 instanceof PropertyDescriptor && InlineClassesUtilsKt.isUnderlyingPropertyOfInlineClass((VariableDescriptor)((Object)descriptor2))) {
            return $this$coerceToExpectedReceiverType;
        }
        KotlinType expectedReceiverType = ValueClassAwareCallerKt.getExpectedReceiverType(descriptor2);
        Object object = expectedReceiverType;
        if (object == null || (object = ValueClassAwareCallerKt.toInlineClass((KotlinType)object)) == null || (object = ValueClassAwareCallerKt.getInlineClassUnboxMethod(object, descriptor2)) == null) {
            return $this$coerceToExpectedReceiverType;
        }
        Object unboxMethod = object;
        return ((Method)unboxMethod).invoke($this$coerceToExpectedReceiverType, new Object[0]);
    }

    /*
     * WARNING - void declaration
     */
    private static final List<String> getMfvcUnboxMethods$getUnboxMethodNameSuffixes(SimpleType type) {
        List list;
        if (InlineClassesUtilsKt.needsMfvcFlattening(type)) {
            void $this$flatMapTo$iv$iv;
            ClassifierDescriptor classifierDescriptor = type.getConstructor().getDeclarationDescriptor();
            Intrinsics.checkNotNull(classifierDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            MultiFieldValueClassRepresentation<SimpleType> multiFieldValueClassRepresentation = DescriptorUtilsKt.getMultiFieldValueClassRepresentation((ClassDescriptor)classifierDescriptor);
            Intrinsics.checkNotNull(multiFieldValueClassRepresentation);
            Iterable $this$flatMap$iv = multiFieldValueClassRepresentation.getUnderlyingPropertyNamesToTypes();
            boolean $i$f$flatMap = false;
            Iterable iterable = $this$flatMap$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$flatMapTo = false;
            for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
                List list2;
                Pair pair = (Pair)element$iv$iv;
                boolean bl2 = false;
                Name name = (Name)pair.component1();
                SimpleType innerType = (SimpleType)pair.component2();
                List<String> list3 = ValueClassAwareCallerKt.getMfvcUnboxMethods$getUnboxMethodNameSuffixes(innerType);
                if (list3 != null) {
                    void $this$mapTo$iv$iv;
                    Iterable $this$map$iv = list3;
                    boolean $i$f$map = false;
                    Iterable iterable2 = $this$map$iv;
                    Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    boolean $i$f$mapTo = false;
                    for (Object item$iv$iv : $this$mapTo$iv$iv) {
                        void it;
                        String string = (String)item$iv$iv;
                        Collection collection = destination$iv$iv2;
                        boolean bl3 = false;
                        collection.add(name.getIdentifier() + '-' + (String)it);
                    }
                    list2 = (List)destination$iv$iv2;
                } else {
                    list2 = CollectionsKt.listOf(name.getIdentifier());
                }
                Iterable list$iv$iv = list2;
                CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            }
            list = (List)destination$iv$iv;
        } else {
            list = null;
        }
        return list;
    }

    public static final /* synthetic */ List access$getValueClassUnboxMethods(SimpleType type, CallableMemberDescriptor descriptor2) {
        return ValueClassAwareCallerKt.getValueClassUnboxMethods(type, descriptor2);
    }

    public static final /* synthetic */ Class access$toInlineClass(KotlinType $receiver) {
        return ValueClassAwareCallerKt.toInlineClass($receiver);
    }

    public static final /* synthetic */ Method access$getBoxMethod(Class $receiver, CallableMemberDescriptor descriptor2) {
        return ValueClassAwareCallerKt.getBoxMethod($receiver, descriptor2);
    }

    public static final /* synthetic */ List access$makeKotlinParameterTypes(CallableMemberDescriptor descriptor2, Member member, Function1 isSpecificClass) {
        return ValueClassAwareCallerKt.makeKotlinParameterTypes(descriptor2, member, isSpecificClass);
    }

    public static final /* synthetic */ void access$checkParametersSize(Caller $receiver, int expectedArgsSize, CallableMemberDescriptor descriptor2, boolean isDefault) {
        ValueClassAwareCallerKt.checkParametersSize($receiver, expectedArgsSize, descriptor2, isDefault);
    }
}

