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
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.item.data.ArmorTrimMaterial;
import com.viaversion.viaversion.api.minecraft.item.data.ArmorTrimPattern;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="material", type=Holder.class), @RecordComponents.Value(name="pattern", type=Holder.class), @RecordComponents.Value(name="showInTooltip", type=boolean.class)})
@NestMembers(value={4.class, 3.class, 2.class, 1.class})
public final class ArmorTrim
extends J_L_Record
implements Rewritable {
    private final Holder<ArmorTrimMaterial> material;
    private final Holder<ArmorTrimPattern> pattern;
    private final boolean showInTooltip;
    public static final Type<ArmorTrim> TYPE1_20_5 = new Type<ArmorTrim>(ArmorTrim.class){

        @Override
        public ArmorTrim read(ByteBuf buffer) {
            Object material = ArmorTrimMaterial.TYPE1_20_5.read(buffer);
            Object pattern = ArmorTrimPattern.TYPE1_20_5.read(buffer);
            boolean showInTooltip = buffer.readBoolean();
            return new ArmorTrim((Holder<ArmorTrimMaterial>)material, (Holder<ArmorTrimPattern>)pattern, showInTooltip);
        }

        @Override
        public void write(ByteBuf buffer, ArmorTrim value) {
            ArmorTrimMaterial.TYPE1_20_5.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_ArmorTrim$get$material());
            ArmorTrimPattern.TYPE1_20_5.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_ArmorTrim$get$pattern());
            buffer.writeBoolean(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_ArmorTrim$get$showInTooltip());
        }
    };
    public static final Type<ArmorTrim> TYPE1_21_2 = new Type<ArmorTrim>(ArmorTrim.class){

        @Override
        public ArmorTrim read(ByteBuf buffer) {
            Object material = ArmorTrimMaterial.TYPE1_21_2.read(buffer);
            Object pattern = ArmorTrimPattern.TYPE1_20_5.read(buffer);
            boolean showInTooltip = buffer.readBoolean();
            return new ArmorTrim((Holder<ArmorTrimMaterial>)material, (Holder<ArmorTrimPattern>)pattern, showInTooltip);
        }

        @Override
        public void write(ByteBuf buffer, ArmorTrim value) {
            ArmorTrimMaterial.TYPE1_21_2.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_ArmorTrim$get$material());
            ArmorTrimPattern.TYPE1_20_5.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_ArmorTrim$get$pattern());
            buffer.writeBoolean(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_ArmorTrim$get$showInTooltip());
        }
    };
    public static final Type<ArmorTrim> TYPE1_21_4 = new Type<ArmorTrim>(ArmorTrim.class){

        @Override
        public ArmorTrim read(ByteBuf buffer) {
            Object material = ArmorTrimMaterial.TYPE1_21_4.read(buffer);
            Object pattern = ArmorTrimPattern.TYPE1_20_5.read(buffer);
            boolean showInTooltip = buffer.readBoolean();
            return new ArmorTrim((Holder<ArmorTrimMaterial>)material, (Holder<ArmorTrimPattern>)pattern, showInTooltip);
        }

        @Override
        public void write(ByteBuf buffer, ArmorTrim value) {
            ArmorTrimMaterial.TYPE1_21_4.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_ArmorTrim$get$material());
            ArmorTrimPattern.TYPE1_20_5.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_ArmorTrim$get$pattern());
            buffer.writeBoolean(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_ArmorTrim$get$showInTooltip());
        }
    };
    public static final Type<ArmorTrim> TYPE1_21_5 = new Type<ArmorTrim>(ArmorTrim.class){

        @Override
        public ArmorTrim read(ByteBuf buffer) {
            Object material = ArmorTrimMaterial.TYPE1_21_5.read(buffer);
            Object pattern = ArmorTrimPattern.TYPE1_21_5.read(buffer);
            return new ArmorTrim((Holder<ArmorTrimMaterial>)material, (Holder<ArmorTrimPattern>)pattern);
        }

        @Override
        public void write(ByteBuf buffer, ArmorTrim value) {
            ArmorTrimMaterial.TYPE1_21_5.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_ArmorTrim$get$material());
            ArmorTrimPattern.TYPE1_21_5.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_ArmorTrim$get$pattern());
        }
    };

    public ArmorTrim(Holder<ArmorTrimMaterial> material, Holder<ArmorTrimPattern> pattern) {
        this(material, pattern, true);
    }

    public ArmorTrim(Holder<ArmorTrimMaterial> material, Holder<ArmorTrimPattern> pattern, boolean showInTooltip) {
        this.material = material;
        this.pattern = pattern;
        this.showInTooltip = showInTooltip;
    }

    @Override
    public ArmorTrim rewrite(UserConnection connection, Protocol<?, ?, ?, ?> protocol, boolean clientbound) {
        Holder<Object> pattern;
        Holder<Object> material = this.material;
        if (material.isDirect()) {
            material = Holder.of(material.value().rewrite(connection, (Protocol)protocol, clientbound));
        }
        if ((pattern = this.pattern).isDirect()) {
            pattern = Holder.of(pattern.value().rewrite(connection, (Protocol)protocol, clientbound));
        }
        return new ArmorTrim(material, pattern, this.showInTooltip);
    }

    @Override
    public final String toString() {
        return ArmorTrim.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return ArmorTrim.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return ArmorTrim.jvmdowngrader$equals$equals(this, o2);
    }

    public Holder<ArmorTrimMaterial> material() {
        return this.material;
    }

    public Holder<ArmorTrimPattern> pattern() {
        return this.pattern;
    }

    public boolean showInTooltip() {
        return this.showInTooltip;
    }

    private static String jvmdowngrader$toString$toString(ArmorTrim armorTrim) {
        ArmorTrim armorTrim2 = armorTrim;
        return "ArmorTrim[" + "material=" + armorTrim.material + ", " + "pattern=" + armorTrim.pattern + ", " + "showInTooltip=" + armorTrim.showInTooltip + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(ArmorTrim armorTrim) {
        Object[] objectArray = new Object[]{armorTrim.material, armorTrim.pattern, armorTrim.showInTooltip};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(ArmorTrim armorTrim, Object object) {
        if (armorTrim == object) {
            return true;
        }
        if (object != null && object instanceof ArmorTrim) {
            ArmorTrim armorTrim2 = (ArmorTrim)object;
            if (Objects.equals(armorTrim.material, armorTrim2.material) && Objects.equals(armorTrim.pattern, armorTrim2.pattern) && armorTrim.showInTooltip == armorTrim2.showInTooltip) {
                return true;
            }
        }
        return false;
    }

    public Holder jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_ArmorTrim$get$material() {
        return this.material;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_ArmorTrim$set$material(Holder holder) {
        this.material = holder;
    }

    public Holder jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_ArmorTrim$get$pattern() {
        return this.pattern;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_ArmorTrim$set$pattern(Holder holder) {
        this.pattern = holder;
    }

    public boolean jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_ArmorTrim$get$showInTooltip() {
        return this.showInTooltip;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_ArmorTrim$set$showInTooltip(boolean bl2) {
        this.showInTooltip = bl2;
    }
}

