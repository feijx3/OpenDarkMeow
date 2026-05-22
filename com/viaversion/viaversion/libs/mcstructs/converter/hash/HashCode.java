/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.hash;

public class HashCode {
    private static final String HEX_CHARS = "0123456789abcdef";
    private final int hashCode;

    public static HashCode of(int hashCode) {
        return new HashCode(hashCode);
    }

    private HashCode(int hashCode) {
        this.hashCode = hashCode;
    }

    public byte[] asBytes() {
        return new byte[]{(byte)this.hashCode, (byte)(this.hashCode >> 8), (byte)(this.hashCode >> 16), (byte)(this.hashCode >> 24)};
    }

    public int asInt() {
        return this.hashCode;
    }

    public long asLong() {
        return (long)this.hashCode & 0xFFFFFFFFL;
    }

    public String toString() {
        byte[] bytes = this.asBytes();
        char[] chars = new char[bytes.length * 2];
        for (int i2 = 0; i2 < bytes.length; ++i2) {
            byte b2 = bytes[i2];
            chars[i2 * 2] = HEX_CHARS.charAt(b2 >> 4 & 0xF);
            chars[i2 * 2 + 1] = HEX_CHARS.charAt(b2 & 0xF);
        }
        return new String(chars);
    }
}

