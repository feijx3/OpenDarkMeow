/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.metadata.tiff;

final class Unknown {
    private final short type;
    private final int count;
    private final long pos;

    public Unknown(short s2, int n2, long l2) {
        this.type = s2;
        this.count = n2;
        this.pos = l2;
    }

    public int hashCode() {
        return (int)(this.pos ^ this.pos >>> 32) + this.count * 37 + this.type * 97;
    }

    public boolean equals(Object object) {
        if (object != null && object.getClass() == this.getClass()) {
            Unknown unknown = (Unknown)object;
            return this.pos == unknown.pos && this.type == unknown.type && this.count == unknown.count;
        }
        return false;
    }

    public String toString() {
        if (this.count == 1) {
            return String.format("Unknown(%d)@%08x", this.type, this.pos);
        }
        return String.format("Unknown(%d)[%d]@%08x", this.type, this.count, this.pos);
    }
}

