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
import org.joml.Matrix4fc;
import org.joml.Matrix4x3fc;
import org.joml.MemUtil;
import org.joml.Options;
import org.joml.Quaternionfc;
import org.joml.Runtime;
import org.joml.Vector2fc;
import org.joml.Vector2ic;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector3ic;
import org.joml.Vector4d;
import org.joml.Vector4dc;
import org.joml.Vector4fc;
import org.joml.Vector4i;
import org.joml.Vector4ic;

public class Vector4f
implements Externalizable,
Cloneable,
Vector4fc {
    private static final long serialVersionUID = 1L;
    public float x;
    public float y;
    public float z;
    public float w;

    public Vector4f() {
        this.w = 1.0f;
    }

    public Vector4f(Vector4fc v2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = v2.z();
        this.w = v2.w();
    }

    public Vector4f(Vector4ic v2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = v2.z();
        this.w = v2.w();
    }

    public Vector4f(Vector3fc v2, float w2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = v2.z();
        this.w = w2;
    }

    public Vector4f(Vector3ic v2, float w2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = v2.z();
        this.w = w2;
    }

    public Vector4f(Vector2fc v2, float z2, float w2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = z2;
        this.w = w2;
    }

    public Vector4f(Vector2ic v2, float z2, float w2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = z2;
        this.w = w2;
    }

    public Vector4f(float d2) {
        this.x = d2;
        this.y = d2;
        this.z = d2;
        this.w = d2;
    }

    public Vector4f(float x2, float y2, float z2, float w2) {
        this.x = x2;
        this.y = y2;
        this.z = z2;
        this.w = w2;
    }

    public Vector4f(float[] xyzw) {
        this.x = xyzw[0];
        this.y = xyzw[1];
        this.z = xyzw[2];
        this.w = xyzw[3];
    }

    public Vector4f(ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
    }

    public Vector4f(int index, ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
    }

    public Vector4f(FloatBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
    }

    public Vector4f(int index, FloatBuffer buffer) {
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

    public float w() {
        return this.w;
    }

    public Vector4f set(Vector4fc v2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = v2.z();
        this.w = v2.w();
        return this;
    }

    public Vector4f set(Vector4ic v2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = v2.z();
        this.w = v2.w();
        return this;
    }

    public Vector4f set(Vector4dc v2) {
        this.x = (float)v2.x();
        this.y = (float)v2.y();
        this.z = (float)v2.z();
        this.w = (float)v2.w();
        return this;
    }

    public Vector4f set(Vector3fc v2, float w2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = v2.z();
        this.w = w2;
        return this;
    }

    public Vector4f set(Vector3ic v2, float w2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = v2.z();
        this.w = w2;
        return this;
    }

    public Vector4f set(Vector2fc v2, float z2, float w2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = z2;
        this.w = w2;
        return this;
    }

    public Vector4f set(Vector2ic v2, float z2, float w2) {
        this.x = v2.x();
        this.y = v2.y();
        this.z = z2;
        this.w = w2;
        return this;
    }

    public Vector4f set(float d2) {
        this.x = d2;
        this.y = d2;
        this.z = d2;
        this.w = d2;
        return this;
    }

    public Vector4f set(float x2, float y2, float z2, float w2) {
        this.x = x2;
        this.y = y2;
        this.z = z2;
        this.w = w2;
        return this;
    }

    public Vector4f set(float x2, float y2, float z2) {
        this.x = x2;
        this.y = y2;
        this.z = z2;
        return this;
    }

    public Vector4f set(double d2) {
        this.x = (float)d2;
        this.y = (float)d2;
        this.z = (float)d2;
        this.w = (float)d2;
        return this;
    }

    public Vector4f set(double x2, double y2, double z2, double w2) {
        this.x = (float)x2;
        this.y = (float)y2;
        this.z = (float)z2;
        this.w = (float)w2;
        return this;
    }

    public Vector4f set(float[] xyzw) {
        this.x = xyzw[0];
        this.y = xyzw[1];
        this.z = xyzw[2];
        this.w = xyzw[3];
        return this;
    }

    public Vector4f set(ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
        return this;
    }

    public Vector4f set(int index, ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
        return this;
    }

    public Vector4f set(FloatBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
        return this;
    }

    public Vector4f set(int index, FloatBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
        return this;
    }

    public Vector4f setFromAddress(long address) {
        if (Options.NO_UNSAFE) {
            throw new UnsupportedOperationException("Not supported when using joml.nounsafe");
        }
        MemUtil.MemUtilUnsafe.get(this, address);
        return this;
    }

    public Vector4f setComponent(int component, float value) throws IllegalArgumentException {
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

    public Vector4fc getToAddress(long address) {
        if (Options.NO_UNSAFE) {
            throw new UnsupportedOperationException("Not supported when using joml.nounsafe");
        }
        MemUtil.MemUtilUnsafe.put(this, address);
        return this;
    }

    public Vector4f sub(Vector4fc v2) {
        this.x -= v2.x();
        this.y -= v2.y();
        this.z -= v2.z();
        this.w -= v2.w();
        return this;
    }

    public Vector4f sub(float x2, float y2, float z2, float w2) {
        this.x -= x2;
        this.y -= y2;
        this.z -= z2;
        this.w -= w2;
        return this;
    }

    public Vector4f sub(Vector4fc v2, Vector4f dest) {
        dest.x = this.x - v2.x();
        dest.y = this.y - v2.y();
        dest.z = this.z - v2.z();
        dest.w = this.w - v2.w();
        return dest;
    }

    public Vector4f sub(float x2, float y2, float z2, float w2, Vector4f dest) {
        dest.x = this.x - x2;
        dest.y = this.y - y2;
        dest.z = this.z - z2;
        dest.w = this.w - w2;
        return dest;
    }

    public Vector4f add(Vector4fc v2) {
        this.x += v2.x();
        this.y += v2.y();
        this.z += v2.z();
        this.w += v2.w();
        return this;
    }

    public Vector4f add(Vector4fc v2, Vector4f dest) {
        dest.x = this.x + v2.x();
        dest.y = this.y + v2.y();
        dest.z = this.z + v2.z();
        dest.w = this.w + v2.w();
        return dest;
    }

    public Vector4f add(float x2, float y2, float z2, float w2) {
        this.x += x2;
        this.y += y2;
        this.z += z2;
        this.w += w2;
        return this;
    }

    public Vector4f add(float x2, float y2, float z2, float w2, Vector4f dest) {
        dest.x = this.x + x2;
        dest.y = this.y + y2;
        dest.z = this.z + z2;
        dest.w = this.w + w2;
        return dest;
    }

    public Vector4f fma(Vector4fc a2, Vector4fc b2) {
        this.x = Math.fma(a2.x(), b2.x(), this.x);
        this.y = Math.fma(a2.y(), b2.y(), this.y);
        this.z = Math.fma(a2.z(), b2.z(), this.z);
        this.w = Math.fma(a2.w(), b2.w(), this.w);
        return this;
    }

    public Vector4f fma(float a2, Vector4fc b2) {
        this.x = Math.fma(a2, b2.x(), this.x);
        this.y = Math.fma(a2, b2.y(), this.y);
        this.z = Math.fma(a2, b2.z(), this.z);
        this.w = Math.fma(a2, b2.w(), this.w);
        return this;
    }

    public Vector4f fma(Vector4fc a2, Vector4fc b2, Vector4f dest) {
        dest.x = Math.fma(a2.x(), b2.x(), this.x);
        dest.y = Math.fma(a2.y(), b2.y(), this.y);
        dest.z = Math.fma(a2.z(), b2.z(), this.z);
        dest.w = Math.fma(a2.w(), b2.w(), this.w);
        return dest;
    }

    public Vector4f fma(float a2, Vector4fc b2, Vector4f dest) {
        dest.x = Math.fma(a2, b2.x(), this.x);
        dest.y = Math.fma(a2, b2.y(), this.y);
        dest.z = Math.fma(a2, b2.z(), this.z);
        dest.w = Math.fma(a2, b2.w(), this.w);
        return dest;
    }

    public Vector4f mulAdd(Vector4fc a2, Vector4fc b2) {
        this.x = Math.fma(this.x, a2.x(), b2.x());
        this.y = Math.fma(this.y, a2.y(), b2.y());
        this.z = Math.fma(this.z, a2.z(), b2.z());
        return this;
    }

    public Vector4f mulAdd(float a2, Vector4fc b2) {
        this.x = Math.fma(this.x, a2, b2.x());
        this.y = Math.fma(this.y, a2, b2.y());
        this.z = Math.fma(this.z, a2, b2.z());
        return this;
    }

    public Vector4f mulAdd(Vector4fc a2, Vector4fc b2, Vector4f dest) {
        dest.x = Math.fma(this.x, a2.x(), b2.x());
        dest.y = Math.fma(this.y, a2.y(), b2.y());
        dest.z = Math.fma(this.z, a2.z(), b2.z());
        return dest;
    }

    public Vector4f mulAdd(float a2, Vector4fc b2, Vector4f dest) {
        dest.x = Math.fma(this.x, a2, b2.x());
        dest.y = Math.fma(this.y, a2, b2.y());
        dest.z = Math.fma(this.z, a2, b2.z());
        return dest;
    }

    public Vector4f mul(Vector4fc v2) {
        this.x *= v2.x();
        this.y *= v2.y();
        this.z *= v2.z();
        this.w *= v2.w();
        return this;
    }

    public Vector4f mul(Vector4fc v2, Vector4f dest) {
        dest.x = this.x * v2.x();
        dest.y = this.y * v2.y();
        dest.z = this.z * v2.z();
        dest.w = this.w * v2.w();
        return dest;
    }

    public Vector4f div(Vector4fc v2) {
        this.x /= v2.x();
        this.y /= v2.y();
        this.z /= v2.z();
        this.w /= v2.w();
        return this;
    }

    public Vector4f div(Vector4fc v2, Vector4f dest) {
        dest.x = this.x / v2.x();
        dest.y = this.y / v2.y();
        dest.z = this.z / v2.z();
        dest.w = this.w / v2.w();
        return dest;
    }

    public Vector4f mul(Matrix4fc mat) {
        if ((mat.properties() & 2) != 0) {
            return this.mulAffine(mat, this);
        }
        return this.mulGeneric(mat, this);
    }

    public Vector4f mul(Matrix4fc mat, Vector4f dest) {
        if ((mat.properties() & 2) != 0) {
            return this.mulAffine(mat, dest);
        }
        return this.mulGeneric(mat, dest);
    }

    public Vector4f mulTranspose(Matrix4fc mat) {
        if ((mat.properties() & 2) != 0) {
            return this.mulAffineTranspose(mat, this);
        }
        return this.mulGenericTranspose(mat, this);
    }

    public Vector4f mulTranspose(Matrix4fc mat, Vector4f dest) {
        if ((mat.properties() & 2) != 0) {
            return this.mulAffineTranspose(mat, dest);
        }
        return this.mulGenericTranspose(mat, dest);
    }

    public Vector4f mulAffine(Matrix4fc mat, Vector4f dest) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        float w2 = this.w;
        dest.x = Math.fma(mat.m00(), x2, Math.fma(mat.m10(), y2, Math.fma(mat.m20(), z2, mat.m30() * w2)));
        dest.y = Math.fma(mat.m01(), x2, Math.fma(mat.m11(), y2, Math.fma(mat.m21(), z2, mat.m31() * w2)));
        dest.z = Math.fma(mat.m02(), x2, Math.fma(mat.m12(), y2, Math.fma(mat.m22(), z2, mat.m32() * w2)));
        dest.w = w2;
        return dest;
    }

    private Vector4f mulGeneric(Matrix4fc mat, Vector4f dest) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        float w2 = this.w;
        dest.x = Math.fma(mat.m00(), x2, Math.fma(mat.m10(), y2, Math.fma(mat.m20(), z2, mat.m30() * w2)));
        dest.y = Math.fma(mat.m01(), x2, Math.fma(mat.m11(), y2, Math.fma(mat.m21(), z2, mat.m31() * w2)));
        dest.z = Math.fma(mat.m02(), x2, Math.fma(mat.m12(), y2, Math.fma(mat.m22(), z2, mat.m32() * w2)));
        dest.w = Math.fma(mat.m03(), x2, Math.fma(mat.m13(), y2, Math.fma(mat.m23(), z2, mat.m33() * w2)));
        return dest;
    }

    public Vector4f mulAffineTranspose(Matrix4fc mat, Vector4f dest) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        float w2 = this.w;
        dest.x = Math.fma(mat.m00(), x2, Math.fma(mat.m01(), y2, mat.m02() * z2));
        dest.y = Math.fma(mat.m10(), x2, Math.fma(mat.m11(), y2, mat.m12() * z2));
        dest.z = Math.fma(mat.m20(), x2, Math.fma(mat.m21(), y2, mat.m22() * z2));
        dest.w = Math.fma(mat.m30(), x2, Math.fma(mat.m31(), y2, mat.m32() * z2 + w2));
        return dest;
    }

    private Vector4f mulGenericTranspose(Matrix4fc mat, Vector4f dest) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        float w2 = this.w;
        dest.x = Math.fma(mat.m00(), x2, Math.fma(mat.m01(), y2, Math.fma(mat.m02(), z2, mat.m03() * w2)));
        dest.y = Math.fma(mat.m10(), x2, Math.fma(mat.m11(), y2, Math.fma(mat.m12(), z2, mat.m13() * w2)));
        dest.z = Math.fma(mat.m20(), x2, Math.fma(mat.m21(), y2, Math.fma(mat.m22(), z2, mat.m23() * w2)));
        dest.w = Math.fma(mat.m30(), x2, Math.fma(mat.m31(), y2, Math.fma(mat.m32(), z2, mat.m33() * w2)));
        return dest;
    }

    public Vector4f mul(Matrix4x3fc mat) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        float w2 = this.w;
        this.x = Math.fma(mat.m00(), x2, Math.fma(mat.m10(), y2, Math.fma(mat.m20(), z2, mat.m30() * w2)));
        this.y = Math.fma(mat.m01(), x2, Math.fma(mat.m11(), y2, Math.fma(mat.m21(), z2, mat.m31() * w2)));
        this.z = Math.fma(mat.m02(), x2, Math.fma(mat.m12(), y2, Math.fma(mat.m22(), z2, mat.m32() * w2)));
        this.w = w2;
        return this;
    }

    public Vector4f mul(Matrix4x3fc mat, Vector4f dest) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        float w2 = this.w;
        dest.x = Math.fma(mat.m00(), x2, Math.fma(mat.m10(), y2, Math.fma(mat.m20(), z2, mat.m30() * w2)));
        dest.y = Math.fma(mat.m01(), x2, Math.fma(mat.m11(), y2, Math.fma(mat.m21(), z2, mat.m31() * w2)));
        dest.z = Math.fma(mat.m02(), x2, Math.fma(mat.m12(), y2, Math.fma(mat.m22(), z2, mat.m32() * w2)));
        dest.w = w2;
        return dest;
    }

    public Vector4f mulProject(Matrix4fc mat, Vector4f dest) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        float w2 = this.w;
        float invW = 1.0f / Math.fma(mat.m03(), x2, Math.fma(mat.m13(), y2, Math.fma(mat.m23(), z2, mat.m33() * w2)));
        dest.x = Math.fma(mat.m00(), x2, Math.fma(mat.m10(), y2, Math.fma(mat.m20(), z2, mat.m30() * w2))) * invW;
        dest.y = Math.fma(mat.m01(), x2, Math.fma(mat.m11(), y2, Math.fma(mat.m21(), z2, mat.m31() * w2))) * invW;
        dest.z = Math.fma(mat.m02(), x2, Math.fma(mat.m12(), y2, Math.fma(mat.m22(), z2, mat.m32() * w2))) * invW;
        dest.w = 1.0f;
        return dest;
    }

    public Vector4f mulProject(Matrix4fc mat) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        float w2 = this.w;
        float invW = 1.0f / Math.fma(mat.m03(), x2, Math.fma(mat.m13(), y2, Math.fma(mat.m23(), z2, mat.m33() * w2)));
        this.x = Math.fma(mat.m00(), x2, Math.fma(mat.m10(), y2, Math.fma(mat.m20(), z2, mat.m30() * w2))) * invW;
        this.y = Math.fma(mat.m01(), x2, Math.fma(mat.m11(), y2, Math.fma(mat.m21(), z2, mat.m31() * w2))) * invW;
        this.z = Math.fma(mat.m02(), x2, Math.fma(mat.m12(), y2, Math.fma(mat.m22(), z2, mat.m32() * w2))) * invW;
        this.w = 1.0f;
        return this;
    }

    public Vector3f mulProject(Matrix4fc mat, Vector3f dest) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        float w2 = this.w;
        float invW = 1.0f / Math.fma(mat.m03(), x2, Math.fma(mat.m13(), y2, Math.fma(mat.m23(), z2, mat.m33() * w2)));
        dest.x = Math.fma(mat.m00(), x2, Math.fma(mat.m10(), y2, Math.fma(mat.m20(), z2, mat.m30() * w2))) * invW;
        dest.y = Math.fma(mat.m01(), x2, Math.fma(mat.m11(), y2, Math.fma(mat.m21(), z2, mat.m31() * w2))) * invW;
        dest.z = Math.fma(mat.m02(), x2, Math.fma(mat.m12(), y2, Math.fma(mat.m22(), z2, mat.m32() * w2))) * invW;
        return dest;
    }

    public Vector4f mul(float scalar) {
        this.x *= scalar;
        this.y *= scalar;
        this.z *= scalar;
        this.w *= scalar;
        return this;
    }

    public Vector4f mul(float scalar, Vector4f dest) {
        dest.x = this.x * scalar;
        dest.y = this.y * scalar;
        dest.z = this.z * scalar;
        dest.w = this.w * scalar;
        return dest;
    }

    public Vector4f mul(float x2, float y2, float z2, float w2) {
        this.x *= x2;
        this.y *= y2;
        this.z *= z2;
        this.w *= w2;
        return this;
    }

    public Vector4f mul(float x2, float y2, float z2, float w2, Vector4f dest) {
        dest.x = this.x * x2;
        dest.y = this.y * y2;
        dest.z = this.z * z2;
        dest.w = this.w * w2;
        return dest;
    }

    public Vector4f div(float scalar) {
        float inv = 1.0f / scalar;
        this.x *= inv;
        this.y *= inv;
        this.z *= inv;
        this.w *= inv;
        return this;
    }

    public Vector4f div(float scalar, Vector4f dest) {
        float inv = 1.0f / scalar;
        dest.x = this.x * inv;
        dest.y = this.y * inv;
        dest.z = this.z * inv;
        dest.w = this.w * inv;
        return dest;
    }

    public Vector4f div(float x2, float y2, float z2, float w2) {
        this.x /= x2;
        this.y /= y2;
        this.z /= z2;
        this.w /= w2;
        return this;
    }

    public Vector4f div(float x2, float y2, float z2, float w2, Vector4f dest) {
        dest.x = this.x / x2;
        dest.y = this.y / y2;
        dest.z = this.z / z2;
        dest.w = this.w / w2;
        return dest;
    }

    public Vector4f rotate(Quaternionfc quat) {
        return quat.transform(this, this);
    }

    public Vector4f rotate(Quaternionfc quat, Vector4f dest) {
        return quat.transform(this, dest);
    }

    public Vector4f rotateAbout(float angle, float x2, float y2, float z2) {
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

    public Vector4f rotateAxis(float angle, float aX, float aY, float aZ, Vector4f dest) {
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

    private Vector4f rotateAxisInternal(float angle, float aX, float aY, float aZ, Vector4f dest) {
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

    public Vector4f rotateX(float angle) {
        float sin = Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float y2 = this.y * cos - this.z * sin;
        float z2 = this.y * sin + this.z * cos;
        this.y = y2;
        this.z = z2;
        return this;
    }

    public Vector4f rotateX(float angle, Vector4f dest) {
        float sin = Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float y2 = this.y * cos - this.z * sin;
        float z2 = this.y * sin + this.z * cos;
        dest.x = this.x;
        dest.y = y2;
        dest.z = z2;
        dest.w = this.w;
        return dest;
    }

    public Vector4f rotateY(float angle) {
        float sin = Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float x2 = this.x * cos + this.z * sin;
        float z2 = -this.x * sin + this.z * cos;
        this.x = x2;
        this.z = z2;
        return this;
    }

    public Vector4f rotateY(float angle, Vector4f dest) {
        float sin = Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float x2 = this.x * cos + this.z * sin;
        float z2 = -this.x * sin + this.z * cos;
        dest.x = x2;
        dest.y = this.y;
        dest.z = z2;
        dest.w = this.w;
        return dest;
    }

    public Vector4f rotateZ(float angle) {
        float sin = Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float x2 = this.x * cos - this.y * sin;
        float y2 = this.x * sin + this.y * cos;
        this.x = x2;
        this.y = y2;
        return this;
    }

    public Vector4f rotateZ(float angle, Vector4f dest) {
        float sin = Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float x2 = this.x * cos - this.y * sin;
        float y2 = this.x * sin + this.y * cos;
        dest.x = x2;
        dest.y = y2;
        dest.z = this.z;
        dest.w = this.w;
        return dest;
    }

    public float lengthSquared() {
        return Math.fma(this.x, this.x, Math.fma(this.y, this.y, Math.fma(this.z, this.z, this.w * this.w)));
    }

    public static float lengthSquared(float x2, float y2, float z2, float w2) {
        return Math.fma(x2, x2, Math.fma(y2, y2, Math.fma(z2, z2, w2 * w2)));
    }

    public static float lengthSquared(int x2, int y2, int z2, int w2) {
        return Math.fma(x2, x2, Math.fma(y2, y2, Math.fma(z2, z2, w2 * w2)));
    }

    public float length() {
        return Math.sqrt(Math.fma(this.x, this.x, Math.fma(this.y, this.y, Math.fma(this.z, this.z, this.w * this.w))));
    }

    public static float length(float x2, float y2, float z2, float w2) {
        return Math.sqrt(Math.fma(x2, x2, Math.fma(y2, y2, Math.fma(z2, z2, w2 * w2))));
    }

    public Vector4f normalize() {
        float invLength = 1.0f / this.length();
        this.x *= invLength;
        this.y *= invLength;
        this.z *= invLength;
        this.w *= invLength;
        return this;
    }

    public Vector4f normalize(Vector4f dest) {
        float invLength = 1.0f / this.length();
        dest.x = this.x * invLength;
        dest.y = this.y * invLength;
        dest.z = this.z * invLength;
        dest.w = this.w * invLength;
        return dest;
    }

    public Vector4f normalize(float length) {
        float invLength = 1.0f / this.length() * length;
        this.x *= invLength;
        this.y *= invLength;
        this.z *= invLength;
        this.w *= invLength;
        return this;
    }

    public Vector4f normalize(float length, Vector4f dest) {
        float invLength = 1.0f / this.length() * length;
        dest.x = this.x * invLength;
        dest.y = this.y * invLength;
        dest.z = this.z * invLength;
        dest.w = this.w * invLength;
        return dest;
    }

    public Vector4f normalize3() {
        float invLength = Math.invsqrt(Math.fma(this.x, this.x, Math.fma(this.y, this.y, this.z * this.z)));
        this.x *= invLength;
        this.y *= invLength;
        this.z *= invLength;
        this.w *= invLength;
        return this;
    }

    public Vector4f normalize3(Vector4f dest) {
        float invLength = Math.invsqrt(Math.fma(this.x, this.x, Math.fma(this.y, this.y, this.z * this.z)));
        dest.x = this.x * invLength;
        dest.y = this.y * invLength;
        dest.z = this.z * invLength;
        dest.w = this.w * invLength;
        return dest;
    }

    public float distance(Vector4fc v2) {
        float dx2 = this.x - v2.x();
        float dy2 = this.y - v2.y();
        float dz2 = this.z - v2.z();
        float dw2 = this.w - v2.w();
        return Math.sqrt(Math.fma(dx2, dx2, Math.fma(dy2, dy2, Math.fma(dz2, dz2, dw2 * dw2))));
    }

    public float distance(float x2, float y2, float z2, float w2) {
        float dx2 = this.x - x2;
        float dy2 = this.y - y2;
        float dz2 = this.z - z2;
        float dw2 = this.w - w2;
        return Math.sqrt(Math.fma(dx2, dx2, Math.fma(dy2, dy2, Math.fma(dz2, dz2, dw2 * dw2))));
    }

    public float distanceSquared(Vector4fc v2) {
        float dx2 = this.x - v2.x();
        float dy2 = this.y - v2.y();
        float dz2 = this.z - v2.z();
        float dw2 = this.w - v2.w();
        return Math.fma(dx2, dx2, Math.fma(dy2, dy2, Math.fma(dz2, dz2, dw2 * dw2)));
    }

    public float distanceSquared(float x2, float y2, float z2, float w2) {
        float dx2 = this.x - x2;
        float dy2 = this.y - y2;
        float dz2 = this.z - z2;
        float dw2 = this.w - w2;
        return Math.fma(dx2, dx2, Math.fma(dy2, dy2, Math.fma(dz2, dz2, dw2 * dw2)));
    }

    public static float distance(float x1, float y1, float z1, float w1, float x2, float y2, float z2, float w2) {
        float dx2 = x1 - x2;
        float dy2 = y1 - y2;
        float dz2 = z1 - z2;
        float dw2 = w1 - w2;
        return Math.sqrt(Math.fma(dx2, dx2, Math.fma(dy2, dy2, Math.fma(dz2, dz2, dw2 * dw2))));
    }

    public static float distanceSquared(float x1, float y1, float z1, float w1, float x2, float y2, float z2, float w2) {
        float dx2 = x1 - x2;
        float dy2 = y1 - y2;
        float dz2 = z1 - z2;
        float dw2 = w1 - w2;
        return Math.fma(dx2, dx2, Math.fma(dy2, dy2, Math.fma(dz2, dz2, dw2 * dw2)));
    }

    public float dot(Vector4fc v2) {
        return Math.fma(this.x, v2.x(), Math.fma(this.y, v2.y(), Math.fma(this.z, v2.z(), this.w * v2.w())));
    }

    public float dot(float x2, float y2, float z2, float w2) {
        return Math.fma(this.x, x2, Math.fma(this.y, y2, Math.fma(this.z, z2, this.w * w2)));
    }

    public float angleCos(Vector4fc v2) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        float w2 = this.w;
        float length1Squared = Math.fma(x2, x2, Math.fma(y2, y2, Math.fma(z2, z2, w2 * w2)));
        float length2Squared = Math.fma(v2.x(), v2.x(), Math.fma(v2.y(), v2.y(), Math.fma(v2.z(), v2.z(), v2.w() * v2.w())));
        float dot = Math.fma(x2, v2.x(), Math.fma(y2, v2.y(), Math.fma(z2, v2.z(), w2 * v2.w())));
        return dot / Math.sqrt(length1Squared * length2Squared);
    }

    public float angle(Vector4fc v2) {
        float cos = this.angleCos(v2);
        cos = cos < 1.0f ? cos : 1.0f;
        cos = cos > -1.0f ? cos : -1.0f;
        return Math.acos(cos);
    }

    public Vector4f zero() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
        this.w = 0.0f;
        return this;
    }

    public Vector4f negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        this.w = -this.w;
        return this;
    }

    public Vector4f negate(Vector4f dest) {
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
        return "(" + Runtime.format(this.x, formatter) + " " + Runtime.format(this.y, formatter) + " " + Runtime.format(this.z, formatter) + " " + Runtime.format(this.w, formatter) + ")";
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeFloat(this.x);
        out.writeFloat(this.y);
        out.writeFloat(this.z);
        out.writeFloat(this.w);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.set(in.readFloat(), in.readFloat(), in.readFloat(), in.readFloat());
    }

    public Vector4f min(Vector4fc v2) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        float w2 = this.w;
        this.x = x2 < v2.x() ? x2 : v2.x();
        this.y = y2 < v2.y() ? y2 : v2.y();
        this.z = z2 < v2.z() ? z2 : v2.z();
        this.w = w2 < v2.w() ? w2 : v2.w();
        return this;
    }

    public Vector4f min(Vector4fc v2, Vector4f dest) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        float w2 = this.w;
        dest.x = x2 < v2.x() ? x2 : v2.x();
        dest.y = y2 < v2.y() ? y2 : v2.y();
        dest.z = z2 < v2.z() ? z2 : v2.z();
        dest.w = w2 < v2.w() ? w2 : v2.w();
        return dest;
    }

    public Vector4f max(Vector4fc v2) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        float w2 = this.w;
        this.x = x2 > v2.x() ? x2 : v2.x();
        this.y = y2 > v2.y() ? y2 : v2.y();
        this.z = z2 > v2.z() ? z2 : v2.z();
        this.w = w2 > v2.w() ? w2 : v2.w();
        return this;
    }

    public Vector4f max(Vector4fc v2, Vector4f dest) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        float w2 = this.w;
        dest.x = x2 > v2.x() ? x2 : v2.x();
        dest.y = y2 > v2.y() ? y2 : v2.y();
        dest.z = z2 > v2.z() ? z2 : v2.z();
        dest.w = w2 > v2.w() ? w2 : v2.w();
        return dest;
    }

    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = 31 * result + Float.floatToIntBits(this.w);
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
        Vector4f other = (Vector4f)obj;
        if (Float.floatToIntBits(this.w) != Float.floatToIntBits(other.w)) {
            return false;
        }
        if (Float.floatToIntBits(this.x) != Float.floatToIntBits(other.x)) {
            return false;
        }
        if (Float.floatToIntBits(this.y) != Float.floatToIntBits(other.y)) {
            return false;
        }
        return Float.floatToIntBits(this.z) == Float.floatToIntBits(other.z);
    }

    public boolean equals(Vector4fc v2, float delta) {
        if (this == v2) {
            return true;
        }
        if (v2 == null) {
            return false;
        }
        if (!(v2 instanceof Vector4fc)) {
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

    public boolean equals(float x2, float y2, float z2, float w2) {
        if (Float.floatToIntBits(this.x) != Float.floatToIntBits(x2)) {
            return false;
        }
        if (Float.floatToIntBits(this.y) != Float.floatToIntBits(y2)) {
            return false;
        }
        if (Float.floatToIntBits(this.z) != Float.floatToIntBits(z2)) {
            return false;
        }
        return Float.floatToIntBits(this.w) == Float.floatToIntBits(w2);
    }

    public Vector4f smoothStep(Vector4fc v2, float t2, Vector4f dest) {
        float t22 = t2 * t2;
        float t3 = t22 * t2;
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        float w2 = this.w;
        dest.x = (x2 + x2 - v2.x() - v2.x()) * t3 + (3.0f * v2.x() - 3.0f * x2) * t22 + x2 * t2 + x2;
        dest.y = (y2 + y2 - v2.y() - v2.y()) * t3 + (3.0f * v2.y() - 3.0f * y2) * t22 + y2 * t2 + y2;
        dest.z = (z2 + z2 - v2.z() - v2.z()) * t3 + (3.0f * v2.z() - 3.0f * z2) * t22 + z2 * t2 + z2;
        dest.w = (w2 + w2 - v2.w() - v2.w()) * t3 + (3.0f * v2.w() - 3.0f * w2) * t22 + w2 * t2 + w2;
        return dest;
    }

    public Vector4f hermite(Vector4fc t0, Vector4fc v1, Vector4fc t1, float t2, Vector4f dest) {
        float t22 = t2 * t2;
        float t3 = t22 * t2;
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        float w2 = this.w;
        dest.x = (x2 + x2 - v1.x() - v1.x() + t1.x() + t0.x()) * t3 + (3.0f * v1.x() - 3.0f * x2 - t0.x() - t0.x() - t1.x()) * t22 + x2 * t2 + x2;
        dest.y = (y2 + y2 - v1.y() - v1.y() + t1.y() + t0.y()) * t3 + (3.0f * v1.y() - 3.0f * y2 - t0.y() - t0.y() - t1.y()) * t22 + y2 * t2 + y2;
        dest.z = (z2 + z2 - v1.z() - v1.z() + t1.z() + t0.z()) * t3 + (3.0f * v1.z() - 3.0f * z2 - t0.z() - t0.z() - t1.z()) * t22 + z2 * t2 + z2;
        dest.w = (w2 + w2 - v1.w() - v1.w() + t1.w() + t0.w()) * t3 + (3.0f * v1.w() - 3.0f * w2 - t0.w() - t0.w() - t1.w()) * t22 + w2 * t2 + w2;
        return dest;
    }

    public Vector4f lerp(Vector4fc other, float t2) {
        this.x = Math.fma(other.x() - this.x, t2, this.x);
        this.y = Math.fma(other.y() - this.y, t2, this.y);
        this.z = Math.fma(other.z() - this.z, t2, this.z);
        this.w = Math.fma(other.w() - this.w, t2, this.w);
        return this;
    }

    public Vector4f lerp(Vector4fc other, float t2, Vector4f dest) {
        dest.x = Math.fma(other.x() - this.x, t2, this.x);
        dest.y = Math.fma(other.y() - this.y, t2, this.y);
        dest.z = Math.fma(other.z() - this.z, t2, this.z);
        dest.w = Math.fma(other.w() - this.w, t2, this.w);
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
        dest.x = this.x();
        dest.y = this.y();
        dest.z = this.z();
        dest.w = this.w();
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
        float absX = Math.abs(this.x);
        float absY = Math.abs(this.y);
        float absZ = Math.abs(this.z);
        float absW = Math.abs(this.w);
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
        float absX = Math.abs(this.x);
        float absY = Math.abs(this.y);
        float absZ = Math.abs(this.z);
        float absW = Math.abs(this.w);
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

    public Vector4f floor() {
        this.x = Math.floor(this.x);
        this.y = Math.floor(this.y);
        this.z = Math.floor(this.z);
        this.w = Math.floor(this.w);
        return this;
    }

    public Vector4f floor(Vector4f dest) {
        dest.x = Math.floor(this.x);
        dest.y = Math.floor(this.y);
        dest.z = Math.floor(this.z);
        dest.w = Math.floor(this.w);
        return dest;
    }

    public Vector4f ceil() {
        this.x = Math.ceil(this.x);
        this.y = Math.ceil(this.y);
        this.z = Math.ceil(this.z);
        this.w = Math.ceil(this.w);
        return this;
    }

    public Vector4f ceil(Vector4f dest) {
        dest.x = Math.ceil(this.x);
        dest.y = Math.ceil(this.y);
        dest.z = Math.ceil(this.z);
        dest.w = Math.ceil(this.w);
        return dest;
    }

    public Vector4f round() {
        this.x = Math.round(this.x);
        this.y = Math.round(this.y);
        this.z = Math.round(this.z);
        this.w = Math.round(this.w);
        return this;
    }

    public Vector4f round(Vector4f dest) {
        dest.x = Math.round(this.x);
        dest.y = Math.round(this.y);
        dest.z = Math.round(this.z);
        dest.w = Math.round(this.w);
        return dest;
    }

    public boolean isFinite() {
        return Math.isFinite(this.x) && Math.isFinite(this.y) && Math.isFinite(this.z) && Math.isFinite(this.w);
    }

    public Vector4f absolute() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
        this.w = Math.abs(this.w);
        return this;
    }

    public Vector4f absolute(Vector4f dest) {
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

