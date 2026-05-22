/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.viaversion.viaversion.libs.mcstructs.text.events.click.types;

import com.viaversion.viaversion.libs.mcstructs.converter.SerializedData;
import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEventAction;
import lombok.Generated;

public class ShowDialogClickEvent
extends ClickEvent {
    private SerializedData<?> dialogData;

    public ShowDialogClickEvent(SerializedData<?> dialogData) {
        super(ClickEventAction.SHOW_DIALOG);
        this.dialogData = dialogData;
    }

    @Override
    public String toString() {
        return ToString.of(this).add("action", this.action).add("dialogData", this.dialogData).toString();
    }

    @Generated
    public SerializedData<?> getDialogData() {
        return this.dialogData;
    }

    @Generated
    public void setDialogData(SerializedData<?> dialogData) {
        this.dialogData = dialogData;
    }

    @Override
    @Generated
    public boolean equals(Object o2) {
        if (o2 == this) {
            return true;
        }
        if (!(o2 instanceof ShowDialogClickEvent)) {
            return false;
        }
        ShowDialogClickEvent other = (ShowDialogClickEvent)o2;
        if (!other.canEqual(this)) {
            return false;
        }
        SerializedData<?> this$dialogData = this.getDialogData();
        SerializedData<?> other$dialogData = other.getDialogData();
        return !(this$dialogData == null ? other$dialogData != null : !((Object)this$dialogData).equals(other$dialogData));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ShowDialogClickEvent;
    }

    @Override
    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        SerializedData<?> $dialogData = this.getDialogData();
        result = result * 59 + ($dialogData == null ? 43 : ((Object)$dialogData).hashCode());
        return result;
    }
}

