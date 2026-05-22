/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.cache.CacheBuilder
 *  org.checkerframework.checker.nullness.qual.Nullable
 */
package com.viaversion.viaversion.data.item;

import com.google.common.cache.CacheBuilder;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.item.ItemHasher;
import com.viaversion.viaversion.api.minecraft.codec.CodecContext;
import com.viaversion.viaversion.api.minecraft.codec.hash.Hasher;
import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.item.HashedItem;
import com.viaversion.viaversion.api.minecraft.item.HashedStructuredItem;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.codec.CodecRegistryContext;
import com.viaversion.viaversion.codec.hash.HashFunction;
import com.viaversion.viaversion.codec.hash.HashOps;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.util.SerializerVersion;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ItemHasherBase
implements ItemHasher {
    public static int UNKNOWN_HASH = 399825415;
    private final Map<Integer, HashedItem> hashes = CacheBuilder.newBuilder().concurrencyLevel(1).maximumSize(1024L).build().asMap();
    protected final UserConnection connection;
    private final List<String> enchantments = new ArrayList<String>();
    private boolean processingClientboundInventoryPacket;
    private final CodecContext context;
    private final CodecContext mappedContext;

    public ItemHasherBase(Protocol<?, ?, ?, ?> protocol, UserConnection connection, SerializerVersion serializerVersion, SerializerVersion mappedSerializerVersion) {
        CodecContext.RegistryAccess registryAccess = CodecContext.RegistryAccess.of(this.enchantments, protocol.getMappingData());
        this.context = new CodecRegistryContext(protocol, serializerVersion, mappedSerializerVersion, registryAccess, false);
        this.mappedContext = new CodecRegistryContext(protocol, serializerVersion, mappedSerializerVersion, registryAccess, true);
        this.connection = connection;
    }

    @Override
    public void setEnchantments(List<String> enchantments) {
        this.enchantments.clear();
        this.enchantments.addAll(enchantments);
    }

    public HashedItem toHashedItem(Item item, boolean mapped) {
        return ItemHasherBase.toHashedItem(new HashOps(mapped ? this.mappedContext : this.context, HashFunction.CRC32C), item);
    }

    public static HashedItem toHashedItem(Hasher hasher, Item item) {
        HashedStructuredItem hashedItem = new HashedStructuredItem(item.identifier(), item.amount());
        for (StructuredData<?> data : item.dataContainer().data().values()) {
            if (data.isEmpty()) {
                hashedItem.removedDataIds().add(data.id());
                continue;
            }
            int hash = hasher.context().isSupported(data.key()) ? ItemHasherBase.hash(hasher, data) : UNKNOWN_HASH;
            hashedItem.dataHashesById().put(data.id(), hash);
        }
        return hashedItem;
    }

    public void trackOriginalHashedItem(CompoundTag customData, HashedItem originalHashedItem) {
        int customDataHash = this.hashTag(customData);
        this.hashes.put(customDataHash, originalHashedItem);
    }

    public @Nullable HashedItem originalHashedItem(int customDataHash, HashedItem clientItem) {
        HashedItem originalItem = this.hashes.get(customDataHash);
        if (originalItem == null) {
            return null;
        }
        originalItem = originalItem.copy();
        for (Int2IntMap.Entry entry : originalItem.dataHashesById().int2IntEntrySet()) {
            int typeId = entry.getIntKey();
            if (entry.getIntValue() != UNKNOWN_HASH || !clientItem.dataHashesById().containsKey(typeId)) continue;
            int clientProvidedHash = clientItem.dataHashesById().get(typeId);
            entry.setValue(clientProvidedHash);
        }
        return originalItem;
    }

    @Override
    public boolean isProcessingClientboundInventoryPacket() {
        return this.processingClientboundInventoryPacket;
    }

    @Override
    public void setProcessingClientboundInventoryPacket(boolean processingClientboundInventoryPacket) {
        this.processingClientboundInventoryPacket = processingClientboundInventoryPacket;
    }

    private static <T> int hash(Hasher hasher, StructuredData<T> data) {
        hasher.reset();
        hasher.write(data.key().type(), data.value());
        return hasher.hash();
    }

    private int hashTag(CompoundTag tag) {
        HashOps hasher = new HashOps(this.context, HashFunction.CRC32C);
        Types.TAG.write(hasher, (Tag)tag);
        return hasher.hash();
    }
}

