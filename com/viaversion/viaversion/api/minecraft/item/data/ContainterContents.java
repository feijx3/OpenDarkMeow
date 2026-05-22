/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={ContainerContentsType.class})
public final class ContainterContents {

    @NestHost(value=ContainterContents.class)
    public static final class ContainerContentsType
    extends ArrayType<Item> {
        private final Type<Item> itemType;

        public ContainerContentsType(Type<Item> itemType) {
            super(itemType, 256);
            this.itemType = itemType;
        }

        @Override
        public void write(Ops ops, Item[] value) {
            ops.writeList(list -> {
                int i2 = 0;
                while (i2 < value.length) {
                    Item item = value[i2];
                    int slot = i2++;
                    list.writeMap(map -> map.write("slot", Types.INT, slot).write("item", this.itemType, item));
                }
            });
        }
    }
}

