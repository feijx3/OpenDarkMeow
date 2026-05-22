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
import kotlin.reflect.jvm.internal.impl.km.KmConstructor;
import kotlin.reflect.jvm.internal.impl.km.KmDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.km.KmEnumEntry;
import kotlin.reflect.jvm.internal.impl.km.KmFunction;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmTypeAlias;
import kotlin.reflect.jvm.internal.impl.km.KmTypeParameter;
import kotlin.reflect.jvm.internal.impl.km.KmVersionRequirement;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmClassExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nNodes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmClass\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,830:1\n1563#2:831\n1634#2,3:832\n*S KotlinDebug\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmClass\n*L\n135#1:831\n135#1:832,3\n*E\n"})
public final class KmClass
implements KmDeclarationContainer {
    private int flags;
    public String name;
    @NotNull
    private final List<KmTypeParameter> typeParameters = new ArrayList(0);
    @NotNull
    private final List<KmType> supertypes = new ArrayList(1);
    @NotNull
    private final List<KmFunction> functions = new ArrayList();
    @NotNull
    private final List<KmProperty> properties = new ArrayList();
    @NotNull
    private final List<KmTypeAlias> typeAliases = new ArrayList(0);
    @NotNull
    private final List<KmConstructor> constructors = new ArrayList(1);
    @Nullable
    private String companionObject;
    @NotNull
    private final List<String> nestedClasses = new ArrayList(0);
    @NotNull
    private final List<String> enumEntries = new ArrayList(0);
    @NotNull
    private final List<KmEnumEntry> kmEnumEntries = new ArrayList(0);
    @NotNull
    private final List<String> sealedSubclasses = new ArrayList(0);
    @Nullable
    private String inlineClassUnderlyingPropertyName;
    @Nullable
    private KmType inlineClassUnderlyingType;
    @NotNull
    private final List<KmAnnotation> annotations = new ArrayList(0);
    @NotNull
    private final List<KmType> contextReceiverTypes = new ArrayList(0);
    @NotNull
    private final List<KmVersionRequirement> versionRequirements = new ArrayList(0);
    @NotNull
    private final List<KmClassExtension> extensions;

    /*
     * WARNING - void declaration
     */
    public KmClass() {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Iterable iterable = MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
        KmClass kmClass = this;
        boolean $i$f$map = false;
        void var3_4 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void p0;
            MetadataExtensions metadataExtensions = (MetadataExtensions)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(p0.createClassExtension());
        }
        kmClass.extensions = (List)destination$iv$iv;
    }

    public final int getFlags$kotlin_metadata() {
        return this.flags;
    }

    public final void setFlags$kotlin_metadata(int n2) {
        this.flags = n2;
    }

    @NotNull
    public final String getName() {
        String string = this.name;
        if (string != null) {
            return string;
        }
        Intrinsics.throwUninitializedPropertyAccessException("name");
        return null;
    }

    public final void setName(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<set-?>");
        this.name = string;
    }

    @NotNull
    public final List<KmTypeParameter> getTypeParameters() {
        return this.typeParameters;
    }

    @NotNull
    public final List<KmType> getSupertypes() {
        return this.supertypes;
    }

    @Override
    @NotNull
    public List<KmFunction> getFunctions() {
        return this.functions;
    }

    @Override
    @NotNull
    public List<KmProperty> getProperties() {
        return this.properties;
    }

    @Override
    @NotNull
    public List<KmTypeAlias> getTypeAliases() {
        return this.typeAliases;
    }

    @NotNull
    public final List<KmConstructor> getConstructors() {
        return this.constructors;
    }

    public final void setCompanionObject(@Nullable String string) {
        this.companionObject = string;
    }

    @NotNull
    public final List<String> getNestedClasses() {
        return this.nestedClasses;
    }

    @NotNull
    public final List<String> getEnumEntries() {
        return this.enumEntries;
    }

    @NotNull
    public final List<KmEnumEntry> getKmEnumEntries() {
        return this.kmEnumEntries;
    }

    @NotNull
    public final List<String> getSealedSubclasses() {
        return this.sealedSubclasses;
    }

    public final void setInlineClassUnderlyingPropertyName(@Nullable String string) {
        this.inlineClassUnderlyingPropertyName = string;
    }

    public final void setInlineClassUnderlyingType(@Nullable KmType kmType) {
        this.inlineClassUnderlyingType = kmType;
    }

    @NotNull
    public final List<KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    @NotNull
    public final List<KmType> getContextReceiverTypes() {
        return this.contextReceiverTypes;
    }

    @NotNull
    public final List<KmVersionRequirement> getVersionRequirements() {
        return this.versionRequirements;
    }

    @NotNull
    public final List<KmClassExtension> getExtensions$kotlin_metadata() {
        return this.extensions;
    }
}

