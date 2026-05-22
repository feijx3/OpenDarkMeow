/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  lombok.Generated
 */
package com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl;

import com.viaversion.viaversion.libs.mcstructs.core.Identifier;
import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEventAction;
import java.util.Objects;
import java.util.UUID;
import javax.annotation.Nullable;
import lombok.Generated;

public class EntityHoverEvent
extends HoverEvent {
    private DataHolder data;

    public EntityHoverEvent(DataHolder data) {
        super(HoverEventAction.SHOW_ENTITY);
        this.data = data;
    }

    public EntityHoverEvent(TextComponent legacyData) {
        super(HoverEventAction.SHOW_ENTITY);
        this.data = new LegacyHolder(legacyData);
    }

    public EntityHoverEvent(Identifier type, UUID uuid, @Nullable TextComponent name) {
        super(HoverEventAction.SHOW_ENTITY);
        this.data = new ModernHolder(type, uuid, name);
    }

    public DataHolder getData() {
        return this.data;
    }

    public EntityHoverEvent setData(DataHolder data) {
        this.data = data;
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
        throw new UnsupportedOperationException("Data holder is not a legacy string holder: " + this.data);
    }

    public ModernHolder asModern() {
        if (this.data instanceof ModernHolder) {
            return (ModernHolder)this.data;
        }
        throw new UnsupportedOperationException("Data holder is not a modern holder: " + this.data);
    }

    public EntityHoverEvent setLegacyData(TextComponent data) {
        this.data = new LegacyHolder(data);
        return this;
    }

    public EntityHoverEvent setModernData(Identifier type, UUID uuid, @Nullable TextComponent name) {
        this.data = new ModernHolder(type, uuid, name);
        return this;
    }

    @Override
    public String toString() {
        return ToString.of(this).add("action", this.action).add("data", this.data).toString();
    }

    @Override
    @Generated
    public boolean equals(Object o2) {
        if (o2 == this) {
            return true;
        }
        if (!(o2 instanceof EntityHoverEvent)) {
            return false;
        }
        EntityHoverEvent other = (EntityHoverEvent)o2;
        if (!other.canEqual(this)) {
            return false;
        }
        DataHolder this$data = this.getData();
        DataHolder other$data = other.getData();
        return !(this$data == null ? other$data != null : !this$data.equals(other$data));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof EntityHoverEvent;
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
        private Identifier type;
        private UUID uuid;
        @Nullable
        private TextComponent name;

        public String toString() {
            return ToString.of(this).add("type", this.type).add("uuid", this.uuid).add("name", this.name, Objects::nonNull).toString();
        }

        @Generated
        public Identifier getType() {
            return this.type;
        }

        @Generated
        public UUID getUuid() {
            return this.uuid;
        }

        @Nullable
        @Generated
        public TextComponent getName() {
            return this.name;
        }

        @Generated
        public void setType(Identifier type) {
            this.type = type;
        }

        @Generated
        public void setUuid(UUID uuid) {
            this.uuid = uuid;
        }

        @Generated
        public void setName(@Nullable TextComponent name) {
            this.name = name;
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
            Identifier this$type = this.getType();
            Identifier other$type = other.getType();
            if (this$type == null ? other$type != null : !((Object)this$type).equals(other$type)) {
                return false;
            }
            UUID this$uuid = this.getUuid();
            UUID other$uuid = other.getUuid();
            if (this$uuid == null ? other$uuid != null : !((Object)this$uuid).equals(other$uuid)) {
                return false;
            }
            TextComponent this$name = this.getName();
            TextComponent other$name = other.getName();
            return !(this$name == null ? other$name != null : !((Object)this$name).equals(other$name));
        }

        @Generated
        protected boolean canEqual(Object other) {
            return other instanceof ModernHolder;
        }

        @Generated
        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            Identifier $type = this.getType();
            result = result * 59 + ($type == null ? 43 : ((Object)$type).hashCode());
            UUID $uuid = this.getUuid();
            result = result * 59 + ($uuid == null ? 43 : ((Object)$uuid).hashCode());
            TextComponent $name = this.getName();
            result = result * 59 + ($name == null ? 43 : ((Object)$name).hashCode());
            return result;
        }

        @Generated
        public ModernHolder(Identifier type, UUID uuid, @Nullable TextComponent name) {
            this.type = type;
            this.uuid = uuid;
            this.name = name;
        }
    }

    public static class LegacyHolder
    implements DataHolder {
        private TextComponent data;

        public String toString() {
            return ToString.of(this).add("data", this.data).toString();
        }

        @Generated
        public TextComponent getData() {
            return this.data;
        }

        @Generated
        public void setData(TextComponent data) {
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
            TextComponent this$data = this.getData();
            TextComponent other$data = other.getData();
            return !(this$data == null ? other$data != null : !((Object)this$data).equals(other$data));
        }

        @Generated
        protected boolean canEqual(Object other) {
            return other instanceof LegacyHolder;
        }

        @Generated
        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            TextComponent $data = this.getData();
            result = result * 59 + ($data == null ? 43 : ((Object)$data).hashCode());
            return result;
        }

        @Generated
        public LegacyHolder(TextComponent data) {
            this.data = data;
        }
    }

    public static interface DataHolder {
    }
}

