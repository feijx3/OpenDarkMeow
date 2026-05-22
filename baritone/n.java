/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  amn
 *  axw
 *  com.google.common.cache.CacheBuilder
 *  et
 *  it.unimi.dsi.fastutil.longs.Long2ObjectMap
 */
package baritone;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.cache.ICachedRegion;
import baritone.api.cache.ICachedWorld;
import baritone.api.cache.IWorldData;
import baritone.api.utils.Helper;
import baritone.l;
import baritone.m;
import baritone.o;
import com.google.common.cache.CacheBuilder;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class n
implements ICachedWorld,
Helper {
    private Long2ObjectMap<m> a;
    private final String a;
    private final LinkedBlockingQueue<amn> a;
    private final Map<amn, axw> a;
    private final int a = CacheBuilder.newBuilder().softValues().build().asMap();

    n(Path path, int n2) {
        if (!Files.exists(path, new LinkOption[0])) {
            try {
                Files.createDirectories(path, new FileAttribute[0]);
            }
            catch (IOException iOException) {}
        }
        this.a = path.toString();
        this.a = n2;
        System.out.println("Cached world directory: ".concat(String.valueOf(path)));
        baritone.a.a().execute(new a(this, 0));
        baritone.a.a().execute(() -> {
            try {
                Thread.sleep(30000L);
                while (true) {
                    this.save();
                    Thread.sleep(600000L);
                }
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
                return;
            }
        });
    }

    @Override
    public final void queueForPacking(axw axw2) {
        if (this.a.put(axw2.k(), axw2) == null) {
            this.a.add((m)axw2.k());
        }
    }

    @Override
    public final boolean isCached(int n2, int n3) {
        m m2 = this.a(n2 >> 9, n3 >> 9);
        if (m2 == null) {
            return false;
        }
        return m2.isCached(n2 & 0x1FF, n3 & 0x1FF);
    }

    @Override
    public final ArrayList<et> getLocationsOf(String string, int n2, int n3, int n4, int n5) {
        ArrayList<et> arrayList = new ArrayList<et>();
        n3 >>= 9;
        n4 >>= 9;
        for (int i2 = 0; i2 <= n5; ++i2) {
            for (int i3 = -i2; i3 <= i2; ++i3) {
                for (int i4 = -i2; i4 <= i2; ++i4) {
                    int n6;
                    int n7;
                    m m2;
                    int n8 = i3;
                    int n9 = i4;
                    if (n8 * n8 + n9 * n9 != i2 || (m2 = this.b(n7 = i3 + n3, n6 = i4 + n4)) == null) continue;
                    arrayList.addAll(m2.a(string));
                }
            }
            if (arrayList.size() < n2) continue;
            return arrayList;
        }
        return arrayList;
    }

    @Override
    public final void save() {
        if (!((Boolean)baritone.a.a().chunkCaching.value).booleanValue()) {
            System.out.println("Not saving to disk; chunk caching is disabled.");
            this.a().forEach(m2 -> {
                if (m2 != null) {
                    m2.a();
                }
            });
            this.a();
            return;
        }
        long l2 = System.nanoTime() / 1000000L;
        this.a().parallelStream().forEach(m2 -> {
            if (m2 != null) {
                m2.a(this.a);
            }
        });
        long l3 = System.nanoTime() / 1000000L;
        System.out.println("World save took " + (l3 - l2) + "ms");
        this.a();
    }

    private synchronized void a() {
        et et2;
        Object object;
        block5: {
            if (!((Boolean)baritone.a.a().pruneRegionsFromRAM.value).booleanValue()) {
                return;
            }
            object = this;
            for (IBaritone object2 : BaritoneAPI.getProvider().getAllBaritones()) {
                IWorldData iWorldData = object2.getWorldProvider().getCurrentWorld();
                if (iWorldData == null || iWorldData.getCachedWorld() != object || object2.getPlayerContext().player() == null) continue;
                et2 = object2.getPlayerContext().playerFeet();
                break block5;
            }
            Object object4 = null;
            for (m m2 : ((n)object).a()) {
                if (m2 == null || (object = m2.a()) == null || object4 != null && ((l)object4).a >= ((l)object).a) continue;
                object4 = object;
            }
            et2 = object4 == null ? new et(0, 0, 0) : new et((((l)object4).a << 4) + 8, 0, (((l)object4).b << 4) + 8);
        }
        object = et2;
        for (m m3 : this.a()) {
            if (m3 == null) continue;
            int n2 = (m3.getX() << 9) + 256 - object.p();
            int n3 = (m3.getZ() << 9) + 256 - object.r();
            int n4 = n2;
            int n5 = n3;
            if (!(Math.sqrt(n4 * n4 + n5 * n5) > 1024.0)) continue;
            if (!((Boolean)baritone.a.a().censorCoordinates.value).booleanValue()) {
                this.logDebug("Deleting cached region " + m3.getX() + "," + m3.getZ() + " from ram");
            }
            this.a.remove(n.a(m3.getX(), m3.getZ()));
        }
    }

    private synchronized List<m> a() {
        return new ArrayList<m>((Collection<m>)this.a.values());
    }

    @Override
    public final void reloadAllFromDisk() {
        long l2 = System.nanoTime() / 1000000L;
        this.a().forEach(m2 -> {
            if (m2 != null) {
                m2.b(this.a);
            }
        });
        long l3 = System.nanoTime() / 1000000L;
        System.out.println("World load took " + (l3 - l2) + "ms");
    }

    public final synchronized m a(int n2, int n3) {
        return (m)this.a.get(n.a(n2, n3));
    }

    public final synchronized m b(int n2, int n3) {
        return (m)this.a.computeIfAbsent((Object)n.a(n2, n3), l2 -> {
            m m2 = new m(n2, n3, this.a);
            m2.b(this.a);
            return m2;
        });
    }

    private static long a(int n2, int n3) {
        if (!n.a(n2, n3)) {
            return 0L;
        }
        return (long)n2 & 0xFFFFFFFFL | ((long)n3 & 0xFFFFFFFFL) << 32;
    }

    private static boolean a(int n2, int n3) {
        return n2 <= 58594 && n2 >= -58594 && n3 <= 58594 && n3 >= -58594;
    }

    @Override
    public final /* synthetic */ ICachedRegion getRegion(int n2, int n3) {
        return this.a(n2, n3);
    }

    static /* synthetic */ void a(n n2, l l2) {
        n2.b(l2.a >> 5, l2.b >> 5).a(l2.a & 0x1F, l2.b & 0x1F, l2);
    }

    final class a
    implements Runnable {
        private /* synthetic */ n a;

        private a(n n2) {
            this.a = n2;
        }

        @Override
        public final void run() {
            while (true) {
                try {
                    while (true) {
                        Object object = (amn)this.a.a.take();
                        object = (axw)this.a.a.remove(object);
                        if (this.a.a.size() > (Integer)baritone.a.a().chunkPackerQueueMaxSize.value) continue;
                        object = o.a((axw)object);
                        n.a(this.a, (l)object);
                    }
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                    return;
                }
                catch (Throwable throwable) {
                    throwable.printStackTrace();
                    continue;
                }
                break;
            }
        }

        /* synthetic */ a(n n2, byte by2) {
            this(n2);
        }
    }
}

