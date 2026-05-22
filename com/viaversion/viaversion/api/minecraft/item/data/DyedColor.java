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
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="rgb", type=int.class), @RecordComponents.Value(name="showInTooltip", type=boolean.class)})
@NestMembers(value={2.class, 1.class})
public final class DyedColor
extends J_L_Record {
    private final int rgb;
    private final boolean showInTooltip;
    public static final Type<DyedColor> TYPE1_20_5 = new Type<DyedColor>(DyedColor.class){

        @Override
        public DyedColor read(ByteBuf buffer) {
            int rgb = buffer.readInt();
            boolean showInTooltip = buffer.readBoolean();
            return new DyedColor(rgb, showInTooltip);
        }

        @Override
        public void write(ByteBuf buffer, DyedColor value) {
            buffer.writeInt(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_DyedColor$get$rgb());
            buffer.writeBoolean(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_DyedColor$get$showInTooltip());
        }
    };
    public static final Type<DyedColor> TYPE1_21_5 = new Type<DyedColor>(DyedColor.class){

        @Override
        public DyedColor read(ByteBuf buffer) {
            int rgb = buffer.readInt();
            return new DyedColor(rgb);
        }

        @Override
        public void write(ByteBuf buffer, DyedColor value) {
            buffer.writeInt(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_DyedColor$get$rgb());
        }

        @Override
        public void write(Ops ops, DyedColor dyedColor) {
            ops.write(Types.INT, dyedColor.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_DyedColor$get$rgb());
        }
    };

    public DyedColor(int rgb) {
        this(rgb, true);
    }

    public DyedColor(int rgb, boolean showInTooltip) {
        this.rgb = rgb;
        this.showInTooltip = showInTooltip;
    }

    @Override
    public final String toString() {
        return DyedColor.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return DyedColor.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return DyedColor.jvmdowngrader$equals$equals(this, o2);
    }

    public int rgb() {
        return this.rgb;
    }

    public boolean showInTooltip() {
        return this.showInTooltip;
    }

    private static String jvmdowngrader$toString$toString(DyedColor dyedColor) {
        DyedColor dyedColor2 = dyedColor;
        return "DyedColor[" + "rgb=" + dyedColor.rgb + ", " + "showInTooltip=" + dyedColor.showInTooltip + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(DyedColor dyedColor) {
        Object[] objectArray = new Object[]{dyedColor.rgb, dyedColor.showInTooltip};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(DyedColor dyedColor, Object object) {
        if (dyedColor == object) {
            return true;
        }
        if (object != null && object instanceof DyedColor) {
            DyedColor dyedColor2 = (DyedColor)object;
            if (dyedColor.rgb == dyedColor2.rgb && dyedColor.showInTooltip == dyedColor2.showInTooltip) {
                return true;
            }
        }
        return false;
    }

    public int jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_DyedColor$get$rgb() {
        return this.rgb;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_DyedColor$set$rgb(int n2) {
        this.rgb = n2;
    }

    public boolean jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_DyedColor$get$showInTooltip() {
        return this.showInTooltip;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_DyedColor$set$showInTooltip(boolean bl2) {
        this.showInTooltip = bl2;
    }
}

