/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bhb
 *  fa
 *  fq
 */
package baritone.api.selection;

import baritone.api.utils.BetterBlockPos;

public interface ISelection {
    public BetterBlockPos pos1();

    public BetterBlockPos pos2();

    public BetterBlockPos min();

    public BetterBlockPos max();

    public fq size();

    public bhb aabb();

    public ISelection expand(fa var1, int var2);

    public ISelection contract(fa var1, int var2);

    public ISelection shift(fa var1, int var2);
}

