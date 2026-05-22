/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={OptionalHolderType.class})
public abstract class HolderType<T>
extends Type<Holder<T>> {
    protected HolderType() {
        super(Holder.class);
    }

    @Override
    public Holder<T> read(ByteBuf buffer) {
        int id = Types.VAR_INT.readPrimitive(buffer) - 1;
        if (id == -1) {
            return Holder.of(this.readDirect(buffer));
        }
        return Holder.of(id);
    }

    @Override
    public void write(ByteBuf buffer, Holder<T> object) {
        if (object.hasId()) {
            Types.VAR_INT.writePrimitive(buffer, object.id() + 1);
        } else {
            Types.VAR_INT.writePrimitive(buffer, 0);
            this.writeDirect(buffer, object.value());
        }
    }

    public abstract T readDirect(ByteBuf var1);

    public abstract void writeDirect(ByteBuf var1, T var2);

    @NestHost(value=HolderType.class)
    public static abstract class OptionalHolderType<T>
    extends HolderType<T> {
        private final HolderType<T> type;

        protected OptionalHolderType(HolderType<T> type) {
            this.type = type;
        }

        @Override
        public Holder<T> read(ByteBuf buffer) {
            return buffer.readBoolean() ? super.read(buffer) : null;
        }

        @Override
        public void write(ByteBuf buffer, Holder<T> object) {
            if (object != null) {
                buffer.writeBoolean(true);
                super.write(buffer, object);
            } else {
                buffer.writeBoolean(false);
            }
        }

        @Override
        public @Nullable T readDirect(ByteBuf buffer) {
            return this.type.readDirect(buffer);
        }

        @Override
        public void writeDirect(ByteBuf buffer, @Nullable T value) {
            this.type.writeDirect(buffer, value);
        }
    }
}

