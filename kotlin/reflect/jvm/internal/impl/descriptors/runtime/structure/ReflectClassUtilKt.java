/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nreflectClassUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 reflectClassUtil.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectClassUtilKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,99:1\n1563#2:100\n1634#2,3:101\n1563#2:104\n1634#2,3:105\n1573#2:108\n1604#2,4:109\n*S KotlinDebug\n*F\n+ 1 reflectClassUtil.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectClassUtilKt\n*L\n34#1:100\n34#1:101,3\n35#1:104\n35#1:105,3\n50#1:108\n50#1:109,4\n*E\n"})
public final class ReflectClassUtilKt {
    @NotNull
    private static final List<KClass<? extends Object>> PRIMITIVE_CLASSES;
    @NotNull
    private static final Map<Class<? extends Object>, Class<? extends Object>> WRAPPER_TO_PRIMITIVE;
    @NotNull
    private static final Map<Class<? extends Object>, Class<? extends Object>> PRIMITIVE_TO_WRAPPER;
    @NotNull
    private static final Map<Class<? extends Function<?>>, Integer> FUNCTION_CLASSES;

    @NotNull
    public static final ClassLoader getSafeClassLoader(@NotNull Class<?> $this$safeClassLoader) {
        Intrinsics.checkNotNullParameter($this$safeClassLoader, "<this>");
        ClassLoader classLoader = $this$safeClassLoader.getClassLoader();
        if (classLoader == null) {
            ClassLoader classLoader2 = ClassLoader.getSystemClassLoader();
            classLoader = classLoader2;
            Intrinsics.checkNotNullExpressionValue(classLoader2, "getSystemClassLoader(...)");
        }
        return classLoader;
    }

    public static final boolean isEnumClassOrSpecializedEnumEntryClass(@NotNull Class<?> $this$isEnumClassOrSpecializedEnumEntryClass) {
        Intrinsics.checkNotNullParameter($this$isEnumClassOrSpecializedEnumEntryClass, "<this>");
        return Enum.class.isAssignableFrom($this$isEnumClassOrSpecializedEnumEntryClass);
    }

    @Nullable
    public static final Class<?> getPrimitiveByWrapper(@NotNull Class<?> $this$primitiveByWrapper) {
        Intrinsics.checkNotNullParameter($this$primitiveByWrapper, "<this>");
        return WRAPPER_TO_PRIMITIVE.get($this$primitiveByWrapper);
    }

    @Nullable
    public static final Class<?> getWrapperByPrimitive(@NotNull Class<?> $this$wrapperByPrimitive) {
        Intrinsics.checkNotNullParameter($this$wrapperByPrimitive, "<this>");
        return PRIMITIVE_TO_WRAPPER.get($this$wrapperByPrimitive);
    }

    @Nullable
    public static final Integer getFunctionClassArity(@NotNull Class<?> $this$functionClassArity) {
        Intrinsics.checkNotNullParameter($this$functionClassArity, "<this>");
        return FUNCTION_CLASSES.get($this$functionClassArity);
    }

    @NotNull
    public static final ClassId getClassId(@NotNull Class<?> $this$classId) {
        Class<?> clazz;
        block7: {
            block8: {
                block6: {
                    block5: {
                        Intrinsics.checkNotNullParameter($this$classId, "<this>");
                        if ($this$classId.isPrimitive()) {
                            throw new IllegalArgumentException("Can't compute ClassId for primitive type: " + $this$classId);
                        }
                        if ($this$classId.isArray()) {
                            throw new IllegalArgumentException("Can't compute ClassId for array type: " + $this$classId);
                        }
                        if ($this$classId.getEnclosingMethod() != null || $this$classId.getEnclosingConstructor() != null) break block5;
                        String string = $this$classId.getSimpleName();
                        Intrinsics.checkNotNullExpressionValue(string, "getSimpleName(...)");
                        if (!(((CharSequence)string).length() == 0)) break block6;
                    }
                    String string = $this$classId.getName();
                    Intrinsics.checkNotNullExpressionValue(string, "getName(...)");
                    FqName fqName = new FqName(string);
                    clazz = new ClassId(fqName.parent(), FqName.Companion.topLevel(fqName.shortName()), true);
                    break block7;
                }
                clazz = $this$classId.getDeclaringClass();
                if (clazz == null || (clazz = ReflectClassUtilKt.getClassId(clazz)) == null) break block8;
                Name name = Name.identifier($this$classId.getSimpleName());
                Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
                if ((clazz = ((ClassId)((Object)clazz)).createNestedClassId(name)) != null) break block7;
            }
            String string = $this$classId.getName();
            Intrinsics.checkNotNullExpressionValue(string, "getName(...)");
            clazz = ClassId.Companion.topLevel(new FqName(string));
        }
        return clazz;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @NotNull
    public static final String getDesc(@NotNull Class<?> $this$desc) {
        String string;
        block33: {
            Intrinsics.checkNotNullParameter($this$desc, "<this>");
            if (!$this$desc.isPrimitive()) break block33;
            String string2 = $this$desc.getName();
            if (string2 == null) throw new IllegalArgumentException("Unsupported primitive type: " + $this$desc);
            int n2 = -1;
            switch (string2.hashCode()) {
                case 64711720: {
                    if (string2.equals("boolean")) {
                        n2 = 1;
                    }
                    break;
                }
                case 3625364: {
                    if (string2.equals("void")) {
                        n2 = 2;
                    }
                    break;
                }
                case 3039496: {
                    if (string2.equals("byte")) {
                        n2 = 3;
                    }
                    break;
                }
                case -1325958191: {
                    if (string2.equals("double")) {
                        n2 = 4;
                    }
                    break;
                }
                case 3052374: {
                    if (string2.equals("char")) {
                        n2 = 5;
                    }
                    break;
                }
                case 109413500: {
                    if (string2.equals("short")) {
                        n2 = 6;
                    }
                    break;
                }
                case 97526364: {
                    if (string2.equals("float")) {
                        n2 = 7;
                    }
                    break;
                }
                case 104431: {
                    if (string2.equals("int")) {
                        n2 = 8;
                    }
                    break;
                }
                case 3327612: {
                    if (string2.equals("long")) {
                        n2 = 9;
                    }
                    break;
                }
            }
            switch (n2) {
                case 1: {
                    return "Z";
                }
                case 5: {
                    return "C";
                }
                case 3: {
                    return "B";
                }
                case 6: {
                    return "S";
                }
                case 8: {
                    return "I";
                }
                case 7: {
                    return "F";
                }
                case 9: {
                    return "J";
                }
                case 4: {
                    return "D";
                }
                case 2: {
                    return "V";
                }
                default: {
                    throw new IllegalArgumentException("Unsupported primitive type: " + $this$desc);
                }
            }
        }
        if ($this$desc.isArray()) {
            String string3 = $this$desc.getName();
            Intrinsics.checkNotNullExpressionValue(string3, "getName(...)");
            string = StringsKt.replace$default(string3, '.', '/', false, 4, null);
            return string;
        } else {
            StringBuilder stringBuilder = new StringBuilder().append('L');
            String string4 = $this$desc.getName();
            Intrinsics.checkNotNullExpressionValue(string4, "getName(...)");
            string = stringBuilder.append(StringsKt.replace$default(string4, '.', '/', false, 4, null)).append(';').toString();
        }
        return string;
    }

    @NotNull
    public static final List<Type> getParameterizedTypeArguments(@NotNull Type $this$parameterizedTypeArguments) {
        Intrinsics.checkNotNullParameter($this$parameterizedTypeArguments, "<this>");
        if (!($this$parameterizedTypeArguments instanceof ParameterizedType)) {
            return CollectionsKt.emptyList();
        }
        if (((ParameterizedType)$this$parameterizedTypeArguments).getOwnerType() == null) {
            Type[] typeArray = ((ParameterizedType)$this$parameterizedTypeArguments).getActualTypeArguments();
            Intrinsics.checkNotNullExpressionValue(typeArray, "getActualTypeArguments(...)");
            return ArraysKt.toList((Object[])typeArray);
        }
        return SequencesKt.toList(SequencesKt.flatMap(SequencesKt.generateSequence($this$parameterizedTypeArguments, ReflectClassUtilKt$$Lambda$0.INSTANCE), ReflectClassUtilKt$$Lambda$1.INSTANCE));
    }

    private static final ParameterizedType _get_parameterizedTypeArguments_$lambda$3(ParameterizedType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Type type = it.getOwnerType();
        return type instanceof ParameterizedType ? (ParameterizedType)type : null;
    }

    private static final Sequence _get_parameterizedTypeArguments_$lambda$4(ParameterizedType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Type[] typeArray = it.getActualTypeArguments();
        Intrinsics.checkNotNullExpressionValue(typeArray, "getActualTypeArguments(...)");
        return ArraysKt.asSequence((Object[])typeArray);
    }

    /*
     * WARNING - void declaration
     */
    static {
        void var3_3;
        void $this$mapIndexedTo$iv$iv;
        KClass it;
        Collection collection;
        Object $this$mapTo$iv$iv;
        KClass[] kClassArray = new KClass[]{Reflection.getOrCreateKotlinClass(Boolean.TYPE), Reflection.getOrCreateKotlinClass(Byte.TYPE), Reflection.getOrCreateKotlinClass(Character.TYPE), Reflection.getOrCreateKotlinClass(Double.TYPE), Reflection.getOrCreateKotlinClass(Float.TYPE), Reflection.getOrCreateKotlinClass(Integer.TYPE), Reflection.getOrCreateKotlinClass(Long.TYPE), Reflection.getOrCreateKotlinClass(Short.TYPE)};
        PRIMITIVE_CLASSES = CollectionsKt.listOf(kClassArray);
        Class[] $this$map$iv = (Class[])PRIMITIVE_CLASSES;
        boolean $i$f$map = false;
        Class[] classArray = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object t2 : $this$mapTo$iv$iv) {
            KClass kClass = (KClass)t2;
            collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(TuplesKt.to(JvmClassMappingKt.getJavaObjectType(it), JvmClassMappingKt.getJavaPrimitiveType(it)));
        }
        WRAPPER_TO_PRIMITIVE = MapsKt.toMap((List)destination$iv$iv);
        $this$map$iv = PRIMITIVE_CLASSES;
        $i$f$map = false;
        $this$mapTo$iv$iv = $this$map$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        $i$f$mapTo = false;
        for (Object t3 : $this$mapTo$iv$iv) {
            it = (KClass)t3;
            collection = destination$iv$iv;
            boolean bl3 = false;
            collection.add(TuplesKt.to(JvmClassMappingKt.getJavaPrimitiveType(it), JvmClassMappingKt.getJavaObjectType(it)));
        }
        PRIMITIVE_TO_WRAPPER = MapsKt.toMap((List)destination$iv$iv);
        $this$map$iv = new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class};
        Iterable $this$mapIndexed$iv = CollectionsKt.listOf($this$map$iv);
        boolean $i$f$mapIndexed = false;
        $this$mapTo$iv$iv = $this$mapIndexed$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
        boolean $i$f$mapIndexedTo = false;
        int index$iv$iv = 0;
        for (Object item$iv$iv : $this$mapIndexedTo$iv$iv) {
            void i2;
            void clazz;
            int n2;
            if ((n2 = index$iv$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Class clazz2 = (Class)item$iv$iv;
            int n3 = n2;
            collection = destination$iv$iv;
            boolean bl4 = false;
            collection.add(TuplesKt.to(clazz, (int)i2));
        }
        FUNCTION_CLASSES = MapsKt.toMap((List)var3_3);
    }

    static /* synthetic */ ParameterizedType accessor$ReflectClassUtilKt$lambda0(ParameterizedType parameterizedType) {
        return ReflectClassUtilKt._get_parameterizedTypeArguments_$lambda$3(parameterizedType);
    }

    static /* synthetic */ Sequence accessor$ReflectClassUtilKt$lambda1(ParameterizedType parameterizedType) {
        return ReflectClassUtilKt._get_parameterizedTypeArguments_$lambda$4(parameterizedType);
    }
}

