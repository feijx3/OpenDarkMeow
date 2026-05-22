/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CopyableThrowable;
import kotlinx.coroutines.internal.ClassValueCtorCache;
import kotlinx.coroutines.internal.CtorCache;
import kotlinx.coroutines.internal.ExceptionsConstructorKt;
import kotlinx.coroutines.internal.FastServiceLoaderKt;
import kotlinx.coroutines.internal.WeakMapCtorCache;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000(\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a!\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u00042\u0006\u0010\t\u001a\u0002H\bH\u0000\u00a2\u0006\u0002\u0010\n\u001a2\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003j\u0002`\f\"\b\b\u0000\u0010\b*\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\b0\u000eH\u0002\u001a.\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003j\u0002`\f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0002\u001a\u0018\u0010\u0011\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0012\u001a\u00020\u0001H\u0002\u001a\u001b\u0010\u0013\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u0001H\u0082\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000*(\b\u0002\u0010\u0002\"\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u00a8\u0006\u0015"}, d2={"throwableFields", "", "Ctor", "Lkotlin/Function1;", "", "ctorCache", "Lkotlinx/coroutines/internal/CtorCache;", "tryCopyException", "E", "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "createConstructor", "Lkotlinx/coroutines/internal/Ctor;", "clz", "Ljava/lang/Class;", "safeCtor", "block", "fieldsCountOrDefault", "defaultValue", "fieldsCount", "accumulator", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nExceptionsConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/ExceptionsConstructorKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,112:1\n1#2:113\n11158#3:114\n11493#3,3:115\n12727#3,3:132\n1971#4,14:118\n*S KotlinDebug\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/ExceptionsConstructorKt\n*L\n41#1:114\n41#1:115,3\n78#1:132,3\n59#1:118,14\n*E\n"})
public final class ExceptionsConstructorKt {
    private static final int throwableFields;
    @NotNull
    private static final CtorCache ctorCache;

    @Nullable
    public static final <E extends Throwable> E tryCopyException(@NotNull E exception) {
        if (exception instanceof CopyableThrowable) {
            Object object;
            try {
                boolean bl2 = false;
                object = Result.constructor-impl(((CopyableThrowable)((Object)exception)).createCopy());
            }
            catch (Throwable throwable) {
                object = Result.constructor-impl(ResultKt.createFailure(throwable));
            }
            return (E)((Throwable)(Result.isFailure-impl(object) ? null : object));
        }
        return (E)ctorCache.get(exception.getClass()).invoke(exception);
    }

    /*
     * WARNING - void declaration
     */
    private static final <E extends Throwable> Function1<Throwable, Throwable> createConstructor(Class<E> clz) {
        Function1 function1;
        Object v1;
        void $this$mapTo$iv$iv;
        Function1 nullResult2 = createConstructor.nullResult.1.INSTANCE;
        if (throwableFields != ExceptionsConstructorKt.fieldsCountOrDefault(clz, 0)) {
            return nullResult2;
        }
        Constructor<?>[] $this$map$iv = clz.getConstructors();
        boolean $i$f$map = false;
        Constructor<?>[] constructorArray = $this$map$iv;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length);
        boolean $i$f$mapTo = false;
        int n2 = ((void)$this$mapTo$iv$iv).length;
        for (int i2 = 0; i2 < n2; ++i2) {
            Pair<Object, Integer> pair;
            void constructor;
            void item$iv$iv;
            void var11_15 = item$iv$iv = $this$mapTo$iv$iv[i2];
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            Class<?>[] p2 = constructor.getParameterTypes();
            switch (p2.length) {
                case 2: {
                    if (Intrinsics.areEqual(p2[0], String.class) && Intrinsics.areEqual(p2[1], Throwable.class)) {
                        pair = TuplesKt.to(ExceptionsConstructorKt.safeCtor(arg_0 -> ExceptionsConstructorKt.createConstructor$lambda$7$lambda$1((Constructor)constructor, arg_0)), 3);
                        break;
                    }
                    pair = TuplesKt.to(null, -1);
                    break;
                }
                case 1: {
                    Class<?> clazz = p2[0];
                    if (Intrinsics.areEqual(clazz, String.class)) {
                        pair = TuplesKt.to(ExceptionsConstructorKt.safeCtor(arg_0 -> ExceptionsConstructorKt.createConstructor$lambda$7$lambda$3((Constructor)constructor, arg_0)), 2);
                        break;
                    }
                    if (Intrinsics.areEqual(clazz, Throwable.class)) {
                        pair = TuplesKt.to(ExceptionsConstructorKt.safeCtor(arg_0 -> ExceptionsConstructorKt.createConstructor$lambda$7$lambda$4((Constructor)constructor, arg_0)), 1);
                        break;
                    }
                    pair = TuplesKt.to(null, -1);
                    break;
                }
                case 0: {
                    pair = TuplesKt.to(ExceptionsConstructorKt.safeCtor(arg_0 -> ExceptionsConstructorKt.createConstructor$lambda$7$lambda$6((Constructor)constructor, arg_0)), 0);
                    break;
                }
                default: {
                    pair = TuplesKt.to(null, -1);
                }
            }
            collection.add(pair);
        }
        Iterable $this$maxByOrNull$iv = (List)destination$iv$iv;
        boolean $i$f$maxByOrNull = false;
        Iterator iterator$iv = $this$maxByOrNull$iv.iterator();
        if (!iterator$iv.hasNext()) {
            v1 = null;
        } else {
            Object maxElem$iv = iterator$iv.next();
            if (!iterator$iv.hasNext()) {
                v1 = maxElem$iv;
            } else {
                Pair p0 = (Pair)maxElem$iv;
                boolean bl3 = false;
                int maxValue$iv = ((Number)p0.getSecond()).intValue();
                do {
                    Object e$iv = iterator$iv.next();
                    Pair p02 = (Pair)e$iv;
                    $i$a$-maxByOrNull-ExceptionsConstructorKt$createConstructor$2 = false;
                    int v$iv = ((Number)p02.getSecond()).intValue();
                    if (maxValue$iv >= v$iv) continue;
                    maxElem$iv = e$iv;
                    maxValue$iv = v$iv;
                } while (iterator$iv.hasNext());
                v1 = maxElem$iv;
            }
        }
        Pair pair = v1;
        return pair != null && (function1 = (Function1)pair.getFirst()) != null ? function1 : nullResult2;
    }

    private static final Function1<Throwable, Throwable> safeCtor(Function1<? super Throwable, ? extends Throwable> block) {
        return arg_0 -> ExceptionsConstructorKt.safeCtor$lambda$9(block, arg_0);
    }

    private static final int fieldsCountOrDefault(Class<?> $this$fieldsCountOrDefault, int defaultValue) {
        Object object;
        Object object2 = JvmClassMappingKt.getKotlinClass($this$fieldsCountOrDefault);
        try {
            KClass<?> $this$fieldsCountOrDefault_u24lambda_u2410 = object2;
            boolean bl2 = false;
            object = Result.constructor-impl(ExceptionsConstructorKt.fieldsCount$default($this$fieldsCountOrDefault, 0, 1, null));
        }
        catch (Throwable throwable) {
            object = Result.constructor-impl(ResultKt.createFailure(throwable));
        }
        object2 = object;
        object = defaultValue;
        return ((Number)(Result.isFailure-impl(object2) ? object : object2)).intValue();
    }

    private static final int fieldsCount(Class<?> $this$fieldsCount, int accumulator) {
        while (true) {
            Class<?> superClass;
            Field[] $this$count$iv = $this$fieldsCount.getDeclaredFields();
            boolean $i$f$count = false;
            int count$iv = 0;
            int n2 = $this$count$iv.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                Field element$iv;
                Field it = element$iv = $this$count$iv[i2];
                boolean bl2 = false;
                if (!(!Modifier.isStatic(it.getModifiers()))) continue;
                ++count$iv;
            }
            int fieldsCount = count$iv;
            int totalFields = accumulator + fieldsCount;
            if ($this$fieldsCount.getSuperclass() == null) {
                return totalFields;
            }
            $this$fieldsCount = superClass;
            accumulator = totalFields;
        }
    }

    static /* synthetic */ int fieldsCount$default(Class clazz, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n2 = 0;
        }
        return ExceptionsConstructorKt.fieldsCount(clazz, n2);
    }

    private static final Throwable createConstructor$lambda$7$lambda$1(Constructor $constructor, Throwable e2) {
        Object[] objectArray = new Object[]{e2.getMessage(), e2};
        Object t2 = $constructor.newInstance(objectArray);
        Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type kotlin.Throwable");
        return (Throwable)t2;
    }

    private static final Throwable createConstructor$lambda$7$lambda$3(Constructor $constructor, Throwable e2) {
        Throwable throwable;
        Object[] objectArray = new Object[]{e2.getMessage()};
        Object t2 = $constructor.newInstance(objectArray);
        Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type kotlin.Throwable");
        Throwable it = throwable = (Throwable)t2;
        boolean bl2 = false;
        it.initCause(e2);
        return throwable;
    }

    private static final Throwable createConstructor$lambda$7$lambda$4(Constructor $constructor, Throwable e2) {
        Object[] objectArray = new Object[]{e2};
        Object t2 = $constructor.newInstance(objectArray);
        Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type kotlin.Throwable");
        return (Throwable)t2;
    }

    private static final Throwable createConstructor$lambda$7$lambda$6(Constructor $constructor, Throwable e2) {
        Throwable throwable;
        Object t2 = $constructor.newInstance(new Object[0]);
        Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type kotlin.Throwable");
        Throwable it = throwable = (Throwable)t2;
        boolean bl2 = false;
        it.initCause(e2);
        return throwable;
    }

    /*
     * WARNING - void declaration
     */
    private static final Throwable safeCtor$lambda$9(Function1 $block, Throwable e2) {
        Object object;
        try {
            void var3_4;
            boolean bl2 = false;
            Throwable result = (Throwable)$block.invoke(e2);
            object = Result.constructor-impl(!Intrinsics.areEqual(e2.getMessage(), result.getMessage()) && !Intrinsics.areEqual(result.getMessage(), e2.toString()) ? null : var3_4);
        }
        catch (Throwable throwable) {
            object = Result.constructor-impl(ResultKt.createFailure(throwable));
        }
        return (Throwable)(Result.isFailure-impl(object) ? null : object);
    }

    public static final /* synthetic */ Function1 access$createConstructor(Class clz) {
        return ExceptionsConstructorKt.createConstructor(clz);
    }

    static {
        CtorCache ctorCache;
        throwableFields = ExceptionsConstructorKt.fieldsCountOrDefault(Throwable.class, -1);
        try {
            ctorCache = FastServiceLoaderKt.getANDROID_DETECTED() ? (CtorCache)WeakMapCtorCache.INSTANCE : (CtorCache)ClassValueCtorCache.INSTANCE;
        }
        catch (Throwable e2) {
            ctorCache = WeakMapCtorCache.INSTANCE;
        }
        ExceptionsConstructorKt.ctorCache = ctorCache;
    }
}

