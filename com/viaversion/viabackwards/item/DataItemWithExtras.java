/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 */
package com.viaversion.viabackwards.item;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.api.minecraft.item.DataItem;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonParser;
import com.viaversion.viaversion.libs.gson.JsonPrimitive;
import com.viaversion.viaversion.libs.gson.JsonSyntaxException;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class DataItemWithExtras
extends DataItem {
    private JsonElement name;
    private List<JsonElement> lore;

    public DataItemWithExtras(Item from) {
        ListTag<StringTag> lore;
        this.setIdentifier(from.identifier());
        this.setAmount(from.amount());
        this.setData(from.data());
        this.setTag(from.tag());
        if (this.tag() == null) {
            return;
        }
        CompoundTag display = this.tag().getCompoundTag("display");
        if (display == null) {
            return;
        }
        StringTag name = display.getStringTag("Name");
        if (name != null) {
            this.name = this.parse(name.getValue());
        }
        if ((lore = display.getListTag("Lore", StringTag.class)) != null) {
            this.lore = new ArrayList<JsonElement>(lore.size());
            for (int i2 = 0; i2 < lore.size(); ++i2) {
                this.lore.add(this.parse(lore.get(i2).getValue()));
            }
        }
    }

    public @Nullable JsonElement name() {
        return this.name;
    }

    public @Nullable StringTag rawName() {
        if (this.tag() == null) {
            return null;
        }
        CompoundTag display = this.tag().getCompoundTag("display");
        return display != null ? display.getStringTag("Name") : null;
    }

    public @Nullable List<JsonElement> lore() {
        return this.lore;
    }

    public @Nullable ListTag<StringTag> rawLore() {
        if (this.tag() == null) {
            return null;
        }
        CompoundTag display = this.tag().getCompoundTag("display");
        return display != null ? display.getListTag("Lore", StringTag.class) : null;
    }

    private JsonElement parse(String value) {
        try {
            return JsonParser.parseString(value);
        }
        catch (JsonSyntaxException e2) {
            return new JsonPrimitive(value);
        }
    }
}

