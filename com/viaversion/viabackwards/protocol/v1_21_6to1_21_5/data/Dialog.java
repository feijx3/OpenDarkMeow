/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data;

import ViaBackwards.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_U_S_Stream;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.Button;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input.BooleanInput;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input.Input;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input.NumberRangeInput;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input.SingleOptionInput;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input.TextInput;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.widget.ItemWidget;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.widget.TextWidget;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.widget.Widget;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.storage.RegistryAndTags;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.storage.ServerLinks;
import com.viaversion.viaversion.util.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={AfterAction.class})
public final class Dialog
implements Widget {
    private final List<Widget> widgets = new ArrayList<Widget>();
    private final Tag title;
    private final @Nullable Tag externalTitle;
    private final boolean canCloseWithEscape;
    private final AfterAction afterAction;
    private @Nullable Button actionButton;
    private @Nullable Button yesButton;
    private @Nullable Button noButton;
    private int columns;
    private int buttonWidth;

    public Dialog(RegistryAndTags registryAndTags, ServerLinks serverLinks, CompoundTag tag) {
        ListTag<CompoundTag> inputListTag;
        Object bodyTag;
        String type = tag.getString("type");
        if (type == null) {
            throw new IllegalArgumentException(Dialog.jvmdowngrader$concat$$init$$1(String.valueOf(tag)));
        }
        this.title = tag.get("title");
        this.externalTitle = tag.get("external_title");
        this.canCloseWithEscape = tag.getBoolean("can_close_with_escape", true);
        this.afterAction = AfterAction.valueOf(tag.getString("after_action", "close").toUpperCase(Locale.ROOT));
        ListTag<CompoundTag> bodyListTag = tag.getListTag("body", CompoundTag.class);
        if (bodyListTag == null && (bodyTag = tag.getCompoundTag("body")) != null) {
            bodyListTag = new ListTag<CompoundTag>(CompoundTag.class);
            bodyListTag.add((CompoundTag)bodyTag);
        }
        if (bodyListTag != null) {
            for (CompoundTag bodyTag2 : bodyListTag) {
                this.fillBodyWidget(bodyTag2);
            }
        }
        if ((inputListTag = tag.getListTag("inputs", CompoundTag.class)) != null) {
            for (CompoundTag inputTag : inputListTag) {
                this.fillInputWidget(inputTag);
            }
        }
        switch (Key.stripMinecraftNamespace(type)) {
            case "notice": {
                this.fillNoticeDialog(tag);
                break;
            }
            case "server_links": {
                this.fillServerLinksDialog(serverLinks, tag);
                break;
            }
            case "dialog_list": {
                this.fillDialogList(registryAndTags, serverLinks, tag);
                break;
            }
            case "multi_action": {
                this.fillMultiActionDialog(tag);
                break;
            }
            case "confirmation": {
                this.fillConfirmationDialog(tag);
                break;
            }
            default: {
                throw new IllegalArgumentException(Dialog.jvmdowngrader$concat$$init$$1(type, String.valueOf(tag)));
            }
        }
    }

    private void fillBodyWidget(CompoundTag tag) {
        String type = tag.getString("type");
        if (type == null) {
            throw new IllegalArgumentException(Dialog.jvmdowngrader$concat$$init$$1(String.valueOf(tag)));
        }
        if (Key.stripMinecraftNamespace(type).equals("plain_message")) {
            this.widgets.add(new TextWidget(tag));
        } else if (Key.stripMinecraftNamespace(type).equals("item")) {
            this.widgets.add(new ItemWidget(tag));
        } else {
            throw new IllegalArgumentException(Dialog.jvmdowngrader$concat$fillBodyWidget$1(type, String.valueOf(tag)));
        }
    }

    private void fillInputWidget(CompoundTag tag) {
        Input input;
        String type = tag.getString("type");
        if (type == null) {
            throw new IllegalArgumentException(Dialog.jvmdowngrader$concat$$init$$1(String.valueOf(tag)));
        }
        switch (Key.stripMinecraftNamespace(type)) {
            case "boolean": {
                input = new BooleanInput(tag);
                break;
            }
            case "number_range": {
                input = new NumberRangeInput(tag);
                break;
            }
            case "single_option": {
                input = new SingleOptionInput(tag);
                break;
            }
            case "text": {
                input = new TextInput(tag);
                break;
            }
            default: {
                throw new IllegalArgumentException(Dialog.jvmdowngrader$concat$fillInputWidget$1(type, String.valueOf(tag)));
            }
        }
        this.widgets.add(input);
    }

    private void fillNoticeDialog(CompoundTag tag) {
        CompoundTag actionTag = tag.getCompoundTag("action");
        this.actionButton = actionTag == null ? Button.DEFAULT : this.actionButton;
    }

    private void fillServerLinksDialog(ServerLinks serverLinks, CompoundTag tag) {
        this.fillDialogBase(tag);
        this.buttonWidth = tag.getInt("button_width", 150);
        if (serverLinks == null) {
            return;
        }
        for (Map.Entry entry : serverLinks.links().entrySet()) {
            Tag label = (Tag)entry.getKey();
            String url = (String)entry.getValue();
            this.widgets.add(Button.openUrl(label, url));
        }
    }

    private void fillDialogList(RegistryAndTags registryAndTags, ServerLinks serverLinks, CompoundTag tag) {
        ListTag<CompoundTag> dialogsTag = tag.getListTag("dialogs", CompoundTag.class);
        if (dialogsTag == null) {
            StringTag registryDialogTag;
            CompoundTag dialogTag = tag.getCompoundTag("dialogs");
            if (dialogTag != null) {
                dialogsTag = new ListTag<CompoundTag>(CompoundTag.class);
                dialogsTag.add(dialogTag);
            }
            if ((registryDialogTag = tag.getStringTag("dialogs")) != null) {
                dialogsTag = new ListTag<CompoundTag>(CompoundTag.class);
                String key = registryDialogTag.getValue();
                if (key.startsWith("#")) {
                    for (CompoundTag entry : registryAndTags.fromRegistryKey(key.substring(1))) {
                        dialogsTag.add(entry);
                    }
                } else {
                    dialogsTag.add(registryAndTags.fromRegistry(key));
                }
            }
        }
        this.widgets.addAll(J_U_S_Stream.toList(dialogsTag.stream().map(dialog -> new Dialog(registryAndTags, serverLinks, (CompoundTag)dialog))));
        this.fillDialogBase(tag);
        this.buttonWidth = tag.getInt("button_width", 150);
    }

    private void fillDialogBase(CompoundTag tag) {
        CompoundTag exitActionTag = tag.getCompoundTag("exit_action");
        this.actionButton = exitActionTag == null ? null : new Button(this, exitActionTag);
        int columns = tag.getInt("columns", 2);
        if (columns < 1) {
            throw new IllegalArgumentException(Dialog.jvmdowngrader$concat$fillDialogBase$1(columns));
        }
        this.columns = columns;
    }

    private void fillMultiActionDialog(CompoundTag tag) {
        ListTag<CompoundTag> actionsTag = tag.getListTag("actions", CompoundTag.class);
        if (actionsTag == null || actionsTag.isEmpty()) {
            throw new IllegalArgumentException(Dialog.jvmdowngrader$concat$fillMultiActionDialog$1(String.valueOf(tag)));
        }
        this.widgets.addAll(J_U_S_Stream.toList(actionsTag.stream().map(actionTag -> new Button(this, (CompoundTag)actionTag))));
        this.fillDialogBase(tag);
    }

    private void fillConfirmationDialog(CompoundTag tag) {
        this.yesButton = new Button(this, tag.getCompoundTag("yes"));
        this.noButton = new Button(this, tag.getCompoundTag("no"));
    }

    public Tag title() {
        return this.title;
    }

    public @Nullable Tag externalTitle() {
        return this.externalTitle;
    }

    public boolean canCloseWithEscape() {
        return this.canCloseWithEscape;
    }

    public AfterAction afterAction() {
        return this.afterAction;
    }

    public @Nullable Button actionButton() {
        return this.actionButton;
    }

    public @Nullable Button yesButton() {
        return this.yesButton;
    }

    public @Nullable Button noButton() {
        return this.noButton;
    }

    public int columns() {
        return this.columns;
    }

    public int buttonWidth() {
        return this.buttonWidth;
    }

    public List<Widget> widgets() {
        return this.widgets;
    }

    private static String jvmdowngrader$concat$$init$$1(String string) {
        return "Dialog type is missing in tag: " + string;
    }

    private static String jvmdowngrader$concat$$init$$1(String string, String string2) {
        return "Unknown dialog type: " + string + " in tag: " + string2;
    }

    private static String jvmdowngrader$concat$fillBodyWidget$1(String string, String string2) {
        return "Unknown dialog body type: " + string + " in tag: " + string2;
    }

    private static String jvmdowngrader$concat$fillInputWidget$1(String string, String string2) {
        return "Unknown dialog input type: " + string + " in tag: " + string2;
    }

    private static String jvmdowngrader$concat$fillDialogBase$1(int n2) {
        return "Columns must be non-negative, got: " + n2;
    }

    private static String jvmdowngrader$concat$fillMultiActionDialog$1(String string) {
        return "Actions must not be empty in tag: " + string;
    }

    @NestHost(value=Dialog.class)
    public static enum AfterAction {
        CLOSE,
        NONE,
        WAIT_FOR_RESPONSE;

    }
}

