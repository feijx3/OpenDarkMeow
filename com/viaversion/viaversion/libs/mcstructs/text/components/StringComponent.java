/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.viaversion.viaversion.libs.mcstructs.text.components;

import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import lombok.Generated;

public class StringComponent
extends TextComponent {
    private String text;

    public StringComponent() {
        this("");
    }

    public StringComponent(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public StringComponent setText(String text) {
        this.text = text;
        return this;
    }

    @Override
    public String asSingleString() {
        return this.text;
    }

    @Override
    public TextComponent copy() {
        return this.copyMetaTo(this.shallowCopy());
    }

    @Override
    public TextComponent shallowCopy() {
        return new StringComponent(this.text).setStyle(this.getStyle().copy());
    }

    @Override
    public String toString() {
        return ToString.of(this).add("siblings", this.getSiblings(), siblings -> !siblings.isEmpty()).add("style", this.getStyle(), style -> !style.isEmpty()).add("text", this.text).toString();
    }

    @Override
    @Generated
    public boolean equals(Object o2) {
        if (o2 == this) {
            return true;
        }
        if (!(o2 instanceof StringComponent)) {
            return false;
        }
        StringComponent other = (StringComponent)o2;
        if (!other.canEqual(this)) {
            return false;
        }
        if (!super.equals(o2)) {
            return false;
        }
        String this$text = this.getText();
        String other$text = other.getText();
        return !(this$text == null ? other$text != null : !this$text.equals(other$text));
    }

    @Override
    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof StringComponent;
    }

    @Override
    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = super.hashCode();
        String $text = this.getText();
        result = result * 59 + ($text == null ? 43 : $text.hashCode());
        return result;
    }
}

