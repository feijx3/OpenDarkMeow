/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinarySourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.PreReleaseInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nDeserializedDescriptorResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeserializedDescriptorResolver.kt\norg/jetbrains/kotlin/load/kotlin/DeserializedDescriptorResolver\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,144:1\n116#1,14:145\n116#1,14:159\n1#2:173\n*S KotlinDebug\n*F\n+ 1 DeserializedDescriptorResolver.kt\norg/jetbrains/kotlin/load/kotlin/DeserializedDescriptorResolver\n*L\n45#1:145,14\n60#1:159,14\n*E\n"})
public final class DeserializedDescriptorResolver {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public DeserializationComponents components;
    @NotNull
    private static final Set<KotlinClassHeader.Kind> KOTLIN_CLASS = SetsKt.setOf(KotlinClassHeader.Kind.CLASS);
    @NotNull
    private static final Set<KotlinClassHeader.Kind> KOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART;
    @NotNull
    private static final MetadataVersion KOTLIN_1_1_EAP_METADATA_VERSION;
    @NotNull
    private static final MetadataVersion KOTLIN_1_3_M1_METADATA_VERSION;
    @NotNull
    private static final MetadataVersion KOTLIN_1_3_RC_METADATA_VERSION;

    @NotNull
    public final DeserializationComponents getComponents() {
        DeserializationComponents deserializationComponents = this.components;
        if (deserializationComponents != null) {
            return deserializationComponents;
        }
        Intrinsics.throwUninitializedPropertyAccessException("components");
        return null;
    }

    public final void setComponents(@NotNull DeserializationComponents deserializationComponents) {
        Intrinsics.checkNotNullParameter(deserializationComponents, "<set-?>");
        this.components = deserializationComponents;
    }

    private final MetadataVersion getOwnMetadataVersion() {
        return this.getComponents().getConfiguration().getMetadataVersion();
    }

    public final void setComponents(@NotNull DeserializationComponentsForJava components) {
        Intrinsics.checkNotNullParameter(components, "components");
        this.setComponents(components.getComponents());
    }

    private final boolean getSkipMetadataVersionCheck() {
        return this.getComponents().getConfiguration().getSkipMetadataVersionCheck();
    }

    @Nullable
    public final ClassDescriptor resolveClass(@NotNull KotlinJvmBinaryClass kotlinClass) {
        Intrinsics.checkNotNullParameter(kotlinClass, "kotlinClass");
        ClassData classData = this.readClassData$descriptors_jvm(kotlinClass);
        if (classData == null) {
            return null;
        }
        ClassData classData2 = classData;
        return this.getComponents().getClassDeserializer().deserializeClass(kotlinClass.getClassId(), classData2);
    }

    @Nullable
    public final ClassData readClassData$descriptors_jvm(@NotNull KotlinJvmBinaryClass kotlinClass) {
        Pair<JvmNameResolver, ProtoBuf.Class> pair;
        Intrinsics.checkNotNullParameter(kotlinClass, "kotlinClass");
        String[] stringArray = this.readData(kotlinClass, KOTLIN_CLASS);
        if (stringArray == null) {
            return null;
        }
        String[] data = stringArray;
        String[] stringArray2 = kotlinClass.getClassHeader().getStrings();
        if (stringArray2 == null) {
            return null;
        }
        String[] strings = stringArray2;
        DeserializedDescriptorResolver this_$iv = this;
        boolean $i$f$parseProto = false;
        try {
            try {
                boolean bl2 = false;
                pair = JvmProtoBufUtil.readClassDataFrom(data, strings);
            }
            catch (InvalidProtocolBufferException e$iv) {
                throw new IllegalStateException("Could not read data from " + kotlinClass.getLocation(), e$iv);
            }
        }
        catch (Throwable e$iv) {
            if (this_$iv.getSkipMetadataVersionCheck() || kotlinClass.getClassHeader().getMetadataVersion().isCompatible(this_$iv.getOwnMetadataVersion())) {
                throw e$iv;
            }
            pair = null;
        }
        Pair<JvmNameResolver, ProtoBuf.Class> pair2 = pair;
        if (pair2 == null) {
            return null;
        }
        Pair<JvmNameResolver, ProtoBuf.Class> pair3 = pair2;
        JvmNameResolver nameResolver = pair3.component1();
        ProtoBuf.Class classProto = pair3.component2();
        KotlinJvmBinarySourceElement source = new KotlinJvmBinarySourceElement(kotlinClass, this.getIncompatibility(kotlinClass), new PreReleaseInfo(this.isPreReleaseInvisible(kotlinClass), null, 2, null), this.getAbiStability(kotlinClass));
        return new ClassData(nameResolver, classProto, kotlinClass.getClassHeader().getMetadataVersion(), source);
    }

    @Nullable
    public final MemberScope createKotlinPackagePartScope(@NotNull PackageFragmentDescriptor descriptor2, @NotNull KotlinJvmBinaryClass kotlinClass) {
        Pair<JvmNameResolver, ProtoBuf.Package> pair;
        Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
        Intrinsics.checkNotNullParameter(kotlinClass, "kotlinClass");
        String[] stringArray = this.readData(kotlinClass, KOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART);
        if (stringArray == null) {
            return null;
        }
        String[] data = stringArray;
        String[] stringArray2 = kotlinClass.getClassHeader().getStrings();
        if (stringArray2 == null) {
            return null;
        }
        String[] strings = stringArray2;
        DeserializedDescriptorResolver this_$iv = this;
        boolean $i$f$parseProto = false;
        try {
            try {
                boolean bl2 = false;
                pair = JvmProtoBufUtil.readPackageDataFrom(data, strings);
            }
            catch (InvalidProtocolBufferException e$iv) {
                throw new IllegalStateException("Could not read data from " + kotlinClass.getLocation(), e$iv);
            }
        }
        catch (Throwable e$iv) {
            if (this_$iv.getSkipMetadataVersionCheck() || kotlinClass.getClassHeader().getMetadataVersion().isCompatible(this_$iv.getOwnMetadataVersion())) {
                throw e$iv;
            }
            pair = null;
        }
        Pair<JvmNameResolver, ProtoBuf.Package> pair2 = pair;
        if (pair2 == null) {
            return null;
        }
        Pair<JvmNameResolver, ProtoBuf.Package> pair3 = pair2;
        JvmNameResolver nameResolver = pair3.component1();
        ProtoBuf.Package packageProto = pair3.component2();
        JvmPackagePartSource source = new JvmPackagePartSource(kotlinClass, packageProto, nameResolver, this.getIncompatibility(kotlinClass), this.isPreReleaseInvisible(kotlinClass), this.getAbiStability(kotlinClass));
        return new DeserializedPackageMemberScope(descriptor2, packageProto, nameResolver, kotlinClass.getClassHeader().getMetadataVersion(), source, this.getComponents(), "scope for " + source + " in " + descriptor2, DeserializedDescriptorResolver$$Lambda$0.INSTANCE);
    }

    private final IncompatibleVersionErrorData<MetadataVersion> getIncompatibility(KotlinJvmBinaryClass $this$incompatibility) {
        if (this.getSkipMetadataVersionCheck() || $this$incompatibility.getClassHeader().getMetadataVersion().isCompatible(this.getOwnMetadataVersion())) {
            return null;
        }
        return new IncompatibleVersionErrorData<MetadataVersion>($this$incompatibility.getClassHeader().getMetadataVersion(), MetadataVersion.INSTANCE, this.getOwnMetadataVersion(), this.getOwnMetadataVersion().lastSupportedVersionWithThisLanguageVersion($this$incompatibility.getClassHeader().getMetadataVersion().isStrictSemantics()), $this$incompatibility.getLocation());
    }

    private final boolean isPreReleaseInvisible(KotlinJvmBinaryClass $this$isPreReleaseInvisible) {
        return this.getComponents().getConfiguration().getReportErrorsOnPreReleaseDependencies() && ($this$isPreReleaseInvisible.getClassHeader().isPreRelease() || Intrinsics.areEqual($this$isPreReleaseInvisible.getClassHeader().getMetadataVersion(), KOTLIN_1_1_EAP_METADATA_VERSION)) || this.isCompiledWith13M1($this$isPreReleaseInvisible);
    }

    private final boolean isCompiledWith13M1(KotlinJvmBinaryClass $this$isCompiledWith13M1) {
        return !this.getComponents().getConfiguration().getSkipPrereleaseCheck() && $this$isCompiledWith13M1.getClassHeader().isPreRelease() && Intrinsics.areEqual($this$isCompiledWith13M1.getClassHeader().getMetadataVersion(), KOTLIN_1_3_M1_METADATA_VERSION);
    }

    private final DeserializedContainerAbiStability getAbiStability(KotlinJvmBinaryClass $this$abiStability) {
        return this.getComponents().getConfiguration().getAllowUnstableDependencies() ? DeserializedContainerAbiStability.STABLE : ($this$abiStability.getClassHeader().isUnstableJvmIrBinary() ? DeserializedContainerAbiStability.UNSTABLE : DeserializedContainerAbiStability.STABLE);
    }

    private final String[] readData(KotlinJvmBinaryClass kotlinClass, Set<? extends KotlinClassHeader.Kind> expectedKinds) {
        Object object;
        KotlinClassHeader header = kotlinClass.getClassHeader();
        String[] stringArray = header.getData();
        if (stringArray == null) {
            stringArray = header.getIncompatibleData();
        }
        if (stringArray != null) {
            String[] stringArray2;
            String[] it = stringArray2 = stringArray;
            boolean bl2 = false;
            object = expectedKinds.contains((Object)header.getKind()) ? stringArray2 : null;
        } else {
            object = null;
        }
        return object;
    }

    private static final Collection createKotlinPackagePartScope$lambda$2() {
        return CollectionsKt.emptyList();
    }

    static {
        Object[] objectArray = new KotlinClassHeader.Kind[]{KotlinClassHeader.Kind.FILE_FACADE, KotlinClassHeader.Kind.MULTIFILE_CLASS_PART};
        KOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART = SetsKt.setOf(objectArray);
        objectArray = new int[3];
        objectArray[0] = (KotlinClassHeader.Kind)true;
        objectArray[1] = (KotlinClassHeader.Kind)true;
        objectArray[2] = (KotlinClassHeader.Kind)2;
        KOTLIN_1_1_EAP_METADATA_VERSION = new MetadataVersion((int[])objectArray);
        objectArray = new int[3];
        objectArray[0] = (KotlinClassHeader.Kind)true;
        objectArray[1] = (KotlinClassHeader.Kind)true;
        objectArray[2] = (KotlinClassHeader.Kind)11;
        KOTLIN_1_3_M1_METADATA_VERSION = new MetadataVersion((int[])objectArray);
        objectArray = new int[3];
        objectArray[0] = (KotlinClassHeader.Kind)true;
        objectArray[1] = (KotlinClassHeader.Kind)true;
        objectArray[2] = (KotlinClassHeader.Kind)13;
        KOTLIN_1_3_RC_METADATA_VERSION = new MetadataVersion((int[])objectArray);
    }

    static /* synthetic */ Collection accessor$DeserializedDescriptorResolver$lambda0() {
        return DeserializedDescriptorResolver.createKotlinPackagePartScope$lambda$2();
    }

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final MetadataVersion getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm() {
            return KOTLIN_1_3_RC_METADATA_VERSION;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

