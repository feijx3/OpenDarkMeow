/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.FloatTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input.Input;
import com.viaversion.viabackwards.utils.ChatUtil;

public final class NumberRangeInput
implements Input {
    private final String key;
    private final Tag label;
    private final String labelFormat;
    private final float start;
    private final float end;
    private final Float initial;
    private final Float step;
    private float value;

    public NumberRangeInput(CompoundTag tag) {
        this.key = tag.getString("key");
        this.label = tag.get("label");
        this.labelFormat = tag.getString("label_format", "options.generic_value");
        this.start = tag.getFloat("start");
        this.end = tag.getFloat("end");
        this.initial = Float.valueOf(tag.getFloat("initial", (this.start + this.end) / 2.0f));
        FloatTag stepTag = tag.getFloatTag("step");
        if (stepTag != null && stepTag.asFloat() < 0.0f) {
            throw new IllegalArgumentException(NumberRangeInput.jvmdowngrader$concat$$init$$1(stepTag.asFloat()));
        }
        this.step = Float.valueOf(stepTag == null ? -1.0f : stepTag.asFloat());
        this.value = this.initial.floatValue();
    }

    @Override
    public String key() {
        return this.key;
    }

    @Override
    public String asCommandSubstitution() {
        return this.valueAsString();
    }

    @Override
    public Tag asTag() {
        return new FloatTag(this.value);
    }

    public Tag label() {
        return this.label;
    }

    public String labelFormat() {
        return this.labelFormat;
    }

    public float start() {
        return this.start;
    }

    public float end() {
        return this.end;
    }

    public float initial() {
        return this.initial.floatValue();
    }

    public float step() {
        return this.step.floatValue();
    }

    public float value() {
        return this.value;
    }

    public String valueAsString() {
        int asInt = (int)this.value;
        return (float)asInt == this.value ? Integer.toString(asInt) : Float.toString(this.value);
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void setClampedValue(float value) {
        this.value = value < this.start ? this.start : Math.min(value, this.end);
    }

    public Tag displayName() {
        return ChatUtil.translate(this.labelFormat, this.label, ChatUtil.text(this.valueAsString()));
    }

    private static String jvmdowngrader$concat$$init$$1(float f2) {
        return "Step must be non-negative, got: " + f2;
    }
}

