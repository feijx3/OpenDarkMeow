/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 */
package com.viaversion.viaversion.api.type.types.item;

import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.item.BaseItemArrayType;
import io.netty.buffer.ByteBuf;

public class ItemShortArrayType1_8
extends BaseItemArrayType {
    @Override
    public Item[] read(ByteBuf buffer) {
        int amount = Types.SHORT.readPrimitive(buffer);
        Item[] array = new Item[amount];
        for (int i2 = 0; i2 < amount; ++i2) {
            array[i2] = (Item)Types.ITEM1_8.read(buffer);
        }
        return array;
    }

    @Override
    public void write(ByteBuf buffer, Item[] object) {
        Types.SHORT.writePrimitive(buffer, (short)object.length);
        for (Item o2 : object) {
            Types.ITEM1_8.write(buffer, o2);
        }
    }
}

