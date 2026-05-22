/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  et
 *  it.unimi.dsi.fastutil.doubles.DoubleIterator
 *  it.unimi.dsi.fastutil.doubles.DoubleOpenHashSet
 */
package baritone.api.pathing.goals;

import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalXZ;
import baritone.api.pathing.goals.GoalYLevel;
import baritone.api.utils.SettingsUtil;
import it.unimi.dsi.fastutil.doubles.DoubleIterator;
import it.unimi.dsi.fastutil.doubles.DoubleOpenHashSet;
import java.util.Arrays;
import java.util.Objects;

public class GoalRunAway
implements Goal {
    private final et[] from;
    private final int distanceSq;
    private final Integer maintainY;

    public GoalRunAway(double d2, et ... etArray) {
        this(d2, (Integer)null, etArray);
    }

    public GoalRunAway(double d2, Integer n2, et ... etArray) {
        if (etArray.length == 0) {
            throw new IllegalArgumentException();
        }
        this.from = etArray;
        double d3 = d2;
        this.distanceSq = (int)(d3 * d3);
        this.maintainY = n2;
    }

    @Override
    public boolean isInGoal(int n2, int n3, int n4) {
        if (this.maintainY != null && this.maintainY != n3) {
            return false;
        }
        et[] etArray = this.from;
        int n5 = this.from.length;
        for (int i2 = 0; i2 < n5; ++i2) {
            et et2 = etArray[i2];
            int n6 = n2 - et2.p();
            int n7 = n4 - et2.r();
            int n8 = n6;
            int n9 = n7;
            if (n8 * n8 + n9 * n9 >= this.distanceSq) continue;
            return false;
        }
        return true;
    }

    @Override
    public double heuristic(int n2, int n3, int n4) {
        double d2 = Double.MAX_VALUE;
        et[] etArray = this.from;
        int n5 = this.from.length;
        for (int i2 = 0; i2 < n5; ++i2) {
            double d3;
            et et2 = etArray[i2];
            double d4 = GoalXZ.calculate(et2.p() - n2, et2.r() - n4);
            if (!(d3 < d2)) continue;
            d2 = d4;
        }
        d2 = -d2;
        if (this.maintainY != null) {
            d2 = d2 * 0.6 + GoalYLevel.calculate(this.maintainY, n3) * 1.5;
        }
        return d2;
    }

    @Override
    public double heuristic() {
        double d2;
        int n2 = (int)Math.ceil(Math.sqrt(this.distanceSq));
        int n3 = Integer.MAX_VALUE;
        int n4 = Integer.MAX_VALUE;
        int n5 = Integer.MAX_VALUE;
        int n6 = Integer.MIN_VALUE;
        int n7 = Integer.MIN_VALUE;
        int n8 = Integer.MIN_VALUE;
        for (et et2 : this.from) {
            n3 = Math.min(n3, et2.p() - n2);
            n4 = Math.min(n4, et2.q() - n2);
            n5 = Math.min(n5, et2.r() - n2);
            n6 = Math.max(n3, et2.p() + n2);
            n7 = Math.max(n4, et2.q() + n2);
            n8 = Math.max(n5, et2.r() + n2);
        }
        DoubleOpenHashSet doubleOpenHashSet = new DoubleOpenHashSet();
        double d3 = Double.POSITIVE_INFINITY;
        for (int i2 = n3; i2 <= n6; ++i2) {
            for (int i3 = n4; i3 <= n7; ++i3) {
                for (n2 = n5; n2 <= n8; ++n2) {
                    double d4;
                    d2 = this.heuristic(i2, i3, n2);
                    if (d4 < d3 && this.isInGoal(i2, i3, n2)) {
                        doubleOpenHashSet.add(d2);
                        continue;
                    }
                    d3 = Math.min(d3, d2);
                }
            }
        }
        double d5 = Double.NEGATIVE_INFINITY;
        DoubleIterator doubleIterator = doubleOpenHashSet.iterator();
        while (doubleIterator.hasNext()) {
            double d6;
            d2 = doubleIterator.nextDouble();
            if (!(d6 < d3)) continue;
            d5 = Math.max(d5, d2);
        }
        return d5;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        object = (GoalRunAway)object;
        return this.distanceSq == ((GoalRunAway)object).distanceSq && Arrays.equals(this.from, ((GoalRunAway)object).from) && Objects.equals(this.maintainY, ((GoalRunAway)object).maintainY);
    }

    public int hashCode() {
        return (Arrays.hashCode(this.from) * 1196803141 + this.distanceSq) * -2053788840 + this.maintainY;
    }

    public String toString() {
        if (this.maintainY != null) {
            return String.format("GoalRunAwayFromMaintainY y=%s, %s", SettingsUtil.maybeCensor(this.maintainY), Arrays.asList(this.from));
        }
        return "GoalRunAwayFrom" + Arrays.asList(this.from);
    }
}

