/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nAnnotations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Annotations.kt\norg/jetbrains/kotlin/descriptors/annotations/FilteredAnnotations\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,123:1\n774#2:124\n865#2,2:125\n1761#2,3:127\n*S KotlinDebug\n*F\n+ 1 Annotations.kt\norg/jetbrains/kotlin/descriptors/annotations/FilteredAnnotations\n*L\n69#1:124\n69#1:125,2\n72#1:127,3\n*E\n"})
public final class FilteredAnnotations
implements Annotations {
    @NotNull
    private final Annotations delegate;
    private final boolean isDefinitelyNewInference;
    @NotNull
    private final Function1<FqName, Boolean> fqNameFilter;

    public FilteredAnnotations(@NotNull Annotations delegate, boolean isDefinitelyNewInference, @NotNull Function1<? super FqName, Boolean> fqNameFilter) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(fqNameFilter, "fqNameFilter");
        this.delegate = delegate;
        this.isDefinitelyNewInference = isDefinitelyNewInference;
        this.fqNameFilter = fqNameFilter;
    }

    public FilteredAnnotations(@NotNull Annotations delegate, @NotNull Function1<? super FqName, Boolean> fqNameFilter) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(fqNameFilter, "fqNameFilter");
        this(delegate, false, fqNameFilter);
    }

    @Override
    public boolean hasAnnotation(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return this.fqNameFilter.invoke(fqName) != false ? this.delegate.hasAnnotation(fqName) : false;
    }

    @Override
    @Nullable
    public AnnotationDescriptor findAnnotation(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return this.fqNameFilter.invoke(fqName) != false ? this.delegate.findAnnotation(fqName) : null;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Iterator<AnnotationDescriptor> iterator() {
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv = this.delegate;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            AnnotationDescriptor p0 = (AnnotationDescriptor)element$iv$iv;
            boolean bl2 = false;
            if (!this.shouldBeReturned(p0)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return ((List)destination$iv$iv).iterator();
    }

    @Override
    public boolean isEmpty() {
        boolean condition;
        block3: {
            boolean bl2;
            Iterable $this$any$iv = this.delegate;
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl2 = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    AnnotationDescriptor p0 = (AnnotationDescriptor)element$iv;
                    boolean bl3 = false;
                    if (!this.shouldBeReturned(p0)) continue;
                    bl2 = true;
                    break block3;
                }
                bl2 = condition = false;
            }
        }
        return this.isDefinitelyNewInference ? !condition : condition;
    }

    private final boolean shouldBeReturned(AnnotationDescriptor annotation) {
        FqName fqName = annotation.getFqName();
        boolean bl2 = false;
        return fqName != null && this.fqNameFilter.invoke(fqName).booleanValue();
    }
}

