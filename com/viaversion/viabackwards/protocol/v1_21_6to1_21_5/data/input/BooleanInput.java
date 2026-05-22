/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input;

import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input.Input;

public final class BooleanInput
implements Input {
    private final String key;
    private final Tag label;
    private final boolean initial;
    private final String onTrue;
    private final String onFalse;
    private boolean value;

    public BooleanInput(CompoundTag tag) {
        this.key = tag.getString("key");
        this.label = tag.get("label");
        this.initial = tag.getBoolean("initial", false);
        this.onTrue = tag.getString("on_true", "true");
        this.onFalse = tag.getString("on_false", "false");
        this.value = this.initial;
    }

    @Override
    public String key() {
        return this.key;
    }

    @Override
    public String asCommandSubstitution() {
        return this.value ? this.onTrue : this.onFalse;
    }

    @Override
    public Tag asTag() {
        return new ByteTag(this.value);
    }

    public Tag label() {
        return this.label;
    }

    public boolean initial() {
        return this.initial;
    }

    public String onTrue() {
        return this.onTrue;
    }

    public String onFalse() {
        return this.onFalse;
    }

    public boolean value() {
        return this.value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}

