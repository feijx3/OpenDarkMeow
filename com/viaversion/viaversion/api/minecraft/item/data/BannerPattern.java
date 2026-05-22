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
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.HolderType;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="assetId", type=String.class), @RecordComponents.Value(name="translationKey", type=String.class)})
@NestMembers(value={1.class})
public final class BannerPattern
extends J_L_Record {
    private final String assetId;
    private final String translationKey;
    public static final HolderType<BannerPattern> TYPE = new HolderType<BannerPattern>(){

        @Override
        public BannerPattern readDirect(ByteBuf buffer) {
            String assetId = (String)Types.STRING.read(buffer);
            String translationKey = (String)Types.STRING.read(buffer);
            return new BannerPattern(assetId, translationKey);
        }

        @Override
        public void writeDirect(ByteBuf buffer, BannerPattern value) {
            Types.STRING.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BannerPattern$get$assetId());
            Types.STRING.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BannerPattern$get$translationKey());
        }
    };

    public BannerPattern(String assetId, String translationKey) {
        this.assetId = assetId;
        this.translationKey = translationKey;
    }

    @Override
    public final String toString() {
        return BannerPattern.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return BannerPattern.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return BannerPattern.jvmdowngrader$equals$equals(this, o2);
    }

    public String assetId() {
        return this.assetId;
    }

    public String translationKey() {
        return this.translationKey;
    }

    private static String jvmdowngrader$toString$toString(BannerPattern bannerPattern) {
        BannerPattern bannerPattern2 = bannerPattern;
        return "BannerPattern[" + "assetId=" + bannerPattern.assetId + ", " + "translationKey=" + bannerPattern.translationKey + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(BannerPattern bannerPattern) {
        Object[] objectArray = new Object[]{bannerPattern.assetId, bannerPattern.translationKey};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(BannerPattern bannerPattern, Object object) {
        if (bannerPattern == object) {
            return true;
        }
        if (object != null && object instanceof BannerPattern) {
            BannerPattern bannerPattern2 = (BannerPattern)object;
            if (Objects.equals(bannerPattern.assetId, bannerPattern2.assetId) && Objects.equals(bannerPattern.translationKey, bannerPattern2.translationKey)) {
                return true;
            }
        }
        return false;
    }

    public String jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BannerPattern$get$translationKey() {
        return this.translationKey;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BannerPattern$set$translationKey(String string) {
        this.translationKey = string;
    }

    public String jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BannerPattern$get$assetId() {
        return this.assetId;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BannerPattern$set$assetId(String string) {
        this.assetId = string;
    }
}

