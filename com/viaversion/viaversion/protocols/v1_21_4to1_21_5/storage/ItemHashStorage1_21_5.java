/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.cache.Cache
 *  com.google.common.cache.CacheBuilder
 */
package com.viaversion.viaversion.protocols.v1_21_4to1_21_5.storage;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.viaversion.viaversion.api.data.item.ItemHasher;
import com.viaversion.viaversion.api.minecraft.codec.CodecContext;
import com.viaversion.viaversion.api.minecraft.codec.hash.Hasher;
import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.codec.CodecRegistryContext;
import com.viaversion.viaversion.codec.hash.HashFunction;
import com.viaversion.viaversion.codec.hash.HashOps;
import com.viaversion.viaversion.data.item.ItemHasherBase;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.Protocol1_21_4To1_21_5;
import com.viaversion.viaversion.util.SerializerVersion;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ItemHashStorage1_21_5
implements ItemHasher {
    private final Cache<Long, StructuredData<?>> hashToStructuredData = CacheBuilder.newBuilder().concurrencyLevel(1).maximumSize(512L).build();
    private final List<String> enchantmentRegistry = new ArrayList<String>();
    private boolean processingClientboundInventoryPacket;
    private final CodecContext context;

    public ItemHashStorage1_21_5(Protocol1_21_4To1_21_5 protocol) {
        CodecContext.RegistryAccess registryAccess = CodecContext.RegistryAccess.of(this.enchantmentRegistry, protocol.getMappingData());
        this.context = new CodecRegistryContext(protocol, SerializerVersion.V1_21_5, SerializerVersion.V1_21_5, registryAccess, true);
    }

    @Override
    public void setEnchantments(List<String> enchantments) {
        this.enchantmentRegistry.clear();
        this.enchantmentRegistry.addAll(enchantments);
    }

    public void trackStructuredData(StructuredData<?> structuredData) {
        int hash;
        if (structuredData.isEmpty()) {
            return;
        }
        HashOps hasher = new HashOps(this.context, HashFunction.CRC32C);
        int n2 = hash = hasher.context().isSupported(structuredData.key()) ? ItemHashStorage1_21_5.hash(hasher, structuredData) : ItemHasherBase.UNKNOWN_HASH;
        if (hash == ItemHasherBase.UNKNOWN_HASH) {
            return;
        }
        long key = (long)structuredData.id() << 32 | (long)hash;
        try {
            this.hashToStructuredData.get((Object)key, structuredData::copy);
        }
        catch (ExecutionException e2) {
            throw new RuntimeException(e2);
        }
    }

    public StructuredData<?> dataFromHash(int dataComponentId, int hash) {
        long key = (long)dataComponentId << 32 | (long)hash;
        StructuredData data = (StructuredData)this.hashToStructuredData.getIfPresent((Object)key);
        return data != null ? data.copy() : null;
    }

    private static <T> int hash(Hasher hasher, StructuredData<T> data) {
        hasher.write(data.key().type(), data.value());
        return hasher.hash();
    }

    @Override
    public boolean isProcessingClientboundInventoryPacket() {
        return this.processingClientboundInventoryPacket;
    }

    @Override
    public void setProcessingClientboundInventoryPacket(boolean processingClientboundInventoryPacket) {
        this.processingClientboundInventoryPacket = processingClientboundInventoryPacket;
    }
}

