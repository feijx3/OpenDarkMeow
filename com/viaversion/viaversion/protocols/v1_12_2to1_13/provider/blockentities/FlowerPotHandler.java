/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.provider.blockentities;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.provider.BlockEntityProvider;
import com.viaversion.viaversion.util.Key;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@NestMembers(value={IntIdPair.class})
public class FlowerPotHandler
implements BlockEntityProvider.BlockEntityHandler {
    private static final int EMPTY_POT = 5265;
    private static final Map<String, Byte> STRING_TO_BYTE_ID = new HashMap<String, Byte>();
    private static final Map<IntIdPair, Integer> FLOWERS = new HashMap<IntIdPair, Integer>();

    private static void register(String identifier, byte blockId, byte blockData, int newId) {
        STRING_TO_BYTE_ID.put(identifier, blockId);
        FLOWERS.put(new IntIdPair(blockId, blockData), newId);
    }

    @Override
    public int transform(UserConnection user, CompoundTag tag) {
        Integer flower;
        Tag itemTag = tag.get("Item");
        byte item = 0;
        if (itemTag instanceof StringTag) {
            StringTag stringTag = (StringTag)itemTag;
            item = STRING_TO_BYTE_ID.getOrDefault(Key.stripMinecraftNamespace(stringTag.getValue()), (byte)0);
        } else if (itemTag instanceof NumberTag) {
            NumberTag numberTag = (NumberTag)itemTag;
            item = numberTag.asByte();
        }
        byte data = 0;
        Tag tag2 = tag.get("Data");
        if (tag2 instanceof NumberTag) {
            NumberTag dataTag = (NumberTag)tag2;
            data = dataTag.asByte();
        }
        if ((flower = FLOWERS.get(new IntIdPair(item, data))) != null) {
            return flower;
        }
        flower = FLOWERS.get(new IntIdPair(item, 0));
        if (flower != null) {
            return flower;
        }
        return 5265;
    }

    static {
        FlowerPotHandler.register("air", (byte)0, (byte)0, 5265);
        FlowerPotHandler.register("sapling", (byte)6, (byte)0, 5266);
        FlowerPotHandler.register("sapling", (byte)6, (byte)1, 5267);
        FlowerPotHandler.register("sapling", (byte)6, (byte)2, 5268);
        FlowerPotHandler.register("sapling", (byte)6, (byte)3, 5269);
        FlowerPotHandler.register("sapling", (byte)6, (byte)4, 5270);
        FlowerPotHandler.register("sapling", (byte)6, (byte)5, 5271);
        FlowerPotHandler.register("tallgrass", (byte)31, (byte)2, 5272);
        FlowerPotHandler.register("yellow_flower", (byte)37, (byte)0, 5273);
        FlowerPotHandler.register("red_flower", (byte)38, (byte)0, 5274);
        FlowerPotHandler.register("red_flower", (byte)38, (byte)1, 5275);
        FlowerPotHandler.register("red_flower", (byte)38, (byte)2, 5276);
        FlowerPotHandler.register("red_flower", (byte)38, (byte)3, 5277);
        FlowerPotHandler.register("red_flower", (byte)38, (byte)4, 5278);
        FlowerPotHandler.register("red_flower", (byte)38, (byte)5, 5279);
        FlowerPotHandler.register("red_flower", (byte)38, (byte)6, 5280);
        FlowerPotHandler.register("red_flower", (byte)38, (byte)7, 5281);
        FlowerPotHandler.register("red_flower", (byte)38, (byte)8, 5282);
        FlowerPotHandler.register("red_mushroom", (byte)40, (byte)0, 5283);
        FlowerPotHandler.register("brown_mushroom", (byte)39, (byte)0, 5284);
        FlowerPotHandler.register("deadbush", (byte)32, (byte)0, 5285);
        FlowerPotHandler.register("cactus", (byte)81, (byte)0, 5286);
    }

    @RecordComponents(value={@RecordComponents.Value(name="id", type=int.class), @RecordComponents.Value(name="data", type=byte.class)})
    @NestHost(value=FlowerPotHandler.class)
    private static final class IntIdPair
    extends J_L_Record {
        private final int id;
        private final byte data;

        IntIdPair(int id, byte data) {
            this.id = id;
            this.data = data;
        }

        @Override
        public final String toString() {
            return IntIdPair.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return IntIdPair.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return IntIdPair.jvmdowngrader$equals$equals(this, o2);
        }

        public int id() {
            return this.id;
        }

        public byte data() {
            return this.data;
        }

        private static String jvmdowngrader$toString$toString(IntIdPair intIdPair) {
            IntIdPair intIdPair2 = intIdPair;
            return "FlowerPotHandler$IntIdPair[" + "id=" + intIdPair.id + ", " + "data=" + intIdPair.data + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(IntIdPair intIdPair) {
            Object[] objectArray = new Object[]{intIdPair.id, intIdPair.data};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(IntIdPair intIdPair, Object object) {
            if (intIdPair == object) {
                return true;
            }
            if (object != null && object instanceof IntIdPair) {
                IntIdPair intIdPair2 = (IntIdPair)object;
                if (intIdPair.id == intIdPair2.id && intIdPair.data == intIdPair2.data) {
                    return true;
                }
            }
            return false;
        }
    }
}

