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
import org.joml.Matrix3f;
import org.joml.Matrix3fc;
import org.joml.Matrix3x2fc;
import org.joml.Matrix4d;
import org.joml.Matrix4dc;
import org.joml.Matrix4fc;
import org.joml.Matrix4x3f;
import org.joml.Matrix4x3fc;
import org.joml.MemUtil;
import org.joml.Options;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Runtime;
import org.joml.Vector2fc;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector4f;
import org.joml.Vector4fc;

public class Matrix4f
implements Externalizable,
Cloneable,
Matrix4fc {
    private static final long serialVersionUID = 1L;
    float m00;
    float m01;
    float m02;
    float m03;
    float m10;
    float m11;
    float m12;
    float m13;
    float m20;
    float m21;
    float m22;
    float m23;
    float m30;
    float m31;
    float m32;
    float m33;
    int properties;

    public Matrix4f() {
        this._m00(1.0f)._m11(1.0f)._m22(1.0f)._m33(1.0f)._properties(30);
    }

    public Matrix4f(Matrix3fc mat) {
        this.set(mat);
    }

    public Matrix4f(Matrix4fc mat) {
        this.set(mat);
    }

    public Matrix4f(Matrix4x3fc mat) {
        this.set(mat);
    }

    public Matrix4f(Matrix4dc mat) {
        this.set(mat);
    }

    public Matrix4f(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, float m30, float m31, float m32, float m33) {
        this._m00(m00)._m01(m01)._m02(m02)._m03(m03)._m10(m10)._m11(m11)._m12(m12)._m13(m13)._m20(m20)._m21(m21)._m22(m22)._m23(m23)._m30(m30)._m31(m31)._m32(m32)._m33(m33).determineProperties();
    }

    public Matrix4f(FloatBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
        this.determineProperties();
    }

    public Matrix4f(Vector4fc col0, Vector4fc col1, Vector4fc col2, Vector4fc col3) {
        this.set(col0, col1, col2, col3);
    }

    Matrix4f _properties(int properties) {
        this.properties = properties;
        return this;
    }

    public Matrix4f assume(int properties) {
        this._properties(properties);
        return this;
    }

    public Matrix4f determineProperties() {
        int properties = 0;
        if (this.m03() == 0.0f && this.m13() == 0.0f) {
            if (this.m23() == 0.0f && this.m33() == 1.0f) {
                properties |= 2;
                if (this.m00() == 1.0f && this.m01() == 0.0f && this.m02() == 0.0f && this.m10() == 0.0f && this.m11() == 1.0f && this.m12() == 0.0f && this.m20() == 0.0f && this.m21() == 0.0f && this.m22() == 1.0f) {
                    properties |= 0x18;
                    if (this.m30() == 0.0f && this.m31() == 0.0f && this.m32() == 0.0f) {
                        properties |= 4;
                    }
                }
            } else if (this.m01() == 0.0f && this.m02() == 0.0f && this.m10() == 0.0f && this.m12() == 0.0f && this.m20() == 0.0f && this.m21() == 0.0f && this.m30() == 0.0f && this.m31() == 0.0f && this.m33() == 0.0f) {
                properties |= 1;
            }
        }
        this.properties = properties;
        return this;
    }

    public int properties() {
        return this.properties;
    }

    public float m00() {
        return this.m00;
    }

    public float m01() {
        return this.m01;
    }

    public float m02() {
        return this.m02;
    }

    public float m03() {
        return this.m03;
    }

    public float m10() {
        return this.m10;
    }

    public float m11() {
        return this.m11;
    }

    public float m12() {
        return this.m12;
    }

    public float m13() {
        return this.m13;
    }

    public float m20() {
        return this.m20;
    }

    public float m21() {
        return this.m21;
    }

    public float m22() {
        return this.m22;
    }

    public float m23() {
        return this.m23;
    }

    public float m30() {
        return this.m30;
    }

    public float m31() {
        return this.m31;
    }

    public float m32() {
        return this.m32;
    }

    public float m33() {
        return this.m33;
    }

    public Matrix4f m00(float m00) {
        this.m00 = m00;
        this.properties &= 0xFFFFFFEF;
        if (m00 != 1.0f) {
            this.properties &= 0xFFFFFFF3;
        }
        return this;
    }

    public Matrix4f m01(float m01) {
        this.m01 = m01;
        this.properties &= 0xFFFFFFEF;
        if (m01 != 0.0f) {
            this.properties &= 0xFFFFFFF2;
        }
        return this;
    }

    public Matrix4f m02(float m02) {
        this.m02 = m02;
        this.properties &= 0xFFFFFFEF;
        if (m02 != 0.0f) {
            this.properties &= 0xFFFFFFF2;
        }
        return this;
    }

    public Matrix4f m03(float m03) {
        this.m03 = m03;
        if (m03 != 0.0f) {
            this.properties = 0;
        }
        return this;
    }

    public Matrix4f m10(float m10) {
        this.m10 = m10;
        this.properties &= 0xFFFFFFEF;
        if (m10 != 0.0f) {
            this.properties &= 0xFFFFFFF2;
        }
        return this;
    }

    public Matrix4f m11(float m11) {
        this.m11 = m11;
        this.properties &= 0xFFFFFFEF;
        if (m11 != 1.0f) {
            this.properties &= 0xFFFFFFF3;
        }
        return this;
    }

    public Matrix4f m12(float m12) {
        this.m12 = m12;
        this.properties &= 0xFFFFFFEF;
        if (m12 != 0.0f) {
            this.properties &= 0xFFFFFFF2;
        }
        return this;
    }

    public Matrix4f m13(float m13) {
        this.m13 = m13;
        if (m13 != 0.0f) {
            this.properties = 0;
        }
        return this;
    }

    public Matrix4f m20(float m20) {
        this.m20 = m20;
        this.properties &= 0xFFFFFFEF;
        if (m20 != 0.0f) {
            this.properties &= 0xFFFFFFF2;
        }
        return this;
    }

    public Matrix4f m21(float m21) {
        this.m21 = m21;
        this.properties &= 0xFFFFFFEF;
        if (m21 != 0.0f) {
            this.properties &= 0xFFFFFFF2;
        }
        return this;
    }

    public Matrix4f m22(float m22) {
        this.m22 = m22;
        this.properties &= 0xFFFFFFEF;
        if (m22 != 1.0f) {
            this.properties &= 0xFFFFFFF3;
        }
        return this;
    }

    public Matrix4f m23(float m23) {
        this.m23 = m23;
        if (m23 != 0.0f) {
            this.properties &= 0xFFFFFFE1;
        }
        return this;
    }

    public Matrix4f m30(float m30) {
        this.m30 = m30;
        if (m30 != 0.0f) {
            this.properties &= 0xFFFFFFFA;
        }
        return this;
    }

    public Matrix4f m31(float m31) {
        this.m31 = m31;
        if (m31 != 0.0f) {
            this.properties &= 0xFFFFFFFA;
        }
        return this;
    }

    public Matrix4f m32(float m32) {
        this.m32 = m32;
        if (m32 != 0.0f) {
            this.properties &= 0xFFFFFFFA;
        }
        return this;
    }

    public Matrix4f m33(float m33) {
        this.m33 = m33;
        if (m33 != 0.0f) {
            this.properties &= 0xFFFFFFFE;
        }
        if (m33 != 1.0f) {
            this.properties &= 0xFFFFFFE1;
        }
        return this;
    }

    Matrix4f _m00(float m00) {
        this.m00 = m00;
        return this;
    }

    Matrix4f _m01(float m01) {
        this.m01 = m01;
        return this;
    }

    Matrix4f _m02(float m02) {
        this.m02 = m02;
        return this;
    }

    Matrix4f _m03(float m03) {
        this.m03 = m03;
        return this;
    }

    Matrix4f _m10(float m10) {
        this.m10 = m10;
        return this;
    }

    Matrix4f _m11(float m11) {
        this.m11 = m11;
        return this;
    }

    Matrix4f _m12(float m12) {
        this.m12 = m12;
        return this;
    }

    Matrix4f _m13(float m13) {
        this.m13 = m13;
        return this;
    }

    Matrix4f _m20(float m20) {
        this.m20 = m20;
        return this;
    }

    Matrix4f _m21(float m21) {
        this.m21 = m21;
        return this;
    }

    Matrix4f _m22(float m22) {
        this.m22 = m22;
        return this;
    }

    Matrix4f _m23(float m23) {
        this.m23 = m23;
        return this;
    }

    Matrix4f _m30(float m30) {
        this.m30 = m30;
        return this;
    }

    Matrix4f _m31(float m31) {
        this.m31 = m31;
        return this;
    }

    Matrix4f _m32(float m32) {
        this.m32 = m32;
        return this;
    }

    Matrix4f _m33(float m33) {
        this.m33 = m33;
        return this;
    }

    public Matrix4f identity() {
        if ((this.properties & 4) != 0) {
            return this;
        }
        return this._m00(1.0f)._m01(0.0f)._m02(0.0f)._m03(0.0f)._m10(0.0f)._m11(1.0f)._m12(0.0f)._m13(0.0f)._m20(0.0f)._m21(0.0f)._m22(1.0f)._m23(0.0f)._m30(0.0f)._m31(0.0f)._m32(0.0f)._m33(1.0f)._properties(30);
    }

    public Matrix4f set(Matrix4fc m2) {
        return this._m00(m2.m00())._m01(m2.m01())._m02(m2.m02())._m03(m2.m03())._m10(m2.m10())._m11(m2.m11())._m12(m2.m12())._m13(m2.m13())._m20(m2.m20())._m21(m2.m21())._m22(m2.m22())._m23(m2.m23())._m30(m2.m30())._m31(m2.m31())._m32(m2.m32())._m33(m2.m33())._properties(m2.properties());
    }

    public Matrix4f setTransposed(Matrix4fc m2) {
        if ((m2.properties() & 4) != 0) {
            return this.identity();
        }
        return this.setTransposedInternal(m2);
    }

    private Matrix4f setTransposedInternal(Matrix4fc m2) {
        float nm10 = m2.m01();
        float nm12 = m2.m21();
        float nm13 = m2.m31();
        float nm20 = m2.m02();
        float nm21 = m2.m12();
        float nm30 = m2.m03();
        float nm31 = m2.m13();
        float nm32 = m2.m23();
        return this._m00(m2.m00())._m01(m2.m10())._m02(m2.m20())._m03(m2.m30())._m10(nm10)._m11(m2.m11())._m12(nm12)._m13(nm13)._m20(nm20)._m21(nm21)._m22(m2.m22())._m23(m2.m32())._m30(nm30)._m31(nm31)._m32(nm32)._m33(m2.m33())._properties(m2.properties() & 4);
    }

    public Matrix4f set(Matrix4x3fc m2) {
        return this._m00(m2.m00())._m01(m2.m01())._m02(m2.m02())._m03(0.0f)._m10(m2.m10())._m11(m2.m11())._m12(m2.m12())._m13(0.0f)._m20(m2.m20())._m21(m2.m21())._m22(m2.m22())._m23(0.0f)._m30(m2.m30())._m31(m2.m31())._m32(m2.m32())._m33(1.0f)._properties(m2.properties() | 2);
    }

    public Matrix4f set(Matrix4dc m2) {
        return this._m00((float)m2.m00())._m01((float)m2.m01())._m02((float)m2.m02())._m03((float)m2.m03())._m10((float)m2.m10())._m11((float)m2.m11())._m12((float)m2.m12())._m13((float)m2.m13())._m20((float)m2.m20())._m21((float)m2.m21())._m22((float)m2.m22())._m23((float)m2.m23())._m30((float)m2.m30())._m31((float)m2.m31())._m32((float)m2.m32())._m33((float)m2.m33())._properties(m2.properties());
    }

    public Matrix4f set(Matrix3fc mat) {
        return this._m00(mat.m00())._m01(mat.m01())._m02(mat.m02())._m03(0.0f)._m10(mat.m10())._m11(mat.m11())._m12(mat.m12())._m13(0.0f)._m20(mat.m20())._m21(mat.m21())._m22(mat.m22())._m23(0.0f)._m30(0.0f)._m31(0.0f)._m32(0.0f)._m33(1.0f)._properties(2);
    }

    public Matrix4f set(AxisAngle4f axisAngle) {
        float x2 = axisAngle.x;
        float y2 = axisAngle.y;
        float z2 = axisAngle.z;
        float angle = axisAngle.angle;
        double n2 = Math.sqrt(x2 * x2 + y2 * y2 + z2 * z2);
        n2 = 1.0 / n2;
        x2 = (float)((double)x2 * n2);
        y2 = (float)((double)y2 * n2);
        z2 = (float)((double)z2 * n2);
        float s2 = Math.sin(angle);
        float c2 = Math.cosFromSin(s2, angle);
        float omc = 1.0f - c2;
        this._m00(c2 + x2 * x2 * omc)._m11(c2 + y2 * y2 * omc)._m22(c2 + z2 * z2 * omc);
        float tmp1 = x2 * y2 * omc;
        float tmp2 = z2 * s2;
        this._m10(tmp1 - tmp2)._m01(tmp1 + tmp2);
        tmp1 = x2 * z2 * omc;
        tmp2 = y2 * s2;
        this._m20(tmp1 + tmp2)._m02(tmp1 - tmp2);
        tmp1 = y2 * z2 * omc;
        tmp2 = x2 * s2;
        return this._m21(tmp1 - tmp2)._m12(tmp1 + tmp2)._m03(0.0f)._m13(0.0f)._m23(0.0f)._m30(0.0f)._m31(0.0f)._m32(0.0f)._m33(1.0f)._properties(18);
    }

    public Matrix4f set(AxisAngle4d axisAngle) {
        double x2 = axisAngle.x;
        double y2 = axisAngle.y;
        double z2 = axisAngle.z;
        double angle = axisAngle.angle;
        double n2 = Math.sqrt(x2 * x2 + y2 * y2 + z2 * z2);
        n2 = 1.0 / n2;
        double s2 = Math.sin(angle);
        double c2 = Math.cosFromSin(s2, angle);
        double omc = 1.0 - c2;
        this._m00((float)(c2 + (x2 *= n2) * x2 * omc))._m11((float)(c2 + (y2 *= n2) * y2 * omc))._m22((float)(c2 + (z2 *= n2) * z2 * omc));
        double tmp1 = x2 * y2 * omc;
        double tmp2 = z2 * s2;
        this._m10((float)(tmp1 - tmp2))._m01((float)(tmp1 + tmp2));
        tmp1 = x2 * z2 * omc;
        tmp2 = y2 * s2;
        this._m20((float)(tmp1 + tmp2))._m02((float)(tmp1 - tmp2));
        tmp1 = y2 * z2 * omc;
        tmp2 = x2 * s2;
        return this._m21((float)(tmp1 - tmp2))._m12((float)(tmp1 + tmp2))._m03(0.0f)._m13(0.0f)._m23(0.0f)._m30(0.0f)._m31(0.0f)._m32(0.0f)._m33(1.0f)._properties(18);
    }

    public Matrix4f set(Quaternionfc q2) {
        return this.rotation(q2);
    }

    public Matrix4f set(Quaterniondc q2) {
        double w2 = q2.w() * q2.w();
        double x2 = q2.x() * q2.x();
        double y2 = q2.y() * q2.y();
        double z2 = q2.z() * q2.z();
        double zw = q2.z() * q2.w();
        double xy = q2.x() * q2.y();
        double xz = q2.x() * q2.z();
        double yw = q2.y() * q2.w();
        double yz = q2.y() * q2.z();
        double xw = q2.x() * q2.w();
        return this._m00((float)(w2 + x2 - z2 - y2))._m01((float)(xy + zw + zw + xy))._m02((float)(xz - yw + xz - yw))._m03(0.0f)._m10((float)(-zw + xy - zw + xy))._m11((float)(y2 - z2 + w2 - x2))._m12((float)(yz + yz + xw + xw))._m13(0.0f)._m20((float)(yw + xz + xz + yw))._m21((float)(yz + yz - xw - xw))._m22((float)(z2 - y2 - x2 + w2))._m30(0.0f)._m31(0.0f)._m32(0.0f)._m33(1.0f)._properties(18);
    }

    public Matrix4f set3x3(Matrix4f mat) {
        MemUtil.INSTANCE.copy3x3(mat, this);
        return this._properties(this.properties & mat.properties & 0xFFFFFFFE);
    }

    public Matrix4f set4x3(Matrix4x3fc mat) {
        return this._m00(mat.m00())._m01(mat.m01())._m02(mat.m02())._m10(mat.m10())._m11(mat.m11())._m12(mat.m12())._m20(mat.m20())._m21(mat.m21())._m22(mat.m22())._m30(mat.m30())._m31(mat.m31())._m32(mat.m32())._properties(this.properties & mat.properties() & 0xFFFFFFFE);
    }

    public Matrix4f set4x3(Matrix4f mat) {
        MemUtil.INSTANCE.copy4x3(mat, this);
        return this._properties(this.properties & mat.properties & 0xFFFFFFFE);
    }

    public Matrix4f mul(Matrix4fc right) {
        return this.mul(right, this);
    }

    public Matrix4f mul(Matrix4fc right, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.set(right);
        }
        if ((right.properties() & 4) != 0) {
            return dest.set(this);
        }
        if ((this.properties & 8) != 0 && (right.properties() & 2) != 0) {
            return this.mulTranslationAffine(right, dest);
        }
        if ((this.properties & 2) != 0 && (right.properties() & 2) != 0) {
            return this.mulAffine(right, dest);
        }
        if ((this.properties & 1) != 0 && (right.properties() & 2) != 0) {
            return this.mulPerspectiveAffine(right, dest);
        }
        if ((right.properties() & 2) != 0) {
            return this.mulAffineR(right, dest);
        }
        return this.mul0(right, dest);
    }

    public Matrix4f mul0(Matrix4fc right) {
        return this.mul0(right, this);
    }

    public Matrix4f mul0(Matrix4fc right, Matrix4f dest) {
        float nm00 = Math.fma(this.m00(), right.m00(), Math.fma(this.m10(), right.m01(), Math.fma(this.m20(), right.m02(), this.m30() * right.m03())));
        float nm01 = Math.fma(this.m01(), right.m00(), Math.fma(this.m11(), right.m01(), Math.fma(this.m21(), right.m02(), this.m31() * right.m03())));
        float nm02 = Math.fma(this.m02(), right.m00(), Math.fma(this.m12(), right.m01(), Math.fma(this.m22(), right.m02(), this.m32() * right.m03())));
        float nm03 = Math.fma(this.m03(), right.m00(), Math.fma(this.m13(), right.m01(), Math.fma(this.m23(), right.m02(), this.m33() * right.m03())));
        float nm10 = Math.fma(this.m00(), right.m10(), Math.fma(this.m10(), right.m11(), Math.fma(this.m20(), right.m12(), this.m30() * right.m13())));
        float nm11 = Math.fma(this.m01(), right.m10(), Math.fma(this.m11(), right.m11(), Math.fma(this.m21(), right.m12(), this.m31() * right.m13())));
        float nm12 = Math.fma(this.m02(), right.m10(), Math.fma(this.m12(), right.m11(), Math.fma(this.m22(), right.m12(), this.m32() * right.m13())));
        float nm13 = Math.fma(this.m03(), right.m10(), Math.fma(this.m13(), right.m11(), Math.fma(this.m23(), right.m12(), this.m33() * right.m13())));
        float nm20 = Math.fma(this.m00(), right.m20(), Math.fma(this.m10(), right.m21(), Math.fma(this.m20(), right.m22(), this.m30() * right.m23())));
        float nm21 = Math.fma(this.m01(), right.m20(), Math.fma(this.m11(), right.m21(), Math.fma(this.m21(), right.m22(), this.m31() * right.m23())));
        float nm22 = Math.fma(this.m02(), right.m20(), Math.fma(this.m12(), right.m21(), Math.fma(this.m22(), right.m22(), this.m32() * right.m23())));
        float nm23 = Math.fma(this.m03(), right.m20(), Math.fma(this.m13(), right.m21(), Math.fma(this.m23(), right.m22(), this.m33() * right.m23())));
        float nm30 = Math.fma(this.m00(), right.m30(), Math.fma(this.m10(), right.m31(), Math.fma(this.m20(), right.m32(), this.m30() * right.m33())));
        float nm31 = Math.fma(this.m01(), right.m30(), Math.fma(this.m11(), right.m31(), Math.fma(this.m21(), right.m32(), this.m31() * right.m33())));
        float nm32 = Math.fma(this.m02(), right.m30(), Math.fma(this.m12(), right.m31(), Math.fma(this.m22(), right.m32(), this.m32() * right.m33())));
        float nm33 = Math.fma(this.m03(), right.m30(), Math.fma(this.m13(), right.m31(), Math.fma(this.m23(), right.m32(), this.m33() * right.m33())));
        return dest._m00(nm00)._m01(nm01)._m02(nm02)._m03(nm03)._m10(nm10)._m11(nm11)._m12(nm12)._m13(nm13)._m20(nm20)._m21(nm21)._m22(nm22)._m23(nm23)._m30(nm30)._m31(nm31)._m32(nm32)._m33(nm33)._properties(0);
    }

    public Matrix4f mul(float r00, float r01, float r02, float r03, float r10, float r11, float r12, float r13, float r20, float r21, float r22, float r23, float r30, float r31, float r32, float r33) {
        return this.mul(r00, r01, r02, r03, r10, r11, r12, r13, r20, r21, r22, r23, r30, r31, r32, r33, this);
    }

    public Matrix4f mul(float r00, float r01, float r02, float r03, float r10, float r11, float r12, float r13, float r20, float r21, float r22, float r23, float r30, float r31, float r32, float r33, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.set(r00, r01, r02, r03, r10, r11, r12, r13, r20, r21, r22, r23, r30, r31, r32, r33);
        }
        if ((this.properties & 2) != 0) {
            return this.mulAffineL(r00, r01, r02, r03, r10, r11, r12, r13, r20, r21, r22, r23, r30, r31, r32, r33, dest);
        }
        return this.mulGeneric(r00, r01, r02, r03, r10, r11, r12, r13, r20, r21, r22, r23, r30, r31, r32, r33, dest);
    }

    private Matrix4f mulAffineL(float r00, float r01, float r02, float r03, float r10, float r11, float r12, float r13, float r20, float r21, float r22, float r23, float r30, float r31, float r32, float r33, Matrix4f dest) {
        float nm00 = Math.fma(this.m00(), r00, Math.fma(this.m10(), r01, Math.fma(this.m20(), r02, this.m30() * r03)));
        float nm01 = Math.fma(this.m01(), r00, Math.fma(this.m11(), r01, Math.fma(this.m21(), r02, this.m31() * r03)));
        float nm02 = Math.fma(this.m02(), r00, Math.fma(this.m12(), r01, Math.fma(this.m22(), r02, this.m32() * r03)));
        float nm03 = r03;
        float nm10 = Math.fma(this.m00(), r10, Math.fma(this.m10(), r11, Math.fma(this.m20(), r12, this.m30() * r13)));
        float nm11 = Math.fma(this.m01(), r10, Math.fma(this.m11(), r11, Math.fma(this.m21(), r12, this.m31() * r13)));
        float nm12 = Math.fma(this.m02(), r10, Math.fma(this.m12(), r11, Math.fma(this.m22(), r12, this.m32() * r13)));
        float nm13 = r13;
        float nm20 = Math.fma(this.m00(), r20, Math.fma(this.m10(), r21, Math.fma(this.m20(), r22, this.m30() * r23)));
        float nm21 = Math.fma(this.m01(), r20, Math.fma(this.m11(), r21, Math.fma(this.m21(), r22, this.m31() * r23)));
        float nm22 = Math.fma(this.m02(), r20, Math.fma(this.m12(), r21, Math.fma(this.m22(), r22, this.m32() * r23)));
        float nm23 = r23;
        float nm30 = Math.fma(this.m00(), r30, Math.fma(this.m10(), r31, Math.fma(this.m20(), r32, this.m30() * r33)));
        float nm31 = Math.fma(this.m01(), r30, Math.fma(this.m11(), r31, Math.fma(this.m21(), r32, this.m31() * r33)));
        float nm32 = Math.fma(this.m02(), r30, Math.fma(this.m12(), r31, Math.fma(this.m22(), r32, this.m32() * r33)));
        float nm33 = r33;
        return dest._m00(nm00)._m01(nm01)._m02(nm02)._m03(nm03)._m10(nm10)._m11(nm11)._m12(nm12)._m13(nm13)._m20(nm20)._m21(nm21)._m22(nm22)._m23(nm23)._m30(nm30)._m31(nm31)._m32(nm32)._m33(nm33)._properties(2);
    }

    private Matrix4f mulGeneric(float r00, float r01, float r02, float r03, float r10, float r11, float r12, float r13, float r20, float r21, float r22, float r23, float r30, float r31, float r32, float r33, Matrix4f dest) {
        float nm00 = Math.fma(this.m00(), r00, Math.fma(this.m10(), r01, Math.fma(this.m20(), r02, this.m30() * r03)));
        float nm01 = Math.fma(this.m01(), r00, Math.fma(this.m11(), r01, Math.fma(this.m21(), r02, this.m31() * r03)));
        float nm02 = Math.fma(this.m02(), r00, Math.fma(this.m12(), r01, Math.fma(this.m22(), r02, this.m32() * r03)));
        float nm03 = Math.fma(this.m03(), r00, Math.fma(this.m13(), r01, Math.fma(this.m23(), r02, this.m33() * r03)));
        float nm10 = Math.fma(this.m00(), r10, Math.fma(this.m10(), r11, Math.fma(this.m20(), r12, this.m30() * r13)));
        float nm11 = Math.fma(this.m01(), r10, Math.fma(this.m11(), r11, Math.fma(this.m21(), r12, this.m31() * r13)));
        float nm12 = Math.fma(this.m02(), r10, Math.fma(this.m12(), r11, Math.fma(this.m22(), r12, this.m32() * r13)));
        float nm13 = Math.fma(this.m03(), r10, Math.fma(this.m13(), r11, Math.fma(this.m23(), r12, this.m33() * r13)));
        float nm20 = Math.fma(this.m00(), r20, Math.fma(this.m10(), r21, Math.fma(this.m20(), r22, this.m30() * r23)));
        float nm21 = Math.fma(this.m01(), r20, Math.fma(this.m11(), r21, Math.fma(this.m21(), r22, this.m31() * r23)));
        float nm22 = Math.fma(this.m02(), r20, Math.fma(this.m12(), r21, Math.fma(this.m22(), r22, this.m32() * r23)));
        float nm23 = Math.fma(this.m03(), r20, Math.fma(this.m13(), r21, Math.fma(this.m23(), r22, this.m33() * r23)));
        float nm30 = Math.fma(this.m00(), r30, Math.fma(this.m10(), r31, Math.fma(this.m20(), r32, this.m30() * r33)));
        float nm31 = Math.fma(this.m01(), r30, Math.fma(this.m11(), r31, Math.fma(this.m21(), r32, this.m31() * r33)));
        float nm32 = Math.fma(this.m02(), r30, Math.fma(this.m12(), r31, Math.fma(this.m22(), r32, this.m32() * r33)));
        float nm33 = Math.fma(this.m03(), r30, Math.fma(this.m13(), r31, Math.fma(this.m23(), r32, this.m33() * r33)));
        return dest._m00(nm00)._m01(nm01)._m02(nm02)._m03(nm03)._m10(nm10)._m11(nm11)._m12(nm12)._m13(nm13)._m20(nm20)._m21(nm21)._m22(nm22)._m23(nm23)._m30(nm30)._m31(nm31)._m32(nm32)._m33(nm33)._properties(0);
    }

    public Matrix4f mul3x3(float r00, float r01, float r02, float r10, float r11, float r12, float r20, float r21, float r22) {
        return this.mul3x3(r00, r01, r02, r10, r11, r12, r20, r21, r22, this);
    }

    public Matrix4f mul3x3(float r00, float r01, float r02, float r10, float r11, float r12, float r20, float r21, float r22, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.set(r00, r01, r02, 0.0f, r10, r11, r12, 0.0f, r20, r21, r22, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f);
        }
        return this.mulGeneric3x3(r00, r01, r02, r10, r11, r12, r20, r21, r22, dest);
    }

    private Matrix4f mulGeneric3x3(float r00, float r01, float r02, float r10, float r11, float r12, float r20, float r21, float r22, Matrix4f dest) {
        float nm00 = Math.fma(this.m00(), r00, Math.fma(this.m10(), r01, this.m20() * r02));
        float nm01 = Math.fma(this.m01(), r00, Math.fma(this.m11(), r01, this.m21() * r02));
        float nm02 = Math.fma(this.m02(), r00, Math.fma(this.m12(), r01, this.m22() * r02));
        float nm03 = Math.fma(this.m03(), r00, Math.fma(this.m13(), r01, this.m23() * r02));
        float nm10 = Math.fma(this.m00(), r10, Math.fma(this.m10(), r11, this.m20() * r12));
        float nm11 = Math.fma(this.m01(), r10, Math.fma(this.m11(), r11, this.m21() * r12));
        float nm12 = Math.fma(this.m02(), r10, Math.fma(this.m12(), r11, this.m22() * r12));
        float nm13 = Math.fma(this.m03(), r10, Math.fma(this.m13(), r11, this.m23() * r12));
        float nm20 = Math.fma(this.m00(), r20, Math.fma(this.m10(), r21, this.m20() * r22));
        float nm21 = Math.fma(this.m01(), r20, Math.fma(this.m11(), r21, this.m21() * r22));
        float nm22 = Math.fma(this.m02(), r20, Math.fma(this.m12(), r21, this.m22() * r22));
        float nm23 = Math.fma(this.m03(), r20, Math.fma(this.m13(), r21, this.m23() * r22));
        return dest._m00(nm00)._m01(nm01)._m02(nm02)._m03(nm03)._m10(nm10)._m11(nm11)._m12(nm12)._m13(nm13)._m20(nm20)._m21(nm21)._m22(nm22)._m23(nm23)._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 2);
    }

    public Matrix4f mulLocal(Matrix4fc left) {
        return this.mulLocal(left, this);
    }

    public Matrix4f mulLocal(Matrix4fc left, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.set(left);
        }
        if ((left.properties() & 4) != 0) {
            return dest.set(this);
        }
        if ((this.properties & 2) != 0 && (left.properties() & 2) != 0) {
            return this.mulLocalAffine(left, dest);
        }
        return this.mulLocalGeneric(left, dest);
    }

    private Matrix4f mulLocalGeneric(Matrix4fc left, Matrix4f dest) {
        float nm00 = Math.fma(left.m00(), this.m00(), Math.fma(left.m10(), this.m01(), Math.fma(left.m20(), this.m02(), left.m30() * this.m03())));
        float nm01 = Math.fma(left.m01(), this.m00(), Math.fma(left.m11(), this.m01(), Math.fma(left.m21(), this.m02(), left.m31() * this.m03())));
        float nm02 = Math.fma(left.m02(), this.m00(), Math.fma(left.m12(), this.m01(), Math.fma(left.m22(), this.m02(), left.m32() * this.m03())));
        float nm03 = Math.fma(left.m03(), this.m00(), Math.fma(left.m13(), this.m01(), Math.fma(left.m23(), this.m02(), left.m33() * this.m03())));
        float nm10 = Math.fma(left.m00(), this.m10(), Math.fma(left.m10(), this.m11(), Math.fma(left.m20(), this.m12(), left.m30() * this.m13())));
        float nm11 = Math.fma(left.m01(), this.m10(), Math.fma(left.m11(), this.m11(), Math.fma(left.m21(), this.m12(), left.m31() * this.m13())));
        float nm12 = Math.fma(left.m02(), this.m10(), Math.fma(left.m12(), this.m11(), Math.fma(left.m22(), this.m12(), left.m32() * this.m13())));
        float nm13 = Math.fma(left.m03(), this.m10(), Math.fma(left.m13(), this.m11(), Math.fma(left.m23(), this.m12(), left.m33() * this.m13())));
        float nm20 = Math.fma(left.m00(), this.m20(), Math.fma(left.m10(), this.m21(), Math.fma(left.m20(), this.m22(), left.m30() * this.m23())));
        float nm21 = Math.fma(left.m01(), this.m20(), Math.fma(left.m11(), this.m21(), Math.fma(left.m21(), this.m22(), left.m31() * this.m23())));
        float nm22 = Math.fma(left.m02(), this.m20(), Math.fma(left.m12(), this.m21(), Math.fma(left.m22(), this.m22(), left.m32() * this.m23())));
        float nm23 = Math.fma(left.m03(), this.m20(), Math.fma(left.m13(), this.m21(), Math.fma(left.m23(), this.m22(), left.m33() * this.m23())));
        float nm30 = Math.fma(left.m00(), this.m30(), Math.fma(left.m10(), this.m31(), Math.fma(left.m20(), this.m32(), left.m30() * this.m33())));
        float nm31 = Math.fma(left.m01(), this.m30(), Math.fma(left.m11(), this.m31(), Math.fma(left.m21(), this.m32(), left.m31() * this.m33())));
        float nm32 = Math.fma(left.m02(), this.m30(), Math.fma(left.m12(), this.m31(), Math.fma(left.m22(), this.m32(), left.m32() * this.m33())));
        float nm33 = Math.fma(left.m03(), this.m30(), Math.fma(left.m13(), this.m31(), Math.fma(left.m23(), this.m32(), left.m33() * this.m33())));
        return dest._m00(nm00)._m01(nm01)._m02(nm02)._m03(nm03)._m10(nm10)._m11(nm11)._m12(nm12)._m13(nm13)._m20(nm20)._m21(nm21)._m22(nm22)._m23(nm23)._m30(nm30)._m31(nm31)._m32(nm32)._m33(nm33)._properties(0);
    }

    public Matrix4f mulLocalAffine(Matrix4fc left) {
        return this.mulLocalAffine(left, this);
    }

    public Matrix4f mulLocalAffine(Matrix4fc left, Matrix4f dest) {
        float nm00 = left.m00() * this.m00() + left.m10() * this.m01() + left.m20() * this.m02();
        float nm01 = left.m01() * this.m00() + left.m11() * this.m01() + left.m21() * this.m02();
        float nm02 = left.m02() * this.m00() + left.m12() * this.m01() + left.m22() * this.m02();
        float nm03 = left.m03();
        float nm10 = left.m00() * this.m10() + left.m10() * this.m11() + left.m20() * this.m12();
        float nm11 = left.m01() * this.m10() + left.m11() * this.m11() + left.m21() * this.m12();
        float nm12 = left.m02() * this.m10() + left.m12() * this.m11() + left.m22() * this.m12();
        float nm13 = left.m13();
        float nm20 = left.m00() * this.m20() + left.m10() * this.m21() + left.m20() * this.m22();
        float nm21 = left.m01() * this.m20() + left.m11() * this.m21() + left.m21() * this.m22();
        float nm22 = left.m02() * this.m20() + left.m12() * this.m21() + left.m22() * this.m22();
        float nm23 = left.m23();
        float nm30 = left.m00() * this.m30() + left.m10() * this.m31() + left.m20() * this.m32() + left.m30();
        float nm31 = left.m01() * this.m30() + left.m11() * this.m31() + left.m21() * this.m32() + left.m31();
        float nm32 = left.m02() * this.m30() + left.m12() * this.m31() + left.m22() * this.m32() + left.m32();
        float nm33 = left.m33();
        return dest._m00(nm00)._m01(nm01)._m02(nm02)._m03(nm03)._m10(nm10)._m11(nm11)._m12(nm12)._m13(nm13)._m20(nm20)._m21(nm21)._m22(nm22)._m23(nm23)._m30(nm30)._m31(nm31)._m32(nm32)._m33(nm33)._properties(2 | this.properties() & left.properties() & 0x10);
    }

    public Matrix4f mul(Matrix4x3fc right) {
        return this.mul(right, this);
    }

    public Matrix4f mul(Matrix4x3fc right, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.set(right);
        }
        if ((right.properties() & 4) != 0) {
            return dest.set(this);
        }
        if ((this.properties & 8) != 0) {
            return this.mulTranslation(right, dest);
        }
        if ((this.properties & 2) != 0) {
            return this.mulAffine(right, dest);
        }
        if ((this.properties & 1) != 0) {
            return this.mulPerspectiveAffine(right, dest);
        }
        return this.mulGeneric(right, dest);
    }

    private Matrix4f mulTranslation(Matrix4x3fc right, Matrix4f dest) {
        return dest._m00(right.m00())._m01(right.m01())._m02(right.m02())._m03(this.m03())._m10(right.m10())._m11(right.m11())._m12(right.m12())._m13(this.m13())._m20(right.m20())._m21(right.m21())._m22(right.m22())._m23(this.m23())._m30(right.m30() + this.m30())._m31(right.m31() + this.m31())._m32(right.m32() + this.m32())._m33(this.m33())._properties(2 | right.properties() & 0x10);
    }

    private Matrix4f mulAffine(Matrix4x3fc right, Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        float m10 = this.m10();
        float m11 = this.m11();
        float m12 = this.m12();
        float m20 = this.m20();
        float m21 = this.m21();
        float m22 = this.m22();
        float rm00 = right.m00();
        float rm01 = right.m01();
        float rm02 = right.m02();
        float rm10 = right.m10();
        float rm11 = right.m11();
        float rm12 = right.m12();
        float rm20 = right.m20();
        float rm21 = right.m21();
        float rm22 = right.m22();
        float rm30 = right.m30();
        float rm31 = right.m31();
        float rm32 = right.m32();
        return dest._m00(Math.fma(m00, rm00, Math.fma(m10, rm01, m20 * rm02)))._m01(Math.fma(m01, rm00, Math.fma(m11, rm01, m21 * rm02)))._m02(Math.fma(m02, rm00, Math.fma(m12, rm01, m22 * rm02)))._m03(this.m03())._m10(Math.fma(m00, rm10, Math.fma(m10, rm11, m20 * rm12)))._m11(Math.fma(m01, rm10, Math.fma(m11, rm11, m21 * rm12)))._m12(Math.fma(m02, rm10, Math.fma(m12, rm11, m22 * rm12)))._m13(this.m13())._m20(Math.fma(m00, rm20, Math.fma(m10, rm21, m20 * rm22)))._m21(Math.fma(m01, rm20, Math.fma(m11, rm21, m21 * rm22)))._m22(Math.fma(m02, rm20, Math.fma(m12, rm21, m22 * rm22)))._m23(this.m23())._m30(Math.fma(m00, rm30, Math.fma(m10, rm31, Math.fma(m20, rm32, this.m30()))))._m31(Math.fma(m01, rm30, Math.fma(m11, rm31, Math.fma(m21, rm32, this.m31()))))._m32(Math.fma(m02, rm30, Math.fma(m12, rm31, Math.fma(m22, rm32, this.m32()))))._m33(this.m33())._properties(2 | this.properties & right.properties() & 0x10);
    }

    private Matrix4f mulGeneric(Matrix4x3fc right, Matrix4f dest) {
        float nm00 = Math.fma(this.m00(), right.m00(), Math.fma(this.m10(), right.m01(), this.m20() * right.m02()));
        float nm01 = Math.fma(this.m01(), right.m00(), Math.fma(this.m11(), right.m01(), this.m21() * right.m02()));
        float nm02 = Math.fma(this.m02(), right.m00(), Math.fma(this.m12(), right.m01(), this.m22() * right.m02()));
        float nm03 = Math.fma(this.m03(), right.m00(), Math.fma(this.m13(), right.m01(), this.m23() * right.m02()));
        float nm10 = Math.fma(this.m00(), right.m10(), Math.fma(this.m10(), right.m11(), this.m20() * right.m12()));
        float nm11 = Math.fma(this.m01(), right.m10(), Math.fma(this.m11(), right.m11(), this.m21() * right.m12()));
        float nm12 = Math.fma(this.m02(), right.m10(), Math.fma(this.m12(), right.m11(), this.m22() * right.m12()));
        float nm13 = Math.fma(this.m03(), right.m10(), Math.fma(this.m13(), right.m11(), this.m23() * right.m12()));
        float nm20 = Math.fma(this.m00(), right.m20(), Math.fma(this.m10(), right.m21(), this.m20() * right.m22()));
        float nm21 = Math.fma(this.m01(), right.m20(), Math.fma(this.m11(), right.m21(), this.m21() * right.m22()));
        float nm22 = Math.fma(this.m02(), right.m20(), Math.fma(this.m12(), right.m21(), this.m22() * right.m22()));
        float nm23 = Math.fma(this.m03(), right.m20(), Math.fma(this.m13(), right.m21(), this.m23() * right.m22()));
        float nm30 = Math.fma(this.m00(), right.m30(), Math.fma(this.m10(), right.m31(), Math.fma(this.m20(), right.m32(), this.m30())));
        float nm31 = Math.fma(this.m01(), right.m30(), Math.fma(this.m11(), right.m31(), Math.fma(this.m21(), right.m32(), this.m31())));
        float nm32 = Math.fma(this.m02(), right.m30(), Math.fma(this.m12(), right.m31(), Math.fma(this.m22(), right.m32(), this.m32())));
        float nm33 = Math.fma(this.m03(), right.m30(), Math.fma(this.m13(), right.m31(), Math.fma(this.m23(), right.m32(), this.m33())));
        return dest._m00(nm00)._m01(nm01)._m02(nm02)._m03(nm03)._m10(nm10)._m11(nm11)._m12(nm12)._m13(nm13)._m20(nm20)._m21(nm21)._m22(nm22)._m23(nm23)._m30(nm30)._m31(nm31)._m32(nm32)._m33(nm33)._properties(this.properties & 0xFFFFFFE2);
    }

    public Matrix4f mul(Matrix3x2fc right) {
        return this.mul(right, this);
    }

    public Matrix4f mul(Matrix3x2fc right, Matrix4f dest) {
        float nm00 = this.m00() * right.m00() + this.m10() * right.m01();
        float nm01 = this.m01() * right.m00() + this.m11() * right.m01();
        float nm02 = this.m02() * right.m00() + this.m12() * right.m01();
        float nm03 = this.m03() * right.m00() + this.m13() * right.m01();
        float nm10 = this.m00() * right.m10() + this.m10() * right.m11();
        float nm11 = this.m01() * right.m10() + this.m11() * right.m11();
        float nm12 = this.m02() * right.m10() + this.m12() * right.m11();
        float nm13 = this.m03() * right.m10() + this.m13() * right.m11();
        float nm30 = this.m00() * right.m20() + this.m10() * right.m21() + this.m30();
        float nm31 = this.m01() * right.m20() + this.m11() * right.m21() + this.m31();
        float nm32 = this.m02() * right.m20() + this.m12() * right.m21() + this.m32();
        float nm33 = this.m03() * right.m20() + this.m13() * right.m21() + this.m33();
        return dest._m00(nm00)._m01(nm01)._m02(nm02)._m03(nm03)._m10(nm10)._m11(nm11)._m12(nm12)._m13(nm13)._m20(this.m20())._m21(this.m21())._m22(this.m22())._m23(this.m23())._m30(nm30)._m31(nm31)._m32(nm32)._m33(nm33)._properties(this.properties & 0xFFFFFFE2);
    }

    public Matrix4f mulPerspectiveAffine(Matrix4fc view) {
        return this.mulPerspectiveAffine(view, this);
    }

    public Matrix4f mulPerspectiveAffine(Matrix4fc view, Matrix4f dest) {
        float nm00 = this.m00() * view.m00();
        float nm01 = this.m11() * view.m01();
        float nm02 = this.m22() * view.m02();
        float nm03 = this.m23() * view.m02();
        float nm10 = this.m00() * view.m10();
        float nm11 = this.m11() * view.m11();
        float nm12 = this.m22() * view.m12();
        float nm13 = this.m23() * view.m12();
        float nm20 = this.m00() * view.m20();
        float nm21 = this.m11() * view.m21();
        float nm22 = this.m22() * view.m22();
        float nm23 = this.m23() * view.m22();
        float nm30 = this.m00() * view.m30();
        float nm31 = this.m11() * view.m31();
        float nm32 = this.m22() * view.m32() + this.m32();
        float nm33 = this.m23() * view.m32();
        return dest._m00(nm00)._m01(nm01)._m02(nm02)._m03(nm03)._m10(nm10)._m11(nm11)._m12(nm12)._m13(nm13)._m20(nm20)._m21(nm21)._m22(nm22)._m23(nm23)._m30(nm30)._m31(nm31)._m32(nm32)._m33(nm33)._properties(0);
    }

    public Matrix4f mulPerspectiveAffine(Matrix4x3fc view) {
        return this.mulPerspectiveAffine(view, this);
    }

    public Matrix4f mulPerspectiveAffine(Matrix4x3fc view, Matrix4f dest) {
        float lm00 = this.m00();
        float lm11 = this.m11();
        float lm22 = this.m22();
        float lm23 = this.m23();
        return dest._m00(lm00 * view.m00())._m01(lm11 * view.m01())._m02(lm22 * view.m02())._m03(lm23 * view.m02())._m10(lm00 * view.m10())._m11(lm11 * view.m11())._m12(lm22 * view.m12())._m13(lm23 * view.m12())._m20(lm00 * view.m20())._m21(lm11 * view.m21())._m22(lm22 * view.m22())._m23(lm23 * view.m22())._m30(lm00 * view.m30())._m31(lm11 * view.m31())._m32(lm22 * view.m32() + this.m32())._m33(lm23 * view.m32())._properties(0);
    }

    public Matrix4f mulAffineR(Matrix4fc right) {
        return this.mulAffineR(right, this);
    }

    public Matrix4f mulAffineR(Matrix4fc right, Matrix4f dest) {
        float nm00 = Math.fma(this.m00(), right.m00(), Math.fma(this.m10(), right.m01(), this.m20() * right.m02()));
        float nm01 = Math.fma(this.m01(), right.m00(), Math.fma(this.m11(), right.m01(), this.m21() * right.m02()));
        float nm02 = Math.fma(this.m02(), right.m00(), Math.fma(this.m12(), right.m01(), this.m22() * right.m02()));
        float nm03 = Math.fma(this.m03(), right.m00(), Math.fma(this.m13(), right.m01(), this.m23() * right.m02()));
        float nm10 = Math.fma(this.m00(), right.m10(), Math.fma(this.m10(), right.m11(), this.m20() * right.m12()));
        float nm11 = Math.fma(this.m01(), right.m10(), Math.fma(this.m11(), right.m11(), this.m21() * right.m12()));
        float nm12 = Math.fma(this.m02(), right.m10(), Math.fma(this.m12(), right.m11(), this.m22() * right.m12()));
        float nm13 = Math.fma(this.m03(), right.m10(), Math.fma(this.m13(), right.m11(), this.m23() * right.m12()));
        float nm20 = Math.fma(this.m00(), right.m20(), Math.fma(this.m10(), right.m21(), this.m20() * right.m22()));
        float nm21 = Math.fma(this.m01(), right.m20(), Math.fma(this.m11(), right.m21(), this.m21() * right.m22()));
        float nm22 = Math.fma(this.m02(), right.m20(), Math.fma(this.m12(), right.m21(), this.m22() * right.m22()));
        float nm23 = Math.fma(this.m03(), right.m20(), Math.fma(this.m13(), right.m21(), this.m23() * right.m22()));
        float nm30 = Math.fma(this.m00(), right.m30(), Math.fma(this.m10(), right.m31(), Math.fma(this.m20(), right.m32(), this.m30())));
        float nm31 = Math.fma(this.m01(), right.m30(), Math.fma(this.m11(), right.m31(), Math.fma(this.m21(), right.m32(), this.m31())));
        float nm32 = Math.fma(this.m02(), right.m30(), Math.fma(this.m12(), right.m31(), Math.fma(this.m22(), right.m32(), this.m32())));
        float nm33 = Math.fma(this.m03(), right.m30(), Math.fma(this.m13(), right.m31(), Math.fma(this.m23(), right.m32(), this.m33())));
        return dest._m00(nm00)._m01(nm01)._m02(nm02)._m03(nm03)._m10(nm10)._m11(nm11)._m12(nm12)._m13(nm13)._m20(nm20)._m21(nm21)._m22(nm22)._m23(nm23)._m30(nm30)._m31(nm31)._m32(nm32)._m33(nm33)._properties(this.properties & 0xFFFFFFE2);
    }

    public Matrix4f mulAffine(Matrix4fc right) {
        return this.mulAffine(right, this);
    }

    public Matrix4f mulAffine(Matrix4fc right, Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        float m10 = this.m10();
        float m11 = this.m11();
        float m12 = this.m12();
        float m20 = this.m20();
        float m21 = this.m21();
        float m22 = this.m22();
        float rm00 = right.m00();
        float rm01 = right.m01();
        float rm02 = right.m02();
        float rm10 = right.m10();
        float rm11 = right.m11();
        float rm12 = right.m12();
        float rm20 = right.m20();
        float rm21 = right.m21();
        float rm22 = right.m22();
        float rm30 = right.m30();
        float rm31 = right.m31();
        float rm32 = right.m32();
        return dest._m00(Math.fma(m00, rm00, Math.fma(m10, rm01, m20 * rm02)))._m01(Math.fma(m01, rm00, Math.fma(m11, rm01, m21 * rm02)))._m02(Math.fma(m02, rm00, Math.fma(m12, rm01, m22 * rm02)))._m03(this.m03())._m10(Math.fma(m00, rm10, Math.fma(m10, rm11, m20 * rm12)))._m11(Math.fma(m01, rm10, Math.fma(m11, rm11, m21 * rm12)))._m12(Math.fma(m02, rm10, Math.fma(m12, rm11, m22 * rm12)))._m13(this.m13())._m20(Math.fma(m00, rm20, Math.fma(m10, rm21, m20 * rm22)))._m21(Math.fma(m01, rm20, Math.fma(m11, rm21, m21 * rm22)))._m22(Math.fma(m02, rm20, Math.fma(m12, rm21, m22 * rm22)))._m23(this.m23())._m30(Math.fma(m00, rm30, Math.fma(m10, rm31, Math.fma(m20, rm32, this.m30()))))._m31(Math.fma(m01, rm30, Math.fma(m11, rm31, Math.fma(m21, rm32, this.m31()))))._m32(Math.fma(m02, rm30, Math.fma(m12, rm31, Math.fma(m22, rm32, this.m32()))))._m33(this.m33())._properties(2 | this.properties & right.properties() & 0x10);
    }

    public Matrix4f mulTranslationAffine(Matrix4fc right, Matrix4f dest) {
        return dest._m00(right.m00())._m01(right.m01())._m02(right.m02())._m03(this.m03())._m10(right.m10())._m11(right.m11())._m12(right.m12())._m13(this.m13())._m20(right.m20())._m21(right.m21())._m22(right.m22())._m23(this.m23())._m30(right.m30() + this.m30())._m31(right.m31() + this.m31())._m32(right.m32() + this.m32())._m33(this.m33())._properties(2 | right.properties() & 0x10);
    }

    public Matrix4f mulOrthoAffine(Matrix4fc view) {
        return this.mulOrthoAffine(view, this);
    }

    public Matrix4f mulOrthoAffine(Matrix4fc view, Matrix4f dest) {
        float nm00 = this.m00() * view.m00();
        float nm01 = this.m11() * view.m01();
        float nm02 = this.m22() * view.m02();
        float nm10 = this.m00() * view.m10();
        float nm11 = this.m11() * view.m11();
        float nm12 = this.m22() * view.m12();
        float nm20 = this.m00() * view.m20();
        float nm21 = this.m11() * view.m21();
        float nm22 = this.m22() * view.m22();
        float nm30 = this.m00() * view.m30() + this.m30();
        float nm31 = this.m11() * view.m31() + this.m31();
        float nm32 = this.m22() * view.m32() + this.m32();
        return dest._m00(nm00)._m01(nm01)._m02(nm02)._m03(0.0f)._m10(nm10)._m11(nm11)._m12(nm12)._m13(0.0f)._m20(nm20)._m21(nm21)._m22(nm22)._m23(0.0f)._m30(nm30)._m31(nm31)._m32(nm32)._m33(1.0f)._properties(2);
    }

    public Matrix4f fma4x3(Matrix4fc other, float otherFactor) {
        return this.fma4x3(other, otherFactor, this);
    }

    public Matrix4f fma4x3(Matrix4fc other, float otherFactor, Matrix4f dest) {
        dest._m00(Math.fma(other.m00(), otherFactor, this.m00()))._m01(Math.fma(other.m01(), otherFactor, this.m01()))._m02(Math.fma(other.m02(), otherFactor, this.m02()))._m03(this.m03())._m10(Math.fma(other.m10(), otherFactor, this.m10()))._m11(Math.fma(other.m11(), otherFactor, this.m11()))._m12(Math.fma(other.m12(), otherFactor, this.m12()))._m13(this.m13())._m20(Math.fma(other.m20(), otherFactor, this.m20()))._m21(Math.fma(other.m21(), otherFactor, this.m21()))._m22(Math.fma(other.m22(), otherFactor, this.m22()))._m23(this.m23())._m30(Math.fma(other.m30(), otherFactor, this.m30()))._m31(Math.fma(other.m31(), otherFactor, this.m31()))._m32(Math.fma(other.m32(), otherFactor, this.m32()))._m33(this.m33())._properties(0);
        return dest;
    }

    public Matrix4f add(Matrix4fc other) {
        return this.add(other, this);
    }

    public Matrix4f add(Matrix4fc other, Matrix4f dest) {
        dest._m00(this.m00() + other.m00())._m01(this.m01() + other.m01())._m02(this.m02() + other.m02())._m03(this.m03() + other.m03())._m10(this.m10() + other.m10())._m11(this.m11() + other.m11())._m12(this.m12() + other.m12())._m13(this.m13() + other.m13())._m20(this.m20() + other.m20())._m21(this.m21() + other.m21())._m22(this.m22() + other.m22())._m23(this.m23() + other.m23())._m30(this.m30() + other.m30())._m31(this.m31() + other.m31())._m32(this.m32() + other.m32())._m33(this.m33() + other.m33())._properties(0);
        return dest;
    }

    public Matrix4f sub(Matrix4fc subtrahend) {
        return this.sub(subtrahend, this);
    }

    public Matrix4f sub(Matrix4fc subtrahend, Matrix4f dest) {
        dest._m00(this.m00() - subtrahend.m00())._m01(this.m01() - subtrahend.m01())._m02(this.m02() - subtrahend.m02())._m03(this.m03() - subtrahend.m03())._m10(this.m10() - subtrahend.m10())._m11(this.m11() - subtrahend.m11())._m12(this.m12() - subtrahend.m12())._m13(this.m13() - subtrahend.m13())._m20(this.m20() - subtrahend.m20())._m21(this.m21() - subtrahend.m21())._m22(this.m22() - subtrahend.m22())._m23(this.m23() - subtrahend.m23())._m30(this.m30() - subtrahend.m30())._m31(this.m31() - subtrahend.m31())._m32(this.m32() - subtrahend.m32())._m33(this.m33() - subtrahend.m33())._properties(0);
        return dest;
    }

    public Matrix4f mulComponentWise(Matrix4fc other) {
        return this.mulComponentWise(other, this);
    }

    public Matrix4f mulComponentWise(Matrix4fc other, Matrix4f dest) {
        dest._m00(this.m00() * other.m00())._m01(this.m01() * other.m01())._m02(this.m02() * other.m02())._m03(this.m03() * other.m03())._m10(this.m10() * other.m10())._m11(this.m11() * other.m11())._m12(this.m12() * other.m12())._m13(this.m13() * other.m13())._m20(this.m20() * other.m20())._m21(this.m21() * other.m21())._m22(this.m22() * other.m22())._m23(this.m23() * other.m23())._m30(this.m30() * other.m30())._m31(this.m31() * other.m31())._m32(this.m32() * other.m32())._m33(this.m33() * other.m33())._properties(0);
        return dest;
    }

    public Matrix4f add4x3(Matrix4fc other) {
        return this.add4x3(other, this);
    }

    public Matrix4f add4x3(Matrix4fc other, Matrix4f dest) {
        dest._m00(this.m00() + other.m00())._m01(this.m01() + other.m01())._m02(this.m02() + other.m02())._m03(this.m03())._m10(this.m10() + other.m10())._m11(this.m11() + other.m11())._m12(this.m12() + other.m12())._m13(this.m13())._m20(this.m20() + other.m20())._m21(this.m21() + other.m21())._m22(this.m22() + other.m22())._m23(this.m23())._m30(this.m30() + other.m30())._m31(this.m31() + other.m31())._m32(this.m32() + other.m32())._m33(this.m33())._properties(0);
        return dest;
    }

    public Matrix4f sub4x3(Matrix4f subtrahend) {
        return this.sub4x3(subtrahend, this);
    }

    public Matrix4f sub4x3(Matrix4fc subtrahend, Matrix4f dest) {
        dest._m00(this.m00() - subtrahend.m00())._m01(this.m01() - subtrahend.m01())._m02(this.m02() - subtrahend.m02())._m03(this.m03())._m10(this.m10() - subtrahend.m10())._m11(this.m11() - subtrahend.m11())._m12(this.m12() - subtrahend.m12())._m13(this.m13())._m20(this.m20() - subtrahend.m20())._m21(this.m21() - subtrahend.m21())._m22(this.m22() - subtrahend.m22())._m23(this.m23())._m30(this.m30() - subtrahend.m30())._m31(this.m31() - subtrahend.m31())._m32(this.m32() - subtrahend.m32())._m33(this.m33())._properties(0);
        return dest;
    }

    public Matrix4f mul4x3ComponentWise(Matrix4fc other) {
        return this.mul4x3ComponentWise(other, this);
    }

    public Matrix4f mul4x3ComponentWise(Matrix4fc other, Matrix4f dest) {
        dest._m00(this.m00() * other.m00())._m01(this.m01() * other.m01())._m02(this.m02() * other.m02())._m03(this.m03())._m10(this.m10() * other.m10())._m11(this.m11() * other.m11())._m12(this.m12() * other.m12())._m13(this.m13())._m20(this.m20() * other.m20())._m21(this.m21() * other.m21())._m22(this.m22() * other.m22())._m23(this.m23())._m30(this.m30() * other.m30())._m31(this.m31() * other.m31())._m32(this.m32() * other.m32())._m33(this.m33())._properties(0);
        return dest;
    }

    public Matrix4f set(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, float m30, float m31, float m32, float m33) {
        return this._m00(m00)._m10(m10)._m20(m20)._m30(m30)._m01(m01)._m11(m11)._m21(m21)._m31(m31)._m02(m02)._m12(m12)._m22(m22)._m32(m32)._m03(m03)._m13(m13)._m23(m23)._m33(m33).determineProperties();
    }

    public Matrix4f set(float[] m2, int off) {
        MemUtil.INSTANCE.copy(m2, off, this);
        return this.determineProperties();
    }

    public Matrix4f set(float[] m2) {
        return this.set(m2, 0);
    }

    public Matrix4f setTransposed(float[] m2, int off) {
        MemUtil.INSTANCE.copyTransposed(m2, off, this);
        return this.determineProperties();
    }

    public Matrix4f setTransposed(float[] m2) {
        return this.setTransposed(m2, 0);
    }

    public Matrix4f set(FloatBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
        return this.determineProperties();
    }

    public Matrix4f set(ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
        return this.determineProperties();
    }

    public Matrix4f set(int index, FloatBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
        return this.determineProperties();
    }

    public Matrix4f set(int index, ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
        return this.determineProperties();
    }

    public Matrix4f setTransposed(FloatBuffer buffer) {
        MemUtil.INSTANCE.getTransposed(this, buffer.position(), buffer);
        return this.determineProperties();
    }

    public Matrix4f setTransposed(ByteBuffer buffer) {
        MemUtil.INSTANCE.getTransposed(this, buffer.position(), buffer);
        return this.determineProperties();
    }

    public Matrix4f setFromAddress(long address) {
        if (Options.NO_UNSAFE) {
            throw new UnsupportedOperationException("Not supported when using joml.nounsafe");
        }
        MemUtil.MemUtilUnsafe.get(this, address);
        return this.determineProperties();
    }

    public Matrix4f setTransposedFromAddress(long address) {
        if (Options.NO_UNSAFE) {
            throw new UnsupportedOperationException("Not supported when using joml.nounsafe");
        }
        MemUtil.MemUtilUnsafe.getTransposed(this, address);
        return this.determineProperties();
    }

    public Matrix4f set(Vector4fc col0, Vector4fc col1, Vector4fc col2, Vector4fc col3) {
        return this._m00(col0.x())._m01(col0.y())._m02(col0.z())._m03(col0.w())._m10(col1.x())._m11(col1.y())._m12(col1.z())._m13(col1.w())._m20(col2.x())._m21(col2.y())._m22(col2.z())._m23(col2.w())._m30(col3.x())._m31(col3.y())._m32(col3.z())._m33(col3.w()).determineProperties();
    }

    public float determinant() {
        if ((this.properties & 2) != 0) {
            return this.determinantAffine();
        }
        return (this.m00() * this.m11() - this.m01() * this.m10()) * (this.m22() * this.m33() - this.m23() * this.m32()) + (this.m02() * this.m10() - this.m00() * this.m12()) * (this.m21() * this.m33() - this.m23() * this.m31()) + (this.m00() * this.m13() - this.m03() * this.m10()) * (this.m21() * this.m32() - this.m22() * this.m31()) + (this.m01() * this.m12() - this.m02() * this.m11()) * (this.m20() * this.m33() - this.m23() * this.m30()) + (this.m03() * this.m11() - this.m01() * this.m13()) * (this.m20() * this.m32() - this.m22() * this.m30()) + (this.m02() * this.m13() - this.m03() * this.m12()) * (this.m20() * this.m31() - this.m21() * this.m30());
    }

    public float determinant3x3() {
        return (this.m00() * this.m11() - this.m01() * this.m10()) * this.m22() + (this.m02() * this.m10() - this.m00() * this.m12()) * this.m21() + (this.m01() * this.m12() - this.m02() * this.m11()) * this.m20();
    }

    public float determinantAffine() {
        return (this.m00() * this.m11() - this.m01() * this.m10()) * this.m22() + (this.m02() * this.m10() - this.m00() * this.m12()) * this.m21() + (this.m01() * this.m12() - this.m02() * this.m11()) * this.m20();
    }

    public Matrix4f invert(Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.identity();
        }
        if ((this.properties & 8) != 0) {
            return this.invertTranslation(dest);
        }
        if ((this.properties & 0x10) != 0) {
            return this.invertOrthonormal(dest);
        }
        if ((this.properties & 2) != 0) {
            return this.invertAffine(dest);
        }
        if ((this.properties & 1) != 0) {
            return this.invertPerspective(dest);
        }
        return this.invertGeneric(dest);
    }

    private Matrix4f invertTranslation(Matrix4f dest) {
        if (dest != this) {
            dest.set(this);
        }
        return dest._m30(-this.m30())._m31(-this.m31())._m32(-this.m32())._properties(26);
    }

    private Matrix4f invertOrthonormal(Matrix4f dest) {
        float nm30 = -(this.m00() * this.m30() + this.m01() * this.m31() + this.m02() * this.m32());
        float nm31 = -(this.m10() * this.m30() + this.m11() * this.m31() + this.m12() * this.m32());
        float nm32 = -(this.m20() * this.m30() + this.m21() * this.m31() + this.m22() * this.m32());
        float m01 = this.m01();
        float m02 = this.m02();
        float m12 = this.m12();
        return dest._m00(this.m00())._m01(this.m10())._m02(this.m20())._m03(0.0f)._m10(m01)._m11(this.m11())._m12(this.m21())._m13(0.0f)._m20(m02)._m21(m12)._m22(this.m22())._m23(0.0f)._m30(nm30)._m31(nm31)._m32(nm32)._m33(1.0f)._properties(18);
    }

    private Matrix4f invertGeneric(Matrix4f dest) {
        if (this != dest) {
            return this.invertGenericNonThis(dest);
        }
        return this.invertGenericThis(dest);
    }

    private Matrix4f invertGenericNonThis(Matrix4f dest) {
        float a2 = this.m00() * this.m11() - this.m01() * this.m10();
        float b2 = this.m00() * this.m12() - this.m02() * this.m10();
        float c2 = this.m00() * this.m13() - this.m03() * this.m10();
        float d2 = this.m01() * this.m12() - this.m02() * this.m11();
        float e2 = this.m01() * this.m13() - this.m03() * this.m11();
        float f2 = this.m02() * this.m13() - this.m03() * this.m12();
        float g2 = this.m20() * this.m31() - this.m21() * this.m30();
        float h2 = this.m20() * this.m32() - this.m22() * this.m30();
        float i2 = this.m20() * this.m33() - this.m23() * this.m30();
        float j2 = this.m21() * this.m32() - this.m22() * this.m31();
        float k2 = this.m21() * this.m33() - this.m23() * this.m31();
        float l2 = this.m22() * this.m33() - this.m23() * this.m32();
        float det = a2 * l2 - b2 * k2 + c2 * j2 + d2 * i2 - e2 * h2 + f2 * g2;
        det = 1.0f / det;
        return dest._m00(Math.fma(this.m11(), l2, Math.fma(-this.m12(), k2, this.m13() * j2)) * det)._m01(Math.fma(-this.m01(), l2, Math.fma(this.m02(), k2, -this.m03() * j2)) * det)._m02(Math.fma(this.m31(), f2, Math.fma(-this.m32(), e2, this.m33() * d2)) * det)._m03(Math.fma(-this.m21(), f2, Math.fma(this.m22(), e2, -this.m23() * d2)) * det)._m10(Math.fma(-this.m10(), l2, Math.fma(this.m12(), i2, -this.m13() * h2)) * det)._m11(Math.fma(this.m00(), l2, Math.fma(-this.m02(), i2, this.m03() * h2)) * det)._m12(Math.fma(-this.m30(), f2, Math.fma(this.m32(), c2, -this.m33() * b2)) * det)._m13(Math.fma(this.m20(), f2, Math.fma(-this.m22(), c2, this.m23() * b2)) * det)._m20(Math.fma(this.m10(), k2, Math.fma(-this.m11(), i2, this.m13() * g2)) * det)._m21(Math.fma(-this.m00(), k2, Math.fma(this.m01(), i2, -this.m03() * g2)) * det)._m22(Math.fma(this.m30(), e2, Math.fma(-this.m31(), c2, this.m33() * a2)) * det)._m23(Math.fma(-this.m20(), e2, Math.fma(this.m21(), c2, -this.m23() * a2)) * det)._m30(Math.fma(-this.m10(), j2, Math.fma(this.m11(), h2, -this.m12() * g2)) * det)._m31(Math.fma(this.m00(), j2, Math.fma(-this.m01(), h2, this.m02() * g2)) * det)._m32(Math.fma(-this.m30(), d2, Math.fma(this.m31(), b2, -this.m32() * a2)) * det)._m33(Math.fma(this.m20(), d2, Math.fma(-this.m21(), b2, this.m22() * a2)) * det)._properties(0);
    }

    private Matrix4f invertGenericThis(Matrix4f dest) {
        float a2 = this.m00() * this.m11() - this.m01() * this.m10();
        float b2 = this.m00() * this.m12() - this.m02() * this.m10();
        float c2 = this.m00() * this.m13() - this.m03() * this.m10();
        float d2 = this.m01() * this.m12() - this.m02() * this.m11();
        float e2 = this.m01() * this.m13() - this.m03() * this.m11();
        float f2 = this.m02() * this.m13() - this.m03() * this.m12();
        float g2 = this.m20() * this.m31() - this.m21() * this.m30();
        float h2 = this.m20() * this.m32() - this.m22() * this.m30();
        float i2 = this.m20() * this.m33() - this.m23() * this.m30();
        float j2 = this.m21() * this.m32() - this.m22() * this.m31();
        float k2 = this.m21() * this.m33() - this.m23() * this.m31();
        float l2 = this.m22() * this.m33() - this.m23() * this.m32();
        float det = a2 * l2 - b2 * k2 + c2 * j2 + d2 * i2 - e2 * h2 + f2 * g2;
        det = 1.0f / det;
        float nm00 = Math.fma(this.m11(), l2, Math.fma(-this.m12(), k2, this.m13() * j2)) * det;
        float nm01 = Math.fma(-this.m01(), l2, Math.fma(this.m02(), k2, -this.m03() * j2)) * det;
        float nm02 = Math.fma(this.m31(), f2, Math.fma(-this.m32(), e2, this.m33() * d2)) * det;
        float nm03 = Math.fma(-this.m21(), f2, Math.fma(this.m22(), e2, -this.m23() * d2)) * det;
        float nm10 = Math.fma(-this.m10(), l2, Math.fma(this.m12(), i2, -this.m13() * h2)) * det;
        float nm11 = Math.fma(this.m00(), l2, Math.fma(-this.m02(), i2, this.m03() * h2)) * det;
        float nm12 = Math.fma(-this.m30(), f2, Math.fma(this.m32(), c2, -this.m33() * b2)) * det;
        float nm13 = Math.fma(this.m20(), f2, Math.fma(-this.m22(), c2, this.m23() * b2)) * det;
        float nm20 = Math.fma(this.m10(), k2, Math.fma(-this.m11(), i2, this.m13() * g2)) * det;
        float nm21 = Math.fma(-this.m00(), k2, Math.fma(this.m01(), i2, -this.m03() * g2)) * det;
        float nm22 = Math.fma(this.m30(), e2, Math.fma(-this.m31(), c2, this.m33() * a2)) * det;
        float nm23 = Math.fma(-this.m20(), e2, Math.fma(this.m21(), c2, -this.m23() * a2)) * det;
        float nm30 = Math.fma(-this.m10(), j2, Math.fma(this.m11(), h2, -this.m12() * g2)) * det;
        float nm31 = Math.fma(this.m00(), j2, Math.fma(-this.m01(), h2, this.m02() * g2)) * det;
        float nm32 = Math.fma(-this.m30(), d2, Math.fma(this.m31(), b2, -this.m32() * a2)) * det;
        float nm33 = Math.fma(this.m20(), d2, Math.fma(-this.m21(), b2, this.m22() * a2)) * det;
        return dest._m00(nm00)._m01(nm01)._m02(nm02)._m03(nm03)._m10(nm10)._m11(nm11)._m12(nm12)._m13(nm13)._m20(nm20)._m21(nm21)._m22(nm22)._m23(nm23)._m30(nm30)._m31(nm31)._m32(nm32)._m33(nm33)._properties(0);
    }

    public Matrix4f invert() {
        return this.invert(this);
    }

    public Matrix4f invertPerspective(Matrix4f dest) {
        float a2 = 1.0f / (this.m00() * this.m11());
        float l2 = -1.0f / (this.m23() * this.m32());
        return dest.set(this.m11() * a2, 0.0f, 0.0f, 0.0f, 0.0f, this.m00() * a2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -this.m23() * l2, 0.0f, 0.0f, -this.m32() * l2, this.m22() * l2)._properties(0);
    }

    public Matrix4f invertPerspective() {
        return this.invertPerspective(this);
    }

    public Matrix4f invertFrustum(Matrix4f dest) {
        float invM00 = 1.0f / this.m00();
        float invM11 = 1.0f / this.m11();
        float invM23 = 1.0f / this.m23();
        float invM32 = 1.0f / this.m32();
        return dest.set(invM00, 0.0f, 0.0f, 0.0f, 0.0f, invM11, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, invM32, -this.m20() * invM00 * invM23, -this.m21() * invM11 * invM23, invM23, -this.m22() * invM23 * invM32);
    }

    public Matrix4f invertFrustum() {
        return this.invertFrustum(this);
    }

    public Matrix4f invertOrtho(Matrix4f dest) {
        float invM00 = 1.0f / this.m00();
        float invM11 = 1.0f / this.m11();
        float invM22 = 1.0f / this.m22();
        return dest.set(invM00, 0.0f, 0.0f, 0.0f, 0.0f, invM11, 0.0f, 0.0f, 0.0f, 0.0f, invM22, 0.0f, -this.m30() * invM00, -this.m31() * invM11, -this.m32() * invM22, 1.0f)._properties(2 | this.properties & 0x10);
    }

    public Matrix4f invertOrtho() {
        return this.invertOrtho(this);
    }

    public Matrix4f invertPerspectiveView(Matrix4fc view, Matrix4f dest) {
        float a2 = 1.0f / (this.m00() * this.m11());
        float l2 = -1.0f / (this.m23() * this.m32());
        float pm00 = this.m11() * a2;
        float pm11 = this.m00() * a2;
        float pm23 = -this.m23() * l2;
        float pm32 = -this.m32() * l2;
        float pm33 = this.m22() * l2;
        float vm30 = -view.m00() * view.m30() - view.m01() * view.m31() - view.m02() * view.m32();
        float vm31 = -view.m10() * view.m30() - view.m11() * view.m31() - view.m12() * view.m32();
        float vm32 = -view.m20() * view.m30() - view.m21() * view.m31() - view.m22() * view.m32();
        float nm10 = view.m01() * pm11;
        float nm30 = view.m02() * pm32 + vm30 * pm33;
        float nm31 = view.m12() * pm32 + vm31 * pm33;
        float nm32 = view.m22() * pm32 + vm32 * pm33;
        return dest._m00(view.m00() * pm00)._m01(view.m10() * pm00)._m02(view.m20() * pm00)._m03(0.0f)._m10(nm10)._m11(view.m11() * pm11)._m12(view.m21() * pm11)._m13(0.0f)._m20(vm30 * pm23)._m21(vm31 * pm23)._m22(vm32 * pm23)._m23(pm23)._m30(nm30)._m31(nm31)._m32(nm32)._m33(pm33)._properties(0);
    }

    public Matrix4f invertPerspectiveView(Matrix4x3fc view, Matrix4f dest) {
        float a2 = 1.0f / (this.m00() * this.m11());
        float l2 = -1.0f / (this.m23() * this.m32());
        float pm00 = this.m11() * a2;
        float pm11 = this.m00() * a2;
        float pm23 = -this.m23() * l2;
        float pm32 = -this.m32() * l2;
        float pm33 = this.m22() * l2;
        float vm30 = -view.m00() * view.m30() - view.m01() * view.m31() - view.m02() * view.m32();
        float vm31 = -view.m10() * view.m30() - view.m11() * view.m31() - view.m12() * view.m32();
        float vm32 = -view.m20() * view.m30() - view.m21() * view.m31() - view.m22() * view.m32();
        return dest._m00(view.m00() * pm00)._m01(view.m10() * pm00)._m02(view.m20() * pm00)._m03(0.0f)._m10(view.m01() * pm11)._m11(view.m11() * pm11)._m12(view.m21() * pm11)._m13(0.0f)._m20(vm30 * pm23)._m21(vm31 * pm23)._m22(vm32 * pm23)._m23(pm23)._m30(view.m02() * pm32 + vm30 * pm33)._m31(view.m12() * pm32 + vm31 * pm33)._m32(view.m22() * pm32 + vm32 * pm33)._m33(pm33)._properties(0);
    }

    public Matrix4f invertAffine(Matrix4f dest) {
        float m11m00 = this.m00() * this.m11();
        float m10m01 = this.m01() * this.m10();
        float m10m02 = this.m02() * this.m10();
        float m12m00 = this.m00() * this.m12();
        float m12m01 = this.m01() * this.m12();
        float m11m02 = this.m02() * this.m11();
        float det = (m11m00 - m10m01) * this.m22() + (m10m02 - m12m00) * this.m21() + (m12m01 - m11m02) * this.m20();
        float s2 = 1.0f / det;
        float m10m22 = this.m10() * this.m22();
        float m10m21 = this.m10() * this.m21();
        float m11m22 = this.m11() * this.m22();
        float m11m20 = this.m11() * this.m20();
        float m12m21 = this.m12() * this.m21();
        float m12m20 = this.m12() * this.m20();
        float m20m02 = this.m20() * this.m02();
        float m20m01 = this.m20() * this.m01();
        float m21m02 = this.m21() * this.m02();
        float m21m00 = this.m21() * this.m00();
        float m22m01 = this.m22() * this.m01();
        float m22m00 = this.m22() * this.m00();
        float nm31 = (m20m02 * this.m31() - m20m01 * this.m32() + m21m00 * this.m32() - m21m02 * this.m30() + m22m01 * this.m30() - m22m00 * this.m31()) * s2;
        float nm32 = (m11m02 * this.m30() - m12m01 * this.m30() + m12m00 * this.m31() - m10m02 * this.m31() + m10m01 * this.m32() - m11m00 * this.m32()) * s2;
        return dest._m00((m11m22 - m12m21) * s2)._m01((m21m02 - m22m01) * s2)._m02((m12m01 - m11m02) * s2)._m03(0.0f)._m10((m12m20 - m10m22) * s2)._m11((m22m00 - m20m02) * s2)._m12((m10m02 - m12m00) * s2)._m13(0.0f)._m20((m10m21 - m11m20) * s2)._m21((m20m01 - m21m00) * s2)._m22((m11m00 - m10m01) * s2)._m23(0.0f)._m30((m10m22 * this.m31() - m10m21 * this.m32() + m11m20 * this.m32() - m11m22 * this.m30() + m12m21 * this.m30() - m12m20 * this.m31()) * s2)._m31(nm31)._m32(nm32)._m33(1.0f)._properties(2);
    }

    public Matrix4f invertAffine() {
        return this.invertAffine(this);
    }

    public Matrix4f transpose(Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.identity();
        }
        if (this != dest) {
            return this.transposeNonThisGeneric(dest);
        }
        return this.transposeThisGeneric(dest);
    }

    private Matrix4f transposeNonThisGeneric(Matrix4f dest) {
        return dest._m00(this.m00())._m01(this.m10())._m02(this.m20())._m03(this.m30())._m10(this.m01())._m11(this.m11())._m12(this.m21())._m13(this.m31())._m20(this.m02())._m21(this.m12())._m22(this.m22())._m23(this.m32())._m30(this.m03())._m31(this.m13())._m32(this.m23())._m33(this.m33())._properties(0);
    }

    private Matrix4f transposeThisGeneric(Matrix4f dest) {
        float nm10 = this.m01();
        float nm20 = this.m02();
        float nm21 = this.m12();
        float nm30 = this.m03();
        float nm31 = this.m13();
        float nm32 = this.m23();
        return dest._m01(this.m10())._m02(this.m20())._m03(this.m30())._m10(nm10)._m12(this.m21())._m13(this.m31())._m20(nm20)._m21(nm21)._m23(this.m32())._m30(nm30)._m31(nm31)._m32(nm32)._properties(0);
    }

    public Matrix4f transpose3x3() {
        return this.transpose3x3(this);
    }

    public Matrix4f transpose3x3(Matrix4f dest) {
        float nm10 = this.m01();
        float nm20 = this.m02();
        float nm21 = this.m12();
        return dest._m00(this.m00())._m01(this.m10())._m02(this.m20())._m10(nm10)._m11(this.m11())._m12(this.m21())._m20(nm20)._m21(nm21)._m22(this.m22())._properties(this.properties & 0x1E);
    }

    public Matrix3f transpose3x3(Matrix3f dest) {
        return dest._m00(this.m00())._m01(this.m10())._m02(this.m20())._m10(this.m01())._m11(this.m11())._m12(this.m21())._m20(this.m02())._m21(this.m12())._m22(this.m22());
    }

    public Matrix4f transpose() {
        return this.transpose(this);
    }

    public Matrix4f translation(float x2, float y2, float z2) {
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        return this._m30(x2)._m31(y2)._m32(z2)._properties(26);
    }

    public Matrix4f translation(Vector3fc offset) {
        return this.translation(offset.x(), offset.y(), offset.z());
    }

    public Matrix4f setTranslation(float x2, float y2, float z2) {
        return this._m30(x2)._m31(y2)._m32(z2)._properties(this.properties & 0xFFFFFFFA);
    }

    public Matrix4f setTranslation(Vector3fc xyz) {
        return this.setTranslation(xyz.x(), xyz.y(), xyz.z());
    }

    public Vector3f getTranslation(Vector3f dest) {
        dest.x = this.m30();
        dest.y = this.m31();
        dest.z = this.m32();
        return dest;
    }

    public Vector3f getScale(Vector3f dest) {
        dest.x = Math.sqrt(this.m00() * this.m00() + this.m01() * this.m01() + this.m02() * this.m02());
        dest.y = Math.sqrt(this.m10() * this.m10() + this.m11() * this.m11() + this.m12() * this.m12());
        dest.z = Math.sqrt(this.m20() * this.m20() + this.m21() * this.m21() + this.m22() * this.m22());
        return dest;
    }

    public String toString() {
        String str = this.toString(Options.NUMBER_FORMAT);
        StringBuffer res = new StringBuffer();
        int eIndex = Integer.MIN_VALUE;
        for (int i2 = 0; i2 < str.length(); ++i2) {
            char c2 = str.charAt(i2);
            if (c2 == 'E') {
                eIndex = i2;
            } else {
                if (c2 == ' ' && eIndex == i2 - 1) {
                    res.append('+');
                    continue;
                }
                if (Character.isDigit(c2) && eIndex == i2 - 1) {
                    res.append('+');
                }
            }
            res.append(c2);
        }
        return res.toString();
    }

    public String toString(NumberFormat formatter) {
        return Runtime.format(this.m00(), formatter) + " " + Runtime.format(this.m10(), formatter) + " " + Runtime.format(this.m20(), formatter) + " " + Runtime.format(this.m30(), formatter) + "\n" + Runtime.format(this.m01(), formatter) + " " + Runtime.format(this.m11(), formatter) + " " + Runtime.format(this.m21(), formatter) + " " + Runtime.format(this.m31(), formatter) + "\n" + Runtime.format(this.m02(), formatter) + " " + Runtime.format(this.m12(), formatter) + " " + Runtime.format(this.m22(), formatter) + " " + Runtime.format(this.m32(), formatter) + "\n" + Runtime.format(this.m03(), formatter) + " " + Runtime.format(this.m13(), formatter) + " " + Runtime.format(this.m23(), formatter) + " " + Runtime.format(this.m33(), formatter) + "\n";
    }

    public Matrix4f get(Matrix4f dest) {
        return dest.set(this);
    }

    public Matrix4x3f get4x3(Matrix4x3f dest) {
        return dest.set(this);
    }

    public Matrix4d get(Matrix4d dest) {
        return dest.set(this);
    }

    public Matrix3f get3x3(Matrix3f dest) {
        return dest.set(this);
    }

    public Matrix3d get3x3(Matrix3d dest) {
        return dest.set(this);
    }

    public AxisAngle4f getRotation(AxisAngle4f dest) {
        return dest.set(this);
    }

    public AxisAngle4d getRotation(AxisAngle4d dest) {
        return dest.set(this);
    }

    public Quaternionf getUnnormalizedRotation(Quaternionf dest) {
        return dest.setFromUnnormalized(this);
    }

    public Quaternionf getNormalizedRotation(Quaternionf dest) {
        return dest.setFromNormalized(this);
    }

    public Quaterniond getUnnormalizedRotation(Quaterniond dest) {
        return dest.setFromUnnormalized(this);
    }

    public Quaterniond getNormalizedRotation(Quaterniond dest) {
        return dest.setFromNormalized(this);
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

    public FloatBuffer get4x3(FloatBuffer buffer) {
        MemUtil.INSTANCE.put4x3(this, buffer.position(), buffer);
        return buffer;
    }

    public FloatBuffer get4x3(int index, FloatBuffer buffer) {
        MemUtil.INSTANCE.put4x3(this, index, buffer);
        return buffer;
    }

    public ByteBuffer get4x3(ByteBuffer buffer) {
        MemUtil.INSTANCE.put4x3(this, buffer.position(), buffer);
        return buffer;
    }

    public ByteBuffer get4x3(int index, ByteBuffer buffer) {
        MemUtil.INSTANCE.put4x3(this, index, buffer);
        return buffer;
    }

    public FloatBuffer get3x4(FloatBuffer buffer) {
        MemUtil.INSTANCE.put3x4(this, buffer.position(), buffer);
        return buffer;
    }

    public FloatBuffer get3x4(int index, FloatBuffer buffer) {
        MemUtil.INSTANCE.put3x4(this, index, buffer);
        return buffer;
    }

    public ByteBuffer get3x4(ByteBuffer buffer) {
        MemUtil.INSTANCE.put3x4(this, buffer.position(), buffer);
        return buffer;
    }

    public ByteBuffer get3x4(int index, ByteBuffer buffer) {
        MemUtil.INSTANCE.put3x4(this, index, buffer);
        return buffer;
    }

    public FloatBuffer getTransposed(FloatBuffer buffer) {
        MemUtil.INSTANCE.putTransposed(this, buffer.position(), buffer);
        return buffer;
    }

    public FloatBuffer getTransposed(int index, FloatBuffer buffer) {
        MemUtil.INSTANCE.putTransposed(this, index, buffer);
        return buffer;
    }

    public ByteBuffer getTransposed(ByteBuffer buffer) {
        MemUtil.INSTANCE.putTransposed(this, buffer.position(), buffer);
        return buffer;
    }

    public ByteBuffer getTransposed(int index, ByteBuffer buffer) {
        MemUtil.INSTANCE.putTransposed(this, index, buffer);
        return buffer;
    }

    public FloatBuffer get4x3Transposed(FloatBuffer buffer) {
        MemUtil.INSTANCE.put4x3Transposed(this, buffer.position(), buffer);
        return buffer;
    }

    public FloatBuffer get4x3Transposed(int index, FloatBuffer buffer) {
        MemUtil.INSTANCE.put4x3Transposed(this, index, buffer);
        return buffer;
    }

    public ByteBuffer get4x3Transposed(ByteBuffer buffer) {
        MemUtil.INSTANCE.put4x3Transposed(this, buffer.position(), buffer);
        return buffer;
    }

    public ByteBuffer get4x3Transposed(int index, ByteBuffer buffer) {
        MemUtil.INSTANCE.put4x3Transposed(this, index, buffer);
        return buffer;
    }

    public Matrix4fc getToAddress(long address) {
        if (Options.NO_UNSAFE) {
            throw new UnsupportedOperationException("Not supported when using joml.nounsafe");
        }
        MemUtil.MemUtilUnsafe.put(this, address);
        return this;
    }

    public float[] get(float[] arr2, int offset) {
        MemUtil.INSTANCE.copy(this, arr2, offset);
        return arr2;
    }

    public float[] get(float[] arr2) {
        MemUtil.INSTANCE.copy(this, arr2, 0);
        return arr2;
    }

    public Matrix4f zero() {
        MemUtil.INSTANCE.zero(this);
        return this._properties(0);
    }

    public Matrix4f scaling(float factor) {
        return this.scaling(factor, factor, factor);
    }

    public Matrix4f scaling(float x2, float y2, float z2) {
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        boolean one = Math.absEqualsOne(x2) && Math.absEqualsOne(y2) && Math.absEqualsOne(z2);
        return this._m00(x2)._m11(y2)._m22(z2)._properties(2 | (one ? 16 : 0));
    }

    public Matrix4f scaling(Vector3fc xyz) {
        return this.scaling(xyz.x(), xyz.y(), xyz.z());
    }

    public Matrix4f rotation(float angle, Vector3fc axis) {
        return this.rotation(angle, axis.x(), axis.y(), axis.z());
    }

    public Matrix4f rotation(AxisAngle4f axisAngle) {
        return this.rotation(axisAngle.angle, axisAngle.x, axisAngle.y, axisAngle.z);
    }

    public Matrix4f rotation(float angle, float x2, float y2, float z2) {
        if (y2 == 0.0f && z2 == 0.0f && Math.absEqualsOne(x2)) {
            return this.rotationX(x2 * angle);
        }
        if (x2 == 0.0f && z2 == 0.0f && Math.absEqualsOne(y2)) {
            return this.rotationY(y2 * angle);
        }
        if (x2 == 0.0f && y2 == 0.0f && Math.absEqualsOne(z2)) {
            return this.rotationZ(z2 * angle);
        }
        return this.rotationInternal(angle, x2, y2, z2);
    }

    private Matrix4f rotationInternal(float angle, float x2, float y2, float z2) {
        float sin = Math.sin(angle);
        float cos = Math.cosFromSin(sin, angle);
        float C = 1.0f - cos;
        float xy = x2 * y2;
        float xz = x2 * z2;
        float yz = y2 * z2;
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        return this._m00(cos + x2 * x2 * C)._m10(xy * C - z2 * sin)._m20(xz * C + y2 * sin)._m01(xy * C + z2 * sin)._m11(cos + y2 * y2 * C)._m21(yz * C - x2 * sin)._m02(xz * C - y2 * sin)._m12(yz * C + x2 * sin)._m22(cos + z2 * z2 * C)._properties(18);
    }

    public Matrix4f rotationX(float ang) {
        float sin = Math.sin(ang);
        float cos = Math.cosFromSin(sin, ang);
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        this._m11(cos)._m12(sin)._m21(-sin)._m22(cos)._properties(18);
        return this;
    }

    public Matrix4f rotationY(float ang) {
        float sin = Math.sin(ang);
        float cos = Math.cosFromSin(sin, ang);
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        this._m00(cos)._m02(-sin)._m20(sin)._m22(cos)._properties(18);
        return this;
    }

    public Matrix4f rotationZ(float ang) {
        float sin = Math.sin(ang);
        float cos = Math.cosFromSin(sin, ang);
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        return this._m00(cos)._m01(sin)._m10(-sin)._m11(cos)._properties(18);
    }

    public Matrix4f rotationTowardsXY(float dirX, float dirY) {
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        return this._m00(dirY)._m01(dirX)._m10(-dirX)._m11(dirY)._properties(18);
    }

    public Matrix4f rotationXYZ(float angleX, float angleY, float angleZ) {
        float sinX = Math.sin(angleX);
        float cosX = Math.cosFromSin(sinX, angleX);
        float sinY = Math.sin(angleY);
        float cosY = Math.cosFromSin(sinY, angleY);
        float sinZ = Math.sin(angleZ);
        float cosZ = Math.cosFromSin(sinZ, angleZ);
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        float nm01 = -sinX * -sinY;
        float nm02 = cosX * -sinY;
        return this._m20(sinY)._m21(-sinX * cosY)._m22(cosX * cosY)._m00(cosY * cosZ)._m01(nm01 * cosZ + cosX * sinZ)._m02(nm02 * cosZ + sinX * sinZ)._m10(cosY * -sinZ)._m11(nm01 * -sinZ + cosX * cosZ)._m12(nm02 * -sinZ + sinX * cosZ)._properties(18);
    }

    public Matrix4f rotationZYX(float angleZ, float angleY, float angleX) {
        float sinX = Math.sin(angleX);
        float cosX = Math.cosFromSin(sinX, angleX);
        float sinY = Math.sin(angleY);
        float cosY = Math.cosFromSin(sinY, angleY);
        float sinZ = Math.sin(angleZ);
        float cosZ = Math.cosFromSin(sinZ, angleZ);
        float nm20 = cosZ * sinY;
        float nm21 = sinZ * sinY;
        return this._m00(cosZ * cosY)._m01(sinZ * cosY)._m02(-sinY)._m03(0.0f)._m10(-sinZ * cosX + nm20 * sinX)._m11(cosZ * cosX + nm21 * sinX)._m12(cosY * sinX)._m13(0.0f)._m20(-sinZ * -sinX + nm20 * cosX)._m21(cosZ * -sinX + nm21 * cosX)._m22(cosY * cosX)._m23(0.0f)._m30(0.0f)._m31(0.0f)._m32(0.0f)._m33(1.0f)._properties(18);
    }

    public Matrix4f rotationYXZ(float angleY, float angleX, float angleZ) {
        float sinX = Math.sin(angleX);
        float cosX = Math.cosFromSin(sinX, angleX);
        float sinY = Math.sin(angleY);
        float cosY = Math.cosFromSin(sinY, angleY);
        float sinZ = Math.sin(angleZ);
        float cosZ = Math.cosFromSin(sinZ, angleZ);
        float nm10 = sinY * sinX;
        float nm12 = cosY * sinX;
        return this._m20(sinY * cosX)._m21(-sinX)._m22(cosY * cosX)._m23(0.0f)._m00(cosY * cosZ + nm10 * sinZ)._m01(cosX * sinZ)._m02(-sinY * cosZ + nm12 * sinZ)._m03(0.0f)._m10(cosY * -sinZ + nm10 * cosZ)._m11(cosX * cosZ)._m12(-sinY * -sinZ + nm12 * cosZ)._m13(0.0f)._m30(0.0f)._m31(0.0f)._m32(0.0f)._m33(1.0f)._properties(18);
    }

    public Matrix4f setRotationXYZ(float angleX, float angleY, float angleZ) {
        float sinX = Math.sin(angleX);
        float cosX = Math.cosFromSin(sinX, angleX);
        float sinY = Math.sin(angleY);
        float cosY = Math.cosFromSin(sinY, angleY);
        float sinZ = Math.sin(angleZ);
        float cosZ = Math.cosFromSin(sinZ, angleZ);
        float nm01 = -sinX * -sinY;
        float nm02 = cosX * -sinY;
        return this._m20(sinY)._m21(-sinX * cosY)._m22(cosX * cosY)._m00(cosY * cosZ)._m01(nm01 * cosZ + cosX * sinZ)._m02(nm02 * cosZ + sinX * sinZ)._m10(cosY * -sinZ)._m11(nm01 * -sinZ + cosX * cosZ)._m12(nm02 * -sinZ + sinX * cosZ)._properties(this.properties & 0xFFFFFFF2);
    }

    public Matrix4f setRotationZYX(float angleZ, float angleY, float angleX) {
        float sinX = Math.sin(angleX);
        float cosX = Math.cosFromSin(sinX, angleX);
        float sinY = Math.sin(angleY);
        float cosY = Math.cosFromSin(sinY, angleY);
        float sinZ = Math.sin(angleZ);
        float cosZ = Math.cosFromSin(sinZ, angleZ);
        float nm20 = cosZ * sinY;
        float nm21 = sinZ * sinY;
        return this._m00(cosZ * cosY)._m01(sinZ * cosY)._m02(-sinY)._m10(-sinZ * cosX + nm20 * sinX)._m11(cosZ * cosX + nm21 * sinX)._m12(cosY * sinX)._m20(-sinZ * -sinX + nm20 * cosX)._m21(cosZ * -sinX + nm21 * cosX)._m22(cosY * cosX)._properties(this.properties & 0xFFFFFFF2);
    }

    public Matrix4f setRotationYXZ(float angleY, float angleX, float angleZ) {
        float sinX = Math.sin(angleX);
        float cosX = Math.cosFromSin(sinX, angleX);
        float sinY = Math.sin(angleY);
        float cosY = Math.cosFromSin(sinY, angleY);
        float sinZ = Math.sin(angleZ);
        float cosZ = Math.cosFromSin(sinZ, angleZ);
        float nm10 = sinY * sinX;
        float nm12 = cosY * sinX;
        return this._m20(sinY * cosX)._m21(-sinX)._m22(cosY * cosX)._m00(cosY * cosZ + nm10 * sinZ)._m01(cosX * sinZ)._m02(-sinY * cosZ + nm12 * sinZ)._m10(cosY * -sinZ + nm10 * cosZ)._m11(cosX * cosZ)._m12(-sinY * -sinZ + nm12 * cosZ)._properties(this.properties & 0xFFFFFFF2);
    }

    public Matrix4f rotation(Quaternionfc quat) {
        float w2 = quat.w() * quat.w();
        float x2 = quat.x() * quat.x();
        float y2 = quat.y() * quat.y();
        float z2 = quat.z() * quat.z();
        float zw = quat.z() * quat.w();
        float dzw = zw + zw;
        float xy = quat.x() * quat.y();
        float dxy = xy + xy;
        float xz = quat.x() * quat.z();
        float dxz = xz + xz;
        float yw = quat.y() * quat.w();
        float dyw = yw + yw;
        float yz = quat.y() * quat.z();
        float dyz = yz + yz;
        float xw = quat.x() * quat.w();
        float dxw = xw + xw;
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        return this._m00(w2 + x2 - z2 - y2)._m01(dxy + dzw)._m02(dxz - dyw)._m10(-dzw + dxy)._m11(y2 - z2 + w2 - x2)._m12(dyz + dxw)._m20(dyw + dxz)._m21(dyz - dxw)._m22(z2 - y2 - x2 + w2)._properties(18);
    }

    public Matrix4f translationRotateScale(float tx, float ty, float tz, float qx, float qy, float qz, float qw2, float sx, float sy, float sz) {
        float dqx = qx + qx;
        float dqy = qy + qy;
        float dqz = qz + qz;
        float q00 = dqx * qx;
        float q11 = dqy * qy;
        float q22 = dqz * qz;
        float q01 = dqx * qy;
        float q02 = dqx * qz;
        float q03 = dqx * qw2;
        float q12 = dqy * qz;
        float q13 = dqy * qw2;
        float q23 = dqz * qw2;
        boolean one = Math.absEqualsOne(sx) && Math.absEqualsOne(sy) && Math.absEqualsOne(sz);
        return this._m00(sx - (q11 + q22) * sx)._m01((q01 + q23) * sx)._m02((q02 - q13) * sx)._m03(0.0f)._m10((q01 - q23) * sy)._m11(sy - (q22 + q00) * sy)._m12((q12 + q03) * sy)._m13(0.0f)._m20((q02 + q13) * sz)._m21((q12 - q03) * sz)._m22(sz - (q11 + q00) * sz)._m23(0.0f)._m30(tx)._m31(ty)._m32(tz)._m33(1.0f)._properties(2 | (one ? 16 : 0));
    }

    public Matrix4f translationRotateScale(Vector3fc translation, Quaternionfc quat, Vector3fc scale) {
        return this.translationRotateScale(translation.x(), translation.y(), translation.z(), quat.x(), quat.y(), quat.z(), quat.w(), scale.x(), scale.y(), scale.z());
    }

    public Matrix4f translationRotateScale(float tx, float ty, float tz, float qx, float qy, float qz, float qw2, float scale) {
        return this.translationRotateScale(tx, ty, tz, qx, qy, qz, qw2, scale, scale, scale);
    }

    public Matrix4f translationRotateScale(Vector3fc translation, Quaternionfc quat, float scale) {
        return this.translationRotateScale(translation.x(), translation.y(), translation.z(), quat.x(), quat.y(), quat.z(), quat.w(), scale, scale, scale);
    }

    public Matrix4f translationRotateScaleInvert(float tx, float ty, float tz, float qx, float qy, float qz, float qw2, float sx, float sy, float sz) {
        boolean one;
        boolean bl2 = one = Math.absEqualsOne(sx) && Math.absEqualsOne(sy) && Math.absEqualsOne(sz);
        if (one) {
            return this.translationRotateInvert(tx, ty, tz, qx, qy, qz, qw2);
        }
        float nqx = -qx;
        float nqy = -qy;
        float nqz = -qz;
        float dqx = nqx + nqx;
        float dqy = nqy + nqy;
        float dqz = nqz + nqz;
        float q00 = dqx * nqx;
        float q11 = dqy * nqy;
        float q22 = dqz * nqz;
        float q01 = dqx * nqy;
        float q02 = dqx * nqz;
        float q03 = dqx * qw2;
        float q12 = dqy * nqz;
        float q13 = dqy * qw2;
        float q23 = dqz * qw2;
        float isx = 1.0f / sx;
        float isy = 1.0f / sy;
        float isz = 1.0f / sz;
        return this._m00(isx * (1.0f - q11 - q22))._m01(isy * (q01 + q23))._m02(isz * (q02 - q13))._m03(0.0f)._m10(isx * (q01 - q23))._m11(isy * (1.0f - q22 - q00))._m12(isz * (q12 + q03))._m13(0.0f)._m20(isx * (q02 + q13))._m21(isy * (q12 - q03))._m22(isz * (1.0f - q11 - q00))._m23(0.0f)._m30(-this.m00() * tx - this.m10() * ty - this.m20() * tz)._m31(-this.m01() * tx - this.m11() * ty - this.m21() * tz)._m32(-this.m02() * tx - this.m12() * ty - this.m22() * tz)._m33(1.0f)._properties(2);
    }

    public Matrix4f translationRotateScaleInvert(Vector3fc translation, Quaternionfc quat, Vector3fc scale) {
        return this.translationRotateScaleInvert(translation.x(), translation.y(), translation.z(), quat.x(), quat.y(), quat.z(), quat.w(), scale.x(), scale.y(), scale.z());
    }

    public Matrix4f translationRotateScaleInvert(Vector3fc translation, Quaternionfc quat, float scale) {
        return this.translationRotateScaleInvert(translation.x(), translation.y(), translation.z(), quat.x(), quat.y(), quat.z(), quat.w(), scale, scale, scale);
    }

    public Matrix4f translationRotateScaleMulAffine(float tx, float ty, float tz, float qx, float qy, float qz, float qw2, float sx, float sy, float sz, Matrix4f m2) {
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
        float nm00 = w2 + x2 - z2 - y2;
        float nm01 = xy + zw + zw + xy;
        float nm02 = xz - yw + xz - yw;
        float nm10 = -zw + xy - zw + xy;
        float nm11 = y2 - z2 + w2 - x2;
        float nm12 = yz + yz + xw + xw;
        float nm20 = yw + xz + xz + yw;
        float nm21 = yz + yz - xw - xw;
        float nm22 = z2 - y2 - x2 + w2;
        float m00 = nm00 * m2.m00() + nm10 * m2.m01() + nm20 * m2.m02();
        float m01 = nm01 * m2.m00() + nm11 * m2.m01() + nm21 * m2.m02();
        this._m02(nm02 * m2.m00() + nm12 * m2.m01() + nm22 * m2.m02())._m00(m00)._m01(m01)._m03(0.0f);
        float m10 = nm00 * m2.m10() + nm10 * m2.m11() + nm20 * m2.m12();
        float m11 = nm01 * m2.m10() + nm11 * m2.m11() + nm21 * m2.m12();
        this._m12(nm02 * m2.m10() + nm12 * m2.m11() + nm22 * m2.m12())._m10(m10)._m11(m11)._m13(0.0f);
        float m20 = nm00 * m2.m20() + nm10 * m2.m21() + nm20 * m2.m22();
        float m21 = nm01 * m2.m20() + nm11 * m2.m21() + nm21 * m2.m22();
        this._m22(nm02 * m2.m20() + nm12 * m2.m21() + nm22 * m2.m22())._m20(m20)._m21(m21)._m23(0.0f);
        float m30 = nm00 * m2.m30() + nm10 * m2.m31() + nm20 * m2.m32() + tx;
        float m31 = nm01 * m2.m30() + nm11 * m2.m31() + nm21 * m2.m32() + ty;
        this._m32(nm02 * m2.m30() + nm12 * m2.m31() + nm22 * m2.m32() + tz)._m30(m30)._m31(m31)._m33(1.0f);
        boolean one = Math.absEqualsOne(sx) && Math.absEqualsOne(sy) && Math.absEqualsOne(sz);
        return this._properties(2 | (one && (m2.properties & 0x10) != 0 ? 16 : 0));
    }

    public Matrix4f translationRotateScaleMulAffine(Vector3fc translation, Quaternionfc quat, Vector3fc scale, Matrix4f m2) {
        return this.translationRotateScaleMulAffine(translation.x(), translation.y(), translation.z(), quat.x(), quat.y(), quat.z(), quat.w(), scale.x(), scale.y(), scale.z(), m2);
    }

    public Matrix4f translationRotate(float tx, float ty, float tz, float qx, float qy, float qz, float qw2) {
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
        return this._m00(w2 + x2 - z2 - y2)._m01(xy + zw + zw + xy)._m02(xz - yw + xz - yw)._m10(-zw + xy - zw + xy)._m11(y2 - z2 + w2 - x2)._m12(yz + yz + xw + xw)._m20(yw + xz + xz + yw)._m21(yz + yz - xw - xw)._m22(z2 - y2 - x2 + w2)._m30(tx)._m31(ty)._m32(tz)._m33(1.0f)._properties(18);
    }

    public Matrix4f translationRotate(float tx, float ty, float tz, Quaternionfc quat) {
        return this.translationRotate(tx, ty, tz, quat.x(), quat.y(), quat.z(), quat.w());
    }

    public Matrix4f translationRotate(Vector3fc translation, Quaternionfc quat) {
        return this.translationRotate(translation.x(), translation.y(), translation.z(), quat.x(), quat.y(), quat.z(), quat.w());
    }

    public Matrix4f translationRotateInvert(float tx, float ty, float tz, float qx, float qy, float qz, float qw2) {
        float nqx = -qx;
        float nqy = -qy;
        float nqz = -qz;
        float dqx = nqx + nqx;
        float dqy = nqy + nqy;
        float dqz = nqz + nqz;
        float q00 = dqx * nqx;
        float q11 = dqy * nqy;
        float q22 = dqz * nqz;
        float q01 = dqx * nqy;
        float q02 = dqx * nqz;
        float q03 = dqx * qw2;
        float q12 = dqy * nqz;
        float q13 = dqy * qw2;
        float q23 = dqz * qw2;
        return this._m00(1.0f - q11 - q22)._m01(q01 + q23)._m02(q02 - q13)._m03(0.0f)._m10(q01 - q23)._m11(1.0f - q22 - q00)._m12(q12 + q03)._m13(0.0f)._m20(q02 + q13)._m21(q12 - q03)._m22(1.0f - q11 - q00)._m23(0.0f)._m30(-this.m00() * tx - this.m10() * ty - this.m20() * tz)._m31(-this.m01() * tx - this.m11() * ty - this.m21() * tz)._m32(-this.m02() * tx - this.m12() * ty - this.m22() * tz)._m33(1.0f)._properties(18);
    }

    public Matrix4f translationRotateInvert(Vector3fc translation, Quaternionfc quat) {
        return this.translationRotateInvert(translation.x(), translation.y(), translation.z(), quat.x(), quat.y(), quat.z(), quat.w());
    }

    public Matrix4f set3x3(Matrix3fc mat) {
        return this.set3x3Matrix3fc(mat)._properties(this.properties & 0xFFFFFFE2);
    }

    private Matrix4f set3x3Matrix3fc(Matrix3fc mat) {
        return this._m00(mat.m00())._m01(mat.m01())._m02(mat.m02())._m10(mat.m10())._m11(mat.m11())._m12(mat.m12())._m20(mat.m20())._m21(mat.m21())._m22(mat.m22());
    }

    public Vector4f transform(Vector4f v2) {
        return v2.mul(this);
    }

    public Vector4f transform(Vector4fc v2, Vector4f dest) {
        return v2.mul(this, dest);
    }

    public Vector4f transform(float x2, float y2, float z2, float w2, Vector4f dest) {
        return dest.set(x2, y2, z2, w2).mul(this);
    }

    public Vector4f transformTranspose(Vector4f v2) {
        return v2.mulTranspose(this);
    }

    public Vector4f transformTranspose(Vector4fc v2, Vector4f dest) {
        return v2.mulTranspose(this, dest);
    }

    public Vector4f transformTranspose(float x2, float y2, float z2, float w2, Vector4f dest) {
        return dest.set(x2, y2, z2, w2).mulTranspose(this);
    }

    public Vector4f transformProject(Vector4f v2) {
        return v2.mulProject(this);
    }

    public Vector4f transformProject(Vector4fc v2, Vector4f dest) {
        return v2.mulProject((Matrix4fc)this, dest);
    }

    public Vector4f transformProject(float x2, float y2, float z2, float w2, Vector4f dest) {
        return dest.set(x2, y2, z2, w2).mulProject(this);
    }

    public Vector3f transformProject(Vector4fc v2, Vector3f dest) {
        return v2.mulProject((Matrix4fc)this, dest);
    }

    public Vector3f transformProject(float x2, float y2, float z2, float w2, Vector3f dest) {
        return dest.set(x2, y2, z2).mulProject(this, w2, dest);
    }

    public Vector3f transformProject(Vector3f v2) {
        return v2.mulProject(this);
    }

    public Vector3f transformProject(Vector3fc v2, Vector3f dest) {
        return v2.mulProject(this, dest);
    }

    public Vector3f transformProject(float x2, float y2, float z2, Vector3f dest) {
        return dest.set(x2, y2, z2).mulProject(this);
    }

    public Vector3f transformPosition(Vector3f v2) {
        return v2.mulPosition(this);
    }

    public Vector3f transformPosition(Vector3fc v2, Vector3f dest) {
        return this.transformPosition(v2.x(), v2.y(), v2.z(), dest);
    }

    public Vector3f transformPosition(float x2, float y2, float z2, Vector3f dest) {
        return dest.set(x2, y2, z2).mulPosition(this);
    }

    public Vector3f transformDirection(Vector3f v2) {
        return this.transformDirection(v2.x, v2.y, v2.z, v2);
    }

    public Vector3f transformDirection(Vector3fc v2, Vector3f dest) {
        return this.transformDirection(v2.x(), v2.y(), v2.z(), dest);
    }

    public Vector3f transformDirection(float x2, float y2, float z2, Vector3f dest) {
        return dest.set(x2, y2, z2).mulDirection(this);
    }

    public Vector4f transformAffine(Vector4f v2) {
        return v2.mulAffine(this, v2);
    }

    public Vector4f transformAffine(Vector4fc v2, Vector4f dest) {
        return this.transformAffine(v2.x(), v2.y(), v2.z(), v2.w(), dest);
    }

    public Vector4f transformAffine(float x2, float y2, float z2, float w2, Vector4f dest) {
        return dest.set(x2, y2, z2, w2).mulAffine(this, dest);
    }

    public Matrix4f scale(Vector3fc xyz, Matrix4f dest) {
        return this.scale(xyz.x(), xyz.y(), xyz.z(), dest);
    }

    public Matrix4f scale(Vector3fc xyz) {
        return this.scale(xyz.x(), xyz.y(), xyz.z(), this);
    }

    public Matrix4f scale(float xyz, Matrix4f dest) {
        return this.scale(xyz, xyz, xyz, dest);
    }

    public Matrix4f scale(float xyz) {
        return this.scale(xyz, xyz, xyz);
    }

    public Matrix4f scaleXY(float x2, float y2, Matrix4f dest) {
        return this.scale(x2, y2, 1.0f, dest);
    }

    public Matrix4f scaleXY(float x2, float y2) {
        return this.scale(x2, y2, 1.0f);
    }

    public Matrix4f scale(float x2, float y2, float z2, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.scaling(x2, y2, z2);
        }
        return this.scaleGeneric(x2, y2, z2, dest);
    }

    private Matrix4f scaleGeneric(float x2, float y2, float z2, Matrix4f dest) {
        boolean one = Math.absEqualsOne(x2) && Math.absEqualsOne(y2) && Math.absEqualsOne(z2);
        return dest._m00(this.m00() * x2)._m01(this.m01() * x2)._m02(this.m02() * x2)._m03(this.m03() * x2)._m10(this.m10() * y2)._m11(this.m11() * y2)._m12(this.m12() * y2)._m13(this.m13() * y2)._m20(this.m20() * z2)._m21(this.m21() * z2)._m22(this.m22() * z2)._m23(this.m23() * z2)._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & ~(0xD | (one ? 0 : 16)));
    }

    public Matrix4f scale(float x2, float y2, float z2) {
        return this.scale(x2, y2, z2, this);
    }

    public Matrix4f scaleAround(float sx, float sy, float sz, float ox, float oy, float oz, Matrix4f dest) {
        float nm30 = this.m00() * ox + this.m10() * oy + this.m20() * oz + this.m30();
        float nm31 = this.m01() * ox + this.m11() * oy + this.m21() * oz + this.m31();
        float nm32 = this.m02() * ox + this.m12() * oy + this.m22() * oz + this.m32();
        float nm33 = this.m03() * ox + this.m13() * oy + this.m23() * oz + this.m33();
        boolean one = Math.absEqualsOne(sx) && Math.absEqualsOne(sy) && Math.absEqualsOne(sz);
        return dest._m00(this.m00() * sx)._m01(this.m01() * sx)._m02(this.m02() * sx)._m03(this.m03() * sx)._m10(this.m10() * sy)._m11(this.m11() * sy)._m12(this.m12() * sy)._m13(this.m13() * sy)._m20(this.m20() * sz)._m21(this.m21() * sz)._m22(this.m22() * sz)._m23(this.m23() * sz)._m30(-dest.m00() * ox - dest.m10() * oy - dest.m20() * oz + nm30)._m31(-dest.m01() * ox - dest.m11() * oy - dest.m21() * oz + nm31)._m32(-dest.m02() * ox - dest.m12() * oy - dest.m22() * oz + nm32)._m33(-dest.m03() * ox - dest.m13() * oy - dest.m23() * oz + nm33)._properties(this.properties & ~(0xD | (one ? 0 : 16)));
    }

    public Matrix4f scaleAround(float sx, float sy, float sz, float ox, float oy, float oz) {
        return this.scaleAround(sx, sy, sz, ox, oy, oz, this);
    }

    public Matrix4f scaleAround(float factor, float ox, float oy, float oz) {
        return this.scaleAround(factor, factor, factor, ox, oy, oz, this);
    }

    public Matrix4f scaleAround(float factor, float ox, float oy, float oz, Matrix4f dest) {
        return this.scaleAround(factor, factor, factor, ox, oy, oz, dest);
    }

    public Matrix4f scaleLocal(float x2, float y2, float z2, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.scaling(x2, y2, z2);
        }
        return this.scaleLocalGeneric(x2, y2, z2, dest);
    }

    private Matrix4f scaleLocalGeneric(float x2, float y2, float z2, Matrix4f dest) {
        float nm00 = x2 * this.m00();
        float nm01 = y2 * this.m01();
        float nm02 = z2 * this.m02();
        float nm10 = x2 * this.m10();
        float nm11 = y2 * this.m11();
        float nm12 = z2 * this.m12();
        float nm20 = x2 * this.m20();
        float nm21 = y2 * this.m21();
        float nm22 = z2 * this.m22();
        float nm30 = x2 * this.m30();
        float nm31 = y2 * this.m31();
        float nm32 = z2 * this.m32();
        boolean one = Math.absEqualsOne(x2) && Math.absEqualsOne(y2) && Math.absEqualsOne(z2);
        return dest._m00(nm00)._m01(nm01)._m02(nm02)._m03(this.m03())._m10(nm10)._m11(nm11)._m12(nm12)._m13(this.m13())._m20(nm20)._m21(nm21)._m22(nm22)._m23(this.m23())._m30(nm30)._m31(nm31)._m32(nm32)._m33(this.m33())._properties(this.properties & ~(0xD | (one ? 0 : 16)));
    }

    public Matrix4f scaleLocal(float xyz, Matrix4f dest) {
        return this.scaleLocal(xyz, xyz, xyz, dest);
    }

    public Matrix4f scaleLocal(float xyz) {
        return this.scaleLocal(xyz, this);
    }

    public Matrix4f scaleLocal(float x2, float y2, float z2) {
        return this.scaleLocal(x2, y2, z2, this);
    }

    public Matrix4f scaleAroundLocal(float sx, float sy, float sz, float ox, float oy, float oz, Matrix4f dest) {
        boolean one = Math.absEqualsOne(sx) && Math.absEqualsOne(sy) && Math.absEqualsOne(sz);
        return dest._m00(sx * (this.m00() - ox * this.m03()) + ox * this.m03())._m01(sy * (this.m01() - oy * this.m03()) + oy * this.m03())._m02(sz * (this.m02() - oz * this.m03()) + oz * this.m03())._m03(this.m03())._m10(sx * (this.m10() - ox * this.m13()) + ox * this.m13())._m11(sy * (this.m11() - oy * this.m13()) + oy * this.m13())._m12(sz * (this.m12() - oz * this.m13()) + oz * this.m13())._m13(this.m13())._m20(sx * (this.m20() - ox * this.m23()) + ox * this.m23())._m21(sy * (this.m21() - oy * this.m23()) + oy * this.m23())._m22(sz * (this.m22() - oz * this.m23()) + oz * this.m23())._m23(this.m23())._m30(sx * (this.m30() - ox * this.m33()) + ox * this.m33())._m31(sy * (this.m31() - oy * this.m33()) + oy * this.m33())._m32(sz * (this.m32() - oz * this.m33()) + oz * this.m33())._m33(this.m33())._properties(this.properties & ~(0xD | (one ? 0 : 16)));
    }

    public Matrix4f scaleAroundLocal(float sx, float sy, float sz, float ox, float oy, float oz) {
        return this.scaleAroundLocal(sx, sy, sz, ox, oy, oz, this);
    }

    public Matrix4f scaleAroundLocal(float factor, float ox, float oy, float oz) {
        return this.scaleAroundLocal(factor, factor, factor, ox, oy, oz, this);
    }

    public Matrix4f scaleAroundLocal(float factor, float ox, float oy, float oz, Matrix4f dest) {
        return this.scaleAroundLocal(factor, factor, factor, ox, oy, oz, dest);
    }

    public Matrix4f rotateX(float ang, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.rotationX(ang);
        }
        if ((this.properties & 8) != 0) {
            float x2 = this.m30();
            float y2 = this.m31();
            float z2 = this.m32();
            return dest.rotationX(ang).setTranslation(x2, y2, z2);
        }
        return this.rotateXInternal(ang, dest);
    }

    private Matrix4f rotateXInternal(float ang, Matrix4f dest) {
        float sin = Math.sin(ang);
        float cos = Math.cosFromSin(sin, ang);
        float lm10 = this.m10();
        float lm11 = this.m11();
        float lm12 = this.m12();
        float lm13 = this.m13();
        float lm20 = this.m20();
        float lm21 = this.m21();
        float lm22 = this.m22();
        float lm23 = this.m23();
        return dest._m20(Math.fma(lm10, -sin, lm20 * cos))._m21(Math.fma(lm11, -sin, lm21 * cos))._m22(Math.fma(lm12, -sin, lm22 * cos))._m23(Math.fma(lm13, -sin, lm23 * cos))._m10(Math.fma(lm10, cos, lm20 * sin))._m11(Math.fma(lm11, cos, lm21 * sin))._m12(Math.fma(lm12, cos, lm22 * sin))._m13(Math.fma(lm13, cos, lm23 * sin))._m00(this.m00())._m01(this.m01())._m02(this.m02())._m03(this.m03())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0xFFFFFFF2);
    }

    public Matrix4f rotateX(float ang) {
        return this.rotateX(ang, this);
    }

    public Matrix4f rotateY(float ang, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.rotationY(ang);
        }
        if ((this.properties & 8) != 0) {
            float x2 = this.m30();
            float y2 = this.m31();
            float z2 = this.m32();
            return dest.rotationY(ang).setTranslation(x2, y2, z2);
        }
        return this.rotateYInternal(ang, dest);
    }

    private Matrix4f rotateYInternal(float ang, Matrix4f dest) {
        float sin = Math.sin(ang);
        float cos = Math.cosFromSin(sin, ang);
        float nm00 = Math.fma(this.m00(), cos, this.m20() * -sin);
        float nm01 = Math.fma(this.m01(), cos, this.m21() * -sin);
        float nm02 = Math.fma(this.m02(), cos, this.m22() * -sin);
        float nm03 = Math.fma(this.m03(), cos, this.m23() * -sin);
        return dest._m20(Math.fma(this.m00(), sin, this.m20() * cos))._m21(Math.fma(this.m01(), sin, this.m21() * cos))._m22(Math.fma(this.m02(), sin, this.m22() * cos))._m23(Math.fma(this.m03(), sin, this.m23() * cos))._m00(nm00)._m01(nm01)._m02(nm02)._m03(nm03)._m10(this.m10())._m11(this.m11())._m12(this.m12())._m13(this.m13())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0xFFFFFFF2);
    }

    public Matrix4f rotateY(float ang) {
        return this.rotateY(ang, this);
    }

    public Matrix4f rotateZ(float ang, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.rotationZ(ang);
        }
        if ((this.properties & 8) != 0) {
            float x2 = this.m30();
            float y2 = this.m31();
            float z2 = this.m32();
            return dest.rotationZ(ang).setTranslation(x2, y2, z2);
        }
        return this.rotateZInternal(ang, dest);
    }

    private Matrix4f rotateZInternal(float ang, Matrix4f dest) {
        float sin = Math.sin(ang);
        float cos = Math.cosFromSin(sin, ang);
        return this.rotateTowardsXY(sin, cos, dest);
    }

    public Matrix4f rotateZ(float ang) {
        return this.rotateZ(ang, this);
    }

    public Matrix4f rotateTowardsXY(float dirX, float dirY) {
        return this.rotateTowardsXY(dirX, dirY, this);
    }

    public Matrix4f rotateTowardsXY(float dirX, float dirY, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.rotationTowardsXY(dirX, dirY);
        }
        float nm00 = Math.fma(this.m00(), dirY, this.m10() * dirX);
        float nm01 = Math.fma(this.m01(), dirY, this.m11() * dirX);
        float nm02 = Math.fma(this.m02(), dirY, this.m12() * dirX);
        float nm03 = Math.fma(this.m03(), dirY, this.m13() * dirX);
        return dest._m10(Math.fma(this.m00(), -dirX, this.m10() * dirY))._m11(Math.fma(this.m01(), -dirX, this.m11() * dirY))._m12(Math.fma(this.m02(), -dirX, this.m12() * dirY))._m13(Math.fma(this.m03(), -dirX, this.m13() * dirY))._m00(nm00)._m01(nm01)._m02(nm02)._m03(nm03)._m20(this.m20())._m21(this.m21())._m22(this.m22())._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0xFFFFFFF2);
    }

    public Matrix4f rotateXYZ(Vector3fc angles) {
        return this.rotateXYZ(angles.x(), angles.y(), angles.z());
    }

    public Matrix4f rotateXYZ(float angleX, float angleY, float angleZ) {
        return this.rotateXYZ(angleX, angleY, angleZ, this);
    }

    public Matrix4f rotateXYZ(float angleX, float angleY, float angleZ, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.rotationXYZ(angleX, angleY, angleZ);
        }
        if ((this.properties & 8) != 0) {
            float tx = this.m30();
            float ty = this.m31();
            float tz = this.m32();
            return dest.rotationXYZ(angleX, angleY, angleZ).setTranslation(tx, ty, tz);
        }
        if ((this.properties & 2) != 0) {
            return dest.rotateAffineXYZ(angleX, angleY, angleZ);
        }
        return this.rotateXYZInternal(angleX, angleY, angleZ, dest);
    }

    private Matrix4f rotateXYZInternal(float angleX, float angleY, float angleZ, Matrix4f dest) {
        float sinX = Math.sin(angleX);
        float cosX = Math.cosFromSin(sinX, angleX);
        float sinY = Math.sin(angleY);
        float cosY = Math.cosFromSin(sinY, angleY);
        float sinZ = Math.sin(angleZ);
        float cosZ = Math.cosFromSin(sinZ, angleZ);
        float m_sinX = -sinX;
        float m_sinY = -sinY;
        float m_sinZ = -sinZ;
        float nm10 = Math.fma(this.m10(), cosX, this.m20() * sinX);
        float nm11 = Math.fma(this.m11(), cosX, this.m21() * sinX);
        float nm12 = Math.fma(this.m12(), cosX, this.m22() * sinX);
        float nm13 = Math.fma(this.m13(), cosX, this.m23() * sinX);
        float nm20 = Math.fma(this.m10(), m_sinX, this.m20() * cosX);
        float nm21 = Math.fma(this.m11(), m_sinX, this.m21() * cosX);
        float nm22 = Math.fma(this.m12(), m_sinX, this.m22() * cosX);
        float nm23 = Math.fma(this.m13(), m_sinX, this.m23() * cosX);
        float nm00 = Math.fma(this.m00(), cosY, nm20 * m_sinY);
        float nm01 = Math.fma(this.m01(), cosY, nm21 * m_sinY);
        float nm02 = Math.fma(this.m02(), cosY, nm22 * m_sinY);
        float nm03 = Math.fma(this.m03(), cosY, nm23 * m_sinY);
        return dest._m20(Math.fma(this.m00(), sinY, nm20 * cosY))._m21(Math.fma(this.m01(), sinY, nm21 * cosY))._m22(Math.fma(this.m02(), sinY, nm22 * cosY))._m23(Math.fma(this.m03(), sinY, nm23 * cosY))._m00(Math.fma(nm00, cosZ, nm10 * sinZ))._m01(Math.fma(nm01, cosZ, nm11 * sinZ))._m02(Math.fma(nm02, cosZ, nm12 * sinZ))._m03(Math.fma(nm03, cosZ, nm13 * sinZ))._m10(Math.fma(nm00, m_sinZ, nm10 * cosZ))._m11(Math.fma(nm01, m_sinZ, nm11 * cosZ))._m12(Math.fma(nm02, m_sinZ, nm12 * cosZ))._m13(Math.fma(nm03, m_sinZ, nm13 * cosZ))._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0xFFFFFFF2);
    }

    public Matrix4f rotateAffineXYZ(float angleX, float angleY, float angleZ) {
        return this.rotateAffineXYZ(angleX, angleY, angleZ, this);
    }

    public Matrix4f rotateAffineXYZ(float angleX, float angleY, float angleZ, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.rotationXYZ(angleX, angleY, angleZ);
        }
        if ((this.properties & 8) != 0) {
            float tx = this.m30();
            float ty = this.m31();
            float tz = this.m32();
            return dest.rotationXYZ(angleX, angleY, angleZ).setTranslation(tx, ty, tz);
        }
        return this.rotateAffineXYZInternal(angleX, angleY, angleZ, dest);
    }

    private Matrix4f rotateAffineXYZInternal(float angleX, float angleY, float angleZ, Matrix4f dest) {
        float sinX = Math.sin(angleX);
        float cosX = Math.cosFromSin(sinX, angleX);
        float sinY = Math.sin(angleY);
        float cosY = Math.cosFromSin(sinY, angleY);
        float sinZ = Math.sin(angleZ);
        float cosZ = Math.cosFromSin(sinZ, angleZ);
        float m_sinX = -sinX;
        float m_sinY = -sinY;
        float m_sinZ = -sinZ;
        float nm10 = Math.fma(this.m10(), cosX, this.m20() * sinX);
        float nm11 = Math.fma(this.m11(), cosX, this.m21() * sinX);
        float nm12 = Math.fma(this.m12(), cosX, this.m22() * sinX);
        float nm20 = Math.fma(this.m10(), m_sinX, this.m20() * cosX);
        float nm21 = Math.fma(this.m11(), m_sinX, this.m21() * cosX);
        float nm22 = Math.fma(this.m12(), m_sinX, this.m22() * cosX);
        float nm00 = Math.fma(this.m00(), cosY, nm20 * m_sinY);
        float nm01 = Math.fma(this.m01(), cosY, nm21 * m_sinY);
        float nm02 = Math.fma(this.m02(), cosY, nm22 * m_sinY);
        return dest._m20(Math.fma(this.m00(), sinY, nm20 * cosY))._m21(Math.fma(this.m01(), sinY, nm21 * cosY))._m22(Math.fma(this.m02(), sinY, nm22 * cosY))._m23(0.0f)._m00(Math.fma(nm00, cosZ, nm10 * sinZ))._m01(Math.fma(nm01, cosZ, nm11 * sinZ))._m02(Math.fma(nm02, cosZ, nm12 * sinZ))._m03(0.0f)._m10(Math.fma(nm00, m_sinZ, nm10 * cosZ))._m11(Math.fma(nm01, m_sinZ, nm11 * cosZ))._m12(Math.fma(nm02, m_sinZ, nm12 * cosZ))._m13(0.0f)._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0xFFFFFFF2);
    }

    public Matrix4f rotateZYX(Vector3f angles) {
        return this.rotateZYX(angles.z, angles.y, angles.x);
    }

    public Matrix4f rotateZYX(float angleZ, float angleY, float angleX) {
        return this.rotateZYX(angleZ, angleY, angleX, this);
    }

    public Matrix4f rotateZYX(float angleZ, float angleY, float angleX, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.rotationZYX(angleZ, angleY, angleX);
        }
        if ((this.properties & 8) != 0) {
            float tx = this.m30();
            float ty = this.m31();
            float tz = this.m32();
            return dest.rotationZYX(angleZ, angleY, angleX).setTranslation(tx, ty, tz);
        }
        if ((this.properties & 2) != 0) {
            return dest.rotateAffineZYX(angleZ, angleY, angleX);
        }
        return this.rotateZYXInternal(angleZ, angleY, angleX, dest);
    }

    private Matrix4f rotateZYXInternal(float angleZ, float angleY, float angleX, Matrix4f dest) {
        float sinX = Math.sin(angleX);
        float cosX = Math.cosFromSin(sinX, angleX);
        float sinY = Math.sin(angleY);
        float cosY = Math.cosFromSin(sinY, angleY);
        float sinZ = Math.sin(angleZ);
        float cosZ = Math.cosFromSin(sinZ, angleZ);
        float m_sinZ = -sinZ;
        float m_sinY = -sinY;
        float m_sinX = -sinX;
        float nm00 = this.m00() * cosZ + this.m10() * sinZ;
        float nm01 = this.m01() * cosZ + this.m11() * sinZ;
        float nm02 = this.m02() * cosZ + this.m12() * sinZ;
        float nm03 = this.m03() * cosZ + this.m13() * sinZ;
        float nm10 = this.m00() * m_sinZ + this.m10() * cosZ;
        float nm11 = this.m01() * m_sinZ + this.m11() * cosZ;
        float nm12 = this.m02() * m_sinZ + this.m12() * cosZ;
        float nm13 = this.m03() * m_sinZ + this.m13() * cosZ;
        float nm20 = nm00 * sinY + this.m20() * cosY;
        float nm21 = nm01 * sinY + this.m21() * cosY;
        float nm22 = nm02 * sinY + this.m22() * cosY;
        float nm23 = nm03 * sinY + this.m23() * cosY;
        return dest._m00(nm00 * cosY + this.m20() * m_sinY)._m01(nm01 * cosY + this.m21() * m_sinY)._m02(nm02 * cosY + this.m22() * m_sinY)._m03(nm03 * cosY + this.m23() * m_sinY)._m10(nm10 * cosX + nm20 * sinX)._m11(nm11 * cosX + nm21 * sinX)._m12(nm12 * cosX + nm22 * sinX)._m13(nm13 * cosX + nm23 * sinX)._m20(nm10 * m_sinX + nm20 * cosX)._m21(nm11 * m_sinX + nm21 * cosX)._m22(nm12 * m_sinX + nm22 * cosX)._m23(nm13 * m_sinX + nm23 * cosX)._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0xFFFFFFF2);
    }

    public Matrix4f rotateAffineZYX(float angleZ, float angleY, float angleX) {
        return this.rotateAffineZYX(angleZ, angleY, angleX, this);
    }

    public Matrix4f rotateAffineZYX(float angleZ, float angleY, float angleX, Matrix4f dest) {
        float sinX = Math.sin(angleX);
        float cosX = Math.cosFromSin(sinX, angleX);
        float sinY = Math.sin(angleY);
        float cosY = Math.cosFromSin(sinY, angleY);
        float sinZ = Math.sin(angleZ);
        float cosZ = Math.cosFromSin(sinZ, angleZ);
        float m_sinZ = -sinZ;
        float m_sinY = -sinY;
        float m_sinX = -sinX;
        float nm00 = this.m00() * cosZ + this.m10() * sinZ;
        float nm01 = this.m01() * cosZ + this.m11() * sinZ;
        float nm02 = this.m02() * cosZ + this.m12() * sinZ;
        float nm10 = this.m00() * m_sinZ + this.m10() * cosZ;
        float nm11 = this.m01() * m_sinZ + this.m11() * cosZ;
        float nm12 = this.m02() * m_sinZ + this.m12() * cosZ;
        float nm20 = nm00 * sinY + this.m20() * cosY;
        float nm21 = nm01 * sinY + this.m21() * cosY;
        float nm22 = nm02 * sinY + this.m22() * cosY;
        return dest._m00(nm00 * cosY + this.m20() * m_sinY)._m01(nm01 * cosY + this.m21() * m_sinY)._m02(nm02 * cosY + this.m22() * m_sinY)._m03(0.0f)._m10(nm10 * cosX + nm20 * sinX)._m11(nm11 * cosX + nm21 * sinX)._m12(nm12 * cosX + nm22 * sinX)._m13(0.0f)._m20(nm10 * m_sinX + nm20 * cosX)._m21(nm11 * m_sinX + nm21 * cosX)._m22(nm12 * m_sinX + nm22 * cosX)._m23(0.0f)._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0xFFFFFFF2);
    }

    public Matrix4f rotateYXZ(Vector3f angles) {
        return this.rotateYXZ(angles.y, angles.x, angles.z);
    }

    public Matrix4f rotateYXZ(float angleY, float angleX, float angleZ) {
        return this.rotateYXZ(angleY, angleX, angleZ, this);
    }

    public Matrix4f rotateYXZ(float angleY, float angleX, float angleZ, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.rotationYXZ(angleY, angleX, angleZ);
        }
        if ((this.properties & 8) != 0) {
            float tx = this.m30();
            float ty = this.m31();
            float tz = this.m32();
            return dest.rotationYXZ(angleY, angleX, angleZ).setTranslation(tx, ty, tz);
        }
        if ((this.properties & 2) != 0) {
            return dest.rotateAffineYXZ(angleY, angleX, angleZ);
        }
        return this.rotateYXZInternal(angleY, angleX, angleZ, dest);
    }

    private Matrix4f rotateYXZInternal(float angleY, float angleX, float angleZ, Matrix4f dest) {
        float sinX = Math.sin(angleX);
        float cosX = Math.cosFromSin(sinX, angleX);
        float sinY = Math.sin(angleY);
        float cosY = Math.cosFromSin(sinY, angleY);
        float sinZ = Math.sin(angleZ);
        float cosZ = Math.cosFromSin(sinZ, angleZ);
        float m_sinY = -sinY;
        float m_sinX = -sinX;
        float m_sinZ = -sinZ;
        float nm20 = this.m00() * sinY + this.m20() * cosY;
        float nm21 = this.m01() * sinY + this.m21() * cosY;
        float nm22 = this.m02() * sinY + this.m22() * cosY;
        float nm23 = this.m03() * sinY + this.m23() * cosY;
        float nm00 = this.m00() * cosY + this.m20() * m_sinY;
        float nm01 = this.m01() * cosY + this.m21() * m_sinY;
        float nm02 = this.m02() * cosY + this.m22() * m_sinY;
        float nm03 = this.m03() * cosY + this.m23() * m_sinY;
        float nm10 = this.m10() * cosX + nm20 * sinX;
        float nm11 = this.m11() * cosX + nm21 * sinX;
        float nm12 = this.m12() * cosX + nm22 * sinX;
        float nm13 = this.m13() * cosX + nm23 * sinX;
        return dest._m20(this.m10() * m_sinX + nm20 * cosX)._m21(this.m11() * m_sinX + nm21 * cosX)._m22(this.m12() * m_sinX + nm22 * cosX)._m23(this.m13() * m_sinX + nm23 * cosX)._m00(nm00 * cosZ + nm10 * sinZ)._m01(nm01 * cosZ + nm11 * sinZ)._m02(nm02 * cosZ + nm12 * sinZ)._m03(nm03 * cosZ + nm13 * sinZ)._m10(nm00 * m_sinZ + nm10 * cosZ)._m11(nm01 * m_sinZ + nm11 * cosZ)._m12(nm02 * m_sinZ + nm12 * cosZ)._m13(nm03 * m_sinZ + nm13 * cosZ)._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0xFFFFFFF2);
    }

    public Matrix4f rotateAffineYXZ(float angleY, float angleX, float angleZ) {
        return this.rotateAffineYXZ(angleY, angleX, angleZ, this);
    }

    public Matrix4f rotateAffineYXZ(float angleY, float angleX, float angleZ, Matrix4f dest) {
        float sinX = Math.sin(angleX);
        float cosX = Math.cosFromSin(sinX, angleX);
        float sinY = Math.sin(angleY);
        float cosY = Math.cosFromSin(sinY, angleY);
        float sinZ = Math.sin(angleZ);
        float cosZ = Math.cosFromSin(sinZ, angleZ);
        float m_sinY = -sinY;
        float m_sinX = -sinX;
        float m_sinZ = -sinZ;
        float nm20 = this.m00() * sinY + this.m20() * cosY;
        float nm21 = this.m01() * sinY + this.m21() * cosY;
        float nm22 = this.m02() * sinY + this.m22() * cosY;
        float nm00 = this.m00() * cosY + this.m20() * m_sinY;
        float nm01 = this.m01() * cosY + this.m21() * m_sinY;
        float nm02 = this.m02() * cosY + this.m22() * m_sinY;
        float nm10 = this.m10() * cosX + nm20 * sinX;
        float nm11 = this.m11() * cosX + nm21 * sinX;
        float nm12 = this.m12() * cosX + nm22 * sinX;
        return dest._m20(this.m10() * m_sinX + nm20 * cosX)._m21(this.m11() * m_sinX + nm21 * cosX)._m22(this.m12() * m_sinX + nm22 * cosX)._m23(0.0f)._m00(nm00 * cosZ + nm10 * sinZ)._m01(nm01 * cosZ + nm11 * sinZ)._m02(nm02 * cosZ + nm12 * sinZ)._m03(0.0f)._m10(nm00 * m_sinZ + nm10 * cosZ)._m11(nm01 * m_sinZ + nm11 * cosZ)._m12(nm02 * m_sinZ + nm12 * cosZ)._m13(0.0f)._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0xFFFFFFF2);
    }

    public Matrix4f rotate(float ang, float x2, float y2, float z2, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.rotation(ang, x2, y2, z2);
        }
        if ((this.properties & 8) != 0) {
            return this.rotateTranslation(ang, x2, y2, z2, dest);
        }
        if ((this.properties & 2) != 0) {
            return this.rotateAffine(ang, x2, y2, z2, dest);
        }
        return this.rotateGeneric(ang, x2, y2, z2, dest);
    }

    private Matrix4f rotateGeneric(float ang, float x2, float y2, float z2, Matrix4f dest) {
        if (y2 == 0.0f && z2 == 0.0f && Math.absEqualsOne(x2)) {
            return this.rotateX(x2 * ang, dest);
        }
        if (x2 == 0.0f && z2 == 0.0f && Math.absEqualsOne(y2)) {
            return this.rotateY(y2 * ang, dest);
        }
        if (x2 == 0.0f && y2 == 0.0f && Math.absEqualsOne(z2)) {
            return this.rotateZ(z2 * ang, dest);
        }
        return this.rotateGenericInternal(ang, x2, y2, z2, dest);
    }

    private Matrix4f rotateGenericInternal(float ang, float x2, float y2, float z2, Matrix4f dest) {
        float s2 = Math.sin(ang);
        float c2 = Math.cosFromSin(s2, ang);
        float C = 1.0f - c2;
        float xx = x2 * x2;
        float xy = x2 * y2;
        float xz = x2 * z2;
        float yy = y2 * y2;
        float yz = y2 * z2;
        float zz = z2 * z2;
        float rm00 = xx * C + c2;
        float rm01 = xy * C + z2 * s2;
        float rm02 = xz * C - y2 * s2;
        float rm10 = xy * C - z2 * s2;
        float rm11 = yy * C + c2;
        float rm12 = yz * C + x2 * s2;
        float rm20 = xz * C + y2 * s2;
        float rm21 = yz * C - x2 * s2;
        float rm22 = zz * C + c2;
        float nm00 = this.m00() * rm00 + this.m10() * rm01 + this.m20() * rm02;
        float nm01 = this.m01() * rm00 + this.m11() * rm01 + this.m21() * rm02;
        float nm02 = this.m02() * rm00 + this.m12() * rm01 + this.m22() * rm02;
        float nm03 = this.m03() * rm00 + this.m13() * rm01 + this.m23() * rm02;
        float nm10 = this.m00() * rm10 + this.m10() * rm11 + this.m20() * rm12;
        float nm11 = this.m01() * rm10 + this.m11() * rm11 + this.m21() * rm12;
        float nm12 = this.m02() * rm10 + this.m12() * rm11 + this.m22() * rm12;
        float nm13 = this.m03() * rm10 + this.m13() * rm11 + this.m23() * rm12;
        return dest._m20(this.m00() * rm20 + this.m10() * rm21 + this.m20() * rm22)._m21(this.m01() * rm20 + this.m11() * rm21 + this.m21() * rm22)._m22(this.m02() * rm20 + this.m12() * rm21 + this.m22() * rm22)._m23(this.m03() * rm20 + this.m13() * rm21 + this.m23() * rm22)._m00(nm00)._m01(nm01)._m02(nm02)._m03(nm03)._m10(nm10)._m11(nm11)._m12(nm12)._m13(nm13)._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0xFFFFFFF2);
    }

    public Matrix4f rotate(float ang, float x2, float y2, float z2) {
        return this.rotate(ang, x2, y2, z2, this);
    }

    public Matrix4f rotateTranslation(float ang, float x2, float y2, float z2, Matrix4f dest) {
        float tx = this.m30();
        float ty = this.m31();
        float tz = this.m32();
        if (y2 == 0.0f && z2 == 0.0f && Math.absEqualsOne(x2)) {
            return dest.rotationX(x2 * ang).setTranslation(tx, ty, tz);
        }
        if (x2 == 0.0f && z2 == 0.0f && Math.absEqualsOne(y2)) {
            return dest.rotationY(y2 * ang).setTranslation(tx, ty, tz);
        }
        if (x2 == 0.0f && y2 == 0.0f && Math.absEqualsOne(z2)) {
            return dest.rotationZ(z2 * ang).setTranslation(tx, ty, tz);
        }
        return this.rotateTranslationInternal(ang, x2, y2, z2, dest);
    }

    private Matrix4f rotateTranslationInternal(float ang, float x2, float y2, float z2, Matrix4f dest) {
        float s2 = Math.sin(ang);
        float c2 = Math.cosFromSin(s2, ang);
        float C = 1.0f - c2;
        float xx = x2 * x2;
        float xy = x2 * y2;
        float xz = x2 * z2;
        float yy = y2 * y2;
        float yz = y2 * z2;
        float zz = z2 * z2;
        float rm00 = xx * C + c2;
        float rm01 = xy * C + z2 * s2;
        float rm02 = xz * C - y2 * s2;
        float rm10 = xy * C - z2 * s2;
        float rm11 = yy * C + c2;
        float rm12 = yz * C + x2 * s2;
        float rm20 = xz * C + y2 * s2;
        float rm21 = yz * C - x2 * s2;
        float rm22 = zz * C + c2;
        return dest._m20(rm20)._m21(rm21)._m22(rm22)._m23(0.0f)._m00(rm00)._m01(rm01)._m02(rm02)._m03(0.0f)._m10(rm10)._m11(rm11)._m12(rm12)._m13(0.0f)._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(1.0f)._properties(this.properties & 0xFFFFFFF2);
    }

    public Matrix4f rotateAffine(float ang, float x2, float y2, float z2, Matrix4f dest) {
        if (y2 == 0.0f && z2 == 0.0f && Math.absEqualsOne(x2)) {
            return this.rotateX(x2 * ang, dest);
        }
        if (x2 == 0.0f && z2 == 0.0f && Math.absEqualsOne(y2)) {
            return this.rotateY(y2 * ang, dest);
        }
        if (x2 == 0.0f && y2 == 0.0f && Math.absEqualsOne(z2)) {
            return this.rotateZ(z2 * ang, dest);
        }
        return this.rotateAffineInternal(ang, x2, y2, z2, dest);
    }

    private Matrix4f rotateAffineInternal(float ang, float x2, float y2, float z2, Matrix4f dest) {
        float s2 = Math.sin(ang);
        float c2 = Math.cosFromSin(s2, ang);
        float C = 1.0f - c2;
        float xx = x2 * x2;
        float xy = x2 * y2;
        float xz = x2 * z2;
        float yy = y2 * y2;
        float yz = y2 * z2;
        float zz = z2 * z2;
        float rm00 = xx * C + c2;
        float rm01 = xy * C + z2 * s2;
        float rm02 = xz * C - y2 * s2;
        float rm10 = xy * C - z2 * s2;
        float rm11 = yy * C + c2;
        float rm12 = yz * C + x2 * s2;
        float rm20 = xz * C + y2 * s2;
        float rm21 = yz * C - x2 * s2;
        float rm22 = zz * C + c2;
        float nm00 = this.m00() * rm00 + this.m10() * rm01 + this.m20() * rm02;
        float nm01 = this.m01() * rm00 + this.m11() * rm01 + this.m21() * rm02;
        float nm02 = this.m02() * rm00 + this.m12() * rm01 + this.m22() * rm02;
        float nm10 = this.m00() * rm10 + this.m10() * rm11 + this.m20() * rm12;
        float nm11 = this.m01() * rm10 + this.m11() * rm11 + this.m21() * rm12;
        float nm12 = this.m02() * rm10 + this.m12() * rm11 + this.m22() * rm12;
        return dest._m20(this.m00() * rm20 + this.m10() * rm21 + this.m20() * rm22)._m21(this.m01() * rm20 + this.m11() * rm21 + this.m21() * rm22)._m22(this.m02() * rm20 + this.m12() * rm21 + this.m22() * rm22)._m23(0.0f)._m00(nm00)._m01(nm01)._m02(nm02)._m03(0.0f)._m10(nm10)._m11(nm11)._m12(nm12)._m13(0.0f)._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(1.0f)._properties(this.properties & 0xFFFFFFF2);
    }

    public Matrix4f rotateAffine(float ang, float x2, float y2, float z2) {
        return this.rotateAffine(ang, x2, y2, z2, this);
    }

    public Matrix4f rotateLocal(float ang, float x2, float y2, float z2, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.rotation(ang, x2, y2, z2);
        }
        return this.rotateLocalGeneric(ang, x2, y2, z2, dest);
    }

    private Matrix4f rotateLocalGeneric(float ang, float x2, float y2, float z2, Matrix4f dest) {
        if (y2 == 0.0f && z2 == 0.0f && Math.absEqualsOne(x2)) {
            return this.rotateLocalX(x2 * ang, dest);
        }
        if (x2 == 0.0f && z2 == 0.0f && Math.absEqualsOne(y2)) {
            return this.rotateLocalY(y2 * ang, dest);
        }
        if (x2 == 0.0f && y2 == 0.0f && Math.absEqualsOne(z2)) {
            return this.rotateLocalZ(z2 * ang, dest);
        }
        return this.rotateLocalGenericInternal(ang, x2, y2, z2, dest);
    }

    private Matrix4f rotateLocalGenericInternal(float ang, float x2, float y2, float z2, Matrix4f dest) {
        float s2 = Math.sin(ang);
        float c2 = Math.cosFromSin(s2, ang);
        float C = 1.0f - c2;
        float xx = x2 * x2;
        float xy = x2 * y2;
        float xz = x2 * z2;
        float yy = y2 * y2;
        float yz = y2 * z2;
        float zz = z2 * z2;
        float lm00 = xx * C + c2;
        float lm01 = xy * C + z2 * s2;
        float lm02 = xz * C - y2 * s2;
        float lm10 = xy * C - z2 * s2;
        float lm11 = yy * C + c2;
        float lm12 = yz * C + x2 * s2;
        float lm20 = xz * C + y2 * s2;
        float lm21 = yz * C - x2 * s2;
        float lm22 = zz * C + c2;
        float nm00 = lm00 * this.m00() + lm10 * this.m01() + lm20 * this.m02();
        float nm01 = lm01 * this.m00() + lm11 * this.m01() + lm21 * this.m02();
        float nm02 = lm02 * this.m00() + lm12 * this.m01() + lm22 * this.m02();
        float nm10 = lm00 * this.m10() + lm10 * this.m11() + lm20 * this.m12();
        float nm11 = lm01 * this.m10() + lm11 * this.m11() + lm21 * this.m12();
        float nm12 = lm02 * this.m10() + lm12 * this.m11() + lm22 * this.m12();
        float nm20 = lm00 * this.m20() + lm10 * this.m21() + lm20 * this.m22();
        float nm21 = lm01 * this.m20() + lm11 * this.m21() + lm21 * this.m22();
        float nm22 = lm02 * this.m20() + lm12 * this.m21() + lm22 * this.m22();
        float nm30 = lm00 * this.m30() + lm10 * this.m31() + lm20 * this.m32();
        float nm31 = lm01 * this.m30() + lm11 * this.m31() + lm21 * this.m32();
        float nm32 = lm02 * this.m30() + lm12 * this.m31() + lm22 * this.m32();
        return dest._m00(nm00)._m01(nm01)._m02(nm02)._m03(this.m03())._m10(nm10)._m11(nm11)._m12(nm12)._m13(this.m13())._m20(nm20)._m21(nm21)._m22(nm22)._m23(this.m23())._m30(nm30)._m31(nm31)._m32(nm32)._m33(this.m33())._properties(this.properties & 0xFFFFFFF2);
    }

    public Matrix4f rotateLocal(float ang, float x2, float y2, float z2) {
        return this.rotateLocal(ang, x2, y2, z2, this);
    }

    public Matrix4f rotateLocalX(float ang, Matrix4f dest) {
        float sin = Math.sin(ang);
        float cos = Math.cosFromSin(sin, ang);
        float nm02 = sin * this.m01() + cos * this.m02();
        float nm12 = sin * this.m11() + cos * this.m12();
        float nm22 = sin * this.m21() + cos * this.m22();
        float nm32 = sin * this.m31() + cos * this.m32();
        return dest._m00(this.m00())._m01(cos * this.m01() - sin * this.m02())._m02(nm02)._m03(this.m03())._m10(this.m10())._m11(cos * this.m11() - sin * this.m12())._m12(nm12)._m13(this.m13())._m20(this.m20())._m21(cos * this.m21() - sin * this.m22())._m22(nm22)._m23(this.m23())._m30(this.m30())._m31(cos * this.m31() - sin * this.m32())._m32(nm32)._m33(this.m33())._properties(this.properties & 0xFFFFFFF2);
    }

    public Matrix4f rotateLocalX(float ang) {
        return this.rotateLocalX(ang, this);
    }

    public Matrix4f rotateLocalY(float ang, Matrix4f dest) {
        float sin = Math.sin(ang);
        float cos = Math.cosFromSin(sin, ang);
        float nm02 = -sin * this.m00() + cos * this.m02();
        float nm12 = -sin * this.m10() + cos * this.m12();
        float nm22 = -sin * this.m20() + cos * this.m22();
        float nm32 = -sin * this.m30() + cos * this.m32();
        return dest._m00(cos * this.m00() + sin * this.m02())._m01(this.m01())._m02(nm02)._m03(this.m03())._m10(cos * this.m10() + sin * this.m12())._m11(this.m11())._m12(nm12)._m13(this.m13())._m20(cos * this.m20() + sin * this.m22())._m21(this.m21())._m22(nm22)._m23(this.m23())._m30(cos * this.m30() + sin * this.m32())._m31(this.m31())._m32(nm32)._m33(this.m33())._properties(this.properties & 0xFFFFFFF2);
    }

    public Matrix4f rotateLocalY(float ang) {
        return this.rotateLocalY(ang, this);
    }

    public Matrix4f rotateLocalZ(float ang, Matrix4f dest) {
        float sin = Math.sin(ang);
        float cos = Math.cosFromSin(sin, ang);
        float nm01 = sin * this.m00() + cos * this.m01();
        float nm11 = sin * this.m10() + cos * this.m11();
        float nm21 = sin * this.m20() + cos * this.m21();
        float nm31 = sin * this.m30() + cos * this.m31();
        return dest._m00(cos * this.m00() - sin * this.m01())._m01(nm01)._m02(this.m02())._m03(this.m03())._m10(cos * this.m10() - sin * this.m11())._m11(nm11)._m12(this.m12())._m13(this.m13())._m20(cos * this.m20() - sin * this.m21())._m21(nm21)._m22(this.m22())._m23(this.m23())._m30(cos * this.m30() - sin * this.m31())._m31(nm31)._m32(this.m32())._m33(this.m33())._properties(this.properties & 0xFFFFFFF2);
    }

    public Matrix4f rotateLocalZ(float ang) {
        return this.rotateLocalZ(ang, this);
    }

    public Matrix4f translate(Vector3fc offset) {
        return this.translate(offset.x(), offset.y(), offset.z());
    }

    public Matrix4f translate(Vector3fc offset, Matrix4f dest) {
        return this.translate(offset.x(), offset.y(), offset.z(), dest);
    }

    public Matrix4f translate(float x2, float y2, float z2, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.translation(x2, y2, z2);
        }
        return this.translateGeneric(x2, y2, z2, dest);
    }

    private Matrix4f translateGeneric(float x2, float y2, float z2, Matrix4f dest) {
        MemUtil.INSTANCE.copy(this, dest);
        return dest._m30(Math.fma(this.m00(), x2, Math.fma(this.m10(), y2, Math.fma(this.m20(), z2, this.m30()))))._m31(Math.fma(this.m01(), x2, Math.fma(this.m11(), y2, Math.fma(this.m21(), z2, this.m31()))))._m32(Math.fma(this.m02(), x2, Math.fma(this.m12(), y2, Math.fma(this.m22(), z2, this.m32()))))._m33(Math.fma(this.m03(), x2, Math.fma(this.m13(), y2, Math.fma(this.m23(), z2, this.m33()))))._properties(this.properties & 0xFFFFFFFA);
    }

    public Matrix4f translate(float x2, float y2, float z2) {
        if ((this.properties & 4) != 0) {
            return this.translation(x2, y2, z2);
        }
        return this.translateGeneric(x2, y2, z2);
    }

    private Matrix4f translateGeneric(float x2, float y2, float z2) {
        return this._m30(Math.fma(this.m00(), x2, Math.fma(this.m10(), y2, Math.fma(this.m20(), z2, this.m30()))))._m31(Math.fma(this.m01(), x2, Math.fma(this.m11(), y2, Math.fma(this.m21(), z2, this.m31()))))._m32(Math.fma(this.m02(), x2, Math.fma(this.m12(), y2, Math.fma(this.m22(), z2, this.m32()))))._m33(Math.fma(this.m03(), x2, Math.fma(this.m13(), y2, Math.fma(this.m23(), z2, this.m33()))))._properties(this.properties & 0xFFFFFFFA);
    }

    public Matrix4f translateLocal(Vector3fc offset) {
        return this.translateLocal(offset.x(), offset.y(), offset.z());
    }

    public Matrix4f translateLocal(Vector3fc offset, Matrix4f dest) {
        return this.translateLocal(offset.x(), offset.y(), offset.z(), dest);
    }

    public Matrix4f translateLocal(float x2, float y2, float z2, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.translation(x2, y2, z2);
        }
        return this.translateLocalGeneric(x2, y2, z2, dest);
    }

    private Matrix4f translateLocalGeneric(float x2, float y2, float z2, Matrix4f dest) {
        float nm00 = this.m00() + x2 * this.m03();
        float nm01 = this.m01() + y2 * this.m03();
        float nm02 = this.m02() + z2 * this.m03();
        float nm10 = this.m10() + x2 * this.m13();
        float nm11 = this.m11() + y2 * this.m13();
        float nm12 = this.m12() + z2 * this.m13();
        float nm20 = this.m20() + x2 * this.m23();
        float nm21 = this.m21() + y2 * this.m23();
        float nm22 = this.m22() + z2 * this.m23();
        float nm30 = this.m30() + x2 * this.m33();
        float nm31 = this.m31() + y2 * this.m33();
        float nm32 = this.m32() + z2 * this.m33();
        return dest._m00(nm00)._m01(nm01)._m02(nm02)._m03(this.m03())._m10(nm10)._m11(nm11)._m12(nm12)._m13(this.m13())._m20(nm20)._m21(nm21)._m22(nm22)._m23(this.m23())._m30(nm30)._m31(nm31)._m32(nm32)._m33(this.m33())._properties(this.properties & 0xFFFFFFFA);
    }

    public Matrix4f translateLocal(float x2, float y2, float z2) {
        return this.translateLocal(x2, y2, z2, this);
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeFloat(this.m00());
        out.writeFloat(this.m01());
        out.writeFloat(this.m02());
        out.writeFloat(this.m03());
        out.writeFloat(this.m10());
        out.writeFloat(this.m11());
        out.writeFloat(this.m12());
        out.writeFloat(this.m13());
        out.writeFloat(this.m20());
        out.writeFloat(this.m21());
        out.writeFloat(this.m22());
        out.writeFloat(this.m23());
        out.writeFloat(this.m30());
        out.writeFloat(this.m31());
        out.writeFloat(this.m32());
        out.writeFloat(this.m33());
    }

    public void readExternal(ObjectInput in) throws IOException {
        this._m00(in.readFloat())._m01(in.readFloat())._m02(in.readFloat())._m03(in.readFloat())._m10(in.readFloat())._m11(in.readFloat())._m12(in.readFloat())._m13(in.readFloat())._m20(in.readFloat())._m21(in.readFloat())._m22(in.readFloat())._m23(in.readFloat())._m30(in.readFloat())._m31(in.readFloat())._m32(in.readFloat())._m33(in.readFloat()).determineProperties();
    }

    public Matrix4f ortho(float left, float right, float bottom, float top, float zNear, float zFar, boolean zZeroToOne, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.setOrtho(left, right, bottom, top, zNear, zFar, zZeroToOne);
        }
        return this.orthoGeneric(left, right, bottom, top, zNear, zFar, zZeroToOne, dest);
    }

    private Matrix4f orthoGeneric(float left, float right, float bottom, float top, float zNear, float zFar, boolean zZeroToOne, Matrix4f dest) {
        float rm00 = 2.0f / (right - left);
        float rm11 = 2.0f / (top - bottom);
        float rm22 = (zZeroToOne ? 1.0f : 2.0f) / (zNear - zFar);
        float rm30 = (left + right) / (left - right);
        float rm31 = (top + bottom) / (bottom - top);
        float rm32 = (zZeroToOne ? zNear : zFar + zNear) / (zNear - zFar);
        dest._m30(this.m00() * rm30 + this.m10() * rm31 + this.m20() * rm32 + this.m30())._m31(this.m01() * rm30 + this.m11() * rm31 + this.m21() * rm32 + this.m31())._m32(this.m02() * rm30 + this.m12() * rm31 + this.m22() * rm32 + this.m32())._m33(this.m03() * rm30 + this.m13() * rm31 + this.m23() * rm32 + this.m33())._m00(this.m00() * rm00)._m01(this.m01() * rm00)._m02(this.m02() * rm00)._m03(this.m03() * rm00)._m10(this.m10() * rm11)._m11(this.m11() * rm11)._m12(this.m12() * rm11)._m13(this.m13() * rm11)._m20(this.m20() * rm22)._m21(this.m21() * rm22)._m22(this.m22() * rm22)._m23(this.m23() * rm22)._properties(this.properties & 0xFFFFFFE2);
        return dest;
    }

    public Matrix4f ortho(float left, float right, float bottom, float top, float zNear, float zFar, Matrix4f dest) {
        return this.ortho(left, right, bottom, top, zNear, zFar, false, dest);
    }

    public Matrix4f ortho(float left, float right, float bottom, float top, float zNear, float zFar, boolean zZeroToOne) {
        return this.ortho(left, right, bottom, top, zNear, zFar, zZeroToOne, this);
    }

    public Matrix4f ortho(float left, float right, float bottom, float top, float zNear, float zFar) {
        return this.ortho(left, right, bottom, top, zNear, zFar, false);
    }

    public Matrix4f orthoLH(float left, float right, float bottom, float top, float zNear, float zFar, boolean zZeroToOne, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.setOrthoLH(left, right, bottom, top, zNear, zFar, zZeroToOne);
        }
        return this.orthoLHGeneric(left, right, bottom, top, zNear, zFar, zZeroToOne, dest);
    }

    private Matrix4f orthoLHGeneric(float left, float right, float bottom, float top, float zNear, float zFar, boolean zZeroToOne, Matrix4f dest) {
        float rm00 = 2.0f / (right - left);
        float rm11 = 2.0f / (top - bottom);
        float rm22 = (zZeroToOne ? 1.0f : 2.0f) / (zFar - zNear);
        float rm30 = (left + right) / (left - right);
        float rm31 = (top + bottom) / (bottom - top);
        float rm32 = (zZeroToOne ? zNear : zFar + zNear) / (zNear - zFar);
        dest._m30(this.m00() * rm30 + this.m10() * rm31 + this.m20() * rm32 + this.m30())._m31(this.m01() * rm30 + this.m11() * rm31 + this.m21() * rm32 + this.m31())._m32(this.m02() * rm30 + this.m12() * rm31 + this.m22() * rm32 + this.m32())._m33(this.m03() * rm30 + this.m13() * rm31 + this.m23() * rm32 + this.m33())._m00(this.m00() * rm00)._m01(this.m01() * rm00)._m02(this.m02() * rm00)._m03(this.m03() * rm00)._m10(this.m10() * rm11)._m11(this.m11() * rm11)._m12(this.m12() * rm11)._m13(this.m13() * rm11)._m20(this.m20() * rm22)._m21(this.m21() * rm22)._m22(this.m22() * rm22)._m23(this.m23() * rm22)._properties(this.properties & 0xFFFFFFE2);
        return dest;
    }

    public Matrix4f orthoLH(float left, float right, float bottom, float top, float zNear, float zFar, Matrix4f dest) {
        return this.orthoLH(left, right, bottom, top, zNear, zFar, false, dest);
    }

    public Matrix4f orthoLH(float left, float right, float bottom, float top, float zNear, float zFar, boolean zZeroToOne) {
        return this.orthoLH(left, right, bottom, top, zNear, zFar, zZeroToOne, this);
    }

    public Matrix4f orthoLH(float left, float right, float bottom, float top, float zNear, float zFar) {
        return this.orthoLH(left, right, bottom, top, zNear, zFar, false);
    }

    public Matrix4f setOrtho(float left, float right, float bottom, float top, float zNear, float zFar, boolean zZeroToOne) {
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        this._m00(2.0f / (right - left))._m11(2.0f / (top - bottom))._m22((zZeroToOne ? 1.0f : 2.0f) / (zNear - zFar))._m30((right + left) / (left - right))._m31((top + bottom) / (bottom - top))._m32((zZeroToOne ? zNear : zFar + zNear) / (zNear - zFar))._properties(2);
        return this;
    }

    public Matrix4f setOrtho(float left, float right, float bottom, float top, float zNear, float zFar) {
        return this.setOrtho(left, right, bottom, top, zNear, zFar, false);
    }

    public Matrix4f setOrthoLH(float left, float right, float bottom, float top, float zNear, float zFar, boolean zZeroToOne) {
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        this._m00(2.0f / (right - left))._m11(2.0f / (top - bottom))._m22((zZeroToOne ? 1.0f : 2.0f) / (zFar - zNear))._m30((right + left) / (left - right))._m31((top + bottom) / (bottom - top))._m32((zZeroToOne ? zNear : zFar + zNear) / (zNear - zFar))._properties(2);
        return this;
    }

    public Matrix4f setOrthoLH(float left, float right, float bottom, float top, float zNear, float zFar) {
        return this.setOrthoLH(left, right, bottom, top, zNear, zFar, false);
    }

    public Matrix4f orthoSymmetric(float width, float height, float zNear, float zFar, boolean zZeroToOne, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.setOrthoSymmetric(width, height, zNear, zFar, zZeroToOne);
        }
        return this.orthoSymmetricGeneric(width, height, zNear, zFar, zZeroToOne, dest);
    }

    private Matrix4f orthoSymmetricGeneric(float width, float height, float zNear, float zFar, boolean zZeroToOne, Matrix4f dest) {
        float rm00 = 2.0f / width;
        float rm11 = 2.0f / height;
        float rm22 = (zZeroToOne ? 1.0f : 2.0f) / (zNear - zFar);
        float rm32 = (zZeroToOne ? zNear : zFar + zNear) / (zNear - zFar);
        dest._m30(this.m20() * rm32 + this.m30())._m31(this.m21() * rm32 + this.m31())._m32(this.m22() * rm32 + this.m32())._m33(this.m23() * rm32 + this.m33())._m00(this.m00() * rm00)._m01(this.m01() * rm00)._m02(this.m02() * rm00)._m03(this.m03() * rm00)._m10(this.m10() * rm11)._m11(this.m11() * rm11)._m12(this.m12() * rm11)._m13(this.m13() * rm11)._m20(this.m20() * rm22)._m21(this.m21() * rm22)._m22(this.m22() * rm22)._m23(this.m23() * rm22)._properties(this.properties & 0xFFFFFFE2);
        return dest;
    }

    public Matrix4f orthoSymmetric(float width, float height, float zNear, float zFar, Matrix4f dest) {
        return this.orthoSymmetric(width, height, zNear, zFar, false, dest);
    }

    public Matrix4f orthoSymmetric(float width, float height, float zNear, float zFar, boolean zZeroToOne) {
        return this.orthoSymmetric(width, height, zNear, zFar, zZeroToOne, this);
    }

    public Matrix4f orthoSymmetric(float width, float height, float zNear, float zFar) {
        return this.orthoSymmetric(width, height, zNear, zFar, false, this);
    }

    public Matrix4f orthoSymmetricLH(float width, float height, float zNear, float zFar, boolean zZeroToOne, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.setOrthoSymmetricLH(width, height, zNear, zFar, zZeroToOne);
        }
        return this.orthoSymmetricLHGeneric(width, height, zNear, zFar, zZeroToOne, dest);
    }

    private Matrix4f orthoSymmetricLHGeneric(float width, float height, float zNear, float zFar, boolean zZeroToOne, Matrix4f dest) {
        float rm00 = 2.0f / width;
        float rm11 = 2.0f / height;
        float rm22 = (zZeroToOne ? 1.0f : 2.0f) / (zFar - zNear);
        float rm32 = (zZeroToOne ? zNear : zFar + zNear) / (zNear - zFar);
        dest._m30(this.m20() * rm32 + this.m30())._m31(this.m21() * rm32 + this.m31())._m32(this.m22() * rm32 + this.m32())._m33(this.m23() * rm32 + this.m33())._m00(this.m00() * rm00)._m01(this.m01() * rm00)._m02(this.m02() * rm00)._m03(this.m03() * rm00)._m10(this.m10() * rm11)._m11(this.m11() * rm11)._m12(this.m12() * rm11)._m13(this.m13() * rm11)._m20(this.m20() * rm22)._m21(this.m21() * rm22)._m22(this.m22() * rm22)._m23(this.m23() * rm22)._properties(this.properties & 0xFFFFFFE2);
        return dest;
    }

    public Matrix4f orthoSymmetricLH(float width, float height, float zNear, float zFar, Matrix4f dest) {
        return this.orthoSymmetricLH(width, height, zNear, zFar, false, dest);
    }

    public Matrix4f orthoSymmetricLH(float width, float height, float zNear, float zFar, boolean zZeroToOne) {
        return this.orthoSymmetricLH(width, height, zNear, zFar, zZeroToOne, this);
    }

    public Matrix4f orthoSymmetricLH(float width, float height, float zNear, float zFar) {
        return this.orthoSymmetricLH(width, height, zNear, zFar, false, this);
    }

    public Matrix4f setOrthoSymmetric(float width, float height, float zNear, float zFar, boolean zZeroToOne) {
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        this._m00(2.0f / width)._m11(2.0f / height)._m22((zZeroToOne ? 1.0f : 2.0f) / (zNear - zFar))._m32((zZeroToOne ? zNear : zFar + zNear) / (zNear - zFar))._properties(2);
        return this;
    }

    public Matrix4f setOrthoSymmetric(float width, float height, float zNear, float zFar) {
        return this.setOrthoSymmetric(width, height, zNear, zFar, false);
    }

    public Matrix4f setOrthoSymmetricLH(float width, float height, float zNear, float zFar, boolean zZeroToOne) {
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        this._m00(2.0f / width)._m11(2.0f / height)._m22((zZeroToOne ? 1.0f : 2.0f) / (zFar - zNear))._m32((zZeroToOne ? zNear : zFar + zNear) / (zNear - zFar))._properties(2);
        return this;
    }

    public Matrix4f setOrthoSymmetricLH(float width, float height, float zNear, float zFar) {
        return this.setOrthoSymmetricLH(width, height, zNear, zFar, false);
    }

    public Matrix4f ortho2D(float left, float right, float bottom, float top, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.setOrtho2D(left, right, bottom, top);
        }
        return this.ortho2DGeneric(left, right, bottom, top, dest);
    }

    private Matrix4f ortho2DGeneric(float left, float right, float bottom, float top, Matrix4f dest) {
        float rm00 = 2.0f / (right - left);
        float rm11 = 2.0f / (top - bottom);
        float rm30 = (right + left) / (left - right);
        float rm31 = (top + bottom) / (bottom - top);
        dest._m30(this.m00() * rm30 + this.m10() * rm31 + this.m30())._m31(this.m01() * rm30 + this.m11() * rm31 + this.m31())._m32(this.m02() * rm30 + this.m12() * rm31 + this.m32())._m33(this.m03() * rm30 + this.m13() * rm31 + this.m33())._m00(this.m00() * rm00)._m01(this.m01() * rm00)._m02(this.m02() * rm00)._m03(this.m03() * rm00)._m10(this.m10() * rm11)._m11(this.m11() * rm11)._m12(this.m12() * rm11)._m13(this.m13() * rm11)._m20(-this.m20())._m21(-this.m21())._m22(-this.m22())._m23(-this.m23())._properties(this.properties & 0xFFFFFFE2);
        return dest;
    }

    public Matrix4f ortho2D(float left, float right, float bottom, float top) {
        return this.ortho2D(left, right, bottom, top, this);
    }

    public Matrix4f ortho2DLH(float left, float right, float bottom, float top, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.setOrtho2DLH(left, right, bottom, top);
        }
        return this.ortho2DLHGeneric(left, right, bottom, top, dest);
    }

    private Matrix4f ortho2DLHGeneric(float left, float right, float bottom, float top, Matrix4f dest) {
        float rm00 = 2.0f / (right - left);
        float rm11 = 2.0f / (top - bottom);
        float rm30 = (right + left) / (left - right);
        float rm31 = (top + bottom) / (bottom - top);
        dest._m30(this.m00() * rm30 + this.m10() * rm31 + this.m30())._m31(this.m01() * rm30 + this.m11() * rm31 + this.m31())._m32(this.m02() * rm30 + this.m12() * rm31 + this.m32())._m33(this.m03() * rm30 + this.m13() * rm31 + this.m33())._m00(this.m00() * rm00)._m01(this.m01() * rm00)._m02(this.m02() * rm00)._m03(this.m03() * rm00)._m10(this.m10() * rm11)._m11(this.m11() * rm11)._m12(this.m12() * rm11)._m13(this.m13() * rm11)._m20(this.m20())._m21(this.m21())._m22(this.m22())._m23(this.m23())._properties(this.properties & 0xFFFFFFE2);
        return dest;
    }

    public Matrix4f ortho2DLH(float left, float right, float bottom, float top) {
        return this.ortho2DLH(left, right, bottom, top, this);
    }

    public Matrix4f setOrtho2D(float left, float right, float bottom, float top) {
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        this._m00(2.0f / (right - left))._m11(2.0f / (top - bottom))._m22(-1.0f)._m30((right + left) / (left - right))._m31((top + bottom) / (bottom - top))._properties(2);
        return this;
    }

    public Matrix4f setOrtho2DLH(float left, float right, float bottom, float top) {
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        this._m00(2.0f / (right - left))._m11(2.0f / (top - bottom))._m30((right + left) / (left - right))._m31((top + bottom) / (bottom - top))._properties(2);
        return this;
    }

    public Matrix4f lookAlong(Vector3fc dir, Vector3fc up) {
        return this.lookAlong(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z(), this);
    }

    public Matrix4f lookAlong(Vector3fc dir, Vector3fc up, Matrix4f dest) {
        return this.lookAlong(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z(), dest);
    }

    public Matrix4f lookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.setLookAlong(dirX, dirY, dirZ, upX, upY, upZ);
        }
        return this.lookAlongGeneric(dirX, dirY, dirZ, upX, upY, upZ, dest);
    }

    private Matrix4f lookAlongGeneric(float dirX, float dirY, float dirZ, float upX, float upY, float upZ, Matrix4f dest) {
        float invDirLength = Math.invsqrt(dirX * dirX + dirY * dirY + dirZ * dirZ);
        float leftX = upY * (dirZ *= -invDirLength) - upZ * (dirY *= -invDirLength);
        float leftY = upZ * (dirX *= -invDirLength) - upX * dirZ;
        float leftZ = upX * dirY - upY * dirX;
        float invLeftLength = Math.invsqrt(leftX * leftX + leftY * leftY + leftZ * leftZ);
        float upnX = dirY * (leftZ *= invLeftLength) - dirZ * (leftY *= invLeftLength);
        float upnY = dirZ * (leftX *= invLeftLength) - dirX * leftZ;
        float upnZ = dirX * leftY - dirY * leftX;
        float nm00 = this.m00() * leftX + this.m10() * upnX + this.m20() * dirX;
        float nm01 = this.m01() * leftX + this.m11() * upnX + this.m21() * dirX;
        float nm02 = this.m02() * leftX + this.m12() * upnX + this.m22() * dirX;
        float nm03 = this.m03() * leftX + this.m13() * upnX + this.m23() * dirX;
        float nm10 = this.m00() * leftY + this.m10() * upnY + this.m20() * dirY;
        float nm11 = this.m01() * leftY + this.m11() * upnY + this.m21() * dirY;
        float nm12 = this.m02() * leftY + this.m12() * upnY + this.m22() * dirY;
        float nm13 = this.m03() * leftY + this.m13() * upnY + this.m23() * dirY;
        return dest._m20(this.m00() * leftZ + this.m10() * upnZ + this.m20() * dirZ)._m21(this.m01() * leftZ + this.m11() * upnZ + this.m21() * dirZ)._m22(this.m02() * leftZ + this.m12() * upnZ + this.m22() * dirZ)._m23(this.m03() * leftZ + this.m13() * upnZ + this.m23() * dirZ)._m00(nm00)._m01(nm01)._m02(nm02)._m03(nm03)._m10(nm10)._m11(nm11)._m12(nm12)._m13(nm13)._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0xFFFFFFF2);
    }

    public Matrix4f lookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        return this.lookAlong(dirX, dirY, dirZ, upX, upY, upZ, this);
    }

    public Matrix4f setLookAlong(Vector3fc dir, Vector3fc up) {
        return this.setLookAlong(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z());
    }

    public Matrix4f setLookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        float invDirLength = Math.invsqrt(dirX * dirX + dirY * dirY + dirZ * dirZ);
        float leftX = upY * (dirZ *= -invDirLength) - upZ * (dirY *= -invDirLength);
        float leftY = upZ * (dirX *= -invDirLength) - upX * dirZ;
        float leftZ = upX * dirY - upY * dirX;
        float invLeftLength = Math.invsqrt(leftX * leftX + leftY * leftY + leftZ * leftZ);
        this._m00(leftX *= invLeftLength)._m01(dirY * (leftZ *= invLeftLength) - dirZ * (leftY *= invLeftLength))._m02(dirX)._m03(0.0f)._m10(leftY)._m11(dirZ * leftX - dirX * leftZ)._m12(dirY)._m13(0.0f)._m20(leftZ)._m21(dirX * leftY - dirY * leftX)._m22(dirZ)._m23(0.0f)._m30(0.0f)._m31(0.0f)._m32(0.0f)._m33(1.0f)._properties(18);
        return this;
    }

    public Matrix4f setLookAt(Vector3fc eye, Vector3fc center, Vector3fc up) {
        return this.setLookAt(eye.x(), eye.y(), eye.z(), center.x(), center.y(), center.z(), up.x(), up.y(), up.z());
    }

    public Matrix4f setLookAt(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        float dirX = eyeX - centerX;
        float dirY = eyeY - centerY;
        float dirZ = eyeZ - centerZ;
        float invDirLength = Math.invsqrt(dirX * dirX + dirY * dirY + dirZ * dirZ);
        float leftX = upY * (dirZ *= invDirLength) - upZ * (dirY *= invDirLength);
        float leftY = upZ * (dirX *= invDirLength) - upX * dirZ;
        float leftZ = upX * dirY - upY * dirX;
        float invLeftLength = Math.invsqrt(leftX * leftX + leftY * leftY + leftZ * leftZ);
        float upnX = dirY * (leftZ *= invLeftLength) - dirZ * (leftY *= invLeftLength);
        float upnY = dirZ * (leftX *= invLeftLength) - dirX * leftZ;
        float upnZ = dirX * leftY - dirY * leftX;
        return this._m00(leftX)._m01(upnX)._m02(dirX)._m03(0.0f)._m10(leftY)._m11(upnY)._m12(dirY)._m13(0.0f)._m20(leftZ)._m21(upnZ)._m22(dirZ)._m23(0.0f)._m30(-(leftX * eyeX + leftY * eyeY + leftZ * eyeZ))._m31(-(upnX * eyeX + upnY * eyeY + upnZ * eyeZ))._m32(-(dirX * eyeX + dirY * eyeY + dirZ * eyeZ))._m33(1.0f)._properties(18);
    }

    public Matrix4f lookAt(Vector3fc eye, Vector3fc center, Vector3fc up, Matrix4f dest) {
        return this.lookAt(eye.x(), eye.y(), eye.z(), center.x(), center.y(), center.z(), up.x(), up.y(), up.z(), dest);
    }

    public Matrix4f lookAt(Vector3fc eye, Vector3fc center, Vector3fc up) {
        return this.lookAt(eye.x(), eye.y(), eye.z(), center.x(), center.y(), center.z(), up.x(), up.y(), up.z(), this);
    }

    public Matrix4f lookAt(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.setLookAt(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        }
        if ((this.properties & 1) != 0) {
            return this.lookAtPerspective(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, dest);
        }
        return this.lookAtGeneric(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, dest);
    }

    private Matrix4f lookAtGeneric(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ, Matrix4f dest) {
        float dirX = eyeX - centerX;
        float dirY = eyeY - centerY;
        float dirZ = eyeZ - centerZ;
        float invDirLength = Math.invsqrt(dirX * dirX + dirY * dirY + dirZ * dirZ);
        float leftX = upY * (dirZ *= invDirLength) - upZ * (dirY *= invDirLength);
        float leftY = upZ * (dirX *= invDirLength) - upX * dirZ;
        float leftZ = upX * dirY - upY * dirX;
        float invLeftLength = Math.invsqrt(leftX * leftX + leftY * leftY + leftZ * leftZ);
        float upnX = dirY * (leftZ *= invLeftLength) - dirZ * (leftY *= invLeftLength);
        float upnY = dirZ * (leftX *= invLeftLength) - dirX * leftZ;
        float upnZ = dirX * leftY - dirY * leftX;
        float rm30 = -(leftX * eyeX + leftY * eyeY + leftZ * eyeZ);
        float rm31 = -(upnX * eyeX + upnY * eyeY + upnZ * eyeZ);
        float rm32 = -(dirX * eyeX + dirY * eyeY + dirZ * eyeZ);
        float nm00 = this.m00() * leftX + this.m10() * upnX + this.m20() * dirX;
        float nm01 = this.m01() * leftX + this.m11() * upnX + this.m21() * dirX;
        float nm02 = this.m02() * leftX + this.m12() * upnX + this.m22() * dirX;
        float nm03 = this.m03() * leftX + this.m13() * upnX + this.m23() * dirX;
        float nm10 = this.m00() * leftY + this.m10() * upnY + this.m20() * dirY;
        float nm11 = this.m01() * leftY + this.m11() * upnY + this.m21() * dirY;
        float nm12 = this.m02() * leftY + this.m12() * upnY + this.m22() * dirY;
        float nm13 = this.m03() * leftY + this.m13() * upnY + this.m23() * dirY;
        return dest._m30(this.m00() * rm30 + this.m10() * rm31 + this.m20() * rm32 + this.m30())._m31(this.m01() * rm30 + this.m11() * rm31 + this.m21() * rm32 + this.m31())._m32(this.m02() * rm30 + this.m12() * rm31 + this.m22() * rm32 + this.m32())._m33(this.m03() * rm30 + this.m13() * rm31 + this.m23() * rm32 + this.m33())._m20(this.m00() * leftZ + this.m10() * upnZ + this.m20() * dirZ)._m21(this.m01() * leftZ + this.m11() * upnZ + this.m21() * dirZ)._m22(this.m02() * leftZ + this.m12() * upnZ + this.m22() * dirZ)._m23(this.m03() * leftZ + this.m13() * upnZ + this.m23() * dirZ)._m00(nm00)._m01(nm01)._m02(nm02)._m03(nm03)._m10(nm10)._m11(nm11)._m12(nm12)._m13(nm13)._properties(this.properties & 0xFFFFFFF2);
    }

    public Matrix4f lookAtPerspective(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ, Matrix4f dest) {
        float dirX = eyeX - centerX;
        float dirY = eyeY - centerY;
        float dirZ = eyeZ - centerZ;
        float invDirLength = Math.invsqrt(dirX * dirX + dirY * dirY + dirZ * dirZ);
        float leftX = upY * (dirZ *= invDirLength) - upZ * (dirY *= invDirLength);
        float leftY = upZ * (dirX *= invDirLength) - upX * dirZ;
        float leftZ = upX * dirY - upY * dirX;
        float invLeftLength = Math.invsqrt(leftX * leftX + leftY * leftY + leftZ * leftZ);
        float upnX = dirY * (leftZ *= invLeftLength) - dirZ * (leftY *= invLeftLength);
        float upnY = dirZ * (leftX *= invLeftLength) - dirX * leftZ;
        float upnZ = dirX * leftY - dirY * leftX;
        float rm30 = -(leftX * eyeX + leftY * eyeY + leftZ * eyeZ);
        float rm31 = -(upnX * eyeX + upnY * eyeY + upnZ * eyeZ);
        float rm32 = -(dirX * eyeX + dirY * eyeY + dirZ * eyeZ);
        float nm10 = this.m00() * leftY;
        float nm20 = this.m00() * leftZ;
        float nm21 = this.m11() * upnZ;
        float nm30 = this.m00() * rm30;
        float nm31 = this.m11() * rm31;
        float nm32 = this.m22() * rm32 + this.m32();
        float nm33 = this.m23() * rm32;
        return dest._m00(this.m00() * leftX)._m01(this.m11() * upnX)._m02(this.m22() * dirX)._m03(this.m23() * dirX)._m10(nm10)._m11(this.m11() * upnY)._m12(this.m22() * dirY)._m13(this.m23() * dirY)._m20(nm20)._m21(nm21)._m22(this.m22() * dirZ)._m23(this.m23() * dirZ)._m30(nm30)._m31(nm31)._m32(nm32)._m33(nm33)._properties(0);
    }

    public Matrix4f lookAt(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        return this.lookAt(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, this);
    }

    public Matrix4f setLookAtLH(Vector3fc eye, Vector3fc center, Vector3fc up) {
        return this.setLookAtLH(eye.x(), eye.y(), eye.z(), center.x(), center.y(), center.z(), up.x(), up.y(), up.z());
    }

    public Matrix4f setLookAtLH(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        float dirX = centerX - eyeX;
        float dirY = centerY - eyeY;
        float dirZ = centerZ - eyeZ;
        float invDirLength = Math.invsqrt(dirX * dirX + dirY * dirY + dirZ * dirZ);
        float leftX = upY * (dirZ *= invDirLength) - upZ * (dirY *= invDirLength);
        float leftY = upZ * (dirX *= invDirLength) - upX * dirZ;
        float leftZ = upX * dirY - upY * dirX;
        float invLeftLength = Math.invsqrt(leftX * leftX + leftY * leftY + leftZ * leftZ);
        float upnX = dirY * (leftZ *= invLeftLength) - dirZ * (leftY *= invLeftLength);
        float upnY = dirZ * (leftX *= invLeftLength) - dirX * leftZ;
        float upnZ = dirX * leftY - dirY * leftX;
        this._m00(leftX)._m01(upnX)._m02(dirX)._m03(0.0f)._m10(leftY)._m11(upnY)._m12(dirY)._m13(0.0f)._m20(leftZ)._m21(upnZ)._m22(dirZ)._m23(0.0f)._m30(-(leftX * eyeX + leftY * eyeY + leftZ * eyeZ))._m31(-(upnX * eyeX + upnY * eyeY + upnZ * eyeZ))._m32(-(dirX * eyeX + dirY * eyeY + dirZ * eyeZ))._m33(1.0f)._properties(18);
        return this;
    }

    public Matrix4f lookAtLH(Vector3fc eye, Vector3fc center, Vector3fc up, Matrix4f dest) {
        return this.lookAtLH(eye.x(), eye.y(), eye.z(), center.x(), center.y(), center.z(), up.x(), up.y(), up.z(), dest);
    }

    public Matrix4f lookAtLH(Vector3fc eye, Vector3fc center, Vector3fc up) {
        return this.lookAtLH(eye.x(), eye.y(), eye.z(), center.x(), center.y(), center.z(), up.x(), up.y(), up.z(), this);
    }

    public Matrix4f lookAtLH(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.setLookAtLH(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        }
        if ((this.properties & 1) != 0) {
            return this.lookAtPerspectiveLH(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, dest);
        }
        return this.lookAtLHGeneric(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, dest);
    }

    private Matrix4f lookAtLHGeneric(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ, Matrix4f dest) {
        float dirX = centerX - eyeX;
        float dirY = centerY - eyeY;
        float dirZ = centerZ - eyeZ;
        float invDirLength = Math.invsqrt(dirX * dirX + dirY * dirY + dirZ * dirZ);
        float leftX = upY * (dirZ *= invDirLength) - upZ * (dirY *= invDirLength);
        float leftY = upZ * (dirX *= invDirLength) - upX * dirZ;
        float leftZ = upX * dirY - upY * dirX;
        float invLeftLength = Math.invsqrt(leftX * leftX + leftY * leftY + leftZ * leftZ);
        float upnX = dirY * (leftZ *= invLeftLength) - dirZ * (leftY *= invLeftLength);
        float upnY = dirZ * (leftX *= invLeftLength) - dirX * leftZ;
        float upnZ = dirX * leftY - dirY * leftX;
        float rm30 = -(leftX * eyeX + leftY * eyeY + leftZ * eyeZ);
        float rm31 = -(upnX * eyeX + upnY * eyeY + upnZ * eyeZ);
        float rm32 = -(dirX * eyeX + dirY * eyeY + dirZ * eyeZ);
        float nm00 = this.m00() * leftX + this.m10() * upnX + this.m20() * dirX;
        float nm01 = this.m01() * leftX + this.m11() * upnX + this.m21() * dirX;
        float nm02 = this.m02() * leftX + this.m12() * upnX + this.m22() * dirX;
        float nm03 = this.m03() * leftX + this.m13() * upnX + this.m23() * dirX;
        float nm10 = this.m00() * leftY + this.m10() * upnY + this.m20() * dirY;
        float nm11 = this.m01() * leftY + this.m11() * upnY + this.m21() * dirY;
        float nm12 = this.m02() * leftY + this.m12() * upnY + this.m22() * dirY;
        float nm13 = this.m03() * leftY + this.m13() * upnY + this.m23() * dirY;
        return dest._m30(this.m00() * rm30 + this.m10() * rm31 + this.m20() * rm32 + this.m30())._m31(this.m01() * rm30 + this.m11() * rm31 + this.m21() * rm32 + this.m31())._m32(this.m02() * rm30 + this.m12() * rm31 + this.m22() * rm32 + this.m32())._m33(this.m03() * rm30 + this.m13() * rm31 + this.m23() * rm32 + this.m33())._m20(this.m00() * leftZ + this.m10() * upnZ + this.m20() * dirZ)._m21(this.m01() * leftZ + this.m11() * upnZ + this.m21() * dirZ)._m22(this.m02() * leftZ + this.m12() * upnZ + this.m22() * dirZ)._m23(this.m03() * leftZ + this.m13() * upnZ + this.m23() * dirZ)._m00(nm00)._m01(nm01)._m02(nm02)._m03(nm03)._m10(nm10)._m11(nm11)._m12(nm12)._m13(nm13)._properties(this.properties & 0xFFFFFFF2);
    }

    public Matrix4f lookAtLH(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        return this.lookAtLH(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, this);
    }

    public Matrix4f lookAtPerspectiveLH(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ, Matrix4f dest) {
        float dirX = centerX - eyeX;
        float dirY = centerY - eyeY;
        float dirZ = centerZ - eyeZ;
        float invDirLength = Math.invsqrt(dirX * dirX + dirY * dirY + dirZ * dirZ);
        float leftX = upY * (dirZ *= invDirLength) - upZ * (dirY *= invDirLength);
        float leftY = upZ * (dirX *= invDirLength) - upX * dirZ;
        float leftZ = upX * dirY - upY * dirX;
        float invLeftLength = Math.invsqrt(leftX * leftX + leftY * leftY + leftZ * leftZ);
        float upnX = dirY * (leftZ *= invLeftLength) - dirZ * (leftY *= invLeftLength);
        float upnY = dirZ * (leftX *= invLeftLength) - dirX * leftZ;
        float upnZ = dirX * leftY - dirY * leftX;
        float rm30 = -(leftX * eyeX + leftY * eyeY + leftZ * eyeZ);
        float rm31 = -(upnX * eyeX + upnY * eyeY + upnZ * eyeZ);
        float rm32 = -(dirX * eyeX + dirY * eyeY + dirZ * eyeZ);
        float nm00 = this.m00() * leftX;
        float nm01 = this.m11() * upnX;
        float nm02 = this.m22() * dirX;
        float nm03 = this.m23() * dirX;
        float nm10 = this.m00() * leftY;
        float nm11 = this.m11() * upnY;
        float nm12 = this.m22() * dirY;
        float nm13 = this.m23() * dirY;
        float nm20 = this.m00() * leftZ;
        float nm21 = this.m11() * upnZ;
        float nm22 = this.m22() * dirZ;
        float nm23 = this.m23() * dirZ;
        float nm30 = this.m00() * rm30;
        float nm31 = this.m11() * rm31;
        float nm32 = this.m22() * rm32 + this.m32();
        float nm33 = this.m23() * rm32;
        return dest._m00(nm00)._m01(nm01)._m02(nm02)._m03(nm03)._m10(nm10)._m11(nm11)._m12(nm12)._m13(nm13)._m20(nm20)._m21(nm21)._m22(nm22)._m23(nm23)._m30(nm30)._m31(nm31)._m32(nm32)._m33(nm33)._properties(0);
    }

    public Matrix4f tile(int x2, int y2, int w2, int h2) {
        return this.tile(x2, y2, w2, h2, this);
    }

    public Matrix4f tile(int x2, int y2, int w2, int h2, Matrix4f dest) {
        float tx = w2 - 1 - (x2 << 1);
        float ty = h2 - 1 - (y2 << 1);
        return dest._m30(Math.fma(this.m00(), tx, Math.fma(this.m10(), ty, this.m30())))._m31(Math.fma(this.m01(), tx, Math.fma(this.m11(), ty, this.m31())))._m32(Math.fma(this.m02(), tx, Math.fma(this.m12(), ty, this.m32())))._m33(Math.fma(this.m03(), tx, Math.fma(this.m13(), ty, this.m33())))._m00(this.m00() * (float)w2)._m01(this.m01() * (float)w2)._m02(this.m02() * (float)w2)._m03(this.m03() * (float)w2)._m10(this.m10() * (float)h2)._m11(this.m11() * (float)h2)._m12(this.m12() * (float)h2)._m13(this.m13() * (float)h2)._m20(this.m20())._m21(this.m21())._m22(this.m22())._m23(this.m23())._properties(this.properties & 0xFFFFFFE2);
    }

    public Matrix4f perspective(float fovy, float aspect, float zNear, float zFar, boolean zZeroToOne, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.setPerspective(fovy, aspect, zNear, zFar, zZeroToOne);
        }
        return this.perspectiveGeneric(fovy, aspect, zNear, zFar, zZeroToOne, dest);
    }

    private Matrix4f perspectiveGeneric(float fovy, float aspect, float zNear, float zFar, boolean zZeroToOne, Matrix4f dest) {
        float rm32;
        float rm22;
        float e2;
        boolean nearInf;
        float h2 = Math.tan(fovy * 0.5f);
        float rm00 = 1.0f / (h2 * aspect);
        float rm11 = 1.0f / h2;
        boolean farInf = zFar > 0.0f && Float.isInfinite(zFar);
        boolean bl2 = nearInf = zNear > 0.0f && Float.isInfinite(zNear);
        if (farInf) {
            e2 = 1.0E-6f;
            rm22 = e2 - 1.0f;
            rm32 = (e2 - (zZeroToOne ? 1.0f : 2.0f)) * zNear;
        } else if (nearInf) {
            e2 = 1.0E-6f;
            rm22 = (zZeroToOne ? 0.0f : 1.0f) - e2;
            rm32 = ((zZeroToOne ? 1.0f : 2.0f) - e2) * zFar;
        } else {
            rm22 = (zZeroToOne ? zFar : zFar + zNear) / (zNear - zFar);
            rm32 = (zZeroToOne ? zFar : zFar + zFar) * zNear / (zNear - zFar);
        }
        float nm20 = this.m20() * rm22 - this.m30();
        float nm21 = this.m21() * rm22 - this.m31();
        float nm22 = this.m22() * rm22 - this.m32();
        float nm23 = this.m23() * rm22 - this.m33();
        dest._m00(this.m00() * rm00)._m01(this.m01() * rm00)._m02(this.m02() * rm00)._m03(this.m03() * rm00)._m10(this.m10() * rm11)._m11(this.m11() * rm11)._m12(this.m12() * rm11)._m13(this.m13() * rm11)._m30(this.m20() * rm32)._m31(this.m21() * rm32)._m32(this.m22() * rm32)._m33(this.m23() * rm32)._m20(nm20)._m21(nm21)._m22(nm22)._m23(nm23)._properties(this.properties & 0xFFFFFFE1);
        return dest;
    }

    public Matrix4f perspective(float fovy, float aspect, float zNear, float zFar, Matrix4f dest) {
        return this.perspective(fovy, aspect, zNear, zFar, false, dest);
    }

    public Matrix4f perspective(float fovy, float aspect, float zNear, float zFar, boolean zZeroToOne) {
        return this.perspective(fovy, aspect, zNear, zFar, zZeroToOne, this);
    }

    public Matrix4f perspective(float fovy, float aspect, float zNear, float zFar) {
        return this.perspective(fovy, aspect, zNear, zFar, this);
    }

    public Matrix4f perspectiveRect(float width, float height, float zNear, float zFar, boolean zZeroToOne, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.setPerspectiveRect(width, height, zNear, zFar, zZeroToOne);
        }
        return this.perspectiveRectGeneric(width, height, zNear, zFar, zZeroToOne, dest);
    }

    private Matrix4f perspectiveRectGeneric(float width, float height, float zNear, float zFar, boolean zZeroToOne, Matrix4f dest) {
        float rm32;
        float rm22;
        float e2;
        boolean nearInf;
        float rm00 = (zNear + zNear) / width;
        float rm11 = (zNear + zNear) / height;
        boolean farInf = zFar > 0.0f && Float.isInfinite(zFar);
        boolean bl2 = nearInf = zNear > 0.0f && Float.isInfinite(zNear);
        if (farInf) {
            e2 = 1.0E-6f;
            rm22 = e2 - 1.0f;
            rm32 = (e2 - (zZeroToOne ? 1.0f : 2.0f)) * zNear;
        } else if (nearInf) {
            e2 = 1.0E-6f;
            rm22 = (zZeroToOne ? 0.0f : 1.0f) - e2;
            rm32 = ((zZeroToOne ? 1.0f : 2.0f) - e2) * zFar;
        } else {
            rm22 = (zZeroToOne ? zFar : zFar + zNear) / (zNear - zFar);
            rm32 = (zZeroToOne ? zFar : zFar + zFar) * zNear / (zNear - zFar);
        }
        float nm20 = this.m20() * rm22 - this.m30();
        float nm21 = this.m21() * rm22 - this.m31();
        float nm22 = this.m22() * rm22 - this.m32();
        float nm23 = this.m23() * rm22 - this.m33();
        dest._m00(this.m00() * rm00)._m01(this.m01() * rm00)._m02(this.m02() * rm00)._m03(this.m03() * rm00)._m10(this.m10() * rm11)._m11(this.m11() * rm11)._m12(this.m12() * rm11)._m13(this.m13() * rm11)._m30(this.m20() * rm32)._m31(this.m21() * rm32)._m32(this.m22() * rm32)._m33(this.m23() * rm32)._m20(nm20)._m21(nm21)._m22(nm22)._m23(nm23)._properties(this.properties & 0xFFFFFFE1);
        return dest;
    }

    public Matrix4f perspectiveRect(float width, float height, float zNear, float zFar, Matrix4f dest) {
        return this.perspectiveRect(width, height, zNear, zFar, false, dest);
    }

    public Matrix4f perspectiveRect(float width, float height, float zNear, float zFar, boolean zZeroToOne) {
        return this.perspectiveRect(width, height, zNear, zFar, zZeroToOne, this);
    }

    public Matrix4f perspectiveRect(float width, float height, float zNear, float zFar) {
        return this.perspectiveRect(width, height, zNear, zFar, this);
    }

    public Matrix4f perspectiveOffCenter(float fovy, float offAngleX, float offAngleY, float aspect, float zNear, float zFar, boolean zZeroToOne, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.setPerspectiveOffCenter(fovy, offAngleX, offAngleY, aspect, zNear, zFar, zZeroToOne);
        }
        return this.perspectiveOffCenterGeneric(fovy, offAngleX, offAngleY, aspect, zNear, zFar, zZeroToOne, dest);
    }

    private Matrix4f perspectiveOffCenterGeneric(float fovy, float offAngleX, float offAngleY, float aspect, float zNear, float zFar, boolean zZeroToOne, Matrix4f dest) {
        float rm32;
        float rm22;
        float e2;
        boolean nearInf;
        float h2 = Math.tan(fovy * 0.5f);
        float xScale = 1.0f / (h2 * aspect);
        float yScale = 1.0f / h2;
        float offX = Math.tan(offAngleX);
        float offY = Math.tan(offAngleY);
        float rm20 = offX * xScale;
        float rm21 = offY * yScale;
        boolean farInf = zFar > 0.0f && Float.isInfinite(zFar);
        boolean bl2 = nearInf = zNear > 0.0f && Float.isInfinite(zNear);
        if (farInf) {
            e2 = 1.0E-6f;
            rm22 = e2 - 1.0f;
            rm32 = (e2 - (zZeroToOne ? 1.0f : 2.0f)) * zNear;
        } else if (nearInf) {
            e2 = 1.0E-6f;
            rm22 = (zZeroToOne ? 0.0f : 1.0f) - e2;
            rm32 = ((zZeroToOne ? 1.0f : 2.0f) - e2) * zFar;
        } else {
            rm22 = (zZeroToOne ? zFar : zFar + zNear) / (zNear - zFar);
            rm32 = (zZeroToOne ? zFar : zFar + zFar) * zNear / (zNear - zFar);
        }
        float nm20 = this.m00() * rm20 + this.m10() * rm21 + this.m20() * rm22 - this.m30();
        float nm21 = this.m01() * rm20 + this.m11() * rm21 + this.m21() * rm22 - this.m31();
        float nm22 = this.m02() * rm20 + this.m12() * rm21 + this.m22() * rm22 - this.m32();
        float nm23 = this.m03() * rm20 + this.m13() * rm21 + this.m23() * rm22 - this.m33();
        dest._m00(this.m00() * xScale)._m01(this.m01() * xScale)._m02(this.m02() * xScale)._m03(this.m03() * xScale)._m10(this.m10() * yScale)._m11(this.m11() * yScale)._m12(this.m12() * yScale)._m13(this.m13() * yScale)._m30(this.m20() * rm32)._m31(this.m21() * rm32)._m32(this.m22() * rm32)._m33(this.m23() * rm32)._m20(nm20)._m21(nm21)._m22(nm22)._m23(nm23)._properties(this.properties & ~(0x1E | (rm20 == 0.0f && rm21 == 0.0f ? 0 : 1)));
        return dest;
    }

    public Matrix4f perspectiveOffCenter(float fovy, float offAngleX, float offAngleY, float aspect, float zNear, float zFar, Matrix4f dest) {
        return this.perspectiveOffCenter(fovy, offAngleX, offAngleY, aspect, zNear, zFar, false, dest);
    }

    public Matrix4f perspectiveOffCenter(float fovy, float offAngleX, float offAngleY, float aspect, float zNear, float zFar, boolean zZeroToOne) {
        return this.perspectiveOffCenter(fovy, offAngleX, offAngleY, aspect, zNear, zFar, zZeroToOne, this);
    }

    public Matrix4f perspectiveOffCenter(float fovy, float offAngleX, float offAngleY, float aspect, float zNear, float zFar) {
        return this.perspectiveOffCenter(fovy, offAngleX, offAngleY, aspect, zNear, zFar, this);
    }

    public Matrix4f perspectiveOffCenterFov(float angleLeft, float angleRight, float angleDown, float angleUp, float zNear, float zFar, boolean zZeroToOne) {
        return this.perspectiveOffCenterFov(angleLeft, angleRight, angleDown, angleUp, zNear, zFar, zZeroToOne, this);
    }

    public Matrix4f perspectiveOffCenterFov(float angleLeft, float angleRight, float angleDown, float angleUp, float zNear, float zFar, boolean zZeroToOne, Matrix4f dest) {
        return this.frustum(Math.tan(angleLeft) * zNear, Math.tan(angleRight) * zNear, Math.tan(angleDown) * zNear, Math.tan(angleUp) * zNear, zNear, zFar, zZeroToOne, dest);
    }

    public Matrix4f perspectiveOffCenterFov(float angleLeft, float angleRight, float angleDown, float angleUp, float zNear, float zFar) {
        return this.perspectiveOffCenterFov(angleLeft, angleRight, angleDown, angleUp, zNear, zFar, this);
    }

    public Matrix4f perspectiveOffCenterFov(float angleLeft, float angleRight, float angleDown, float angleUp, float zNear, float zFar, Matrix4f dest) {
        return this.frustum(Math.tan(angleLeft) * zNear, Math.tan(angleRight) * zNear, Math.tan(angleDown) * zNear, Math.tan(angleUp) * zNear, zNear, zFar, dest);
    }

    public Matrix4f perspectiveOffCenterFovLH(float angleLeft, float angleRight, float angleDown, float angleUp, float zNear, float zFar, boolean zZeroToOne) {
        return this.perspectiveOffCenterFovLH(angleLeft, angleRight, angleDown, angleUp, zNear, zFar, zZeroToOne, this);
    }

    public Matrix4f perspectiveOffCenterFovLH(float angleLeft, float angleRight, float angleDown, float angleUp, float zNear, float zFar, boolean zZeroToOne, Matrix4f dest) {
        return this.frustumLH(Math.tan(angleLeft) * zNear, Math.tan(angleRight) * zNear, Math.tan(angleDown) * zNear, Math.tan(angleUp) * zNear, zNear, zFar, zZeroToOne, dest);
    }

    public Matrix4f perspectiveOffCenterFovLH(float angleLeft, float angleRight, float angleDown, float angleUp, float zNear, float zFar) {
        return this.perspectiveOffCenterFovLH(angleLeft, angleRight, angleDown, angleUp, zNear, zFar, this);
    }

    public Matrix4f perspectiveOffCenterFovLH(float angleLeft, float angleRight, float angleDown, float angleUp, float zNear, float zFar, Matrix4f dest) {
        return this.frustumLH(Math.tan(angleLeft) * zNear, Math.tan(angleRight) * zNear, Math.tan(angleDown) * zNear, Math.tan(angleUp) * zNear, zNear, zFar, dest);
    }

    public Matrix4f setPerspective(float fovy, float aspect, float zNear, float zFar, boolean zZeroToOne) {
        boolean nearInf;
        MemUtil.INSTANCE.zero(this);
        float h2 = Math.tan(fovy * 0.5f);
        this._m00(1.0f / (h2 * aspect))._m11(1.0f / h2);
        boolean farInf = zFar > 0.0f && Float.isInfinite(zFar);
        boolean bl2 = nearInf = zNear > 0.0f && Float.isInfinite(zNear);
        if (farInf) {
            float e2 = 1.0E-6f;
            this._m22(e2 - 1.0f)._m32((e2 - (zZeroToOne ? 1.0f : 2.0f)) * zNear);
        } else if (nearInf) {
            float e3 = 1.0E-6f;
            this._m22((zZeroToOne ? 0.0f : 1.0f) - e3)._m32(((zZeroToOne ? 1.0f : 2.0f) - e3) * zFar);
        } else {
            this._m22((zZeroToOne ? zFar : zFar + zNear) / (zNear - zFar))._m32((zZeroToOne ? zFar : zFar + zFar) * zNear / (zNear - zFar));
        }
        return this._m23(-1.0f)._properties(1);
    }

    public Matrix4f setPerspective(float fovy, float aspect, float zNear, float zFar) {
        return this.setPerspective(fovy, aspect, zNear, zFar, false);
    }

    public Matrix4f setPerspectiveRect(float width, float height, float zNear, float zFar, boolean zZeroToOne) {
        boolean nearInf;
        MemUtil.INSTANCE.zero(this);
        this._m00((zNear + zNear) / width)._m11((zNear + zNear) / height);
        boolean farInf = zFar > 0.0f && Float.isInfinite(zFar);
        boolean bl2 = nearInf = zNear > 0.0f && Float.isInfinite(zNear);
        if (farInf) {
            float e2 = 1.0E-6f;
            this._m22(e2 - 1.0f)._m32((e2 - (zZeroToOne ? 1.0f : 2.0f)) * zNear);
        } else if (nearInf) {
            float e3 = 1.0E-6f;
            this._m22((zZeroToOne ? 0.0f : 1.0f) - e3)._m32(((zZeroToOne ? 1.0f : 2.0f) - e3) * zFar);
        } else {
            this._m22((zZeroToOne ? zFar : zFar + zNear) / (zNear - zFar))._m32((zZeroToOne ? zFar : zFar + zFar) * zNear / (zNear - zFar));
        }
        this._m23(-1.0f)._properties(1);
        return this;
    }

    public Matrix4f setPerspectiveRect(float width, float height, float zNear, float zFar) {
        return this.setPerspectiveRect(width, height, zNear, zFar, false);
    }

    public Matrix4f setPerspectiveOffCenter(float fovy, float offAngleX, float offAngleY, float aspect, float zNear, float zFar) {
        return this.setPerspectiveOffCenter(fovy, offAngleX, offAngleY, aspect, zNear, zFar, false);
    }

    public Matrix4f setPerspectiveOffCenter(float fovy, float offAngleX, float offAngleY, float aspect, float zNear, float zFar, boolean zZeroToOne) {
        boolean nearInf;
        MemUtil.INSTANCE.zero(this);
        float h2 = Math.tan(fovy * 0.5f);
        float xScale = 1.0f / (h2 * aspect);
        float yScale = 1.0f / h2;
        float offX = Math.tan(offAngleX);
        float offY = Math.tan(offAngleY);
        this._m00(xScale)._m11(yScale)._m20(offX * xScale)._m21(offY * yScale);
        boolean farInf = zFar > 0.0f && Float.isInfinite(zFar);
        boolean bl2 = nearInf = zNear > 0.0f && Float.isInfinite(zNear);
        if (farInf) {
            float e2 = 1.0E-6f;
            this._m22(e2 - 1.0f)._m32((e2 - (zZeroToOne ? 1.0f : 2.0f)) * zNear);
        } else if (nearInf) {
            float e3 = 1.0E-6f;
            this._m22((zZeroToOne ? 0.0f : 1.0f) - e3)._m32(((zZeroToOne ? 1.0f : 2.0f) - e3) * zFar);
        } else {
            this._m22((zZeroToOne ? zFar : zFar + zNear) / (zNear - zFar))._m32((zZeroToOne ? zFar : zFar + zFar) * zNear / (zNear - zFar));
        }
        this._m23(-1.0f)._properties(offAngleX == 0.0f && offAngleY == 0.0f ? 1 : 0);
        return this;
    }

    public Matrix4f setPerspectiveOffCenterFov(float angleLeft, float angleRight, float angleDown, float angleUp, float zNear, float zFar) {
        return this.setPerspectiveOffCenterFov(angleLeft, angleRight, angleDown, angleUp, zNear, zFar, false);
    }

    public Matrix4f setPerspectiveOffCenterFov(float angleLeft, float angleRight, float angleDown, float angleUp, float zNear, float zFar, boolean zZeroToOne) {
        return this.setFrustum(Math.tan(angleLeft) * zNear, Math.tan(angleRight) * zNear, Math.tan(angleDown) * zNear, Math.tan(angleUp) * zNear, zNear, zFar, zZeroToOne);
    }

    public Matrix4f setPerspectiveOffCenterFovLH(float angleLeft, float angleRight, float angleDown, float angleUp, float zNear, float zFar) {
        return this.setPerspectiveOffCenterFovLH(angleLeft, angleRight, angleDown, angleUp, zNear, zFar, false);
    }

    public Matrix4f setPerspectiveOffCenterFovLH(float angleLeft, float angleRight, float angleDown, float angleUp, float zNear, float zFar, boolean zZeroToOne) {
        return this.setFrustumLH(Math.tan(angleLeft) * zNear, Math.tan(angleRight) * zNear, Math.tan(angleDown) * zNear, Math.tan(angleUp) * zNear, zNear, zFar, zZeroToOne);
    }

    public Matrix4f perspectiveLH(float fovy, float aspect, float zNear, float zFar, boolean zZeroToOne, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.setPerspectiveLH(fovy, aspect, zNear, zFar, zZeroToOne);
        }
        return this.perspectiveLHGeneric(fovy, aspect, zNear, zFar, zZeroToOne, dest);
    }

    private Matrix4f perspectiveLHGeneric(float fovy, float aspect, float zNear, float zFar, boolean zZeroToOne, Matrix4f dest) {
        float rm32;
        float rm22;
        float e2;
        boolean nearInf;
        float h2 = Math.tan(fovy * 0.5f);
        float rm00 = 1.0f / (h2 * aspect);
        float rm11 = 1.0f / h2;
        boolean farInf = zFar > 0.0f && Float.isInfinite(zFar);
        boolean bl2 = nearInf = zNear > 0.0f && Float.isInfinite(zNear);
        if (farInf) {
            e2 = 1.0E-6f;
            rm22 = 1.0f - e2;
            rm32 = (e2 - (zZeroToOne ? 1.0f : 2.0f)) * zNear;
        } else if (nearInf) {
            e2 = 1.0E-6f;
            rm22 = (zZeroToOne ? 0.0f : 1.0f) - e2;
            rm32 = ((zZeroToOne ? 1.0f : 2.0f) - e2) * zFar;
        } else {
            rm22 = (zZeroToOne ? zFar : zFar + zNear) / (zFar - zNear);
            rm32 = (zZeroToOne ? zFar : zFar + zFar) * zNear / (zNear - zFar);
        }
        float nm20 = this.m20() * rm22 + this.m30();
        float nm21 = this.m21() * rm22 + this.m31();
        float nm22 = this.m22() * rm22 + this.m32();
        float nm23 = this.m23() * rm22 + this.m33();
        dest._m00(this.m00() * rm00)._m01(this.m01() * rm00)._m02(this.m02() * rm00)._m03(this.m03() * rm00)._m10(this.m10() * rm11)._m11(this.m11() * rm11)._m12(this.m12() * rm11)._m13(this.m13() * rm11)._m30(this.m20() * rm32)._m31(this.m21() * rm32)._m32(this.m22() * rm32)._m33(this.m23() * rm32)._m20(nm20)._m21(nm21)._m22(nm22)._m23(nm23)._properties(this.properties & 0xFFFFFFE1);
        return dest;
    }

    public Matrix4f perspectiveLH(float fovy, float aspect, float zNear, float zFar, boolean zZeroToOne) {
        return this.perspectiveLH(fovy, aspect, zNear, zFar, zZeroToOne, this);
    }

    public Matrix4f perspectiveLH(float fovy, float aspect, float zNear, float zFar, Matrix4f dest) {
        return this.perspectiveLH(fovy, aspect, zNear, zFar, false, dest);
    }

    public Matrix4f perspectiveLH(float fovy, float aspect, float zNear, float zFar) {
        return this.perspectiveLH(fovy, aspect, zNear, zFar, this);
    }

    public Matrix4f setPerspectiveLH(float fovy, float aspect, float zNear, float zFar, boolean zZeroToOne) {
        boolean nearInf;
        MemUtil.INSTANCE.zero(this);
        float h2 = Math.tan(fovy * 0.5f);
        this._m00(1.0f / (h2 * aspect))._m11(1.0f / h2);
        boolean farInf = zFar > 0.0f && Float.isInfinite(zFar);
        boolean bl2 = nearInf = zNear > 0.0f && Float.isInfinite(zNear);
        if (farInf) {
            float e2 = 1.0E-6f;
            this._m22(1.0f - e2)._m32((e2 - (zZeroToOne ? 1.0f : 2.0f)) * zNear);
        } else if (nearInf) {
            float e3 = 1.0E-6f;
            this._m22((zZeroToOne ? 0.0f : 1.0f) - e3)._m32(((zZeroToOne ? 1.0f : 2.0f) - e3) * zFar);
        } else {
            this._m22((zZeroToOne ? zFar : zFar + zNear) / (zFar - zNear))._m32((zZeroToOne ? zFar : zFar + zFar) * zNear / (zNear - zFar));
        }
        this._m23(1.0f)._properties(1);
        return this;
    }

    public Matrix4f setPerspectiveLH(float fovy, float aspect, float zNear, float zFar) {
        return this.setPerspectiveLH(fovy, aspect, zNear, zFar, false);
    }

    public Matrix4f frustum(float left, float right, float bottom, float top, float zNear, float zFar, boolean zZeroToOne, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.setFrustum(left, right, bottom, top, zNear, zFar, zZeroToOne);
        }
        return this.frustumGeneric(left, right, bottom, top, zNear, zFar, zZeroToOne, dest);
    }

    private Matrix4f frustumGeneric(float left, float right, float bottom, float top, float zNear, float zFar, boolean zZeroToOne, Matrix4f dest) {
        float rm32;
        float rm22;
        float e2;
        boolean nearInf;
        float rm00 = (zNear + zNear) / (right - left);
        float rm11 = (zNear + zNear) / (top - bottom);
        float rm20 = (right + left) / (right - left);
        float rm21 = (top + bottom) / (top - bottom);
        boolean farInf = zFar > 0.0f && Float.isInfinite(zFar);
        boolean bl2 = nearInf = zNear > 0.0f && Float.isInfinite(zNear);
        if (farInf) {
            e2 = 1.0E-6f;
            rm22 = e2 - 1.0f;
            rm32 = (e2 - (zZeroToOne ? 1.0f : 2.0f)) * zNear;
        } else if (nearInf) {
            e2 = 1.0E-6f;
            rm22 = (zZeroToOne ? 0.0f : 1.0f) - e2;
            rm32 = ((zZeroToOne ? 1.0f : 2.0f) - e2) * zFar;
        } else {
            rm22 = (zZeroToOne ? zFar : zFar + zNear) / (zNear - zFar);
            rm32 = (zZeroToOne ? zFar : zFar + zFar) * zNear / (zNear - zFar);
        }
        float nm20 = this.m00() * rm20 + this.m10() * rm21 + this.m20() * rm22 - this.m30();
        float nm21 = this.m01() * rm20 + this.m11() * rm21 + this.m21() * rm22 - this.m31();
        float nm22 = this.m02() * rm20 + this.m12() * rm21 + this.m22() * rm22 - this.m32();
        float nm23 = this.m03() * rm20 + this.m13() * rm21 + this.m23() * rm22 - this.m33();
        dest._m00(this.m00() * rm00)._m01(this.m01() * rm00)._m02(this.m02() * rm00)._m03(this.m03() * rm00)._m10(this.m10() * rm11)._m11(this.m11() * rm11)._m12(this.m12() * rm11)._m13(this.m13() * rm11)._m30(this.m20() * rm32)._m31(this.m21() * rm32)._m32(this.m22() * rm32)._m33(this.m23() * rm32)._m20(nm20)._m21(nm21)._m22(nm22)._m23(nm23)._properties(0);
        return dest;
    }

    public Matrix4f frustum(float left, float right, float bottom, float top, float zNear, float zFar, Matrix4f dest) {
        return this.frustum(left, right, bottom, top, zNear, zFar, false, dest);
    }

    public Matrix4f frustum(float left, float right, float bottom, float top, float zNear, float zFar, boolean zZeroToOne) {
        return this.frustum(left, right, bottom, top, zNear, zFar, zZeroToOne, this);
    }

    public Matrix4f frustum(float left, float right, float bottom, float top, float zNear, float zFar) {
        return this.frustum(left, right, bottom, top, zNear, zFar, this);
    }

    public Matrix4f setFrustum(float left, float right, float bottom, float top, float zNear, float zFar, boolean zZeroToOne) {
        boolean nearInf;
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        this._m00((zNear + zNear) / (right - left))._m11((zNear + zNear) / (top - bottom))._m20((right + left) / (right - left))._m21((top + bottom) / (top - bottom));
        boolean farInf = zFar > 0.0f && Float.isInfinite(zFar);
        boolean bl2 = nearInf = zNear > 0.0f && Float.isInfinite(zNear);
        if (farInf) {
            float e2 = 1.0E-6f;
            this._m22(e2 - 1.0f)._m32((e2 - (zZeroToOne ? 1.0f : 2.0f)) * zNear);
        } else if (nearInf) {
            float e3 = 1.0E-6f;
            this._m22((zZeroToOne ? 0.0f : 1.0f) - e3)._m32(((zZeroToOne ? 1.0f : 2.0f) - e3) * zFar);
        } else {
            this._m22((zZeroToOne ? zFar : zFar + zNear) / (zNear - zFar))._m32((zZeroToOne ? zFar : zFar + zFar) * zNear / (zNear - zFar));
        }
        this._m23(-1.0f)._m33(0.0f)._properties(this.m20() == 0.0f && this.m21() == 0.0f ? 1 : 0);
        return this;
    }

    public Matrix4f setFrustum(float left, float right, float bottom, float top, float zNear, float zFar) {
        return this.setFrustum(left, right, bottom, top, zNear, zFar, false);
    }

    public Matrix4f frustumLH(float left, float right, float bottom, float top, float zNear, float zFar, boolean zZeroToOne, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.setFrustumLH(left, right, bottom, top, zNear, zFar, zZeroToOne);
        }
        return this.frustumLHGeneric(left, right, bottom, top, zNear, zFar, zZeroToOne, dest);
    }

    private Matrix4f frustumLHGeneric(float left, float right, float bottom, float top, float zNear, float zFar, boolean zZeroToOne, Matrix4f dest) {
        float rm32;
        float rm22;
        float e2;
        boolean nearInf;
        float rm00 = (zNear + zNear) / (right - left);
        float rm11 = (zNear + zNear) / (top - bottom);
        float rm20 = (right + left) / (right - left);
        float rm21 = (top + bottom) / (top - bottom);
        boolean farInf = zFar > 0.0f && Float.isInfinite(zFar);
        boolean bl2 = nearInf = zNear > 0.0f && Float.isInfinite(zNear);
        if (farInf) {
            e2 = 1.0E-6f;
            rm22 = 1.0f - e2;
            rm32 = (e2 - (zZeroToOne ? 1.0f : 2.0f)) * zNear;
        } else if (nearInf) {
            e2 = 1.0E-6f;
            rm22 = (zZeroToOne ? 0.0f : 1.0f) - e2;
            rm32 = ((zZeroToOne ? 1.0f : 2.0f) - e2) * zFar;
        } else {
            rm22 = (zZeroToOne ? zFar : zFar + zNear) / (zFar - zNear);
            rm32 = (zZeroToOne ? zFar : zFar + zFar) * zNear / (zNear - zFar);
        }
        float nm20 = this.m00() * rm20 + this.m10() * rm21 + this.m20() * rm22 + this.m30();
        float nm21 = this.m01() * rm20 + this.m11() * rm21 + this.m21() * rm22 + this.m31();
        float nm22 = this.m02() * rm20 + this.m12() * rm21 + this.m22() * rm22 + this.m32();
        float nm23 = this.m03() * rm20 + this.m13() * rm21 + this.m23() * rm22 + this.m33();
        dest._m00(this.m00() * rm00)._m01(this.m01() * rm00)._m02(this.m02() * rm00)._m03(this.m03() * rm00)._m10(this.m10() * rm11)._m11(this.m11() * rm11)._m12(this.m12() * rm11)._m13(this.m13() * rm11)._m30(this.m20() * rm32)._m31(this.m21() * rm32)._m32(this.m22() * rm32)._m33(this.m23() * rm32)._m20(nm20)._m21(nm21)._m22(nm22)._m23(nm23)._properties(0);
        return dest;
    }

    public Matrix4f frustumLH(float left, float right, float bottom, float top, float zNear, float zFar, boolean zZeroToOne) {
        return this.frustumLH(left, right, bottom, top, zNear, zFar, zZeroToOne, this);
    }

    public Matrix4f frustumLH(float left, float right, float bottom, float top, float zNear, float zFar, Matrix4f dest) {
        return this.frustumLH(left, right, bottom, top, zNear, zFar, false, dest);
    }

    public Matrix4f frustumLH(float left, float right, float bottom, float top, float zNear, float zFar) {
        return this.frustumLH(left, right, bottom, top, zNear, zFar, this);
    }

    public Matrix4f setFrustumLH(float left, float right, float bottom, float top, float zNear, float zFar, boolean zZeroToOne) {
        boolean nearInf;
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        this._m00((zNear + zNear) / (right - left))._m11((zNear + zNear) / (top - bottom))._m20((right + left) / (right - left))._m21((top + bottom) / (top - bottom));
        boolean farInf = zFar > 0.0f && Float.isInfinite(zFar);
        boolean bl2 = nearInf = zNear > 0.0f && Float.isInfinite(zNear);
        if (farInf) {
            float e2 = 1.0E-6f;
            this._m22(1.0f - e2)._m32((e2 - (zZeroToOne ? 1.0f : 2.0f)) * zNear);
        } else if (nearInf) {
            float e3 = 1.0E-6f;
            this._m22((zZeroToOne ? 0.0f : 1.0f) - e3)._m32(((zZeroToOne ? 1.0f : 2.0f) - e3) * zFar);
        } else {
            this._m22((zZeroToOne ? zFar : zFar + zNear) / (zFar - zNear))._m32((zZeroToOne ? zFar : zFar + zFar) * zNear / (zNear - zFar));
        }
        return this._m23(1.0f)._m33(0.0f)._properties(0);
    }

    public Matrix4f setFrustumLH(float left, float right, float bottom, float top, float zNear, float zFar) {
        return this.setFrustumLH(left, right, bottom, top, zNear, zFar, false);
    }

    public Matrix4f setFromIntrinsic(float alphaX, float alphaY, float gamma, float u0, float v0, int imgWidth, int imgHeight, float near, float far) {
        float l00 = 2.0f / (float)imgWidth;
        float l11 = 2.0f / (float)imgHeight;
        float l22 = 2.0f / (near - far);
        return this._m00(l00 * alphaX)._m01(0.0f)._m02(0.0f)._m03(0.0f)._m10(l00 * gamma)._m11(l11 * alphaY)._m12(0.0f)._m13(0.0f)._m20(l00 * u0 - 1.0f)._m21(l11 * v0 - 1.0f)._m22(l22 * -(near + far) + (far + near) / (near - far))._m23(-1.0f)._m30(0.0f)._m31(0.0f)._m32(l22 * -near * far)._m33(0.0f)._properties(1);
    }

    public Matrix4f rotate(Quaternionfc quat, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.rotation(quat);
        }
        if ((this.properties & 8) != 0) {
            return this.rotateTranslation(quat, dest);
        }
        if ((this.properties & 2) != 0) {
            return this.rotateAffine(quat, dest);
        }
        return this.rotateGeneric(quat, dest);
    }

    private Matrix4f rotateGeneric(Quaternionfc quat, Matrix4f dest) {
        float w2 = quat.w() * quat.w();
        float x2 = quat.x() * quat.x();
        float y2 = quat.y() * quat.y();
        float z2 = quat.z() * quat.z();
        float zw = quat.z() * quat.w();
        float dzw = zw + zw;
        float xy = quat.x() * quat.y();
        float dxy = xy + xy;
        float xz = quat.x() * quat.z();
        float dxz = xz + xz;
        float yw = quat.y() * quat.w();
        float dyw = yw + yw;
        float yz = quat.y() * quat.z();
        float dyz = yz + yz;
        float xw = quat.x() * quat.w();
        float dxw = xw + xw;
        float rm00 = w2 + x2 - z2 - y2;
        float rm01 = dxy + dzw;
        float rm02 = dxz - dyw;
        float rm10 = -dzw + dxy;
        float rm11 = y2 - z2 + w2 - x2;
        float rm12 = dyz + dxw;
        float rm20 = dyw + dxz;
        float rm21 = dyz - dxw;
        float rm22 = z2 - y2 - x2 + w2;
        float nm00 = this.m00() * rm00 + this.m10() * rm01 + this.m20() * rm02;
        float nm01 = this.m01() * rm00 + this.m11() * rm01 + this.m21() * rm02;
        float nm02 = this.m02() * rm00 + this.m12() * rm01 + this.m22() * rm02;
        float nm03 = this.m03() * rm00 + this.m13() * rm01 + this.m23() * rm02;
        float nm10 = this.m00() * rm10 + this.m10() * rm11 + this.m20() * rm12;
        float nm11 = this.m01() * rm10 + this.m11() * rm11 + this.m21() * rm12;
        float nm12 = this.m02() * rm10 + this.m12() * rm11 + this.m22() * rm12;
        float nm13 = this.m03() * rm10 + this.m13() * rm11 + this.m23() * rm12;
        return dest._m20(this.m00() * rm20 + this.m10() * rm21 + this.m20() * rm22)._m21(this.m01() * rm20 + this.m11() * rm21 + this.m21() * rm22)._m22(this.m02() * rm20 + this.m12() * rm21 + this.m22() * rm22)._m23(this.m03() * rm20 + this.m13() * rm21 + this.m23() * rm22)._m00(nm00)._m01(nm01)._m02(nm02)._m03(nm03)._m10(nm10)._m11(nm11)._m12(nm12)._m13(nm13)._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0xFFFFFFF2);
    }

    public Matrix4f rotate(Quaternionfc quat) {
        return this.rotate(quat, this);
    }

    public Matrix4f rotateAffine(Quaternionfc quat, Matrix4f dest) {
        float w2 = quat.w() * quat.w();
        float x2 = quat.x() * quat.x();
        float y2 = quat.y() * quat.y();
        float z2 = quat.z() * quat.z();
        float zw = quat.z() * quat.w();
        float dzw = zw + zw;
        float xy = quat.x() * quat.y();
        float dxy = xy + xy;
        float xz = quat.x() * quat.z();
        float dxz = xz + xz;
        float yw = quat.y() * quat.w();
        float dyw = yw + yw;
        float yz = quat.y() * quat.z();
        float dyz = yz + yz;
        float xw = quat.x() * quat.w();
        float dxw = xw + xw;
        float rm00 = w2 + x2 - z2 - y2;
        float rm01 = dxy + dzw;
        float rm02 = dxz - dyw;
        float rm10 = -dzw + dxy;
        float rm11 = y2 - z2 + w2 - x2;
        float rm12 = dyz + dxw;
        float rm20 = dyw + dxz;
        float rm21 = dyz - dxw;
        float rm22 = z2 - y2 - x2 + w2;
        float nm00 = this.m00() * rm00 + this.m10() * rm01 + this.m20() * rm02;
        float nm01 = this.m01() * rm00 + this.m11() * rm01 + this.m21() * rm02;
        float nm02 = this.m02() * rm00 + this.m12() * rm01 + this.m22() * rm02;
        float nm10 = this.m00() * rm10 + this.m10() * rm11 + this.m20() * rm12;
        float nm11 = this.m01() * rm10 + this.m11() * rm11 + this.m21() * rm12;
        float nm12 = this.m02() * rm10 + this.m12() * rm11 + this.m22() * rm12;
        return dest._m20(this.m00() * rm20 + this.m10() * rm21 + this.m20() * rm22)._m21(this.m01() * rm20 + this.m11() * rm21 + this.m21() * rm22)._m22(this.m02() * rm20 + this.m12() * rm21 + this.m22() * rm22)._m23(0.0f)._m00(nm00)._m01(nm01)._m02(nm02)._m03(0.0f)._m10(nm10)._m11(nm11)._m12(nm12)._m13(0.0f)._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0xFFFFFFF2);
    }

    public Matrix4f rotateAffine(Quaternionfc quat) {
        return this.rotateAffine(quat, this);
    }

    public Matrix4f rotateTranslation(Quaternionfc quat, Matrix4f dest) {
        float w2 = quat.w() * quat.w();
        float x2 = quat.x() * quat.x();
        float y2 = quat.y() * quat.y();
        float z2 = quat.z() * quat.z();
        float zw = quat.z() * quat.w();
        float dzw = zw + zw;
        float xy = quat.x() * quat.y();
        float dxy = xy + xy;
        float xz = quat.x() * quat.z();
        float dxz = xz + xz;
        float yw = quat.y() * quat.w();
        float dyw = yw + yw;
        float yz = quat.y() * quat.z();
        float dyz = yz + yz;
        float xw = quat.x() * quat.w();
        float dxw = xw + xw;
        float rm00 = w2 + x2 - z2 - y2;
        float rm01 = dxy + dzw;
        float rm02 = dxz - dyw;
        float rm10 = -dzw + dxy;
        float rm11 = y2 - z2 + w2 - x2;
        float rm12 = dyz + dxw;
        float rm20 = dyw + dxz;
        float rm21 = dyz - dxw;
        float rm22 = z2 - y2 - x2 + w2;
        return dest._m20(rm20)._m21(rm21)._m22(rm22)._m23(0.0f)._m00(rm00)._m01(rm01)._m02(rm02)._m03(0.0f)._m10(rm10)._m11(rm11)._m12(rm12)._m13(0.0f)._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0xFFFFFFF2);
    }

    public Matrix4f rotateAround(Quaternionfc quat, float ox, float oy, float oz) {
        return this.rotateAround(quat, ox, oy, oz, this);
    }

    public Matrix4f rotateAroundAffine(Quaternionfc quat, float ox, float oy, float oz, Matrix4f dest) {
        float w2 = quat.w() * quat.w();
        float x2 = quat.x() * quat.x();
        float y2 = quat.y() * quat.y();
        float z2 = quat.z() * quat.z();
        float zw = quat.z() * quat.w();
        float dzw = zw + zw;
        float xy = quat.x() * quat.y();
        float dxy = xy + xy;
        float xz = quat.x() * quat.z();
        float dxz = xz + xz;
        float yw = quat.y() * quat.w();
        float dyw = yw + yw;
        float yz = quat.y() * quat.z();
        float dyz = yz + yz;
        float xw = quat.x() * quat.w();
        float dxw = xw + xw;
        float rm00 = w2 + x2 - z2 - y2;
        float rm01 = dxy + dzw;
        float rm02 = dxz - dyw;
        float rm10 = -dzw + dxy;
        float rm11 = y2 - z2 + w2 - x2;
        float rm12 = dyz + dxw;
        float rm20 = dyw + dxz;
        float rm21 = dyz - dxw;
        float rm22 = z2 - y2 - x2 + w2;
        float tm30 = this.m00() * ox + this.m10() * oy + this.m20() * oz + this.m30();
        float tm31 = this.m01() * ox + this.m11() * oy + this.m21() * oz + this.m31();
        float tm32 = this.m02() * ox + this.m12() * oy + this.m22() * oz + this.m32();
        float nm00 = this.m00() * rm00 + this.m10() * rm01 + this.m20() * rm02;
        float nm01 = this.m01() * rm00 + this.m11() * rm01 + this.m21() * rm02;
        float nm02 = this.m02() * rm00 + this.m12() * rm01 + this.m22() * rm02;
        float nm10 = this.m00() * rm10 + this.m10() * rm11 + this.m20() * rm12;
        float nm11 = this.m01() * rm10 + this.m11() * rm11 + this.m21() * rm12;
        float nm12 = this.m02() * rm10 + this.m12() * rm11 + this.m22() * rm12;
        dest._m20(this.m00() * rm20 + this.m10() * rm21 + this.m20() * rm22)._m21(this.m01() * rm20 + this.m11() * rm21 + this.m21() * rm22)._m22(this.m02() * rm20 + this.m12() * rm21 + this.m22() * rm22)._m23(0.0f)._m00(nm00)._m01(nm01)._m02(nm02)._m03(0.0f)._m10(nm10)._m11(nm11)._m12(nm12)._m13(0.0f)._m30(-nm00 * ox - nm10 * oy - this.m20() * oz + tm30)._m31(-nm01 * ox - nm11 * oy - this.m21() * oz + tm31)._m32(-nm02 * ox - nm12 * oy - this.m22() * oz + tm32)._m33(1.0f)._properties(this.properties & 0xFFFFFFF2);
        return dest;
    }

    public Matrix4f rotateAround(Quaternionfc quat, float ox, float oy, float oz, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return this.rotationAround(quat, ox, oy, oz);
        }
        if ((this.properties & 2) != 0) {
            return this.rotateAroundAffine(quat, ox, oy, oz, dest);
        }
        return this.rotateAroundGeneric(quat, ox, oy, oz, dest);
    }

    private Matrix4f rotateAroundGeneric(Quaternionfc quat, float ox, float oy, float oz, Matrix4f dest) {
        float w2 = quat.w() * quat.w();
        float x2 = quat.x() * quat.x();
        float y2 = quat.y() * quat.y();
        float z2 = quat.z() * quat.z();
        float zw = quat.z() * quat.w();
        float dzw = zw + zw;
        float xy = quat.x() * quat.y();
        float dxy = xy + xy;
        float xz = quat.x() * quat.z();
        float dxz = xz + xz;
        float yw = quat.y() * quat.w();
        float dyw = yw + yw;
        float yz = quat.y() * quat.z();
        float dyz = yz + yz;
        float xw = quat.x() * quat.w();
        float dxw = xw + xw;
        float rm00 = w2 + x2 - z2 - y2;
        float rm01 = dxy + dzw;
        float rm02 = dxz - dyw;
        float rm10 = -dzw + dxy;
        float rm11 = y2 - z2 + w2 - x2;
        float rm12 = dyz + dxw;
        float rm20 = dyw + dxz;
        float rm21 = dyz - dxw;
        float rm22 = z2 - y2 - x2 + w2;
        float tm30 = this.m00() * ox + this.m10() * oy + this.m20() * oz + this.m30();
        float tm31 = this.m01() * ox + this.m11() * oy + this.m21() * oz + this.m31();
        float tm32 = this.m02() * ox + this.m12() * oy + this.m22() * oz + this.m32();
        float nm00 = this.m00() * rm00 + this.m10() * rm01 + this.m20() * rm02;
        float nm01 = this.m01() * rm00 + this.m11() * rm01 + this.m21() * rm02;
        float nm02 = this.m02() * rm00 + this.m12() * rm01 + this.m22() * rm02;
        float nm03 = this.m03() * rm00 + this.m13() * rm01 + this.m23() * rm02;
        float nm10 = this.m00() * rm10 + this.m10() * rm11 + this.m20() * rm12;
        float nm11 = this.m01() * rm10 + this.m11() * rm11 + this.m21() * rm12;
        float nm12 = this.m02() * rm10 + this.m12() * rm11 + this.m22() * rm12;
        float nm13 = this.m03() * rm10 + this.m13() * rm11 + this.m23() * rm12;
        dest._m20(this.m00() * rm20 + this.m10() * rm21 + this.m20() * rm22)._m21(this.m01() * rm20 + this.m11() * rm21 + this.m21() * rm22)._m22(this.m02() * rm20 + this.m12() * rm21 + this.m22() * rm22)._m23(this.m03() * rm20 + this.m13() * rm21 + this.m23() * rm22)._m00(nm00)._m01(nm01)._m02(nm02)._m03(nm03)._m10(nm10)._m11(nm11)._m12(nm12)._m13(nm13)._m30(-nm00 * ox - nm10 * oy - this.m20() * oz + tm30)._m31(-nm01 * ox - nm11 * oy - this.m21() * oz + tm31)._m32(-nm02 * ox - nm12 * oy - this.m22() * oz + tm32)._m33(this.m33())._properties(this.properties & 0xFFFFFFF2);
        return dest;
    }

    public Matrix4f rotationAround(Quaternionfc quat, float ox, float oy, float oz) {
        float w2 = quat.w() * quat.w();
        float x2 = quat.x() * quat.x();
        float y2 = quat.y() * quat.y();
        float z2 = quat.z() * quat.z();
        float zw = quat.z() * quat.w();
        float dzw = zw + zw;
        float xy = quat.x() * quat.y();
        float dxy = xy + xy;
        float xz = quat.x() * quat.z();
        float dxz = xz + xz;
        float yw = quat.y() * quat.w();
        float dyw = yw + yw;
        float yz = quat.y() * quat.z();
        float dyz = yz + yz;
        float xw = quat.x() * quat.w();
        float dxw = xw + xw;
        this._m20(dyw + dxz)._m21(dyz - dxw)._m22(z2 - y2 - x2 + w2)._m23(0.0f)._m00(w2 + x2 - z2 - y2)._m01(dxy + dzw)._m02(dxz - dyw)._m03(0.0f)._m10(-dzw + dxy)._m11(y2 - z2 + w2 - x2)._m12(dyz + dxw)._m13(0.0f)._m30(-this.m00() * ox - this.m10() * oy - this.m20() * oz + ox)._m31(-this.m01() * ox - this.m11() * oy - this.m21() * oz + oy)._m32(-this.m02() * ox - this.m12() * oy - this.m22() * oz + oz)._m33(1.0f)._properties(18);
        return this;
    }

    public Matrix4f rotateLocal(Quaternionfc quat, Matrix4f dest) {
        float w2 = quat.w() * quat.w();
        float x2 = quat.x() * quat.x();
        float y2 = quat.y() * quat.y();
        float z2 = quat.z() * quat.z();
        float zw = quat.z() * quat.w();
        float dzw = zw + zw;
        float xy = quat.x() * quat.y();
        float dxy = xy + xy;
        float xz = quat.x() * quat.z();
        float dxz = xz + xz;
        float yw = quat.y() * quat.w();
        float dyw = yw + yw;
        float yz = quat.y() * quat.z();
        float dyz = yz + yz;
        float xw = quat.x() * quat.w();
        float dxw = xw + xw;
        float lm00 = w2 + x2 - z2 - y2;
        float lm01 = dxy + dzw;
        float lm02 = dxz - dyw;
        float lm10 = -dzw + dxy;
        float lm11 = y2 - z2 + w2 - x2;
        float lm12 = dyz + dxw;
        float lm20 = dyw + dxz;
        float lm21 = dyz - dxw;
        float lm22 = z2 - y2 - x2 + w2;
        float nm00 = lm00 * this.m00() + lm10 * this.m01() + lm20 * this.m02();
        float nm01 = lm01 * this.m00() + lm11 * this.m01() + lm21 * this.m02();
        float nm02 = lm02 * this.m00() + lm12 * this.m01() + lm22 * this.m02();
        float nm10 = lm00 * this.m10() + lm10 * this.m11() + lm20 * this.m12();
        float nm11 = lm01 * this.m10() + lm11 * this.m11() + lm21 * this.m12();
        float nm12 = lm02 * this.m10() + lm12 * this.m11() + lm22 * this.m12();
        float nm20 = lm00 * this.m20() + lm10 * this.m21() + lm20 * this.m22();
        float nm21 = lm01 * this.m20() + lm11 * this.m21() + lm21 * this.m22();
        float nm22 = lm02 * this.m20() + lm12 * this.m21() + lm22 * this.m22();
        float nm30 = lm00 * this.m30() + lm10 * this.m31() + lm20 * this.m32();
        float nm31 = lm01 * this.m30() + lm11 * this.m31() + lm21 * this.m32();
        float nm32 = lm02 * this.m30() + lm12 * this.m31() + lm22 * this.m32();
        return dest._m00(nm00)._m01(nm01)._m02(nm02)._m03(this.m03())._m10(nm10)._m11(nm11)._m12(nm12)._m13(this.m13())._m20(nm20)._m21(nm21)._m22(nm22)._m23(this.m23())._m30(nm30)._m31(nm31)._m32(nm32)._m33(this.m33())._properties(this.properties & 0xFFFFFFF2);
    }

    public Matrix4f rotateLocal(Quaternionfc quat) {
        return this.rotateLocal(quat, this);
    }

    public Matrix4f rotateAroundLocal(Quaternionfc quat, float ox, float oy, float oz, Matrix4f dest) {
        float w2 = quat.w() * quat.w();
        float x2 = quat.x() * quat.x();
        float y2 = quat.y() * quat.y();
        float z2 = quat.z() * quat.z();
        float zw = quat.z() * quat.w();
        float xy = quat.x() * quat.y();
        float xz = quat.x() * quat.z();
        float yw = quat.y() * quat.w();
        float yz = quat.y() * quat.z();
        float xw = quat.x() * quat.w();
        float lm00 = w2 + x2 - z2 - y2;
        float lm01 = xy + zw + zw + xy;
        float lm02 = xz - yw + xz - yw;
        float lm10 = -zw + xy - zw + xy;
        float lm11 = y2 - z2 + w2 - x2;
        float lm12 = yz + yz + xw + xw;
        float lm20 = yw + xz + xz + yw;
        float lm21 = yz + yz - xw - xw;
        float lm22 = z2 - y2 - x2 + w2;
        float tm00 = this.m00() - ox * this.m03();
        float tm01 = this.m01() - oy * this.m03();
        float tm02 = this.m02() - oz * this.m03();
        float tm10 = this.m10() - ox * this.m13();
        float tm11 = this.m11() - oy * this.m13();
        float tm12 = this.m12() - oz * this.m13();
        float tm20 = this.m20() - ox * this.m23();
        float tm21 = this.m21() - oy * this.m23();
        float tm22 = this.m22() - oz * this.m23();
        float tm30 = this.m30() - ox * this.m33();
        float tm31 = this.m31() - oy * this.m33();
        float tm32 = this.m32() - oz * this.m33();
        dest._m00(lm00 * tm00 + lm10 * tm01 + lm20 * tm02 + ox * this.m03())._m01(lm01 * tm00 + lm11 * tm01 + lm21 * tm02 + oy * this.m03())._m02(lm02 * tm00 + lm12 * tm01 + lm22 * tm02 + oz * this.m03())._m03(this.m03())._m10(lm00 * tm10 + lm10 * tm11 + lm20 * tm12 + ox * this.m13())._m11(lm01 * tm10 + lm11 * tm11 + lm21 * tm12 + oy * this.m13())._m12(lm02 * tm10 + lm12 * tm11 + lm22 * tm12 + oz * this.m13())._m13(this.m13())._m20(lm00 * tm20 + lm10 * tm21 + lm20 * tm22 + ox * this.m23())._m21(lm01 * tm20 + lm11 * tm21 + lm21 * tm22 + oy * this.m23())._m22(lm02 * tm20 + lm12 * tm21 + lm22 * tm22 + oz * this.m23())._m23(this.m23())._m30(lm00 * tm30 + lm10 * tm31 + lm20 * tm32 + ox * this.m33())._m31(lm01 * tm30 + lm11 * tm31 + lm21 * tm32 + oy * this.m33())._m32(lm02 * tm30 + lm12 * tm31 + lm22 * tm32 + oz * this.m33())._m33(this.m33())._properties(this.properties & 0xFFFFFFF2);
        return dest;
    }

    public Matrix4f rotateAroundLocal(Quaternionfc quat, float ox, float oy, float oz) {
        return this.rotateAroundLocal(quat, ox, oy, oz, this);
    }

    public Matrix4f rotate(AxisAngle4f axisAngle) {
        return this.rotate(axisAngle.angle, axisAngle.x, axisAngle.y, axisAngle.z);
    }

    public Matrix4f rotate(AxisAngle4f axisAngle, Matrix4f dest) {
        return this.rotate(axisAngle.angle, axisAngle.x, axisAngle.y, axisAngle.z, dest);
    }

    public Matrix4f rotate(float angle, Vector3fc axis) {
        return this.rotate(angle, axis.x(), axis.y(), axis.z());
    }

    public Matrix4f rotate(float angle, Vector3fc axis, Matrix4f dest) {
        return this.rotate(angle, axis.x(), axis.y(), axis.z(), dest);
    }

    public Vector4f unproject(float winX, float winY, float winZ, int[] viewport, Vector4f dest) {
        float a2 = this.m00() * this.m11() - this.m01() * this.m10();
        float b2 = this.m00() * this.m12() - this.m02() * this.m10();
        float c2 = this.m00() * this.m13() - this.m03() * this.m10();
        float d2 = this.m01() * this.m12() - this.m02() * this.m11();
        float e2 = this.m01() * this.m13() - this.m03() * this.m11();
        float f2 = this.m02() * this.m13() - this.m03() * this.m12();
        float g2 = this.m20() * this.m31() - this.m21() * this.m30();
        float h2 = this.m20() * this.m32() - this.m22() * this.m30();
        float i2 = this.m20() * this.m33() - this.m23() * this.m30();
        float j2 = this.m21() * this.m32() - this.m22() * this.m31();
        float k2 = this.m21() * this.m33() - this.m23() * this.m31();
        float l2 = this.m22() * this.m33() - this.m23() * this.m32();
        float det = a2 * l2 - b2 * k2 + c2 * j2 + d2 * i2 - e2 * h2 + f2 * g2;
        det = 1.0f / det;
        float im00 = (this.m11() * l2 - this.m12() * k2 + this.m13() * j2) * det;
        float im01 = (-this.m01() * l2 + this.m02() * k2 - this.m03() * j2) * det;
        float im02 = (this.m31() * f2 - this.m32() * e2 + this.m33() * d2) * det;
        float im03 = (-this.m21() * f2 + this.m22() * e2 - this.m23() * d2) * det;
        float im10 = (-this.m10() * l2 + this.m12() * i2 - this.m13() * h2) * det;
        float im11 = (this.m00() * l2 - this.m02() * i2 + this.m03() * h2) * det;
        float im12 = (-this.m30() * f2 + this.m32() * c2 - this.m33() * b2) * det;
        float im13 = (this.m20() * f2 - this.m22() * c2 + this.m23() * b2) * det;
        float im20 = (this.m10() * k2 - this.m11() * i2 + this.m13() * g2) * det;
        float im21 = (-this.m00() * k2 + this.m01() * i2 - this.m03() * g2) * det;
        float im22 = (this.m30() * e2 - this.m31() * c2 + this.m33() * a2) * det;
        float im23 = (-this.m20() * e2 + this.m21() * c2 - this.m23() * a2) * det;
        float im30 = (-this.m10() * j2 + this.m11() * h2 - this.m12() * g2) * det;
        float im31 = (this.m00() * j2 - this.m01() * h2 + this.m02() * g2) * det;
        float im32 = (-this.m30() * d2 + this.m31() * b2 - this.m32() * a2) * det;
        float im33 = (this.m20() * d2 - this.m21() * b2 + this.m22() * a2) * det;
        float ndcX = (winX - (float)viewport[0]) / (float)viewport[2] * 2.0f - 1.0f;
        float ndcY = (winY - (float)viewport[1]) / (float)viewport[3] * 2.0f - 1.0f;
        float ndcZ = winZ + winZ - 1.0f;
        float invW = 1.0f / (im03 * ndcX + im13 * ndcY + im23 * ndcZ + im33);
        return dest.set((im00 * ndcX + im10 * ndcY + im20 * ndcZ + im30) * invW, (im01 * ndcX + im11 * ndcY + im21 * ndcZ + im31) * invW, (im02 * ndcX + im12 * ndcY + im22 * ndcZ + im32) * invW, 1.0f);
    }

    public Vector3f unproject(float winX, float winY, float winZ, int[] viewport, Vector3f dest) {
        float a2 = this.m00() * this.m11() - this.m01() * this.m10();
        float b2 = this.m00() * this.m12() - this.m02() * this.m10();
        float c2 = this.m00() * this.m13() - this.m03() * this.m10();
        float d2 = this.m01() * this.m12() - this.m02() * this.m11();
        float e2 = this.m01() * this.m13() - this.m03() * this.m11();
        float f2 = this.m02() * this.m13() - this.m03() * this.m12();
        float g2 = this.m20() * this.m31() - this.m21() * this.m30();
        float h2 = this.m20() * this.m32() - this.m22() * this.m30();
        float i2 = this.m20() * this.m33() - this.m23() * this.m30();
        float j2 = this.m21() * this.m32() - this.m22() * this.m31();
        float k2 = this.m21() * this.m33() - this.m23() * this.m31();
        float l2 = this.m22() * this.m33() - this.m23() * this.m32();
        float det = a2 * l2 - b2 * k2 + c2 * j2 + d2 * i2 - e2 * h2 + f2 * g2;
        det = 1.0f / det;
        float im00 = (this.m11() * l2 - this.m12() * k2 + this.m13() * j2) * det;
        float im01 = (-this.m01() * l2 + this.m02() * k2 - this.m03() * j2) * det;
        float im02 = (this.m31() * f2 - this.m32() * e2 + this.m33() * d2) * det;
        float im03 = (-this.m21() * f2 + this.m22() * e2 - this.m23() * d2) * det;
        float im10 = (-this.m10() * l2 + this.m12() * i2 - this.m13() * h2) * det;
        float im11 = (this.m00() * l2 - this.m02() * i2 + this.m03() * h2) * det;
        float im12 = (-this.m30() * f2 + this.m32() * c2 - this.m33() * b2) * det;
        float im13 = (this.m20() * f2 - this.m22() * c2 + this.m23() * b2) * det;
        float im20 = (this.m10() * k2 - this.m11() * i2 + this.m13() * g2) * det;
        float im21 = (-this.m00() * k2 + this.m01() * i2 - this.m03() * g2) * det;
        float im22 = (this.m30() * e2 - this.m31() * c2 + this.m33() * a2) * det;
        float im23 = (-this.m20() * e2 + this.m21() * c2 - this.m23() * a2) * det;
        float im30 = (-this.m10() * j2 + this.m11() * h2 - this.m12() * g2) * det;
        float im31 = (this.m00() * j2 - this.m01() * h2 + this.m02() * g2) * det;
        float im32 = (-this.m30() * d2 + this.m31() * b2 - this.m32() * a2) * det;
        float im33 = (this.m20() * d2 - this.m21() * b2 + this.m22() * a2) * det;
        float ndcX = (winX - (float)viewport[0]) / (float)viewport[2] * 2.0f - 1.0f;
        float ndcY = (winY - (float)viewport[1]) / (float)viewport[3] * 2.0f - 1.0f;
        float ndcZ = winZ + winZ - 1.0f;
        float invW = 1.0f / (im03 * ndcX + im13 * ndcY + im23 * ndcZ + im33);
        return dest.set((im00 * ndcX + im10 * ndcY + im20 * ndcZ + im30) * invW, (im01 * ndcX + im11 * ndcY + im21 * ndcZ + im31) * invW, (im02 * ndcX + im12 * ndcY + im22 * ndcZ + im32) * invW);
    }

    public Vector4f unproject(Vector3fc winCoords, int[] viewport, Vector4f dest) {
        return this.unproject(winCoords.x(), winCoords.y(), winCoords.z(), viewport, dest);
    }

    public Vector3f unproject(Vector3fc winCoords, int[] viewport, Vector3f dest) {
        return this.unproject(winCoords.x(), winCoords.y(), winCoords.z(), viewport, dest);
    }

    public Matrix4f unprojectRay(float winX, float winY, int[] viewport, Vector3f originDest, Vector3f dirDest) {
        float a2 = this.m00() * this.m11() - this.m01() * this.m10();
        float b2 = this.m00() * this.m12() - this.m02() * this.m10();
        float c2 = this.m00() * this.m13() - this.m03() * this.m10();
        float d2 = this.m01() * this.m12() - this.m02() * this.m11();
        float e2 = this.m01() * this.m13() - this.m03() * this.m11();
        float f2 = this.m02() * this.m13() - this.m03() * this.m12();
        float g2 = this.m20() * this.m31() - this.m21() * this.m30();
        float h2 = this.m20() * this.m32() - this.m22() * this.m30();
        float i2 = this.m20() * this.m33() - this.m23() * this.m30();
        float j2 = this.m21() * this.m32() - this.m22() * this.m31();
        float k2 = this.m21() * this.m33() - this.m23() * this.m31();
        float l2 = this.m22() * this.m33() - this.m23() * this.m32();
        float det = a2 * l2 - b2 * k2 + c2 * j2 + d2 * i2 - e2 * h2 + f2 * g2;
        det = 1.0f / det;
        float im00 = (this.m11() * l2 - this.m12() * k2 + this.m13() * j2) * det;
        float im01 = (-this.m01() * l2 + this.m02() * k2 - this.m03() * j2) * det;
        float im02 = (this.m31() * f2 - this.m32() * e2 + this.m33() * d2) * det;
        float im03 = (-this.m21() * f2 + this.m22() * e2 - this.m23() * d2) * det;
        float im10 = (-this.m10() * l2 + this.m12() * i2 - this.m13() * h2) * det;
        float im11 = (this.m00() * l2 - this.m02() * i2 + this.m03() * h2) * det;
        float im12 = (-this.m30() * f2 + this.m32() * c2 - this.m33() * b2) * det;
        float im13 = (this.m20() * f2 - this.m22() * c2 + this.m23() * b2) * det;
        float im20 = (this.m10() * k2 - this.m11() * i2 + this.m13() * g2) * det;
        float im21 = (-this.m00() * k2 + this.m01() * i2 - this.m03() * g2) * det;
        float im22 = (this.m30() * e2 - this.m31() * c2 + this.m33() * a2) * det;
        float im23 = (-this.m20() * e2 + this.m21() * c2 - this.m23() * a2) * det;
        float im30 = (-this.m10() * j2 + this.m11() * h2 - this.m12() * g2) * det;
        float im31 = (this.m00() * j2 - this.m01() * h2 + this.m02() * g2) * det;
        float im32 = (-this.m30() * d2 + this.m31() * b2 - this.m32() * a2) * det;
        float im33 = (this.m20() * d2 - this.m21() * b2 + this.m22() * a2) * det;
        float ndcX = (winX - (float)viewport[0]) / (float)viewport[2] * 2.0f - 1.0f;
        float ndcY = (winY - (float)viewport[1]) / (float)viewport[3] * 2.0f - 1.0f;
        float px = im00 * ndcX + im10 * ndcY + im30;
        float py = im01 * ndcX + im11 * ndcY + im31;
        float pz = im02 * ndcX + im12 * ndcY + im32;
        float invNearW = 1.0f / (im03 * ndcX + im13 * ndcY - im23 + im33);
        float nearX = (px - im20) * invNearW;
        float nearY = (py - im21) * invNearW;
        float nearZ = (pz - im22) * invNearW;
        float invW0 = 1.0f / (im03 * ndcX + im13 * ndcY + im33);
        float x0 = px * invW0;
        float y0 = py * invW0;
        float z0 = pz * invW0;
        originDest.x = nearX;
        originDest.y = nearY;
        originDest.z = nearZ;
        dirDest.x = x0 - nearX;
        dirDest.y = y0 - nearY;
        dirDest.z = z0 - nearZ;
        return this;
    }

    public Matrix4f unprojectRay(Vector2fc winCoords, int[] viewport, Vector3f originDest, Vector3f dirDest) {
        return this.unprojectRay(winCoords.x(), winCoords.y(), viewport, originDest, dirDest);
    }

    public Vector4f unprojectInv(Vector3fc winCoords, int[] viewport, Vector4f dest) {
        return this.unprojectInv(winCoords.x(), winCoords.y(), winCoords.z(), viewport, dest);
    }

    public Vector4f unprojectInv(float winX, float winY, float winZ, int[] viewport, Vector4f dest) {
        float ndcX = (winX - (float)viewport[0]) / (float)viewport[2] * 2.0f - 1.0f;
        float ndcY = (winY - (float)viewport[1]) / (float)viewport[3] * 2.0f - 1.0f;
        float ndcZ = winZ + winZ - 1.0f;
        float invW = 1.0f / (this.m03() * ndcX + this.m13() * ndcY + this.m23() * ndcZ + this.m33());
        return dest.set((this.m00() * ndcX + this.m10() * ndcY + this.m20() * ndcZ + this.m30()) * invW, (this.m01() * ndcX + this.m11() * ndcY + this.m21() * ndcZ + this.m31()) * invW, (this.m02() * ndcX + this.m12() * ndcY + this.m22() * ndcZ + this.m32()) * invW, 1.0f);
    }

    public Matrix4f unprojectInvRay(Vector2fc winCoords, int[] viewport, Vector3f originDest, Vector3f dirDest) {
        return this.unprojectInvRay(winCoords.x(), winCoords.y(), viewport, originDest, dirDest);
    }

    public Matrix4f unprojectInvRay(float winX, float winY, int[] viewport, Vector3f originDest, Vector3f dirDest) {
        float ndcX = (winX - (float)viewport[0]) / (float)viewport[2] * 2.0f - 1.0f;
        float ndcY = (winY - (float)viewport[1]) / (float)viewport[3] * 2.0f - 1.0f;
        float px = this.m00() * ndcX + this.m10() * ndcY + this.m30();
        float py = this.m01() * ndcX + this.m11() * ndcY + this.m31();
        float pz = this.m02() * ndcX + this.m12() * ndcY + this.m32();
        float invNearW = 1.0f / (this.m03() * ndcX + this.m13() * ndcY - this.m23() + this.m33());
        float nearX = (px - this.m20()) * invNearW;
        float nearY = (py - this.m21()) * invNearW;
        float nearZ = (pz - this.m22()) * invNearW;
        float invW0 = 1.0f / (this.m03() * ndcX + this.m13() * ndcY + this.m33());
        float x0 = px * invW0;
        float y0 = py * invW0;
        float z0 = pz * invW0;
        originDest.x = nearX;
        originDest.y = nearY;
        originDest.z = nearZ;
        dirDest.x = x0 - nearX;
        dirDest.y = y0 - nearY;
        dirDest.z = z0 - nearZ;
        return this;
    }

    public Vector3f unprojectInv(Vector3fc winCoords, int[] viewport, Vector3f dest) {
        return this.unprojectInv(winCoords.x(), winCoords.y(), winCoords.z(), viewport, dest);
    }

    public Vector3f unprojectInv(float winX, float winY, float winZ, int[] viewport, Vector3f dest) {
        float ndcX = (winX - (float)viewport[0]) / (float)viewport[2] * 2.0f - 1.0f;
        float ndcY = (winY - (float)viewport[1]) / (float)viewport[3] * 2.0f - 1.0f;
        float ndcZ = winZ + winZ - 1.0f;
        float invW = 1.0f / (this.m03() * ndcX + this.m13() * ndcY + this.m23() * ndcZ + this.m33());
        return dest.set((this.m00() * ndcX + this.m10() * ndcY + this.m20() * ndcZ + this.m30()) * invW, (this.m01() * ndcX + this.m11() * ndcY + this.m21() * ndcZ + this.m31()) * invW, (this.m02() * ndcX + this.m12() * ndcY + this.m22() * ndcZ + this.m32()) * invW);
    }

    public Vector4f project(float x2, float y2, float z2, int[] viewport, Vector4f winCoordsDest) {
        float invW = 1.0f / Math.fma(this.m03(), x2, Math.fma(this.m13(), y2, Math.fma(this.m23(), z2, this.m33())));
        float nx = Math.fma(this.m00(), x2, Math.fma(this.m10(), y2, Math.fma(this.m20(), z2, this.m30()))) * invW;
        float ny = Math.fma(this.m01(), x2, Math.fma(this.m11(), y2, Math.fma(this.m21(), z2, this.m31()))) * invW;
        float nz = Math.fma(this.m02(), x2, Math.fma(this.m12(), y2, Math.fma(this.m22(), z2, this.m32()))) * invW;
        return winCoordsDest.set(Math.fma(Math.fma(nx, 0.5f, 0.5f), viewport[2], viewport[0]), Math.fma(Math.fma(ny, 0.5f, 0.5f), viewport[3], viewport[1]), Math.fma(0.5f, nz, 0.5f), 1.0f);
    }

    public Vector3f project(float x2, float y2, float z2, int[] viewport, Vector3f winCoordsDest) {
        float invW = 1.0f / Math.fma(this.m03(), x2, Math.fma(this.m13(), y2, Math.fma(this.m23(), z2, this.m33())));
        float nx = Math.fma(this.m00(), x2, Math.fma(this.m10(), y2, Math.fma(this.m20(), z2, this.m30()))) * invW;
        float ny = Math.fma(this.m01(), x2, Math.fma(this.m11(), y2, Math.fma(this.m21(), z2, this.m31()))) * invW;
        float nz = Math.fma(this.m02(), x2, Math.fma(this.m12(), y2, Math.fma(this.m22(), z2, this.m32()))) * invW;
        winCoordsDest.x = Math.fma(Math.fma(nx, 0.5f, 0.5f), viewport[2], viewport[0]);
        winCoordsDest.y = Math.fma(Math.fma(ny, 0.5f, 0.5f), viewport[3], viewport[1]);
        winCoordsDest.z = Math.fma(0.5f, nz, 0.5f);
        return winCoordsDest;
    }

    public Vector4f project(Vector3fc position, int[] viewport, Vector4f winCoordsDest) {
        return this.project(position.x(), position.y(), position.z(), viewport, winCoordsDest);
    }

    public Vector3f project(Vector3fc position, int[] viewport, Vector3f winCoordsDest) {
        return this.project(position.x(), position.y(), position.z(), viewport, winCoordsDest);
    }

    public Matrix4f reflect(float a2, float b2, float c2, float d2, Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.reflection(a2, b2, c2, d2);
        }
        if ((this.properties & 2) != 0) {
            return this.reflectAffine(a2, b2, c2, d2, dest);
        }
        return this.reflectGeneric(a2, b2, c2, d2, dest);
    }

    private Matrix4f reflectAffine(float a2, float b2, float c2, float d2, Matrix4f dest) {
        float da2 = a2 + a2;
        float db2 = b2 + b2;
        float dc2 = c2 + c2;
        float dd2 = d2 + d2;
        float rm00 = 1.0f - da2 * a2;
        float rm01 = -da2 * b2;
        float rm02 = -da2 * c2;
        float rm10 = -db2 * a2;
        float rm11 = 1.0f - db2 * b2;
        float rm12 = -db2 * c2;
        float rm20 = -dc2 * a2;
        float rm21 = -dc2 * b2;
        float rm22 = 1.0f - dc2 * c2;
        float rm30 = -dd2 * a2;
        float rm31 = -dd2 * b2;
        float rm32 = -dd2 * c2;
        dest._m30(this.m00() * rm30 + this.m10() * rm31 + this.m20() * rm32 + this.m30())._m31(this.m01() * rm30 + this.m11() * rm31 + this.m21() * rm32 + this.m31())._m32(this.m02() * rm30 + this.m12() * rm31 + this.m22() * rm32 + this.m32())._m33(this.m33());
        float nm00 = this.m00() * rm00 + this.m10() * rm01 + this.m20() * rm02;
        float nm01 = this.m01() * rm00 + this.m11() * rm01 + this.m21() * rm02;
        float nm02 = this.m02() * rm00 + this.m12() * rm01 + this.m22() * rm02;
        float nm10 = this.m00() * rm10 + this.m10() * rm11 + this.m20() * rm12;
        float nm11 = this.m01() * rm10 + this.m11() * rm11 + this.m21() * rm12;
        float nm12 = this.m02() * rm10 + this.m12() * rm11 + this.m22() * rm12;
        dest._m20(this.m00() * rm20 + this.m10() * rm21 + this.m20() * rm22)._m21(this.m01() * rm20 + this.m11() * rm21 + this.m21() * rm22)._m22(this.m02() * rm20 + this.m12() * rm21 + this.m22() * rm22)._m23(0.0f)._m00(nm00)._m01(nm01)._m02(nm02)._m03(0.0f)._m10(nm10)._m11(nm11)._m12(nm12)._m13(0.0f)._properties(this.properties & 0xFFFFFFF2);
        return dest;
    }

    private Matrix4f reflectGeneric(float a2, float b2, float c2, float d2, Matrix4f dest) {
        float da2 = a2 + a2;
        float db2 = b2 + b2;
        float dc2 = c2 + c2;
        float dd2 = d2 + d2;
        float rm00 = 1.0f - da2 * a2;
        float rm01 = -da2 * b2;
        float rm02 = -da2 * c2;
        float rm10 = -db2 * a2;
        float rm11 = 1.0f - db2 * b2;
        float rm12 = -db2 * c2;
        float rm20 = -dc2 * a2;
        float rm21 = -dc2 * b2;
        float rm22 = 1.0f - dc2 * c2;
        float rm30 = -dd2 * a2;
        float rm31 = -dd2 * b2;
        float rm32 = -dd2 * c2;
        dest._m30(this.m00() * rm30 + this.m10() * rm31 + this.m20() * rm32 + this.m30())._m31(this.m01() * rm30 + this.m11() * rm31 + this.m21() * rm32 + this.m31())._m32(this.m02() * rm30 + this.m12() * rm31 + this.m22() * rm32 + this.m32())._m33(this.m03() * rm30 + this.m13() * rm31 + this.m23() * rm32 + this.m33());
        float nm00 = this.m00() * rm00 + this.m10() * rm01 + this.m20() * rm02;
        float nm01 = this.m01() * rm00 + this.m11() * rm01 + this.m21() * rm02;
        float nm02 = this.m02() * rm00 + this.m12() * rm01 + this.m22() * rm02;
        float nm03 = this.m03() * rm00 + this.m13() * rm01 + this.m23() * rm02;
        float nm10 = this.m00() * rm10 + this.m10() * rm11 + this.m20() * rm12;
        float nm11 = this.m01() * rm10 + this.m11() * rm11 + this.m21() * rm12;
        float nm12 = this.m02() * rm10 + this.m12() * rm11 + this.m22() * rm12;
        float nm13 = this.m03() * rm10 + this.m13() * rm11 + this.m23() * rm12;
        dest._m20(this.m00() * rm20 + this.m10() * rm21 + this.m20() * rm22)._m21(this.m01() * rm20 + this.m11() * rm21 + this.m21() * rm22)._m22(this.m02() * rm20 + this.m12() * rm21 + this.m22() * rm22)._m23(this.m03() * rm20 + this.m13() * rm21 + this.m23() * rm22)._m00(nm00)._m01(nm01)._m02(nm02)._m03(nm03)._m10(nm10)._m11(nm11)._m12(nm12)._m13(nm13)._properties(this.properties & 0xFFFFFFF2);
        return dest;
    }

    public Matrix4f reflect(float a2, float b2, float c2, float d2) {
        return this.reflect(a2, b2, c2, d2, this);
    }

    public Matrix4f reflect(float nx, float ny, float nz, float px, float py, float pz) {
        return this.reflect(nx, ny, nz, px, py, pz, this);
    }

    public Matrix4f reflect(float nx, float ny, float nz, float px, float py, float pz, Matrix4f dest) {
        float invLength = Math.invsqrt(nx * nx + ny * ny + nz * nz);
        float nnx = nx * invLength;
        float nny = ny * invLength;
        float nnz = nz * invLength;
        return this.reflect(nnx, nny, nnz, -nnx * px - nny * py - nnz * pz, dest);
    }

    public Matrix4f reflect(Vector3fc normal, Vector3fc point) {
        return this.reflect(normal.x(), normal.y(), normal.z(), point.x(), point.y(), point.z());
    }

    public Matrix4f reflect(Quaternionfc orientation, Vector3fc point) {
        return this.reflect(orientation, point, this);
    }

    public Matrix4f reflect(Quaternionfc orientation, Vector3fc point, Matrix4f dest) {
        double num1 = orientation.x() + orientation.x();
        double num2 = orientation.y() + orientation.y();
        double num3 = orientation.z() + orientation.z();
        float normalX = (float)((double)orientation.x() * num3 + (double)orientation.w() * num2);
        float normalY = (float)((double)orientation.y() * num3 - (double)orientation.w() * num1);
        float normalZ = (float)(1.0 - ((double)orientation.x() * num1 + (double)orientation.y() * num2));
        return this.reflect(normalX, normalY, normalZ, point.x(), point.y(), point.z(), dest);
    }

    public Matrix4f reflect(Vector3fc normal, Vector3fc point, Matrix4f dest) {
        return this.reflect(normal.x(), normal.y(), normal.z(), point.x(), point.y(), point.z(), dest);
    }

    public Matrix4f reflection(float a2, float b2, float c2, float d2) {
        float da2 = a2 + a2;
        float db2 = b2 + b2;
        float dc2 = c2 + c2;
        float dd2 = d2 + d2;
        this._m00(1.0f - da2 * a2)._m01(-da2 * b2)._m02(-da2 * c2)._m03(0.0f)._m10(-db2 * a2)._m11(1.0f - db2 * b2)._m12(-db2 * c2)._m13(0.0f)._m20(-dc2 * a2)._m21(-dc2 * b2)._m22(1.0f - dc2 * c2)._m23(0.0f)._m30(-dd2 * a2)._m31(-dd2 * b2)._m32(-dd2 * c2)._m33(1.0f)._properties(18);
        return this;
    }

    public Matrix4f reflection(float nx, float ny, float nz, float px, float py, float pz) {
        float invLength = Math.invsqrt(nx * nx + ny * ny + nz * nz);
        float nnx = nx * invLength;
        float nny = ny * invLength;
        float nnz = nz * invLength;
        return this.reflection(nnx, nny, nnz, -nnx * px - nny * py - nnz * pz);
    }

    public Matrix4f reflection(Vector3fc normal, Vector3fc point) {
        return this.reflection(normal.x(), normal.y(), normal.z(), point.x(), point.y(), point.z());
    }

    public Matrix4f reflection(Quaternionfc orientation, Vector3fc point) {
        double num1 = orientation.x() + orientation.x();
        double num2 = orientation.y() + orientation.y();
        double num3 = orientation.z() + orientation.z();
        float normalX = (float)((double)orientation.x() * num3 + (double)orientation.w() * num2);
        float normalY = (float)((double)orientation.y() * num3 - (double)orientation.w() * num1);
        float normalZ = (float)(1.0 - ((double)orientation.x() * num1 + (double)orientation.y() * num2));
        return this.reflection(normalX, normalY, normalZ, point.x(), point.y(), point.z());
    }

    public Vector4f getRow(int row, Vector4f dest) throws IndexOutOfBoundsException {
        switch (row) {
            case 0: {
                return dest.set(this.m00(), this.m10(), this.m20(), this.m30());
            }
            case 1: {
                return dest.set(this.m01(), this.m11(), this.m21(), this.m31());
            }
            case 2: {
                return dest.set(this.m02(), this.m12(), this.m22(), this.m32());
            }
            case 3: {
                return dest.set(this.m03(), this.m13(), this.m23(), this.m33());
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public Vector3f getRow(int row, Vector3f dest) throws IndexOutOfBoundsException {
        switch (row) {
            case 0: {
                return dest.set(this.m00(), this.m10(), this.m20());
            }
            case 1: {
                return dest.set(this.m01(), this.m11(), this.m21());
            }
            case 2: {
                return dest.set(this.m02(), this.m12(), this.m22());
            }
            case 3: {
                return dest.set(this.m03(), this.m13(), this.m23());
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public Matrix4f setRow(int row, Vector4fc src) throws IndexOutOfBoundsException {
        switch (row) {
            case 0: {
                return this._m00(src.x())._m10(src.y())._m20(src.z())._m30(src.w())._properties(0);
            }
            case 1: {
                return this._m01(src.x())._m11(src.y())._m21(src.z())._m31(src.w())._properties(0);
            }
            case 2: {
                return this._m02(src.x())._m12(src.y())._m22(src.z())._m32(src.w())._properties(0);
            }
            case 3: {
                return this._m03(src.x())._m13(src.y())._m23(src.z())._m33(src.w())._properties(0);
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public Vector4f getColumn(int column, Vector4f dest) throws IndexOutOfBoundsException {
        return MemUtil.INSTANCE.getColumn(this, column, dest);
    }

    public Vector3f getColumn(int column, Vector3f dest) throws IndexOutOfBoundsException {
        switch (column) {
            case 0: {
                return dest.set(this.m00(), this.m01(), this.m02());
            }
            case 1: {
                return dest.set(this.m10(), this.m11(), this.m12());
            }
            case 2: {
                return dest.set(this.m20(), this.m21(), this.m22());
            }
            case 3: {
                return dest.set(this.m30(), this.m31(), this.m32());
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public Matrix4f setColumn(int column, Vector4fc src) throws IndexOutOfBoundsException {
        if (src instanceof Vector4f) {
            return MemUtil.INSTANCE.setColumn((Vector4f)src, column, this)._properties(0);
        }
        return MemUtil.INSTANCE.setColumn(src, column, this)._properties(0);
    }

    public float get(int column, int row) {
        return MemUtil.INSTANCE.get(this, column, row);
    }

    public Matrix4f set(int column, int row, float value) {
        return MemUtil.INSTANCE.set(this, column, row, value);
    }

    public float getRowColumn(int row, int column) {
        return MemUtil.INSTANCE.get(this, column, row);
    }

    public Matrix4f setRowColumn(int row, int column, float value) {
        return MemUtil.INSTANCE.set(this, column, row, value);
    }

    public Matrix4f normal() {
        return this.normal(this);
    }

    public Matrix4f normal(Matrix4f dest) {
        if ((this.properties & 4) != 0) {
            return dest.identity();
        }
        if ((this.properties & 0x10) != 0) {
            return this.normalOrthonormal(dest);
        }
        return this.normalGeneric(dest);
    }

    private Matrix4f normalOrthonormal(Matrix4f dest) {
        if (dest != this) {
            dest.set(this);
        }
        return dest._properties(18);
    }

    private Matrix4f normalGeneric(Matrix4f dest) {
        float m00m11 = this.m00() * this.m11();
        float m01m10 = this.m01() * this.m10();
        float m02m10 = this.m02() * this.m10();
        float m00m12 = this.m00() * this.m12();
        float m01m12 = this.m01() * this.m12();
        float m02m11 = this.m02() * this.m11();
        float det = (m00m11 - m01m10) * this.m22() + (m02m10 - m00m12) * this.m21() + (m01m12 - m02m11) * this.m20();
        float s2 = 1.0f / det;
        float nm00 = (this.m11() * this.m22() - this.m21() * this.m12()) * s2;
        float nm01 = (this.m20() * this.m12() - this.m10() * this.m22()) * s2;
        float nm02 = (this.m10() * this.m21() - this.m20() * this.m11()) * s2;
        float nm10 = (this.m21() * this.m02() - this.m01() * this.m22()) * s2;
        float nm11 = (this.m00() * this.m22() - this.m20() * this.m02()) * s2;
        float nm12 = (this.m20() * this.m01() - this.m00() * this.m21()) * s2;
        float nm20 = (m01m12 - m02m11) * s2;
        float nm21 = (m02m10 - m00m12) * s2;
        float nm22 = (m00m11 - m01m10) * s2;
        return dest._m00(nm00)._m01(nm01)._m02(nm02)._m03(0.0f)._m10(nm10)._m11(nm11)._m12(nm12)._m13(0.0f)._m20(nm20)._m21(nm21)._m22(nm22)._m23(0.0f)._m30(0.0f)._m31(0.0f)._m32(0.0f)._m33(1.0f)._properties((this.properties | 2) & 0xFFFFFFF6);
    }

    public Matrix3f normal(Matrix3f dest) {
        if ((this.properties & 0x10) != 0) {
            return this.normalOrthonormal(dest);
        }
        return this.normalGeneric(dest);
    }

    private Matrix3f normalOrthonormal(Matrix3f dest) {
        dest.set(this);
        return dest;
    }

    private Matrix3f normalGeneric(Matrix3f dest) {
        float det = (this.m00() * this.m11() - this.m01() * this.m10()) * this.m22() + (this.m02() * this.m10() - this.m00() * this.m12()) * this.m21() + (this.m01() * this.m12() - this.m02() * this.m11()) * this.m20();
        float s2 = 1.0f / det;
        return dest._m00((this.m11() * this.m22() - this.m21() * this.m12()) * s2)._m01((this.m20() * this.m12() - this.m10() * this.m22()) * s2)._m02((this.m10() * this.m21() - this.m20() * this.m11()) * s2)._m10((this.m21() * this.m02() - this.m01() * this.m22()) * s2)._m11((this.m00() * this.m22() - this.m20() * this.m02()) * s2)._m12((this.m20() * this.m01() - this.m00() * this.m21()) * s2)._m20((this.m01() * this.m12() - this.m02() * this.m11()) * s2)._m21((this.m02() * this.m10() - this.m00() * this.m12()) * s2)._m22((this.m00() * this.m11() - this.m01() * this.m10()) * s2);
    }

    public Matrix4f cofactor3x3() {
        return this.cofactor3x3(this);
    }

    public Matrix3f cofactor3x3(Matrix3f dest) {
        return dest._m00(this.m11() * this.m22() - this.m21() * this.m12())._m01(this.m20() * this.m12() - this.m10() * this.m22())._m02(this.m10() * this.m21() - this.m20() * this.m11())._m10(this.m21() * this.m02() - this.m01() * this.m22())._m11(this.m00() * this.m22() - this.m20() * this.m02())._m12(this.m20() * this.m01() - this.m00() * this.m21())._m20(this.m01() * this.m12() - this.m02() * this.m11())._m21(this.m02() * this.m10() - this.m00() * this.m12())._m22(this.m00() * this.m11() - this.m01() * this.m10());
    }

    public Matrix4f cofactor3x3(Matrix4f dest) {
        float nm10 = this.m21() * this.m02() - this.m01() * this.m22();
        float nm11 = this.m00() * this.m22() - this.m20() * this.m02();
        float nm12 = this.m20() * this.m01() - this.m00() * this.m21();
        float nm20 = this.m01() * this.m12() - this.m11() * this.m02();
        float nm21 = this.m02() * this.m10() - this.m12() * this.m00();
        float nm22 = this.m00() * this.m11() - this.m10() * this.m01();
        return dest._m00(this.m11() * this.m22() - this.m21() * this.m12())._m01(this.m20() * this.m12() - this.m10() * this.m22())._m02(this.m10() * this.m21() - this.m20() * this.m11())._m03(0.0f)._m10(nm10)._m11(nm11)._m12(nm12)._m13(0.0f)._m20(nm20)._m21(nm21)._m22(nm22)._m23(0.0f)._m30(0.0f)._m31(0.0f)._m32(0.0f)._m33(1.0f)._properties((this.properties | 2) & 0xFFFFFFF6);
    }

    public Matrix4f normalize3x3() {
        return this.normalize3x3(this);
    }

    public Matrix4f normalize3x3(Matrix4f dest) {
        float invXlen = Math.invsqrt(this.m00() * this.m00() + this.m01() * this.m01() + this.m02() * this.m02());
        float invYlen = Math.invsqrt(this.m10() * this.m10() + this.m11() * this.m11() + this.m12() * this.m12());
        float invZlen = Math.invsqrt(this.m20() * this.m20() + this.m21() * this.m21() + this.m22() * this.m22());
        return dest._m00(this.m00() * invXlen)._m01(this.m01() * invXlen)._m02(this.m02() * invXlen)._m10(this.m10() * invYlen)._m11(this.m11() * invYlen)._m12(this.m12() * invYlen)._m20(this.m20() * invZlen)._m21(this.m21() * invZlen)._m22(this.m22() * invZlen)._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties);
    }

    public Matrix3f normalize3x3(Matrix3f dest) {
        float invXlen = Math.invsqrt(this.m00() * this.m00() + this.m01() * this.m01() + this.m02() * this.m02());
        float invYlen = Math.invsqrt(this.m10() * this.m10() + this.m11() * this.m11() + this.m12() * this.m12());
        float invZlen = Math.invsqrt(this.m20() * this.m20() + this.m21() * this.m21() + this.m22() * this.m22());
        return dest._m00(this.m00() * invXlen)._m01(this.m01() * invXlen)._m02(this.m02() * invXlen)._m10(this.m10() * invYlen)._m11(this.m11() * invYlen)._m12(this.m12() * invYlen)._m20(this.m20() * invZlen)._m21(this.m21() * invZlen)._m22(this.m22() * invZlen);
    }

    public Vector4f frustumPlane(int plane, Vector4f dest) {
        switch (plane) {
            case 0: {
                dest.set(this.m03() + this.m00(), this.m13() + this.m10(), this.m23() + this.m20(), this.m33() + this.m30()).normalize3();
                break;
            }
            case 1: {
                dest.set(this.m03() - this.m00(), this.m13() - this.m10(), this.m23() - this.m20(), this.m33() - this.m30()).normalize3();
                break;
            }
            case 2: {
                dest.set(this.m03() + this.m01(), this.m13() + this.m11(), this.m23() + this.m21(), this.m33() + this.m31()).normalize3();
                break;
            }
            case 3: {
                dest.set(this.m03() - this.m01(), this.m13() - this.m11(), this.m23() - this.m21(), this.m33() - this.m31()).normalize3();
                break;
            }
            case 4: {
                dest.set(this.m03() + this.m02(), this.m13() + this.m12(), this.m23() + this.m22(), this.m33() + this.m32()).normalize3();
                break;
            }
            case 5: {
                dest.set(this.m03() - this.m02(), this.m13() - this.m12(), this.m23() - this.m22(), this.m33() - this.m32()).normalize3();
                break;
            }
            default: {
                throw new IllegalArgumentException("dest");
            }
        }
        return dest;
    }

    public Vector3f frustumCorner(int corner, Vector3f point) {
        float d3;
        float n3z;
        float n3y;
        float n3x;
        float d2;
        float n2z;
        float n2y;
        float n2x;
        float d1;
        float n1z;
        float n1y;
        float n1x;
        switch (corner) {
            case 0: {
                n1x = this.m03() + this.m00();
                n1y = this.m13() + this.m10();
                n1z = this.m23() + this.m20();
                d1 = this.m33() + this.m30();
                n2x = this.m03() + this.m01();
                n2y = this.m13() + this.m11();
                n2z = this.m23() + this.m21();
                d2 = this.m33() + this.m31();
                n3x = this.m03() + this.m02();
                n3y = this.m13() + this.m12();
                n3z = this.m23() + this.m22();
                d3 = this.m33() + this.m32();
                break;
            }
            case 1: {
                n1x = this.m03() - this.m00();
                n1y = this.m13() - this.m10();
                n1z = this.m23() - this.m20();
                d1 = this.m33() - this.m30();
                n2x = this.m03() + this.m01();
                n2y = this.m13() + this.m11();
                n2z = this.m23() + this.m21();
                d2 = this.m33() + this.m31();
                n3x = this.m03() + this.m02();
                n3y = this.m13() + this.m12();
                n3z = this.m23() + this.m22();
                d3 = this.m33() + this.m32();
                break;
            }
            case 2: {
                n1x = this.m03() - this.m00();
                n1y = this.m13() - this.m10();
                n1z = this.m23() - this.m20();
                d1 = this.m33() - this.m30();
                n2x = this.m03() - this.m01();
                n2y = this.m13() - this.m11();
                n2z = this.m23() - this.m21();
                d2 = this.m33() - this.m31();
                n3x = this.m03() + this.m02();
                n3y = this.m13() + this.m12();
                n3z = this.m23() + this.m22();
                d3 = this.m33() + this.m32();
                break;
            }
            case 3: {
                n1x = this.m03() + this.m00();
                n1y = this.m13() + this.m10();
                n1z = this.m23() + this.m20();
                d1 = this.m33() + this.m30();
                n2x = this.m03() - this.m01();
                n2y = this.m13() - this.m11();
                n2z = this.m23() - this.m21();
                d2 = this.m33() - this.m31();
                n3x = this.m03() + this.m02();
                n3y = this.m13() + this.m12();
                n3z = this.m23() + this.m22();
                d3 = this.m33() + this.m32();
                break;
            }
            case 4: {
                n1x = this.m03() - this.m00();
                n1y = this.m13() - this.m10();
                n1z = this.m23() - this.m20();
                d1 = this.m33() - this.m30();
                n2x = this.m03() + this.m01();
                n2y = this.m13() + this.m11();
                n2z = this.m23() + this.m21();
                d2 = this.m33() + this.m31();
                n3x = this.m03() - this.m02();
                n3y = this.m13() - this.m12();
                n3z = this.m23() - this.m22();
                d3 = this.m33() - this.m32();
                break;
            }
            case 5: {
                n1x = this.m03() + this.m00();
                n1y = this.m13() + this.m10();
                n1z = this.m23() + this.m20();
                d1 = this.m33() + this.m30();
                n2x = this.m03() + this.m01();
                n2y = this.m13() + this.m11();
                n2z = this.m23() + this.m21();
                d2 = this.m33() + this.m31();
                n3x = this.m03() - this.m02();
                n3y = this.m13() - this.m12();
                n3z = this.m23() - this.m22();
                d3 = this.m33() - this.m32();
                break;
            }
            case 6: {
                n1x = this.m03() + this.m00();
                n1y = this.m13() + this.m10();
                n1z = this.m23() + this.m20();
                d1 = this.m33() + this.m30();
                n2x = this.m03() - this.m01();
                n2y = this.m13() - this.m11();
                n2z = this.m23() - this.m21();
                d2 = this.m33() - this.m31();
                n3x = this.m03() - this.m02();
                n3y = this.m13() - this.m12();
                n3z = this.m23() - this.m22();
                d3 = this.m33() - this.m32();
                break;
            }
            case 7: {
                n1x = this.m03() - this.m00();
                n1y = this.m13() - this.m10();
                n1z = this.m23() - this.m20();
                d1 = this.m33() - this.m30();
                n2x = this.m03() - this.m01();
                n2y = this.m13() - this.m11();
                n2z = this.m23() - this.m21();
                d2 = this.m33() - this.m31();
                n3x = this.m03() - this.m02();
                n3y = this.m13() - this.m12();
                n3z = this.m23() - this.m22();
                d3 = this.m33() - this.m32();
                break;
            }
            default: {
                throw new IllegalArgumentException("corner");
            }
        }
        float c23x = n2y * n3z - n2z * n3y;
        float c23y = n2z * n3x - n2x * n3z;
        float c23z = n2x * n3y - n2y * n3x;
        float c31x = n3y * n1z - n3z * n1y;
        float c31y = n3z * n1x - n3x * n1z;
        float c31z = n3x * n1y - n3y * n1x;
        float c12x = n1y * n2z - n1z * n2y;
        float c12y = n1z * n2x - n1x * n2z;
        float c12z = n1x * n2y - n1y * n2x;
        float invDot = 1.0f / (n1x * c23x + n1y * c23y + n1z * c23z);
        point.x = (-c23x * d1 - c31x * d2 - c12x * d3) * invDot;
        point.y = (-c23y * d1 - c31y * d2 - c12y * d3) * invDot;
        point.z = (-c23z * d1 - c31z * d2 - c12z * d3) * invDot;
        return point;
    }

    public Vector3f perspectiveOrigin(Vector3f origin) {
        float n1x = this.m03() + this.m00();
        float n1y = this.m13() + this.m10();
        float n1z = this.m23() + this.m20();
        float d1 = this.m33() + this.m30();
        float n2x = this.m03() - this.m00();
        float n2y = this.m13() - this.m10();
        float n2z = this.m23() - this.m20();
        float d2 = this.m33() - this.m30();
        float n3x = this.m03() - this.m01();
        float n3y = this.m13() - this.m11();
        float n3z = this.m23() - this.m21();
        float d3 = this.m33() - this.m31();
        float c23x = n2y * n3z - n2z * n3y;
        float c23y = n2z * n3x - n2x * n3z;
        float c23z = n2x * n3y - n2y * n3x;
        float c31x = n3y * n1z - n3z * n1y;
        float c31y = n3z * n1x - n3x * n1z;
        float c31z = n3x * n1y - n3y * n1x;
        float c12x = n1y * n2z - n1z * n2y;
        float c12y = n1z * n2x - n1x * n2z;
        float c12z = n1x * n2y - n1y * n2x;
        float invDot = 1.0f / (n1x * c23x + n1y * c23y + n1z * c23z);
        origin.x = (-c23x * d1 - c31x * d2 - c12x * d3) * invDot;
        origin.y = (-c23y * d1 - c31y * d2 - c12y * d3) * invDot;
        origin.z = (-c23z * d1 - c31z * d2 - c12z * d3) * invDot;
        return origin;
    }

    public Vector3f perspectiveInvOrigin(Vector3f dest) {
        float invW = 1.0f / this.m23();
        dest.x = this.m20() * invW;
        dest.y = this.m21() * invW;
        dest.z = this.m22() * invW;
        return dest;
    }

    public float perspectiveFov() {
        float n1x = this.m03() + this.m01();
        float n1y = this.m13() + this.m11();
        float n1z = this.m23() + this.m21();
        float n2x = this.m01() - this.m03();
        float n2y = this.m11() - this.m13();
        float n2z = this.m21() - this.m23();
        float n1len = Math.sqrt(n1x * n1x + n1y * n1y + n1z * n1z);
        float n2len = Math.sqrt(n2x * n2x + n2y * n2y + n2z * n2z);
        return Math.acos((n1x * n2x + n1y * n2y + n1z * n2z) / (n1len * n2len));
    }

    public float perspectiveNear() {
        return this.m32() / (this.m23() + this.m22());
    }

    public float perspectiveFar() {
        return this.m32() / (this.m22() - this.m23());
    }

    public Vector3f frustumRayDir(float x2, float y2, Vector3f dir) {
        float a2 = this.m10() * this.m23();
        float b2 = this.m13() * this.m21();
        float c2 = this.m10() * this.m21();
        float d2 = this.m11() * this.m23();
        float e2 = this.m13() * this.m20();
        float f2 = this.m11() * this.m20();
        float g2 = this.m03() * this.m20();
        float h2 = this.m01() * this.m23();
        float i2 = this.m01() * this.m20();
        float j2 = this.m03() * this.m21();
        float k2 = this.m00() * this.m23();
        float l2 = this.m00() * this.m21();
        float m2 = this.m00() * this.m13();
        float n2 = this.m03() * this.m11();
        float o2 = this.m00() * this.m11();
        float p2 = this.m01() * this.m13();
        float q2 = this.m03() * this.m10();
        float r2 = this.m01() * this.m10();
        float m1x = (d2 + e2 + f2 - a2 - b2 - c2) * (1.0f - y2) + (a2 - b2 - c2 + d2 - e2 + f2) * y2;
        float m1y = (j2 + k2 + l2 - g2 - h2 - i2) * (1.0f - y2) + (g2 - h2 - i2 + j2 - k2 + l2) * y2;
        float m1z = (p2 + q2 + r2 - m2 - n2 - o2) * (1.0f - y2) + (m2 - n2 - o2 + p2 - q2 + r2) * y2;
        float m2x = (b2 - c2 - d2 + e2 + f2 - a2) * (1.0f - y2) + (a2 + b2 - c2 - d2 - e2 + f2) * y2;
        float m2y = (h2 - i2 - j2 + k2 + l2 - g2) * (1.0f - y2) + (g2 + h2 - i2 - j2 - k2 + l2) * y2;
        float m2z = (n2 - o2 - p2 + q2 + r2 - m2) * (1.0f - y2) + (m2 + n2 - o2 - p2 - q2 + r2) * y2;
        dir.x = m1x + (m2x - m1x) * x2;
        dir.y = m1y + (m2y - m1y) * x2;
        dir.z = m1z + (m2z - m1z) * x2;
        return dir.normalize(dir);
    }

    public Vector3f positiveZ(Vector3f dir) {
        if ((this.properties & 0x10) != 0) {
            return this.normalizedPositiveZ(dir);
        }
        return this.positiveZGeneric(dir);
    }

    private Vector3f positiveZGeneric(Vector3f dir) {
        return dir.set(this.m10() * this.m21() - this.m11() * this.m20(), this.m20() * this.m01() - this.m21() * this.m00(), this.m00() * this.m11() - this.m01() * this.m10()).normalize();
    }

    public Vector3f normalizedPositiveZ(Vector3f dir) {
        return dir.set(this.m02(), this.m12(), this.m22());
    }

    public Vector3f positiveX(Vector3f dir) {
        if ((this.properties & 0x10) != 0) {
            return this.normalizedPositiveX(dir);
        }
        return this.positiveXGeneric(dir);
    }

    private Vector3f positiveXGeneric(Vector3f dir) {
        return dir.set(this.m11() * this.m22() - this.m12() * this.m21(), this.m02() * this.m21() - this.m01() * this.m22(), this.m01() * this.m12() - this.m02() * this.m11()).normalize();
    }

    public Vector3f normalizedPositiveX(Vector3f dir) {
        return dir.set(this.m00(), this.m10(), this.m20());
    }

    public Vector3f positiveY(Vector3f dir) {
        if ((this.properties & 0x10) != 0) {
            return this.normalizedPositiveY(dir);
        }
        return this.positiveYGeneric(dir);
    }

    private Vector3f positiveYGeneric(Vector3f dir) {
        return dir.set(this.m12() * this.m20() - this.m10() * this.m22(), this.m00() * this.m22() - this.m02() * this.m20(), this.m02() * this.m10() - this.m00() * this.m12()).normalize();
    }

    public Vector3f normalizedPositiveY(Vector3f dir) {
        return dir.set(this.m01(), this.m11(), this.m21());
    }

    public Vector3f originAffine(Vector3f origin) {
        float a2 = this.m00() * this.m11() - this.m01() * this.m10();
        float b2 = this.m00() * this.m12() - this.m02() * this.m10();
        float d2 = this.m01() * this.m12() - this.m02() * this.m11();
        float g2 = this.m20() * this.m31() - this.m21() * this.m30();
        float h2 = this.m20() * this.m32() - this.m22() * this.m30();
        float j2 = this.m21() * this.m32() - this.m22() * this.m31();
        return origin.set(-this.m10() * j2 + this.m11() * h2 - this.m12() * g2, this.m00() * j2 - this.m01() * h2 + this.m02() * g2, -this.m30() * d2 + this.m31() * b2 - this.m32() * a2);
    }

    public Vector3f origin(Vector3f dest) {
        if ((this.properties & 2) != 0) {
            return this.originAffine(dest);
        }
        return this.originGeneric(dest);
    }

    private Vector3f originGeneric(Vector3f dest) {
        float a2 = this.m00() * this.m11() - this.m01() * this.m10();
        float b2 = this.m00() * this.m12() - this.m02() * this.m10();
        float c2 = this.m00() * this.m13() - this.m03() * this.m10();
        float d2 = this.m01() * this.m12() - this.m02() * this.m11();
        float e2 = this.m01() * this.m13() - this.m03() * this.m11();
        float f2 = this.m02() * this.m13() - this.m03() * this.m12();
        float g2 = this.m20() * this.m31() - this.m21() * this.m30();
        float h2 = this.m20() * this.m32() - this.m22() * this.m30();
        float i2 = this.m20() * this.m33() - this.m23() * this.m30();
        float j2 = this.m21() * this.m32() - this.m22() * this.m31();
        float k2 = this.m21() * this.m33() - this.m23() * this.m31();
        float l2 = this.m22() * this.m33() - this.m23() * this.m32();
        float det = a2 * l2 - b2 * k2 + c2 * j2 + d2 * i2 - e2 * h2 + f2 * g2;
        float invDet = 1.0f / det;
        float nm30 = (-this.m10() * j2 + this.m11() * h2 - this.m12() * g2) * invDet;
        float nm31 = (this.m00() * j2 - this.m01() * h2 + this.m02() * g2) * invDet;
        float nm32 = (-this.m30() * d2 + this.m31() * b2 - this.m32() * a2) * invDet;
        float nm33 = det / (this.m20() * d2 - this.m21() * b2 + this.m22() * a2);
        return dest.set(nm30 * nm33, nm31 * nm33, nm32 * nm33);
    }

    public Matrix4f shadow(Vector4f light, float a2, float b2, float c2, float d2) {
        return this.shadow(light.x, light.y, light.z, light.w, a2, b2, c2, d2, this);
    }

    public Matrix4f shadow(Vector4f light, float a2, float b2, float c2, float d2, Matrix4f dest) {
        return this.shadow(light.x, light.y, light.z, light.w, a2, b2, c2, d2, dest);
    }

    public Matrix4f shadow(float lightX, float lightY, float lightZ, float lightW, float a2, float b2, float c2, float d2) {
        return this.shadow(lightX, lightY, lightZ, lightW, a2, b2, c2, d2, this);
    }

    public Matrix4f shadow(float lightX, float lightY, float lightZ, float lightW, float a2, float b2, float c2, float d2, Matrix4f dest) {
        float invPlaneLen = Math.invsqrt(a2 * a2 + b2 * b2 + c2 * c2);
        float an2 = a2 * invPlaneLen;
        float bn2 = b2 * invPlaneLen;
        float cn2 = c2 * invPlaneLen;
        float dn2 = d2 * invPlaneLen;
        float dot = an2 * lightX + bn2 * lightY + cn2 * lightZ + dn2 * lightW;
        float rm00 = dot - an2 * lightX;
        float rm01 = -an2 * lightY;
        float rm02 = -an2 * lightZ;
        float rm03 = -an2 * lightW;
        float rm10 = -bn2 * lightX;
        float rm11 = dot - bn2 * lightY;
        float rm12 = -bn2 * lightZ;
        float rm13 = -bn2 * lightW;
        float rm20 = -cn2 * lightX;
        float rm21 = -cn2 * lightY;
        float rm22 = dot - cn2 * lightZ;
        float rm23 = -cn2 * lightW;
        float rm30 = -dn2 * lightX;
        float rm31 = -dn2 * lightY;
        float rm32 = -dn2 * lightZ;
        float rm33 = dot - dn2 * lightW;
        float nm00 = this.m00() * rm00 + this.m10() * rm01 + this.m20() * rm02 + this.m30() * rm03;
        float nm01 = this.m01() * rm00 + this.m11() * rm01 + this.m21() * rm02 + this.m31() * rm03;
        float nm02 = this.m02() * rm00 + this.m12() * rm01 + this.m22() * rm02 + this.m32() * rm03;
        float nm03 = this.m03() * rm00 + this.m13() * rm01 + this.m23() * rm02 + this.m33() * rm03;
        float nm10 = this.m00() * rm10 + this.m10() * rm11 + this.m20() * rm12 + this.m30() * rm13;
        float nm11 = this.m01() * rm10 + this.m11() * rm11 + this.m21() * rm12 + this.m31() * rm13;
        float nm12 = this.m02() * rm10 + this.m12() * rm11 + this.m22() * rm12 + this.m32() * rm13;
        float nm13 = this.m03() * rm10 + this.m13() * rm11 + this.m23() * rm12 + this.m33() * rm13;
        float nm20 = this.m00() * rm20 + this.m10() * rm21 + this.m20() * rm22 + this.m30() * rm23;
        float nm21 = this.m01() * rm20 + this.m11() * rm21 + this.m21() * rm22 + this.m31() * rm23;
        float nm22 = this.m02() * rm20 + this.m12() * rm21 + this.m22() * rm22 + this.m32() * rm23;
        float nm23 = this.m03() * rm20 + this.m13() * rm21 + this.m23() * rm22 + this.m33() * rm23;
        dest._m30(this.m00() * rm30 + this.m10() * rm31 + this.m20() * rm32 + this.m30() * rm33)._m31(this.m01() * rm30 + this.m11() * rm31 + this.m21() * rm32 + this.m31() * rm33)._m32(this.m02() * rm30 + this.m12() * rm31 + this.m22() * rm32 + this.m32() * rm33)._m33(this.m03() * rm30 + this.m13() * rm31 + this.m23() * rm32 + this.m33() * rm33)._m00(nm00)._m01(nm01)._m02(nm02)._m03(nm03)._m10(nm10)._m11(nm11)._m12(nm12)._m13(nm13)._m20(nm20)._m21(nm21)._m22(nm22)._m23(nm23)._properties(this.properties & 0xFFFFFFE2);
        return dest;
    }

    public Matrix4f shadow(Vector4f light, Matrix4fc planeTransform, Matrix4f dest) {
        float a2 = planeTransform.m10();
        float b2 = planeTransform.m11();
        float c2 = planeTransform.m12();
        float d2 = -a2 * planeTransform.m30() - b2 * planeTransform.m31() - c2 * planeTransform.m32();
        return this.shadow(light.x, light.y, light.z, light.w, a2, b2, c2, d2, dest);
    }

    public Matrix4f shadow(Vector4f light, Matrix4f planeTransform) {
        return this.shadow(light, planeTransform, this);
    }

    public Matrix4f shadow(float lightX, float lightY, float lightZ, float lightW, Matrix4fc planeTransform, Matrix4f dest) {
        float a2 = planeTransform.m10();
        float b2 = planeTransform.m11();
        float c2 = planeTransform.m12();
        float d2 = -a2 * planeTransform.m30() - b2 * planeTransform.m31() - c2 * planeTransform.m32();
        return this.shadow(lightX, lightY, lightZ, lightW, a2, b2, c2, d2, dest);
    }

    public Matrix4f shadow(float lightX, float lightY, float lightZ, float lightW, Matrix4f planeTransform) {
        return this.shadow(lightX, lightY, lightZ, lightW, planeTransform, this);
    }

    public Matrix4f billboardCylindrical(Vector3fc objPos, Vector3fc targetPos, Vector3fc up) {
        float dirX = targetPos.x() - objPos.x();
        float dirY = targetPos.y() - objPos.y();
        float dirZ = targetPos.z() - objPos.z();
        float leftX = up.y() * dirZ - up.z() * dirY;
        float leftY = up.z() * dirX - up.x() * dirZ;
        float leftZ = up.x() * dirY - up.y() * dirX;
        float invLeftLen = Math.invsqrt(leftX * leftX + leftY * leftY + leftZ * leftZ);
        dirX = (leftY *= invLeftLen) * up.z() - (leftZ *= invLeftLen) * up.y();
        dirY = leftZ * up.x() - (leftX *= invLeftLen) * up.z();
        dirZ = leftX * up.y() - leftY * up.x();
        float invDirLen = Math.invsqrt(dirX * dirX + dirY * dirY + dirZ * dirZ);
        this._m00(leftX)._m01(leftY)._m02(leftZ)._m03(0.0f)._m10(up.x())._m11(up.y())._m12(up.z())._m13(0.0f)._m20(dirX *= invDirLen)._m21(dirY *= invDirLen)._m22(dirZ *= invDirLen)._m23(0.0f)._m30(objPos.x())._m31(objPos.y())._m32(objPos.z())._m33(1.0f)._properties(18);
        return this;
    }

    public Matrix4f billboardSpherical(Vector3fc objPos, Vector3fc targetPos, Vector3fc up) {
        float dirX = targetPos.x() - objPos.x();
        float dirY = targetPos.y() - objPos.y();
        float dirZ = targetPos.z() - objPos.z();
        float invDirLen = Math.invsqrt(dirX * dirX + dirY * dirY + dirZ * dirZ);
        float leftX = up.y() * (dirZ *= invDirLen) - up.z() * (dirY *= invDirLen);
        float leftY = up.z() * (dirX *= invDirLen) - up.x() * dirZ;
        float leftZ = up.x() * dirY - up.y() * dirX;
        float invLeftLen = Math.invsqrt(leftX * leftX + leftY * leftY + leftZ * leftZ);
        float upX = dirY * (leftZ *= invLeftLen) - dirZ * (leftY *= invLeftLen);
        float upY = dirZ * (leftX *= invLeftLen) - dirX * leftZ;
        float upZ = dirX * leftY - dirY * leftX;
        this._m00(leftX)._m01(leftY)._m02(leftZ)._m03(0.0f)._m10(upX)._m11(upY)._m12(upZ)._m13(0.0f)._m20(dirX)._m21(dirY)._m22(dirZ)._m23(0.0f)._m30(objPos.x())._m31(objPos.y())._m32(objPos.z())._m33(1.0f)._properties(18);
        return this;
    }

    public Matrix4f billboardSpherical(Vector3fc objPos, Vector3fc targetPos) {
        float toDirX = targetPos.x() - objPos.x();
        float toDirY = targetPos.y() - objPos.y();
        float toDirZ = targetPos.z() - objPos.z();
        float x2 = -toDirY;
        float y2 = toDirX;
        float w2 = Math.sqrt(toDirX * toDirX + toDirY * toDirY + toDirZ * toDirZ) + toDirZ;
        float invNorm = Math.invsqrt(x2 * x2 + y2 * y2 + w2 * w2);
        float q00 = ((x2 *= invNorm) + x2) * x2;
        float q11 = ((y2 *= invNorm) + y2) * y2;
        float q01 = (x2 + x2) * y2;
        float q03 = (x2 + x2) * (w2 *= invNorm);
        float q13 = (y2 + y2) * w2;
        this._m00(1.0f - q11)._m01(q01)._m02(-q13)._m03(0.0f)._m10(q01)._m11(1.0f - q00)._m12(q03)._m13(0.0f)._m20(q13)._m21(-q03)._m22(1.0f - q11 - q00)._m23(0.0f)._m30(objPos.x())._m31(objPos.y())._m32(objPos.z())._m33(1.0f)._properties(18);
        return this;
    }

    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = 31 * result + Float.floatToIntBits(this.m00());
        result = 31 * result + Float.floatToIntBits(this.m01());
        result = 31 * result + Float.floatToIntBits(this.m02());
        result = 31 * result + Float.floatToIntBits(this.m03());
        result = 31 * result + Float.floatToIntBits(this.m10());
        result = 31 * result + Float.floatToIntBits(this.m11());
        result = 31 * result + Float.floatToIntBits(this.m12());
        result = 31 * result + Float.floatToIntBits(this.m13());
        result = 31 * result + Float.floatToIntBits(this.m20());
        result = 31 * result + Float.floatToIntBits(this.m21());
        result = 31 * result + Float.floatToIntBits(this.m22());
        result = 31 * result + Float.floatToIntBits(this.m23());
        result = 31 * result + Float.floatToIntBits(this.m30());
        result = 31 * result + Float.floatToIntBits(this.m31());
        result = 31 * result + Float.floatToIntBits(this.m32());
        result = 31 * result + Float.floatToIntBits(this.m33());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Matrix4f)) {
            return false;
        }
        Matrix4fc other = (Matrix4fc)obj;
        if (Float.floatToIntBits(this.m00()) != Float.floatToIntBits(other.m00())) {
            return false;
        }
        if (Float.floatToIntBits(this.m01()) != Float.floatToIntBits(other.m01())) {
            return false;
        }
        if (Float.floatToIntBits(this.m02()) != Float.floatToIntBits(other.m02())) {
            return false;
        }
        if (Float.floatToIntBits(this.m03()) != Float.floatToIntBits(other.m03())) {
            return false;
        }
        if (Float.floatToIntBits(this.m10()) != Float.floatToIntBits(other.m10())) {
            return false;
        }
        if (Float.floatToIntBits(this.m11()) != Float.floatToIntBits(other.m11())) {
            return false;
        }
        if (Float.floatToIntBits(this.m12()) != Float.floatToIntBits(other.m12())) {
            return false;
        }
        if (Float.floatToIntBits(this.m13()) != Float.floatToIntBits(other.m13())) {
            return false;
        }
        if (Float.floatToIntBits(this.m20()) != Float.floatToIntBits(other.m20())) {
            return false;
        }
        if (Float.floatToIntBits(this.m21()) != Float.floatToIntBits(other.m21())) {
            return false;
        }
        if (Float.floatToIntBits(this.m22()) != Float.floatToIntBits(other.m22())) {
            return false;
        }
        if (Float.floatToIntBits(this.m23()) != Float.floatToIntBits(other.m23())) {
            return false;
        }
        if (Float.floatToIntBits(this.m30()) != Float.floatToIntBits(other.m30())) {
            return false;
        }
        if (Float.floatToIntBits(this.m31()) != Float.floatToIntBits(other.m31())) {
            return false;
        }
        if (Float.floatToIntBits(this.m32()) != Float.floatToIntBits(other.m32())) {
            return false;
        }
        return Float.floatToIntBits(this.m33()) == Float.floatToIntBits(other.m33());
    }

    public boolean equals(Matrix4fc m2, float delta) {
        if (this == m2) {
            return true;
        }
        if (m2 == null) {
            return false;
        }
        if (!(m2 instanceof Matrix4f)) {
            return false;
        }
        if (!Runtime.equals(this.m00(), m2.m00(), delta)) {
            return false;
        }
        if (!Runtime.equals(this.m01(), m2.m01(), delta)) {
            return false;
        }
        if (!Runtime.equals(this.m02(), m2.m02(), delta)) {
            return false;
        }
        if (!Runtime.equals(this.m03(), m2.m03(), delta)) {
            return false;
        }
        if (!Runtime.equals(this.m10(), m2.m10(), delta)) {
            return false;
        }
        if (!Runtime.equals(this.m11(), m2.m11(), delta)) {
            return false;
        }
        if (!Runtime.equals(this.m12(), m2.m12(), delta)) {
            return false;
        }
        if (!Runtime.equals(this.m13(), m2.m13(), delta)) {
            return false;
        }
        if (!Runtime.equals(this.m20(), m2.m20(), delta)) {
            return false;
        }
        if (!Runtime.equals(this.m21(), m2.m21(), delta)) {
            return false;
        }
        if (!Runtime.equals(this.m22(), m2.m22(), delta)) {
            return false;
        }
        if (!Runtime.equals(this.m23(), m2.m23(), delta)) {
            return false;
        }
        if (!Runtime.equals(this.m30(), m2.m30(), delta)) {
            return false;
        }
        if (!Runtime.equals(this.m31(), m2.m31(), delta)) {
            return false;
        }
        if (!Runtime.equals(this.m32(), m2.m32(), delta)) {
            return false;
        }
        return Runtime.equals(this.m33(), m2.m33(), delta);
    }

    public Matrix4f pick(float x2, float y2, float width, float height, int[] viewport, Matrix4f dest) {
        float sx = (float)viewport[2] / width;
        float sy = (float)viewport[3] / height;
        float tx = ((float)viewport[2] + 2.0f * ((float)viewport[0] - x2)) / width;
        float ty = ((float)viewport[3] + 2.0f * ((float)viewport[1] - y2)) / height;
        dest._m30(this.m00() * tx + this.m10() * ty + this.m30())._m31(this.m01() * tx + this.m11() * ty + this.m31())._m32(this.m02() * tx + this.m12() * ty + this.m32())._m33(this.m03() * tx + this.m13() * ty + this.m33())._m00(this.m00() * sx)._m01(this.m01() * sx)._m02(this.m02() * sx)._m03(this.m03() * sx)._m10(this.m10() * sy)._m11(this.m11() * sy)._m12(this.m12() * sy)._m13(this.m13() * sy)._properties(0);
        return dest;
    }

    public Matrix4f pick(float x2, float y2, float width, float height, int[] viewport) {
        return this.pick(x2, y2, width, height, viewport, this);
    }

    public boolean isAffine() {
        return this.m03() == 0.0f && this.m13() == 0.0f && this.m23() == 0.0f && this.m33() == 1.0f;
    }

    public Matrix4f swap(Matrix4f other) {
        MemUtil.INSTANCE.swap(this, other);
        int props = this.properties;
        this.properties = other.properties();
        other.properties = props;
        return this;
    }

    public Matrix4f arcball(float radius, float centerX, float centerY, float centerZ, float angleX, float angleY, Matrix4f dest) {
        float m30 = this.m20() * -radius + this.m30();
        float m31 = this.m21() * -radius + this.m31();
        float m32 = this.m22() * -radius + this.m32();
        float m33 = this.m23() * -radius + this.m33();
        float sin = Math.sin(angleX);
        float cos = Math.cosFromSin(sin, angleX);
        float nm10 = this.m10() * cos + this.m20() * sin;
        float nm11 = this.m11() * cos + this.m21() * sin;
        float nm12 = this.m12() * cos + this.m22() * sin;
        float nm13 = this.m13() * cos + this.m23() * sin;
        float m20 = this.m20() * cos - this.m10() * sin;
        float m21 = this.m21() * cos - this.m11() * sin;
        float m22 = this.m22() * cos - this.m12() * sin;
        float m23 = this.m23() * cos - this.m13() * sin;
        sin = Math.sin(angleY);
        cos = Math.cosFromSin(sin, angleY);
        float nm00 = this.m00() * cos - m20 * sin;
        float nm01 = this.m01() * cos - m21 * sin;
        float nm02 = this.m02() * cos - m22 * sin;
        float nm03 = this.m03() * cos - m23 * sin;
        float nm20 = this.m00() * sin + m20 * cos;
        float nm21 = this.m01() * sin + m21 * cos;
        float nm22 = this.m02() * sin + m22 * cos;
        float nm23 = this.m03() * sin + m23 * cos;
        dest._m30(-nm00 * centerX - nm10 * centerY - nm20 * centerZ + m30)._m31(-nm01 * centerX - nm11 * centerY - nm21 * centerZ + m31)._m32(-nm02 * centerX - nm12 * centerY - nm22 * centerZ + m32)._m33(-nm03 * centerX - nm13 * centerY - nm23 * centerZ + m33)._m20(nm20)._m21(nm21)._m22(nm22)._m23(nm23)._m10(nm10)._m11(nm11)._m12(nm12)._m13(nm13)._m00(nm00)._m01(nm01)._m02(nm02)._m03(nm03)._properties(this.properties & 0xFFFFFFF2);
        return dest;
    }

    public Matrix4f arcball(float radius, Vector3fc center, float angleX, float angleY, Matrix4f dest) {
        return this.arcball(radius, center.x(), center.y(), center.z(), angleX, angleY, dest);
    }

    public Matrix4f arcball(float radius, float centerX, float centerY, float centerZ, float angleX, float angleY) {
        return this.arcball(radius, centerX, centerY, centerZ, angleX, angleY, this);
    }

    public Matrix4f arcball(float radius, Vector3fc center, float angleX, float angleY) {
        return this.arcball(radius, center.x(), center.y(), center.z(), angleX, angleY, this);
    }

    public Matrix4f frustumAabb(Vector3f min, Vector3f max) {
        float minX = Float.POSITIVE_INFINITY;
        float minY = Float.POSITIVE_INFINITY;
        float minZ = Float.POSITIVE_INFINITY;
        float maxX = Float.NEGATIVE_INFINITY;
        float maxY = Float.NEGATIVE_INFINITY;
        float maxZ = Float.NEGATIVE_INFINITY;
        for (int t2 = 0; t2 < 8; ++t2) {
            float x2 = (float)((t2 & 1) << 1) - 1.0f;
            float y2 = (float)((t2 >>> 1 & 1) << 1) - 1.0f;
            float z2 = (float)((t2 >>> 2 & 1) << 1) - 1.0f;
            float invW = 1.0f / (this.m03() * x2 + this.m13() * y2 + this.m23() * z2 + this.m33());
            float nx = (this.m00() * x2 + this.m10() * y2 + this.m20() * z2 + this.m30()) * invW;
            float ny = (this.m01() * x2 + this.m11() * y2 + this.m21() * z2 + this.m31()) * invW;
            float nz = (this.m02() * x2 + this.m12() * y2 + this.m22() * z2 + this.m32()) * invW;
            minX = minX < nx ? minX : nx;
            minY = minY < ny ? minY : ny;
            minZ = minZ < nz ? minZ : nz;
            maxX = maxX > nx ? maxX : nx;
            maxY = maxY > ny ? maxY : ny;
            maxZ = maxZ > nz ? maxZ : nz;
        }
        min.x = minX;
        min.y = minY;
        min.z = minZ;
        max.x = maxX;
        max.y = maxY;
        max.z = maxZ;
        return this;
    }

    public Matrix4f projectedGridRange(Matrix4fc projector, float sLower, float sUpper, Matrix4f dest) {
        float minX = Float.POSITIVE_INFINITY;
        float minY = Float.POSITIVE_INFINITY;
        float maxX = Float.NEGATIVE_INFINITY;
        float maxY = Float.NEGATIVE_INFINITY;
        boolean intersection = false;
        for (int t2 = 0; t2 < 12; ++t2) {
            float c0Z;
            float c1Z;
            float c0Y;
            float c1Y;
            float c1X;
            float c0X;
            if (t2 < 4) {
                c0X = -1.0f;
                c1X = 1.0f;
                c0Y = c1Y = (float)((t2 & 1) << 1) - 1.0f;
                c0Z = c1Z = (float)((t2 >>> 1 & 1) << 1) - 1.0f;
            } else if (t2 < 8) {
                c0Y = -1.0f;
                c1Y = 1.0f;
                c0X = c1X = (float)((t2 & 1) << 1) - 1.0f;
                c0Z = c1Z = (float)((t2 >>> 1 & 1) << 1) - 1.0f;
            } else {
                c0Z = -1.0f;
                c1Z = 1.0f;
                c0X = c1X = (float)((t2 & 1) << 1) - 1.0f;
                c0Y = c1Y = (float)((t2 >>> 1 & 1) << 1) - 1.0f;
            }
            float invW = 1.0f / (this.m03() * c0X + this.m13() * c0Y + this.m23() * c0Z + this.m33());
            float p0x = (this.m00() * c0X + this.m10() * c0Y + this.m20() * c0Z + this.m30()) * invW;
            float p0y = (this.m01() * c0X + this.m11() * c0Y + this.m21() * c0Z + this.m31()) * invW;
            float p0z = (this.m02() * c0X + this.m12() * c0Y + this.m22() * c0Z + this.m32()) * invW;
            invW = 1.0f / (this.m03() * c1X + this.m13() * c1Y + this.m23() * c1Z + this.m33());
            float p1x = (this.m00() * c1X + this.m10() * c1Y + this.m20() * c1Z + this.m30()) * invW;
            float p1y = (this.m01() * c1X + this.m11() * c1Y + this.m21() * c1Z + this.m31()) * invW;
            float p1z = (this.m02() * c1X + this.m12() * c1Y + this.m22() * c1Z + this.m32()) * invW;
            float dirX = p1x - p0x;
            float dirY = p1y - p0y;
            float dirZ = p1z - p0z;
            float invDenom = 1.0f / dirY;
            for (int s2 = 0; s2 < 2; ++s2) {
                float isectT = -(p0y + (s2 == 0 ? sLower : sUpper)) * invDenom;
                if (!(isectT >= 0.0f) || !(isectT <= 1.0f)) continue;
                intersection = true;
                float ix = p0x + isectT * dirX;
                float iz = p0z + isectT * dirZ;
                invW = 1.0f / (projector.m03() * ix + projector.m23() * iz + projector.m33());
                float px = (projector.m00() * ix + projector.m20() * iz + projector.m30()) * invW;
                float py = (projector.m01() * ix + projector.m21() * iz + projector.m31()) * invW;
                minX = minX < px ? minX : px;
                minY = minY < py ? minY : py;
                maxX = maxX > px ? maxX : px;
                maxY = maxY > py ? maxY : py;
            }
        }
        if (!intersection) {
            return null;
        }
        dest.set(maxX - minX, 0.0f, 0.0f, 0.0f, 0.0f, maxY - minY, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, minX, minY, 0.0f, 1.0f);
        dest._properties(2);
        return dest;
    }

    public Matrix4f perspectiveFrustumSlice(float near, float far, Matrix4f dest) {
        float invOldNear = (this.m23() + this.m22()) / this.m32();
        float invNearFar = 1.0f / (near - far);
        dest._m00(this.m00() * invOldNear * near)._m01(this.m01())._m02(this.m02())._m03(this.m03())._m10(this.m10())._m11(this.m11() * invOldNear * near)._m12(this.m12())._m13(this.m13())._m20(this.m20())._m21(this.m21())._m22((far + near) * invNearFar)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32((far + far) * near * invNearFar)._m33(this.m33())._properties(this.properties & 0xFFFFFFE3);
        return dest;
    }

    public Matrix4f orthoCrop(Matrix4fc view, Matrix4f dest) {
        float minX = Float.POSITIVE_INFINITY;
        float maxX = Float.NEGATIVE_INFINITY;
        float minY = Float.POSITIVE_INFINITY;
        float maxY = Float.NEGATIVE_INFINITY;
        float minZ = Float.POSITIVE_INFINITY;
        float maxZ = Float.NEGATIVE_INFINITY;
        for (int t2 = 0; t2 < 8; ++t2) {
            float x2 = (float)((t2 & 1) << 1) - 1.0f;
            float y2 = (float)((t2 >>> 1 & 1) << 1) - 1.0f;
            float z2 = (float)((t2 >>> 2 & 1) << 1) - 1.0f;
            float invW = 1.0f / (this.m03() * x2 + this.m13() * y2 + this.m23() * z2 + this.m33());
            float wx = (this.m00() * x2 + this.m10() * y2 + this.m20() * z2 + this.m30()) * invW;
            float wy = (this.m01() * x2 + this.m11() * y2 + this.m21() * z2 + this.m31()) * invW;
            float wz = (this.m02() * x2 + this.m12() * y2 + this.m22() * z2 + this.m32()) * invW;
            invW = 1.0f / (view.m03() * wx + view.m13() * wy + view.m23() * wz + view.m33());
            float vx = view.m00() * wx + view.m10() * wy + view.m20() * wz + view.m30();
            float vy = view.m01() * wx + view.m11() * wy + view.m21() * wz + view.m31();
            float vz = (view.m02() * wx + view.m12() * wy + view.m22() * wz + view.m32()) * invW;
            minX = minX < vx ? minX : vx;
            maxX = maxX > vx ? maxX : vx;
            minY = minY < vy ? minY : vy;
            maxY = maxY > vy ? maxY : vy;
            minZ = minZ < vz ? minZ : vz;
            maxZ = maxZ > vz ? maxZ : vz;
        }
        return dest.setOrtho(minX, maxX, minY, maxY, -maxZ, -minZ);
    }

    public Matrix4f trapezoidCrop(float p0x, float p0y, float p1x, float p1y, float p2x, float p2y, float p3x, float p3y) {
        float aY;
        float aX = p1y - p0y;
        float nm00 = aY = p0x - p1x;
        float nm10 = -aX;
        float nm30 = aX * p0y - aY * p0x;
        float nm01 = aX;
        float nm11 = aY;
        float nm31 = -(aX * p0x + aY * p0y);
        float c3x = nm00 * p3x + nm10 * p3y + nm30;
        float c3y = nm01 * p3x + nm11 * p3y + nm31;
        float s2 = -c3x / c3y;
        float d1x = (nm00 += s2 * nm01) * p1x + (nm10 += s2 * nm11) * p1y + (nm30 += s2 * nm31);
        float d2x = nm00 * p2x + nm10 * p2y + nm30;
        float d2 = d1x * c3y / (d2x - d1x);
        nm31 += d2;
        float sx = 2.0f / d2x;
        float sy = 1.0f / (c3y + d2);
        float u2 = (sy + sy) * d2 / (1.0f - sy * d2);
        float m03 = nm01 * sy;
        float m13 = nm11 * sy;
        float m33 = nm31 * sy;
        nm01 = (u2 + 1.0f) * m03;
        nm11 = (u2 + 1.0f) * m13;
        nm31 = (u2 + 1.0f) * m33 - u2;
        nm00 = sx * nm00 - m03;
        nm10 = sx * nm10 - m13;
        nm30 = sx * nm30 - m33;
        this.set(nm00, nm01, 0.0f, m03, nm10, nm11, 0.0f, m13, 0.0f, 0.0f, 1.0f, 0.0f, nm30, nm31, 0.0f, m33);
        this._properties(0);
        return this;
    }

    public Matrix4f transformAab(float minX, float minY, float minZ, float maxX, float maxY, float maxZ, Vector3f outMin, Vector3f outMax) {
        float zmaxz;
        float zminz;
        float zmaxy;
        float zminy;
        float zmaxx;
        float zminx;
        float ymaxz;
        float yminz;
        float ymaxy;
        float yminy;
        float ymaxx;
        float yminx;
        float xmaxz;
        float xminz;
        float xmaxy;
        float xminy;
        float xmaxx;
        float xminx;
        float xax = this.m00() * minX;
        float xay = this.m01() * minX;
        float xaz = this.m02() * minX;
        float xbx = this.m00() * maxX;
        float xby = this.m01() * maxX;
        float xbz = this.m02() * maxX;
        float yax = this.m10() * minY;
        float yay = this.m11() * minY;
        float yaz = this.m12() * minY;
        float ybx = this.m10() * maxY;
        float yby = this.m11() * maxY;
        float ybz = this.m12() * maxY;
        float zax = this.m20() * minZ;
        float zay = this.m21() * minZ;
        float zaz = this.m22() * minZ;
        float zbx = this.m20() * maxZ;
        float zby = this.m21() * maxZ;
        float zbz = this.m22() * maxZ;
        if (xax < xbx) {
            xminx = xax;
            xmaxx = xbx;
        } else {
            xminx = xbx;
            xmaxx = xax;
        }
        if (xay < xby) {
            xminy = xay;
            xmaxy = xby;
        } else {
            xminy = xby;
            xmaxy = xay;
        }
        if (xaz < xbz) {
            xminz = xaz;
            xmaxz = xbz;
        } else {
            xminz = xbz;
            xmaxz = xaz;
        }
        if (yax < ybx) {
            yminx = yax;
            ymaxx = ybx;
        } else {
            yminx = ybx;
            ymaxx = yax;
        }
        if (yay < yby) {
            yminy = yay;
            ymaxy = yby;
        } else {
            yminy = yby;
            ymaxy = yay;
        }
        if (yaz < ybz) {
            yminz = yaz;
            ymaxz = ybz;
        } else {
            yminz = ybz;
            ymaxz = yaz;
        }
        if (zax < zbx) {
            zminx = zax;
            zmaxx = zbx;
        } else {
            zminx = zbx;
            zmaxx = zax;
        }
        if (zay < zby) {
            zminy = zay;
            zmaxy = zby;
        } else {
            zminy = zby;
            zmaxy = zay;
        }
        if (zaz < zbz) {
            zminz = zaz;
            zmaxz = zbz;
        } else {
            zminz = zbz;
            zmaxz = zaz;
        }
        outMin.x = xminx + yminx + zminx + this.m30();
        outMin.y = xminy + yminy + zminy + this.m31();
        outMin.z = xminz + yminz + zminz + this.m32();
        outMax.x = xmaxx + ymaxx + zmaxx + this.m30();
        outMax.y = xmaxy + ymaxy + zmaxy + this.m31();
        outMax.z = xmaxz + ymaxz + zmaxz + this.m32();
        return this;
    }

    public Matrix4f transformAab(Vector3fc min, Vector3fc max, Vector3f outMin, Vector3f outMax) {
        return this.transformAab(min.x(), min.y(), min.z(), max.x(), max.y(), max.z(), outMin, outMax);
    }

    public Matrix4f lerp(Matrix4fc other, float t2) {
        return this.lerp(other, t2, this);
    }

    public Matrix4f lerp(Matrix4fc other, float t2, Matrix4f dest) {
        dest._m00(Math.fma(other.m00() - this.m00(), t2, this.m00()))._m01(Math.fma(other.m01() - this.m01(), t2, this.m01()))._m02(Math.fma(other.m02() - this.m02(), t2, this.m02()))._m03(Math.fma(other.m03() - this.m03(), t2, this.m03()))._m10(Math.fma(other.m10() - this.m10(), t2, this.m10()))._m11(Math.fma(other.m11() - this.m11(), t2, this.m11()))._m12(Math.fma(other.m12() - this.m12(), t2, this.m12()))._m13(Math.fma(other.m13() - this.m13(), t2, this.m13()))._m20(Math.fma(other.m20() - this.m20(), t2, this.m20()))._m21(Math.fma(other.m21() - this.m21(), t2, this.m21()))._m22(Math.fma(other.m22() - this.m22(), t2, this.m22()))._m23(Math.fma(other.m23() - this.m23(), t2, this.m23()))._m30(Math.fma(other.m30() - this.m30(), t2, this.m30()))._m31(Math.fma(other.m31() - this.m31(), t2, this.m31()))._m32(Math.fma(other.m32() - this.m32(), t2, this.m32()))._m33(Math.fma(other.m33() - this.m33(), t2, this.m33()))._properties(this.properties & other.properties());
        return dest;
    }

    public Matrix4f rotateTowards(Vector3fc dir, Vector3fc up, Matrix4f dest) {
        return this.rotateTowards(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z(), dest);
    }

    public Matrix4f rotateTowards(Vector3fc dir, Vector3fc up) {
        return this.rotateTowards(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z(), this);
    }

    public Matrix4f rotateTowards(float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        return this.rotateTowards(dirX, dirY, dirZ, upX, upY, upZ, this);
    }

    public Matrix4f rotateTowards(float dirX, float dirY, float dirZ, float upX, float upY, float upZ, Matrix4f dest) {
        float invDirLength = Math.invsqrt(dirX * dirX + dirY * dirY + dirZ * dirZ);
        float ndirX = dirX * invDirLength;
        float ndirY = dirY * invDirLength;
        float ndirZ = dirZ * invDirLength;
        float leftX = upY * ndirZ - upZ * ndirY;
        float leftY = upZ * ndirX - upX * ndirZ;
        float leftZ = upX * ndirY - upY * ndirX;
        float invLeftLength = Math.invsqrt(leftX * leftX + leftY * leftY + leftZ * leftZ);
        float upnX = ndirY * (leftZ *= invLeftLength) - ndirZ * (leftY *= invLeftLength);
        float upnY = ndirZ * (leftX *= invLeftLength) - ndirX * leftZ;
        float upnZ = ndirX * leftY - ndirY * leftX;
        float rm00 = leftX;
        float rm01 = leftY;
        float rm02 = leftZ;
        float rm10 = upnX;
        float rm11 = upnY;
        float rm12 = upnZ;
        float rm20 = ndirX;
        float rm21 = ndirY;
        float rm22 = ndirZ;
        dest._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33());
        float nm00 = this.m00() * rm00 + this.m10() * rm01 + this.m20() * rm02;
        float nm01 = this.m01() * rm00 + this.m11() * rm01 + this.m21() * rm02;
        float nm02 = this.m02() * rm00 + this.m12() * rm01 + this.m22() * rm02;
        float nm03 = this.m03() * rm00 + this.m13() * rm01 + this.m23() * rm02;
        float nm10 = this.m00() * rm10 + this.m10() * rm11 + this.m20() * rm12;
        float nm11 = this.m01() * rm10 + this.m11() * rm11 + this.m21() * rm12;
        float nm12 = this.m02() * rm10 + this.m12() * rm11 + this.m22() * rm12;
        float nm13 = this.m03() * rm10 + this.m13() * rm11 + this.m23() * rm12;
        dest._m20(this.m00() * rm20 + this.m10() * rm21 + this.m20() * rm22)._m21(this.m01() * rm20 + this.m11() * rm21 + this.m21() * rm22)._m22(this.m02() * rm20 + this.m12() * rm21 + this.m22() * rm22)._m23(this.m03() * rm20 + this.m13() * rm21 + this.m23() * rm22)._m00(nm00)._m01(nm01)._m02(nm02)._m03(nm03)._m10(nm10)._m11(nm11)._m12(nm12)._m13(nm13)._properties(this.properties & 0xFFFFFFF2);
        return dest;
    }

    public Matrix4f rotationTowards(Vector3fc dir, Vector3fc up) {
        return this.rotationTowards(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z());
    }

    public Matrix4f rotationTowards(float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        float invDirLength = Math.invsqrt(dirX * dirX + dirY * dirY + dirZ * dirZ);
        float ndirX = dirX * invDirLength;
        float ndirY = dirY * invDirLength;
        float ndirZ = dirZ * invDirLength;
        float leftX = upY * ndirZ - upZ * ndirY;
        float leftY = upZ * ndirX - upX * ndirZ;
        float leftZ = upX * ndirY - upY * ndirX;
        float invLeftLength = Math.invsqrt(leftX * leftX + leftY * leftY + leftZ * leftZ);
        float upnX = ndirY * (leftZ *= invLeftLength) - ndirZ * (leftY *= invLeftLength);
        float upnY = ndirZ * (leftX *= invLeftLength) - ndirX * leftZ;
        float upnZ = ndirX * leftY - ndirY * leftX;
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        this._m00(leftX)._m01(leftY)._m02(leftZ)._m10(upnX)._m11(upnY)._m12(upnZ)._m20(ndirX)._m21(ndirY)._m22(ndirZ)._properties(18);
        return this;
    }

    public Matrix4f translationRotateTowards(Vector3fc pos, Vector3fc dir, Vector3fc up) {
        return this.translationRotateTowards(pos.x(), pos.y(), pos.z(), dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z());
    }

    public Matrix4f translationRotateTowards(float posX, float posY, float posZ, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        float invDirLength = Math.invsqrt(dirX * dirX + dirY * dirY + dirZ * dirZ);
        float ndirX = dirX * invDirLength;
        float ndirY = dirY * invDirLength;
        float ndirZ = dirZ * invDirLength;
        float leftX = upY * ndirZ - upZ * ndirY;
        float leftY = upZ * ndirX - upX * ndirZ;
        float leftZ = upX * ndirY - upY * ndirX;
        float invLeftLength = Math.invsqrt(leftX * leftX + leftY * leftY + leftZ * leftZ);
        float upnX = ndirY * (leftZ *= invLeftLength) - ndirZ * (leftY *= invLeftLength);
        float upnY = ndirZ * (leftX *= invLeftLength) - ndirX * leftZ;
        float upnZ = ndirX * leftY - ndirY * leftX;
        this._m00(leftX)._m01(leftY)._m02(leftZ)._m03(0.0f)._m10(upnX)._m11(upnY)._m12(upnZ)._m13(0.0f)._m20(ndirX)._m21(ndirY)._m22(ndirZ)._m23(0.0f)._m30(posX)._m31(posY)._m32(posZ)._m33(1.0f)._properties(18);
        return this;
    }

    public Vector3f getEulerAnglesZYX(Vector3f dest) {
        dest.x = Math.atan2(this.m12(), this.m22());
        dest.y = Math.atan2(-this.m02(), Math.sqrt(1.0f - this.m02() * this.m02()));
        dest.z = Math.atan2(this.m01(), this.m00());
        return dest;
    }

    public Vector3f getEulerAnglesXYZ(Vector3f dest) {
        dest.x = Math.atan2(-this.m21(), this.m22());
        dest.y = Math.atan2(this.m20(), Math.sqrt(1.0f - this.m20() * this.m20()));
        dest.z = Math.atan2(-this.m10(), this.m00());
        return dest;
    }

    public Matrix4f affineSpan(Vector3f corner, Vector3f xDir, Vector3f yDir, Vector3f zDir) {
        float a2 = this.m10() * this.m22();
        float b2 = this.m10() * this.m21();
        float c2 = this.m10() * this.m02();
        float d2 = this.m10() * this.m01();
        float e2 = this.m11() * this.m22();
        float f2 = this.m11() * this.m20();
        float g2 = this.m11() * this.m02();
        float h2 = this.m11() * this.m00();
        float i2 = this.m12() * this.m21();
        float j2 = this.m12() * this.m20();
        float k2 = this.m12() * this.m01();
        float l2 = this.m12() * this.m00();
        float m2 = this.m20() * this.m02();
        float n2 = this.m20() * this.m01();
        float o2 = this.m21() * this.m02();
        float p2 = this.m21() * this.m00();
        float q2 = this.m22() * this.m01();
        float r2 = this.m22() * this.m00();
        float s2 = 1.0f / (this.m00() * this.m11() - this.m01() * this.m10()) * this.m22() + (this.m02() * this.m10() - this.m00() * this.m12()) * this.m21() + (this.m01() * this.m12() - this.m02() * this.m11()) * this.m20();
        float nm00 = (e2 - i2) * s2;
        float nm01 = (o2 - q2) * s2;
        float nm02 = (k2 - g2) * s2;
        float nm10 = (j2 - a2) * s2;
        float nm11 = (r2 - m2) * s2;
        float nm12 = (c2 - l2) * s2;
        float nm20 = (b2 - f2) * s2;
        float nm21 = (n2 - p2) * s2;
        float nm22 = (h2 - d2) * s2;
        corner.x = -nm00 - nm10 - nm20 + (a2 * this.m31() - b2 * this.m32() + f2 * this.m32() - e2 * this.m30() + i2 * this.m30() - j2 * this.m31()) * s2;
        corner.y = -nm01 - nm11 - nm21 + (m2 * this.m31() - n2 * this.m32() + p2 * this.m32() - o2 * this.m30() + q2 * this.m30() - r2 * this.m31()) * s2;
        corner.z = -nm02 - nm12 - nm22 + (g2 * this.m30() - k2 * this.m30() + l2 * this.m31() - c2 * this.m31() + d2 * this.m32() - h2 * this.m32()) * s2;
        xDir.x = 2.0f * nm00;
        xDir.y = 2.0f * nm01;
        xDir.z = 2.0f * nm02;
        yDir.x = 2.0f * nm10;
        yDir.y = 2.0f * nm11;
        yDir.z = 2.0f * nm12;
        zDir.x = 2.0f * nm20;
        zDir.y = 2.0f * nm21;
        zDir.z = 2.0f * nm22;
        return this;
    }

    public boolean testPoint(float x2, float y2, float z2) {
        float nxX = this.m03() + this.m00();
        float nxY = this.m13() + this.m10();
        float nxZ = this.m23() + this.m20();
        float nxW = this.m33() + this.m30();
        float pxX = this.m03() - this.m00();
        float pxY = this.m13() - this.m10();
        float pxZ = this.m23() - this.m20();
        float pxW = this.m33() - this.m30();
        float nyX = this.m03() + this.m01();
        float nyY = this.m13() + this.m11();
        float nyZ = this.m23() + this.m21();
        float nyW = this.m33() + this.m31();
        float pyX = this.m03() - this.m01();
        float pyY = this.m13() - this.m11();
        float pyZ = this.m23() - this.m21();
        float pyW = this.m33() - this.m31();
        float nzX = this.m03() + this.m02();
        float nzY = this.m13() + this.m12();
        float nzZ = this.m23() + this.m22();
        float nzW = this.m33() + this.m32();
        float pzX = this.m03() - this.m02();
        float pzY = this.m13() - this.m12();
        float pzZ = this.m23() - this.m22();
        float pzW = this.m33() - this.m32();
        return nxX * x2 + nxY * y2 + nxZ * z2 + nxW >= 0.0f && pxX * x2 + pxY * y2 + pxZ * z2 + pxW >= 0.0f && nyX * x2 + nyY * y2 + nyZ * z2 + nyW >= 0.0f && pyX * x2 + pyY * y2 + pyZ * z2 + pyW >= 0.0f && nzX * x2 + nzY * y2 + nzZ * z2 + nzW >= 0.0f && pzX * x2 + pzY * y2 + pzZ * z2 + pzW >= 0.0f;
    }

    public boolean testSphere(float x2, float y2, float z2, float r2) {
        float nxX = this.m03() + this.m00();
        float nxY = this.m13() + this.m10();
        float nxZ = this.m23() + this.m20();
        float nxW = this.m33() + this.m30();
        float invl = Math.invsqrt(nxX * nxX + nxY * nxY + nxZ * nxZ);
        nxX *= invl;
        nxY *= invl;
        nxZ *= invl;
        nxW *= invl;
        float pxX = this.m03() - this.m00();
        float pxY = this.m13() - this.m10();
        float pxZ = this.m23() - this.m20();
        float pxW = this.m33() - this.m30();
        invl = Math.invsqrt(pxX * pxX + pxY * pxY + pxZ * pxZ);
        pxX *= invl;
        pxY *= invl;
        pxZ *= invl;
        pxW *= invl;
        float nyX = this.m03() + this.m01();
        float nyY = this.m13() + this.m11();
        float nyZ = this.m23() + this.m21();
        float nyW = this.m33() + this.m31();
        invl = Math.invsqrt(nyX * nyX + nyY * nyY + nyZ * nyZ);
        nyX *= invl;
        nyY *= invl;
        nyZ *= invl;
        nyW *= invl;
        float pyX = this.m03() - this.m01();
        float pyY = this.m13() - this.m11();
        float pyZ = this.m23() - this.m21();
        float pyW = this.m33() - this.m31();
        invl = Math.invsqrt(pyX * pyX + pyY * pyY + pyZ * pyZ);
        pyX *= invl;
        pyY *= invl;
        pyZ *= invl;
        pyW *= invl;
        float nzX = this.m03() + this.m02();
        float nzY = this.m13() + this.m12();
        float nzZ = this.m23() + this.m22();
        float nzW = this.m33() + this.m32();
        invl = Math.invsqrt(nzX * nzX + nzY * nzY + nzZ * nzZ);
        nzX *= invl;
        nzY *= invl;
        nzZ *= invl;
        nzW *= invl;
        float pzX = this.m03() - this.m02();
        float pzY = this.m13() - this.m12();
        float pzZ = this.m23() - this.m22();
        float pzW = this.m33() - this.m32();
        invl = Math.invsqrt(pzX * pzX + pzY * pzY + pzZ * pzZ);
        return nxX * x2 + nxY * y2 + nxZ * z2 + nxW >= -r2 && pxX * x2 + pxY * y2 + pxZ * z2 + pxW >= -r2 && nyX * x2 + nyY * y2 + nyZ * z2 + nyW >= -r2 && pyX * x2 + pyY * y2 + pyZ * z2 + pyW >= -r2 && nzX * x2 + nzY * y2 + nzZ * z2 + nzW >= -r2 && (pzX *= invl) * x2 + (pzY *= invl) * y2 + (pzZ *= invl) * z2 + (pzW *= invl) >= -r2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean testAab(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        float nxX = this.m03() + this.m00();
        float nxY = this.m13() + this.m10();
        float nxZ = this.m23() + this.m20();
        float nxW = this.m33() + this.m30();
        float pxX = this.m03() - this.m00();
        float pxY = this.m13() - this.m10();
        float pxZ = this.m23() - this.m20();
        float pxW = this.m33() - this.m30();
        float nyX = this.m03() + this.m01();
        float nyY = this.m13() + this.m11();
        float nyZ = this.m23() + this.m21();
        float nyW = this.m33() + this.m31();
        float pyX = this.m03() - this.m01();
        float pyY = this.m13() - this.m11();
        float pyZ = this.m23() - this.m21();
        float pyW = this.m33() - this.m31();
        float nzX = this.m03() + this.m02();
        float nzY = this.m13() + this.m12();
        float nzZ = this.m23() + this.m22();
        float nzW = this.m33() + this.m32();
        float pzX = this.m03() - this.m02();
        float pzY = this.m13() - this.m12();
        float pzZ = this.m23() - this.m22();
        float pzW = this.m33() - this.m32();
        float f2 = nxX * (nxX < 0.0f ? minX : maxX) + nxY * (nxY < 0.0f ? minY : maxY);
        float f3 = nxZ < 0.0f ? minZ : maxZ;
        if (!(f2 + nxZ * f3 >= -nxW)) return false;
        float f4 = pxX * (pxX < 0.0f ? minX : maxX) + pxY * (pxY < 0.0f ? minY : maxY);
        float f5 = pxZ < 0.0f ? minZ : maxZ;
        if (!(f4 + pxZ * f5 >= -pxW)) return false;
        float f6 = nyX * (nyX < 0.0f ? minX : maxX) + nyY * (nyY < 0.0f ? minY : maxY);
        float f7 = nyZ < 0.0f ? minZ : maxZ;
        if (!(f6 + nyZ * f7 >= -nyW)) return false;
        float f8 = pyX * (pyX < 0.0f ? minX : maxX) + pyY * (pyY < 0.0f ? minY : maxY);
        float f9 = pyZ < 0.0f ? minZ : maxZ;
        if (!(f8 + pyZ * f9 >= -pyW)) return false;
        float f10 = nzX * (nzX < 0.0f ? minX : maxX) + nzY * (nzY < 0.0f ? minY : maxY);
        float f11 = nzZ < 0.0f ? minZ : maxZ;
        if (!(f10 + nzZ * f11 >= -nzW)) return false;
        float f12 = pzX * (pzX < 0.0f ? minX : maxX) + pzY * (pzY < 0.0f ? minY : maxY);
        float f13 = pzZ < 0.0f ? minZ : maxZ;
        if (!(f12 + pzZ * f13 >= -pzW)) return false;
        return true;
    }

    public Matrix4f obliqueZ(float a2, float b2) {
        return this._m20(this.m00() * a2 + this.m10() * b2 + this.m20())._m21(this.m01() * a2 + this.m11() * b2 + this.m21())._m22(this.m02() * a2 + this.m12() * b2 + this.m22())._properties(this.properties & 2);
    }

    public Matrix4f obliqueZ(float a2, float b2, Matrix4f dest) {
        dest._m00(this.m00())._m01(this.m01())._m02(this.m02())._m03(this.m03())._m10(this.m10())._m11(this.m11())._m12(this.m12())._m13(this.m13())._m20(this.m00() * a2 + this.m10() * b2 + this.m20())._m21(this.m01() * a2 + this.m11() * b2 + this.m21())._m22(this.m02() * a2 + this.m12() * b2 + this.m22())._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 2);
        return dest;
    }

    public static void perspectiveOffCenterViewFromRectangle(Vector3f eye, Vector3f p2, Vector3f x2, Vector3f y2, float nearFarDist, boolean zeroToOne, Matrix4f projDest, Matrix4f viewDest) {
        float far;
        float zx = y2.y * x2.z - y2.z * x2.y;
        float zy = y2.z * x2.x - y2.x * x2.z;
        float zz = y2.x * x2.y - y2.y * x2.x;
        float zd = zx * (p2.x - eye.x) + zy * (p2.y - eye.y) + zz * (p2.z - eye.z);
        float zs = zd >= 0.0f ? 1.0f : -1.0f;
        zd *= zs;
        viewDest.setLookAt(eye.x, eye.y, eye.z, eye.x + (zx *= zs), eye.y + (zy *= zs), eye.z + (zz *= zs), y2.x, y2.y, y2.z);
        float px = viewDest.m00() * p2.x + viewDest.m10() * p2.y + viewDest.m20() * p2.z + viewDest.m30();
        float py = viewDest.m01() * p2.x + viewDest.m11() * p2.y + viewDest.m21() * p2.z + viewDest.m31();
        float tx = viewDest.m00() * x2.x + viewDest.m10() * x2.y + viewDest.m20() * x2.z;
        float ty = viewDest.m01() * y2.x + viewDest.m11() * y2.y + viewDest.m21() * y2.z;
        float len = Math.sqrt(zx * zx + zy * zy + zz * zz);
        float near = zd / len;
        if (Float.isInfinite(nearFarDist) && nearFarDist < 0.0f) {
            far = near;
            near = Float.POSITIVE_INFINITY;
        } else if (Float.isInfinite(nearFarDist) && nearFarDist > 0.0f) {
            far = Float.POSITIVE_INFINITY;
        } else if (nearFarDist < 0.0f) {
            far = near;
            near += nearFarDist;
        } else {
            far = near + nearFarDist;
        }
        projDest.setFrustum(px, px + tx, py, py + ty, near, far, zeroToOne);
    }

    public Matrix4f withLookAtUp(Vector3fc up) {
        return this.withLookAtUp(up.x(), up.y(), up.z(), this);
    }

    public Matrix4f withLookAtUp(Vector3fc up, Matrix4f dest) {
        return this.withLookAtUp(up.x(), up.y(), up.z());
    }

    public Matrix4f withLookAtUp(float upX, float upY, float upZ) {
        return this.withLookAtUp(upX, upY, upZ, this);
    }

    public Matrix4f withLookAtUp(float upX, float upY, float upZ, Matrix4f dest) {
        float y2 = (upY * this.m21() - upZ * this.m11()) * this.m02() + (upZ * this.m01() - upX * this.m21()) * this.m12() + (upX * this.m11() - upY * this.m01()) * this.m22();
        float x2 = upX * this.m01() + upY * this.m11() + upZ * this.m21();
        if ((this.properties & 0x10) == 0) {
            x2 *= Math.sqrt(this.m01() * this.m01() + this.m11() * this.m11() + this.m21() * this.m21());
        }
        float invsqrt = Math.invsqrt(y2 * y2 + x2 * x2);
        float c2 = x2 * invsqrt;
        float s2 = y2 * invsqrt;
        float nm00 = c2 * this.m00() - s2 * this.m01();
        float nm10 = c2 * this.m10() - s2 * this.m11();
        float nm20 = c2 * this.m20() - s2 * this.m21();
        float nm31 = s2 * this.m30() + c2 * this.m31();
        float nm01 = s2 * this.m00() + c2 * this.m01();
        float nm11 = s2 * this.m10() + c2 * this.m11();
        float nm21 = s2 * this.m20() + c2 * this.m21();
        float nm30 = c2 * this.m30() - s2 * this.m31();
        dest._m00(nm00)._m10(nm10)._m20(nm20)._m30(nm30)._m01(nm01)._m11(nm11)._m21(nm21)._m31(nm31);
        if (dest != this) {
            dest._m02(this.m02())._m12(this.m12())._m22(this.m22())._m32(this.m32())._m03(this.m03())._m13(this.m13())._m23(this.m23())._m33(this.m33());
        }
        dest._properties(this.properties & 0xFFFFFFF2);
        return dest;
    }

    public Matrix4f mapXZY() {
        return this.mapXZY(this);
    }

    public Matrix4f mapXZY(Matrix4f dest) {
        float m10 = this.m10();
        float m11 = this.m11();
        float m12 = this.m12();
        return dest._m00(this.m00())._m01(this.m01())._m02(this.m02())._m03(this.m03())._m10(this.m20())._m11(this.m21())._m12(this.m22())._m13(this.m13())._m20(m10)._m21(m11)._m22(m12)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapXZnY() {
        return this.mapXZnY(this);
    }

    public Matrix4f mapXZnY(Matrix4f dest) {
        float m10 = this.m10();
        float m11 = this.m11();
        float m12 = this.m12();
        return dest._m00(this.m00())._m01(this.m01())._m02(this.m02())._m03(this.m03())._m10(this.m20())._m11(this.m21())._m12(this.m22())._m13(this.m13())._m20(-m10)._m21(-m11)._m22(-m12)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapXnYnZ() {
        return this.mapXnYnZ(this);
    }

    public Matrix4f mapXnYnZ(Matrix4f dest) {
        return dest._m00(this.m00())._m01(this.m01())._m02(this.m02())._m03(this.m03())._m10(-this.m10())._m11(-this.m11())._m12(-this.m12())._m13(this.m13())._m20(-this.m20())._m21(-this.m21())._m22(-this.m22())._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapXnZY() {
        return this.mapXnZY(this);
    }

    public Matrix4f mapXnZY(Matrix4f dest) {
        float m10 = this.m10();
        float m11 = this.m11();
        float m12 = this.m12();
        return dest._m00(this.m00())._m01(this.m01())._m02(this.m02())._m03(this.m03())._m10(-this.m20())._m11(-this.m21())._m12(-this.m22())._m13(this.m13())._m20(m10)._m21(m11)._m22(m12)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapXnZnY() {
        return this.mapXnZnY(this);
    }

    public Matrix4f mapXnZnY(Matrix4f dest) {
        float m10 = this.m10();
        float m11 = this.m11();
        float m12 = this.m12();
        return dest._m00(this.m00())._m01(this.m01())._m02(this.m02())._m03(this.m03())._m10(-this.m20())._m11(-this.m21())._m12(-this.m22())._m13(this.m13())._m20(-m10)._m21(-m11)._m22(-m12)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapYXZ() {
        return this.mapYXZ(this);
    }

    public Matrix4f mapYXZ(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        return dest._m00(this.m10())._m01(this.m11())._m02(this.m12())._m03(this.m03())._m10(m00)._m11(m01)._m12(m02)._m13(this.m13())._m20(this.m20())._m21(this.m21())._m22(this.m22())._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapYXnZ() {
        return this.mapYXnZ(this);
    }

    public Matrix4f mapYXnZ(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        return dest._m00(this.m10())._m01(this.m11())._m02(this.m12())._m03(this.m03())._m10(m00)._m11(m01)._m12(m02)._m13(this.m13())._m20(-this.m20())._m21(-this.m21())._m22(-this.m22())._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapYZX() {
        return this.mapYZX(this);
    }

    public Matrix4f mapYZX(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        return dest._m00(this.m10())._m01(this.m11())._m02(this.m12())._m03(this.m03())._m10(this.m20())._m11(this.m21())._m12(this.m22())._m13(this.m13())._m20(m00)._m21(m01)._m22(m02)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapYZnX() {
        return this.mapYZnX(this);
    }

    public Matrix4f mapYZnX(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        return dest._m00(this.m10())._m01(this.m11())._m02(this.m12())._m03(this.m03())._m10(this.m20())._m11(this.m21())._m12(this.m22())._m13(this.m13())._m20(-m00)._m21(-m01)._m22(-m02)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapYnXZ() {
        return this.mapYnXZ(this);
    }

    public Matrix4f mapYnXZ(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        return dest._m00(this.m10())._m01(this.m11())._m02(this.m12())._m03(this.m03())._m10(-m00)._m11(-m01)._m12(-m02)._m13(this.m13())._m20(this.m20())._m21(this.m21())._m22(this.m22())._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapYnXnZ() {
        return this.mapYnXnZ(this);
    }

    public Matrix4f mapYnXnZ(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        return dest._m00(this.m10())._m01(this.m11())._m02(this.m12())._m03(this.m03())._m10(-m00)._m11(-m01)._m12(-m02)._m13(this.m13())._m20(-this.m20())._m21(-this.m21())._m22(-this.m22())._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapYnZX() {
        return this.mapYnZX(this);
    }

    public Matrix4f mapYnZX(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        return dest._m00(this.m10())._m01(this.m11())._m02(this.m12())._m03(this.m03())._m10(-this.m20())._m11(-this.m21())._m12(-this.m22())._m13(this.m13())._m20(m00)._m21(m01)._m22(m02)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapYnZnX() {
        return this.mapYnZnX(this);
    }

    public Matrix4f mapYnZnX(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        return dest._m00(this.m10())._m01(this.m11())._m02(this.m12())._m03(this.m03())._m10(-this.m20())._m11(-this.m21())._m12(-this.m22())._m13(this.m13())._m20(-m00)._m21(-m01)._m22(-m02)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapZXY() {
        return this.mapZXY(this);
    }

    public Matrix4f mapZXY(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        float m10 = this.m10();
        float m11 = this.m11();
        float m12 = this.m12();
        return dest._m00(this.m20())._m01(this.m21())._m02(this.m22())._m03(this.m03())._m10(m00)._m11(m01)._m12(m02)._m13(this.m13())._m20(m10)._m21(m11)._m22(m12)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapZXnY() {
        return this.mapZXnY(this);
    }

    public Matrix4f mapZXnY(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        float m10 = this.m10();
        float m11 = this.m11();
        float m12 = this.m12();
        return dest._m00(this.m20())._m01(this.m21())._m02(this.m22())._m03(this.m03())._m10(m00)._m11(m01)._m12(m02)._m13(this.m13())._m20(-m10)._m21(-m11)._m22(-m12)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapZYX() {
        return this.mapZYX(this);
    }

    public Matrix4f mapZYX(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        return dest._m00(this.m20())._m01(this.m21())._m02(this.m22())._m03(this.m03())._m10(this.m10())._m11(this.m11())._m12(this.m12())._m13(this.m13())._m20(m00)._m21(m01)._m22(m02)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapZYnX() {
        return this.mapZYnX(this);
    }

    public Matrix4f mapZYnX(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        return dest._m00(this.m20())._m01(this.m21())._m02(this.m22())._m03(this.m03())._m10(this.m10())._m11(this.m11())._m12(this.m12())._m13(this.m13())._m20(-m00)._m21(-m01)._m22(-m02)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapZnXY() {
        return this.mapZnXY(this);
    }

    public Matrix4f mapZnXY(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        float m10 = this.m10();
        float m11 = this.m11();
        float m12 = this.m12();
        return dest._m00(this.m20())._m01(this.m21())._m02(this.m22())._m03(this.m03())._m10(-m00)._m11(-m01)._m12(-m02)._m13(this.m13())._m20(m10)._m21(m11)._m22(m12)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapZnXnY() {
        return this.mapZnXnY(this);
    }

    public Matrix4f mapZnXnY(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        float m10 = this.m10();
        float m11 = this.m11();
        float m12 = this.m12();
        return dest._m00(this.m20())._m01(this.m21())._m02(this.m22())._m03(this.m03())._m10(-m00)._m11(-m01)._m12(-m02)._m13(this.m13())._m20(-m10)._m21(-m11)._m22(-m12)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapZnYX() {
        return this.mapZnYX(this);
    }

    public Matrix4f mapZnYX(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        return dest._m00(this.m20())._m01(this.m21())._m02(this.m22())._m03(this.m03())._m10(-this.m10())._m11(-this.m11())._m12(-this.m12())._m13(this.m13())._m20(m00)._m21(m01)._m22(m02)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapZnYnX() {
        return this.mapZnYnX(this);
    }

    public Matrix4f mapZnYnX(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        return dest._m00(this.m20())._m01(this.m21())._m02(this.m22())._m03(this.m03())._m10(-this.m10())._m11(-this.m11())._m12(-this.m12())._m13(this.m13())._m20(-m00)._m21(-m01)._m22(-m02)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapnXYnZ() {
        return this.mapnXYnZ(this);
    }

    public Matrix4f mapnXYnZ(Matrix4f dest) {
        return dest._m00(-this.m00())._m01(-this.m01())._m02(-this.m02())._m03(this.m03())._m10(this.m10())._m11(this.m11())._m12(this.m12())._m13(this.m13())._m20(-this.m20())._m21(-this.m21())._m22(-this.m22())._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapnXZY() {
        return this.mapnXZY(this);
    }

    public Matrix4f mapnXZY(Matrix4f dest) {
        float m10 = this.m10();
        float m11 = this.m11();
        float m12 = this.m12();
        return dest._m00(-this.m00())._m01(-this.m01())._m02(-this.m02())._m03(this.m03())._m10(this.m20())._m11(this.m21())._m12(this.m22())._m13(this.m13())._m20(m10)._m21(m11)._m22(m12)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapnXZnY() {
        return this.mapnXZnY(this);
    }

    public Matrix4f mapnXZnY(Matrix4f dest) {
        float m10 = this.m10();
        float m11 = this.m11();
        float m12 = this.m12();
        return dest._m00(-this.m00())._m01(-this.m01())._m02(-this.m02())._m03(this.m03())._m10(this.m20())._m11(this.m21())._m12(this.m22())._m13(this.m13())._m20(-m10)._m21(-m11)._m22(-m12)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapnXnYZ() {
        return this.mapnXnYZ(this);
    }

    public Matrix4f mapnXnYZ(Matrix4f dest) {
        return dest._m00(-this.m00())._m01(-this.m01())._m02(-this.m02())._m03(this.m03())._m10(-this.m10())._m11(-this.m11())._m12(-this.m12())._m13(this.m13())._m20(this.m20())._m21(this.m21())._m22(this.m22())._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapnXnYnZ() {
        return this.mapnXnYnZ(this);
    }

    public Matrix4f mapnXnYnZ(Matrix4f dest) {
        return dest._m00(-this.m00())._m01(-this.m01())._m02(-this.m02())._m03(this.m03())._m10(-this.m10())._m11(-this.m11())._m12(-this.m12())._m13(this.m13())._m20(-this.m20())._m21(-this.m21())._m22(-this.m22())._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapnXnZY() {
        return this.mapnXnZY(this);
    }

    public Matrix4f mapnXnZY(Matrix4f dest) {
        float m10 = this.m10();
        float m11 = this.m11();
        float m12 = this.m12();
        return dest._m00(-this.m00())._m01(-this.m01())._m02(-this.m02())._m03(this.m03())._m10(-this.m20())._m11(-this.m21())._m12(-this.m22())._m13(this.m13())._m20(m10)._m21(m11)._m22(m12)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapnXnZnY() {
        return this.mapnXnZnY(this);
    }

    public Matrix4f mapnXnZnY(Matrix4f dest) {
        float m10 = this.m10();
        float m11 = this.m11();
        float m12 = this.m12();
        return dest._m00(-this.m00())._m01(-this.m01())._m02(-this.m02())._m03(this.m03())._m10(-this.m20())._m11(-this.m21())._m12(-this.m22())._m13(this.m13())._m20(-m10)._m21(-m11)._m22(-m12)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapnYXZ() {
        return this.mapnYXZ(this);
    }

    public Matrix4f mapnYXZ(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        return dest._m00(-this.m10())._m01(-this.m11())._m02(-this.m12())._m03(this.m03())._m10(m00)._m11(m01)._m12(m02)._m13(this.m13())._m20(this.m20())._m21(this.m21())._m22(this.m22())._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapnYXnZ() {
        return this.mapnYXnZ(this);
    }

    public Matrix4f mapnYXnZ(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        return dest._m00(-this.m10())._m01(-this.m11())._m02(-this.m12())._m03(this.m03())._m10(m00)._m11(m01)._m12(m02)._m13(this.m13())._m20(-this.m20())._m21(-this.m21())._m22(-this.m22())._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapnYZX() {
        return this.mapnYZX(this);
    }

    public Matrix4f mapnYZX(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        return dest._m00(-this.m10())._m01(-this.m11())._m02(-this.m12())._m03(this.m03())._m10(this.m20())._m11(this.m21())._m12(this.m22())._m13(this.m13())._m20(m00)._m21(m01)._m22(m02)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapnYZnX() {
        return this.mapnYZnX(this);
    }

    public Matrix4f mapnYZnX(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        return dest._m00(-this.m10())._m01(-this.m11())._m02(-this.m12())._m03(this.m03())._m10(this.m20())._m11(this.m21())._m12(this.m22())._m13(this.m13())._m20(-m00)._m21(-m01)._m22(-m02)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapnYnXZ() {
        return this.mapnYnXZ(this);
    }

    public Matrix4f mapnYnXZ(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        return dest._m00(-this.m10())._m01(-this.m11())._m02(-this.m12())._m03(this.m03())._m10(-m00)._m11(-m01)._m12(-m02)._m13(this.m13())._m20(this.m20())._m21(this.m21())._m22(this.m22())._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapnYnXnZ() {
        return this.mapnYnXnZ(this);
    }

    public Matrix4f mapnYnXnZ(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        return dest._m00(-this.m10())._m01(-this.m11())._m02(-this.m12())._m03(this.m03())._m10(-m00)._m11(-m01)._m12(-m02)._m13(this.m13())._m20(-this.m20())._m21(-this.m21())._m22(-this.m22())._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapnYnZX() {
        return this.mapnYnZX(this);
    }

    public Matrix4f mapnYnZX(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        return dest._m00(-this.m10())._m01(-this.m11())._m02(-this.m12())._m03(this.m03())._m10(-this.m20())._m11(-this.m21())._m12(-this.m22())._m13(this.m13())._m20(m00)._m21(m01)._m22(m02)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapnYnZnX() {
        return this.mapnYnZnX(this);
    }

    public Matrix4f mapnYnZnX(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        return dest._m00(-this.m10())._m01(-this.m11())._m02(-this.m12())._m03(this.m03())._m10(-this.m20())._m11(-this.m21())._m12(-this.m22())._m13(this.m13())._m20(-m00)._m21(-m01)._m22(-m02)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapnZXY() {
        return this.mapnZXY(this);
    }

    public Matrix4f mapnZXY(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        float m10 = this.m10();
        float m11 = this.m11();
        float m12 = this.m12();
        return dest._m00(-this.m20())._m01(-this.m21())._m02(-this.m22())._m03(this.m03())._m10(m00)._m11(m01)._m12(m02)._m13(this.m13())._m20(m10)._m21(m11)._m22(m12)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapnZXnY() {
        return this.mapnZXnY(this);
    }

    public Matrix4f mapnZXnY(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        float m10 = this.m10();
        float m11 = this.m11();
        float m12 = this.m12();
        return dest._m00(-this.m20())._m01(-this.m21())._m02(-this.m22())._m03(this.m03())._m10(m00)._m11(m01)._m12(m02)._m13(this.m13())._m20(-m10)._m21(-m11)._m22(-m12)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapnZYX() {
        return this.mapnZYX(this);
    }

    public Matrix4f mapnZYX(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        return dest._m00(-this.m20())._m01(-this.m21())._m02(-this.m22())._m03(this.m03())._m10(this.m10())._m11(this.m11())._m12(this.m12())._m13(this.m13())._m20(m00)._m21(m01)._m22(m02)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapnZYnX() {
        return this.mapnZYnX(this);
    }

    public Matrix4f mapnZYnX(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        return dest._m00(-this.m20())._m01(-this.m21())._m02(-this.m22())._m03(this.m03())._m10(this.m10())._m11(this.m11())._m12(this.m12())._m13(this.m13())._m20(-m00)._m21(-m01)._m22(-m02)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapnZnXY() {
        return this.mapnZnXY(this);
    }

    public Matrix4f mapnZnXY(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        float m10 = this.m10();
        float m11 = this.m11();
        float m12 = this.m12();
        return dest._m00(-this.m20())._m01(-this.m21())._m02(-this.m22())._m03(this.m03())._m10(-m00)._m11(-m01)._m12(-m02)._m13(this.m13())._m20(m10)._m21(m11)._m22(m12)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapnZnXnY() {
        return this.mapnZnXnY(this);
    }

    public Matrix4f mapnZnXnY(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        float m10 = this.m10();
        float m11 = this.m11();
        float m12 = this.m12();
        return dest._m00(-this.m20())._m01(-this.m21())._m02(-this.m22())._m03(this.m03())._m10(-m00)._m11(-m01)._m12(-m02)._m13(this.m13())._m20(-m10)._m21(-m11)._m22(-m12)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapnZnYX() {
        return this.mapnZnYX(this);
    }

    public Matrix4f mapnZnYX(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        return dest._m00(-this.m20())._m01(-this.m21())._m02(-this.m22())._m03(this.m03())._m10(-this.m10())._m11(-this.m11())._m12(-this.m12())._m13(this.m13())._m20(m00)._m21(m01)._m22(m02)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f mapnZnYnX() {
        return this.mapnZnYnX(this);
    }

    public Matrix4f mapnZnYnX(Matrix4f dest) {
        float m00 = this.m00();
        float m01 = this.m01();
        float m02 = this.m02();
        return dest._m00(-this.m20())._m01(-this.m21())._m02(-this.m22())._m03(this.m03())._m10(-this.m10())._m11(-this.m11())._m12(-this.m12())._m13(this.m13())._m20(-m00)._m21(-m01)._m22(-m02)._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f negateX() {
        return this._m00(-this.m00())._m01(-this.m01())._m02(-this.m02())._properties(this.properties & 0x12);
    }

    public Matrix4f negateX(Matrix4f dest) {
        return dest._m00(-this.m00())._m01(-this.m01())._m02(-this.m02())._m03(this.m03())._m10(this.m10())._m11(this.m11())._m12(this.m12())._m13(this.m13())._m20(this.m20())._m21(this.m21())._m22(this.m22())._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f negateY() {
        return this._m10(-this.m10())._m11(-this.m11())._m12(-this.m12())._properties(this.properties & 0x12);
    }

    public Matrix4f negateY(Matrix4f dest) {
        return dest._m00(this.m00())._m01(this.m01())._m02(this.m02())._m03(this.m03())._m10(-this.m10())._m11(-this.m11())._m12(-this.m12())._m13(this.m13())._m20(this.m20())._m21(this.m21())._m22(this.m22())._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public Matrix4f negateZ() {
        return this._m20(-this.m20())._m21(-this.m21())._m22(-this.m22())._properties(this.properties & 0x12);
    }

    public Matrix4f negateZ(Matrix4f dest) {
        return dest._m00(this.m00())._m01(this.m01())._m02(this.m02())._m03(this.m03())._m10(this.m10())._m11(this.m11())._m12(this.m12())._m13(this.m13())._m20(-this.m20())._m21(-this.m21())._m22(-this.m22())._m23(this.m23())._m30(this.m30())._m31(this.m31())._m32(this.m32())._m33(this.m33())._properties(this.properties & 0x12);
    }

    public boolean isFinite() {
        return Math.isFinite(this.m00()) && Math.isFinite(this.m01()) && Math.isFinite(this.m02()) && Math.isFinite(this.m03()) && Math.isFinite(this.m10()) && Math.isFinite(this.m11()) && Math.isFinite(this.m12()) && Math.isFinite(this.m13()) && Math.isFinite(this.m20()) && Math.isFinite(this.m21()) && Math.isFinite(this.m22()) && Math.isFinite(this.m23()) && Math.isFinite(this.m30()) && Math.isFinite(this.m31()) && Math.isFinite(this.m32()) && Math.isFinite(this.m33());
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

