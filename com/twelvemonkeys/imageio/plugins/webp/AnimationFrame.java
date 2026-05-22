/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.plugins.webp;

import com.twelvemonkeys.imageio.plugins.webp.RIFFChunk;
import java.awt.Rectangle;

final class AnimationFrame
extends RIFFChunk {
    final Rectangle bounds;
    final int duration;
    final boolean blend;
    final boolean dispose;

    AnimationFrame(long l2, long l3, Rectangle rectangle, int n2, int n3) {
        super(1179471425, l2, l3);
        this.bounds = rectangle.getBounds();
        this.duration = n2;
        this.blend = (n3 & 2) == 0;
        this.dispose = (n3 & 1) != 0;
    }
}

