/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 */
package com.viaversion.viaversion.rewriter.text;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonPrimitive;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.SerializerVersion;
import java.util.BitSet;
import org.checkerframework.checker.nullness.qual.Nullable;

public class JsonNBTComponentRewriter<C extends ClientboundPacketType>
extends ComponentRewriterBase<C> {
    public JsonNBTComponentRewriter(Protocol<C, ?, ?, ?> protocol, ComponentRewriterBase.ReadType type) {
        super(protocol, type);
    }

    public void registerPlayerCombat(C packetType) {
        this.protocol.registerClientbound(packetType, wrapper -> {
            if (wrapper.passthrough(Types.VAR_INT) == 2) {
                wrapper.passthrough(Types.VAR_INT);
                wrapper.passthrough(Types.INT);
                this.processText(wrapper.user(), wrapper.passthrough(Types.COMPONENT));
            }
        });
    }

    public void registerTitle(C packetType) {
        this.protocol.registerClientbound(packetType, wrapper -> {
            int action = wrapper.passthrough(Types.VAR_INT);
            if (action >= 0 && action <= 2) {
                this.processText(wrapper.user(), wrapper.passthrough(Types.COMPONENT));
            }
        });
    }

    public void registerLegacyOpenWindow(C packetType) {
        this.protocol.registerClientbound(packetType, wrapper -> {
            wrapper.passthrough(Types.UNSIGNED_BYTE);
            wrapper.passthrough(Types.STRING);
            this.processText(wrapper.user(), wrapper.passthrough(Types.COMPONENT));
        });
    }

    public void registerPlayerCombatKill(C packetType) {
        this.protocol.registerClientbound(packetType, wrapper -> {
            wrapper.passthrough(Types.VAR_INT);
            wrapper.passthrough(Types.INT);
            this.processText(wrapper.user(), wrapper.passthrough(Types.COMPONENT));
        });
    }

    public void registerPlayerInfoUpdate1_20_3(C packetType) {
        this.protocol.registerClientbound(packetType, wrapper -> {
            BitSet actions = wrapper.passthrough(Types.PROFILE_ACTIONS_ENUM1_19_3);
            if (!actions.get(5)) {
                return;
            }
            int entries = wrapper.passthrough(Types.VAR_INT);
            for (int i2 = 0; i2 < entries; ++i2) {
                wrapper.passthrough(Types.UUID);
                if (actions.get(0)) {
                    wrapper.passthrough(Types.STRING);
                    wrapper.passthrough(Types.PROFILE_PROPERTY_ARRAY);
                }
                if (actions.get(1) && wrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                    wrapper.passthrough(Types.UUID);
                    wrapper.passthrough(Types.PROFILE_KEY);
                }
                if (actions.get(2)) {
                    wrapper.passthrough(Types.VAR_INT);
                }
                if (actions.get(3)) {
                    wrapper.passthrough(Types.BOOLEAN);
                }
                if (actions.get(4)) {
                    wrapper.passthrough(Types.VAR_INT);
                }
                this.processTag(wrapper.user(), wrapper.passthrough(Types.OPTIONAL_TAG));
            }
        });
    }

    public void registerPlayerChat(C packetType, Type<?> chatType) {
        this.protocol.registerClientbound(packetType, wrapper -> {
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
            wrapper.passthrough(chatType);
            this.processTag(wrapper.user(), wrapper.passthrough(Types.TAG));
            this.processTag(wrapper.user(), wrapper.passthrough(Types.OPTIONAL_TAG));
        });
    }

    @Override
    protected void handleHoverEvent(UserConnection connection, JsonObject hoverEvent) {
        JsonElement contents;
        JsonPrimitive actionElement = hoverEvent.getAsJsonPrimitive("action");
        if (!actionElement.isString()) {
            return;
        }
        String action = actionElement.getAsString();
        if (action.equals("show_text")) {
            JsonElement value = hoverEvent.get("value");
            this.processText(connection, value != null ? value : hoverEvent.get("contents"));
        } else if (action.equals("show_entity") && (contents = hoverEvent.get("contents")) != null && contents.isJsonObject()) {
            this.processText(connection, contents.getAsJsonObject().get("name"));
        }
    }

    @Override
    protected void handleHoverEvent(UserConnection connection, CompoundTag hoverEventTag) {
        StringTag actionTag = hoverEventTag.getStringTag("action");
        if (actionTag == null) {
            return;
        }
        String action = actionTag.getValue();
        if (action.equals("show_text")) {
            Tag value = hoverEventTag.get("value");
            this.processTag(connection, value != null ? value : hoverEventTag.get("contents"));
        } else if (action.equals("show_entity")) {
            this.convertLegacyEntityContents(hoverEventTag);
            CompoundTag contents = hoverEventTag.getCompoundTag("contents");
            if (contents != null) {
                this.processTag(connection, contents.get("name"));
                StringTag typeTag = contents.getStringTag("type");
                if (typeTag != null && this.protocol.getEntityRewriter() != null) {
                    typeTag.setValue(this.protocol.getEntityRewriter().mappedEntityIdentifier(typeTag.getValue()));
                }
            }
        } else if (action.equals("show_item")) {
            this.convertLegacyItemContents(hoverEventTag);
            CompoundTag contentsTag = hoverEventTag.getCompoundTag("contents");
            if (contentsTag != null) {
                CompoundTag componentsTag = contentsTag.getCompoundTag("components");
                this.handleShowItem(connection, contentsTag, componentsTag);
            }
        }
    }

    @Override
    protected void handleNestedComponent(UserConnection connection, CompoundTag parent, String key) {
        StringTag tag = parent.getStringTag(key);
        if (tag == null) {
            return;
        }
        SerializerVersion input = this.inputSerializerVersion();
        SerializerVersion output = this.outputSerializerVersion();
        Tag asTag = input.toTag(input.toComponent(tag.getValue()));
        this.processTag(connection, asTag);
        tag.setValue(output.toString(output.toComponent(asTag)));
    }

    @Override
    protected void handleWrittenBookContents(UserConnection connection, CompoundTag tag) {
        if (this.inputSerializerVersion() != null) {
            super.handleWrittenBookContents(connection, tag);
        }
    }

    @Override
    protected String hoverEventKey() {
        return "hoverEvent";
    }

    protected @Nullable SerializerVersion inputSerializerVersion() {
        return null;
    }

    protected @Nullable SerializerVersion outputSerializerVersion() {
        return this.inputSerializerVersion();
    }

    protected void convertLegacyEntityContents(CompoundTag hoverEvent) {
        if (this.inputSerializerVersion() == null) {
            return;
        }
        Tag valueTag = hoverEvent.remove("value");
        if (valueTag != null) {
            CompoundTag tag = ComponentUtil.deserializeShowItem(valueTag, this.inputSerializerVersion());
            CompoundTag contentsTag = new CompoundTag();
            contentsTag.put("type", tag.getStringTag("type"));
            contentsTag.put("id", tag.getStringTag("id"));
            contentsTag.put("name", this.outputSerializerVersion().toTag(this.outputSerializerVersion().toComponent(tag.getString("name"))));
            hoverEvent.put("contents", contentsTag);
        }
    }

    protected void convertLegacyItemContents(CompoundTag hoverEvent) {
        if (this.inputSerializerVersion() == null) {
            return;
        }
        Tag valueTag = hoverEvent.remove("value");
        if (valueTag != null) {
            CompoundTag tag = ComponentUtil.deserializeShowItem(valueTag, this.inputSerializerVersion());
            CompoundTag contentsTag = new CompoundTag();
            contentsTag.put("id", tag.getStringTag("id"));
            contentsTag.put("count", tag.getIntTag("count"));
            if (tag.get("tag") instanceof CompoundTag) {
                contentsTag.putString("tag", this.outputSerializerVersion().toSNBT(tag.getCompoundTag("tag")));
            }
            hoverEvent.put("contents", contentsTag);
        }
    }
}

