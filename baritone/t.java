/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  amu
 *  bse
 *  org.apache.commons.lang3.SystemUtils
 *  rr
 */
package baritone;

import baritone.a;
import baritone.api.cache.IWorldData;
import baritone.api.cache.IWorldProvider;
import baritone.api.utils.IPlayerContext;
import baritone.fj;
import baritone.fn;
import baritone.s;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.apache.commons.lang3.SystemUtils;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class t
implements IWorldProvider {
    private static final Map<Path, s> a = new HashMap<Path, s>();
    private final a a;
    private final IPlayerContext a;
    private s a;
    private amu a;

    public t(a a2) {
        this.a = a2;
        this.a = a2.getPlayerContext();
    }

    public final s a() {
        this.b();
        return this.a;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void a(amu amu2) {
        Optional<rr> optional;
        block6: {
            Object object2;
            Object object3;
            block2: {
                block4: {
                    block5: {
                        block3: {
                            block1: {
                                object3 = amu2;
                                object2 = this;
                                if (!((t)object2).a.minecraft().E()) break block1;
                                int n2 = ((amu)object3).s.q().a();
                                object3 = ((fj)((fn)((t)object2).a.minecraft().F().a(n2).r()).getChunkLoader()).getChunkSaveLocation().toPath();
                                if (object3.relativize(((t)object2).a.minecraft().w.toPath()).getNameCount() != 2) {
                                    object3 = object3.getParent();
                                }
                                object2 = object3 = object3.resolve("baritone");
                                break block2;
                            }
                            object3 = ((t)object2).a.minecraft().C();
                            if (object3 == null) break block3;
                            object3 = ((bse)object3).b;
                            if (!SystemUtils.IS_OS_WINDOWS) break block4;
                            break block5;
                        }
                        System.out.println("World seems to be a replay. Not loading Baritone cache.");
                        ((t)object2).a = null;
                        ((t)object2).a = ((t)object2).a.world();
                        optional = Optional.empty();
                        break block6;
                    }
                    object3 = ((String)object3).replace(":", "_");
                }
                object3 = ((t)object2).a.a.resolve((String)object3);
                object2 = ((t)object2).a.a;
            }
            optional = Optional.of(new rr(object3, object2));
        }
        optional.ifPresent(object -> {
            Object object2 = (Path)object.a();
            object = (Path)object.b();
            try {
                Files.createDirectories((Path)object, new FileAttribute[0]);
                Files.write(object.resolve("readme.txt"), "https://github.com/cabaletta/baritone\n".getBytes(StandardCharsets.US_ASCII), new OpenOption[0]);
            }
            catch (IOException iOException) {}
            Path path2 = object2;
            object2 = amu2;
            object = path2.resolve("DIM" + ((amu)object2).s.q().a());
            try {
                Files.createDirectories((Path)object, new FileAttribute[0]);
            }
            catch (IOException iOException) {}
            System.out.println("Baritone world data dir: ".concat(String.valueOf(object)));
            object2 = a;
            synchronized (object2) {
                int n2 = amu2.s.q().a();
                this.a = a.computeIfAbsent((Path)object, path -> new s((Path)path, n2));
            }
            this.a = this.a.world();
        });
    }

    public final void a() {
        s s2 = this.a;
        this.a = null;
        this.a = null;
        if (s2 == null) {
            return;
        }
        s2.a();
    }

    private void b() {
        if (this.a != this.a.world()) {
            if (this.a != null) {
                System.out.println("mc.world unloaded unnoticed! Unloading Baritone cache now.");
                this.a();
            }
            if (this.a.world() != null) {
                System.out.println("mc.world loaded unnoticed! Loading Baritone cache now.");
                t t2 = this;
                t2.a(t2.a.world());
                return;
            }
        } else if (this.a == null && this.a.world() != null && (this.a.minecraft().E() || this.a.minecraft().C() != null)) {
            System.out.println("Retrying to load Baritone cache");
            t t3 = this;
            t3.a(t3.a.world());
        }
    }

    @Override
    public final /* synthetic */ IWorldData getCurrentWorld() {
        return this.a();
    }
}

