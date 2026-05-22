/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.api.command.ICommandSystem;
import baritone.api.command.argparser.IArgParserManager;
import baritone.w;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class u
extends Enum<u>
implements ICommandSystem {
    public static final /* enum */ u a = new u("INSTANCE");
    private static final /* synthetic */ u[] a;

    public static u[] values() {
        return (u[])a.clone();
    }

    public static u valueOf(String string) {
        return Enum.valueOf(u.class, string);
    }

    @Override
    public final IArgParserManager getParserManager() {
        return w.a;
    }

    static {
        a = new u[]{a};
    }
}

