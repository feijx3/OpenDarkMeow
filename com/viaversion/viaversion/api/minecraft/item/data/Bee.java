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
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import com.viaversion.viaversion.util.Copyable;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="entityData", type=CompoundTag.class), @RecordComponents.Value(name="ticksInHive", type=int.class), @RecordComponents.Value(name="minTicksInHive", type=int.class)})
@NestMembers(value={1.class})
public final class Bee
extends J_L_Record
implements Copyable {
    private final CompoundTag entityData;
    private final int ticksInHive;
    private final int minTicksInHive;
    public static final Type<Bee> TYPE = new Type<Bee>(Bee.class){

        @Override
        public Bee read(ByteBuf buffer) {
            CompoundTag entityData = (CompoundTag)Types.COMPOUND_TAG.read(buffer);
            int ticksInHive = Types.VAR_INT.readPrimitive(buffer);
            int minTicksInHive = Types.VAR_INT.readPrimitive(buffer);
            return new Bee(entityData, ticksInHive, minTicksInHive);
        }

        @Override
        public void write(ByteBuf buffer, Bee value) {
            Types.COMPOUND_TAG.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Bee$get$entityData());
            Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Bee$get$ticksInHive());
            Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Bee$get$minTicksInHive());
        }

        @Override
        public void write(Ops ops, Bee value) {
            ops.writeMap(map -> map.writeOptional("entity_data", Types.COMPOUND_TAG, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Bee$get$entityData(), new CompoundTag()).write("ticks_in_hive", Types.INT, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Bee$get$ticksInHive()).write("min_ticks_in_hive", Types.INT, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Bee$get$minTicksInHive()));
        }
    };
    public static final Type<Bee[]> ARRAY_TYPE = new ArrayType<Bee>(TYPE);

    public Bee(CompoundTag entityData, int ticksInHive, int minTicksInHive) {
        this.entityData = entityData;
        this.ticksInHive = ticksInHive;
        this.minTicksInHive = minTicksInHive;
    }

    @Override
    public Bee copy() {
        return new Bee(this.entityData.copy(), this.ticksInHive, this.minTicksInHive);
    }

    @Override
    public final String toString() {
        return Bee.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return Bee.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return Bee.jvmdowngrader$equals$equals(this, o2);
    }

    public CompoundTag entityData() {
        return this.entityData;
    }

    public int ticksInHive() {
        return this.ticksInHive;
    }

    public int minTicksInHive() {
        return this.minTicksInHive;
    }

    private static String jvmdowngrader$toString$toString(Bee bee) {
        Bee bee2 = bee;
        return "Bee[" + "entityData=" + bee.entityData + ", " + "ticksInHive=" + bee.ticksInHive + ", " + "minTicksInHive=" + bee.minTicksInHive + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(Bee bee) {
        Object[] objectArray = new Object[]{bee.entityData, bee.ticksInHive, bee.minTicksInHive};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(Bee bee, Object object) {
        if (bee == object) {
            return true;
        }
        if (object != null && object instanceof Bee) {
            Bee bee2 = (Bee)object;
            if (Objects.equals(bee.entityData, bee2.entityData) && bee.ticksInHive == bee2.ticksInHive && bee.minTicksInHive == bee2.minTicksInHive) {
                return true;
            }
        }
        return false;
    }

    public int jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Bee$get$ticksInHive() {
        return this.ticksInHive;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Bee$set$ticksInHive(int n2) {
        this.ticksInHive = n2;
    }

    public int jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Bee$get$minTicksInHive() {
        return this.minTicksInHive;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Bee$set$minTicksInHive(int n2) {
        this.minTicksInHive = n2;
    }

    public CompoundTag jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Bee$get$entityData() {
        return this.entityData;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Bee$set$entityData(CompoundTag compoundTag) {
        this.entityData = compoundTag;
    }
}

