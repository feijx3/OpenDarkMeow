/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.HolderType;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="soundEvent", type=Holder.class), @RecordComponents.Value(name="useDuration", type=int.class), @RecordComponents.Value(name="range", type=float.class)})
@NestMembers(value={1.class})
public final class Instrument1_20_5
extends J_L_Record
implements Rewritable {
    private final Holder<SoundEvent> soundEvent;
    private final int useDuration;
    private final float range;
    public static final HolderType<Instrument1_20_5> TYPE = new HolderType<Instrument1_20_5>(){

        @Override
        public Instrument1_20_5 readDirect(ByteBuf buffer) {
            Object soundEvent = Types.SOUND_EVENT.read(buffer);
            int useDuration = Types.VAR_INT.readPrimitive(buffer);
            float range = Types.FLOAT.readPrimitive(buffer);
            return new Instrument1_20_5((Holder<SoundEvent>)soundEvent, useDuration, range);
        }

        @Override
        public void writeDirect(ByteBuf buffer, Instrument1_20_5 value) {
            Types.SOUND_EVENT.write(buffer, value.soundEvent());
            Types.VAR_INT.writePrimitive(buffer, value.useDuration());
            Types.FLOAT.writePrimitive(buffer, value.range());
        }
    };

    public Instrument1_20_5(Holder<SoundEvent> soundEvent, int useDuration, float range) {
        this.soundEvent = soundEvent;
        this.useDuration = useDuration;
        this.range = range;
    }

    @Override
    public Instrument1_20_5 rewrite(UserConnection connection, Protocol<?, ?, ?, ?> protocol, boolean clientbound) {
        Holder<SoundEvent> soundEvent = SoundEvent.rewriteHolder(this.soundEvent, Rewritable.soundRewriteFunction(protocol, clientbound));
        return soundEvent == this.soundEvent ? this : new Instrument1_20_5(soundEvent, this.useDuration, this.range);
    }

    @Override
    public final String toString() {
        return Instrument1_20_5.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return Instrument1_20_5.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return Instrument1_20_5.jvmdowngrader$equals$equals(this, o2);
    }

    public Holder<SoundEvent> soundEvent() {
        return this.soundEvent;
    }

    public int useDuration() {
        return this.useDuration;
    }

    public float range() {
        return this.range;
    }

    private static String jvmdowngrader$toString$toString(Instrument1_20_5 instrument1_20_5) {
        Instrument1_20_5 instrument1_20_52 = instrument1_20_5;
        return "Instrument1_20_5[" + "soundEvent=" + instrument1_20_5.soundEvent + ", " + "useDuration=" + instrument1_20_5.useDuration + ", " + "range=" + instrument1_20_5.range + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(Instrument1_20_5 instrument1_20_5) {
        Object[] objectArray = new Object[]{instrument1_20_5.soundEvent, instrument1_20_5.useDuration, Float.valueOf(instrument1_20_5.range)};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(Instrument1_20_5 instrument1_20_5, Object object) {
        if (instrument1_20_5 == object) {
            return true;
        }
        if (object != null && object instanceof Instrument1_20_5) {
            Instrument1_20_5 instrument1_20_52 = (Instrument1_20_5)object;
            if (Objects.equals(instrument1_20_5.soundEvent, instrument1_20_52.soundEvent) && instrument1_20_5.useDuration == instrument1_20_52.useDuration && instrument1_20_5.range == instrument1_20_52.range) {
                return true;
            }
        }
        return false;
    }
}

