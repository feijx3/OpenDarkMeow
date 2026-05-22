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
import com.viaversion.viaversion.util.Key;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="typesTagKey", type=Key.class)})
@NestMembers(value={1.class})
public final class DamageResistant
extends J_L_Record {
    private final Key typesTagKey;
    public static final Type<DamageResistant> TYPE = new Type<DamageResistant>(DamageResistant.class){

        @Override
        public DamageResistant read(ByteBuf buffer) {
            Key typesTagKey = (Key)Types.RESOURCE_LOCATION.read(buffer);
            return new DamageResistant(typesTagKey);
        }

        @Override
        public void write(ByteBuf buffer, DamageResistant value) {
            Types.RESOURCE_LOCATION.write(buffer, value.typesTagKey());
        }

        @Override
        public void write(Ops ops, DamageResistant value) {
            ops.writeMap(map -> map.write("types", Types.TAG_KEY, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_DamageResistant$get$typesTagKey()));
        }
    };

    public DamageResistant(Key typesTagKey) {
        this.typesTagKey = typesTagKey;
    }

    @Override
    public final String toString() {
        return DamageResistant.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return DamageResistant.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return DamageResistant.jvmdowngrader$equals$equals(this, o2);
    }

    public Key typesTagKey() {
        return this.typesTagKey;
    }

    private static String jvmdowngrader$toString$toString(DamageResistant damageResistant) {
        DamageResistant damageResistant2 = damageResistant;
        return "DamageResistant[" + "typesTagKey=" + damageResistant.typesTagKey + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(DamageResistant damageResistant) {
        Object[] objectArray = new Object[]{damageResistant.typesTagKey};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(DamageResistant damageResistant, Object object) {
        if (damageResistant == object) {
            return true;
        }
        if (object != null && object instanceof DamageResistant) {
            DamageResistant damageResistant2 = (DamageResistant)object;
            if (Objects.equals(damageResistant.typesTagKey, damageResistant2.typesTagKey)) {
                return true;
            }
        }
        return false;
    }

    public Key jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_DamageResistant$get$typesTagKey() {
        return this.typesTagKey;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_DamageResistant$set$typesTagKey(Key key) {
        this.typesTagKey = key;
    }
}

