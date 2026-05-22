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
 *  bud
 *  et
 *  fa
 *  ub
 *  ud
 */
package baritone.api.utils;

import baritone.api.BaritoneAPI;

public interface IPlayerController {
    public void syncHeldItem();

    public boolean hasBrokenBlock();

    public boolean onPlayerDamageBlock(et var1, fa var2);

    public void resetBlockRemoving();

    public aip windowClick(int var1, int var2, int var3, afw var4, aed var5);

    public ams getGameType();

    public ud processRightClickBlock(bud var1, amu var2, et var3, fa var4, bhe var5, ub var6);

    public ud processRightClick(bud var1, amu var2, ub var3);

    public boolean clickBlock(et var1, fa var2);

    public void setHittingBlock(boolean var1);

    default public double getBlockReachDistance() {
        if (this.getGameType().d()) {
            return 5.0;
        }
        return ((Float)BaritoneAPI.getSettings().blockReachDistance.value).floatValue();
    }
}

