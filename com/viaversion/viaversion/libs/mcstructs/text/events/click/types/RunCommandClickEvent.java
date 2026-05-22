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

public class RunCommandClickEvent
extends ClickEvent {
    private String command;

    public RunCommandClickEvent(String command) {
        super(ClickEventAction.RUN_COMMAND);
        this.command = command;
    }

    public String getCommand() {
        return this.command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return ToString.of(this).add("action", this.action).add("command", this.command).toString();
    }

    @Override
    @Generated
    public boolean equals(Object o2) {
        if (o2 == this) {
            return true;
        }
        if (!(o2 instanceof RunCommandClickEvent)) {
            return false;
        }
        RunCommandClickEvent other = (RunCommandClickEvent)o2;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$command = this.getCommand();
        String other$command = other.getCommand();
        return !(this$command == null ? other$command != null : !this$command.equals(other$command));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof RunCommandClickEvent;
    }

    @Override
    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $command = this.getCommand();
        result = result * 59 + ($command == null ? 43 : $command.hashCode());
        return result;
    }
}

