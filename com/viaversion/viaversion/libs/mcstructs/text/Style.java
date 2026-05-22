/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text;

import com.viaversion.viaversion.libs.mcstructs.core.Copyable;
import com.viaversion.viaversion.libs.mcstructs.core.Identifier;
import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEvent;
import java.util.ArrayList;
import java.util.Objects;

public class Style
implements Copyable<Style> {
    private Style parent;
    private TextFormatting color;
    private Integer shadowColor;
    private Boolean obfuscated;
    private Boolean bold;
    private Boolean strikethrough;
    private Boolean underlined;
    private Boolean italic;
    private ClickEvent clickEvent;
    private HoverEvent hoverEvent;
    private String insertion;
    private Identifier font;

    public Style() {
    }

    public Style(TextFormatting color, Boolean obfuscated, Boolean bold, Boolean strikethrough, Boolean underlined, Boolean italic, ClickEvent clickEvent, HoverEvent hoverEvent, String insertion, Identifier font) {
        this(color, null, obfuscated, bold, strikethrough, underlined, italic, clickEvent, hoverEvent, insertion, font);
    }

    public Style(TextFormatting color, Integer shadowColor, Boolean obfuscated, Boolean bold, Boolean strikethrough, Boolean underlined, Boolean italic, ClickEvent clickEvent, HoverEvent hoverEvent, String insertion, Identifier font) {
        if (color != null && !color.isColor()) {
            throw new IllegalArgumentException("The color must be a color");
        }
        this.color = color;
        this.shadowColor = shadowColor;
        this.obfuscated = obfuscated;
        this.bold = bold;
        this.strikethrough = strikethrough;
        this.underlined = underlined;
        this.italic = italic;
        this.clickEvent = clickEvent;
        this.hoverEvent = hoverEvent;
        this.insertion = insertion;
        this.font = font;
    }

    public Style setParent(Style style) {
        this.parent = style;
        return this;
    }

    public Style getParent() {
        return this.parent;
    }

    public Style setFormatting(TextFormatting formatting) {
        if (formatting == null) {
            return this;
        }
        if (formatting.isColor()) {
            this.color = formatting;
        } else if (TextFormatting.OBFUSCATED.equals(formatting)) {
            this.obfuscated = true;
        } else if (TextFormatting.BOLD.equals(formatting)) {
            this.bold = true;
        } else if (TextFormatting.STRIKETHROUGH.equals(formatting)) {
            this.strikethrough = true;
        } else if (TextFormatting.UNDERLINE.equals(formatting)) {
            this.underlined = true;
        } else if (TextFormatting.ITALIC.equals(formatting)) {
            this.italic = true;
        } else if (TextFormatting.RESET.equals(formatting)) {
            this.color = null;
            this.obfuscated = null;
            this.bold = null;
            this.strikethrough = null;
            this.underlined = null;
            this.italic = null;
            this.clickEvent = null;
            this.hoverEvent = null;
            this.insertion = null;
            this.font = null;
        } else {
            throw new IllegalArgumentException("Invalid TextFormatting " + formatting);
        }
        return this;
    }

    public Style setFormatting(TextFormatting ... formattings) {
        for (TextFormatting formatting : formattings) {
            this.setFormatting(formatting);
        }
        return this;
    }

    public TextFormatting[] getFormattings() {
        return this.getFormattings(true);
    }

    public TextFormatting[] getFormattings(boolean includeColor) {
        ArrayList<TextFormatting> formattings = new ArrayList<TextFormatting>();
        if (includeColor && this.color != null) {
            formattings.add(this.color);
        }
        if (this.isObfuscated()) {
            formattings.add(TextFormatting.OBFUSCATED);
        }
        if (this.isBold()) {
            formattings.add(TextFormatting.BOLD);
        }
        if (this.isStrikethrough()) {
            formattings.add(TextFormatting.STRIKETHROUGH);
        }
        if (this.isUnderlined()) {
            formattings.add(TextFormatting.UNDERLINE);
        }
        if (this.isItalic()) {
            formattings.add(TextFormatting.ITALIC);
        }
        return formattings.toArray(new TextFormatting[0]);
    }

    public Style setColor(int rgb) {
        this.color = new TextFormatting(rgb);
        return this;
    }

    public TextFormatting getColor() {
        if (this.color == null && this.parent != null) {
            return this.parent.getColor();
        }
        return this.color;
    }

    public Style setShadowColor(Integer shadowColor) {
        this.shadowColor = shadowColor;
        return this;
    }

    public Integer getShadowColor() {
        if (this.shadowColor == null && this.parent != null) {
            return this.parent.getShadowColor();
        }
        return this.shadowColor;
    }

    public Style setBold(Boolean bold) {
        this.bold = bold;
        return this;
    }

    public Boolean getBold() {
        if (this.bold == null && this.parent != null) {
            return this.parent.getBold();
        }
        return this.bold;
    }

    public boolean isBold() {
        Boolean bold = this.getBold();
        return bold != null && bold != false;
    }

    public Style setItalic(Boolean italic) {
        this.italic = italic;
        return this;
    }

    public Boolean getItalic() {
        if (this.italic == null && this.parent != null) {
            return this.parent.getItalic();
        }
        return this.italic;
    }

    public boolean isItalic() {
        Boolean italic = this.getItalic();
        return italic != null && italic != false;
    }

    public Style setUnderlined(Boolean underlined) {
        this.underlined = underlined;
        return this;
    }

    public Boolean getUnderlined() {
        if (this.underlined == null && this.parent != null) {
            return this.parent.getUnderlined();
        }
        return this.underlined;
    }

    public boolean isUnderlined() {
        Boolean underlined = this.getUnderlined();
        return underlined != null && underlined != false;
    }

    public Style setStrikethrough(Boolean strikethrough) {
        this.strikethrough = strikethrough;
        return this;
    }

    public Boolean getStrikethrough() {
        if (this.strikethrough == null && this.parent != null) {
            return this.parent.getStrikethrough();
        }
        return this.strikethrough;
    }

    public boolean isStrikethrough() {
        Boolean strikethrough = this.getStrikethrough();
        return strikethrough != null && strikethrough != false;
    }

    public Style setObfuscated(Boolean obfuscated) {
        this.obfuscated = obfuscated;
        return this;
    }

    public Boolean getObfuscated() {
        if (this.obfuscated == null && this.parent != null) {
            return this.parent.getObfuscated();
        }
        return this.obfuscated;
    }

    public boolean isObfuscated() {
        Boolean obfuscated = this.getObfuscated();
        return obfuscated != null && obfuscated != false;
    }

    public Style setClickEvent(ClickEvent clickEvent) {
        this.clickEvent = clickEvent;
        return this;
    }

    public ClickEvent getClickEvent() {
        if (this.clickEvent == null && this.parent != null) {
            return this.parent.getClickEvent();
        }
        return this.clickEvent;
    }

    public Style setHoverEvent(HoverEvent hoverEvent) {
        this.hoverEvent = hoverEvent;
        return this;
    }

    public HoverEvent getHoverEvent() {
        if (this.hoverEvent == null && this.parent != null) {
            return this.parent.getHoverEvent();
        }
        return this.hoverEvent;
    }

    public Style setInsertion(String insertion) {
        this.insertion = insertion;
        return this;
    }

    public String getInsertion() {
        if (this.insertion == null && this.parent != null) {
            return this.parent.getInsertion();
        }
        return this.insertion;
    }

    public Style setFont(Identifier font) {
        this.font = font;
        return this;
    }

    public Identifier getFont() {
        if (this.font == null && this.parent != null) {
            return this.parent.getFont();
        }
        return this.font;
    }

    public boolean isEmpty() {
        return this.getColor() == null && this.getShadowColor() == null && this.getBold() == null && this.getItalic() == null && this.getUnderlined() == null && this.getStrikethrough() == null && this.getObfuscated() == null && this.getClickEvent() == null && this.getHoverEvent() == null && this.getInsertion() == null && this.getFont() == null;
    }

    public void mergeParent() {
        this.color = this.getColor();
        this.shadowColor = this.getShadowColor();
        this.bold = this.getBold();
        this.italic = this.getItalic();
        this.underlined = this.getUnderlined();
        this.strikethrough = this.getStrikethrough();
        this.obfuscated = this.getObfuscated();
        this.clickEvent = this.getClickEvent();
        this.hoverEvent = this.getHoverEvent();
        this.insertion = this.getInsertion();
        this.font = this.getFont();
        this.parent = null;
    }

    @Override
    public Style copy() {
        Style style = new Style();
        style.parent = this.parent;
        style.color = this.color;
        style.shadowColor = this.shadowColor;
        style.bold = this.bold;
        style.italic = this.italic;
        style.underlined = this.underlined;
        style.strikethrough = this.strikethrough;
        style.obfuscated = this.obfuscated;
        style.clickEvent = this.clickEvent;
        style.hoverEvent = this.hoverEvent;
        style.insertion = this.insertion;
        style.font = this.font;
        return style;
    }

    public boolean equals(Object o2) {
        if (this == o2) {
            return true;
        }
        if (o2 == null || this.getClass() != o2.getClass()) {
            return false;
        }
        Style style = (Style)o2;
        return Objects.equals(this.parent, style.parent) && Objects.equals(this.color, style.color) && Objects.equals(this.shadowColor, style.shadowColor) && Objects.equals(this.obfuscated, style.obfuscated) && Objects.equals(this.bold, style.bold) && Objects.equals(this.strikethrough, style.strikethrough) && Objects.equals(this.underlined, style.underlined) && Objects.equals(this.italic, style.italic) && Objects.equals(this.clickEvent, style.clickEvent) && Objects.equals(this.hoverEvent, style.hoverEvent) && Objects.equals(this.insertion, style.insertion) && Objects.equals(this.font, style.font);
    }

    public int hashCode() {
        return Objects.hash(this.parent, this.color, this.shadowColor, this.obfuscated, this.bold, this.strikethrough, this.underlined, this.italic, this.clickEvent, this.hoverEvent, this.insertion, this.font);
    }

    public String toString() {
        return ToString.of(this).add("parent", this.parent, Objects::nonNull).add("shadowColor", this.shadowColor, Objects::nonNull).add("color", this.color, Objects::nonNull).add("obfuscated", this.obfuscated, Objects::nonNull).add("bold", this.bold, Objects::nonNull).add("strikethrough", this.strikethrough, Objects::nonNull).add("underlined", this.underlined, Objects::nonNull).add("italic", this.italic, Objects::nonNull).add("clickEvent", this.clickEvent, Objects::nonNull).add("hoverEvent", this.hoverEvent, Objects::nonNull).add("insertion", this.insertion, Objects::nonNull).add("font", this.font, Objects::nonNull).toString();
    }
}

