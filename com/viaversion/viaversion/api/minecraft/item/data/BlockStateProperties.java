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
import com.viaversion.viaversion.libs.fastutil.objects.Object2ObjectOpenHashMap;
import com.viaversion.viaversion.util.Copyable;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="properties", type=Map.class)})
@NestMembers(value={1.class})
public final class BlockStateProperties
extends J_L_Record
implements Copyable {
    private final Map<String, String> properties;
    public static final Type<BlockStateProperties> TYPE = new Type<BlockStateProperties>(BlockStateProperties.class){

        @Override
        public BlockStateProperties read(ByteBuf buffer) {
            int size = Types.VAR_INT.readPrimitive(buffer);
            Object2ObjectOpenHashMap<String, String> properties = new Object2ObjectOpenHashMap<String, String>();
            for (int i2 = 0; i2 < size; ++i2) {
                properties.put((String)Types.STRING.read(buffer), (String)Types.STRING.read(buffer));
            }
            return new BlockStateProperties(properties);
        }

        @Override
        public void write(ByteBuf buffer, BlockStateProperties value) {
            Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BlockStateProperties$get$properties().size());
            for (Map.Entry entry : value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BlockStateProperties$get$properties().entrySet()) {
                Types.STRING.write(buffer, (String)entry.getKey());
                Types.STRING.write(buffer, (String)entry.getValue());
            }
        }

        @Override
        public void write(Ops ops, BlockStateProperties value) {
            ops.writeMap(map -> {
                for (Map.Entry entry : value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BlockStateProperties$get$properties().entrySet()) {
                    map.write(Types.STRING, (String)entry.getKey(), Types.STRING, (String)entry.getValue());
                }
            });
        }
    };

    public BlockStateProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    @Override
    public BlockStateProperties copy() {
        return new BlockStateProperties(new Object2ObjectOpenHashMap<String, String>(this.properties));
    }

    @Override
    public final String toString() {
        return BlockStateProperties.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return BlockStateProperties.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return BlockStateProperties.jvmdowngrader$equals$equals(this, o2);
    }

    public Map<String, String> properties() {
        return this.properties;
    }

    private static String jvmdowngrader$toString$toString(BlockStateProperties blockStateProperties) {
        BlockStateProperties blockStateProperties2 = blockStateProperties;
        return "BlockStateProperties[" + "properties=" + blockStateProperties.properties + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(BlockStateProperties blockStateProperties) {
        Object[] objectArray = new Object[]{blockStateProperties.properties};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(BlockStateProperties blockStateProperties, Object object) {
        if (blockStateProperties == object) {
            return true;
        }
        if (object != null && object instanceof BlockStateProperties) {
            BlockStateProperties blockStateProperties2 = (BlockStateProperties)object;
            if (Objects.equals(blockStateProperties.properties, blockStateProperties2.properties)) {
                return true;
            }
        }
        return false;
    }

    public Map jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BlockStateProperties$get$properties() {
        return this.properties;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BlockStateProperties$set$properties(Map map) {
        this.properties = map;
    }
}

