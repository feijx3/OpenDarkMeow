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
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.item.data.PotionEffect;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import com.viaversion.viaversion.util.Copyable;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="consumeSeconds", type=float.class), @RecordComponents.Value(name="animationType", type=int.class), @RecordComponents.Value(name="sound", type=Holder.class), @RecordComponents.Value(name="hasConsumeParticles", type=boolean.class), @RecordComponents.Value(name="consumeEffects", type=ConsumeEffect[].class)})
@NestMembers(value={ApplyStatusEffects.class, ApplyStatusEffects.1.class, ConsumeEffect.class, ConsumeEffect.1.class, 1.class})
public final class Consumable1_21_2
extends J_L_Record
implements Copyable,
Rewritable {
    private final float consumeSeconds;
    private final int animationType;
    private final Holder<SoundEvent> sound;
    private final boolean hasConsumeParticles;
    private final ConsumeEffect<?>[] consumeEffects;
    public static final Type<?>[] EFFECT_TYPES = new Type[]{ApplyStatusEffects.TYPE, Types.HOLDER_SET, Types.EMPTY, Types.FLOAT, Types.SOUND_EVENT};
    public static final Type<Consumable1_21_2> TYPE = new Type<Consumable1_21_2>(Consumable1_21_2.class){

        @Override
        public Consumable1_21_2 read(ByteBuf buffer) {
            float consumeSeconds = buffer.readFloat();
            int animationType = Types.VAR_INT.readPrimitive(buffer);
            Object sound = Types.SOUND_EVENT.read(buffer);
            boolean hasConsumeParticles = buffer.readBoolean();
            ConsumeEffect[] consumeEffects = (ConsumeEffect[])ConsumeEffect.ARRAY_TYPE.read(buffer);
            return new Consumable1_21_2(consumeSeconds, animationType, (Holder<SoundEvent>)sound, hasConsumeParticles, consumeEffects);
        }

        @Override
        public void write(ByteBuf buffer, Consumable1_21_2 value) {
            buffer.writeFloat(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Consumable1_21_2$get$consumeSeconds());
            Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Consumable1_21_2$get$animationType());
            Types.SOUND_EVENT.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Consumable1_21_2$get$sound());
            buffer.writeBoolean(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Consumable1_21_2$get$hasConsumeParticles());
            ConsumeEffect.ARRAY_TYPE.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Consumable1_21_2$get$consumeEffects());
        }
    };

    public Consumable1_21_2(float consumeSeconds, int animationType, Holder<SoundEvent> sound, boolean hasConsumeParticles, ConsumeEffect<?>[] consumeEffects) {
        this.consumeSeconds = consumeSeconds;
        this.animationType = animationType;
        this.sound = sound;
        this.hasConsumeParticles = hasConsumeParticles;
        this.consumeEffects = consumeEffects;
    }

    @Override
    public Consumable1_21_2 rewrite(UserConnection connection, Protocol<?, ?, ?, ?> protocol, boolean clientbound) {
        Holder<SoundEvent> soundHolder = SoundEvent.rewriteHolder(this.sound, Rewritable.soundRewriteFunction(protocol, clientbound));
        return soundHolder == this.sound ? this : new Consumable1_21_2(this.consumeSeconds, this.animationType, soundHolder, this.hasConsumeParticles, this.consumeEffects);
    }

    @Override
    public Consumable1_21_2 copy() {
        return new Consumable1_21_2(this.consumeSeconds, this.animationType, this.sound, this.hasConsumeParticles, Copyable.copy(this.consumeEffects));
    }

    @Override
    public final String toString() {
        return Consumable1_21_2.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return Consumable1_21_2.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return Consumable1_21_2.jvmdowngrader$equals$equals(this, o2);
    }

    public float consumeSeconds() {
        return this.consumeSeconds;
    }

    public int animationType() {
        return this.animationType;
    }

    public Holder<SoundEvent> sound() {
        return this.sound;
    }

    public boolean hasConsumeParticles() {
        return this.hasConsumeParticles;
    }

    public ConsumeEffect<?>[] consumeEffects() {
        return this.consumeEffects;
    }

    private static String jvmdowngrader$toString$toString(Consumable1_21_2 consumable1_21_2) {
        Consumable1_21_2 consumable1_21_22 = consumable1_21_2;
        return "Consumable1_21_2[" + "consumeSeconds=" + consumable1_21_2.consumeSeconds + ", " + "animationType=" + consumable1_21_2.animationType + ", " + "sound=" + consumable1_21_2.sound + ", " + "hasConsumeParticles=" + consumable1_21_2.hasConsumeParticles + ", " + "consumeEffects=" + consumable1_21_2.consumeEffects + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(Consumable1_21_2 consumable1_21_2) {
        Object[] objectArray = new Object[]{Float.valueOf(consumable1_21_2.consumeSeconds), consumable1_21_2.animationType, consumable1_21_2.sound, consumable1_21_2.hasConsumeParticles, consumable1_21_2.consumeEffects};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(Consumable1_21_2 consumable1_21_2, Object object) {
        if (consumable1_21_2 == object) {
            return true;
        }
        if (object != null && object instanceof Consumable1_21_2) {
            Consumable1_21_2 consumable1_21_22 = (Consumable1_21_2)object;
            if (consumable1_21_2.consumeSeconds == consumable1_21_22.consumeSeconds && consumable1_21_2.animationType == consumable1_21_22.animationType && Objects.equals(consumable1_21_2.sound, consumable1_21_22.sound) && consumable1_21_2.hasConsumeParticles == consumable1_21_22.hasConsumeParticles && Objects.equals(consumable1_21_2.consumeEffects, consumable1_21_22.consumeEffects)) {
                return true;
            }
        }
        return false;
    }

    public boolean jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Consumable1_21_2$get$hasConsumeParticles() {
        return this.hasConsumeParticles;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Consumable1_21_2$set$hasConsumeParticles(boolean bl2) {
        this.hasConsumeParticles = bl2;
    }

    public float jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Consumable1_21_2$get$consumeSeconds() {
        return this.consumeSeconds;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Consumable1_21_2$set$consumeSeconds(float f2) {
        this.consumeSeconds = f2;
    }

    public Holder jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Consumable1_21_2$get$sound() {
        return this.sound;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Consumable1_21_2$set$sound(Holder holder) {
        this.sound = holder;
    }

    public int jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Consumable1_21_2$get$animationType() {
        return this.animationType;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Consumable1_21_2$set$animationType(int n2) {
        this.animationType = n2;
    }

    public ConsumeEffect[] jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Consumable1_21_2$get$consumeEffects() {
        return this.consumeEffects;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Consumable1_21_2$set$consumeEffects(ConsumeEffect[] consumeEffectArray) {
        this.consumeEffects = consumeEffectArray;
    }

    @RecordComponents(value={@RecordComponents.Value(name="id", type=int.class), @RecordComponents.Value(name="type", type=Type.class), @RecordComponents.Value(name="value", type=Object.class)})
    @NestHost(value=Consumable1_21_2.class)
    public static final class ConsumeEffect<T>
    extends J_L_Record {
        private final int id;
        private final Type<T> type;
        private final T value;
        public static final Type<ConsumeEffect<?>> TYPE = new Type<ConsumeEffect<?>>(ConsumeEffect.class){

            @Override
            public ConsumeEffect<?> read(ByteBuf buffer) {
                int effectType = Types.VAR_INT.readPrimitive(buffer);
                Type<?> type = EFFECT_TYPES[effectType];
                Object value = type.read(buffer);
                return ConsumeEffect.of(effectType, type, value);
            }

            @Override
            public void write(ByteBuf buffer, ConsumeEffect<?> value) {
                Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Consumable1_21_2$ConsumeEffect$get$id());
                value.writeValue(buffer);
            }
        };
        public static final Type<ConsumeEffect<?>[]> ARRAY_TYPE = new ArrayType(TYPE);

        public ConsumeEffect(int id, Type<T> type, T value) {
            this.id = id;
            this.type = type;
            this.value = value;
        }

        static <T> ConsumeEffect<T> of(int id, Type<T> type, Object value) {
            return new ConsumeEffect<Object>(id, type, value);
        }

        void writeValue(ByteBuf buf) {
            this.type.write(buf, this.value);
        }

        @Override
        public final String toString() {
            return ConsumeEffect.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return ConsumeEffect.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return ConsumeEffect.jvmdowngrader$equals$equals(this, o2);
        }

        public int id() {
            return this.id;
        }

        public Type<T> type() {
            return this.type;
        }

        public T value() {
            return this.value;
        }

        private static String jvmdowngrader$toString$toString(ConsumeEffect consumeEffect) {
            ConsumeEffect consumeEffect2 = consumeEffect;
            return "Consumable1_21_2$ConsumeEffect[" + "id=" + consumeEffect.id + ", " + "type=" + consumeEffect.type + ", " + "value=" + consumeEffect.value + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(ConsumeEffect consumeEffect) {
            Object[] objectArray = new Object[]{consumeEffect.id, consumeEffect.type, consumeEffect.value};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(ConsumeEffect consumeEffect, Object object) {
            if (consumeEffect == object) {
                return true;
            }
            if (object != null && object instanceof ConsumeEffect) {
                ConsumeEffect consumeEffect2 = (ConsumeEffect)object;
                if (consumeEffect.id == consumeEffect2.id && Objects.equals(consumeEffect.type, consumeEffect2.type) && Objects.equals(consumeEffect.value, consumeEffect2.value)) {
                    return true;
                }
            }
            return false;
        }

        public int jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Consumable1_21_2$ConsumeEffect$get$id() {
            return this.id;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Consumable1_21_2$ConsumeEffect$set$id(int n2) {
            this.id = n2;
        }
    }

    @RecordComponents(value={@RecordComponents.Value(name="effects", type=PotionEffect[].class), @RecordComponents.Value(name="probability", type=float.class)})
    @NestHost(value=Consumable1_21_2.class)
    public static final class ApplyStatusEffects
    extends J_L_Record {
        private final PotionEffect[] effects;
        private final float probability;
        public static final Type<ApplyStatusEffects> TYPE = new Type<ApplyStatusEffects>(ApplyStatusEffects.class){

            @Override
            public ApplyStatusEffects read(ByteBuf buffer) {
                PotionEffect[] effects = (PotionEffect[])PotionEffect.ARRAY_TYPE.read(buffer);
                float probability = buffer.readFloat();
                return new ApplyStatusEffects(effects, probability);
            }

            @Override
            public void write(ByteBuf buffer, ApplyStatusEffects value) {
                PotionEffect.ARRAY_TYPE.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Consumable1_21_2$ApplyStatusEffects$get$effects());
                buffer.writeFloat(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Consumable1_21_2$ApplyStatusEffects$get$probability());
            }
        };

        public ApplyStatusEffects(PotionEffect[] effects, float probability) {
            this.effects = effects;
            this.probability = probability;
        }

        @Override
        public final String toString() {
            return ApplyStatusEffects.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return ApplyStatusEffects.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return ApplyStatusEffects.jvmdowngrader$equals$equals(this, o2);
        }

        public PotionEffect[] effects() {
            return this.effects;
        }

        public float probability() {
            return this.probability;
        }

        private static String jvmdowngrader$toString$toString(ApplyStatusEffects applyStatusEffects) {
            ApplyStatusEffects applyStatusEffects2 = applyStatusEffects;
            return "Consumable1_21_2$ApplyStatusEffects[" + "effects=" + applyStatusEffects.effects + ", " + "probability=" + applyStatusEffects.probability + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(ApplyStatusEffects applyStatusEffects) {
            Object[] objectArray = new Object[]{applyStatusEffects.effects, Float.valueOf(applyStatusEffects.probability)};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(ApplyStatusEffects applyStatusEffects, Object object) {
            if (applyStatusEffects == object) {
                return true;
            }
            if (object != null && object instanceof ApplyStatusEffects) {
                ApplyStatusEffects applyStatusEffects2 = (ApplyStatusEffects)object;
                if (Objects.equals(applyStatusEffects.effects, applyStatusEffects2.effects) && applyStatusEffects.probability == applyStatusEffects2.probability) {
                    return true;
                }
            }
            return false;
        }

        public PotionEffect[] jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Consumable1_21_2$ApplyStatusEffects$get$effects() {
            return this.effects;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Consumable1_21_2$ApplyStatusEffects$set$effects(PotionEffect[] potionEffectArray) {
            this.effects = potionEffectArray;
        }

        public float jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Consumable1_21_2$ApplyStatusEffects$get$probability() {
            return this.probability;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Consumable1_21_2$ApplyStatusEffects$set$probability(float f2) {
            this.probability = f2;
        }
    }
}

