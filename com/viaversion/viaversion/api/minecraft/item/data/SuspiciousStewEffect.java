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
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="mobEffect", type=int.class), @RecordComponents.Value(name="duration", type=int.class)})
@NestMembers(value={1.class})
public final class SuspiciousStewEffect
extends J_L_Record {
    private final int mobEffect;
    private final int duration;
    public static final Type<SuspiciousStewEffect> TYPE = new Type<SuspiciousStewEffect>(SuspiciousStewEffect.class){

        @Override
        public SuspiciousStewEffect read(ByteBuf buffer) {
            int effect = Types.VAR_INT.readPrimitive(buffer);
            int duration = Types.VAR_INT.readPrimitive(buffer);
            return new SuspiciousStewEffect(effect, duration);
        }

        @Override
        public void write(ByteBuf buffer, SuspiciousStewEffect value) {
            Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_SuspiciousStewEffect$get$mobEffect());
            Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_SuspiciousStewEffect$get$duration());
        }
    };
    public static final Type<SuspiciousStewEffect[]> ARRAY_TYPE = new ArrayType<SuspiciousStewEffect>(TYPE);

    public SuspiciousStewEffect(int mobEffect, int duration) {
        this.mobEffect = mobEffect;
        this.duration = duration;
    }

    @Override
    public final String toString() {
        return SuspiciousStewEffect.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return SuspiciousStewEffect.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return SuspiciousStewEffect.jvmdowngrader$equals$equals(this, o2);
    }

    public int mobEffect() {
        return this.mobEffect;
    }

    public int duration() {
        return this.duration;
    }

    private static String jvmdowngrader$toString$toString(SuspiciousStewEffect suspiciousStewEffect) {
        SuspiciousStewEffect suspiciousStewEffect2 = suspiciousStewEffect;
        return "SuspiciousStewEffect[" + "mobEffect=" + suspiciousStewEffect.mobEffect + ", " + "duration=" + suspiciousStewEffect.duration + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(SuspiciousStewEffect suspiciousStewEffect) {
        Object[] objectArray = new Object[]{suspiciousStewEffect.mobEffect, suspiciousStewEffect.duration};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(SuspiciousStewEffect suspiciousStewEffect, Object object) {
        if (suspiciousStewEffect == object) {
            return true;
        }
        if (object != null && object instanceof SuspiciousStewEffect) {
            SuspiciousStewEffect suspiciousStewEffect2 = (SuspiciousStewEffect)object;
            if (suspiciousStewEffect.mobEffect == suspiciousStewEffect2.mobEffect && suspiciousStewEffect.duration == suspiciousStewEffect2.duration) {
                return true;
            }
        }
        return false;
    }

    public int jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_SuspiciousStewEffect$get$duration() {
        return this.duration;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_SuspiciousStewEffect$set$duration(int n2) {
        this.duration = n2;
    }

    public int jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_SuspiciousStewEffect$get$mobEffect() {
        return this.mobEffect;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_SuspiciousStewEffect$set$mobEffect(int n2) {
        this.mobEffect = n2;
    }
}

