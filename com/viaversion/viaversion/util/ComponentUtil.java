/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 */
package com.viaversion.viaversion.util;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.mcstructs.text.Style;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.StringComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.TranslationComponent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.EntityHoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.ItemHoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.TextComponentSerializer;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.StringFormat;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.handling.ColorHandling;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.handling.DeserializerUnknownHandling;
import com.viaversion.viaversion.libs.mcstructs.text.utils.TextUtils;
import com.viaversion.viaversion.util.SerializerVersion;
import com.viaversion.viaversion.util.StringUtil;
import com.viaversion.viaversion.util.TagUtil;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class ComponentUtil {
    private static final int MAX_UNSIGNED_SHORT = 65535;

    public static JsonObject emptyJsonComponent() {
        return ComponentUtil.plainToJson("");
    }

    public static String emptyJsonComponentString() {
        return "{\"text\":\"\"}";
    }

    public static JsonObject plainToJson(String message) {
        JsonObject object = new JsonObject();
        object.addProperty("text", message);
        return object;
    }

    public static @Nullable JsonElement tagToJson(@Nullable Tag tag) {
        try {
            TextComponent component = SerializerVersion.V1_20_3.toComponent(tag);
            return component != null ? SerializerVersion.V1_19_4.toJson(component) : null;
        }
        catch (Exception e2) {
            if (!Via.getConfig().isSuppressTextComponentConversionWarnings()) {
                Via.getPlatform().getLogger().log(Level.SEVERE, ComponentUtil.jvmdowngrader$concat$tagToJson$1(StringUtil.forLogging(tag)), e2);
            }
            return ComponentUtil.plainToJson("<error>");
        }
    }

    public static @Nullable Tag jsonToTag(@Nullable JsonElement element) {
        if (element == null || element.isJsonNull()) {
            return null;
        }
        try {
            TextComponent component = SerializerVersion.V1_19_4.toComponent(element);
            return ComponentUtil.trimStrings(SerializerVersion.V1_20_3.toTag(component));
        }
        catch (Exception e2) {
            if (!Via.getConfig().isSuppressTextComponentConversionWarnings()) {
                Via.getPlatform().getLogger().log(Level.SEVERE, ComponentUtil.jvmdowngrader$concat$jsonToTag$1(StringUtil.forLogging(element)), e2);
            }
            return new StringTag("<error>");
        }
    }

    public static Tag trimStrings(Tag input) {
        if (input == null) {
            return null;
        }
        return TagUtil.handleDeep(input, (key, tag) -> {
            StringTag stringTag;
            byte[] value;
            if (tag instanceof StringTag && (value = (stringTag = (StringTag)tag).getValue().getBytes(StandardCharsets.UTF_8)).length > 65535) {
                stringTag.setValue("{}");
            }
            return tag;
        });
    }

    public static @Nullable String tagToJsonString(@Nullable Tag tag) {
        try {
            TextComponent component = SerializerVersion.V1_20_5.toComponent(tag);
            return component != null ? SerializerVersion.V1_20_3.toString(component) : null;
        }
        catch (Exception e2) {
            if (!Via.getConfig().isSuppressTextComponentConversionWarnings()) {
                Via.getPlatform().getLogger().log(Level.SEVERE, ComponentUtil.jvmdowngrader$concat$tagToJson$1(StringUtil.forLogging(tag)), e2);
            }
            return ComponentUtil.plainToJson("<error>").toString();
        }
    }

    public static @Nullable Tag jsonStringToTag(@Nullable String json) {
        return ComponentUtil.jsonStringToTag(json, SerializerVersion.V1_20_3, SerializerVersion.V1_20_5);
    }

    public static @Nullable Tag jsonStringToTag(@Nullable String json, SerializerVersion from, SerializerVersion to) {
        if (json == null) {
            return null;
        }
        return to.toTag(from.jsonSerializer.deserialize(json));
    }

    public static @Nullable JsonElement convertJson(@Nullable JsonElement element, SerializerVersion from, SerializerVersion to) {
        return element != null ? ComponentUtil.convert(from, to, from.toComponent(element)) : null;
    }

    public static @Nullable JsonElement convertJson(@Nullable String json, SerializerVersion from, SerializerVersion to) {
        return json != null ? ComponentUtil.convert(from, to, from.toComponent(json)) : null;
    }

    public static @Nullable JsonElement convertJsonOrEmpty(@Nullable String json, SerializerVersion from, SerializerVersion to) {
        TextComponent component = from.toComponent(json);
        if (component == null) {
            return ComponentUtil.emptyJsonComponent();
        }
        return to.toJson(component);
    }

    private static JsonElement convert(SerializerVersion from, SerializerVersion to, TextComponent component) {
        if (from.ordinal() >= SerializerVersion.V1_16.ordinal() && to.ordinal() < SerializerVersion.V1_16.ordinal()) {
            component.forEach(c2 -> ComponentUtil.convertHoverToLegacy(to, c2));
        }
        return to.toJson(component);
    }

    private static void convertHoverToLegacy(SerializerVersion to, TextComponent component) {
        ItemHoverEvent itemHoverEvent;
        CompoundTag tag;
        EntityHoverEvent entityHoverEvent;
        Style style;
        HoverEvent hoverEvent;
        if (component instanceof TranslationComponent) {
            TranslationComponent translationComponent = (TranslationComponent)component;
            for (Object arg : translationComponent.getArgs()) {
                if (!(arg instanceof TextComponent)) continue;
                TextComponent componentArg = (TextComponent)arg;
                ComponentUtil.convertHoverToLegacy(to, componentArg);
            }
        }
        if ((hoverEvent = (style = component.getStyle()).getHoverEvent()) instanceof EntityHoverEvent && (entityHoverEvent = (EntityHoverEvent)hoverEvent).isModern()) {
            EntityHoverEvent.ModernHolder entityData = entityHoverEvent.asModern();
            tag = new CompoundTag();
            tag.putString("type", entityData.getType().get());
            tag.putString("id", entityData.getUuid().toString());
            tag.putString("name", to.toString(entityData.getName() != null ? entityData.getName() : new StringComponent("")));
            entityHoverEvent.setLegacyData(new StringComponent(to.toSNBT(tag)));
        } else if (hoverEvent instanceof ItemHoverEvent && (itemHoverEvent = (ItemHoverEvent)hoverEvent).isModern()) {
            ItemHoverEvent.ModernHolder itemData = itemHoverEvent.asModern();
            tag = new CompoundTag();
            tag.putString("id", itemData.getId().get());
            tag.putByte("Count", (byte)itemData.getCount());
            if (itemData.getTag() != null) {
                tag.put("tag", itemData.getTag());
            }
            itemHoverEvent.setLegacyData(to.toSNBT(tag));
        }
    }

    public static JsonElement legacyToJson(String message) {
        return SerializerVersion.V1_12.toJson(StringFormat.vanilla().fromString(message, ColorHandling.RESET, DeserializerUnknownHandling.WHITE));
    }

    public static String legacyToJsonString(String message) {
        return ComponentUtil.legacyToJsonString(message, false);
    }

    public static String legacyToJsonString(String message, boolean itemData) {
        TextComponent component = StringFormat.vanilla().fromString(message, ColorHandling.RESET, DeserializerUnknownHandling.WHITE);
        if (itemData) {
            TextUtils.iterateAll(component, c2 -> {
                if (!c2.getStyle().isEmpty()) {
                    c2.setParentStyle(new Style().setItalic(false));
                }
            });
        }
        return SerializerVersion.V1_12.toString(component);
    }

    public static String jsonToLegacy(String value) {
        return TextComponentSerializer.V1_12.deserializeReader(value).asLegacyFormatString();
    }

    public static String jsonToLegacy(JsonElement value) {
        return SerializerVersion.V1_12.toComponent(value).asLegacyFormatString();
    }

    public static CompoundTag deserializeLegacyShowItem(JsonElement element, SerializerVersion version) {
        return (CompoundTag)version.toTag(version.toComponent(element).asUnformattedString());
    }

    public static CompoundTag deserializeShowItem(Tag value, SerializerVersion version) {
        return (CompoundTag)version.toTag(version.toComponent(value).asUnformattedString());
    }

    private static String jvmdowngrader$concat$tagToJson$1(String string) {
        return "Error converting tag: " + string;
    }

    private static String jvmdowngrader$concat$jsonToTag$1(String string) {
        return "Error converting component: " + string;
    }
}

