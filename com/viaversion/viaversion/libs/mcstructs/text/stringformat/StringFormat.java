/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.viaversion.viaversion.libs.mcstructs.text.stringformat;

import com.viaversion.viaversion.libs.mcstructs.text.Style;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.components.TranslationComponent;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.ResolvedFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.TextStringReader;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.handling.ColorHandling;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.handling.DeserializerUnknownHandling;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.handling.SerializerUnknownHandling;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.matcher.AdventureRgbStringFormat;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.matcher.AnsiStringFormat;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.matcher.BungeeRgbStringFormat;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.matcher.PrioritizingStringFormat;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.matcher.VanillaStringFormat;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.matcher.VoidVanillaStringFormat;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

public abstract class StringFormat {
    protected final char colorChar;
    private static final IllegalArgumentException EX = new IllegalArgumentException("Too long");

    public static StringFormat vanilla() {
        return StringFormat.vanilla('\u00a7', false);
    }

    public static StringFormat vanilla(char colorChar) {
        return StringFormat.vanilla(colorChar, false);
    }

    public static StringFormat vanilla(boolean downsampleRgbColors) {
        return StringFormat.vanilla('\u00a7', downsampleRgbColors);
    }

    public static StringFormat vanilla(char colorChar, boolean downsampleRgbColors) {
        return new PrioritizingStringFormat(new VanillaStringFormat(colorChar, downsampleRgbColors), new VoidVanillaStringFormat(colorChar));
    }

    public static StringFormat bungee() {
        return StringFormat.bungee('&');
    }

    public static StringFormat bungee(char colorChar) {
        return new PrioritizingStringFormat(new BungeeRgbStringFormat(colorChar), new VanillaStringFormat(colorChar, false), new VoidVanillaStringFormat(colorChar));
    }

    public static StringFormat adventure() {
        return StringFormat.adventure('&');
    }

    public static StringFormat adventure(char colorChar) {
        return new PrioritizingStringFormat(new AdventureRgbStringFormat(colorChar), new VanillaStringFormat(colorChar, false), new VoidVanillaStringFormat(colorChar));
    }

    public static StringFormat ansi() {
        return StringFormat.ansi(true);
    }

    public static StringFormat ansi(boolean trueColor) {
        return new AnsiStringFormat(trueColor);
    }

    public StringFormat(char colorChar) {
        this.colorChar = colorChar;
    }

    public TextComponent fromString(String s2, ColorHandling colorHandling, DeserializerUnknownHandling unknownHandling) {
        return this.fromString(s2, colorHandling, unknownHandling, true);
    }

    public TextComponent fromString(String s2, ColorHandling colorHandling, DeserializerUnknownHandling unknownHandling, boolean ignoreEmptySections) {
        TextStringReader reader = new TextStringReader(s2);
        Style currentStyle = new Style();
        ArrayList<TextComponent> components = new ArrayList<TextComponent>();
        StringBuilder currentText = new StringBuilder();
        while (reader.canRead()) {
            ResolvedFormatting resolved = this.resolve(reader);
            if (resolved == null) {
                currentText.append(reader.read());
                continue;
            }
            TextFormatting formatting = resolved.get();
            if (formatting == null && (formatting = unknownHandling.handle(resolved, currentText)) == null) continue;
            if (currentText.length() > 0 || !ignoreEmptySections) {
                components.add(TextComponent.of(currentText.toString()).setStyle(currentStyle.copy()));
                currentText.setLength(0);
            }
            if (formatting.equals(TextFormatting.RESET) || colorHandling.equals((Object)ColorHandling.RESET) && formatting.isColor()) {
                currentStyle = new Style();
            }
            currentStyle.setFormatting(formatting);
        }
        if (currentText.length() > 0 || !ignoreEmptySections) {
            components.add(TextComponent.of(currentText.toString()).setStyle(currentStyle));
        }
        if (components.size() == 1) {
            return (TextComponent)components.get(0);
        }
        return TextComponent.of(components);
    }

    public String toString(TextComponent component, ColorHandling colorHandling, SerializerUnknownHandling unknownHandling) {
        return this.toString(component, colorHandling, unknownHandling, true);
    }

    public String toString(TextComponent component, ColorHandling colorHandling, SerializerUnknownHandling unknownHandling, boolean ignoreEmptyComponents) {
        StringBuilder output = new StringBuilder();
        Style lastStyle = null;
        ArrayList<TextComponent> texts = new ArrayList<TextComponent>();
        texts.add(component.copy().mergeSiblingParentStyle());
        int wow = 1;
        while (!texts.isEmpty()) {
            TextComponent current = (TextComponent)texts.remove(0);
            if (current instanceof TranslationComponent) {
                TranslationComponent translation = (TranslationComponent)current;
                TextComponent resolved = translation.resolveIntoComponents();
                if ((wow += resolved.getSiblings().size()) > 32) {
                    throw EX;
                }
                texts.add(0, resolved.mergeSiblingParentStyle());
                for (int i2 = 0; i2 < translation.getSiblings().size(); ++i2) {
                    texts.add(i2 + 1, translation.getSiblings().get(i2));
                }
                continue;
            }
            String text = current.asSingleString();
            if (!text.isEmpty() || !ignoreEmptyComponents) {
                Style currentStyle = current.getStyle();
                if (!currentStyle.equals(lastStyle)) {
                    TextFormatting[] formattings = currentStyle.getFormattings();
                    if (!(lastStyle == null || lastStyle.isEmpty() || !colorHandling.equals((Object)ColorHandling.FORMATTING) && formattings.length > 0 && formattings[0].isColor())) {
                        this.write(output, TextFormatting.RESET);
                    }
                    for (TextFormatting formatting : formattings) {
                        if (this.canWrite(formatting)) {
                            this.write(output, formatting);
                            continue;
                        }
                        TextFormatting resolved = unknownHandling.handle(formatting, output);
                        if (resolved == null || !this.canWrite(resolved)) continue;
                        this.write(output, resolved);
                    }
                    lastStyle = currentStyle;
                }
                output.append(current.asSingleString());
            }
            for (int i3 = 0; i3 < current.getSiblings().size(); ++i3) {
                texts.add(i3, current.getSiblings().get(i3));
            }
        }
        if (lastStyle != null && !lastStyle.isEmpty() && this.shouldResetAtEnd()) {
            this.write(output, TextFormatting.RESET);
        }
        return output.toString();
    }

    public Style styleAt(String s2, int index, ColorHandling colorHandling, DeserializerUnknownHandling unknownHandling) {
        TextStringReader reader = new TextStringReader(s2);
        Style style = new Style();
        while (reader.canRead() && reader.getIndex() < index) {
            ResolvedFormatting resolved = this.resolve(reader);
            if (resolved == null) {
                reader.read();
                continue;
            }
            TextFormatting formatting = resolved.get();
            if (formatting == null && (formatting = unknownHandling.handle(resolved, new StringBuilder())) == null) continue;
            if (formatting.equals(TextFormatting.RESET) || colorHandling.equals((Object)ColorHandling.RESET) && formatting.isColor()) {
                style = new Style();
            }
            style.setFormatting(formatting);
        }
        return style;
    }

    public String convertTo(String s2, StringFormat target) {
        TextStringReader reader = new TextStringReader(s2);
        StringBuilder out = new StringBuilder();
        TextFormatting formatting = null;
        while (reader.canRead()) {
            ResolvedFormatting resolved = this.resolve(reader);
            if (resolved == null) {
                out.append(reader.read());
                continue;
            }
            formatting = resolved.get();
            target.write(out, formatting);
        }
        if (target.shouldResetAtEnd() && !TextFormatting.RESET.equals(formatting)) {
            target.write(out, TextFormatting.RESET);
        }
        return out.toString();
    }

    public String prependStyle(String s2, Style style, SerializerUnknownHandling unknownHandling) {
        StringBuilder output = new StringBuilder();
        for (TextFormatting formatting : style.getFormattings()) {
            if (this.canWrite(formatting)) {
                this.write(output, formatting);
                continue;
            }
            TextFormatting resolved = unknownHandling.handle(formatting, output);
            if (resolved == null || !this.canWrite(resolved)) continue;
            this.write(output, resolved);
        }
        return output.append(s2).toString();
    }

    public String[] split(String s2, String split, ColorHandling colorHandling, SerializerUnknownHandling serializerUnknownHandling, DeserializerUnknownHandling deserializerUnknownHandling) {
        String[] parts = s2.split(Pattern.quote(split));
        for (int i2 = 1; i2 < parts.length; ++i2) {
            String previous = parts[i2 - 1];
            Style style = this.styleAt(previous, previous.length(), colorHandling, deserializerUnknownHandling);
            parts[i2] = this.prependStyle(parts[i2], style, serializerUnknownHandling);
        }
        return parts;
    }

    @Nullable
    public ResolvedFormatting resolve(TextStringReader reader) {
        if (!this.canRead(reader)) {
            return null;
        }
        reader.mark();
        if (!this.matches(reader)) {
            reader.reset();
            return null;
        }
        reader.reset();
        TextFormatting formatting = this.read(reader);
        String raw = reader.getMark();
        return new ResolvedFormatting(raw, formatting);
    }

    public boolean canRead(TextStringReader reader) {
        return reader.canRead() && reader.peek() == this.colorChar;
    }

    public abstract boolean matches(TextStringReader var1);

    @Nullable
    public abstract TextFormatting read(TextStringReader var1);

    public abstract boolean canWrite(TextFormatting var1);

    public abstract void write(StringBuilder var1, TextFormatting var2);

    public boolean shouldResetAtEnd() {
        return false;
    }

    protected static <T> T init(T t2, Consumer<T> initializer) {
        initializer.accept(t2);
        return t2;
    }
}

