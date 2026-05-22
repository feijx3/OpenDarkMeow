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
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.item.data.BannerPattern;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="pattern", type=Holder.class), @RecordComponents.Value(name="dyeColor", type=int.class)})
@NestMembers(value={1.class})
public final class BannerPatternLayer
extends J_L_Record {
    private final Holder<BannerPattern> pattern;
    private final int dyeColor;
    public static final Type<BannerPatternLayer> TYPE = new Type<BannerPatternLayer>(BannerPatternLayer.class){

        @Override
        public BannerPatternLayer read(ByteBuf buffer) {
            Object pattern = BannerPattern.TYPE.read(buffer);
            int color = Types.VAR_INT.readPrimitive(buffer);
            return new BannerPatternLayer((Holder<BannerPattern>)pattern, color);
        }

        @Override
        public void write(ByteBuf buffer, BannerPatternLayer value) {
            BannerPattern.TYPE.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BannerPatternLayer$get$pattern());
            Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BannerPatternLayer$get$dyeColor());
        }
    };
    public static final Type<BannerPatternLayer[]> ARRAY_TYPE = new ArrayType<BannerPatternLayer>(TYPE);

    public BannerPatternLayer(Holder<BannerPattern> pattern, int dyeColor) {
        this.pattern = pattern;
        this.dyeColor = dyeColor;
    }

    @Override
    public final String toString() {
        return BannerPatternLayer.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return BannerPatternLayer.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return BannerPatternLayer.jvmdowngrader$equals$equals(this, o2);
    }

    public Holder<BannerPattern> pattern() {
        return this.pattern;
    }

    public int dyeColor() {
        return this.dyeColor;
    }

    private static String jvmdowngrader$toString$toString(BannerPatternLayer bannerPatternLayer) {
        BannerPatternLayer bannerPatternLayer2 = bannerPatternLayer;
        return "BannerPatternLayer[" + "pattern=" + bannerPatternLayer.pattern + ", " + "dyeColor=" + bannerPatternLayer.dyeColor + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(BannerPatternLayer bannerPatternLayer) {
        Object[] objectArray = new Object[]{bannerPatternLayer.pattern, bannerPatternLayer.dyeColor};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(BannerPatternLayer bannerPatternLayer, Object object) {
        if (bannerPatternLayer == object) {
            return true;
        }
        if (object != null && object instanceof BannerPatternLayer) {
            BannerPatternLayer bannerPatternLayer2 = (BannerPatternLayer)object;
            if (Objects.equals(bannerPatternLayer.pattern, bannerPatternLayer2.pattern) && bannerPatternLayer.dyeColor == bannerPatternLayer2.dyeColor) {
                return true;
            }
        }
        return false;
    }

    public Holder jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BannerPatternLayer$get$pattern() {
        return this.pattern;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BannerPatternLayer$set$pattern(Holder holder) {
        this.pattern = holder;
    }

    public int jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BannerPatternLayer$get$dyeColor() {
        return this.dyeColor;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BannerPatternLayer$set$dyeColor(int n2) {
        this.dyeColor = n2;
    }
}

