/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={FilterableType.class})
public abstract class Filterable<T> {
    private final T raw;
    private final T filtered;

    protected Filterable(T raw, @Nullable T filtered) {
        this.raw = raw;
        this.filtered = filtered;
    }

    public T raw() {
        return this.raw;
    }

    public boolean isFiltered() {
        return this.filtered != null;
    }

    public @Nullable T filtered() {
        return this.filtered;
    }

    public T get() {
        return this.filtered != null ? this.filtered : this.raw;
    }

    @NestHost(value=Filterable.class)
    public static abstract class FilterableType<T, F extends Filterable<T>>
    extends Type<F> {
        private final Type<T> elementType;
        private final Type<T> optionalElementType;

        protected FilterableType(Type<T> elementType, Type<T> optionalElementType, Class<F> outputClass) {
            super(outputClass);
            this.elementType = elementType;
            this.optionalElementType = optionalElementType;
        }

        @Override
        public F read(ByteBuf buffer) {
            Object raw = this.elementType.read(buffer);
            Object filtered = this.optionalElementType.read(buffer);
            return this.create(raw, filtered);
        }

        @Override
        public void write(ByteBuf buffer, F value) {
            this.elementType.write(buffer, ((Filterable)value).raw());
            this.optionalElementType.write(buffer, ((Filterable)value).filtered());
        }

        @Override
        public void write(Ops ops, F value) {
            ops.writeMap(map -> map.write("raw", this.elementType, value.raw()).writeOptional("filtered", this.elementType, value.filtered()));
        }

        protected abstract F create(T var1, T var2);
    }
}

