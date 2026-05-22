/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.storage;

import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.minecraft.codec.CodecContext;
import com.viaversion.viaversion.api.minecraft.codec.hash.Hasher;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.codec.CodecRegistryContext;
import com.viaversion.viaversion.codec.hash.HashFunction;
import com.viaversion.viaversion.codec.hash.HashOps;
import com.viaversion.viaversion.util.SerializerVersion;
import java.util.ArrayList;
import java.util.List;

public class HashedItemConverterStorage
implements StorableObject {
    private final List<String> enchantments = new ArrayList<String>();
    private final Hasher hasher;

    public HashedItemConverterStorage(Protocol<?, ?, ?, ?> protocol) {
        CodecContext.RegistryAccess registryAccess = CodecContext.RegistryAccess.of(this.enchantments, protocol.getMappingData());
        CodecRegistryContext context = new CodecRegistryContext(protocol, SerializerVersion.V1_21_5, SerializerVersion.V1_21_5, registryAccess, false);
        this.hasher = new HashOps(context, HashFunction.CRC32C);
    }

    public void setEnchantments(List<String> enchantments) {
        this.enchantments.clear();
        this.enchantments.addAll(enchantments);
    }

    public Hasher hasher() {
        return this.hasher;
    }
}

