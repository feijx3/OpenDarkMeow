/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  io.netty.buffer.ByteBuf
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.api.type.types;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import java.nio.charset.StandardCharsets;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={OptionalStringType.class})
public class StringType
extends Type<String> {
    private static final int MAX_CHAR_UTF_8_LENGTH = Character.toString('\uffff').getBytes(StandardCharsets.UTF_8).length;
    private final int maxLength;

    public StringType() {
        this(Short.MAX_VALUE);
    }

    public StringType(int maxLength) {
        super(String.class);
        this.maxLength = maxLength;
    }

    @Override
    public String read(ByteBuf buffer) {
        int len = Types.VAR_INT.readPrimitive(buffer);
        Preconditions.checkArgument((len <= this.maxLength * MAX_CHAR_UTF_8_LENGTH ? 1 : 0) != 0, (String)StringType.jvmdowngrader$concat$read$1(this.maxLength, MAX_CHAR_UTF_8_LENGTH), (Object[])new Object[]{len});
        String string = buffer.toString(buffer.readerIndex(), len, StandardCharsets.UTF_8);
        buffer.skipBytes(len);
        Preconditions.checkArgument((string.length() <= this.maxLength ? 1 : 0) != 0, (String)StringType.jvmdowngrader$concat$read$1(this.maxLength), (Object[])new Object[]{string.length()});
        return string;
    }

    @Override
    public void write(ByteBuf buffer, String object) {
        if (object.length() > this.maxLength) {
            throw new IllegalArgumentException(StringType.jvmdowngrader$concat$write$1(this.maxLength, object.length()));
        }
        byte[] b2 = object.getBytes(StandardCharsets.UTF_8);
        Types.VAR_INT.writePrimitive(buffer, b2.length);
        buffer.writeBytes(b2);
    }

    @Override
    public void write(Ops ops, String value) {
        ops.writeString(value);
    }

    private static String jvmdowngrader$concat$read$1(int n2, int n3) {
        return "Cannot receive string longer than " + n2 + " * " + n3 + " bytes (got %s bytes)";
    }

    private static String jvmdowngrader$concat$read$1(int n2) {
        return "Cannot receive string longer than " + n2 + " characters (got %s bytes)";
    }

    private static String jvmdowngrader$concat$write$1(int n2, int n3) {
        return "Cannot send string longer than " + n2 + " characters (got " + n3 + " characters)";
    }

    @NestHost(value=StringType.class)
    public static final class OptionalStringType
    extends OptionalType<String> {
        public OptionalStringType() {
            super(Types.STRING);
        }
    }
}

