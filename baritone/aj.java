/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.ak;
import baritone.al;
import baritone.am;
import baritone.an;
import baritone.ao;
import baritone.api.IBaritone;
import baritone.api.command.Command;

public final class aj {
    public Command a;
    public Command b;
    public Command c;
    public Command d;

    public aj(IBaritone iBaritone) {
        boolean[] blArray = new boolean[]{false};
        iBaritone.getPathingControlManager().registerProcess(new ak(this, blArray, iBaritone));
        this.a = new al(this, iBaritone, new String[]{"pause", "p", "paws"}, blArray);
        this.b = new am(this, iBaritone, new String[]{"resume", "r", "unpause", "unpaws"}, blArray);
        this.c = new an(this, iBaritone, new String[]{"paused"}, blArray);
        this.d = new ao(this, iBaritone, new String[]{"cancel", "c", "stop"}, blArray);
    }
}

