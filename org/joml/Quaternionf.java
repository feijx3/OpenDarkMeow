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
import org.joml.AxisAngle4d;
import org.joml.AxisAngle4f;
import org.joml.Math;
import org.joml.Matrix3d;
import org.joml.Matrix3dc;
import org.joml.Matrix3f;
import org.joml.Matrix3fc;
import org.joml.Matrix4d;
import org.joml.Matrix4dc;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Matrix4x3d;
import org.joml.Matrix4x3dc;
import org.joml.Matrix4x3f;
import org.joml.Matrix4x3fc;
import org.joml.MemUtil;
import org.joml.Options;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Quaternionfc;
import org.joml.Runtime;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector4d;
import org.joml.Vector4dc;
import org.joml.Vector4f;
import org.joml.Vector4fc;

public class Quaternionf
implements Externalizable,
Cloneable,
Quaternionfc {
    private static final long serialVersionUID = 1L;
    public float x;
    public float y;
    public float z;
    public float w;

    public Quaternionf() {
        this.w = 1.0f;
    }

    public Quaternionf(double x2, double y2, double z2, double w2) {
        this.x = (float)x2;
        this.y = (float)y2;
        this.z = (float)z2;
        this.w = (float)w2;
    }

    public Quaternionf(float x2, float y2, float z2, float w2) {
        this.x = x2;
        this.y = y2;
        this.z = z2;
        this.w = w2;
    }

    public Quaternionf(Quaternionfc source) {
        this.set(source);
    }

    public Quaternionf(Quaterniondc source) {
        this.set(source);
    }

    public Quaternionf(AxisAngle4f axisAngle) {
        float sin = Math.sin(axisAngle.angle * 0.5f);
        float cos = Math.cosFromSin(sin, axisAngle.angle * 0.5f);
        this.x = axisAngle.x * sin;
        this.y = axisAngle.y * sin;
        this.z = axisAngle.z * sin;
        this.w = cos;
    }

    public Quaternionf(AxisAngle4d axisAngle) {
        double sin = Math.sin(axisAngle.angle * 0.5);
        double cos = Math.cosFromSin(sin, axisAngle.angle * 0.5);
        this.x = (float)(axisAngle.x * sin);
        this.y = (float)(axisAngle.y * sin);
        this.z = (float)(axisAngle.z * sin);
        this.w = (float)cos;
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

    public Quaternionf normalize() {
        return this.normalize(this);
    }

    public Quaternionf normalize(Quaternionf dest) {
        float invNorm = Math.invsqrt(Math.fma(this.x, this.x, Math.fma(this.y, this.y, Math.fma(this.z, this.z, this.w * this.w))));
        dest.x = this.x * invNorm;
        dest.y = this.y * invNorm;
        dest.z = this.z * invNorm;
        dest.w = this.w * invNorm;
        return dest;
    }

    public Quaternionf add(float x2, float y2, float z2, float w2) {
        return this.add(x2, y2, z2, w2, this);
    }

    public Quaternionf add(float x2, float y2, float z2, float w2, Quaternionf dest) {
        dest.x = this.x + x2;
        dest.y = this.y + y2;
        dest.z = this.z + z2;
        dest.w = this.w + w2;
        return dest;
    }

    public Quaternionf add(Quaternionfc q2) {
        return this.add(q2, this);
    }

    public Quaternionf add(Quaternionfc q2, Quaternionf dest) {
        dest.x = this.x + q2.x();
        dest.y = this.y + q2.y();
        dest.z = this.z + q2.z();
        dest.w = this.w + q2.w();
        return dest;
    }

    public float dot(Quaternionf otherQuat) {
        return this.x * otherQuat.x + this.y * otherQuat.y + this.z * otherQuat.z + this.w * otherQuat.w;
    }

    public float angle() {
        return (float)(2.0 * (double)Math.safeAcos(this.w));
    }

    public Matrix3f get(Matrix3f dest) {
        return dest.set(this);
    }

    public Matrix3d get(Matrix3d dest) {
        return dest.set(this);
    }

    public Matrix4f get(Matrix4f dest) {
        return dest.set(this);
    }

    public Matrix4d get(Matrix4d dest) {
        return dest.set(this);
    }

    public Matrix4x3f get(Matrix4x3f dest) {
        return dest.set(this);
    }

    public Matrix4x3d get(Matrix4x3d dest) {
        return dest.set(this);
    }

    public AxisAngle4f get(AxisAngle4f dest) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        float w2 = this.w;
        if (w2 > 1.0f) {
            float invNorm = Math.invsqrt(Math.fma(x2, x2, Math.fma(y2, y2, Math.fma(z2, z2, w2 * w2))));
            x2 *= invNorm;
            y2 *= invNorm;
            z2 *= invNorm;
            w2 *= invNorm;
        }
        dest.angle = 2.0f * Math.acos(w2);
        float s2 = Math.sqrt(1.0f - w2 * w2);
        if (s2 < 0.001f) {
            dest.x = x2;
            dest.y = y2;
            dest.z = z2;
        } else {
            s2 = 1.0f / s2;
            dest.x = x2 * s2;
            dest.y = y2 * s2;
            dest.z = z2 * s2;
        }
        return dest;
    }

    public AxisAngle4d get(AxisAngle4d dest) {
        float x2 = this.x;
        float y2 = this.y;
        float z2 = this.z;
        float w2 = this.w;
        if (w2 > 1.0f) {
            float invNorm = Math.invsqrt(Math.fma(x2, x2, Math.fma(y2, y2, Math.fma(z2, z2, w2 * w2))));
            x2 *= invNorm;
            y2 *= invNorm;
            z2 *= invNorm;
            w2 *= invNorm;
        }
        dest.angle = 2.0f * Math.acos(w2);
        float s2 = Math.sqrt(1.0f - w2 * w2);
        if (s2 < 0.001f) {
            dest.x = x2;
            dest.y = y2;
            dest.z = z2;
        } else {
            s2 = 1.0f / s2;
            dest.x = x2 * s2;
            dest.y = y2 * s2;
            dest.z = z2 * s2;
        }
        return dest;
    }

    public Quaterniond get(Quaterniond dest) {
        return dest.set(this);
    }

    public Quaternionf get(Quaternionf dest) {
        return dest.set(this);
    }

    public ByteBuffer getAsMatrix3f(ByteBuffer dest) {
        MemUtil.INSTANCE.putMatrix3f(this, dest.position(), dest);
        return dest;
    }

    public FloatBuffer getAsMatrix3f(FloatBuffer dest) {
        MemUtil.INSTANCE.putMatrix3f(this, dest.position(), dest);
        return dest;
    }

    public ByteBuffer getAsMatrix4f(ByteBuffer dest) {
        MemUtil.INSTANCE.putMatrix4f(this, dest.position(), dest);
        return dest;
    }

    public FloatBuffer getAsMatrix4f(FloatBuffer dest) {
        MemUtil.INSTANCE.putMatrix4f(this, dest.position(), dest);
        return dest;
    }

    public ByteBuffer getAsMatrix4x3f(ByteBuffer dest) {
        MemUtil.INSTANCE.putMatrix4x3f(this, dest.position(), dest);
        return dest;
    }

    public FloatBuffer getAsMatrix4x3f(FloatBuffer dest) {
        MemUtil.INSTANCE.putMatrix4x3f(this, dest.position(), dest);
        return dest;
    }

    public Quaternionf set(float x2, float y2, float z2, float w2) {
        this.x = x2;
        this.y = y2;
        this.z = z2;
        this.w = w2;
        return this;
    }

    public Quaternionf set(Quaternionfc q2) {
        this.x = q2.x();
        this.y = q2.y();
        this.z = q2.z();
        this.w = q2.w();
        return this;
    }

    public Quaternionf set(Quaterniondc q2) {
        this.x = (float)q2.x();
        this.y = (float)q2.y();
        this.z = (float)q2.z();
        this.w = (float)q2.w();
        return this;
    }

    public Quaternionf set(AxisAngle4f axisAngle) {
        return this.setAngleAxis(axisAngle.angle, axisAngle.x, axisAngle.y, axisAngle.z);
    }

    public Quaternionf set(AxisAngle4d axisAngle) {
        return this.setAngleAxis(axisAngle.angle, axisAngle.x, axisAngle.y, axisAngle.z);
    }

    public Quaternionf setAngleAxis(float angle, float x2, float y2, float z2) {
        float s2 = Math.sin(angle * 0.5f);
        this.x = x2 * s2;
        this.y = y2 * s2;
        this.z = z2 * s2;
        this.w = Math.cosFromSin(s2, angle * 0.5f);
        return this;
    }

    public Quaternionf setAngleAxis(double angle, double x2, double y2, double z2) {
        double s2 = Math.sin(angle * 0.5);
        this.x = (float)(x2 * s2);
        this.y = (float)(y2 * s2);
        this.z = (float)(z2 * s2);
        this.w = (float)Math.cosFromSin(s2, angle * 0.5);
        return this;
    }

    public Quaternionf rotationAxis(AxisAngle4f axisAngle) {
        return this.rotationAxis(axisAngle.angle, axisAngle.x, axisAngle.y, axisAngle.z);
    }

    public Quaternionf rotationAxis(float angle, float axisX, float axisY, float axisZ) {
        float hangle = angle / 2.0f;
        float sinAngle = Math.sin(hangle);
        float invVLength = Math.invsqrt(axisX * axisX + axisY * axisY + axisZ * axisZ);
        return this.set(axisX * invVLength * sinAngle, axisY * invVLength * sinAngle, axisZ * invVLength * sinAngle, Math.cosFromSin(sinAngle, hangle));
    }

    public Quaternionf rotationAxis(float angle, Vector3fc axis) {
        return this.rotationAxis(angle, axis.x(), axis.y(), axis.z());
    }

    public Quaternionf rotationX(float angle) {
        float sin = Math.sin(angle * 0.5f);
        float cos = Math.cosFromSin(sin, angle * 0.5f);
        return this.set(sin, 0.0f, 0.0f, cos);
    }

    public Quaternionf rotationY(float angle) {
        float sin = Math.sin(angle * 0.5f);
        float cos = Math.cosFromSin(sin, angle * 0.5f);
        return this.set(0.0f, sin, 0.0f, cos);
    }

    public Quaternionf rotationZ(float angle) {
        float sin = Math.sin(angle * 0.5f);
        float cos = Math.cosFromSin(sin, angle * 0.5f);
        return this.set(0.0f, 0.0f, sin, cos);
    }

    private void setFromUnnormalized(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) {
        float nm00 = m00;
        float nm01 = m01;
        float nm02 = m02;
        float nm10 = m10;
        float nm11 = m11;
        float nm12 = m12;
        float nm20 = m20;
        float nm21 = m21;
        float nm22 = m22;
        float lenX = Math.invsqrt(m00 * m00 + m01 * m01 + m02 * m02);
        float lenY = Math.invsqrt(m10 * m10 + m11 * m11 + m12 * m12);
        float lenZ = Math.invsqrt(m20 * m20 + m21 * m21 + m22 * m22);
        this.setFromNormalized(nm00 *= lenX, nm01 *= lenX, nm02 *= lenX, nm10 *= lenY, nm11 *= lenY, nm12 *= lenY, nm20 *= lenZ, nm21 *= lenZ, nm22 *= lenZ);
    }

    private void setFromNormalized(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) {
        float tr = m00 + m11 + m22;
        if (tr >= 0.0f) {
            float t2 = Math.sqrt(tr + 1.0f);
            this.w = t2 * 0.5f;
            t2 = 0.5f / t2;
            this.x = (m12 - m21) * t2;
            this.y = (m20 - m02) * t2;
            this.z = (m01 - m10) * t2;
        } else if (m00 >= m11 && m00 >= m22) {
            float t3 = Math.sqrt(m00 - (m11 + m22) + 1.0f);
            this.x = t3 * 0.5f;
            t3 = 0.5f / t3;
            this.y = (m10 + m01) * t3;
            this.z = (m02 + m20) * t3;
            this.w = (m12 - m21) * t3;
        } else if (m11 > m22) {
            float t4 = Math.sqrt(m11 - (m22 + m00) + 1.0f);
            this.y = t4 * 0.5f;
            t4 = 0.5f / t4;
            this.z = (m21 + m12) * t4;
            this.x = (m10 + m01) * t4;
            this.w = (m20 - m02) * t4;
        } else {
            float t5 = Math.sqrt(m22 - (m00 + m11) + 1.0f);
            this.z = t5 * 0.5f;
            t5 = 0.5f / t5;
            this.x = (m02 + m20) * t5;
            this.y = (m21 + m12) * t5;
            this.w = (m01 - m10) * t5;
        }
    }

    private void setFromUnnormalized(double m00, double m01, double m02, double m10, double m11, double m12, double m20, double m21, double m22) {
        double nm00 = m00;
        double nm01 = m01;
        double nm02 = m02;
        double nm10 = m10;
        double nm11 = m11;
        double nm12 = m12;
        double nm20 = m20;
        double nm21 = m21;
        double nm22 = m22;
        double lenX = Math.invsqrt(m00 * m00 + m01 * m01 + m02 * m02);
        double lenY = Math.invsqrt(m10 * m10 + m11 * m11 + m12 * m12);
        double lenZ = Math.invsqrt(m20 * m20 + m21 * m21 + m22 * m22);
        this.setFromNormalized(nm00 *= lenX, nm01 *= lenX, nm02 *= lenX, nm10 *= lenY, nm11 *= lenY, nm12 *= lenY, nm20 *= lenZ, nm21 *= lenZ, nm22 *= lenZ);
    }

    private void setFromNormalized(double m00, double m01, double m02, double m10, double m11, double m12, double m20, double m21, double m22) {
        double tr = m00 + m11 + m22;
        if (tr >= 0.0) {
            double t2 = Math.sqrt(tr + 1.0);
            this.w = (float)(t2 * 0.5);
            t2 = 0.5 / t2;
            this.x = (float)((m12 - m21) * t2);
            this.y = (float)((m20 - m02) * t2);
            this.z = (float)((m01 - m10) * t2);
        } else if (m00 >= m11 && m00 >= m22) {
            double t3 = Math.sqrt(m00 - (m11 + m22) + 1.0);
            this.x = (float)(t3 * 0.5);
            t3 = 0.5 / t3;
            this.y = (float)((m10 + m01) * t3);
            this.z = (float)((m02 + m20) * t3);
            this.w = (float)((m12 - m21) * t3);
        } else if (m11 > m22) {
            double t4 = Math.sqrt(m11 - (m22 + m00) + 1.0);
            this.y = (float)(t4 * 0.5);
            t4 = 0.5 / t4;
            this.z = (float)((m21 + m12) * t4);
            this.x = (float)((m10 + m01) * t4);
            this.w = (float)((m20 - m02) * t4);
        } else {
            double t5 = Math.sqrt(m22 - (m00 + m11) + 1.0);
            this.z = (float)(t5 * 0.5);
            t5 = 0.5 / t5;
            this.x = (float)((m02 + m20) * t5);
            this.y = (float)((m21 + m12) * t5);
            this.w = (float)((m01 - m10) * t5);
        }
    }

    public Quaternionf setFromUnnormalized(Matrix4fc mat) {
        this.setFromUnnormalized(mat.m00(), mat.m01(), mat.m02(), mat.m10(), mat.m11(), mat.m12(), mat.m20(), mat.m21(), mat.m22());
        return this;
    }

    public Quaternionf setFromUnnormalized(Matrix4x3fc mat) {
        this.setFromUnnormalized(mat.m00(), mat.m01(), mat.m02(), mat.m10(), mat.m11(), mat.m12(), mat.m20(), mat.m21(), mat.m22());
        return this;
    }

    public Quaternionf setFromUnnormalized(Matrix4x3dc mat) {
        this.setFromUnnormalized(mat.m00(), mat.m01(), mat.m02(), mat.m10(), mat.m11(), mat.m12(), mat.m20(), mat.m21(), mat.m22());
        return this;
    }

    public Quaternionf setFromNormalized(Matrix4fc mat) {
        this.setFromNormalized(mat.m00(), mat.m01(), mat.m02(), mat.m10(), mat.m11(), mat.m12(), mat.m20(), mat.m21(), mat.m22());
        return this;
    }

    public Quaternionf setFromNormalized(Matrix4x3fc mat) {
        this.setFromNormalized(mat.m00(), mat.m01(), mat.m02(), mat.m10(), mat.m11(), mat.m12(), mat.m20(), mat.m21(), mat.m22());
        return this;
    }

    public Quaternionf setFromNormalized(Matrix4x3dc mat) {
        this.setFromNormalized(mat.m00(), mat.m01(), mat.m02(), mat.m10(), mat.m11(), mat.m12(), mat.m20(), mat.m21(), mat.m22());
        return this;
    }

    public Quaternionf setFromUnnormalized(Matrix4dc mat) {
        this.setFromUnnormalized(mat.m00(), mat.m01(), mat.m02(), mat.m10(), mat.m11(), mat.m12(), mat.m20(), mat.m21(), mat.m22());
        return this;
    }

    public Quaternionf setFromNormalized(Matrix4dc mat) {
        this.setFromNormalized(mat.m00(), mat.m01(), mat.m02(), mat.m10(), mat.m11(), mat.m12(), mat.m20(), mat.m21(), mat.m22());
        return this;
    }

    public Quaternionf setFromUnnormalized(Matrix3fc mat) {
        this.setFromUnnormalized(mat.m00(), mat.m01(), mat.m02(), mat.m10(), mat.m11(), mat.m12(), mat.m20(), mat.m21(), mat.m22());
        return this;
    }

    public Quaternionf setFromNormalized(Matrix3fc mat) {
        this.setFromNormalized(mat.m00(), mat.m01(), mat.m02(), mat.m10(), mat.m11(), mat.m12(), mat.m20(), mat.m21(), mat.m22());
        return this;
    }

    public Quaternionf setFromUnnormalized(Matrix3dc mat) {
        this.setFromUnnormalized(mat.m00(), mat.m01(), mat.m02(), mat.m10(), mat.m11(), mat.m12(), mat.m20(), mat.m21(), mat.m22());
        return this;
    }

    public Quaternionf setFromNormalized(Matrix3dc mat) {
        this.setFromNormalized(mat.m00(), mat.m01(), mat.m02(), mat.m10(), mat.m11(), mat.m12(), mat.m20(), mat.m21(), mat.m22());
        return this;
    }

    public Quaternionf fromAxisAngleRad(Vector3fc axis, float angle) {
        return this.fromAxisAngleRad(axis.x(), axis.y(), axis.z(), angle);
    }

    public Quaternionf fromAxisAngleRad(float axisX, float axisY, float axisZ, float angle) {
        float hangle = angle / 2.0f;
        float sinAngle = Math.sin(hangle);
        float vLength = Math.sqrt(axisX * axisX + axisY * axisY + axisZ * axisZ);
        this.x = axisX / vLength * sinAngle;
        this.y = axisY / vLength * sinAngle;
        this.z = axisZ / vLength * sinAngle;
        this.w = Math.cosFromSin(sinAngle, hangle);
        return this;
    }

    public Quaternionf fromAxisAngleDeg(Vector3fc axis, float angle) {
        return this.fromAxisAngleRad(axis.x(), axis.y(), axis.z(), Math.toRadians(angle));
    }

    public Quaternionf fromAxisAngleDeg(float axisX, float axisY, float axisZ, float angle) {
        return this.fromAxisAngleRad(axisX, axisY, axisZ, Math.toRadians(angle));
    }

    public Quaternionf mul(Quaternionfc q2) {
        return this.mul(q2, this);
    }

    public Quaternionf mul(Quaternionfc q2, Quaternionf dest) {
        return dest.set(Math.fma(this.w, q2.x(), Math.fma(this.x, q2.w(), Math.fma(this.y, q2.z(), -this.z * q2.y()))), Math.fma(this.w, q2.y(), Math.fma(-this.x, q2.z(), Math.fma(this.y, q2.w(), this.z * q2.x()))), Math.fma(this.w, q2.z(), Math.fma(this.x, q2.y(), Math.fma(-this.y, q2.x(), this.z * q2.w()))), Math.fma(this.w, q2.w(), Math.fma(-this.x, q2.x(), Math.fma(-this.y, q2.y(), -this.z * q2.z()))));
    }

    public Quaternionf mul(float qx, float qy, float qz, float qw2) {
        return this.mul(qx, qy, qz, qw2, this);
    }

    public Quaternionf mul(float qx, float qy, float qz, float qw2, Quaternionf dest) {
        return dest.set(Math.fma(this.w, qx, Math.fma(this.x, qw2, Math.fma(this.y, qz, -this.z * qy))), Math.fma(this.w, qy, Math.fma(-this.x, qz, Math.fma(this.y, qw2, this.z * qx))), Math.fma(this.w, qz, Math.fma(this.x, qy, Math.fma(-this.y, qx, this.z * qw2))), Math.fma(this.w, qw2, Math.fma(-this.x, qx, Math.fma(-this.y, qy, -this.z * qz))));
    }

    public Quaternionf mul(float f2) {
        return this.mul(f2, this);
    }

    public Quaternionf mul(float f2, Quaternionf dest) {
        dest.x = this.x * f2;
        dest.y = this.y * f2;
        dest.z = this.z * f2;
        dest.w = this.w * f2;
        return dest;
    }

    public Quaternionf premul(Quaternionfc q2) {
        return this.premul(q2, this);
    }

    public Quaternionf premul(Quaternionfc q2, Quaternionf dest) {
        return dest.set(Math.fma(q2.w(), this.x, Math.fma(q2.x(), this.w, Math.fma(q2.y(), this.z, -q2.z() * this.y))), Math.fma(q2.w(), this.y, Math.fma(-q2.x(), this.z, Math.fma(q2.y(), this.w, q2.z() * this.x))), Math.fma(q2.w(), this.z, Math.fma(q2.x(), this.y, Math.fma(-q2.y(), this.x, q2.z() * this.w))), Math.fma(q2.w(), this.w, Math.fma(-q2.x(), this.x, Math.fma(-q2.y(), this.y, -q2.z() * this.z))));
    }

    public Quaternionf premul(float qx, float qy, float qz, float qw2) {
        return this.premul(qx, qy, qz, qw2, this);
    }

    public Quaternionf premul(float qx, float qy, float qz, float qw2, Quaternionf dest) {
        return dest.set(Math.fma(qw2, this.x, Math.fma(qx, this.w, Math.fma(qy, this.z, -qz * this.y))), Math.fma(qw2, this.y, Math.fma(-qx, this.z, Math.fma(qy, this.w, qz * this.x))), Math.fma(qw2, this.z, Math.fma(qx, this.y, Math.fma(-qy, this.x, qz * this.w))), Math.fma(qw2, this.w, Math.fma(-qx, this.x, Math.fma(-qy, this.y, -qz * this.z))));
    }

    public Vector3f transform(Vector3f vec) {
        return this.transform(vec.x, vec.y, vec.z, vec);
    }

    public Vector3f transformInverse(Vector3f vec) {
        return this.transformInverse(vec.x, vec.y, vec.z, vec);
    }

    public Vector3f transformPositiveX(Vector3f dest) {
        float ww = this.w * this.w;
        float xx = this.x * this.x;
        float yy = this.y * this.y;
        float zz = this.z * this.z;
        float zw = this.z * this.w;
        float xy = this.x * this.y;
        float xz = this.x * this.z;
        float yw = this.y * this.w;
        dest.x = ww + xx - zz - yy;
        dest.y = xy + zw + zw + xy;
        dest.z = xz - yw + xz - yw;
        return dest;
    }

    public Vector4f transformPositiveX(Vector4f dest) {
        float ww = this.w * this.w;
        float xx = this.x * this.x;
        float yy = this.y * this.y;
        float zz = this.z * this.z;
        float zw = this.z * this.w;
        float xy = this.x * this.y;
        float xz = this.x * this.z;
        float yw = this.y * this.w;
        dest.x = ww + xx - zz - yy;
        dest.y = xy + zw + zw + xy;
        dest.z = xz - yw + xz - yw;
        return dest;
    }

    public Vector3f transformUnitPositiveX(Vector3f dest) {
        float xy = this.x * this.y;
        float xz = this.x * this.z;
        float yy = this.y * this.y;
        float yw = this.y * this.w;
        float zz = this.z * this.z;
        float zw = this.z * this.w;
        dest.x = 1.0f - yy - zz - yy - zz;
        dest.y = xy + zw + xy + zw;
        dest.z = xz - yw + xz - yw;
        return dest;
    }

    public Vector4f transformUnitPositiveX(Vector4f dest) {
        float yy = this.y * this.y;
        float zz = this.z * this.z;
        float xy = this.x * this.y;
        float xz = this.x * this.z;
        float yw = this.y * this.w;
        float zw = this.z * this.w;
        dest.x = 1.0f - yy - yy - zz - zz;
        dest.y = xy + zw + xy + zw;
        dest.z = xz - yw + xz - yw;
        return dest;
    }

    public Vector3f transformPositiveY(Vector3f dest) {
        float ww = this.w * this.w;
        float xx = this.x * this.x;
        float yy = this.y * this.y;
        float zz = this.z * this.z;
        float zw = this.z * this.w;
        float xy = this.x * this.y;
        float yz = this.y * this.z;
        float xw = this.x * this.w;
        dest.x = -zw + xy - zw + xy;
        dest.y = yy - zz + ww - xx;
        dest.z = yz + yz + xw + xw;
        return dest;
    }

    public Vector4f transformPositiveY(Vector4f dest) {
        float ww = this.w * this.w;
        float xx = this.x * this.x;
        float yy = this.y * this.y;
        float zz = this.z * this.z;
        float zw = this.z * this.w;
        float xy = this.x * this.y;
        float yz = this.y * this.z;
        float xw = this.x * this.w;
        dest.x = -zw + xy - zw + xy;
        dest.y = yy - zz + ww - xx;
        dest.z = yz + yz + xw + xw;
        return dest;
    }

    public Vector4f transformUnitPositiveY(Vector4f dest) {
        float xx = this.x * this.x;
        float zz = this.z * this.z;
        float xy = this.x * this.y;
        float yz = this.y * this.z;
        float xw = this.x * this.w;
        float zw = this.z * this.w;
        dest.x = xy - zw + xy - zw;
        dest.y = 1.0f - xx - xx - zz - zz;
        dest.z = yz + yz + xw + xw;
        return dest;
    }

    public Vector3f transformUnitPositiveY(Vector3f dest) {
        float xx = this.x * this.x;
        float zz = this.z * this.z;
        float xy = this.x * this.y;
        float yz = this.y * this.z;
        float xw = this.x * this.w;
        float zw = this.z * this.w;
        dest.x = xy - zw + xy - zw;
        dest.y = 1.0f - xx - xx - zz - zz;
        dest.z = yz + yz + xw + xw;
        return dest;
    }

    public Vector3f transformPositiveZ(Vector3f dest) {
        float ww = this.w * this.w;
        float xx = this.x * this.x;
        float yy = this.y * this.y;
        float zz = this.z * this.z;
        float xz = this.x * this.z;
        float yw = this.y * this.w;
        float yz = this.y * this.z;
        float xw = this.x * this.w;
        dest.x = yw + xz + xz + yw;
        dest.y = yz + yz - xw - xw;
        dest.z = zz - yy - xx + ww;
        return dest;
    }

    public Vector4f transformPositiveZ(Vector4f dest) {
        float ww = this.w * this.w;
        float xx = this.x * this.x;
        float yy = this.y * this.y;
        float zz = this.z * this.z;
        float xz = this.x * this.z;
        float yw = this.y * this.w;
        float yz = this.y * this.z;
        float xw = this.x * this.w;
        dest.x = yw + xz + xz + yw;
        dest.y = yz + yz - xw - xw;
        dest.z = zz - yy - xx + ww;
        return dest;
    }

    public Vector4f transformUnitPositiveZ(Vector4f dest) {
        float xx = this.x * this.x;
        float yy = this.y * this.y;
        float xz = this.x * this.z;
        float yz = this.y * this.z;
        float xw = this.x * this.w;
        float yw = this.y * this.w;
        dest.x = xz + yw + xz + yw;
        dest.y = yz + yz - xw - xw;
        dest.z = 1.0f - xx - xx - yy - yy;
        return dest;
    }

    public Vector3f transformUnitPositiveZ(Vector3f dest) {
        float xx = this.x * this.x;
        float yy = this.y * this.y;
        float xz = this.x * this.z;
        float yz = this.y * this.z;
        float xw = this.x * this.w;
        float yw = this.y * this.w;
        dest.x = xz + yw + xz + yw;
        dest.y = yz + yz - xw - xw;
        dest.z = 1.0f - xx - xx - yy - yy;
        return dest;
    }

    public Vector4f transform(Vector4f vec) {
        return this.transform(vec, vec);
    }

    public Vector4f transformInverse(Vector4f vec) {
        return this.transformInverse(vec, vec);
    }

    public Vector3f transform(Vector3fc vec, Vector3f dest) {
        return this.transform(vec.x(), vec.y(), vec.z(), dest);
    }

    public Vector3f transformInverse(Vector3fc vec, Vector3f dest) {
        return this.transformInverse(vec.x(), vec.y(), vec.z(), dest);
    }

    public Vector3f transform(float x2, float y2, float z2, Vector3f dest) {
        float xx = this.x * this.x;
        float yy = this.y * this.y;
        float zz = this.z * this.z;
        float ww = this.w * this.w;
        float xy = this.x * this.y;
        float xz = this.x * this.z;
        float yz = this.y * this.z;
        float xw = this.x * this.w;
        float zw = this.z * this.w;
        float yw = this.y * this.w;
        float k2 = 1.0f / (xx + yy + zz + ww);
        return dest.set(Math.fma((xx - yy - zz + ww) * k2, x2, Math.fma(2.0f * (xy - zw) * k2, y2, 2.0f * (xz + yw) * k2 * z2)), Math.fma(2.0f * (xy + zw) * k2, x2, Math.fma((yy - xx - zz + ww) * k2, y2, 2.0f * (yz - xw) * k2 * z2)), Math.fma(2.0f * (xz - yw) * k2, x2, Math.fma(2.0f * (yz + xw) * k2, y2, (zz - xx - yy + ww) * k2 * z2)));
    }

    public Vector3f transformInverse(float x2, float y2, float z2, Vector3f dest) {
        float n2 = 1.0f / Math.fma(this.x, this.x, Math.fma(this.y, this.y, Math.fma(this.z, this.z, this.w * this.w)));
        float qx = this.x * n2;
        float qy = this.y * n2;
        float qz = this.z * n2;
        float qw2 = this.w * n2;
        float xx = qx * qx;
        float yy = qy * qy;
        float zz = qz * qz;
        float ww = qw2 * qw2;
        float xy = qx * qy;
        float xz = qx * qz;
        float yz = qy * qz;
        float xw = qx * qw2;
        float zw = qz * qw2;
        float yw = qy * qw2;
        float k2 = 1.0f / (xx + yy + zz + ww);
        return dest.set(Math.fma((xx - yy - zz + ww) * k2, x2, Math.fma(2.0f * (xy + zw) * k2, y2, 2.0f * (xz - yw) * k2 * z2)), Math.fma(2.0f * (xy - zw) * k2, x2, Math.fma((yy - xx - zz + ww) * k2, y2, 2.0f * (yz + xw) * k2 * z2)), Math.fma(2.0f * (xz + yw) * k2, x2, Math.fma(2.0f * (yz - xw) * k2, y2, (zz - xx - yy + ww) * k2 * z2)));
    }

    public Vector3f transformUnit(Vector3f vec) {
        return this.transformUnit(vec.x, vec.y, vec.z, vec);
    }

    public Vector3f transformInverseUnit(Vector3f vec) {
        return this.transformInverseUnit(vec.x, vec.y, vec.z, vec);
    }

    public Vector3f transformUnit(Vector3fc vec, Vector3f dest) {
        return this.transformUnit(vec.x(), vec.y(), vec.z(), dest);
    }

    public Vector3f transformInverseUnit(Vector3fc vec, Vector3f dest) {
        return this.transformInverseUnit(vec.x(), vec.y(), vec.z(), dest);
    }

    public Vector3f transformUnit(float x2, float y2, float z2, Vector3f dest) {
        float xx = this.x * this.x;
        float xy = this.x * this.y;
        float xz = this.x * this.z;
        float xw = this.x * this.w;
        float yy = this.y * this.y;
        float yz = this.y * this.z;
        float yw = this.y * this.w;
        float zz = this.z * this.z;
        float zw = this.z * this.w;
        return dest.set(Math.fma(Math.fma(-2.0f, yy + zz, 1.0f), x2, Math.fma(2.0f * (xy - zw), y2, 2.0f * (xz + yw) * z2)), Math.fma(2.0f * (xy + zw), x2, Math.fma(Math.fma(-2.0f, xx + zz, 1.0f), y2, 2.0f * (yz - xw) * z2)), Math.fma(2.0f * (xz - yw), x2, Math.fma(2.0f * (yz + xw), y2, Math.fma(-2.0f, xx + yy, 1.0f) * z2)));
    }

    public Vector3f transformInverseUnit(float x2, float y2, float z2, Vector3f dest) {
        float xx = this.x * this.x;
        float xy = this.x * this.y;
        float xz = this.x * this.z;
        float xw = this.x * this.w;
        float yy = this.y * this.y;
        float yz = this.y * this.z;
        float yw = this.y * this.w;
        float zz = this.z * this.z;
        float zw = this.z * this.w;
        return dest.set(Math.fma(Math.fma(-2.0f, yy + zz, 1.0f), x2, Math.fma(2.0f * (xy + zw), y2, 2.0f * (xz - yw) * z2)), Math.fma(2.0f * (xy - zw), x2, Math.fma(Math.fma(-2.0f, xx + zz, 1.0f), y2, 2.0f * (yz + xw) * z2)), Math.fma(2.0f * (xz + yw), x2, Math.fma(2.0f * (yz - xw), y2, Math.fma(-2.0f, xx + yy, 1.0f) * z2)));
    }

    public Vector4f transform(Vector4fc vec, Vector4f dest) {
        return this.transform(vec.x(), vec.y(), vec.z(), dest);
    }

    public Vector4f transformInverse(Vector4fc vec, Vector4f dest) {
        return this.transformInverse(vec.x(), vec.y(), vec.z(), dest);
    }

    public Vector4f transform(float x2, float y2, float z2, Vector4f dest) {
        float xx = this.x * this.x;
        float yy = this.y * this.y;
        float zz = this.z * this.z;
        float ww = this.w * this.w;
        float xy = this.x * this.y;
        float xz = this.x * this.z;
        float yz = this.y * this.z;
        float xw = this.x * this.w;
        float zw = this.z * this.w;
        float yw = this.y * this.w;
        float k2 = 1.0f / (xx + yy + zz + ww);
        return dest.set(Math.fma((xx - yy - zz + ww) * k2, x2, Math.fma(2.0f * (xy - zw) * k2, y2, 2.0f * (xz + yw) * k2 * z2)), Math.fma(2.0f * (xy + zw) * k2, x2, Math.fma((yy - xx - zz + ww) * k2, y2, 2.0f * (yz - xw) * k2 * z2)), Math.fma(2.0f * (xz - yw) * k2, x2, Math.fma(2.0f * (yz + xw) * k2, y2, (zz - xx - yy + ww) * k2 * z2)));
    }

    public Vector4f transformInverse(float x2, float y2, float z2, Vector4f dest) {
        float n2 = 1.0f / Math.fma(this.x, this.x, Math.fma(this.y, this.y, Math.fma(this.z, this.z, this.w * this.w)));
        float qx = this.x * n2;
        float qy = this.y * n2;
        float qz = this.z * n2;
        float qw2 = this.w * n2;
        float xx = qx * qx;
        float yy = qy * qy;
        float zz = qz * qz;
        float ww = qw2 * qw2;
        float xy = qx * qy;
        float xz = qx * qz;
        float yz = qy * qz;
        float xw = qx * qw2;
        float zw = qz * qw2;
        float yw = qy * qw2;
        float k2 = 1.0f / (xx + yy + zz + ww);
        return dest.set(Math.fma((xx - yy - zz + ww) * k2, x2, Math.fma(2.0f * (xy + zw) * k2, y2, 2.0f * (xz - yw) * k2 * z2)), Math.fma(2.0f * (xy - zw) * k2, x2, Math.fma((yy - xx - zz + ww) * k2, y2, 2.0f * (yz + xw) * k2 * z2)), Math.fma(2.0f * (xz + yw) * k2, x2, Math.fma(2.0f * (yz - xw) * k2, y2, (zz - xx - yy + ww) * k2 * z2)));
    }

    public Vector3d transform(Vector3d vec) {
        return this.transform(vec.x, vec.y, vec.z, vec);
    }

    public Vector3d transformInverse(Vector3d vec) {
        return this.transformInverse(vec.x, vec.y, vec.z, vec);
    }

    public Vector4f transformUnit(Vector4f vec) {
        return this.transformUnit(vec.x, vec.y, vec.z, vec);
    }

    public Vector4f transformInverseUnit(Vector4f vec) {
        return this.transformInverseUnit(vec.x, vec.y, vec.z, vec);
    }

    public Vector4f transformUnit(Vector4fc vec, Vector4f dest) {
        return this.transformUnit(vec.x(), vec.y(), vec.z(), dest);
    }

    public Vector4f transformInverseUnit(Vector4fc vec, Vector4f dest) {
        return this.transformInverseUnit(vec.x(), vec.y(), vec.z(), dest);
    }

    public Vector4f transformUnit(float x2, float y2, float z2, Vector4f dest) {
        float xx = this.x * this.x;
        float xy = this.x * this.y;
        float xz = this.x * this.z;
        float xw = this.x * this.w;
        float yy = this.y * this.y;
        float yz = this.y * this.z;
        float yw = this.y * this.w;
        float zz = this.z * this.z;
        float zw = this.z * this.w;
        return dest.set(Math.fma(Math.fma(-2.0f, yy + zz, 1.0f), x2, Math.fma(2.0f * (xy - zw), y2, 2.0f * (xz + yw) * z2)), Math.fma(2.0f * (xy + zw), x2, Math.fma(Math.fma(-2.0f, xx + zz, 1.0f), y2, 2.0f * (yz - xw) * z2)), Math.fma(2.0f * (xz - yw), x2, Math.fma(2.0f * (yz + xw), y2, Math.fma(-2.0f, xx + yy, 1.0f) * z2)));
    }

    public Vector4f transformInverseUnit(float x2, float y2, float z2, Vector4f dest) {
        float xx = this.x * this.x;
        float xy = this.x * this.y;
        float xz = this.x * this.z;
        float xw = this.x * this.w;
        float yy = this.y * this.y;
        float yz = this.y * this.z;
        float yw = this.y * this.w;
        float zz = this.z * this.z;
        float zw = this.z * this.w;
        return dest.set(Math.fma(Math.fma(-2.0f, yy + zz, 1.0f), x2, Math.fma(2.0f * (xy + zw), y2, 2.0f * (xz - yw) * z2)), Math.fma(2.0f * (xy - zw), x2, Math.fma(Math.fma(-2.0f, xx + zz, 1.0f), y2, 2.0f * (yz + xw) * z2)), Math.fma(2.0f * (xz + yw), x2, Math.fma(2.0f * (yz - xw), y2, Math.fma(-2.0f, xx + yy, 1.0f) * z2)));
    }

    public Vector3d transformPositiveX(Vector3d dest) {
        float ww = this.w * this.w;
        float xx = this.x * this.x;
        float yy = this.y * this.y;
        float zz = this.z * this.z;
        float zw = this.z * this.w;
        float xy = this.x * this.y;
        float xz = this.x * this.z;
        float yw = this.y * this.w;
        dest.x = ww + xx - zz - yy;
        dest.y = xy + zw + zw + xy;
        dest.z = xz - yw + xz - yw;
        return dest;
    }

    public Vector4d transformPositiveX(Vector4d dest) {
        float ww = this.w * this.w;
        float xx = this.x * this.x;
        float yy = this.y * this.y;
        float zz = this.z * this.z;
        float zw = this.z * this.w;
        float xy = this.x * this.y;
        float xz = this.x * this.z;
        float yw = this.y * this.w;
        dest.x = ww + xx - zz - yy;
        dest.y = xy + zw + zw + xy;
        dest.z = xz - yw + xz - yw;
        return dest;
    }

    public Vector3d transformUnitPositiveX(Vector3d dest) {
        float yy = this.y * this.y;
        float zz = this.z * this.z;
        float xy = this.x * this.y;
        float xz = this.x * this.z;
        float yw = this.y * this.w;
        float zw = this.z * this.w;
        dest.x = 1.0f - yy - yy - zz - zz;
        dest.y = xy + zw + xy + zw;
        dest.z = xz - yw + xz - yw;
        return dest;
    }

    public Vector4d transformUnitPositiveX(Vector4d dest) {
        float yy = this.y * this.y;
        float zz = this.z * this.z;
        float xy = this.x * this.y;
        float xz = this.x * this.z;
        float yw = this.y * this.w;
        float zw = this.z * this.w;
        dest.x = 1.0f - yy - yy - zz - zz;
        dest.y = xy + zw + xy + zw;
        dest.z = xz - yw + xz - yw;
        return dest;
    }

    public Vector3d transformPositiveY(Vector3d dest) {
        float ww = this.w * this.w;
        float xx = this.x * this.x;
        float yy = this.y * this.y;
        float zz = this.z * this.z;
        float zw = this.z * this.w;
        float xy = this.x * this.y;
        float yz = this.y * this.z;
        float xw = this.x * this.w;
        dest.x = -zw + xy - zw + xy;
        dest.y = yy - zz + ww - xx;
        dest.z = yz + yz + xw + xw;
        return dest;
    }

    public Vector4d transformPositiveY(Vector4d dest) {
        float ww = this.w * this.w;
        float xx = this.x * this.x;
        float yy = this.y * this.y;
        float zz = this.z * this.z;
        float zw = this.z * this.w;
        float xy = this.x * this.y;
        float yz = this.y * this.z;
        float xw = this.x * this.w;
        dest.x = -zw + xy - zw + xy;
        dest.y = yy - zz + ww - xx;
        dest.z = yz + yz + xw + xw;
        return dest;
    }

    public Vector4d transformUnitPositiveY(Vector4d dest) {
        float xx = this.x * this.x;
        float zz = this.z * this.z;
        float xy = this.x * this.y;
        float yz = this.y * this.z;
        float xw = this.x * this.w;
        float zw = this.z * this.w;
        dest.x = xy - zw + xy - zw;
        dest.y = 1.0f - xx - xx - zz - zz;
        dest.z = yz + yz + xw + xw;
        return dest;
    }

    public Vector3d transformUnitPositiveY(Vector3d dest) {
        float xx = this.x * this.x;
        float zz = this.z * this.z;
        float xy = this.x * this.y;
        float yz = this.y * this.z;
        float xw = this.x * this.w;
        float zw = this.z * this.w;
        dest.x = xy - zw + xy - zw;
        dest.y = 1.0f - xx - xx - zz - zz;
        dest.z = yz + yz + xw + xw;
        return dest;
    }

    public Vector3d transformPositiveZ(Vector3d dest) {
        float ww = this.w * this.w;
        float xx = this.x * this.x;
        float yy = this.y * this.y;
        float zz = this.z * this.z;
        float xz = this.x * this.z;
        float yw = this.y * this.w;
        float yz = this.y * this.z;
        float xw = this.x * this.w;
        dest.x = yw + xz + xz + yw;
        dest.y = yz + yz - xw - xw;
        dest.z = zz - yy - xx + ww;
        return dest;
    }

    public Vector4d transformPositiveZ(Vector4d dest) {
        float ww = this.w * this.w;
        float xx = this.x * this.x;
        float yy = this.y * this.y;
        float zz = this.z * this.z;
        float xz = this.x * this.z;
        float yw = this.y * this.w;
        float yz = this.y * this.z;
        float xw = this.x * this.w;
        dest.x = yw + xz + xz + yw;
        dest.y = yz + yz - xw - xw;
        dest.z = zz - yy - xx + ww;
        return dest;
    }

    public Vector4d transformUnitPositiveZ(Vector4d dest) {
        float xx = this.x * this.x;
        float yy = this.y * this.y;
        float xz = this.x * this.z;
        float yz = this.y * this.z;
        float xw = this.x * this.w;
        float yw = this.y * this.w;
        dest.x = xz + yw + xz + yw;
        dest.y = yz + yz - xw - xw;
        dest.z = 1.0f - xx - xx - yy - yy;
        return dest;
    }

    public Vector3d transformUnitPositiveZ(Vector3d dest) {
        float xx = this.x * this.x;
        float yy = this.y * this.y;
        float xz = this.x * this.z;
        float yz = this.y * this.z;
        float xw = this.x * this.w;
        float yw = this.y * this.w;
        dest.x = xz + yw + xz + yw;
        dest.y = yz + yz - xw - xw;
        dest.z = 1.0f - xx - xx - yy - yy;
        return dest;
    }

    public Vector4d transform(Vector4d vec) {
        return this.transform(vec, vec);
    }

    public Vector4d transformInverse(Vector4d vec) {
        return this.transformInverse(vec, vec);
    }

    public Vector3d transform(Vector3dc vec, Vector3d dest) {
        return this.transform(vec.x(), vec.y(), vec.z(), dest);
    }

    public Vector3d transformInverse(Vector3dc vec, Vector3d dest) {
        return this.transformInverse(vec.x(), vec.y(), vec.z(), dest);
    }

    public Vector3d transform(float x2, float y2, float z2, Vector3d dest) {
        return this.transform((double)x2, (double)y2, (double)z2, dest);
    }

    public Vector3d transformInverse(float x2, float y2, float z2, Vector3d dest) {
        return this.transformInverse((double)x2, (double)y2, (double)z2, dest);
    }

    public Vector3d transform(double x2, double y2, double z2, Vector3d dest) {
        float xx = this.x * this.x;
        float yy = this.y * this.y;
        float zz = this.z * this.z;
        float ww = this.w * this.w;
        float xy = this.x * this.y;
        float xz = this.x * this.z;
        float yz = this.y * this.z;
        float xw = this.x * this.w;
        float zw = this.z * this.w;
        float yw = this.y * this.w;
        float k2 = 1.0f / (xx + yy + zz + ww);
        return dest.set(Math.fma((double)((xx - yy - zz + ww) * k2), x2, Math.fma((double)(2.0f * (xy - zw) * k2), y2, (double)(2.0f * (xz + yw) * k2) * z2)), Math.fma((double)(2.0f * (xy + zw) * k2), x2, Math.fma((double)((yy - xx - zz + ww) * k2), y2, (double)(2.0f * (yz - xw) * k2) * z2)), Math.fma((double)(2.0f * (xz - yw) * k2), x2, Math.fma((double)(2.0f * (yz + xw) * k2), y2, (double)((zz - xx - yy + ww) * k2) * z2)));
    }

    public Vector3d transformInverse(double x2, double y2, double z2, Vector3d dest) {
        float n2 = 1.0f / Math.fma(this.x, this.x, Math.fma(this.y, this.y, Math.fma(this.z, this.z, this.w * this.w)));
        float qx = this.x * n2;
        float qy = this.y * n2;
        float qz = this.z * n2;
        float qw2 = this.w * n2;
        float xx = qx * qx;
        float yy = qy * qy;
        float zz = qz * qz;
        float ww = qw2 * qw2;
        float xy = qx * qy;
        float xz = qx * qz;
        float yz = qy * qz;
        float xw = qx * qw2;
        float zw = qz * qw2;
        float yw = qy * qw2;
        float k2 = 1.0f / (xx + yy + zz + ww);
        return dest.set(Math.fma((double)((xx - yy - zz + ww) * k2), x2, Math.fma((double)(2.0f * (xy + zw) * k2), y2, (double)(2.0f * (xz - yw) * k2) * z2)), Math.fma((double)(2.0f * (xy - zw) * k2), x2, Math.fma((double)((yy - xx - zz + ww) * k2), y2, (double)(2.0f * (yz + xw) * k2) * z2)), Math.fma((double)(2.0f * (xz + yw) * k2), x2, Math.fma((double)(2.0f * (yz - xw) * k2), y2, (double)((zz - xx - yy + ww) * k2) * z2)));
    }

    public Vector4d transform(Vector4dc vec, Vector4d dest) {
        return this.transform(vec.x(), vec.y(), vec.z(), dest);
    }

    public Vector4d transformInverse(Vector4dc vec, Vector4d dest) {
        return this.transformInverse(vec.x(), vec.y(), vec.z(), dest);
    }

    public Vector4d transform(double x2, double y2, double z2, Vector4d dest) {
        float xx = this.x * this.x;
        float yy = this.y * this.y;
        float zz = this.z * this.z;
        float ww = this.w * this.w;
        float xy = this.x * this.y;
        float xz = this.x * this.z;
        float yz = this.y * this.z;
        float xw = this.x * this.w;
        float zw = this.z * this.w;
        float yw = this.y * this.w;
        float k2 = 1.0f / (xx + yy + zz + ww);
        return dest.set(Math.fma((double)((xx - yy - zz + ww) * k2), x2, Math.fma((double)(2.0f * (xy - zw) * k2), y2, (double)(2.0f * (xz + yw) * k2) * z2)), Math.fma((double)(2.0f * (xy + zw) * k2), x2, Math.fma((double)((yy - xx - zz + ww) * k2), y2, (double)(2.0f * (yz - xw) * k2) * z2)), Math.fma((double)(2.0f * (xz - yw) * k2), x2, Math.fma((double)(2.0f * (yz + xw) * k2), y2, (double)((zz - xx - yy + ww) * k2) * z2)));
    }

    public Vector4d transformInverse(double x2, double y2, double z2, Vector4d dest) {
        float n2 = 1.0f / Math.fma(this.x, this.x, Math.fma(this.y, this.y, Math.fma(this.z, this.z, this.w * this.w)));
        float qx = this.x * n2;
        float qy = this.y * n2;
        float qz = this.z * n2;
        float qw2 = this.w * n2;
        float xx = qx * qx;
        float yy = qy * qy;
        float zz = qz * qz;
        float ww = qw2 * qw2;
        float xy = qx * qy;
        float xz = qx * qz;
        float yz = qy * qz;
        float xw = qx * qw2;
        float zw = qz * qw2;
        float yw = qy * qw2;
        float k2 = 1.0f / (xx + yy + zz + ww);
        return dest.set(Math.fma((double)((xx - yy - zz + ww) * k2), x2, Math.fma((double)(2.0f * (xy + zw) * k2), y2, (double)(2.0f * (xz - yw) * k2) * z2)), Math.fma((double)(2.0f * (xy - zw) * k2), x2, Math.fma((double)((yy - xx - zz + ww) * k2), y2, (double)(2.0f * (yz + xw) * k2) * z2)), Math.fma((double)(2.0f * (xz + yw) * k2), x2, Math.fma((double)(2.0f * (yz - xw) * k2), y2, (double)((zz - xx - yy + ww) * k2) * z2)));
    }

    public Vector4d transformUnit(Vector4d vec) {
        return this.transformUnit(vec, vec);
    }

    public Vector4d transformInverseUnit(Vector4d vec) {
        return this.transformInverseUnit(vec, vec);
    }

    public Vector3d transformUnit(Vector3dc vec, Vector3d dest) {
        return this.transformUnit(vec.x(), vec.y(), vec.z(), dest);
    }

    public Vector3d transformInverseUnit(Vector3dc vec, Vector3d dest) {
        return this.transformInverseUnit(vec.x(), vec.y(), vec.z(), dest);
    }

    public Vector3d transformUnit(float x2, float y2, float z2, Vector3d dest) {
        return this.transformUnit((double)x2, (double)y2, (double)z2, dest);
    }

    public Vector3d transformInverseUnit(float x2, float y2, float z2, Vector3d dest) {
        return this.transformInverseUnit((double)x2, (double)y2, (double)z2, dest);
    }

    public Vector3d transformUnit(double x2, double y2, double z2, Vector3d dest) {
        float xx = this.x * this.x;
        float xy = this.x * this.y;
        float xz = this.x * this.z;
        float xw = this.x * this.w;
        float yy = this.y * this.y;
        float yz = this.y * this.z;
        float yw = this.y * this.w;
        float zz = this.z * this.z;
        float zw = this.z * this.w;
        return dest.set(Math.fma((double)Math.fma(-2.0f, yy + zz, 1.0f), x2, Math.fma((double)(2.0f * (xy - zw)), y2, (double)(2.0f * (xz + yw)) * z2)), Math.fma((double)(2.0f * (xy + zw)), x2, Math.fma((double)Math.fma(-2.0f, xx + zz, 1.0f), y2, (double)(2.0f * (yz - xw)) * z2)), Math.fma((double)(2.0f * (xz - yw)), x2, Math.fma((double)(2.0f * (yz + xw)), y2, (double)Math.fma(-2.0f, xx + yy, 1.0f) * z2)));
    }

    public Vector3d transformInverseUnit(double x2, double y2, double z2, Vector3d dest) {
        float xx = this.x * this.x;
        float xy = this.x * this.y;
        float xz = this.x * this.z;
        float xw = this.x * this.w;
        float yy = this.y * this.y;
        float yz = this.y * this.z;
        float yw = this.y * this.w;
        float zz = this.z * this.z;
        float zw = this.z * this.w;
        return dest.set(Math.fma((double)Math.fma(-2.0f, yy + zz, 1.0f), x2, Math.fma((double)(2.0f * (xy + zw)), y2, (double)(2.0f * (xz - yw)) * z2)), Math.fma((double)(2.0f * (xy - zw)), x2, Math.fma((double)Math.fma(-2.0f, xx + zz, 1.0f), y2, (double)(2.0f * (yz + xw)) * z2)), Math.fma((double)(2.0f * (xz + yw)), x2, Math.fma((double)(2.0f * (yz - xw)), y2, (double)Math.fma(-2.0f, xx + yy, 1.0f) * z2)));
    }

    public Vector4d transformUnit(Vector4dc vec, Vector4d dest) {
        return this.transformUnit(vec.x(), vec.y(), vec.z(), dest);
    }

    public Vector4d transformInverseUnit(Vector4dc vec, Vector4d dest) {
        return this.transformInverseUnit(vec.x(), vec.y(), vec.z(), dest);
    }

    public Vector4d transformUnit(double x2, double y2, double z2, Vector4d dest) {
        float xx = this.x * this.x;
        float xy = this.x * this.y;
        float xz = this.x * this.z;
        float xw = this.x * this.w;
        float yy = this.y * this.y;
        float yz = this.y * this.z;
        float yw = this.y * this.w;
        float zz = this.z * this.z;
        float zw = this.z * this.w;
        return dest.set(Math.fma((double)Math.fma(-2.0f, yy + zz, 1.0f), x2, Math.fma((double)(2.0f * (xy - zw)), y2, (double)(2.0f * (xz + yw)) * z2)), Math.fma((double)(2.0f * (xy + zw)), x2, Math.fma((double)Math.fma(-2.0f, xx + zz, 1.0f), y2, (double)(2.0f * (yz - xw)) * z2)), Math.fma((double)(2.0f * (xz - yw)), x2, Math.fma((double)(2.0f * (yz + xw)), y2, (double)Math.fma(-2.0f, xx + yy, 1.0f) * z2)));
    }

    public Vector4d transformInverseUnit(double x2, double y2, double z2, Vector4d dest) {
        float xx = this.x * this.x;
        float xy = this.x * this.y;
        float xz = this.x * this.z;
        float xw = this.x * this.w;
        float yy = this.y * this.y;
        float yz = this.y * this.z;
        float yw = this.y * this.w;
        float zz = this.z * this.z;
        float zw = this.z * this.w;
        return dest.set(Math.fma((double)Math.fma(-2.0f, yy + zz, 1.0f), x2, Math.fma((double)(2.0f * (xy + zw)), y2, (double)(2.0f * (xz - yw)) * z2)), Math.fma((double)(2.0f * (xy - zw)), x2, Math.fma((double)Math.fma(-2.0f, xx + zz, 1.0f), y2, (double)(2.0f * (yz + xw)) * z2)), Math.fma((double)(2.0f * (xz + yw)), x2, Math.fma((double)(2.0f * (yz - xw)), y2, (double)Math.fma(-2.0f, xx + yy, 1.0f) * z2)));
    }

    public Quaternionf invert(Quaternionf dest) {
        float invNorm = 1.0f / Math.fma(this.x, this.x, Math.fma(this.y, this.y, Math.fma(this.z, this.z, this.w * this.w)));
        dest.x = -this.x * invNorm;
        dest.y = -this.y * invNorm;
        dest.z = -this.z * invNorm;
        dest.w = this.w * invNorm;
        return dest;
    }

    public Quaternionf invert() {
        return this.invert(this);
    }

    public Quaternionf div(Quaternionfc b2, Quaternionf dest) {
        float invNorm = 1.0f / Math.fma(b2.x(), b2.x(), Math.fma(b2.y(), b2.y(), Math.fma(b2.z(), b2.z(), b2.w() * b2.w())));
        float x2 = -b2.x() * invNorm;
        float y2 = -b2.y() * invNorm;
        float z2 = -b2.z() * invNorm;
        float w2 = b2.w() * invNorm;
        return dest.set(Math.fma(this.w, x2, Math.fma(this.x, w2, Math.fma(this.y, z2, -this.z * y2))), Math.fma(this.w, y2, Math.fma(-this.x, z2, Math.fma(this.y, w2, this.z * x2))), Math.fma(this.w, z2, Math.fma(this.x, y2, Math.fma(-this.y, x2, this.z * w2))), Math.fma(this.w, w2, Math.fma(-this.x, x2, Math.fma(-this.y, y2, -this.z * z2))));
    }

    public Quaternionf div(Quaternionfc b2) {
        return this.div(b2, this);
    }

    public Quaternionf conjugate() {
        return this.conjugate(this);
    }

    public Quaternionf conjugate(Quaternionf dest) {
        dest.x = -this.x;
        dest.y = -this.y;
        dest.z = -this.z;
        dest.w = this.w;
        return dest;
    }

    public Quaternionf identity() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
        this.w = 1.0f;
        return this;
    }

    public Quaternionf rotateXYZ(float angleX, float angleY, float angleZ) {
        return this.rotateXYZ(angleX, angleY, angleZ, this);
    }

    public Quaternionf rotateXYZ(float angleX, float angleY, float angleZ, Quaternionf dest) {
        float sx = Math.sin(angleX * 0.5f);
        float cx2 = Math.cosFromSin(sx, angleX * 0.5f);
        float sy = Math.sin(angleY * 0.5f);
        float cy2 = Math.cosFromSin(sy, angleY * 0.5f);
        float sz = Math.sin(angleZ * 0.5f);
        float cz2 = Math.cosFromSin(sz, angleZ * 0.5f);
        float cycz = cy2 * cz2;
        float sysz = sy * sz;
        float sycz = sy * cz2;
        float cysz = cy2 * sz;
        float w2 = cx2 * cycz - sx * sysz;
        float x2 = sx * cycz + cx2 * sysz;
        float y2 = cx2 * sycz - sx * cysz;
        float z2 = cx2 * cysz + sx * sycz;
        return dest.set(Math.fma(this.w, x2, Math.fma(this.x, w2, Math.fma(this.y, z2, -this.z * y2))), Math.fma(this.w, y2, Math.fma(-this.x, z2, Math.fma(this.y, w2, this.z * x2))), Math.fma(this.w, z2, Math.fma(this.x, y2, Math.fma(-this.y, x2, this.z * w2))), Math.fma(this.w, w2, Math.fma(-this.x, x2, Math.fma(-this.y, y2, -this.z * z2))));
    }

    public Quaternionf rotateZYX(float angleZ, float angleY, float angleX) {
        return this.rotateZYX(angleZ, angleY, angleX, this);
    }

    public Quaternionf rotateZYX(float angleZ, float angleY, float angleX, Quaternionf dest) {
        float sx = Math.sin(angleX * 0.5f);
        float cx2 = Math.cosFromSin(sx, angleX * 0.5f);
        float sy = Math.sin(angleY * 0.5f);
        float cy2 = Math.cosFromSin(sy, angleY * 0.5f);
        float sz = Math.sin(angleZ * 0.5f);
        float cz2 = Math.cosFromSin(sz, angleZ * 0.5f);
        float cycz = cy2 * cz2;
        float sysz = sy * sz;
        float sycz = sy * cz2;
        float cysz = cy2 * sz;
        float w2 = cx2 * cycz + sx * sysz;
        float x2 = sx * cycz - cx2 * sysz;
        float y2 = cx2 * sycz + sx * cysz;
        float z2 = cx2 * cysz - sx * sycz;
        return dest.set(Math.fma(this.w, x2, Math.fma(this.x, w2, Math.fma(this.y, z2, -this.z * y2))), Math.fma(this.w, y2, Math.fma(-this.x, z2, Math.fma(this.y, w2, this.z * x2))), Math.fma(this.w, z2, Math.fma(this.x, y2, Math.fma(-this.y, x2, this.z * w2))), Math.fma(this.w, w2, Math.fma(-this.x, x2, Math.fma(-this.y, y2, -this.z * z2))));
    }

    public Quaternionf rotateYXZ(float angleY, float angleX, float angleZ) {
        return this.rotateYXZ(angleY, angleX, angleZ, this);
    }

    public Quaternionf rotateYXZ(float angleY, float angleX, float angleZ, Quaternionf dest) {
        float sx = Math.sin(angleX * 0.5f);
        float cx2 = Math.cosFromSin(sx, angleX * 0.5f);
        float sy = Math.sin(angleY * 0.5f);
        float cy2 = Math.cosFromSin(sy, angleY * 0.5f);
        float sz = Math.sin(angleZ * 0.5f);
        float cz2 = Math.cosFromSin(sz, angleZ * 0.5f);
        float yx = cy2 * sx;
        float yy = sy * cx2;
        float yz = sy * sx;
        float yw = cy2 * cx2;
        float x2 = yx * cz2 + yy * sz;
        float y2 = yy * cz2 - yx * sz;
        float z2 = yw * sz - yz * cz2;
        float w2 = yw * cz2 + yz * sz;
        return dest.set(Math.fma(this.w, x2, Math.fma(this.x, w2, Math.fma(this.y, z2, -this.z * y2))), Math.fma(this.w, y2, Math.fma(-this.x, z2, Math.fma(this.y, w2, this.z * x2))), Math.fma(this.w, z2, Math.fma(this.x, y2, Math.fma(-this.y, x2, this.z * w2))), Math.fma(this.w, w2, Math.fma(-this.x, x2, Math.fma(-this.y, y2, -this.z * z2))));
    }

    public Vector3f getEulerAnglesXYZ(Vector3f eulerAngles) {
        eulerAngles.x = Math.atan2(this.x * this.w - this.y * this.z, 0.5f - this.x * this.x - this.y * this.y);
        eulerAngles.y = Math.safeAsin(2.0f * (this.x * this.z + this.y * this.w));
        eulerAngles.z = Math.atan2(this.z * this.w - this.x * this.y, 0.5f - this.y * this.y - this.z * this.z);
        return eulerAngles;
    }

    public Vector3f getEulerAnglesZYX(Vector3f eulerAngles) {
        eulerAngles.x = Math.atan2(this.y * this.z + this.w * this.x, 0.5f - this.x * this.x + this.y * this.y);
        eulerAngles.y = Math.safeAsin(-2.0f * (this.x * this.z - this.w * this.y));
        eulerAngles.z = Math.atan2(this.x * this.y + this.w * this.z, 0.5f - this.y * this.y - this.z * this.z);
        return eulerAngles;
    }

    public Vector3f getEulerAnglesZXY(Vector3f eulerAngles) {
        eulerAngles.x = Math.safeAsin(2.0f * (this.w * this.x + this.y * this.z));
        eulerAngles.y = Math.atan2(this.w * this.y - this.x * this.z, 0.5f - this.y * this.y - this.x * this.x);
        eulerAngles.z = Math.atan2(this.w * this.z - this.x * this.y, 0.5f - this.z * this.z - this.x * this.x);
        return eulerAngles;
    }

    public Vector3f getEulerAnglesYXZ(Vector3f eulerAngles) {
        eulerAngles.x = Math.safeAsin(-2.0f * (this.y * this.z - this.w * this.x));
        eulerAngles.y = Math.atan2(this.x * this.z + this.y * this.w, 0.5f - this.y * this.y - this.x * this.x);
        eulerAngles.z = Math.atan2(this.y * this.x + this.w * this.z, 0.5f - this.x * this.x - this.z * this.z);
        return eulerAngles;
    }

    public float lengthSquared() {
        return Math.fma(this.x, this.x, Math.fma(this.y, this.y, Math.fma(this.z, this.z, this.w * this.w)));
    }

    public Quaternionf rotationXYZ(float angleX, float angleY, float angleZ) {
        float sx = Math.sin(angleX * 0.5f);
        float cx2 = Math.cosFromSin(sx, angleX * 0.5f);
        float sy = Math.sin(angleY * 0.5f);
        float cy2 = Math.cosFromSin(sy, angleY * 0.5f);
        float sz = Math.sin(angleZ * 0.5f);
        float cz2 = Math.cosFromSin(sz, angleZ * 0.5f);
        float cycz = cy2 * cz2;
        float sysz = sy * sz;
        float sycz = sy * cz2;
        float cysz = cy2 * sz;
        this.w = cx2 * cycz - sx * sysz;
        this.x = sx * cycz + cx2 * sysz;
        this.y = cx2 * sycz - sx * cysz;
        this.z = cx2 * cysz + sx * sycz;
        return this;
    }

    public Quaternionf rotationZYX(float angleZ, float angleY, float angleX) {
        float sx = Math.sin(angleX * 0.5f);
        float cx2 = Math.cosFromSin(sx, angleX * 0.5f);
        float sy = Math.sin(angleY * 0.5f);
        float cy2 = Math.cosFromSin(sy, angleY * 0.5f);
        float sz = Math.sin(angleZ * 0.5f);
        float cz2 = Math.cosFromSin(sz, angleZ * 0.5f);
        float cycz = cy2 * cz2;
        float sysz = sy * sz;
        float sycz = sy * cz2;
        float cysz = cy2 * sz;
        this.w = cx2 * cycz + sx * sysz;
        this.x = sx * cycz - cx2 * sysz;
        this.y = cx2 * sycz + sx * cysz;
        this.z = cx2 * cysz - sx * sycz;
        return this;
    }

    public Quaternionf rotationYXZ(float angleY, float angleX, float angleZ) {
        float sx = Math.sin(angleX * 0.5f);
        float cx2 = Math.cosFromSin(sx, angleX * 0.5f);
        float sy = Math.sin(angleY * 0.5f);
        float cy2 = Math.cosFromSin(sy, angleY * 0.5f);
        float sz = Math.sin(angleZ * 0.5f);
        float cz2 = Math.cosFromSin(sz, angleZ * 0.5f);
        float x2 = cy2 * sx;
        float y2 = sy * cx2;
        float z2 = sy * sx;
        float w2 = cy2 * cx2;
        this.x = x2 * cz2 + y2 * sz;
        this.y = y2 * cz2 - x2 * sz;
        this.z = w2 * sz - z2 * cz2;
        this.w = w2 * cz2 + z2 * sz;
        return this;
    }

    public Quaternionf slerp(Quaternionfc target, float alpha) {
        return this.slerp(target, alpha, this);
    }

    public Quaternionf slerp(Quaternionfc target, float alpha, Quaternionf dest) {
        float scale1;
        float scale0;
        float cosom = Math.fma(this.x, target.x(), Math.fma(this.y, target.y(), Math.fma(this.z, target.z(), this.w * target.w())));
        float absCosom = Math.abs(cosom);
        if (1.0f - absCosom > 1.0E-6f) {
            float sinSqr = 1.0f - absCosom * absCosom;
            float sinom = Math.invsqrt(sinSqr);
            float omega = Math.atan2(sinSqr * sinom, absCosom);
            scale0 = (float)(Math.sin((1.0 - (double)alpha) * (double)omega) * (double)sinom);
            scale1 = Math.sin(alpha * omega) * sinom;
        } else {
            scale0 = 1.0f - alpha;
            scale1 = alpha;
        }
        scale1 = cosom >= 0.0f ? scale1 : -scale1;
        dest.x = Math.fma(scale0, this.x, scale1 * target.x());
        dest.y = Math.fma(scale0, this.y, scale1 * target.y());
        dest.z = Math.fma(scale0, this.z, scale1 * target.z());
        dest.w = Math.fma(scale0, this.w, scale1 * target.w());
        return dest;
    }

    public static Quaternionfc slerp(Quaternionf[] qs, float[] weights, Quaternionf dest) {
        dest.set(qs[0]);
        float w2 = weights[0];
        for (int i2 = 1; i2 < qs.length; ++i2) {
            float w0 = w2;
            float w1 = weights[i2];
            float rw1 = w1 / (w0 + w1);
            w2 += w1;
            dest.slerp(qs[i2], rw1);
        }
        return dest;
    }

    public Quaternionf scale(float factor) {
        return this.scale(factor, this);
    }

    public Quaternionf scale(float factor, Quaternionf dest) {
        float sqrt = Math.sqrt(factor);
        dest.x = sqrt * this.x;
        dest.y = sqrt * this.y;
        dest.z = sqrt * this.z;
        dest.w = sqrt * this.w;
        return dest;
    }

    public Quaternionf scaling(float factor) {
        float sqrt = Math.sqrt(factor);
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
        this.w = sqrt;
        return this;
    }

    public Quaternionf integrate(float dt2, float vx, float vy, float vz) {
        return this.integrate(dt2, vx, vy, vz, this);
    }

    public Quaternionf integrate(float dt2, float vx, float vy, float vz, Quaternionf dest) {
        float s2;
        float dqW;
        float thetaX = dt2 * vx * 0.5f;
        float thetaY = dt2 * vy * 0.5f;
        float thetaZ = dt2 * vz * 0.5f;
        float thetaMagSq = thetaX * thetaX + thetaY * thetaY + thetaZ * thetaZ;
        if (thetaMagSq * thetaMagSq / 24.0f < 1.0E-8f) {
            dqW = 1.0f - thetaMagSq * 0.5f;
            s2 = 1.0f - thetaMagSq / 6.0f;
        } else {
            float thetaMag = Math.sqrt(thetaMagSq);
            float sin = Math.sin(thetaMag);
            s2 = sin / thetaMag;
            dqW = Math.cosFromSin(sin, thetaMag);
        }
        float dqX = thetaX * s2;
        float dqY = thetaY * s2;
        float dqZ = thetaZ * s2;
        return dest.set(Math.fma(dqW, this.x, Math.fma(dqX, this.w, Math.fma(dqY, this.z, -dqZ * this.y))), Math.fma(dqW, this.y, Math.fma(-dqX, this.z, Math.fma(dqY, this.w, dqZ * this.x))), Math.fma(dqW, this.z, Math.fma(dqX, this.y, Math.fma(-dqY, this.x, dqZ * this.w))), Math.fma(dqW, this.w, Math.fma(-dqX, this.x, Math.fma(-dqY, this.y, -dqZ * this.z))));
    }

    public Quaternionf nlerp(Quaternionfc q2, float factor) {
        return this.nlerp(q2, factor, this);
    }

    public Quaternionf nlerp(Quaternionfc q2, float factor, Quaternionf dest) {
        float cosom = Math.fma(this.x, q2.x(), Math.fma(this.y, q2.y(), Math.fma(this.z, q2.z(), this.w * q2.w())));
        float scale0 = 1.0f - factor;
        float scale1 = cosom >= 0.0f ? factor : -factor;
        dest.x = Math.fma(scale0, this.x, scale1 * q2.x());
        dest.y = Math.fma(scale0, this.y, scale1 * q2.y());
        dest.z = Math.fma(scale0, this.z, scale1 * q2.z());
        dest.w = Math.fma(scale0, this.w, scale1 * q2.w());
        float s2 = Math.invsqrt(Math.fma(dest.x, dest.x, Math.fma(dest.y, dest.y, Math.fma(dest.z, dest.z, dest.w * dest.w))));
        dest.x *= s2;
        dest.y *= s2;
        dest.z *= s2;
        dest.w *= s2;
        return dest;
    }

    public static Quaternionfc nlerp(Quaternionfc[] qs, float[] weights, Quaternionf dest) {
        dest.set(qs[0]);
        float w2 = weights[0];
        for (int i2 = 1; i2 < qs.length; ++i2) {
            float w0 = w2;
            float w1 = weights[i2];
            float rw1 = w1 / (w0 + w1);
            w2 += w1;
            dest.nlerp(qs[i2], rw1);
        }
        return dest;
    }

    public Quaternionf nlerpIterative(Quaternionfc q2, float alpha, float dotThreshold, Quaternionf dest) {
        float scale1;
        float scale0;
        float q2w;
        float q2z;
        float q2y;
        float q1x = this.x;
        float q1y = this.y;
        float q1z = this.z;
        float q1w = this.w;
        float q2x = q2.x();
        float dot = Math.fma(q1x, q2x, Math.fma(q1y, q2y = q2.y(), Math.fma(q1z, q2z = q2.z(), q1w * (q2w = q2.w()))));
        float absDot = Math.abs(dot);
        if (0.999999f < absDot) {
            return dest.set(this);
        }
        float alphaN = alpha;
        while (absDot < dotThreshold) {
            float s2;
            scale0 = 0.5f;
            float f2 = scale1 = dot >= 0.0f ? 0.5f : -0.5f;
            if (alphaN < 0.5f) {
                q2x = Math.fma(scale0, q2x, scale1 * q1x);
                q2y = Math.fma(scale0, q2y, scale1 * q1y);
                q2z = Math.fma(scale0, q2z, scale1 * q1z);
                q2w = Math.fma(scale0, q2w, scale1 * q1w);
                s2 = Math.invsqrt(Math.fma(q2x, q2x, Math.fma(q2y, q2y, Math.fma(q2z, q2z, q2w * q2w))));
                q2x *= s2;
                q2y *= s2;
                q2z *= s2;
                q2w *= s2;
                alphaN += alphaN;
            } else {
                q1x = Math.fma(scale0, q1x, scale1 * q2x);
                q1y = Math.fma(scale0, q1y, scale1 * q2y);
                q1z = Math.fma(scale0, q1z, scale1 * q2z);
                q1w = Math.fma(scale0, q1w, scale1 * q2w);
                s2 = Math.invsqrt(Math.fma(q1x, q1x, Math.fma(q1y, q1y, Math.fma(q1z, q1z, q1w * q1w))));
                q1x *= s2;
                q1y *= s2;
                q1z *= s2;
                q1w *= s2;
                alphaN = alphaN + alphaN - 1.0f;
            }
            dot = Math.fma(q1x, q2x, Math.fma(q1y, q2y, Math.fma(q1z, q2z, q1w * q2w)));
            absDot = Math.abs(dot);
        }
        scale0 = 1.0f - alphaN;
        scale1 = dot >= 0.0f ? alphaN : -alphaN;
        float resX = Math.fma(scale0, q1x, scale1 * q2x);
        float resY = Math.fma(scale0, q1y, scale1 * q2y);
        float resZ = Math.fma(scale0, q1z, scale1 * q2z);
        float resW = Math.fma(scale0, q1w, scale1 * q2w);
        float s3 = Math.invsqrt(Math.fma(resX, resX, Math.fma(resY, resY, Math.fma(resZ, resZ, resW * resW))));
        dest.x = resX * s3;
        dest.y = resY * s3;
        dest.z = resZ * s3;
        dest.w = resW * s3;
        return dest;
    }

    public Quaternionf nlerpIterative(Quaternionfc q2, float alpha, float dotThreshold) {
        return this.nlerpIterative(q2, alpha, dotThreshold, this);
    }

    public static Quaternionfc nlerpIterative(Quaternionf[] qs, float[] weights, float dotThreshold, Quaternionf dest) {
        dest.set(qs[0]);
        float w2 = weights[0];
        for (int i2 = 1; i2 < qs.length; ++i2) {
            float w0 = w2;
            float w1 = weights[i2];
            float rw1 = w1 / (w0 + w1);
            w2 += w1;
            dest.nlerpIterative(qs[i2], rw1, dotThreshold);
        }
        return dest;
    }

    public Quaternionf lookAlong(Vector3fc dir, Vector3fc up) {
        return this.lookAlong(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z(), this);
    }

    public Quaternionf lookAlong(Vector3fc dir, Vector3fc up, Quaternionf dest) {
        return this.lookAlong(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z(), dest);
    }

    public Quaternionf lookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        return this.lookAlong(dirX, dirY, dirZ, upX, upY, upZ, this);
    }

    public Quaternionf lookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ, Quaternionf dest) {
        float z2;
        float y2;
        float x2;
        float w2;
        float invDirLength = Math.invsqrt(dirX * dirX + dirY * dirY + dirZ * dirZ);
        float dirnX = -dirX * invDirLength;
        float dirnY = -dirY * invDirLength;
        float dirnZ = -dirZ * invDirLength;
        float leftX = upY * dirnZ - upZ * dirnY;
        float leftY = upZ * dirnX - upX * dirnZ;
        float leftZ = upX * dirnY - upY * dirnX;
        float invLeftLength = Math.invsqrt(leftX * leftX + leftY * leftY + leftZ * leftZ);
        float upnX = dirnY * (leftZ *= invLeftLength) - dirnZ * (leftY *= invLeftLength);
        float upnY = dirnZ * (leftX *= invLeftLength) - dirnX * leftZ;
        float upnZ = dirnX * leftY - dirnY * leftX;
        double tr = leftX + upnY + dirnZ;
        if (tr >= 0.0) {
            double t2 = Math.sqrt(tr + 1.0);
            w2 = (float)(t2 * 0.5);
            t2 = 0.5 / t2;
            x2 = (float)((double)(dirnY - upnZ) * t2);
            y2 = (float)((double)(leftZ - dirnX) * t2);
            z2 = (float)((double)(upnX - leftY) * t2);
        } else if (leftX > upnY && leftX > dirnZ) {
            double t3 = Math.sqrt(1.0 + (double)leftX - (double)upnY - (double)dirnZ);
            x2 = (float)(t3 * 0.5);
            t3 = 0.5 / t3;
            y2 = (float)((double)(leftY + upnX) * t3);
            z2 = (float)((double)(dirnX + leftZ) * t3);
            w2 = (float)((double)(dirnY - upnZ) * t3);
        } else if (upnY > dirnZ) {
            double t4 = Math.sqrt(1.0 + (double)upnY - (double)leftX - (double)dirnZ);
            y2 = (float)(t4 * 0.5);
            t4 = 0.5 / t4;
            x2 = (float)((double)(leftY + upnX) * t4);
            z2 = (float)((double)(upnZ + dirnY) * t4);
            w2 = (float)((double)(leftZ - dirnX) * t4);
        } else {
            double t5 = Math.sqrt(1.0 + (double)dirnZ - (double)leftX - (double)upnY);
            z2 = (float)(t5 * 0.5);
            t5 = 0.5 / t5;
            x2 = (float)((double)(dirnX + leftZ) * t5);
            y2 = (float)((double)(upnZ + dirnY) * t5);
            w2 = (float)((double)(upnX - leftY) * t5);
        }
        return dest.set(Math.fma(this.w, x2, Math.fma(this.x, w2, Math.fma(this.y, z2, -this.z * y2))), Math.fma(this.w, y2, Math.fma(-this.x, z2, Math.fma(this.y, w2, this.z * x2))), Math.fma(this.w, z2, Math.fma(this.x, y2, Math.fma(-this.y, x2, this.z * w2))), Math.fma(this.w, w2, Math.fma(-this.x, x2, Math.fma(-this.y, y2, -this.z * z2))));
    }

    public Quaternionf rotationTo(float fromDirX, float fromDirY, float fromDirZ, float toDirX, float toDirY, float toDirZ) {
        float tz;
        float fz2;
        float ty;
        float fy2;
        float tn;
        float tx;
        float fn2 = Math.invsqrt(Math.fma(fromDirX, fromDirX, Math.fma(fromDirY, fromDirY, fromDirZ * fromDirZ)));
        float fx2 = fromDirX * fn2;
        float dot = fx2 * (tx = toDirX * (tn = Math.invsqrt(Math.fma(toDirX, toDirX, Math.fma(toDirY, toDirY, toDirZ * toDirZ))))) + (fy2 = fromDirY * fn2) * (ty = toDirY * tn) + (fz2 = fromDirZ * fn2) * (tz = toDirZ * tn);
        if (dot < -0.999999f) {
            float x2 = fy2;
            float y2 = -fx2;
            float z2 = 0.0f;
            float w2 = 0.0f;
            if (x2 * x2 + y2 * y2 == 0.0f) {
                x2 = 0.0f;
                y2 = fz2;
                z2 = -fy2;
                w2 = 0.0f;
            }
            this.x = x2;
            this.y = y2;
            this.z = z2;
            this.w = 0.0f;
        } else {
            float sd2 = Math.sqrt((1.0f + dot) * 2.0f);
            float isd2 = 1.0f / sd2;
            float cx2 = fy2 * tz - fz2 * ty;
            float cy2 = fz2 * tx - fx2 * tz;
            float cz2 = fx2 * ty - fy2 * tx;
            float x3 = cx2 * isd2;
            float y3 = cy2 * isd2;
            float z3 = cz2 * isd2;
            float w3 = sd2 * 0.5f;
            float n2 = Math.invsqrt(Math.fma(x3, x3, Math.fma(y3, y3, Math.fma(z3, z3, w3 * w3))));
            this.x = x3 * n2;
            this.y = y3 * n2;
            this.z = z3 * n2;
            this.w = w3 * n2;
        }
        return this;
    }

    public Quaternionf rotationTo(Vector3fc fromDir, Vector3fc toDir) {
        return this.rotationTo(fromDir.x(), fromDir.y(), fromDir.z(), toDir.x(), toDir.y(), toDir.z());
    }

    public Quaternionf rotateTo(float fromDirX, float fromDirY, float fromDirZ, float toDirX, float toDirY, float toDirZ, Quaternionf dest) {
        float w2;
        float z2;
        float y2;
        float x2;
        float tz;
        float fz2;
        float ty;
        float fy2;
        float tn;
        float tx;
        float fn2 = Math.invsqrt(Math.fma(fromDirX, fromDirX, Math.fma(fromDirY, fromDirY, fromDirZ * fromDirZ)));
        float fx2 = fromDirX * fn2;
        float dot = fx2 * (tx = toDirX * (tn = Math.invsqrt(Math.fma(toDirX, toDirX, Math.fma(toDirY, toDirY, toDirZ * toDirZ))))) + (fy2 = fromDirY * fn2) * (ty = toDirY * tn) + (fz2 = fromDirZ * fn2) * (tz = toDirZ * tn);
        if (dot < -0.999999f) {
            x2 = fy2;
            y2 = -fx2;
            z2 = 0.0f;
            w2 = 0.0f;
            if (x2 * x2 + y2 * y2 == 0.0f) {
                x2 = 0.0f;
                y2 = fz2;
                z2 = -fy2;
                w2 = 0.0f;
            }
        } else {
            float sd2 = Math.sqrt((1.0f + dot) * 2.0f);
            float isd2 = 1.0f / sd2;
            float cx2 = fy2 * tz - fz2 * ty;
            float cy2 = fz2 * tx - fx2 * tz;
            float cz2 = fx2 * ty - fy2 * tx;
            x2 = cx2 * isd2;
            y2 = cy2 * isd2;
            z2 = cz2 * isd2;
            w2 = sd2 * 0.5f;
            float n2 = Math.invsqrt(Math.fma(x2, x2, Math.fma(y2, y2, Math.fma(z2, z2, w2 * w2))));
            x2 *= n2;
            y2 *= n2;
            z2 *= n2;
            w2 *= n2;
        }
        return dest.set(Math.fma(this.w, x2, Math.fma(this.x, w2, Math.fma(this.y, z2, -this.z * y2))), Math.fma(this.w, y2, Math.fma(-this.x, z2, Math.fma(this.y, w2, this.z * x2))), Math.fma(this.w, z2, Math.fma(this.x, y2, Math.fma(-this.y, x2, this.z * w2))), Math.fma(this.w, w2, Math.fma(-this.x, x2, Math.fma(-this.y, y2, -this.z * z2))));
    }

    public Quaternionf rotateTo(float fromDirX, float fromDirY, float fromDirZ, float toDirX, float toDirY, float toDirZ) {
        return this.rotateTo(fromDirX, fromDirY, fromDirZ, toDirX, toDirY, toDirZ, this);
    }

    public Quaternionf rotateTo(Vector3fc fromDir, Vector3fc toDir, Quaternionf dest) {
        return this.rotateTo(fromDir.x(), fromDir.y(), fromDir.z(), toDir.x(), toDir.y(), toDir.z(), dest);
    }

    public Quaternionf rotateTo(Vector3fc fromDir, Vector3fc toDir) {
        return this.rotateTo(fromDir.x(), fromDir.y(), fromDir.z(), toDir.x(), toDir.y(), toDir.z(), this);
    }

    public Quaternionf rotateX(float angle) {
        return this.rotateX(angle, this);
    }

    public Quaternionf rotateX(float angle, Quaternionf dest) {
        float sin = Math.sin(angle * 0.5f);
        float cos = Math.cosFromSin(sin, angle * 0.5f);
        return dest.set(this.w * sin + this.x * cos, this.y * cos + this.z * sin, this.z * cos - this.y * sin, this.w * cos - this.x * sin);
    }

    public Quaternionf rotateY(float angle) {
        return this.rotateY(angle, this);
    }

    public Quaternionf rotateY(float angle, Quaternionf dest) {
        float sin = Math.sin(angle * 0.5f);
        float cos = Math.cosFromSin(sin, angle * 0.5f);
        return dest.set(this.x * cos - this.z * sin, this.w * sin + this.y * cos, this.x * sin + this.z * cos, this.w * cos - this.y * sin);
    }

    public Quaternionf rotateZ(float angle) {
        return this.rotateZ(angle, this);
    }

    public Quaternionf rotateZ(float angle, Quaternionf dest) {
        float sin = Math.sin(angle * 0.5f);
        float cos = Math.cosFromSin(sin, angle * 0.5f);
        return dest.set(this.x * cos + this.y * sin, this.y * cos - this.x * sin, this.w * sin + this.z * cos, this.w * cos - this.z * sin);
    }

    public Quaternionf rotateLocalX(float angle) {
        return this.rotateLocalX(angle, this);
    }

    public Quaternionf rotateLocalX(float angle, Quaternionf dest) {
        float hangle = angle * 0.5f;
        float s2 = Math.sin(hangle);
        float c2 = Math.cosFromSin(s2, hangle);
        dest.set(c2 * this.x + s2 * this.w, c2 * this.y - s2 * this.z, c2 * this.z + s2 * this.y, c2 * this.w - s2 * this.x);
        return dest;
    }

    public Quaternionf rotateLocalY(float angle) {
        return this.rotateLocalY(angle, this);
    }

    public Quaternionf rotateLocalY(float angle, Quaternionf dest) {
        float hangle = angle * 0.5f;
        float s2 = Math.sin(hangle);
        float c2 = Math.cosFromSin(s2, hangle);
        dest.set(c2 * this.x + s2 * this.z, c2 * this.y + s2 * this.w, c2 * this.z - s2 * this.x, c2 * this.w - s2 * this.y);
        return dest;
    }

    public Quaternionf rotateLocalZ(float angle) {
        return this.rotateLocalZ(angle, this);
    }

    public Quaternionf rotateLocalZ(float angle, Quaternionf dest) {
        float hangle = angle * 0.5f;
        float s2 = Math.sin(hangle);
        float c2 = Math.cosFromSin(s2, hangle);
        dest.set(c2 * this.x - s2 * this.y, c2 * this.y + s2 * this.x, c2 * this.z + s2 * this.w, c2 * this.w - s2 * this.z);
        return dest;
    }

    public Quaternionf rotateAxis(float angle, float axisX, float axisY, float axisZ, Quaternionf dest) {
        float hangle = angle / 2.0f;
        float sinAngle = Math.sin(hangle);
        float invVLength = Math.invsqrt(Math.fma(axisX, axisX, Math.fma(axisY, axisY, axisZ * axisZ)));
        float rx = axisX * invVLength * sinAngle;
        float ry = axisY * invVLength * sinAngle;
        float rz = axisZ * invVLength * sinAngle;
        float rw = Math.cosFromSin(sinAngle, hangle);
        return dest.set(Math.fma(this.w, rx, Math.fma(this.x, rw, Math.fma(this.y, rz, -this.z * ry))), Math.fma(this.w, ry, Math.fma(-this.x, rz, Math.fma(this.y, rw, this.z * rx))), Math.fma(this.w, rz, Math.fma(this.x, ry, Math.fma(-this.y, rx, this.z * rw))), Math.fma(this.w, rw, Math.fma(-this.x, rx, Math.fma(-this.y, ry, -this.z * rz))));
    }

    public Quaternionf rotateAxis(float angle, Vector3fc axis, Quaternionf dest) {
        return this.rotateAxis(angle, axis.x(), axis.y(), axis.z(), dest);
    }

    public Quaternionf rotateAxis(float angle, Vector3fc axis) {
        return this.rotateAxis(angle, axis.x(), axis.y(), axis.z(), this);
    }

    public Quaternionf rotateAxis(float angle, float axisX, float axisY, float axisZ) {
        return this.rotateAxis(angle, axisX, axisY, axisZ, this);
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
        this.x = in.readFloat();
        this.y = in.readFloat();
        this.z = in.readFloat();
        this.w = in.readFloat();
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
        Quaternionf other = (Quaternionf)obj;
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

    public Quaternionf difference(Quaternionf other) {
        return this.difference(other, this);
    }

    public Quaternionf difference(Quaternionfc other, Quaternionf dest) {
        float invNorm = 1.0f / this.lengthSquared();
        float x2 = -this.x * invNorm;
        float y2 = -this.y * invNorm;
        float z2 = -this.z * invNorm;
        float w2 = this.w * invNorm;
        dest.set(Math.fma(w2, other.x(), Math.fma(x2, other.w(), Math.fma(y2, other.z(), -z2 * other.y()))), Math.fma(w2, other.y(), Math.fma(-x2, other.z(), Math.fma(y2, other.w(), z2 * other.x()))), Math.fma(w2, other.z(), Math.fma(x2, other.y(), Math.fma(-y2, other.x(), z2 * other.w()))), Math.fma(w2, other.w(), Math.fma(-x2, other.x(), Math.fma(-y2, other.y(), -z2 * other.z()))));
        return dest;
    }

    public Vector3f positiveX(Vector3f dir) {
        float invNorm = 1.0f / this.lengthSquared();
        float nx = -this.x * invNorm;
        float ny = -this.y * invNorm;
        float nz = -this.z * invNorm;
        float nw = this.w * invNorm;
        float dy2 = ny + ny;
        float dz2 = nz + nz;
        dir.x = -ny * dy2 - nz * dz2 + 1.0f;
        dir.y = nx * dy2 + nw * dz2;
        dir.z = nx * dz2 - nw * dy2;
        return dir;
    }

    public Vector3f normalizedPositiveX(Vector3f dir) {
        float dy2 = this.y + this.y;
        float dz2 = this.z + this.z;
        dir.x = -this.y * dy2 - this.z * dz2 + 1.0f;
        dir.y = this.x * dy2 - this.w * dz2;
        dir.z = this.x * dz2 + this.w * dy2;
        return dir;
    }

    public Vector3f positiveY(Vector3f dir) {
        float invNorm = 1.0f / this.lengthSquared();
        float nx = -this.x * invNorm;
        float ny = -this.y * invNorm;
        float nz = -this.z * invNorm;
        float nw = this.w * invNorm;
        float dx2 = nx + nx;
        float dy2 = ny + ny;
        float dz2 = nz + nz;
        dir.x = nx * dy2 - nw * dz2;
        dir.y = -nx * dx2 - nz * dz2 + 1.0f;
        dir.z = ny * dz2 + nw * dx2;
        return dir;
    }

    public Vector3f normalizedPositiveY(Vector3f dir) {
        float dx2 = this.x + this.x;
        float dy2 = this.y + this.y;
        float dz2 = this.z + this.z;
        dir.x = this.x * dy2 + this.w * dz2;
        dir.y = -this.x * dx2 - this.z * dz2 + 1.0f;
        dir.z = this.y * dz2 - this.w * dx2;
        return dir;
    }

    public Vector3f positiveZ(Vector3f dir) {
        float invNorm = 1.0f / this.lengthSquared();
        float nx = -this.x * invNorm;
        float ny = -this.y * invNorm;
        float nz = -this.z * invNorm;
        float nw = this.w * invNorm;
        float dx2 = nx + nx;
        float dy2 = ny + ny;
        float dz2 = nz + nz;
        dir.x = nx * dz2 + nw * dy2;
        dir.y = ny * dz2 - nw * dx2;
        dir.z = -nx * dx2 - ny * dy2 + 1.0f;
        return dir;
    }

    public Vector3f normalizedPositiveZ(Vector3f dir) {
        float dx2 = this.x + this.x;
        float dy2 = this.y + this.y;
        float dz2 = this.z + this.z;
        dir.x = this.x * dz2 - this.w * dy2;
        dir.y = this.y * dz2 + this.w * dx2;
        dir.z = -this.x * dx2 - this.y * dy2 + 1.0f;
        return dir;
    }

    public Quaternionf conjugateBy(Quaternionfc q2) {
        return this.conjugateBy(q2, this);
    }

    public Quaternionf conjugateBy(Quaternionfc q2, Quaternionf dest) {
        float invNorm = 1.0f / q2.lengthSquared();
        float qix = -q2.x() * invNorm;
        float qiy = -q2.y() * invNorm;
        float qiz = -q2.z() * invNorm;
        float qiw = q2.w() * invNorm;
        float qpx = Math.fma(q2.w(), this.x, Math.fma(q2.x(), this.w, Math.fma(q2.y(), this.z, -q2.z() * this.y)));
        float qpy = Math.fma(q2.w(), this.y, Math.fma(-q2.x(), this.z, Math.fma(q2.y(), this.w, q2.z() * this.x)));
        float qpz = Math.fma(q2.w(), this.z, Math.fma(q2.x(), this.y, Math.fma(-q2.y(), this.x, q2.z() * this.w)));
        float qpw = Math.fma(q2.w(), this.w, Math.fma(-q2.x(), this.x, Math.fma(-q2.y(), this.y, -q2.z() * this.z)));
        return dest.set(Math.fma(qpw, qix, Math.fma(qpx, qiw, Math.fma(qpy, qiz, -qpz * qiy))), Math.fma(qpw, qiy, Math.fma(-qpx, qiz, Math.fma(qpy, qiw, qpz * qix))), Math.fma(qpw, qiz, Math.fma(qpx, qiy, Math.fma(-qpy, qix, qpz * qiw))), Math.fma(qpw, qiw, Math.fma(-qpx, qix, Math.fma(-qpy, qiy, -qpz * qiz))));
    }

    public boolean isFinite() {
        return Math.isFinite(this.x) && Math.isFinite(this.y) && Math.isFinite(this.z) && Math.isFinite(this.w);
    }

    public boolean equals(Quaternionfc q2, float delta) {
        if (this == q2) {
            return true;
        }
        if (q2 == null) {
            return false;
        }
        if (!(q2 instanceof Quaternionfc)) {
            return false;
        }
        if (!Runtime.equals(this.x, q2.x(), delta)) {
            return false;
        }
        if (!Runtime.equals(this.y, q2.y(), delta)) {
            return false;
        }
        if (!Runtime.equals(this.z, q2.z(), delta)) {
            return false;
        }
        return Runtime.equals(this.w, q2.w(), delta);
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

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

