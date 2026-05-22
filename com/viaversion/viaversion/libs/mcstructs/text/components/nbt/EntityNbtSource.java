/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.viaversion.viaversion.libs.mcstructs.text.components.nbt;

import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.NbtDataSource;
import lombok.Generated;

public class EntityNbtSource
implements NbtDataSource {
    private String selector;

    public EntityNbtSource(String selector) {
        this.selector = selector;
    }

    public String getSelector() {
        return this.selector;
    }

    public EntityNbtSource setSelector(String selector) {
        this.selector = selector;
        return this;
    }

    @Override
    public EntityNbtSource copy() {
        return new EntityNbtSource(this.selector);
    }

    public String toString() {
        return ToString.of(this).add("selector", this.selector).toString();
    }

    @Generated
    public boolean equals(Object o2) {
        if (o2 == this) {
            return true;
        }
        if (!(o2 instanceof EntityNbtSource)) {
            return false;
        }
        EntityNbtSource other = (EntityNbtSource)o2;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$selector = this.getSelector();
        String other$selector = other.getSelector();
        return !(this$selector == null ? other$selector != null : !this$selector.equals(other$selector));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof EntityNbtSource;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $selector = this.getSelector();
        result = result * 59 + ($selector == null ? 43 : $selector.hashCode());
        return result;
    }
}

