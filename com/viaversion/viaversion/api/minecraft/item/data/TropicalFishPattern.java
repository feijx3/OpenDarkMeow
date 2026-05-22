/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  xyz.wagyourtail.jvmdg.j11.NestHost
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
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="packedId", type=int.class)})
@NestMembers(value={Pattern.class, 1.class})
public final class TropicalFishPattern
extends J_L_Record {
    private final int packedId;
    public static final Type<TropicalFishPattern> TYPE = new Type<TropicalFishPattern>(TropicalFishPattern.class){

        @Override
        public TropicalFishPattern read(ByteBuf buffer) {
            int packedId = Types.VAR_INT.readPrimitive(buffer);
            return new TropicalFishPattern(packedId);
        }

        @Override
        public void write(ByteBuf buffer, TropicalFishPattern value) {
            Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_TropicalFishPattern$get$packedId());
        }

        @Override
        public void write(Ops ops, TropicalFishPattern value) {
            Pattern pattern = Arrays.stream(Pattern.values()).filter(e2 -> e2.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_TropicalFishPattern$Pattern$get$packedId() == value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_TropicalFishPattern$get$packedId()).findAny().orElse(Pattern.KOB);
            ops.write(Types.STRING, pattern.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_TropicalFishPattern$Pattern$get$key());
        }
    };

    public TropicalFishPattern(int packedId) {
        this.packedId = packedId;
    }

    public int sizeId() {
        return this.packedId & 0xFF;
    }

    public int sizeSpecificId() {
        return this.packedId >> 8;
    }

    @Override
    public final String toString() {
        return TropicalFishPattern.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return TropicalFishPattern.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return TropicalFishPattern.jvmdowngrader$equals$equals(this, o2);
    }

    public int packedId() {
        return this.packedId;
    }

    private static String jvmdowngrader$toString$toString(TropicalFishPattern tropicalFishPattern) {
        TropicalFishPattern tropicalFishPattern2 = tropicalFishPattern;
        return "TropicalFishPattern[" + "packedId=" + tropicalFishPattern.packedId + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(TropicalFishPattern tropicalFishPattern) {
        Object[] objectArray = new Object[]{tropicalFishPattern.packedId};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(TropicalFishPattern tropicalFishPattern, Object object) {
        if (tropicalFishPattern == object) {
            return true;
        }
        if (object != null && object instanceof TropicalFishPattern) {
            TropicalFishPattern tropicalFishPattern2 = (TropicalFishPattern)object;
            if (tropicalFishPattern.packedId == tropicalFishPattern2.packedId) {
                return true;
            }
        }
        return false;
    }

    public int jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_TropicalFishPattern$get$packedId() {
        return this.packedId;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_TropicalFishPattern$set$packedId(int n2) {
        this.packedId = n2;
    }

    @NestHost(value=TropicalFishPattern.class)
    private static enum Pattern {
        KOB("kob", 0, 0),
        SUNSTREAK("sunstreak", 0, 1),
        SNOOPER("snooper", 0, 2),
        DASHER("dasher", 0, 3),
        BRINELY("brinely", 0, 4),
        SPOTTY("spotty", 0, 5),
        FLOPPER("flopper", 1, 0),
        STRIPEY("stripey", 1, 1),
        GLITTER("glitter", 1, 2),
        BLOCKFISH("blockfish", 1, 3),
        BETTY("betty", 1, 4),
        CLAYFISH("clayfish", 1, 5);

        private final String key;
        private final int packedId;

        private Pattern(String key, int sizeId, int sizeSpecificId) {
            this.key = key;
            this.packedId = sizeId | sizeSpecificId << 8;
        }

        public int jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_TropicalFishPattern$Pattern$get$packedId() {
            return this.packedId;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_TropicalFishPattern$Pattern$set$packedId(int n2) {
            this.packedId = n2;
        }

        public String jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_TropicalFishPattern$Pattern$get$key() {
            return this.key;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_TropicalFishPattern$Pattern$set$key(String string) {
            this.key = string;
        }
    }
}

