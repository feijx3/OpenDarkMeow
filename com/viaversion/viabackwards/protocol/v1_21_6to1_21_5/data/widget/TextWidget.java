/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.widget;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.widget.Widget;

public final class TextWidget
implements Widget {
    private final Tag label;
    private final int width;

    public TextWidget(CompoundTag tag) {
        this.label = tag.get("contents");
        this.width = tag.getInt("width", 200);
    }

    public Tag label() {
        return this.label;
    }

    public int width() {
        return this.width;
    }
}

