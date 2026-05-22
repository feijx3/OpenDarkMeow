/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.storage;

import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.Protocol1_21_6To1_21_5;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.Dialog;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input.TextInput;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.provider.ChestDialogViewProvider;
import com.viaversion.viabackwards.utils.ChatUtil;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPackets1_21_5;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={Phase.class})
public final class ChestDialogStorage
implements StorableObject {
    private static final byte MIN_FAKE_ID = 64;
    private static final byte MAX_FAKE_ID = 126;
    private static final AtomicInteger FAKE_ID_COUNTER = new AtomicInteger(64);
    private static final Tag[] RESPONSE_BUTTON_LABELS = new Tag[]{ChatUtil.text(""), ChatUtil.translate("gui.waitingForResponse.button.inactive", 4), ChatUtil.translate("gui.waitingForResponse.button.inactive", 3), ChatUtil.translate("gui.waitingForResponse.button.inactive", 2), ChatUtil.translate("gui.waitingForResponse.button.inactive", 1), ChatUtil.translate("gui.back")};
    private final ChestDialogViewProvider provider;
    private final Dialog dialog;
    private int containerId;
    private Dialog previousDialog;
    public int page;
    private Item[] items;
    private int confirmationYesIndex = -1;
    private int confirmationNoIndex = -1;
    private int actionIndex = -1;
    private @Nullable Phase phase;
    private int ticksWaitingForResponse = 0;
    private boolean closeButtonEnabled;
    private Tag closeButtonLabel;
    private TextInput currentTextInput;
    private boolean allowClosing;

    public ChestDialogStorage(ChestDialogViewProvider provider, Dialog dialog) {
        this.provider = provider;
        this.dialog = dialog;
    }

    public void tick(UserConnection connection) {
        int index;
        if (this.phase != Phase.WAITING_FOR_RESPONSE) {
            return;
        }
        if ((index = this.ticksWaitingForResponse++ / 20) > RESPONSE_BUTTON_LABELS.length - 1) {
            return;
        }
        this.closeButtonEnabled = index >= 1;
        this.closeButtonLabel = RESPONSE_BUTTON_LABELS[index];
        this.provider.updateDialog(connection, this.dialog);
    }

    public Dialog dialog() {
        return this.dialog;
    }

    public @Nullable Dialog previousDialog() {
        return this.previousDialog;
    }

    public void setPreviousDialog(Dialog previousDialog) {
        this.previousDialog = previousDialog;
    }

    public int containerId() {
        return this.containerId;
    }

    public Item[] items() {
        return this.items;
    }

    public void setItems(Item[] items, int confirmationYesIndex, int confirmationNoIndex, int actionIndex) {
        this.items = items;
        this.confirmationYesIndex = confirmationYesIndex;
        this.confirmationNoIndex = confirmationNoIndex;
        this.actionIndex = actionIndex;
    }

    public int confirmationYesIndex() {
        return this.confirmationYesIndex;
    }

    public int confirmationNoIndex() {
        return this.confirmationNoIndex;
    }

    public int actionIndex() {
        return this.actionIndex;
    }

    public @Nullable Phase phase() {
        return this.phase;
    }

    public boolean closeButtonEnabled() {
        return this.closeButtonEnabled;
    }

    public Tag closeButtonLabel() {
        return this.closeButtonLabel;
    }

    public TextInput currentTextInput() {
        return this.currentTextInput;
    }

    public boolean allowClosing() {
        return this.allowClosing;
    }

    public void setPhase(UserConnection connection, @Nullable Phase phase) {
        if (phase == Phase.DIALOG_VIEW || phase == Phase.ANVIL_VIEW) {
            if (this.phase != null) {
                PacketWrapper containerClose = PacketWrapper.create(ClientboundPackets1_21_5.CONTAINER_CLOSE, connection);
                containerClose.write(Types.VAR_INT, this.containerId);
                containerClose.send(Protocol1_21_6To1_21_5.class);
            }
            this.currentTextInput = null;
            int id = FAKE_ID_COUNTER.getAndIncrement();
            if (id > 126) {
                FAKE_ID_COUNTER.set(64);
                this.containerId = 64;
            } else {
                this.containerId = (byte)id;
            }
        }
        this.phase = phase;
    }

    public void setCurrentTextInput(TextInput currentTextInput) {
        this.currentTextInput = currentTextInput;
    }

    public void setAllowClosing(boolean allowClosing) {
        this.allowClosing = allowClosing;
    }

    @NestHost(value=ChestDialogStorage.class)
    public static enum Phase {
        DIALOG_VIEW,
        ANVIL_VIEW,
        WAITING_FOR_RESPONSE;

    }
}

