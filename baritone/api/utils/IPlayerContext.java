/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  amu
 *  arf
 *  bhc
 *  bhc$a
 *  bhe
 *  bib
 *  bud
 *  et
 */
package baritone.api.utils;

import baritone.api.cache.IWorldData;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.IPlayerController;
import baritone.api.utils.Rotation;
import java.util.Optional;

public interface IPlayerContext {
    public bib minecraft();

    public bud player();

    public IPlayerController playerController();

    public amu world();

    public IWorldData worldData();

    public bhc objectMouseOver();

    default public BetterBlockPos playerFeet() {
        BetterBlockPos betterBlockPos = new BetterBlockPos(this.player().p, this.player().q + 0.1251, this.player().r);
        try {
            if (this.world().o((et)betterBlockPos).u() instanceof arf) {
                return betterBlockPos.up();
            }
        }
        catch (NullPointerException nullPointerException) {}
        return betterBlockPos;
    }

    default public bhe playerFeetAsVec() {
        return new bhe(this.player().p, this.player().q, this.player().r);
    }

    default public bhe playerHead() {
        return new bhe(this.player().p, this.player().q + (double)this.player().by(), this.player().r);
    }

    default public bhe playerMotion() {
        return new bhe(this.player().s, this.player().t, this.player().u);
    }

    public BetterBlockPos viewerPos();

    default public Rotation playerRotations() {
        return new Rotation(this.player().v, this.player().w);
    }

    public static double eyeHeight(boolean bl2) {
        if (bl2) {
            return 1.54;
        }
        return 1.62;
    }

    default public Optional<et> getSelectedBlock() {
        bhc bhc2 = this.objectMouseOver();
        if (bhc2 != null && bhc2.a == bhc.a.b) {
            return Optional.of(bhc2.a());
        }
        return Optional.empty();
    }

    default public boolean isLookingAt(et et2) {
        return this.getSelectedBlock().equals(Optional.of(et2));
    }
}

