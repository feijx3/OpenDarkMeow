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

public class Vector2i
implements Externalizable,
Cloneable,
Vector2ic {
    private static final long serialVersionUID = 1L;
    public int x;
    public int y;

    public Vector2i() {
    }

    public Vector2i(int s2) {
        this.x = s2;
        this.y = s2;
    }

    public Vector2i(int x2, int y2) {
        this.x = x2;
        this.y = y2;
    }

    public Vector2i(float x2, float y2, int mode) {
        this.x = Math.roundUsing(x2, mode);
        this.y = Math.roundUsing(y2, mode);
    }

    public Vector2i(double x2, double y2, int mode) {
        this.x = Math.roundUsing(x2, mode);
        this.y = Math.roundUsing(y2, mode);
    }

    public Vector2i(Vector2ic v2) {
        this.x = v2.x();
        this.y = v2.y();
    }

    public Vector2i(Vector2fc v2, int mode) {
        this.x = Math.roundUsing(v2.x(), mode);
        this.y = Math.roundUsing(v2.y(), mode);
    }

    public Vector2i(Vector2dc v2, int mode) {
        this.x = Math.roundUsing(v2.x(), mode);
        this.y = Math.roundUsing(v2.y(), mode);
    }

    public Vector2i(int[] xy) {
        this.x = xy[0];
        this.y = xy[1];
    }

    public Vector2i(ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
    }

    public Vector2i(int index, ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
    }

    public Vector2i(IntBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
    }

    public Vector2i(int index, IntBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }

    public Vector2i set(int s2) {
        this.x = s2;
        this.y = s2;
        return this;
    }

    public Vector2i set(int x2, int y2) {
        this.x = x2;
        this.y = y2;
        return this;
    }

    public Vector2i set(Vector2ic v2) {
        this.x = v2.x();
        this.y = v2.y();
        return this;
    }

    public Vector2i set(Vector2dc v2) {
        this.x = (int)v2.x();
        this.y = (int)v2.y();
        return this;
    }

    public Vector2i set(Vector2dc v2, int mode) {
        this.x = Math.roundUsing(v2.x(), mode);
        this.y = Math.roundUsing(v2.y(), mode);
        return this;
    }

    public Vector2i set(Vector2fc v2, int mode) {
        this.x = Math.roundUsing(v2.x(), mode);
        this.y = Math.roundUsing(v2.y(), mode);
        return this;
    }

    public Vector2i set(int[] xy) {
        this.x = xy[0];
        this.y = xy[1];
        return this;
    }

    public Vector2i set(ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
        return this;
    }

    public Vector2i set(int index, ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
        return this;
    }

    public Vector2i set(IntBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
        return this;
    }

    public Vector2i set(int index, IntBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
        return this;
    }

    public Vector2i setFromAddress(long address) {
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
        }
        throw new IllegalArgumentException();
    }

    public Vector2i setComponent(int component, int value) throws IllegalArgumentException {
        switch (component) {
            case 0: {
                this.x = value;
                break;
            }
            case 1: {
                this.y = value;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return this;
    }

    public ByteBuffer get(ByteBuffer buffer) {
        MemUtil.INSTANCE.put(this, buffer.position(), buffer);
        return buffer;
    }

    public ByteBuffer get(int index, ByteBuffer buffer) {
        MemUtil.INSTANCE.put(this, index, buffer);
        return buffer;
    }

    public IntBuffer get(IntBuffer buffer) {
        MemUtil.INSTANCE.put(this, buffer.position(), buffer);
        return buffer;
    }

    public IntBuffer get(int index, IntBuffer buffer) {
        MemUtil.INSTANCE.put(this, index, buffer);
        return buffer;
    }

    public Vector2ic getToAddress(long address) {
        if (Options.NO_UNSAFE) {
            throw new UnsupportedOperationException("Not supported when using joml.nounsafe");
        }
        MemUtil.MemUtilUnsafe.put(this, address);
        return this;
    }

    public Vector2i sub(Vector2ic v2) {
        this.x -= v2.x();
        this.y -= v2.y();
        return this;
    }

    public Vector2i sub(Vector2ic v2, Vector2i dest) {
        dest.x = this.x - v2.x();
        dest.y = this.y - v2.y();
        return dest;
    }

    public Vector2i sub(int x2, int y2) {
        this.x -= x2;
        this.y -= y2;
        return this;
    }

    public Vector2i sub(int x2, int y2, Vector2i dest) {
        dest.x = this.x - x2;
        dest.y = this.y - y2;
        return dest;
    }

    public long lengthSquared() {
        return this.x * this.x + this.y * this.y;
    }

    public static long lengthSquared(int x2, int y2) {
        return x2 * x2 + y2 * y2;
    }

    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public static double length(int x2, int y2) {
        return Math.sqrt(x2 * x2 + y2 * y2);
    }

    public double distance(Vector2ic v2) {
        int dx2 = this.x - v2.x();
        int dy2 = this.y - v2.y();
        return Math.sqrt(dx2 * dx2 + dy2 * dy2);
    }

    public double distance(int x2, int y2) {
        int dx2 = this.x - x2;
        int dy2 = this.y - y2;
        return Math.sqrt(dx2 * dx2 + dy2 * dy2);
    }

    public long distanceSquared(Vector2ic v2) {
        int dx2 = this.x - v2.x();
        int dy2 = this.y - v2.y();
        return dx2 * dx2 + dy2 * dy2;
    }

    public long distanceSquared(int x2, int y2) {
        int dx2 = this.x - x2;
        int dy2 = this.y - y2;
        return dx2 * dx2 + dy2 * dy2;
    }

    public long gridDistance(Vector2ic v2) {
        return Math.abs(v2.x() - this.x()) + Math.abs(v2.y() - this.y());
    }

    public long gridDistance(int x2, int y2) {
        return Math.abs(x2 - this.x()) + Math.abs(y2 - this.y());
    }

    public static double distance(int x1, int y1, int x2, int y2) {
        int dx2 = x1 - x2;
        int dy2 = y1 - y2;
        return Math.sqrt(dx2 * dx2 + dy2 * dy2);
    }

    public static long distanceSquared(int x1, int y1, int x2, int y2) {
        int dx2 = x1 - x2;
        int dy2 = y1 - y2;
        return dx2 * dx2 + dy2 * dy2;
    }

    public Vector2i add(Vector2ic v2) {
        this.x += v2.x();
        this.y += v2.y();
        return this;
    }

    public Vector2i add(Vector2ic v2, Vector2i dest) {
        dest.x = this.x + v2.x();
        dest.y = this.y + v2.y();
        return dest;
    }

    public Vector2i add(int x2, int y2) {
        this.x += x2;
        this.y += y2;
        return this;
    }

    public Vector2i add(int x2, int y2, Vector2i dest) {
        dest.x = this.x + x2;
        dest.y = this.y + y2;
        return dest;
    }

    public Vector2i mul(int scalar) {
        this.x *= scalar;
        this.y *= scalar;
        return this;
    }

    public Vector2i mul(int scalar, Vector2i dest) {
        dest.x = this.x * scalar;
        dest.y = this.y * scalar;
        return dest;
    }

    public Vector2i mul(Vector2ic v2) {
        this.x *= v2.x();
        this.y *= v2.y();
        return this;
    }

    public Vector2i mul(Vector2ic v2, Vector2i dest) {
        dest.x = this.x * v2.x();
        dest.y = this.y * v2.y();
        return dest;
    }

    public Vector2i mul(int x2, int y2) {
        this.x *= x2;
        this.y *= y2;
        return this;
    }

    public Vector2i mul(int x2, int y2, Vector2i dest) {
        dest.x = this.x * x2;
        dest.y = this.y * y2;
        return dest;
    }

    public Vector2i div(float scalar) {
        float invscalar = 1.0f / scalar;
        this.x = (int)((float)this.x * invscalar);
        this.y = (int)((float)this.y * invscalar);
        return this;
    }

    public Vector2i div(float scalar, Vector2i dest) {
        float invscalar = 1.0f / scalar;
        dest.x = (int)((float)this.x * invscalar);
        dest.y = (int)((float)this.y * invscalar);
        return dest;
    }

    public Vector2i div(int scalar) {
        this.x /= scalar;
        this.y /= scalar;
        return this;
    }

    public Vector2i div(int scalar, Vector2i dest) {
        dest.x = this.x / scalar;
        dest.y = this.y / scalar;
        return dest;
    }

    public Vector2i zero() {
        this.x = 0;
        this.y = 0;
        return this;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(this.x);
        out.writeInt(this.y);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.x = in.readInt();
        this.y = in.readInt();
    }

    public Vector2i negate() {
        this.x = -this.x;
        this.y = -this.y;
        return this;
    }

    public Vector2i negate(Vector2i dest) {
        dest.x = -this.x;
        dest.y = -this.y;
        return dest;
    }

    public Vector2i min(Vector2ic v2) {
        this.x = this.x < v2.x() ? this.x : v2.x();
        this.y = this.y < v2.y() ? this.y : v2.y();
        return this;
    }

    public Vector2i min(Vector2ic v2, Vector2i dest) {
        dest.x = this.x < v2.x() ? this.x : v2.x();
        dest.y = this.y < v2.y() ? this.y : v2.y();
        return dest;
    }

    public Vector2i max(Vector2ic v2) {
        this.x = this.x > v2.x() ? this.x : v2.x();
        this.y = this.y > v2.y() ? this.y : v2.y();
        return this;
    }

    public Vector2i max(Vector2ic v2, Vector2i dest) {
        dest.x = this.x > v2.x() ? this.x : v2.x();
        dest.y = this.y > v2.y() ? this.y : v2.y();
        return dest;
    }

    public int maxComponent() {
        int absY;
        int absX = Math.abs(this.x);
        if (absX >= (absY = Math.abs(this.y))) {
            return 0;
        }
        return 1;
    }

    public int minComponent() {
        int absY;
        int absX = Math.abs(this.x);
        if (absX < (absY = Math.abs(this.y))) {
            return 0;
        }
        return 1;
    }

    public Vector2i absolute() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        return this;
    }

    public Vector2i absolute(Vector2i dest) {
        dest.x = Math.abs(this.x);
        dest.y = Math.abs(this.y);
        return dest;
    }

    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = 31 * result + this.x;
        result = 31 * result + this.y;
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
        Vector2i other = (Vector2i)obj;
        if (this.x != other.x) {
            return false;
        }
        return this.y == other.y;
    }

    public boolean equals(int x2, int y2) {
        if (this.x != x2) {
            return false;
        }
        return this.y == y2;
    }

    public String toString() {
        return Runtime.formatNumbers(this.toString(Options.NUMBER_FORMAT));
    }

    public String toString(NumberFormat formatter) {
        return "(" + formatter.format(this.x) + " " + formatter.format(this.y) + ")";
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

