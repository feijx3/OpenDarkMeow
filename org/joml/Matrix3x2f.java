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
import org.joml.Matrix2f;
import org.joml.Matrix2fc;
import org.joml.Matrix3x2fc;
import org.joml.MemUtil;
import org.joml.Options;
import org.joml.Runtime;
import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.joml.Vector3f;

public class Matrix3x2f
implements Matrix3x2fc,
Externalizable,
Cloneable {
    private static final long serialVersionUID = 1L;
    public float m00;
    public float m01;
    public float m10;
    public float m11;
    public float m20;
    public float m21;

    public Matrix3x2f() {
        this.m00 = 1.0f;
        this.m11 = 1.0f;
    }

    public Matrix3x2f(Matrix3x2fc mat) {
        if (mat instanceof Matrix3x2f) {
            MemUtil.INSTANCE.copy((Matrix3x2f)mat, this);
        } else {
            this.setMatrix3x2fc(mat);
        }
    }

    public Matrix3x2f(Matrix2fc mat) {
        if (mat instanceof Matrix2f) {
            MemUtil.INSTANCE.copy((Matrix2f)mat, this);
        } else {
            this.setMatrix2fc(mat);
        }
    }

    public Matrix3x2f(float m00, float m01, float m10, float m11, float m20, float m21) {
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
        this.m20 = m20;
        this.m21 = m21;
    }

    public Matrix3x2f(FloatBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
    }

    public float m00() {
        return this.m00;
    }

    public float m01() {
        return this.m01;
    }

    public float m10() {
        return this.m10;
    }

    public float m11() {
        return this.m11;
    }

    public float m20() {
        return this.m20;
    }

    public float m21() {
        return this.m21;
    }

    Matrix3x2f _m00(float m00) {
        this.m00 = m00;
        return this;
    }

    Matrix3x2f _m01(float m01) {
        this.m01 = m01;
        return this;
    }

    Matrix3x2f _m10(float m10) {
        this.m10 = m10;
        return this;
    }

    Matrix3x2f _m11(float m11) {
        this.m11 = m11;
        return this;
    }

    Matrix3x2f _m20(float m20) {
        this.m20 = m20;
        return this;
    }

    Matrix3x2f _m21(float m21) {
        this.m21 = m21;
        return this;
    }

    public Matrix3x2f set(Matrix3x2fc m2) {
        if (m2 instanceof Matrix3x2f) {
            MemUtil.INSTANCE.copy((Matrix3x2f)m2, this);
        } else {
            this.setMatrix3x2fc(m2);
        }
        return this;
    }

    private void setMatrix3x2fc(Matrix3x2fc mat) {
        this.m00 = mat.m00();
        this.m01 = mat.m01();
        this.m10 = mat.m10();
        this.m11 = mat.m11();
        this.m20 = mat.m20();
        this.m21 = mat.m21();
    }

    public Matrix3x2f set(Matrix2fc m2) {
        if (m2 instanceof Matrix2f) {
            MemUtil.INSTANCE.copy((Matrix2f)m2, this);
        } else {
            this.setMatrix2fc(m2);
        }
        return this;
    }

    private void setMatrix2fc(Matrix2fc mat) {
        this.m00 = mat.m00();
        this.m01 = mat.m01();
        this.m10 = mat.m10();
        this.m11 = mat.m11();
    }

    public Matrix3x2f mul(Matrix3x2fc right) {
        return this.mul(right, this);
    }

    public Matrix3x2f mul(Matrix3x2fc right, Matrix3x2f dest) {
        float nm00 = this.m00 * right.m00() + this.m10 * right.m01();
        float nm01 = this.m01 * right.m00() + this.m11 * right.m01();
        float nm10 = this.m00 * right.m10() + this.m10 * right.m11();
        float nm11 = this.m01 * right.m10() + this.m11 * right.m11();
        float nm20 = this.m00 * right.m20() + this.m10 * right.m21() + this.m20;
        float nm21 = this.m01 * right.m20() + this.m11 * right.m21() + this.m21;
        dest.m00 = nm00;
        dest.m01 = nm01;
        dest.m10 = nm10;
        dest.m11 = nm11;
        dest.m20 = nm20;
        dest.m21 = nm21;
        return dest;
    }

    public Matrix3x2f mulLocal(Matrix3x2fc left) {
        return this.mulLocal(left, this);
    }

    public Matrix3x2f mulLocal(Matrix3x2fc left, Matrix3x2f dest) {
        float nm00 = left.m00() * this.m00 + left.m10() * this.m01;
        float nm01 = left.m01() * this.m00 + left.m11() * this.m01;
        float nm10 = left.m00() * this.m10 + left.m10() * this.m11;
        float nm11 = left.m01() * this.m10 + left.m11() * this.m11;
        float nm20 = left.m00() * this.m20 + left.m10() * this.m21 + left.m20();
        float nm21 = left.m01() * this.m20 + left.m11() * this.m21 + left.m21();
        dest.m00 = nm00;
        dest.m01 = nm01;
        dest.m10 = nm10;
        dest.m11 = nm11;
        dest.m20 = nm20;
        dest.m21 = nm21;
        return dest;
    }

    public Matrix3x2f set(float m00, float m01, float m10, float m11, float m20, float m21) {
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
        this.m20 = m20;
        this.m21 = m21;
        return this;
    }

    public Matrix3x2f set(float[] m2) {
        MemUtil.INSTANCE.copy(m2, 0, this);
        return this;
    }

    public float determinant() {
        return this.m00 * this.m11 - this.m01 * this.m10;
    }

    public Matrix3x2f invert() {
        return this.invert(this);
    }

    public Matrix3x2f invert(Matrix3x2f dest) {
        float s2 = 1.0f / (this.m00 * this.m11 - this.m01 * this.m10);
        float nm00 = this.m11 * s2;
        float nm01 = -this.m01 * s2;
        float nm10 = -this.m10 * s2;
        float nm11 = this.m00 * s2;
        float nm20 = (this.m10 * this.m21 - this.m20 * this.m11) * s2;
        float nm21 = (this.m20 * this.m01 - this.m00 * this.m21) * s2;
        dest.m00 = nm00;
        dest.m01 = nm01;
        dest.m10 = nm10;
        dest.m11 = nm11;
        dest.m20 = nm20;
        dest.m21 = nm21;
        return dest;
    }

    public Matrix3x2f translation(float x2, float y2) {
        this.m00 = 1.0f;
        this.m01 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 1.0f;
        this.m20 = x2;
        this.m21 = y2;
        return this;
    }

    public Matrix3x2f translation(Vector2fc offset) {
        return this.translation(offset.x(), offset.y());
    }

    public Matrix3x2f setTranslation(float x2, float y2) {
        this.m20 = x2;
        this.m21 = y2;
        return this;
    }

    public Matrix3x2f setTranslation(Vector2f offset) {
        return this.setTranslation(offset.x, offset.y);
    }

    public Matrix3x2f translate(float x2, float y2, Matrix3x2f dest) {
        float rm20 = x2;
        float rm21 = y2;
        dest.m20 = this.m00 * rm20 + this.m10 * rm21 + this.m20;
        dest.m21 = this.m01 * rm20 + this.m11 * rm21 + this.m21;
        dest.m00 = this.m00;
        dest.m01 = this.m01;
        dest.m10 = this.m10;
        dest.m11 = this.m11;
        return dest;
    }

    public Matrix3x2f translate(float x2, float y2) {
        return this.translate(x2, y2, this);
    }

    public Matrix3x2f translate(Vector2fc offset, Matrix3x2f dest) {
        return this.translate(offset.x(), offset.y(), dest);
    }

    public Matrix3x2f translate(Vector2fc offset) {
        return this.translate(offset.x(), offset.y(), this);
    }

    public Matrix3x2f translateLocal(Vector2fc offset) {
        return this.translateLocal(offset.x(), offset.y());
    }

    public Matrix3x2f translateLocal(Vector2fc offset, Matrix3x2f dest) {
        return this.translateLocal(offset.x(), offset.y(), dest);
    }

    public Matrix3x2f translateLocal(float x2, float y2, Matrix3x2f dest) {
        dest.m00 = this.m00;
        dest.m01 = this.m01;
        dest.m10 = this.m10;
        dest.m11 = this.m11;
        dest.m20 = this.m20 + x2;
        dest.m21 = this.m21 + y2;
        return dest;
    }

    public Matrix3x2f translateLocal(float x2, float y2) {
        return this.translateLocal(x2, y2, this);
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
        return Runtime.format(this.m00, formatter) + " " + Runtime.format(this.m10, formatter) + " " + Runtime.format(this.m20, formatter) + "\n" + Runtime.format(this.m01, formatter) + " " + Runtime.format(this.m11, formatter) + " " + Runtime.format(this.m21, formatter) + "\n";
    }

    public Matrix3x2f get(Matrix3x2f dest) {
        return dest.set(this);
    }

    public FloatBuffer get(FloatBuffer buffer) {
        return this.get(buffer.position(), buffer);
    }

    public FloatBuffer get(int index, FloatBuffer buffer) {
        MemUtil.INSTANCE.put(this, index, buffer);
        return buffer;
    }

    public ByteBuffer get(ByteBuffer buffer) {
        return this.get(buffer.position(), buffer);
    }

    public ByteBuffer get(int index, ByteBuffer buffer) {
        MemUtil.INSTANCE.put(this, index, buffer);
        return buffer;
    }

    public FloatBuffer get3x3(FloatBuffer buffer) {
        MemUtil.INSTANCE.put3x3(this, 0, buffer);
        return buffer;
    }

    public FloatBuffer get3x3(int index, FloatBuffer buffer) {
        MemUtil.INSTANCE.put3x3(this, index, buffer);
        return buffer;
    }

    public ByteBuffer get3x3(ByteBuffer buffer) {
        MemUtil.INSTANCE.put3x3(this, 0, buffer);
        return buffer;
    }

    public ByteBuffer get3x3(int index, ByteBuffer buffer) {
        MemUtil.INSTANCE.put3x3(this, index, buffer);
        return buffer;
    }

    public FloatBuffer get4x4(FloatBuffer buffer) {
        MemUtil.INSTANCE.put4x4(this, 0, buffer);
        return buffer;
    }

    public FloatBuffer get4x4(int index, FloatBuffer buffer) {
        MemUtil.INSTANCE.put4x4(this, index, buffer);
        return buffer;
    }

    public ByteBuffer get4x4(ByteBuffer buffer) {
        MemUtil.INSTANCE.put4x4(this, 0, buffer);
        return buffer;
    }

    public ByteBuffer get4x4(int index, ByteBuffer buffer) {
        MemUtil.INSTANCE.put4x4(this, index, buffer);
        return buffer;
    }

    public Matrix3x2fc getToAddress(long address) {
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
        return this.get(arr2, 0);
    }

    public float[] get3x3(float[] arr2, int offset) {
        MemUtil.INSTANCE.copy3x3(this, arr2, offset);
        return arr2;
    }

    public float[] get3x3(float[] arr2) {
        return this.get3x3(arr2, 0);
    }

    public float[] get4x4(float[] arr2, int offset) {
        MemUtil.INSTANCE.copy4x4(this, arr2, offset);
        return arr2;
    }

    public float[] get4x4(float[] arr2) {
        return this.get4x4(arr2, 0);
    }

    public Matrix3x2f set(FloatBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
        return this;
    }

    public Matrix3x2f set(ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
        return this;
    }

    public Matrix3x2f set(int index, FloatBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
        return this;
    }

    public Matrix3x2f set(int index, ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
        return this;
    }

    public Matrix3x2f setFromAddress(long address) {
        if (Options.NO_UNSAFE) {
            throw new UnsupportedOperationException("Not supported when using joml.nounsafe");
        }
        MemUtil.MemUtilUnsafe.get(this, address);
        return this;
    }

    public Matrix3x2f zero() {
        MemUtil.INSTANCE.zero(this);
        return this;
    }

    public Matrix3x2f identity() {
        MemUtil.INSTANCE.identity(this);
        return this;
    }

    public Matrix3x2f scale(float x2, float y2, Matrix3x2f dest) {
        dest.m00 = this.m00 * x2;
        dest.m01 = this.m01 * x2;
        dest.m10 = this.m10 * y2;
        dest.m11 = this.m11 * y2;
        dest.m20 = this.m20;
        dest.m21 = this.m21;
        return dest;
    }

    public Matrix3x2f scale(float x2, float y2) {
        return this.scale(x2, y2, this);
    }

    public Matrix3x2f scale(Vector2fc xy) {
        return this.scale(xy.x(), xy.y(), this);
    }

    public Matrix3x2f scale(Vector2fc xy, Matrix3x2f dest) {
        return this.scale(xy.x(), xy.y(), dest);
    }

    public Matrix3x2f scale(float xy, Matrix3x2f dest) {
        return this.scale(xy, xy, dest);
    }

    public Matrix3x2f scale(float xy) {
        return this.scale(xy, xy);
    }

    public Matrix3x2f scaleLocal(float x2, float y2, Matrix3x2f dest) {
        dest.m00 = x2 * this.m00;
        dest.m01 = y2 * this.m01;
        dest.m10 = x2 * this.m10;
        dest.m11 = y2 * this.m11;
        dest.m20 = x2 * this.m20;
        dest.m21 = y2 * this.m21;
        return dest;
    }

    public Matrix3x2f scaleLocal(float x2, float y2) {
        return this.scaleLocal(x2, y2, this);
    }

    public Matrix3x2f scaleLocal(float xy, Matrix3x2f dest) {
        return this.scaleLocal(xy, xy, dest);
    }

    public Matrix3x2f scaleLocal(float xy) {
        return this.scaleLocal(xy, xy, this);
    }

    public Matrix3x2f scaleAround(float sx, float sy, float ox, float oy, Matrix3x2f dest) {
        float nm20 = this.m00 * ox + this.m10 * oy + this.m20;
        float nm21 = this.m01 * ox + this.m11 * oy + this.m21;
        dest.m00 = this.m00 * sx;
        dest.m01 = this.m01 * sx;
        dest.m10 = this.m10 * sy;
        dest.m11 = this.m11 * sy;
        dest.m20 = dest.m00 * -ox + dest.m10 * -oy + nm20;
        dest.m21 = dest.m01 * -ox + dest.m11 * -oy + nm21;
        return dest;
    }

    public Matrix3x2f scaleAround(float sx, float sy, float ox, float oy) {
        return this.scaleAround(sx, sy, ox, oy, this);
    }

    public Matrix3x2f scaleAround(float factor, float ox, float oy, Matrix3x2f dest) {
        return this.scaleAround(factor, factor, ox, oy, this);
    }

    public Matrix3x2f scaleAround(float factor, float ox, float oy) {
        return this.scaleAround(factor, factor, ox, oy, this);
    }

    public Matrix3x2f scaleAroundLocal(float sx, float sy, float ox, float oy, Matrix3x2f dest) {
        dest.m00 = sx * this.m00;
        dest.m01 = sy * this.m01;
        dest.m10 = sx * this.m10;
        dest.m11 = sy * this.m11;
        dest.m20 = sx * this.m20 - sx * ox + ox;
        dest.m21 = sy * this.m21 - sy * oy + oy;
        return dest;
    }

    public Matrix3x2f scaleAroundLocal(float factor, float ox, float oy, Matrix3x2f dest) {
        return this.scaleAroundLocal(factor, factor, ox, oy, dest);
    }

    public Matrix3x2f scaleAroundLocal(float sx, float sy, float sz, float ox, float oy, float oz) {
        return this.scaleAroundLocal(sx, sy, ox, oy, this);
    }

    public Matrix3x2f scaleAroundLocal(float factor, float ox, float oy) {
        return this.scaleAroundLocal(factor, factor, ox, oy, this);
    }

    public Matrix3x2f scaling(float factor) {
        return this.scaling(factor, factor);
    }

    public Matrix3x2f scaling(float x2, float y2) {
        this.m00 = x2;
        this.m01 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = y2;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        return this;
    }

    public Matrix3x2f rotation(float angle) {
        float cos = Math.cos(angle);
        float sin = Math.sin(angle);
        this.m00 = cos;
        this.m10 = -sin;
        this.m20 = 0.0f;
        this.m01 = sin;
        this.m11 = cos;
        this.m21 = 0.0f;
        return this;
    }

    public Vector3f transform(Vector3f v2) {
        return v2.mul(this);
    }

    public Vector3f transform(Vector3f v2, Vector3f dest) {
        return v2.mul(this, dest);
    }

    public Vector3f transform(float x2, float y2, float z2, Vector3f dest) {
        return dest.set(this.m00 * x2 + this.m10 * y2 + this.m20 * z2, this.m01 * x2 + this.m11 * y2 + this.m21 * z2, z2);
    }

    public Vector2f transformPosition(Vector2f v2) {
        v2.set(this.m00 * v2.x + this.m10 * v2.y + this.m20, this.m01 * v2.x + this.m11 * v2.y + this.m21);
        return v2;
    }

    public Vector2f transformPosition(Vector2fc v2, Vector2f dest) {
        dest.set(this.m00 * v2.x() + this.m10 * v2.y() + this.m20, this.m01 * v2.x() + this.m11 * v2.y() + this.m21);
        return dest;
    }

    public Vector2f transformPosition(float x2, float y2, Vector2f dest) {
        return dest.set(this.m00 * x2 + this.m10 * y2 + this.m20, this.m01 * x2 + this.m11 * y2 + this.m21);
    }

    public Vector2f transformDirection(Vector2f v2) {
        v2.set(this.m00 * v2.x + this.m10 * v2.y, this.m01 * v2.x + this.m11 * v2.y);
        return v2;
    }

    public Vector2f transformDirection(Vector2fc v2, Vector2f dest) {
        dest.set(this.m00 * v2.x() + this.m10 * v2.y(), this.m01 * v2.x() + this.m11 * v2.y());
        return dest;
    }

    public Vector2f transformDirection(float x2, float y2, Vector2f dest) {
        return dest.set(this.m00 * x2 + this.m10 * y2, this.m01 * x2 + this.m11 * y2);
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeFloat(this.m00);
        out.writeFloat(this.m01);
        out.writeFloat(this.m10);
        out.writeFloat(this.m11);
        out.writeFloat(this.m20);
        out.writeFloat(this.m21);
    }

    public void readExternal(ObjectInput in) throws IOException {
        this.m00 = in.readFloat();
        this.m01 = in.readFloat();
        this.m10 = in.readFloat();
        this.m11 = in.readFloat();
        this.m20 = in.readFloat();
        this.m21 = in.readFloat();
    }

    public Matrix3x2f rotate(float ang) {
        return this.rotate(ang, this);
    }

    public Matrix3x2f rotate(float ang, Matrix3x2f dest) {
        float cos = Math.cos(ang);
        float sin = Math.sin(ang);
        float rm00 = cos;
        float rm01 = sin;
        float rm10 = -sin;
        float rm11 = cos;
        float nm00 = this.m00 * rm00 + this.m10 * rm01;
        float nm01 = this.m01 * rm00 + this.m11 * rm01;
        dest.m10 = this.m00 * rm10 + this.m10 * rm11;
        dest.m11 = this.m01 * rm10 + this.m11 * rm11;
        dest.m00 = nm00;
        dest.m01 = nm01;
        dest.m20 = this.m20;
        dest.m21 = this.m21;
        return dest;
    }

    public Matrix3x2f rotateLocal(float ang, Matrix3x2f dest) {
        float sin = Math.sin(ang);
        float cos = Math.cosFromSin(sin, ang);
        float nm00 = cos * this.m00 - sin * this.m01;
        float nm01 = sin * this.m00 + cos * this.m01;
        float nm10 = cos * this.m10 - sin * this.m11;
        float nm11 = sin * this.m10 + cos * this.m11;
        float nm20 = cos * this.m20 - sin * this.m21;
        float nm21 = sin * this.m20 + cos * this.m21;
        dest.m00 = nm00;
        dest.m01 = nm01;
        dest.m10 = nm10;
        dest.m11 = nm11;
        dest.m20 = nm20;
        dest.m21 = nm21;
        return dest;
    }

    public Matrix3x2f rotateLocal(float ang) {
        return this.rotateLocal(ang, this);
    }

    public Matrix3x2f rotateAbout(float ang, float x2, float y2) {
        return this.rotateAbout(ang, x2, y2, this);
    }

    public Matrix3x2f rotateAbout(float ang, float x2, float y2, Matrix3x2f dest) {
        float tm20 = this.m00 * x2 + this.m10 * y2 + this.m20;
        float tm21 = this.m01 * x2 + this.m11 * y2 + this.m21;
        float cos = Math.cos(ang);
        float sin = Math.sin(ang);
        float nm00 = this.m00 * cos + this.m10 * sin;
        float nm01 = this.m01 * cos + this.m11 * sin;
        dest.m10 = this.m00 * -sin + this.m10 * cos;
        dest.m11 = this.m01 * -sin + this.m11 * cos;
        dest.m00 = nm00;
        dest.m01 = nm01;
        dest.m20 = dest.m00 * -x2 + dest.m10 * -y2 + tm20;
        dest.m21 = dest.m01 * -x2 + dest.m11 * -y2 + tm21;
        return dest;
    }

    public Matrix3x2f rotateTo(Vector2fc fromDir, Vector2fc toDir, Matrix3x2f dest) {
        float dot = fromDir.x() * toDir.x() + fromDir.y() * toDir.y();
        float det = fromDir.x() * toDir.y() - fromDir.y() * toDir.x();
        float rm00 = dot;
        float rm01 = det;
        float rm10 = -det;
        float rm11 = dot;
        float nm00 = this.m00 * rm00 + this.m10 * rm01;
        float nm01 = this.m01 * rm00 + this.m11 * rm01;
        dest.m10 = this.m00 * rm10 + this.m10 * rm11;
        dest.m11 = this.m01 * rm10 + this.m11 * rm11;
        dest.m00 = nm00;
        dest.m01 = nm01;
        dest.m20 = this.m20;
        dest.m21 = this.m21;
        return dest;
    }

    public Matrix3x2f rotateTo(Vector2fc fromDir, Vector2fc toDir) {
        return this.rotateTo(fromDir, toDir, this);
    }

    public Matrix3x2f view(float left, float right, float bottom, float top, Matrix3x2f dest) {
        float rm00 = 2.0f / (right - left);
        float rm11 = 2.0f / (top - bottom);
        float rm20 = (left + right) / (left - right);
        float rm21 = (bottom + top) / (bottom - top);
        dest.m20 = this.m00 * rm20 + this.m10 * rm21 + this.m20;
        dest.m21 = this.m01 * rm20 + this.m11 * rm21 + this.m21;
        dest.m00 = this.m00 * rm00;
        dest.m01 = this.m01 * rm00;
        dest.m10 = this.m10 * rm11;
        dest.m11 = this.m11 * rm11;
        return dest;
    }

    public Matrix3x2f view(float left, float right, float bottom, float top) {
        return this.view(left, right, bottom, top, this);
    }

    public Matrix3x2f setView(float left, float right, float bottom, float top) {
        this.m00 = 2.0f / (right - left);
        this.m01 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 2.0f / (top - bottom);
        this.m20 = (left + right) / (left - right);
        this.m21 = (bottom + top) / (bottom - top);
        return this;
    }

    public Vector2f origin(Vector2f origin) {
        float s2 = 1.0f / (this.m00 * this.m11 - this.m01 * this.m10);
        origin.x = (this.m10 * this.m21 - this.m20 * this.m11) * s2;
        origin.y = (this.m20 * this.m01 - this.m00 * this.m21) * s2;
        return origin;
    }

    public float[] viewArea(float[] area) {
        float s2 = 1.0f / (this.m00 * this.m11 - this.m01 * this.m10);
        float rm00 = this.m11 * s2;
        float rm01 = -this.m01 * s2;
        float rm10 = -this.m10 * s2;
        float rm11 = this.m00 * s2;
        float rm20 = (this.m10 * this.m21 - this.m20 * this.m11) * s2;
        float rm21 = (this.m20 * this.m01 - this.m00 * this.m21) * s2;
        float nxnyX = -rm00 - rm10;
        float nxnyY = -rm01 - rm11;
        float pxnyX = rm00 - rm10;
        float pxnyY = rm01 - rm11;
        float nxpyX = -rm00 + rm10;
        float nxpyY = -rm01 + rm11;
        float pxpyX = rm00 + rm10;
        float pxpyY = rm01 + rm11;
        float minX = nxnyX;
        minX = minX < nxpyX ? minX : nxpyX;
        minX = minX < pxnyX ? minX : pxnyX;
        minX = minX < pxpyX ? minX : pxpyX;
        float minY = nxnyY;
        minY = minY < nxpyY ? minY : nxpyY;
        minY = minY < pxnyY ? minY : pxnyY;
        minY = minY < pxpyY ? minY : pxpyY;
        float maxX = nxnyX;
        maxX = maxX > nxpyX ? maxX : nxpyX;
        maxX = maxX > pxnyX ? maxX : pxnyX;
        maxX = maxX > pxpyX ? maxX : pxpyX;
        float maxY = nxnyY;
        maxY = maxY > nxpyY ? maxY : nxpyY;
        maxY = maxY > pxnyY ? maxY : pxnyY;
        maxY = maxY > pxpyY ? maxY : pxpyY;
        area[0] = minX + rm20;
        area[1] = minY + rm21;
        area[2] = maxX + rm20;
        area[3] = maxY + rm21;
        return area;
    }

    public Vector2f positiveX(Vector2f dir) {
        float s2 = this.m00 * this.m11 - this.m01 * this.m10;
        s2 = 1.0f / s2;
        dir.x = this.m11 * s2;
        dir.y = -this.m01 * s2;
        return dir.normalize(dir);
    }

    public Vector2f normalizedPositiveX(Vector2f dir) {
        dir.x = this.m11;
        dir.y = -this.m01;
        return dir;
    }

    public Vector2f positiveY(Vector2f dir) {
        float s2 = this.m00 * this.m11 - this.m01 * this.m10;
        s2 = 1.0f / s2;
        dir.x = -this.m10 * s2;
        dir.y = this.m00 * s2;
        return dir.normalize(dir);
    }

    public Vector2f normalizedPositiveY(Vector2f dir) {
        dir.x = -this.m10;
        dir.y = this.m00;
        return dir;
    }

    public Vector2f unproject(float winX, float winY, int[] viewport, Vector2f dest) {
        float s2 = 1.0f / (this.m00 * this.m11 - this.m01 * this.m10);
        float im00 = this.m11 * s2;
        float im01 = -this.m01 * s2;
        float im10 = -this.m10 * s2;
        float im11 = this.m00 * s2;
        float im20 = (this.m10 * this.m21 - this.m20 * this.m11) * s2;
        float im21 = (this.m20 * this.m01 - this.m00 * this.m21) * s2;
        float ndcX = (winX - (float)viewport[0]) / (float)viewport[2] * 2.0f - 1.0f;
        float ndcY = (winY - (float)viewport[1]) / (float)viewport[3] * 2.0f - 1.0f;
        dest.x = im00 * ndcX + im10 * ndcY + im20;
        dest.y = im01 * ndcX + im11 * ndcY + im21;
        return dest;
    }

    public Vector2f unprojectInv(float winX, float winY, int[] viewport, Vector2f dest) {
        float ndcX = (winX - (float)viewport[0]) / (float)viewport[2] * 2.0f - 1.0f;
        float ndcY = (winY - (float)viewport[1]) / (float)viewport[3] * 2.0f - 1.0f;
        dest.x = this.m00 * ndcX + this.m10 * ndcY + this.m20;
        dest.y = this.m01 * ndcX + this.m11 * ndcY + this.m21;
        return dest;
    }

    public Matrix3x2f shearX(float yFactor) {
        return this.shearX(yFactor, this);
    }

    public Matrix3x2f shearX(float yFactor, Matrix3x2f dest) {
        float nm10 = this.m00 * yFactor + this.m10;
        float nm11 = this.m01 * yFactor + this.m11;
        dest.m00 = this.m00;
        dest.m01 = this.m01;
        dest.m10 = nm10;
        dest.m11 = nm11;
        dest.m20 = this.m20;
        dest.m21 = this.m21;
        return dest;
    }

    public Matrix3x2f shearY(float xFactor) {
        return this.shearY(xFactor, this);
    }

    public Matrix3x2f shearY(float xFactor, Matrix3x2f dest) {
        float nm00 = this.m00 + this.m10 * xFactor;
        float nm01 = this.m01 + this.m11 * xFactor;
        dest.m00 = nm00;
        dest.m01 = nm01;
        dest.m10 = this.m10;
        dest.m11 = this.m11;
        dest.m20 = this.m20;
        dest.m21 = this.m21;
        return dest;
    }

    public Matrix3x2f span(Vector2f corner, Vector2f xDir, Vector2f yDir) {
        float s2 = 1.0f / (this.m00 * this.m11 - this.m01 * this.m10);
        float nm00 = this.m11 * s2;
        float nm01 = -this.m01 * s2;
        float nm10 = -this.m10 * s2;
        float nm11 = this.m00 * s2;
        corner.x = -nm00 - nm10 + (this.m10 * this.m21 - this.m20 * this.m11) * s2;
        corner.y = -nm01 - nm11 + (this.m20 * this.m01 - this.m00 * this.m21) * s2;
        xDir.x = 2.0f * nm00;
        xDir.y = 2.0f * nm01;
        yDir.x = 2.0f * nm10;
        yDir.y = 2.0f * nm11;
        return this;
    }

    public boolean testPoint(float x2, float y2) {
        float nxX = this.m00;
        float nxY = this.m10;
        float nxW = 1.0f + this.m20;
        float pxX = -this.m00;
        float pxY = -this.m10;
        float pxW = 1.0f - this.m20;
        float nyX = this.m01;
        float nyY = this.m11;
        float nyW = 1.0f + this.m21;
        float pyX = -this.m01;
        float pyY = -this.m11;
        float pyW = 1.0f - this.m21;
        return nxX * x2 + nxY * y2 + nxW >= 0.0f && pxX * x2 + pxY * y2 + pxW >= 0.0f && nyX * x2 + nyY * y2 + nyW >= 0.0f && pyX * x2 + pyY * y2 + pyW >= 0.0f;
    }

    public boolean testCircle(float x2, float y2, float r2) {
        float nxX = this.m00;
        float nxY = this.m10;
        float nxW = 1.0f + this.m20;
        float invl = Math.invsqrt(nxX * nxX + nxY * nxY);
        nxX *= invl;
        nxY *= invl;
        nxW *= invl;
        float pxX = -this.m00;
        float pxY = -this.m10;
        float pxW = 1.0f - this.m20;
        invl = Math.invsqrt(pxX * pxX + pxY * pxY);
        pxX *= invl;
        pxY *= invl;
        pxW *= invl;
        float nyX = this.m01;
        float nyY = this.m11;
        float nyW = 1.0f + this.m21;
        invl = Math.invsqrt(nyX * nyX + nyY * nyY);
        nyX *= invl;
        nyY *= invl;
        nyW *= invl;
        float pyX = -this.m01;
        float pyY = -this.m11;
        float pyW = 1.0f - this.m21;
        invl = Math.invsqrt(pyX * pyX + pyY * pyY);
        return nxX * x2 + nxY * y2 + nxW >= -r2 && pxX * x2 + pxY * y2 + pxW >= -r2 && nyX * x2 + nyY * y2 + nyW >= -r2 && (pyX *= invl) * x2 + (pyY *= invl) * y2 + (pyW *= invl) >= -r2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean testAar(float minX, float minY, float maxX, float maxY) {
        float nxX = this.m00;
        float nxY = this.m10;
        float nxW = 1.0f + this.m20;
        float pxX = -this.m00;
        float pxY = -this.m10;
        float pxW = 1.0f - this.m20;
        float nyX = this.m01;
        float nyY = this.m11;
        float nyW = 1.0f + this.m21;
        float pyX = -this.m01;
        float pyY = -this.m11;
        float pyW = 1.0f - this.m21;
        float f2 = nxX * (nxX < 0.0f ? minX : maxX);
        float f3 = nxY < 0.0f ? minY : maxY;
        if (!(f2 + nxY * f3 >= -nxW)) return false;
        float f4 = pxX * (pxX < 0.0f ? minX : maxX);
        float f5 = pxY < 0.0f ? minY : maxY;
        if (!(f4 + pxY * f5 >= -pxW)) return false;
        float f6 = nyX * (nyX < 0.0f ? minX : maxX);
        float f7 = nyY < 0.0f ? minY : maxY;
        if (!(f6 + nyY * f7 >= -nyW)) return false;
        float f8 = pyX * (pyX < 0.0f ? minX : maxX);
        float f9 = pyY < 0.0f ? minY : maxY;
        if (!(f8 + pyY * f9 >= -pyW)) return false;
        return true;
    }

    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = 31 * result + Float.floatToIntBits(this.m00);
        result = 31 * result + Float.floatToIntBits(this.m01);
        result = 31 * result + Float.floatToIntBits(this.m10);
        result = 31 * result + Float.floatToIntBits(this.m11);
        result = 31 * result + Float.floatToIntBits(this.m20);
        result = 31 * result + Float.floatToIntBits(this.m21);
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
        Matrix3x2f other = (Matrix3x2f)obj;
        if (Float.floatToIntBits(this.m00) != Float.floatToIntBits(other.m00)) {
            return false;
        }
        if (Float.floatToIntBits(this.m01) != Float.floatToIntBits(other.m01)) {
            return false;
        }
        if (Float.floatToIntBits(this.m10) != Float.floatToIntBits(other.m10)) {
            return false;
        }
        if (Float.floatToIntBits(this.m11) != Float.floatToIntBits(other.m11)) {
            return false;
        }
        if (Float.floatToIntBits(this.m20) != Float.floatToIntBits(other.m20)) {
            return false;
        }
        return Float.floatToIntBits(this.m21) == Float.floatToIntBits(other.m21);
    }

    public boolean equals(Matrix3x2fc m2, float delta) {
        if (this == m2) {
            return true;
        }
        if (m2 == null) {
            return false;
        }
        if (!(m2 instanceof Matrix3x2f)) {
            return false;
        }
        if (!Runtime.equals(this.m00, m2.m00(), delta)) {
            return false;
        }
        if (!Runtime.equals(this.m01, m2.m01(), delta)) {
            return false;
        }
        if (!Runtime.equals(this.m10, m2.m10(), delta)) {
            return false;
        }
        if (!Runtime.equals(this.m11, m2.m11(), delta)) {
            return false;
        }
        if (!Runtime.equals(this.m20, m2.m20(), delta)) {
            return false;
        }
        return Runtime.equals(this.m21, m2.m21(), delta);
    }

    public boolean isFinite() {
        return Math.isFinite(this.m00) && Math.isFinite(this.m01) && Math.isFinite(this.m10) && Math.isFinite(this.m11) && Math.isFinite(this.m20) && Math.isFinite(this.m21);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

