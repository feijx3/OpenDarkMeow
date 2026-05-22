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
import com.viaversion.viaversion.api.minecraft.item.data.EnumTypes;
import com.viaversion.viaversion.api.minecraft.item.data.PotionEffectData;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="effect", type=int.class), @RecordComponents.Value(name="effectData", type=PotionEffectData.class)})
@NestMembers(value={1.class})
public final class PotionEffect
extends J_L_Record {
    private final int effect;
    private final PotionEffectData effectData;
    public static final Type<PotionEffect> TYPE = new Type<PotionEffect>(PotionEffect.class){

        @Override
        public PotionEffect read(ByteBuf buffer) {
            int effect = Types.VAR_INT.readPrimitive(buffer);
            PotionEffectData effectData = (PotionEffectData)PotionEffectData.TYPE.read(buffer);
            return new PotionEffect(effect, effectData);
        }

        @Override
        public void write(ByteBuf buffer, PotionEffect value) {
            Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffect$get$effect());
            PotionEffectData.TYPE.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffect$get$effectData());
        }

        @Override
        public void write(Ops ops, PotionEffect value) {
            ops.writeMap(map -> map.write("id", EnumTypes.MOB_EFFECT, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffect$get$effect()).writeInlinedMap(PotionEffectData.TYPE, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffect$get$effectData()));
        }
    };
    public static final Type<PotionEffect[]> ARRAY_TYPE = new ArrayType<PotionEffect>(TYPE);

    public PotionEffect(int effect, PotionEffectData effectData) {
        this.effect = effect;
        this.effectData = effectData;
    }

    @Override
    public final String toString() {
        return PotionEffect.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return PotionEffect.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return PotionEffect.jvmdowngrader$equals$equals(this, o2);
    }

    public int effect() {
        return this.effect;
    }

    public PotionEffectData effectData() {
        return this.effectData;
    }

    private static String jvmdowngrader$toString$toString(PotionEffect potionEffect) {
        PotionEffect potionEffect2 = potionEffect;
        return "PotionEffect[" + "effect=" + potionEffect.effect + ", " + "effectData=" + potionEffect.effectData + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(PotionEffect potionEffect) {
        Object[] objectArray = new Object[]{potionEffect.effect, potionEffect.effectData};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(PotionEffect potionEffect, Object object) {
        if (potionEffect == object) {
            return true;
        }
        if (object != null && object instanceof PotionEffect) {
            PotionEffect potionEffect2 = (PotionEffect)object;
            if (potionEffect.effect == potionEffect2.effect && Objects.equals(potionEffect.effectData, potionEffect2.effectData)) {
                return true;
            }
        }
        return false;
    }

    public PotionEffectData jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffect$get$effectData() {
        return this.effectData;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffect$set$effectData(PotionEffectData potionEffectData) {
        this.effectData = potionEffectData;
    }

    public int jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffect$get$effect() {
        return this.effect;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionEffect$set$effect(int n2) {
        this.effect = n2;
    }
}

