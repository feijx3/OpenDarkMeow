/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.viaversion.viaversion.libs.mcstructs.text.translation;

import com.viaversion.viaversion.libs.mcstructs.text.translation.BasicTranslator;
import javax.annotation.Nullable;

@FunctionalInterface
public interface Translator {
    public static final BasicTranslator GLOBAL = new BasicTranslator();

    @Nullable
    public String translate(String var1);

    default public String translateOrKey(String key) {
        String translation = this.translate(key);
        return translation != null ? translation : key;
    }
}

