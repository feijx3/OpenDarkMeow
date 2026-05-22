/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KPackageImpl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u000e\u0010 \u001a\u0004\u0018\u00010!*\u00020\"H\u0002\u001a$\u0010&\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e*\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030(0'2\u0006\u0010)\u001a\u00020\u0006H\u0002\u001a$\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002*\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030(0'2\u0006\u0010+\u001a\u00020\u0001H\u0002\"\u001b\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u001b\u0010\t\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u001b\u0010\r\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"/\u0010\u0011\u001a\n\u0012\u0004\u0012\u0002H\u0013\u0018\u00010\u0012\"\u0004\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u000e8F\u00a2\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0015\u0010\u0018\u001a\u00020\u0019*\u00020\u001a8F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u001b\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\"\u001b\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b$\u0010%\"-\u0010#\u001a\n\u0012\u0004\u0012\u0002H\u0013\u0018\u00010\u000e\"\b\b\u0000\u0010\u0013*\u00020,*\b\u0012\u0004\u0012\u0002H\u00130\u00128F\u00a2\u0006\u0006\u001a\u0004\b$\u0010-\u00a8\u0006."}, d2={"javaField", "Ljava/lang/reflect/Field;", "Lkotlin/reflect/KProperty;", "getJavaField", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Field;", "javaGetter", "Ljava/lang/reflect/Method;", "getJavaGetter", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Method;", "javaSetter", "Lkotlin/reflect/KMutableProperty;", "getJavaSetter", "(Lkotlin/reflect/KMutableProperty;)Ljava/lang/reflect/Method;", "javaMethod", "Lkotlin/reflect/KFunction;", "getJavaMethod", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Method;", "javaConstructor", "Ljava/lang/reflect/Constructor;", "T", "getJavaConstructor$annotations", "(Lkotlin/reflect/KFunction;)V", "getJavaConstructor", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Constructor;", "javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "kotlinProperty", "getKotlinProperty", "(Ljava/lang/reflect/Field;)Lkotlin/reflect/KProperty;", "getKPackage", "Lkotlin/reflect/KDeclarationContainer;", "Ljava/lang/reflect/Member;", "kotlinFunction", "getKotlinFunction", "(Ljava/lang/reflect/Method;)Lkotlin/reflect/KFunction;", "findKFunction", "", "Lkotlin/reflect/KCallable;", "method", "findKProperty", "field", "", "(Ljava/lang/reflect/Constructor;)Lkotlin/reflect/KFunction;", "kotlin-reflection"})
@JvmName(name="ReflectJvmMapping")
@SourceDebugExtension(value={"SMAP\nReflectJvmMapping.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJvmMapping.kt\nkotlin/reflect/jvm/ReflectJvmMapping\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,179:1\n1#2:180\n295#3,2:181\n*S KotlinDebug\n*F\n+ 1 ReflectJvmMapping.kt\nkotlin/reflect/jvm/ReflectJvmMapping\n*L\n177#1:181,2\n*E\n"})
public final class ReflectJvmMapping {
    @Nullable
    public static final Field getJavaField(@NotNull KProperty<?> $this$javaField) {
        Intrinsics.checkNotNullParameter($this$javaField, "<this>");
        KPropertyImpl<?> kPropertyImpl = UtilKt.asKPropertyImpl($this$javaField);
        return kPropertyImpl != null ? kPropertyImpl.getJavaField() : null;
    }

    @Nullable
    public static final Method getJavaGetter(@NotNull KProperty<?> $this$javaGetter) {
        Intrinsics.checkNotNullParameter($this$javaGetter, "<this>");
        return ReflectJvmMapping.getJavaMethod((KFunction)$this$javaGetter.getGetter());
    }

    @Nullable
    public static final Method getJavaSetter(@NotNull KMutableProperty<?> $this$javaSetter) {
        Intrinsics.checkNotNullParameter($this$javaSetter, "<this>");
        return ReflectJvmMapping.getJavaMethod((KFunction)$this$javaSetter.getSetter());
    }

    @Nullable
    public static final Method getJavaMethod(@NotNull KFunction<?> $this$javaMethod) {
        Intrinsics.checkNotNullParameter($this$javaMethod, "<this>");
        KCallableImpl<?> kCallableImpl = UtilKt.asKCallableImpl($this$javaMethod);
        Object var1_1 = kCallableImpl != null && (kCallableImpl = kCallableImpl.getCaller()) != null ? kCallableImpl.getMember() : null;
        return var1_1 instanceof Method ? (Method)var1_1 : null;
    }

    @Nullable
    public static final <T> Constructor<T> getJavaConstructor(@NotNull KFunction<? extends T> $this$javaConstructor) {
        Intrinsics.checkNotNullParameter($this$javaConstructor, "<this>");
        KCallableImpl<?> kCallableImpl = UtilKt.asKCallableImpl($this$javaConstructor);
        Object var1_1 = kCallableImpl != null && (kCallableImpl = kCallableImpl.getCaller()) != null ? kCallableImpl.getMember() : null;
        return var1_1 instanceof Constructor ? (Constructor)var1_1 : null;
    }

    public static /* synthetic */ void getJavaConstructor$annotations(KFunction kFunction) {
    }

    @NotNull
    public static final Type getJavaType(@NotNull KType $this$javaType) {
        Intrinsics.checkNotNullParameter($this$javaType, "<this>");
        Type type = ((KTypeImpl)$this$javaType).getJavaType();
        if (type == null) {
            type = TypesJVMKt.getJavaType($this$javaType);
        }
        return type;
    }

    @Nullable
    public static final KProperty<?> getKotlinProperty(@NotNull Field $this$kotlinProperty) {
        Intrinsics.checkNotNullParameter($this$kotlinProperty, "<this>");
        if ($this$kotlinProperty.isSynthetic()) {
            return null;
        }
        if (Modifier.isStatic($this$kotlinProperty.getModifiers())) {
            KDeclarationContainer kotlinPackage = ReflectJvmMapping.getKPackage($this$kotlinProperty);
            if (kotlinPackage != null) {
                return ReflectJvmMapping.findKProperty(kotlinPackage.getMembers(), $this$kotlinProperty);
            }
            Class<?> clazz = $this$kotlinProperty.getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue(clazz, "getDeclaringClass(...)");
            KClass<?> companionKClass = KClasses.getCompanionObject(JvmClassMappingKt.getKotlinClass(clazz));
            if (companionKClass != null) {
                KProperty<?> kProperty;
                Class<?> clazz2 = $this$kotlinProperty.getDeclaringClass();
                Intrinsics.checkNotNullExpressionValue(clazz2, "getDeclaringClass(...)");
                String string = $this$kotlinProperty.getName();
                Intrinsics.checkNotNullExpressionValue(string, "getName(...)");
                Field companionField = UtilKt.getDeclaredFieldOrNull(clazz2, string);
                if (companionField != null && (kProperty = ReflectJvmMapping.findKProperty(KClasses.getMemberProperties(companionKClass), companionField)) != null) {
                    KProperty<?> it = kProperty;
                    boolean bl2 = false;
                    return it;
                }
            }
        }
        Class<?> clazz = $this$kotlinProperty.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(clazz, "getDeclaringClass(...)");
        return ReflectJvmMapping.findKProperty(KClasses.getMemberProperties(JvmClassMappingKt.getKotlinClass(clazz)), $this$kotlinProperty);
    }

    private static final KDeclarationContainer getKPackage(Member $this$getKPackage) {
        KDeclarationContainer kDeclarationContainer;
        Class<?> clazz = $this$getKPackage.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(clazz, "getDeclaringClass(...)");
        Object object = ReflectKotlinClass.Factory.create(clazz);
        KotlinClassHeader.Kind kind2 = object != null && (object = ((ReflectKotlinClass)object).getClassHeader()) != null ? ((KotlinClassHeader)object).getKind() : null;
        switch (kind2 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[kind2.ordinal()]) {
            case 1: 
            case 2: 
            case 3: {
                Class<?> clazz2 = $this$getKPackage.getDeclaringClass();
                Intrinsics.checkNotNullExpressionValue(clazz2, "getDeclaringClass(...)");
                kDeclarationContainer = new KPackageImpl(clazz2);
                break;
            }
            default: {
                kDeclarationContainer = null;
            }
        }
        return kDeclarationContainer;
    }

    @Nullable
    public static final KFunction<?> getKotlinFunction(@NotNull Method $this$kotlinFunction) {
        Intrinsics.checkNotNullParameter($this$kotlinFunction, "<this>");
        if (Modifier.isStatic($this$kotlinFunction.getModifiers())) {
            KDeclarationContainer kotlinPackage = ReflectJvmMapping.getKPackage($this$kotlinFunction);
            if (kotlinPackage != null) {
                return ReflectJvmMapping.findKFunction(kotlinPackage.getMembers(), $this$kotlinFunction);
            }
            Class<?> clazz = $this$kotlinFunction.getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue(clazz, "getDeclaringClass(...)");
            KClass<?> companionKClass = KClasses.getCompanionObject(JvmClassMappingKt.getKotlinClass(clazz));
            if (companionKClass != null) {
                Class<KClass<?>> clazz2 = JvmClassMappingKt.getJavaClass(companionKClass);
                String string = $this$kotlinFunction.getName();
                Intrinsics.checkNotNullExpressionValue(string, "getName(...)");
                Object object = $this$kotlinFunction.getParameterTypes();
                Method companionMethod = UtilKt.getDeclaredMethodOrNull(clazz2, string, Arrays.copyOf(object, ((Class<?>[])object).length));
                if (companionMethod != null && (object = ReflectJvmMapping.findKFunction(KClasses.getFunctions(companionKClass), companionMethod)) != null) {
                    Object it = object;
                    boolean bl2 = false;
                    return it;
                }
            }
        }
        Class<?> clazz = $this$kotlinFunction.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(clazz, "getDeclaringClass(...)");
        return ReflectJvmMapping.findKFunction(KClasses.getFunctions(JvmClassMappingKt.getKotlinClass(clazz)), $this$kotlinFunction);
    }

    private static final KFunction<?> findKFunction(Collection<? extends KCallable<?>> $this$findKFunction, Method method) {
        for (KCallable<?> callable : $this$findKFunction) {
            if (!(callable instanceof KFunction) || !Intrinsics.areEqual(((KFunction)callable).getName(), method.getName()) || !Intrinsics.areEqual(ReflectJvmMapping.getJavaMethod((KFunction)callable), method)) continue;
            return (KFunction)callable;
        }
        for (KCallable<?> callable : $this$findKFunction) {
            if (!(callable instanceof KFunction) || Intrinsics.areEqual(((KFunction)callable).getName(), method.getName()) || !Intrinsics.areEqual(ReflectJvmMapping.getJavaMethod((KFunction)callable), method)) continue;
            return (KFunction)callable;
        }
        return null;
    }

    private static final KProperty<?> findKProperty(Collection<? extends KCallable<?>> $this$findKProperty, Field field) {
        for (KCallable<?> callable : $this$findKProperty) {
            if (!(callable instanceof KProperty) || !Intrinsics.areEqual(((KProperty)callable).getName(), field.getName()) || !Intrinsics.areEqual(ReflectJvmMapping.getJavaField((KProperty)callable), field)) continue;
            return (KProperty)callable;
        }
        for (KCallable<?> callable : $this$findKProperty) {
            if (!(callable instanceof KProperty) || Intrinsics.areEqual(((KProperty)callable).getName(), field.getName()) || !Intrinsics.areEqual(ReflectJvmMapping.getJavaField((KProperty)callable), field)) continue;
            return (KProperty)callable;
        }
        return null;
    }

    @Nullable
    public static final <T> KFunction<T> getKotlinFunction(@NotNull Constructor<T> $this$kotlinFunction) {
        Object v1;
        block1: {
            Intrinsics.checkNotNullParameter($this$kotlinFunction, "<this>");
            Class<T> clazz = $this$kotlinFunction.getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue(clazz, "getDeclaringClass(...)");
            Iterable $this$firstOrNull$iv = JvmClassMappingKt.getKotlinClass(clazz).getConstructors();
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                KFunction it = (KFunction)element$iv;
                boolean bl2 = false;
                if (!Intrinsics.areEqual(ReflectJvmMapping.getJavaConstructor(it), $this$kotlinFunction)) continue;
                v1 = element$iv;
                break block1;
            }
            v1 = null;
        }
        return v1;
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[KotlinClassHeader.Kind.values().length];
            try {
                nArray[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[KotlinClassHeader.Kind.MULTIFILE_CLASS.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

