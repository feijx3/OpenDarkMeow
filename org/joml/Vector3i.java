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
import org.joml.Vector2dc;
import org.joml.Vector2fc;
import org.joml.Vector2ic;
import org.joml.Vector3dc;
import org.joml.Vector3fc;
import org.joml.Vector3ic;

public class Vector3i
implements Externalizable,
Cloneable,
Vector3ic {
    private static final long serialVersionUID = 1L;
    public int x;
    public int y;
    public int z;

    public Vector3i() {
    }

    public Vector3i(int d2) {
        this.x = d2;
        this.y = d2;
        this.z = d2;
    }

    public Vector3i(int x2, int y2, int z2) {
        this.x = x2;
        this.y = y2;
        this.z = z2;
    }

    public Vector3i(Vector3ic v2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = v2.z();
    }

    public Vector3i(Vector2ic v2, int z2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = z2;
    }

    public Vector3i(float x2, float y2, float z2, int mode) {
        this.x = Math.roundUsing(x2, mode);
        this.y = Math.roundUsing(y2, mode);
        this.z = Math.roundUsing(z2, mode);
    }

    public Vector3i(double x2, double y2, double z2, int mode) {
        this.x = Math.roundUsing(x2, mode);
        this.y = Math.roundUsing(y2, mode);
        this.z = Math.roundUsing(z2, mode);
    }

    public Vector3i(Vector2fc v2, float z2, int mode) {
        this.x = Math.roundUsing(v2.x(), mode);
        this.y = Math.roundUsing(v2.y(), mode);
        this.z = Math.roundUsing(z2, mode);
    }

    public Vector3i(Vector3fc v2, int mode) {
        this.x = Math.roundUsing(v2.x(), mode);
        this.y = Math.roundUsing(v2.y(), mode);
        this.z = Math.roundUsing(v2.z(), mode);
    }

    public Vector3i(Vector2dc v2, float z2, int mode) {
        this.x = Math.roundUsing(v2.x(), mode);
        this.y = Math.roundUsing(v2.y(), mode);
        this.z = Math.roundUsing(z2, mode);
    }

    public Vector3i(Vector3dc v2, int mode) {
        this.x = Math.roundUsing(v2.x(), mode);
        this.y = Math.roundUsing(v2.y(), mode);
        this.z = Math.roundUsing(v2.z(), mode);
    }

    public Vector3i(int[] xyz) {
        this.x = xyz[0];
        this.y = xyz[1];
        this.z = xyz[2];
    }

    public Vector3i(ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
    }

    public Vector3i(int index, ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
    }

    public Vector3i(IntBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
    }

    public Vector3i(int index, IntBuffer buffer) {
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

    public Vector3i set(Vector3ic v2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = v2.z();
        return this;
    }

    public Vector3i set(Vector3dc v2) {
        this.x = (int)v2.x();
        this.y = (int)v2.y();
        this.z = (int)v2.z();
        return this;
    }

    public Vector3i set(Vector3dc v2, int mode) {
        this.x = Math.roundUsing(v2.x(), mode);
        this.y = Math.roundUsing(v2.y(), mode);
        this.z = Math.roundUsing(v2.z(), mode);
        return this;
    }

    public Vector3i set(Vector3fc v2, int mode) {
        this.x = Math.roundUsing(v2.x(), mode);
        this.y = Math.roundUsing(v2.y(), mode);
        this.z = Math.roundUsing(v2.z(), mode);
        return this;
    }

    public Vector3i set(Vector2ic v2, int z2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = z2;
        return this;
    }

    public Vector3i set(int d2) {
        this.x = d2;
        this.y = d2;
        this.z = d2;
        return this;
    }

    public Vector3i set(int x2, int y2, int z2) {
        this.x = x2;
        this.y = y2;
        this.z = z2;
        return this;
    }

    public Vector3i set(int[] xyz) {
        this.x = xyz[0];
        this.y = xyz[1];
        this.z = xyz[2];
        return this;
    }

    public Vector3i set(ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
        return this;
    }

    public Vector3i set(int index, ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
        return this;
    }

    public Vector3i set(IntBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
        return this;
    }

    public Vector3i set(int index, IntBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
        return this;
    }

    public Vector3i setFromAddress(long address) {
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
        }
        throw new IllegalArgumentException();
    }

    public Vector3i setComponent(int component, int value) throws IllegalArgumentException {
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

    public Vector3ic getToAddress(long address) {
        if (Options.NO_UNSAFE) {
            throw new UnsupportedOperationException("Not supported when using joml.nounsafe");
        }
        MemUtil.MemUtilUnsafe.put(this, address);
        return this;
    }

    public Vector3i sub(Vector3ic v2) {
        this.x -= v2.x();
        this.y -= v2.y();
        this.z -= v2.z();
        return this;
    }

    public Vector3i sub(Vector3ic v2, Vector3i dest) {
        dest.x = this.x - v2.x();
        dest.y = this.y - v2.y();
        dest.z = this.z - v2.z();
        return dest;
    }

    public Vector3i sub(int x2, int y2, int z2) {
        this.x -= x2;
        this.y -= y2;
        this.z -= z2;
        return this;
    }

    public Vector3i sub(int x2, int y2, int z2, Vector3i dest) {
        dest.x = this.x - x2;
        dest.y = this.y - y2;
        dest.z = this.z - z2;
        return dest;
    }

    public Vector3i add(Vector3ic v2) {
        this.x += v2.x();
        this.y += v2.y();
        this.z += v2.z();
        return this;
    }

    public Vector3i add(Vector3ic v2, Vector3i dest) {
        dest.x = this.x + v2.x();
        dest.y = this.y + v2.y();
        dest.z = this.z + v2.z();
        return dest;
    }

    public Vector3i add(int x2, int y2, int z2) {
        this.x += x2;
        this.y += y2;
        this.z += z2;
        return this;
    }

    public Vector3i add(int x2, int y2, int z2, Vector3i dest) {
        dest.x = this.x + x2;
        dest.y = this.y + y2;
        dest.z = this.z + z2;
        return dest;
    }

    public Vector3i mul(int scalar) {
        this.x *= scalar;
        this.y *= scalar;
        this.z *= scalar;
        return this;
    }

    public Vector3i mul(int scalar, Vector3i dest) {
        dest.x = this.x * scalar;
        dest.y = this.y * scalar;
        dest.z = this.z * scalar;
        return dest;
    }

    public Vector3i mul(Vector3ic v2) {
        this.x *= v2.x();
        this.y *= v2.y();
        this.z *= v2.z();
        return this;
    }

    public Vector3i mul(Vector3ic v2, Vector3i dest) {
        dest.x = this.x * v2.x();
        dest.y = this.y * v2.y();
        dest.z = this.z * v2.z();
        return dest;
    }

    public Vector3i mul(int x2, int y2, int z2) {
        this.x *= x2;
        this.y *= y2;
        this.z *= z2;
        return this;
    }

    public Vector3i mul(int x2, int y2, int z2, Vector3i dest) {
        dest.x = this.x * x2;
        dest.y = this.y * y2;
        dest.z = this.z * z2;
        return dest;
    }

    public Vector3i div(float scalar) {
        float invscalar = 1.0f / scalar;
        this.x = (int)((float)this.x * invscalar);
        this.y = (int)((float)this.y * invscalar);
        this.z = (int)((float)this.z * invscalar);
        return this;
    }

    public Vector3i div(float scalar, Vector3i dest) {
        float invscalar = 1.0f / scalar;
        dest.x = (int)((float)this.x * invscalar);
        dest.y = (int)((float)this.y * invscalar);
        dest.z = (int)((float)this.z * invscalar);
        return dest;
    }

    public Vector3i div(int scalar) {
        this.x /= scalar;
        this.y /= scalar;
        this.z /= scalar;
        return this;
    }

    public Vector3i div(int scalar, Vector3i dest) {
        dest.x = this.x / scalar;
        dest.y = this.y / scalar;
        dest.z = this.z / scalar;
        return dest;
    }

    public long lengthSquared() {
        return this.x * this.x + this.y * this.y + this.z * this.z;
    }

    public static long lengthSquared(int x2, int y2, int z2) {
        return x2 * x2 + y2 * y2 + z2 * z2;
    }

    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    public static double length(int x2, int y2, int z2) {
        return Math.sqrt(x2 * x2 + y2 * y2 + z2 * z2);
    }

    public double distance(Vector3ic v2) {
        int dx2 = this.x - v2.x();
        int dy2 = this.y - v2.y();
        int dz2 = this.z - v2.z();
        return Math.sqrt(dx2 * dx2 + dy2 * dy2 + dz2 * dz2);
    }

    public double distance(int x2, int y2, int z2) {
        int dx2 = this.x - x2;
        int dy2 = this.y - y2;
        int dz2 = this.z - z2;
        return Math.sqrt(dx2 * dx2 + dy2 * dy2 + dz2 * dz2);
    }

    public long gridDistance(Vector3ic v2) {
        return Math.abs(v2.x() - this.x()) + Math.abs(v2.y() - this.y()) + Math.abs(v2.z() - this.z());
    }

    public long gridDistance(int x2, int y2, int z2) {
        return Math.abs(x2 - this.x()) + Math.abs(y2 - this.y()) + Math.abs(z2 - this.z());
    }

    public long distanceSquared(Vector3ic v2) {
        int dx2 = this.x - v2.x();
        int dy2 = this.y - v2.y();
        int dz2 = this.z - v2.z();
        return dx2 * dx2 + dy2 * dy2 + dz2 * dz2;
    }

    public long distanceSquared(int x2, int y2, int z2) {
        int dx2 = this.x - x2;
        int dy2 = this.y - y2;
        int dz2 = this.z - z2;
        return dx2 * dx2 + dy2 * dy2 + dz2 * dz2;
    }

    public static double distance(int x1, int y1, int z1, int x2, int y2, int z2) {
        return Math.sqrt(Vector3i.distanceSquared(x1, y1, z1, x2, y2, z2));
    }

    public static long distanceSquared(int x1, int y1, int z1, int x2, int y2, int z2) {
        int dx2 = x1 - x2;
        int dy2 = y1 - y2;
        int dz2 = z1 - z2;
        return dx2 * dx2 + dy2 * dy2 + dz2 * dz2;
    }

    public Vector3i zero() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        return this;
    }

    public String toString() {
        return Runtime.formatNumbers(this.toString(Options.NUMBER_FORMAT));
    }

    public String toString(NumberFormat formatter) {
        return "(" + formatter.format(this.x) + " " + formatter.format(this.y) + " " + formatter.format(this.z) + ")";
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(this.x);
        out.writeInt(this.y);
        out.writeInt(this.z);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.x = in.readInt();
        this.y = in.readInt();
        this.z = in.readInt();
    }

    public Vector3i negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        return this;
    }

    public Vector3i negate(Vector3i dest) {
        dest.x = -this.x;
        dest.y = -this.y;
        dest.z = -this.z;
        return dest;
    }

    public Vector3i min(Vector3ic v2) {
        this.x = this.x < v2.x() ? this.x : v2.x();
        this.y = this.y < v2.y() ? this.y : v2.y();
        this.z = this.z < v2.z() ? this.z : v2.z();
        return this;
    }

    public Vector3i min(Vector3ic v2, Vector3i dest) {
        dest.x = this.x < v2.x() ? this.x : v2.x();
        dest.y = this.y < v2.y() ? this.y : v2.y();
        dest.z = this.z < v2.z() ? this.z : v2.z();
        return dest;
    }

    public Vector3i max(Vector3ic v2) {
        this.x = this.x > v2.x() ? this.x : v2.x();
        this.y = this.y > v2.y() ? this.y : v2.y();
        this.z = this.z > v2.z() ? this.z : v2.z();
        return this;
    }

    public Vector3i max(Vector3ic v2, Vector3i dest) {
        dest.x = this.x > v2.x() ? this.x : v2.x();
        dest.y = this.y > v2.y() ? this.y : v2.y();
        dest.z = this.z > v2.z() ? this.z : v2.z();
        return dest;
    }

    public int maxComponent() {
        float absX = Math.abs(this.x);
        float absY = Math.abs(this.y);
        float absZ = Math.abs(this.z);
        if (absX >= absY && absX >= absZ) {
            return 0;
        }
        if (absY >= absZ) {
            return 1;
        }
        return 2;
    }

    public int minComponent() {
        float absX = Math.abs(this.x);
        float absY = Math.abs(this.y);
        float absZ = Math.abs(this.z);
        if (absX < absY && absX < absZ) {
            return 0;
        }
        if (absY < absZ) {
            return 1;
        }
        return 2;
    }

    public Vector3i absolute() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
        return this;
    }

    public Vector3i absolute(Vector3i dest) {
        dest.x = Math.abs(this.x);
        dest.y = Math.abs(this.y);
        dest.z = Math.abs(this.z);
        return dest;
    }

    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = 31 * result + this.x;
        result = 31 * result + this.y;
        result = 31 * result + this.z;
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
        Vector3i other = (Vector3i)obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return this.z == other.z;
    }

    public boolean equals(int x2, int y2, int z2) {
        if (this.x != x2) {
            return false;
        }
        if (this.y != y2) {
            return false;
        }
        return this.z == z2;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

