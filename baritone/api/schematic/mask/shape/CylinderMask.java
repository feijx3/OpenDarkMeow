/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  fa$a
 */
package baritone.api.schematic.mask.shape;

import baritone.api.schematic.mask.AbstractMask;
import baritone.api.schematic.mask.StaticMask;

public final class CylinderMask
extends AbstractMask
implements StaticMask {
    private final double centerA;
    private final double centerB;
    private final double radiusSqA;
    private final double radiusSqB;
    private final boolean filled;
    private final fa.a alignment;

    public CylinderMask(int n2, int n3, int n4, boolean bl2, fa.a a2) {
        super(n2, n3, n4);
        this.centerA = (double)CylinderMask.getA(n2, n3, a2) / 2.0;
        this.centerB = (double)CylinderMask.getB(n3, n4, a2) / 2.0;
        this.radiusSqA = (this.centerA - 1.0) * (this.centerA - 1.0);
        this.radiusSqB = (this.centerB - 1.0) * (this.centerB - 1.0);
        this.filled = bl2;
        this.alignment = a2;
    }

    @Override
    public final boolean partOfMask(int n2, int n3, int n4) {
        double d2;
        double d3 = Math.abs((double)CylinderMask.getA(n2, n3, this.alignment) + 0.5 - this.centerA);
        if (this.outside(d3, d2 = Math.abs((double)CylinderMask.getB(n3, n4, this.alignment) + 0.5 - this.centerB))) {
            return false;
        }
        return this.filled || this.outside(d3 + 1.0, d2) || this.outside(d3, d2 + 1.0);
    }

    private boolean outside(double d2, double d3) {
        double d4 = d2;
        double d5 = d3;
        return d4 * d4 / this.radiusSqA + d5 * d5 / this.radiusSqB > 1.0;
    }

    private static int getA(int n2, int n3, fa.a a2) {
        if (a2 == fa.a.a) {
            return n3;
        }
        return n2;
    }

    private static int getB(int n2, int n3, fa.a a2) {
        if (a2 == fa.a.c) {
            return n2;
        }
        return n3;
    }
}

