/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  io.netty.buffer.ByteBuf
 */
package com.viaversion.viaversion.api.type.types;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.BitSet;

public class BitSetType
extends Type<BitSet> {
    private final int length;
    private final int bytesLength;

    public BitSetType(int length) {
        super(BitSet.class);
        this.length = length;
        this.bytesLength = (int)Math.ceil((double)length / 8.0);
    }

    @Override
    public BitSet read(ByteBuf buffer) {
        byte[] bytes = new byte[this.bytesLength];
        buffer.readBytes(bytes);
        return BitSet.valueOf(bytes);
    }

    @Override
    public void write(ByteBuf buffer, BitSet object) {
        Preconditions.checkArgument((object.length() <= this.length ? 1 : 0) != 0, (String)"BitSet of length %s larger than max length %s", (Object[])new Object[]{object.length(), this.length});
        byte[] bytes = object.toByteArray();
        buffer.writeBytes(bytes.length == this.bytesLength ? bytes : Arrays.copyOf(bytes, this.bytesLength));
    }
}

