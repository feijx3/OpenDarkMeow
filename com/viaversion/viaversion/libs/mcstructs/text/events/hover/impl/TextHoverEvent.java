/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl;

import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEventAction;
import lombok.Generated;

public class TextHoverEvent
extends HoverEvent {
    private TextComponent text;

    public TextHoverEvent(TextComponent text) {
        super(HoverEventAction.SHOW_TEXT);
        this.text = text;
    }

    public TextComponent getText() {
        return this.text;
    }

    public TextHoverEvent setText(TextComponent text) {
        this.text = text;
        return this;
    }

    @Override
    public String toString() {
        return ToString.of(this).add("action", this.action).add("text", this.text).toString();
    }

    @Override
    @Generated
    public boolean equals(Object o2) {
        if (o2 == this) {
            return true;
        }
        if (!(o2 instanceof TextHoverEvent)) {
            return false;
        }
        TextHoverEvent other = (TextHoverEvent)o2;
        if (!other.canEqual(this)) {
            return false;
        }
        TextComponent this$text = this.getText();
        TextComponent other$text = other.getText();
        return !(this$text == null ? other$text != null : !((Object)this$text).equals(other$text));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof TextHoverEvent;
    }

    @Override
    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        TextComponent $text = this.getText();
        result = result * 59 + ($text == null ? 43 : ((Object)$text).hashCode());
        return result;
    }
}

