/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl;

import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEventAction;
import lombok.Generated;

public class AchievementHoverEvent
extends HoverEvent {
    private String statistic;

    public AchievementHoverEvent(String statistic) {
        super(HoverEventAction.SHOW_ACHIEVEMENT);
        this.statistic = statistic;
    }

    public String getStatistic() {
        return this.statistic;
    }

    public AchievementHoverEvent setStatistic(String statistic) {
        this.statistic = statistic;
        return this;
    }

    @Override
    public String toString() {
        return ToString.of(this).add("action", this.action).add("statistic", this.statistic).toString();
    }

    @Override
    @Generated
    public boolean equals(Object o2) {
        if (o2 == this) {
            return true;
        }
        if (!(o2 instanceof AchievementHoverEvent)) {
            return false;
        }
        AchievementHoverEvent other = (AchievementHoverEvent)o2;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$statistic = this.getStatistic();
        String other$statistic = other.getStatistic();
        return !(this$statistic == null ? other$statistic != null : !this$statistic.equals(other$statistic));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AchievementHoverEvent;
    }

    @Override
    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $statistic = this.getStatistic();
        result = result * 59 + ($statistic == null ? 43 : $statistic.hashCode());
        return result;
    }
}

