/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  lombok.Generated
 */
package com.viaversion.viaversion.libs.mcstructs.text.components;

import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import java.util.Objects;
import javax.annotation.Nullable;
import lombok.Generated;

public class ScoreComponent
extends TextComponent {
    private String name;
    private String objective;
    @Nullable
    private String value;

    public ScoreComponent(String name, String objective) {
        this(name, objective, null);
    }

    public ScoreComponent(String name, String objective, @Nullable String value) {
        this.name = name;
        this.objective = objective;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public ScoreComponent setName(String name) {
        this.name = name;
        return this;
    }

    public String getObjective() {
        return this.objective;
    }

    public ScoreComponent setObjective(@Nullable String objective) {
        this.objective = objective;
        return this;
    }

    @Nullable
    public String getValue() {
        return this.value;
    }

    public ScoreComponent setValue(@Nullable String value) {
        this.value = value;
        return this;
    }

    @Override
    public String asSingleString() {
        return this.value;
    }

    @Override
    public TextComponent copy() {
        return this.copyMetaTo(this.shallowCopy());
    }

    @Override
    public TextComponent shallowCopy() {
        ScoreComponent copy = new ScoreComponent(this.name, this.objective);
        copy.value = this.value;
        return copy.setStyle(this.getStyle().copy());
    }

    @Override
    public String toString() {
        return ToString.of(this).add("siblings", this.getSiblings(), siblings -> !siblings.isEmpty()).add("style", this.getStyle(), style -> !style.isEmpty()).add("name", this.name).add("objective", this.objective).add("value", this.value, Objects::nonNull).toString();
    }

    @Override
    @Generated
    public boolean equals(Object o2) {
        if (o2 == this) {
            return true;
        }
        if (!(o2 instanceof ScoreComponent)) {
            return false;
        }
        ScoreComponent other = (ScoreComponent)o2;
        if (!other.canEqual(this)) {
            return false;
        }
        if (!super.equals(o2)) {
            return false;
        }
        String this$name = this.getName();
        String other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        String this$objective = this.getObjective();
        String other$objective = other.getObjective();
        if (this$objective == null ? other$objective != null : !this$objective.equals(other$objective)) {
            return false;
        }
        String this$value = this.getValue();
        String other$value = other.getValue();
        return !(this$value == null ? other$value != null : !this$value.equals(other$value));
    }

    @Override
    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ScoreComponent;
    }

    @Override
    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = super.hashCode();
        String $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        String $objective = this.getObjective();
        result = result * 59 + ($objective == null ? 43 : $objective.hashCode());
        String $value = this.getValue();
        result = result * 59 + ($value == null ? 43 : $value.hashCode());
        return result;
    }
}

