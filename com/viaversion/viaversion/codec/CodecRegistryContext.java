/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.codec;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import ViaVersion.xyz.wagyourtail.jvmdg.j9.stub.java_base.J_U_List;
import com.viaversion.viaversion.api.minecraft.codec.CodecContext;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.types.version.VersionedTypesHolder;
import com.viaversion.viaversion.libs.fastutil.objects.ReferenceOpenHashSet;
import com.viaversion.viaversion.util.SerializerVersion;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="protocol", type=Protocol.class), @RecordComponents.Value(name="serializerVersion", type=SerializerVersion.class), @RecordComponents.Value(name="mappedSerializerVersion", type=SerializerVersion.class), @RecordComponents.Value(name="registryAccess", type=CodecContext.RegistryAccess.class), @RecordComponents.Value(name="mapped", type=boolean.class)})
public final class CodecRegistryContext
extends J_L_Record
implements CodecContext {
    private final Protocol<?, ?, ?, ?> protocol;
    private final SerializerVersion serializerVersion;
    private final SerializerVersion mappedSerializerVersion;
    private final CodecContext.RegistryAccess registryAccess;
    private final boolean mapped;
    private static final Set<StructuredDataKey<?>> NOT_IMPLEMENTED = new ReferenceOpenHashSet<StructuredDataKey[]>(J_U_List.of(new StructuredDataKey[]{StructuredDataKey.TRIM1_21_5, StructuredDataKey.TOOL1_21_5, StructuredDataKey.PROVIDES_TRIM_MATERIAL, StructuredDataKey.CONSUMABLE1_21_2, StructuredDataKey.JUKEBOX_PLAYABLE1_21_5, StructuredDataKey.INSTRUMENT1_21_5, StructuredDataKey.EQUIPPABLE1_21_5, StructuredDataKey.REPAIRABLE, StructuredDataKey.DEATH_PROTECTION, StructuredDataKey.BLOCKS_ATTACKS, StructuredDataKey.SUSPICIOUS_STEW_EFFECTS, StructuredDataKey.BANNER_PATTERNS, StructuredDataKey.POT_DECORATIONS, StructuredDataKey.BREAK_SOUND, StructuredDataKey.WOLF_VARIANT, StructuredDataKey.WOLF_SOUND_VARIANT, StructuredDataKey.PIG_VARIANT, StructuredDataKey.COW_VARIANT, StructuredDataKey.CHICKEN_VARIANT, StructuredDataKey.FROG_VARIANT, StructuredDataKey.PAINTING_VARIANT, StructuredDataKey.CAT_VARIANT, StructuredDataKey.EQUIPPABLE1_21_6}));

    public CodecRegistryContext(Protocol<?, ?, ?, ?> protocol, SerializerVersion serializerVersion, SerializerVersion mappedSerializerVersion, CodecContext.RegistryAccess registryAccess, boolean mapped) {
        this.protocol = protocol;
        this.serializerVersion = serializerVersion;
        this.mappedSerializerVersion = mappedSerializerVersion;
        this.registryAccess = registryAccess.withMapped(mapped);
        this.mapped = mapped;
    }

    @Override
    public boolean isSupported(StructuredDataKey<?> key) {
        if (this.protocol == null) {
            return !NOT_IMPLEMENTED.contains(key);
        }
        VersionedTypesHolder types = this.mapped ? this.protocol.mappedTypes() : this.protocol.types();
        return !NOT_IMPLEMENTED.contains(key) && types.structuredDataKeys().supportsOps(key);
    }

    @Override
    public final String toString() {
        return CodecRegistryContext.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return CodecRegistryContext.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return CodecRegistryContext.jvmdowngrader$equals$equals(this, o2);
    }

    public Protocol<?, ?, ?, ?> protocol() {
        return this.protocol;
    }

    public SerializerVersion serializerVersion() {
        return this.serializerVersion;
    }

    public SerializerVersion mappedSerializerVersion() {
        return this.mappedSerializerVersion;
    }

    @Override
    public CodecContext.RegistryAccess registryAccess() {
        return this.registryAccess;
    }

    @Override
    public boolean mapped() {
        return this.mapped;
    }

    private static String jvmdowngrader$toString$toString(CodecRegistryContext codecRegistryContext) {
        CodecRegistryContext codecRegistryContext2 = codecRegistryContext;
        return "CodecRegistryContext[" + "protocol=" + codecRegistryContext.protocol + ", " + "serializerVersion=" + (Object)((Object)codecRegistryContext.serializerVersion) + ", " + "mappedSerializerVersion=" + (Object)((Object)codecRegistryContext.mappedSerializerVersion) + ", " + "registryAccess=" + codecRegistryContext.registryAccess + ", " + "mapped=" + codecRegistryContext.mapped + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(CodecRegistryContext codecRegistryContext) {
        Object[] objectArray = new Object[]{codecRegistryContext.protocol, codecRegistryContext.serializerVersion, codecRegistryContext.mappedSerializerVersion, codecRegistryContext.registryAccess, codecRegistryContext.mapped};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(CodecRegistryContext codecRegistryContext, Object object) {
        if (codecRegistryContext == object) {
            return true;
        }
        if (object != null && object instanceof CodecRegistryContext) {
            CodecRegistryContext codecRegistryContext2 = (CodecRegistryContext)object;
            if (Objects.equals(codecRegistryContext.protocol, codecRegistryContext2.protocol) && Objects.equals((Object)codecRegistryContext.serializerVersion, (Object)codecRegistryContext2.serializerVersion) && Objects.equals((Object)codecRegistryContext.mappedSerializerVersion, (Object)codecRegistryContext2.mappedSerializerVersion) && Objects.equals(codecRegistryContext.registryAccess, codecRegistryContext2.registryAccess) && codecRegistryContext.mapped == codecRegistryContext2.mapped) {
                return true;
            }
        }
        return false;
    }
}

