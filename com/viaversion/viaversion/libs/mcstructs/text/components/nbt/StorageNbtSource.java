/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.viaversion.viaversion.libs.mcstructs.text.components.nbt;

import com.viaversion.viaversion.libs.mcstructs.core.Identifier;
import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.NbtDataSource;
import lombok.Generated;

public class StorageNbtSource
implements NbtDataSource {
    private Identifier id;

    public StorageNbtSource(Identifier id) {
        this.id = id;
    }

    public Identifier getId() {
        return this.id;
    }

    public StorageNbtSource setId(Identifier id) {
        this.id = id;
        return this;
    }

    @Override
    public StorageNbtSource copy() {
        return new StorageNbtSource(this.id);
    }

    public String toString() {
        return ToString.of(this).add("id", this.id).toString();
    }

    @Generated
    public boolean equals(Object o2) {
        if (o2 == this) {
            return true;
        }
        if (!(o2 instanceof StorageNbtSource)) {
            return false;
        }
        StorageNbtSource other = (StorageNbtSource)o2;
        if (!other.canEqual(this)) {
            return false;
        }
        Identifier this$id = this.getId();
        Identifier other$id = other.getId();
        return !(this$id == null ? other$id != null : !((Object)this$id).equals(other$id));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof StorageNbtSource;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Identifier $id = this.getId();
        result = result * 59 + ($id == null ? 43 : ((Object)$id).hashCode());
        return result;
    }
}

