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
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="nutrition", type=int.class), @RecordComponents.Value(name="saturationModifier", type=float.class), @RecordComponents.Value(name="canAlwaysEat", type=boolean.class)})
@NestMembers(value={1.class})
public final class FoodProperties1_21_2
extends J_L_Record {
    private final int nutrition;
    private final float saturationModifier;
    private final boolean canAlwaysEat;
    public static final Type<FoodProperties1_21_2> TYPE = new Type<FoodProperties1_21_2>(FoodProperties1_21_2.class){

        @Override
        public FoodProperties1_21_2 read(ByteBuf buffer) {
            int nutrition = Types.VAR_INT.readPrimitive(buffer);
            float saturationModifier = buffer.readFloat();
            boolean canAlwaysEat = buffer.readBoolean();
            return new FoodProperties1_21_2(nutrition, saturationModifier, canAlwaysEat);
        }

        @Override
        public void write(ByteBuf buffer, FoodProperties1_21_2 value) {
            Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_21_2$get$nutrition());
            buffer.writeFloat(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_21_2$get$saturationModifier());
            buffer.writeBoolean(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_21_2$get$canAlwaysEat());
        }

        @Override
        public void write(Ops ops, FoodProperties1_21_2 value) {
            ops.writeMap(map -> map.write("nutrition", Types.VAR_INT, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_21_2$get$nutrition()).write("saturation", Types.FLOAT, Float.valueOf(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_21_2$get$saturationModifier())).writeOptional("can_always_eat", Types.BOOLEAN, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_21_2$get$canAlwaysEat(), false));
        }
    };

    public FoodProperties1_21_2(int nutrition, float saturationModifier, boolean canAlwaysEat) {
        this.nutrition = nutrition;
        this.saturationModifier = saturationModifier;
        this.canAlwaysEat = canAlwaysEat;
    }

    @Override
    public final String toString() {
        return FoodProperties1_21_2.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return FoodProperties1_21_2.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return FoodProperties1_21_2.jvmdowngrader$equals$equals(this, o2);
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

    private static String jvmdowngrader$toString$toString(FoodProperties1_21_2 foodProperties1_21_2) {
        FoodProperties1_21_2 foodProperties1_21_22 = foodProperties1_21_2;
        return "FoodProperties1_21_2[" + "nutrition=" + foodProperties1_21_2.nutrition + ", " + "saturationModifier=" + foodProperties1_21_2.saturationModifier + ", " + "canAlwaysEat=" + foodProperties1_21_2.canAlwaysEat + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(FoodProperties1_21_2 foodProperties1_21_2) {
        Object[] objectArray = new Object[]{foodProperties1_21_2.nutrition, Float.valueOf(foodProperties1_21_2.saturationModifier), foodProperties1_21_2.canAlwaysEat};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(FoodProperties1_21_2 foodProperties1_21_2, Object object) {
        if (foodProperties1_21_2 == object) {
            return true;
        }
        if (object != null && object instanceof FoodProperties1_21_2) {
            FoodProperties1_21_2 foodProperties1_21_22 = (FoodProperties1_21_2)object;
            if (foodProperties1_21_2.nutrition == foodProperties1_21_22.nutrition && foodProperties1_21_2.saturationModifier == foodProperties1_21_22.saturationModifier && foodProperties1_21_2.canAlwaysEat == foodProperties1_21_22.canAlwaysEat) {
                return true;
            }
        }
        return false;
    }

    public float jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_21_2$get$saturationModifier() {
        return this.saturationModifier;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_21_2$set$saturationModifier(float f2) {
        this.saturationModifier = f2;
    }

    public int jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_21_2$get$nutrition() {
        return this.nutrition;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_21_2$set$nutrition(int n2) {
        this.nutrition = n2;
    }

    public boolean jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_21_2$get$canAlwaysEat() {
        return this.canAlwaysEat;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FoodProperties1_21_2$set$canAlwaysEat(boolean bl2) {
        this.canAlwaysEat = bl2;
    }
}

