/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.SinceKotlin
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.full;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.full.KClasses$$Lambda$0;
import kotlin.reflect.full.KClasses$$Lambda$1;
import kotlin.reflect.full.KClasses$$Lambda$2;
import kotlin.reflect.full.KClasses$$Lambda$3;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0013\u001a\u001c\u0010S\u001a\u00020D*\u0006\u0012\u0002\b\u00030\u00042\n\u0010T\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0007\u001a\u001c\u0010U\u001a\u00020D*\u0006\u0012\u0002\b\u00030\u00042\n\u0010V\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0007\u001a+\u0010W\u001a\u0002H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\b\u0010X\u001a\u0004\u0018\u00010\u0003H\u0007\u00a2\u0006\u0002\u0010Y\u001a-\u0010Z\u001a\u0004\u0018\u0001H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\b\u0010X\u001a\u0004\u0018\u00010\u0003H\u0007\u00a2\u0006\u0002\u0010Y\u001a!\u0010[\u001a\u0002H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0007\u00a2\u0006\u0002\u0010\u0010\"6\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00048FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"(\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\f\"$\u0010\r\u001a\u0004\u0018\u00010\u0003*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010\"\"\u0010\u0011\u001a\u00020\u0012*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\u0015\",\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00180\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u001a\u0010\u001b\",\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001e\u0010\u001b\",\u0010\u001f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b \u0010\u0006\u001a\u0004\b!\u0010\u001b\",\u0010\"\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b#\u0010\u0006\u001a\u0004\b$\u0010\u001b\",\u0010%\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b&\u0010\u0006\u001a\u0004\b'\u0010\u001b\",\u0010(\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b)\u0010\u0006\u001a\u0004\b*\u0010\u001b\",\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b,\u0010\u0006\u001a\u0004\b-\u0010\u001b\",\u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b/\u0010\u0006\u001a\u0004\b0\u0010\u001b\",\u00101\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003020\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b3\u0010\u0006\u001a\u0004\b4\u0010\u001b\">\u00105\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u0002H\u0002\u0012\u0002\b\u0003060\u0017\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00048FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b7\u0010\u0006\u001a\u0004\b8\u0010\u001b\"B\u00109\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0002\b\u0003\u0012\u0002\b\u00030:0\u0017\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00048FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b;\u0010\u0006\u001a\u0004\b<\u0010\u001b\">\u0010=\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u0002H\u0002\u0012\u0002\b\u0003060\u0017\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00048FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b>\u0010\u0006\u001a\u0004\b?\u0010\u001b\"B\u0010@\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0002\b\u0003\u0012\u0002\b\u00030:0\u0017\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00048FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bA\u0010\u0006\u001a\u0004\bB\u0010\u001b\"\u001c\u0010C\u001a\u00020D*\u0006\u0012\u0002\b\u00030E8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bC\u0010F\"\u001c\u0010G\u001a\u00020D*\u0006\u0012\u0002\b\u00030E8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bG\u0010F\",\u0010H\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040I*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bJ\u0010\u0006\u001a\u0004\bK\u0010L\"(\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00120\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bN\u0010\u0006\u001a\u0004\bO\u0010\u001b\",\u0010P\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bQ\u0010\u0006\u001a\u0004\bR\u0010\u001b\u00a8\u0006\\"}, d2={"primaryConstructor", "Lkotlin/reflect/KFunction;", "T", "", "Lkotlin/reflect/KClass;", "getPrimaryConstructor$annotations", "(Lkotlin/reflect/KClass;)V", "getPrimaryConstructor", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KFunction;", "companionObject", "getCompanionObject$annotations", "getCompanionObject", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KClass;", "companionObjectInstance", "getCompanionObjectInstance$annotations", "getCompanionObjectInstance", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "defaultType", "Lkotlin/reflect/KType;", "getDefaultType$annotations", "getDefaultType", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KType;", "declaredMembers", "", "Lkotlin/reflect/KCallable;", "getDeclaredMembers$annotations", "getDeclaredMembers", "(Lkotlin/reflect/KClass;)Ljava/util/Collection;", "functions", "getFunctions$annotations", "getFunctions", "staticFunctions", "getStaticFunctions$annotations", "getStaticFunctions", "memberFunctions", "getMemberFunctions$annotations", "getMemberFunctions", "memberExtensionFunctions", "getMemberExtensionFunctions$annotations", "getMemberExtensionFunctions", "declaredFunctions", "getDeclaredFunctions$annotations", "getDeclaredFunctions", "declaredMemberFunctions", "getDeclaredMemberFunctions$annotations", "getDeclaredMemberFunctions", "declaredMemberExtensionFunctions", "getDeclaredMemberExtensionFunctions$annotations", "getDeclaredMemberExtensionFunctions", "staticProperties", "Lkotlin/reflect/KProperty0;", "getStaticProperties$annotations", "getStaticProperties", "memberProperties", "Lkotlin/reflect/KProperty1;", "getMemberProperties$annotations", "getMemberProperties", "memberExtensionProperties", "Lkotlin/reflect/KProperty2;", "getMemberExtensionProperties$annotations", "getMemberExtensionProperties", "declaredMemberProperties", "getDeclaredMemberProperties$annotations", "getDeclaredMemberProperties", "declaredMemberExtensionProperties", "getDeclaredMemberExtensionProperties$annotations", "getDeclaredMemberExtensionProperties", "isExtension", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "(Lkotlin/reflect/jvm/internal/KCallableImpl;)Z", "isNotExtension", "superclasses", "", "getSuperclasses$annotations", "getSuperclasses", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "allSupertypes", "getAllSupertypes$annotations", "getAllSupertypes", "allSuperclasses", "getAllSuperclasses$annotations", "getAllSuperclasses", "isSubclassOf", "base", "isSuperclassOf", "derived", "cast", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Ljava/lang/Object;", "safeCast", "createInstance", "kotlin-reflection"})
@JvmName(name="KClasses")
@SourceDebugExtension(value={"SMAP\nKClasses.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KClasses.kt\nkotlin/reflect/full/KClasses\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,279:1\n295#2,2:280\n295#2,2:282\n808#2,11:284\n808#2,11:295\n774#2:306\n865#2,2:307\n774#2:309\n865#2,2:310\n808#2,11:312\n774#2:323\n865#2,2:324\n774#2:326\n865#2,2:327\n774#2:329\n865#2,2:330\n774#2:332\n865#2,2:333\n774#2:335\n865#2,2:336\n774#2:338\n865#2,2:339\n774#2:341\n865#2,2:342\n1617#2,9:344\n1869#2:353\n1870#2:355\n1626#2:356\n1563#2:357\n1634#2,3:358\n669#2,4:361\n1740#2,3:365\n673#2,7:368\n1563#2:375\n1634#2,3:376\n1#3:354\n*S KotlinDebug\n*F\n+ 1 KClasses.kt\nkotlin/reflect/full/KClasses\n*L\n36#1:280,2\n47#1:282,2\n87#1:284,11\n94#1:295,11\n101#1:306\n101#1:307,2\n108#1:309\n108#1:310,2\n117#1:312,11\n124#1:323\n124#1:324,2\n131#1:326\n131#1:327,2\n139#1:329\n139#1:330,2\n146#1:332\n146#1:333,2\n153#1:335\n153#1:336,2\n160#1:338\n160#1:339,2\n167#1:341\n167#1:342,2\n182#1:344,9\n182#1:353\n182#1:355\n182#1:356\n221#1:357\n221#1:358,3\n274#1:361,4\n274#1:365,3\n274#1:368,7\n198#1:375\n198#1:376,3\n182#1:354\n*E\n"})
public final class KClasses {
    @Nullable
    public static final <T> KFunction<T> getPrimaryConstructor(@NotNull KClass<T> $this$primaryConstructor) {
        Object v1;
        block1: {
            Intrinsics.checkNotNullParameter($this$primaryConstructor, "<this>");
            Iterable $this$firstOrNull$iv = ((KClassImpl)$this$primaryConstructor).getConstructors();
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                KFunction it = (KFunction)element$iv;
                boolean bl2 = false;
                Intrinsics.checkNotNull(it, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KFunctionImpl");
                FunctionDescriptor functionDescriptor = ((KFunctionImpl)it).getDescriptor();
                Intrinsics.checkNotNull(functionDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ConstructorDescriptor");
                if (!((ConstructorDescriptor)functionDescriptor).isPrimary()) continue;
                v1 = element$iv;
                break block1;
            }
            v1 = null;
        }
        return v1;
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void getPrimaryConstructor$annotations(KClass kClass) {
    }

    @Nullable
    public static final KClass<?> getCompanionObject(@NotNull KClass<?> $this$companionObject) {
        Object v0;
        block1: {
            Intrinsics.checkNotNullParameter($this$companionObject, "<this>");
            Iterable $this$firstOrNull$iv = $this$companionObject.getNestedClasses();
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                KClass p0 = (KClass)element$iv;
                boolean bl2 = false;
                if (!p0.isCompanion()) continue;
                v0 = element$iv;
                break block1;
            }
            v0 = null;
        }
        return v0;
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void getCompanionObject$annotations(KClass kClass) {
    }

    @Nullable
    public static final Object getCompanionObjectInstance(@NotNull KClass<?> $this$companionObjectInstance) {
        Intrinsics.checkNotNullParameter($this$companionObjectInstance, "<this>");
        KClass<?> kClass = KClasses.getCompanionObject($this$companionObjectInstance);
        return kClass != null ? kClass.getObjectInstance() : null;
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void getCompanionObjectInstance$annotations(KClass kClass) {
    }

    @NotNull
    public static final KType getDefaultType(@NotNull KClass<?> $this$defaultType) {
        Intrinsics.checkNotNullParameter($this$defaultType, "<this>");
        SimpleType simpleType = ((KClassImpl)$this$defaultType).getDescriptor().getDefaultType();
        Intrinsics.checkNotNullExpressionValue(simpleType, "getDefaultType(...)");
        KClass<?> kClass = $this$defaultType;
        return new KTypeImpl(simpleType, new KClasses$$Lambda$0(kClass));
    }

    @Deprecated(message="This function creates a type which rarely makes sense for generic classes. For example, such type can only be used in signatures of members of that class. Use starProjectedType or createType() for clearer semantics.")
    @SinceKotlin(version="1.1")
    public static /* synthetic */ void getDefaultType$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KCallable<?>> getDeclaredMembers(@NotNull KClass<?> $this$declaredMembers) {
        Intrinsics.checkNotNullParameter($this$declaredMembers, "<this>");
        return ((KClassImpl)$this$declaredMembers).getData().getValue().getDeclaredMembers();
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void getDeclaredMembers$annotations(KClass kClass) {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final Collection<KFunction<?>> getFunctions(@NotNull KClass<?> $this$functions) {
        void $this$filterIsInstanceTo$iv$iv;
        Intrinsics.checkNotNullParameter($this$functions, "<this>");
        Iterable $this$filterIsInstance$iv = $this$functions.getMembers();
        boolean $i$f$filterIsInstance = false;
        Iterable iterable = $this$filterIsInstance$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterIsInstanceTo = false;
        for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
            if (!(element$iv$iv instanceof KFunction)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void getFunctions$annotations(KClass kClass) {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final Collection<KFunction<?>> getStaticFunctions(@NotNull KClass<?> $this$staticFunctions) {
        void $this$filterIsInstanceTo$iv$iv;
        Intrinsics.checkNotNullParameter($this$staticFunctions, "<this>");
        Iterable $this$filterIsInstance$iv = ((KClassImpl)$this$staticFunctions).getData().getValue().getAllStaticMembers();
        boolean $i$f$filterIsInstance = false;
        Iterable iterable = $this$filterIsInstance$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterIsInstanceTo = false;
        for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
            if (!(element$iv$iv instanceof KFunction)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void getStaticFunctions$annotations(KClass kClass) {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final Collection<KFunction<?>> getMemberFunctions(@NotNull KClass<?> $this$memberFunctions) {
        void $this$filterTo$iv$iv;
        Intrinsics.checkNotNullParameter($this$memberFunctions, "<this>");
        Iterable $this$filter$iv = ((KClassImpl)$this$memberFunctions).getData().getValue().getAllNonStaticMembers();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            KCallableImpl it = (KCallableImpl)element$iv$iv;
            boolean bl2 = false;
            if (!(KClasses.isNotExtension(it) && it instanceof KFunction)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void getMemberFunctions$annotations(KClass kClass) {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final Collection<KFunction<?>> getMemberExtensionFunctions(@NotNull KClass<?> $this$memberExtensionFunctions) {
        void $this$filterTo$iv$iv;
        Intrinsics.checkNotNullParameter($this$memberExtensionFunctions, "<this>");
        Iterable $this$filter$iv = ((KClassImpl)$this$memberExtensionFunctions).getData().getValue().getAllNonStaticMembers();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            KCallableImpl it = (KCallableImpl)element$iv$iv;
            boolean bl2 = false;
            if (!(KClasses.isExtension(it) && it instanceof KFunction)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void getMemberExtensionFunctions$annotations(KClass kClass) {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final Collection<KFunction<?>> getDeclaredFunctions(@NotNull KClass<?> $this$declaredFunctions) {
        void $this$filterIsInstanceTo$iv$iv;
        Intrinsics.checkNotNullParameter($this$declaredFunctions, "<this>");
        Iterable $this$filterIsInstance$iv = ((KClassImpl)$this$declaredFunctions).getData().getValue().getDeclaredMembers();
        boolean $i$f$filterIsInstance = false;
        Iterable iterable = $this$filterIsInstance$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterIsInstanceTo = false;
        for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
            if (!(element$iv$iv instanceof KFunction)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void getDeclaredFunctions$annotations(KClass kClass) {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final Collection<KFunction<?>> getDeclaredMemberFunctions(@NotNull KClass<?> $this$declaredMemberFunctions) {
        void $this$filterTo$iv$iv;
        Intrinsics.checkNotNullParameter($this$declaredMemberFunctions, "<this>");
        Iterable $this$filter$iv = ((KClassImpl)$this$declaredMemberFunctions).getData().getValue().getDeclaredNonStaticMembers();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            KCallableImpl it = (KCallableImpl)element$iv$iv;
            boolean bl2 = false;
            if (!(KClasses.isNotExtension(it) && it instanceof KFunction)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void getDeclaredMemberFunctions$annotations(KClass kClass) {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final Collection<KFunction<?>> getDeclaredMemberExtensionFunctions(@NotNull KClass<?> $this$declaredMemberExtensionFunctions) {
        void $this$filterTo$iv$iv;
        Intrinsics.checkNotNullParameter($this$declaredMemberExtensionFunctions, "<this>");
        Iterable $this$filter$iv = ((KClassImpl)$this$declaredMemberExtensionFunctions).getData().getValue().getDeclaredNonStaticMembers();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            KCallableImpl it = (KCallableImpl)element$iv$iv;
            boolean bl2 = false;
            if (!(KClasses.isExtension(it) && it instanceof KFunction)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void getDeclaredMemberExtensionFunctions$annotations(KClass kClass) {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final Collection<KProperty0<?>> getStaticProperties(@NotNull KClass<?> $this$staticProperties) {
        void $this$filterTo$iv$iv;
        Intrinsics.checkNotNullParameter($this$staticProperties, "<this>");
        Iterable $this$filter$iv = ((KClassImpl)$this$staticProperties).getData().getValue().getAllStaticMembers();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            KCallableImpl it = (KCallableImpl)element$iv$iv;
            boolean bl2 = false;
            if (!(KClasses.isNotExtension(it) && it instanceof KProperty0)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void getStaticProperties$annotations(KClass kClass) {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> Collection<KProperty1<T, ?>> getMemberProperties(@NotNull KClass<T> $this$memberProperties) {
        void $this$filterTo$iv$iv;
        Intrinsics.checkNotNullParameter($this$memberProperties, "<this>");
        Iterable $this$filter$iv = ((KClassImpl)$this$memberProperties).getData().getValue().getAllNonStaticMembers();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            KCallableImpl it = (KCallableImpl)element$iv$iv;
            boolean bl2 = false;
            if (!(KClasses.isNotExtension(it) && it instanceof KProperty1)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void getMemberProperties$annotations(KClass kClass) {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> Collection<KProperty2<T, ?, ?>> getMemberExtensionProperties(@NotNull KClass<T> $this$memberExtensionProperties) {
        void $this$filterTo$iv$iv;
        Intrinsics.checkNotNullParameter($this$memberExtensionProperties, "<this>");
        Iterable $this$filter$iv = ((KClassImpl)$this$memberExtensionProperties).getData().getValue().getAllNonStaticMembers();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            KCallableImpl it = (KCallableImpl)element$iv$iv;
            boolean bl2 = false;
            if (!(KClasses.isExtension(it) && it instanceof KProperty2)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void getMemberExtensionProperties$annotations(KClass kClass) {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> Collection<KProperty1<T, ?>> getDeclaredMemberProperties(@NotNull KClass<T> $this$declaredMemberProperties) {
        void $this$filterTo$iv$iv;
        Intrinsics.checkNotNullParameter($this$declaredMemberProperties, "<this>");
        Iterable $this$filter$iv = ((KClassImpl)$this$declaredMemberProperties).getData().getValue().getDeclaredNonStaticMembers();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            KCallableImpl it = (KCallableImpl)element$iv$iv;
            boolean bl2 = false;
            if (!(KClasses.isNotExtension(it) && it instanceof KProperty1)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void getDeclaredMemberProperties$annotations(KClass kClass) {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> Collection<KProperty2<T, ?, ?>> getDeclaredMemberExtensionProperties(@NotNull KClass<T> $this$declaredMemberExtensionProperties) {
        void $this$filterTo$iv$iv;
        Intrinsics.checkNotNullParameter($this$declaredMemberExtensionProperties, "<this>");
        Iterable $this$filter$iv = ((KClassImpl)$this$declaredMemberExtensionProperties).getData().getValue().getDeclaredNonStaticMembers();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            KCallableImpl it = (KCallableImpl)element$iv$iv;
            boolean bl2 = false;
            if (!(KClasses.isExtension(it) && it instanceof KProperty2)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void getDeclaredMemberExtensionProperties$annotations(KClass kClass) {
    }

    private static final boolean isExtension(KCallableImpl<?> $this$isExtension) {
        return $this$isExtension.getDescriptor().getExtensionReceiverParameter() != null;
    }

    private static final boolean isNotExtension(KCallableImpl<?> $this$isNotExtension) {
        return !KClasses.isExtension($this$isNotExtension);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<KClass<?>> getSuperclasses(@NotNull KClass<?> $this$superclasses) {
        void $this$mapNotNullTo$iv$iv;
        Intrinsics.checkNotNullParameter($this$superclasses, "<this>");
        Iterable $this$mapNotNull$iv = $this$superclasses.getSupertypes();
        boolean $i$f$mapNotNull = false;
        Iterable iterable = $this$mapNotNull$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
        while (iterator2.hasNext()) {
            KClass it$iv$iv;
            Object element$iv$iv$iv;
            Object element$iv$iv = element$iv$iv$iv = iterator2.next();
            boolean bl2 = false;
            KType it = (KType)element$iv$iv;
            boolean bl3 = false;
            KClassifier kClassifier = it.getClassifier();
            if ((kClassifier instanceof KClass ? (KClass)kClassifier : null) == null) continue;
            it$iv$iv = it$iv$iv;
            boolean bl4 = false;
            destination$iv$iv.add(it$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void getSuperclasses$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KType> getAllSupertypes(@NotNull KClass<?> $this$allSupertypes) {
        Intrinsics.checkNotNullParameter($this$allSupertypes, "<this>");
        Object r2 = DFS.dfs((Collection)$this$allSupertypes.getSupertypes(), KClasses$$Lambda$1.INSTANCE, new DFS.VisitedWithSet(), (DFS.NodeHandler)new DFS.NodeHandlerWithListResult<KType, KType>(){

            public boolean beforeChildren(KType current) {
                Intrinsics.checkNotNullParameter(current, "current");
                ((LinkedList)this.result).add(current);
                return true;
            }
        });
        Intrinsics.checkNotNullExpressionValue(r2, "dfs(...)");
        return (Collection)r2;
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void getAllSupertypes$annotations(KClass kClass) {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final Collection<KClass<?>> getAllSuperclasses(@NotNull KClass<?> $this$allSuperclasses) {
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter($this$allSuperclasses, "<this>");
        Iterable $this$map$iv = KClasses.getAllSupertypes($this$allSuperclasses);
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void supertype;
            KType kType = (KType)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            KClassifier kClassifier = supertype.getClassifier();
            KClass kClass = kClassifier instanceof KClass ? (KClass)kClassifier : null;
            if (kClass == null) {
                throw new KotlinReflectionInternalError("Supertype not a class: " + supertype);
            }
            collection.add(kClass);
        }
        return (List)destination$iv$iv;
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void getAllSuperclasses$annotations(KClass kClass) {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @SinceKotlin(version="1.1")
    public static final boolean isSubclassOf(@NotNull KClass<?> $this$isSubclassOf, @NotNull KClass<?> base) {
        Intrinsics.checkNotNullParameter($this$isSubclassOf, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        if (Intrinsics.areEqual($this$isSubclassOf, base)) return true;
        KProperty1 kProperty1 = isSubclassOf.1.INSTANCE;
        KClass<?> kClass = base;
        if (DFS.ifAny((Collection)CollectionsKt.listOf($this$isSubclassOf), new KClasses$$Lambda$2(kProperty1), new KClasses$$Lambda$3(kClass)) == false) return false;
        return true;
    }

    @SinceKotlin(version="1.1")
    public static final boolean isSuperclassOf(@NotNull KClass<?> $this$isSuperclassOf, @NotNull KClass<?> derived) {
        Intrinsics.checkNotNullParameter($this$isSuperclassOf, "<this>");
        Intrinsics.checkNotNullParameter(derived, "derived");
        return KClasses.isSubclassOf(derived, $this$isSuperclassOf);
    }

    @SinceKotlin(version="1.1")
    @NotNull
    public static final <T> T cast(@NotNull KClass<T> $this$cast, @Nullable Object value) {
        Intrinsics.checkNotNullParameter($this$cast, "<this>");
        if (!$this$cast.isInstance(value)) {
            throw new TypeCastException("Value cannot be cast to " + $this$cast.getQualifiedName());
        }
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type T of kotlin.reflect.full.KClasses.cast");
        return (T)value;
    }

    @SinceKotlin(version="1.1")
    @Nullable
    public static final <T> T safeCast(@NotNull KClass<T> $this$safeCast, @Nullable Object value) {
        Object object;
        Intrinsics.checkNotNullParameter($this$safeCast, "<this>");
        if ($this$safeCast.isInstance(value)) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type T of kotlin.reflect.full.KClasses.safeCast");
            object = value;
        } else {
            object = null;
        }
        return (T)object;
    }

    @SinceKotlin(version="1.1")
    @NotNull
    public static final <T> T createInstance(@NotNull KClass<T> $this$createInstance) {
        Object v1;
        block7: {
            Intrinsics.checkNotNullParameter($this$createInstance, "<this>");
            Iterable $this$singleOrNull$iv = $this$createInstance.getConstructors();
            boolean $i$f$singleOrNull = false;
            Object single$iv = null;
            boolean found$iv = false;
            for (Object element$iv : $this$singleOrNull$iv) {
                boolean bl2;
                block6: {
                    KFunction it = (KFunction)element$iv;
                    boolean bl3 = false;
                    Iterable $this$all$iv = it.getParameters();
                    boolean $i$f$all = false;
                    if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                        bl2 = true;
                    } else {
                        for (Object element$iv2 : $this$all$iv) {
                            KParameter p0 = (KParameter)element$iv2;
                            boolean bl4 = false;
                            if (p0.isOptional()) continue;
                            bl2 = false;
                            break block6;
                        }
                        bl2 = true;
                    }
                }
                if (!bl2) continue;
                if (found$iv) {
                    v1 = null;
                    break block7;
                }
                single$iv = element$iv;
                found$iv = true;
            }
            v1 = !found$iv ? null : single$iv;
        }
        KFunction kFunction = v1;
        if (kFunction == null) {
            throw new IllegalArgumentException("Class should have a single no-arg constructor: " + $this$createInstance);
        }
        KFunction noArgsConstructor = kFunction;
        return (T)noArgsConstructor.callBy(MapsKt.emptyMap());
    }

    private static final Type _get_defaultType_$lambda$1(KClass $this_defaultType) {
        return ((KClassImpl)$this_defaultType).getJClass();
    }

    /*
     * WARNING - void declaration
     */
    private static final Iterable _get_allSupertypes_$lambda$14(KType current) {
        Iterable iterable;
        KClassifier kClassifier = current.getClassifier();
        KClass kClass = kClassifier instanceof KClass ? (KClass)kClassifier : null;
        if (kClass == null) {
            throw new KotlinReflectionInternalError("Supertype not a class: " + current);
        }
        KClass klass = kClass;
        List<KType> supertypes = klass.getSupertypes();
        List<KTypeProjection> typeArguments = current.getArguments();
        if (typeArguments.isEmpty()) {
            iterable = supertypes;
        } else {
            void $this$mapTo$iv$iv;
            Intrinsics.checkNotNull(current, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
            TypeSubstitutor substitutor = TypeSubstitutor.create(((KTypeImpl)current).getType());
            boolean bl2 = false;
            Iterable $this$map$iv = supertypes;
            boolean $i$f$map = false;
            Iterable iterable2 = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                KotlinType substituted;
                void supertype;
                KType kType = (KType)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl3 = false;
                Intrinsics.checkNotNull(supertype, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
                if (substitutor.substitute(((KTypeImpl)supertype).getType(), Variance.INVARIANT) == null) {
                    throw new KotlinReflectionInternalError("Type substitution failed: " + supertype + " (" + current + ')');
                }
                collection.add(new KTypeImpl(substituted, null, 2, null));
            }
            iterable = (List)destination$iv$iv;
        }
        return iterable;
    }

    private static final Iterable isSubclassOf$lambda$16(KProperty1 $tmp0, KClass p0) {
        return (Iterable)((Function1)$tmp0).invoke(p0);
    }

    private static final Boolean isSubclassOf$lambda$17(KClass $base, KClass it) {
        return Intrinsics.areEqual(it, $base);
    }

    static /* synthetic */ Type accessor$KClasses$lambda0(KClass kClass) {
        return KClasses._get_defaultType_$lambda$1(kClass);
    }

    static /* synthetic */ Iterable accessor$KClasses$lambda1(KType kType) {
        return KClasses._get_allSupertypes_$lambda$14(kType);
    }

    static /* synthetic */ Iterable accessor$KClasses$lambda2(KProperty1 kProperty1, KClass kClass) {
        return KClasses.isSubclassOf$lambda$16(kProperty1, kClass);
    }

    static /* synthetic */ Boolean accessor$KClasses$lambda3(KClass kClass, KClass kClass2) {
        return KClasses.isSubclassOf$lambda$17(kClass, kClass2);
    }
}

