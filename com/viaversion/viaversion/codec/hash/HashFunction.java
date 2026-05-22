/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.codec.hash;

import com.viaversion.viaversion.codec.hash.CRC32C;

@FunctionalInterface
public interface HashFunction {
    public static final HashFunction CRC32C = new CRC32C();

    public int hashBytes(byte[] var1, int var2);

    default public int hashBytes(byte[] data) {
        return this.hashBytes(data, data.length);
    }
}

