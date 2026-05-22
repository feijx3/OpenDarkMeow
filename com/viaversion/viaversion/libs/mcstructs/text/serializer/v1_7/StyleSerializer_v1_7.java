/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_7;

import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonSerializationContext;
import com.viaversion.viaversion.libs.gson.JsonSerializer;
import com.viaversion.viaversion.libs.mcstructs.snbt.SNbt;
import com.viaversion.viaversion.libs.mcstructs.text.Style;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_7.EventSerializers_v1_7;
import java.lang.reflect.Type;

public class StyleSerializer_v1_7
extends EventSerializers_v1_7
implements JsonSerializer<Style> {
    public StyleSerializer_v1_7(SNbt<?> sNbt) {
        super(sNbt);
    }

    @Override
    public JsonElement serialize(Style src, Type typeOfSrc, JsonSerializationContext context) {
        if (src.isEmpty()) {
            return null;
        }
        JsonObject serializedStyle = new JsonObject();
        if (src.getBold() != null) {
            serializedStyle.addProperty("bold", src.isBold());
        }
        if (src.getItalic() != null) {
            serializedStyle.addProperty("italic", src.isItalic());
        }
        if (src.getUnderlined() != null) {
            serializedStyle.addProperty("underlined", src.isUnderlined());
        }
        if (src.getStrikethrough() != null) {
            serializedStyle.addProperty("strikethrough", src.isStrikethrough());
        }
        if (src.getObfuscated() != null) {
            serializedStyle.addProperty("obfuscated", src.isObfuscated());
        }
        if (src.getColor() != null && !src.getColor().isRGBColor()) {
            serializedStyle.addProperty("color", src.getColor().serialize());
        }
        if (src.getClickEvent() != null) {
            JsonObject clickEvent = new JsonObject();
            clickEvent.addProperty("action", src.getClickEvent().getAction().getName());
            clickEvent.addProperty("value", (String)this.clickEventSerializer.serialize(src.getClickEvent()));
            serializedStyle.add("clickEvent", clickEvent);
        }
        if (src.getHoverEvent() != null) {
            JsonObject hoverEvent = new JsonObject();
            hoverEvent.addProperty("action", src.getHoverEvent().getAction().getName());
            hoverEvent.add("value", context.serialize(this.hoverEventSerializer.serialize(src.getHoverEvent())));
            serializedStyle.add("hoverEvent", hoverEvent);
        }
        return serializedStyle;
    }
}

