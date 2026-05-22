/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.viaversion.viaversion.libs.mcstructs.text.stringformat.matcher;

import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.StringFormat;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.TextStringReader;
import javax.annotation.Nullable;

public class VoidVanillaStringFormat
extends StringFormat {
    public VoidVanillaStringFormat(char colorChar) {
        super(colorChar);
    }

    @Override
    public boolean matches(TextStringReader reader) {
        return reader.canRead() && reader.peek() == this.colorChar;
    }

    @Override
    @Nullable
    public TextFormatting read(TextStringReader reader) {
        reader.skip();
        if (reader.canRead()) {
            reader.skip();
        }
        return null;
    }

    @Override
    public boolean canWrite(TextFormatting formatting) {
        return true;
    }

    @Override
    public void write(StringBuilder builder, TextFormatting formatting) {
    }
}

