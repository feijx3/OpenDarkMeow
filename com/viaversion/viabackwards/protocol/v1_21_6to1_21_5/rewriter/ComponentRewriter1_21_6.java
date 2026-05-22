/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.rewriters.text.NBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.storage.ChestDialogStorage;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.storage.ClickEvents;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPacket1_21_6;

public final class ComponentRewriter1_21_6
extends NBTComponentRewriter<ClientboundPacket1_21_6> {
    public ComponentRewriter1_21_6(BackwardsProtocol<ClientboundPacket1_21_6, ?, ?, ?> protocol) {
        super(protocol);
    }

    @Override
    protected void processCompoundTag(UserConnection connection, CompoundTag tag) {
        super.processCompoundTag(connection, tag);
        CompoundTag clickEvent = tag.getCompoundTag("click_event");
        if (clickEvent == null) {
            return;
        }
        String action = clickEvent.getString("action");
        ChestDialogStorage chestDialogStorage = connection.get(ChestDialogStorage.class);
        if (chestDialogStorage != null && ("show_dialog".equals(action) || "custom".equals(action))) {
            tag.remove("click_event");
            return;
        }
        if ("show_dialog".equals(action)) {
            ClickEvents clickEvents = connection.get(ClickEvents.class);
            String command = clickEvents.storeClickEvent(clickEvent.copy());
            clickEvent.putString("action", "run_command");
            clickEvent.putString("command", command);
            clickEvent.remove("dialog");
        } else if ("custom".equals(action)) {
            ClickEvents clickEvents = connection.get(ClickEvents.class);
            String command = clickEvents.storeClickEvent(clickEvent.copy());
            clickEvent.putString("action", "run_command");
            clickEvent.putString("command", command);
            clickEvent.remove("id");
            clickEvent.remove("payload");
        }
    }
}

