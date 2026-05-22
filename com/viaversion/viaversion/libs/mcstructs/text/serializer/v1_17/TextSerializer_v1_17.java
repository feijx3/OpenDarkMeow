/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_17;

import com.viaversion.viaversion.libs.gson.JsonArray;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonParseException;
import com.viaversion.viaversion.libs.gson.JsonPrimitive;
import com.viaversion.viaversion.libs.gson.JsonSerializationContext;
import com.viaversion.viaversion.libs.gson.JsonSerializer;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.KeybindComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.NbtComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.ScoreComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.SelectorComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.StringComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.TranslationComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.BlockNbtSource;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.EntityNbtSource;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.StorageNbtSource;
import java.lang.reflect.Type;
import java.util.Map;

public class TextSerializer_v1_17
implements JsonSerializer<TextComponent> {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public JsonElement serialize(TextComponent src, Type typeOfSrc, JsonSerializationContext context) {
        JsonElement serializedStyle;
        JsonObject serializedComponent = new JsonObject();
        if (!src.getStyle().isEmpty() && (serializedStyle = context.serialize(src.getStyle())).isJsonObject()) {
            JsonObject serializedStyleObject = serializedStyle.getAsJsonObject();
            for (Map.Entry<String, JsonElement> entry : serializedStyleObject.entrySet()) {
                serializedComponent.add(entry.getKey(), entry.getValue());
            }
        }
        if (!src.getSiblings().isEmpty()) {
            JsonArray siblings = new JsonArray();
            for (TextComponent sibling : src.getSiblings()) {
                siblings.add(this.serialize(sibling, (Type)sibling.getClass(), context));
            }
            serializedComponent.add("extra", siblings);
        }
        if (src instanceof StringComponent) {
            serializedComponent.addProperty("text", ((StringComponent)src).getText());
            return serializedComponent;
        } else if (src instanceof TranslationComponent) {
            Object[] args;
            TranslationComponent translationComponent = (TranslationComponent)src;
            serializedComponent.addProperty("translate", translationComponent.getKey());
            if (translationComponent.getArgs().length <= 0) return serializedComponent;
            JsonArray with = new JsonArray();
            for (Object arg : args = translationComponent.getArgs()) {
                if (arg instanceof TextComponent) {
                    with.add(this.serialize((TextComponent)arg, (Type)arg.getClass(), context));
                    continue;
                }
                with.add(new JsonPrimitive(String.valueOf(arg)));
            }
            serializedComponent.add("with", with);
            return serializedComponent;
        } else if (src instanceof ScoreComponent) {
            ScoreComponent scoreComponent = (ScoreComponent)src;
            JsonObject serializedScore = new JsonObject();
            serializedScore.addProperty("name", scoreComponent.getName());
            serializedScore.addProperty("objective", scoreComponent.getObjective());
            serializedComponent.add("score", serializedScore);
            return serializedComponent;
        } else if (src instanceof SelectorComponent) {
            SelectorComponent selectorComponent = (SelectorComponent)src;
            serializedComponent.addProperty("selector", selectorComponent.getSelector());
            if (selectorComponent.getSeparator() == null) return serializedComponent;
            serializedComponent.add("separator", this.serialize(selectorComponent.getSeparator(), typeOfSrc, context));
            return serializedComponent;
        } else if (src instanceof KeybindComponent) {
            serializedComponent.addProperty("keybind", ((KeybindComponent)src).getKeybind());
            return serializedComponent;
        } else {
            if (!(src instanceof NbtComponent)) throw new JsonParseException("Don't know how to serialize " + src + " as a Component");
            NbtComponent nbtComponent = (NbtComponent)src;
            serializedComponent.addProperty("nbt", nbtComponent.getComponent());
            serializedComponent.addProperty("interpret", nbtComponent.isResolve());
            if (nbtComponent.getSeparator() != null) {
                serializedComponent.add("separator", this.serialize(nbtComponent.getSeparator(), typeOfSrc, context));
            }
            if (nbtComponent.getDataSource() instanceof BlockNbtSource) {
                serializedComponent.addProperty("block", ((BlockNbtSource)nbtComponent.getDataSource()).getPos());
                return serializedComponent;
            } else if (nbtComponent.getDataSource() instanceof EntityNbtSource) {
                serializedComponent.addProperty("entity", ((EntityNbtSource)nbtComponent.getDataSource()).getSelector());
                return serializedComponent;
            } else {
                if (!(nbtComponent.getDataSource() instanceof StorageNbtSource)) throw new JsonParseException("Don't know how to serialize " + src + " as a Component");
                serializedComponent.addProperty("storage", ((StorageNbtSource)nbtComponent.getDataSource()).getId().get());
            }
        }
        return serializedComponent;
    }
}

