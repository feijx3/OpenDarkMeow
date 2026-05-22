/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.value.Value;
import org.jetbrains.annotations.NotNull;
import org.reflections.Reflections;
import org.reflections.scanners.Scanner;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0006H\u0007J#\u0010\u000b\u001a\u0002H\f\"\b\b\u0000\u0010\f*\u00020\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000e\u00a2\u0006\u0002\u0010\u000fJ$\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u00112\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0013\u001a\u00020\u0001J\u0006\u0010\u0014\u001a\u00020\u0007J4\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\f0\u000e0\u0016\"\b\b\u0000\u0010\f*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\f0\u000eR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2={"Lnet/ccbluex/liquidbounce/utils/ClassUtils;", "", "<init>", "()V", "cachedClasses", "", "", "", "getPackageName", "hasClass", "className", "getObjectInstance", "T", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "getValues", "", "Lnet/ccbluex/liquidbounce/value/Value;", "instance", "hasForge", "resolvePackage", "", "packagePath", "klass", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nClassUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassUtils.kt\nnet/ccbluex/liquidbounce/utils/ClassUtils\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,58:1\n13472#2,2:59\n11228#2:61\n11563#2,3:62\n808#3,11:65\n*S KotlinDebug\n*F\n+ 1 ClassUtils.kt\nnet/ccbluex/liquidbounce/utils/ClassUtils\n*L\n39#1:59,2\n47#1:61\n47#1:62,3\n50#1:65,11\n*E\n"})
public final class ClassUtils {
    @NotNull
    public static final ClassUtils INSTANCE = new ClassUtils();
    @NotNull
    private static final Map<String, Boolean> cachedClasses = new LinkedHashMap();

    private ClassUtils() {
    }

    @NotNull
    public final String getPackageName() {
        String string = DarkMeow.INSTANCE.getClass().getPackage().getName();
        Intrinsics.checkNotNullExpressionValue(string, "getName(...)");
        return string;
    }

    @JvmStatic
    public static final boolean hasClass(@NotNull String className) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(className, "className");
        if (cachedClasses.containsKey(className)) {
            Boolean bl3 = cachedClasses.get(className);
            Intrinsics.checkNotNull(bl3);
            bl2 = bl3;
        } else {
            boolean bl4;
            try {
                Class.forName(className);
                cachedClasses.put(className, true);
                bl4 = true;
            }
            catch (ClassNotFoundException e2) {
                cachedClasses.put(className, false);
                bl4 = false;
            }
            bl2 = bl4;
        }
        return bl2;
    }

    @NotNull
    public final <T> T getObjectInstance(@NotNull Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Field[] fieldArray = clazz.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(fieldArray, "getDeclaredFields(...)");
        Object[] $this$forEach$iv = fieldArray;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Field it = (Field)element$iv;
            boolean bl2 = false;
            if (!it.getName().equals("INSTANCE")) continue;
            Object object = it.get(null);
            Intrinsics.checkNotNull(object, "null cannot be cast to non-null type T of net.ccbluex.liquidbounce.utils.ClassUtils.getObjectInstance");
            return (T)object;
        }
        throw new IllegalAccessException("This class not a kotlin object");
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final List<Value<?>> getValues(@NotNull Class<?> clazz, @NotNull Object instance) {
        void $this$filterIsInstanceTo$iv$iv;
        Iterable $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(instance, "instance");
        Field[] fieldArray = clazz.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(fieldArray, "getDeclaredFields(...)");
        Object[] $this$map$iv = fieldArray;
        boolean $i$f$map = false;
        Object[] objectArray = $this$map$iv;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length);
        boolean $i$f$mapTo = false;
        for (void item$iv$iv : $this$mapTo$iv$iv) {
            void valueField;
            Field field = (Field)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            valueField.setAccessible(true);
            collection.add(valueField.get(instance));
        }
        Iterable $this$filterIsInstance$iv = (List)destination$iv$iv;
        boolean $i$f$filterIsInstance = false;
        $this$mapTo$iv$iv = $this$filterIsInstance$iv;
        destination$iv$iv = new ArrayList();
        boolean $i$f$filterIsInstanceTo = false;
        for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
            if (!(element$iv$iv instanceof Value)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    public final boolean hasForge() {
        return ClassUtils.hasClass("net.minecraftforge.common.MinecraftForge");
    }

    @NotNull
    public final <T> List<Class<? extends T>> resolvePackage(@NotNull String packagePath, @NotNull Class<T> klass) {
        Intrinsics.checkNotNullParameter(packagePath, "packagePath");
        Intrinsics.checkNotNullParameter(klass, "klass");
        Set<Class<T>> set = new Reflections(packagePath, new Scanner[0]).getSubTypesOf(klass);
        Intrinsics.checkNotNullExpressionValue(set, "getSubTypesOf(...)");
        return CollectionsKt.toMutableList((Collection)set);
    }
}

