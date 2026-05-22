/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.km.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.km.Attributes;
import kotlin.reflect.jvm.internal.impl.km.InconsistentKotlinMetadataException;
import kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.km.KmClassifier;
import kotlin.reflect.jvm.internal.impl.km.KmEffectInvocationKind;
import kotlin.reflect.jvm.internal.impl.km.KmEffectType;
import kotlin.reflect.jvm.internal.impl.km.KmFlexibleTypeUpperBound;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.KmPropertyAccessorAttributes;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmTypeParameter;
import kotlin.reflect.jvm.internal.impl.km.KmTypeProjection;
import kotlin.reflect.jvm.internal.impl.km.KmValueParameter;
import kotlin.reflect.jvm.internal.impl.km.KmVariance;
import kotlin.reflect.jvm.internal.impl.km.KmVersion;
import kotlin.reflect.jvm.internal.impl.km.KmVersionRequirement;
import kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementLevel;
import kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind;
import kotlin.reflect.jvm.internal.impl.km.internal.WriteContext;
import kotlin.reflect.jvm.internal.impl.km.internal.WriteUtilsKt;
import kotlin.reflect.jvm.internal.impl.km.internal.WritersKt$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.km.internal.WritersKt$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.serialization.MutableVersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nWriters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Writers.kt\nkotlin/metadata/internal/WritersKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,427:1\n1869#2,2:428\n1869#2,2:430\n1869#2,2:432\n1869#2,2:435\n1869#2,2:437\n1617#2,9:439\n1869#2:448\n1870#2:450\n1626#2:451\n1869#2,2:452\n1563#2:454\n1634#2,3:455\n1563#2:458\n1634#2,3:459\n1563#2:462\n1634#2,3:463\n1617#2,9:466\n1869#2:475\n1870#2:477\n1626#2:478\n1869#2,2:479\n1869#2,2:481\n1563#2:483\n1634#2,3:484\n1617#2,9:487\n1869#2:496\n1870#2:498\n1626#2:499\n1869#2,2:500\n1869#2,2:502\n1563#2:504\n1634#2,3:505\n1563#2:508\n1634#2,3:509\n1617#2,9:512\n1869#2:521\n1870#2:523\n1626#2:524\n1869#2,2:525\n1869#2,2:527\n1563#2:529\n1634#2,3:530\n1563#2:533\n1634#2,3:534\n1563#2:537\n1634#2,3:538\n1563#2:541\n1634#2,3:542\n1#3:434\n1#3:449\n1#3:476\n1#3:497\n1#3:522\n*S KotlinDebug\n*F\n+ 1 Writers.kt\nkotlin/metadata/internal/WritersKt\n*L\n39#1:428,2\n42#1:430,2\n85#1:432,2\n97#1:435,2\n112#1:437,2\n115#1:439,9\n115#1:448\n115#1:450\n115#1:451\n116#1:452,2\n129#1:454\n129#1:455,3\n133#1:458\n133#1:459,3\n134#1:462\n134#1:463,3\n136#1:466,9\n136#1:475\n136#1:477\n136#1:478\n141#1:479,2\n156#1:481,2\n162#1:483\n162#1:484,3\n165#1:487,9\n165#1:496\n165#1:498\n165#1:499\n167#1:500,2\n196#1:502,2\n210#1:504\n210#1:505,3\n213#1:508\n213#1:509,3\n214#1:512,9\n214#1:521\n214#1:523\n214#1:524\n215#1:525,2\n271#1:527,2\n280#1:529\n280#1:530,3\n290#1:533\n290#1:534,3\n325#1:537\n325#1:538,3\n326#1:541\n326#1:542,3\n115#1:449\n136#1:476\n165#1:497\n214#1:522\n*E\n"})
public final class WritersKt {
    private static final ProtoBuf.TypeParameter.Builder writeTypeParameter(WriteContext $this$writeTypeParameter, KmTypeParameter kmTypeParameter) {
        ProtoBuf.TypeParameter.Builder t2 = ProtoBuf.TypeParameter.newBuilder();
        Iterable $this$forEach$iv = kmTypeParameter.getUpperBounds();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            KmType ub2 = (KmType)element$iv;
            boolean bl2 = false;
            t2.addUpperBound(WritersKt.writeType($this$writeTypeParameter, ub2).build());
        }
        $this$forEach$iv = $this$writeTypeParameter.getExtensions$kotlin_metadata();
        $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            MetadataExtensions it = (MetadataExtensions)element$iv;
            boolean bl3 = false;
            Intrinsics.checkNotNull(t2);
            it.writeTypeParameterExtensions(kmTypeParameter, t2, $this$writeTypeParameter);
        }
        t2.setName($this$writeTypeParameter.get(kmTypeParameter.getName()));
        t2.setId(kmTypeParameter.getId());
        boolean reified = Attributes.isReified(kmTypeParameter);
        if (reified != ProtoBuf.TypeParameter.getDefaultInstance().getReified()) {
            t2.setReified(reified);
        }
        if (kmTypeParameter.getVariance() == KmVariance.IN) {
            t2.setVariance(ProtoBuf.TypeParameter.Variance.IN);
        } else if (kmTypeParameter.getVariance() == KmVariance.OUT) {
            t2.setVariance(ProtoBuf.TypeParameter.Variance.OUT);
        }
        Intrinsics.checkNotNull(t2);
        return t2;
    }

    private static final ProtoBuf.Type.Argument.Builder writeTypeProjection(WriteContext $this$writeTypeProjection, KmTypeProjection argument) {
        ProtoBuf.Type.Argument.Builder t2 = ProtoBuf.Type.Argument.newBuilder();
        if (Intrinsics.areEqual(argument, KmTypeProjection.STAR)) {
            t2.setProjection(ProtoBuf.Type.Argument.Projection.STAR);
        } else {
            KmVariance variance = argument.component1();
            KmType argType = argument.component2();
            if (variance == null || argType == null) {
                throw new InconsistentKotlinMetadataException("Variance and type must be set for non-star type projection", null, 2, null);
            }
            if (variance == KmVariance.IN) {
                t2.setProjection(ProtoBuf.Type.Argument.Projection.IN);
            } else if (variance == KmVariance.OUT) {
                t2.setProjection(ProtoBuf.Type.Argument.Projection.OUT);
            }
            t2.setType(WritersKt.writeType($this$writeTypeProjection, argType).build());
        }
        Intrinsics.checkNotNull(t2);
        return t2;
    }

    private static final ProtoBuf.Type.Builder writeType(WriteContext $this$writeType, KmType kmType) {
        int flagsToWrite;
        KmType it;
        ProtoBuf.Type.Builder t2 = ProtoBuf.Type.newBuilder();
        KmClassifier cls = kmType.getClassifier();
        if (cls instanceof KmClassifier.Class) {
            t2.setClassName($this$writeType.getClassName$kotlin_metadata(((KmClassifier.Class)cls).getName()));
        } else if (cls instanceof KmClassifier.TypeAlias) {
            t2.setTypeAliasName($this$writeType.getClassName$kotlin_metadata(((KmClassifier.TypeAlias)cls).getName()));
        } else if (cls instanceof KmClassifier.TypeParameter) {
            t2.setTypeParameter(((KmClassifier.TypeParameter)cls).getId());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Iterable $this$forEach$iv = kmType.getArguments();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            KmTypeProjection argument = (KmTypeProjection)element$iv;
            boolean bl2 = false;
            t2.addArgument(WritersKt.writeTypeProjection($this$writeType, argument));
        }
        KmType kmType2 = kmType.getAbbreviatedType();
        if (kmType2 != null) {
            it = kmType2;
            boolean bl3 = false;
            t2.setAbbreviatedType(WritersKt.writeType($this$writeType, it).build());
        }
        KmType kmType3 = kmType.getOuterType();
        if (kmType3 != null) {
            it = kmType3;
            boolean bl4 = false;
            t2.setOuterType(WritersKt.writeType($this$writeType, it).build());
        }
        KmFlexibleTypeUpperBound kmFlexibleTypeUpperBound = kmType.getFlexibleTypeUpperBound();
        if (kmFlexibleTypeUpperBound != null) {
            KmFlexibleTypeUpperBound fub = kmFlexibleTypeUpperBound;
            boolean bl5 = false;
            ProtoBuf.Type.Builder fubType = WritersKt.writeType($this$writeType, fub.getType());
            String string = fub.getTypeFlexibilityId();
            if (string != null) {
                String it2 = string;
                boolean bl6 = false;
                t2.setFlexibleTypeCapabilitiesId($this$writeType.get(it2));
            }
            t2.setFlexibleUpperBound(fubType.build());
        }
        $this$forEach$iv = $this$writeType.getExtensions$kotlin_metadata();
        $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            MetadataExtensions it3 = (MetadataExtensions)element$iv;
            boolean bl7 = false;
            Intrinsics.checkNotNull(t2);
            it3.writeTypeExtensions(kmType, t2, $this$writeType);
        }
        if (Attributes.isNullable(kmType)) {
            t2.setNullable(true);
        }
        if ((flagsToWrite = kmType.getFlags$kotlin_metadata() >> 1) != ProtoBuf.Type.getDefaultInstance().getFlags()) {
            t2.setFlags(flagsToWrite);
        }
        Intrinsics.checkNotNull(t2);
        return t2;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final ProtoBuf.Property.Builder writeProperty(@NotNull WriteContext $this$writeProperty, @NotNull KmProperty kmProperty) {
        void $this$mapNotNullTo$iv$iv;
        void $this$mapNotNull$iv;
        Object object;
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv;
        Object it;
        Intrinsics.checkNotNullParameter($this$writeProperty, "<this>");
        Intrinsics.checkNotNullParameter(kmProperty, "kmProperty");
        ProtoBuf.Property.Builder t2 = ProtoBuf.Property.newBuilder();
        Iterable $this$forEach$iv = kmProperty.getTypeParameters();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            KmTypeParameter tp = (KmTypeParameter)element$iv;
            boolean bl2 = false;
            t2.addTypeParameter(WritersKt.writeTypeParameter($this$writeProperty, tp).build());
        }
        KmType kmType = kmProperty.getReceiverParameterType();
        if (kmType != null) {
            it = kmType;
            boolean bl3 = false;
            t2.setReceiverType(WritersKt.writeType($this$writeProperty, (KmType)it).build());
        }
        $this$forEach$iv = kmProperty.getContextReceiverTypes();
        ProtoBuf.Property.Builder builder = t2;
        boolean $i$f$map = false;
        it = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it2;
            object = (KmType)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl4 = false;
            collection.add(WritersKt.writeType($this$writeProperty, (KmType)it2).build());
        }
        builder.addAllContextReceiverType((List)destination$iv$iv);
        KmValueParameter kmValueParameter = kmProperty.getSetterParameter();
        if (kmValueParameter != null) {
            it = kmValueParameter;
            boolean bl5 = false;
            t2.setSetterValueParameter(WritersKt.writeValueParameter($this$writeProperty, (KmValueParameter)it).build());
        }
        t2.setReturnType(WritersKt.writeType($this$writeProperty, kmProperty.getReturnType()).build());
        $this$map$iv = kmProperty.getVersionRequirements();
        builder = t2;
        boolean $i$f$mapNotNull = false;
        it = $this$mapNotNull$iv;
        destination$iv$iv = new ArrayList();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        boolean $i$f$forEach2 = false;
        object = $this$forEach$iv$iv$iv.iterator();
        while (object.hasNext()) {
            Integer it$iv$iv;
            Object element$iv$iv$iv;
            Object element$iv$iv = element$iv$iv$iv = object.next();
            boolean bl6 = false;
            KmVersionRequirement it3 = (KmVersionRequirement)element$iv$iv;
            boolean bl7 = false;
            if (WritersKt.writeVersionRequirement($this$writeProperty, it3) == null) continue;
            boolean bl8 = false;
            destination$iv$iv.add(it$iv$iv);
        }
        builder.addAllVersionRequirement((List)destination$iv$iv);
        $this$forEach$iv = $this$writeProperty.getExtensions$kotlin_metadata();
        $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            MetadataExtensions it4 = (MetadataExtensions)element$iv;
            boolean bl9 = false;
            Intrinsics.checkNotNull(t2);
            it4.writePropertyExtensions(kmProperty, t2, $this$writeProperty);
        }
        t2.setName($this$writeProperty.get(kmProperty.getName()));
        int flags = kmProperty.getFlags$kotlin_metadata() | Flags.HAS_ANNOTATIONS.toFlags(!((Collection)kmProperty.getAnnotations()).isEmpty());
        if (flags != ProtoBuf.Property.getDefaultInstance().getFlags()) {
            t2.setFlags(flags);
        }
        t2.setGetterFlags(kmProperty.getGetter().getFlags$kotlin_metadata() | Flags.HAS_ANNOTATIONS.toFlags(!((Collection)kmProperty.getGetter().getAnnotations()).isEmpty()));
        KmPropertyAccessorAttributes kmPropertyAccessorAttributes = kmProperty.getSetter();
        if (kmPropertyAccessorAttributes != null) {
            KmPropertyAccessorAttributes setter = kmPropertyAccessorAttributes;
            boolean bl10 = false;
            t2.setSetterFlags(setter.getFlags$kotlin_metadata() | Flags.HAS_ANNOTATIONS.toFlags(!((Collection)setter.getAnnotations()).isEmpty()));
        }
        Intrinsics.checkNotNull(t2);
        return t2;
    }

    private static final ProtoBuf.ValueParameter.Builder writeValueParameter(WriteContext $this$writeValueParameter, KmValueParameter kmValueParameter) {
        Object it;
        ProtoBuf.ValueParameter.Builder t2 = ProtoBuf.ValueParameter.newBuilder();
        t2.setType(WritersKt.writeType($this$writeValueParameter, kmValueParameter.getType()).build());
        KmType kmType = kmValueParameter.getVarargElementType();
        if (kmType != null) {
            it = kmType;
            boolean bl2 = false;
            t2.setVarargElementType(WritersKt.writeType($this$writeValueParameter, (KmType)it).build());
        }
        KmAnnotationArgument kmAnnotationArgument = kmValueParameter.getAnnotationParameterDefaultValue();
        if (kmAnnotationArgument != null) {
            it = kmAnnotationArgument;
            boolean bl3 = false;
            t2.setAnnotationParameterDefaultValue(WriteUtilsKt.writeAnnotationArgument((KmAnnotationArgument)it, $this$writeValueParameter.getStrings()).build());
        }
        Iterable $this$forEach$iv = $this$writeValueParameter.getExtensions$kotlin_metadata();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            MetadataExtensions it2 = (MetadataExtensions)element$iv;
            boolean bl4 = false;
            Intrinsics.checkNotNull(t2);
            it2.writeValueParameterExtensions(kmValueParameter, t2, $this$writeValueParameter);
        }
        int flags = kmValueParameter.getFlags$kotlin_metadata() | Flags.HAS_ANNOTATIONS.toFlags(!((Collection)kmValueParameter.getAnnotations()).isEmpty());
        if (flags != ProtoBuf.ValueParameter.getDefaultInstance().getFlags()) {
            t2.setFlags(flags);
        }
        t2.setName($this$writeValueParameter.get(kmValueParameter.getName()));
        Intrinsics.checkNotNull(t2);
        return t2;
    }

    private static final Integer writeVersionRequirement(WriteContext $this$writeVersionRequirement, KmVersionRequirement kmVersionRequirement) {
        ProtoBuf.VersionRequirement.Level level;
        ProtoBuf.VersionRequirement.VersionKind versionKind;
        KmVersionRequirementVersionKind kind2 = kmVersionRequirement.getKind();
        KmVersionRequirementLevel level2 = kmVersionRequirement.getLevel();
        Integer errorCode = kmVersionRequirement.getErrorCode();
        String message = kmVersionRequirement.getMessage();
        Object object = ProtoBuf.VersionRequirement.newBuilder();
        ProtoBuf.VersionRequirement.Builder $this$writeVersionRequirement_u24lambda_u2431 = object;
        boolean bl2 = false;
        switch (WhenMappings.$EnumSwitchMapping$0[kind2.ordinal()]) {
            case 1: {
                versionKind = ProtoBuf.VersionRequirement.VersionKind.LANGUAGE_VERSION;
                break;
            }
            case 2: {
                versionKind = ProtoBuf.VersionRequirement.VersionKind.COMPILER_VERSION;
                break;
            }
            case 3: {
                versionKind = ProtoBuf.VersionRequirement.VersionKind.API_VERSION;
                break;
            }
            case 4: {
                return null;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        ProtoBuf.VersionRequirement.VersionKind versionKind2 = versionKind;
        if (versionKind2 != $this$writeVersionRequirement_u24lambda_u2431.getDefaultInstanceForType().getVersionKind()) {
            $this$writeVersionRequirement_u24lambda_u2431.setVersionKind(versionKind2);
        }
        switch (WhenMappings.$EnumSwitchMapping$1[level2.ordinal()]) {
            case 1: {
                level = ProtoBuf.VersionRequirement.Level.WARNING;
                break;
            }
            case 2: {
                level = ProtoBuf.VersionRequirement.Level.ERROR;
                break;
            }
            case 3: {
                level = ProtoBuf.VersionRequirement.Level.HIDDEN;
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        ProtoBuf.VersionRequirement.Level requirementLevel = level;
        if (requirementLevel != $this$writeVersionRequirement_u24lambda_u2431.getDefaultInstanceForType().getLevel()) {
            $this$writeVersionRequirement_u24lambda_u2431.setLevel(requirementLevel);
        }
        if (errorCode != null) {
            $this$writeVersionRequirement_u24lambda_u2431.setErrorCode(errorCode);
        }
        if (message != null) {
            $this$writeVersionRequirement_u24lambda_u2431.setMessage($this$writeVersionRequirement.get(message));
        }
        ProtoBuf.VersionRequirement.Builder t2 = object;
        object = kmVersionRequirement.getVersion();
        int major = ((KmVersion)object).component1();
        int minor = ((KmVersion)object).component2();
        int patch = ((KmVersion)object).component3();
        ProtoBuf.VersionRequirement.Builder builder = t2;
        WritersKt$$Lambda$0 writersKt$$Lambda$0 = new WritersKt$$Lambda$0(builder);
        builder = t2;
        new VersionRequirement.Version(major, minor, patch).encode(writersKt$$Lambda$0, new WritersKt$$Lambda$1(builder));
        MutableVersionRequirementTable mutableVersionRequirementTable = $this$writeVersionRequirement.getVersionRequirements$kotlin_metadata();
        Intrinsics.checkNotNull(t2);
        return mutableVersionRequirementTable.get((GeneratedMessageLite.Builder)t2);
    }

    private static final Unit writeVersionRequirement$lambda$32(ProtoBuf.VersionRequirement.Builder $t, int it) {
        ProtoBuf.VersionRequirement.Builder builder = $t;
        Intrinsics.checkNotNull(builder);
        builder.setVersion(it);
        return Unit.INSTANCE;
    }

    private static final Unit writeVersionRequirement$lambda$33(ProtoBuf.VersionRequirement.Builder $t, int it) {
        ProtoBuf.VersionRequirement.Builder builder = $t;
        Intrinsics.checkNotNull(builder);
        builder.setVersionFull(it);
        return Unit.INSTANCE;
    }

    static /* synthetic */ Unit accessor$WritersKt$lambda0(ProtoBuf.VersionRequirement.Builder builder, int n2) {
        return WritersKt.writeVersionRequirement$lambda$32(builder, n2);
    }

    static /* synthetic */ Unit accessor$WritersKt$lambda1(ProtoBuf.VersionRequirement.Builder builder, int n2) {
        return WritersKt.writeVersionRequirement$lambda$33(builder, n2);
    }

    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] nArray = new int[KmVersionRequirementVersionKind.values().length];
            try {
                nArray[KmVersionRequirementVersionKind.LANGUAGE_VERSION.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[KmVersionRequirementVersionKind.COMPILER_VERSION.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[KmVersionRequirementVersionKind.API_VERSION.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[KmVersionRequirementVersionKind.UNKNOWN.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
            nArray = new int[KmVersionRequirementLevel.values().length];
            try {
                nArray[KmVersionRequirementLevel.WARNING.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[KmVersionRequirementLevel.ERROR.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[KmVersionRequirementLevel.HIDDEN.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$1 = nArray;
            nArray = new int[KmEffectType.values().length];
            try {
                nArray[KmEffectType.RETURNS_CONSTANT.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[KmEffectType.CALLS.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[KmEffectType.RETURNS_NOT_NULL.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$2 = nArray;
            nArray = new int[KmEffectInvocationKind.values().length];
            try {
                nArray[KmEffectInvocationKind.AT_MOST_ONCE.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[KmEffectInvocationKind.EXACTLY_ONCE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[KmEffectInvocationKind.AT_LEAST_ONCE.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$3 = nArray;
        }
    }
}

