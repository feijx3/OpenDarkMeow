/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_16;

import com.viaversion.viaversion.libs.gson.JsonDeserializationContext;
import com.viaversion.viaversion.libs.gson.JsonDeserializer;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonParseException;
import com.viaversion.viaversion.libs.gson.JsonSyntaxException;
import com.viaversion.viaversion.libs.mcstructs.core.Identifier;
import com.viaversion.viaversion.libs.mcstructs.text.Style;
import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEventAction;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.ChangePageClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.OpenUrlClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.utils.JsonUtils;
import java.lang.reflect.Type;

public class StyleDeserializer_v1_16
implements JsonDeserializer<Style> {
    @Override
    public Style deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject rawHoverEvent;
        HoverEvent hoverEvent;
        if (!json.isJsonObject()) {
            return null;
        }
        JsonObject rawStyle = json.getAsJsonObject();
        if (rawStyle == null) {
            return null;
        }
        Style style = new Style();
        if (rawStyle.has("bold")) {
            style.setBold(rawStyle.get("bold").getAsBoolean());
        }
        if (rawStyle.has("italic")) {
            style.setItalic(rawStyle.get("italic").getAsBoolean());
        }
        if (rawStyle.has("underlined")) {
            style.setUnderlined(rawStyle.get("underlined").getAsBoolean());
        }
        if (rawStyle.has("strikethrough")) {
            style.setStrikethrough(rawStyle.get("strikethrough").getAsBoolean());
        }
        if (rawStyle.has("obfuscated")) {
            style.setObfuscated(rawStyle.get("obfuscated").getAsBoolean());
        }
        if (rawStyle.has("color")) {
            style.setFormatting(TextFormatting.parse(JsonUtils.getString(rawStyle, "color")));
        }
        if (rawStyle.has("insertion")) {
            style.setInsertion(JsonUtils.getString(rawStyle, "insertion", null));
        }
        if (rawStyle.has("clickEvent")) {
            JsonObject rawClickEvent = JsonUtils.getJsonObject(rawStyle, "clickEvent");
            String rawAction = JsonUtils.getString(rawClickEvent, "action");
            ClickEventAction action = null;
            String value = JsonUtils.getString(rawClickEvent, "value");
            if (rawAction != null) {
                action = ClickEventAction.byName(rawAction);
            }
            if (action != null && value != null && action.isUserDefinable()) {
                style.setClickEvent(this.deserializeClickEvent(action, value));
            }
        }
        if (rawStyle.has("hoverEvent") && (hoverEvent = (HoverEvent)context.deserialize(rawHoverEvent = JsonUtils.getJsonObject(rawStyle, "hoverEvent"), (Type)((Object)HoverEvent.class))) != null && hoverEvent.getAction().isUserDefinable()) {
            style.setHoverEvent(hoverEvent);
        }
        if (rawStyle.has("font")) {
            String font = JsonUtils.getString(rawStyle, "font");
            try {
                style.setFont(Identifier.of(font));
            }
            catch (Throwable t2) {
                throw new JsonSyntaxException("Invalid font name: " + font);
            }
        }
        return style;
    }

    private ClickEvent deserializeClickEvent(ClickEventAction action, String value) {
        switch (action) {
            case OPEN_URL: {
                return new OpenUrlClickEvent(value);
            }
            case OPEN_FILE: {
                return ClickEvent.openFile(value);
            }
            case RUN_COMMAND: {
                return ClickEvent.runCommand(value);
            }
            case SUGGEST_COMMAND: {
                return ClickEvent.suggestCommand(value);
            }
            case CHANGE_PAGE: {
                return new ChangePageClickEvent(value);
            }
            case COPY_TO_CLIPBOARD: {
                return ClickEvent.copyToClipboard(value);
            }
        }
        throw new IllegalArgumentException("Unknown click event action: " + action.getName());
    }
}

