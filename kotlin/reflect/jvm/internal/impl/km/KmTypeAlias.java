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
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.km.KmAnnotation;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmTypeParameter;
import kotlin.reflect.jvm.internal.impl.km.KmVersionRequirement;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeAliasExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nNodes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmTypeAlias\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,830:1\n1617#2,9:831\n1869#2:840\n1870#2:842\n1626#2:843\n1#3:841\n*S KotlinDebug\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmTypeAlias\n*L\n435#1:831,9\n435#1:840\n435#1:842\n435#1:843\n435#1:841\n*E\n"})
public final class KmTypeAlias {
    private int flags;
    @NotNull
    private String name;
    @NotNull
    private final List<KmTypeParameter> typeParameters;
    public KmType underlyingType;
    public KmType expandedType;
    @NotNull
    private final List<KmAnnotation> annotations;
    @NotNull
    private final List<KmVersionRequirement> versionRequirements;
    @NotNull
    private final List<KmTypeAliasExtension> extensions;

    /*
     * WARNING - void declaration
     */
    public KmTypeAlias(int flags, @NotNull String name) {
        void $this$mapNotNullTo$iv$iv;
        void $this$mapNotNull$iv;
        Intrinsics.checkNotNullParameter(name, "name");
        this.flags = flags;
        this.name = name;
        this.typeParameters = new ArrayList(0);
        this.annotations = new ArrayList(0);
        this.versionRequirements = new ArrayList(0);
        Iterable iterable = MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
        KmTypeAlias kmTypeAlias = this;
        boolean $i$f$mapNotNull = false;
        void var5_6 = $this$mapNotNull$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
        while (iterator2.hasNext()) {
            KmTypeAliasExtension it$iv$iv;
            Object element$iv$iv$iv;
            Object element$iv$iv = element$iv$iv$iv = iterator2.next();
            boolean bl2 = false;
            MetadataExtensions p0 = (MetadataExtensions)element$iv$iv;
            boolean bl3 = false;
            if (p0.createTypeAliasExtension() == null) continue;
            boolean bl4 = false;
            destination$iv$iv.add(it$iv$iv);
        }
        kmTypeAlias.extensions = (List)destination$iv$iv;
    }

    public final int getFlags$kotlin_metadata() {
        return this.flags;
    }

    public final void setFlags$kotlin_metadata(int n2) {
        this.flags = n2;
    }

    @NotNull
    public final List<KmTypeParameter> getTypeParameters() {
        return this.typeParameters;
    }

    public final void setUnderlyingType(@NotNull KmType kmType) {
        Intrinsics.checkNotNullParameter(kmType, "<set-?>");
        this.underlyingType = kmType;
    }

    public final void setExpandedType(@NotNull KmType kmType) {
        Intrinsics.checkNotNullParameter(kmType, "<set-?>");
        this.expandedType = kmType;
    }

    @NotNull
    public final List<KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    @NotNull
    public final List<KmVersionRequirement> getVersionRequirements() {
        return this.versionRequirements;
    }
}

