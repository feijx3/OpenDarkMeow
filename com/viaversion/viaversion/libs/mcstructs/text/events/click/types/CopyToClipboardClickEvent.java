/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.viaversion.viaversion.libs.mcstructs.text.events.click.types;

import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEventAction;
import lombok.Generated;

public class CopyToClipboardClickEvent
extends ClickEvent {
    private String value;

    public CopyToClipboardClickEvent(String value) {
        super(ClickEventAction.COPY_TO_CLIPBOARD);
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return ToString.of(this).add("action", this.action).add("value", this.value).toString();
    }

    @Override
    @Generated
    public boolean equals(Object o2) {
        if (o2 == this) {
            return true;
        }
        if (!(o2 instanceof CopyToClipboardClickEvent)) {
            return false;
        }
        CopyToClipboardClickEvent other = (CopyToClipboardClickEvent)o2;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$value = this.getValue();
        String other$value = other.getValue();
        return !(this$value == null ? other$value != null : !this$value.equals(other$value));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof CopyToClipboardClickEvent;
    }

    @Override
    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $value = this.getValue();
        result = result * 59 + ($value == null ? 43 : $value.hashCode());
        return result;
    }
}

