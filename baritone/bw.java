/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap
 */
package baritone;

import baritone.a;
import baritone.api.pathing.calc.IPath;
import baritone.api.pathing.calc.IPathFinder;
import baritone.api.pathing.goals.Goal;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.Helper;
import baritone.api.utils.PathCalculationResult;
import baritone.bx;
import baritone.bz;
import baritone.o;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import java.util.Optional;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class bw
implements IPathFinder,
Helper {
    protected final int a;
    protected final int b;
    protected final int c;
    protected final Goal a;
    private final bz a;
    final Long2ObjectOpenHashMap<o> a;
    protected o a;
    protected o b;
    protected final o[] a;
    private volatile boolean b;
    protected boolean a = new o[7];
    protected static final double[] a = new double[]{1.5, 2.0, 2.5, 3.0, 4.0, 5.0, 10.0};

    bw(int n2, int n3, int n4, Goal goal, bz bz2) {
        this.a = n2;
        this.b = n3;
        this.c = n4;
        this.a = goal;
        this.a = bz2;
        this.a = (int)new Long2ObjectOpenHashMap(((Integer)baritone.a.a().pathingMapDefaultSize.value).intValue(), ((Float)baritone.a.a().pathingMapLoadFactor.value).floatValue());
    }

    public void a() {
        this.a = true;
    }

    @Override
    public synchronized PathCalculationResult calculate(long l2, long l3) {
        if (this.b) {
            throw new IllegalStateException("Path finder cannot be reused!");
        }
        this.a = false;
        try {
            Object object = this.a(l2, l3).map(IPath::postProcess).orElse(null);
            if (this.a) {
                PathCalculationResult pathCalculationResult = new PathCalculationResult(PathCalculationResult.Type.CANCELLATION);
                return pathCalculationResult;
            }
            if (object == null) {
                PathCalculationResult pathCalculationResult = new PathCalculationResult(PathCalculationResult.Type.FAILURE);
                return pathCalculationResult;
            }
            int n2 = object.length();
            if ((object = object.cutoffAtLoadedChunks(this.a.a)).length() < n2) {
                Helper.HELPER.logDebug("Cutting off path at edge of loaded chunks");
                Helper.HELPER.logDebug("Length decreased by " + (n2 - object.length()));
            } else {
                Helper.HELPER.logDebug("Path ends within loaded chunks");
            }
            n2 = object.length();
            object = object.staticCutoff(this.a);
            if (object.length() < n2) {
                Helper.HELPER.logDebug("Static cutoff " + n2 + " to " + object.length());
            }
            if (this.a.isInGoal(object.getDest())) {
                object = new PathCalculationResult(PathCalculationResult.Type.SUCCESS_TO_GOAL, (IPath)object);
                return object;
            }
            object = new PathCalculationResult(PathCalculationResult.Type.SUCCESS_SEGMENT, (IPath)object);
            return object;
        }
        catch (Exception exception) {
            Helper.HELPER.logDirect("Pathing exception: ".concat(String.valueOf(exception)));
            exception.printStackTrace();
            PathCalculationResult pathCalculationResult = new PathCalculationResult(PathCalculationResult.Type.EXCEPTION);
            return pathCalculationResult;
        }
        finally {
            this.b = true;
        }
    }

    protected abstract Optional<IPath> a(long var1, long var3);

    protected final double a(o o2) {
        int n2 = o2.a - this.a;
        int n3 = o2.b - this.b;
        int n4 = o2.c - this.c;
        int n5 = n2;
        int n6 = n3;
        int n7 = n4;
        return n5 * n5 + n6 * n6 + n7 * n7;
    }

    protected final o a(int n2, int n3, int n4, long l2) {
        o o2 = (o)this.a.get(l2);
        if (o2 == null) {
            o2 = new o(n2, n3, n4, this.a);
            this.a.put(l2, (Object)o2);
        }
        return o2;
    }

    @Override
    public Optional<IPath> pathToMostRecentNodeConsidered() {
        return Optional.ofNullable(this.b).map(o2 -> new bx(this.a, (o)o2, 0, this.a, this.a));
    }

    @Override
    public Optional<IPath> bestPathSoFar() {
        return this.a(false, 0);
    }

    protected final Optional<IPath> a(boolean bl2, int n2) {
        if (this.a == null) {
            return Optional.empty();
        }
        double d2 = 0.0;
        for (int i2 = 0; i2 < 7; ++i2) {
            double d3;
            if (this.a[i2] == null) continue;
            bw bw2 = this;
            double d4 = bw2.a(bw2.a[i2]);
            if (d3 > d2) {
                d2 = d4;
            }
            if (!(d4 > 25.0)) continue;
            if (bl2) {
                if (a[i2] >= 3.0) {
                    System.out.println("Warning: cost coefficient is greater than three! Probably means that");
                    System.out.println("the path I found is pretty terrible (like sneak-bridging for dozens of blocks)");
                    System.out.println("But I'm going to do it anyway, because yolo");
                }
                System.out.println("Path goes for " + Math.sqrt(d4) + " blocks");
                this.logDebug("A* cost coefficient " + a[i2]);
            }
            return Optional.of(new bx(this.a, this.a[i2], n2, this.a, this.a));
        }
        if (bl2) {
            this.logDebug("Even with a cost coefficient of " + a[6] + ", I couldn't get more than " + Math.sqrt(d2) + " blocks");
            this.logDebug("No path found =(");
            this.logNotification("No path found =(", true);
        }
        return Optional.empty();
    }

    @Override
    public final boolean isFinished() {
        return this.b;
    }

    @Override
    public final Goal getGoal() {
        return this.a;
    }

    public final BetterBlockPos a() {
        return new BetterBlockPos(this.a, this.b, this.c);
    }
}

