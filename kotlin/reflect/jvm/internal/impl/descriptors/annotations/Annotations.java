/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface Annotations
extends Iterable<AnnotationDescriptor>,
KMappedMarker {
    @NotNull
    public static final Companion Companion = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion.$$INSTANCE;

    public boolean isEmpty();

    @Nullable
    public AnnotationDescriptor findAnnotation(@NotNull FqName var1);

    public boolean hasAnnotation(@NotNull FqName var1);

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;
        @NotNull
        private static final Annotations EMPTY;

        private Companion() {
        }

        @NotNull
        public final Annotations getEMPTY() {
            return EMPTY;
        }

        @NotNull
        public final Annotations create(@NotNull List<? extends AnnotationDescriptor> annotations) {
            Intrinsics.checkNotNullParameter(annotations, "annotations");
            return annotations.isEmpty() ? EMPTY : (Annotations)new AnnotationsImpl(annotations);
        }

        static {
            $$INSTANCE = new Companion();
            EMPTY = new Annotations(){

                public boolean isEmpty() {
                    return true;
                }

                public Void findAnnotation(FqName fqName) {
                    Intrinsics.checkNotNullParameter(fqName, "fqName");
                    return null;
                }

                public Iterator<AnnotationDescriptor> iterator() {
                    return CollectionsKt.emptyList().iterator();
                }

                public String toString() {
                    return "EMPTY";
                }

                public boolean hasAnnotation(FqName fqName) {
                    return DefaultImpls.hasAnnotation(this, fqName);
                }
            };
        }
    }

    @SourceDebugExtension(value={"SMAP\nAnnotations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Annotations.kt\norg/jetbrains/kotlin/descriptors/annotations/Annotations$DefaultImpls\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,123:1\n295#2,2:124\n*S KotlinDebug\n*F\n+ 1 Annotations.kt\norg/jetbrains/kotlin/descriptors/annotations/Annotations$DefaultImpls\n*L\n29#1:124,2\n*E\n"})
    public static final class DefaultImpls {
        @Nullable
        public static AnnotationDescriptor findAnnotation(@NotNull Annotations $this, @NotNull FqName fqName) {
            Object v0;
            block1: {
                Intrinsics.checkNotNullParameter(fqName, "fqName");
                Iterable $this$firstOrNull$iv = $this;
                boolean $i$f$firstOrNull = false;
                for (Object element$iv : $this$firstOrNull$iv) {
                    AnnotationDescriptor it = (AnnotationDescriptor)element$iv;
                    boolean bl2 = false;
                    if (!Intrinsics.areEqual(it.getFqName(), fqName)) continue;
                    v0 = element$iv;
                    break block1;
                }
                v0 = null;
            }
            return v0;
        }

        public static boolean hasAnnotation(@NotNull Annotations $this, @NotNull FqName fqName) {
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            return $this.findAnnotation(fqName) != null;
        }
    }
}

