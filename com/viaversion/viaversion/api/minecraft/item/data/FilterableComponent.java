/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.item.data.Filterable;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import com.viaversion.viaversion.util.Copyable;
import com.viaversion.viaversion.util.Rewritable;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={1.class})
public final class FilterableComponent
extends Filterable<Tag>
implements Copyable,
Rewritable {
    public static final Type<FilterableComponent> TYPE = new Filterable.FilterableType<Tag, FilterableComponent>(Types.TAG, Types.OPTIONAL_TAG, FilterableComponent.class){

        @Override
        protected FilterableComponent create(Tag raw, Tag filtered) {
            return new FilterableComponent(raw, filtered);
        }
    };
    public static final Type<FilterableComponent[]> ARRAY_TYPE = new ArrayType<FilterableComponent>(TYPE);

    public FilterableComponent(Tag raw, @Nullable Tag filtered) {
        super(raw, filtered);
    }

    @Override
    public FilterableComponent rewrite(UserConnection connection, Protocol<?, ?, ?, ?> protocol, boolean clientbound) {
        if (protocol.getComponentRewriter() == null) {
            return this;
        }
        FilterableComponent copy = this.copy();
        protocol.getComponentRewriter().processTag(connection, (Tag)copy.raw());
        protocol.getComponentRewriter().processTag(connection, (Tag)copy.filtered());
        return copy;
    }

    @Override
    public FilterableComponent copy() {
        return new FilterableComponent(((Tag)this.raw()).copy(), this.filtered() != null ? ((Tag)this.filtered()).copy() : null);
    }
}

