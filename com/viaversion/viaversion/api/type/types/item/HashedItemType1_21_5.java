/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 */
package com.viaversion.viaversion.api.type.types.item;

import com.viaversion.viaversion.api.minecraft.item.HashedItem;
import com.viaversion.viaversion.api.minecraft.item.HashedStructuredItem;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntOpenHashMap;
import com.viaversion.viaversion.libs.fastutil.ints.IntOpenHashSet;
import com.viaversion.viaversion.util.Limit;
import io.netty.buffer.ByteBuf;
import java.util.Iterator;

public class HashedItemType1_21_5
extends Type<HashedItem> {
    public HashedItemType1_21_5() {
        super(HashedItem.class);
    }

    @Override
    public HashedItem read(ByteBuf buffer) {
        if (!buffer.readBoolean()) {
            return HashedStructuredItem.empty();
        }
        int id = Types.VAR_INT.readPrimitive(buffer);
        int amount = Types.VAR_INT.readPrimitive(buffer);
        int addedComponentsSize = Limit.max(Types.VAR_INT.readPrimitive(buffer), 256);
        Int2IntOpenHashMap dataHashes = new Int2IntOpenHashMap(addedComponentsSize);
        for (int i2 = 0; i2 < addedComponentsSize; ++i2) {
            int dataType = Types.VAR_INT.readPrimitive(buffer);
            int hash = Types.INT.readPrimitive(buffer);
            dataHashes.put(dataType, hash);
        }
        int removedComponentsSize = Limit.max(Types.VAR_INT.readPrimitive(buffer), 256);
        IntOpenHashSet removedData = new IntOpenHashSet(removedComponentsSize);
        for (int i3 = 0; i3 < removedComponentsSize; ++i3) {
            int dataType = Types.VAR_INT.readPrimitive(buffer);
            removedData.add(dataType);
        }
        return new HashedStructuredItem(id, amount, dataHashes, removedData);
    }

    @Override
    public void write(ByteBuf buffer, HashedItem value) {
        if (value.isEmpty()) {
            buffer.writeBoolean(false);
            return;
        }
        buffer.writeBoolean(true);
        Types.VAR_INT.writePrimitive(buffer, value.identifier());
        Types.VAR_INT.writePrimitive(buffer, value.amount());
        Types.VAR_INT.writePrimitive(buffer, value.dataHashesById().size());
        for (Int2IntMap.Entry entry : value.dataHashesById().int2IntEntrySet()) {
            Types.VAR_INT.writePrimitive(buffer, entry.getIntKey());
            Types.INT.writePrimitive(buffer, entry.getIntValue());
        }
        Types.VAR_INT.writePrimitive(buffer, value.removedDataIds().size());
        Iterator iterator2 = value.removedDataIds().iterator();
        while (iterator2.hasNext()) {
            int removedDataId = (Integer)iterator2.next();
            Types.VAR_INT.writePrimitive(buffer, removedDataId);
        }
    }
}

