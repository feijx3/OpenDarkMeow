/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.plugins.webp.vp8;

import com.twelvemonkeys.imageio.plugins.webp.vp8.BoolDecoder;
import com.twelvemonkeys.imageio.plugins.webp.vp8.DeltaQ;
import com.twelvemonkeys.imageio.plugins.webp.vp8.SegmentQuant;
import java.io.IOException;

final class SegmentQuants {
    private int qIndex;
    private final SegmentQuant[] segQuants = new SegmentQuant[4];

    public SegmentQuants() {
        for (int i2 = 0; i2 < 4; ++i2) {
            this.segQuants[i2] = new SegmentQuant();
        }
    }

    private static DeltaQ get_delta_q(BoolDecoder boolDecoder, int n2) throws IOException {
        DeltaQ deltaQ = new DeltaQ();
        deltaQ.v = 0;
        deltaQ.update = false;
        if (boolDecoder.readBit() > 0) {
            deltaQ.v = boolDecoder.readLiteral(4);
            if (boolDecoder.readBit() > 0) {
                deltaQ.v = -deltaQ.v;
            }
        }
        if (deltaQ.v != n2) {
            deltaQ.update = true;
        }
        return deltaQ;
    }

    public int getqIndex() {
        return this.qIndex;
    }

    public SegmentQuant[] getSegQuants() {
        return this.segQuants;
    }

    public void parse(BoolDecoder boolDecoder, boolean bl2, boolean bl3) throws IOException {
        this.qIndex = boolDecoder.readLiteral(7);
        boolean bl4 = false;
        DeltaQ deltaQ = SegmentQuants.get_delta_q(boolDecoder, 0);
        int n2 = deltaQ.v;
        bl4 = bl4 || deltaQ.update;
        deltaQ = SegmentQuants.get_delta_q(boolDecoder, 0);
        int n3 = deltaQ.v;
        bl4 = bl4 || deltaQ.update;
        deltaQ = SegmentQuants.get_delta_q(boolDecoder, 0);
        int n4 = deltaQ.v;
        bl4 = bl4 || deltaQ.update;
        deltaQ = SegmentQuants.get_delta_q(boolDecoder, 0);
        int n5 = deltaQ.v;
        bl4 = bl4 || deltaQ.update;
        deltaQ = SegmentQuants.get_delta_q(boolDecoder, 0);
        int n6 = deltaQ.v;
        bl4 = bl4 || deltaQ.update;
        for (SegmentQuant segmentQuant : this.segQuants) {
            if (!bl2) {
                segmentQuant.setQindex(this.qIndex);
            } else if (!bl3) {
                segmentQuant.setQindex(segmentQuant.getQindex() + this.qIndex);
            }
            segmentQuant.setY1dc(n2);
            segmentQuant.setY2dc(n3);
            segmentQuant.setY2ac_delta_q(n4);
            segmentQuant.setUvdc_delta_q(n5);
            segmentQuant.setUvac_delta_q(n6);
        }
    }
}

