/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  awt
 *  et
 */
package baritone.api.cache;

public interface IBlockTypeAccess {
    public awt getBlock(int var1, int var2, int var3);

    default public awt getBlock(et et2) {
        return this.getBlock(et2.p(), et2.q(), et2.r());
    }
}

