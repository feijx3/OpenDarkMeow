/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.a;
import baritone.api.cache.ICachedWorld;
import baritone.api.cache.IWaypointCollection;
import baritone.api.cache.IWorldData;
import baritone.n;
import baritone.r;
import java.nio.file.Path;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class s
implements IWorldData {
    public final n a;
    private final r a;
    private Path a;
    private int a;

    s(Path path, int n2) {
        this.a = path;
        this.a = new n(path.resolve("cache"), n2);
        this.a = new r(path.resolve("waypoints"));
        this.a = n2;
    }

    public final void a() {
        baritone.a.a().execute(() -> {
            System.out.println("Started saving the world in a new thread");
            this.a.save();
        });
    }

    @Override
    public final ICachedWorld getCachedWorld() {
        return this.a;
    }

    @Override
    public final IWaypointCollection getWaypoints() {
        return this.a;
    }
}

