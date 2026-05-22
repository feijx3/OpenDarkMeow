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
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntOpenHashMap;
import com.viaversion.viaversion.util.Copyable;
import com.viaversion.viaversion.util.Key;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="enchantments", type=Int2IntMap.class), @RecordComponents.Value(name="showInTooltip", type=boolean.class)})
@NestMembers(value={2.class, 1.class})
public final class Enchantments
extends J_L_Record
implements Copyable {
    private final Int2IntMap enchantments;
    private final boolean showInTooltip;
    public static final Type<Enchantments> TYPE1_20_5 = new Type<Enchantments>(Enchantments.class){

        @Override
        public Enchantments read(ByteBuf buffer) {
            Int2IntOpenHashMap enchantments = new Int2IntOpenHashMap();
            int size = Types.VAR_INT.readPrimitive(buffer);
            for (int i2 = 0; i2 < size; ++i2) {
                int id = Types.VAR_INT.readPrimitive(buffer);
                int level = Types.VAR_INT.readPrimitive(buffer);
                enchantments.put(id, level);
            }
            return new Enchantments(enchantments, buffer.readBoolean());
        }

        @Override
        public void write(ByteBuf buffer, Enchantments value) {
            Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Enchantments$get$enchantments().size());
            for (Int2IntMap.Entry entry : value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Enchantments$get$enchantments().int2IntEntrySet()) {
                Types.VAR_INT.writePrimitive(buffer, entry.getIntKey());
                Types.VAR_INT.writePrimitive(buffer, entry.getIntValue());
            }
            buffer.writeBoolean(value.showInTooltip());
        }
    };
    public static final Type<Enchantments> TYPE1_21_5 = new Type<Enchantments>(Enchantments.class){

        @Override
        public Enchantments read(ByteBuf buffer) {
            Int2IntOpenHashMap enchantments = new Int2IntOpenHashMap();
            int size = Types.VAR_INT.readPrimitive(buffer);
            for (int i2 = 0; i2 < size; ++i2) {
                int id = Types.VAR_INT.readPrimitive(buffer);
                int level = Types.VAR_INT.readPrimitive(buffer);
                enchantments.put(id, level);
            }
            return new Enchantments(enchantments);
        }

        @Override
        public void write(ByteBuf buffer, Enchantments value) {
            Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Enchantments$get$enchantments().size());
            for (Int2IntMap.Entry entry : value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Enchantments$get$enchantments().int2IntEntrySet()) {
                Types.VAR_INT.writePrimitive(buffer, entry.getIntKey());
                Types.VAR_INT.writePrimitive(buffer, entry.getIntValue());
            }
        }

        @Override
        public void write(Ops ops, Enchantments value) {
            ops.writeMap(map -> {
                for (Int2IntMap.Entry entry : value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Enchantments$get$enchantments().int2IntEntrySet()) {
                    Key key = ops.context().registryAccess().enchantment(entry.getIntKey());
                    map.write(Types.RESOURCE_LOCATION, key, Types.VAR_INT, Integer.valueOf(entry.getIntValue()));
                }
            });
        }
    };

    public Enchantments(Int2IntMap enchantments) {
        this(enchantments, true);
    }

    public Enchantments(boolean showInTooltip) {
        this(new Int2IntOpenHashMap(), showInTooltip);
    }

    public Enchantments(Int2IntMap enchantments, boolean showInTooltip) {
        this.enchantments = enchantments;
        this.showInTooltip = showInTooltip;
    }

    public int size() {
        return this.enchantments.size();
    }

    public void add(int id, int level) {
        this.enchantments.put(id, level);
    }

    public void remove(int id) {
        this.enchantments.remove(id);
    }

    public void clear() {
        this.enchantments.clear();
    }

    public int getLevel(int id) {
        return this.enchantments.getOrDefault(id, -1);
    }

    @Override
    public Enchantments copy() {
        return new Enchantments(new Int2IntOpenHashMap(this.enchantments), this.showInTooltip);
    }

    @Override
    public final String toString() {
        return Enchantments.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return Enchantments.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return Enchantments.jvmdowngrader$equals$equals(this, o2);
    }

    public Int2IntMap enchantments() {
        return this.enchantments;
    }

    public boolean showInTooltip() {
        return this.showInTooltip;
    }

    private static String jvmdowngrader$toString$toString(Enchantments enchantments) {
        Enchantments enchantments2 = enchantments;
        return "Enchantments[" + "enchantments=" + enchantments.enchantments + ", " + "showInTooltip=" + enchantments.showInTooltip + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(Enchantments enchantments) {
        Object[] objectArray = new Object[]{enchantments.enchantments, enchantments.showInTooltip};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(Enchantments enchantments, Object object) {
        if (enchantments == object) {
            return true;
        }
        if (object != null && object instanceof Enchantments) {
            Enchantments enchantments2 = (Enchantments)object;
            if (Objects.equals(enchantments.enchantments, enchantments2.enchantments) && enchantments.showInTooltip == enchantments2.showInTooltip) {
                return true;
            }
        }
        return false;
    }

    public Int2IntMap jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Enchantments$get$enchantments() {
        return this.enchantments;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_Enchantments$set$enchantments(Int2IntMap int2IntMap) {
        this.enchantments = int2IntMap;
    }
}

