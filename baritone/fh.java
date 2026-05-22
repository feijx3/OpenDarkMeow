/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bub
 */
package baritone;

import baritone.api.utils.input.Input;
import baritone.fb;

public class fh
extends bub {
    private final fb a;

    fh(fb fb2) {
        this.a = fb2;
    }

    public void a() {
        this.a = (fb)0.0f;
        this.b = 0.0f;
        this.g = this.a.isInputForcedDown(Input.JUMP);
        this.c = this.a.isInputForcedDown(Input.MOVE_FORWARD);
        if (this.c) {
            this.b += 1.0f;
        }
        if (this.d = this.a.isInputForcedDown(Input.MOVE_BACK)) {
            this.b -= 1.0f;
        }
        if (this.e = this.a.isInputForcedDown(Input.MOVE_LEFT)) {
            this.a += 1.0f;
        }
        if (this.f = this.a.isInputForcedDown(Input.MOVE_RIGHT)) {
            this.a -= 1.0f;
        }
        if (this.h = this.a.isInputForcedDown(Input.SNEAK)) {
            this.a = (fb)((float)((double)this.a * 0.3));
            this.b = (float)((double)this.b * 0.3);
        }
    }
}

