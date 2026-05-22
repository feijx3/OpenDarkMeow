/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.version.Ref
 *  xyz.wagyourtail.jvmdg.version.Stub
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input.Input;
import java.util.Objects;
import java.util.function.Supplier;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.version.Ref;
import xyz.wagyourtail.jvmdg.version.Stub;

@NestMembers(value={Entry.class})
public final class SingleOptionInput
implements Input {
    private final String key;
    private final Entry[] options;
    private final @Nullable Tag label;
    private int value;

    public SingleOptionInput(CompoundTag tag) {
        ListTag<CompoundTag> options = tag.getListTag("options", CompoundTag.class);
        if (options == null || options.isEmpty()) {
            throw new IllegalArgumentException(SingleOptionInput.jvmdowngrader$concat$$init$$1(String.valueOf(tag)));
        }
        this.key = tag.getString("key");
        this.options = (Entry[])options.stream().map(Entry::new).toArray(Entry[]::new);
        this.label = tag.getBoolean("label_visible", true) ? tag.get("label") : null;
        for (int i2 = 0; i2 < this.options.length; ++i2) {
            if (!this.options[i2].initial()) continue;
            if (this.value != 0) {
                throw new IllegalArgumentException(SingleOptionInput.jvmdowngrader$concat$$init$$2(String.valueOf(tag)));
            }
            this.value = i2;
        }
    }

    @Override
    public String key() {
        return this.key;
    }

    @Override
    public String asCommandSubstitution() {
        return this.options[this.value].jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_21_6to1_21_5_data_input_SingleOptionInput$Entry$get$id();
    }

    @Override
    public Tag asTag() {
        return new StringTag(this.asCommandSubstitution());
    }

    public Entry[] options() {
        return this.options;
    }

    public @Nullable Tag label() {
        return this.label;
    }

    public int value() {
        return this.value;
    }

    public void setValue(int value) {
        if (value < 0 || value >= this.options.length) {
            throw new IllegalArgumentException(SingleOptionInput.jvmdowngrader$concat$setValue$1(this.options.length - 1));
        }
        this.value = value;
    }

    public void setClampedValue(int value) {
        this.value = value < 0 ? 0 : (value >= this.options.length ? 0 : value);
    }

    private static String jvmdowngrader$concat$$init$$1(String string) {
        return "Options must not be empty in tag: " + string;
    }

    private static String jvmdowngrader$concat$$init$$2(String string) {
        return "Multiple initial options found in tag: " + string;
    }

    private static String jvmdowngrader$concat$setValue$1(int n2) {
        return "Value must be between 0 and " + n2;
    }

    @NestHost(value=SingleOptionInput.class)
    public static class Entry {
        private final String id;
        private final Tag display;
        private final boolean initial;

        public Entry(CompoundTag tag) {
            this.id = tag.getString("id");
            this.display = tag.get("display");
            this.initial = tag.getBoolean("initial", false);
        }

        public String id() {
            return this.id;
        }

        public Tag display() {
            return this.display;
        }

        public boolean initial() {
            return this.initial;
        }

        public Tag computeDisplay() {
            return Entry.jvmdg$inlined$requireNonNullElseGet(this.display, () -> new StringTag(this.id));
        }

        public String jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_21_6to1_21_5_data_input_SingleOptionInput$Entry$get$id() {
            return this.id;
        }

        public void jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_21_6to1_21_5_data_input_SingleOptionInput$Entry$set$id(String string) {
            this.id = string;
        }

        @Stub(ref=@Ref(value="Ljava/util/Objects;"))
        private static <T> T jvmdg$inlined$requireNonNullElseGet(T obj, Supplier<? extends T> defaultObjSupplier) {
            return obj != null ? obj : Objects.requireNonNull(Objects.requireNonNull(defaultObjSupplier, "supplier").get(), "supplier.get()");
        }
    }
}

