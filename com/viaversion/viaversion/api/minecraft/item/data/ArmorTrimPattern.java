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
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.HolderType;
import com.viaversion.viaversion.util.Copyable;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="assetName", type=String.class), @RecordComponents.Value(name="itemId", type=int.class), @RecordComponents.Value(name="description", type=Tag.class), @RecordComponents.Value(name="decal", type=boolean.class)})
@NestMembers(value={2.class, 1.class})
public final class ArmorTrimPattern
extends J_L_Record
implements Copyable,
Rewritable {
    private final String assetName;
    private final int itemId;
    private final Tag description;
    private final boolean decal;
    public static final HolderType<ArmorTrimPattern> TYPE1_20_5 = new HolderType<ArmorTrimPattern>(){

        @Override
        public ArmorTrimPattern readDirect(ByteBuf buffer) {
            String assetName = (String)Types.STRING.read(buffer);
            int itemId = Types.VAR_INT.readPrimitive(buffer);
            Tag description = (Tag)Types.TAG.read(buffer);
            boolean decal = buffer.readBoolean();
            return new ArmorTrimPattern(assetName, itemId, description, decal);
        }

        @Override
        public void writeDirect(ByteBuf buffer, ArmorTrimPattern value) {
            Types.STRING.write(buffer, value.assetName());
            Types.VAR_INT.writePrimitive(buffer, value.itemId());
            Types.TAG.write(buffer, value.description());
            buffer.writeBoolean(value.decal());
        }
    };
    public static final HolderType<ArmorTrimPattern> TYPE1_21_5 = new HolderType<ArmorTrimPattern>(){

        @Override
        public ArmorTrimPattern readDirect(ByteBuf buffer) {
            String assetName = (String)Types.STRING.read(buffer);
            Tag description = (Tag)Types.TAG.read(buffer);
            boolean decal = buffer.readBoolean();
            return new ArmorTrimPattern(assetName, description, decal);
        }

        @Override
        public void writeDirect(ByteBuf buffer, ArmorTrimPattern value) {
            Types.STRING.write(buffer, value.assetName());
            Types.TAG.write(buffer, value.description());
            buffer.writeBoolean(value.decal());
        }
    };

    public ArmorTrimPattern(String assetName, Tag description, boolean decal) {
        this(assetName, 0, description, decal);
    }

    public ArmorTrimPattern(String assetName, int itemId, Tag description, boolean decal) {
        this.assetName = assetName;
        this.itemId = itemId;
        this.description = description;
        this.decal = decal;
    }

    @Override
    public ArmorTrimPattern rewrite(UserConnection connection, Protocol<?, ?, ?, ?> protocol, boolean clientbound) {
        return new ArmorTrimPattern(this.assetName, Rewritable.rewriteItem(protocol, clientbound, this.itemId), this.description, this.decal);
    }

    @Override
    public ArmorTrimPattern copy() {
        return new ArmorTrimPattern(this.assetName, this.itemId, this.description.copy(), this.decal);
    }

    @Override
    public final String toString() {
        return ArmorTrimPattern.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return ArmorTrimPattern.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return ArmorTrimPattern.jvmdowngrader$equals$equals(this, o2);
    }

    public String assetName() {
        return this.assetName;
    }

    public int itemId() {
        return this.itemId;
    }

    public Tag description() {
        return this.description;
    }

    public boolean decal() {
        return this.decal;
    }

    private static String jvmdowngrader$toString$toString(ArmorTrimPattern armorTrimPattern) {
        ArmorTrimPattern armorTrimPattern2 = armorTrimPattern;
        return "ArmorTrimPattern[" + "assetName=" + armorTrimPattern.assetName + ", " + "itemId=" + armorTrimPattern.itemId + ", " + "description=" + armorTrimPattern.description + ", " + "decal=" + armorTrimPattern.decal + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(ArmorTrimPattern armorTrimPattern) {
        Object[] objectArray = new Object[]{armorTrimPattern.assetName, armorTrimPattern.itemId, armorTrimPattern.description, armorTrimPattern.decal};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(ArmorTrimPattern armorTrimPattern, Object object) {
        if (armorTrimPattern == object) {
            return true;
        }
        if (object != null && object instanceof ArmorTrimPattern) {
            ArmorTrimPattern armorTrimPattern2 = (ArmorTrimPattern)object;
            if (Objects.equals(armorTrimPattern.assetName, armorTrimPattern2.assetName) && armorTrimPattern.itemId == armorTrimPattern2.itemId && Objects.equals(armorTrimPattern.description, armorTrimPattern2.description) && armorTrimPattern.decal == armorTrimPattern2.decal) {
                return true;
            }
        }
        return false;
    }
}

