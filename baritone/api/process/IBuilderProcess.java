/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  awt
 *  bib
 *  et
 *  fq
 */
package baritone.api.process;

import baritone.api.process.IBaritoneProcess;
import baritone.api.schematic.ISchematic;
import java.io.File;
import java.util.List;

public interface IBuilderProcess
extends IBaritoneProcess {
    public void build(String var1, ISchematic var2, fq var3);

    public boolean build(String var1, File var2, fq var3);

    @Deprecated
    default public boolean build(String string, et et2) {
        File file = new File(new File(bib.z().w, "schematics"), string);
        return this.build(string, file, (fq)et2);
    }

    public void buildOpenSchematic();

    public void buildOpenLitematic(int var1);

    public void pause();

    public boolean isPaused();

    public void resume();

    public void clearArea(et var1, et var2);

    public List<awt> getApproxPlaceable();
}

