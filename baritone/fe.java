/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  et
 */
package baritone;

import baritone.a;
import baritone.api.pathing.calc.IPathingControlManager;
import baritone.api.pathing.goals.Goal;
import baritone.api.process.IBaritoneProcess;
import baritone.api.process.PathingCommand;
import baritone.api.process.PathingCommandType;
import baritone.ff;
import baritone.fg;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class fe
implements IPathingControlManager {
    public final a a;
    private final HashSet<IBaritoneProcess> a;
    private final List<IBaritoneProcess> a;
    public IBaritoneProcess a;
    public IBaritoneProcess b;
    public PathingCommand a;

    public fe(a a2) {
        this.a = a2;
        this.a = new HashSet();
        this.a = new ArrayList();
        a2.getGameEventHandler().registerEventListener(new ff(this));
    }

    @Override
    public final void registerProcess(IBaritoneProcess iBaritoneProcess) {
        iBaritoneProcess.onLostControl();
        ((HashSet)((Object)this.a)).add(iBaritoneProcess);
    }

    public final void a() {
        this.a = null;
        this.b = null;
        this.a = null;
        this.a.clear();
        Iterator iterator2 = ((HashSet)((Object)this.a)).iterator();
        while (iterator2.hasNext()) {
            IBaritoneProcess iBaritoneProcess = (IBaritoneProcess)iterator2.next();
            iBaritoneProcess.onLostControl();
            if (!iBaritoneProcess.isActive() || iBaritoneProcess.isTemporary()) continue;
            throw new IllegalStateException(iBaritoneProcess.displayName());
        }
    }

    @Override
    public final Optional<IBaritoneProcess> mostRecentInControl() {
        return Optional.ofNullable(this.b);
    }

    @Override
    public final Optional<PathingCommand> mostRecentCommand() {
        return Optional.ofNullable(this.a);
    }

    private boolean a(Goal goal) {
        Goal goal2;
        Object object = this.a.a.a;
        return object != null && (goal2 = object.getPath().getGoal()).isInGoal((et)(object = object.getPath().getDest())) && !goal.isInGoal((et)object);
    }

    public final PathingCommand a() {
        IBaritoneProcess iBaritoneProcess;
        Iterator<IBaritoneProcess> iterator2 = ((HashSet)((Object)this.a)).iterator();
        while (iterator2.hasNext()) {
            iBaritoneProcess = (IBaritoneProcess)iterator2.next();
            if (iBaritoneProcess.isActive()) {
                if (this.a.contains(iBaritoneProcess)) continue;
                this.a.add(0, iBaritoneProcess);
                continue;
            }
            this.a.remove(iBaritoneProcess);
        }
        this.a.sort(Comparator.comparingDouble(IBaritoneProcess::priority).reversed());
        iterator2 = this.a.iterator();
        while (iterator2.hasNext()) {
            PathingCommand pathingCommand = iBaritoneProcess.onTick(Objects.equals(iBaritoneProcess = (IBaritoneProcess)iterator2.next(), this.a) && this.a.a.a, this.a.a.a());
            if (pathingCommand == null) {
                if (!iBaritoneProcess.isActive()) continue;
                throw new IllegalStateException(iBaritoneProcess.displayName() + " actively returned null PathingCommand");
            }
            if (pathingCommand.commandType == PathingCommandType.DEFER) continue;
            this.b = iBaritoneProcess;
            if (!iBaritoneProcess.isTemporary()) {
                iterator2.forEachRemaining(IBaritoneProcess::onLostControl);
            }
            return pathingCommand;
        }
        return null;
    }

    /*
     * Unable to fully structure code
     */
    static /* synthetic */ void a(fe var0) {
        block10: {
            if (var0.a == null) break block10;
            var1_1 = var0.a.a;
            switch (fg.a[var0.a.commandType.ordinal()]) {
                case 4: {
                    if (var0.a.goal == null) ** GOTO lbl12
                    v0 = var0;
                    var3_2 = v0.a.goal;
                    var2_3 = v0.a.a.a;
                    if (var2_3 != null && !var3_2.isInGoal(var2_3.getPath().getDest()) ? !var3_2.equals(var2_3.getPath().getGoal()) : false) ** GOTO lbl12
                    v1 = var0;
                    if (!v1.a(v1.a.goal)) ** GOTO lbl13
lbl12:
                    // 3 sources

                    var1_1.a();
lbl13:
                    // 2 sources

                    var1_1.a(var0.a);
                    return;
                }
                case 5: {
                    if (!((Boolean)baritone.a.a().cancelOnGoalInvalidation.value).booleanValue()) ** GOTO lbl22
                    if (var0.a.goal == null) ** GOTO lbl21
                    v2 = var0;
                    if (!v2.a(v2.a.goal)) ** GOTO lbl22
lbl21:
                    // 2 sources

                    var1_1.a();
lbl22:
                    // 3 sources

                    var1_1.a(var0.a);
                }
            }
        }
    }
}

