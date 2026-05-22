/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.minecraft.item.data.EnumTypes;
import com.viaversion.viaversion.api.minecraft.item.data.PotionEffect;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.Copyable;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="potion", type=Integer.class), @RecordComponents.Value(name="customColor", type=Integer.class), @RecordComponents.Value(name="customEffects", type=PotionEffect[].class), @RecordComponents.Value(name="customName", type=String.class)})
@NestMembers(value={2.class, 1.class})
public final class PotionContents
extends J_L_Record
implements Copyable {
    private final @Nullable Integer potion;
    private final @Nullable Integer customColor;
    private final PotionEffect[] customEffects;
    private final @Nullable String customName;
    public static final Type<PotionContents> TYPE1_20_5 = new Type<PotionContents>(PotionContents.class){

        @Override
        public PotionContents read(ByteBuf buffer) {
            Integer potion = buffer.readBoolean() ? Integer.valueOf(Types.VAR_INT.readPrimitive(buffer)) : null;
            Integer customColor = buffer.readBoolean() ? Integer.valueOf(buffer.readInt()) : null;
            PotionEffect[] customEffects = (PotionEffect[])PotionEffect.ARRAY_TYPE.read(buffer);
            return new PotionContents(potion, customColor, customEffects, null);
        }

        @Override
        public void write(ByteBuf buffer, PotionContents value) {
            buffer.writeBoolean(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionContents$get$potion() != null);
            if (value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionContents$get$potion() != null) {
                Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionContents$get$potion());
            }
            buffer.writeBoolean(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionContents$get$customColor() != null);
            if (value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionContents$get$customColor() != null) {
                buffer.writeInt(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionContents$get$customColor().intValue());
            }
            PotionEffect.ARRAY_TYPE.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionContents$get$customEffects());
        }
    };
    public static final Type<PotionContents> TYPE1_21_2 = new Type<PotionContents>(PotionContents.class){

        @Override
        public PotionContents read(ByteBuf buffer) {
            Integer potion = buffer.readBoolean() ? Integer.valueOf(Types.VAR_INT.readPrimitive(buffer)) : null;
            Integer customColor = buffer.readBoolean() ? Integer.valueOf(buffer.readInt()) : null;
            PotionEffect[] customEffects = (PotionEffect[])PotionEffect.ARRAY_TYPE.read(buffer);
            String customName = (String)Types.OPTIONAL_STRING.read(buffer);
            return new PotionContents(potion, customColor, customEffects, customName);
        }

        @Override
        public void write(ByteBuf buffer, PotionContents value) {
            buffer.writeBoolean(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionContents$get$potion() != null);
            if (value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionContents$get$potion() != null) {
                Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionContents$get$potion());
            }
            buffer.writeBoolean(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionContents$get$customColor() != null);
            if (value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionContents$get$customColor() != null) {
                buffer.writeInt(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionContents$get$customColor().intValue());
            }
            PotionEffect.ARRAY_TYPE.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionContents$get$customEffects());
            Types.OPTIONAL_STRING.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionContents$get$customName());
        }

        @Override
        public void write(Ops ops, PotionContents value) {
            ops.writeMap(map -> map.writeOptional("potion", EnumTypes.POTION, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionContents$get$potion()).writeOptional("custom_color", Types.INT, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionContents$get$customColor()).writeOptional("custom_effects", PotionEffect.ARRAY_TYPE, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionContents$get$customEffects(), new PotionEffect[0]).writeOptional("custom_name", Types.STRING, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionContents$get$customName()));
        }
    };

    public PotionContents(@Nullable Integer potion, @Nullable Integer customColor, PotionEffect[] customEffects) {
        this(potion, customColor, customEffects, null);
    }

    public PotionContents(@Nullable Integer potion, @Nullable Integer customColor, PotionEffect[] customEffects, @Nullable String customName) {
        this.potion = potion;
        this.customColor = customColor;
        this.customEffects = customEffects;
        this.customName = customName;
    }

    @Override
    public PotionContents copy() {
        return new PotionContents(this.potion, this.customColor, Copyable.copy(this.customEffects), this.customName);
    }

    @Override
    public final String toString() {
        return PotionContents.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return PotionContents.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return PotionContents.jvmdowngrader$equals$equals(this, o2);
    }

    public @Nullable Integer potion() {
        return this.potion;
    }

    public @Nullable Integer customColor() {
        return this.customColor;
    }

    public PotionEffect[] customEffects() {
        return this.customEffects;
    }

    public @Nullable String customName() {
        return this.customName;
    }

    private static String jvmdowngrader$toString$toString(PotionContents potionContents) {
        PotionContents potionContents2 = potionContents;
        return "PotionContents[" + "potion=" + potionContents.potion + ", " + "customColor=" + potionContents.customColor + ", " + "customEffects=" + potionContents.customEffects + ", " + "customName=" + potionContents.customName + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(PotionContents potionContents) {
        Object[] objectArray = new Object[]{potionContents.potion, potionContents.customColor, potionContents.customEffects, potionContents.customName};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(PotionContents potionContents, Object object) {
        if (potionContents == object) {
            return true;
        }
        if (object != null && object instanceof PotionContents) {
            PotionContents potionContents2 = (PotionContents)object;
            if (Objects.equals(potionContents.potion, potionContents2.potion) && Objects.equals(potionContents.customColor, potionContents2.customColor) && Objects.equals(potionContents.customEffects, potionContents2.customEffects) && Objects.equals(potionContents.customName, potionContents2.customName)) {
                return true;
            }
        }
        return false;
    }

    public Integer jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionContents$get$potion() {
        return this.potion;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionContents$set$potion(Integer n2) {
        this.potion = n2;
    }

    public Integer jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionContents$get$customColor() {
        return this.customColor;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionContents$set$customColor(Integer n2) {
        this.customColor = n2;
    }

    public String jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionContents$get$customName() {
        return this.customName;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionContents$set$customName(String string) {
        this.customName = string;
    }

    public PotionEffect[] jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionContents$get$customEffects() {
        return this.customEffects;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_PotionContents$set$customEffects(PotionEffect[] potionEffectArray) {
        this.customEffects = potionEffectArray;
    }
}

