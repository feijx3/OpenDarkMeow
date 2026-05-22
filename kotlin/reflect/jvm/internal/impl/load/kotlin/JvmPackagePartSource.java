/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.PreReleaseInfo;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nJvmPackagePartSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmPackagePartSource.kt\norg/jetbrains/kotlin/load/kotlin/JvmPackagePartSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,68:1\n1#2:69\n*E\n"})
public final class JvmPackagePartSource
implements DeserializedContainerSource {
    @NotNull
    private final JvmClassName className;
    @Nullable
    private final JvmClassName facadeClassName;
    @Nullable
    private final IncompatibleVersionErrorData<MetadataVersion> incompatibility;
    @NotNull
    private final PreReleaseInfo preReleaseInfo;
    @NotNull
    private final DeserializedContainerAbiStability abiStability;
    @Nullable
    private final KotlinJvmBinaryClass knownJvmBinaryClass;
    @NotNull
    private final String moduleName;

    /*
     * WARNING - void declaration
     */
    public JvmPackagePartSource(@NotNull JvmClassName className, @Nullable JvmClassName facadeClassName, @NotNull ProtoBuf.Package packageProto, @NotNull NameResolver nameResolver, @Nullable IncompatibleVersionErrorData<MetadataVersion> incompatibility, @NotNull PreReleaseInfo preReleaseInfo, @NotNull DeserializedContainerAbiStability abiStability, @Nullable KotlinJvmBinaryClass knownJvmBinaryClass) {
        Object object;
        block3: {
            block2: {
                void p0;
                Intrinsics.checkNotNullParameter(className, "className");
                Intrinsics.checkNotNullParameter(packageProto, "packageProto");
                Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
                Intrinsics.checkNotNullParameter(preReleaseInfo, "preReleaseInfo");
                Intrinsics.checkNotNullParameter((Object)abiStability, "abiStability");
                this.className = className;
                this.facadeClassName = facadeClassName;
                this.incompatibility = incompatibility;
                this.preReleaseInfo = preReleaseInfo;
                this.abiStability = abiStability;
                this.knownJvmBinaryClass = knownJvmBinaryClass;
                JvmPackagePartSource jvmPackagePartSource = this;
                GeneratedMessageLite.ExtendableMessage extendableMessage = packageProto;
                GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, Integer> generatedExtension = JvmProtoBuf.packageModuleName;
                Intrinsics.checkNotNullExpressionValue(generatedExtension, "packageModuleName");
                object = ProtoBufUtilKt.getExtensionOrNull(extendableMessage, generatedExtension);
                if (object == null) break block2;
                int n2 = ((Number)object).intValue();
                JvmPackagePartSource jvmPackagePartSource2 = jvmPackagePartSource;
                boolean bl2 = false;
                String string = nameResolver.getString((int)p0);
                jvmPackagePartSource = jvmPackagePartSource2;
                object = string;
                if (string != null) break block3;
            }
            object = "main";
        }
        jvmPackagePartSource.moduleName = object;
    }

    @NotNull
    public JvmClassName getClassName() {
        return this.className;
    }

    @Nullable
    public JvmClassName getFacadeClassName() {
        return this.facadeClassName;
    }

    @Nullable
    public final KotlinJvmBinaryClass getKnownJvmBinaryClass() {
        return this.knownJvmBinaryClass;
    }

    /*
     * WARNING - void declaration
     */
    public JvmPackagePartSource(@NotNull KotlinJvmBinaryClass kotlinClass, @NotNull ProtoBuf.Package packageProto, @NotNull NameResolver nameResolver, @Nullable IncompatibleVersionErrorData<MetadataVersion> incompatibility, boolean isPreReleaseInvisible, @NotNull DeserializedContainerAbiStability abiStability) {
        JvmClassName jvmClassName;
        Intrinsics.checkNotNullParameter(kotlinClass, "kotlinClass");
        Intrinsics.checkNotNullParameter(packageProto, "packageProto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter((Object)abiStability, "abiStability");
        JvmPackagePartSource jvmPackagePartSource = this;
        JvmClassName jvmClassName2 = JvmClassName.byClassId(kotlinClass.getClassId());
        JvmClassName jvmClassName3 = jvmClassName2;
        Intrinsics.checkNotNullExpressionValue(jvmClassName2, "byClassId(...)");
        String string = kotlinClass.getClassHeader().getMultifileClassName();
        if (string != null) {
            void it;
            String string2 = string;
            JvmClassName jvmClassName4 = jvmClassName3;
            JvmPackagePartSource jvmPackagePartSource2 = jvmPackagePartSource;
            boolean bl2 = false;
            JvmClassName jvmClassName5 = ((CharSequence)it).length() > 0 ? JvmClassName.byInternalName((String)it) : null;
            jvmPackagePartSource = jvmPackagePartSource2;
            jvmClassName3 = jvmClassName4;
            jvmClassName = jvmClassName5;
        } else {
            jvmClassName = null;
        }
        jvmPackagePartSource(jvmClassName3, jvmClassName, packageProto, nameResolver, incompatibility, new PreReleaseInfo(isPreReleaseInvisible, null, 2, null), abiStability, kotlinClass);
    }

    @Override
    @NotNull
    public String getPresentableString() {
        return "Class '" + this.getClassId().asSingleFqName().asString() + '\'';
    }

    @NotNull
    public final Name getSimpleName() {
        String string = this.getClassName().getInternalName();
        Intrinsics.checkNotNullExpressionValue(string, "getInternalName(...)");
        Name name = Name.identifier(StringsKt.substringAfterLast$default(string, '/', null, 2, null));
        Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
        return name;
    }

    @NotNull
    public final ClassId getClassId() {
        FqName fqName = this.getClassName().getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(fqName, "getPackageFqName(...)");
        return new ClassId(fqName, this.getSimpleName());
    }

    @NotNull
    public String toString() {
        return this.getClass().getSimpleName() + ": " + this.getClassName();
    }

    @Override
    @NotNull
    public SourceFile getContainingFile() {
        SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
        Intrinsics.checkNotNullExpressionValue(sourceFile, "NO_SOURCE_FILE");
        return sourceFile;
    }
}

