/*
 * Decompiled with CFR 0.152.
 */
package org.joml;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.text.NumberFormat;
import org.joml.Math;
import org.joml.Matrix2dc;
import org.joml.Matrix2fc;
import org.joml.Matrix3x2dc;
import org.joml.MemUtil;
import org.joml.Options;
import org.joml.Runtime;
import org.joml.Vector2dc;
import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.joml.Vector2i;
import org.joml.Vector2ic;

public class Vector2d
implements Externalizable,
Cloneable,
Vector2dc {
    private static final long serialVersionUID = 1L;
    public double x;
    public double y;

    public Vector2d() {
    }

    public Vector2d(double d2) {
        this.x = d2;
        this.y = d2;
    }

    public Vector2d(double x2, double y2) {
        this.x = x2;
        this.y = y2;
    }

    public Vector2d(Vector2dc v2) {
        this.x = v2.x();
        this.y = v2.y();
    }

    public Vector2d(Vector2fc v2) {
        this.x = v2.x();
        this.y = v2.y();
    }

    public Vector2d(Vector2ic v2) {
        this.x = v2.x();
        this.y = v2.y();
    }

    public Vector2d(double[] xy) {
        this.x = xy[0];
        this.y = xy[1];
    }

    public Vector2d(float[] xy) {
        this.x = xy[0];
        this.y = xy[1];
    }

    public Vector2d(ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
    }

    public Vector2d(int index, ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
    }

    public Vector2d(DoubleBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
    }

    public Vector2d(int index, DoubleBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
    }

    public double x() {
        return this.x;
    }

    public double y() {
        return this.y;
    }

    public Vector2d set(double d2) {
        this.x = d2;
        this.y = d2;
        return this;
    }

    public Vector2d set(double x2, double y2) {
        this.x = x2;
        this.y = y2;
        return this;
    }

    public Vector2d set(Vector2dc v2) {
        this.x = v2.x();
        this.y = v2.y();
        return this;
    }

    public Vector2d set(Vector2fc v2) {
        this.x = v2.x();
        this.y = v2.y();
        return this;
    }

    public Vector2d set(Vector2ic v2) {
        this.x = v2.x();
        this.y = v2.y();
        return this;
    }

    public Vector2d set(double[] xy) {
        this.x = xy[0];
        this.y = xy[1];
        return this;
    }

    public Vector2d set(float[] xy) {
        this.x = xy[0];
        this.y = xy[1];
        return this;
    }

    public Vector2d set(ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
        return this;
    }

    public Vector2d set(int index, ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
        return this;
    }

    public Vector2d set(DoubleBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
        return this;
    }

    public Vector2d set(int index, DoubleBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
        return this;
    }

    public Vector2d setFromAddress(long address) {
        if (Options.NO_UNSAFE) {
            throw new UnsupportedOperationException("Not supported when using joml.nounsafe");
        }
        MemUtil.MemUtilUnsafe.get(this, address);
        return this;
    }

    public double get(int component) throws IllegalArgumentException {
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

    public Vector2i get(int mode, Vector2i dest) {
        dest.x = Math.roundUsing(this.x(), mode);
        dest.y = Math.roundUsing(this.y(), mode);
        return dest;
    }

    public Vector2f get(Vector2f dest) {
        dest.x = (float)this.x();
        dest.y = (float)this.y();
        return dest;
    }

    public Vector2d get(Vector2d dest) {
        dest.x = this.x();
        dest.y = this.y();
        return dest;
    }

    public Vector2d setComponent(int component, double value) throws IllegalArgumentException {
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

    public DoubleBuffer get(DoubleBuffer buffer) {
        MemUtil.INSTANCE.put(this, buffer.position(), buffer);
        return buffer;
    }

    public DoubleBuffer get(int index, DoubleBuffer buffer) {
        MemUtil.INSTANCE.put(this, index, buffer);
        return buffer;
    }

    public Vector2dc getToAddress(long address) {
        if (Options.NO_UNSAFE) {
            throw new UnsupportedOperationException("Not supported when using joml.nounsafe");
        }
        MemUtil.MemUtilUnsafe.put(this, address);
        return this;
    }

    public Vector2d perpendicular() {
        double xTemp = this.y;
        this.y = this.x * -1.0;
        this.x = xTemp;
        return this;
    }

    public Vector2d sub(Vector2dc v2) {
        this.x -= v2.x();
        this.y -= v2.y();
        return this;
    }

    public Vector2d sub(double x2, double y2) {
        this.x -= x2;
        this.y -= y2;
        return this;
    }

    public Vector2d sub(double x2, double y2, Vector2d dest) {
        dest.x = this.x - x2;
        dest.y = this.y - y2;
        return dest;
    }

    public Vector2d sub(Vector2fc v2) {
        this.x -= (double)v2.x();
        this.y -= (double)v2.y();
        return this;
    }

    public Vector2d sub(Vector2dc v2, Vector2d dest) {
        dest.x = this.x - v2.x();
        dest.y = this.y - v2.y();
        return dest;
    }

    public Vector2d sub(Vector2fc v2, Vector2d dest) {
        dest.x = this.x - (double)v2.x();
        dest.y = this.y - (double)v2.y();
        return dest;
    }

    public Vector2d mul(double scalar) {
        this.x *= scalar;
        this.y *= scalar;
        return this;
    }

    public Vector2d mul(double scalar, Vector2d dest) {
        dest.x = this.x * scalar;
        dest.y = this.y * scalar;
        return dest;
    }

    public Vector2d mul(double x2, double y2) {
        this.x *= x2;
        this.y *= y2;
        return this;
    }

    public Vector2d mul(double x2, double y2, Vector2d dest) {
        dest.x = this.x * x2;
        dest.y = this.y * y2;
        return dest;
    }

    public Vector2d mul(Vector2dc v2) {
        this.x *= v2.x();
        this.y *= v2.y();
        return this;
    }

    public Vector2d mul(Vector2dc v2, Vector2d dest) {
        dest.x = this.x * v2.x();
        dest.y = this.y * v2.y();
        return dest;
    }

    public Vector2d div(double scalar) {
        double inv = 1.0 / scalar;
        this.x *= inv;
        this.y *= inv;
        return this;
    }

    public Vector2d div(double scalar, Vector2d dest) {
        double inv = 1.0 / scalar;
        dest.x = this.x * inv;
        dest.y = this.y * inv;
        return dest;
    }

    public Vector2d div(double x2, double y2) {
        this.x /= x2;
        this.y /= y2;
        return this;
    }

    public Vector2d div(double x2, double y2, Vector2d dest) {
        dest.x = this.x / x2;
        dest.y = this.y / y2;
        return dest;
    }

    public Vector2d div(Vector2d v2) {
        this.x /= v2.x();
        this.y /= v2.y();
        return this;
    }

    public Vector2d div(Vector2fc v2) {
        this.x /= (double)v2.x();
        this.y /= (double)v2.y();
        return this;
    }

    public Vector2d div(Vector2fc v2, Vector2d dest) {
        dest.x = this.x / (double)v2.x();
        dest.y = this.y / (double)v2.y();
        return dest;
    }

    public Vector2d div(Vector2dc v2, Vector2d dest) {
        dest.x = this.x / v2.x();
        dest.y = this.y / v2.y();
        return dest;
    }

    public Vector2d mul(Matrix2fc mat) {
        double rx = (double)mat.m00() * this.x + (double)mat.m10() * this.y;
        double ry = (double)mat.m01() * this.x + (double)mat.m11() * this.y;
        this.x = rx;
        this.y = ry;
        return this;
    }

    public Vector2d mul(Matrix2dc mat) {
        double rx = mat.m00() * this.x + mat.m10() * this.y;
        double ry = mat.m01() * this.x + mat.m11() * this.y;
        this.x = rx;
        this.y = ry;
        return this;
    }

    public Vector2d mul(Matrix2dc mat, Vector2d dest) {
        double rx = mat.m00() * this.x + mat.m10() * this.y;
        double ry = mat.m01() * this.x + mat.m11() * this.y;
        dest.x = rx;
        dest.y = ry;
        return dest;
    }

    public Vector2d mul(Matrix2fc mat, Vector2d dest) {
        double rx = (double)mat.m00() * this.x + (double)mat.m10() * this.y;
        double ry = (double)mat.m01() * this.x + (double)mat.m11() * this.y;
        dest.x = rx;
        dest.y = ry;
        return dest;
    }

    public Vector2d mulTranspose(Matrix2dc mat) {
        double rx = mat.m00() * this.x + mat.m01() * this.y;
        double ry = mat.m10() * this.x + mat.m11() * this.y;
        this.x = rx;
        this.y = ry;
        return this;
    }

    public Vector2d mulTranspose(Matrix2dc mat, Vector2d dest) {
        double rx = mat.m00() * this.x + mat.m01() * this.y;
        double ry = mat.m10() * this.x + mat.m11() * this.y;
        dest.x = rx;
        dest.y = ry;
        return dest;
    }

    public Vector2d mulTranspose(Matrix2fc mat) {
        double rx = (double)mat.m00() * this.x + (double)mat.m01() * this.y;
        double ry = (double)mat.m10() * this.x + (double)mat.m11() * this.y;
        this.x = rx;
        this.y = ry;
        return this;
    }

    public Vector2d mulTranspose(Matrix2fc mat, Vector2d dest) {
        double rx = (double)mat.m00() * this.x + (double)mat.m01() * this.y;
        double ry = (double)mat.m10() * this.x + (double)mat.m11() * this.y;
        dest.x = rx;
        dest.y = ry;
        return dest;
    }

    public Vector2d mulPosition(Matrix3x2dc mat) {
        double rx = mat.m00() * this.x + mat.m10() * this.y + mat.m20();
        double ry = mat.m01() * this.x + mat.m11() * this.y + mat.m21();
        this.x = rx;
        this.y = ry;
        return this;
    }

    public Vector2d mulPosition(Matrix3x2dc mat, Vector2d dest) {
        double rx = mat.m00() * this.x + mat.m10() * this.y + mat.m20();
        double ry = mat.m01() * this.x + mat.m11() * this.y + mat.m21();
        dest.x = rx;
        dest.y = ry;
        return dest;
    }

    public Vector2d mulDirection(Matrix3x2dc mat) {
        double rx = mat.m00() * this.x + mat.m10() * this.y;
        double ry = mat.m01() * this.x + mat.m11() * this.y;
        this.x = rx;
        this.y = ry;
        return this;
    }

    public Vector2d mulDirection(Matrix3x2dc mat, Vector2d dest) {
        double rx = mat.m00() * this.x + mat.m10() * this.y;
        double ry = mat.m01() * this.x + mat.m11() * this.y;
        dest.x = rx;
        dest.y = ry;
        return dest;
    }

    public double dot(Vector2dc v2) {
        return this.x * v2.x() + this.y * v2.y();
    }

    public double angle(Vector2dc v2) {
        double dot = this.x * v2.x() + this.y * v2.y();
        double det = this.x * v2.y() - this.y * v2.x();
        return Math.atan2(det, dot);
    }

    public double lengthSquared() {
        return this.x * this.x + this.y * this.y;
    }

    public static double lengthSquared(double x2, double y2) {
        return x2 * x2 + y2 * y2;
    }

    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public static double length(double x2, double y2) {
        return Math.sqrt(x2 * x2 + y2 * y2);
    }

    public double distance(Vector2dc v2) {
        double dx2 = this.x - v2.x();
        double dy2 = this.y - v2.y();
        return Math.sqrt(dx2 * dx2 + dy2 * dy2);
    }

    public double distanceSquared(Vector2dc v2) {
        double dx2 = this.x - v2.x();
        double dy2 = this.y - v2.y();
        return dx2 * dx2 + dy2 * dy2;
    }

    public double distance(Vector2fc v2) {
        double dx2 = this.x - (double)v2.x();
        double dy2 = this.y - (double)v2.y();
        return Math.sqrt(dx2 * dx2 + dy2 * dy2);
    }

    public double distanceSquared(Vector2fc v2) {
        double dx2 = this.x - (double)v2.x();
        double dy2 = this.y - (double)v2.y();
        return dx2 * dx2 + dy2 * dy2;
    }

    public double distance(double x2, double y2) {
        double dx2 = this.x - x2;
        double dy2 = this.y - y2;
        return Math.sqrt(dx2 * dx2 + dy2 * dy2);
    }

    public double distanceSquared(double x2, double y2) {
        double dx2 = this.x - x2;
        double dy2 = this.y - y2;
        return dx2 * dx2 + dy2 * dy2;
    }

    public static double distance(double x1, double y1, double x2, double y2) {
        double dx2 = x1 - x2;
        double dy2 = y1 - y2;
        return Math.sqrt(dx2 * dx2 + dy2 * dy2);
    }

    public static double distanceSquared(double x1, double y1, double x2, double y2) {
        double dx2 = x1 - x2;
        double dy2 = y1 - y2;
        return dx2 * dx2 + dy2 * dy2;
    }

    public Vector2d normalize() {
        double invLength = Math.invsqrt(this.x * this.x + this.y * this.y);
        this.x *= invLength;
        this.y *= invLength;
        return this;
    }

    public Vector2d normalize(Vector2d dest) {
        double invLength = Math.invsqrt(this.x * this.x + this.y * this.y);
        dest.x = this.x * invLength;
        dest.y = this.y * invLength;
        return dest;
    }

    public Vector2d normalize(double length) {
        double invLength = Math.invsqrt(this.x * this.x + this.y * this.y) * length;
        this.x *= invLength;
        this.y *= invLength;
        return this;
    }

    public Vector2d normalize(double length, Vector2d dest) {
        double invLength = Math.invsqrt(this.x * this.x + this.y * this.y) * length;
        dest.x = this.x * invLength;
        dest.y = this.y * invLength;
        return dest;
    }

    public Vector2d add(Vector2dc v2) {
        this.x += v2.x();
        this.y += v2.y();
        return this;
    }

    public Vector2d add(double x2, double y2) {
        this.x += x2;
        this.y += y2;
        return this;
    }

    public Vector2d add(double x2, double y2, Vector2d dest) {
        dest.x = this.x + x2;
        dest.y = this.y + y2;
        return dest;
    }

    public Vector2d add(Vector2fc v2) {
        this.x += (double)v2.x();
        this.y += (double)v2.y();
        return this;
    }

    public Vector2d add(Vector2dc v2, Vector2d dest) {
        dest.x = this.x + v2.x();
        dest.y = this.y + v2.y();
        return dest;
    }

    public Vector2d add(Vector2fc v2, Vector2d dest) {
        dest.x = this.x + (double)v2.x();
        dest.y = this.y + (double)v2.y();
        return dest;
    }

    public Vector2d zero() {
        this.x = 0.0;
        this.y = 0.0;
        return this;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeDouble(this.x);
        out.writeDouble(this.y);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.x = in.readDouble();
        this.y = in.readDouble();
    }

    public Vector2d negate() {
        this.x = -this.x;
        this.y = -this.y;
        return this;
    }

    public Vector2d negate(Vector2d dest) {
        dest.x = -this.x;
        dest.y = -this.y;
        return dest;
    }

    public Vector2d lerp(Vector2dc other, double t2) {
        this.x += (other.x() - this.x) * t2;
        this.y += (other.y() - this.y) * t2;
        return this;
    }

    public Vector2d lerp(Vector2dc other, double t2, Vector2d dest) {
        dest.x = this.x + (other.x() - this.x) * t2;
        dest.y = this.y + (other.y() - this.y) * t2;
        return dest;
    }

    public int hashCode() {
        int prime = 31;
        int result = 1;
        long temp = Double.doubleToLongBits(this.x);
        result = 31 * result + (int)(temp ^ temp >>> 32);
        temp = Double.doubleToLongBits(this.y);
        result = 31 * result + (int)(temp ^ temp >>> 32);
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
        Vector2d other = (Vector2d)obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        return Double.doubleToLongBits(this.y) == Double.doubleToLongBits(other.y);
    }

    public boolean equals(Vector2dc v2, double delta) {
        if (this == v2) {
            return true;
        }
        if (v2 == null) {
            return false;
        }
        if (!(v2 instanceof Vector2dc)) {
            return false;
        }
        if (!Runtime.equals(this.x, v2.x(), delta)) {
            return false;
        }
        return Runtime.equals(this.y, v2.y(), delta);
    }

    public boolean equals(double x2, double y2) {
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(x2)) {
            return false;
        }
        return Double.doubleToLongBits(this.y) == Double.doubleToLongBits(y2);
    }

    public String toString() {
        return Runtime.formatNumbers(this.toString(Options.NUMBER_FORMAT));
    }

    public String toString(NumberFormat formatter) {
        return "(" + Runtime.format(this.x, formatter) + " " + Runtime.format(this.y, formatter) + ")";
    }

    public Vector2d fma(Vector2dc a2, Vector2dc b2) {
        this.x += a2.x() * b2.x();
        this.y += a2.y() * b2.y();
        return this;
    }

    public Vector2d fma(double a2, Vector2dc b2) {
        this.x += a2 * b2.x();
        this.y += a2 * b2.y();
        return this;
    }

    public Vector2d fma(Vector2dc a2, Vector2dc b2, Vector2d dest) {
        dest.x = this.x + a2.x() * b2.x();
        dest.y = this.y + a2.y() * b2.y();
        return dest;
    }

    public Vector2d fma(double a2, Vector2dc b2, Vector2d dest) {
        dest.x = this.x + a2 * b2.x();
        dest.y = this.y + a2 * b2.y();
        return dest;
    }

    public Vector2d min(Vector2dc v2) {
        this.x = this.x < v2.x() ? this.x : v2.x();
        this.y = this.y < v2.y() ? this.y : v2.y();
        return this;
    }

    public Vector2d min(Vector2dc v2, Vector2d dest) {
        dest.x = this.x < v2.x() ? this.x : v2.x();
        dest.y = this.y < v2.y() ? this.y : v2.y();
        return dest;
    }

    public Vector2d max(Vector2dc v2) {
        this.x = this.x > v2.x() ? this.x : v2.x();
        this.y = this.y > v2.y() ? this.y : v2.y();
        return this;
    }

    public Vector2d max(Vector2dc v2, Vector2d dest) {
        dest.x = this.x > v2.x() ? this.x : v2.x();
        dest.y = this.y > v2.y() ? this.y : v2.y();
        return dest;
    }

    public int maxComponent() {
        double absY;
        double absX = Math.abs(this.x);
        if (absX >= (absY = Math.abs(this.y))) {
            return 0;
        }
        return 1;
    }

    public int minComponent() {
        double absY;
        double absX = Math.abs(this.x);
        if (absX < (absY = Math.abs(this.y))) {
            return 0;
        }
        return 1;
    }

    public Vector2d floor() {
        this.x = Math.floor(this.x);
        this.y = Math.floor(this.y);
        return this;
    }

    public Vector2d floor(Vector2d dest) {
        dest.x = Math.floor(this.x);
        dest.y = Math.floor(this.y);
        return dest;
    }

    public Vector2d ceil() {
        this.x = Math.ceil(this.x);
        this.y = Math.ceil(this.y);
        return this;
    }

    public Vector2d ceil(Vector2d dest) {
        dest.x = Math.ceil(this.x);
        dest.y = Math.ceil(this.y);
        return dest;
    }

    public Vector2d round() {
        this.x = Math.round(this.x);
        this.y = Math.round(this.y);
        return this;
    }

    public Vector2d round(Vector2d dest) {
        dest.x = Math.round(this.x);
        dest.y = Math.round(this.y);
        return dest;
    }

    public boolean isFinite() {
        return Math.isFinite(this.x) && Math.isFinite(this.y);
    }

    public Vector2d absolute() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        return this;
    }

    public Vector2d absolute(Vector2d dest) {
        dest.x = Math.abs(this.x);
        dest.y = Math.abs(this.y);
        return dest;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

