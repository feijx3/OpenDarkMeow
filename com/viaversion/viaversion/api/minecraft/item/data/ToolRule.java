/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="blocks", type=HolderSet.class), @RecordComponents.Value(name="speed", type=Float.class), @RecordComponents.Value(name="correctForDrops", type=Boolean.class)})
@NestMembers(value={1.class})
public final class ToolRule
extends J_L_Record
implements Rewritable {
    private final HolderSet blocks;
    private final @Nullable Float speed;
    private final @Nullable Boolean correctForDrops;
    public static final Type<ToolRule> TYPE = new Type<ToolRule>(ToolRule.class){

        @Override
        public ToolRule read(ByteBuf buffer) {
            HolderSet blocks = (HolderSet)Types.HOLDER_SET.read(buffer);
            Float speed = (Float)Types.OPTIONAL_FLOAT.read(buffer);
            Boolean correctForDrops = (Boolean)Types.OPTIONAL_BOOLEAN.read(buffer);
            return new ToolRule(blocks, speed, correctForDrops);
        }

        @Override
        public void write(ByteBuf buffer, ToolRule value) {
            Types.HOLDER_SET.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_ToolRule$get$blocks());
            Types.OPTIONAL_FLOAT.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_ToolRule$get$speed());
            Types.OPTIONAL_BOOLEAN.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_ToolRule$get$correctForDrops());
        }
    };
    public static final Type<ToolRule[]> ARRAY_TYPE = new ArrayType<ToolRule>(TYPE);

    public ToolRule(HolderSet blocks, @Nullable Float speed, @Nullable Boolean correctForDrops) {
        this.blocks = blocks;
        this.speed = speed;
        this.correctForDrops = correctForDrops;
    }

    @Override
    public ToolRule rewrite(UserConnection connection, Protocol<?, ?, ?, ?> protocol, boolean clientbound) {
        return this.blocks.hasIds() ? new ToolRule(this.blocks.rewrite(Rewritable.blockRewriteFunction(protocol, clientbound)), this.speed, this.correctForDrops) : this;
    }

    @Override
    public final String toString() {
        return ToolRule.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return ToolRule.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return ToolRule.jvmdowngrader$equals$equals(this, o2);
    }

    public HolderSet blocks() {
        return this.blocks;
    }

    public @Nullable Float speed() {
        return this.speed;
    }

    public @Nullable Boolean correctForDrops() {
        return this.correctForDrops;
    }

    private static String jvmdowngrader$toString$toString(ToolRule toolRule) {
        ToolRule toolRule2 = toolRule;
        return "ToolRule[" + "blocks=" + toolRule.blocks + ", " + "speed=" + toolRule.speed + ", " + "correctForDrops=" + toolRule.correctForDrops + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(ToolRule toolRule) {
        Object[] objectArray = new Object[]{toolRule.blocks, toolRule.speed, toolRule.correctForDrops};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(ToolRule toolRule, Object object) {
        if (toolRule == object) {
            return true;
        }
        if (object != null && object instanceof ToolRule) {
            ToolRule toolRule2 = (ToolRule)object;
            if (Objects.equals(toolRule.blocks, toolRule2.blocks) && Objects.equals(toolRule.speed, toolRule2.speed) && Objects.equals(toolRule.correctForDrops, toolRule2.correctForDrops)) {
                return true;
            }
        }
        return false;
    }

    public HolderSet jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_ToolRule$get$blocks() {
        return this.blocks;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_ToolRule$set$blocks(HolderSet holderSet) {
        this.blocks = holderSet;
    }

    public Float jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_ToolRule$get$speed() {
        return this.speed;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_ToolRule$set$speed(Float f2) {
        this.speed = f2;
    }

    public Boolean jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_ToolRule$get$correctForDrops() {
        return this.correctForDrops;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_ToolRule$set$correctForDrops(Boolean bl2) {
        this.correctForDrops = bl2;
    }
}

