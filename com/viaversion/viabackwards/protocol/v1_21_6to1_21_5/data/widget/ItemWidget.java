/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.widget;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.widget.TextWidget;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.widget.Widget;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class ItemWidget
implements Widget {
    private final CompoundTag item;
    private final @Nullable TextWidget description;
    private final boolean showTooltip;
    private final int width;
    private final int height;

    public ItemWidget(CompoundTag tag) {
        this.item = tag.getCompoundTag("item");
        if (this.item == null) {
            throw new IllegalArgumentException(ItemWidget.jvmdowngrader$concat$$init$$1(String.valueOf(tag)));
        }
        this.description = tag.contains("description") ? new TextWidget(tag.getCompoundTag("description")) : null;
        this.showTooltip = tag.getBoolean("show_tooltip", true);
        int width = tag.getInt("width", 16);
        int height = tag.getInt("height", 16);
        if (width < 1 || width > 256) {
            throw new IllegalArgumentException(ItemWidget.jvmdowngrader$concat$$init$$1(width));
        }
        if (height < 1 || height > 256) {
            throw new IllegalArgumentException(ItemWidget.jvmdowngrader$concat$$init$$2(height));
        }
        this.width = width;
        this.height = height;
    }

    public CompoundTag item() {
        return this.item;
    }

    public @Nullable TextWidget description() {
        return this.description;
    }

    public boolean showTooltip() {
        return this.showTooltip;
    }

    public int width() {
        return this.width;
    }

    public int height() {
        return this.height;
    }

    private static String jvmdowngrader$concat$$init$$1(String string) {
        return "Item tag is missing in ItemWidget tag: " + string;
    }

    private static String jvmdowngrader$concat$$init$$1(int n2) {
        return "Width must be between 1 and 256, got: " + n2;
    }

    private static String jvmdowngrader$concat$$init$$2(int n2) {
        return "Height must be between 1 and 256, got: " + n2;
    }
}

