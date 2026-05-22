/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.rewriter;

import com.google.common.base.Preconditions;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.data.item.ItemHasher;
import com.viaversion.viaversion.api.minecraft.EitherHolder;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.HashedItem;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.data.FilterableComponent;
import com.viaversion.viaversion.api.minecraft.item.data.WrittenBook;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypesHolder;
import com.viaversion.viaversion.data.item.ItemHasherBase;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.rewriter.ItemRewriter;
import com.viaversion.viaversion.util.Rewritable;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={ItemHandler.class})
public class StructuredItemRewriter<C extends ClientboundPacketType, S extends ServerboundPacketType, T extends Protocol<C, ?, ?, S>>
extends ItemRewriter<C, S, T> {
    public static final String MARKER_KEY = "VV|custom_data";

    public StructuredItemRewriter(T protocol) {
        super(protocol);
    }

    @Override
    public Item handleItemToClient(UserConnection connection, Item item) {
        MappingData mappingData;
        if (item.isEmpty()) {
            return item;
        }
        ItemHasherBase itemHasher = (ItemHasherBase)this.itemHasher(connection);
        HashedItem originalHashedItem = this.hashItem(item, itemHasher);
        StructuredDataContainer dataContainer = item.dataContainer();
        this.updateItemDataComponentTypeIds(dataContainer, true);
        CompoundTag backupTag = new CompoundTag();
        this.backupInconvertibleData(connection, item, dataContainer, backupTag);
        if (!backupTag.isEmpty()) {
            this.saveTag(this.createCustomTag(item), backupTag, "backup");
        }
        if ((mappingData = this.protocol.getMappingData()) != null && mappingData.getItemMappings() != null) {
            item.setIdentifier(mappingData.getNewItemId(item.identifier()));
        }
        this.handleRewritablesToClient(connection, dataContainer, originalHashedItem != null ? itemHasher : null);
        this.handleItemDataComponentsToClient(connection, item, dataContainer);
        this.storeOriginalHashedItem(item, itemHasher, originalHashedItem);
        return item;
    }

    protected @Nullable HashedItem hashItem(Item item, @Nullable ItemHasherBase hasher) {
        return hasher == null || !hasher.isProcessingClientboundInventoryPacket() ? null : hasher.toHashedItem(item, false);
    }

    protected void storeOriginalHashedItem(Item item, ItemHasherBase hasher, @Nullable HashedItem originalHashedItem) {
        if (originalHashedItem == null || item.dataContainer().isEmpty()) {
            return;
        }
        HashedItem hashedItem = hasher.toHashedItem(item, true);
        if (hashedItem.dataHashesById().equals(originalHashedItem.dataHashesById()) && hashedItem.removedDataIds().equals(originalHashedItem.removedDataIds())) {
            return;
        }
        CompoundTag originalHashes = new CompoundTag();
        for (Int2IntMap.Entry entry : originalHashedItem.dataHashesById().int2IntEntrySet()) {
            originalHashes.putInt(Integer.toString(entry.getIntKey()), entry.getIntValue());
        }
        originalHashes.put("removed", new IntArrayTag(originalHashedItem.removedDataIds().toIntArray()));
        CompoundTag customTag = this.createCustomTag(item);
        this.saveTag(customTag, originalHashes, "original_hashes");
        hasher.trackOriginalHashedItem(customTag, originalHashedItem);
    }

    @Override
    public Item handleItemToServer(UserConnection connection, Item item) {
        if (item.isEmpty()) {
            return item;
        }
        MappingData mappingData = this.protocol.getMappingData();
        if (mappingData != null && mappingData.getItemMappings() != null) {
            item.setIdentifier(mappingData.getOldItemId(item.identifier()));
        }
        this.updateItemDataComponentTypeIds(item.dataContainer(), false);
        this.handleRewritablesToServer(connection, item.dataContainer());
        this.restoreBackupData(item);
        this.handleItemDataComponentsToServer(connection, item, item.dataContainer());
        return item;
    }

    protected void updateItemDataComponentTypeIds(StructuredDataContainer container, boolean mappedNames) {
        MappingData mappingData = this.protocol.getMappingData();
        if (mappingData == null) {
            return;
        }
        FullMappings dataComponentMappings = mappingData.getDataComponentSerializerMappings();
        if (dataComponentMappings == null) {
            return;
        }
        if (!mappedNames) {
            dataComponentMappings = dataComponentMappings.inverse();
        }
        container.setIdLookup(this.protocol, mappedNames);
        container.updateIds(this.protocol, dataComponentMappings::getNewId);
    }

    protected void handleItemDataComponentsToClient(UserConnection connection, Item item, StructuredDataContainer container) {
        if (this.protocol.getComponentRewriter() != null) {
            WrittenBook book;
            this.updateTextComponent(connection, item, StructuredDataKey.ITEM_NAME, "item_name");
            this.updateTextComponent(connection, item, StructuredDataKey.CUSTOM_NAME, "custom_name");
            Tag[] lore = container.get(StructuredDataKey.LORE);
            if (lore != null) {
                for (Tag tag : lore) {
                    this.protocol.getComponentRewriter().processTag(connection, tag);
                }
            }
            if ((book = container.get(StructuredDataKey.WRITTEN_BOOK_CONTENT)) != null) {
                for (FilterableComponent page : book.pages()) {
                    this.protocol.getComponentRewriter().processTag(connection, (Tag)page.raw());
                    if (!page.isFiltered()) continue;
                    this.protocol.getComponentRewriter().processTag(connection, (Tag)page.filtered());
                }
            }
        }
        this.replaceAnnoyingKeys(container, this.protocol.types(), this.protocol.mappedTypes());
    }

    protected void handleItemDataComponentsToServer(UserConnection connection, Item item, StructuredDataContainer container) {
        this.replaceAnnoyingKeys(container, this.protocol.mappedTypes(), this.protocol.types());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void handleRewritablesToClient(UserConnection connection, StructuredDataContainer container, @Nullable ItemHasher itemHasher) {
        if (itemHasher == null) {
            this.handleRewritables(connection, true, container, this::handleItemToClient);
            return;
        }
        itemHasher.setProcessingClientboundInventoryPacket(false);
        try {
            this.handleRewritables(connection, true, container, this::handleItemToClient);
        }
        finally {
            itemHasher.setProcessingClientboundInventoryPacket(true);
        }
    }

    protected void handleRewritablesToServer(UserConnection connection, StructuredDataContainer container) {
        this.handleRewritables(connection, false, container, this::handleItemToServer);
    }

    private void handleRewritables(UserConnection connection, boolean clientbound, StructuredDataContainer container, ItemHandler itemHandler) {
        for (Map.Entry<StructuredDataKey<?>, StructuredData<?>> entry : container.data().entrySet()) {
            StructuredData<?> holderData;
            StructuredData<?> data = entry.getValue();
            if (data.isEmpty()) continue;
            Object value = data.value();
            if (value instanceof Item) {
                Item itemValue = (Item)value;
                StructuredData<?> itemData = data;
                itemData.setValue(itemHandler.rewrite(connection, itemValue));
                continue;
            }
            if (value instanceof Item[]) {
                Item[] items = (Item[])value;
                for (int i2 = 0; i2 < items.length; ++i2) {
                    items[i2] = itemHandler.rewrite(connection, items[i2]);
                }
                continue;
            }
            if (value instanceof Rewritable) {
                Rewritable rewritable = (Rewritable)value;
                this.setDataUnchecked(data, rewritable.rewrite(connection, this.protocol, clientbound));
                continue;
            }
            if (value instanceof Holder) {
                Holder holder = (Holder)value;
                holderData = data;
                if (!holder.isDirect() || !(holder.value() instanceof Rewritable)) continue;
                holderData.setValue(this.updateHolderUnchecked(holder, connection, clientbound));
                continue;
            }
            if (!(value instanceof EitherHolder)) continue;
            EitherHolder eitherHolder = (EitherHolder)value;
            holderData = data;
            if (!eitherHolder.hasHolder() || !eitherHolder.holder().isDirect() || !(eitherHolder.holder().value() instanceof Rewritable)) continue;
            holderData.setValue(EitherHolder.of(this.updateHolderUnchecked(eitherHolder.holder(), connection, clientbound)));
        }
    }

    private <V> void setDataUnchecked(StructuredData<V> data, Object value) {
        data.setValue(value);
    }

    private <V> Holder<V> updateHolderUnchecked(Holder<V> holder, UserConnection connection, boolean clientbound) {
        return holder.updateValue(val -> {
            Object object;
            if (val instanceof Rewritable) {
                Rewritable rewritable = (Rewritable)val;
                object = rewritable.rewrite(connection, this.protocol, clientbound);
            } else {
                object = val;
            }
            return object;
        });
    }

    protected void updateTextComponent(UserConnection connection, Item item, StructuredDataKey<Tag> key, String backupKey) {
        Tag name = item.dataContainer().get(key);
        if (name == null) {
            return;
        }
        Tag originalName = name.copy();
        this.protocol.getComponentRewriter().processTag(connection, name);
        if (!name.equals(originalName)) {
            this.saveTag(this.createCustomTag(item), originalName, backupKey);
        }
    }

    protected void restoreBackupData(Item item) {
        StructuredDataContainer container = item.dataContainer();
        CompoundTag customData = container.get(StructuredDataKey.CUSTOM_DATA);
        if (customData != null) {
            this.restoreBackupData(item, container, customData);
            this.removeCustomTag(container, customData);
        }
    }

    protected void backupInconvertibleData(UserConnection connection, Item item, StructuredDataContainer dataContainer, CompoundTag backupTag) {
    }

    protected void restoreBackupData(Item item, StructuredDataContainer container, CompoundTag customData) {
        customData.remove(this.nbtTagName("original_hashes"));
        if (this.removeBackupTag(customData, "added_custom_name") != null) {
            container.remove(StructuredDataKey.CUSTOM_NAME);
        } else {
            Tag itemName;
            Tag customName = this.removeBackupTag(customData, "custom_name");
            if (customName != null) {
                container.set(StructuredDataKey.CUSTOM_NAME, customName);
            }
            if ((itemName = this.removeBackupTag(customData, "item_name")) != null) {
                container.set(StructuredDataKey.ITEM_NAME, itemName);
            }
        }
    }

    protected CompoundTag createCustomTag(Item item) {
        StructuredDataContainer data = item.dataContainer();
        CompoundTag customData = data.get(StructuredDataKey.CUSTOM_DATA);
        if (customData == null) {
            customData = new CompoundTag();
            customData.putBoolean(MARKER_KEY, true);
            data.set(StructuredDataKey.CUSTOM_DATA, customData);
        }
        return customData;
    }

    protected void saveTag(CompoundTag customData, Tag tag, String name) {
        String backupName = this.nbtTagName(name);
        if (!customData.contains(backupName)) {
            customData.put(backupName, tag);
        }
    }

    protected @Nullable Tag removeBackupTag(CompoundTag customData, String tagName) {
        return customData.remove(this.nbtTagName(tagName));
    }

    protected void removeCustomTag(StructuredDataContainer data, CompoundTag customData) {
        if (customData.size() == 1 && customData.contains(MARKER_KEY)) {
            data.remove(StructuredDataKey.CUSTOM_DATA);
        }
    }

    protected void passthroughLengthPrefixedItem(PacketWrapper wrapper) {
        Item item = this.handleItemToServer(wrapper.user(), wrapper.read(this.protocol.mappedTypes().lengthPrefixedItem()));
        wrapper.write(this.protocol.types().lengthPrefixedItem(), item);
    }

    private void replaceAnnoyingKeys(StructuredDataContainer container, VersionedTypesHolder types, VersionedTypesHolder mappedTypes) {
        List<StructuredDataKey<?>> keys = types.structuredDataKeys().keys();
        List<StructuredDataKey<?>> mappedKeys = mappedTypes.structuredDataKeys().keys();
        int minSize = Math.min(keys.size(), mappedKeys.size());
        for (int i2 = 0; i2 < minSize; ++i2) {
            StructuredDataKey<?> key = keys.get(i2);
            StructuredDataKey<?> mappedKey = mappedKeys.get(i2);
            StructuredItemRewriter.replaceKeyUnchecked(container, key, mappedKey);
        }
    }

    private static <T> void replaceKeyUnchecked(StructuredDataContainer container, StructuredDataKey<T> key, StructuredDataKey<?> mappedKey) {
        Preconditions.checkArgument((key.type().getOutputClass() == mappedKey.type().getOutputClass() ? 1 : 0) != 0, (String)"Type mismatch: %s vs %s", (Object[])new Object[]{key, mappedKey});
        container.replaceKey(key, mappedKey);
    }

    public void registerSetCreativeModeSlot1_21_5(S packetType) {
        this.protocol.registerServerbound(packetType, wrapper -> {
            if (!this.protocol.getEntityRewriter().tracker(wrapper.user()).canInstaBuild()) {
                wrapper.cancel();
                return;
            }
            wrapper.passthrough(Types.SHORT);
            this.passthroughLengthPrefixedItem(wrapper);
        });
    }

    @FunctionalInterface
    @NestHost(value=StructuredItemRewriter.class)
    private static interface ItemHandler {
        public Item rewrite(UserConnection var1, Item var2);
    }
}

