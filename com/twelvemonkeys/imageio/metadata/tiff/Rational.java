/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.metadata.tiff;

public final class Rational
extends Number
implements Comparable<Rational> {
    static final Rational ZERO = new Rational(0L, 1L);
    static final Rational NaN = new Rational();
    private final long numerator;
    private final long denominator;

    private Rational() {
        this.numerator = 0L;
        this.denominator = 0L;
    }

    public Rational(long l2) {
        this(l2, 1L);
    }

    public Rational(long l2, long l3) {
        if (l3 == 0L) {
            throw new IllegalArgumentException("denominator == 0");
        }
        if (l2 == Long.MIN_VALUE || l3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("value == Long.MIN_VALUE");
        }
        long l4 = Rational.gcd(l2, l3);
        long l5 = l2 / l4;
        long l6 = l3 / l4;
        this.numerator = l3 >= 0L ? l5 : -l5;
        this.denominator = l3 >= 0L ? l6 : -l6;
    }

    private static long gcd(long l2, long l3) {
        if (l2 < 0L) {
            return Rational.gcd(l3, -l2);
        }
        return l3 == 0L ? l2 : Rational.gcd(l3, l2 % l3);
    }

    private static long lcm(long l2, long l3) {
        if (l2 < 0L) {
            return Rational.lcm(l3, -l2);
        }
        return l2 * (l3 / Rational.gcd(l2, l3));
    }

    public long numerator() {
        return this.numerator;
    }

    public long denominator() {
        return this.denominator;
    }

    @Override
    public int intValue() {
        return (int)this.doubleValue();
    }

    @Override
    public long longValue() {
        return (long)this.doubleValue();
    }

    @Override
    public float floatValue() {
        return (float)this.doubleValue();
    }

    @Override
    public double doubleValue() {
        if (this == NaN) {
            return Double.NaN;
        }
        return (double)this.numerator / (double)this.denominator;
    }

    @Override
    public int compareTo(Rational rational) {
        double d2 = this.doubleValue();
        double d3 = rational.doubleValue();
        return Double.compare(d2, d3);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.floatValue());
    }

    public boolean equals(Object object) {
        return object == this || object instanceof Rational && this.compareTo((Rational)object) == 0;
    }

    public String toString() {
        if (this == NaN) {
            return "NaN";
        }
        return this.denominator == 1L ? Long.toString(this.numerator) : String.format("%s/%s", this.numerator, this.denominator);
    }

    public Rational times(Rational rational) {
        if (this.equals(ZERO) || rational.equals(ZERO)) {
            return ZERO;
        }
        Rational rational2 = new Rational(this.numerator, rational.denominator);
        Rational rational3 = new Rational(rational.numerator, this.denominator);
        return new Rational(rational2.numerator * rational3.numerator, rational2.denominator * rational3.denominator);
    }

    public Rational plus(Rational rational) {
        if (this.equals(ZERO)) {
            return rational;
        }
        if (rational.equals(ZERO)) {
            return this;
        }
        long l2 = Rational.gcd(this.numerator, rational.numerator);
        long l3 = Rational.gcd(this.denominator, rational.denominator);
        return new Rational((this.numerator / l2 * (rational.denominator / l3) + rational.numerator / l2 * (this.denominator / l3)) * l2, Rational.lcm(this.denominator, rational.denominator));
    }

    public Rational negate() {
        return new Rational(-this.numerator, this.denominator);
    }

    public Rational minus(Rational rational) {
        return this.plus(rational.negate());
    }

    public Rational reciprocal() {
        return new Rational(this.denominator, this.numerator);
    }

    public Rational divides(Rational rational) {
        if (rational.equals(ZERO)) {
            throw new ArithmeticException("/ by zero");
        }
        return this.times(rational.reciprocal());
    }
}

