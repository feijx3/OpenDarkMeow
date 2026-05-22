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

@RecordComponents(value={@RecordComponents.Value(name="value", type=int.class)})
@NestMembers(value={1.class})
public final class Enchantable
extends J_L_Record {
    private final int value;
    public static final Type<Enchantable> TYPE = new Type<Enchantable>(Enchantable.class){

        @Override
        public Enchantable read(ByteBuf buffer) {
            return new Enchantable(Types.VAR_INT.readPrimitive(buffer));
        }

        @Override
        public void write(ByteBuf buffer, Enchantable value) {
            Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Enchantable$get$value());
        }

        @Override
        public void write(Ops ops, Enchantable enchantable) {
            ops.writeMap(map -> map.write("value", Types.INT, enchantable.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Enchantable$get$value()));
        }
    };

    public Enchantable(int value) {
        this.value = value;
    }

    @Override
    public final String toString() {
        return Enchantable.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return Enchantable.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return Enchantable.jvmdowngrader$equals$equals(this, o2);
    }

    public int value() {
        return this.value;
    }

    private static String jvmdowngrader$toString$toString(Enchantable enchantable) {
        Enchantable enchantable2 = enchantable;
        return "Enchantable[" + "value=" + enchantable.value + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(Enchantable enchantable) {
        Object[] objectArray = new Object[]{enchantable.value};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(Enchantable enchantable, Object object) {
        if (enchantable == object) {
            return true;
        }
        if (object != null && object instanceof Enchantable) {
            Enchantable enchantable2 = (Enchantable)object;
            if (enchantable.value == enchantable2.value) {
                return true;
            }
        }
        return false;
    }

    public int jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Enchantable$get$value() {
        return this.value;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Enchantable$set$value(int n2) {
        this.value = n2;
    }
}

