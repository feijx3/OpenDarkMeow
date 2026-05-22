/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.hash.function;

import com.viaversion.viaversion.libs.mcstructs.converter.hash.HashCode;
import com.viaversion.viaversion.libs.mcstructs.converter.hash.HashFunction;

public class CRC32C
extends HashFunction {
    private static final int[] CRC32C_TABLE = new int[256];

    @Override
    public HashCode hash(byte[] data) {
        int crc = -1;
        for (byte b2 : data) {
            int index = (crc ^ b2) & 0xFF;
            crc = crc >>> 8 ^ CRC32C_TABLE[index];
        }
        return HashCode.of(~crc);
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
            com.viaversion.viaversion.libs.mcstructs.converter.hash.function.CRC32C.CRC32C_TABLE[i2] = crc;
        }
    }
}

