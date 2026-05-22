/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  amu
 *  bhc
 *  bib
 *  bud
 *  et
 *  vg
 */
package baritone;

import baritone.a;
import baritone.api.cache.IWorldData;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.IPlayerContext;
import baritone.api.utils.IPlayerController;
import baritone.api.utils.RayTraceUtils;
import baritone.api.utils.Rotation;
import baritone.e;
import baritone.ga;
import java.util.Optional;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class fz
implements IPlayerContext {
    private final a a;
    private final bib a;
    private final IPlayerController a;

    public fz(a a2, bib bib2) {
        this.a = a2;
        this.a = bib2;
        this.a = new ga(bib2);
    }

    @Override
    public final bib minecraft() {
        return this.a;
    }

    @Override
    public final bud player() {
        return this.a.h;
    }

    @Override
    public final IPlayerController playerController() {
        return this.a;
    }

    @Override
    public final amu world() {
        return this.a.f;
    }

    @Override
    public final IWorldData worldData() {
        return this.a.a.a();
    }

    @Override
    public final BetterBlockPos viewerPos() {
        vg vg2 = this.a.aa();
        if (vg2 == null) {
            return this.playerFeet();
        }
        return BetterBlockPos.from(new et(vg2));
    }

    @Override
    public final Rotation playerRotations() {
        e e2 = this.a.a;
        return ((Boolean)baritone.a.a().freeLook.value != false ? Optional.ofNullable(e2.a) : Optional.empty()).orElseGet(() -> IPlayerContext.super.playerRotations());
    }

    @Override
    public final bhc objectMouseOver() {
        return RayTraceUtils.rayTraceTowards((vg)this.player(), this.playerRotations(), this.playerController().getBlockReachDistance());
    }
}

