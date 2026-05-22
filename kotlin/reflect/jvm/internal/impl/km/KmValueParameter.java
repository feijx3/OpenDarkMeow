/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.km.KmAnnotation;
import kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmValueParameterExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nNodes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmValueParameter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,830:1\n1617#2,9:831\n1869#2:840\n1870#2:842\n1626#2:843\n1#3:841\n*S KotlinDebug\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmValueParameter\n*L\n476#1:831,9\n476#1:840\n476#1:842\n476#1:843\n476#1:841\n*E\n"})
public final class KmValueParameter {
    private int flags;
    @NotNull
    private String name;
    public KmType type;
    @Nullable
    private KmType varargElementType;
    @Nullable
    private KmAnnotationArgument annotationParameterDefaultValue;
    @NotNull
    private final List<KmAnnotation> annotations;
    @NotNull
    private final List<KmValueParameterExtension> extensions;

    /*
     * WARNING - void declaration
     */
    public KmValueParameter(int flags, @NotNull String name) {
        void $this$mapNotNullTo$iv$iv;
        void $this$mapNotNull$iv;
        Intrinsics.checkNotNullParameter(name, "name");
        this.flags = flags;
        this.name = name;
        this.annotations = new ArrayList(0);
        Iterable iterable = MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
        KmValueParameter kmValueParameter = this;
        boolean $i$f$mapNotNull = false;
        void var5_6 = $this$mapNotNull$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
        while (iterator2.hasNext()) {
            KmValueParameterExtension it$iv$iv;
            Object element$iv$iv$iv;
            Object element$iv$iv = element$iv$iv$iv = iterator2.next();
            boolean bl2 = false;
            MetadataExtensions p0 = (MetadataExtensions)element$iv$iv;
            boolean bl3 = false;
            if (p0.createValueParameterExtension() == null) continue;
            boolean bl4 = false;
            destination$iv$iv.add(it$iv$iv);
        }
        kmValueParameter.extensions = (List)destination$iv$iv;
    }

    public final int getFlags$kotlin_metadata() {
        return this.flags;
    }

    public final void setFlags$kotlin_metadata(int n2) {
        this.flags = n2;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final KmType getType() {
        KmType kmType = this.type;
        if (kmType != null) {
            return kmType;
        }
        Intrinsics.throwUninitializedPropertyAccessException("type");
        return null;
    }

    public final void setType(@NotNull KmType kmType) {
        Intrinsics.checkNotNullParameter(kmType, "<set-?>");
        this.type = kmType;
    }

    @Nullable
    public final KmType getVarargElementType() {
        return this.varargElementType;
    }

    public final void setVarargElementType(@Nullable KmType kmType) {
        this.varargElementType = kmType;
    }

    @Nullable
    public final KmAnnotationArgument getAnnotationParameterDefaultValue() {
        return this.annotationParameterDefaultValue;
    }

    public final void setAnnotationParameterDefaultValue(@Nullable KmAnnotationArgument kmAnnotationArgument) {
        this.annotationParameterDefaultValue = kmAnnotationArgument;
    }

    @NotNull
    public final List<KmAnnotation> getAnnotations() {
        return this.annotations;
    }
}

