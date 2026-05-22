/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input.Input;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={MultilineOptions.class})
public final class TextInput
implements Input {
    private final String key;
    private final @Nullable Tag label;
    private final String initial;
    private final int maxLength;
    private final @Nullable MultilineOptions[] options;
    private String value;

    public TextInput(CompoundTag tag) {
        this.key = tag.getString("key");
        this.label = tag.getBoolean("label_visible", true) ? tag.get("label") : null;
        this.initial = tag.getString("initial", "");
        this.maxLength = tag.getInt("max_length", 32);
        if (this.maxLength < 1) {
            throw new IllegalArgumentException(TextInput.jvmdowngrader$concat$$init$$1(this.maxLength));
        }
        ListTag<CompoundTag> multilineList = tag.getListTag("multiline", CompoundTag.class);
        this.options = multilineList != null && !multilineList.isEmpty() ? (MultilineOptions[])multilineList.stream().map(MultilineOptions::new).toArray(MultilineOptions[]::new) : null;
        this.value = this.initial;
    }

    @Override
    public String key() {
        return this.key;
    }

    @Override
    public String asCommandSubstitution() {
        return this.value;
    }

    @Override
    public Tag asTag() {
        return new StringTag(this.value);
    }

    public @Nullable Tag label() {
        return this.label;
    }

    public String initial() {
        return this.initial;
    }

    public int maxLength() {
        return this.maxLength;
    }

    public @Nullable MultilineOptions[] options() {
        return this.options;
    }

    public String value() {
        return this.value;
    }

    public void setValue(String value) {
        if (value.length() > this.maxLength) {
            throw new IllegalArgumentException(TextInput.jvmdowngrader$concat$setValue$1(this.maxLength, value));
        }
        this.value = value;
    }

    public void setClampedValue(String value) {
        this.value = value.length() > this.maxLength ? value.substring(0, this.maxLength) : value;
    }

    private static String jvmdowngrader$concat$$init$$1(int n2) {
        return "Max length must be at least 1, got: " + n2;
    }

    private static String jvmdowngrader$concat$setValue$1(int n2, String string) {
        return "Value exceeds max length of " + n2 + ": " + string;
    }

    @NestHost(value=TextInput.class)
    public static class MultilineOptions {
        private final @Nullable Integer maxLines;

        public MultilineOptions(CompoundTag tag) {
            IntTag maxLinesTag = tag.getIntTag("max_lines");
            if (maxLinesTag != null && maxLinesTag.asInt() < 1) {
                throw new IllegalArgumentException(MultilineOptions.jvmdowngrader$concat$$init$$1(String.valueOf(maxLinesTag)));
            }
            this.maxLines = maxLinesTag != null ? Integer.valueOf(maxLinesTag.asInt()) : null;
        }

        public @Nullable Integer maxLines() {
            return this.maxLines;
        }

        private static String jvmdowngrader$concat$$init$$1(String string) {
            return "Max lines must be at least 1, got: " + string;
        }
    }
}

