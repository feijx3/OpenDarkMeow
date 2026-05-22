/*
 * Decompiled with CFR 0.152.
 */
package org.joml;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.text.NumberFormat;
import org.joml.Math;
import org.joml.MemUtil;
import org.joml.Options;
import org.joml.Runtime;
import org.joml.Vector2ic;
import org.joml.Vector3fc;
import org.joml.Vector3ic;
import org.joml.Vector4dc;
import org.joml.Vector4fc;
import org.joml.Vector4ic;

public class Vector4i
implements Externalizable,
Cloneable,
Vector4ic {
    private static final long serialVersionUID = 1L;
    public int x;
    public int y;
    public int z;
    public int w;

    public Vector4i() {
        this.w = 1;
    }

    public Vector4i(Vector4ic v2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = v2.z();
        this.w = v2.w();
    }

    public Vector4i(Vector3ic v2, int w2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = v2.z();
        this.w = w2;
    }

    public Vector4i(Vector2ic v2, int z2, int w2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = z2;
        this.w = w2;
    }

    public Vector4i(Vector3fc v2, float w2, int mode) {
        this.x = Math.roundUsing(v2.x(), mode);
        this.y = Math.roundUsing(v2.y(), mode);
        this.z = Math.roundUsing(v2.z(), mode);
        w2 = Math.roundUsing(w2, mode);
    }

    public Vector4i(Vector4fc v2, int mode) {
        this.x = Math.roundUsing(v2.x(), mode);
        this.y = Math.roundUsing(v2.y(), mode);
        this.z = Math.roundUsing(v2.z(), mode);
        this.w = Math.roundUsing(v2.w(), mode);
    }

    public Vector4i(Vector4dc v2, int mode) {
        this.x = Math.roundUsing(v2.x(), mode);
        this.y = Math.roundUsing(v2.y(), mode);
        this.z = Math.roundUsing(v2.z(), mode);
        this.w = Math.roundUsing(v2.w(), mode);
    }

    public Vector4i(int s2) {
        this.x = s2;
        this.y = s2;
        this.z = s2;
        this.w = s2;
    }

    public Vector4i(int x2, int y2, int z2, int w2) {
        this.x = x2;
        this.y = y2;
        this.z = z2;
        this.w = w2;
    }

    public Vector4i(int[] xyzw) {
        this.x = xyzw[0];
        this.y = xyzw[1];
        this.z = xyzw[2];
        this.w = xyzw[3];
    }

    public Vector4i(ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
    }

    public Vector4i(int index, ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
    }

    public Vector4i(IntBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
    }

    public Vector4i(int index, IntBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }

    public int z() {
        return this.z;
    }

    public int w() {
        return this.w;
    }

    public Vector4i set(Vector4ic v2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = v2.z();
        this.w = v2.w();
        return this;
    }

    public Vector4i set(Vector4dc v2) {
        this.x = (int)v2.x();
        this.y = (int)v2.y();
        this.z = (int)v2.z();
        this.w = (int)v2.w();
        return this;
    }

    public Vector4i set(Vector4dc v2, int mode) {
        this.x = Math.roundUsing(v2.x(), mode);
        this.y = Math.roundUsing(v2.y(), mode);
        this.z = Math.roundUsing(v2.z(), mode);
        this.w = Math.roundUsing(v2.w(), mode);
        return this;
    }

    public Vector4i set(Vector4fc v2, int mode) {
        this.x = Math.roundUsing(v2.x(), mode);
        this.y = Math.roundUsing(v2.y(), mode);
        this.z = Math.roundUsing(v2.z(), mode);
        this.w = Math.roundUsing(v2.w(), mode);
        return this;
    }

    public Vector4i set(Vector3ic v2, int w2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = v2.z();
        this.w = w2;
        return this;
    }

    public Vector4i set(Vector2ic v2, int z2, int w2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = z2;
        this.w = w2;
        return this;
    }

    public Vector4i set(int s2) {
        this.x = s2;
        this.y = s2;
        this.z = s2;
        this.w = s2;
        return this;
    }

    public Vector4i set(int x2, int y2, int z2, int w2) {
        this.x = x2;
        this.y = y2;
        this.z = z2;
        this.w = w2;
        return this;
    }

    public Vector4i set(int[] xyzw) {
        this.x = xyzw[0];
        this.y = xyzw[1];
        this.z = xyzw[2];
        this.w = xyzw[3];
        return this;
    }

    public Vector4i set(ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
        return this;
    }

    public Vector4i set(int index, ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
        return this;
    }

    public Vector4i set(IntBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
        return this;
    }

    public Vector4i set(int index, IntBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
        return this;
    }

    public Vector4i setFromAddress(long address) {
        if (Options.NO_UNSAFE) {
            throw new UnsupportedOperationException("Not supported when using joml.nounsafe");
        }
        MemUtil.MemUtilUnsafe.get(this, address);
        return this;
    }

    public int get(int component) throws IllegalArgumentException {
        switch (component) {
            case 0: {
                return this.x;
            }
            case 1: {
                return this.y;
            }
            case 2: {
                return this.z;
            }
            case 3: {
                return this.w;
            }
        }
        throw new IllegalArgumentException();
    }

    public int maxComponent() {
        int absX = Math.abs(this.x);
        int absY = Math.abs(this.y);
        int absZ = Math.abs(this.z);
        int absW = Math.abs(this.w);
        if (absX >= absY && absX >= absZ && absX >= absW) {
            return 0;
        }
        if (absY >= absZ && absY >= absW) {
            return 1;
        }
        if (absZ >= absW) {
            return 2;
        }
        return 3;
    }

    public int minComponent() {
        int absX = Math.abs(this.x);
        int absY = Math.abs(this.y);
        int absZ = Math.abs(this.z);
        int absW = Math.abs(this.w);
        if (absX < absY && absX < absZ && absX < absW) {
            return 0;
        }
        if (absY < absZ && absY < absW) {
            return 1;
        }
        if (absZ < absW) {
            return 2;
        }
        return 3;
    }

    public Vector4i setComponent(int component, int value) throws IllegalArgumentException {
        switch (component) {
            case 0: {
                this.x = value;
                break;
            }
            case 1: {
                this.y = value;
                break;
            }
            case 2: {
                this.z = value;
                break;
            }
            case 3: {
                this.w = value;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return this;
    }

    public IntBuffer get(IntBuffer buffer) {
        MemUtil.INSTANCE.put(this, buffer.position(), buffer);
        return buffer;
    }

    public IntBuffer get(int index, IntBuffer buffer) {
        MemUtil.INSTANCE.put(this, index, buffer);
        return buffer;
    }

    public ByteBuffer get(ByteBuffer buffer) {
        MemUtil.INSTANCE.put(this, buffer.position(), buffer);
        return buffer;
    }

    public ByteBuffer get(int index, ByteBuffer buffer) {
        MemUtil.INSTANCE.put(this, index, buffer);
        return buffer;
    }

    public Vector4ic getToAddress(long address) {
        if (Options.NO_UNSAFE) {
            throw new UnsupportedOperationException("Not supported when using joml.nounsafe");
        }
        MemUtil.MemUtilUnsafe.put(this, address);
        return this;
    }

    public Vector4i sub(Vector4ic v2) {
        this.x -= v2.x();
        this.y -= v2.y();
        this.z -= v2.z();
        this.w -= v2.w();
        return this;
    }

    public Vector4i sub(int x2, int y2, int z2, int w2) {
        this.x -= x2;
        this.y -= y2;
        this.z -= z2;
        this.w -= w2;
        return this;
    }

    public Vector4i sub(Vector4ic v2, Vector4i dest) {
        dest.x = this.x - v2.x();
        dest.y = this.y - v2.y();
        dest.z = this.z - v2.z();
        dest.w = this.w - v2.w();
        return dest;
    }

    public Vector4i sub(int x2, int y2, int z2, int w2, Vector4i dest) {
        dest.x = this.x - x2;
        dest.y = this.y - y2;
        dest.z = this.z - z2;
        dest.w = this.w - w2;
        return dest;
    }

    public Vector4i add(Vector4ic v2) {
        this.x += v2.x();
        this.y += v2.y();
        this.z += v2.z();
        this.w += v2.w();
        return this;
    }

    public Vector4i add(Vector4ic v2, Vector4i dest) {
        dest.x = this.x + v2.x();
        dest.y = this.y + v2.y();
        dest.z = this.z + v2.z();
        dest.w = this.w + v2.w();
        return dest;
    }

    public Vector4i add(int x2, int y2, int z2, int w2) {
        this.x += x2;
        this.y += y2;
        this.z += z2;
        this.w += w2;
        return this;
    }

    public Vector4i add(int x2, int y2, int z2, int w2, Vector4i dest) {
        dest.x = this.x + x2;
        dest.y = this.y + y2;
        dest.z = this.z + z2;
        dest.w = this.w + w2;
        return dest;
    }

    public Vector4i mul(Vector4ic v2) {
        this.x *= v2.x();
        this.y *= v2.y();
        this.z *= v2.z();
        this.w *= v2.w();
        return this;
    }

    public Vector4i mul(Vector4ic v2, Vector4i dest) {
        dest.x = this.x * v2.x();
        dest.y = this.y * v2.y();
        dest.z = this.z * v2.z();
        dest.w = this.w * v2.w();
        return dest;
    }

    public Vector4i div(Vector4ic v2) {
        this.x /= v2.x();
        this.y /= v2.y();
        this.z /= v2.z();
        this.w /= v2.w();
        return this;
    }

    public Vector4i div(Vector4ic v2, Vector4i dest) {
        dest.x = this.x / v2.x();
        dest.y = this.y / v2.y();
        dest.z = this.z / v2.z();
        dest.w = this.w / v2.w();
        return dest;
    }

    public Vector4i mul(int scalar) {
        this.x *= scalar;
        this.y *= scalar;
        this.z *= scalar;
        this.w *= scalar;
        return this;
    }

    public Vector4i mul(int scalar, Vector4i dest) {
        dest.x = this.x * scalar;
        dest.y = this.y * scalar;
        dest.z = this.z * scalar;
        dest.w = this.w * scalar;
        return dest;
    }

    public Vector4i div(float scalar) {
        float invscalar = 1.0f / scalar;
        this.x = (int)((float)this.x * invscalar);
        this.y = (int)((float)this.y * invscalar);
        this.z = (int)((float)this.z * invscalar);
        this.w = (int)((float)this.w * invscalar);
        return this;
    }

    public Vector4i div(float scalar, Vector4i dest) {
        float invscalar = 1.0f / scalar;
        dest.x = (int)((float)this.x * invscalar);
        dest.y = (int)((float)this.y * invscalar);
        dest.z = (int)((float)this.z * invscalar);
        dest.w = (int)((float)this.w * invscalar);
        return dest;
    }

    public Vector4i div(int scalar) {
        this.x /= scalar;
        this.y /= scalar;
        this.z /= scalar;
        this.w /= scalar;
        return this;
    }

    public Vector4i div(int scalar, Vector4i dest) {
        dest.x = this.x / scalar;
        dest.y = this.y / scalar;
        dest.z = this.z / scalar;
        dest.w = this.w / scalar;
        return dest;
    }

    public long lengthSquared() {
        return this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
    }

    public static long lengthSquared(int x2, int y2, int z2, int w2) {
        return x2 * x2 + y2 * y2 + z2 * z2 + w2 * w2;
    }

    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w);
    }

    public static double length(int x2, int y2, int z2, int w2) {
        return Math.sqrt(x2 * x2 + y2 * y2 + z2 * z2 + w2 * w2);
    }

    public double distance(Vector4ic v2) {
        int dx2 = this.x - v2.x();
        int dy2 = this.y - v2.y();
        int dz2 = this.z - v2.z();
        int dw2 = this.w - v2.w();
        return Math.sqrt(Math.fma(dx2, dx2, Math.fma(dy2, dy2, Math.fma(dz2, dz2, dw2 * dw2))));
    }

    public double distance(int x2, int y2, int z2, int w2) {
        int dx2 = this.x - x2;
        int dy2 = this.y - y2;
        int dz2 = this.z - z2;
        int dw2 = this.w - w2;
        return Math.sqrt(Math.fma(dx2, dx2, Math.fma(dy2, dy2, Math.fma(dz2, dz2, dw2 * dw2))));
    }

    public long gridDistance(Vector4ic v2) {
        return Math.abs(v2.x() - this.x()) + Math.abs(v2.y() - this.y()) + Math.abs(v2.z() - this.z()) + Math.abs(v2.w() - this.w());
    }

    public long gridDistance(int x2, int y2, int z2, int w2) {
        return Math.abs(x2 - this.x()) + Math.abs(y2 - this.y()) + Math.abs(z2 - this.z()) + Math.abs(w2 - this.w());
    }

    public int distanceSquared(Vector4ic v2) {
        int dx2 = this.x - v2.x();
        int dy2 = this.y - v2.y();
        int dz2 = this.z - v2.z();
        int dw2 = this.w - v2.w();
        return dx2 * dx2 + dy2 * dy2 + dz2 * dz2 + dw2 * dw2;
    }

    public int distanceSquared(int x2, int y2, int z2, int w2) {
        int dx2 = this.x - x2;
        int dy2 = this.y - y2;
        int dz2 = this.z - z2;
        int dw2 = this.w - w2;
        return dx2 * dx2 + dy2 * dy2 + dz2 * dz2 + dw2 * dw2;
    }

    public static double distance(int x1, int y1, int z1, int w1, int x2, int y2, int z2, int w2) {
        int dx2 = x1 - x2;
        int dy2 = y1 - y2;
        int dz2 = z1 - z2;
        int dw2 = w1 - w2;
        return Math.sqrt(dx2 * dx2 + dy2 * dy2 + dz2 * dz2 + dw2 * dw2);
    }

    public static long distanceSquared(int x1, int y1, int z1, int w1, int x2, int y2, int z2, int w2) {
        int dx2 = x1 - x2;
        int dy2 = y1 - y2;
        int dz2 = z1 - z2;
        int dw2 = w1 - w2;
        return dx2 * dx2 + dy2 * dy2 + dz2 * dz2 + dw2 * dw2;
    }

    public int dot(Vector4ic v2) {
        return this.x * v2.x() + this.y * v2.y() + this.z * v2.z() + this.w * v2.w();
    }

    public Vector4i zero() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.w = 0;
        return this;
    }

    public Vector4i negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        this.w = -this.w;
        return this;
    }

    public Vector4i negate(Vector4i dest) {
        dest.x = -this.x;
        dest.y = -this.y;
        dest.z = -this.z;
        dest.w = -this.w;
        return dest;
    }

    public String toString() {
        return Runtime.formatNumbers(this.toString(Options.NUMBER_FORMAT));
    }

    public String toString(NumberFormat formatter) {
        return "(" + formatter.format(this.x) + " " + formatter.format(this.y) + " " + formatter.format(this.z) + " " + formatter.format(this.w) + ")";
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(this.x);
        out.writeInt(this.y);
        out.writeInt(this.z);
        out.writeInt(this.w);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.x = in.readInt();
        this.y = in.readInt();
        this.z = in.readInt();
        this.w = in.readInt();
    }

    public Vector4i min(Vector4ic v2) {
        this.x = this.x < v2.x() ? this.x : v2.x();
        this.y = this.y < v2.y() ? this.y : v2.y();
        this.z = this.z < v2.z() ? this.z : v2.z();
        this.w = this.w < v2.w() ? this.w : v2.w();
        return this;
    }

    public Vector4i min(Vector4ic v2, Vector4i dest) {
        dest.x = this.x < v2.x() ? this.x : v2.x();
        dest.y = this.y < v2.y() ? this.y : v2.y();
        dest.z = this.z < v2.z() ? this.z : v2.z();
        dest.w = this.w < v2.w() ? this.w : v2.w();
        return dest;
    }

    public Vector4i max(Vector4ic v2) {
        this.x = this.x > v2.x() ? this.x : v2.x();
        this.y = this.y > v2.y() ? this.y : v2.y();
        this.z = this.z > v2.z() ? this.z : v2.z();
        this.w = this.w > v2.w() ? this.w : v2.w();
        return this;
    }

    public Vector4i max(Vector4ic v2, Vector4i dest) {
        dest.x = this.x > v2.x() ? this.x : v2.x();
        dest.y = this.y > v2.y() ? this.y : v2.y();
        dest.z = this.z > v2.z() ? this.z : v2.z();
        dest.w = this.w > v2.w() ? this.w : v2.w();
        return dest;
    }

    public Vector4i absolute() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
        this.w = Math.abs(this.w);
        return this;
    }

    public Vector4i absolute(Vector4i dest) {
        dest.x = Math.abs(this.x);
        dest.y = Math.abs(this.y);
        dest.z = Math.abs(this.z);
        dest.w = Math.abs(this.w);
        return dest;
    }

    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = 31 * result + this.x;
        result = 31 * result + this.y;
        result = 31 * result + this.z;
        result = 31 * result + this.w;
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Vector4i other = (Vector4i)obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        if (this.z != other.z) {
            return false;
        }
        return this.w == other.w;
    }

    public boolean equals(int x2, int y2, int z2, int w2) {
        if (this.x != x2) {
            return false;
        }
        if (this.y != y2) {
            return false;
        }
        if (this.z != z2) {
            return false;
        }
        return this.w == w2;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

