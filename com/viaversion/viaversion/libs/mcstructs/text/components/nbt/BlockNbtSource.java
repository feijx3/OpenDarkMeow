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

public class BlockNbtSource
implements NbtDataSource {
    private String pos;

    public BlockNbtSource(String pos) {
        this.pos = pos;
    }

    public String getPos() {
        return this.pos;
    }

    public BlockNbtSource setPos(String pos) {
        this.pos = pos;
        return this;
    }

    @Override
    public BlockNbtSource copy() {
        return new BlockNbtSource(this.pos);
    }

    public String toString() {
        return ToString.of(this).add("pos", this.pos).toString();
    }

    @Generated
    public boolean equals(Object o2) {
        if (o2 == this) {
            return true;
        }
        if (!(o2 instanceof BlockNbtSource)) {
            return false;
        }
        BlockNbtSource other = (BlockNbtSource)o2;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$pos = this.getPos();
        String other$pos = other.getPos();
        return !(this$pos == null ? other$pos != null : !this$pos.equals(other$pos));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof BlockNbtSource;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $pos = this.getPos();
        result = result * 59 + ($pos == null ? 43 : $pos.hashCode());
        return result;
    }
}

