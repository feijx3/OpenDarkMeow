/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.km.internal;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.internal.ReadUtilsKt;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReadContext {
    @NotNull
    private final NameResolver strings;
    @NotNull
    private final TypeTable types;
    @NotNull
    private final VersionRequirementTable versionRequirements;
    private final boolean ignoreUnknownVersionRequirements;
    @Nullable
    private final ReadContext parent;
    @NotNull
    private final List<Object> contextExtensions;
    @NotNull
    private final Map<Integer, Integer> typeParameterNameToId;
    @NotNull
    private final List<MetadataExtensions> extensions;

    public ReadContext(@NotNull NameResolver strings, @NotNull TypeTable types, @NotNull VersionRequirementTable versionRequirements, boolean ignoreUnknownVersionRequirements, @Nullable ReadContext parent, @NotNull List<? extends Object> contextExtensions) {
        Intrinsics.checkNotNullParameter(strings, "strings");
        Intrinsics.checkNotNullParameter(types, "types");
        Intrinsics.checkNotNullParameter(versionRequirements, "versionRequirements");
        Intrinsics.checkNotNullParameter(contextExtensions, "contextExtensions");
        this.strings = strings;
        this.types = types;
        this.versionRequirements = versionRequirements;
        this.ignoreUnknownVersionRequirements = ignoreUnknownVersionRequirements;
        this.parent = parent;
        this.contextExtensions = contextExtensions;
        this.typeParameterNameToId = new LinkedHashMap();
        this.extensions = MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
    }

    public /* synthetic */ ReadContext(NameResolver nameResolver, TypeTable typeTable, VersionRequirementTable versionRequirementTable, boolean bl2, ReadContext readContext, List list, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 0x10) != 0) {
            readContext = null;
        }
        if ((n2 & 0x20) != 0) {
            list = CollectionsKt.emptyList();
        }
        this(nameResolver, typeTable, versionRequirementTable, bl2, readContext, list);
    }

    @NotNull
    public final NameResolver getStrings() {
        return this.strings;
    }

    @NotNull
    public final TypeTable getTypes() {
        return this.types;
    }

    @NotNull
    public final VersionRequirementTable getVersionRequirements$kotlin_metadata() {
        return this.versionRequirements;
    }

    public final boolean getIgnoreUnknownVersionRequirements$kotlin_metadata() {
        return this.ignoreUnknownVersionRequirements;
    }

    @NotNull
    public final List<MetadataExtensions> getExtensions$kotlin_metadata() {
        return this.extensions;
    }

    @NotNull
    public final String get(int index) {
        return this.strings.getString(index);
    }

    @NotNull
    public final String className$kotlin_metadata(int index) {
        return ReadUtilsKt.getClassName(this.strings, index);
    }

    @Nullable
    public final Integer getTypeParameterId$kotlin_metadata(int name) {
        Integer n2 = this.typeParameterNameToId.get(name);
        if (n2 == null) {
            ReadContext readContext = this.parent;
            n2 = readContext != null ? readContext.getTypeParameterId$kotlin_metadata(name) : null;
        }
        return n2;
    }

    @NotNull
    public final ReadContext withTypeParameters$kotlin_metadata(@NotNull List<ProtoBuf.TypeParameter> typeParameters) {
        ReadContext readContext;
        Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
        ReadContext $this$withTypeParameters_u24lambda_u240 = readContext = new ReadContext(this.strings, this.types, this.versionRequirements, this.ignoreUnknownVersionRequirements, this, this.contextExtensions);
        boolean bl2 = false;
        for (ProtoBuf.TypeParameter typeParameter : typeParameters) {
            $this$withTypeParameters_u24lambda_u240.typeParameterNameToId.put(typeParameter.getName(), typeParameter.getId());
        }
        return readContext;
    }
}

