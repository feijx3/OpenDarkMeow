/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  amn
 *  aow
 *  awt
 *  axp
 *  axr
 *  axu
 *  axw
 *  axx
 *  et
 *  fd
 *  gy
 *  io.netty.buffer.Unpooled
 */
package baritone;

import baritone.api.cache.ICachedWorld;
import baritone.api.cache.IWorldScanner;
import baritone.api.utils.BlockOptionalMetaLookup;
import baritone.api.utils.IPlayerContext;
import baritone.fk;
import baritone.fl;
import io.netty.buffer.Unpooled;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class q
extends Enum<q>
implements IWorldScanner {
    public static final /* enum */ q a = new q("INSTANCE");
    private static final /* synthetic */ q[] a;

    public static q[] values() {
        return (q[])a.clone();
    }

    public static q valueOf(String string) {
        return Enum.valueOf(q.class, string);
    }

    @Override
    public final List<et> scanChunkRadius(IPlayerContext iPlayerContext, BlockOptionalMetaLookup blockOptionalMetaLookup, int n2, int n3, int n4) {
        assert (iPlayerContext.world() != null);
        if (n4 < 0) {
            throw new IllegalArgumentException("chunkRange must be >= 0");
        }
        return this.a(iPlayerContext, blockOptionalMetaLookup, q.a(iPlayerContext.playerFeet().a >> 4, iPlayerContext.playerFeet().c >> 4, n4), n2);
    }

    @Override
    public final List<et> scanChunk(IPlayerContext stream, BlockOptionalMetaLookup blockOptionalMetaLookup, amn amn2, int n2, int n3) {
        stream = q.a((IPlayerContext)((Object)stream), blockOptionalMetaLookup, amn2);
        if (n2 >= 0) {
            stream = stream.limit(n2);
        }
        return stream.collect(Collectors.toList());
    }

    @Override
    public final int repack(IPlayerContext iPlayerContext) {
        return this.repack(iPlayerContext, 40);
    }

    @Override
    public final int repack(IPlayerContext object, int n2) {
        axr axr2 = object.world().B();
        ICachedWorld iCachedWorld = object.worldData().getCachedWorld();
        object = object.playerFeet();
        int n3 = object.p() >> 4;
        int n4 = object.r() >> 4;
        int n5 = n3 - n2;
        int n6 = n4 - n2;
        n3 += n2;
        n4 += n2;
        n2 = 0;
        while (n5 <= n3) {
            for (int i2 = n6; i2 <= n4; ++i2) {
                axw axw2 = axr2.a(n5, i2);
                if (axw2 == null || axw2.f()) continue;
                ++n2;
                iCachedWorld.queueForPacking(axw2);
            }
            ++n5;
        }
        return n2;
    }

    private static List<amn> a(int n2, int n3, int n4) {
        ArrayList<amn> arrayList = new ArrayList<amn>();
        arrayList.add(new amn(n2, n3));
        for (int i2 = 1; i2 < n4; ++i2) {
            for (int i3 = 0; i3 <= i2; ++i3) {
                arrayList.add(new amn(n2 - i3, n3 - i2));
                if (i3 != 0) {
                    arrayList.add(new amn(n2 + i3, n3 - i2));
                    arrayList.add(new amn(n2 - i3, n3 + i2));
                }
                arrayList.add(new amn(n2 + i3, n3 + i2));
                if (i3 == i2) continue;
                arrayList.add(new amn(n2 - i2, n3 - i3));
                arrayList.add(new amn(n2 + i2, n3 - i3));
                if (i3 == 0) continue;
                arrayList.add(new amn(n2 - i2, n3 + i3));
                arrayList.add(new amn(n2 + i2, n3 + i3));
            }
        }
        return arrayList;
    }

    private List<et> a(IPlayerContext stream, BlockOptionalMetaLookup blockOptionalMetaLookup, List<amn> list, int n2) {
        assert (stream.world() != null);
        try {
            stream = list.parallelStream().flatMap(arg_0 -> this.b((IPlayerContext)((Object)stream), blockOptionalMetaLookup, arg_0));
            if (n2 >= 0) {
                stream = stream.limit(n2);
            }
            return stream.collect(Collectors.toList());
        }
        catch (Exception exception) {
            stream = exception;
            exception.printStackTrace();
            throw stream;
        }
    }

    private static Stream<et> a(IPlayerContext iPlayerContext, BlockOptionalMetaLookup blockOptionalMetaLookup, amn amn2) {
        axr axr2 = iPlayerContext.world().B();
        if (!axr2.e(amn2.a, amn2.b)) {
            return Stream.empty();
        }
        long l2 = (long)amn2.a << 4;
        long l3 = (long)amn2.b << 4;
        int n2 = iPlayerContext.playerFeet().b >> 4;
        return q.a(blockOptionalMetaLookup, axr2.a(amn2.a, amn2.b), l2, l3, n2).stream();
    }

    private static List<et> a(BlockOptionalMetaLookup blockOptionalMetaLookup, axw axxArray, long l2, long l3, int n2) {
        ArrayList<et> arrayList = new ArrayList<et>();
        axxArray = axxArray.h();
        int n3 = axxArray.length;
        for (int i2 = n2 - 1; i2 >= 0 || n2 < n3; ++n2, --i2) {
            if (n2 < n3) {
                q.a(blockOptionalMetaLookup, axxArray[n2], arrayList, l2, l3);
            }
            if (i2 < 0) continue;
            q.a(blockOptionalMetaLookup, axxArray[i2], arrayList, l2, l3);
        }
        return arrayList;
    }

    private static void a(BlockOptionalMetaLookup object, axx axx2, List<et> list, long l2, long l3) {
        awt awt2;
        int n2;
        Object object2;
        Object object3;
        if (axx2 == null || axx2.a()) {
            return;
        }
        axp axp2 = axx2.g();
        if (((fl)axp2).getStorage() == null) {
            return;
        }
        axp2 = ((fl)axp2).getPalette();
        boolean bl2 = false;
        if (axp2 instanceof axu) {
            object3 = aow.i;
        } else {
            gy gy2 = new gy(Unpooled.buffer());
            axp2.b(gy2);
            int n3 = gy2.g();
            object2 = new fd();
            for (n2 = 0; n2 < n3; ++n2) {
                awt2 = (awt)aow.i.a(gy2.g());
                assert (awt2 != null);
                object2.a((Object)awt2, n2);
            }
            object3 = object2;
        }
        fd fd2 = object3;
        int n4 = object3.a();
        object2 = new boolean[n4];
        for (n2 = 0; n2 < n4; ++n2) {
            awt2 = (awt)fd2.a(n2);
            if (((BlockOptionalMetaLookup)object).has(awt2)) {
                object2[n2] = true;
                bl2 = true;
                continue;
            }
            object2[n2] = false;
        }
        Object object4 = !bl2 ? new boolean[]{} : object2;
        object = object4;
        if (((boolean[])object4).length == 0) {
            return;
        }
        fd2 = ((fl)axx2.g()).getStorage();
        long[] lArray = fd2.a();
        n4 = fd2.b();
        int n5 = ((fk)fd2).getBitsPerEntry();
        long l4 = ((fk)fd2).getMaxEntryValue();
        int n6 = axx2.d();
        int n7 = 0;
        n2 = n5 - 1;
        while (n7 < n4) {
            int n8 = n7 * n5;
            int n9 = n8 >> 6;
            int n10 = n2 >> 6;
            long l5 = lArray[n9] >>> (n8 &= 0x3F);
            if (n9 == n10) {
                if (object[(int)(l5 & l4)] != false) {
                    list.add(new et((double)(l2 + (long)(n7 & 0xFF & 0xF)), (double)(n6 + (n7 >> 8)), (double)(l3 + (long)((n7 & 0xFF) >> 4))));
                }
            } else if (object[(int)((l5 | lArray[n10] << 64 - n8) & l4)] != false) {
                list.add(new et((double)(l2 + (long)(n7 & 0xFF & 0xF)), (double)(n6 + (n7 >> 8)), (double)(l3 + (long)((n7 & 0xFF) >> 4))));
            }
            ++n7;
            n2 += n5;
        }
    }

    private /* synthetic */ Stream b(IPlayerContext iPlayerContext, BlockOptionalMetaLookup blockOptionalMetaLookup, amn amn2) {
        return q.a(iPlayerContext, blockOptionalMetaLookup, amn2);
    }

    static {
        a = new q[]{a};
    }
}

