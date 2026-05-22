/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  axw
 *  et
 */
package baritone.api.cache;

import baritone.api.cache.ICachedRegion;
import java.util.ArrayList;

public interface ICachedWorld {
    public ICachedRegion getRegion(int var1, int var2);

    public void queueForPacking(axw var1);

    public boolean isCached(int var1, int var2);

    public ArrayList<et> getLocationsOf(String var1, int var2, int var3, int var4, int var5);

    public void reloadAllFromDisk();

    public void save();
}

