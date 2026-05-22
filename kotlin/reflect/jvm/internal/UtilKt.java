/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference;
import kotlin.jvm.internal.RepeatableContainer;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.ModuleByClassLoaderKt;
import kotlin.reflect.jvm.internal.Util;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectAnnotationSource;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinarySourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.NullValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.TypedArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000\u00da\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005*\u00020\u0006H\u0000\u001a$\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0000\u001a.\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0014\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0005*\u0006\u0012\u0002\b\u00030\u0005H\u0000\u001a\u000e\u0010\u0012\u001a\u0004\u0018\u00010\u0013*\u00020\u0014H\u0000\u001a\u0012\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016*\u00020\u0018H\u0000\u001a\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016*\b\u0012\u0004\u0012\u00020\u00170\u0016\u001a\u000e\u0010\u001a\u001a\u0004\u0018\u00010\u0017*\u00020\u001bH\u0002\u001a\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u001d*\u0006\u0012\u0002\b\u00030\u001e2\u0006\u0010\r\u001a\u00020\bH\u0002\u001a\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001d*\u00020 2\u0006\u0010\r\u001a\u00020\bH\u0002\u001a%\u0010!\u001a\u0002H\"\"\u0004\b\u0000\u0010\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\"0$H\u0080\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010%\u001a\u0010\u0010&\u001a\u0004\u0018\u00010'*\u0004\u0018\u00010\u001dH\u0000\u001a\u0014\u0010(\u001a\b\u0012\u0002\b\u0003\u0018\u00010)*\u0004\u0018\u00010\u001dH\u0000\u001a\u0014\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010+*\u0004\u0018\u00010\u001dH\u0000\u001al\u00101\u001a\u0002H2\"\b\b\u0000\u00103*\u000204\"\b\b\u0001\u00102*\u00020.2\n\u00105\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u00106\u001a\u0002H32\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u001d\u0010=\u001a\u0019\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002H20>\u00a2\u0006\u0002\b@H\u0000\u00a2\u0006\u0002\u0010A\u001a\u0012\u0010H\u001a\u0004\u0018\u00010\u001d2\u0006\u0010I\u001a\u00020JH\u0000\u001a;\u0010K\u001a\u0004\u0018\u00010L*\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010M\u001a\u00020\u000f2\u001a\u0010N\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00050O\"\u0006\u0012\u0002\b\u00030\u0005H\u0000\u00a2\u0006\u0002\u0010P\u001a\u001a\u0010Q\u001a\u0004\u0018\u00010R*\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010M\u001a\u00020\u000fH\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001a\u0010,\u001a\u0004\u0018\u00010-*\u00020.8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b/\u00100\"\u0018\u0010B\u001a\u00020C*\u00020D8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\bB\u0010E\"\u0018\u0010F\u001a\u00020C*\u00020D8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\bG\u0010E\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006S"}, d2={"JVM_STATIC", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "getJVM_STATIC", "()Lorg/jetbrains/kotlin/name/FqName;", "toJavaClass", "Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "loadClass", "Ljava/lang/ClassLoader;", "kotlinClassId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "arrayDimensions", "", "classLoader", "packageName", "", "className", "createArrayType", "toKVisibility", "Lkotlin/reflect/KVisibility;", "Lkotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibility;", "computeAnnotations", "", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotated;", "unwrapRepeatableAnnotations", "toAnnotationInstance", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;", "toRuntimeValue", "", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;", "arrayToRuntimeValue", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ArrayValue;", "reflectionCall", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "asKFunctionImpl", "Lkotlin/reflect/jvm/internal/KFunctionImpl;", "asKPropertyImpl", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "asKCallableImpl", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "instanceReceiverParameter", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "getInstanceReceiverParameter", "(Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;)Lorg/jetbrains/kotlin/descriptors/ReceiverParameterDescriptor;", "deserializeToDescriptor", "D", "M", "Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;", "moduleAnchor", "proto", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "metadataVersion", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/BinaryVersion;", "createDescriptor", "Lkotlin/Function2;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/protobuf/MessageLite;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;Lorg/jetbrains/kotlin/metadata/deserialization/BinaryVersion;Lkotlin/jvm/functions/Function2;)Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;", "isInlineClassType", "", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KType;)Z", "needsMultiFieldValueClassFlattening", "getNeedsMultiFieldValueClassFlattening", "defaultPrimitiveValue", "type", "Ljava/lang/reflect/Type;", "getDeclaredMethodOrNull", "Ljava/lang/reflect/Method;", "name", "parameterTypes", "", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "getDeclaredFieldOrNull", "Ljava/lang/reflect/Field;", "kotlin-reflection"})
@SourceDebugExtension(value={"SMAP\nutil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 util.kt\nkotlin/reflect/jvm/internal/UtilKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,333:1\n1617#2,9:334\n1869#2:343\n1870#2:345\n1626#2:346\n1761#2,3:347\n1374#2:350\n1460#2,5:351\n1617#2,9:356\n1869#2:365\n1870#2:368\n1626#2:369\n1563#2:370\n1634#2,3:371\n1#3:344\n1#3:366\n1#3:367\n1#3:374\n*S KotlinDebug\n*F\n+ 1 util.kt\nkotlin/reflect/jvm/internal/UtilKt\n*L\n137#1:334,9\n137#1:343\n137#1:345\n137#1:346\n146#1:347,3\n147#1:350\n147#1:351,5\n167#1:356,9\n167#1:365\n167#1:368\n167#1:369\n197#1:370\n197#1:371,3\n137#1:344\n167#1:367\n*E\n"})
public final class UtilKt {
    @NotNull
    private static final FqName JVM_STATIC = new FqName("kotlin.jvm.JvmStatic");

    @NotNull
    public static final FqName getJVM_STATIC() {
        return JVM_STATIC;
    }

    @Nullable
    public static final Class<?> toJavaClass(@NotNull ClassDescriptor $this$toJavaClass) {
        AnnotatedElement annotatedElement;
        Intrinsics.checkNotNullParameter($this$toJavaClass, "<this>");
        SourceElement sourceElement = $this$toJavaClass.getSource();
        Intrinsics.checkNotNullExpressionValue(sourceElement, "getSource(...)");
        SourceElement source = sourceElement;
        if (source instanceof KotlinJvmBinarySourceElement) {
            KotlinJvmBinaryClass kotlinJvmBinaryClass = ((KotlinJvmBinarySourceElement)source).getBinaryClass();
            Intrinsics.checkNotNull(kotlinJvmBinaryClass, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
            annotatedElement = ((ReflectKotlinClass)kotlinJvmBinaryClass).getKlass();
        } else if (source instanceof RuntimeSourceElementFactory.RuntimeSourceElement) {
            ReflectJavaElement reflectJavaElement = ((RuntimeSourceElementFactory.RuntimeSourceElement)source).getJavaElement();
            Intrinsics.checkNotNull(reflectJavaElement, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
            annotatedElement = ((ReflectJavaClass)reflectJavaElement).getElement();
        } else {
            ClassId classId = DescriptorUtilsKt.getClassId($this$toJavaClass);
            if (classId == null) {
                return null;
            }
            ClassId classId2 = classId;
            annotatedElement = UtilKt.loadClass$default(ReflectClassUtilKt.getSafeClassLoader($this$toJavaClass.getClass()), classId2, 0, 2, null);
        }
        return annotatedElement;
    }

    @Nullable
    public static final Class<?> loadClass(@NotNull ClassLoader $this$loadClass, @NotNull ClassId kotlinClassId, int arrayDimensions) {
        ClassId javaClassId;
        Intrinsics.checkNotNullParameter($this$loadClass, "<this>");
        Intrinsics.checkNotNullParameter(kotlinClassId, "kotlinClassId");
        ClassId classId = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(kotlinClassId.asSingleFqName().toUnsafe());
        if (classId == null) {
            classId = kotlinClassId;
        }
        ClassLoader correctClassLoader = !Intrinsics.areEqual(javaClassId = classId, kotlinClassId) ? ReflectClassUtilKt.getSafeClassLoader(Unit.class) : $this$loadClass;
        return UtilKt.loadClass(correctClassLoader, javaClassId.getPackageFqName().asString(), javaClassId.getRelativeClassName().asString(), arrayDimensions);
    }

    public static /* synthetic */ Class loadClass$default(ClassLoader classLoader, ClassId classId, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n2 = 0;
        }
        return UtilKt.loadClass(classLoader, classId, n2);
    }

    private static final Class<?> loadClass(ClassLoader classLoader, String packageName, String className, int arrayDimensions) {
        StringBuilder stringBuilder;
        block35: {
            if (!Intrinsics.areEqual(packageName, "kotlin")) break block35;
            switch (className) {
                case "Array": {
                    return Object[].class;
                }
                case "BooleanArray": {
                    return boolean[].class;
                }
                case "ByteArray": {
                    return byte[].class;
                }
                case "CharArray": {
                    return char[].class;
                }
                case "DoubleArray": {
                    return double[].class;
                }
                case "FloatArray": {
                    return float[].class;
                }
                case "IntArray": {
                    return int[].class;
                }
                case "LongArray": {
                    return long[].class;
                }
                case "ShortArray": {
                    return short[].class;
                }
            }
        }
        StringBuilder $this$loadClass_u24lambda_u241 = stringBuilder = new StringBuilder();
        boolean bl2 = false;
        if (arrayDimensions > 0) {
            int n2 = 0;
            while (n2 < arrayDimensions) {
                int it = n2++;
                boolean bl3 = false;
                $this$loadClass_u24lambda_u241.append("[");
            }
            $this$loadClass_u24lambda_u241.append("L");
        }
        if (((CharSequence)packageName).length() > 0) {
            $this$loadClass_u24lambda_u241.append(packageName + '.');
        }
        $this$loadClass_u24lambda_u241.append(StringsKt.replace$default(className, '.', '$', false, 4, null));
        if (arrayDimensions > 0) {
            $this$loadClass_u24lambda_u241.append(";");
        }
        String fqName = stringBuilder.toString();
        return ReflectJavaClassFinderKt.tryLoadClass(classLoader, fqName);
    }

    @NotNull
    public static final Class<?> createArrayType(@NotNull Class<?> $this$createArrayType) {
        Intrinsics.checkNotNullParameter($this$createArrayType, "<this>");
        return Array.newInstance($this$createArrayType, 0).getClass();
    }

    @Nullable
    public static final KVisibility toKVisibility(@NotNull DescriptorVisibility $this$toKVisibility) {
        Intrinsics.checkNotNullParameter($this$toKVisibility, "<this>");
        DescriptorVisibility descriptorVisibility = $this$toKVisibility;
        return Intrinsics.areEqual(descriptorVisibility, DescriptorVisibilities.PUBLIC) ? KVisibility.PUBLIC : (Intrinsics.areEqual(descriptorVisibility, DescriptorVisibilities.PROTECTED) ? KVisibility.PROTECTED : (Intrinsics.areEqual(descriptorVisibility, DescriptorVisibilities.INTERNAL) ? KVisibility.INTERNAL : (Intrinsics.areEqual(descriptorVisibility, DescriptorVisibilities.PRIVATE) || Intrinsics.areEqual(descriptorVisibility, DescriptorVisibilities.PRIVATE_TO_THIS) ? KVisibility.PRIVATE : null)));
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<Annotation> computeAnnotations(@NotNull Annotated $this$computeAnnotations) {
        void $this$mapNotNullTo$iv$iv;
        Intrinsics.checkNotNullParameter($this$computeAnnotations, "<this>");
        Iterable $this$mapNotNull$iv = $this$computeAnnotations.getAnnotations();
        boolean $i$f$mapNotNull = false;
        Iterable iterable = $this$mapNotNull$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
        while (iterator2.hasNext()) {
            Annotation annotation;
            Object element$iv$iv$iv;
            Object element$iv$iv = element$iv$iv$iv = iterator2.next();
            boolean bl2 = false;
            AnnotationDescriptor it = (AnnotationDescriptor)element$iv$iv;
            boolean bl3 = false;
            SourceElement source = it.getSource();
            if (source instanceof ReflectAnnotationSource) {
                annotation = ((ReflectAnnotationSource)source).getAnnotation();
            } else if (source instanceof RuntimeSourceElementFactory.RuntimeSourceElement) {
                ReflectJavaElement reflectJavaElement = ((RuntimeSourceElementFactory.RuntimeSourceElement)source).getJavaElement();
                ReflectJavaAnnotation reflectJavaAnnotation = reflectJavaElement instanceof ReflectJavaAnnotation ? (ReflectJavaAnnotation)reflectJavaElement : null;
                annotation = reflectJavaAnnotation != null ? reflectJavaAnnotation.getAnnotation() : null;
            } else {
                annotation = UtilKt.toAnnotationInstance(it);
            }
            if (annotation == null) continue;
            Annotation it$iv$iv = annotation;
            boolean bl4 = false;
            destination$iv$iv.add(it$iv$iv);
        }
        return UtilKt.unwrapRepeatableAnnotations((List)destination$iv$iv);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<Annotation> unwrapRepeatableAnnotations(@NotNull List<? extends Annotation> $this$unwrapRepeatableAnnotations) {
        List list;
        boolean bl2;
        block8: {
            Intrinsics.checkNotNullParameter($this$unwrapRepeatableAnnotations, "<this>");
            Iterable $this$any$iv = $this$unwrapRepeatableAnnotations;
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl2 = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    Annotation it = (Annotation)element$iv;
                    boolean bl3 = false;
                    if (!Intrinsics.areEqual(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(it)).getSimpleName(), "Container")) continue;
                    bl2 = true;
                    break block8;
                }
                bl2 = false;
            }
        }
        if (bl2) {
            void $this$flatMapTo$iv$iv;
            Iterable $this$flatMap$iv = $this$unwrapRepeatableAnnotations;
            boolean $i$f$flatMap = false;
            Iterable iterable = $this$flatMap$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$flatMapTo = false;
            for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
                List<Annotation> list2;
                Annotation it = (Annotation)element$iv$iv;
                boolean bl4 = false;
                Class<KClass<Annotation>> klass = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(it));
                if (Intrinsics.areEqual(klass.getSimpleName(), "Container") && klass.getAnnotation(RepeatableContainer.class) != null) {
                    Object object = klass.getDeclaredMethod("value", new Class[0]).invoke(it, new Object[0]);
                    Intrinsics.checkNotNull(object, "null cannot be cast to non-null type kotlin.Array<out kotlin.Annotation>");
                    list2 = ArraysKt.asList((Annotation[])object);
                } else {
                    list2 = CollectionsKt.listOf(it);
                }
                Iterable list$iv$iv = list2;
                CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            }
            list = (List)destination$iv$iv;
        } else {
            list = $this$unwrapRepeatableAnnotations;
        }
        return list;
    }

    /*
     * WARNING - void declaration
     */
    private static final Annotation toAnnotationInstance(AnnotationDescriptor $this$toAnnotationInstance) {
        void $this$mapNotNullTo$iv$iv;
        void $this$mapNotNull$iv;
        ClassDescriptor classDescriptor = DescriptorUtilsKt.getAnnotationClass($this$toAnnotationInstance);
        Class<?> clazz = classDescriptor != null ? UtilKt.toJavaClass(classDescriptor) : null;
        Class<Object> clazz2 = clazz instanceof Class ? clazz : null;
        if (clazz2 == null) {
            return null;
        }
        Class<?> annotationClass = clazz2;
        Iterable iterable = $this$toAnnotationInstance.getAllValueArguments().entrySet();
        Class<?> clazz3 = annotationClass;
        boolean $i$f$mapNotNull = false;
        void var4_6 = $this$mapNotNull$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
        while (iterator2.hasNext()) {
            Pair<String, Object> pair;
            Object element$iv$iv$iv;
            Object element$iv$iv = element$iv$iv$iv = iterator2.next();
            boolean bl2 = false;
            Map.Entry entry = (Map.Entry)element$iv$iv;
            boolean bl3 = false;
            Name name = (Name)entry.getKey();
            ConstantValue value = (ConstantValue)entry.getValue();
            ClassLoader classLoader = annotationClass.getClassLoader();
            Intrinsics.checkNotNullExpressionValue(classLoader, "getClassLoader(...)");
            if (UtilKt.toRuntimeValue(value, classLoader) != null) {
                Object object;
                String string = name.asString();
                Object p0 = object;
                boolean bl4 = false;
                pair = TuplesKt.to(string, p0);
            } else {
                pair = null;
            }
            if (pair == null) continue;
            Pair<String, Object> it$iv$iv = pair;
            boolean bl5 = false;
            destination$iv$iv.add(it$iv$iv);
        }
        return (Annotation)AnnotationConstructorCallerKt.createAnnotationInstance$default(clazz3, MapsKt.toMap((List)destination$iv$iv), null, 4, null);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final Object toRuntimeValue(ConstantValue<?> $this$toRuntimeValue, ClassLoader classLoader) {
        Object object;
        ConstantValue<?> constantValue = $this$toRuntimeValue;
        if (constantValue instanceof AnnotationValue) {
            object = UtilKt.toAnnotationInstance((AnnotationDescriptor)((AnnotationValue)$this$toRuntimeValue).getValue());
            return object;
        } else if (constantValue instanceof ArrayValue) {
            object = UtilKt.arrayToRuntimeValue((ArrayValue)$this$toRuntimeValue, classLoader);
            return object;
        } else if (constantValue instanceof EnumValue) {
            Pair pair = (Pair)((EnumValue)$this$toRuntimeValue).getValue();
            ClassId enumClassId = (ClassId)pair.component1();
            Name entryName = (Name)pair.component2();
            Class clazz = UtilKt.loadClass$default(classLoader, enumClassId, 0, 2, null);
            if (clazz == null) return null;
            Class enumClass = clazz;
            boolean bl2 = false;
            object = Util.getEnumConstantByName(enumClass, entryName.asString());
            return object;
        } else if (constantValue instanceof KClassValue) {
            KClassValue.Value classValue = (KClassValue.Value)((KClassValue)$this$toRuntimeValue).getValue();
            if (classValue instanceof KClassValue.Value.NormalClass) {
                object = UtilKt.loadClass(classLoader, ((KClassValue.Value.NormalClass)classValue).getClassId(), ((KClassValue.Value.NormalClass)classValue).getArrayDimensions());
                return object;
            } else {
                if (!(classValue instanceof KClassValue.Value.LocalClass)) throw new NoWhenBranchMatchedException();
                ClassifierDescriptor classifierDescriptor = ((KClassValue.Value.LocalClass)classValue).getType().getConstructor().getDeclarationDescriptor();
                if (!(classifierDescriptor instanceof ClassDescriptor)) return null;
                ClassDescriptor classDescriptor = (ClassDescriptor)classifierDescriptor;
                if (classDescriptor == null) return null;
                object = UtilKt.toJavaClass(classDescriptor);
            }
            return object;
        } else {
            if (constantValue instanceof ErrorValue) return null;
            if (constantValue instanceof NullValue) {
                return null;
            }
            object = $this$toRuntimeValue.getValue();
        }
        return object;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final Object arrayToRuntimeValue(ArrayValue $this$arrayToRuntimeValue, ClassLoader classLoader) {
        void $this$mapTo$iv$iv2;
        if (!($this$arrayToRuntimeValue instanceof TypedArrayValue)) return null;
        TypedArrayValue typedArrayValue = (TypedArrayValue)$this$arrayToRuntimeValue;
        Object object = typedArrayValue;
        if (typedArrayValue == null) return null;
        if ((object = ((TypedArrayValue)object).getType()) == null) {
            return null;
        }
        Object type = object;
        Iterable $this$map$iv = (Iterable)$this$arrayToRuntimeValue.getValue();
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        int $i$f$mapTo2 = 0;
        for (Object item$iv$iv : $this$mapTo$iv$iv2) {
            void it;
            ConstantValue constantValue = (ConstantValue)item$iv$iv;
            Collection collection = destination$iv$iv2;
            boolean bl2 = false;
            collection.add(UtilKt.toRuntimeValue(it, classLoader));
        }
        List values = (List)destination$iv$iv2;
        PrimitiveType primitiveType = KotlinBuiltIns.getPrimitiveArrayElementType((KotlinType)type);
        switch (primitiveType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[primitiveType.ordinal()]) {
            case 1: {
                int $this$mapTo$iv$iv2 = 0;
                int destination$iv$iv2 = ((List)$this$arrayToRuntimeValue.getValue()).size();
                boolean[] $i$f$mapTo2 = new boolean[destination$iv$iv2];
                while ($this$mapTo$iv$iv2 < destination$iv$iv2) {
                    int n2 = $this$mapTo$iv$iv2++;
                    Object e2 = values.get(n2);
                    Intrinsics.checkNotNull(e2, "null cannot be cast to non-null type kotlin.Boolean");
                    $i$f$mapTo2[n2] = (Boolean)e2;
                }
                Object[] objectArray2 = $i$f$mapTo2;
                return objectArray2;
            }
            case 2: {
                int $this$mapTo$iv$iv2 = 0;
                int destination$iv$iv2 = ((List)$this$arrayToRuntimeValue.getValue()).size();
                char[] $i$f$mapTo2 = new char[destination$iv$iv2];
                while ($this$mapTo$iv$iv2 < destination$iv$iv2) {
                    int n3 = $this$mapTo$iv$iv2++;
                    Object e3 = values.get(n3);
                    Intrinsics.checkNotNull(e3, "null cannot be cast to non-null type kotlin.Char");
                    $i$f$mapTo2[n3] = ((Character)e3).charValue();
                }
                Object[] objectArray2 = $i$f$mapTo2;
                return objectArray2;
            }
            case 3: {
                int $this$mapTo$iv$iv2 = 0;
                int destination$iv$iv2 = ((List)$this$arrayToRuntimeValue.getValue()).size();
                byte[] $i$f$mapTo2 = new byte[destination$iv$iv2];
                while ($this$mapTo$iv$iv2 < destination$iv$iv2) {
                    int n4 = $this$mapTo$iv$iv2++;
                    Object e4 = values.get(n4);
                    Intrinsics.checkNotNull(e4, "null cannot be cast to non-null type kotlin.Byte");
                    $i$f$mapTo2[n4] = (Byte)e4;
                }
                Object[] objectArray2 = $i$f$mapTo2;
                return objectArray2;
            }
            case 4: {
                int $this$mapTo$iv$iv2 = 0;
                int destination$iv$iv2 = ((List)$this$arrayToRuntimeValue.getValue()).size();
                short[] $i$f$mapTo2 = new short[destination$iv$iv2];
                while ($this$mapTo$iv$iv2 < destination$iv$iv2) {
                    int n5 = $this$mapTo$iv$iv2++;
                    Object e5 = values.get(n5);
                    Intrinsics.checkNotNull(e5, "null cannot be cast to non-null type kotlin.Short");
                    $i$f$mapTo2[n5] = (Short)e5;
                }
                Object[] objectArray2 = $i$f$mapTo2;
                return objectArray2;
            }
            case 5: {
                int $this$mapTo$iv$iv2 = 0;
                int destination$iv$iv2 = ((List)$this$arrayToRuntimeValue.getValue()).size();
                int[] $i$f$mapTo2 = new int[destination$iv$iv2];
                while ($this$mapTo$iv$iv2 < destination$iv$iv2) {
                    int n6 = $this$mapTo$iv$iv2++;
                    Object e6 = values.get(n6);
                    Intrinsics.checkNotNull(e6, "null cannot be cast to non-null type kotlin.Int");
                    $i$f$mapTo2[n6] = (Integer)e6;
                }
                Object[] objectArray2 = $i$f$mapTo2;
                return objectArray2;
            }
            case 6: {
                int $this$mapTo$iv$iv2 = 0;
                int destination$iv$iv2 = ((List)$this$arrayToRuntimeValue.getValue()).size();
                float[] $i$f$mapTo2 = new float[destination$iv$iv2];
                while ($this$mapTo$iv$iv2 < destination$iv$iv2) {
                    int n7 = $this$mapTo$iv$iv2++;
                    Object e7 = values.get(n7);
                    Intrinsics.checkNotNull(e7, "null cannot be cast to non-null type kotlin.Float");
                    $i$f$mapTo2[n7] = ((Float)e7).floatValue();
                }
                Object[] objectArray2 = $i$f$mapTo2;
                return objectArray2;
            }
            case 7: {
                int $this$mapTo$iv$iv2 = 0;
                int destination$iv$iv2 = ((List)$this$arrayToRuntimeValue.getValue()).size();
                long[] $i$f$mapTo2 = new long[destination$iv$iv2];
                while ($this$mapTo$iv$iv2 < destination$iv$iv2) {
                    int n8 = $this$mapTo$iv$iv2++;
                    Object e8 = values.get(n8);
                    Intrinsics.checkNotNull(e8, "null cannot be cast to non-null type kotlin.Long");
                    $i$f$mapTo2[n8] = (Long)e8;
                }
                Object[] objectArray2 = $i$f$mapTo2;
                return objectArray2;
            }
            case 8: {
                int $this$mapTo$iv$iv2 = 0;
                int destination$iv$iv2 = ((List)$this$arrayToRuntimeValue.getValue()).size();
                double[] $i$f$mapTo2 = new double[destination$iv$iv2];
                while ($this$mapTo$iv$iv2 < destination$iv$iv2) {
                    int n9 = $this$mapTo$iv$iv2++;
                    Object e9 = values.get(n9);
                    Intrinsics.checkNotNull(e9, "null cannot be cast to non-null type kotlin.Double");
                    $i$f$mapTo2[n9] = (Double)e9;
                }
                Object[] objectArray2 = $i$f$mapTo2;
                return objectArray2;
            }
            case -1: {
                Object[] objectArray;
                Object[] objectArray2;
                if (!KotlinBuiltIns.isArray((KotlinType)type)) {
                    boolean $i$a$-check-UtilKt$arrayToRuntimeValue$102 = false;
                    String $i$a$-check-UtilKt$arrayToRuntimeValue$102 = "Not an array type: " + type;
                    throw new IllegalStateException($i$a$-check-UtilKt$arrayToRuntimeValue$102.toString());
                }
                KotlinType kotlinType = CollectionsKt.single(((KotlinType)type).getArguments()).getType();
                Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
                KotlinType argType = kotlinType;
                ClassifierDescriptor classifierDescriptor = argType.getConstructor().getDeclarationDescriptor();
                ClassDescriptor classDescriptor = classifierDescriptor instanceof ClassDescriptor ? (ClassDescriptor)classifierDescriptor : null;
                if (classDescriptor == null) {
                    throw new IllegalStateException(("Not a class type: " + argType).toString());
                }
                ClassDescriptor classifier = classDescriptor;
                if (KotlinBuiltIns.isString(argType)) {
                    $i$f$mapTo2 = 0;
                    int n10 = ((List)$this$arrayToRuntimeValue.getValue()).size();
                    objectArray = new String[n10];
                    while ($i$f$mapTo2 < n10) {
                        int n11 = $i$f$mapTo2++;
                        Intrinsics.checkNotNull(values.get(n11), "null cannot be cast to non-null type kotlin.String");
                    }
                    objectArray2 = objectArray;
                    return objectArray2;
                }
                if (KotlinBuiltIns.isKClass(classifier)) {
                    $i$f$mapTo2 = 0;
                    int n12 = ((List)$this$arrayToRuntimeValue.getValue()).size();
                    objectArray = new Class[n12];
                    while ($i$f$mapTo2 < n12) {
                        int n13 = $i$f$mapTo2++;
                        Intrinsics.checkNotNull(values.get(n13), "null cannot be cast to non-null type java.lang.Class<*>");
                    }
                    objectArray2 = objectArray;
                    return objectArray2;
                }
                ClassId classId = DescriptorUtilsKt.getClassId(classifier);
                Object object2 = classId;
                if (classId == null) return null;
                ClassId p0 = object2;
                boolean bl3 = false;
                Class clazz = UtilKt.loadClass$default(classLoader, p0, 0, 2, null);
                object2 = clazz;
                if (clazz == null) {
                    return null;
                }
                Object argClass = object2;
                Object object3 = Array.newInstance(argClass, ((List)$this$arrayToRuntimeValue.getValue()).size());
                Intrinsics.checkNotNull(object3, "null cannot be cast to non-null type kotlin.Array<in kotlin.Any?>");
                Object[] array = (Object[])object3;
                int n14 = values.size();
                int n15 = 0;
                while (n15 < n14) {
                    int it = n15++;
                    boolean bl4 = false;
                    array[it] = values.get(it);
                }
                objectArray2 = array;
                return objectArray2;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @Nullable
    public static final KFunctionImpl asKFunctionImpl(@Nullable Object $this$asKFunctionImpl) {
        KFunctionImpl kFunctionImpl = $this$asKFunctionImpl instanceof KFunctionImpl ? (KFunctionImpl)$this$asKFunctionImpl : null;
        if (kFunctionImpl == null) {
            FunctionReference functionReference = $this$asKFunctionImpl instanceof FunctionReference ? (FunctionReference)$this$asKFunctionImpl : null;
            KCallable kCallable = functionReference != null ? functionReference.compute() : null;
            kFunctionImpl = kCallable instanceof KFunctionImpl ? (KFunctionImpl)kCallable : null;
        }
        return kFunctionImpl;
    }

    @Nullable
    public static final KPropertyImpl<?> asKPropertyImpl(@Nullable Object $this$asKPropertyImpl) {
        KPropertyImpl kPropertyImpl = $this$asKPropertyImpl instanceof KPropertyImpl ? (KPropertyImpl)$this$asKPropertyImpl : null;
        if (kPropertyImpl == null) {
            PropertyReference propertyReference = $this$asKPropertyImpl instanceof PropertyReference ? (PropertyReference)$this$asKPropertyImpl : null;
            KCallable kCallable = propertyReference != null ? propertyReference.compute() : null;
            kPropertyImpl = kCallable instanceof KPropertyImpl ? (KPropertyImpl)kCallable : null;
        }
        return kPropertyImpl;
    }

    @Nullable
    public static final KCallableImpl<?> asKCallableImpl(@Nullable Object $this$asKCallableImpl) {
        KCallableImpl kCallableImpl = $this$asKCallableImpl instanceof KCallableImpl ? (KCallableImpl)$this$asKCallableImpl : null;
        if (kCallableImpl == null) {
            KFunctionImpl kFunctionImpl = UtilKt.asKFunctionImpl($this$asKCallableImpl);
            kCallableImpl = kFunctionImpl != null ? (KCallableImpl)kFunctionImpl : (KCallableImpl)UtilKt.asKPropertyImpl($this$asKCallableImpl);
        }
        return kCallableImpl;
    }

    @Nullable
    public static final ReceiverParameterDescriptor getInstanceReceiverParameter(@NotNull CallableDescriptor $this$instanceReceiverParameter) {
        ReceiverParameterDescriptor receiverParameterDescriptor;
        Intrinsics.checkNotNullParameter($this$instanceReceiverParameter, "<this>");
        if ($this$instanceReceiverParameter.getDispatchReceiverParameter() != null) {
            DeclarationDescriptor declarationDescriptor = $this$instanceReceiverParameter.getContainingDeclaration();
            Intrinsics.checkNotNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            receiverParameterDescriptor = ((ClassDescriptor)declarationDescriptor).getThisAsReceiverParameter();
        } else {
            receiverParameterDescriptor = null;
        }
        return receiverParameterDescriptor;
    }

    @NotNull
    public static final <M extends MessageLite, D extends CallableDescriptor> D deserializeToDescriptor(@NotNull Class<?> moduleAnchor, @NotNull M proto, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable, @NotNull BinaryVersion metadataVersion, @NotNull Function2<? super MemberDeserializer, ? super M, ? extends D> createDescriptor) {
        List<ProtoBuf.TypeParameter> list;
        Intrinsics.checkNotNullParameter(moduleAnchor, "moduleAnchor");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
        Intrinsics.checkNotNullParameter(createDescriptor, "createDescriptor");
        RuntimeModuleData moduleData = ModuleByClassLoaderKt.getOrCreateModule(moduleAnchor);
        M m2 = proto;
        if (m2 instanceof ProtoBuf.Function) {
            list = ((ProtoBuf.Function)proto).getTypeParameterList();
        } else if (m2 instanceof ProtoBuf.Property) {
            list = ((ProtoBuf.Property)proto).getTypeParameterList();
        } else {
            throw new IllegalStateException(("Unsupported message: " + proto).toString());
        }
        List<ProtoBuf.TypeParameter> typeParameters = list;
        DeserializationComponents deserializationComponents = moduleData.getDeserialization();
        DeclarationDescriptor declarationDescriptor = moduleData.getModule();
        VersionRequirementTable versionRequirementTable = VersionRequirementTable.Companion.getEMPTY();
        Intrinsics.checkNotNull(typeParameters);
        DeserializationContext context = new DeserializationContext(deserializationComponents, nameResolver, declarationDescriptor, typeTable, versionRequirementTable, metadataVersion, null, null, typeParameters);
        return (D)((CallableDescriptor)createDescriptor.invoke(new MemberDeserializer(context), proto));
    }

    public static final boolean isInlineClassType(@NotNull KType $this$isInlineClassType) {
        Intrinsics.checkNotNullParameter($this$isInlineClassType, "<this>");
        Object object = $this$isInlineClassType instanceof KTypeImpl ? (KTypeImpl)$this$isInlineClassType : null;
        return object != null && (object = ((KTypeImpl)object).getType()) != null ? InlineClassesUtilsKt.isInlineClassType((KotlinType)object) : false;
    }

    public static final boolean getNeedsMultiFieldValueClassFlattening(@NotNull KType $this$needsMultiFieldValueClassFlattening) {
        Intrinsics.checkNotNullParameter($this$needsMultiFieldValueClassFlattening, "<this>");
        Object object = $this$needsMultiFieldValueClassFlattening instanceof KTypeImpl ? (KTypeImpl)$this$needsMultiFieldValueClassFlattening : null;
        return object != null && (object = ((KTypeImpl)object).getType()) != null ? InlineClassesUtilsKt.needsMfvcFlattening((KotlinType)object) : false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Nullable
    public static final Object defaultPrimitiveValue(@NotNull Type type) {
        Comparable<Boolean> comparable;
        Intrinsics.checkNotNullParameter(type, "type");
        if (!(type instanceof Class)) return null;
        if (!((Class)type).isPrimitive()) return null;
        Class clazz = (Class)type;
        if (Intrinsics.areEqual(clazz, Boolean.TYPE)) {
            comparable = false;
            return comparable;
        } else if (Intrinsics.areEqual(clazz, Character.TYPE)) {
            comparable = Character.valueOf('\u0000');
            return comparable;
        } else if (Intrinsics.areEqual(clazz, Byte.TYPE)) {
            comparable = (byte)0;
            return comparable;
        } else if (Intrinsics.areEqual(clazz, Short.TYPE)) {
            comparable = (short)0;
            return comparable;
        } else if (Intrinsics.areEqual(clazz, Integer.TYPE)) {
            comparable = 0;
            return comparable;
        } else if (Intrinsics.areEqual(clazz, Float.TYPE)) {
            comparable = Float.valueOf(0.0f);
            return comparable;
        } else if (Intrinsics.areEqual(clazz, Long.TYPE)) {
            comparable = 0L;
            return comparable;
        } else if (Intrinsics.areEqual(clazz, Double.TYPE)) {
            comparable = 0.0;
            return comparable;
        } else {
            if (!Intrinsics.areEqual(clazz, Void.TYPE)) throw new UnsupportedOperationException("Unknown primitive: " + type);
            throw new IllegalStateException("Parameter with void type is illegal");
        }
    }

    @Nullable
    public static final Method getDeclaredMethodOrNull(@NotNull Class<?> $this$getDeclaredMethodOrNull, @NotNull String name, Class<?> ... parameterTypes) {
        Method method;
        Intrinsics.checkNotNullParameter($this$getDeclaredMethodOrNull, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
        try {
            method = $this$getDeclaredMethodOrNull.getDeclaredMethod(name, Arrays.copyOf(parameterTypes, parameterTypes.length));
        }
        catch (NoSuchMethodException e2) {
            method = null;
        }
        return method;
    }

    @Nullable
    public static final Field getDeclaredFieldOrNull(@NotNull Class<?> $this$getDeclaredFieldOrNull, @NotNull String name) {
        Field field;
        Intrinsics.checkNotNullParameter($this$getDeclaredFieldOrNull, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            field = $this$getDeclaredFieldOrNull.getDeclaredField(name);
        }
        catch (NoSuchFieldException e2) {
            field = null;
        }
        return field;
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[PrimitiveType.values().length];
            try {
                nArray[PrimitiveType.BOOLEAN.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[PrimitiveType.CHAR.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[PrimitiveType.BYTE.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[PrimitiveType.SHORT.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[PrimitiveType.INT.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[PrimitiveType.FLOAT.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[PrimitiveType.LONG.ordinal()] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[PrimitiveType.DOUBLE.ordinal()] = 8;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

