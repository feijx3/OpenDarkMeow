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
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.EitherHolderType;
import com.viaversion.viaversion.api.type.types.misc.HolderType;
import com.viaversion.viaversion.util.Copyable;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="soundEvent", type=Holder.class), @RecordComponents.Value(name="useDuration", type=float.class), @RecordComponents.Value(name="range", type=float.class), @RecordComponents.Value(name="description", type=Tag.class)})
@NestMembers(value={1.class})
public final class Instrument1_21_2
extends J_L_Record
implements Copyable,
Rewritable {
    private final Holder<SoundEvent> soundEvent;
    private final float useDuration;
    private final float range;
    private final Tag description;
    public static final HolderType<Instrument1_21_2> TYPE = new HolderType<Instrument1_21_2>(){

        @Override
        public Instrument1_21_2 readDirect(ByteBuf buffer) {
            Object soundEvent = Types.SOUND_EVENT.read(buffer);
            float useDuration = Types.FLOAT.readPrimitive(buffer);
            float range = Types.FLOAT.readPrimitive(buffer);
            Tag description = (Tag)Types.TAG.read(buffer);
            return new Instrument1_21_2((Holder<SoundEvent>)soundEvent, useDuration, range, description);
        }

        @Override
        public void writeDirect(ByteBuf buffer, Instrument1_21_2 value) {
            Types.SOUND_EVENT.write(buffer, value.soundEvent());
            Types.FLOAT.writePrimitive(buffer, value.useDuration());
            Types.FLOAT.writePrimitive(buffer, value.range());
            Types.TAG.write(buffer, value.description());
        }
    };
    public static final EitherHolderType<Instrument1_21_2> EITHER_HOLDER_TYPE = new EitherHolderType<Instrument1_21_2>(TYPE);

    public Instrument1_21_2(Holder<SoundEvent> soundEvent, float useDuration, float range, Tag description) {
        this.soundEvent = soundEvent;
        this.useDuration = useDuration;
        this.range = range;
        this.description = description;
    }

    @Override
    public Instrument1_21_2 rewrite(UserConnection connection, Protocol<?, ?, ?, ?> protocol, boolean clientbound) {
        Holder<SoundEvent> soundEvent = SoundEvent.rewriteHolder(this.soundEvent, Rewritable.soundRewriteFunction(protocol, clientbound));
        return soundEvent == this.soundEvent ? this : new Instrument1_21_2(soundEvent, this.useDuration, this.range, this.description);
    }

    @Override
    public Instrument1_21_2 copy() {
        return new Instrument1_21_2(this.soundEvent, this.useDuration, this.range, this.description.copy());
    }

    @Override
    public final String toString() {
        return Instrument1_21_2.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return Instrument1_21_2.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return Instrument1_21_2.jvmdowngrader$equals$equals(this, o2);
    }

    public Holder<SoundEvent> soundEvent() {
        return this.soundEvent;
    }

    public float useDuration() {
        return this.useDuration;
    }

    public float range() {
        return this.range;
    }

    public Tag description() {
        return this.description;
    }

    private static String jvmdowngrader$toString$toString(Instrument1_21_2 instrument1_21_2) {
        Instrument1_21_2 instrument1_21_22 = instrument1_21_2;
        return "Instrument1_21_2[" + "soundEvent=" + instrument1_21_2.soundEvent + ", " + "useDuration=" + instrument1_21_2.useDuration + ", " + "range=" + instrument1_21_2.range + ", " + "description=" + instrument1_21_2.description + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(Instrument1_21_2 instrument1_21_2) {
        Object[] objectArray = new Object[]{instrument1_21_2.soundEvent, Float.valueOf(instrument1_21_2.useDuration), Float.valueOf(instrument1_21_2.range), instrument1_21_2.description};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(Instrument1_21_2 instrument1_21_2, Object object) {
        if (instrument1_21_2 == object) {
            return true;
        }
        if (object != null && object instanceof Instrument1_21_2) {
            Instrument1_21_2 instrument1_21_22 = (Instrument1_21_2)object;
            if (Objects.equals(instrument1_21_2.soundEvent, instrument1_21_22.soundEvent) && instrument1_21_2.useDuration == instrument1_21_22.useDuration && instrument1_21_2.range == instrument1_21_22.range && Objects.equals(instrument1_21_2.description, instrument1_21_22.description)) {
                return true;
            }
        }
        return false;
    }
}

