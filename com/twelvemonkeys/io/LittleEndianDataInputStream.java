/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.io;

import com.twelvemonkeys.lang.Validate;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UTFDataFormatException;

public class LittleEndianDataInputStream
extends FilterInputStream
implements DataInput {
    public LittleEndianDataInputStream(InputStream inputStream) {
        super(Validate.notNull(inputStream, "stream"));
    }

    @Override
    public boolean readBoolean() throws IOException {
        int n2 = this.in.read();
        if (n2 < 0) {
            throw new EOFException();
        }
        return n2 != 0;
    }

    @Override
    public byte readByte() throws IOException {
        int n2 = this.in.read();
        if (n2 < 0) {
            throw new EOFException();
        }
        return (byte)n2;
    }

    @Override
    public int readUnsignedByte() throws IOException {
        int n2 = this.in.read();
        if (n2 < 0) {
            throw new EOFException();
        }
        return n2;
    }

    @Override
    public short readShort() throws IOException {
        int n2 = this.in.read();
        int n3 = this.in.read();
        if (n3 < 0) {
            throw new EOFException();
        }
        return (short)(n3 << 24 >>> 16 | n2 << 24 >>> 24);
    }

    @Override
    public int readUnsignedShort() throws IOException {
        int n2 = this.in.read();
        int n3 = this.in.read();
        if (n3 < 0) {
            throw new EOFException();
        }
        return (n3 << 8) + n2;
    }

    @Override
    public char readChar() throws IOException {
        int n2 = this.in.read();
        int n3 = this.in.read();
        if (n3 < 0) {
            throw new EOFException();
        }
        return (char)(n3 << 24 >>> 16 | n2 << 24 >>> 24);
    }

    @Override
    public int readInt() throws IOException {
        int n2 = this.in.read();
        int n3 = this.in.read();
        int n4 = this.in.read();
        int n5 = this.in.read();
        if (n5 < 0) {
            throw new EOFException();
        }
        return n5 << 24 | n4 << 24 >>> 8 | n3 << 24 >>> 16 | n2 << 24 >>> 24;
    }

    @Override
    public long readLong() throws IOException {
        long l2 = this.in.read();
        long l3 = this.in.read();
        long l4 = this.in.read();
        long l5 = this.in.read();
        long l6 = this.in.read();
        long l7 = this.in.read();
        long l8 = this.in.read();
        long l9 = this.in.read();
        if (l9 < 0L) {
            throw new EOFException();
        }
        return l9 << 56 | l8 << 56 >>> 8 | l7 << 56 >>> 16 | l6 << 56 >>> 24 | l5 << 56 >>> 32 | l4 << 56 >>> 40 | l3 << 56 >>> 48 | l2 << 56 >>> 56;
    }

    @Override
    public String readUTF() throws IOException {
        int n2 = this.in.read();
        int n3 = this.in.read();
        if (n3 < 0) {
            throw new EOFException();
        }
        int n4 = (n2 << 8) + n3;
        char[] cArray = new char[n4];
        int n5 = 0;
        int n6 = 0;
        while (n5 < n4) {
            int n7;
            int n8 = this.readUnsignedByte();
            int n9 = n8 >> 4;
            if (n9 < 8) {
                ++n5;
                cArray[n6++] = (char)n8;
                continue;
            }
            if (n9 == 12 || n9 == 13) {
                if ((n5 += 2) > n4) {
                    throw new UTFDataFormatException();
                }
                n7 = this.readUnsignedByte();
                if ((n7 & 0xC0) != 128) {
                    throw new UTFDataFormatException();
                }
                cArray[n6++] = (char)((n8 & 0x1F) << 6 | n7 & 0x3F);
                continue;
            }
            if (n9 == 14) {
                if ((n5 += 3) > n4) {
                    throw new UTFDataFormatException();
                }
                n7 = this.readUnsignedByte();
                int n10 = this.readUnsignedByte();
                if ((n7 & 0xC0) != 128 || (n10 & 0xC0) != 128) {
                    throw new UTFDataFormatException();
                }
                cArray[n6++] = (char)((n8 & 0xF) << 12 | (n7 & 0x3F) << 6 | n10 & 0x3F);
                continue;
            }
            throw new UTFDataFormatException();
        }
        return new String(cArray, 0, n6);
    }

    @Override
    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(this.readLong());
    }

    @Override
    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(this.readInt());
    }

    @Override
    public final int skipBytes(int n2) throws IOException {
        int n3;
        int n4;
        for (n3 = 0; n3 < n2 && (n4 = (int)this.in.skip(n2 - n3)) > 0; n3 += n4) {
        }
        return n3;
    }

    @Override
    public final void readFully(byte[] byArray) throws IOException {
        this.readFully(byArray, 0, byArray.length);
    }

    @Override
    public final void readFully(byte[] byArray, int n2, int n3) throws IOException {
        int n4;
        if (n3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        for (int i2 = 0; i2 < n3; i2 += n4) {
            n4 = this.in.read(byArray, n2 + i2, n3 - i2);
            if (n4 >= 0) continue;
            throw new EOFException();
        }
    }

    @Override
    @Deprecated
    public String readLine() throws IOException {
        DataInputStream dataInputStream = new DataInputStream(this.in);
        return dataInputStream.readLine();
    }
}

