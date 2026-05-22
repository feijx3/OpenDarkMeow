/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  et
 */
package baritone;

import baritone.a;
import baritone.api.BaritoneAPI;
import baritone.api.pathing.calc.IPath;
import baritone.api.pathing.goals.Goal;
import baritone.dj;
import baritone.ex;

public abstract class fx
implements IPath {
    @Override
    public /* synthetic */ IPath staticCutoff(Goal object) {
        Goal goal = object;
        object = this;
        int n2 = (Integer)BaritoneAPI.getSettings().pathCutoffMinimumLength.value;
        if (object.length() < n2) {
            return object;
        }
        if (goal == null || goal.isInGoal(object.getDest())) {
            return object;
        }
        double d2 = (Double)BaritoneAPI.getSettings().pathCutoffFactor.value;
        int n3 = (int)((double)(object.length() - n2) * d2) + n2 - 1;
        return new dj((IPath)object, n3);
    }

    @Override
    public /* synthetic */ IPath cutoffAtLoadedChunks(Object object) {
        Object object2 = object;
        object = this;
        if (((Boolean)a.a().cutoffAtLoadBoundary.value).booleanValue()) {
            object2 = (ex)object2;
            for (int i2 = 0; i2 < object.positions().size(); ++i2) {
                et et2 = object.positions().get(i2);
                if (((ex)object2).a(et2.p(), et2.r())) continue;
                return new dj((IPath)object, i2);
            }
        }
        return object;
    }
}

