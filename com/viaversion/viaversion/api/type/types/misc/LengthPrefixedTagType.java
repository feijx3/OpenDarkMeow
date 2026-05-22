/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  io.netty.buffer.ByteBuf
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.google.common.base.Preconditions;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public final class LengthPrefixedTagType
extends Type<Tag> {
    private final int maxLength;

    public LengthPrefixedTagType(int maxLength) {
        super(Tag.class);
        this.maxLength = maxLength;
    }

    @Override
    public Tag read(ByteBuf buffer) {
        int length = Types.VAR_INT.readPrimitive(buffer);
        Preconditions.checkArgument((length <= this.maxLength ? 1 : 0) != 0, (String)"Cannot receive tag longer than %s bytes (got %s bytes)", (Object[])new Object[]{this.maxLength, length});
        return (Tag)Types.TAG.read(buffer.readSlice(length));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(ByteBuf buffer, Tag tag) {
        ByteBuf tempBuf = buffer.alloc().buffer();
        try {
            Types.TAG.write(tempBuf, tag);
            Preconditions.checkArgument((tempBuf.readableBytes() <= this.maxLength ? 1 : 0) != 0, (String)"Cannot send tag longer than %s bytes (got %s bytes)", (Object[])new Object[]{this.maxLength, tempBuf.readableBytes()});
            Types.VAR_INT.writePrimitive(buffer, tempBuf.readableBytes());
            buffer.writeBytes(tempBuf);
        }
        finally {
            tempBuf.release();
        }
    }
}

