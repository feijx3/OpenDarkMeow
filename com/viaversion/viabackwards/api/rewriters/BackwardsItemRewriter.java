/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 */
package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.MappedItem;
import com.viaversion.viabackwards.api.rewriters.BackwardsItemRewriterBase;
import com.viaversion.viabackwards.item.DataItemWithExtras;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.libs.gson.JsonElement;
import java.util.List;
import org.checkerframework.checker.nullness.qual.Nullable;

public class BackwardsItemRewriter<C extends ClientboundPacketType, S extends ServerboundPacketType, T extends BackwardsProtocol<C, ?, ?, S>>
extends BackwardsItemRewriterBase<C, S, T> {
    public BackwardsItemRewriter(T protocol, Type<Item> itemType, Type<Item[]> itemArrayType) {
        super(protocol, itemType, itemArrayType, true);
    }

    public BackwardsItemRewriter(T protocol, Type<Item> itemType, Type<Item[]> itemArrayType, Type<Item> mappedItemType, Type<Item[]> mappedItemArrayType) {
        super(protocol, itemType, itemArrayType, mappedItemType, mappedItemArrayType, true);
    }

    @Override
    public @Nullable Item handleItemToClient(UserConnection connection, @Nullable Item item) {
        MappedItem data;
        CompoundTag display;
        if (item == null) {
            return null;
        }
        CompoundTag compoundTag = display = item.tag() != null ? item.tag().getCompoundTag("display") : null;
        if (((BackwardsProtocol)this.protocol).getComponentRewriter() != null && display != null) {
            List<JsonElement> lore;
            DataItemWithExtras fullItem;
            if (item instanceof DataItemWithExtras) {
                fullItem = (DataItemWithExtras)item;
            } else {
                fullItem = new DataItemWithExtras(item);
                item = fullItem;
            }
            JsonElement name = fullItem.name();
            if (name != null) {
                JsonElement updatedName = name.deepCopy();
                ((BackwardsProtocol)this.protocol).getComponentRewriter().processText(connection, updatedName);
                if (!updatedName.equals(name)) {
                    StringTag rawName = fullItem.rawName();
                    this.saveStringTag(display, rawName, "Name");
                    rawName.setValue(updatedName.toString());
                }
            }
            if ((lore = fullItem.lore()) != null) {
                boolean changed = false;
                ListTag<StringTag> rawLore = fullItem.rawLore();
                for (int i2 = 0; i2 < lore.size(); ++i2) {
                    JsonElement loreEntry = lore.get(i2);
                    JsonElement updatedLoreEntry = loreEntry.deepCopy();
                    ((BackwardsProtocol)this.protocol).getComponentRewriter().processText(connection, updatedLoreEntry);
                    if (updatedLoreEntry.equals(loreEntry)) continue;
                    if (!changed) {
                        changed = true;
                        this.saveListTag(display, rawLore, "Lore");
                    }
                    StringTag rawLoreEntry = rawLore.get(i2);
                    rawLoreEntry.setValue(updatedLoreEntry.toString());
                }
            }
        }
        MappedItem mappedItem = data = ((BackwardsProtocol)this.protocol).getMappingData() != null ? ((BackwardsProtocol)this.protocol).getMappingData().getMappedItem(item.identifier()) : null;
        if (data == null) {
            return super.handleItemToClient(connection, item);
        }
        if (item.tag() == null) {
            item.setTag(new CompoundTag());
        }
        item.tag().putInt(this.nbtTagName("id"), item.identifier());
        item.setIdentifier(data.id());
        if (data.customModelData() != null && !item.tag().contains("CustomModelData")) {
            item.tag().putInt("CustomModelData", data.customModelData());
        }
        if (display == null) {
            display = new CompoundTag();
            item.tag().put("display", display);
        }
        if (!display.contains("Name")) {
            display.put("Name", new StringTag(data.jsonName()));
            display.put(this.nbtTagName("customName"), new ByteTag(false));
        }
        return item;
    }

    @Override
    public @Nullable Item handleItemToServer(UserConnection connection, @Nullable Item item) {
        Tag originalId;
        if (item == null) {
            return null;
        }
        super.handleItemToServer(connection, item);
        if (item.tag() != null && (originalId = item.tag().remove(this.nbtTagName("id"))) instanceof IntTag) {
            item.setIdentifier(((NumberTag)originalId).asInt());
        }
        return item;
    }
}

