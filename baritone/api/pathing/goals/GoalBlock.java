/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  et
 */
package baritone.api.pathing.goals;

import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalXZ;
import baritone.api.pathing.goals.GoalYLevel;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.SettingsUtil;
import baritone.api.utils.interfaces.IGoalRenderPos;

public class GoalBlock
implements Goal,
IGoalRenderPos {
    public final int x;
    public final int y;
    public final int z;

    public GoalBlock(et et2) {
        this(et2.p(), et2.q(), et2.r());
    }

    public GoalBlock(int n2, int n3, int n4) {
        this.x = n2;
        this.y = n3;
        this.z = n4;
    }

    @Override
    public boolean isInGoal(int n2, int n3, int n4) {
        return n2 == this.x && n3 == this.y && n4 == this.z;
    }

    @Override
    public double heuristic(int n2, int n3, int n4) {
        return GoalBlock.calculate(n2 -= this.x, n3 -= this.y, n4 -= this.z);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        object = (GoalBlock)object;
        return this.x == ((GoalBlock)object).x && this.y == ((GoalBlock)object).y && this.z == ((GoalBlock)object).z;
    }

    public int hashCode() {
        return (int)BetterBlockPos.longHash(this.x, this.y, this.z) * 905165533;
    }

    public String toString() {
        return String.format("GoalBlock{x=%s,y=%s,z=%s}", SettingsUtil.maybeCensor(this.x), SettingsUtil.maybeCensor(this.y), SettingsUtil.maybeCensor(this.z));
    }

    @Override
    public et getGoalPos() {
        return new et(this.x, this.y, this.z);
    }

    public static double calculate(double d2, int n2, double d3) {
        return 0.0 + GoalYLevel.calculate(0, n2) + GoalXZ.calculate(d2, d3);
    }
}

