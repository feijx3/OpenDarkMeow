/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.SinceKotlin
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm;

import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\"\"\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001c\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00078@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\b\u00a8\u0006\t"}, d2={"jvmErasure", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/KType;", "getJvmErasure$annotations", "(Lkotlin/reflect/KType;)V", "getJvmErasure", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KClass;", "Lkotlin/reflect/KClassifier;", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KClass;", "kotlin-reflection"})
@JvmName(name="KTypesJvm")
@SourceDebugExtension(value={"SMAP\nKTypesJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KTypesJvm.kt\nkotlin/reflect/jvm/KTypesJvm\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,52:1\n295#2,2:53\n*S KotlinDebug\n*F\n+ 1 KTypesJvm.kt\nkotlin/reflect/jvm/KTypesJvm\n*L\n44#1:53,2\n*E\n"})
public final class KTypesJvm {
    @NotNull
    public static final KClass<?> getJvmErasure(@NotNull KType $this$jvmErasure) {
        Intrinsics.checkNotNullParameter($this$jvmErasure, "<this>");
        KClass<?> kClass = $this$jvmErasure.getClassifier();
        if (kClass == null || (kClass = KTypesJvm.getJvmErasure(kClass)) == null) {
            throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + $this$jvmErasure);
        }
        return kClass;
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void getJvmErasure$annotations(KType kType) {
    }

    @NotNull
    public static final KClass<?> getJvmErasure(@NotNull KClassifier $this$jvmErasure) {
        KClass kClass;
        Intrinsics.checkNotNullParameter($this$jvmErasure, "<this>");
        KClassifier kClassifier = $this$jvmErasure;
        if (kClassifier instanceof KClass) {
            kClass = (KClass)$this$jvmErasure;
        } else if (kClassifier instanceof KTypeParameter) {
            KType representativeBound;
            KType kType;
            Object v1;
            List<KType> bounds;
            block7: {
                bounds = ((KTypeParameter)$this$jvmErasure).getUpperBounds();
                Iterable $this$firstOrNull$iv = bounds;
                boolean $i$f$firstOrNull = false;
                for (Object element$iv : $this$firstOrNull$iv) {
                    KType it = (KType)element$iv;
                    boolean bl2 = false;
                    Intrinsics.checkNotNull(it, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
                    ClassifierDescriptor classifierDescriptor = ((KTypeImpl)it).getType().getConstructor().getDeclarationDescriptor();
                    ClassDescriptor classDescriptor = classifierDescriptor instanceof ClassDescriptor ? (ClassDescriptor)classifierDescriptor : null;
                    if (!(classDescriptor != null && classDescriptor.getKind() != ClassKind.INTERFACE && classDescriptor.getKind() != ClassKind.ANNOTATION_CLASS)) continue;
                    v1 = element$iv;
                    break block7;
                }
                v1 = null;
            }
            if ((kType = (KType)v1) == null) {
                kType = CollectionsKt.firstOrNull(bounds);
            }
            if ((kClass = (representativeBound = kType)) == null || (kClass = KTypesJvm.getJvmErasure((KType)((Object)kClass))) == null) {
                kClass = Reflection.getOrCreateKotlinClass(Object.class);
            }
        } else {
            throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + $this$jvmErasure);
        }
        return kClass;
    }
}

