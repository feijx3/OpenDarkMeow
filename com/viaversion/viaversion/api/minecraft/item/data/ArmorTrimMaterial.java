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
import com.viaversion.viaversion.libs.fastutil.objects.Object2ObjectArrayMap;
import com.viaversion.viaversion.util.Copyable;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="assetName", type=String.class), @RecordComponents.Value(name="itemId", type=int.class), @RecordComponents.Value(name="itemModelIndex", type=float.class), @RecordComponents.Value(name="overrideArmorMaterials", type=Map.class), @RecordComponents.Value(name="description", type=Tag.class)})
@NestMembers(value={4.class, 3.class, 2.class, 1.class})
public final class ArmorTrimMaterial
extends J_L_Record
implements Copyable,
Rewritable {
    private final String assetName;
    private final int itemId;
    private final float itemModelIndex;
    private final Map<String, String> overrideArmorMaterials;
    private final Tag description;
    public static final HolderType<ArmorTrimMaterial> TYPE1_20_5 = new HolderType<ArmorTrimMaterial>(){

        @Override
        public ArmorTrimMaterial readDirect(ByteBuf buffer) {
            String assetName = (String)Types.STRING.read(buffer);
            int item = Types.VAR_INT.readPrimitive(buffer);
            float itemModelIndex = buffer.readFloat();
            int overrideArmorMaterialsSize = Types.VAR_INT.readPrimitive(buffer);
            Object2ObjectArrayMap<String, String> overrideArmorMaterials = new Object2ObjectArrayMap<String, String>();
            for (int i2 = 0; i2 < overrideArmorMaterialsSize; ++i2) {
                int key = Types.VAR_INT.readPrimitive(buffer);
                String value = (String)Types.STRING.read(buffer);
                overrideArmorMaterials.put(Integer.toString(key), value);
            }
            Tag description = (Tag)Types.TAG.read(buffer);
            return new ArmorTrimMaterial(assetName, item, itemModelIndex, overrideArmorMaterials, description);
        }

        @Override
        public void writeDirect(ByteBuf buffer, ArmorTrimMaterial value) {
            Types.STRING.write(buffer, value.assetName());
            Types.VAR_INT.writePrimitive(buffer, value.itemId());
            buffer.writeFloat(value.itemModelIndex());
            Types.VAR_INT.writePrimitive(buffer, value.overrideArmorMaterials().size());
            for (Map.Entry<String, String> entry : value.overrideArmorMaterials().entrySet()) {
                Types.VAR_INT.writePrimitive(buffer, Integer.parseInt(entry.getKey()));
                Types.STRING.write(buffer, entry.getValue());
            }
            Types.TAG.write(buffer, value.description());
        }
    };
    public static final HolderType<ArmorTrimMaterial> TYPE1_21_2 = new HolderType<ArmorTrimMaterial>(){

        @Override
        public ArmorTrimMaterial readDirect(ByteBuf buffer) {
            String assetName = (String)Types.STRING.read(buffer);
            int item = Types.VAR_INT.readPrimitive(buffer);
            float itemModelIndex = buffer.readFloat();
            int overrideArmorMaterialsSize = Types.VAR_INT.readPrimitive(buffer);
            Object2ObjectArrayMap<String, String> overrideArmorMaterials = new Object2ObjectArrayMap<String, String>();
            for (int i2 = 0; i2 < overrideArmorMaterialsSize; ++i2) {
                String key = (String)Types.STRING.read(buffer);
                String value = (String)Types.STRING.read(buffer);
                overrideArmorMaterials.put(key, value);
            }
            Tag description = (Tag)Types.TAG.read(buffer);
            return new ArmorTrimMaterial(assetName, item, itemModelIndex, overrideArmorMaterials, description);
        }

        @Override
        public void writeDirect(ByteBuf buffer, ArmorTrimMaterial value) {
            Types.STRING.write(buffer, value.assetName());
            Types.VAR_INT.writePrimitive(buffer, value.itemId());
            buffer.writeFloat(value.itemModelIndex());
            Types.VAR_INT.writePrimitive(buffer, value.overrideArmorMaterials().size());
            for (Map.Entry<String, String> entry : value.overrideArmorMaterials().entrySet()) {
                Types.STRING.write(buffer, entry.getKey());
                Types.STRING.write(buffer, entry.getValue());
            }
            Types.TAG.write(buffer, value.description());
        }
    };
    public static final HolderType<ArmorTrimMaterial> TYPE1_21_4 = new HolderType<ArmorTrimMaterial>(){

        @Override
        public ArmorTrimMaterial readDirect(ByteBuf buffer) {
            String assetName = (String)Types.STRING.read(buffer);
            int item = Types.VAR_INT.readPrimitive(buffer);
            int overrideArmorMaterialsSize = Types.VAR_INT.readPrimitive(buffer);
            Object2ObjectArrayMap<String, String> overrideArmorMaterials = new Object2ObjectArrayMap<String, String>();
            for (int i2 = 0; i2 < overrideArmorMaterialsSize; ++i2) {
                String key = (String)Types.STRING.read(buffer);
                String value = (String)Types.STRING.read(buffer);
                overrideArmorMaterials.put(key, value);
            }
            Tag description = (Tag)Types.TAG.read(buffer);
            return new ArmorTrimMaterial(assetName, item, overrideArmorMaterials, description);
        }

        @Override
        public void writeDirect(ByteBuf buffer, ArmorTrimMaterial value) {
            Types.STRING.write(buffer, value.assetName());
            Types.VAR_INT.writePrimitive(buffer, value.itemId());
            Types.VAR_INT.writePrimitive(buffer, value.overrideArmorMaterials().size());
            for (Map.Entry<String, String> entry : value.overrideArmorMaterials().entrySet()) {
                Types.STRING.write(buffer, entry.getKey());
                Types.STRING.write(buffer, entry.getValue());
            }
            Types.TAG.write(buffer, value.description());
        }
    };
    public static final HolderType<ArmorTrimMaterial> TYPE1_21_5 = new HolderType<ArmorTrimMaterial>(){

        @Override
        public ArmorTrimMaterial readDirect(ByteBuf buffer) {
            String assetName = (String)Types.STRING.read(buffer);
            int overrideArmorMaterialsSize = Types.VAR_INT.readPrimitive(buffer);
            Object2ObjectArrayMap<String, String> overrideArmorMaterials = new Object2ObjectArrayMap<String, String>();
            for (int i2 = 0; i2 < overrideArmorMaterialsSize; ++i2) {
                String key = (String)Types.STRING.read(buffer);
                String value = (String)Types.STRING.read(buffer);
                overrideArmorMaterials.put(key, value);
            }
            Tag description = (Tag)Types.TAG.read(buffer);
            return new ArmorTrimMaterial(assetName, overrideArmorMaterials, description);
        }

        @Override
        public void writeDirect(ByteBuf buffer, ArmorTrimMaterial value) {
            Types.STRING.write(buffer, value.assetName());
            Types.VAR_INT.writePrimitive(buffer, value.overrideArmorMaterials().size());
            for (Map.Entry<String, String> entry : value.overrideArmorMaterials().entrySet()) {
                Types.STRING.write(buffer, entry.getKey());
                Types.STRING.write(buffer, entry.getValue());
            }
            Types.TAG.write(buffer, value.description());
        }
    };

    public ArmorTrimMaterial(String assetName, int itemId, Map<String, String> overrideArmorMaterials, Tag description) {
        this(assetName, itemId, 0.0f, overrideArmorMaterials, description);
    }

    public ArmorTrimMaterial(String assetName, Map<String, String> overrideArmorMaterials, Tag description) {
        this(assetName, 0, 0.0f, overrideArmorMaterials, description);
    }

    public ArmorTrimMaterial(String assetName, int itemId, float itemModelIndex, Map<String, String> overrideArmorMaterials, Tag description) {
        this.assetName = assetName;
        this.itemId = itemId;
        this.itemModelIndex = itemModelIndex;
        this.overrideArmorMaterials = overrideArmorMaterials;
        this.description = description;
    }

    @Override
    public ArmorTrimMaterial rewrite(UserConnection connection, Protocol<?, ?, ?, ?> protocol, boolean clientbound) {
        return new ArmorTrimMaterial(this.assetName, Rewritable.rewriteItem(protocol, clientbound, this.itemId), this.itemModelIndex, this.overrideArmorMaterials, this.description);
    }

    @Override
    public ArmorTrimMaterial copy() {
        return new ArmorTrimMaterial(this.assetName, this.itemId, this.itemModelIndex, new Object2ObjectArrayMap<String, String>(this.overrideArmorMaterials), this.description);
    }

    @Override
    public final String toString() {
        return ArmorTrimMaterial.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return ArmorTrimMaterial.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return ArmorTrimMaterial.jvmdowngrader$equals$equals(this, o2);
    }

    public String assetName() {
        return this.assetName;
    }

    public int itemId() {
        return this.itemId;
    }

    public float itemModelIndex() {
        return this.itemModelIndex;
    }

    public Map<String, String> overrideArmorMaterials() {
        return this.overrideArmorMaterials;
    }

    public Tag description() {
        return this.description;
    }

    private static String jvmdowngrader$toString$toString(ArmorTrimMaterial armorTrimMaterial) {
        ArmorTrimMaterial armorTrimMaterial2 = armorTrimMaterial;
        return "ArmorTrimMaterial[" + "assetName=" + armorTrimMaterial.assetName + ", " + "itemId=" + armorTrimMaterial.itemId + ", " + "itemModelIndex=" + armorTrimMaterial.itemModelIndex + ", " + "overrideArmorMaterials=" + armorTrimMaterial.overrideArmorMaterials + ", " + "description=" + armorTrimMaterial.description + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(ArmorTrimMaterial armorTrimMaterial) {
        Object[] objectArray = new Object[]{armorTrimMaterial.assetName, armorTrimMaterial.itemId, Float.valueOf(armorTrimMaterial.itemModelIndex), armorTrimMaterial.overrideArmorMaterials, armorTrimMaterial.description};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(ArmorTrimMaterial armorTrimMaterial, Object object) {
        if (armorTrimMaterial == object) {
            return true;
        }
        if (object != null && object instanceof ArmorTrimMaterial) {
            ArmorTrimMaterial armorTrimMaterial2 = (ArmorTrimMaterial)object;
            if (Objects.equals(armorTrimMaterial.assetName, armorTrimMaterial2.assetName) && armorTrimMaterial.itemId == armorTrimMaterial2.itemId && armorTrimMaterial.itemModelIndex == armorTrimMaterial2.itemModelIndex && Objects.equals(armorTrimMaterial.overrideArmorMaterials, armorTrimMaterial2.overrideArmorMaterials) && Objects.equals(armorTrimMaterial.description, armorTrimMaterial2.description)) {
                return true;
            }
        }
        return false;
    }
}

