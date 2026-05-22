/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  amn
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  et
 *  it.unimi.dsi.fastutil.longs.LongOpenHashSet
 */
package baritone;

import baritone.api.cache.ICachedWorld;
import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalComposite;
import baritone.api.pathing.goals.GoalXZ;
import baritone.api.process.IExploreProcess;
import baritone.api.process.PathingCommand;
import baritone.api.process.PathingCommandType;
import baritone.api.utils.MyChunkPos;
import baritone.dy;
import baritone.dz;
import baritone.eu;
import baritone.n;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.ArrayList;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class dx
extends eu
implements IExploreProcess {
    private et a;
    private c a;
    private int a;

    public dx(baritone.a a2) {
        super(a2);
    }

    @Override
    public final boolean isActive() {
        return this.a != null;
    }

    @Override
    public final void explore(int n2, int n3) {
        this.a = new et(n2, 0, n3);
        this.a = 0;
    }

    @Override
    public final void applyJsonFilter(Path path, boolean bl2) {
        this.a = new d(this, path, bl2, 0);
    }

    private c a() {
        c c2;
        if (this.a != null) {
            dx dx2 = this;
            c2 = new b(dx2, dx2.a, new a(this, 0), 0);
        } else {
            c2 = new a(this, 0);
        }
        return c2;
    }

    @Override
    public final PathingCommand onTick(boolean bl2, boolean bl3) {
        if (bl2) {
            this.logDirect("Failed");
            if (((Boolean)baritone.a.a().notificationOnExploreFinished.value).booleanValue()) {
                this.logNotification("Exploration failed", true);
            }
            this.onLostControl();
            return null;
        }
        Goal[] goalArray = this.a();
        if (!((Boolean)baritone.a.a().disableCompletionCheck.value).booleanValue() && goalArray.a() == 0) {
            this.logDirect("Explored all chunks");
            if (((Boolean)baritone.a.a().notificationOnExploreFinished.value).booleanValue()) {
                this.logNotification("Explored all chunks", false);
            }
            this.onLostControl();
            return null;
        }
        dx dx2 = this;
        if ((goalArray = dx2.a(dx2.a, (c)goalArray)) == null) {
            this.logDebug("awaiting region load from disk");
            return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
        }
        return new PathingCommand(new GoalComposite(goalArray), PathingCommandType.FORCE_REVALIDATE_GOAL_AND_PATH);
    }

    /*
     * Enabled aggressive block sorting
     */
    private Goal[] a(et et3, c c2) {
        int n2 = et3.p() >> 4;
        int n3 = et3.r() >> 4;
        int n4 = Math.min(c2.a(), (Integer)baritone.a.a().exploreChunkSetMinimumSize.value);
        ArrayList<et> arrayList = new ArrayList<et>();
        int n5 = (Integer)baritone.a.a().worldExploringChunkOffset.value;
        int n6 = this.a;
        block5: while (true) {
            int n7 = -n6;
            while (true) {
                int n8;
                if (n7 <= n6) {
                    n8 = n6 - Math.abs(n7);
                } else {
                    if (n6 % 10 == 0) {
                        n4 = Math.min(c2.a(), (Integer)baritone.a.a().exploreChunkSetMinimumSize.value);
                    }
                    if (arrayList.size() >= n4) {
                        return (Goal[])arrayList.stream().map(et2 -> {
                            int n2 = et2.r();
                            int n3 = et2.p();
                            if ((Integer)baritone.a.a().exploreMaintainY.value == -1) {
                                return new GoalXZ(n3, n2);
                            }
                            return new dy(n3, n2);
                        }).toArray(Goal[]::new);
                    }
                    if (arrayList.isEmpty()) {
                        this.a = n6 + 1;
                    }
                    ++n6;
                    continue block5;
                }
                block7: for (int i2 = 0; i2 < 2; ++i2) {
                    int n9 = ((i2 << 1) - 1) * n8;
                    if (Math.abs(n7) + Math.abs(n9) != n6) {
                        throw new IllegalStateException();
                    }
                    switch (dz.a[c2.a(n2 + n7, n3 + n9) - 1]) {
                        case 1: {
                            return null;
                        }
                        case 2: {
                            break;
                        }
                        case 3: {
                            continue block7;
                        }
                    }
                    int n10 = (n2 + n7 << 4) + 8;
                    int n11 = (n3 + n9 << 4) + 8;
                    int n12 = n5 << 4;
                    n10 = n7 < 0 ? (n10 -= n12) : (n10 += n12);
                    n11 = n9 < 0 ? (n11 -= n12) : (n11 += n12);
                    arrayList.add(new et(n10, 0, n11));
                }
                ++n7;
            }
            break;
        }
    }

    @Override
    public final void onLostControl() {
        this.a = null;
    }

    @Override
    public final String displayName0() {
        dx dx2 = this;
        return "Exploring around " + this.a + ", distance completed " + this.a + ", currently going to " + new GoalComposite(dx2.a(dx2.a, this.a()));
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    final class b
    implements c {
        private final c a;
        private final c b;
        private /* synthetic */ dx a;

        private b(dx dx2, c c2, c c3) {
            this.a = dx2;
            this.a = c2;
            this.b = c3;
        }

        @Override
        public final int a(int n2, int n3) {
            if (this.a.a(n2, n3) == e.a) {
                return e.a;
            }
            return this.b.a(n2, n3);
        }

        @Override
        public final int a() {
            return Math.min(this.a.a(), this.b.a());
        }

        /* synthetic */ b(dx dx2, c c2, c c3, byte by2) {
            this(dx2, c2, c3);
        }
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    final class d
    implements c {
        private final boolean a;
        private final LongOpenHashSet a;
        private final MyChunkPos[] a;
        private /* synthetic */ dx a;

        private d(dx myChunkPosArray, Path path, boolean bl2) {
            this.a = myChunkPosArray;
            this.a = bl2;
            Gson gson = new GsonBuilder().create();
            this.a = (MyChunkPos[])gson.fromJson((Reader)new InputStreamReader(Files.newInputStream(path, new OpenOption[0])), MyChunkPos[].class);
            myChunkPosArray.logDirect("Loaded " + this.a.length + " positions");
            this.a = new LongOpenHashSet();
            myChunkPosArray = this.a;
            int n2 = this.a.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                MyChunkPos myChunkPos = myChunkPosArray[i2];
                this.a.add(amn.a((int)myChunkPos.x, (int)myChunkPos.z));
            }
        }

        @Override
        public final int a(int n2, int n3) {
            if (this.a.contains(amn.a((int)n2, (int)n3)) ^ this.a) {
                return e.a;
            }
            return e.c;
        }

        @Override
        public final int a() {
            if (!this.a) {
                return Integer.MAX_VALUE;
            }
            int n2 = 0;
            a a2 = new a(this.a, 0);
            MyChunkPos[] myChunkPosArray = this.a;
            int n3 = this.a.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                MyChunkPos myChunkPos = myChunkPosArray[i2];
                if (a2.a(myChunkPos.x, myChunkPos.z) == e.a || ++n2 < (Integer)baritone.a.a().exploreChunkSetMinimumSize.value) continue;
                return n2;
            }
            return n2;
        }

        /* synthetic */ d(dx dx2, Path path, boolean bl2, byte by2) {
            this(dx2, path, bl2);
        }
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    final class a
    implements c {
        private final ICachedWorld a;
        private /* synthetic */ dx a;

        private a(dx dx2) {
            this.a = dx2;
            this.a = ((dx)this.a).a.a.a().getCachedWorld();
        }

        @Override
        public final int a(int n2, int n3) {
            if (this.a.isCached(n2 <<= 4, n3 <<= 4)) {
                return e.a;
            }
            int n4 = n3;
            if (!(((n)this.a).a(n2 >> 9, n4 >> 9) != null)) {
                baritone.a.a().execute(() -> ((n)this.a).b(n2 >> 9, n3 >> 9));
                return e.c;
            }
            return e.b;
        }

        @Override
        public final int a() {
            return Integer.MAX_VALUE;
        }

        /* synthetic */ a(dx dx2, byte by2) {
            this(dx2);
        }
    }

    static interface c {
        public int a(int var1, int var2);

        public int a();
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    static final class e
    extends Enum<e> {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        private static final /* synthetic */ int[] a;

        public static int[] a() {
            return (int[])a.clone();
        }

        static {
            a = new int[]{1, 2, 3};
        }
    }
}

