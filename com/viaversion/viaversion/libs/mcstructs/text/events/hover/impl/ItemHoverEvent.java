/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  lombok.Generated
 */
package com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.libs.mcstructs.core.Identifier;
import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEventAction;
import java.util.Objects;
import javax.annotation.Nullable;
import lombok.Generated;

public class ItemHoverEvent
extends HoverEvent {
    private DataHolder data;

    public ItemHoverEvent(DataHolder data) {
        super(HoverEventAction.SHOW_ITEM);
        this.data = data;
    }

    public ItemHoverEvent(String legacyData) {
        super(HoverEventAction.SHOW_ITEM);
        this.data = new LegacyHolder(legacyData);
    }

    public ItemHoverEvent(Identifier id, int count, @Nullable CompoundTag tag) {
        super(HoverEventAction.SHOW_ITEM);
        this.data = new ModernHolder(id, count, tag);
    }

    public DataHolder getData() {
        return this.data;
    }

    public ItemHoverEvent setData(String data) {
        this.data = new LegacyHolder(data);
        return this;
    }

    public boolean isLegacy() {
        return this.data instanceof LegacyHolder;
    }

    public boolean isModern() {
        return this.data instanceof ModernHolder;
    }

    public LegacyHolder asLegacy() {
        if (this.data instanceof LegacyHolder) {
            return (LegacyHolder)this.data;
        }
        throw new UnsupportedOperationException("Data holder is not a legacy raw holder: " + this.data);
    }

    public ModernHolder asModern() {
        if (this.data instanceof ModernHolder) {
            return (ModernHolder)this.data;
        }
        throw new UnsupportedOperationException("Data holder is not a modern holder: " + this.data);
    }

    public ItemHoverEvent setLegacyData(String data) {
        this.data = new LegacyHolder(data);
        return this;
    }

    public ItemHoverEvent setModernData(Identifier id, int count, @Nullable CompoundTag tag) {
        this.data = new ModernHolder(id, count, tag);
        return this;
    }

    @Override
    public String toString() {
        return ToString.of(this).put("action", this.action).put("data", this.data).toString();
    }

    @Override
    @Generated
    public boolean equals(Object o2) {
        if (o2 == this) {
            return true;
        }
        if (!(o2 instanceof ItemHoverEvent)) {
            return false;
        }
        ItemHoverEvent other = (ItemHoverEvent)o2;
        if (!other.canEqual(this)) {
            return false;
        }
        DataHolder this$data = this.getData();
        DataHolder other$data = other.getData();
        return !(this$data == null ? other$data != null : !this$data.equals(other$data));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ItemHoverEvent;
    }

    @Override
    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        DataHolder $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public static class ModernHolder
    implements DataHolder {
        private Identifier id;
        private int count;
        @Nullable
        private CompoundTag tag;

        public String toString() {
            return ToString.of(this).put("id", this.id).put("count", this.count, c2 -> c2 != 1).put("tag", this.tag, Objects::nonNull).toString();
        }

        @Generated
        public Identifier getId() {
            return this.id;
        }

        @Generated
        public int getCount() {
            return this.count;
        }

        @Nullable
        @Generated
        public CompoundTag getTag() {
            return this.tag;
        }

        @Generated
        public void setId(Identifier id) {
            this.id = id;
        }

        @Generated
        public void setCount(int count) {
            this.count = count;
        }

        @Generated
        public void setTag(@Nullable CompoundTag tag) {
            this.tag = tag;
        }

        @Generated
        public boolean equals(Object o2) {
            if (o2 == this) {
                return true;
            }
            if (!(o2 instanceof ModernHolder)) {
                return false;
            }
            ModernHolder other = (ModernHolder)o2;
            if (!other.canEqual(this)) {
                return false;
            }
            if (this.getCount() != other.getCount()) {
                return false;
            }
            Identifier this$id = this.getId();
            Identifier other$id = other.getId();
            if (this$id == null ? other$id != null : !((Object)this$id).equals(other$id)) {
                return false;
            }
            CompoundTag this$tag = this.getTag();
            CompoundTag other$tag = other.getTag();
            return !(this$tag == null ? other$tag != null : !((Object)this$tag).equals(other$tag));
        }

        @Generated
        protected boolean canEqual(Object other) {
            return other instanceof ModernHolder;
        }

        @Generated
        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            result = result * 59 + this.getCount();
            Identifier $id = this.getId();
            result = result * 59 + ($id == null ? 43 : ((Object)$id).hashCode());
            CompoundTag $tag = this.getTag();
            result = result * 59 + ($tag == null ? 43 : ((Object)$tag).hashCode());
            return result;
        }

        @Generated
        public ModernHolder(Identifier id, int count, @Nullable CompoundTag tag) {
            this.id = id;
            this.count = count;
            this.tag = tag;
        }
    }

    public static class LegacyHolder
    implements DataHolder {
        private String data;

        public String toString() {
            return ToString.of(this).put("data", this.data).toString();
        }

        @Generated
        public String getData() {
            return this.data;
        }

        @Generated
        public void setData(String data) {
            this.data = data;
        }

        @Generated
        public boolean equals(Object o2) {
            if (o2 == this) {
                return true;
            }
            if (!(o2 instanceof LegacyHolder)) {
                return false;
            }
            LegacyHolder other = (LegacyHolder)o2;
            if (!other.canEqual(this)) {
                return false;
            }
            String this$data = this.getData();
            String other$data = other.getData();
            return !(this$data == null ? other$data != null : !this$data.equals(other$data));
        }

        @Generated
        protected boolean canEqual(Object other) {
            return other instanceof LegacyHolder;
        }

        @Generated
        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            String $data = this.getData();
            result = result * 59 + ($data == null ? 43 : $data.hashCode());
            return result;
        }

        @Generated
        public LegacyHolder(String data) {
            this.data = data;
        }
    }

    public static interface DataHolder {
    }
}

