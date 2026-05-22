/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  io.netty.buffer.ByteBuf
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.api.type.types.item;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.StructuredItem;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.item.StructuredDataTypeBase;
import com.viaversion.viaversion.libs.fastutil.objects.Reference2ObjectOpenHashMap;
import com.viaversion.viaversion.util.Key;
import io.netty.buffer.ByteBuf;
import java.util.Map;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={OptionalItemType.class})
public class ItemType1_20_5
extends Type<Item> {
    private final StructuredDataTypeBase dataType;

    public ItemType1_20_5(StructuredDataTypeBase dataType) {
        super(Item.class);
        this.dataType = dataType;
    }

    @Override
    public Item read(ByteBuf buffer) {
        int amount = Types.VAR_INT.readPrimitive(buffer);
        if (amount <= 0) {
            return StructuredItem.empty();
        }
        int id = Types.VAR_INT.readPrimitive(buffer);
        Map<StructuredDataKey<?>, StructuredData<?>> data = this.readData(buffer);
        return new StructuredItem(id, amount, new StructuredDataContainer(data));
    }

    private Map<StructuredDataKey<?>, StructuredData<?>> readData(ByteBuf buffer) {
        StructuredDataKey<?> key;
        int i2;
        int valuesSize = Types.VAR_INT.readPrimitive(buffer);
        int markersSize = Types.VAR_INT.readPrimitive(buffer);
        if (valuesSize == 0 && markersSize == 0) {
            return new Reference2ObjectOpenHashMap(0);
        }
        Reference2ObjectOpenHashMap map = new Reference2ObjectOpenHashMap(Math.min(valuesSize + markersSize, 128));
        for (i2 = 0; i2 < valuesSize; ++i2) {
            StructuredData<?> value = this.dataType.read(buffer);
            key = this.dataType.key(value.id());
            Preconditions.checkNotNull(key, (String)"No data component serializer found for %s", (Object[])new Object[]{value});
            map.put(key, value);
        }
        for (i2 = 0; i2 < markersSize; ++i2) {
            int id = Types.VAR_INT.readPrimitive(buffer);
            key = this.dataType.key(id);
            Preconditions.checkNotNull(key, (String)"No data component serializer found for empty id %s", (Object[])new Object[]{id});
            map.put(key, StructuredData.empty(key, id));
        }
        return map;
    }

    @Override
    public void write(ByteBuf buffer, Item object) {
        if (object.isEmpty()) {
            Types.VAR_INT.writePrimitive(buffer, 0);
            return;
        }
        Types.VAR_INT.writePrimitive(buffer, object.amount());
        Types.VAR_INT.writePrimitive(buffer, object.identifier());
        Map<StructuredDataKey<?>, StructuredData<?>> data = object.dataContainer().data();
        int valuesSize = 0;
        int markersSize = 0;
        for (StructuredData<?> value : data.values()) {
            if (value.isPresent()) {
                ++valuesSize;
                continue;
            }
            ++markersSize;
        }
        Types.VAR_INT.writePrimitive(buffer, valuesSize);
        Types.VAR_INT.writePrimitive(buffer, markersSize);
        for (StructuredData<?> value : data.values()) {
            if (!value.isPresent()) continue;
            this.dataType.write(buffer, value);
        }
        for (StructuredData<?> value : data.values()) {
            if (!value.isEmpty()) continue;
            Types.VAR_INT.writePrimitive(buffer, value.id());
        }
    }

    @Override
    public void write(Ops ops, Item item) {
        ops.writeMap(map -> {
            map.write("id", Types.RESOURCE_LOCATION, ops.context().registryAccess().item(item.identifier())).write("count", Types.VAR_INT, item.amount());
            if (item.dataContainer().isEmpty()) {
                return;
            }
            map.writeMap("components", components -> {
                for (Map.Entry<StructuredDataKey<?>, StructuredData<?>> entry : item.dataContainer().data().entrySet()) {
                    StructuredData<?> data = entry.getValue();
                    String key = Key.namespaced(data.key().identifier());
                    if (data.isEmpty()) {
                        key = ItemType1_20_5.jvmdowngrader$concat$lambda$write$0$1(key);
                    }
                    components.write(key, (Type)((Object)this.dataType), data);
                }
            });
        });
    }

    private static String jvmdowngrader$concat$lambda$write$0$1(String string) {
        return "!" + string;
    }

    @NestHost(value=ItemType1_20_5.class)
    public final class OptionalItemType
    extends OptionalType<Item> {
        public OptionalItemType() {
            super(ItemType1_20_5.this);
        }
    }
}

