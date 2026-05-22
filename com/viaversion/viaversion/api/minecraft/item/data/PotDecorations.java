/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.Copyable;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={1.class})
public final class PotDecorations
implements Copyable,
Rewritable {
    public static final Type<PotDecorations> TYPE = new Type<PotDecorations>(PotDecorations.class){

        @Override
        public PotDecorations read(ByteBuf buffer) {
            return new PotDecorations((int[])Types.VAR_INT_ARRAY_PRIMITIVE.read(buffer));
        }

        @Override
        public void write(ByteBuf buffer, PotDecorations value) {
            Types.VAR_INT_ARRAY_PRIMITIVE.write(buffer, value.itemIds());
        }
    };
    private final int[] itemIds;

    public PotDecorations(int[] itemIds) {
        this.itemIds = itemIds;
    }

    public PotDecorations(int backItem, int leftItem, int rightItem, int frontItem) {
        this.itemIds = new int[]{backItem, leftItem, rightItem, frontItem};
    }

    public int[] itemIds() {
        return this.itemIds;
    }

    public int backItem() {
        return this.item(0);
    }

    public int leftItem() {
        return this.item(1);
    }

    public int rightItem() {
        return this.item(2);
    }

    public int frontItem() {
        return this.item(3);
    }

    private int item(int index) {
        return index < 0 || index >= this.itemIds.length ? -1 : this.itemIds[index];
    }

    @Override
    public PotDecorations rewrite(UserConnection connection, Protocol<?, ?, ?, ?> protocol, boolean clientbound) {
        int[] newItems = new int[this.itemIds.length];
        for (int i2 = 0; i2 < this.itemIds.length; ++i2) {
            newItems[i2] = Rewritable.rewriteItem(protocol, clientbound, this.itemIds[i2]);
        }
        return new PotDecorations(newItems);
    }

    @Override
    public PotDecorations copy() {
        return new PotDecorations(Copyable.copy(this.itemIds));
    }
}

