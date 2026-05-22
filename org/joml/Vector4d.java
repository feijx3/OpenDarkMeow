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
import java.nio.FloatBuffer;
import java.text.NumberFormat;
import org.joml.Math;
import org.joml.Matrix4dc;
import org.joml.Matrix4fc;
import org.joml.Matrix4x3dc;
import org.joml.Matrix4x3fc;
import org.joml.MemUtil;
import org.joml.Options;
import org.joml.Quaterniondc;
import org.joml.Runtime;
import org.joml.Vector2dc;
import org.joml.Vector2fc;
import org.joml.Vector2ic;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3fc;
import org.joml.Vector3ic;
import org.joml.Vector4dc;
import org.joml.Vector4f;
import org.joml.Vector4fc;
import org.joml.Vector4i;
import org.joml.Vector4ic;

public class Vector4d
implements Externalizable,
Cloneable,
Vector4dc {
    private static final long serialVersionUID = 1L;
    public double x;
    public double y;
    public double z;
    public double w;

    public Vector4d() {
        this.w = 1.0;
    }

    public Vector4d(Vector4dc v2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = v2.z();
        this.w = v2.w();
    }

    public Vector4d(Vector4ic v2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = v2.z();
        this.w = v2.w();
    }

    public Vector4d(Vector3dc v2, double w2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = v2.z();
        this.w = w2;
    }

    public Vector4d(Vector3ic v2, double w2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = v2.z();
        this.w = w2;
    }

    public Vector4d(Vector2dc v2, double z2, double w2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = z2;
        this.w = w2;
    }

    public Vector4d(Vector2ic v2, double z2, double w2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = z2;
        this.w = w2;
    }

    public Vector4d(double d2) {
        this.x = d2;
        this.y = d2;
        this.z = d2;
        this.w = d2;
    }

    public Vector4d(Vector4fc v2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = v2.z();
        this.w = v2.w();
    }

    public Vector4d(Vector3fc v2, double w2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = v2.z();
        this.w = w2;
    }

    public Vector4d(Vector2fc v2, double z2, double w2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = z2;
        this.w = w2;
    }

    public Vector4d(double x2, double y2, double z2, double w2) {
        this.x = x2;
        this.y = y2;
        this.z = z2;
        this.w = w2;
    }

    public Vector4d(float[] xyzw) {
        this.x = xyzw[0];
        this.y = xyzw[1];
        this.z = xyzw[2];
        this.w = xyzw[3];
    }

    public Vector4d(double[] xyzw) {
        this.x = xyzw[0];
        this.y = xyzw[1];
        this.z = xyzw[2];
        this.w = xyzw[3];
    }

    public Vector4d(ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
    }

    public Vector4d(int index, ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
    }

    public Vector4d(DoubleBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
    }

    public Vector4d(int index, DoubleBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
    }

    public double x() {
        return this.x;
    }

    public double y() {
        return this.y;
    }

    public double z() {
        return this.z;
    }

    public double w() {
        return this.w;
    }

    public Vector4d set(Vector4dc v2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = v2.z();
        this.w = v2.w();
        return this;
    }

    public Vector4d set(Vector4fc v2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = v2.z();
        this.w = v2.w();
        return this;
    }

    public Vector4d set(Vector4ic v2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = v2.z();
        this.w = v2.w();
        return this;
    }

    public Vector4d set(Vector3dc v2, double w2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = v2.z();
        this.w = w2;
        return this;
    }

    public Vector4d set(Vector3ic v2, double w2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = v2.z();
        this.w = w2;
        return this;
    }

    public Vector4d set(Vector3fc v2, double w2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = v2.z();
        this.w = w2;
        return this;
    }

    public Vector4d set(Vector2dc v2, double z2, double w2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = z2;
        this.w = w2;
        return this;
    }

    public Vector4d set(Vector2ic v2, double z2, double w2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = z2;
        this.w = w2;
        return this;
    }

    public Vector4d set(double d2) {
        this.x = d2;
        this.y = d2;
        this.z = d2;
        this.w = d2;
        return this;
    }

    public Vector4d set(Vector2fc v2, double z2, double w2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = z2;
        this.w = w2;
        return this;
    }

    public Vector4d set(double x2, double y2, double z2, double w2) {
        this.x = x2;
        this.y = y2;
        this.z = z2;
        this.w = w2;
        return this;
    }

    public Vector4d set(double x2, double y2, double z2) {
        this.x = x2;
        this.y = y2;
        this.z = z2;
        return this;
    }

    public Vector4d set(double[] xyzw) {
        this.x = xyzw[0];
        this.y = xyzw[1];
        this.z = xyzw[2];
        this.w = xyzw[3];
        return this;
    }

    public Vector4d set(float[] xyzw) {
        this.x = xyzw[0];
        this.y = xyzw[1];
        this.z = xyzw[2];
        this.w = xyzw[3];
        return this;
    }

    public Vector4d set(ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
        return this;
    }

    public Vector4d set(int index, ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
        return this;
    }

    public Vector4d set(DoubleBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
        return this;
    }

    public Vector4d set(int index, DoubleBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
        return this;
    }

    public Vector4d setFromAddress(long address) {
        if (Options.NO_UNSAFE) {
            throw new UnsupportedOperationException("Not supported when using joml.nounsafe");
        }
        MemUtil.MemUtilUnsafe.get(this, address);
        return this;
    }

    public Vector4d setComponent(int component, double value) throws IllegalArgumentException {
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

    public ByteBuffer getf(ByteBuffer buffer) {
        MemUtil.INSTANCE.putf(this, buffer.position(), buffer);
        return buffer;
    }

    public ByteBuffer getf(int index, ByteBuffer buffer) {
        MemUtil.INSTANCE.putf(this, index, buffer);
        return buffer;
    }

    public FloatBuffer get(FloatBuffer buffer) {
        MemUtil.INSTANCE.put(this, buffer.position(), buffer);
        return buffer;
    }

    public FloatBuffer get(int index, FloatBuffer buffer) {
        MemUtil.INSTANCE.put(this, index, buffer);
        return buffer;
    }

    public Vector4dc getToAddress(long address) {
        if (Options.NO_UNSAFE) {
            throw new UnsupportedOperationException("Not supported when using joml.nounsafe");
        }
        MemUtil.MemUtilUnsafe.put(this, address);
        return this;
    }

    public Vector4d sub(Vector4dc v2) {
        this.x -= v2.x();
        this.y -= v2.y();
        this.z -= v2.z();
        this.w -= v2.w();
        return this;
    }

    public Vector4d sub(Vector4dc v2, Vector4d dest) {
        dest.x = this.x - v2.x();
        dest.y = this.y - v2.y();
        dest.z = this.z - v2.z();
        dest.w = this.w - v2.w();
        return dest;
    }

    public Vector4d sub(Vector4fc v2) {
        this.x -= (double)v2.x();
        this.y -= (double)v2.y();
        this.z -= (double)v2.z();
        this.w -= (double)v2.w();
        return this;
    }

    public Vector4d sub(Vector4fc v2, Vector4d dest) {
        dest.x = this.x - (double)v2.x();
        dest.y = this.y - (double)v2.y();
        dest.z = this.z - (double)v2.z();
        dest.w = this.w - (double)v2.w();
        return dest;
    }

    public Vector4d sub(double x2, double y2, double z2, double w2) {
        this.x -= x2;
        this.y -= y2;
        this.z -= z2;
        this.w -= w2;
        return this;
    }

    public Vector4d sub(double x2, double y2, double z2, double w2, Vector4d dest) {
        dest.x = this.x - x2;
        dest.y = this.y - y2;
        dest.z = this.z - z2;
        dest.w = this.w - w2;
        return dest;
    }

    public Vector4d add(Vector4dc v2) {
        this.x += v2.x();
        this.y += v2.y();
        this.z += v2.z();
        this.w += v2.w();
        return this;
    }

    public Vector4d add(Vector4dc v2, Vector4d dest) {
        dest.x = this.x + v2.x();
        dest.y = this.y + v2.y();
        dest.z = this.z + v2.z();
        dest.w = this.w + v2.w();
        return dest;
    }

    public Vector4d add(Vector4fc v2, Vector4d dest) {
        dest.x = this.x + (double)v2.x();
        dest.y = this.y + (double)v2.y();
        dest.z = this.z + (double)v2.z();
        dest.w = this.w + (double)v2.w();
        return dest;
    }

    public Vector4d add(double x2, double y2, double z2, double w2) {
        this.x += x2;
        this.y += y2;
        this.z += z2;
        this.w += w2;
        return this;
    }

    public Vector4d add(double x2, double y2, double z2, double w2, Vector4d dest) {
        dest.x = this.x + x2;
        dest.y = this.y + y2;
        dest.z = this.z + z2;
        dest.w = this.w + w2;
        return dest;
    }

    public Vector4d add(Vector4fc v2) {
        this.x += (double)v2.x();
        this.y += (double)v2.y();
        this.z += (double)v2.z();
        this.w += (double)v2.w();
        return this;
    }

    public Vector4d fma(Vector4dc a2, Vector4dc b2) {
        this.x = Math.fma(a2.x(), b2.x(), this.x);
        this.y = Math.fma(a2.y(), b2.y(), this.y);
        this.z = Math.fma(a2.z(), b2.z(), this.z);
        this.w = Math.fma(a2.w(), b2.w(), this.w);
        return this;
    }

    public Vector4d fma(double a2, Vector4dc b2) {
        this.x = Math.fma(a2, b2.x(), this.x);
        this.y = Math.fma(a2, b2.y(), this.y);
        this.z = Math.fma(a2, b2.z(), this.z);
        this.w = Math.fma(a2, b2.w(), this.w);
        return this;
    }

    public Vector4d fma(Vector4dc a2, Vector4dc b2, Vector4d dest) {
        dest.x = Math.fma(a2.x(), b2.x(), this.x);
        dest.y = Math.fma(a2.y(), b2.y(), this.y);
        dest.z = Math.fma(a2.z(), b2.z(), this.z);
        dest.w = Math.fma(a2.w(), b2.w(), this.w);
        return dest;
    }

    public Vector4d fma(double a2, Vector4dc b2, Vector4d dest) {
        dest.x = Math.fma(a2, b2.x(), this.x);
        dest.y = Math.fma(a2, b2.y(), this.y);
        dest.z = Math.fma(a2, b2.z(), this.z);
        dest.w = Math.fma(a2, b2.w(), this.w);
        return dest;
    }

    public Vector4d mulAdd(Vector4dc a2, Vector4dc b2) {
        this.x = Math.fma(this.x, a2.x(), b2.x());
        this.y = Math.fma(this.y, a2.y(), b2.y());
        this.z = Math.fma(this.z, a2.z(), b2.z());
        return this;
    }

    public Vector4d mulAdd(double a2, Vector4dc b2) {
        this.x = Math.fma(this.x, a2, b2.x());
        this.y = Math.fma(this.y, a2, b2.y());
        this.z = Math.fma(this.z, a2, b2.z());
        return this;
    }

    public Vector4d mulAdd(Vector4dc a2, Vector4dc b2, Vector4d dest) {
        dest.x = Math.fma(this.x, a2.x(), b2.x());
        dest.y = Math.fma(this.y, a2.y(), b2.y());
        dest.z = Math.fma(this.z, a2.z(), b2.z());
        return dest;
    }

    public Vector4d mulAdd(double a2, Vector4dc b2, Vector4d dest) {
        dest.x = Math.fma(this.x, a2, b2.x());
        dest.y = Math.fma(this.y, a2, b2.y());
        dest.z = Math.fma(this.z, a2, b2.z());
        return dest;
    }

    public Vector4d mul(Vector4dc v2) {
        this.x *= v2.x();
        this.y *= v2.y();
        this.z *= v2.z();
        this.w *= v2.w();
        return this;
    }

    public Vector4d mul(Vector4dc v2, Vector4d dest) {
        dest.x = this.x * v2.x();
        dest.y = this.y * v2.y();
        dest.z = this.z * v2.z();
        dest.w = this.w * v2.w();
        return dest;
    }

    public Vector4d div(Vector4dc v2) {
        this.x /= v2.x();
        this.y /= v2.y();
        this.z /= v2.z();
        this.w /= v2.w();
        return this;
    }

    public Vector4d div(Vector4dc v2, Vector4d dest) {
        dest.x = this.x / v2.x();
        dest.y = this.y / v2.y();
        dest.z = this.z / v2.z();
        dest.w = this.w / v2.w();
        return dest;
    }

    public Vector4d mul(Vector4fc v2) {
        this.x *= (double)v2.x();
        this.y *= (double)v2.y();
        this.z *= (double)v2.z();
        this.w *= (double)v2.w();
        return this;
    }

    public Vector4d mul(Vector4fc v2, Vector4d dest) {
        dest.x = this.x * (double)v2.x();
        dest.y = this.y * (double)v2.y();
        dest.z = this.z * (double)v2.z();
        dest.w = this.w * (double)v2.w();
        return dest;
    }

    public Vector4d mul(Matrix4dc mat) {
        if ((mat.properties() & 2) != 0) {
            return this.mulAffine(mat, this);
        }
        return this.mulGeneric(mat, this);
    }

    public Vector4d mul(Matrix4dc mat, Vector4d dest) {
        if ((mat.properties() & 2) != 0) {
            return this.mulAffine(mat, dest);
        }
        return this.mulGeneric(mat, dest);
    }

    public Vector4d mulTranspose(Matrix4dc mat) {
        if ((mat.properties() & 2) != 0) {
            return this.mulAffineTranspose(mat, this);
        }
        return this.mulGenericTranspose(mat, this);
    }

    public Vector4d mulTranspose(Matrix4dc mat, Vector4d dest) {
        if ((mat.properties() & 2) != 0) {
            return this.mulAffineTranspose(mat, dest);
        }
        return this.mulGenericTranspose(mat, dest);
    }

    public Vector4d mulAffine(Matrix4dc mat, Vector4d dest) {
        double rx = Math.fma(mat.m00(), this.x, Math.fma(mat.m10(), this.y, Math.fma(mat.m20(), this.z, mat.m30() * this.w)));
        double ry = Math.fma(mat.m01(), this.x, Math.fma(mat.m11(), this.y, Math.fma(mat.m21(), this.z, mat.m31() * this.w)));
        double rz = Math.fma(mat.m02(), this.x, Math.fma(mat.m12(), this.y, Math.fma(mat.m22(), this.z, mat.m32() * this.w)));
        dest.x = rx;
        dest.y = ry;
        dest.z = rz;
        dest.w = this.w;
        return dest;
    }

    private Vector4d mulGeneric(Matrix4dc mat, Vector4d dest) {
        double rx = Math.fma(mat.m00(), this.x, Math.fma(mat.m10(), this.y, Math.fma(mat.m20(), this.z, mat.m30() * this.w)));
        double ry = Math.fma(mat.m01(), this.x, Math.fma(mat.m11(), this.y, Math.fma(mat.m21(), this.z, mat.m31() * this.w)));
        double rz = Math.fma(mat.m02(), this.x, Math.fma(mat.m12(), this.y, Math.fma(mat.m22(), this.z, mat.m32() * this.w)));
        double rw = Math.fma(mat.m03(), this.x, Math.fma(mat.m13(), this.y, Math.fma(mat.m23(), this.z, mat.m33() * this.w)));
        dest.x = rx;
        dest.y = ry;
        dest.z = rz;
        dest.w = rw;
        return dest;
    }

    public Vector4d mulAffineTranspose(Matrix4dc mat, Vector4d dest) {
        double x2 = this.x;
        double y2 = this.y;
        double z2 = this.z;
        double w2 = this.w;
        dest.x = Math.fma(mat.m00(), x2, Math.fma(mat.m01(), y2, mat.m02() * z2));
        dest.y = Math.fma(mat.m10(), x2, Math.fma(mat.m11(), y2, mat.m12() * z2));
        dest.z = Math.fma(mat.m20(), x2, Math.fma(mat.m21(), y2, mat.m22() * z2));
        dest.w = Math.fma(mat.m30(), x2, Math.fma(mat.m31(), y2, mat.m32() * z2 + w2));
        return dest;
    }

    private Vector4d mulGenericTranspose(Matrix4dc mat, Vector4d dest) {
        double x2 = this.x;
        double y2 = this.y;
        double z2 = this.z;
        double w2 = this.w;
        dest.x = Math.fma(mat.m00(), x2, Math.fma(mat.m01(), y2, Math.fma(mat.m02(), z2, mat.m03() * w2)));
        dest.y = Math.fma(mat.m10(), x2, Math.fma(mat.m11(), y2, Math.fma(mat.m12(), z2, mat.m13() * w2)));
        dest.z = Math.fma(mat.m20(), x2, Math.fma(mat.m21(), y2, Math.fma(mat.m22(), z2, mat.m23() * w2)));
        dest.w = Math.fma(mat.m30(), x2, Math.fma(mat.m31(), y2, Math.fma(mat.m32(), z2, mat.m33() * w2)));
        return dest;
    }

    public Vector4d mul(Matrix4x3dc mat) {
        double rx = Math.fma(mat.m00(), this.x, Math.fma(mat.m10(), this.y, Math.fma(mat.m20(), this.z, mat.m30() * this.w)));
        double ry = Math.fma(mat.m01(), this.x, Math.fma(mat.m11(), this.y, Math.fma(mat.m21(), this.z, mat.m31() * this.w)));
        double rz = Math.fma(mat.m02(), this.x, Math.fma(mat.m12(), this.y, Math.fma(mat.m22(), this.z, mat.m32() * this.w)));
        this.x = rx;
        this.y = ry;
        this.z = rz;
        return this;
    }

    public Vector4d mul(Matrix4x3dc mat, Vector4d dest) {
        double rx = Math.fma(mat.m00(), this.x, Math.fma(mat.m10(), this.y, Math.fma(mat.m20(), this.z, mat.m30() * this.w)));
        double ry = Math.fma(mat.m01(), this.x, Math.fma(mat.m11(), this.y, Math.fma(mat.m21(), this.z, mat.m31() * this.w)));
        double rz = Math.fma(mat.m02(), this.x, Math.fma(mat.m12(), this.y, Math.fma(mat.m22(), this.z, mat.m32() * this.w)));
        dest.x = rx;
        dest.y = ry;
        dest.z = rz;
        dest.w = this.w;
        return dest;
    }

    public Vector4d mul(Matrix4x3fc mat) {
        double rx = Math.fma((double)mat.m00(), this.x, Math.fma((double)mat.m10(), this.y, Math.fma((double)mat.m20(), this.z, (double)mat.m30() * this.w)));
        double ry = Math.fma((double)mat.m01(), this.x, Math.fma((double)mat.m11(), this.y, Math.fma((double)mat.m21(), this.z, (double)mat.m31() * this.w)));
        double rz = Math.fma((double)mat.m02(), this.x, Math.fma((double)mat.m12(), this.y, Math.fma((double)mat.m22(), this.z, (double)mat.m32() * this.w)));
        this.x = rx;
        this.y = ry;
        this.z = rz;
        return this;
    }

    public Vector4d mul(Matrix4x3fc mat, Vector4d dest) {
        double rx = Math.fma((double)mat.m00(), this.x, Math.fma((double)mat.m10(), this.y, Math.fma((double)mat.m20(), this.z, (double)mat.m30() * this.w)));
        double ry = Math.fma((double)mat.m01(), this.x, Math.fma((double)mat.m11(), this.y, Math.fma((double)mat.m21(), this.z, (double)mat.m31() * this.w)));
        double rz = Math.fma((double)mat.m02(), this.x, Math.fma((double)mat.m12(), this.y, Math.fma((double)mat.m22(), this.z, (double)mat.m32() * this.w)));
        dest.x = rx;
        dest.y = ry;
        dest.z = rz;
        dest.w = this.w;
        return dest;
    }

    public Vector4d mul(Matrix4fc mat) {
        if ((mat.properties() & 2) != 0) {
            return this.mulAffine(mat, this);
        }
        return this.mulGeneric(mat, this);
    }

    public Vector4d mul(Matrix4fc mat, Vector4d dest) {
        if ((mat.properties() & 2) != 0) {
            return this.mulAffine(mat, dest);
        }
        return this.mulGeneric(mat, dest);
    }

    private Vector4d mulAffine(Matrix4fc mat, Vector4d dest) {
        double rx = Math.fma((double)mat.m00(), this.x, Math.fma((double)mat.m10(), this.y, Math.fma((double)mat.m20(), this.z, (double)mat.m30() * this.w)));
        double ry = Math.fma((double)mat.m01(), this.x, Math.fma((double)mat.m11(), this.y, Math.fma((double)mat.m21(), this.z, (double)mat.m31() * this.w)));
        double rz = Math.fma((double)mat.m02(), this.x, Math.fma((double)mat.m12(), this.y, Math.fma((double)mat.m22(), this.z, (double)mat.m32() * this.w)));
        dest.x = rx;
        dest.y = ry;
        dest.z = rz;
        dest.w = this.w;
        return dest;
    }

    private Vector4d mulGeneric(Matrix4fc mat, Vector4d dest) {
        double rx = Math.fma((double)mat.m00(), this.x, Math.fma((double)mat.m10(), this.y, Math.fma((double)mat.m20(), this.z, (double)mat.m30() * this.w)));
        double ry = Math.fma((double)mat.m01(), this.x, Math.fma((double)mat.m11(), this.y, Math.fma((double)mat.m21(), this.z, (double)mat.m31() * this.w)));
        double rz = Math.fma((double)mat.m02(), this.x, Math.fma((double)mat.m12(), this.y, Math.fma((double)mat.m22(), this.z, (double)mat.m32() * this.w)));
        double rw = Math.fma((double)mat.m03(), this.x, Math.fma((double)mat.m13(), this.y, Math.fma((double)mat.m23(), this.z, (double)mat.m33() * this.w)));
        dest.x = rx;
        dest.y = ry;
        dest.z = rz;
        dest.w = rw;
        return dest;
    }

    public Vector4d mulProject(Matrix4dc mat, Vector4d dest) {
        double invW = 1.0 / Math.fma(mat.m03(), this.x, Math.fma(mat.m13(), this.y, Math.fma(mat.m23(), this.z, mat.m33() * this.w)));
        double rx = Math.fma(mat.m00(), this.x, Math.fma(mat.m10(), this.y, Math.fma(mat.m20(), this.z, mat.m30() * this.w))) * invW;
        double ry = Math.fma(mat.m01(), this.x, Math.fma(mat.m11(), this.y, Math.fma(mat.m21(), this.z, mat.m31() * this.w))) * invW;
        double rz = Math.fma(mat.m02(), this.x, Math.fma(mat.m12(), this.y, Math.fma(mat.m22(), this.z, mat.m32() * this.w))) * invW;
        dest.x = rx;
        dest.y = ry;
        dest.z = rz;
        dest.w = 1.0;
        return dest;
    }

    public Vector4d mulProject(Matrix4dc mat) {
        double invW = 1.0 / Math.fma(mat.m03(), this.x, Math.fma(mat.m13(), this.y, Math.fma(mat.m23(), this.z, mat.m33() * this.w)));
        double rx = Math.fma(mat.m00(), this.x, Math.fma(mat.m10(), this.y, Math.fma(mat.m20(), this.z, mat.m30() * this.w))) * invW;
        double ry = Math.fma(mat.m01(), this.x, Math.fma(mat.m11(), this.y, Math.fma(mat.m21(), this.z, mat.m31() * this.w))) * invW;
        double rz = Math.fma(mat.m02(), this.x, Math.fma(mat.m12(), this.y, Math.fma(mat.m22(), this.z, mat.m32() * this.w))) * invW;
        this.x = rx;
        this.y = ry;
        this.z = rz;
        this.w = 1.0;
        return this;
    }

    public Vector3d mulProject(Matrix4dc mat, Vector3d dest) {
        double invW = 1.0 / Math.fma(mat.m03(), this.x, Math.fma(mat.m13(), this.y, Math.fma(mat.m23(), this.z, mat.m33() * this.w)));
        double rx = Math.fma(mat.m00(), this.x, Math.fma(mat.m10(), this.y, Math.fma(mat.m20(), this.z, mat.m30() * this.w))) * invW;
        double ry = Math.fma(mat.m01(), this.x, Math.fma(mat.m11(), this.y, Math.fma(mat.m21(), this.z, mat.m31() * this.w))) * invW;
        double rz = Math.fma(mat.m02(), this.x, Math.fma(mat.m12(), this.y, Math.fma(mat.m22(), this.z, mat.m32() * this.w))) * invW;
        dest.x = rx;
        dest.y = ry;
        dest.z = rz;
        return dest;
    }

    public Vector4d mul(double scalar) {
        this.x *= scalar;
        this.y *= scalar;
        this.z *= scalar;
        this.w *= scalar;
        return this;
    }

    public Vector4d mul(double scalar, Vector4d dest) {
        dest.x = this.x * scalar;
        dest.y = this.y * scalar;
        dest.z = this.z * scalar;
        dest.w = this.w * scalar;
        return dest;
    }

    public Vector4d div(double scalar) {
        double inv = 1.0 / scalar;
        this.x *= inv;
        this.y *= inv;
        this.z *= inv;
        this.w *= inv;
        return this;
    }

    public Vector4d div(double scalar, Vector4d dest) {
        double inv = 1.0 / scalar;
        dest.x = this.x * inv;
        dest.y = this.y * inv;
        dest.z = this.z * inv;
        dest.w = this.w * inv;
        return dest;
    }

    public Vector4d rotate(Quaterniondc quat) {
        quat.transform(this, this);
        return this;
    }

    public Vector4d rotate(Quaterniondc quat, Vector4d dest) {
        quat.transform(this, dest);
        return dest;
    }

    public Vector4d rotateAxis(double angle, double x2, double y2, double z2) {
        if (y2 == 0.0 && z2 == 0.0 && Math.absEqualsOne(x2)) {
            return this.rotateX(x2 * angle, this);
        }
        if (x2 == 0.0 && z2 == 0.0 && Math.absEqualsOne(y2)) {
            return this.rotateY(y2 * angle, this);
        }
        if (x2 == 0.0 && y2 == 0.0 && Math.absEqualsOne(z2)) {
            return this.rotateZ(z2 * angle, this);
        }
        return this.rotateAxisInternal(angle, x2, y2, z2, this);
    }

    public Vector4d rotateAxis(double angle, double aX, double aY, double aZ, Vector4d dest) {
        if (aY == 0.0 && aZ == 0.0 && Math.absEqualsOne(aX)) {
            return this.rotateX(aX * angle, dest);
        }
        if (aX == 0.0 && aZ == 0.0 && Math.absEqualsOne(aY)) {
            return this.rotateY(aY * angle, dest);
        }
        if (aX == 0.0 && aY == 0.0 && Math.absEqualsOne(aZ)) {
            return this.rotateZ(aZ * angle, dest);
        }
        return this.rotateAxisInternal(angle, aX, aY, aZ, dest);
    }

    private Vector4d rotateAxisInternal(double angle, double aX, double aY, double aZ, Vector4d dest) {
        double hangle = angle * 0.5;
        double sinAngle = Math.sin(hangle);
        double qx = aX * sinAngle;
        double qy = aY * sinAngle;
        double qz = aZ * sinAngle;
        double qw2 = Math.cosFromSin(sinAngle, hangle);
        double w2 = qw2 * qw2;
        double x2 = qx * qx;
        double y2 = qy * qy;
        double z2 = qz * qz;
        double zw = qz * qw2;
        double xy = qx * qy;
        double xz = qx * qz;
        double yw = qy * qw2;
        double yz = qy * qz;
        double xw = qx * qw2;
        double nx = (w2 + x2 - z2 - y2) * this.x + (-zw + xy - zw + xy) * this.y + (yw + xz + xz + yw) * this.z;
        double ny = (xy + zw + zw + xy) * this.x + (y2 - z2 + w2 - x2) * this.y + (yz + yz - xw - xw) * this.z;
        double nz = (xz - yw + xz - yw) * this.x + (yz + yz + xw + xw) * this.y + (z2 - y2 - x2 + w2) * this.z;
        dest.x = nx;
        dest.y = ny;
        dest.z = nz;
        return dest;
    }

    public Vector4d rotateX(double angle) {
        double sin = Math.sin(angle);
        double cos = Math.cosFromSin(sin, angle);
        double y2 = this.y * cos - this.z * sin;
        double z2 = this.y * sin + this.z * cos;
        this.y = y2;
        this.z = z2;
        return this;
    }

    public Vector4d rotateX(double angle, Vector4d dest) {
        double sin = Math.sin(angle);
        double cos = Math.cosFromSin(sin, angle);
        double y2 = this.y * cos - this.z * sin;
        double z2 = this.y * sin + this.z * cos;
        dest.x = this.x;
        dest.y = y2;
        dest.z = z2;
        dest.w = this.w;
        return dest;
    }

    public Vector4d rotateY(double angle) {
        double sin = Math.sin(angle);
        double cos = Math.cosFromSin(sin, angle);
        double x2 = this.x * cos + this.z * sin;
        double z2 = -this.x * sin + this.z * cos;
        this.x = x2;
        this.z = z2;
        return this;
    }

    public Vector4d rotateY(double angle, Vector4d dest) {
        double sin = Math.sin(angle);
        double cos = Math.cosFromSin(sin, angle);
        double x2 = this.x * cos + this.z * sin;
        double z2 = -this.x * sin + this.z * cos;
        dest.x = x2;
        dest.y = this.y;
        dest.z = z2;
        dest.w = this.w;
        return dest;
    }

    public Vector4d rotateZ(double angle) {
        double sin = Math.sin(angle);
        double cos = Math.cosFromSin(sin, angle);
        double x2 = this.x * cos - this.y * sin;
        double y2 = this.x * sin + this.y * cos;
        this.x = x2;
        this.y = y2;
        return this;
    }

    public Vector4d rotateZ(double angle, Vector4d dest) {
        double sin = Math.sin(angle);
        double cos = Math.cosFromSin(sin, angle);
        double x2 = this.x * cos - this.y * sin;
        double y2 = this.x * sin + this.y * cos;
        dest.x = x2;
        dest.y = y2;
        dest.z = this.z;
        dest.w = this.w;
        return dest;
    }

    public double lengthSquared() {
        return Math.fma(this.x, this.x, Math.fma(this.y, this.y, Math.fma(this.z, this.z, this.w * this.w)));
    }

    public static double lengthSquared(double x2, double y2, double z2, double w2) {
        return Math.fma(x2, x2, Math.fma(y2, y2, Math.fma(z2, z2, w2 * w2)));
    }

    public double length() {
        return Math.sqrt(Math.fma(this.x, this.x, Math.fma(this.y, this.y, Math.fma(this.z, this.z, this.w * this.w))));
    }

    public static double length(double x2, double y2, double z2, double w2) {
        return Math.sqrt(Math.fma(x2, x2, Math.fma(y2, y2, Math.fma(z2, z2, w2 * w2))));
    }

    public Vector4d normalize() {
        double invLength = 1.0 / this.length();
        this.x *= invLength;
        this.y *= invLength;
        this.z *= invLength;
        this.w *= invLength;
        return this;
    }

    public Vector4d normalize(Vector4d dest) {
        double invLength = 1.0 / this.length();
        dest.x = this.x * invLength;
        dest.y = this.y * invLength;
        dest.z = this.z * invLength;
        dest.w = this.w * invLength;
        return dest;
    }

    public Vector4d normalize(double length) {
        double invLength = 1.0 / this.length() * length;
        this.x *= invLength;
        this.y *= invLength;
        this.z *= invLength;
        this.w *= invLength;
        return this;
    }

    public Vector4d normalize(double length, Vector4d dest) {
        double invLength = 1.0 / this.length() * length;
        dest.x = this.x * invLength;
        dest.y = this.y * invLength;
        dest.z = this.z * invLength;
        dest.w = this.w * invLength;
        return dest;
    }

    public Vector4d normalize3() {
        double invLength = Math.invsqrt(Math.fma(this.x, this.x, Math.fma(this.y, this.y, this.z * this.z)));
        this.x *= invLength;
        this.y *= invLength;
        this.z *= invLength;
        this.w *= invLength;
        return this;
    }

    public Vector4d normalize3(Vector4d dest) {
        double invLength = Math.invsqrt(Math.fma(this.x, this.x, Math.fma(this.y, this.y, this.z * this.z)));
        dest.x = this.x * invLength;
        dest.y = this.y * invLength;
        dest.z = this.z * invLength;
        dest.w = this.w * invLength;
        return dest;
    }

    public double distance(Vector4dc v2) {
        double dx2 = this.x - v2.x();
        double dy2 = this.y - v2.y();
        double dz2 = this.z - v2.z();
        double dw2 = this.w - v2.w();
        return Math.sqrt(Math.fma(dx2, dx2, Math.fma(dy2, dy2, Math.fma(dz2, dz2, dw2 * dw2))));
    }

    public double distance(double x2, double y2, double z2, double w2) {
        double dx2 = this.x - x2;
        double dy2 = this.y - y2;
        double dz2 = this.z - z2;
        double dw2 = this.w - w2;
        return Math.sqrt(Math.fma(dx2, dx2, Math.fma(dy2, dy2, Math.fma(dz2, dz2, dw2 * dw2))));
    }

    public double distanceSquared(Vector4dc v2) {
        double dx2 = this.x - v2.x();
        double dy2 = this.y - v2.y();
        double dz2 = this.z - v2.z();
        double dw2 = this.w - v2.w();
        return Math.fma(dx2, dx2, Math.fma(dy2, dy2, Math.fma(dz2, dz2, dw2 * dw2)));
    }

    public double distanceSquared(double x2, double y2, double z2, double w2) {
        double dx2 = this.x - x2;
        double dy2 = this.y - y2;
        double dz2 = this.z - z2;
        double dw2 = this.w - w2;
        return Math.fma(dx2, dx2, Math.fma(dy2, dy2, Math.fma(dz2, dz2, dw2 * dw2)));
    }

    public static double distance(double x1, double y1, double z1, double w1, double x2, double y2, double z2, double w2) {
        double dx2 = x1 - x2;
        double dy2 = y1 - y2;
        double dz2 = z1 - z2;
        double dw2 = w1 - w2;
        return Math.sqrt(Math.fma(dx2, dx2, Math.fma(dy2, dy2, Math.fma(dz2, dz2, dw2 * dw2))));
    }

    public static double distanceSquared(double x1, double y1, double z1, double w1, double x2, double y2, double z2, double w2) {
        double dx2 = x1 - x2;
        double dy2 = y1 - y2;
        double dz2 = z1 - z2;
        double dw2 = w1 - w2;
        return Math.fma(dx2, dx2, Math.fma(dy2, dy2, Math.fma(dz2, dz2, dw2 * dw2)));
    }

    public double dot(Vector4dc v2) {
        return Math.fma(this.x, v2.x(), Math.fma(this.y, v2.y(), Math.fma(this.z, v2.z(), this.w * v2.w())));
    }

    public double dot(double x2, double y2, double z2, double w2) {
        return Math.fma(this.x, x2, Math.fma(this.y, y2, Math.fma(this.z, z2, this.w * w2)));
    }

    public double angleCos(Vector4dc v2) {
        double length1Squared = Math.fma(this.x, this.x, Math.fma(this.y, this.y, Math.fma(this.z, this.z, this.w * this.w)));
        double length2Squared = Math.fma(v2.x(), v2.x(), Math.fma(v2.y(), v2.y(), Math.fma(v2.z(), v2.z(), v2.w() * v2.w())));
        double dot = Math.fma(this.x, v2.x(), Math.fma(this.y, v2.y(), Math.fma(this.z, v2.z(), this.w * v2.w())));
        return dot / Math.sqrt(length1Squared * length2Squared);
    }

    public double angle(Vector4dc v2) {
        double cos = this.angleCos(v2);
        cos = cos < 1.0 ? cos : 1.0;
        cos = cos > -1.0 ? cos : -1.0;
        return Math.acos(cos);
    }

    public Vector4d zero() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.w = 0.0;
        return this;
    }

    public Vector4d negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        this.w = -this.w;
        return this;
    }

    public Vector4d negate(Vector4d dest) {
        dest.x = -this.x;
        dest.y = -this.y;
        dest.z = -this.z;
        dest.w = -this.w;
        return dest;
    }

    public Vector4d min(Vector4dc v2) {
        this.x = this.x < v2.x() ? this.x : v2.x();
        this.y = this.y < v2.y() ? this.y : v2.y();
        this.z = this.z < v2.z() ? this.z : v2.z();
        this.w = this.w < v2.w() ? this.w : v2.w();
        return this;
    }

    public Vector4d min(Vector4dc v2, Vector4d dest) {
        dest.x = this.x < v2.x() ? this.x : v2.x();
        dest.y = this.y < v2.y() ? this.y : v2.y();
        dest.z = this.z < v2.z() ? this.z : v2.z();
        dest.w = this.w < v2.w() ? this.w : v2.w();
        return dest;
    }

    public Vector4d max(Vector4dc v2) {
        this.x = this.x > v2.x() ? this.x : v2.x();
        this.y = this.y > v2.y() ? this.y : v2.y();
        this.z = this.z > v2.z() ? this.z : v2.z();
        this.w = this.w > v2.w() ? this.w : v2.w();
        return this;
    }

    public Vector4d max(Vector4dc v2, Vector4d dest) {
        dest.x = this.x > v2.x() ? this.x : v2.x();
        dest.y = this.y > v2.y() ? this.y : v2.y();
        dest.z = this.z > v2.z() ? this.z : v2.z();
        dest.w = this.w > v2.w() ? this.w : v2.w();
        return dest;
    }

    public String toString() {
        return Runtime.formatNumbers(this.toString(Options.NUMBER_FORMAT));
    }

    public String toString(NumberFormat formatter) {
        return "(" + Runtime.format(this.x, formatter) + " " + Runtime.format(this.y, formatter) + " " + Runtime.format(this.z, formatter) + " " + Runtime.format(this.w, formatter) + ")";
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeDouble(this.x);
        out.writeDouble(this.y);
        out.writeDouble(this.z);
        out.writeDouble(this.w);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.x = in.readDouble();
        this.y = in.readDouble();
        this.z = in.readDouble();
        this.w = in.readDouble();
    }

    public int hashCode() {
        int prime = 31;
        int result = 1;
        long temp = Double.doubleToLongBits(this.w);
        result = 31 * result + (int)(temp ^ temp >>> 32);
        temp = Double.doubleToLongBits(this.x);
        result = 31 * result + (int)(temp ^ temp >>> 32);
        temp = Double.doubleToLongBits(this.y);
        result = 31 * result + (int)(temp ^ temp >>> 32);
        temp = Double.doubleToLongBits(this.z);
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
        Vector4d other = (Vector4d)obj;
        if (Double.doubleToLongBits(this.w) != Double.doubleToLongBits(other.w)) {
            return false;
        }
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        return Double.doubleToLongBits(this.z) == Double.doubleToLongBits(other.z);
    }

    public boolean equals(Vector4dc v2, double delta) {
        if (this == v2) {
            return true;
        }
        if (v2 == null) {
            return false;
        }
        if (!(v2 instanceof Vector4dc)) {
            return false;
        }
        if (!Runtime.equals(this.x, v2.x(), delta)) {
            return false;
        }
        if (!Runtime.equals(this.y, v2.y(), delta)) {
            return false;
        }
        if (!Runtime.equals(this.z, v2.z(), delta)) {
            return false;
        }
        return Runtime.equals(this.w, v2.w(), delta);
    }

    public boolean equals(double x2, double y2, double z2, double w2) {
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(x2)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(y2)) {
            return false;
        }
        if (Double.doubleToLongBits(this.z) != Double.doubleToLongBits(z2)) {
            return false;
        }
        return Double.doubleToLongBits(this.w) == Double.doubleToLongBits(w2);
    }

    public Vector4d smoothStep(Vector4dc v2, double t2, Vector4d dest) {
        double t22 = t2 * t2;
        double t3 = t22 * t2;
        dest.x = (this.x + this.x - v2.x() - v2.x()) * t3 + (3.0 * v2.x() - 3.0 * this.x) * t22 + this.x * t2 + this.x;
        dest.y = (this.y + this.y - v2.y() - v2.y()) * t3 + (3.0 * v2.y() - 3.0 * this.y) * t22 + this.y * t2 + this.y;
        dest.z = (this.z + this.z - v2.z() - v2.z()) * t3 + (3.0 * v2.z() - 3.0 * this.z) * t22 + this.z * t2 + this.z;
        dest.w = (this.w + this.w - v2.w() - v2.w()) * t3 + (3.0 * v2.w() - 3.0 * this.w) * t22 + this.w * t2 + this.w;
        return dest;
    }

    public Vector4d hermite(Vector4dc t0, Vector4dc v1, Vector4dc t1, double t2, Vector4d dest) {
        double t22 = t2 * t2;
        double t3 = t22 * t2;
        dest.x = (this.x + this.x - v1.x() - v1.x() + t1.x() + t0.x()) * t3 + (3.0 * v1.x() - 3.0 * this.x - t0.x() - t0.x() - t1.x()) * t22 + this.x * t2 + this.x;
        dest.y = (this.y + this.y - v1.y() - v1.y() + t1.y() + t0.y()) * t3 + (3.0 * v1.y() - 3.0 * this.y - t0.y() - t0.y() - t1.y()) * t22 + this.y * t2 + this.y;
        dest.z = (this.z + this.z - v1.z() - v1.z() + t1.z() + t0.z()) * t3 + (3.0 * v1.z() - 3.0 * this.z - t0.z() - t0.z() - t1.z()) * t22 + this.z * t2 + this.z;
        dest.w = (this.w + this.w - v1.w() - v1.w() + t1.w() + t0.w()) * t3 + (3.0 * v1.w() - 3.0 * this.w - t0.w() - t0.w() - t1.w()) * t22 + this.w * t2 + this.w;
        return dest;
    }

    public Vector4d lerp(Vector4dc other, double t2) {
        this.x = Math.fma(other.x() - this.x, t2, this.x);
        this.y = Math.fma(other.y() - this.y, t2, this.y);
        this.z = Math.fma(other.z() - this.z, t2, this.z);
        this.w = Math.fma(other.w() - this.w, t2, this.w);
        return this;
    }

    public Vector4d lerp(Vector4dc other, double t2, Vector4d dest) {
        dest.x = Math.fma(other.x() - this.x, t2, this.x);
        dest.y = Math.fma(other.y() - this.y, t2, this.y);
        dest.z = Math.fma(other.z() - this.z, t2, this.z);
        dest.w = Math.fma(other.w() - this.w, t2, this.w);
        return dest;
    }

    public double get(int component) throws IllegalArgumentException {
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

    public Vector4i get(int mode, Vector4i dest) {
        dest.x = Math.roundUsing(this.x(), mode);
        dest.y = Math.roundUsing(this.y(), mode);
        dest.z = Math.roundUsing(this.z(), mode);
        dest.w = Math.roundUsing(this.w(), mode);
        return dest;
    }

    public Vector4f get(Vector4f dest) {
        dest.x = (float)this.x();
        dest.y = (float)this.y();
        dest.z = (float)this.z();
        dest.w = (float)this.w();
        return dest;
    }

    public Vector4d get(Vector4d dest) {
        dest.x = this.x();
        dest.y = this.y();
        dest.z = this.z();
        dest.w = this.w();
        return dest;
    }

    public int maxComponent() {
        double absX = Math.abs(this.x);
        double absY = Math.abs(this.y);
        double absZ = Math.abs(this.z);
        double absW = Math.abs(this.w);
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
        double absX = Math.abs(this.x);
        double absY = Math.abs(this.y);
        double absZ = Math.abs(this.z);
        double absW = Math.abs(this.w);
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

    public Vector4d floor() {
        this.x = Math.floor(this.x);
        this.y = Math.floor(this.y);
        this.z = Math.floor(this.z);
        this.w = Math.floor(this.w);
        return this;
    }

    public Vector4d floor(Vector4d dest) {
        dest.x = Math.floor(this.x);
        dest.y = Math.floor(this.y);
        dest.z = Math.floor(this.z);
        dest.w = Math.floor(this.w);
        return dest;
    }

    public Vector4d ceil() {
        this.x = Math.ceil(this.x);
        this.y = Math.ceil(this.y);
        this.z = Math.ceil(this.z);
        this.w = Math.ceil(this.w);
        return this;
    }

    public Vector4d ceil(Vector4d dest) {
        dest.x = Math.ceil(this.x);
        dest.y = Math.ceil(this.y);
        dest.z = Math.ceil(this.z);
        dest.w = Math.ceil(this.w);
        return dest;
    }

    public Vector4d round() {
        this.x = Math.round(this.x);
        this.y = Math.round(this.y);
        this.z = Math.round(this.z);
        this.w = Math.round(this.w);
        return this;
    }

    public Vector4d round(Vector4d dest) {
        dest.x = Math.round(this.x);
        dest.y = Math.round(this.y);
        dest.z = Math.round(this.z);
        dest.w = Math.round(this.w);
        return dest;
    }

    public boolean isFinite() {
        return Math.isFinite(this.x) && Math.isFinite(this.y) && Math.isFinite(this.z) && Math.isFinite(this.w);
    }

    public Vector4d absolute() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
        this.w = Math.abs(this.w);
        return this;
    }

    public Vector4d absolute(Vector4d dest) {
        dest.x = Math.abs(this.x);
        dest.y = Math.abs(this.y);
        dest.z = Math.abs(this.z);
        dest.w = Math.abs(this.w);
        return dest;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

