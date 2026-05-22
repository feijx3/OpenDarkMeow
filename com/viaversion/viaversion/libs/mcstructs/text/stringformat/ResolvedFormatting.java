/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.viaversion.viaversion.libs.mcstructs.text.stringformat;

import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import javax.annotation.Nullable;

public class ResolvedFormatting {
    private final String raw;
    @Nullable
    private final TextFormatting formatting;

    public ResolvedFormatting(String raw, @Nullable TextFormatting formatting) {
        this.raw = raw;
        this.formatting = formatting;
    }

    public String raw() {
        return this.raw;
    }

    @Nullable
    public TextFormatting get() {
        return this.formatting;
    }
}

