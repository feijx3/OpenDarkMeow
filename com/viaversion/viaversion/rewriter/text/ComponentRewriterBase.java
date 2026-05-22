/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.rewriter.text;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.data.ChatType;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.rewriter.ComponentRewriter;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.gson.JsonArray;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonParser;
import com.viaversion.viaversion.libs.gson.JsonPrimitive;
import com.viaversion.viaversion.libs.gson.JsonSyntaxException;
import com.viaversion.viaversion.protocols.base.ClientboundLoginPackets;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.TagUtil;
import java.util.BitSet;
import java.util.Collection;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={1.class, ReadType.class})
public abstract class ComponentRewriterBase<C extends ClientboundPacketType>
implements ComponentRewriter {
    protected final Protocol<C, ?, ?, ?> protocol;
    protected final ReadType type;

    protected ComponentRewriterBase(Protocol<C, ?, ?, ?> protocol, ReadType type) {
        this.protocol = protocol;
        this.type = type;
    }

    public void registerComponentPacket(C packetType) {
        this.protocol.registerClientbound(packetType, this::passthroughAndProcess);
    }

    public void registerBossEvent(C packetType) {
        this.protocol.registerClientbound(packetType, wrapper -> {
            wrapper.passthrough(Types.UUID);
            int action = wrapper.passthrough(Types.VAR_INT);
            if (action == 0 || action == 3) {
                this.passthroughAndProcess(wrapper);
            }
        });
    }

    public void registerPing() {
        this.protocol.registerClientbound(State.LOGIN, ClientboundLoginPackets.LOGIN_DISCONNECT, wrapper -> this.processText(wrapper.user(), wrapper.passthrough(Types.COMPONENT)));
    }

    public void registerOpenScreen1_14(C packetType) {
        this.protocol.registerClientbound(packetType, wrapper -> {
            wrapper.passthrough(Types.VAR_INT);
            wrapper.passthrough(Types.VAR_INT);
            this.passthroughAndProcess(wrapper);
        });
    }

    public void registerTabList(C packetType) {
        this.protocol.registerClientbound(packetType, wrapper -> {
            this.passthroughAndProcess(wrapper);
            this.passthroughAndProcess(wrapper);
        });
    }

    public void registerPlayerInfoUpdate1_21_4(C packetType) {
        this.protocol.registerClientbound(packetType, wrapper -> {
            BitSet actions = wrapper.passthrough(Types.PROFILE_ACTIONS_ENUM1_21_4);
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
                if (actions.get(6)) {
                    wrapper.passthrough(Types.VAR_INT);
                }
                if (!actions.get(7)) continue;
                wrapper.passthrough(Types.BOOLEAN);
            }
        });
    }

    public void registerPlayerCombatKill1_20(C packetType) {
        this.protocol.registerClientbound(packetType, wrapper -> {
            wrapper.passthrough(Types.VAR_INT);
            this.passthroughAndProcess(wrapper);
        });
    }

    public void registerDisguisedChat(C packetType) {
        this.protocol.registerClientbound(packetType, wrapper -> {
            this.passthroughAndProcess(wrapper);
            wrapper.passthrough(ChatType.TYPE);
            this.passthroughAndProcess(wrapper);
            this.passthroughAndProcessOptional(wrapper);
        });
    }

    public void passthroughAndProcess(PacketWrapper wrapper) {
        switch (this.type) {
            case JSON: {
                this.processText(wrapper.user(), wrapper.passthrough(Types.COMPONENT));
                break;
            }
            case NBT: {
                this.processTag(wrapper.user(), wrapper.passthrough(Types.TAG));
            }
        }
    }

    public void passthroughAndProcessOptional(PacketWrapper wrapper) {
        switch (this.type) {
            case JSON: {
                this.processText(wrapper.user(), wrapper.passthrough(Types.OPTIONAL_COMPONENT));
                break;
            }
            case NBT: {
                this.processTag(wrapper.user(), wrapper.passthrough(Types.OPTIONAL_TAG));
            }
        }
    }

    @Override
    public JsonElement processText(UserConnection connection, String value) {
        try {
            JsonElement root = JsonParser.parseString(value);
            this.processText(connection, root);
            return root;
        }
        catch (JsonSyntaxException e2) {
            if (Via.getManager().isDebug()) {
                this.protocol.getLogger().severe(ComponentRewriterBase.jvmdowngrader$concat$processText$1(value));
                throw e2;
            }
            return new JsonPrimitive(value);
        }
    }

    @Override
    public void processText(UserConnection connection, JsonElement element) {
        if (element == null || element.isJsonNull()) {
            return;
        }
        if (element.isJsonArray()) {
            this.processJsonArray(connection, element.getAsJsonArray());
        } else if (element.isJsonObject()) {
            this.processJsonObject(connection, element.getAsJsonObject());
        }
    }

    protected void processJsonArray(UserConnection connection, JsonArray array) {
        for (JsonElement jsonElement : array) {
            this.processText(connection, jsonElement);
        }
    }

    protected void processJsonObject(UserConnection connection, JsonObject object) {
        JsonElement hoverEvent;
        JsonElement extra;
        JsonElement translate = object.get("translate");
        if (translate != null && translate.isJsonPrimitive()) {
            this.handleTranslate(object, translate.getAsString());
            JsonElement with = object.get("with");
            if (with != null && with.isJsonArray()) {
                this.processJsonArray(connection, with.getAsJsonArray());
            }
        }
        if ((extra = object.get("extra")) != null && extra.isJsonArray()) {
            this.processJsonArray(connection, extra.getAsJsonArray());
        }
        if ((hoverEvent = object.get(this.hoverEventKey())) != null && hoverEvent.isJsonObject()) {
            this.handleHoverEvent(connection, hoverEvent.getAsJsonObject());
        }
    }

    protected abstract void handleHoverEvent(UserConnection var1, JsonObject var2);

    protected void handleTranslate(JsonObject object, String translate) {
    }

    @Override
    public void processTag(UserConnection connection, @Nullable Tag tag) {
        if (tag == null) {
            return;
        }
        if (tag instanceof ListTag) {
            this.processListTag(connection, (ListTag)tag);
        } else if (tag instanceof CompoundTag) {
            this.processCompoundTag(connection, (CompoundTag)tag);
        }
    }

    private void processListTag(UserConnection connection, ListTag<?> tag) {
        for (Tag entry : tag) {
            this.processTag(connection, entry);
        }
    }

    protected void processCompoundTag(UserConnection connection, CompoundTag tag) {
        CompoundTag hoverEvent;
        ListTag<?> extra;
        StringTag translate = tag.getStringTag("translate");
        if (translate != null) {
            this.handleTranslate(connection, tag, translate);
            ListTag<?> with = tag.getListTag("with");
            if (with != null) {
                this.processListTag(connection, with);
            }
        }
        if ((extra = tag.getListTag("extra")) != null) {
            this.processListTag(connection, extra);
        }
        if ((hoverEvent = tag.getCompoundTag(this.hoverEventKey())) != null) {
            this.handleHoverEvent(connection, hoverEvent);
        }
    }

    protected void handleTranslate(UserConnection connection, CompoundTag parentTag, StringTag translateTag) {
    }

    protected abstract void handleHoverEvent(UserConnection var1, CompoundTag var2);

    protected final void handleShowItem(UserConnection connection, CompoundTag itemTag) {
        this.handleShowItem(connection, itemTag, itemTag.getCompoundTag("components"));
    }

    protected void handleShowItem(UserConnection connection, CompoundTag itemTag, @Nullable CompoundTag componentsTag) {
        StringTag idTag = itemTag.getStringTag("id");
        String mappedId = this.protocol.getMappingData().getFullItemMappings().mappedIdentifier(idTag.getValue());
        if (mappedId != null) {
            idTag.setValue(mappedId);
        }
        if (componentsTag == null) {
            return;
        }
        this.handleAttributeModifiers(componentsTag);
        this.handleWrittenBookContents(connection, componentsTag);
        this.handleContainerContents(connection, componentsTag);
        this.handleItemArrayContents(connection, componentsTag, "bundle_contents");
        this.handleItemArrayContents(connection, componentsTag, "charged_projectiles");
        CompoundTag useRemainder = TagUtil.getNamespacedCompoundTag(componentsTag, "use_remainder");
        if (useRemainder != null) {
            this.handleShowItem(connection, useRemainder);
        }
    }

    protected void handleAttributeModifiers(CompoundTag tag) {
        if (this.protocol.getMappingData().getAttributeMappings() == null) {
            return;
        }
        ListTag<CompoundTag> attributeModifiers = TagUtil.getNamespacedCompoundTagList(tag, "attribute_modifiers");
        if (attributeModifiers == null) {
            return;
        }
        attributeModifiers.getValue().removeIf(attributeTag -> {
            StringTag typeTag = attributeTag.getStringTag("type");
            if (typeTag == null) {
                return false;
            }
            String mappedId = this.protocol.getMappingData().getAttributeMappings().mappedIdentifier(typeTag.getValue());
            if (mappedId != null) {
                typeTag.setValue(mappedId);
                return false;
            }
            return true;
        });
    }

    protected void handleContainerContents(UserConnection connection, CompoundTag tag) {
        ListTag<CompoundTag> container = TagUtil.getNamespacedCompoundTagList(tag, "container");
        if (container == null) {
            return;
        }
        for (CompoundTag entryTag : container) {
            this.handleShowItem(connection, entryTag.getCompoundTag("item"));
        }
    }

    protected void handleWrittenBookContents(UserConnection connection, CompoundTag tag) {
        CompoundTag book = TagUtil.getNamespacedCompoundTag(tag, "written_book_content");
        if (book == null) {
            return;
        }
        ListTag<CompoundTag> pagesTag = book.getListTag("pages", CompoundTag.class);
        if (pagesTag == null) {
            return;
        }
        for (CompoundTag compoundTag : pagesTag) {
            this.handleNestedComponent(connection, compoundTag, "raw");
            this.handleNestedComponent(connection, compoundTag, "filtered");
        }
    }

    protected void handleItemArrayContents(UserConnection connection, CompoundTag tag, String key) {
        ListTag<CompoundTag> container = TagUtil.getNamespacedCompoundTagList(tag, key);
        if (container == null) {
            return;
        }
        for (CompoundTag itemTag : container) {
            this.handleShowItem(connection, itemTag);
        }
    }

    protected void removeDataComponents(CompoundTag tag, Collection<StructuredDataKey<?>> keys) {
        for (StructuredDataKey<?> key : keys) {
            this.removeDataComponent(tag, key.identifier());
        }
    }

    protected void removeDataComponents(CompoundTag tag, StructuredDataKey<?> ... keys) {
        for (StructuredDataKey<?> key : keys) {
            this.removeDataComponent(tag, key.identifier());
        }
    }

    protected void removeDataComponents(CompoundTag tag, String ... keys) {
        for (String key : keys) {
            this.removeDataComponent(tag, key);
        }
    }

    private boolean removeDataComponent(CompoundTag tag, String key) {
        return TagUtil.removeNamespaced(tag, key) || tag.remove(ComponentRewriterBase.jvmdowngrader$concat$removeDataComponent$1(Key.namespaced(key))) != null || tag.remove(ComponentRewriterBase.jvmdowngrader$concat$removeDataComponent$1(Key.stripMinecraftNamespace(key))) != null;
    }

    protected abstract void handleNestedComponent(UserConnection var1, CompoundTag var2, String var3);

    protected abstract String hoverEventKey();

    private static String jvmdowngrader$concat$processText$1(String string) {
        return "Error when trying to parse json: " + string;
    }

    private static String jvmdowngrader$concat$removeDataComponent$1(String string) {
        return "!" + string;
    }

    @NestHost(value=ComponentRewriterBase.class)
    public static enum ReadType {
        JSON,
        NBT;

    }
}

