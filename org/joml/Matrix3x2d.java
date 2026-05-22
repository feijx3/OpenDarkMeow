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
import org.joml.Matrix2d;
import org.joml.Matrix2dc;
import org.joml.Matrix2fc;
import org.joml.Matrix3x2dc;
import org.joml.MemUtil;
import org.joml.Options;
import org.joml.Runtime;
import org.joml.Vector2d;
import org.joml.Vector2dc;
import org.joml.Vector2fc;
import org.joml.Vector3d;
import org.joml.Vector3dc;

public class Matrix3x2d
implements Matrix3x2dc,
Cloneable,
Externalizable {
    private static final long serialVersionUID = 1L;
    public double m00;
    public double m01;
    public double m10;
    public double m11;
    public double m20;
    public double m21;

    public Matrix3x2d() {
        this.m00 = 1.0;
        this.m11 = 1.0;
    }

    public Matrix3x2d(Matrix2dc mat) {
        if (mat instanceof Matrix2d) {
            MemUtil.INSTANCE.copy((Matrix2d)mat, this);
        } else {
            this.setMatrix2dc(mat);
        }
    }

    public Matrix3x2d(Matrix2fc mat) {
        this.m00 = mat.m00();
        this.m01 = mat.m01();
        this.m10 = mat.m10();
        this.m11 = mat.m11();
    }

    public Matrix3x2d(Matrix3x2dc mat) {
        if (mat instanceof Matrix3x2d) {
            MemUtil.INSTANCE.copy((Matrix3x2d)mat, this);
        } else {
            this.setMatrix3x2dc(mat);
        }
    }

    public Matrix3x2d(double m00, double m01, double m10, double m11, double m20, double m21) {
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
        this.m20 = m20;
        this.m21 = m21;
    }

    public Matrix3x2d(DoubleBuffer buffer) {
        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
    }

    public double m00() {
        return this.m00;
    }

    public double m01() {
        return this.m01;
    }

    public double m10() {
        return this.m10;
    }

    public double m11() {
        return this.m11;
    }

    public double m20() {
        return this.m20;
    }

    public double m21() {
        return this.m21;
    }

    Matrix3x2d _m00(double m00) {
        this.m00 = m00;
        return this;
    }

    Matrix3x2d _m01(double m01) {
        this.m01 = m01;
        return this;
    }

    Matrix3x2d _m10(double m10) {
        this.m10 = m10;
        return this;
    }

    Matrix3x2d _m11(double m11) {
        this.m11 = m11;
        return this;
    }

    Matrix3x2d _m20(double m20) {
        this.m20 = m20;
        return this;
    }

    Matrix3x2d _m21(double m21) {
        this.m21 = m21;
        return this;
    }

    public Matrix3x2d set(Matrix3x2dc m2) {
        if (m2 instanceof Matrix3x2d) {
            MemUtil.INSTANCE.copy((Matrix3x2d)m2, this);
        } else {
            this.setMatrix3x2dc(m2);
        }
        return this;
    }

    private void setMatrix3x2dc(Matrix3x2dc mat) {
        this.m00 = mat.m00();
        this.m01 = mat.m01();
        this.m10 = mat.m10();
        this.m11 = mat.m11();
        this.m20 = mat.m20();
        this.m21 = mat.m21();
    }

    public Matrix3x2d set(Matrix2dc m2) {
        if (m2 instanceof Matrix2d) {
            MemUtil.INSTANCE.copy((Matrix2d)m2, this);
        } else {
            this.setMatrix2dc(m2);
        }
        return this;
    }

    private void setMatrix2dc(Matrix2dc mat) {
        this.m00 = mat.m00();
        this.m01 = mat.m01();
        this.m10 = mat.m10();
        this.m11 = mat.m11();
    }

    public Matrix3x2d set(Matrix2fc m2) {
        this.m00 = m2.m00();
        this.m01 = m2.m01();
        this.m10 = m2.m10();
        this.m11 = m2.m11();
        return this;
    }

    public Matrix3x2d mul(Matrix3x2dc right) {
        return this.mul(right, this);
    }

    public Matrix3x2d mul(Matrix3x2dc right, Matrix3x2d dest) {
        double nm00 = this.m00 * right.m00() + this.m10 * right.m01();
        double nm01 = this.m01 * right.m00() + this.m11 * right.m01();
        double nm10 = this.m00 * right.m10() + this.m10 * right.m11();
        double nm11 = this.m01 * right.m10() + this.m11 * right.m11();
        double nm20 = this.m00 * right.m20() + this.m10 * right.m21() + this.m20;
        double nm21 = this.m01 * right.m20() + this.m11 * right.m21() + this.m21;
        dest.m00 = nm00;
        dest.m01 = nm01;
        dest.m10 = nm10;
        dest.m11 = nm11;
        dest.m20 = nm20;
        dest.m21 = nm21;
        return dest;
    }

    public Matrix3x2d mulLocal(Matrix3x2dc left) {
        return this.mulLocal(left, this);
    }

    public Matrix3x2d mulLocal(Matrix3x2dc left, Matrix3x2d dest) {
        double nm00 = left.m00() * this.m00 + left.m10() * this.m01;
        double nm01 = left.m01() * this.m00 + left.m11() * this.m01;
        double nm10 = left.m00() * this.m10 + left.m10() * this.m11;
        double nm11 = left.m01() * this.m10 + left.m11() * this.m11;
        double nm20 = left.m00() * this.m20 + left.m10() * this.m21 + left.m20();
        double nm21 = left.m01() * this.m20 + left.m11() * this.m21 + left.m21();
        dest.m00 = nm00;
        dest.m01 = nm01;
        dest.m10 = nm10;
        dest.m11 = nm11;
        dest.m20 = nm20;
        dest.m21 = nm21;
        return dest;
    }

    public Matrix3x2d set(double m00, double m01, double m10, double m11, double m20, double m21) {
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
        this.m20 = m20;
        this.m21 = m21;
        return this;
    }

    public Matrix3x2d set(double[] m2) {
        MemUtil.INSTANCE.copy(m2, 0, this);
        return this;
    }

    public double determinant() {
        return this.m00 * this.m11 - this.m01 * this.m10;
    }

    public Matrix3x2d invert() {
        return this.invert(this);
    }

    public Matrix3x2d invert(Matrix3x2d dest) {
        double s2 = 1.0 / (this.m00 * this.m11 - this.m01 * this.m10);
        double nm00 = this.m11 * s2;
        double nm01 = -this.m01 * s2;
        double nm10 = -this.m10 * s2;
        double nm11 = this.m00 * s2;
        double nm20 = (this.m10 * this.m21 - this.m20 * this.m11) * s2;
        double nm21 = (this.m20 * this.m01 - this.m00 * this.m21) * s2;
        dest.m00 = nm00;
        dest.m01 = nm01;
        dest.m10 = nm10;
        dest.m11 = nm11;
        dest.m20 = nm20;
        dest.m21 = nm21;
        return dest;
    }

    public Matrix3x2d translation(double x2, double y2) {
        this.m00 = 1.0;
        this.m01 = 0.0;
        this.m10 = 0.0;
        this.m11 = 1.0;
        this.m20 = x2;
        this.m21 = y2;
        return this;
    }

    public Matrix3x2d translation(Vector2dc offset) {
        return this.translation(offset.x(), offset.y());
    }

    public Matrix3x2d setTranslation(double x2, double y2) {
        this.m20 = x2;
        this.m21 = y2;
        return this;
    }

    public Matrix3x2d setTranslation(Vector2dc offset) {
        return this.setTranslation(offset.x(), offset.y());
    }

    public Matrix3x2d translate(double x2, double y2, Matrix3x2d dest) {
        double rm20 = x2;
        double rm21 = y2;
        dest.m20 = this.m00 * rm20 + this.m10 * rm21 + this.m20;
        dest.m21 = this.m01 * rm20 + this.m11 * rm21 + this.m21;
        dest.m00 = this.m00;
        dest.m01 = this.m01;
        dest.m10 = this.m10;
        dest.m11 = this.m11;
        return dest;
    }

    public Matrix3x2d translate(double x2, double y2) {
        return this.translate(x2, y2, this);
    }

    public Matrix3x2d translate(Vector2dc offset, Matrix3x2d dest) {
        return this.translate(offset.x(), offset.y(), dest);
    }

    public Matrix3x2d translate(Vector2dc offset) {
        return this.translate(offset.x(), offset.y(), this);
    }

    public Matrix3x2d translateLocal(Vector2dc offset) {
        return this.translateLocal(offset.x(), offset.y());
    }

    public Matrix3x2d translateLocal(Vector2dc offset, Matrix3x2d dest) {
        return this.translateLocal(offset.x(), offset.y(), dest);
    }

    public Matrix3x2d translateLocal(double x2, double y2, Matrix3x2d dest) {
        dest.m00 = this.m00;
        dest.m01 = this.m01;
        dest.m10 = this.m10;
        dest.m11 = this.m11;
        dest.m20 = this.m20 + x2;
        dest.m21 = this.m21 + y2;
        return dest;
    }

    public Matrix3x2d translateLocal(double x2, double y2) {
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

    public Matrix3x2d get(Matrix3x2d dest) {
        return dest.set(this);
    }

    public DoubleBuffer get(DoubleBuffer buffer) {
        return this.get(buffer.position(), buffer);
    }

    public DoubleBuffer get(int index, DoubleBuffer buffer) {
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

    public DoubleBuffer get3x3(DoubleBuffer buffer) {
        MemUtil.INSTANCE.put3x3(this, 0, buffer);
        return buffer;
    }

    public DoubleBuffer get3x3(int index, DoubleBuffer buffer) {
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

    public DoubleBuffer get4x4(DoubleBuffer buffer) {
        MemUtil.INSTANCE.put4x4(this, 0, buffer);
        return buffer;
    }

    public DoubleBuffer get4x4(int index, DoubleBuffer buffer) {
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

    public DoubleBuffer getTransposed(DoubleBuffer buffer) {
        return this.getTransposed(buffer.position(), buffer);
    }

    public DoubleBuffer getTransposed(int index, DoubleBuffer buffer) {
        MemUtil.INSTANCE.putTransposed(this, index, buffer);
        return buffer;
    }

    public ByteBuffer getTransposed(ByteBuffer buffer) {
        return this.getTransposed(buffer.position(), buffer);
    }

    public ByteBuffer getTransposed(int index, ByteBuffer buffer) {
        MemUtil.INSTANCE.putTransposed(this, index, buffer);
        return buffer;
    }

    public FloatBuffer getTransposed(FloatBuffer buffer) {
        return this.getTransposed(buffer.position(), buffer);
    }

    public FloatBuffer getTransposed(int index, FloatBuffer buffer) {
        MemUtil.INSTANCE.putfTransposed(this, index, buffer);
        return buffer;
    }

    public ByteBuffer getTransposedFloats(ByteBuffer buffer) {
        return this.getTransposedFloats(buffer.position(), buffer);
    }

    public ByteBuffer getTransposedFloats(int index, ByteBuffer buffer) {
        MemUtil.INSTANCE.putfTransposed(this, index, buffer);
        return buffer;
    }

    public Matrix3x2dc getToAddress(long address) {
        if (Options.NO_UNSAFE) {
            throw new UnsupportedOperationException("Not supported when using joml.nounsafe");
        }
        MemUtil.MemUtilUnsafe.put(this, address);
        return this;
    }

    public double[] get(double[] arr2, int offset) {
        MemUtil.INSTANCE.copy(this, arr2, offset);
        return arr2;
    }

    public double[] get(double[] arr2) {
        return this.get(arr2, 0);
    }

    public double[] get3x3(double[] arr2, int offset) {
        MemUtil.INSTANCE.copy3x3(this, arr2, offset);
        return arr2;
    }

    public double[] get3x3(double[] arr2) {
        return this.get3x3(arr2, 0);
    }

    public double[] get4x4(double[] arr2, int offset) {
        MemUtil.INSTANCE.copy4x4(this, arr2, offset);
        return arr2;
    }

    public double[] get4x4(double[] arr2) {
        return this.get4x4(arr2, 0);
    }

    public Matrix3x2d set(DoubleBuffer buffer) {
        int pos = buffer.position();
        MemUtil.INSTANCE.get(this, pos, buffer);
        return this;
    }

    public Matrix3x2d set(ByteBuffer buffer) {
        int pos = buffer.position();
        MemUtil.INSTANCE.get(this, pos, buffer);
        return this;
    }

    public Matrix3x2d set(int index, DoubleBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
        return this;
    }

    public Matrix3x2d set(int index, ByteBuffer buffer) {
        MemUtil.INSTANCE.get(this, index, buffer);
        return this;
    }

    public Matrix3x2d setFromAddress(long address) {
        if (Options.NO_UNSAFE) {
            throw new UnsupportedOperationException("Not supported when using joml.nounsafe");
        }
        MemUtil.MemUtilUnsafe.get(this, address);
        return this;
    }

    public Matrix3x2d zero() {
        MemUtil.INSTANCE.zero(this);
        return this;
    }

    public Matrix3x2d identity() {
        MemUtil.INSTANCE.identity(this);
        return this;
    }

    public Matrix3x2d scale(double x2, double y2, Matrix3x2d dest) {
        dest.m00 = this.m00 * x2;
        dest.m01 = this.m01 * x2;
        dest.m10 = this.m10 * y2;
        dest.m11 = this.m11 * y2;
        dest.m20 = this.m20;
        dest.m21 = this.m21;
        return dest;
    }

    public Matrix3x2d scale(double x2, double y2) {
        return this.scale(x2, y2, this);
    }

    public Matrix3x2d scale(Vector2dc xy) {
        return this.scale(xy.x(), xy.y(), this);
    }

    public Matrix3x2d scale(Vector2dc xy, Matrix3x2d dest) {
        return this.scale(xy.x(), xy.y(), dest);
    }

    public Matrix3x2d scale(Vector2fc xy) {
        return this.scale(xy.x(), xy.y(), this);
    }

    public Matrix3x2d scale(Vector2fc xy, Matrix3x2d dest) {
        return this.scale(xy.x(), xy.y(), dest);
    }

    public Matrix3x2d scale(double xy, Matrix3x2d dest) {
        return this.scale(xy, xy, dest);
    }

    public Matrix3x2d scale(double xy) {
        return this.scale(xy, xy);
    }

    public Matrix3x2d scaleLocal(double x2, double y2, Matrix3x2d dest) {
        dest.m00 = x2 * this.m00;
        dest.m01 = y2 * this.m01;
        dest.m10 = x2 * this.m10;
        dest.m11 = y2 * this.m11;
        dest.m20 = x2 * this.m20;
        dest.m21 = y2 * this.m21;
        return dest;
    }

    public Matrix3x2d scaleLocal(double x2, double y2) {
        return this.scaleLocal(x2, y2, this);
    }

    public Matrix3x2d scaleLocal(double xy, Matrix3x2d dest) {
        return this.scaleLocal(xy, xy, dest);
    }

    public Matrix3x2d scaleLocal(double xy) {
        return this.scaleLocal(xy, xy, this);
    }

    public Matrix3x2d scaleAround(double sx, double sy, double ox, double oy, Matrix3x2d dest) {
        double nm20 = this.m00 * ox + this.m10 * oy + this.m20;
        double nm21 = this.m01 * ox + this.m11 * oy + this.m21;
        dest.m00 = this.m00 * sx;
        dest.m01 = this.m01 * sx;
        dest.m10 = this.m10 * sy;
        dest.m11 = this.m11 * sy;
        dest.m20 = dest.m00 * -ox + dest.m10 * -oy + nm20;
        dest.m21 = dest.m01 * -ox + dest.m11 * -oy + nm21;
        return dest;
    }

    public Matrix3x2d scaleAround(double sx, double sy, double ox, double oy) {
        return this.scaleAround(sx, sy, ox, oy, this);
    }

    public Matrix3x2d scaleAround(double factor, double ox, double oy, Matrix3x2d dest) {
        return this.scaleAround(factor, factor, ox, oy, this);
    }

    public Matrix3x2d scaleAround(double factor, double ox, double oy) {
        return this.scaleAround(factor, factor, ox, oy, this);
    }

    public Matrix3x2d scaleAroundLocal(double sx, double sy, double ox, double oy, Matrix3x2d dest) {
        dest.m00 = sx * this.m00;
        dest.m01 = sy * this.m01;
        dest.m10 = sx * this.m10;
        dest.m11 = sy * this.m11;
        dest.m20 = sx * this.m20 - sx * ox + ox;
        dest.m21 = sy * this.m21 - sy * oy + oy;
        return dest;
    }

    public Matrix3x2d scaleAroundLocal(double factor, double ox, double oy, Matrix3x2d dest) {
        return this.scaleAroundLocal(factor, factor, ox, oy, dest);
    }

    public Matrix3x2d scaleAroundLocal(double sx, double sy, double sz, double ox, double oy, double oz) {
        return this.scaleAroundLocal(sx, sy, ox, oy, this);
    }

    public Matrix3x2d scaleAroundLocal(double factor, double ox, double oy) {
        return this.scaleAroundLocal(factor, factor, ox, oy, this);
    }

    public Matrix3x2d scaling(double factor) {
        return this.scaling(factor, factor);
    }

    public Matrix3x2d scaling(double x2, double y2) {
        this.m00 = x2;
        this.m01 = 0.0;
        this.m10 = 0.0;
        this.m11 = y2;
        this.m20 = 0.0;
        this.m21 = 0.0;
        return this;
    }

    public Matrix3x2d rotation(double angle) {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        this.m00 = cos;
        this.m10 = -sin;
        this.m20 = 0.0;
        this.m01 = sin;
        this.m11 = cos;
        this.m21 = 0.0;
        return this;
    }

    public Vector3d transform(Vector3d v2) {
        return v2.mul(this);
    }

    public Vector3d transform(Vector3dc v2, Vector3d dest) {
        return v2.mul(this, dest);
    }

    public Vector3d transform(double x2, double y2, double z2, Vector3d dest) {
        return dest.set(this.m00 * x2 + this.m10 * y2 + this.m20 * z2, this.m01 * x2 + this.m11 * y2 + this.m21 * z2, z2);
    }

    public Vector2d transformPosition(Vector2d v2) {
        v2.set(this.m00 * v2.x + this.m10 * v2.y + this.m20, this.m01 * v2.x + this.m11 * v2.y + this.m21);
        return v2;
    }

    public Vector2d transformPosition(Vector2dc v2, Vector2d dest) {
        dest.set(this.m00 * v2.x() + this.m10 * v2.y() + this.m20, this.m01 * v2.x() + this.m11 * v2.y() + this.m21);
        return dest;
    }

    public Vector2d transformPosition(double x2, double y2, Vector2d dest) {
        return dest.set(this.m00 * x2 + this.m10 * y2 + this.m20, this.m01 * x2 + this.m11 * y2 + this.m21);
    }

    public Vector2d transformDirection(Vector2d v2) {
        v2.set(this.m00 * v2.x + this.m10 * v2.y, this.m01 * v2.x + this.m11 * v2.y);
        return v2;
    }

    public Vector2d transformDirection(Vector2dc v2, Vector2d dest) {
        dest.set(this.m00 * v2.x() + this.m10 * v2.y(), this.m01 * v2.x() + this.m11 * v2.y());
        return dest;
    }

    public Vector2d transformDirection(double x2, double y2, Vector2d dest) {
        return dest.set(this.m00 * x2 + this.m10 * y2, this.m01 * x2 + this.m11 * y2);
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeDouble(this.m00);
        out.writeDouble(this.m01);
        out.writeDouble(this.m10);
        out.writeDouble(this.m11);
        out.writeDouble(this.m20);
        out.writeDouble(this.m21);
    }

    public void readExternal(ObjectInput in) throws IOException {
        this.m00 = in.readDouble();
        this.m01 = in.readDouble();
        this.m10 = in.readDouble();
        this.m11 = in.readDouble();
        this.m20 = in.readDouble();
        this.m21 = in.readDouble();
    }

    public Matrix3x2d rotate(double ang) {
        return this.rotate(ang, this);
    }

    public Matrix3x2d rotate(double ang, Matrix3x2d dest) {
        double cos = Math.cos(ang);
        double sin = Math.sin(ang);
        double rm00 = cos;
        double rm01 = sin;
        double rm10 = -sin;
        double rm11 = cos;
        double nm00 = this.m00 * rm00 + this.m10 * rm01;
        double nm01 = this.m01 * rm00 + this.m11 * rm01;
        dest.m10 = this.m00 * rm10 + this.m10 * rm11;
        dest.m11 = this.m01 * rm10 + this.m11 * rm11;
        dest.m00 = nm00;
        dest.m01 = nm01;
        dest.m20 = this.m20;
        dest.m21 = this.m21;
        return dest;
    }

    public Matrix3x2d rotateLocal(double ang, Matrix3x2d dest) {
        double sin = Math.sin(ang);
        double cos = Math.cosFromSin(sin, ang);
        double nm00 = cos * this.m00 - sin * this.m01;
        double nm01 = sin * this.m00 + cos * this.m01;
        double nm10 = cos * this.m10 - sin * this.m11;
        double nm11 = sin * this.m10 + cos * this.m11;
        double nm20 = cos * this.m20 - sin * this.m21;
        double nm21 = sin * this.m20 + cos * this.m21;
        dest.m00 = nm00;
        dest.m01 = nm01;
        dest.m10 = nm10;
        dest.m11 = nm11;
        dest.m20 = nm20;
        dest.m21 = nm21;
        return dest;
    }

    public Matrix3x2d rotateLocal(double ang) {
        return this.rotateLocal(ang, this);
    }

    public Matrix3x2d rotateAbout(double ang, double x2, double y2) {
        return this.rotateAbout(ang, x2, y2, this);
    }

    public Matrix3x2d rotateAbout(double ang, double x2, double y2, Matrix3x2d dest) {
        double tm20 = this.m00 * x2 + this.m10 * y2 + this.m20;
        double tm21 = this.m01 * x2 + this.m11 * y2 + this.m21;
        double cos = Math.cos(ang);
        double sin = Math.sin(ang);
        double nm00 = this.m00 * cos + this.m10 * sin;
        double nm01 = this.m01 * cos + this.m11 * sin;
        dest.m10 = this.m00 * -sin + this.m10 * cos;
        dest.m11 = this.m01 * -sin + this.m11 * cos;
        dest.m00 = nm00;
        dest.m01 = nm01;
        dest.m20 = dest.m00 * -x2 + dest.m10 * -y2 + tm20;
        dest.m21 = dest.m01 * -x2 + dest.m11 * -y2 + tm21;
        return dest;
    }

    public Matrix3x2d rotateTo(Vector2dc fromDir, Vector2dc toDir, Matrix3x2d dest) {
        double dot = fromDir.x() * toDir.x() + fromDir.y() * toDir.y();
        double det = fromDir.x() * toDir.y() - fromDir.y() * toDir.x();
        double rm00 = dot;
        double rm01 = det;
        double rm10 = -det;
        double rm11 = dot;
        double nm00 = this.m00 * rm00 + this.m10 * rm01;
        double nm01 = this.m01 * rm00 + this.m11 * rm01;
        dest.m10 = this.m00 * rm10 + this.m10 * rm11;
        dest.m11 = this.m01 * rm10 + this.m11 * rm11;
        dest.m00 = nm00;
        dest.m01 = nm01;
        dest.m20 = this.m20;
        dest.m21 = this.m21;
        return dest;
    }

    public Matrix3x2d rotateTo(Vector2dc fromDir, Vector2dc toDir) {
        return this.rotateTo(fromDir, toDir, this);
    }

    public Matrix3x2d view(double left, double right, double bottom, double top, Matrix3x2d dest) {
        double rm00 = 2.0 / (right - left);
        double rm11 = 2.0 / (top - bottom);
        double rm20 = (left + right) / (left - right);
        double rm21 = (bottom + top) / (bottom - top);
        dest.m20 = this.m00 * rm20 + this.m10 * rm21 + this.m20;
        dest.m21 = this.m01 * rm20 + this.m11 * rm21 + this.m21;
        dest.m00 = this.m00 * rm00;
        dest.m01 = this.m01 * rm00;
        dest.m10 = this.m10 * rm11;
        dest.m11 = this.m11 * rm11;
        return dest;
    }

    public Matrix3x2d view(double left, double right, double bottom, double top) {
        return this.view(left, right, bottom, top, this);
    }

    public Matrix3x2d setView(double left, double right, double bottom, double top) {
        this.m00 = 2.0 / (right - left);
        this.m01 = 0.0;
        this.m10 = 0.0;
        this.m11 = 2.0 / (top - bottom);
        this.m20 = (left + right) / (left - right);
        this.m21 = (bottom + top) / (bottom - top);
        return this;
    }

    public Vector2d origin(Vector2d origin) {
        double s2 = 1.0 / (this.m00 * this.m11 - this.m01 * this.m10);
        origin.x = (this.m10 * this.m21 - this.m20 * this.m11) * s2;
        origin.y = (this.m20 * this.m01 - this.m00 * this.m21) * s2;
        return origin;
    }

    public double[] viewArea(double[] area) {
        double s2 = 1.0 / (this.m00 * this.m11 - this.m01 * this.m10);
        double rm00 = this.m11 * s2;
        double rm01 = -this.m01 * s2;
        double rm10 = -this.m10 * s2;
        double rm11 = this.m00 * s2;
        double rm20 = (this.m10 * this.m21 - this.m20 * this.m11) * s2;
        double rm21 = (this.m20 * this.m01 - this.m00 * this.m21) * s2;
        double nxnyX = -rm00 - rm10;
        double nxnyY = -rm01 - rm11;
        double pxnyX = rm00 - rm10;
        double pxnyY = rm01 - rm11;
        double nxpyX = -rm00 + rm10;
        double nxpyY = -rm01 + rm11;
        double pxpyX = rm00 + rm10;
        double pxpyY = rm01 + rm11;
        double minX = nxnyX;
        minX = minX < nxpyX ? minX : nxpyX;
        minX = minX < pxnyX ? minX : pxnyX;
        minX = minX < pxpyX ? minX : pxpyX;
        double minY = nxnyY;
        minY = minY < nxpyY ? minY : nxpyY;
        minY = minY < pxnyY ? minY : pxnyY;
        minY = minY < pxpyY ? minY : pxpyY;
        double maxX = nxnyX;
        maxX = maxX > nxpyX ? maxX : nxpyX;
        maxX = maxX > pxnyX ? maxX : pxnyX;
        maxX = maxX > pxpyX ? maxX : pxpyX;
        double maxY = nxnyY;
        maxY = maxY > nxpyY ? maxY : nxpyY;
        maxY = maxY > pxnyY ? maxY : pxnyY;
        maxY = maxY > pxpyY ? maxY : pxpyY;
        area[0] = minX + rm20;
        area[1] = minY + rm21;
        area[2] = maxX + rm20;
        area[3] = maxY + rm21;
        return area;
    }

    public Vector2d positiveX(Vector2d dir) {
        double s2 = this.m00 * this.m11 - this.m01 * this.m10;
        s2 = 1.0 / s2;
        dir.x = this.m11 * s2;
        dir.y = -this.m01 * s2;
        return dir.normalize(dir);
    }

    public Vector2d normalizedPositiveX(Vector2d dir) {
        dir.x = this.m11;
        dir.y = -this.m01;
        return dir;
    }

    public Vector2d positiveY(Vector2d dir) {
        double s2 = this.m00 * this.m11 - this.m01 * this.m10;
        s2 = 1.0 / s2;
        dir.x = -this.m10 * s2;
        dir.y = this.m00 * s2;
        return dir.normalize(dir);
    }

    public Vector2d normalizedPositiveY(Vector2d dir) {
        dir.x = -this.m10;
        dir.y = this.m00;
        return dir;
    }

    public Vector2d unproject(double winX, double winY, int[] viewport, Vector2d dest) {
        double s2 = 1.0 / (this.m00 * this.m11 - this.m01 * this.m10);
        double im00 = this.m11 * s2;
        double im01 = -this.m01 * s2;
        double im10 = -this.m10 * s2;
        double im11 = this.m00 * s2;
        double im20 = (this.m10 * this.m21 - this.m20 * this.m11) * s2;
        double im21 = (this.m20 * this.m01 - this.m00 * this.m21) * s2;
        double ndcX = (winX - (double)viewport[0]) / (double)viewport[2] * 2.0 - 1.0;
        double ndcY = (winY - (double)viewport[1]) / (double)viewport[3] * 2.0 - 1.0;
        dest.x = im00 * ndcX + im10 * ndcY + im20;
        dest.y = im01 * ndcX + im11 * ndcY + im21;
        return dest;
    }

    public Vector2d unprojectInv(double winX, double winY, int[] viewport, Vector2d dest) {
        double ndcX = (winX - (double)viewport[0]) / (double)viewport[2] * 2.0 - 1.0;
        double ndcY = (winY - (double)viewport[1]) / (double)viewport[3] * 2.0 - 1.0;
        dest.x = this.m00 * ndcX + this.m10 * ndcY + this.m20;
        dest.y = this.m01 * ndcX + this.m11 * ndcY + this.m21;
        return dest;
    }

    public Matrix3x2d span(Vector2d corner, Vector2d xDir, Vector2d yDir) {
        double s2 = 1.0 / (this.m00 * this.m11 - this.m01 * this.m10);
        double nm00 = this.m11 * s2;
        double nm01 = -this.m01 * s2;
        double nm10 = -this.m10 * s2;
        double nm11 = this.m00 * s2;
        corner.x = -nm00 - nm10 + (this.m10 * this.m21 - this.m20 * this.m11) * s2;
        corner.y = -nm01 - nm11 + (this.m20 * this.m01 - this.m00 * this.m21) * s2;
        xDir.x = 2.0 * nm00;
        xDir.y = 2.0 * nm01;
        yDir.x = 2.0 * nm10;
        yDir.y = 2.0 * nm11;
        return this;
    }

    public boolean testPoint(double x2, double y2) {
        double nxX = this.m00;
        double nxY = this.m10;
        double nxW = 1.0 + this.m20;
        double pxX = -this.m00;
        double pxY = -this.m10;
        double pxW = 1.0 - this.m20;
        double nyX = this.m01;
        double nyY = this.m11;
        double nyW = 1.0 + this.m21;
        double pyX = -this.m01;
        double pyY = -this.m11;
        double pyW = 1.0 - this.m21;
        return nxX * x2 + nxY * y2 + nxW >= 0.0 && pxX * x2 + pxY * y2 + pxW >= 0.0 && nyX * x2 + nyY * y2 + nyW >= 0.0 && pyX * x2 + pyY * y2 + pyW >= 0.0;
    }

    public boolean testCircle(double x2, double y2, double r2) {
        double nxX = this.m00;
        double nxY = this.m10;
        double nxW = 1.0 + this.m20;
        double invl = Math.invsqrt(nxX * nxX + nxY * nxY);
        nxX *= invl;
        nxY *= invl;
        nxW *= invl;
        double pxX = -this.m00;
        double pxY = -this.m10;
        double pxW = 1.0 - this.m20;
        invl = Math.invsqrt(pxX * pxX + pxY * pxY);
        pxX *= invl;
        pxY *= invl;
        pxW *= invl;
        double nyX = this.m01;
        double nyY = this.m11;
        double nyW = 1.0 + this.m21;
        invl = Math.invsqrt(nyX * nyX + nyY * nyY);
        nyX *= invl;
        nyY *= invl;
        nyW *= invl;
        double pyX = -this.m01;
        double pyY = -this.m11;
        double pyW = 1.0 - this.m21;
        invl = Math.invsqrt(pyX * pyX + pyY * pyY);
        return nxX * x2 + nxY * y2 + nxW >= -r2 && pxX * x2 + pxY * y2 + pxW >= -r2 && nyX * x2 + nyY * y2 + nyW >= -r2 && (pyX *= invl) * x2 + (pyY *= invl) * y2 + (pyW *= invl) >= -r2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean testAar(double minX, double minY, double maxX, double maxY) {
        double nxX = this.m00;
        double nxY = this.m10;
        double nxW = 1.0 + this.m20;
        double pxX = -this.m00;
        double pxY = -this.m10;
        double pxW = 1.0 - this.m20;
        double nyX = this.m01;
        double nyY = this.m11;
        double nyW = 1.0 + this.m21;
        double pyX = -this.m01;
        double pyY = -this.m11;
        double pyW = 1.0 - this.m21;
        double d2 = nxX * (nxX < 0.0 ? minX : maxX);
        double d3 = nxY < 0.0 ? minY : maxY;
        if (!(d2 + nxY * d3 >= -nxW)) return false;
        double d4 = pxX * (pxX < 0.0 ? minX : maxX);
        double d5 = pxY < 0.0 ? minY : maxY;
        if (!(d4 + pxY * d5 >= -pxW)) return false;
        double d6 = nyX * (nyX < 0.0 ? minX : maxX);
        double d7 = nyY < 0.0 ? minY : maxY;
        if (!(d6 + nyY * d7 >= -nyW)) return false;
        double d8 = pyX * (pyX < 0.0 ? minX : maxX);
        double d9 = pyY < 0.0 ? minY : maxY;
        if (!(d8 + pyY * d9 >= -pyW)) return false;
        return true;
    }

    public int hashCode() {
        int prime = 31;
        int result = 1;
        long temp = Double.doubleToLongBits(this.m00);
        result = 31 * result + (int)(temp ^ temp >>> 32);
        temp = Double.doubleToLongBits(this.m01);
        result = 31 * result + (int)(temp ^ temp >>> 32);
        temp = Double.doubleToLongBits(this.m10);
        result = 31 * result + (int)(temp ^ temp >>> 32);
        temp = Double.doubleToLongBits(this.m11);
        result = 31 * result + (int)(temp ^ temp >>> 32);
        temp = Double.doubleToLongBits(this.m20);
        result = 31 * result + (int)(temp ^ temp >>> 32);
        temp = Double.doubleToLongBits(this.m21);
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
        Matrix3x2d other = (Matrix3x2d)obj;
        if (Double.doubleToLongBits(this.m00) != Double.doubleToLongBits(other.m00)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m01) != Double.doubleToLongBits(other.m01)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m10) != Double.doubleToLongBits(other.m10)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m11) != Double.doubleToLongBits(other.m11)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m20) != Double.doubleToLongBits(other.m20)) {
            return false;
        }
        return Double.doubleToLongBits(this.m21) == Double.doubleToLongBits(other.m21);
    }

    public boolean equals(Matrix3x2dc m2, double delta) {
        if (this == m2) {
            return true;
        }
        if (m2 == null) {
            return false;
        }
        if (!(m2 instanceof Matrix3x2d)) {
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

