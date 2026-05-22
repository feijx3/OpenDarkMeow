/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 */
package com.viaversion.viaversion.protocols.v1_21_4to1_21_5.rewriter;

import ViaVersion.xyz.wagyourtail.jvmdg.j9.stub.java_base.J_U_List;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.Protocol1_21_4To1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.rewriter.BlockItemPacketRewriter1_21_5;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.rewriter.text.JsonNBTComponentRewriter;
import com.viaversion.viaversion.util.SerializerVersion;
import com.viaversion.viaversion.util.StringUtil;
import com.viaversion.viaversion.util.TagUtil;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class ComponentRewriter1_21_5
extends JsonNBTComponentRewriter<ClientboundPacket1_21_2> {
    public ComponentRewriter1_21_5(Protocol1_21_4To1_21_5 protocol) {
        super(protocol, ComponentRewriterBase.ReadType.NBT);
    }

    @Override
    protected void processCompoundTag(UserConnection connection, CompoundTag tag) {
        super.processCompoundTag(connection, tag);
        Tag tag2 = tag.remove("hoverEvent");
        if (tag2 instanceof CompoundTag) {
            CompoundTag hoverEvent = (CompoundTag)tag2;
            tag.put("hover_event", hoverEvent);
        }
        if ((tag2 = tag.remove("clickEvent")) instanceof CompoundTag) {
            CompoundTag clickEvent = (CompoundTag)tag2;
            try {
                this.updateClickEvent(clickEvent);
            }
            catch (IllegalArgumentException | URISyntaxException ignored) {
                return;
            }
            tag.put("click_event", clickEvent);
        }
    }

    @Override
    protected void handleShowItem(UserConnection connection, CompoundTag itemTag, @Nullable CompoundTag componentsTag) {
        CompoundTag dyedColor;
        CompoundTag attributeModifiers;
        super.handleShowItem(connection, itemTag, componentsTag);
        if (componentsTag == null) {
            return;
        }
        CompoundTag tooltipDisplay = new CompoundTag();
        boolean hideTooltip = TagUtil.removeNamespaced(componentsTag, "hide_tooltip");
        ListTag<StringTag> hiddenComponents = new ListTag<StringTag>(StringTag.class);
        if (TagUtil.removeNamespaced(componentsTag, "hide_additional_tooltip")) {
            for (StructuredDataKey<?> key : BlockItemPacketRewriter1_21_5.HIDE_ADDITIONAL_KEYS) {
                hiddenComponents.add(new StringTag(key.identifier()));
            }
        }
        this.updateHiddenComponents(componentsTag, "unbreakable", hiddenComponents);
        this.updateHiddenComponents(componentsTag, "can_place_on", hiddenComponents);
        this.updateHiddenComponents(componentsTag, "can_break", hiddenComponents);
        this.updateHiddenComponents(componentsTag, "dyed_color", hiddenComponents);
        this.updateHiddenComponents(componentsTag, "attribute_modifiers", hiddenComponents);
        this.updateHiddenComponents(componentsTag, "trim", hiddenComponents);
        this.updateHiddenComponents(componentsTag, "enchantments", hiddenComponents);
        this.updateHiddenComponents(componentsTag, "stored_enchantments", hiddenComponents);
        this.updateHiddenComponents(componentsTag, "jukebox_playable", hiddenComponents);
        if (hideTooltip || !hiddenComponents.isEmpty()) {
            tooltipDisplay.putBoolean("hide_tooltip", hideTooltip);
            tooltipDisplay.put("hidden_components", hiddenComponents);
            componentsTag.put("tooltip_display", tooltipDisplay);
        }
        if ((attributeModifiers = TagUtil.getNamespacedCompoundTag(componentsTag, "attribute_modifiers")) != null) {
            this.removeDataComponents(componentsTag, "attribute_modifiers");
            componentsTag.put("attribute_modifiers", attributeModifiers.get("modifiers"));
        }
        if ((dyedColor = TagUtil.getNamespacedCompoundTag(componentsTag, "dyed_color")) != null) {
            this.removeDataComponents(componentsTag, "dyed_color");
            componentsTag.put("dyed_color", dyedColor.get("rgb"));
        }
        this.handleAdventureModePredicate(componentsTag, "can_break");
        this.handleAdventureModePredicate(componentsTag, "can_place_on");
        this.handleEnchantments(componentsTag, "enchantments");
        this.handleEnchantments(componentsTag, "stored_enchantments");
        this.updateUglyJson(componentsTag, connection);
        this.removeDataComponents(componentsTag, StructuredDataKey.INSTRUMENT1_21_2, StructuredDataKey.JUKEBOX_PLAYABLE1_21);
    }

    private void updateHiddenComponents(CompoundTag componentsTag, String key, ListTag<StringTag> hiddenComponents) {
        CompoundTag component = TagUtil.getNamespacedCompoundTag(componentsTag, key);
        if (component == null) {
            return;
        }
        boolean showInTooltip = component.getBoolean("show_in_tooltip", true);
        if (!showInTooltip) {
            hiddenComponents.add(new StringTag(key));
        }
        component.remove("show_in_tooltip");
    }

    private void handleAdventureModePredicate(CompoundTag componentsTag, String key) {
        CompoundTag predicate = TagUtil.getNamespacedCompoundTag(componentsTag, key);
        if (predicate == null) {
            return;
        }
        ListTag<CompoundTag> blockPredicates = predicate.getListTag("predicates", CompoundTag.class);
        this.removeDataComponents(componentsTag, key);
        componentsTag.put(key, blockPredicates);
    }

    private void handleEnchantments(CompoundTag componentsTag, String key) {
        Tag tag;
        CompoundTag enchantments = TagUtil.getNamespacedCompoundTag(componentsTag, key);
        if (enchantments != null && (tag = enchantments.remove("levels")) instanceof CompoundTag) {
            CompoundTag levels = (CompoundTag)tag;
            enchantments.putAll(levels);
        }
    }

    @Override
    protected void handleHoverEvent(UserConnection connection, CompoundTag hoverEventTag) {
        String action = hoverEventTag.getString("action");
        if (action == null) {
            return;
        }
        switch (action) {
            case "show_text": {
                this.updateShowTextHover(connection, hoverEventTag);
                break;
            }
            case "show_entity": {
                this.updateShowEntityHover(connection, hoverEventTag);
                break;
            }
            case "show_item": {
                this.updateShowItemHover(connection, hoverEventTag);
            }
        }
    }

    private void updateClickEvent(CompoundTag clickEventTag) throws URISyntaxException {
        String action = clickEventTag.getString("action");
        if (action == null) {
            return;
        }
        if (action.equals("open_url")) {
            StringTag url = clickEventTag.getStringTag("value");
            URI uri = new URI(url.getValue());
            if (!"https".equalsIgnoreCase(uri.getScheme()) && !"http".equalsIgnoreCase(uri.getScheme())) {
                throw new IllegalArgumentException("Invalid URL");
            }
            clickEventTag.put("url", url);
        } else if (action.equals("change_page")) {
            int page = Integer.parseInt(clickEventTag.getString("value"));
            if (page < 1) {
                throw new IllegalArgumentException("Invalid page number");
            }
            clickEventTag.putInt("page", page);
        } else if (action.equals("run_command") || action.equals("suggest_command")) {
            String value = clickEventTag.getString("value");
            StringBuilder command = new StringBuilder();
            for (int i2 = 0; i2 < value.length(); ++i2) {
                char c2 = value.charAt(i2);
                if (c2 != '\u00a7' && c2 >= ' ' && c2 != '\u007f') {
                    command.append(c2);
                    continue;
                }
                if (!action.equals("suggest_command") || c2 != '\n') continue;
                command.append(c2);
            }
            clickEventTag.putString("command", command.toString());
        }
    }

    private void updateShowTextHover(UserConnection connection, CompoundTag hoverEventTag) {
        Tag tag = hoverEventTag.remove("value");
        if (tag instanceof StringTag) {
            StringTag value = (StringTag)tag;
            Tag contents = this.uglyJsonToTag(connection, value.getValue());
            hoverEventTag.put("value", contents);
            return;
        }
        Tag contents = hoverEventTag.remove("contents");
        this.processTag(connection, contents);
        hoverEventTag.put("value", contents);
    }

    private void updateShowItemHover(UserConnection connection, CompoundTag hoverEventTag) {
        this.convertLegacyItemContents(hoverEventTag);
        Tag contentsTag = hoverEventTag.remove("contents");
        if (contentsTag instanceof CompoundTag) {
            Tag idTag;
            CompoundTag compoundContents = (CompoundTag)contentsTag;
            Tag countTag = compoundContents.get("count");
            if (countTag != null) {
                hoverEventTag.put("count", countTag);
            }
            if ((idTag = compoundContents.get("id")) != null) {
                hoverEventTag.put("id", idTag);
            }
            CompoundTag componentsTag = compoundContents.getCompoundTag("components");
            this.handleShowItem(connection, compoundContents, componentsTag);
            if (componentsTag != null) {
                hoverEventTag.put("components", componentsTag);
            }
        } else if (contentsTag instanceof StringTag) {
            StringTag inlinedContents = (StringTag)contentsTag;
            hoverEventTag.put("id", inlinedContents);
        }
    }

    private void updateUglyJson(CompoundTag componentsTag, UserConnection connection) {
        this.updateUglyJson(componentsTag, "item_name", connection);
        this.updateUglyJson(componentsTag, "custom_name", connection);
        String loreKey = TagUtil.getNamespacedTagKey(componentsTag, "lore");
        ListTag<StringTag> lore = componentsTag.getListTag(loreKey, StringTag.class);
        if (lore != null) {
            componentsTag.put(loreKey, this.updateComponentList(connection, lore, false));
        }
    }

    public ListTag<CompoundTag> updateComponentList(UserConnection connection, ListTag<StringTag> messages, boolean skipInvalid) {
        ListTag<CompoundTag> updatedMessages = new ListTag<CompoundTag>(CompoundTag.class);
        for (StringTag message : messages) {
            Tag output;
            try {
                output = skipInvalid ? this.uglyJsonToTagUncaught(connection, message.getValue()) : this.uglyJsonToTag(connection, message.getValue());
            }
            catch (Exception e2) {
                continue;
            }
            CompoundTag wrappedComponent = new CompoundTag();
            wrappedComponent.putString("text", "");
            wrappedComponent.put("extra", new ListTag<Tag>(J_U_List.of(output)));
            updatedMessages.add(wrappedComponent);
        }
        return updatedMessages;
    }

    private void updateUglyJson(CompoundTag componentsTag, String key, UserConnection connection) {
        String actualKey = TagUtil.getNamespacedTagKey(componentsTag, key);
        String json = componentsTag.getString(actualKey);
        if (json == null) {
            return;
        }
        componentsTag.put(actualKey, this.uglyJsonToTag(connection, json));
    }

    private void updateShowEntityHover(UserConnection connection, CompoundTag hoverEventTag) {
        StringTag typeTag;
        Tag uuidTag;
        this.convertLegacyEntityContents(hoverEventTag);
        Tag tag = hoverEventTag.remove("contents");
        if (!(tag instanceof CompoundTag)) {
            return;
        }
        CompoundTag contents = (CompoundTag)tag;
        Tag nameTag = contents.get("name");
        if (nameTag != null) {
            this.processTag(connection, nameTag);
            hoverEventTag.put("name", nameTag);
        }
        if ((uuidTag = contents.get("id")) != null) {
            hoverEventTag.put("uuid", uuidTag);
        }
        if ((typeTag = contents.getStringTag("type")) != null) {
            typeTag.setValue(this.protocol.getEntityRewriter().mappedEntityIdentifier(typeTag.getValue()));
            hoverEventTag.put("id", typeTag);
        }
    }

    public Tag uglyJsonToTagUncaught(UserConnection connection, String value) {
        Tag contents = SerializerVersion.V1_21_4.toTag(SerializerVersion.V1_21_4.toComponent(value));
        this.processTag(connection, contents);
        return contents;
    }

    public Tag uglyJsonToTag(UserConnection connection, String value) {
        try {
            return this.uglyJsonToTagUncaught(connection, value);
        }
        catch (Exception e2) {
            if (!Via.getConfig().isSuppressTextComponentConversionWarnings()) {
                Via.getPlatform().getLogger().log(Level.SEVERE, ComponentRewriter1_21_5.jvmdowngrader$concat$uglyJsonToTag$1(StringUtil.forLogging(value)), e2);
            }
            return new StringTag("<error>");
        }
    }

    @Override
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
            String raw = compoundTag.getString("raw");
            compoundTag.put("raw", this.uglyJsonToTag(connection, raw));
            String filtered = compoundTag.getString("filtered");
            if (filtered == null) continue;
            compoundTag.put("filtered", this.uglyJsonToTag(connection, filtered));
        }
    }

    @Override
    protected SerializerVersion inputSerializerVersion() {
        return SerializerVersion.V1_21_4;
    }

    private static String jvmdowngrader$concat$uglyJsonToTag$1(String string) {
        return "Error converting json text component: " + string;
    }
}

