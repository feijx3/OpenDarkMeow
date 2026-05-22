/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.api.minecraft;

import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.util.Copyable;
import com.viaversion.viaversion.util.IdHolder;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.List;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={ParticleData.class})
public final class Particle
implements IdHolder,
Copyable {
    private final List<ParticleData<?>> arguments = new ArrayList(4);
    private int id;

    public Particle(int id) {
        this.id = id;
    }

    @Override
    public int id() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public <T> ParticleData<T> getArgument(int index) {
        return this.arguments.get(index);
    }

    public <T> ParticleData<T> removeArgument(int index) {
        return this.arguments.remove(index);
    }

    public List<ParticleData<?>> getArguments() {
        return this.arguments;
    }

    public <T> void add(Type<T> type, T value) {
        this.arguments.add(new ParticleData<T>(type, value));
    }

    public <T> void add(int index, Type<T> type, T value) {
        this.arguments.add(index, new ParticleData<T>(type, value));
    }

    public <T> void set(int index, Type<T> type, T value) {
        this.arguments.set(index, new ParticleData<T>(type, value));
    }

    @Override
    public Particle copy() {
        Particle particle = new Particle(this.id);
        for (ParticleData<?> argument : this.arguments) {
            particle.arguments.add((ParticleData<?>)argument.copy());
        }
        return particle;
    }

    public String toString() {
        return Particle.jvmdowngrader$concat$toString$1(String.valueOf(this.arguments), this.id);
    }

    private static String jvmdowngrader$concat$toString$1(String string, int n2) {
        return "Particle{arguments=" + string + ", id=" + n2 + "}";
    }

    @NestHost(value=Particle.class)
    public static final class ParticleData<T>
    implements Copyable {
        private final Type<T> type;
        private T value;

        public ParticleData(Type<T> type, T value) {
            this.type = type;
            this.value = value;
        }

        public Type<T> getType() {
            return this.type;
        }

        public T getValue() {
            return this.value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void write(ByteBuf buf) {
            this.type.write(buf, this.value);
        }

        public void write(PacketWrapper wrapper) {
            wrapper.write(this.type, this.value);
        }

        @Override
        public ParticleData<T> copy() {
            return new ParticleData<T>(this.type, Copyable.copy(this.value));
        }

        public String toString() {
            return ParticleData.jvmdowngrader$concat$toString$1(String.valueOf(this.type), String.valueOf(this.value));
        }

        private static String jvmdowngrader$concat$toString$1(String string, String string2) {
            return "ParticleData{type=" + string + ", value=" + string2 + "}";
        }
    }
}

