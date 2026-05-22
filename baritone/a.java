/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bib
 *  blk
 */
package baritone;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.Settings;
import baritone.api.behavior.IBehavior;
import baritone.api.event.listener.IEventBus;
import baritone.api.process.IBaritoneProcess;
import baritone.api.process.IElytraProcess;
import baritone.api.utils.IPlayerContext;
import baritone.bt;
import baritone.bu;
import baritone.d;
import baritone.do;
import baritone.dq;
import baritone.du;
import baritone.dw;
import baritone.dx;
import baritone.e;
import baritone.ea;
import baritone.ed;
import baritone.ee;
import baritone.eg;
import baritone.eh;
import baritone.es;
import baritone.ex;
import baritone.ez;
import baritone.fb;
import baritone.fe;
import baritone.fz;
import baritone.h;
import baritone.j;
import baritone.t;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class a
implements IBaritone {
    private static final ThreadPoolExecutor a = new ThreadPoolExecutor(4, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
    private final bib a;
    public final Path a;
    private final bu a;
    public final h a;
    public final e a;
    public final d a;
    public final fb a;
    private final ed a;
    private final eh a;
    private final ee a;
    private final du a;
    public final dq a;
    private final dx a;
    private final ea a;
    public final eg a;
    private final dw a;
    public final fe a;
    public final es a;
    public final bt a;
    private final IPlayerContext a;
    public final t a;
    public ex a;

    a(bib bib2) {
        this.a = bib2;
        this.a = new bu(this);
        this.a = bib2.w.toPath().resolve("baritone");
        if (!Files.exists(this.a, new LinkOption[0])) {
            try {
                Files.createDirectories(this.a, new FileAttribute[0]);
            }
            catch (IOException iOException) {}
        }
        this.a = new fz(this, bib2);
        this.a = this.a(e::new);
        this.a = this.a(h::new);
        this.a = this.a(d::new);
        this.a = this.a(fb::new);
        this.a(j::new);
        this.a = new fe(this);
        this.a = this.a(ed::new);
        this.a = this.a(eh::new);
        this.a = this.a(du::new);
        this.a = this.a(ee::new);
        this.a = this.a(dq::new);
        this.a = this.a(dx::new);
        this.a = this.a(ea::new);
        this.a = this.a(eg::new);
        this.a = this.a(dw::a);
        this.a(do::new);
        this.a = new t(this);
        this.a = new es(this);
        this.a = new bt(this);
    }

    private void a(IBehavior iBehavior) {
        this.a.registerEventListener(iBehavior);
    }

    public final <T extends IBehavior> T a(Function<a, T> object) {
        object = (IBehavior)object.apply((a)this);
        this.a((IBehavior)object);
        return (T)object;
    }

    private <T extends IBaritoneProcess> T a(Function<a, T> object) {
        object = (IBaritoneProcess)object.apply((a)this);
        this.a.registerProcess((IBaritoneProcess)object);
        return (T)object;
    }

    @Override
    public final IPlayerContext getPlayerContext() {
        return this.a;
    }

    @Override
    public final IEventBus getGameEventHandler() {
        return this.a;
    }

    @Override
    public final IElytraProcess getElytraProcess() {
        return this.a;
    }

    @Override
    public final void openClick() {
        new Thread(() -> {
            try {
                Thread.sleep(100L);
                this.a.a(() -> this.a.a((blk)new ez()));
                return;
            }
            catch (Exception exception) {
                return;
            }
        }).start();
    }

    public static Settings a() {
        return BaritoneAPI.getSettings();
    }

    public static Executor a() {
        return a;
    }
}

