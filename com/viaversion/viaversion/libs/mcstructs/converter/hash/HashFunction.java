/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.hash;

import com.viaversion.viaversion.libs.mcstructs.converter.hash.HashBuilder;
import com.viaversion.viaversion.libs.mcstructs.converter.hash.HashCode;
import com.viaversion.viaversion.libs.mcstructs.converter.hash.function.CRC32C;

public abstract class HashFunction {
    public static final HashFunction CRC32C = new CRC32C();

    public abstract HashCode hash(byte[] var1);

    public HashBuilder builder() {
        return new HashBuilder(this);
    }

    public HashBuilder builder(int initialSize) {
        return new HashBuilder(this, initialSize);
    }
}

