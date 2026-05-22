/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.CacheByClass;
import kotlin.reflect.jvm.internal.ClassValueCache;
import kotlin.reflect.jvm.internal.ConcurrentHashMapCache;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u0002H\u00040\u0007H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"useClassValue", "", "createCache", "Lkotlin/reflect/jvm/internal/CacheByClass;", "V", "", "compute", "Lkotlin/Function1;", "Ljava/lang/Class;", "kotlin-reflection"})
@SourceDebugExtension(value={"SMAP\nCacheByClass.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CacheByClass.kt\nkotlin/reflect/jvm/internal/CacheByClassKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,98:1\n1#2:99\n*E\n"})
public final class CacheByClassKt {
    private static final boolean useClassValue;

    @NotNull
    public static final <V> CacheByClass<V> createCache(@NotNull Function1<? super Class<?>, ? extends V> compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        return useClassValue ? (CacheByClass)new ClassValueCache<V>(compute) : (CacheByClass)new ConcurrentHashMapCache<V>(compute);
    }

    static {
        Object object;
        Object object2;
        try {
            boolean bl2 = false;
            object2 = Result.constructor-impl(Class.forName("java.lang.ClassValue"));
        }
        catch (Throwable throwable) {
            object2 = Result.constructor-impl(ResultKt.createFailure(throwable));
        }
        if (Result.isSuccess-impl(object2)) {
            Class it = (Class)object2;
            boolean bl3 = false;
            object = Result.constructor-impl(true);
        } else {
            object = Result.constructor-impl(object2);
        }
        object2 = object;
        Boolean bl4 = false;
        useClassValue = (Boolean)(Result.isFailure-impl(object2) ? bl4 : object2);
    }
}

