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

public class TwitchUserInfoClickEvent
extends ClickEvent {
    private String user;

    public TwitchUserInfoClickEvent(String user) {
        super(ClickEventAction.TWITCH_USER_INFO);
        this.user = user;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return ToString.of(this).add("action", this.action).add("user", this.user).toString();
    }

    @Override
    @Generated
    public boolean equals(Object o2) {
        if (o2 == this) {
            return true;
        }
        if (!(o2 instanceof TwitchUserInfoClickEvent)) {
            return false;
        }
        TwitchUserInfoClickEvent other = (TwitchUserInfoClickEvent)o2;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$user = this.getUser();
        String other$user = other.getUser();
        return !(this$user == null ? other$user != null : !this$user.equals(other$user));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof TwitchUserInfoClickEvent;
    }

    @Override
    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $user = this.getUser();
        result = result * 59 + ($user == null ? 43 : $user.hashCode());
        return result;
    }
}

