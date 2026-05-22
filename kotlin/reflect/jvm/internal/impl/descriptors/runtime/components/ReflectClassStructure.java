/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectAnnotationSource;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClassKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.SignatureSerializer;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;

final class ReflectClassStructure {
    @NotNull
    public static final ReflectClassStructure INSTANCE = new ReflectClassStructure();

    private ReflectClassStructure() {
    }

    public final void loadClassAnnotations(@NotNull Class<?> klass, @NotNull KotlinJvmBinaryClass.AnnotationVisitor visitor2) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        Intrinsics.checkNotNullParameter(visitor2, "visitor");
        Iterator<Annotation> iterator2 = ArrayIteratorKt.iterator(klass.getDeclaredAnnotations());
        while (iterator2.hasNext()) {
            Annotation annotation = iterator2.next();
            Intrinsics.checkNotNull(annotation);
            this.processAnnotation(visitor2, annotation);
        }
        visitor2.visitEnd();
    }

    public final void visitMembers(@NotNull Class<?> klass, @NotNull KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        Intrinsics.checkNotNullParameter(memberVisitor, "memberVisitor");
        this.loadMethodAnnotations(klass, memberVisitor);
        this.loadConstructorAnnotations(klass, memberVisitor);
        this.loadFieldAnnotations(klass, memberVisitor);
    }

    private final void loadMethodAnnotations(Class<?> klass, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Iterator<Method> iterator2 = ArrayIteratorKt.iterator(klass.getDeclaredMethods());
        while (iterator2.hasNext()) {
            KotlinJvmBinaryClass.MethodAnnotationVisitor visitor2;
            Method method = iterator2.next();
            Name name = Name.identifier(method.getName());
            Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
            Intrinsics.checkNotNull(method);
            if (memberVisitor.visitMethod(name, SignatureSerializer.INSTANCE.methodDesc(method)) == null) continue;
            Annotation[][] annotationArray = ArrayIteratorKt.iterator(method.getDeclaredAnnotations());
            while (annotationArray.hasNext()) {
                Annotation annotation = annotationArray.next();
                KotlinJvmBinaryClass.AnnotationVisitor annotationVisitor = visitor2;
                Intrinsics.checkNotNull(annotation);
                this.processAnnotation(annotationVisitor, annotation);
            }
            Annotation[][] annotationArray2 = method.getParameterAnnotations();
            Intrinsics.checkNotNullExpressionValue(annotationArray2, "getParameterAnnotations(...)");
            annotationArray = annotationArray2;
            int n2 = ((Object[])annotationArray).length;
            for (int i2 = 0; i2 < n2; ++i2) {
                int parameterIndex = i2;
                Annotation[] annotations = annotationArray[i2];
                Iterator<Annotation> iterator3 = ArrayIteratorKt.iterator(annotations);
                while (iterator3.hasNext()) {
                    KotlinJvmBinaryClass.AnnotationArgumentVisitor it;
                    Annotation annotation = iterator3.next();
                    Class<KClass<Annotation>> annotationType = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation));
                    ClassId classId = ReflectClassUtilKt.getClassId(annotationType);
                    Intrinsics.checkNotNull(annotation);
                    if (visitor2.visitParameterAnnotation(parameterIndex, classId, new ReflectAnnotationSource(annotation)) == null) continue;
                    boolean bl2 = false;
                    INSTANCE.processAnnotationArguments(it, annotation, annotationType);
                }
            }
            visitor2.visitEnd();
        }
    }

    private final void loadConstructorAnnotations(Class<?> klass, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Iterator<Constructor<?>> iterator2 = ArrayIteratorKt.iterator(klass.getDeclaredConstructors());
        while (iterator2.hasNext()) {
            KotlinJvmBinaryClass.MethodAnnotationVisitor visitor2;
            Constructor<?> constructor = iterator2.next();
            Intrinsics.checkNotNull(constructor);
            if (memberVisitor.visitMethod(SpecialNames.INIT, SignatureSerializer.INSTANCE.constructorDesc(constructor)) == null) continue;
            Iterator<Annotation> iterator3 = ArrayIteratorKt.iterator(constructor.getDeclaredAnnotations());
            while (iterator3.hasNext()) {
                Annotation annotation = iterator3.next();
                KotlinJvmBinaryClass.AnnotationVisitor annotationVisitor = visitor2;
                Intrinsics.checkNotNull(annotation);
                this.processAnnotation(annotationVisitor, annotation);
            }
            Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
            Intrinsics.checkNotNull(parameterAnnotations);
            if (!(((Object[])parameterAnnotations).length == 0)) {
                int shift = constructor.getParameterTypes().length - ((Object[])parameterAnnotations).length;
                Annotation[][] annotationArray = parameterAnnotations;
                int n2 = ((Object[])annotationArray).length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    int parameterIndex = i2;
                    Annotation[] annotations = annotationArray[i2];
                    Iterator<Annotation> iterator4 = ArrayIteratorKt.iterator(annotations);
                    while (iterator4.hasNext()) {
                        Annotation annotation = iterator4.next();
                        Class<KClass<Annotation>> annotationType = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation));
                        ClassId classId = ReflectClassUtilKt.getClassId(annotationType);
                        Intrinsics.checkNotNull(annotation);
                        KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor = visitor2.visitParameterAnnotation(parameterIndex + shift, classId, new ReflectAnnotationSource(annotation));
                        if (annotationArgumentVisitor == null) continue;
                        KotlinJvmBinaryClass.AnnotationArgumentVisitor it = annotationArgumentVisitor;
                        boolean bl2 = false;
                        INSTANCE.processAnnotationArguments(it, annotation, annotationType);
                    }
                }
            }
            visitor2.visitEnd();
        }
    }

    private final void loadFieldAnnotations(Class<?> klass, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Iterator<Field> iterator2 = ArrayIteratorKt.iterator(klass.getDeclaredFields());
        while (iterator2.hasNext()) {
            KotlinJvmBinaryClass.AnnotationVisitor visitor2;
            Field field = iterator2.next();
            Name name = Name.identifier(field.getName());
            Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
            Intrinsics.checkNotNull(field);
            if (memberVisitor.visitField(name, SignatureSerializer.INSTANCE.fieldDesc(field), null) == null) continue;
            Iterator<Annotation> iterator3 = ArrayIteratorKt.iterator(field.getDeclaredAnnotations());
            while (iterator3.hasNext()) {
                Annotation annotation = iterator3.next();
                Intrinsics.checkNotNull(annotation);
                this.processAnnotation(visitor2, annotation);
            }
            visitor2.visitEnd();
        }
    }

    private final void processAnnotation(KotlinJvmBinaryClass.AnnotationVisitor visitor2, Annotation annotation) {
        block0: {
            Class<KClass<Annotation>> annotationType = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation));
            KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor = visitor2.visitAnnotation(ReflectClassUtilKt.getClassId(annotationType), new ReflectAnnotationSource(annotation));
            if (annotationArgumentVisitor == null) break block0;
            KotlinJvmBinaryClass.AnnotationArgumentVisitor it = annotationArgumentVisitor;
            boolean bl2 = false;
            INSTANCE.processAnnotationArguments(it, annotation, annotationType);
        }
    }

    private final void processAnnotationArguments(KotlinJvmBinaryClass.AnnotationArgumentVisitor visitor2, Annotation annotation, Class<?> annotationType) {
        Iterator<Method> iterator2 = ArrayIteratorKt.iterator(annotationType.getDeclaredMethods());
        while (iterator2.hasNext()) {
            Object object;
            Method method = iterator2.next();
            try {
                Intrinsics.checkNotNull(method.invoke(annotation, new Object[0]));
            }
            catch (IllegalAccessException e2) {
                continue;
            }
            Object value = object;
            Name name = Name.identifier(method.getName());
            Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
            this.processAnnotationArgumentValue(visitor2, name, value);
        }
        visitor2.visitEnd();
    }

    private final ClassLiteralValue classLiteralValue(Class<?> $this$classLiteralValue) {
        Class<?> currentClass = $this$classLiteralValue;
        int dimensions = 0;
        while (currentClass.isArray()) {
            ++dimensions;
            Intrinsics.checkNotNullExpressionValue(currentClass.getComponentType(), "getComponentType(...)");
        }
        if (currentClass.isPrimitive()) {
            if (Intrinsics.areEqual(currentClass, Void.TYPE)) {
                return new ClassLiteralValue(ClassId.Companion.topLevel(StandardNames.FqNames.unit.toSafe()), dimensions);
            }
            PrimitiveType primitiveType = JvmPrimitiveType.get(currentClass.getName()).getPrimitiveType();
            Intrinsics.checkNotNullExpressionValue((Object)primitiveType, "getPrimitiveType(...)");
            PrimitiveType primitiveType2 = primitiveType;
            if (dimensions > 0) {
                return new ClassLiteralValue(ClassId.Companion.topLevel(primitiveType2.getArrayTypeFqName()), dimensions - 1);
            }
            return new ClassLiteralValue(ClassId.Companion.topLevel(primitiveType2.getTypeFqName()), dimensions);
        }
        ClassId javaClassId = ReflectClassUtilKt.getClassId(currentClass);
        ClassId classId = JavaToKotlinClassMap.INSTANCE.mapJavaToKotlin(javaClassId.asSingleFqName());
        if (classId == null) {
            classId = javaClassId;
        }
        ClassId kotlinClassId = classId;
        return new ClassLiteralValue(kotlinClassId, dimensions);
    }

    private final void processAnnotationArgumentValue(KotlinJvmBinaryClass.AnnotationArgumentVisitor visitor2, Name name, Object value) {
        Class<?> clazz = value.getClass();
        if (Intrinsics.areEqual(clazz, Class.class)) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type java.lang.Class<*>");
            visitor2.visitClassLiteral(name, this.classLiteralValue((Class)value));
        } else if (ReflectKotlinClassKt.access$getTYPES_ELIGIBLE_FOR_SIMPLE_VISIT$p().contains(clazz)) {
            visitor2.visit(name, value);
        } else if (ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(clazz)) {
            Class<?> clazz2 = clazz.isEnum() ? clazz : clazz.getEnclosingClass();
            Intrinsics.checkNotNull(clazz2);
            ClassId classId = ReflectClassUtilKt.getClassId(clazz2);
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Enum<*>");
            Name name2 = Name.identifier(((Enum)value).name());
            Intrinsics.checkNotNullExpressionValue(name2, "identifier(...)");
            visitor2.visitEnum(name, classId, name2);
        } else if (Annotation.class.isAssignableFrom(clazz)) {
            Class<?>[] classArray = clazz.getInterfaces();
            Intrinsics.checkNotNullExpressionValue(classArray, "getInterfaces(...)");
            Class annotationClass = (Class)ArraysKt.single((Object[])classArray);
            Intrinsics.checkNotNull(annotationClass);
            KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor = visitor2.visitAnnotation(name, ReflectClassUtilKt.getClassId(annotationClass));
            if (annotationArgumentVisitor == null) {
                return;
            }
            KotlinJvmBinaryClass.AnnotationArgumentVisitor v2 = annotationArgumentVisitor;
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Annotation");
            this.processAnnotationArguments(v2, (Annotation)value, annotationClass);
        } else if (clazz.isArray()) {
            KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor annotationArrayArgumentVisitor = visitor2.visitArray(name);
            if (annotationArrayArgumentVisitor == null) {
                return;
            }
            KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor v3 = annotationArrayArgumentVisitor;
            Class<?> componentType = clazz.getComponentType();
            if (componentType.isEnum()) {
                Intrinsics.checkNotNull(componentType);
                ClassId enumClassId = ReflectClassUtilKt.getClassId(componentType);
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<*>");
                for (Object element : (Object[])value) {
                    Intrinsics.checkNotNull(element, "null cannot be cast to non-null type kotlin.Enum<*>");
                    Name name3 = Name.identifier(((Enum)element).name());
                    Intrinsics.checkNotNullExpressionValue(name3, "identifier(...)");
                    v3.visitEnum(enumClassId, name3);
                }
            } else if (Intrinsics.areEqual(componentType, Class.class)) {
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<*>");
                for (Object element : (Object[])value) {
                    Intrinsics.checkNotNull(element, "null cannot be cast to non-null type java.lang.Class<*>");
                    v3.visitClassLiteral(this.classLiteralValue((Class)element));
                }
            } else if (Annotation.class.isAssignableFrom(componentType)) {
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<*>");
                for (Object element : (Object[])value) {
                    KotlinJvmBinaryClass.AnnotationArgumentVisitor vv;
                    Intrinsics.checkNotNull(componentType);
                    if (v3.visitAnnotation(ReflectClassUtilKt.getClassId(componentType)) == null) continue;
                    Intrinsics.checkNotNull(element, "null cannot be cast to non-null type kotlin.Annotation");
                    this.processAnnotationArguments(vv, (Annotation)element, componentType);
                }
            } else {
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<*>");
                for (Object element : (Object[])value) {
                    v3.visit(element);
                }
            }
            v3.visitEnd();
        } else {
            throw new UnsupportedOperationException("Unsupported annotation argument value (" + clazz + "): " + value);
        }
    }
}

