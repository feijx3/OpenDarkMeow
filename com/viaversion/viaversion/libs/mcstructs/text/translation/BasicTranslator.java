/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.viaversion.viaversion.libs.mcstructs.text.translation;

import com.viaversion.viaversion.libs.mcstructs.text.translation.Translator;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public class BasicTranslator
implements Translator {
    private final Map<String, String> translations;

    public BasicTranslator() {
        this(new HashMap<String, String>());
    }

    public BasicTranslator(Map<String, String> translations) {
        this.translations = translations;
    }

    public Map<String, String> getTranslations() {
        return Collections.unmodifiableMap(this.translations);
    }

    public synchronized void addTranslation(String key, String value) {
        this.translations.put(key, value);
    }

    public synchronized void removeTranslation(String key) {
        this.translations.remove(key);
    }

    @Override
    @Nullable
    public String translate(String key) {
        return this.translations.get(key);
    }

    @Override
    public String translateOrKey(String key) {
        return this.translations.getOrDefault(key, key);
    }
}

