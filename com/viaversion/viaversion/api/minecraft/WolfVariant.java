/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.minecraft;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.HolderType;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="wildTexture", type=String.class), @RecordComponents.Value(name="tameTexture", type=String.class), @RecordComponents.Value(name="angryTexture", type=String.class), @RecordComponents.Value(name="biomes", type=HolderSet.class)})
@NestMembers(value={1.class})
public final class WolfVariant
extends J_L_Record {
    private final String wildTexture;
    private final String tameTexture;
    private final String angryTexture;
    private final HolderSet biomes;
    public static HolderType<WolfVariant> TYPE = new HolderType<WolfVariant>(){

        @Override
        public WolfVariant readDirect(ByteBuf buffer) {
            String wildTexture = (String)Types.STRING.read(buffer);
            String tameTexture = (String)Types.STRING.read(buffer);
            String angryTexture = (String)Types.STRING.read(buffer);
            HolderSet biomes = (HolderSet)Types.HOLDER_SET.read(buffer);
            return new WolfVariant(wildTexture, tameTexture, angryTexture, biomes);
        }

        @Override
        public void writeDirect(ByteBuf buffer, WolfVariant variant) {
            Types.STRING.write(buffer, variant.wildTexture());
            Types.STRING.write(buffer, variant.tameTexture());
            Types.STRING.write(buffer, variant.angryTexture());
            Types.HOLDER_SET.write(buffer, variant.biomes());
        }
    };

    public WolfVariant(String wildTexture, String tameTexture, String angryTexture, HolderSet biomes) {
        this.wildTexture = wildTexture;
        this.tameTexture = tameTexture;
        this.angryTexture = angryTexture;
        this.biomes = biomes;
    }

    @Override
    public final String toString() {
        return WolfVariant.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return WolfVariant.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return WolfVariant.jvmdowngrader$equals$equals(this, o2);
    }

    public String wildTexture() {
        return this.wildTexture;
    }

    public String tameTexture() {
        return this.tameTexture;
    }

    public String angryTexture() {
        return this.angryTexture;
    }

    public HolderSet biomes() {
        return this.biomes;
    }

    private static String jvmdowngrader$toString$toString(WolfVariant wolfVariant) {
        WolfVariant wolfVariant2 = wolfVariant;
        return "WolfVariant[" + "wildTexture=" + wolfVariant.wildTexture + ", " + "tameTexture=" + wolfVariant.tameTexture + ", " + "angryTexture=" + wolfVariant.angryTexture + ", " + "biomes=" + wolfVariant.biomes + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(WolfVariant wolfVariant) {
        Object[] objectArray = new Object[]{wolfVariant.wildTexture, wolfVariant.tameTexture, wolfVariant.angryTexture, wolfVariant.biomes};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(WolfVariant wolfVariant, Object object) {
        if (wolfVariant == object) {
            return true;
        }
        if (object != null && object instanceof WolfVariant) {
            WolfVariant wolfVariant2 = (WolfVariant)object;
            if (Objects.equals(wolfVariant.wildTexture, wolfVariant2.wildTexture) && Objects.equals(wolfVariant.tameTexture, wolfVariant2.tameTexture) && Objects.equals(wolfVariant.angryTexture, wolfVariant2.angryTexture) && Objects.equals(wolfVariant.biomes, wolfVariant2.biomes)) {
                return true;
            }
        }
        return false;
    }
}

