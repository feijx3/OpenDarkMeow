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
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.km.KmClassifier;
import kotlin.reflect.jvm.internal.impl.km.KmFlexibleTypeUpperBound;
import kotlin.reflect.jvm.internal.impl.km.KmTypeProjection;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nNodes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmType\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,830:1\n1563#2:831\n1634#2,3:832\n*S KotlinDebug\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmType\n*L\n579#1:831\n579#1:832,3\n*E\n"})
public final class KmType {
    private int flags;
    public KmClassifier classifier;
    @NotNull
    private final List<KmTypeProjection> arguments;
    @Nullable
    private KmType abbreviatedType;
    @Nullable
    private KmType outerType;
    @Nullable
    private KmFlexibleTypeUpperBound flexibleTypeUpperBound;
    @NotNull
    private final List<KmTypeExtension> extensions;

    /*
     * WARNING - void declaration
     */
    public KmType(int flags) {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        this.flags = flags;
        this.arguments = new ArrayList(0);
        Iterable iterable = MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
        KmType kmType = this;
        boolean $i$f$map = false;
        void var4_5 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void p0;
            MetadataExtensions metadataExtensions = (MetadataExtensions)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(p0.createTypeExtension());
        }
        kmType.extensions = (List)destination$iv$iv;
    }

    public final int getFlags$kotlin_metadata() {
        return this.flags;
    }

    public final void setFlags$kotlin_metadata(int n2) {
        this.flags = n2;
    }

    public KmType() {
        this(0);
    }

    @NotNull
    public final KmClassifier getClassifier() {
        KmClassifier kmClassifier = this.classifier;
        if (kmClassifier != null) {
            return kmClassifier;
        }
        Intrinsics.throwUninitializedPropertyAccessException("classifier");
        return null;
    }

    public final void setClassifier(@NotNull KmClassifier kmClassifier) {
        Intrinsics.checkNotNullParameter(kmClassifier, "<set-?>");
        this.classifier = kmClassifier;
    }

    @NotNull
    public final List<KmTypeProjection> getArguments() {
        return this.arguments;
    }

    @Nullable
    public final KmType getAbbreviatedType() {
        return this.abbreviatedType;
    }

    public final void setAbbreviatedType(@Nullable KmType kmType) {
        this.abbreviatedType = kmType;
    }

    @Nullable
    public final KmType getOuterType() {
        return this.outerType;
    }

    public final void setOuterType(@Nullable KmType kmType) {
        this.outerType = kmType;
    }

    @Nullable
    public final KmFlexibleTypeUpperBound getFlexibleTypeUpperBound() {
        return this.flexibleTypeUpperBound;
    }

    public final void setFlexibleTypeUpperBound(@Nullable KmFlexibleTypeUpperBound kmFlexibleTypeUpperBound) {
        this.flexibleTypeUpperBound = kmFlexibleTypeUpperBound;
    }

    @NotNull
    public final List<KmTypeExtension> getExtensions$kotlin_metadata() {
        return this.extensions;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        Object object = other;
        if (!Intrinsics.areEqual(this.getClass(), object != null ? object.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type kotlin.metadata.KmType");
        KmType cfr_ignored_0 = (KmType)other;
        if (this.flags != ((KmType)other).flags) {
            return false;
        }
        if (!Intrinsics.areEqual(this.getClassifier(), ((KmType)other).getClassifier())) {
            return false;
        }
        if (!Intrinsics.areEqual(this.arguments, ((KmType)other).arguments)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.outerType, ((KmType)other).outerType)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.abbreviatedType, ((KmType)other).abbreviatedType)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.flexibleTypeUpperBound, ((KmType)other).flexibleTypeUpperBound)) {
            return false;
        }
        return Intrinsics.areEqual(this.extensions, ((KmType)other).extensions);
    }

    public int hashCode() {
        int result = this.flags;
        result = 31 * result + this.getClassifier().hashCode();
        result = 31 * result + ((Object)this.arguments).hashCode();
        return result;
    }
}

