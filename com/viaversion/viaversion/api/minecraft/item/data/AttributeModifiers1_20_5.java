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

import ViaVersion.xyz.wagyourtail.jvmdg.j11.stub.java_base.J_U_Collection;
import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import com.viaversion.viaversion.util.Copyable;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="modifiers", type=AttributeModifier[].class), @RecordComponents.Value(name="showInTooltip", type=boolean.class)})
@NestMembers(value={ModifierData.class, ModifierData.1.class, AttributeModifier.class, AttributeModifier.1.class, 1.class})
public final class AttributeModifiers1_20_5
extends J_L_Record
implements Copyable,
Rewritable {
    private final AttributeModifier[] modifiers;
    private final boolean showInTooltip;
    public static final Type<AttributeModifiers1_20_5> TYPE = new Type<AttributeModifiers1_20_5>(AttributeModifiers1_20_5.class){

        @Override
        public AttributeModifiers1_20_5 read(ByteBuf buffer) {
            AttributeModifier[] modifiers = (AttributeModifier[])AttributeModifier.ARRAY_TYPE.read(buffer);
            boolean showInTooltip = buffer.readBoolean();
            return new AttributeModifiers1_20_5(modifiers, showInTooltip);
        }

        @Override
        public void write(ByteBuf buffer, AttributeModifiers1_20_5 value) {
            AttributeModifier.ARRAY_TYPE.write(buffer, value.modifiers());
            buffer.writeBoolean(value.showInTooltip());
        }
    };

    public AttributeModifiers1_20_5(AttributeModifier[] modifiers, boolean showInTooltip) {
        this.modifiers = modifiers;
        this.showInTooltip = showInTooltip;
    }

    @Override
    public AttributeModifiers1_20_5 copy() {
        return new AttributeModifiers1_20_5(Copyable.copy(this.modifiers), this.showInTooltip);
    }

    @Override
    public AttributeModifiers1_20_5 rewrite(UserConnection connection, Protocol<?, ?, ?, ?> protocol, boolean clientbound) {
        FullMappings mappings = protocol.getMappingData().getAttributeMappings();
        if (mappings == null) {
            return this;
        }
        ArrayList<AttributeModifier> modifiers = new ArrayList<AttributeModifier>(this.modifiers.length);
        for (AttributeModifier modifier : this.modifiers) {
            int mappedId;
            int n2 = mappedId = clientbound ? mappings.getNewId(modifier.attribute()) : mappings.inverse().getNewId(modifier.attribute());
            if (mappedId == -1) continue;
            modifiers.add(new AttributeModifier(mappedId, modifier.modifier(), modifier.slotType()));
        }
        return new AttributeModifiers1_20_5((AttributeModifier[])J_U_Collection.toArray(modifiers, AttributeModifier[]::new), this.showInTooltip);
    }

    @Override
    public final String toString() {
        return AttributeModifiers1_20_5.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return AttributeModifiers1_20_5.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return AttributeModifiers1_20_5.jvmdowngrader$equals$equals(this, o2);
    }

    public AttributeModifier[] modifiers() {
        return this.modifiers;
    }

    public boolean showInTooltip() {
        return this.showInTooltip;
    }

    private static String jvmdowngrader$toString$toString(AttributeModifiers1_20_5 attributeModifiers1_20_5) {
        AttributeModifiers1_20_5 attributeModifiers1_20_52 = attributeModifiers1_20_5;
        return "AttributeModifiers1_20_5[" + "modifiers=" + attributeModifiers1_20_5.modifiers + ", " + "showInTooltip=" + attributeModifiers1_20_5.showInTooltip + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(AttributeModifiers1_20_5 attributeModifiers1_20_5) {
        Object[] objectArray = new Object[]{attributeModifiers1_20_5.modifiers, attributeModifiers1_20_5.showInTooltip};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(AttributeModifiers1_20_5 attributeModifiers1_20_5, Object object) {
        if (attributeModifiers1_20_5 == object) {
            return true;
        }
        if (object != null && object instanceof AttributeModifiers1_20_5) {
            AttributeModifiers1_20_5 attributeModifiers1_20_52 = (AttributeModifiers1_20_5)object;
            if (Objects.equals(attributeModifiers1_20_5.modifiers, attributeModifiers1_20_52.modifiers) && attributeModifiers1_20_5.showInTooltip == attributeModifiers1_20_52.showInTooltip) {
                return true;
            }
        }
        return false;
    }

    @RecordComponents(value={@RecordComponents.Value(name="attribute", type=int.class), @RecordComponents.Value(name="modifier", type=ModifierData.class), @RecordComponents.Value(name="slotType", type=int.class)})
    @NestHost(value=AttributeModifiers1_20_5.class)
    public static final class AttributeModifier
    extends J_L_Record {
        private final int attribute;
        private final ModifierData modifier;
        private final int slotType;
        public static final Type<AttributeModifier> TYPE = new Type<AttributeModifier>(AttributeModifier.class){

            @Override
            public AttributeModifier read(ByteBuf buffer) {
                int attribute = Types.VAR_INT.readPrimitive(buffer);
                ModifierData modifier = (ModifierData)ModifierData.TYPE.read(buffer);
                int slot = Types.VAR_INT.readPrimitive(buffer);
                return new AttributeModifier(attribute, modifier, slot);
            }

            @Override
            public void write(ByteBuf buffer, AttributeModifier value) {
                Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_20_5$AttributeModifier$get$attribute());
                ModifierData.TYPE.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_20_5$AttributeModifier$get$modifier());
                Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_20_5$AttributeModifier$get$slotType());
            }
        };
        public static final Type<AttributeModifier[]> ARRAY_TYPE = new ArrayType<AttributeModifier>(TYPE);

        public AttributeModifier(int attribute, ModifierData modifier, int slotType) {
            this.attribute = attribute;
            this.modifier = modifier;
            this.slotType = slotType;
        }

        @Override
        public final String toString() {
            return AttributeModifier.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return AttributeModifier.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return AttributeModifier.jvmdowngrader$equals$equals(this, o2);
        }

        public int attribute() {
            return this.attribute;
        }

        public ModifierData modifier() {
            return this.modifier;
        }

        public int slotType() {
            return this.slotType;
        }

        private static String jvmdowngrader$toString$toString(AttributeModifier attributeModifier) {
            AttributeModifier attributeModifier2 = attributeModifier;
            return "AttributeModifiers1_20_5$AttributeModifier[" + "attribute=" + attributeModifier.attribute + ", " + "modifier=" + attributeModifier.modifier + ", " + "slotType=" + attributeModifier.slotType + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(AttributeModifier attributeModifier) {
            Object[] objectArray = new Object[]{attributeModifier.attribute, attributeModifier.modifier, attributeModifier.slotType};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(AttributeModifier attributeModifier, Object object) {
            if (attributeModifier == object) {
                return true;
            }
            if (object != null && object instanceof AttributeModifier) {
                AttributeModifier attributeModifier2 = (AttributeModifier)object;
                if (attributeModifier.attribute == attributeModifier2.attribute && Objects.equals(attributeModifier.modifier, attributeModifier2.modifier) && attributeModifier.slotType == attributeModifier2.slotType) {
                    return true;
                }
            }
            return false;
        }

        public int jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_20_5$AttributeModifier$get$slotType() {
            return this.slotType;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_20_5$AttributeModifier$set$slotType(int n2) {
            this.slotType = n2;
        }

        public ModifierData jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_20_5$AttributeModifier$get$modifier() {
            return this.modifier;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_20_5$AttributeModifier$set$modifier(ModifierData modifierData) {
            this.modifier = modifierData;
        }

        public int jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_20_5$AttributeModifier$get$attribute() {
            return this.attribute;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_20_5$AttributeModifier$set$attribute(int n2) {
            this.attribute = n2;
        }
    }

    @RecordComponents(value={@RecordComponents.Value(name="uuid", type=UUID.class), @RecordComponents.Value(name="name", type=String.class), @RecordComponents.Value(name="amount", type=double.class), @RecordComponents.Value(name="operation", type=int.class)})
    @NestHost(value=AttributeModifiers1_20_5.class)
    public static final class ModifierData
    extends J_L_Record {
        private final UUID uuid;
        private final String name;
        private final double amount;
        private final int operation;
        public static final Type<ModifierData> TYPE = new Type<ModifierData>(ModifierData.class){

            @Override
            public ModifierData read(ByteBuf buffer) {
                UUID uuid = (UUID)Types.UUID.read(buffer);
                String name = (String)Types.STRING.read(buffer);
                double amount = buffer.readDouble();
                int operation = Types.VAR_INT.readPrimitive(buffer);
                return new ModifierData(uuid, name, amount, operation);
            }

            @Override
            public void write(ByteBuf buffer, ModifierData value) {
                Types.UUID.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_20_5$ModifierData$get$uuid());
                Types.STRING.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_20_5$ModifierData$get$name());
                buffer.writeDouble(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_20_5$ModifierData$get$amount());
                Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_20_5$ModifierData$get$operation());
            }
        };

        public ModifierData(UUID uuid, String name, double amount, int operation) {
            this.uuid = uuid;
            this.name = name;
            this.amount = amount;
            this.operation = operation;
        }

        @Override
        public final String toString() {
            return ModifierData.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return ModifierData.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return ModifierData.jvmdowngrader$equals$equals(this, o2);
        }

        public UUID uuid() {
            return this.uuid;
        }

        public String name() {
            return this.name;
        }

        public double amount() {
            return this.amount;
        }

        public int operation() {
            return this.operation;
        }

        private static String jvmdowngrader$toString$toString(ModifierData modifierData) {
            ModifierData modifierData2 = modifierData;
            return "AttributeModifiers1_20_5$ModifierData[" + "uuid=" + modifierData.uuid + ", " + "name=" + modifierData.name + ", " + "amount=" + modifierData.amount + ", " + "operation=" + modifierData.operation + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(ModifierData modifierData) {
            Object[] objectArray = new Object[]{modifierData.uuid, modifierData.name, modifierData.amount, modifierData.operation};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(ModifierData modifierData, Object object) {
            if (modifierData == object) {
                return true;
            }
            if (object != null && object instanceof ModifierData) {
                ModifierData modifierData2 = (ModifierData)object;
                if (Objects.equals(modifierData.uuid, modifierData2.uuid) && Objects.equals(modifierData.name, modifierData2.name) && modifierData.amount == modifierData2.amount && modifierData.operation == modifierData2.operation) {
                    return true;
                }
            }
            return false;
        }

        public String jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_20_5$ModifierData$get$name() {
            return this.name;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_20_5$ModifierData$set$name(String string) {
            this.name = string;
        }

        public double jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_20_5$ModifierData$get$amount() {
            return this.amount;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_20_5$ModifierData$set$amount(double d2) {
            this.amount = d2;
        }

        public UUID jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_20_5$ModifierData$get$uuid() {
            return this.uuid;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_20_5$ModifierData$set$uuid(UUID uUID) {
            this.uuid = uUID;
        }

        public int jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_20_5$ModifierData$get$operation() {
            return this.operation;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_20_5$ModifierData$set$operation(int n2) {
            this.operation = n2;
        }
    }
}

