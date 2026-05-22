/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.io.FilenameUtils
 */
package baritone;

import baritone.api.schematic.format.ISchematicFormat;
import baritone.gg;
import baritone.gh;
import baritone.gi;
import java.io.File;
import org.apache.commons.io.FilenameUtils;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class gf
extends Enum<gf>
implements ISchematicFormat {
    private static /* enum */ gf a = new gg();
    private static /* enum */ gf b = new gh();
    private static /* enum */ gf c = new gi();
    private final String a;
    private static final /* synthetic */ gf[] a;

    public static gf[] values() {
        return (gf[])a.clone();
    }

    public static gf valueOf(String string) {
        return Enum.valueOf(gf.class, string);
    }

    private gf(String string2) {
        this.a = string2;
    }

    @Override
    public boolean isFileType(File file) {
        return this.a.equalsIgnoreCase(FilenameUtils.getExtension((String)file.getAbsolutePath()));
    }

    /* synthetic */ gf(String string, int n2, String string2, byte by2) {
        this(string2);
    }

    static {
        a = new gf[]{a, b, c};
    }
}

