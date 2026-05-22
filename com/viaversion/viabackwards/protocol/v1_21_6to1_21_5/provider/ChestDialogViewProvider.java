/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.provider;

import ViaBackwards.xyz.wagyourtail.jvmdg.j11.stub.java_base.J_U_Collection;
import ViaBackwards.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.Protocol1_21_6To1_21_5;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.Button;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.Dialog;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input.BooleanInput;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input.NumberRangeInput;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input.SingleOptionInput;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input.TextInput;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.widget.ItemWidget;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.widget.TextWidget;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.widget.Widget;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.provider.DialogViewProvider;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.storage.ChestDialogStorage;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.storage.ClickEvents;
import com.viaversion.viabackwards.utils.ChatUtil;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.StructuredItem;
import com.viaversion.viaversion.api.minecraft.item.data.TooltipDisplay;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.libs.fastutil.ints.IntSortedSets;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ServerboundPackets1_21_6;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.MathUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@NestMembers(value={1.class, MultiTextWidget.class})
public class ChestDialogViewProvider
implements DialogViewProvider {
    private static final int INVENTORY_SIZE = 27;
    private static final int INVENTORY_LAST_ROW = 18;
    private final Protocol1_21_6To1_21_5 protocol;

    public ChestDialogViewProvider(Protocol1_21_6To1_21_5 protocol) {
        this.protocol = protocol;
    }

    @Override
    public void openDialog(UserConnection connection, Dialog dialog) {
        State state = connection.getProtocolInfo().getClientState();
        if (state == State.CONFIGURATION) {
            return;
        }
        ArrayList<Tag> texts = new ArrayList<Tag>();
        for (Widget widget : new ArrayList<Widget>(dialog.widgets())) {
            if (widget instanceof TextWidget) {
                TextWidget textWidget = (TextWidget)widget;
                texts.add(textWidget.label());
                dialog.widgets().remove(textWidget);
                continue;
            }
            if (texts.isEmpty()) continue;
            dialog.widgets().add(dialog.widgets().indexOf(widget), new MultiTextWidget((Tag[])J_U_Collection.toArray(texts, Tag[]::new)));
            texts.clear();
        }
        ChestDialogStorage previousStorage = connection.get(ChestDialogStorage.class);
        ChestDialogStorage storage = new ChestDialogStorage(this, dialog);
        if (previousStorage != null) {
            storage.setPreviousDialog(previousStorage.dialog());
        }
        connection.put(storage);
        this.openChestView(connection, storage, ChestDialogStorage.Phase.DIALOG_VIEW);
    }

    public void openChestView(UserConnection connection, ChestDialogStorage storage, ChestDialogStorage.Phase phase) {
        storage.setPhase(connection, phase);
        PacketWrapper openScreen = PacketWrapper.create(ClientboundPackets1_21_5.OPEN_SCREEN, connection);
        openScreen.write(Types.VAR_INT, storage.containerId());
        openScreen.write(Types.VAR_INT, 2);
        openScreen.write(Types.TAG, storage.dialog().title());
        openScreen.send(Protocol1_21_6To1_21_5.class);
        this.updateDialog(connection, storage.dialog());
    }

    @Override
    public void closeDialog(UserConnection connection) {
        State state = connection.getProtocolInfo().getClientState();
        if (state == State.CONFIGURATION) {
            return;
        }
        ChestDialogStorage storage = connection.get(ChestDialogStorage.class);
        PacketWrapper containerClose = PacketWrapper.create(ClientboundPackets1_21_5.CONTAINER_CLOSE, connection);
        containerClose.write(Types.VAR_INT, storage.containerId());
        containerClose.send(Protocol1_21_6To1_21_5.class);
        if (storage.previousDialog() != null) {
            this.openDialog(connection, storage.previousDialog());
        } else {
            connection.remove(ChestDialogStorage.class);
        }
    }

    public boolean clickDialog(UserConnection connection, int container, int slot, byte mouse, int mode) {
        Button actionButton;
        Button noButton;
        Button yesButton;
        List<Widget> widgets;
        ChestDialogStorage storage = connection.get(ChestDialogStorage.class);
        if (storage == null || storage.containerId() != container) {
            return false;
        }
        if (mode != 0 || slot < 0 || slot >= 27) {
            this.updateDialog(connection, storage.dialog());
            return true;
        }
        if (storage.phase() == ChestDialogStorage.Phase.ANVIL_VIEW) {
            this.openChestView(connection, storage, ChestDialogStorage.Phase.DIALOG_VIEW);
            return true;
        }
        if (storage.phase() == ChestDialogStorage.Phase.WAITING_FOR_RESPONSE) {
            if (slot == storage.actionIndex() && storage.closeButtonEnabled()) {
                this.closeDialog(connection);
            } else {
                this.updateDialog(connection, storage.dialog());
            }
            return true;
        }
        if (slot == 26) {
            int pages = MathUtil.ceil((float)storage.items().length / 18.0f);
            if (mouse == 0) {
                ++storage.page;
            } else if (mouse == 1) {
                --storage.page;
            }
            storage.page = MathUtil.clamp(storage.page, 0, pages - 1);
        }
        if ((slot += storage.page * 18) < (widgets = storage.dialog().widgets()).size()) {
            Widget widget = widgets.get(slot);
            if (widget instanceof BooleanInput) {
                BooleanInput booleanInput = (BooleanInput)widget;
                this.clickBooleanInput(booleanInput);
            } else if (widget instanceof NumberRangeInput) {
                NumberRangeInput numberRangeInput = (NumberRangeInput)widget;
                this.clickNumberRangeInput(numberRangeInput, mouse);
            } else if (widget instanceof TextInput) {
                TextInput textInput = (TextInput)widget;
                this.clickTextInput(connection, textInput);
            } else if (widget instanceof SingleOptionInput) {
                SingleOptionInput singleOptionInput = (SingleOptionInput)widget;
                this.clickSingleOptionInput(singleOptionInput);
            } else if (widget instanceof Button) {
                Button button = (Button)widget;
                this.clickButton(connection, storage.dialog().afterAction(), button);
            } else if (widget instanceof Dialog) {
                Dialog dialog = (Dialog)widget;
                this.clickDialogButton(connection, dialog);
            }
        }
        if (slot == storage.confirmationYesIndex() && (yesButton = storage.dialog().yesButton()) != null) {
            this.clickButton(connection, storage.dialog().afterAction(), yesButton);
        }
        if (slot == storage.confirmationNoIndex() && (noButton = storage.dialog().noButton()) != null) {
            this.clickButton(connection, storage.dialog().afterAction(), noButton);
        }
        if (slot == storage.actionIndex() && (actionButton = storage.dialog().actionButton()) != null) {
            this.clickButton(connection, storage.dialog().afterAction(), actionButton);
        }
        if (connection.has(ChestDialogStorage.class) && storage.phase() == ChestDialogStorage.Phase.DIALOG_VIEW) {
            this.updateDialog(connection, storage.dialog());
        }
        return true;
    }

    public void updateDialog(UserConnection connection, Dialog dialog) {
        ChestDialogStorage storage = connection.get(ChestDialogStorage.class);
        PacketWrapper containerSetContent = PacketWrapper.create(ClientboundPackets1_21_5.CONTAINER_SET_CONTENT, connection);
        containerSetContent.write(Types.VAR_INT, storage.containerId());
        containerSetContent.write(Types.VAR_INT, 0);
        containerSetContent.write(VersionedTypes.V1_21_5.itemArray, this.getItems(connection, storage, dialog));
        containerSetContent.write(VersionedTypes.V1_21_5.item, StructuredItem.empty());
        containerSetContent.send(Protocol1_21_6To1_21_5.class);
    }

    protected Item createPageNavigationItem() {
        return this.createItem("minecraft:arrow", (Tag)ChatUtil.text("\u00a79\u00a7lPage navigation"), "\u00a79Left click: \u00a76Go to next page", "\u00a79Right click: \u00a76Go to previous page");
    }

    protected Item createActionButtonItem(UserConnection connection, Button button) {
        Tag label = this.handleTag(connection, button.label());
        if (button.tooltip() == null) {
            return this.createItem("minecraft:oak_button", label);
        }
        return this.createItem("minecraft:oak_button", label, this.handleTag(connection, button.tooltip()));
    }

    protected Item createCloseButtonItem(Tag label) {
        return this.createItem("minecraft:oak_button", label);
    }

    protected Item getItemWidget(UserConnection connection, ItemWidget itemWidget) {
        String identifier = itemWidget.item().getString("id");
        int count = itemWidget.item().getInt("count", 1);
        CompoundTag label = ChatUtil.text(Key.stripMinecraftNamespace(identifier));
        Item item = this.createItem(identifier, label);
        item.setAmount(count);
        if (itemWidget.description() != null) {
            item.dataContainer().set(StructuredDataKey.LORE, new Tag[]{this.handleTag(connection, ChatUtil.fixStyle(itemWidget.description().label()))});
        }
        if (!itemWidget.showTooltip()) {
            item.dataContainer().set(StructuredDataKey.TOOLTIP_DISPLAY, new TooltipDisplay(true, IntSortedSets.EMPTY_SET));
        }
        return item;
    }

    protected Item getMultiTextWidget(UserConnection connection, MultiTextWidget multiTextWidget) {
        Tag name = this.handleTag(connection, multiTextWidget.labels()[0]);
        int length = multiTextWidget.labels().length;
        if (length == 1) {
            return this.createItem("minecraft:paper", name);
        }
        Tag[] lore = new Tag[length - 1];
        for (int i2 = 1; i2 < length; ++i2) {
            lore[i2 - 1] = this.handleTag(connection, ChatUtil.fixStyle(multiTextWidget.labels()[i2]));
        }
        return this.createItem("minecraft:paper", name, lore);
    }

    protected Item getBooleanInput(UserConnection connection, BooleanInput booleanInput) {
        String item = booleanInput.value() ? "minecraft:lime_dye" : "minecraft:gray_dye";
        Tag[] label = ChatUtil.split(booleanInput.label(), "\n");
        if (label.length == 1) {
            return this.createItem(item, this.handleTag(connection, booleanInput.label()), ChatUtil.text("\u00a79Left click: \u00a76Toggle value"));
        }
        Tag[] lore = new Tag[label.length];
        for (int i2 = 1; i2 < label.length; ++i2) {
            lore[i2 - 1] = this.handleTag(connection, ChatUtil.fixStyle(label[i2]));
        }
        lore[lore.length - 1] = ChatUtil.text("\u00a79Left click: \u00a76Toggle value");
        return this.createItem(item, this.handleTag(connection, label[0]), lore);
    }

    protected void clickBooleanInput(BooleanInput booleanInput) {
        booleanInput.setValue(!booleanInput.value());
    }

    protected Item getNumberRangeInput(UserConnection connection, NumberRangeInput numberRangeInput) {
        Tag label = this.handleTag(connection, numberRangeInput.displayName());
        return this.createItem("minecraft:clock", label, ChestDialogViewProvider.jvmdowngrader$concat$getNumberRangeInput$1(numberRangeInput.step()), ChestDialogViewProvider.jvmdowngrader$concat$getNumberRangeInput$2(numberRangeInput.step()), ChestDialogViewProvider.jvmdowngrader$concat$getNumberRangeInput$1(numberRangeInput.start(), numberRangeInput.end()));
    }

    protected void clickNumberRangeInput(NumberRangeInput numberRangeInput, int mouse) {
        float value = numberRangeInput.value();
        if (mouse == 0) {
            value += numberRangeInput.step();
        } else if (mouse == 1) {
            value -= numberRangeInput.step();
        }
        numberRangeInput.setClampedValue(value);
    }

    protected Item getTextInput(UserConnection connection, TextInput textInput) {
        CompoundTag currentValue = ChatUtil.text(ChestDialogViewProvider.jvmdowngrader$concat$getTextInput$1(textInput.value()));
        if (textInput.label() == null) {
            return this.createItem("minecraft:writable_book", currentValue);
        }
        Tag label = this.handleTag(connection, textInput.label());
        return this.createItem("minecraft:writable_book", label, currentValue, ChatUtil.text("\u00a79Left click: \u00a76Edit text"));
    }

    protected void clickTextInput(UserConnection connection, TextInput textInput) {
        ChestDialogStorage storage = connection.get(ChestDialogStorage.class);
        this.openAnvilView(connection, storage, ChatUtil.text("\u00a77Edit text"), textInput.value(), textInput);
    }

    protected Item getSingleOptionInput(UserConnection connection, SingleOptionInput singleOptionInput) {
        Tag displayName = singleOptionInput.options()[singleOptionInput.value()].computeDisplay();
        Tag label = singleOptionInput.label() != null ? ChatUtil.translate("options.generic_value", singleOptionInput.label(), displayName) : displayName;
        return this.createItem("minecraft:bookshelf", this.handleTag(connection, label), "\u00a79Left click: \u00a76Go to next option", "\u00a79Right click: \u00a76Go to previous option");
    }

    protected void clickSingleOptionInput(SingleOptionInput singleOptionInput) {
        singleOptionInput.setClampedValue(singleOptionInput.value() + 1);
    }

    protected Item getButton(UserConnection connection, Button button) {
        return this.createItem("minecraft:oak_button", this.handleTag(connection, button.label()));
    }

    public void clickButton(UserConnection connection, Dialog.AfterAction afterAction, @Nullable Button button) {
        String action;
        ChestDialogStorage storage = connection.get(ChestDialogStorage.class);
        switch (afterAction) {
            case CLOSE: {
                this.closeDialog(connection);
                break;
            }
            case WAIT_FOR_RESPONSE: {
                storage.setPhase(null, ChestDialogStorage.Phase.WAITING_FOR_RESPONSE);
            }
        }
        if (button == null || button.clickEvent() == null) {
            return;
        }
        CompoundTag clickEvent = button.clickEvent();
        switch (action = Key.stripMinecraftNamespace(clickEvent.getString("action"))) {
            case "open_url": {
                String url = clickEvent.getString("url");
                this.openAnvilView(connection, storage, ChatUtil.text("Open URL"), url, null);
                break;
            }
            case "run_command": {
                PacketWrapper chatCommand = PacketWrapper.create(ServerboundPackets1_21_6.CHAT_COMMAND, connection);
                String command = clickEvent.getString("command");
                if (command.startsWith("/")) {
                    command = command.substring(1);
                }
                chatCommand.write(Types.STRING, command);
                chatCommand.sendToServer(Protocol1_21_6To1_21_5.class);
                break;
            }
            case "copy_to_clipboard": {
                String value = clickEvent.getString("value");
                this.openAnvilView(connection, storage, ChatUtil.text("Copy to clipboard"), value, null);
            }
        }
        ClickEvents.handleClickEvent(connection, clickEvent);
    }

    protected Item createTextInputItem(String value) {
        return this.createItem("minecraft:paper", (Tag)ChatUtil.text(value), "\u00a79Left click/close: \u00a76Set text");
    }

    protected Item createTextCopyItem(String value) {
        return this.createItem("minecraft:paper", (Tag)ChatUtil.text(value), "\u00a79Left click: \u00a76Close");
    }

    private void openAnvilView(UserConnection connection, ChestDialogStorage storage, Tag title, String value, TextInput textInput) {
        storage.setPhase(connection, ChestDialogStorage.Phase.ANVIL_VIEW);
        PacketWrapper openScreen = PacketWrapper.create(ClientboundPackets1_21_5.OPEN_SCREEN, connection);
        openScreen.write(Types.VAR_INT, storage.containerId());
        openScreen.write(Types.VAR_INT, 8);
        openScreen.write(Types.TAG, title);
        openScreen.send(Protocol1_21_6To1_21_5.class);
        Item[] items = new Item[]{textInput != null ? this.createTextInputItem(value) : this.createTextCopyItem(value)};
        storage.setCurrentTextInput(textInput);
        PacketWrapper containerSetContent = PacketWrapper.create(ClientboundPackets1_21_5.CONTAINER_SET_CONTENT, connection);
        containerSetContent.write(Types.VAR_INT, storage.containerId());
        containerSetContent.write(Types.VAR_INT, 0);
        containerSetContent.write(VersionedTypes.V1_21_5.itemArray, items);
        containerSetContent.write(VersionedTypes.V1_21_5.item, StructuredItem.empty());
        containerSetContent.send(Protocol1_21_6To1_21_5.class);
    }

    public void updateAnvilText(UserConnection connection, String value) {
        if (value.isEmpty()) {
            return;
        }
        ChestDialogStorage storage = connection.get(ChestDialogStorage.class);
        if (storage.currentTextInput() != null) {
            storage.currentTextInput().setClampedValue(value);
        }
    }

    protected Item getDialog(UserConnection connection, Dialog dialog) {
        Tag title = dialog.externalTitle() != null ? dialog.externalTitle() : dialog.title();
        return this.createItem("minecraft:command_block", this.handleTag(connection, title));
    }

    protected void clickDialogButton(UserConnection connection, Dialog dialog) {
        this.closeDialog(connection);
        this.openDialog(connection, dialog);
    }

    protected Item getItem(UserConnection connection, Widget widget) {
        if (widget instanceof ItemWidget) {
            ItemWidget itemWidget = (ItemWidget)widget;
            return this.getItemWidget(connection, itemWidget);
        }
        if (widget instanceof MultiTextWidget) {
            MultiTextWidget multiTextWidget = (MultiTextWidget)widget;
            return this.getMultiTextWidget(connection, multiTextWidget);
        }
        if (widget instanceof BooleanInput) {
            BooleanInput booleanInput = (BooleanInput)widget;
            return this.getBooleanInput(connection, booleanInput);
        }
        if (widget instanceof NumberRangeInput) {
            NumberRangeInput numberRangeInput = (NumberRangeInput)widget;
            return this.getNumberRangeInput(connection, numberRangeInput);
        }
        if (widget instanceof TextInput) {
            TextInput textInput = (TextInput)widget;
            return this.getTextInput(connection, textInput);
        }
        if (widget instanceof SingleOptionInput) {
            SingleOptionInput singleOptionInput = (SingleOptionInput)widget;
            return this.getSingleOptionInput(connection, singleOptionInput);
        }
        if (widget instanceof Button) {
            Button button = (Button)widget;
            return this.getButton(connection, button);
        }
        if (widget instanceof Dialog) {
            Dialog dialog = (Dialog)widget;
            return this.getDialog(connection, dialog);
        }
        throw new IllegalArgumentException(ChestDialogViewProvider.jvmdowngrader$concat$getItem$1(widget.getClass().getName()));
    }

    protected Item[] getItems(UserConnection connection, ChestDialogStorage storage, Dialog dialog) {
        Item[] items = StructuredItem.emptyArray(27);
        int confirmationYesIndex = -1;
        int confirmationNoIndex = -1;
        int actionIndex = -1;
        if (storage.phase() == ChestDialogStorage.Phase.WAITING_FOR_RESPONSE) {
            actionIndex = 13;
            items[actionIndex] = this.createCloseButtonItem(storage.closeButtonLabel());
            storage.setItems(items, confirmationYesIndex, confirmationNoIndex, actionIndex);
            return items;
        }
        List<Widget> widgets = dialog.widgets();
        if (widgets.size() > 18) {
            int begin = storage.page * 18;
            int end = Math.min((storage.page + 1) * 18, widgets.size());
            for (int i2 = 0; i2 < end - begin; ++i2) {
                items[i2] = this.getItem(connection, widgets.get(begin + i2));
            }
            items[26] = this.createPageNavigationItem();
        } else {
            for (int i3 = 0; i3 < widgets.size(); ++i3) {
                items[i3] = this.getItem(connection, widgets.get(i3));
            }
        }
        if (dialog.yesButton() != null && dialog.noButton() != null) {
            confirmationYesIndex = widgets.isEmpty() ? 11 : 20;
            confirmationNoIndex = widgets.isEmpty() ? 15 : 24;
            items[confirmationYesIndex] = this.createActionButtonItem(connection, dialog.yesButton());
            items[confirmationNoIndex] = this.createActionButtonItem(connection, dialog.noButton());
        }
        if (dialog.actionButton() != null) {
            actionIndex = widgets.isEmpty() ? 13 : 18;
            items[actionIndex] = this.createActionButtonItem(connection, dialog.actionButton());
        }
        storage.setItems(items, confirmationYesIndex, confirmationNoIndex, actionIndex);
        return items;
    }

    private @Nullable Tag handleTag(UserConnection connection, @Nullable Tag tag) {
        if (tag == null) {
            return null;
        }
        ((ComponentRewriterBase)((Object)this.protocol.getComponentRewriter())).processTag(connection, tag);
        return tag;
    }

    protected Item createItem(String identifier, Tag name) {
        return this.createItem(identifier, name, new String[0]);
    }

    protected Item createItem(String identifier, Tag name, Tag ... description) {
        int id = this.protocol.getMappingData().getFullItemMappings().mappedId(identifier);
        StructuredDataContainer data = new StructuredDataContainer();
        data.setIdLookup(this.protocol, true);
        data.set(StructuredDataKey.ITEM_NAME, name);
        if (description != null) {
            data.set(StructuredDataKey.LORE, description);
        }
        return new StructuredItem(id, 1, data);
    }

    protected Item createItem(String identifier, Tag name, String ... description) {
        int id = this.protocol.getMappingData().getFullItemMappings().mappedId(identifier);
        StructuredDataContainer data = new StructuredDataContainer();
        data.setIdLookup(this.protocol, true);
        data.set(StructuredDataKey.ITEM_NAME, name);
        if (description.length > 0) {
            ArrayList<CompoundTag> lore = new ArrayList<CompoundTag>();
            for (String s2 : description) {
                lore.add(ChatUtil.text(s2));
            }
            data.set(StructuredDataKey.LORE, lore.toArray(new Tag[0]));
        }
        return new StructuredItem(id, 1, data);
    }

    private static String jvmdowngrader$concat$getNumberRangeInput$1(float f2) {
        return "\u00a79Left click: \u00a76Increase value by " + f2;
    }

    private static String jvmdowngrader$concat$getNumberRangeInput$2(float f2) {
        return "\u00a79Right click: \u00a76Decrease value by " + f2;
    }

    private static String jvmdowngrader$concat$getNumberRangeInput$1(float f2, float f3) {
        return "\u00a77(Value between \u00a7a" + f2 + " \u00a77and \u00a7a" + f3 + "\u00a77)";
    }

    private static String jvmdowngrader$concat$getTextInput$1(String string) {
        return "\u00a77Current value: \u00a7a" + string;
    }

    private static String jvmdowngrader$concat$getItem$1(String string) {
        return "Unknown widget type: " + string;
    }

    @RecordComponents(value={@RecordComponents.Value(name="labels", type=Tag[].class)})
    @NestHost(value=ChestDialogViewProvider.class)
    public static final class MultiTextWidget
    extends J_L_Record
    implements Widget {
        private final Tag[] labels;

        public MultiTextWidget(Tag[] labels) {
            this.labels = labels;
        }

        @Override
        public final String toString() {
            return MultiTextWidget.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return MultiTextWidget.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return MultiTextWidget.jvmdowngrader$equals$equals(this, o2);
        }

        public Tag[] labels() {
            return this.labels;
        }

        private static String jvmdowngrader$toString$toString(MultiTextWidget multiTextWidget) {
            MultiTextWidget multiTextWidget2 = multiTextWidget;
            return "ChestDialogViewProvider$MultiTextWidget[" + "labels=" + multiTextWidget.labels + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(MultiTextWidget multiTextWidget) {
            Object[] objectArray = new Object[]{multiTextWidget.labels};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(MultiTextWidget multiTextWidget, Object object) {
            if (multiTextWidget == object) {
                return true;
            }
            if (object != null && object instanceof MultiTextWidget) {
                MultiTextWidget multiTextWidget2 = (MultiTextWidget)object;
                if (Objects.equals(multiTextWidget.labels, multiTextWidget2.labels)) {
                    return true;
                }
            }
            return false;
        }
    }
}

