/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.full.KClassifiers;
import kotlin.reflect.jvm.internal.CacheByClass;
import kotlin.reflect.jvm.internal.CacheByClassKt;
import kotlin.reflect.jvm.internal.CachesKt$$Lambda$0;
import kotlin.reflect.jvm.internal.CachesKt$$Lambda$1;
import kotlin.reflect.jvm.internal.CachesKt$$Lambda$2;
import kotlin.reflect.jvm.internal.CachesKt$$Lambda$3;
import kotlin.reflect.jvm.internal.CachesKt$$Lambda$4;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KPackageImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a&\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\b0\u0002\"\b\b\u0000\u0010\b*\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0000\u001a \u0010\u000b\u001a\u00020\f\"\b\b\u0000\u0010\b*\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0000\u001a\b\u0010\r\u001a\u00020\u000eH\u0000\u001a6\u0010\u001a\u001a\u00020\u0010\"\b\b\u0000\u0010\b*\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u001c\u001a\u00020\u0016H\u0000\u001a6\u0010\u001d\u001a\u00020\u0010\"\b\b\u0000\u0010\b*\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u001c\u001a\u00020\u0016H\u0002\"$\u0010\u0000\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"6\u0010\u0017\u001a*\u0012&\u0012$\u0012\u001a\u0012\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\u00160\u0013j\u0002`\u0019\u0012\u0004\u0012\u00020\u00100\u00180\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000*0\b\u0002\u0010\u0012\"\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\u00160\u00132\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\u00160\u0013\u00a8\u0006\u001e"}, d2={"K_CLASS_CACHE", "Lkotlin/reflect/jvm/internal/CacheByClass;", "Lkotlin/reflect/jvm/internal/KClassImpl;", "", "kotlin.jvm.PlatformType", "K_PACKAGE_CACHE", "Lkotlin/reflect/jvm/internal/KPackageImpl;", "getOrCreateKotlinClass", "T", "jClass", "Ljava/lang/Class;", "getOrCreateKotlinPackage", "Lkotlin/reflect/KDeclarationContainer;", "clearCaches", "", "CACHE_FOR_BASE_CLASSIFIERS", "Lkotlin/reflect/KType;", "CACHE_FOR_NULLABLE_BASE_CLASSIFIERS", "Key", "Lkotlin/Pair;", "", "Lkotlin/reflect/KTypeProjection;", "", "CACHE_FOR_GENERIC_CLASSIFIERS", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/reflect/jvm/internal/Key;", "getOrCreateKType", "arguments", "isMarkedNullable", "getOrCreateKTypeWithTypeArguments", "kotlin-reflection"})
@SourceDebugExtension(value={"SMAP\ncaches.kt\nKotlin\n*S Kotlin\n*F\n+ 1 caches.kt\nkotlin/reflect/jvm/internal/CachesKt\n+ 2 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,74:1\n72#2,2:75\n1#3:77\n*S KotlinDebug\n*F\n+ 1 caches.kt\nkotlin/reflect/jvm/internal/CachesKt\n*L\n68#1:75,2\n68#1:77\n*E\n"})
public final class CachesKt {
    @NotNull
    private static final CacheByClass<KClassImpl<? extends Object>> K_CLASS_CACHE = CacheByClassKt.createCache(CachesKt$$Lambda$0.INSTANCE);
    @NotNull
    private static final CacheByClass<KPackageImpl> K_PACKAGE_CACHE = CacheByClassKt.createCache(CachesKt$$Lambda$1.INSTANCE);
    @NotNull
    private static final CacheByClass<KType> CACHE_FOR_BASE_CLASSIFIERS = CacheByClassKt.createCache(CachesKt$$Lambda$2.INSTANCE);
    @NotNull
    private static final CacheByClass<KType> CACHE_FOR_NULLABLE_BASE_CLASSIFIERS = CacheByClassKt.createCache(CachesKt$$Lambda$3.INSTANCE);
    @NotNull
    private static final CacheByClass<ConcurrentHashMap<Pair<List<KTypeProjection>, Boolean>, KType>> CACHE_FOR_GENERIC_CLASSIFIERS = CacheByClassKt.createCache(CachesKt$$Lambda$4.INSTANCE);

    @NotNull
    public static final <T> KClassImpl<T> getOrCreateKotlinClass(@NotNull Class<T> jClass) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        KClassImpl<? extends Object> kClassImpl = K_CLASS_CACHE.get(jClass);
        Intrinsics.checkNotNull(kClassImpl, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<T of kotlin.reflect.jvm.internal.CachesKt.getOrCreateKotlinClass>");
        return kClassImpl;
    }

    @NotNull
    public static final <T> KDeclarationContainer getOrCreateKotlinPackage(@NotNull Class<T> jClass) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        return K_PACKAGE_CACHE.get(jClass);
    }

    public static final void clearCaches() {
        K_CLASS_CACHE.clear();
        K_PACKAGE_CACHE.clear();
        CACHE_FOR_BASE_CLASSIFIERS.clear();
        CACHE_FOR_NULLABLE_BASE_CLASSIFIERS.clear();
        CACHE_FOR_GENERIC_CLASSIFIERS.clear();
    }

    @NotNull
    public static final <T> KType getOrCreateKType(@NotNull Class<T> jClass, @NotNull List<KTypeProjection> arguments, boolean isMarkedNullable) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        return arguments.isEmpty() ? (isMarkedNullable ? CACHE_FOR_NULLABLE_BASE_CLASSIFIERS.get(jClass) : CACHE_FOR_BASE_CLASSIFIERS.get(jClass)) : CachesKt.getOrCreateKTypeWithTypeArguments(jClass, arguments, isMarkedNullable);
    }

    /*
     * WARNING - void declaration
     */
    private static final <T> KType getOrCreateKTypeWithTypeArguments(Class<T> jClass, List<KTypeProjection> arguments, boolean isMarkedNullable) {
        void $this$getOrPut$iv;
        ConcurrentHashMap<Pair<List<KTypeProjection>, Boolean>, KType> cache2 = CACHE_FOR_GENERIC_CLASSIFIERS.get(jClass);
        ConcurrentMap concurrentMap = cache2;
        Pair<List<KTypeProjection>, Boolean> key$iv = TuplesKt.to(arguments, isMarkedNullable);
        boolean $i$f$getOrPut = false;
        Object object = $this$getOrPut$iv.get(key$iv);
        if (object == null) {
            boolean bl2 = false;
            KType default$iv = KClassifiers.createType(CachesKt.getOrCreateKotlinClass(jClass), arguments, isMarkedNullable, CollectionsKt.emptyList());
            boolean bl3 = false;
            object = $this$getOrPut$iv.putIfAbsent(key$iv, default$iv);
            if (object == null) {
                object = default$iv;
            }
        }
        Intrinsics.checkNotNullExpressionValue(object, "getOrPut(...)");
        return (KType)object;
    }

    private static final KClassImpl K_CLASS_CACHE$lambda$0(Class it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new KClassImpl(it);
    }

    private static final KPackageImpl K_PACKAGE_CACHE$lambda$1(Class it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new KPackageImpl(it);
    }

    private static final KType CACHE_FOR_BASE_CLASSIFIERS$lambda$2(Class it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return KClassifiers.createType(CachesKt.getOrCreateKotlinClass(it), CollectionsKt.<KTypeProjection>emptyList(), false, CollectionsKt.emptyList());
    }

    private static final KType CACHE_FOR_NULLABLE_BASE_CLASSIFIERS$lambda$3(Class it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return KClassifiers.createType(CachesKt.getOrCreateKotlinClass(it), CollectionsKt.<KTypeProjection>emptyList(), true, CollectionsKt.emptyList());
    }

    private static final ConcurrentHashMap CACHE_FOR_GENERIC_CLASSIFIERS$lambda$4(Class it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new ConcurrentHashMap();
    }

    static /* synthetic */ KClassImpl accessor$CachesKt$lambda0(Class clazz) {
        return CachesKt.K_CLASS_CACHE$lambda$0(clazz);
    }

    static /* synthetic */ KPackageImpl accessor$CachesKt$lambda1(Class clazz) {
        return CachesKt.K_PACKAGE_CACHE$lambda$1(clazz);
    }

    static /* synthetic */ KType accessor$CachesKt$lambda2(Class clazz) {
        return CachesKt.CACHE_FOR_BASE_CLASSIFIERS$lambda$2(clazz);
    }

    static /* synthetic */ KType accessor$CachesKt$lambda3(Class clazz) {
        return CachesKt.CACHE_FOR_NULLABLE_BASE_CLASSIFIERS$lambda$3(clazz);
    }

    static /* synthetic */ ConcurrentHashMap accessor$CachesKt$lambda4(Class clazz) {
        return CachesKt.CACHE_FOR_GENERIC_CLASSIFIERS$lambda$4(clazz);
    }
}

