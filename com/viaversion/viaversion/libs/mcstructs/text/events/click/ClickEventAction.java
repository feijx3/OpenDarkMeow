/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.viaversion.viaversion.libs.mcstructs.text.events.click;

import com.viaversion.viaversion.libs.mcstructs.converter.types.NamedType;
import java.util.function.BiPredicate;
import javax.annotation.Nullable;

public enum ClickEventAction implements NamedType
{
    OPEN_URL("open_url", true),
    OPEN_FILE("open_file", false),
    RUN_COMMAND("run_command", true),
    TWITCH_USER_INFO("twitch_user_info", false),
    SUGGEST_COMMAND("suggest_command", true),
    CHANGE_PAGE("change_page", true),
    COPY_TO_CLIPBOARD("copy_to_clipboard", true),
    SHOW_DIALOG("show_dialog", true),
    CUSTOM("custom", true);

    private final String name;
    private final boolean userDefinable;

    @Nullable
    public static ClickEventAction byName(String name) {
        return ClickEventAction.byName(name, true);
    }

    @Nullable
    public static ClickEventAction byName(String name, boolean ignoreCase) {
        return ClickEventAction.byName(name, ignoreCase ? String::equalsIgnoreCase : String::equals);
    }

    @Nullable
    public static ClickEventAction byName(String name, BiPredicate<String, String> predicate) {
        for (ClickEventAction hoverEventAction : ClickEventAction.values()) {
            if (!predicate.test(name, hoverEventAction.getName())) continue;
            return hoverEventAction;
        }
        return null;
    }

    private ClickEventAction(String name, boolean userDefinable) {
        this.name = name;
        this.userDefinable = userDefinable;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public boolean isUserDefinable() {
        return this.userDefinable;
    }
}

