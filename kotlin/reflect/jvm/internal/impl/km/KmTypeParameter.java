/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmVariance;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeParameterExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nNodes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmTypeParameter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,830:1\n1563#2:831\n1634#2,3:832\n*S KotlinDebug\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmTypeParameter\n*L\n505#1:831\n505#1:832,3\n*E\n"})
public final class KmTypeParameter {
    private int flags;
    @NotNull
    private String name;
    private int id;
    @NotNull
    private KmVariance variance;
    @NotNull
    private final List<KmType> upperBounds;
    @NotNull
    private final List<KmTypeParameterExtension> extensions;

    /*
     * WARNING - void declaration
     */
    public KmTypeParameter(int flags, @NotNull String name, int id, @NotNull KmVariance variance) {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter((Object)variance, "variance");
        this.flags = flags;
        this.name = name;
        this.id = id;
        this.variance = variance;
        this.upperBounds = new ArrayList(1);
        Iterable iterable = MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
        KmTypeParameter kmTypeParameter = this;
        boolean $i$f$map = false;
        void var7_8 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void p0;
            MetadataExtensions metadataExtensions = (MetadataExtensions)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(p0.createTypeParameterExtension());
        }
        kmTypeParameter.extensions = (List)destination$iv$iv;
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

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final KmVariance getVariance() {
        return this.variance;
    }

    @NotNull
    public final List<KmType> getUpperBounds() {
        return this.upperBounds;
    }

    @NotNull
    public final List<KmTypeParameterExtension> getExtensions$kotlin_metadata() {
        return this.extensions;
    }
}

