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

public class PrioritizingStringFormat
extends StringFormat {
    private final StringFormat[] matchers;

    public PrioritizingStringFormat(StringFormat ... matchers) {
        super('\u0000');
        this.matchers = matchers;
    }

    @Override
    public boolean canRead(TextStringReader reader) {
        for (StringFormat matcher : this.matchers) {
            if (!matcher.canRead(reader)) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean matches(TextStringReader reader) {
        reader.mark();
        for (StringFormat matcher : this.matchers) {
            if (matcher.canRead(reader) && matcher.matches(reader)) {
                return true;
            }
            reader.reset();
        }
        return false;
    }

    @Override
    @Nullable
    public TextFormatting read(TextStringReader reader) {
        reader.mark();
        for (StringFormat matcher : this.matchers) {
            if (matcher.canRead(reader) && matcher.matches(reader)) {
                reader.reset();
                return matcher.read(reader);
            }
            reader.reset();
        }
        return null;
    }

    @Override
    public boolean canWrite(TextFormatting formatting) {
        for (StringFormat matcher : this.matchers) {
            if (!matcher.canWrite(formatting)) continue;
            return true;
        }
        return false;
    }

    @Override
    public void write(StringBuilder builder, TextFormatting formatting) {
        for (StringFormat matcher : this.matchers) {
            if (!matcher.canWrite(formatting)) continue;
            matcher.write(builder, formatting);
            return;
        }
    }
}

