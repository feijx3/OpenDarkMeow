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
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.item.data.ToolRule;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="rules", type=ToolRule[].class), @RecordComponents.Value(name="defaultMiningSpeed", type=float.class), @RecordComponents.Value(name="damagePerBlock", type=int.class), @RecordComponents.Value(name="canDestroyBlocksInCreative", type=boolean.class)})
@NestMembers(value={2.class, 1.class})
public final class ToolProperties
extends J_L_Record
implements Rewritable {
    private final ToolRule[] rules;
    private final float defaultMiningSpeed;
    private final int damagePerBlock;
    private final boolean canDestroyBlocksInCreative;
    public static final Type<ToolProperties> TYPE1_20_5 = new Type<ToolProperties>(ToolProperties.class){

        @Override
        public ToolProperties read(ByteBuf buffer) {
            ToolRule[] rules = (ToolRule[])ToolRule.ARRAY_TYPE.read(buffer);
            float defaultMiningSpeed = buffer.readFloat();
            int damagePerBlock = Types.VAR_INT.readPrimitive(buffer);
            return new ToolProperties(rules, defaultMiningSpeed, damagePerBlock, true);
        }

        @Override
        public void write(ByteBuf buffer, ToolProperties value) {
            ToolRule.ARRAY_TYPE.write(buffer, value.rules());
            buffer.writeFloat(value.defaultMiningSpeed());
            Types.VAR_INT.writePrimitive(buffer, value.damagePerBlock());
        }
    };
    public static final Type<ToolProperties> TYPE1_21_5 = new Type<ToolProperties>(ToolProperties.class){

        @Override
        public ToolProperties read(ByteBuf buffer) {
            ToolRule[] rules = (ToolRule[])ToolRule.ARRAY_TYPE.read(buffer);
            float defaultMiningSpeed = buffer.readFloat();
            int damagePerBlock = Types.VAR_INT.readPrimitive(buffer);
            boolean canDestroyBlocksInCreative = buffer.readBoolean();
            return new ToolProperties(rules, defaultMiningSpeed, damagePerBlock, canDestroyBlocksInCreative);
        }

        @Override
        public void write(ByteBuf buffer, ToolProperties value) {
            ToolRule.ARRAY_TYPE.write(buffer, value.rules());
            buffer.writeFloat(value.defaultMiningSpeed());
            Types.VAR_INT.writePrimitive(buffer, value.damagePerBlock());
            buffer.writeBoolean(value.canDestroyBlocksInCreative());
        }
    };

    public ToolProperties(ToolRule[] rules, float defaultMiningSpeed, int damagePerBlock) {
        this(rules, defaultMiningSpeed, damagePerBlock, false);
    }

    public ToolProperties(ToolRule[] rules, float defaultMiningSpeed, int damagePerBlock, boolean canDestroyBlocksInCreative) {
        this.rules = rules;
        this.defaultMiningSpeed = defaultMiningSpeed;
        this.damagePerBlock = damagePerBlock;
        this.canDestroyBlocksInCreative = canDestroyBlocksInCreative;
    }

    @Override
    public ToolProperties rewrite(UserConnection connection, Protocol<?, ?, ?, ?> protocol, boolean clientbound) {
        ToolRule[] rules = new ToolRule[this.rules.length];
        for (int i2 = 0; i2 < rules.length; ++i2) {
            rules[i2] = this.rules[i2].rewrite(connection, (Protocol)protocol, clientbound);
        }
        return new ToolProperties(rules, this.defaultMiningSpeed, this.damagePerBlock, this.canDestroyBlocksInCreative);
    }

    @Override
    public final String toString() {
        return ToolProperties.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return ToolProperties.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return ToolProperties.jvmdowngrader$equals$equals(this, o2);
    }

    public ToolRule[] rules() {
        return this.rules;
    }

    public float defaultMiningSpeed() {
        return this.defaultMiningSpeed;
    }

    public int damagePerBlock() {
        return this.damagePerBlock;
    }

    public boolean canDestroyBlocksInCreative() {
        return this.canDestroyBlocksInCreative;
    }

    private static String jvmdowngrader$toString$toString(ToolProperties toolProperties) {
        ToolProperties toolProperties2 = toolProperties;
        return "ToolProperties[" + "rules=" + toolProperties.rules + ", " + "defaultMiningSpeed=" + toolProperties.defaultMiningSpeed + ", " + "damagePerBlock=" + toolProperties.damagePerBlock + ", " + "canDestroyBlocksInCreative=" + toolProperties.canDestroyBlocksInCreative + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(ToolProperties toolProperties) {
        Object[] objectArray = new Object[]{toolProperties.rules, Float.valueOf(toolProperties.defaultMiningSpeed), toolProperties.damagePerBlock, toolProperties.canDestroyBlocksInCreative};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(ToolProperties toolProperties, Object object) {
        if (toolProperties == object) {
            return true;
        }
        if (object != null && object instanceof ToolProperties) {
            ToolProperties toolProperties2 = (ToolProperties)object;
            if (Objects.equals(toolProperties.rules, toolProperties2.rules) && toolProperties.defaultMiningSpeed == toolProperties2.defaultMiningSpeed && toolProperties.damagePerBlock == toolProperties2.damagePerBlock && toolProperties.canDestroyBlocksInCreative == toolProperties2.canDestroyBlocksInCreative) {
                return true;
            }
        }
        return false;
    }
}

