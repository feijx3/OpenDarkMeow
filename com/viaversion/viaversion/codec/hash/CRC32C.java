/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.codec.hash;

import com.viaversion.viaversion.codec.hash.HashFunction;

final class CRC32C
implements HashFunction {
    private static final int[] CRC32C_TABLE = new int[256];

    CRC32C() {
    }

    @Override
    public int hashBytes(byte[] data, int length) {
        int crc = -1;
        for (int i2 = 0; i2 < length; ++i2) {
            byte b2 = data[i2];
            int index = (crc ^ b2) & 0xFF;
            crc = crc >>> 8 ^ CRC32C_TABLE[index];
        }
        return ~crc;
    }

    static {
        for (int i2 = 0; i2 < 256; ++i2) {
            int crc = i2;
            for (int j2 = 0; j2 < 8; ++j2) {
                if ((crc & 1) == 1) {
                    crc = crc >>> 1 ^ 0x82F63B78;
                    continue;
                }
                crc >>>= 1;
            }
            CRC32C.CRC32C_TABLE[i2] = crc;
        }
    }
}

