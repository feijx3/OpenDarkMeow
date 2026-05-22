/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  amn
 *  aox
 *  awt
 *  axw
 *  axx
 *  bhe
 *  et
 */
package baritone;

import baritone.a;
import baritone.api.event.events.BlockChangeEvent;
import baritone.ej;
import baritone.eo;
import baritone.fk;
import baritone.fl;
import dev.babbaj.pathfinder.NetherPathfinder;
import dev.babbaj.pathfinder.Octree;
import dev.babbaj.pathfinder.PathSegment;
import java.lang.ref.SoftReference;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class em {
    private static final awt a = aox.a.t();
    public final Object a;
    final long a;
    public final long b;
    final ExecutorService a = new Object();

    public em(long l2) {
        this.a = NetherPathfinder.newContext(l2);
        this.b = l2;
        this.a = Executors.newSingleThreadExecutor();
    }

    public final void a(int n2, int n3, int n4, ej ej2) {
        this.a.execute(() -> {
            Object object = this.a;
            synchronized (object) {
                ej2.a = 0L;
                NetherPathfinder.cullFarChunks(this.a, n2, n3, n4);
                return;
            }
        });
    }

    public final void a(axw object) {
        object = new SoftReference<axw>((axw)object);
        this.a.execute(() -> this.a((SoftReference)object));
    }

    public final void a(BlockChangeEvent blockChangeEvent) {
        this.a.execute(() -> {
            amn amn2 = blockChangeEvent.getChunkPos();
            long l2 = NetherPathfinder.getChunkPointer(this.a, amn2.a, amn2.b);
            if (l2 == 0L) {
                return;
            }
            blockChangeEvent.getBlocks().forEach(pair -> {
                et et2 = (et)pair.first();
                if (et2.q() >= 128) {
                    return;
                }
                boolean bl2 = pair.second() != a;
                Octree.setBlock(l2, et2.p() & 0xF, et2.q(), et2.r() & 0xF, bl2);
            });
        });
    }

    public final CompletableFuture<PathSegment> a(et et2, et et3) {
        return CompletableFuture.supplyAsync(() -> {
            if ((et2 = NetherPathfinder.pathFind(this.a, et2.p(), et2.q(), et2.r(), et3.p(), et3.q(), et3.r(), true, false, 10000, (Boolean)baritone.a.a().elytraPredictTerrain.value == false)) == null) {
                throw new eo("Path calculation failed");
            }
            return et2;
        }, this.a);
    }

    public final boolean a(bhe bhe2, bhe bhe3) {
        return NetherPathfinder.isVisible(this.a, NetherPathfinder.CACHE_MISS_SOLID, bhe2.b, bhe2.c, bhe2.d, bhe3.b, bhe3.c, bhe3.d);
    }

    public static boolean a() {
        return NetherPathfinder.isThisSystemSupported();
    }

    private /* synthetic */ void a(SoftReference object) {
        if ((object = (axw)object.get()) != null) {
            long l2;
            long l3 = l2 = NetherPathfinder.getOrCreateChunk(this.a, object.b, object.c);
            try {
                object = object.h();
                for (int i2 = 0; i2 < 8; ++i2) {
                    axx axx2 = object[i2];
                    if (axx2 == null) continue;
                    axx2 = axx2.g();
                    int n2 = ((fl)axx2).getPalette().a(a);
                    if ((axx2 = ((fl)axx2).getStorage()) == null) continue;
                    long[] lArray = axx2.a();
                    int n3 = axx2.b();
                    int n4 = ((fk)axx2).getBitsPerEntry();
                    long l4 = ((fk)axx2).getMaxEntryValue();
                    int n5 = i2 << 4;
                    int n6 = 0;
                    int n7 = n4 - 1;
                    while (n6 < n3) {
                        int n8 = n6 * n4;
                        int n9 = n8 >> 6;
                        int n10 = n7 >> 6;
                        long l5 = lArray[n9] >>> (n8 &= 0x3F);
                        n8 = n9 == n10 ? (int)(l5 & l4) : (int)((l5 | lArray[n10] << 64 - n8) & l4);
                        n9 = n6 & 0xF;
                        n10 = n5 + (n6 >> 8);
                        int n11 = n6 >> 4 & 0xF;
                        Octree.setBlock(l3, n9, n10, n11, n8 != n2);
                        ++n6;
                        n7 += n4;
                    }
                }
                Octree.setIsFromJava(l3);
                return;
            }
            catch (Exception exception) {
                object = exception;
                exception.printStackTrace();
                throw new RuntimeException((Throwable)object);
            }
        }
    }
}

