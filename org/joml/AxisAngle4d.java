/*
 * Decompiled with CFR 0.152.
 */
package org.joml;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.NumberFormat;
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
import org.joml.Matrix4x3fc;
import org.joml.Options;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Runtime;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector4d;
import org.joml.Vector4dc;

public class AxisAngle4d
implements Externalizable,
Cloneable {
    private static final long serialVersionUID = 1L;
    public double angle;
    public double x;
    public double y;
    public double z;

    public AxisAngle4d() {
        this.z = 1.0;
    }

    public AxisAngle4d(AxisAngle4d a2) {
        this.x = a2.x;
        this.y = a2.y;
        this.z = a2.z;
        this.angle = (a2.angle < 0.0 ? java.lang.Math.PI * 2 + a2.angle % (java.lang.Math.PI * 2) : a2.angle) % (java.lang.Math.PI * 2);
    }

    public AxisAngle4d(AxisAngle4f a2) {
        this.x = a2.x;
        this.y = a2.y;
        this.z = a2.z;
        this.angle = ((double)a2.angle < 0.0 ? java.lang.Math.PI * 2 + (double)a2.angle % (java.lang.Math.PI * 2) : (double)a2.angle) % (java.lang.Math.PI * 2);
    }

    public AxisAngle4d(Quaternionfc q2) {
        float acos = Math.safeAcos(q2.w());
        float invSqrt = Math.invsqrt(1.0f - q2.w() * q2.w());
        if (Float.isInfinite(invSqrt)) {
            this.x = 0.0;
            this.y = 0.0;
            this.z = 1.0;
        } else {
            this.x = q2.x() * invSqrt;
            this.y = q2.y() * invSqrt;
            this.z = q2.z() * invSqrt;
        }
        this.angle = acos + acos;
    }

    public AxisAngle4d(Quaterniondc q2) {
        double acos = Math.safeAcos(q2.w());
        double invSqrt = Math.invsqrt(1.0 - q2.w() * q2.w());
        if (Double.isInfinite(invSqrt)) {
            this.x = 0.0;
            this.y = 0.0;
            this.z = 1.0;
        } else {
            this.x = q2.x() * invSqrt;
            this.y = q2.y() * invSqrt;
            this.z = q2.z() * invSqrt;
        }
        this.angle = acos + acos;
    }

    public AxisAngle4d(double angle, double x2, double y2, double z2) {
        this.x = x2;
        this.y = y2;
        this.z = z2;
        this.angle = (angle < 0.0 ? java.lang.Math.PI * 2 + angle % (java.lang.Math.PI * 2) : angle) % (java.lang.Math.PI * 2);
    }

    public AxisAngle4d(double angle, Vector3dc v2) {
        this(angle, v2.x(), v2.y(), v2.z());
    }

    public AxisAngle4d(double angle, Vector3f v2) {
        this(angle, v2.x, v2.y, v2.z);
    }

    public AxisAngle4d set(AxisAngle4d a2) {
        this.x = a2.x;
        this.y = a2.y;
        this.z = a2.z;
        this.angle = (a2.angle < 0.0 ? java.lang.Math.PI * 2 + a2.angle % (java.lang.Math.PI * 2) : a2.angle) % (java.lang.Math.PI * 2);
        return this;
    }

    public AxisAngle4d set(AxisAngle4f a2) {
        this.x = a2.x;
        this.y = a2.y;
        this.z = a2.z;
        this.angle = ((double)a2.angle < 0.0 ? java.lang.Math.PI * 2 + (double)a2.angle % (java.lang.Math.PI * 2) : (double)a2.angle) % (java.lang.Math.PI * 2);
        return this;
    }

    public AxisAngle4d set(double angle, double x2, double y2, double z2) {
        this.x = x2;
        this.y = y2;
        this.z = z2;
        this.angle = (angle < 0.0 ? java.lang.Math.PI * 2 + angle % (java.lang.Math.PI * 2) : angle) % (java.lang.Math.PI * 2);
        return this;
    }

    public AxisAngle4d set(double angle, Vector3dc v2) {
        return this.set(angle, v2.x(), v2.y(), v2.z());
    }

    public AxisAngle4d set(double angle, Vector3f v2) {
        return this.set(angle, v2.x, v2.y, v2.z);
    }

    public AxisAngle4d set(Quaternionfc q2) {
        float acos = Math.safeAcos(q2.w());
        float invSqrt = Math.invsqrt(1.0f - q2.w() * q2.w());
        if (Float.isInfinite(invSqrt)) {
            this.x = 0.0;
            this.y = 0.0;
            this.z = 1.0;
        } else {
            this.x = q2.x() * invSqrt;
            this.y = q2.y() * invSqrt;
            this.z = q2.z() * invSqrt;
        }
        this.angle = acos + acos;
        return this;
    }

    public AxisAngle4d set(Quaterniondc q2) {
        double acos = Math.safeAcos(q2.w());
        double invSqrt = Math.invsqrt(1.0 - q2.w() * q2.w());
        if (Double.isInfinite(invSqrt)) {
            this.x = 0.0;
            this.y = 0.0;
            this.z = 1.0;
        } else {
            this.x = q2.x() * invSqrt;
            this.y = q2.y() * invSqrt;
            this.z = q2.z() * invSqrt;
        }
        this.angle = acos + acos;
        return this;
    }

    public AxisAngle4d set(Matrix3fc m2) {
        double nm00 = m2.m00();
        double nm01 = m2.m01();
        double nm02 = m2.m02();
        double nm10 = m2.m10();
        double nm11 = m2.m11();
        double nm12 = m2.m12();
        double nm20 = m2.m20();
        double nm21 = m2.m21();
        double nm22 = m2.m22();
        double lenX = Math.invsqrt(m2.m00() * m2.m00() + m2.m01() * m2.m01() + m2.m02() * m2.m02());
        double lenY = Math.invsqrt(m2.m10() * m2.m10() + m2.m11() * m2.m11() + m2.m12() * m2.m12());
        double lenZ = Math.invsqrt(m2.m20() * m2.m20() + m2.m21() * m2.m21() + m2.m22() * m2.m22());
        nm00 *= lenX;
        nm01 *= lenX;
        nm02 *= lenX;
        nm10 *= lenY;
        nm11 *= lenY;
        nm12 *= lenY;
        nm20 *= lenZ;
        nm21 *= lenZ;
        nm22 *= lenZ;
        double epsilon = 1.0E-4;
        double epsilon2 = 0.001;
        if (Math.abs(nm10 - nm01) < epsilon && Math.abs(nm20 - nm02) < epsilon && Math.abs(nm21 - nm12) < epsilon) {
            if (Math.abs(nm10 + nm01) < epsilon2 && Math.abs(nm20 + nm02) < epsilon2 && Math.abs(nm21 + nm12) < epsilon2 && Math.abs(nm00 + nm11 + nm22 - 3.0) < epsilon2) {
                this.x = 0.0;
                this.y = 0.0;
                this.z = 1.0;
                this.angle = 0.0;
                return this;
            }
            this.angle = java.lang.Math.PI;
            double xx = (nm00 + 1.0) / 2.0;
            double yy = (nm11 + 1.0) / 2.0;
            double zz = (nm22 + 1.0) / 2.0;
            double xy = (nm10 + nm01) / 4.0;
            double xz = (nm20 + nm02) / 4.0;
            double yz = (nm21 + nm12) / 4.0;
            if (xx > yy && xx > zz) {
                this.x = Math.sqrt(xx);
                this.y = xy / this.x;
                this.z = xz / this.x;
            } else if (yy > zz) {
                this.y = Math.sqrt(yy);
                this.x = xy / this.y;
                this.z = yz / this.y;
            } else {
                this.z = Math.sqrt(zz);
                this.x = xz / this.z;
                this.y = yz / this.z;
            }
            return this;
        }
        double s2 = Math.sqrt((nm12 - nm21) * (nm12 - nm21) + (nm20 - nm02) * (nm20 - nm02) + (nm01 - nm10) * (nm01 - nm10));
        this.angle = Math.safeAcos((nm00 + nm11 + nm22 - 1.0) / 2.0);
        this.x = (nm12 - nm21) / s2;
        this.y = (nm20 - nm02) / s2;
        this.z = (nm01 - nm10) / s2;
        return this;
    }

    public AxisAngle4d set(Matrix3dc m2) {
        double nm00 = m2.m00();
        double nm01 = m2.m01();
        double nm02 = m2.m02();
        double nm10 = m2.m10();
        double nm11 = m2.m11();
        double nm12 = m2.m12();
        double nm20 = m2.m20();
        double nm21 = m2.m21();
        double nm22 = m2.m22();
        double lenX = Math.invsqrt(m2.m00() * m2.m00() + m2.m01() * m2.m01() + m2.m02() * m2.m02());
        double lenY = Math.invsqrt(m2.m10() * m2.m10() + m2.m11() * m2.m11() + m2.m12() * m2.m12());
        double lenZ = Math.invsqrt(m2.m20() * m2.m20() + m2.m21() * m2.m21() + m2.m22() * m2.m22());
        nm00 *= lenX;
        nm01 *= lenX;
        nm02 *= lenX;
        nm10 *= lenY;
        nm11 *= lenY;
        nm12 *= lenY;
        nm20 *= lenZ;
        nm21 *= lenZ;
        nm22 *= lenZ;
        double epsilon = 1.0E-4;
        double epsilon2 = 0.001;
        if (Math.abs(nm10 - nm01) < epsilon && Math.abs(nm20 - nm02) < epsilon && Math.abs(nm21 - nm12) < epsilon) {
            if (Math.abs(nm10 + nm01) < epsilon2 && Math.abs(nm20 + nm02) < epsilon2 && Math.abs(nm21 + nm12) < epsilon2 && Math.abs(nm00 + nm11 + nm22 - 3.0) < epsilon2) {
                this.x = 0.0;
                this.y = 0.0;
                this.z = 1.0;
                this.angle = 0.0;
                return this;
            }
            this.angle = java.lang.Math.PI;
            double xx = (nm00 + 1.0) / 2.0;
            double yy = (nm11 + 1.0) / 2.0;
            double zz = (nm22 + 1.0) / 2.0;
            double xy = (nm10 + nm01) / 4.0;
            double xz = (nm20 + nm02) / 4.0;
            double yz = (nm21 + nm12) / 4.0;
            if (xx > yy && xx > zz) {
                this.x = Math.sqrt(xx);
                this.y = xy / this.x;
                this.z = xz / this.x;
            } else if (yy > zz) {
                this.y = Math.sqrt(yy);
                this.x = xy / this.y;
                this.z = yz / this.y;
            } else {
                this.z = Math.sqrt(zz);
                this.x = xz / this.z;
                this.y = yz / this.z;
            }
            return this;
        }
        double s2 = Math.sqrt((nm12 - nm21) * (nm12 - nm21) + (nm20 - nm02) * (nm20 - nm02) + (nm01 - nm10) * (nm01 - nm10));
        this.angle = Math.safeAcos((nm00 + nm11 + nm22 - 1.0) / 2.0);
        this.x = (nm12 - nm21) / s2;
        this.y = (nm20 - nm02) / s2;
        this.z = (nm01 - nm10) / s2;
        return this;
    }

    public AxisAngle4d set(Matrix4fc m2) {
        double nm00 = m2.m00();
        double nm01 = m2.m01();
        double nm02 = m2.m02();
        double nm10 = m2.m10();
        double nm11 = m2.m11();
        double nm12 = m2.m12();
        double nm20 = m2.m20();
        double nm21 = m2.m21();
        double nm22 = m2.m22();
        double lenX = Math.invsqrt(m2.m00() * m2.m00() + m2.m01() * m2.m01() + m2.m02() * m2.m02());
        double lenY = Math.invsqrt(m2.m10() * m2.m10() + m2.m11() * m2.m11() + m2.m12() * m2.m12());
        double lenZ = Math.invsqrt(m2.m20() * m2.m20() + m2.m21() * m2.m21() + m2.m22() * m2.m22());
        nm00 *= lenX;
        nm01 *= lenX;
        nm02 *= lenX;
        nm10 *= lenY;
        nm11 *= lenY;
        nm12 *= lenY;
        nm20 *= lenZ;
        nm21 *= lenZ;
        nm22 *= lenZ;
        double epsilon = 1.0E-4;
        double epsilon2 = 0.001;
        if (Math.abs(nm10 - nm01) < epsilon && Math.abs(nm20 - nm02) < epsilon && Math.abs(nm21 - nm12) < epsilon) {
            if (Math.abs(nm10 + nm01) < epsilon2 && Math.abs(nm20 + nm02) < epsilon2 && Math.abs(nm21 + nm12) < epsilon2 && Math.abs(nm00 + nm11 + nm22 - 3.0) < epsilon2) {
                this.x = 0.0;
                this.y = 0.0;
                this.z = 1.0;
                this.angle = 0.0;
                return this;
            }
            this.angle = java.lang.Math.PI;
            double xx = (nm00 + 1.0) / 2.0;
            double yy = (nm11 + 1.0) / 2.0;
            double zz = (nm22 + 1.0) / 2.0;
            double xy = (nm10 + nm01) / 4.0;
            double xz = (nm20 + nm02) / 4.0;
            double yz = (nm21 + nm12) / 4.0;
            if (xx > yy && xx > zz) {
                this.x = Math.sqrt(xx);
                this.y = xy / this.x;
                this.z = xz / this.x;
            } else if (yy > zz) {
                this.y = Math.sqrt(yy);
                this.x = xy / this.y;
                this.z = yz / this.y;
            } else {
                this.z = Math.sqrt(zz);
                this.x = xz / this.z;
                this.y = yz / this.z;
            }
            return this;
        }
        double s2 = Math.sqrt((nm12 - nm21) * (nm12 - nm21) + (nm20 - nm02) * (nm20 - nm02) + (nm01 - nm10) * (nm01 - nm10));
        this.angle = Math.safeAcos((nm00 + nm11 + nm22 - 1.0) / 2.0);
        this.x = (nm12 - nm21) / s2;
        this.y = (nm20 - nm02) / s2;
        this.z = (nm01 - nm10) / s2;
        return this;
    }

    public AxisAngle4d set(Matrix4x3fc m2) {
        double nm00 = m2.m00();
        double nm01 = m2.m01();
        double nm02 = m2.m02();
        double nm10 = m2.m10();
        double nm11 = m2.m11();
        double nm12 = m2.m12();
        double nm20 = m2.m20();
        double nm21 = m2.m21();
        double nm22 = m2.m22();
        double lenX = Math.invsqrt(m2.m00() * m2.m00() + m2.m01() * m2.m01() + m2.m02() * m2.m02());
        double lenY = Math.invsqrt(m2.m10() * m2.m10() + m2.m11() * m2.m11() + m2.m12() * m2.m12());
        double lenZ = Math.invsqrt(m2.m20() * m2.m20() + m2.m21() * m2.m21() + m2.m22() * m2.m22());
        nm00 *= lenX;
        nm01 *= lenX;
        nm02 *= lenX;
        nm10 *= lenY;
        nm11 *= lenY;
        nm12 *= lenY;
        nm20 *= lenZ;
        nm21 *= lenZ;
        nm22 *= lenZ;
        double epsilon = 1.0E-4;
        double epsilon2 = 0.001;
        if (Math.abs(nm10 - nm01) < epsilon && Math.abs(nm20 - nm02) < epsilon && Math.abs(nm21 - nm12) < epsilon) {
            if (Math.abs(nm10 + nm01) < epsilon2 && Math.abs(nm20 + nm02) < epsilon2 && Math.abs(nm21 + nm12) < epsilon2 && Math.abs(nm00 + nm11 + nm22 - 3.0) < epsilon2) {
                this.x = 0.0;
                this.y = 0.0;
                this.z = 1.0;
                this.angle = 0.0;
                return this;
            }
            this.angle = java.lang.Math.PI;
            double xx = (nm00 + 1.0) / 2.0;
            double yy = (nm11 + 1.0) / 2.0;
            double zz = (nm22 + 1.0) / 2.0;
            double xy = (nm10 + nm01) / 4.0;
            double xz = (nm20 + nm02) / 4.0;
            double yz = (nm21 + nm12) / 4.0;
            if (xx > yy && xx > zz) {
                this.x = Math.sqrt(xx);
                this.y = xy / this.x;
                this.z = xz / this.x;
            } else if (yy > zz) {
                this.y = Math.sqrt(yy);
                this.x = xy / this.y;
                this.z = yz / this.y;
            } else {
                this.z = Math.sqrt(zz);
                this.x = xz / this.z;
                this.y = yz / this.z;
            }
            return this;
        }
        double s2 = Math.sqrt((nm12 - nm21) * (nm12 - nm21) + (nm20 - nm02) * (nm20 - nm02) + (nm01 - nm10) * (nm01 - nm10));
        this.angle = Math.safeAcos((nm00 + nm11 + nm22 - 1.0) / 2.0);
        this.x = (nm12 - nm21) / s2;
        this.y = (nm20 - nm02) / s2;
        this.z = (nm01 - nm10) / s2;
        return this;
    }

    public AxisAngle4d set(Matrix4dc m2) {
        double nm00 = m2.m00();
        double nm01 = m2.m01();
        double nm02 = m2.m02();
        double nm10 = m2.m10();
        double nm11 = m2.m11();
        double nm12 = m2.m12();
        double nm20 = m2.m20();
        double nm21 = m2.m21();
        double nm22 = m2.m22();
        double lenX = Math.invsqrt(m2.m00() * m2.m00() + m2.m01() * m2.m01() + m2.m02() * m2.m02());
        double lenY = Math.invsqrt(m2.m10() * m2.m10() + m2.m11() * m2.m11() + m2.m12() * m2.m12());
        double lenZ = Math.invsqrt(m2.m20() * m2.m20() + m2.m21() * m2.m21() + m2.m22() * m2.m22());
        nm00 *= lenX;
        nm01 *= lenX;
        nm02 *= lenX;
        nm10 *= lenY;
        nm11 *= lenY;
        nm12 *= lenY;
        nm20 *= lenZ;
        nm21 *= lenZ;
        nm22 *= lenZ;
        double epsilon = 1.0E-4;
        double epsilon2 = 0.001;
        if (Math.abs(nm10 - nm01) < epsilon && Math.abs(nm20 - nm02) < epsilon && Math.abs(nm21 - nm12) < epsilon) {
            if (Math.abs(nm10 + nm01) < epsilon2 && Math.abs(nm20 + nm02) < epsilon2 && Math.abs(nm21 + nm12) < epsilon2 && Math.abs(nm00 + nm11 + nm22 - 3.0) < epsilon2) {
                this.x = 0.0;
                this.y = 0.0;
                this.z = 1.0;
                this.angle = 0.0;
                return this;
            }
            this.angle = java.lang.Math.PI;
            double xx = (nm00 + 1.0) / 2.0;
            double yy = (nm11 + 1.0) / 2.0;
            double zz = (nm22 + 1.0) / 2.0;
            double xy = (nm10 + nm01) / 4.0;
            double xz = (nm20 + nm02) / 4.0;
            double yz = (nm21 + nm12) / 4.0;
            if (xx > yy && xx > zz) {
                this.x = Math.sqrt(xx);
                this.y = xy / this.x;
                this.z = xz / this.x;
            } else if (yy > zz) {
                this.y = Math.sqrt(yy);
                this.x = xy / this.y;
                this.z = yz / this.y;
            } else {
                this.z = Math.sqrt(zz);
                this.x = xz / this.z;
                this.y = yz / this.z;
            }
            return this;
        }
        double s2 = Math.sqrt((nm12 - nm21) * (nm12 - nm21) + (nm20 - nm02) * (nm20 - nm02) + (nm01 - nm10) * (nm01 - nm10));
        this.angle = Math.safeAcos((nm00 + nm11 + nm22 - 1.0) / 2.0);
        this.x = (nm12 - nm21) / s2;
        this.y = (nm20 - nm02) / s2;
        this.z = (nm01 - nm10) / s2;
        return this;
    }

    public Quaternionf get(Quaternionf q2) {
        return q2.set(this);
    }

    public Quaterniond get(Quaterniond q2) {
        return q2.set(this);
    }

    public Matrix4f get(Matrix4f m2) {
        return m2.set(this);
    }

    public Matrix3f get(Matrix3f m2) {
        return m2.set(this);
    }

    public Matrix4d get(Matrix4d m2) {
        return m2.set(this);
    }

    public Matrix3d get(Matrix3d m2) {
        return m2.set(this);
    }

    public AxisAngle4d get(AxisAngle4d dest) {
        return dest.set(this);
    }

    public AxisAngle4f get(AxisAngle4f dest) {
        return dest.set(this);
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeDouble(this.angle);
        out.writeDouble(this.x);
        out.writeDouble(this.y);
        out.writeDouble(this.z);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.angle = in.readDouble();
        this.x = in.readDouble();
        this.y = in.readDouble();
        this.z = in.readDouble();
    }

    public AxisAngle4d normalize() {
        double invLength = Math.invsqrt(this.x * this.x + this.y * this.y + this.z * this.z);
        this.x *= invLength;
        this.y *= invLength;
        this.z *= invLength;
        return this;
    }

    public AxisAngle4d rotate(double ang) {
        this.angle += ang;
        this.angle = (this.angle < 0.0 ? java.lang.Math.PI * 2 + this.angle % (java.lang.Math.PI * 2) : this.angle) % (java.lang.Math.PI * 2);
        return this;
    }

    public Vector3d transform(Vector3d v2) {
        return this.transform(v2, v2);
    }

    public Vector3d transform(Vector3dc v2, Vector3d dest) {
        double sin = Math.sin(this.angle);
        double cos = Math.cosFromSin(sin, this.angle);
        double dot = this.x * v2.x() + this.y * v2.y() + this.z * v2.z();
        dest.set(v2.x() * cos + sin * (this.y * v2.z() - this.z * v2.y()) + (1.0 - cos) * dot * this.x, v2.y() * cos + sin * (this.z * v2.x() - this.x * v2.z()) + (1.0 - cos) * dot * this.y, v2.z() * cos + sin * (this.x * v2.y() - this.y * v2.x()) + (1.0 - cos) * dot * this.z);
        return dest;
    }

    public Vector3f transform(Vector3f v2) {
        return this.transform(v2, v2);
    }

    public Vector3f transform(Vector3fc v2, Vector3f dest) {
        double sin = Math.sin(this.angle);
        double cos = Math.cosFromSin(sin, this.angle);
        double dot = this.x * (double)v2.x() + this.y * (double)v2.y() + this.z * (double)v2.z();
        dest.set((float)((double)v2.x() * cos + sin * (this.y * (double)v2.z() - this.z * (double)v2.y()) + (1.0 - cos) * dot * this.x), (float)((double)v2.y() * cos + sin * (this.z * (double)v2.x() - this.x * (double)v2.z()) + (1.0 - cos) * dot * this.y), (float)((double)v2.z() * cos + sin * (this.x * (double)v2.y() - this.y * (double)v2.x()) + (1.0 - cos) * dot * this.z));
        return dest;
    }

    public Vector4d transform(Vector4d v2) {
        return this.transform(v2, v2);
    }

    public Vector4d transform(Vector4dc v2, Vector4d dest) {
        double sin = Math.sin(this.angle);
        double cos = Math.cosFromSin(sin, this.angle);
        double dot = this.x * v2.x() + this.y * v2.y() + this.z * v2.z();
        dest.set(v2.x() * cos + sin * (this.y * v2.z() - this.z * v2.y()) + (1.0 - cos) * dot * this.x, v2.y() * cos + sin * (this.z * v2.x() - this.x * v2.z()) + (1.0 - cos) * dot * this.y, v2.z() * cos + sin * (this.x * v2.y() - this.y * v2.x()) + (1.0 - cos) * dot * this.z, dest.w);
        return dest;
    }

    public String toString() {
        return Runtime.formatNumbers(this.toString(Options.NUMBER_FORMAT));
    }

    public String toString(NumberFormat formatter) {
        return "(" + Runtime.format(this.x, formatter) + " " + Runtime.format(this.y, formatter) + " " + Runtime.format(this.z, formatter) + " <| " + Runtime.format(this.angle, formatter) + ")";
    }

    public int hashCode() {
        int prime = 31;
        int result = 1;
        long temp = Double.doubleToLongBits((this.angle < 0.0 ? java.lang.Math.PI * 2 + this.angle % (java.lang.Math.PI * 2) : this.angle) % (java.lang.Math.PI * 2));
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
        AxisAngle4d other = (AxisAngle4d)obj;
        if (Double.doubleToLongBits((this.angle < 0.0 ? java.lang.Math.PI * 2 + this.angle % (java.lang.Math.PI * 2) : this.angle) % (java.lang.Math.PI * 2)) != Double.doubleToLongBits((other.angle < 0.0 ? java.lang.Math.PI * 2 + other.angle % (java.lang.Math.PI * 2) : other.angle) % (java.lang.Math.PI * 2))) {
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

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

