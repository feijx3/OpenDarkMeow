/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 */
package com.viaversion.viabackwards.api.data;

import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.api.data.BackwardsMappingDataLoader;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class TranslatableMappings {
    private static final Map<String, Map<String, String>> TRANSLATABLES = new HashMap<String, Map<String, String>>();

    public static void loadTranslatables() {
        if (!TRANSLATABLES.isEmpty()) {
            throw new IllegalStateException("Translatables already loaded!");
        }
        TranslatableMappings.fillTranslatables(BackwardsMappingDataLoader.INSTANCE.loadFromDataDir("translation-mappings.json"), TRANSLATABLES);
    }

    public static void fillTranslatables(JsonObject jsonObject, Map<String, Map<String, String>> translatables) {
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            HashMap<String, String> versionMappings = new HashMap<String, String>();
            translatables.put(entry.getKey(), versionMappings);
            for (Map.Entry<String, JsonElement> translationEntry : entry.getValue().getAsJsonObject().entrySet()) {
                versionMappings.put(translationEntry.getKey(), translationEntry.getValue().getAsString());
            }
        }
    }

    public static Map<String, String> translatablesFor(Protocol<?, ?, ?, ?> protocol) {
        String version = protocol.getClass().getSimpleName().replace("Protocol", "").split("To")[0].replace("_", ".");
        return TranslatableMappings.translatablesFor(version);
    }

    public static Map<String, String> translatablesFor(String version) {
        Map<String, String> translatableMappings = TranslatableMappings.getTranslatableMappings(version);
        if (translatableMappings == null) {
            ViaBackwards.getPlatform().getLogger().warning(TranslatableMappings.jvmdowngrader$concat$translatablesFor$1(version));
            return new HashMap<String, String>();
        }
        return translatableMappings;
    }

    public static @Nullable Map<String, String> getTranslatableMappings(String sectionIdentifier) {
        return TRANSLATABLES.get(sectionIdentifier);
    }

    private static String jvmdowngrader$concat$translatablesFor$1(String string) {
        return "Missing " + string + " translatables!";
    }
}

