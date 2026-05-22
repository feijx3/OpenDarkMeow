/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input;

import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.widget.Widget;

public interface Input
extends Widget {
    public String key();

    public String asCommandSubstitution();

    public Tag asTag();
}

