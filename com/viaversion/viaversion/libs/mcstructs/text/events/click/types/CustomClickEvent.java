/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  lombok.Generated
 */
package com.viaversion.viaversion.libs.mcstructs.text.events.click.types;

import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.libs.mcstructs.core.Identifier;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEventAction;
import javax.annotation.Nullable;
import lombok.Generated;

public class CustomClickEvent
extends ClickEvent {
    private Identifier id;
    @Nullable
    private Tag payload;

    public CustomClickEvent(Identifier id, @Nullable Tag payload) {
        super(ClickEventAction.CUSTOM);
        this.id = id;
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "";
    }

    @Generated
    public Identifier getId() {
        return this.id;
    }

    @Nullable
    @Generated
    public Tag getPayload() {
        return this.payload;
    }

    @Generated
    public void setId(Identifier id) {
        this.id = id;
    }

    @Generated
    public void setPayload(@Nullable Tag payload) {
        this.payload = payload;
    }

    @Override
    @Generated
    public boolean equals(Object o2) {
        if (o2 == this) {
            return true;
        }
        if (!(o2 instanceof CustomClickEvent)) {
            return false;
        }
        CustomClickEvent other = (CustomClickEvent)o2;
        if (!other.canEqual(this)) {
            return false;
        }
        Identifier this$id = this.getId();
        Identifier other$id = other.getId();
        if (this$id == null ? other$id != null : !((Object)this$id).equals(other$id)) {
            return false;
        }
        Tag this$payload = this.getPayload();
        Tag other$payload = other.getPayload();
        return !(this$payload == null ? other$payload != null : !this$payload.equals(other$payload));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof CustomClickEvent;
    }

    @Override
    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Identifier $id = this.getId();
        result = result * 59 + ($id == null ? 43 : ((Object)$id).hashCode());
        Tag $payload = this.getPayload();
        result = result * 59 + ($payload == null ? 43 : $payload.hashCode());
        return result;
    }
}

