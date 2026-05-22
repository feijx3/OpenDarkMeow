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

@RecordComponents(value={@RecordComponents.Value(name="itemDamagePerAttack", type=int.class), @RecordComponents.Value(name="disableBlockingForSeconds", type=float.class)})
@NestMembers(value={1.class})
public final class Weapon
extends J_L_Record {
    private final int itemDamagePerAttack;
    private final float disableBlockingForSeconds;
    public static final Type<Weapon> TYPE = new Type<Weapon>(Weapon.class){

        @Override
        public Weapon read(ByteBuf buffer) {
            int damagePerAttack = Types.VAR_INT.readPrimitive(buffer);
            float disableBlockingForSeconds = buffer.readFloat();
            return new Weapon(damagePerAttack, disableBlockingForSeconds);
        }

        @Override
        public void write(ByteBuf buffer, Weapon value) {
            Types.VAR_INT.writePrimitive(buffer, value.itemDamagePerAttack());
            buffer.writeFloat(value.disableBlockingForSeconds());
        }

        @Override
        public void write(Ops ops, Weapon weapon) {
            ops.writeMap(map -> map.writeOptional("item_damage_per_attack", Types.INT, weapon.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Weapon$get$itemDamagePerAttack(), 1).writeOptional("disable_blocking_for_seconds", Types.FLOAT, Float.valueOf(weapon.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Weapon$get$disableBlockingForSeconds()), Float.valueOf(0.0f)));
        }
    };

    public Weapon(int itemDamagePerAttack, float disableBlockingForSeconds) {
        this.itemDamagePerAttack = itemDamagePerAttack;
        this.disableBlockingForSeconds = disableBlockingForSeconds;
    }

    @Override
    public final String toString() {
        return Weapon.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return Weapon.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return Weapon.jvmdowngrader$equals$equals(this, o2);
    }

    public int itemDamagePerAttack() {
        return this.itemDamagePerAttack;
    }

    public float disableBlockingForSeconds() {
        return this.disableBlockingForSeconds;
    }

    private static String jvmdowngrader$toString$toString(Weapon weapon) {
        Weapon weapon2 = weapon;
        return "Weapon[" + "itemDamagePerAttack=" + weapon.itemDamagePerAttack + ", " + "disableBlockingForSeconds=" + weapon.disableBlockingForSeconds + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(Weapon weapon) {
        Object[] objectArray = new Object[]{weapon.itemDamagePerAttack, Float.valueOf(weapon.disableBlockingForSeconds)};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(Weapon weapon, Object object) {
        if (weapon == object) {
            return true;
        }
        if (object != null && object instanceof Weapon) {
            Weapon weapon2 = (Weapon)object;
            if (weapon.itemDamagePerAttack == weapon2.itemDamagePerAttack && weapon.disableBlockingForSeconds == weapon2.disableBlockingForSeconds) {
                return true;
            }
        }
        return false;
    }

    public int jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Weapon$get$itemDamagePerAttack() {
        return this.itemDamagePerAttack;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Weapon$set$itemDamagePerAttack(int n2) {
        this.itemDamagePerAttack = n2;
    }

    public float jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Weapon$get$disableBlockingForSeconds() {
        return this.disableBlockingForSeconds;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Weapon$set$disableBlockingForSeconds(float f2) {
        this.disableBlockingForSeconds = f2;
    }
}

