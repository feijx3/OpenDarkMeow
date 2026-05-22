/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.Dialog;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.Template;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input.Input;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.widget.Widget;
import com.viaversion.viaversion.util.Key;
import java.util.HashMap;
import org.checkerframework.checker.nullness.qual.Nullable;

public class Button
implements Widget {
    public static final Button DEFAULT = Button.defaulted();
    private static final String[] CLICK_EVENTS = new String[]{"open_url", "run_command", "suggest_command", "show_dialog", "change_page", "copy_to_clipboard", "custom"};
    private final Dialog dialog;
    private final Tag label;
    private final int width;
    private final @Nullable Tag tooltip;
    private @Nullable CompoundTag clickEvent;
    private @Nullable Template template;
    private @Nullable String id;
    private @Nullable CompoundTag additions;

    public Button(Dialog dialog, CompoundTag tag) {
        this.dialog = dialog;
        this.label = tag.get("label");
        this.tooltip = tag.get("tooltip");
        int width = tag.getInt("width", 150);
        if (width < 1 || width > 1024) {
            throw new IllegalArgumentException(Button.jvmdowngrader$concat$$init$$1(width));
        }
        this.width = width;
        CompoundTag actionTag = tag.getCompoundTag("action");
        if (actionTag == null) {
            return;
        }
        String type = actionTag.getString("type");
        if (type == null) {
            throw new IllegalArgumentException(Button.jvmdowngrader$concat$$init$$1(String.valueOf(tag)));
        }
        for (String event : CLICK_EVENTS) {
            if (!Key.stripMinecraftNamespace(type).equals(event)) continue;
            this.clickEvent = actionTag;
            this.clickEvent.put("action", this.clickEvent.remove("type"));
            return;
        }
        if (Key.stripMinecraftNamespace(type).equals("dynamic/run_command")) {
            this.template = Template.fromString(actionTag.getString("template"));
        } else if (Key.stripMinecraftNamespace(type).equals("dynamic/custom")) {
            this.id = actionTag.getString("id");
            this.additions = actionTag.getCompoundTag("additions");
        }
    }

    private static Button defaulted() {
        CompoundTag tag = new CompoundTag();
        CompoundTag label = new CompoundTag();
        tag.put("label", label);
        label.putString("translate", "gui.ok");
        return new Button(null, tag);
    }

    public static Button openUrl(Tag label, String url) {
        CompoundTag tag = new CompoundTag();
        CompoundTag actionTag = new CompoundTag();
        CompoundTag openUrlTag = new CompoundTag();
        tag.put("label", label);
        tag.put("action", actionTag);
        actionTag.putString("type", "open_url");
        actionTag.put("action", openUrlTag);
        openUrlTag.putString("url", url);
        return new Button(null, tag);
    }

    public @Nullable CompoundTag clickEvent() {
        if (this.clickEvent != null) {
            return this.clickEvent;
        }
        if (this.dialog == null) {
            return null;
        }
        Input[] inputs = (Input[])this.dialog.widgets().stream().filter(widget -> widget instanceof Input).toArray(Input[]::new);
        if (this.template != null) {
            HashMap<String, String> substitutions = new HashMap<String, String>();
            for (Input input : inputs) {
                substitutions.put(input.key(), input.asCommandSubstitution());
            }
            CompoundTag tag = new CompoundTag();
            tag.putString("action", "run_command");
            tag.putString("command", this.template.instantiate(substitutions));
            return tag;
        }
        if (this.id != null) {
            CompoundTag additions = this.additions != null ? this.additions.copy() : new CompoundTag();
            for (Input input : inputs) {
                additions.put(input.key(), input.asTag());
            }
            CompoundTag tag = new CompoundTag();
            tag.putString("action", "custom");
            tag.putString("id", this.id);
            tag.put("payload", additions);
            return tag;
        }
        return null;
    }

    public Tag label() {
        return this.label;
    }

    public @Nullable Tag tooltip() {
        return this.tooltip;
    }

    public int width() {
        return this.width;
    }

    private static String jvmdowngrader$concat$$init$$1(int n2) {
        return "Width must be between 1 and 1024, got: " + n2;
    }

    private static String jvmdowngrader$concat$$init$$1(String string) {
        return "Action type is missing in tag: " + string;
    }
}

