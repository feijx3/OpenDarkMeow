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
import kotlin.reflect.jvm.internal.impl.km.KmAnnotation;
import kotlin.reflect.jvm.internal.impl.km.KmContract;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmTypeParameter;
import kotlin.reflect.jvm.internal.impl.km.KmValueParameter;
import kotlin.reflect.jvm.internal.impl.km.KmVersionRequirement;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmFunctionExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nNodes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmFunction\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,830:1\n1563#2:831\n1634#2,3:832\n*S KotlinDebug\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmFunction\n*L\n263#1:831\n263#1:832,3\n*E\n"})
public final class KmFunction {
    private int flags;
    @NotNull
    private String name;
    @NotNull
    private final List<KmTypeParameter> typeParameters;
    @Nullable
    private KmType receiverParameterType;
    @NotNull
    private final List<KmAnnotation> extensionReceiverParameterAnnotations;
    @NotNull
    private final List<KmType> contextReceiverTypes;
    @NotNull
    private final List<KmValueParameter> valueParameters;
    public KmType returnType;
    @NotNull
    private final List<KmVersionRequirement> versionRequirements;
    @Nullable
    private KmContract contract;
    @NotNull
    private final List<KmAnnotation> annotations;
    @NotNull
    private final List<KmFunctionExtension> extensions;

    /*
     * WARNING - void declaration
     */
    public KmFunction(int flags, @NotNull String name) {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Intrinsics.checkNotNullParameter(name, "name");
        this.flags = flags;
        this.name = name;
        this.typeParameters = new ArrayList(0);
        this.extensionReceiverParameterAnnotations = new ArrayList(0);
        this.contextReceiverTypes = new ArrayList(0);
        this.valueParameters = new ArrayList();
        this.versionRequirements = new ArrayList(0);
        this.annotations = new ArrayList(0);
        Iterable iterable = MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
        KmFunction kmFunction = this;
        boolean $i$f$map = false;
        void var5_6 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void p0;
            MetadataExtensions metadataExtensions = (MetadataExtensions)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(p0.createFunctionExtension());
        }
        kmFunction.extensions = (List)destination$iv$iv;
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

    public final void setReceiverParameterType(@Nullable KmType kmType) {
        this.receiverParameterType = kmType;
    }

    @NotNull
    public final List<KmAnnotation> getExtensionReceiverParameterAnnotations() {
        return this.extensionReceiverParameterAnnotations;
    }

    @NotNull
    public final List<KmType> getContextReceiverTypes() {
        return this.contextReceiverTypes;
    }

    @NotNull
    public final List<KmValueParameter> getValueParameters() {
        return this.valueParameters;
    }

    public final void setReturnType(@NotNull KmType kmType) {
        Intrinsics.checkNotNullParameter(kmType, "<set-?>");
        this.returnType = kmType;
    }

    @NotNull
    public final List<KmVersionRequirement> getVersionRequirements() {
        return this.versionRequirements;
    }

    public final void setContract(@Nullable KmContract kmContract) {
        this.contract = kmContract;
    }

    @NotNull
    public final List<KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    @NotNull
    public final List<KmFunctionExtension> getExtensions$kotlin_metadata() {
        return this.extensions;
    }
}

