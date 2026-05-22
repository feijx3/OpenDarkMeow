/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.data.PotionEffect;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.util.Copyable;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="nutrition", type=int.class), @RecordComponents.Value(name="saturationModifier", type=float.class), @RecordComponents.Value(name="canAlwaysEat", type=boolean.class), @RecordComponents.Value(name="eatSeconds", type=float.class), @RecordComponents.Value(name="usingConvertsTo", type=Item.class), @RecordComponents.Value(name="possibleEffects", type=FoodEffect[].class)})
@NestMembers(value={FoodEffect.class, FoodEffect.1.class, 2.class, 1.class})
public final class FoodProperties1_20_5
extends J_L_Record
implements Copyable {
    private final int nutrition;
    private final float saturationModifier;
    private final boolean canAlwaysEat;
    private final float eatSeconds;
    private final @Nullable Item usingConvertsTo;
    private final FoodEffect[] possibleEffects;
    public static final Type<FoodProperties1_20_5> TYPE1_20_5 = new Type<FoodProperties1_20_5>(FoodProperties1_20_5.class){

        @Override
        public FoodProperties1_20_5 read(ByteBuf buffer) {
            int nutrition = Types.VAR_INT.readPrimitive(buffer);
            float saturationModifier = buffer.readFloat();
            boolean canAlwaysEat = buffer.readBoolean();
            float eatSeconds = buffer.readFloat();
            FoodEffect[] possibleEffects = (FoodEffect[])FoodEffect.ARRAY_TYPE.read(buffer);
            return new FoodProperties1_20_5(nutrition, saturationModifier, canAlwaysEat, eatSeconds, null, possibleEffects);
        }

        @Override
        public void write(ByteBuf buffer, FoodProperties1_20_5 value) {
            Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_20_5$get$nutrition());
            buffer.writeFloat(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_20_5$get$saturationModifier());
            buffer.writeBoolean(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_20_5$get$canAlwaysEat());
            buffer.writeFloat(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_20_5$get$eatSeconds());
            FoodEffect.ARRAY_TYPE.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_20_5$get$possibleEffects());
        }
    };
    public static final Type<FoodProperties1_20_5> TYPE1_21 = new Type<FoodProperties1_20_5>(FoodProperties1_20_5.class){

        @Override
        public FoodProperties1_20_5 read(ByteBuf buffer) {
            int nutrition = Types.VAR_INT.readPrimitive(buffer);
            float saturationModifier = buffer.readFloat();
            boolean canAlwaysEat = buffer.readBoolean();
            float eatSeconds = buffer.readFloat();
            Item usingConvertsTo = (Item)VersionedTypes.V1_21.optionalItem.read(buffer);
            FoodEffect[] possibleEffects = (FoodEffect[])FoodEffect.ARRAY_TYPE.read(buffer);
            return new FoodProperties1_20_5(nutrition, saturationModifier, canAlwaysEat, eatSeconds, usingConvertsTo, possibleEffects);
        }

        @Override
        public void write(ByteBuf buffer, FoodProperties1_20_5 value) {
            Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_20_5$get$nutrition());
            buffer.writeFloat(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_20_5$get$saturationModifier());
            buffer.writeBoolean(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_20_5$get$canAlwaysEat());
            buffer.writeFloat(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_20_5$get$eatSeconds());
            VersionedTypes.V1_21.optionalItem.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_20_5$get$usingConvertsTo());
            FoodEffect.ARRAY_TYPE.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_20_5$get$possibleEffects());
        }
    };

    public FoodProperties1_20_5(int nutrition, float saturationModifier, boolean canAlwaysEat, float eatSeconds, @Nullable Item usingConvertsTo, FoodEffect[] possibleEffects) {
        this.nutrition = nutrition;
        this.saturationModifier = saturationModifier;
        this.canAlwaysEat = canAlwaysEat;
        this.eatSeconds = eatSeconds;
        this.usingConvertsTo = usingConvertsTo;
        this.possibleEffects = possibleEffects;
    }

    @Override
    public FoodProperties1_20_5 copy() {
        return new FoodProperties1_20_5(this.nutrition, this.saturationModifier, this.canAlwaysEat, this.eatSeconds, this.usingConvertsTo == null ? null : this.usingConvertsTo.copy(), Copyable.copy(this.possibleEffects));
    }

    @Override
    public final String toString() {
        return FoodProperties1_20_5.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return FoodProperties1_20_5.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return FoodProperties1_20_5.jvmdowngrader$equals$equals(this, o2);
    }

    public int nutrition() {
        return this.nutrition;
    }

    public float saturationModifier() {
        return this.saturationModifier;
    }

    public boolean canAlwaysEat() {
        return this.canAlwaysEat;
    }

    public float eatSeconds() {
        return this.eatSeconds;
    }

    public @Nullable Item usingConvertsTo() {
        return this.usingConvertsTo;
    }

    public FoodEffect[] possibleEffects() {
        return this.possibleEffects;
    }

    private static String jvmdowngrader$toString$toString(FoodProperties1_20_5 foodProperties1_20_5) {
        FoodProperties1_20_5 foodProperties1_20_52 = foodProperties1_20_5;
        return "FoodProperties1_20_5[" + "nutrition=" + foodProperties1_20_5.nutrition + ", " + "saturationModifier=" + foodProperties1_20_5.saturationModifier + ", " + "canAlwaysEat=" + foodProperties1_20_5.canAlwaysEat + ", " + "eatSeconds=" + foodProperties1_20_5.eatSeconds + ", " + "usingConvertsTo=" + foodProperties1_20_5.usingConvertsTo + ", " + "possibleEffects=" + foodProperties1_20_5.possibleEffects + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(FoodProperties1_20_5 foodProperties1_20_5) {
        Object[] objectArray = new Object[]{foodProperties1_20_5.nutrition, Float.valueOf(foodProperties1_20_5.saturationModifier), foodProperties1_20_5.canAlwaysEat, Float.valueOf(foodProperties1_20_5.eatSeconds), foodProperties1_20_5.usingConvertsTo, foodProperties1_20_5.possibleEffects};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(FoodProperties1_20_5 foodProperties1_20_5, Object object) {
        if (foodProperties1_20_5 == object) {
            return true;
        }
        if (object != null && object instanceof FoodProperties1_20_5) {
            FoodProperties1_20_5 foodProperties1_20_52 = (FoodProperties1_20_5)object;
            if (foodProperties1_20_5.nutrition == foodProperties1_20_52.nutrition && foodProperties1_20_5.saturationModifier == foodProperties1_20_52.saturationModifier && foodProperties1_20_5.canAlwaysEat == foodProperties1_20_52.canAlwaysEat && foodProperties1_20_5.eatSeconds == foodProperties1_20_52.eatSeconds && Objects.equals(foodProperties1_20_5.usingConvertsTo, foodProperties1_20_52.usingConvertsTo) && Objects.equals(foodProperties1_20_5.possibleEffects, foodProperties1_20_52.possibleEffects)) {
                return true;
            }
        }
        return false;
    }

    public int jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_20_5$get$nutrition() {
        return this.nutrition;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_20_5$set$nutrition(int n2) {
        this.nutrition = n2;
    }

    public float jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_20_5$get$eatSeconds() {
        return this.eatSeconds;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_20_5$set$eatSeconds(float f2) {
        this.eatSeconds = f2;
    }

    public FoodEffect[] jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_20_5$get$possibleEffects() {
        return this.possibleEffects;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_20_5$set$possibleEffects(FoodEffect[] foodEffectArray) {
        this.possibleEffects = foodEffectArray;
    }

    public boolean jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_20_5$get$canAlwaysEat() {
        return this.canAlwaysEat;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_20_5$set$canAlwaysEat(boolean bl2) {
        this.canAlwaysEat = bl2;
    }

    public Item jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_20_5$get$usingConvertsTo() {
        return this.usingConvertsTo;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_20_5$set$usingConvertsTo(Item item) {
        this.usingConvertsTo = item;
    }

    public float jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_20_5$get$saturationModifier() {
        return this.saturationModifier;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_20_5$set$saturationModifier(float f2) {
        this.saturationModifier = f2;
    }

    @RecordComponents(value={@RecordComponents.Value(name="effect", type=PotionEffect.class), @RecordComponents.Value(name="probability", type=float.class)})
    @NestHost(value=FoodProperties1_20_5.class)
    public static final class FoodEffect
    extends J_L_Record {
        private final PotionEffect effect;
        private final float probability;
        public static final Type<FoodEffect> TYPE = new Type<FoodEffect>(FoodEffect.class){

            @Override
            public FoodEffect read(ByteBuf buffer) {
                PotionEffect effect = (PotionEffect)PotionEffect.TYPE.read(buffer);
                float probability = buffer.readFloat();
                return new FoodEffect(effect, probability);
            }

            @Override
            public void write(ByteBuf buffer, FoodEffect value) {
                PotionEffect.TYPE.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_20_5$FoodEffect$get$effect());
                buffer.writeFloat(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_20_5$FoodEffect$get$probability());
            }
        };
        public static final Type<FoodEffect[]> ARRAY_TYPE = new ArrayType<FoodEffect>(TYPE);

        public FoodEffect(PotionEffect effect, float probability) {
            this.effect = effect;
            this.probability = probability;
        }

        @Override
        public final String toString() {
            return FoodEffect.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return FoodEffect.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return FoodEffect.jvmdowngrader$equals$equals(this, o2);
        }

        public PotionEffect effect() {
            return this.effect;
        }

        public float probability() {
            return this.probability;
        }

        private static String jvmdowngrader$toString$toString(FoodEffect foodEffect) {
            FoodEffect foodEffect2 = foodEffect;
            return "FoodProperties1_20_5$FoodEffect[" + "effect=" + foodEffect.effect + ", " + "probability=" + foodEffect.probability + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(FoodEffect foodEffect) {
            Object[] objectArray = new Object[]{foodEffect.effect, Float.valueOf(foodEffect.probability)};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(FoodEffect foodEffect, Object object) {
            if (foodEffect == object) {
                return true;
            }
            if (object != null && object instanceof FoodEffect) {
                FoodEffect foodEffect2 = (FoodEffect)object;
                if (Objects.equals(foodEffect.effect, foodEffect2.effect) && foodEffect.probability == foodEffect2.probability) {
                    return true;
                }
            }
            return false;
        }

        public float jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_20_5$FoodEffect$get$probability() {
            return this.probability;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_20_5$FoodEffect$set$probability(float f2) {
            this.probability = f2;
        }

        public PotionEffect jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_20_5$FoodEffect$get$effect() {
            return this.effect;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_20_5$FoodEffect$set$effect(PotionEffect potionEffect) {
            this.effect = potionEffect;
        }
    }
}

