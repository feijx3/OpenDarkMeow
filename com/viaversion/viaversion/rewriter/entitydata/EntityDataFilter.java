/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.rewriter.entitydata;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityDataType;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectFunction;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import com.viaversion.viaversion.rewriter.entitydata.EntityDataHandler;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="type", type=EntityType.class), @RecordComponents.Value(name="filterFamily", type=boolean.class), @RecordComponents.Value(name="dataType", type=EntityDataType.class), @RecordComponents.Value(name="index", type=int.class), @RecordComponents.Value(name="handler", type=EntityDataHandler.class)})
@NestMembers(value={Builder.class})
public final class EntityDataFilter
extends J_L_Record {
    private final @Nullable EntityType type;
    private final boolean filterFamily;
    private final @Nullable EntityDataType dataType;
    private final int index;
    private final EntityDataHandler handler;

    public EntityDataFilter(@Nullable EntityType type, boolean filterFamily, @Nullable EntityDataType dataType, int index, EntityDataHandler handler) {
        Preconditions.checkNotNull((Object)handler, (Object)"EntityDataHandler cannot be null");
        this.type = type;
        this.filterFamily = filterFamily;
        this.dataType = dataType;
        this.index = index;
        this.handler = handler;
    }

    public int index() {
        return this.index;
    }

    public @Nullable EntityType type() {
        return this.type;
    }

    public @Nullable EntityDataType dataType() {
        return this.dataType;
    }

    public EntityDataHandler handler() {
        return this.handler;
    }

    public boolean filterFamily() {
        return this.filterFamily;
    }

    public boolean isFiltered(@Nullable EntityType type, EntityData entityData) {
        return !(this.index != -1 && entityData.id() != this.index || this.type != null && !this.matchesType(type) || this.dataType != null && entityData.dataType() != this.dataType);
    }

    private boolean matchesType(EntityType type) {
        if (type == null) {
            return false;
        }
        return this.filterFamily ? type.isOrHasParent(this.type) : this.type == type;
    }

    @Override
    public boolean equals(Object o2) {
        if (this == o2) {
            return true;
        }
        if (o2 == null || this.getClass() != o2.getClass()) {
            return false;
        }
        EntityDataFilter that = (EntityDataFilter)o2;
        if (this.index != that.index) {
            return false;
        }
        if (this.filterFamily != that.filterFamily) {
            return false;
        }
        if (!this.handler.equals(that.handler)) {
            return false;
        }
        if (!Objects.equals(this.dataType, that.dataType)) {
            return false;
        }
        return Objects.equals(this.type, that.type);
    }

    @Override
    public int hashCode() {
        int result = this.handler.hashCode();
        result = 31 * result + (this.type != null ? this.type.hashCode() : 0);
        result = 31 * result + (this.dataType != null ? this.dataType.hashCode() : 0);
        result = 31 * result + this.index;
        result = 31 * result + (this.filterFamily ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return EntityDataFilter.jvmdowngrader$concat$toString$1(String.valueOf(this.type), this.filterFamily, String.valueOf(this.dataType), this.index, String.valueOf(this.handler));
    }

    private static String jvmdowngrader$concat$toString$1(String string, boolean bl2, String string2, int n2, String string3) {
        return "EntityDataFilter{type=" + string + ", filterFamily=" + bl2 + ", dataType=" + string2 + ", index=" + n2 + ", handler=" + string3 + "}";
    }

    @NestHost(value=EntityDataFilter.class)
    public static final class Builder {
        private final EntityRewriter<?, ?> rewriter;
        private EntityType type;
        private EntityDataType dataType;
        private int index = -1;
        private boolean filterFamily;
        private EntityDataHandler handler;

        public Builder(EntityRewriter<?, ?> rewriter) {
            this.rewriter = rewriter;
        }

        public Builder dataType(EntityDataType dataType) {
            Preconditions.checkArgument((this.dataType == null ? 1 : 0) != 0);
            this.dataType = dataType;
            return this;
        }

        public Builder type(EntityType type) {
            Preconditions.checkArgument((this.type == null ? 1 : 0) != 0);
            this.type = type;
            this.filterFamily = true;
            return this;
        }

        public Builder exactType(EntityType type) {
            Preconditions.checkArgument((this.type == null ? 1 : 0) != 0);
            this.type = type;
            this.filterFamily = false;
            return this;
        }

        public Builder index(int index) {
            Preconditions.checkArgument((this.index == -1 ? 1 : 0) != 0);
            this.index = index;
            return this;
        }

        public Builder handlerNoRegister(EntityDataHandler handler) {
            Preconditions.checkArgument((this.handler == null ? 1 : 0) != 0);
            this.handler = handler;
            return this;
        }

        public void handler(EntityDataHandler handler) {
            Preconditions.checkArgument((this.handler == null ? 1 : 0) != 0);
            this.handler = handler;
            this.register();
        }

        public void mapDataType(Int2ObjectFunction<EntityDataType> updateFunction) {
            this.handler((event, data) -> {
                EntityDataType mappedType = (EntityDataType)updateFunction.apply(data.dataType().typeId());
                if (mappedType != null) {
                    data.setDataType(mappedType);
                } else {
                    event.cancel();
                }
            });
        }

        public void cancel(int index) {
            this.index = index;
            this.handler((event, data) -> event.cancel());
        }

        public void toIndex(int newIndex) {
            Preconditions.checkArgument((this.index != -1 ? 1 : 0) != 0);
            this.handler((event, data) -> event.setIndex(newIndex));
        }

        public void addIndex(int index) {
            Preconditions.checkArgument((this.index == -1 ? 1 : 0) != 0);
            this.handler((event, data) -> {
                if (event.index() >= index) {
                    event.setIndex(event.index() + 1);
                }
            });
        }

        public void removeIndex(int index) {
            Preconditions.checkArgument((this.index == -1 ? 1 : 0) != 0);
            this.handler((event, data) -> {
                int dataIndex = event.index();
                if (dataIndex == index) {
                    event.cancel();
                } else if (dataIndex > index) {
                    event.setIndex(dataIndex - 1);
                }
            });
        }

        public void register() {
            this.rewriter.registerFilter(this.build());
        }

        public EntityDataFilter build() {
            return new EntityDataFilter(this.type, this.filterFamily, this.dataType, this.index, this.handler);
        }
    }
}

