/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.EitherHolder;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.EitherHolderType;
import com.viaversion.viaversion.api.type.types.misc.HolderType;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="song", type=EitherHolder.class), @RecordComponents.Value(name="showInTooltip", type=boolean.class)})
@NestMembers(value={JukeboxSong.class, JukeboxSong.1.class, 2.class, 1.class})
public final class JukeboxPlayable
extends J_L_Record
implements Rewritable {
    private final EitherHolder<JukeboxSong> song;
    private final boolean showInTooltip;
    public static final Type<JukeboxPlayable> TYPE1_21 = new Type<JukeboxPlayable>(JukeboxPlayable.class){

        @Override
        public JukeboxPlayable read(ByteBuf buffer) {
            EitherHolder<JukeboxSong> position = EitherHolderType.read(buffer, JukeboxSong.TYPE);
            boolean showInTooltip = buffer.readBoolean();
            return new JukeboxPlayable(position, showInTooltip);
        }

        @Override
        public void write(ByteBuf buffer, JukeboxPlayable value) {
            EitherHolderType.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_JukeboxPlayable$get$song(), JukeboxSong.TYPE);
            buffer.writeBoolean(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_JukeboxPlayable$get$showInTooltip());
        }
    };
    public static final Type<JukeboxPlayable> TYPE1_21_5 = new Type<JukeboxPlayable>(JukeboxPlayable.class){

        @Override
        public JukeboxPlayable read(ByteBuf buffer) {
            EitherHolder<JukeboxSong> position = EitherHolderType.read(buffer, JukeboxSong.TYPE);
            return new JukeboxPlayable(position, true);
        }

        @Override
        public void write(ByteBuf buffer, JukeboxPlayable value) {
            EitherHolderType.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_JukeboxPlayable$get$song(), JukeboxSong.TYPE);
        }
    };

    public JukeboxPlayable(Holder<JukeboxSong> song, boolean showInTooltip) {
        this(EitherHolder.of(song), showInTooltip);
    }

    public JukeboxPlayable(String resourceKey, boolean showInTooltip) {
        this(EitherHolder.of(resourceKey), showInTooltip);
    }

    public JukeboxPlayable(EitherHolder<JukeboxSong> song, boolean showInTooltip) {
        this.song = song;
        this.showInTooltip = showInTooltip;
    }

    @Override
    public JukeboxPlayable rewrite(UserConnection connection, Protocol<?, ?, ?, ?> protocol, boolean clientbound) {
        if (this.song.hasKey()) {
            return this;
        }
        Holder<JukeboxSong> songHolder = this.song.holder();
        if (songHolder.hasId()) {
            return this;
        }
        Object rewrittenSong = songHolder.value().rewrite(connection, (Protocol)protocol, clientbound);
        return rewrittenSong == songHolder.value() ? this : new JukeboxPlayable(Holder.of(rewrittenSong), this.showInTooltip);
    }

    @Override
    public final String toString() {
        return JukeboxPlayable.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return JukeboxPlayable.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return JukeboxPlayable.jvmdowngrader$equals$equals(this, o2);
    }

    public EitherHolder<JukeboxSong> song() {
        return this.song;
    }

    public boolean showInTooltip() {
        return this.showInTooltip;
    }

    private static String jvmdowngrader$toString$toString(JukeboxPlayable jukeboxPlayable) {
        JukeboxPlayable jukeboxPlayable2 = jukeboxPlayable;
        return "JukeboxPlayable[" + "song=" + jukeboxPlayable.song + ", " + "showInTooltip=" + jukeboxPlayable.showInTooltip + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(JukeboxPlayable jukeboxPlayable) {
        Object[] objectArray = new Object[]{jukeboxPlayable.song, jukeboxPlayable.showInTooltip};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(JukeboxPlayable jukeboxPlayable, Object object) {
        if (jukeboxPlayable == object) {
            return true;
        }
        if (object != null && object instanceof JukeboxPlayable) {
            JukeboxPlayable jukeboxPlayable2 = (JukeboxPlayable)object;
            if (Objects.equals(jukeboxPlayable.song, jukeboxPlayable2.song) && jukeboxPlayable.showInTooltip == jukeboxPlayable2.showInTooltip) {
                return true;
            }
        }
        return false;
    }

    public EitherHolder jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_JukeboxPlayable$get$song() {
        return this.song;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_JukeboxPlayable$set$song(EitherHolder eitherHolder) {
        this.song = eitherHolder;
    }

    public boolean jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_JukeboxPlayable$get$showInTooltip() {
        return this.showInTooltip;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_JukeboxPlayable$set$showInTooltip(boolean bl2) {
        this.showInTooltip = bl2;
    }

    @RecordComponents(value={@RecordComponents.Value(name="soundEvent", type=Holder.class), @RecordComponents.Value(name="description", type=Tag.class), @RecordComponents.Value(name="lengthInSeconds", type=float.class), @RecordComponents.Value(name="comparatorOutput", type=int.class)})
    @NestHost(value=JukeboxPlayable.class)
    public static final class JukeboxSong
    extends J_L_Record
    implements Rewritable {
        private final Holder<SoundEvent> soundEvent;
        private final Tag description;
        private final float lengthInSeconds;
        private final int comparatorOutput;
        public static final HolderType<JukeboxSong> TYPE = new HolderType<JukeboxSong>(){

            @Override
            public JukeboxSong readDirect(ByteBuf buffer) {
                Object soundEvent = Types.SOUND_EVENT.read(buffer);
                Tag description = (Tag)Types.TAG.read(buffer);
                float lengthInSeconds = buffer.readFloat();
                int useDuration = Types.VAR_INT.readPrimitive(buffer);
                return new JukeboxSong((Holder<SoundEvent>)soundEvent, description, lengthInSeconds, useDuration);
            }

            @Override
            public void writeDirect(ByteBuf buffer, JukeboxSong value) {
                Types.SOUND_EVENT.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_JukeboxPlayable$JukeboxSong$get$soundEvent());
                Types.TAG.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_JukeboxPlayable$JukeboxSong$get$description());
                buffer.writeFloat(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_JukeboxPlayable$JukeboxSong$get$lengthInSeconds());
                Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_JukeboxPlayable$JukeboxSong$get$comparatorOutput());
            }
        };

        public JukeboxSong(Holder<SoundEvent> soundEvent, Tag description, float lengthInSeconds, int comparatorOutput) {
            this.soundEvent = soundEvent;
            this.description = description;
            this.lengthInSeconds = lengthInSeconds;
            this.comparatorOutput = comparatorOutput;
        }

        @Override
        public JukeboxSong rewrite(UserConnection connection, Protocol<?, ?, ?, ?> protocol, boolean clientbound) {
            Holder<SoundEvent> soundEvent = SoundEvent.rewriteHolder(this.soundEvent, Rewritable.soundRewriteFunction(protocol, clientbound));
            return soundEvent == this.soundEvent ? this : new JukeboxSong(soundEvent, this.description, this.lengthInSeconds, this.comparatorOutput);
        }

        @Override
        public final String toString() {
            return JukeboxSong.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return JukeboxSong.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return JukeboxSong.jvmdowngrader$equals$equals(this, o2);
        }

        public Holder<SoundEvent> soundEvent() {
            return this.soundEvent;
        }

        public Tag description() {
            return this.description;
        }

        public float lengthInSeconds() {
            return this.lengthInSeconds;
        }

        public int comparatorOutput() {
            return this.comparatorOutput;
        }

        private static String jvmdowngrader$toString$toString(JukeboxSong jukeboxSong) {
            JukeboxSong jukeboxSong2 = jukeboxSong;
            return "JukeboxPlayable$JukeboxSong[" + "soundEvent=" + jukeboxSong.soundEvent + ", " + "description=" + jukeboxSong.description + ", " + "lengthInSeconds=" + jukeboxSong.lengthInSeconds + ", " + "comparatorOutput=" + jukeboxSong.comparatorOutput + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(JukeboxSong jukeboxSong) {
            Object[] objectArray = new Object[]{jukeboxSong.soundEvent, jukeboxSong.description, Float.valueOf(jukeboxSong.lengthInSeconds), jukeboxSong.comparatorOutput};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(JukeboxSong jukeboxSong, Object object) {
            if (jukeboxSong == object) {
                return true;
            }
            if (object != null && object instanceof JukeboxSong) {
                JukeboxSong jukeboxSong2 = (JukeboxSong)object;
                if (Objects.equals(jukeboxSong.soundEvent, jukeboxSong2.soundEvent) && Objects.equals(jukeboxSong.description, jukeboxSong2.description) && jukeboxSong.lengthInSeconds == jukeboxSong2.lengthInSeconds && jukeboxSong.comparatorOutput == jukeboxSong2.comparatorOutput) {
                    return true;
                }
            }
            return false;
        }

        public Tag jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_JukeboxPlayable$JukeboxSong$get$description() {
            return this.description;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_JukeboxPlayable$JukeboxSong$set$description(Tag tag) {
            this.description = tag;
        }

        public Holder jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_JukeboxPlayable$JukeboxSong$get$soundEvent() {
            return this.soundEvent;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_JukeboxPlayable$JukeboxSong$set$soundEvent(Holder holder) {
            this.soundEvent = holder;
        }

        public float jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_JukeboxPlayable$JukeboxSong$get$lengthInSeconds() {
            return this.lengthInSeconds;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_JukeboxPlayable$JukeboxSong$set$lengthInSeconds(float f2) {
            this.lengthInSeconds = f2;
        }

        public int jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_JukeboxPlayable$JukeboxSong$get$comparatorOutput() {
            return this.comparatorOutput;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_JukeboxPlayable$JukeboxSong$set$comparatorOutput(int n2) {
            this.comparatorOutput = n2;
        }
    }
}

