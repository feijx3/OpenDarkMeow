/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.ExperimentalStdlibApi
 *  kotlin.SinceKotlin
 *  kotlin.WasExperimental
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.full;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KAnnotatedElement;
import kotlin.reflect.KClass;
import kotlin.reflect.full.Java8RepeatableContainerLoader;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000\"\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0087\b\u00a2\u0006\u0002\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u0006\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0087\b\u001a\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00010\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0087\b\u001a*\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00010\b\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0007\u00a8\u0006\u000b"}, d2={"findAnnotation", "T", "", "Lkotlin/reflect/KAnnotatedElement;", "(Lkotlin/reflect/KAnnotatedElement;)Ljava/lang/annotation/Annotation;", "hasAnnotation", "", "findAnnotations", "", "klass", "Lkotlin/reflect/KClass;", "kotlin-reflection"})
@JvmName(name="KAnnotatedElements")
@SourceDebugExtension(value={"SMAP\nKAnnotatedElements.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KAnnotatedElements.kt\nkotlin/reflect/full/KAnnotatedElements\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,102:1\n20#1:105\n295#2,2:103\n295#2,2:106\n295#2,2:108\n*S KotlinDebug\n*F\n+ 1 KAnnotatedElements.kt\nkotlin/reflect/full/KAnnotatedElements\n*L\n29#1:105\n20#1:103,2\n29#1:106,2\n62#1:108,2\n*E\n"})
public final class KAnnotatedElements {
    @SinceKotlin(version="1.1")
    public static final /* synthetic */ <T extends Annotation> T findAnnotation(KAnnotatedElement $this$findAnnotation) {
        Object v0;
        block1: {
            Intrinsics.checkNotNullParameter($this$findAnnotation, "<this>");
            boolean $i$f$findAnnotation = false;
            Iterable $this$firstOrNull$iv = $this$findAnnotation.getAnnotations();
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                Annotation it = (Annotation)element$iv;
                boolean bl2 = false;
                Intrinsics.reifiedOperationMarker(3, "T");
                if (!(it instanceof Annotation)) continue;
                v0 = element$iv;
                break block1;
            }
            v0 = null;
        }
        Intrinsics.reifiedOperationMarker(1, "T?");
        return (T)((Annotation)v0);
    }

    @SinceKotlin(version="1.4")
    @WasExperimental(markerClass={ExperimentalStdlibApi.class})
    public static final /* synthetic */ <T extends Annotation> boolean hasAnnotation(KAnnotatedElement $this$hasAnnotation) {
        Object v0;
        block1: {
            Intrinsics.checkNotNullParameter($this$hasAnnotation, "<this>");
            boolean $i$f$hasAnnotation = false;
            KAnnotatedElement $this$findAnnotation$iv = $this$hasAnnotation;
            boolean $i$f$findAnnotation = false;
            Iterable $this$firstOrNull$iv$iv = $this$findAnnotation$iv.getAnnotations();
            boolean $i$f$firstOrNull = false;
            for (Object element$iv$iv : $this$firstOrNull$iv$iv) {
                Annotation it$iv = (Annotation)element$iv$iv;
                boolean bl2 = false;
                Intrinsics.reifiedOperationMarker(3, "T");
                if (!(it$iv instanceof Annotation)) continue;
                v0 = element$iv$iv;
                break block1;
            }
            v0 = null;
        }
        Intrinsics.reifiedOperationMarker(1, "T?");
        return (Annotation)v0 != null;
    }

    @SinceKotlin(version="1.7")
    @WasExperimental(markerClass={ExperimentalStdlibApi.class})
    public static final /* synthetic */ <T extends Annotation> List<T> findAnnotations(KAnnotatedElement $this$findAnnotations) {
        Intrinsics.checkNotNullParameter($this$findAnnotations, "<this>");
        boolean $i$f$findAnnotations = false;
        Intrinsics.reifiedOperationMarker(4, "T");
        return KAnnotatedElements.findAnnotations($this$findAnnotations, Reflection.getOrCreateKotlinClass(Annotation.class));
    }

    @SinceKotlin(version="1.7")
    @WasExperimental(markerClass={ExperimentalStdlibApi.class})
    @NotNull
    public static final <T extends Annotation> List<T> findAnnotations(@NotNull KAnnotatedElement $this$findAnnotations, @NotNull KClass<T> klass) {
        Intrinsics.checkNotNullParameter($this$findAnnotations, "<this>");
        Intrinsics.checkNotNullParameter(klass, "klass");
        List<KClass<T>> filtered = CollectionsKt.filterIsInstance((Iterable)$this$findAnnotations.getAnnotations(), JvmClassMappingKt.getJavaClass(klass));
        if (!((Collection)filtered).isEmpty()) {
            return filtered;
        }
        Class<? extends Annotation> containerClass = Java8RepeatableContainerLoader.INSTANCE.loadRepeatableContainer(JvmClassMappingKt.getJavaClass(klass));
        if (containerClass != null) {
            Object v0;
            block4: {
                Iterable $this$firstOrNull$iv = $this$findAnnotations.getAnnotations();
                boolean $i$f$firstOrNull = false;
                for (Object element$iv : $this$firstOrNull$iv) {
                    Annotation it = (Annotation)element$iv;
                    boolean bl2 = false;
                    if (!Intrinsics.areEqual(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(it)), containerClass)) continue;
                    v0 = element$iv;
                    break block4;
                }
                v0 = null;
            }
            Annotation container = v0;
            if (container != null) {
                Method valueMethod = container.getClass().getMethod("value", new Class[0]);
                Object object = valueMethod.invoke(container, new Object[0]);
                Intrinsics.checkNotNull(object, "null cannot be cast to non-null type kotlin.Array<T of kotlin.reflect.full.KAnnotatedElements.findAnnotations>");
                return ArraysKt.asList((Annotation[])object);
            }
        }
        return CollectionsKt.emptyList();
    }
}

