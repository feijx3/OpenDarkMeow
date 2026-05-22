/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.mcstructs.snbt.SNbt;
import com.viaversion.viaversion.libs.mcstructs.snbt.exceptions.SNbtDeserializeException;
import com.viaversion.viaversion.libs.mcstructs.snbt.exceptions.SNbtSerializeException;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.TextComponentCodec;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.TextComponentSerializer;

public enum SerializerVersion {
    V1_6(TextComponentSerializer.V1_6, null),
    V1_7(TextComponentSerializer.V1_7, SNbt.V1_7),
    V1_8(TextComponentSerializer.V1_8, SNbt.V1_8),
    V1_9(TextComponentSerializer.V1_9, SNbt.V1_8),
    V1_12(TextComponentSerializer.V1_12, SNbt.V1_12),
    V1_13(TextComponentSerializer.V1_12, SNbt.V1_13),
    V1_14(TextComponentSerializer.V1_14, SNbt.V1_14),
    V1_15(TextComponentSerializer.V1_15, SNbt.V1_14),
    V1_16(TextComponentSerializer.V1_16, SNbt.V1_14),
    V1_17(TextComponentSerializer.V1_17, SNbt.V1_14),
    V1_18(TextComponentSerializer.V1_18, SNbt.V1_14),
    V1_19_4(TextComponentSerializer.V1_19_4, SNbt.V1_14),
    V1_20_3(TextComponentCodec.V1_20_3, SNbt.V1_14),
    V1_20_5(TextComponentCodec.V1_20_5, SNbt.V1_14),
    V1_21_4(TextComponentCodec.V1_21_4, SNbt.V1_14),
    V1_21_5(TextComponentCodec.V1_21_5, null),
    V1_21_6(TextComponentCodec.V1_21_6, null);

    final TextComponentSerializer jsonSerializer;
    final SNbt<? extends Tag> sNbt;
    final TextComponentCodec codec;

    private SerializerVersion(TextComponentSerializer jsonSerializer, SNbt<? extends Tag> sNbt) {
        this.jsonSerializer = jsonSerializer;
        this.sNbt = sNbt;
        this.codec = null;
    }

    private SerializerVersion(TextComponentCodec codec, SNbt<? extends Tag> sNbt) {
        this.codec = codec;
        this.jsonSerializer = codec.asSerializer();
        this.sNbt = sNbt;
    }

    public String toString(TextComponent component) {
        return this.jsonSerializer.serialize(component);
    }

    public JsonElement toJson(TextComponent component) {
        return this.jsonSerializer.serializeJson(component);
    }

    public Tag toTag(TextComponent component) {
        if (this.codec == null) {
            throw new IllegalStateException("Cannot convert component to NBT with this version");
        }
        return this.codec.serializeNbtTree(component);
    }

    public TextComponent toComponent(JsonElement json) {
        return this.jsonSerializer.deserialize(json);
    }

    public TextComponent toComponent(String json) {
        if (this.ordinal() >= V1_20_3.ordinal()) {
            return this.jsonSerializer.deserializeParser(json);
        }
        if (this.ordinal() >= V1_9.ordinal()) {
            return this.jsonSerializer.deserializeReader(json);
        }
        return this.jsonSerializer.deserialize(json);
    }

    public TextComponent toComponent(Tag tag) {
        if (this.codec == null) {
            throw new IllegalStateException("Cannot convert NBT to component with this version");
        }
        return this.codec.deserializeNbtTree(tag);
    }

    public Tag toTag(String snbt) {
        if (this.sNbt == null) {
            throw new IllegalStateException("Cannot convert SNBT to NBT with this version");
        }
        try {
            return this.sNbt.deserialize(snbt);
        }
        catch (SNbtDeserializeException e2) {
            throw new RuntimeException(e2);
        }
    }

    public String toSNBT(Tag tag) {
        if (this.sNbt == null) {
            throw new IllegalStateException("Cannot convert SNBT to NBT with this version");
        }
        try {
            return this.sNbt.serialize(tag);
        }
        catch (SNbtSerializeException e2) {
            throw new RuntimeException(e2);
        }
    }
}

