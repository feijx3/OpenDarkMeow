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
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.km.KmAnnotation;
import kotlin.reflect.jvm.internal.impl.km.KmPropertyAccessorAttributes;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmTypeParameter;
import kotlin.reflect.jvm.internal.impl.km.KmValueParameter;
import kotlin.reflect.jvm.internal.impl.km.KmVersionRequirement;
import kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate;
import kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt;
import kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPropertyExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nNodes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmProperty\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,830:1\n1#2:831\n1563#3:832\n1634#3,3:833\n*S KotlinDebug\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmProperty\n*L\n390#1:832\n390#1:833,3\n*E\n"})
public final class KmProperty {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private int flags;
    @NotNull
    private String name;
    @NotNull
    private final BooleanFlagDelegate _hasSetter$delegate;
    @NotNull
    private final BooleanFlagDelegate _hasGetter$delegate;
    @NotNull
    private final KmPropertyAccessorAttributes getter;
    @Nullable
    private KmPropertyAccessorAttributes setter;
    @NotNull
    private final List<KmTypeParameter> typeParameters;
    @Nullable
    private KmType receiverParameterType;
    @NotNull
    private final List<KmAnnotation> extensionReceiverParameterAnnotations;
    @NotNull
    private final List<KmType> contextReceiverTypes;
    @Nullable
    private KmValueParameter setterParameter;
    public KmType returnType;
    @NotNull
    private final List<KmVersionRequirement> versionRequirements;
    @NotNull
    private final List<KmAnnotation> annotations;
    @NotNull
    private final List<KmAnnotation> backingFieldAnnotations;
    @NotNull
    private final List<KmAnnotation> delegateFieldAnnotations;
    @NotNull
    private final List<KmPropertyExtension> extensions;

    /*
     * WARNING - void declaration
     */
    public KmProperty(int flags, @NotNull String name, int getterFlags, int setterFlags) {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Intrinsics.checkNotNullParameter(name, "name");
        this.flags = flags;
        this.name = name;
        Flags.BooleanFlagField booleanFlagField = Flags.HAS_SETTER;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField, "HAS_SETTER");
        this._hasSetter$delegate = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(booleanFlagField));
        Flags.BooleanFlagField booleanFlagField2 = Flags.HAS_GETTER;
        Intrinsics.checkNotNullExpressionValue(booleanFlagField2, "HAS_GETTER");
        this._hasGetter$delegate = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(booleanFlagField2));
        Object object = new KmPropertyAccessorAttributes(getterFlags);
        KmPropertyAccessorAttributes kmPropertyAccessorAttributes = object;
        KmProperty kmProperty = this;
        boolean $i$a$-also-KmProperty$getter$22 = false;
        this.set_hasGetter(true);
        kmProperty.getter = object;
        this.setter = this.get_hasSetter() ? new KmPropertyAccessorAttributes(setterFlags) : null;
        this.typeParameters = new ArrayList(0);
        this.extensionReceiverParameterAnnotations = new ArrayList(0);
        this.contextReceiverTypes = new ArrayList(0);
        this.versionRequirements = new ArrayList(0);
        this.annotations = new ArrayList(0);
        this.backingFieldAnnotations = new ArrayList(0);
        this.delegateFieldAnnotations = new ArrayList(0);
        object = MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
        kmProperty = this;
        boolean $i$f$map = false;
        void $i$a$-also-KmProperty$getter$22 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void p0;
            MetadataExtensions metadataExtensions = (MetadataExtensions)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(p0.createPropertyExtension());
        }
        kmProperty.extensions = (List)destination$iv$iv;
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

    private final boolean get_hasSetter() {
        return this._hasSetter$delegate.getValue(this, $$delegatedProperties[0]);
    }

    private final void set_hasGetter(boolean bl2) {
        this._hasGetter$delegate.setValue(this, $$delegatedProperties[1], bl2);
    }

    @NotNull
    public final KmPropertyAccessorAttributes getGetter() {
        return this.getter;
    }

    @Nullable
    public final KmPropertyAccessorAttributes getSetter() {
        return this.setter;
    }

    @NotNull
    public final List<KmTypeParameter> getTypeParameters() {
        return this.typeParameters;
    }

    @Nullable
    public final KmType getReceiverParameterType() {
        return this.receiverParameterType;
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

    @Nullable
    public final KmValueParameter getSetterParameter() {
        return this.setterParameter;
    }

    public final void setSetterParameter(@Nullable KmValueParameter kmValueParameter) {
        this.setterParameter = kmValueParameter;
    }

    @NotNull
    public final KmType getReturnType() {
        KmType kmType = this.returnType;
        if (kmType != null) {
            return kmType;
        }
        Intrinsics.throwUninitializedPropertyAccessException("returnType");
        return null;
    }

    public final void setReturnType(@NotNull KmType kmType) {
        Intrinsics.checkNotNullParameter(kmType, "<set-?>");
        this.returnType = kmType;
    }

    @NotNull
    public final List<KmVersionRequirement> getVersionRequirements() {
        return this.versionRequirements;
    }

    @NotNull
    public final List<KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    @NotNull
    public final List<KmAnnotation> getBackingFieldAnnotations() {
        return this.backingFieldAnnotations;
    }

    @NotNull
    public final List<KmAnnotation> getDelegateFieldAnnotations() {
        return this.delegateFieldAnnotations;
    }

    @NotNull
    public final List<KmPropertyExtension> getExtensions$kotlin_metadata() {
        return this.extensions;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(KmProperty.class, "_hasSetter", "get_hasSetter()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(KmProperty.class, "_hasGetter", "get_hasGetter()Z", 0))};
        $$delegatedProperties = kPropertyArray;
    }
}

