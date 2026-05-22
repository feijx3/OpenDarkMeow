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
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="type", type=String.class), @RecordComponents.Value(name="x", type=double.class), @RecordComponents.Value(name="z", type=double.class), @RecordComponents.Value(name="rotation", type=float.class)})
@NestMembers(value={1.class})
public final class MapDecoration
extends J_L_Record {
    private final String type;
    private final double x;
    private final double z;
    private final float rotation;
    public static final Type<MapDecoration> TYPE = new Type<MapDecoration>(MapDecoration.class){

        @Override
        public MapDecoration read(ByteBuf buffer) {
            String type = (String)Types.STRING.read(buffer);
            double x2 = Types.DOUBLE.readPrimitive(buffer);
            double z2 = Types.DOUBLE.readPrimitive(buffer);
            float rotation = Types.FLOAT.readPrimitive(buffer);
            return new MapDecoration(type, x2, z2, rotation);
        }

        @Override
        public void write(ByteBuf buffer, MapDecoration value) {
            Types.STRING.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_MapDecoration$get$type());
            buffer.writeDouble(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_MapDecoration$get$x());
            buffer.writeDouble(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_MapDecoration$get$z());
            buffer.writeFloat(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_MapDecoration$get$rotation());
        }
    };

    public MapDecoration(String type, double x2, double z2, float rotation) {
        this.type = type;
        this.x = x2;
        this.z = z2;
        this.rotation = rotation;
    }

    @Override
    public final String toString() {
        return MapDecoration.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return MapDecoration.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return MapDecoration.jvmdowngrader$equals$equals(this, o2);
    }

    public String type() {
        return this.type;
    }

    public double x() {
        return this.x;
    }

    public double z() {
        return this.z;
    }

    public float rotation() {
        return this.rotation;
    }

    private static String jvmdowngrader$toString$toString(MapDecoration mapDecoration) {
        MapDecoration mapDecoration2 = mapDecoration;
        return "MapDecoration[" + "type=" + mapDecoration.type + ", " + "x=" + mapDecoration.x + ", " + "z=" + mapDecoration.z + ", " + "rotation=" + mapDecoration.rotation + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(MapDecoration mapDecoration) {
        Object[] objectArray = new Object[]{mapDecoration.type, mapDecoration.x, mapDecoration.z, Float.valueOf(mapDecoration.rotation)};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(MapDecoration mapDecoration, Object object) {
        if (mapDecoration == object) {
            return true;
        }
        if (object != null && object instanceof MapDecoration) {
            MapDecoration mapDecoration2 = (MapDecoration)object;
            if (Objects.equals(mapDecoration.type, mapDecoration2.type) && mapDecoration.x == mapDecoration2.x && mapDecoration.z == mapDecoration2.z && mapDecoration.rotation == mapDecoration2.rotation) {
                return true;
            }
        }
        return false;
    }

    public double jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_MapDecoration$get$x() {
        return this.x;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_MapDecoration$set$x(double d2) {
        this.x = d2;
    }

    public double jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_MapDecoration$get$z() {
        return this.z;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_MapDecoration$set$z(double d2) {
        this.z = d2;
    }

    public String jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_MapDecoration$get$type() {
        return this.type;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_MapDecoration$set$type(String string) {
        this.type = string;
    }

    public float jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_MapDecoration$get$rotation() {
        return this.rotation;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_MapDecoration$set$rotation(float f2) {
        this.rotation = f2;
    }
}

