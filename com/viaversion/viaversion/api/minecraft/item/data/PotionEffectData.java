/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="amplifier", type=int.class), @RecordComponents.Value(name="duration", type=int.class), @RecordComponents.Value(name="ambient", type=boolean.class), @RecordComponents.Value(name="showParticles", type=boolean.class), @RecordComponents.Value(name="showIcon", type=boolean.class), @RecordComponents.Value(name="hiddenEffect", type=PotionEffectData.class)})
@NestMembers(value={2.class, 1.class})
public final class PotionEffectData
extends J_L_Record {
    private final int amplifier;
    private final int duration;
    private final boolean ambient;
    private final boolean showParticles;
    private final boolean showIcon;
    private final @Nullable PotionEffectData hiddenEffect;
    public static final Type<PotionEffectData> TYPE = new Type<PotionEffectData>(PotionEffectData.class){

        @Override
        public PotionEffectData read(ByteBuf buffer) {
            int amplifier = Types.VAR_INT.readPrimitive(buffer);
            int duration = Types.VAR_INT.readPrimitive(buffer);
            boolean ambient = buffer.readBoolean();
            boolean showParticles = buffer.readBoolean();
            boolean showIcon = buffer.readBoolean();
            PotionEffectData hiddenEffect = (PotionEffectData)OPTIONAL_TYPE.read(buffer);
            return new PotionEffectData(amplifier, duration, ambient, showParticles, showIcon, hiddenEffect);
        }

        @Override
        public void write(ByteBuf buffer, PotionEffectData value) {
            Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffectData$get$amplifier());
            Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffectData$get$duration());
            buffer.writeBoolean(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffectData$get$ambient());
            buffer.writeBoolean(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffectData$get$showParticles());
            buffer.writeBoolean(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffectData$get$showIcon());
            OPTIONAL_TYPE.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffectData$get$hiddenEffect());
        }

        @Override
        public void write(Ops ops, PotionEffectData value) {
            ops.writeMap(map -> map.writeOptional("amplifier", Types.UNSIGNED_BYTE, (short)value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffectData$get$amplifier(), (short)0).writeOptional("duration", Types.INT, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffectData$get$duration(), 0).writeOptional("ambient", Types.BOOLEAN, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffectData$get$ambient(), false).writeOptional("show_particles", Types.BOOLEAN, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffectData$get$showParticles(), true).writeOptional("show_icon", Types.BOOLEAN, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffectData$get$showIcon()).writeOptional("hidden_effect", TYPE, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffectData$get$hiddenEffect()));
        }
    };
    public static final Type<PotionEffectData> OPTIONAL_TYPE = new OptionalType<PotionEffectData>(TYPE){};

    public PotionEffectData(int amplifier, int duration, boolean ambient, boolean showParticles, boolean showIcon, @Nullable PotionEffectData hiddenEffect) {
        this.amplifier = amplifier;
        this.duration = duration;
        this.ambient = ambient;
        this.showParticles = showParticles;
        this.showIcon = showIcon;
        this.hiddenEffect = hiddenEffect;
    }

    @Override
    public final String toString() {
        return PotionEffectData.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return PotionEffectData.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return PotionEffectData.jvmdowngrader$equals$equals(this, o2);
    }

    public int amplifier() {
        return this.amplifier;
    }

    public int duration() {
        return this.duration;
    }

    public boolean ambient() {
        return this.ambient;
    }

    public boolean showParticles() {
        return this.showParticles;
    }

    public boolean showIcon() {
        return this.showIcon;
    }

    public @Nullable PotionEffectData hiddenEffect() {
        return this.hiddenEffect;
    }

    private static String jvmdowngrader$toString$toString(PotionEffectData potionEffectData) {
        PotionEffectData potionEffectData2 = potionEffectData;
        return "PotionEffectData[" + "amplifier=" + potionEffectData.amplifier + ", " + "duration=" + potionEffectData.duration + ", " + "ambient=" + potionEffectData.ambient + ", " + "showParticles=" + potionEffectData.showParticles + ", " + "showIcon=" + potionEffectData.showIcon + ", " + "hiddenEffect=" + potionEffectData.hiddenEffect + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(PotionEffectData potionEffectData) {
        Object[] objectArray = new Object[]{potionEffectData.amplifier, potionEffectData.duration, potionEffectData.ambient, potionEffectData.showParticles, potionEffectData.showIcon, potionEffectData.hiddenEffect};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(PotionEffectData potionEffectData, Object object) {
        if (potionEffectData == object) {
            return true;
        }
        if (object != null && object instanceof PotionEffectData) {
            PotionEffectData potionEffectData2 = (PotionEffectData)object;
            if (potionEffectData.amplifier == potionEffectData2.amplifier && potionEffectData.duration == potionEffectData2.duration && potionEffectData.ambient == potionEffectData2.ambient && potionEffectData.showParticles == potionEffectData2.showParticles && potionEffectData.showIcon == potionEffectData2.showIcon && Objects.equals(potionEffectData.hiddenEffect, potionEffectData2.hiddenEffect)) {
                return true;
            }
        }
        return false;
    }

    public int jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffectData$get$duration() {
        return this.duration;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffectData$set$duration(int n2) {
        this.duration = n2;
    }

    public PotionEffectData jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffectData$get$hiddenEffect() {
        return this.hiddenEffect;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffectData$set$hiddenEffect(PotionEffectData potionEffectData) {
        this.hiddenEffect = potionEffectData;
    }

    public int jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffectData$get$amplifier() {
        return this.amplifier;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffectData$set$amplifier(int n2) {
        this.amplifier = n2;
    }

    public boolean jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffectData$get$ambient() {
        return this.ambient;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffectData$set$ambient(boolean bl2) {
        this.ambient = bl2;
    }

    public boolean jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffectData$get$showIcon() {
        return this.showIcon;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffectData$set$showIcon(boolean bl2) {
        this.showIcon = bl2;
    }

    public boolean jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffectData$get$showParticles() {
        return this.showParticles;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffectData$set$showParticles(boolean bl2) {
        this.showParticles = bl2;
    }
}

