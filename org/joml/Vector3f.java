/*
 * Decompiled with CFR 0.152.
 */
package org.joml;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.text.NumberFormat;
import org.joml.Math;
import org.joml.Matrix3dc;
import org.joml.Matrix3fc;
import org.joml.Matrix3x2fc;
import org.joml.Matrix4dc;
import org.joml.Matrix4fc;
import org.joml.Matrix4x3fc;
import org.joml.MemUtil;
import org.joml.Options;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Runtime;
import org.joml.Vector2dc;
import org.joml.Vector2fc;
import org.joml.Vector2ic;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3fc;
import org.joml.Vector3i;
import org.joml.Vector3ic;

public class Vector3f
implements Externalizable,
Cloneable,
Vector3fc {
    private static final long serialVersionUID = 1L;
    public float x;
    public float y;
    public float z;

    public Vector3f() {
    }

    public Vector3f(float d2) {
        this.x = d2;
        this.y = d2;
        this.z = d2;
    }

    public Vector3f(float x2, float y2, float z2) {
        this.x = x2;
        this.y = y2;
        this.z = z2;
    }

    public Vector3f(Vector3fc v2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = v2.z();
    }

    public Vector3f(Vector3ic v2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = v2.z();
    }

    public Vector3f(Vector2fc v2, float z2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = z2;
    }

    public Vector3f(Vector2ic v2, float z2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = z2;
    }

    public Vector3f(float[] xyz) {
        this.x = xyz[0];
        this.y = xyz[1];
        this.z = xyz[2];
    }

    public Vector3f(ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
    }

    public Vector3f(int index, ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
    }

    public Vector3f(FloatBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
    }

    public Vector3f(int index, FloatBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
    }

    public float x() {
        return this.x;
    }

    public float y() {
        return this.y;
    }

    public float z() {
        return this.z;
    }

    public Vector3f set(Vector3fc v2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = v2.z();
        return this;
    }

    public Vector3f set(Vector3dc v2) {
        this.x = (float)v2.x();
        this.y = (float)v2.y();
        this.z = (float)v2.z();
        return this;
    }

    public Vector3f set(Vector3ic v2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = v2.z();
        return this;
    }

    public Vector3f set(Vector2fc v2, float z2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = z2;
        return this;
    }

    public Vector3f set(Vector2dc v2, float z2) {
        this.x = (float)v2.x();
        this.y = (float)v2.y();
        this.z = z2;
        return this;
    }

    public Vector3f set(Vector2ic v2, float z2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = z2;
        return this;
    }

    public Vector3f set(float d2) {
        this.x = d2;
        this.y = d2;
        this.z = d2;
        return this;
    }

    public Vector3f set(float x2, float y2, float z2) {
        this.x = x2;
        this.y = y2;
        this.z = z2;
        return this;
    }

    public Vector3f set(double d2) {
        this.x = (float)d2;
        this.y = (float)d2;
        this.z = (float)d2;
        return this;
    }

    public Vector3f set(double x2, double y2, double z2) {
        this.x = (float)x2;
        this.y = (float)y2;
        this.z = (float)z2;
        return this;
    }

    public Vector3f set(float[] xyz) {
        this.x = xyz[0];
        this.y = xyz[1];
        this.z = xyz[2];
        return this;
    }

    public Vector3f set(ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
        return this;
    }

    public Vector3f set(int index, ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
        return this;
    }

    public Vector3f set(FloatBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
        return this;
    }

    public Vector3f set(int index, FloatBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
        return this;
    }

    public Vector3f setFromAddress(long address) {
        if (Options.NO_UNSAFE) {
            throw new UnsupportedOperationException("Not supported when using joml.nounsafe");
        }
        MemUtil.MemUtilUnsafe.get(this, address);
        return this;
    }

    public Vector3f setComponent(int component, float value) throws IllegalArgumentException {
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

    public FloatBuffer get(FloatBuffer buffer) {
        MemUtil.INSTANCE.put(this, buffer.position(), buffer);
        return buffer;
    }

    public FloatBuffer get(int index, FloatBuffer buffer) {
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

    public Vector3fc getToAddress(long address) {
        if (Options.NO_UNSAFE) {
            throw new UnsupportedOperationException("Not supported when using joml.nounsafe");
        }
        MemUtil.MemUtilUnsafe.put(this, address);
        return this;
    }

    public Vector3f sub(Vector3fc v2) {
        this.x -= v2.x();
        this.y -= v2.y();
        this.z -= v2.z();
        return this;
    }

    public Vector3f sub(Vector3fc v2, Vector3f dest) {
        dest.x = this.x - v2.x();
        dest.y = this.y - v2.y();
        dest.z = this.z - v2.z();
        return dest;
    }

    public Vector3f sub(float x2, float y2, float z2) {
        this.x -= x2;
        this.y -= y2;
        this.z -= z2;
        return this;
    }

    public Vector3f sub(float x2, float y2, float z2, Vector3f dest) {
        dest.x = this.x - x2;
        dest.y = this.y - y2;
        dest.z = this.z - z2;
        return dest;
    }

    public Vector3f add(Vector3fc v2) {
        this.x += v2.x();
        this.y += v2.y();
        this.z += v2.z();
        return this;
    }

    public Vector3f add(Vector3fc v2, Vector3f dest) {
        dest.x = this.x + v2.x();
        dest.y = this.y + v2.y();
        dest.z = this.z + v2.z();
        return dest;
    }

    public Vector3f add(float x2, float y2, float z2) {
        this.x += x2;
        this.y += y2;
        this.z += z2;
        return this;
    }

    public Vector3f add(float x2, float y2, float z2, Vector3f dest) {
        dest.x = this.x + x2;
        dest.y = this.y + y2;
        dest.z = this.z + z2;
        return dest;
    }

    public Vector3f fma(Vector3fc a2, Vector3fc b2) {
        this.x = Math.fma(a2.x(), b2.x(), this.x);
        this.y = Math.fma(a2.y(), b2.y(), this.y);
        this.z = Math.fma(a2.z(), b2.z(), this.z);
        return this;
    }

    public Vector3f fma(float a2, Vector3fc b2) {
        this.x = Math.fma(a2, b2.x(), this.x);
        this.y = Math.fma(a2, b2.y(), this.y);
        this.z = Math.fma(a2, b2.z(), this.z);
        return this;
    }

    public Vector3f fma(Vector3fc a2, Vector3fc b2, Vector3f dest) {
        dest.x = Math.fma(a2.x(), b2.x(), this.x);
        dest.y = Math.fma(a2.y(), b2.y(), this.y);
        dest.z = Math.fma(a2.z(), b2.z(), this.z);
        return dest;
    }

    public Vector3f fma(float a2, Vector3fc b2, Vector3f dest) {
        dest.x = Math.fma(a2, b2.x(), this.x);
        dest.y = Math.fma(a2, b2.y(), this.y);
        dest.z = Math.fma(a2, b2.z(), this.z);
        return dest;
    }

    public Vector3f mulAdd(Vector3fc a2, Vector3fc b2) {
        this.x = Math.fma(this.x, a2.x(), b2.x());
        this.y = Math.fma(this.y, a2.y(), b2.y());
        this.z = Math.fma(this.z, a2.z(), b2.z());
        return this;
    }

    public Vector3f mulAdd(float a2, Vector3fc b2) {
        this.x = Math.fma(this.x, a2, b2.x());
        this.y = Math.fma(this.y, a2, b2.y());
        this.z = Math.fma(this.z, a2, b2.z());
        return this;
    }

    public Vector3f mulAdd(Vector3fc a2, Vector3fc b2, Vector3f dest) {
        dest.x = Math.fma(this.x, a2.x(), b2.x());
        dest.y = Math.fma(this.y, a2.y(), b2.y());
        dest.z = Math.fma(this.z, a2.z(), b2.z());
        return dest;
    }

    public Vector3f mulAdd(float a2, Vector3fc b2, Vector3f dest) {
        dest.x = Math.fma(this.x, a2, b2.x());
        dest.y = Math.fma(this.y, a2, b2.y());
        dest.z = Math.fma(this.z, a2, b2.z());
        return dest;
    }

    public Vector3f mul(Vector3fc v2) {
        this.x *= v2.x();
        this.y *= v2.y();
        this.z *= v2.z();
        return this;
    }

    public Vector3f mul(Vector3fc v2, Vector3f dest) {
        dest.x = this.x * v2.x();
        dest.y = this.y * v2.y();
        dest.z = this.z * v2.z();
        return dest;
    }

    public Vector3f div(Vector3fc v2) {
        this.x /= v2.x();
        this.y /= v2.y();
        this.z /= v2.z();
        return this;
    }

    public Vector3f div(Vector3fc v2, Vector3f dest) {
        dest.x = this.x / v2.x();
        dest.y = this.y / v2.y();
        dest.z = this.z / v2.z();
        return dest;
    }

    public Vector3f mulProject(Matrix4fc mat, Vector3f dest) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        float invW = 1.0f / Math.fma(mat.m03(), x2, Math.fma(mat.m13(), y2, Math.fma(mat.m23(), z2, mat.m33())));
        dest.x = Math.fma(mat.m00(), x2, Math.fma(mat.m10(), y2, Math.fma(mat.m20(), z2, mat.m30()))) * invW;
        dest.y = Math.fma(mat.m01(), x2, Math.fma(mat.m11(), y2, Math.fma(mat.m21(), z2, mat.m31()))) * invW;
        dest.z = Math.fma(mat.m02(), x2, Math.fma(mat.m12(), y2, Math.fma(mat.m22(), z2, mat.m32()))) * invW;
        return dest;
    }

    public Vector3f mulProject(Matrix4fc mat, float w2, Vector3f dest) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        float invW = 1.0f / Math.fma(mat.m03(), x2, Math.fma(mat.m13(), y2, Math.fma(mat.m23(), z2, mat.m33() * w2)));
        dest.x = Math.fma(mat.m00(), x2, Math.fma(mat.m10(), y2, Math.fma(mat.m20(), z2, mat.m30() * w2))) * invW;
        dest.y = Math.fma(mat.m01(), x2, Math.fma(mat.m11(), y2, Math.fma(mat.m21(), z2, mat.m31() * w2))) * invW;
        dest.z = Math.fma(mat.m02(), x2, Math.fma(mat.m12(), y2, Math.fma(mat.m22(), z2, mat.m32() * w2))) * invW;
        return dest;
    }

    public Vector3f mulProject(Matrix4fc mat) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        float invW = 1.0f / Math.fma(mat.m03(), x2, Math.fma(mat.m13(), y2, Math.fma(mat.m23(), z2, mat.m33())));
        this.x = Math.fma(mat.m00(), x2, Math.fma(mat.m10(), y2, Math.fma(mat.m20(), z2, mat.m30()))) * invW;
        this.y = Math.fma(mat.m01(), x2, Math.fma(mat.m11(), y2, Math.fma(mat.m21(), z2, mat.m31()))) * invW;
        this.z = Math.fma(mat.m02(), x2, Math.fma(mat.m12(), y2, Math.fma(mat.m22(), z2, mat.m32()))) * invW;
        return this;
    }

    public Vector3f mul(Matrix3fc mat) {
        float lx = this.x;
        float ly = this.y;
        float lz = this.z;
        this.x = Math.fma(mat.m00(), lx, Math.fma(mat.m10(), ly, mat.m20() * lz));
        this.y = Math.fma(mat.m01(), lx, Math.fma(mat.m11(), ly, mat.m21() * lz));
        this.z = Math.fma(mat.m02(), lx, Math.fma(mat.m12(), ly, mat.m22() * lz));
        return this;
    }

    public Vector3f mul(Matrix3fc mat, Vector3f dest) {
        float lx = this.x;
        float ly = this.y;
        float lz = this.z;
        dest.x = Math.fma(mat.m00(), lx, Math.fma(mat.m10(), ly, mat.m20() * lz));
        dest.y = Math.fma(mat.m01(), lx, Math.fma(mat.m11(), ly, mat.m21() * lz));
        dest.z = Math.fma(mat.m02(), lx, Math.fma(mat.m12(), ly, mat.m22() * lz));
        return dest;
    }

    public Vector3f mul(Matrix3dc mat) {
        float lx = this.x;
        float ly = this.y;
        float lz = this.z;
        this.x = (float)Math.fma(mat.m00(), (double)lx, Math.fma(mat.m10(), (double)ly, mat.m20() * (double)lz));
        this.y = (float)Math.fma(mat.m01(), (double)lx, Math.fma(mat.m11(), (double)ly, mat.m21() * (double)lz));
        this.z = (float)Math.fma(mat.m02(), (double)lx, Math.fma(mat.m12(), (double)ly, mat.m22() * (double)lz));
        return this;
    }

    public Vector3f mul(Matrix3dc mat, Vector3f dest) {
        float lx = this.x;
        float ly = this.y;
        float lz = this.z;
        dest.x = (float)Math.fma(mat.m00(), (double)lx, Math.fma(mat.m10(), (double)ly, mat.m20() * (double)lz));
        dest.y = (float)Math.fma(mat.m01(), (double)lx, Math.fma(mat.m11(), (double)ly, mat.m21() * (double)lz));
        dest.z = (float)Math.fma(mat.m02(), (double)lx, Math.fma(mat.m12(), (double)ly, mat.m22() * (double)lz));
        return dest;
    }

    public Vector3f mul(Matrix3x2fc mat) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        this.x = Math.fma(mat.m00(), x2, Math.fma(mat.m10(), y2, mat.m20() * z2));
        this.y = Math.fma(mat.m01(), x2, Math.fma(mat.m11(), y2, mat.m21() * z2));
        this.z = z2;
        return this;
    }

    public Vector3f mul(Matrix3x2fc mat, Vector3f dest) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        dest.x = Math.fma(mat.m00(), x2, Math.fma(mat.m10(), y2, mat.m20() * z2));
        dest.y = Math.fma(mat.m01(), x2, Math.fma(mat.m11(), y2, mat.m21() * z2));
        dest.z = z2;
        return dest;
    }

    public Vector3f mulTranspose(Matrix3fc mat) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        this.x = Math.fma(mat.m00(), x2, Math.fma(mat.m01(), y2, mat.m02() * z2));
        this.y = Math.fma(mat.m10(), x2, Math.fma(mat.m11(), y2, mat.m12() * z2));
        this.z = Math.fma(mat.m20(), x2, Math.fma(mat.m21(), y2, mat.m22() * z2));
        return this;
    }

    public Vector3f mulTranspose(Matrix3fc mat, Vector3f dest) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        dest.x = Math.fma(mat.m00(), x2, Math.fma(mat.m01(), y2, mat.m02() * z2));
        dest.y = Math.fma(mat.m10(), x2, Math.fma(mat.m11(), y2, mat.m12() * z2));
        dest.z = Math.fma(mat.m20(), x2, Math.fma(mat.m21(), y2, mat.m22() * z2));
        return dest;
    }

    public Vector3f mulPosition(Matrix4fc mat) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        this.x = Math.fma(mat.m00(), x2, Math.fma(mat.m10(), y2, Math.fma(mat.m20(), z2, mat.m30())));
        this.y = Math.fma(mat.m01(), x2, Math.fma(mat.m11(), y2, Math.fma(mat.m21(), z2, mat.m31())));
        this.z = Math.fma(mat.m02(), x2, Math.fma(mat.m12(), y2, Math.fma(mat.m22(), z2, mat.m32())));
        return this;
    }

    public Vector3f mulPosition(Matrix4x3fc mat) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        this.x = Math.fma(mat.m00(), x2, Math.fma(mat.m10(), y2, Math.fma(mat.m20(), z2, mat.m30())));
        this.y = Math.fma(mat.m01(), x2, Math.fma(mat.m11(), y2, Math.fma(mat.m21(), z2, mat.m31())));
        this.z = Math.fma(mat.m02(), x2, Math.fma(mat.m12(), y2, Math.fma(mat.m22(), z2, mat.m32())));
        return this;
    }

    public Vector3f mulPosition(Matrix4fc mat, Vector3f dest) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        dest.x = Math.fma(mat.m00(), x2, Math.fma(mat.m10(), y2, Math.fma(mat.m20(), z2, mat.m30())));
        dest.y = Math.fma(mat.m01(), x2, Math.fma(mat.m11(), y2, Math.fma(mat.m21(), z2, mat.m31())));
        dest.z = Math.fma(mat.m02(), x2, Math.fma(mat.m12(), y2, Math.fma(mat.m22(), z2, mat.m32())));
        return dest;
    }

    public Vector3f mulPosition(Matrix4x3fc mat, Vector3f dest) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        dest.x = Math.fma(mat.m00(), x2, Math.fma(mat.m10(), y2, Math.fma(mat.m20(), z2, mat.m30())));
        dest.y = Math.fma(mat.m01(), x2, Math.fma(mat.m11(), y2, Math.fma(mat.m21(), z2, mat.m31())));
        dest.z = Math.fma(mat.m02(), x2, Math.fma(mat.m12(), y2, Math.fma(mat.m22(), z2, mat.m32())));
        return dest;
    }

    public Vector3f mulTransposePosition(Matrix4fc mat) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        this.x = Math.fma(mat.m00(), x2, Math.fma(mat.m01(), y2, Math.fma(mat.m02(), z2, mat.m03())));
        this.y = Math.fma(mat.m10(), x2, Math.fma(mat.m11(), y2, Math.fma(mat.m12(), z2, mat.m13())));
        this.z = Math.fma(mat.m20(), x2, Math.fma(mat.m21(), y2, Math.fma(mat.m22(), z2, mat.m23())));
        return this;
    }

    public Vector3f mulTransposePosition(Matrix4fc mat, Vector3f dest) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        dest.x = Math.fma(mat.m00(), x2, Math.fma(mat.m01(), y2, Math.fma(mat.m02(), z2, mat.m03())));
        dest.y = Math.fma(mat.m10(), x2, Math.fma(mat.m11(), y2, Math.fma(mat.m12(), z2, mat.m13())));
        dest.z = Math.fma(mat.m20(), x2, Math.fma(mat.m21(), y2, Math.fma(mat.m22(), z2, mat.m23())));
        return dest;
    }

    public float mulPositionW(Matrix4fc mat) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        float w2 = Math.fma(mat.m03(), x2, Math.fma(mat.m13(), y2, Math.fma(mat.m23(), z2, mat.m33())));
        this.x = Math.fma(mat.m00(), x2, Math.fma(mat.m10(), y2, Math.fma(mat.m20(), z2, mat.m30())));
        this.y = Math.fma(mat.m01(), x2, Math.fma(mat.m11(), y2, Math.fma(mat.m21(), z2, mat.m31())));
        this.z = Math.fma(mat.m02(), x2, Math.fma(mat.m12(), y2, Math.fma(mat.m22(), z2, mat.m32())));
        return w2;
    }

    public float mulPositionW(Matrix4fc mat, Vector3f dest) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        float w2 = Math.fma(mat.m03(), x2, Math.fma(mat.m13(), y2, Math.fma(mat.m23(), z2, mat.m33())));
        dest.x = Math.fma(mat.m00(), x2, Math.fma(mat.m10(), y2, Math.fma(mat.m20(), z2, mat.m30())));
        dest.y = Math.fma(mat.m01(), x2, Math.fma(mat.m11(), y2, Math.fma(mat.m21(), z2, mat.m31())));
        dest.z = Math.fma(mat.m02(), x2, Math.fma(mat.m12(), y2, Math.fma(mat.m22(), z2, mat.m32())));
        return w2;
    }

    public Vector3f mulDirection(Matrix4dc mat) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        this.x = (float)Math.fma(mat.m00(), (double)x2, Math.fma(mat.m10(), (double)y2, mat.m20() * (double)z2));
        this.y = (float)Math.fma(mat.m01(), (double)x2, Math.fma(mat.m11(), (double)y2, mat.m21() * (double)z2));
        this.z = (float)Math.fma(mat.m02(), (double)x2, Math.fma(mat.m12(), (double)y2, mat.m22() * (double)z2));
        return this;
    }

    public Vector3f mulDirection(Matrix4fc mat) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        this.x = Math.fma(mat.m00(), x2, Math.fma(mat.m10(), y2, mat.m20() * z2));
        this.y = Math.fma(mat.m01(), x2, Math.fma(mat.m11(), y2, mat.m21() * z2));
        this.z = Math.fma(mat.m02(), x2, Math.fma(mat.m12(), y2, mat.m22() * z2));
        return this;
    }

    public Vector3f mulDirection(Matrix4x3fc mat) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        this.x = Math.fma(mat.m00(), x2, Math.fma(mat.m10(), y2, mat.m20() * z2));
        this.y = Math.fma(mat.m01(), x2, Math.fma(mat.m11(), y2, mat.m21() * z2));
        this.z = Math.fma(mat.m02(), x2, Math.fma(mat.m12(), y2, mat.m22() * z2));
        return this;
    }

    public Vector3f mulDirection(Matrix4dc mat, Vector3f dest) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        dest.x = (float)Math.fma(mat.m00(), (double)x2, Math.fma(mat.m10(), (double)y2, mat.m20() * (double)z2));
        dest.y = (float)Math.fma(mat.m01(), (double)x2, Math.fma(mat.m11(), (double)y2, mat.m21() * (double)z2));
        dest.z = (float)Math.fma(mat.m02(), (double)x2, Math.fma(mat.m12(), (double)y2, mat.m22() * (double)z2));
        return dest;
    }

    public Vector3f mulDirection(Matrix4fc mat, Vector3f dest) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        dest.x = Math.fma(mat.m00(), x2, Math.fma(mat.m10(), y2, mat.m20() * z2));
        dest.y = Math.fma(mat.m01(), x2, Math.fma(mat.m11(), y2, mat.m21() * z2));
        dest.z = Math.fma(mat.m02(), x2, Math.fma(mat.m12(), y2, mat.m22() * z2));
        return dest;
    }

    public Vector3f mulDirection(Matrix4x3fc mat, Vector3f dest) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        dest.x = Math.fma(mat.m00(), x2, Math.fma(mat.m10(), y2, mat.m20() * z2));
        dest.y = Math.fma(mat.m01(), x2, Math.fma(mat.m11(), y2, mat.m21() * z2));
        dest.z = Math.fma(mat.m02(), x2, Math.fma(mat.m12(), y2, mat.m22() * z2));
        return dest;
    }

    public Vector3f mulTransposeDirection(Matrix4fc mat) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        this.x = Math.fma(mat.m00(), x2, Math.fma(mat.m01(), y2, mat.m02() * z2));
        this.y = Math.fma(mat.m10(), x2, Math.fma(mat.m11(), y2, mat.m12() * z2));
        this.z = Math.fma(mat.m20(), x2, Math.fma(mat.m21(), y2, mat.m22() * z2));
        return this;
    }

    public Vector3f mulTransposeDirection(Matrix4fc mat, Vector3f dest) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        dest.x = Math.fma(mat.m00(), x2, Math.fma(mat.m01(), y2, mat.m02() * z2));
        dest.y = Math.fma(mat.m10(), x2, Math.fma(mat.m11(), y2, mat.m12() * z2));
        dest.z = Math.fma(mat.m20(), x2, Math.fma(mat.m21(), y2, mat.m22() * z2));
        return dest;
    }

    public Vector3f mul(float scalar) {
        this.x *= scalar;
        this.y *= scalar;
        this.z *= scalar;
        return this;
    }

    public Vector3f mul(float scalar, Vector3f dest) {
        dest.x = this.x * scalar;
        dest.y = this.y * scalar;
        dest.z = this.z * scalar;
        return dest;
    }

    public Vector3f mul(float x2, float y2, float z2) {
        this.x *= x2;
        this.y *= y2;
        this.z *= z2;
        return this;
    }

    public Vector3f mul(float x2, float y2, float z2, Vector3f dest) {
        dest.x = this.x * x2;
        dest.y = this.y * y2;
        dest.z = this.z * z2;
        return dest;
    }

    public Vector3f div(float scalar) {
        float inv = 1.0f / scalar;
        this.x *= inv;
        this.y *= inv;
        this.z *= inv;
        return this;
    }

    public Vector3f div(float scalar, Vector3f dest) {
        float inv = 1.0f / scalar;
        dest.x = this.x * inv;
        dest.y = this.y * inv;
        dest.z = this.z * inv;
        return dest;
    }

    public Vector3f div(float x2, float y2, float z2) {
        this.x /= x2;
        this.y /= y2;
        this.z /= z2;
        return this;
    }

    public Vector3f div(float x2, float y2, float z2, Vector3f dest) {
        dest.x = this.x / x2;
        dest.y = this.y / y2;
        dest.z = this.z / z2;
        return dest;
    }

    public Vector3f rotate(Quaternionfc quat) {
        return quat.transform(this, this);
    }

    public Vector3f rotate(Quaternionfc quat, Vector3f dest) {
        return quat.transform(this, dest);
    }

    public Quaternionf rotationTo(Vector3fc toDir, Quaternionf dest) {
        return dest.rotationTo(this, toDir);
    }

    public Quaternionf rotationTo(float toDirX, float toDirY, float toDirZ, Quaternionf dest) {
        return dest.rotationTo(this.x, this.y, this.z, toDirX, toDirY, toDirZ);
    }

    public Vector3f rotateAxis(float angle, float x2, float y2, float z2) {
        if (y2 == 0.0f && z2 == 0.0f && Math.absEqualsOne(x2)) {
            return this.rotateX(x2 * angle, this);
        }
        if (x2 == 0.0f && z2 == 0.0f && Math.absEqualsOne(y2)) {
            return this.rotateY(y2 * angle, this);
        }
        if (x2 == 0.0f && y2 == 0.0f && Math.absEqualsOne(z2)) {
            return this.rotateZ(z2 * angle, this);
        }
        return this.rotateAxisInternal(angle, x2, y2, z2, this);
    }

    public Vector3f rotateAxis(float angle, float aX, float aY, float aZ, Vector3f dest) {
        if (aY == 0.0f && aZ == 0.0f && Math.absEqualsOne(aX)) {
            return this.rotateX(aX * angle, dest);
        }
        if (aX == 0.0f && aZ == 0.0f && Math.absEqualsOne(aY)) {
            return this.rotateY(aY * angle, dest);
        }
        if (aX == 0.0f && aY == 0.0f && Math.absEqualsOne(aZ)) {
            return this.rotateZ(aZ * angle, dest);
        }
        return this.rotateAxisInternal(angle, aX, aY, aZ, dest);
    }

    private Vector3f rotateAxisInternal(float angle, float aX, float aY, float aZ, Vector3f dest) {
        float hangle = angle * 0.5f;
        float sinAngle = Math.sin(hangle);
        float qx = aX * sinAngle;
        float qy = aY * sinAngle;
        float qz = aZ * sinAngle;
        float qw2 = Math.cosFromSin(sinAngle, hangle);
        float w2 = qw2 * qw2;
        float x2 = qx * qx;
        float y2 = qy * qy;
        float z2 = qz * qz;
        float zw = qz * qw2;
        float xy = qx * qy;
        float xz = qx * qz;
        float yw = qy * qw2;
        float yz = qy * qz;
        float xw = qx * qw2;
        float x3 = this.x;
        float y3 = this.y;
        float z3 = this.z;
        dest.x = (w2 + x2 - z2 - y2) * x3 + (-zw + xy - zw + xy) * y3 + (yw + xz + xz + yw) * z3;
        dest.y = (xy + zw + zw + xy) * x3 + (y2 - z2 + w2 - x2) * y3 + (yz + yz - xw - xw) * z3;
        dest.z = (xz - yw + xz - yw) * x3 + (yz + yz + xw + xw) * y3 + (z2 - y2 - x2 + w2) * z3;
        return dest;
    }

    public Vector3f rotateX(float angle) {
        float sin = Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float y2 = this.y * cos - this.z * sin;
        float z2 = this.y * sin + this.z * cos;
        this.y = y2;
        this.z = z2;
        return this;
    }

    public Vector3f rotateX(float angle, Vector3f dest) {
        float sin = Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float y2 = this.y * cos - this.z * sin;
        float z2 = this.y * sin + this.z * cos;
        dest.x = this.x;
        dest.y = y2;
        dest.z = z2;
        return dest;
    }

    public Vector3f rotateY(float angle) {
        float sin = Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float x2 = this.x * cos + this.z * sin;
        float z2 = -this.x * sin + this.z * cos;
        this.x = x2;
        this.z = z2;
        return this;
    }

    public Vector3f rotateY(float angle, Vector3f dest) {
        float sin = Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float x2 = this.x * cos + this.z * sin;
        float z2 = -this.x * sin + this.z * cos;
        dest.x = x2;
        dest.y = this.y;
        dest.z = z2;
        return dest;
    }

    public Vector3f rotateZ(float angle) {
        float sin = Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float x2 = this.x * cos - this.y * sin;
        float y2 = this.x * sin + this.y * cos;
        this.x = x2;
        this.y = y2;
        return this;
    }

    public Vector3f rotateZ(float angle, Vector3f dest) {
        float sin = Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float x2 = this.x * cos - this.y * sin;
        float y2 = this.x * sin + this.y * cos;
        dest.x = x2;
        dest.y = y2;
        dest.z = this.z;
        return dest;
    }

    public float lengthSquared() {
        return Math.fma(this.x, this.x, Math.fma(this.y, this.y, this.z * this.z));
    }

    public static float lengthSquared(float x2, float y2, float z2) {
        return Math.fma(x2, x2, Math.fma(y2, y2, z2 * z2));
    }

    public float length() {
        return Math.sqrt(Math.fma(this.x, this.x, Math.fma(this.y, this.y, this.z * this.z)));
    }

    public static float length(float x2, float y2, float z2) {
        return Math.sqrt(Math.fma(x2, x2, Math.fma(y2, y2, z2 * z2)));
    }

    public Vector3f normalize() {
        float scalar = Math.invsqrt(Math.fma(this.x, this.x, Math.fma(this.y, this.y, this.z * this.z)));
        this.x *= scalar;
        this.y *= scalar;
        this.z *= scalar;
        return this;
    }

    public Vector3f normalize(Vector3f dest) {
        float scalar = Math.invsqrt(Math.fma(this.x, this.x, Math.fma(this.y, this.y, this.z * this.z)));
        dest.x = this.x * scalar;
        dest.y = this.y * scalar;
        dest.z = this.z * scalar;
        return dest;
    }

    public Vector3f normalize(float length) {
        float scalar = Math.invsqrt(Math.fma(this.x, this.x, Math.fma(this.y, this.y, this.z * this.z))) * length;
        this.x *= scalar;
        this.y *= scalar;
        this.z *= scalar;
        return this;
    }

    public Vector3f normalize(float length, Vector3f dest) {
        float scalar = Math.invsqrt(Math.fma(this.x, this.x, Math.fma(this.y, this.y, this.z * this.z))) * length;
        dest.x = this.x * scalar;
        dest.y = this.y * scalar;
        dest.z = this.z * scalar;
        return dest;
    }

    public Vector3f cross(Vector3fc v2) {
        float rx = Math.fma(this.y, v2.z(), -this.z * v2.y());
        float ry = Math.fma(this.z, v2.x(), -this.x * v2.z());
        float rz = Math.fma(this.x, v2.y(), -this.y * v2.x());
        this.x = rx;
        this.y = ry;
        this.z = rz;
        return this;
    }

    public Vector3f cross(float x2, float y2, float z2) {
        float rx = Math.fma(this.y, z2, -this.z * y2);
        float ry = Math.fma(this.z, x2, -this.x * z2);
        float rz = Math.fma(this.x, y2, -this.y * x2);
        this.x = rx;
        this.y = ry;
        this.z = rz;
        return this;
    }

    public Vector3f cross(Vector3fc v2, Vector3f dest) {
        float rx = Math.fma(this.y, v2.z(), -this.z * v2.y());
        float ry = Math.fma(this.z, v2.x(), -this.x * v2.z());
        float rz = Math.fma(this.x, v2.y(), -this.y * v2.x());
        dest.x = rx;
        dest.y = ry;
        dest.z = rz;
        return dest;
    }

    public Vector3f cross(float x2, float y2, float z2, Vector3f dest) {
        float rx = Math.fma(this.y, z2, -this.z * y2);
        float ry = Math.fma(this.z, x2, -this.x * z2);
        float rz = Math.fma(this.x, y2, -this.y * x2);
        dest.x = rx;
        dest.y = ry;
        dest.z = rz;
        return dest;
    }

    public float distance(Vector3fc v2) {
        float dx2 = this.x - v2.x();
        float dy2 = this.y - v2.y();
        float dz2 = this.z - v2.z();
        return Math.sqrt(Math.fma(dx2, dx2, Math.fma(dy2, dy2, dz2 * dz2)));
    }

    public float distance(float x2, float y2, float z2) {
        float dx2 = this.x - x2;
        float dy2 = this.y - y2;
        float dz2 = this.z - z2;
        return Math.sqrt(Math.fma(dx2, dx2, Math.fma(dy2, dy2, dz2 * dz2)));
    }

    public float distanceSquared(Vector3fc v2) {
        float dx2 = this.x - v2.x();
        float dy2 = this.y - v2.y();
        float dz2 = this.z - v2.z();
        return Math.fma(dx2, dx2, Math.fma(dy2, dy2, dz2 * dz2));
    }

    public float distanceSquared(float x2, float y2, float z2) {
        float dx2 = this.x - x2;
        float dy2 = this.y - y2;
        float dz2 = this.z - z2;
        return Math.fma(dx2, dx2, Math.fma(dy2, dy2, dz2 * dz2));
    }

    public static float distance(float x1, float y1, float z1, float x2, float y2, float z2) {
        return Math.sqrt(Vector3f.distanceSquared(x1, y1, z1, x2, y2, z2));
    }

    public static float distanceSquared(float x1, float y1, float z1, float x2, float y2, float z2) {
        float dx2 = x1 - x2;
        float dy2 = y1 - y2;
        float dz2 = z1 - z2;
        return Math.fma(dx2, dx2, Math.fma(dy2, dy2, dz2 * dz2));
    }

    public float dot(Vector3fc v2) {
        return Math.fma(this.x, v2.x(), Math.fma(this.y, v2.y(), this.z * v2.z()));
    }

    public float dot(float x2, float y2, float z2) {
        return Math.fma(this.x, x2, Math.fma(this.y, y2, this.z * z2));
    }

    public float angleCos(Vector3fc v2) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        float length1Squared = Math.fma(x2, x2, Math.fma(y2, y2, z2 * z2));
        float length2Squared = Math.fma(v2.x(), v2.x(), Math.fma(v2.y(), v2.y(), v2.z() * v2.z()));
        float dot = Math.fma(x2, v2.x(), Math.fma(y2, v2.y(), z2 * v2.z()));
        return dot / Math.sqrt(length1Squared * length2Squared);
    }

    public float angle(Vector3fc v2) {
        float cos = this.angleCos(v2);
        cos = cos < 1.0f ? cos : 1.0f;
        cos = cos > -1.0f ? cos : -1.0f;
        return Math.acos(cos);
    }

    public float angleSigned(Vector3fc v2, Vector3fc n2) {
        return this.angleSigned(v2.x(), v2.y(), v2.z(), n2.x(), n2.y(), n2.z());
    }

    public float angleSigned(float x2, float y2, float z2, float nx, float ny, float nz) {
        float tx = this.x;
        float ty = this.y;
        float tz = this.z;
        return Math.atan2((ty * z2 - tz * y2) * nx + (tz * x2 - tx * z2) * ny + (tx * y2 - ty * x2) * nz, tx * x2 + ty * y2 + tz * z2);
    }

    public Vector3f min(Vector3fc v2) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        this.x = x2 < v2.x() ? x2 : v2.x();
        this.y = y2 < v2.y() ? y2 : v2.y();
        this.z = z2 < v2.z() ? z2 : v2.z();
        return this;
    }

    public Vector3f min(Vector3fc v2, Vector3f dest) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        dest.x = x2 < v2.x() ? x2 : v2.x();
        dest.y = y2 < v2.y() ? y2 : v2.y();
        dest.z = z2 < v2.z() ? z2 : v2.z();
        return dest;
    }

    public Vector3f max(Vector3fc v2) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        this.x = x2 > v2.x() ? x2 : v2.x();
        this.y = y2 > v2.y() ? y2 : v2.y();
        this.z = z2 > v2.z() ? z2 : v2.z();
        return this;
    }

    public Vector3f max(Vector3fc v2, Vector3f dest) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        dest.x = x2 > v2.x() ? x2 : v2.x();
        dest.y = y2 > v2.y() ? y2 : v2.y();
        dest.z = z2 > v2.z() ? z2 : v2.z();
        return dest;
    }

    public Vector3f zero() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
        return this;
    }

    public String toString() {
        return Runtime.formatNumbers(this.toString(Options.NUMBER_FORMAT));
    }

    public String toString(NumberFormat formatter) {
        return "(" + Runtime.format(this.x, formatter) + " " + Runtime.format(this.y, formatter) + " " + Runtime.format(this.z, formatter) + ")";
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeFloat(this.x);
        out.writeFloat(this.y);
        out.writeFloat(this.z);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.set(in.readFloat(), in.readFloat(), in.readFloat());
    }

    public Vector3f negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        return this;
    }

    public Vector3f negate(Vector3f dest) {
        dest.x = -this.x;
        dest.y = -this.y;
        dest.z = -this.z;
        return dest;
    }

    public Vector3f absolute() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
        return this;
    }

    public Vector3f absolute(Vector3f dest) {
        dest.x = Math.abs(this.x);
        dest.y = Math.abs(this.y);
        dest.z = Math.abs(this.z);
        return dest;
    }

    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = 31 * result + Float.floatToIntBits(this.x);
        result = 31 * result + Float.floatToIntBits(this.y);
        result = 31 * result + Float.floatToIntBits(this.z);
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
        Vector3f other = (Vector3f)obj;
        if (Float.floatToIntBits(this.x) != Float.floatToIntBits(other.x)) {
            return false;
        }
        if (Float.floatToIntBits(this.y) != Float.floatToIntBits(other.y)) {
            return false;
        }
        return Float.floatToIntBits(this.z) == Float.floatToIntBits(other.z);
    }

    public boolean equals(Vector3fc v2, float delta) {
        if (this == v2) {
            return true;
        }
        if (v2 == null) {
            return false;
        }
        if (!(v2 instanceof Vector3fc)) {
            return false;
        }
        if (!Runtime.equals(this.x, v2.x(), delta)) {
            return false;
        }
        if (!Runtime.equals(this.y, v2.y(), delta)) {
            return false;
        }
        return Runtime.equals(this.z, v2.z(), delta);
    }

    public boolean equals(float x2, float y2, float z2) {
        if (Float.floatToIntBits(this.x) != Float.floatToIntBits(x2)) {
            return false;
        }
        if (Float.floatToIntBits(this.y) != Float.floatToIntBits(y2)) {
            return false;
        }
        return Float.floatToIntBits(this.z) == Float.floatToIntBits(z2);
    }

    public Vector3f reflect(Vector3fc normal) {
        float x2 = normal.x();
        float y2 = normal.y();
        float z2 = normal.z();
        float dot = Math.fma(this.x, x2, Math.fma(this.y, y2, this.z * z2));
        this.x -= (dot + dot) * x2;
        this.y -= (dot + dot) * y2;
        this.z -= (dot + dot) * z2;
        return this;
    }

    public Vector3f reflect(float x2, float y2, float z2) {
        float dot = Math.fma(this.x, x2, Math.fma(this.y, y2, this.z * z2));
        this.x -= (dot + dot) * x2;
        this.y -= (dot + dot) * y2;
        this.z -= (dot + dot) * z2;
        return this;
    }

    public Vector3f reflect(Vector3fc normal, Vector3f dest) {
        return this.reflect(normal.x(), normal.y(), normal.z(), dest);
    }

    public Vector3f reflect(float x2, float y2, float z2, Vector3f dest) {
        float dot = this.dot(x2, y2, z2);
        dest.x = this.x - (dot + dot) * x2;
        dest.y = this.y - (dot + dot) * y2;
        dest.z = this.z - (dot + dot) * z2;
        return dest;
    }

    public Vector3f half(Vector3fc other) {
        return this.set(this).add(other.x(), other.y(), other.z()).normalize();
    }

    public Vector3f half(float x2, float y2, float z2) {
        return this.half(x2, y2, z2, this);
    }

    public Vector3f half(Vector3fc other, Vector3f dest) {
        return this.half(other.x(), other.y(), other.z(), dest);
    }

    public Vector3f half(float x2, float y2, float z2, Vector3f dest) {
        return dest.set(this).add(x2, y2, z2).normalize();
    }

    public Vector3f smoothStep(Vector3fc v2, float t2, Vector3f dest) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        float t22 = t2 * t2;
        float t3 = t22 * t2;
        dest.x = (x2 + x2 - v2.x() - v2.x()) * t3 + (3.0f * v2.x() - 3.0f * x2) * t22 + x2 * t2 + x2;
        dest.y = (y2 + y2 - v2.y() - v2.y()) * t3 + (3.0f * v2.y() - 3.0f * y2) * t22 + y2 * t2 + y2;
        dest.z = (z2 + z2 - v2.z() - v2.z()) * t3 + (3.0f * v2.z() - 3.0f * z2) * t22 + z2 * t2 + z2;
        return dest;
    }

    public Vector3f hermite(Vector3fc t0, Vector3fc v1, Vector3fc t1, float t2, Vector3f dest) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        float t22 = t2 * t2;
        float t3 = t22 * t2;
        dest.x = (x2 + x2 - v1.x() - v1.x() + t1.x() + t0.x()) * t3 + (3.0f * v1.x() - 3.0f * x2 - t0.x() - t0.x() - t1.x()) * t22 + x2 * t2 + x2;
        dest.y = (y2 + y2 - v1.y() - v1.y() + t1.y() + t0.y()) * t3 + (3.0f * v1.y() - 3.0f * y2 - t0.y() - t0.y() - t1.y()) * t22 + y2 * t2 + y2;
        dest.z = (z2 + z2 - v1.z() - v1.z() + t1.z() + t0.z()) * t3 + (3.0f * v1.z() - 3.0f * z2 - t0.z() - t0.z() - t1.z()) * t22 + z2 * t2 + z2;
        return dest;
    }

    public Vector3f lerp(Vector3fc other, float t2) {
        return this.lerp(other, t2, this);
    }

    public Vector3f lerp(Vector3fc other, float t2, Vector3f dest) {
        dest.x = Math.fma(other.x() - this.x, t2, this.x);
        dest.y = Math.fma(other.y() - this.y, t2, this.y);
        dest.z = Math.fma(other.z() - this.z, t2, this.z);
        return dest;
    }

    public float get(int component) throws IllegalArgumentException {
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

    public Vector3i get(int mode, Vector3i dest) {
        dest.x = Math.roundUsing(this.x(), mode);
        dest.y = Math.roundUsing(this.y(), mode);
        dest.z = Math.roundUsing(this.z(), mode);
        return dest;
    }

    public Vector3f get(Vector3f dest) {
        dest.x = this.x();
        dest.y = this.y();
        dest.z = this.z();
        return dest;
    }

    public Vector3d get(Vector3d dest) {
        dest.x = this.x();
        dest.y = this.y();
        dest.z = this.z();
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

    public Vector3f orthogonalize(Vector3fc v2, Vector3f dest) {
        float rz;
        float ry;
        float rx;
        if (Math.abs(v2.x()) > Math.abs(v2.z())) {
            rx = -v2.y();
            ry = v2.x();
            rz = 0.0f;
        } else {
            rx = 0.0f;
            ry = -v2.z();
            rz = v2.y();
        }
        float invLen = Math.invsqrt(rx * rx + ry * ry + rz * rz);
        dest.x = rx * invLen;
        dest.y = ry * invLen;
        dest.z = rz * invLen;
        return dest;
    }

    public Vector3f orthogonalize(Vector3fc v2) {
        return this.orthogonalize(v2, this);
    }

    public Vector3f orthogonalizeUnit(Vector3fc v2, Vector3f dest) {
        return this.orthogonalize(v2, dest);
    }

    public Vector3f orthogonalizeUnit(Vector3fc v2) {
        return this.orthogonalizeUnit(v2, this);
    }

    public Vector3f floor() {
        return this.floor(this);
    }

    public Vector3f floor(Vector3f dest) {
        dest.x = Math.floor(this.x);
        dest.y = Math.floor(this.y);
        dest.z = Math.floor(this.z);
        return dest;
    }

    public Vector3f ceil() {
        return this.ceil(this);
    }

    public Vector3f ceil(Vector3f dest) {
        dest.x = Math.ceil(this.x);
        dest.y = Math.ceil(this.y);
        dest.z = Math.ceil(this.z);
        return dest;
    }

    public Vector3f round() {
        return this.round(this);
    }

    public Vector3f round(Vector3f dest) {
        dest.x = Math.round(this.x);
        dest.y = Math.round(this.y);
        dest.z = Math.round(this.z);
        return dest;
    }

    public boolean isFinite() {
        return Math.isFinite(this.x) && Math.isFinite(this.y) && Math.isFinite(this.z);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

