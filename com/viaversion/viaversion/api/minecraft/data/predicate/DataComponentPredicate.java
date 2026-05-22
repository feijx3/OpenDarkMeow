/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.minecraft.data.predicate;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="id", type=int.class), @RecordComponents.Value(name="predicate", type=Tag.class)})
@NestMembers(value={1.class})
public final class DataComponentPredicate
extends J_L_Record {
    private final int id;
    private final Tag predicate;
    public static final Type<DataComponentPredicate> TYPE = new Type<DataComponentPredicate>(DataComponentPredicate.class){

        @Override
        public DataComponentPredicate read(ByteBuf buffer) {
            int id = Types.VAR_INT.readPrimitive(buffer);
            Tag predicate = (Tag)Types.TAG.read(buffer);
            return new DataComponentPredicate(id, predicate);
        }

        @Override
        public void write(ByteBuf buffer, DataComponentPredicate value) {
            Types.VAR_INT.writePrimitive(buffer, value.id());
            Types.TAG.write(buffer, value.predicate());
        }
    };
    public static final Type<DataComponentPredicate[]> ARRAY_TYPE = new ArrayType<DataComponentPredicate>(TYPE, 64);

    public DataComponentPredicate(int id, Tag predicate) {
        this.id = id;
        this.predicate = predicate;
    }

    @Override
    public final String toString() {
        return DataComponentPredicate.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return DataComponentPredicate.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return DataComponentPredicate.jvmdowngrader$equals$equals(this, o2);
    }

    public int id() {
        return this.id;
    }

    public Tag predicate() {
        return this.predicate;
    }

    private static String jvmdowngrader$toString$toString(DataComponentPredicate dataComponentPredicate) {
        DataComponentPredicate dataComponentPredicate2 = dataComponentPredicate;
        return "DataComponentPredicate[" + "id=" + dataComponentPredicate.id + ", " + "predicate=" + dataComponentPredicate.predicate + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(DataComponentPredicate dataComponentPredicate) {
        Object[] objectArray = new Object[]{dataComponentPredicate.id, dataComponentPredicate.predicate};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(DataComponentPredicate dataComponentPredicate, Object object) {
        if (dataComponentPredicate == object) {
            return true;
        }
        if (object != null && object instanceof DataComponentPredicate) {
            DataComponentPredicate dataComponentPredicate2 = (DataComponentPredicate)object;
            if (dataComponentPredicate.id == dataComponentPredicate2.id && Objects.equals(dataComponentPredicate.predicate, dataComponentPredicate2.predicate)) {
                return true;
            }
        }
        return false;
    }
}

