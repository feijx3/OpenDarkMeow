/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.calls;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$$Lambda$0;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$$Lambda$1;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$$Lambda$2;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$$Lambda$3;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u00004\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002\u001a$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002\u001aI\u0010\u000b\u001a\u0002H\f\"\b\b\u0000\u0010\f*\u00020\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00032\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0000\u00a2\u0006\u0002\u0010\u0013\u00a8\u0006\u0014\u00b2\u0006\n\u0010\u0015\u001a\u00020\u0007X\u008a\u0084\u0002\u00b2\u0006\n\u0010\u0016\u001a\u00020\tX\u008a\u0084\u0002"}, d2={"transformKotlinToJvm", "", "expectedType", "Ljava/lang/Class;", "throwIllegalArgumentType", "", "index", "", "name", "", "expectedJvmType", "createAnnotationInstance", "T", "annotationClass", "values", "", "methods", "", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/Map;Ljava/util/List;)Ljava/lang/Object;", "kotlin-reflection", "hashCode", "toString"})
@SourceDebugExtension(value={"SMAP\nAnnotationConstructorCaller.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnnotationConstructorCaller.kt\nkotlin/reflect/jvm/internal/calls/AnnotationConstructorCallerKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,181:1\n11228#2:182\n11563#2,3:183\n37#3:186\n36#3,3:187\n18#3:197\n1563#4:190\n1634#4,3:191\n1740#4,3:194\n*S KotlinDebug\n*F\n+ 1 AnnotationConstructorCaller.kt\nkotlin/reflect/jvm/internal/calls/AnnotationConstructorCallerKt\n*L\n75#1:182\n75#1:183,3\n75#1:186\n75#1:187,3\n173#1:197\n102#1:190\n102#1:191,3\n106#1:194,3\n*E\n"})
public final class AnnotationConstructorCallerKt {
    /*
     * WARNING - void declaration
     */
    private static final Object transformKotlinToJvm(Object $this$transformKotlinToJvm, Class<?> expectedType) {
        Object[] objectArray;
        Object object = $this$transformKotlinToJvm;
        if (object instanceof Class) {
            return null;
        }
        if (object instanceof KClass) {
            objectArray = JvmClassMappingKt.getJavaClass((KClass)$this$transformKotlinToJvm);
        } else if (object instanceof Object[]) {
            if ((Object[])$this$transformKotlinToJvm instanceof Class[]) {
                return null;
            }
            if ((Object[])$this$transformKotlinToJvm instanceof KClass[]) {
                void $this$toTypedArray$iv;
                void $this$mapTo$iv$iv;
                Object object2 = $this$transformKotlinToJvm;
                Intrinsics.checkNotNull(object2, "null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
                Object $this$map$iv = (KClass[])object2;
                boolean $i$f$map = false;
                KClass[] kClassArray = $this$map$iv;
                Collection destination$iv$iv = new ArrayList(((KClass[])$this$map$iv).length);
                boolean $i$f$mapTo = false;
                int n2 = ((void)$this$mapTo$iv$iv).length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    void p0;
                    void item$iv$iv;
                    void var12_11 = item$iv$iv = $this$mapTo$iv$iv[i2];
                    Collection collection = destination$iv$iv;
                    boolean bl2 = false;
                    collection.add(JvmClassMappingKt.getJavaClass(p0));
                }
                $this$map$iv = (List)destination$iv$iv;
                boolean $i$f$toTypedArray = false;
                void thisCollection$iv = $this$toTypedArray$iv;
                objectArray = thisCollection$iv.toArray(new Class[0]);
            } else {
                objectArray = (Object[])$this$transformKotlinToJvm;
            }
        } else {
            objectArray = $this$transformKotlinToJvm;
        }
        Object[] result = objectArray;
        return expectedType.isInstance(result) ? result : null;
    }

    private static final Void throwIllegalArgumentType(int index, String name, Class<?> expectedJvmType) {
        String string;
        KClass kotlinClass;
        KClass kClass = Intrinsics.areEqual(expectedJvmType, Class.class) ? Reflection.getOrCreateKotlinClass(KClass.class) : (kotlinClass = expectedJvmType.isArray() && Intrinsics.areEqual(expectedJvmType.getComponentType(), Class.class) ? Reflection.getOrCreateKotlinClass(KClass[].class) : JvmClassMappingKt.getKotlinClass(expectedJvmType));
        if (Intrinsics.areEqual(kotlinClass.getQualifiedName(), Reflection.getOrCreateKotlinClass(Object[].class).getQualifiedName())) {
            StringBuilder stringBuilder = new StringBuilder().append(kotlinClass.getQualifiedName()).append('<');
            Class<?> clazz = JvmClassMappingKt.getJavaClass(kotlinClass).getComponentType();
            Intrinsics.checkNotNullExpressionValue(clazz, "getComponentType(...)");
            string = stringBuilder.append(JvmClassMappingKt.getKotlinClass(clazz).getQualifiedName()).append('>').toString();
        } else {
            string = kotlinClass.getQualifiedName();
        }
        String typeString = string;
        throw new IllegalArgumentException("Argument #" + index + ' ' + name + " is not of the required type " + typeString);
    }

    @NotNull
    public static final <T> T createAnnotationInstance(@NotNull Class<T> annotationClass, @NotNull Map<String, ? extends Object> values, @NotNull List<Method> methods2) {
        Intrinsics.checkNotNullParameter(annotationClass, "annotationClass");
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(methods2, "methods");
        Object object = values;
        Lazy hashCode$delegate = LazyKt.lazy(new AnnotationConstructorCallerKt$$Lambda$0((Map)object));
        object = values;
        Object object2 = annotationClass;
        Lazy toString$delegate = LazyKt.lazy(new AnnotationConstructorCallerKt$$Lambda$1((Class)object2, (Map)object));
        Class[] classArray = new Class[]{annotationClass};
        object = methods2;
        object2 = hashCode$delegate;
        Lazy lazy = toString$delegate;
        Map<String, ? extends Object> map = values;
        Class<T> clazz = annotationClass;
        Object result = Proxy.newProxyInstance(annotationClass.getClassLoader(), classArray, new AnnotationConstructorCallerKt$$Lambda$2(clazz, map, lazy, (Lazy)object2, (List)object));
        Intrinsics.checkNotNull(result, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance");
        return (T)result;
    }

    /*
     * WARNING - void declaration
     */
    public static /* synthetic */ Object createAnnotationInstance$default(Class clazz, Map map, List list, int n2, Object object) {
        if ((n2 & 4) != 0) {
            void $this$mapTo$iv$iv;
            Iterable $this$map$iv = map.keySet();
            boolean $i$f$map = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void name;
                String string = (String)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl2 = false;
                collection.add(clazz.getDeclaredMethod((String)name, new Class[0]));
            }
            list = (List)destination$iv$iv;
        }
        return AnnotationConstructorCallerKt.createAnnotationInstance(clazz, map, list);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final <T> boolean createAnnotationInstance$equals(Class<T> $annotationClass, List<Method> $methods, Map<String, ? extends Object> $values, Object other) {
        boolean bl2;
        Object object = other instanceof Annotation ? (Annotation)other : null;
        if (!Intrinsics.areEqual(object != null && (object = JvmClassMappingKt.getAnnotationClass(object)) != null ? JvmClassMappingKt.getJavaClass(object) : null, $annotationClass)) return false;
        Iterable $this$all$iv = $methods;
        boolean $i$f$all = false;
        if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
            return true;
        }
        Iterator iterator2 = $this$all$iv.iterator();
        do {
            if (!iterator2.hasNext()) return true;
            Object element$iv = iterator2.next();
            Method method = (Method)element$iv;
            boolean bl3 = false;
            Object ours = $values.get(method.getName());
            Object theirs = method.invoke(other, new Object[0]);
            Object object2 = ours;
            if (object2 instanceof boolean[]) {
                boolean[] blArray = (boolean[])ours;
                Intrinsics.checkNotNull(theirs, "null cannot be cast to non-null type kotlin.BooleanArray");
                bl2 = Arrays.equals(blArray, (boolean[])theirs);
                continue;
            }
            if (object2 instanceof char[]) {
                char[] cArray = (char[])ours;
                Intrinsics.checkNotNull(theirs, "null cannot be cast to non-null type kotlin.CharArray");
                bl2 = Arrays.equals(cArray, (char[])theirs);
                continue;
            }
            if (object2 instanceof byte[]) {
                byte[] byArray = (byte[])ours;
                Intrinsics.checkNotNull(theirs, "null cannot be cast to non-null type kotlin.ByteArray");
                bl2 = Arrays.equals(byArray, (byte[])theirs);
                continue;
            }
            if (object2 instanceof short[]) {
                short[] sArray = (short[])ours;
                Intrinsics.checkNotNull(theirs, "null cannot be cast to non-null type kotlin.ShortArray");
                bl2 = Arrays.equals(sArray, (short[])theirs);
                continue;
            }
            if (object2 instanceof int[]) {
                int[] nArray = (int[])ours;
                Intrinsics.checkNotNull(theirs, "null cannot be cast to non-null type kotlin.IntArray");
                bl2 = Arrays.equals(nArray, (int[])theirs);
                continue;
            }
            if (object2 instanceof float[]) {
                float[] fArray = (float[])ours;
                Intrinsics.checkNotNull(theirs, "null cannot be cast to non-null type kotlin.FloatArray");
                bl2 = Arrays.equals(fArray, (float[])theirs);
                continue;
            }
            if (object2 instanceof long[]) {
                long[] lArray = (long[])ours;
                Intrinsics.checkNotNull(theirs, "null cannot be cast to non-null type kotlin.LongArray");
                bl2 = Arrays.equals(lArray, (long[])theirs);
                continue;
            }
            if (object2 instanceof double[]) {
                double[] dArray = (double[])ours;
                Intrinsics.checkNotNull(theirs, "null cannot be cast to non-null type kotlin.DoubleArray");
                bl2 = Arrays.equals(dArray, (double[])theirs);
                continue;
            }
            if (object2 instanceof Object[]) {
                Object[] objectArray = (Object[])ours;
                Intrinsics.checkNotNull(theirs, "null cannot be cast to non-null type kotlin.Array<*>");
                bl2 = Arrays.equals(objectArray, (Object[])theirs);
                continue;
            }
            bl2 = Intrinsics.areEqual(ours, theirs);
        } while (bl2);
        return false;
    }

    /*
     * WARNING - void declaration
     */
    private static final int createAnnotationInstance$lambda$3(Map $values) {
        Iterable iterable = $values.entrySet();
        int n2 = 0;
        for (Object t2 : iterable) {
            void entry;
            Map.Entry entry2 = (Map.Entry)t2;
            int n3 = n2;
            boolean bl2 = false;
            String key = (String)entry.getKey();
            Object value = entry.getValue();
            Object v2 = value;
            int valueHash = v2 instanceof boolean[] ? Arrays.hashCode((boolean[])value) : (v2 instanceof char[] ? Arrays.hashCode((char[])value) : (v2 instanceof byte[] ? Arrays.hashCode((byte[])value) : (v2 instanceof short[] ? Arrays.hashCode((short[])value) : (v2 instanceof int[] ? Arrays.hashCode((int[])value) : (v2 instanceof float[] ? Arrays.hashCode((float[])value) : (v2 instanceof long[] ? Arrays.hashCode((long[])value) : (v2 instanceof double[] ? Arrays.hashCode((double[])value) : (v2 instanceof Object[] ? Arrays.hashCode((Object[])value) : value.hashCode()))))))));
            int n4 = 127 * key.hashCode() ^ valueHash;
            n2 = n3 + n4;
        }
        return n2;
    }

    private static final int createAnnotationInstance$lambda$4(Lazy<Integer> $hashCode$delegate) {
        Lazy<Integer> lazy = $hashCode$delegate;
        return ((Number)lazy.getValue()).intValue();
    }

    private static final CharSequence createAnnotationInstance$lambda$7$lambda$6$lambda$5(Map.Entry entry) {
        String string;
        Object value;
        Intrinsics.checkNotNullParameter(entry, "entry");
        String key = (String)entry.getKey();
        Object v2 = value = entry.getValue();
        if (v2 instanceof boolean[]) {
            String string2 = Arrays.toString((boolean[])value);
            string = string2;
            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        } else if (v2 instanceof char[]) {
            String string3 = Arrays.toString((char[])value);
            string = string3;
            Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
        } else if (v2 instanceof byte[]) {
            String string4 = Arrays.toString((byte[])value);
            string = string4;
            Intrinsics.checkNotNullExpressionValue(string4, "toString(...)");
        } else if (v2 instanceof short[]) {
            String string5 = Arrays.toString((short[])value);
            string = string5;
            Intrinsics.checkNotNullExpressionValue(string5, "toString(...)");
        } else if (v2 instanceof int[]) {
            String string6 = Arrays.toString((int[])value);
            string = string6;
            Intrinsics.checkNotNullExpressionValue(string6, "toString(...)");
        } else if (v2 instanceof float[]) {
            String string7 = Arrays.toString((float[])value);
            string = string7;
            Intrinsics.checkNotNullExpressionValue(string7, "toString(...)");
        } else if (v2 instanceof long[]) {
            String string8 = Arrays.toString((long[])value);
            string = string8;
            Intrinsics.checkNotNullExpressionValue(string8, "toString(...)");
        } else if (v2 instanceof double[]) {
            String string9 = Arrays.toString((double[])value);
            string = string9;
            Intrinsics.checkNotNullExpressionValue(string9, "toString(...)");
        } else if (v2 instanceof Object[]) {
            String string10 = Arrays.toString((Object[])value);
            string = string10;
            Intrinsics.checkNotNullExpressionValue(string10, "toString(...)");
        } else {
            string = value.toString();
        }
        String valueString = string;
        return key + '=' + valueString;
    }

    private static final String createAnnotationInstance$lambda$7(Class $annotationClass, Map $values) {
        StringBuilder stringBuilder;
        StringBuilder $this$createAnnotationInstance_u24lambda_u247_u24lambda_u246 = stringBuilder = new StringBuilder();
        boolean bl2 = false;
        $this$createAnnotationInstance_u24lambda_u247_u24lambda_u246.append('@');
        $this$createAnnotationInstance_u24lambda_u247_u24lambda_u246.append($annotationClass.getCanonicalName());
        CollectionsKt.joinTo$default($values.entrySet(), $this$createAnnotationInstance_u24lambda_u247_u24lambda_u246, ", ", "(", ")", 0, null, AnnotationConstructorCallerKt$$Lambda$3.INSTANCE, 48, null);
        return stringBuilder.toString();
    }

    private static final String createAnnotationInstance$lambda$8(Lazy<String> $toString$delegate) {
        Lazy<String> lazy = $toString$delegate;
        return lazy.getValue();
    }

    /*
     * Enabled aggressive block sorting
     */
    private static final Object createAnnotationInstance$lambda$9(Class $annotationClass, Map $values, Lazy $toString$delegate, Lazy $hashCode$delegate, List $methods, Object object, Method method, Object[] args) {
        Object object2;
        String name = method.getName();
        if (name != null) {
            int n2 = -1;
            switch (name.hashCode()) {
                case 147696667: {
                    if (!name.equals("hashCode")) break;
                    n2 = 1;
                    break;
                }
                case 1444986633: {
                    if (!name.equals("annotationType")) break;
                    n2 = 2;
                    break;
                }
                case -1776922004: {
                    if (!name.equals("toString")) break;
                    n2 = 3;
                    break;
                }
            }
            switch (n2) {
                case 2: {
                    object2 = $annotationClass;
                    return object2;
                }
                case 3: {
                    object2 = AnnotationConstructorCallerKt.createAnnotationInstance$lambda$8($toString$delegate);
                    return object2;
                }
                case 1: {
                    object2 = AnnotationConstructorCallerKt.createAnnotationInstance$lambda$4($hashCode$delegate);
                    return object2;
                }
            }
        }
        if (Intrinsics.areEqual(name, "equals")) {
            boolean bl2 = args != null ? args.length == 1 : false;
            if (bl2) {
                object2 = AnnotationConstructorCallerKt.createAnnotationInstance$equals($annotationClass, $methods, $values, ArraysKt.single(args));
                return object2;
            }
        }
        if ($values.containsKey(name)) {
            object2 = $values.get(name);
            return object2;
        }
        StringBuilder stringBuilder = new StringBuilder().append("Method is not supported: ").append(method).append(" (args: ");
        Object[] $this$orEmpty$iv = args;
        boolean $i$f$orEmpty = false;
        Object[] objectArray = $this$orEmpty$iv;
        if ($this$orEmpty$iv != null) throw new KotlinReflectionInternalError(stringBuilder.append(ArraysKt.toList(objectArray)).append(')').toString());
        objectArray = new Object[]{};
        throw new KotlinReflectionInternalError(stringBuilder.append(ArraysKt.toList(objectArray)).append(')').toString());
    }

    public static final /* synthetic */ Object access$transformKotlinToJvm(Object $receiver, Class expectedType) {
        return AnnotationConstructorCallerKt.transformKotlinToJvm($receiver, expectedType);
    }

    public static final /* synthetic */ Void access$throwIllegalArgumentType(int index, String name, Class expectedJvmType) {
        return AnnotationConstructorCallerKt.throwIllegalArgumentType(index, name, expectedJvmType);
    }

    static /* synthetic */ int accessor$AnnotationConstructorCallerKt$lambda0(Map map) {
        return AnnotationConstructorCallerKt.createAnnotationInstance$lambda$3(map);
    }

    static /* synthetic */ String accessor$AnnotationConstructorCallerKt$lambda1(Class clazz, Map map) {
        return AnnotationConstructorCallerKt.createAnnotationInstance$lambda$7(clazz, map);
    }

    static /* synthetic */ Object accessor$AnnotationConstructorCallerKt$lambda2(Class clazz, Map map, Lazy lazy, Lazy lazy2, List list, Object object, Method method, Object[] objectArray) {
        return AnnotationConstructorCallerKt.createAnnotationInstance$lambda$9(clazz, map, lazy, lazy2, list, object, method, objectArray);
    }

    static /* synthetic */ CharSequence accessor$AnnotationConstructorCallerKt$lambda3(Map.Entry entry) {
        return AnnotationConstructorCallerKt.createAnnotationInstance$lambda$7$lambda$6$lambda$5(entry);
    }
}

