/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.rewriter.text;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.item.data.ChatType;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;

public class NBTComponentRewriter<C extends ClientboundPacketType>
extends ComponentRewriterBase<C> {
    public NBTComponentRewriter(Protocol<C, ?, ?, ?> protocol) {
        super(protocol, ComponentRewriterBase.ReadType.NBT);
    }

    @Override
    protected void handleHoverEvent(UserConnection connection, JsonObject hoverEvent) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    protected void handleHoverEvent(UserConnection connection, CompoundTag hoverEventTag) {
        StringTag actionTag = hoverEventTag.getStringTag("action");
        if (actionTag == null) {
            return;
        }
        String action = actionTag.getValue();
        if (action.equals("show_text")) {
            this.processTag(connection, hoverEventTag.get("value"));
        } else if (action.equals("show_entity")) {
            this.processTag(connection, hoverEventTag.get("name"));
            StringTag idTag = hoverEventTag.getStringTag("id");
            if (idTag != null && this.protocol.getEntityRewriter() != null) {
                idTag.setValue(this.protocol.getEntityRewriter().mappedEntityIdentifier(idTag.getValue()));
            }
        } else if (action.equals("show_item")) {
            CompoundTag componentsTag = hoverEventTag.getCompoundTag("components");
            this.handleShowItem(connection, hoverEventTag, componentsTag);
        }
    }

    @Override
    protected void handleNestedComponent(UserConnection connection, CompoundTag parent, String key) {
        Tag tag = parent.get(key);
        if (tag != null) {
            this.processTag(connection, tag);
        }
    }

    @Override
    protected String hoverEventKey() {
        return "hover_event";
    }

    public void registerPlayerChat1_21_5(C packetType) {
        this.protocol.registerClientbound(packetType, wrapper -> {
            wrapper.passthrough(Types.VAR_INT);
            wrapper.passthrough(Types.UUID);
            wrapper.passthrough(Types.VAR_INT);
            wrapper.passthrough(Types.OPTIONAL_SIGNATURE_BYTES);
            wrapper.passthrough(Types.STRING);
            wrapper.passthrough(Types.LONG);
            wrapper.passthrough(Types.LONG);
            int lastSeen = wrapper.passthrough(Types.VAR_INT);
            for (int i2 = 0; i2 < lastSeen; ++i2) {
                int index = wrapper.passthrough(Types.VAR_INT);
                if (index != 0) continue;
                wrapper.passthrough(Types.SIGNATURE_BYTES);
            }
            this.processTag(wrapper.user(), wrapper.passthrough(Types.OPTIONAL_TAG));
            int filterMaskType = wrapper.passthrough(Types.VAR_INT);
            if (filterMaskType == 2) {
                wrapper.passthrough(Types.LONG_ARRAY_PRIMITIVE);
            }
            wrapper.passthrough(ChatType.TYPE);
            this.processTag(wrapper.user(), wrapper.passthrough(Types.TAG));
            this.processTag(wrapper.user(), wrapper.passthrough(Types.OPTIONAL_TAG));
        });
    }
}

