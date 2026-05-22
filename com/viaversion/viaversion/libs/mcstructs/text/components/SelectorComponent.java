/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  lombok.Generated
 */
package com.viaversion.viaversion.libs.mcstructs.text.components;

import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import java.util.Objects;
import javax.annotation.Nullable;
import lombok.Generated;

public class SelectorComponent
extends TextComponent {
    private String selector;
    @Nullable
    private TextComponent separator;

    public SelectorComponent(String selector) {
        this(selector, null);
    }

    public SelectorComponent(String selector, @Nullable TextComponent separator) {
        this.selector = selector;
        this.separator = separator;
    }

    public String getSelector() {
        return this.selector;
    }

    public SelectorComponent setSelector(String selector) {
        this.selector = selector;
        return this;
    }

    @Nullable
    public TextComponent getSeparator() {
        return this.separator;
    }

    public SelectorComponent setSeparator(@Nullable TextComponent separator) {
        this.separator = separator;
        return this;
    }

    @Override
    public String asSingleString() {
        return this.selector;
    }

    @Override
    public TextComponent copy() {
        return this.copyMetaTo(this.shallowCopy());
    }

    @Override
    public TextComponent shallowCopy() {
        if (this.separator == null) {
            return new SelectorComponent(this.selector, null).setStyle(this.getStyle().copy());
        }
        return new SelectorComponent(this.selector, this.separator.copy()).setStyle(this.getStyle().copy());
    }

    @Override
    public String toString() {
        return ToString.of(this).add("siblings", this.getSiblings(), siblings -> !siblings.isEmpty()).add("style", this.getStyle(), style -> !style.isEmpty()).add("selector", this.selector).add("separator", this.separator, Objects::nonNull).toString();
    }

    @Override
    @Generated
    public boolean equals(Object o2) {
        if (o2 == this) {
            return true;
        }
        if (!(o2 instanceof SelectorComponent)) {
            return false;
        }
        SelectorComponent other = (SelectorComponent)o2;
        if (!other.canEqual(this)) {
            return false;
        }
        if (!super.equals(o2)) {
            return false;
        }
        String this$selector = this.getSelector();
        String other$selector = other.getSelector();
        if (this$selector == null ? other$selector != null : !this$selector.equals(other$selector)) {
            return false;
        }
        TextComponent this$separator = this.getSeparator();
        TextComponent other$separator = other.getSeparator();
        return !(this$separator == null ? other$separator != null : !((Object)this$separator).equals(other$separator));
    }

    @Override
    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof SelectorComponent;
    }

    @Override
    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = super.hashCode();
        String $selector = this.getSelector();
        result = result * 59 + ($selector == null ? 43 : $selector.hashCode());
        TextComponent $separator = this.getSeparator();
        result = result * 59 + ($separator == null ? 43 : ((Object)$separator).hashCode());
        return result;
    }
}

