/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.viaversion.viaversion.libs.mcstructs.text.events.click;

import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.libs.mcstructs.converter.SerializedData;
import com.viaversion.viaversion.libs.mcstructs.core.Identifier;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEventAction;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.ChangePageClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.CopyToClipboardClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.CustomClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.OpenFileClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.OpenUrlClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.RunCommandClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.ShowDialogClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.SuggestCommandClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.TwitchUserInfoClickEvent;
import java.net.URI;
import javax.annotation.Nullable;

public abstract class ClickEvent {
    protected final ClickEventAction action;

    public static OpenUrlClickEvent openUrl(URI url) {
        return new OpenUrlClickEvent(url);
    }

    public static OpenFileClickEvent openFile(String path) {
        return new OpenFileClickEvent(path);
    }

    public static RunCommandClickEvent runCommand(String command) {
        return new RunCommandClickEvent(command);
    }

    public static TwitchUserInfoClickEvent twitchUserInfo(String user) {
        return new TwitchUserInfoClickEvent(user);
    }

    public static SuggestCommandClickEvent suggestCommand(String command) {
        return new SuggestCommandClickEvent(command);
    }

    public static ChangePageClickEvent changePage(int page) {
        return new ChangePageClickEvent(page);
    }

    public static CopyToClipboardClickEvent copyToClipboard(String value) {
        return new CopyToClipboardClickEvent(value);
    }

    public static ShowDialogClickEvent showDialog(SerializedData<?> dialogData) {
        return new ShowDialogClickEvent(dialogData);
    }

    public static CustomClickEvent custom(Identifier id, @Nullable Tag payload) {
        return new CustomClickEvent(id, payload);
    }

    public ClickEvent(ClickEventAction action) {
        this.action = action;
    }

    public ClickEventAction getAction() {
        return this.action;
    }

    public abstract boolean equals(Object var1);

    public abstract int hashCode();

    public abstract String toString();
}

