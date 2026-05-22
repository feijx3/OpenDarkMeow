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

@RecordComponents(value={@RecordComponents.Value(name="shape", type=int.class), @RecordComponents.Value(name="colors", type=int[].class), @RecordComponents.Value(name="fadeColors", type=int[].class), @RecordComponents.Value(name="hasTrail", type=boolean.class), @RecordComponents.Value(name="hasTwinkle", type=boolean.class)})
@NestMembers(value={1.class})
public final class FireworkExplosion
extends J_L_Record
implements Copyable {
    private final int shape;
    private final int[] colors;
    private final int[] fadeColors;
    private final boolean hasTrail;
    private final boolean hasTwinkle;
    public static final String[] SHAPES = new String[]{"small_ball", "large_ball", "star", "creeper", "burst"};
    public static final Type<FireworkExplosion> TYPE = new Type<FireworkExplosion>(FireworkExplosion.class){

        @Override
        public FireworkExplosion read(ByteBuf buffer) {
            int shape = Types.VAR_INT.readPrimitive(buffer);
            int[] colors = (int[])Types.INT_ARRAY_PRIMITIVE.read(buffer);
            int[] fadeColors = (int[])Types.INT_ARRAY_PRIMITIVE.read(buffer);
            boolean hasTrail = buffer.readBoolean();
            boolean hasTwinkle = buffer.readBoolean();
            return new FireworkExplosion(shape, colors, fadeColors, hasTrail, hasTwinkle);
        }

        @Override
        public void write(ByteBuf buffer, FireworkExplosion value) {
            Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FireworkExplosion$get$shape());
            Types.INT_ARRAY_PRIMITIVE.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FireworkExplosion$get$colors());
            Types.INT_ARRAY_PRIMITIVE.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FireworkExplosion$get$fadeColors());
            buffer.writeBoolean(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FireworkExplosion$get$hasTrail());
            buffer.writeBoolean(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FireworkExplosion$get$hasTwinkle());
        }

        @Override
        public void write(Ops ops, FireworkExplosion value) {
            ops.writeMap(map -> map.write("shape", Types.STRING, SHAPES[value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FireworkExplosion$get$shape()]).writeOptional("colors", new ArrayType<Integer>(Types.INT), ArrayUtil.boxedArray(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FireworkExplosion$get$colors()), new Integer[0]).writeOptional("fade_colors", new ArrayType<Integer>(Types.INT), ArrayUtil.boxedArray(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FireworkExplosion$get$fadeColors()), new Integer[0]).writeOptional("has_trail", Types.BOOLEAN, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FireworkExplosion$get$hasTrail(), false).writeOptional("has_twinkle", Types.BOOLEAN, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FireworkExplosion$get$hasTwinkle(), false));
        }
    };
    public static final Type<FireworkExplosion[]> ARRAY_TYPE = new ArrayType<FireworkExplosion>(TYPE);

    public FireworkExplosion(int shape, int[] colors, int[] fadeColors, boolean hasTrail, boolean hasTwinkle) {
        this.shape = shape;
        this.colors = colors;
        this.fadeColors = fadeColors;
        this.hasTrail = hasTrail;
        this.hasTwinkle = hasTwinkle;
    }

    @Override
    public FireworkExplosion copy() {
        return new FireworkExplosion(this.shape, Copyable.copy(this.colors), Copyable.copy(this.fadeColors), this.hasTrail, this.hasTwinkle);
    }

    @Override
    public final String toString() {
        return FireworkExplosion.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return FireworkExplosion.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return FireworkExplosion.jvmdowngrader$equals$equals(this, o2);
    }

    public int shape() {
        return this.shape;
    }

    public int[] colors() {
        return this.colors;
    }

    public int[] fadeColors() {
        return this.fadeColors;
    }

    public boolean hasTrail() {
        return this.hasTrail;
    }

    public boolean hasTwinkle() {
        return this.hasTwinkle;
    }

    private static String jvmdowngrader$toString$toString(FireworkExplosion fireworkExplosion) {
        FireworkExplosion fireworkExplosion2 = fireworkExplosion;
        return "FireworkExplosion[" + "shape=" + fireworkExplosion.shape + ", " + "colors=" + fireworkExplosion.colors + ", " + "fadeColors=" + fireworkExplosion.fadeColors + ", " + "hasTrail=" + fireworkExplosion.hasTrail + ", " + "hasTwinkle=" + fireworkExplosion.hasTwinkle + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(FireworkExplosion fireworkExplosion) {
        Object[] objectArray = new Object[]{fireworkExplosion.shape, fireworkExplosion.colors, fireworkExplosion.fadeColors, fireworkExplosion.hasTrail, fireworkExplosion.hasTwinkle};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(FireworkExplosion fireworkExplosion, Object object) {
        if (fireworkExplosion == object) {
            return true;
        }
        if (object != null && object instanceof FireworkExplosion) {
            FireworkExplosion fireworkExplosion2 = (FireworkExplosion)object;
            if (fireworkExplosion.shape == fireworkExplosion2.shape && Objects.equals(fireworkExplosion.colors, fireworkExplosion2.colors) && Objects.equals(fireworkExplosion.fadeColors, fireworkExplosion2.fadeColors) && fireworkExplosion.hasTrail == fireworkExplosion2.hasTrail && fireworkExplosion.hasTwinkle == fireworkExplosion2.hasTwinkle) {
                return true;
            }
        }
        return false;
    }

    public boolean jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FireworkExplosion$get$hasTwinkle() {
        return this.hasTwinkle;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FireworkExplosion$set$hasTwinkle(boolean bl2) {
        this.hasTwinkle = bl2;
    }

    public int[] jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FireworkExplosion$get$fadeColors() {
        return this.fadeColors;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FireworkExplosion$set$fadeColors(int[] nArray) {
        this.fadeColors = nArray;
    }

    public int jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FireworkExplosion$get$shape() {
        return this.shape;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FireworkExplosion$set$shape(int n2) {
        this.shape = n2;
    }

    public boolean jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FireworkExplosion$get$hasTrail() {
        return this.hasTrail;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FireworkExplosion$set$hasTrail(boolean bl2) {
        this.hasTrail = bl2;
    }

    public int[] jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FireworkExplosion$get$colors() {
        return this.colors;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_FireworkExplosion$set$colors(int[] nArray) {
        this.colors = nArray;
    }
}

