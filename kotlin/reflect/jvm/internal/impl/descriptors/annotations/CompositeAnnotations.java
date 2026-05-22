/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nAnnotations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Annotations.kt\norg/jetbrains/kotlin/descriptors/annotations/CompositeAnnotations\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,123:1\n1740#2,3:124\n1374#2:129\n1460#2,5:130\n1255#3,2:127\n*S KotlinDebug\n*F\n+ 1 Annotations.kt\norg/jetbrains/kotlin/descriptors/annotations/CompositeAnnotations\n*L\n105#1:124,3\n112#1:129\n112#1:130,5\n107#1:127,2\n*E\n"})
public final class CompositeAnnotations
implements Annotations {
    @NotNull
    private final List<Annotations> delegates;

    public CompositeAnnotations(@NotNull List<? extends Annotations> delegates) {
        Intrinsics.checkNotNullParameter(delegates, "delegates");
        this.delegates = delegates;
    }

    public CompositeAnnotations(Annotations ... delegates) {
        Intrinsics.checkNotNullParameter(delegates, "delegates");
        this(ArraysKt.toList(delegates));
    }

    @Override
    public boolean isEmpty() {
        boolean bl2;
        block3: {
            Iterable $this$all$iv = this.delegates;
            boolean $i$f$all = false;
            if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                bl2 = true;
            } else {
                for (Object element$iv : $this$all$iv) {
                    Annotations it = (Annotations)element$iv;
                    boolean bl3 = false;
                    if (it.isEmpty()) continue;
                    bl2 = false;
                    break block3;
                }
                bl2 = true;
            }
        }
        return bl2;
    }

    @Override
    public boolean hasAnnotation(@NotNull FqName fqName) {
        boolean bl2;
        block1: {
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            Sequence $this$any$iv = CollectionsKt.asSequence((Iterable)this.delegates);
            boolean $i$f$any = false;
            Iterator iterator2 = $this$any$iv.iterator();
            while (iterator2.hasNext()) {
                Object element$iv = iterator2.next();
                Annotations it = (Annotations)element$iv;
                boolean bl3 = false;
                if (!it.hasAnnotation(fqName)) continue;
                bl2 = true;
                break block1;
            }
            bl2 = false;
        }
        return bl2;
    }

    @Override
    @Nullable
    public AnnotationDescriptor findAnnotation(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        FqName fqName2 = fqName;
        return (AnnotationDescriptor)SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence((Iterable)this.delegates), new CompositeAnnotations$$Lambda$0(fqName2)));
    }

    @Override
    @NotNull
    public Iterator<AnnotationDescriptor> iterator() {
        return SequencesKt.flatMap(CollectionsKt.asSequence((Iterable)this.delegates), CompositeAnnotations$$Lambda$1.INSTANCE).iterator();
    }

    private static final AnnotationDescriptor findAnnotation$lambda$2(FqName $fqName, Annotations it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.findAnnotation($fqName);
    }

    private static final Sequence iterator$lambda$4(Annotations it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return CollectionsKt.asSequence(it);
    }

    static /* synthetic */ AnnotationDescriptor accessor$CompositeAnnotations$lambda0(FqName fqName, Annotations annotations) {
        return CompositeAnnotations.findAnnotation$lambda$2(fqName, annotations);
    }

    static /* synthetic */ Sequence accessor$CompositeAnnotations$lambda1(Annotations annotations) {
        return CompositeAnnotations.iterator$lambda$4(annotations);
    }
}

