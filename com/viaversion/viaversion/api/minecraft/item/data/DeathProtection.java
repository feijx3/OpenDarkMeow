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
import com.viaversion.viaversion.api.minecraft.item.data.Consumable1_21_2;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.util.Copyable;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="deathEffects", type=Consumable1_21_2.ConsumeEffect[].class)})
@NestMembers(value={1.class})
public final class DeathProtection
extends J_L_Record
implements Copyable {
    private final Consumable1_21_2.ConsumeEffect<?>[] deathEffects;
    public static final Type<DeathProtection> TYPE = new Type<DeathProtection>(DeathProtection.class){

        @Override
        public DeathProtection read(ByteBuf buffer) {
            Consumable1_21_2.ConsumeEffect[] deathEffects = (Consumable1_21_2.ConsumeEffect[])Consumable1_21_2.ConsumeEffect.ARRAY_TYPE.read(buffer);
            return new DeathProtection(deathEffects);
        }

        @Override
        public void write(ByteBuf buffer, DeathProtection value) {
            Consumable1_21_2.ConsumeEffect.ARRAY_TYPE.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_DeathProtection$get$deathEffects());
        }
    };

    public DeathProtection(Consumable1_21_2.ConsumeEffect<?>[] deathEffects) {
        this.deathEffects = deathEffects;
    }

    @Override
    public DeathProtection copy() {
        return new DeathProtection(Copyable.copy(this.deathEffects));
    }

    @Override
    public final String toString() {
        return DeathProtection.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return DeathProtection.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return DeathProtection.jvmdowngrader$equals$equals(this, o2);
    }

    public Consumable1_21_2.ConsumeEffect<?>[] deathEffects() {
        return this.deathEffects;
    }

    private static String jvmdowngrader$toString$toString(DeathProtection deathProtection) {
        DeathProtection deathProtection2 = deathProtection;
        return "DeathProtection[" + "deathEffects=" + deathProtection.deathEffects + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(DeathProtection deathProtection) {
        Object[] objectArray = new Object[]{deathProtection.deathEffects};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(DeathProtection deathProtection, Object object) {
        if (deathProtection == object) {
            return true;
        }
        if (object != null && object instanceof DeathProtection) {
            DeathProtection deathProtection2 = (DeathProtection)object;
            if (Objects.equals(deathProtection.deathEffects, deathProtection2.deathEffects)) {
                return true;
            }
        }
        return false;
    }

    public Consumable1_21_2.ConsumeEffect[] jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_DeathProtection$get$deathEffects() {
        return this.deathEffects;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_DeathProtection$set$deathEffects(Consumable1_21_2.ConsumeEffect[] consumeEffectArray) {
        this.deathEffects = consumeEffectArray;
    }
}

