/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer;

import com.viaversion.viaversion.libs.gson.Gson;
import com.viaversion.viaversion.libs.gson.GsonBuilder;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonParseException;
import com.viaversion.viaversion.libs.gson.JsonParser;
import com.viaversion.viaversion.libs.gson.stream.JsonReader;
import com.viaversion.viaversion.libs.mcstructs.snbt.SNbt;
import com.viaversion.viaversion.libs.mcstructs.text.Style;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.TextComponentCodec;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_12.StyleDeserializer_v1_12;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_12.StyleSerializer_v1_12;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_12.TextDeserializer_v1_12;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_12.TextSerializer_v1_12;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_14.TextDeserializer_v1_14;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_14.TextSerializer_v1_14;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_15.TextDeserializer_v1_15;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_15.TextSerializer_v1_15;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_16.HoverEventDeserializer_v1_16;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_16.HoverEventSerializer_v1_16;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_16.StyleDeserializer_v1_16;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_16.StyleSerializer_v1_16;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_16.TextDeserializer_v1_16;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_16.TextSerializer_v1_16;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_17.TextDeserializer_v1_17;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_17.TextSerializer_v1_17;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_18.HoverEventDeserializer_v1_18;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_19_4.TextDeserializer_v1_19_4;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_19_4.TextSerializer_v1_19_4;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_6.TextDeserializer_v1_6;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_6.TextSerializer_v1_6;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_7.StyleDeserializer_v1_7;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_7.StyleSerializer_v1_7;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_7.TextDeserializer_v1_7;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_7.TextSerializer_v1_7;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_8.StyleDeserializer_v1_8;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_8.StyleSerializer_v1_8;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_8.TextDeserializer_v1_8;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_8.TextSerializer_v1_8;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_9.StyleDeserializer_v1_9;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_9.StyleSerializer_v1_9;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_9.TextSerializer_v1_9;
import com.viaversion.viaversion.libs.mcstructs.text.utils.LegacyGson;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.function.Supplier;
import javax.annotation.Nullable;

public class TextComponentSerializer {
    public static final TextComponentSerializer V1_6 = new TextComponentSerializer(() -> new GsonBuilder().registerTypeHierarchyAdapter(TextComponent.class, new TextSerializer_v1_6()).registerTypeHierarchyAdapter(TextComponent.class, new TextDeserializer_v1_6()).create(), true);
    public static final TextComponentSerializer V1_7 = new TextComponentSerializer(() -> new GsonBuilder().registerTypeHierarchyAdapter(TextComponent.class, new TextSerializer_v1_7()).registerTypeHierarchyAdapter(TextComponent.class, new TextDeserializer_v1_7()).registerTypeAdapter((Type)((Object)Style.class), new StyleDeserializer_v1_7(SNbt.V1_7)).registerTypeAdapter((Type)((Object)Style.class), new StyleSerializer_v1_7(SNbt.V1_7)).create(), true);
    public static final TextComponentSerializer V1_8 = new TextComponentSerializer(() -> new GsonBuilder().registerTypeHierarchyAdapter(TextComponent.class, new TextSerializer_v1_8()).registerTypeHierarchyAdapter(TextComponent.class, new TextDeserializer_v1_8()).registerTypeAdapter((Type)((Object)Style.class), new StyleDeserializer_v1_8(SNbt.V1_8)).registerTypeAdapter((Type)((Object)Style.class), new StyleSerializer_v1_8(SNbt.V1_8)).create(), true);
    public static final TextComponentSerializer V1_9 = new TextComponentSerializer(() -> new GsonBuilder().registerTypeHierarchyAdapter(TextComponent.class, new TextSerializer_v1_9()).registerTypeHierarchyAdapter(TextComponent.class, new TextDeserializer_v1_8()).registerTypeAdapter((Type)((Object)Style.class), new StyleDeserializer_v1_9(SNbt.V1_8)).registerTypeAdapter((Type)((Object)Style.class), new StyleSerializer_v1_9(SNbt.V1_8)).create(), true);
    public static final TextComponentSerializer V1_12 = new TextComponentSerializer(() -> new GsonBuilder().registerTypeHierarchyAdapter(TextComponent.class, new TextSerializer_v1_12()).registerTypeHierarchyAdapter(TextComponent.class, new TextDeserializer_v1_12()).registerTypeAdapter((Type)((Object)Style.class), new StyleDeserializer_v1_12(SNbt.V1_12)).registerTypeAdapter((Type)((Object)Style.class), new StyleSerializer_v1_12(SNbt.V1_12)).create());
    public static final TextComponentSerializer V1_14 = new TextComponentSerializer(() -> new GsonBuilder().registerTypeHierarchyAdapter(TextComponent.class, new TextSerializer_v1_14()).registerTypeHierarchyAdapter(TextComponent.class, new TextDeserializer_v1_14()).registerTypeAdapter((Type)((Object)Style.class), new StyleDeserializer_v1_12(SNbt.V1_14)).registerTypeAdapter((Type)((Object)Style.class), new StyleSerializer_v1_12(SNbt.V1_14)).disableHtmlEscaping().create());
    public static final TextComponentSerializer V1_15 = new TextComponentSerializer(() -> new GsonBuilder().registerTypeHierarchyAdapter(TextComponent.class, new TextSerializer_v1_15()).registerTypeHierarchyAdapter(TextComponent.class, new TextDeserializer_v1_15()).registerTypeAdapter((Type)((Object)Style.class), new StyleDeserializer_v1_12(SNbt.V1_14)).registerTypeAdapter((Type)((Object)Style.class), new StyleSerializer_v1_12(SNbt.V1_14)).disableHtmlEscaping().create());
    public static final TextComponentSerializer V1_16 = new TextComponentSerializer(() -> new GsonBuilder().registerTypeHierarchyAdapter(TextComponent.class, new TextSerializer_v1_16()).registerTypeHierarchyAdapter(TextComponent.class, new TextDeserializer_v1_16()).registerTypeAdapter((Type)((Object)Style.class), new StyleDeserializer_v1_16()).registerTypeAdapter((Type)((Object)Style.class), new StyleSerializer_v1_16()).registerTypeHierarchyAdapter(HoverEvent.class, new HoverEventDeserializer_v1_16(V1_16, SNbt.V1_14)).registerTypeHierarchyAdapter(HoverEvent.class, new HoverEventSerializer_v1_16(V1_16, SNbt.V1_14)).disableHtmlEscaping().create());
    public static final TextComponentSerializer V1_17 = new TextComponentSerializer(() -> new GsonBuilder().registerTypeHierarchyAdapter(TextComponent.class, new TextSerializer_v1_17()).registerTypeHierarchyAdapter(TextComponent.class, new TextDeserializer_v1_17()).registerTypeAdapter((Type)((Object)Style.class), new StyleDeserializer_v1_16()).registerTypeAdapter((Type)((Object)Style.class), new StyleSerializer_v1_16()).registerTypeHierarchyAdapter(HoverEvent.class, new HoverEventDeserializer_v1_16(V1_17, SNbt.V1_14)).registerTypeHierarchyAdapter(HoverEvent.class, new HoverEventSerializer_v1_16(V1_17, SNbt.V1_14)).disableHtmlEscaping().create());
    public static final TextComponentSerializer V1_18 = new TextComponentSerializer(() -> new GsonBuilder().registerTypeHierarchyAdapter(TextComponent.class, new TextSerializer_v1_17()).registerTypeHierarchyAdapter(TextComponent.class, new TextDeserializer_v1_17()).registerTypeAdapter((Type)((Object)Style.class), new StyleDeserializer_v1_16()).registerTypeAdapter((Type)((Object)Style.class), new StyleSerializer_v1_16()).registerTypeHierarchyAdapter(HoverEvent.class, new HoverEventDeserializer_v1_18(V1_18, SNbt.V1_14)).registerTypeHierarchyAdapter(HoverEvent.class, new HoverEventSerializer_v1_16(V1_18, SNbt.V1_14)).disableHtmlEscaping().create());
    public static final TextComponentSerializer V1_19_4 = new TextComponentSerializer(() -> new GsonBuilder().registerTypeHierarchyAdapter(TextComponent.class, new TextSerializer_v1_19_4()).registerTypeHierarchyAdapter(TextComponent.class, new TextDeserializer_v1_19_4()).registerTypeAdapter((Type)((Object)Style.class), new StyleDeserializer_v1_16()).registerTypeAdapter((Type)((Object)Style.class), new StyleSerializer_v1_16()).registerTypeHierarchyAdapter(HoverEvent.class, new HoverEventDeserializer_v1_18(V1_19_4, SNbt.V1_14)).registerTypeHierarchyAdapter(HoverEvent.class, new HoverEventSerializer_v1_16(V1_19_4, SNbt.V1_14)).disableHtmlEscaping().create());
    public static final TextComponentSerializer V1_20_3 = TextComponentCodec.V1_20_3.asSerializer();
    public static final TextComponentSerializer V1_20_5 = TextComponentCodec.V1_20_5.asSerializer();
    public static final TextComponentSerializer V1_21_2 = TextComponentCodec.V1_21_2.asSerializer();
    public static final TextComponentSerializer V1_21_4 = TextComponentCodec.V1_21_4.asSerializer();
    public static final TextComponentSerializer V1_21_5 = TextComponentCodec.V1_21_5.asSerializer();
    public static final TextComponentSerializer V1_21_6;
    public static final TextComponentSerializer LATEST;
    private final TextComponentCodec parentCodec;
    private final Supplier<Gson> gsonSupplier;
    private final boolean legacyGson;
    private Gson gson;

    public TextComponentSerializer(Supplier<Gson> gsonSupplier) {
        this(gsonSupplier, false);
    }

    public TextComponentSerializer(Supplier<Gson> gsonSupplier, boolean legacyGson) {
        this.parentCodec = null;
        this.gsonSupplier = gsonSupplier;
        this.legacyGson = legacyGson;
    }

    public TextComponentSerializer(TextComponentCodec parentCodec, Supplier<Gson> gsonSupplier) {
        this.parentCodec = parentCodec;
        this.gsonSupplier = gsonSupplier;
        this.legacyGson = false;
    }

    @Nullable
    public TextComponentCodec getParentCodec() {
        return this.parentCodec;
    }

    public boolean isCodec() {
        return this.parentCodec != null;
    }

    public Gson getGson() {
        if (this.gson == null) {
            this.gson = this.gsonSupplier.get();
        }
        return this.gson;
    }

    public String serialize(TextComponent component) {
        return this.getGson().toJson(component);
    }

    public JsonElement serializeJson(TextComponent component) {
        return this.getGson().toJsonTree(component);
    }

    public TextComponent deserialize(String json) {
        if (this.legacyGson) {
            LegacyGson.checkStartingType(json, true);
            json = LegacyGson.fixInvalidEscapes(json);
        }
        return this.getGson().fromJson(json, TextComponent.class);
    }

    public TextComponent deserialize(JsonElement element) {
        return this.getGson().fromJson(element, TextComponent.class);
    }

    public TextComponent deserializeReader(String json) {
        return this.deserializeReader(json, false);
    }

    public TextComponent deserializeParser(String json) {
        if (this.legacyGson) {
            LegacyGson.checkStartingType(json, true);
            json = LegacyGson.fixInvalidEscapes(json);
        }
        if (this.parentCodec != null) {
            return this.parentCodec.deserializeJson(json);
        }
        return this.getGson().fromJson(JsonParser.parseString(json), TextComponent.class);
    }

    public TextComponent deserializeLenientReader(String json) {
        if (this.parentCodec != null) {
            return this.parentCodec.deserializeLenientJson(json);
        }
        return this.deserializeReader(json, true);
    }

    public TextComponent deserializeReader(String json, boolean lenient) {
        if (this.legacyGson) {
            LegacyGson.checkStartingType(json, lenient);
            json = LegacyGson.fixInvalidEscapes(json);
        }
        if (this.parentCodec != null) {
            if (lenient) {
                return this.parentCodec.deserializeLenientJson(json);
            }
            return this.parentCodec.deserializeJsonReader(json);
        }
        try {
            JsonReader reader = new JsonReader(new StringReader(json));
            reader.setLenient(lenient);
            return this.getGson().getAdapter(TextComponent.class).read(reader);
        }
        catch (IOException e2) {
            throw new JsonParseException("Failed to parse json", e2);
        }
    }

    static {
        LATEST = V1_21_6 = TextComponentCodec.V1_21_6.asSerializer();
    }
}

