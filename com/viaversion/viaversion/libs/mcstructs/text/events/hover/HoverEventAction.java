/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.viaversion.viaversion.libs.mcstructs.text.events.hover;

import com.viaversion.viaversion.libs.mcstructs.converter.types.NamedType;
import java.util.function.BiPredicate;
import javax.annotation.Nullable;

public enum HoverEventAction implements NamedType
{
    SHOW_TEXT("show_text", true),
    SHOW_ACHIEVEMENT("show_achievement", true),
    SHOW_ITEM("show_item", true),
    SHOW_ENTITY("show_entity", true);

    private final String name;
    private final boolean userDefinable;

    @Nullable
    public static HoverEventAction byName(String name) {
        return HoverEventAction.byName(name, true);
    }

    @Nullable
    public static HoverEventAction byName(String name, boolean ignoreCase) {
        return HoverEventAction.byName(name, ignoreCase ? String::equalsIgnoreCase : String::equals);
    }

    @Nullable
    public static HoverEventAction byName(String name, BiPredicate<String, String> predicate) {
        for (HoverEventAction hoverEventAction : HoverEventAction.values()) {
            if (!predicate.test(name, hoverEventAction.getName())) continue;
            return hoverEventAction;
        }
        return null;
    }

    private HoverEventAction(String name, boolean userDefinable) {
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

