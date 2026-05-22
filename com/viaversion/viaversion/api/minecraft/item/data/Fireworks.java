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
import com.viaversion.viaversion.api.minecraft.item.data.FireworkExplosion;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.Copyable;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="flightDuration", type=int.class), @RecordComponents.Value(name="explosions", type=FireworkExplosion[].class)})
@NestMembers(value={1.class})
public final class Fireworks
extends J_L_Record
implements Copyable {
    private final int flightDuration;
    private final FireworkExplosion[] explosions;
    public static final Type<Fireworks> TYPE = new Type<Fireworks>(Fireworks.class){

        @Override
        public Fireworks read(ByteBuf buffer) {
            int flightDuration = Types.VAR_INT.readPrimitive(buffer);
            FireworkExplosion[] explosions = (FireworkExplosion[])FireworkExplosion.ARRAY_TYPE.read(buffer);
            return new Fireworks(flightDuration, explosions);
        }

        @Override
        public void write(ByteBuf buffer, Fireworks value) {
            Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Fireworks$get$flightDuration());
            FireworkExplosion.ARRAY_TYPE.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Fireworks$get$explosions());
        }

        @Override
        public void write(Ops ops, Fireworks value) {
            ops.writeMap(map -> map.writeOptional("flight_duration", Types.UNSIGNED_BYTE, (short)value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Fireworks$get$flightDuration(), (short)0).writeOptional("explosions", FireworkExplosion.ARRAY_TYPE, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Fireworks$get$explosions(), new FireworkExplosion[0]));
        }
    };

    public Fireworks(int flightDuration, FireworkExplosion[] explosions) {
        this.flightDuration = flightDuration;
        this.explosions = explosions;
    }

    @Override
    public Fireworks copy() {
        return new Fireworks(this.flightDuration, Copyable.copy(this.explosions));
    }

    @Override
    public final String toString() {
        return Fireworks.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return Fireworks.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return Fireworks.jvmdowngrader$equals$equals(this, o2);
    }

    public int flightDuration() {
        return this.flightDuration;
    }

    public FireworkExplosion[] explosions() {
        return this.explosions;
    }

    private static String jvmdowngrader$toString$toString(Fireworks fireworks) {
        Fireworks fireworks2 = fireworks;
        return "Fireworks[" + "flightDuration=" + fireworks.flightDuration + ", " + "explosions=" + fireworks.explosions + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(Fireworks fireworks) {
        Object[] objectArray = new Object[]{fireworks.flightDuration, fireworks.explosions};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(Fireworks fireworks, Object object) {
        if (fireworks == object) {
            return true;
        }
        if (object != null && object instanceof Fireworks) {
            Fireworks fireworks2 = (Fireworks)object;
            if (fireworks.flightDuration == fireworks2.flightDuration && Objects.equals(fireworks.explosions, fireworks2.explosions)) {
                return true;
            }
        }
        return false;
    }

    public int jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Fireworks$get$flightDuration() {
        return this.flightDuration;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Fireworks$set$flightDuration(int n2) {
        this.flightDuration = n2;
    }

    public FireworkExplosion[] jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Fireworks$get$explosions() {
        return this.explosions;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Fireworks$set$explosions(FireworkExplosion[] fireworkExplosionArray) {
        this.explosions = fireworkExplosionArray;
    }
}

