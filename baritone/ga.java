/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aed
 *  afw
 *  aip
 *  ams
 *  amu
 *  bhe
 *  bib
 *  bsb
 *  bud
 *  et
 *  fa
 *  ub
 *  ud
 */
package baritone;

import baritone.api.utils.IPlayerController;
import baritone.fs;

public final class ga
implements IPlayerController {
    private final bib a;

    public ga(bib bib2) {
        this.a = bib2;
    }

    @Override
    public final void syncHeldItem() {
        ((fs)this.a.c).callSyncCurrentPlayItem();
    }

    @Override
    public final boolean hasBrokenBlock() {
        return ((fs)this.a.c).getCurrentBlock().q() == -1;
    }

    @Override
    public final boolean onPlayerDamageBlock(et et2, fa fa2) {
        return this.a.c.b(et2, fa2);
    }

    @Override
    public final void resetBlockRemoving() {
        this.a.c.c();
    }

    @Override
    public final aip windowClick(int n2, int n3, int n4, afw afw2, aed aed2) {
        return this.a.c.a(n2, n3, n4, afw2, aed2);
    }

    @Override
    public final ams getGameType() {
        return this.a.c.l();
    }

    @Override
    public final ud processRightClickBlock(bud bud2, amu amu2, et et2, fa fa2, bhe bhe2, ub ub2) {
        return this.a.c.a(bud2, (bsb)amu2, et2, fa2, bhe2, ub2);
    }

    @Override
    public final ud processRightClick(bud bud2, amu amu2, ub ub2) {
        return this.a.c.a((aed)bud2, amu2, ub2);
    }

    @Override
    public final boolean clickBlock(et et2, fa fa2) {
        return this.a.c.a(et2, fa2);
    }

    @Override
    public final void setHittingBlock(boolean bl2) {
        ((fs)this.a.c).setIsHittingBlock(bl2);
    }
}

