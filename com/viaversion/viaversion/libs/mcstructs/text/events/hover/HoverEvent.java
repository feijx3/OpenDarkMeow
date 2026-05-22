/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.viaversion.viaversion.libs.mcstructs.text.events.hover;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.libs.mcstructs.core.Identifier;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEventAction;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.AchievementHoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.EntityHoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.ItemHoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.TextHoverEvent;
import java.util.UUID;
import javax.annotation.Nullable;

public abstract class HoverEvent {
    protected HoverEventAction action;

    public static TextHoverEvent text(TextComponent text) {
        return new TextHoverEvent(text);
    }

    public static AchievementHoverEvent achievement(String statistic) {
        return new AchievementHoverEvent(statistic);
    }

    public static ItemHoverEvent item(Identifier item, int count, @Nullable CompoundTag nbt) {
        return new ItemHoverEvent(item, count, nbt);
    }

    public static EntityHoverEvent entity(Identifier entityType, UUID uuid, @Nullable TextComponent name) {
        return new EntityHoverEvent(entityType, uuid, name);
    }

    public HoverEvent(HoverEventAction action) {
        this.action = action;
    }

    public HoverEventAction getAction() {
        return this.action;
    }

    public abstract boolean equals(Object var1);

    public abstract int hashCode();

    public abstract String toString();
}

