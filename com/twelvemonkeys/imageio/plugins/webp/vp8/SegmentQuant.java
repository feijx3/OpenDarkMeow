/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.plugins.webp.vp8;

import com.twelvemonkeys.imageio.plugins.webp.vp8.Globals;

final class SegmentQuant {
    private int filterStrength;
    private int Qindex;
    private int uvac;
    private int uvdc;
    private int y1ac;
    private int y1dc;
    private int y2ac;
    private int y2dc;

    SegmentQuant() {
    }

    public int getQindex() {
        return this.Qindex;
    }

    public int getUvac_delta_q() {
        return this.uvac;
    }

    public int getUvdc_delta_q() {
        return this.uvdc;
    }

    public int getY1ac() {
        return this.y1ac;
    }

    public int getY1dc() {
        return this.y1dc;
    }

    public int getY2ac_delta_q() {
        return this.y2ac;
    }

    public int getY2dc() {
        return this.y2dc;
    }

    public void setFilterStrength(int n2) {
        this.filterStrength = n2;
    }

    public void setQindex(int n2) {
        this.Qindex = n2;
    }

    public void setUvac_delta_q(int n2) {
        this.uvac = Globals.vp8AcQLookup[Globals.clamp(this.Qindex + n2, 127)];
    }

    public void setUvdc_delta_q(int n2) {
        this.uvdc = Globals.vp8DcQLookup[Globals.clamp(this.Qindex + n2, 127)];
    }

    public void setY1ac() {
        this.y1ac = Globals.vp8AcQLookup[Globals.clamp(this.Qindex, 127)];
    }

    public void setY1dc(int n2) {
        this.y1dc = Globals.vp8DcQLookup[Globals.clamp(this.Qindex + n2, 127)];
        this.setY1ac();
    }

    public void setY2ac_delta_q(int n2) {
        this.y2ac = Globals.vp8AcQLookup[Globals.clamp(this.Qindex + n2, 127)] * 155 / 100;
        if (this.y2ac < 8) {
            this.y2ac = 8;
        }
    }

    public void setY2dc(int n2) {
        this.y2dc = Globals.vp8DcQLookup[Globals.clamp(this.Qindex + n2, 127)] * 2;
    }

    public int getFilterStrength() {
        return this.filterStrength;
    }
}

