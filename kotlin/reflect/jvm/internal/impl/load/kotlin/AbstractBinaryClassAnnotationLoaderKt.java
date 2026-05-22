/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AbstractBinaryClassAnnotationLoaderKt {
    @Nullable
    public static final MemberSignature getPropertySignature(@NotNull ProtoBuf.Property proto, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable, boolean field, boolean synthetic, boolean requireHasFieldFlagForField) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        GeneratedMessageLite.ExtendableMessage extendableMessage = proto;
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> generatedExtension = JvmProtoBuf.propertySignature;
        Intrinsics.checkNotNullExpressionValue(generatedExtension, "propertySignature");
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = ProtoBufUtilKt.getExtensionOrNull(extendableMessage, generatedExtension);
        if (jvmPropertySignature == null) {
            return null;
        }
        JvmProtoBuf.JvmPropertySignature signature = jvmPropertySignature;
        if (field) {
            JvmMemberSignature.Field field2 = JvmProtoBufUtil.INSTANCE.getJvmFieldSignature(proto, nameResolver, typeTable, requireHasFieldFlagForField);
            if (field2 == null) {
                return null;
            }
            JvmMemberSignature.Field fieldSignature = field2;
            return MemberSignature.Companion.fromJvmMemberSignature(fieldSignature);
        }
        if (synthetic && signature.hasSyntheticMethod()) {
            JvmProtoBuf.JvmMethodSignature jvmMethodSignature = signature.getSyntheticMethod();
            Intrinsics.checkNotNullExpressionValue(jvmMethodSignature, "getSyntheticMethod(...)");
            return MemberSignature.Companion.fromMethod(nameResolver, jvmMethodSignature);
        }
        return null;
    }

    public static /* synthetic */ MemberSignature getPropertySignature$default(ProtoBuf.Property property, NameResolver nameResolver, TypeTable typeTable, boolean bl2, boolean bl3, boolean bl4, int n2, Object object) {
        if ((n2 & 8) != 0) {
            bl2 = false;
        }
        if ((n2 & 0x10) != 0) {
            bl3 = false;
        }
        if ((n2 & 0x20) != 0) {
            bl4 = true;
        }
        return AbstractBinaryClassAnnotationLoaderKt.getPropertySignature(property, nameResolver, typeTable, bl2, bl3, bl4);
    }
}

