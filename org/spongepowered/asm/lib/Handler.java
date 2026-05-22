/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib;

import org.spongepowered.asm.lib.Label;

class Handler {
    Label start;
    Label end;
    Label handler;
    String desc;
    int type;
    Handler next;

    Handler() {
    }

    static Handler remove(Handler h2, Label start, Label end) {
        int e2;
        if (h2 == null) {
            return null;
        }
        h2.next = Handler.remove(h2.next, start, end);
        int hstart = h2.start.position;
        int hend = h2.end.position;
        int s2 = start.position;
        int n2 = e2 = end == null ? Integer.MAX_VALUE : end.position;
        if (s2 < hend && e2 > hstart) {
            if (s2 <= hstart) {
                if (e2 >= hend) {
                    h2 = h2.next;
                } else {
                    h2.start = end;
                }
            } else if (e2 >= hend) {
                h2.end = start;
            } else {
                Handler g2 = new Handler();
                g2.start = end;
                g2.end = h2.end;
                g2.handler = h2.handler;
                g2.desc = h2.desc;
                g2.type = h2.type;
                g2.next = h2.next;
                h2.end = start;
                h2.next = g2;
            }
        }
        return h2;
    }
}

