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
import com.viaversion.viaversion.api.type.types.ArrayType;
import com.viaversion.viaversion.util.ArrayUtil;
import com.viaversion.viaversion.util.Copyable;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="floats", type=float[].class), @RecordComponents.Value(name="booleans", type=boolean[].class), @RecordComponents.Value(name="strings", type=String[].class), @RecordComponents.Value(name="colors", type=int[].class)})
@NestMembers(value={1.class})
public final class CustomModelData1_21_4
extends J_L_Record
implements Copyable {
    private final float[] floats;
    private final boolean[] booleans;
    private final String[] strings;
    private final int[] colors;
    public static final Type<CustomModelData1_21_4> TYPE = new Type<CustomModelData1_21_4>(CustomModelData1_21_4.class){

        @Override
        public CustomModelData1_21_4 read(ByteBuf buffer) {
            float[] floats = (float[])Types.FLOAT_ARRAY_PRIMITIVE.read(buffer);
            boolean[] booleans = (boolean[])Types.BOOLEAN_ARRAY_PRIMITIVE.read(buffer);
            String[] strings = (String[])Types.STRING_ARRAY.read(buffer);
            int[] colors = (int[])Types.INT_ARRAY_PRIMITIVE.read(buffer);
            return new CustomModelData1_21_4(floats, booleans, strings, colors);
        }

        @Override
        public void write(ByteBuf buffer, CustomModelData1_21_4 value) {
            Types.FLOAT_ARRAY_PRIMITIVE.write(buffer, value.floats());
            Types.BOOLEAN_ARRAY_PRIMITIVE.write(buffer, value.booleans());
            Types.STRING_ARRAY.write(buffer, value.strings());
            Types.INT_ARRAY_PRIMITIVE.write(buffer, value.colors());
        }

        @Override
        public void write(Ops ops, CustomModelData1_21_4 value) {
            ops.writeMap(map -> map.writeOptional("floats", new ArrayType<Float>(Types.FLOAT), ArrayUtil.boxedArray(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_CustomModelData1_21_4$get$floats()), new Float[0]).writeOptional("flags", new ArrayType<Boolean>(Types.BOOLEAN), ArrayUtil.boxedArray(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_CustomModelData1_21_4$get$booleans()), new Boolean[0]).writeOptional("strings", Types.STRING_ARRAY, value.strings(), new String[0]).writeOptional("colors", new ArrayType<Integer>(Types.INT), ArrayUtil.boxedArray(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_CustomModelData1_21_4$get$colors()), new Integer[0]));
        }
    };

    public CustomModelData1_21_4(float[] floats, boolean[] booleans, String[] strings, int[] colors) {
        this.floats = floats;
        this.booleans = booleans;
        this.strings = strings;
        this.colors = colors;
    }

    @Override
    public CustomModelData1_21_4 copy() {
        return new CustomModelData1_21_4(Copyable.copy(this.floats), Copyable.copy(this.booleans), Copyable.copy(this.strings), Copyable.copy(this.colors));
    }

    @Override
    public final String toString() {
        return CustomModelData1_21_4.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return CustomModelData1_21_4.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return CustomModelData1_21_4.jvmdowngrader$equals$equals(this, o2);
    }

    public float[] floats() {
        return this.floats;
    }

    public boolean[] booleans() {
        return this.booleans;
    }

    public String[] strings() {
        return this.strings;
    }

    public int[] colors() {
        return this.colors;
    }

    private static String jvmdowngrader$toString$toString(CustomModelData1_21_4 customModelData1_21_4) {
        CustomModelData1_21_4 customModelData1_21_42 = customModelData1_21_4;
        return "CustomModelData1_21_4[" + "floats=" + customModelData1_21_4.floats + ", " + "booleans=" + customModelData1_21_4.booleans + ", " + "strings=" + customModelData1_21_4.strings + ", " + "colors=" + customModelData1_21_4.colors + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(CustomModelData1_21_4 customModelData1_21_4) {
        Object[] objectArray = new Object[]{customModelData1_21_4.floats, customModelData1_21_4.booleans, customModelData1_21_4.strings, customModelData1_21_4.colors};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(CustomModelData1_21_4 customModelData1_21_4, Object object) {
        if (customModelData1_21_4 == object) {
            return true;
        }
        if (object != null && object instanceof CustomModelData1_21_4) {
            CustomModelData1_21_4 customModelData1_21_42 = (CustomModelData1_21_4)object;
            if (Objects.equals(customModelData1_21_4.floats, customModelData1_21_42.floats) && Objects.equals(customModelData1_21_4.booleans, customModelData1_21_42.booleans) && Objects.equals(customModelData1_21_4.strings, customModelData1_21_42.strings) && Objects.equals(customModelData1_21_4.colors, customModelData1_21_42.colors)) {
                return true;
            }
        }
        return false;
    }

    public boolean[] jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_CustomModelData1_21_4$get$booleans() {
        return this.booleans;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_CustomModelData1_21_4$set$booleans(boolean[] blArray) {
        this.booleans = blArray;
    }

    public int[] jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_CustomModelData1_21_4$get$colors() {
        return this.colors;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_CustomModelData1_21_4$set$colors(int[] nArray) {
        this.colors = nArray;
    }

    public float[] jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_CustomModelData1_21_4$get$floats() {
        return this.floats;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_CustomModelData1_21_4$set$floats(float[] fArray) {
        this.floats = fArray;
    }
}

