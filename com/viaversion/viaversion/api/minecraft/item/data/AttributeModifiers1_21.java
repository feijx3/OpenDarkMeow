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
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntFunction;
import com.viaversion.viaversion.util.Copyable;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="modifiers", type=AttributeModifier[].class), @RecordComponents.Value(name="showInTooltip", type=boolean.class)})
@NestMembers(value={OverrideText.class, Display.class, ModifierData.class, ModifierData.1.class, AttributeModifier.class, AttributeModifier.2.class, AttributeModifier.1.class, 3.class, 2.class, 1.class})
public final class AttributeModifiers1_21
extends J_L_Record
implements Copyable,
Rewritable {
    private final AttributeModifier[] modifiers;
    private final boolean showInTooltip;
    public static final Type<AttributeModifiers1_21> TYPE1_21 = new Type<AttributeModifiers1_21>(AttributeModifiers1_21.class){

        @Override
        public AttributeModifiers1_21 read(ByteBuf buffer) {
            AttributeModifier[] modifiers = (AttributeModifier[])AttributeModifier.ARRAY_TYPE1_21.read(buffer);
            boolean showInTooltip = buffer.readBoolean();
            return new AttributeModifiers1_21(modifiers, showInTooltip);
        }

        @Override
        public void write(ByteBuf buffer, AttributeModifiers1_21 value) {
            AttributeModifier.ARRAY_TYPE1_21.write(buffer, value.modifiers());
            buffer.writeBoolean(value.showInTooltip());
        }
    };
    public static final Type<AttributeModifiers1_21> TYPE1_21_5 = new Type<AttributeModifiers1_21>(AttributeModifiers1_21.class){

        @Override
        public AttributeModifiers1_21 read(ByteBuf buffer) {
            AttributeModifier[] modifiers = (AttributeModifier[])AttributeModifier.ARRAY_TYPE1_21.read(buffer);
            return new AttributeModifiers1_21(modifiers);
        }

        @Override
        public void write(ByteBuf buffer, AttributeModifiers1_21 value) {
            AttributeModifier.ARRAY_TYPE1_21.write(buffer, value.modifiers());
        }

        @Override
        public void write(Ops ops, AttributeModifiers1_21 value) {
            ops.write(AttributeModifier.ARRAY_TYPE1_21, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$get$modifiers());
        }
    };
    public static final Type<AttributeModifiers1_21> TYPE1_21_6 = new Type<AttributeModifiers1_21>(AttributeModifiers1_21.class){

        @Override
        public AttributeModifiers1_21 read(ByteBuf buffer) {
            AttributeModifier[] modifiers = (AttributeModifier[])AttributeModifier.ARRAY_TYPE1_21_6.read(buffer);
            return new AttributeModifiers1_21(modifiers);
        }

        @Override
        public void write(ByteBuf buffer, AttributeModifiers1_21 value) {
            AttributeModifier.ARRAY_TYPE1_21_6.write(buffer, value.modifiers());
        }

        @Override
        public void write(Ops ops, AttributeModifiers1_21 value) {
            ops.write(AttributeModifier.ARRAY_TYPE1_21_6, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$get$modifiers());
        }
    };

    public AttributeModifiers1_21(AttributeModifier[] modifiers) {
        this(modifiers, true);
    }

    public AttributeModifiers1_21(AttributeModifier[] modifiers, boolean showInTooltip) {
        this.modifiers = modifiers;
        this.showInTooltip = showInTooltip;
    }

    public AttributeModifiers1_21 rewrite(Int2IntFunction rewriteFunction) {
        AttributeModifier[] modifiers = new AttributeModifier[this.modifiers.length];
        for (int i2 = 0; i2 < this.modifiers.length; ++i2) {
            AttributeModifier modifier = this.modifiers[i2];
            modifiers[i2] = new AttributeModifier(rewriteFunction.applyAsInt(modifier.attribute()), modifier.modifier(), modifier.slotType(), modifier.display());
        }
        return new AttributeModifiers1_21(modifiers, this.showInTooltip);
    }

    @Override
    public AttributeModifiers1_21 copy() {
        return new AttributeModifiers1_21(Copyable.copy(this.modifiers), this.showInTooltip);
    }

    @Override
    public AttributeModifiers1_21 rewrite(UserConnection connection, Protocol<?, ?, ?, ?> protocol, boolean clientbound) {
        FullMappings mappings = protocol.getMappingData().getAttributeMappings();
        if (mappings == null) {
            return this;
        }
        ArrayList<AttributeModifier> modifiers = new ArrayList<AttributeModifier>(this.modifiers.length);
        for (AttributeModifier modifier : this.modifiers) {
            int mappedId;
            int n2 = mappedId = clientbound ? mappings.getNewId(modifier.attribute()) : mappings.inverse().getNewId(modifier.attribute());
            if (mappedId == -1) continue;
            modifiers.add(new AttributeModifier(mappedId, modifier.modifier(), modifier.slotType(), modifier.display()));
        }
        return new AttributeModifiers1_21((AttributeModifier[])J_U_Collection.toArray(modifiers, AttributeModifier[]::new), this.showInTooltip);
    }

    @Override
    public final String toString() {
        return AttributeModifiers1_21.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return AttributeModifiers1_21.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return AttributeModifiers1_21.jvmdowngrader$equals$equals(this, o2);
    }

    public AttributeModifier[] modifiers() {
        return this.modifiers;
    }

    public boolean showInTooltip() {
        return this.showInTooltip;
    }

    private static String jvmdowngrader$toString$toString(AttributeModifiers1_21 attributeModifiers1_21) {
        AttributeModifiers1_21 attributeModifiers1_212 = attributeModifiers1_21;
        return "AttributeModifiers1_21[" + "modifiers=" + attributeModifiers1_21.modifiers + ", " + "showInTooltip=" + attributeModifiers1_21.showInTooltip + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(AttributeModifiers1_21 attributeModifiers1_21) {
        Object[] objectArray = new Object[]{attributeModifiers1_21.modifiers, attributeModifiers1_21.showInTooltip};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(AttributeModifiers1_21 attributeModifiers1_21, Object object) {
        if (attributeModifiers1_21 == object) {
            return true;
        }
        if (object != null && object instanceof AttributeModifiers1_21) {
            AttributeModifiers1_21 attributeModifiers1_212 = (AttributeModifiers1_21)object;
            if (Objects.equals(attributeModifiers1_21.modifiers, attributeModifiers1_212.modifiers) && attributeModifiers1_21.showInTooltip == attributeModifiers1_212.showInTooltip) {
                return true;
            }
        }
        return false;
    }

    public AttributeModifier[] jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$get$modifiers() {
        return this.modifiers;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$set$modifiers(AttributeModifier[] attributeModifierArray) {
        this.modifiers = attributeModifierArray;
    }

    @RecordComponents(value={@RecordComponents.Value(name="attribute", type=int.class), @RecordComponents.Value(name="modifier", type=ModifierData.class), @RecordComponents.Value(name="slotType", type=int.class), @RecordComponents.Value(name="display", type=Display.class)})
    @NestHost(value=AttributeModifiers1_21.class)
    public static final class AttributeModifier
    extends J_L_Record {
        private final int attribute;
        private final ModifierData modifier;
        private final int slotType;
        private final Display display;
        private static final String[] EQUIPMENT_SLOT_GROUPS = new String[]{"any", "mainhand", "offhand", "hand", "feet", "legs", "chest", "head", "armor", "body", "saddle"};
        private static final String[] OPERATION = new String[]{"add_value", "add_multiplied_base", "add_multiplied_total"};
        public static final Type<AttributeModifier> TYPE1_21 = new Type<AttributeModifier>(AttributeModifier.class){

            @Override
            public AttributeModifier read(ByteBuf buffer) {
                int attribute = Types.VAR_INT.readPrimitive(buffer);
                ModifierData modifier = (ModifierData)ModifierData.TYPE.read(buffer);
                int slot = Types.VAR_INT.readPrimitive(buffer);
                return new AttributeModifier(attribute, modifier, slot);
            }

            @Override
            public void write(ByteBuf buffer, AttributeModifier value) {
                Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$get$attribute());
                ModifierData.TYPE.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$get$modifier());
                Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$get$slotType());
            }

            @Override
            public void write(Ops ops, AttributeModifier value) {
                Key attribute = ops.context().registryAccess().attributeModifier(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$get$attribute());
                ops.writeMap(map -> map.write("type", Types.RESOURCE_LOCATION, attribute).write("id", Types.RESOURCE_LOCATION, Key.of(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$get$modifier().id())).write("amount", Types.DOUBLE, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$get$modifier().jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$ModifierData$get$amount()).write("operation", Types.STRING, AttributeModifier.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$get$OPERATION()[value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$get$modifier().operation()]).writeOptional("slot", Types.STRING, AttributeModifier.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$get$EQUIPMENT_SLOT_GROUPS()[value.slotType()], "any"));
            }
        };
        public static final Type<AttributeModifier[]> ARRAY_TYPE1_21 = new ArrayType<AttributeModifier>(TYPE1_21);
        public static final Type<AttributeModifier> TYPE1_21_6 = new Type<AttributeModifier>(AttributeModifier.class){

            @Override
            public AttributeModifier read(ByteBuf buffer) {
                int attribute = Types.VAR_INT.readPrimitive(buffer);
                ModifierData modifier = (ModifierData)ModifierData.TYPE.read(buffer);
                int slot = Types.VAR_INT.readPrimitive(buffer);
                int displayType = Types.VAR_INT.readPrimitive(buffer);
                Display display = displayType == 2 ? new OverrideText((Tag)Types.TAG.read(buffer)) : new Display(displayType);
                return new AttributeModifier(attribute, modifier, slot, display);
            }

            @Override
            public void write(ByteBuf buffer, AttributeModifier value) {
                Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$get$attribute());
                ModifierData.TYPE.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$get$modifier());
                Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$get$slotType());
                value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$get$display().write(buffer);
            }

            @Override
            public void write(Ops ops, AttributeModifier value) {
                Key attribute = ops.context().registryAccess().attributeModifier(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$get$attribute());
                ops.writeMap(map -> {
                    map.write("type", Types.RESOURCE_LOCATION, attribute).write("id", Types.RESOURCE_LOCATION, Key.of(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$get$modifier().id())).write("amount", Types.DOUBLE, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$get$modifier().jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$ModifierData$get$amount()).write("operation", Types.STRING, AttributeModifier.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$get$OPERATION()[value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$get$modifier().operation()]).writeOptional("slot", Types.STRING, AttributeModifier.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$get$EQUIPMENT_SLOT_GROUPS()[value.slotType()], "any");
                    if (value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$get$display().equals(Display.DEFAULT)) {
                        return;
                    }
                    map.writeMap("display", display -> {
                        display.write("type", Types.STRING, Display.DISPLAY_TYPES[value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$get$display().id()]);
                        Display patt10310$temp = value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$get$display();
                        if (patt10310$temp instanceof OverrideText) {
                            OverrideText overrideText = (OverrideText)patt10310$temp;
                            display.write("value", Types.TEXT_COMPONENT_TAG, overrideText.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$OverrideText$get$component());
                        }
                    });
                });
            }
        };
        public static final Type<AttributeModifier[]> ARRAY_TYPE1_21_6 = new ArrayType<AttributeModifier>(TYPE1_21_6);

        public AttributeModifier(int attribute, ModifierData modifier, int slotType) {
            this(attribute, modifier, slotType, Display.DEFAULT);
        }

        public AttributeModifier(int attribute, ModifierData modifier, int slotType, Display display) {
            this.attribute = attribute;
            this.modifier = modifier;
            this.slotType = slotType;
            this.display = display;
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

        public Display display() {
            return this.display;
        }

        private static String jvmdowngrader$toString$toString(AttributeModifier attributeModifier) {
            AttributeModifier attributeModifier2 = attributeModifier;
            return "AttributeModifiers1_21$AttributeModifier[" + "attribute=" + attributeModifier.attribute + ", " + "modifier=" + attributeModifier.modifier + ", " + "slotType=" + attributeModifier.slotType + ", " + "display=" + attributeModifier.display + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(AttributeModifier attributeModifier) {
            Object[] objectArray = new Object[]{attributeModifier.attribute, attributeModifier.modifier, attributeModifier.slotType, attributeModifier.display};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(AttributeModifier attributeModifier, Object object) {
            if (attributeModifier == object) {
                return true;
            }
            if (object != null && object instanceof AttributeModifier) {
                AttributeModifier attributeModifier2 = (AttributeModifier)object;
                if (attributeModifier.attribute == attributeModifier2.attribute && Objects.equals(attributeModifier.modifier, attributeModifier2.modifier) && attributeModifier.slotType == attributeModifier2.slotType && Objects.equals(attributeModifier.display, attributeModifier2.display)) {
                    return true;
                }
            }
            return false;
        }

        public static String[] jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$get$EQUIPMENT_SLOT_GROUPS() {
            return EQUIPMENT_SLOT_GROUPS;
        }

        public static void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$set$EQUIPMENT_SLOT_GROUPS(String[] stringArray) {
            EQUIPMENT_SLOT_GROUPS = stringArray;
        }

        public int jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$get$attribute() {
            return this.attribute;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$set$attribute(int n2) {
            this.attribute = n2;
        }

        public int jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$get$slotType() {
            return this.slotType;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$set$slotType(int n2) {
            this.slotType = n2;
        }

        public static String[] jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$get$OPERATION() {
            return OPERATION;
        }

        public static void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$set$OPERATION(String[] stringArray) {
            OPERATION = stringArray;
        }

        public ModifierData jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$get$modifier() {
            return this.modifier;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$set$modifier(ModifierData modifierData) {
            this.modifier = modifierData;
        }

        public Display jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$get$display() {
            return this.display;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$AttributeModifier$set$display(Display display) {
            this.display = display;
        }
    }

    @RecordComponents(value={@RecordComponents.Value(name="id", type=String.class), @RecordComponents.Value(name="amount", type=double.class), @RecordComponents.Value(name="operation", type=int.class)})
    @NestHost(value=AttributeModifiers1_21.class)
    public static final class ModifierData
    extends J_L_Record {
        private final String id;
        private final double amount;
        private final int operation;
        public static final Type<ModifierData> TYPE = new Type<ModifierData>(ModifierData.class){

            @Override
            public ModifierData read(ByteBuf buffer) {
                String id = (String)Types.STRING.read(buffer);
                double amount = buffer.readDouble();
                int operation = Types.VAR_INT.readPrimitive(buffer);
                return new ModifierData(id, amount, operation);
            }

            @Override
            public void write(ByteBuf buffer, ModifierData value) {
                Types.STRING.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$ModifierData$get$id());
                buffer.writeDouble(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$ModifierData$get$amount());
                Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$ModifierData$get$operation());
            }
        };

        public ModifierData(String id, double amount, int operation) {
            this.id = id;
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

        public String id() {
            return this.id;
        }

        public double amount() {
            return this.amount;
        }

        public int operation() {
            return this.operation;
        }

        private static String jvmdowngrader$toString$toString(ModifierData modifierData) {
            ModifierData modifierData2 = modifierData;
            return "AttributeModifiers1_21$ModifierData[" + "id=" + modifierData.id + ", " + "amount=" + modifierData.amount + ", " + "operation=" + modifierData.operation + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(ModifierData modifierData) {
            Object[] objectArray = new Object[]{modifierData.id, modifierData.amount, modifierData.operation};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(ModifierData modifierData, Object object) {
            if (modifierData == object) {
                return true;
            }
            if (object != null && object instanceof ModifierData) {
                ModifierData modifierData2 = (ModifierData)object;
                if (Objects.equals(modifierData.id, modifierData2.id) && modifierData.amount == modifierData2.amount && modifierData.operation == modifierData2.operation) {
                    return true;
                }
            }
            return false;
        }

        public int jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$ModifierData$get$operation() {
            return this.operation;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$ModifierData$set$operation(int n2) {
            this.operation = n2;
        }

        public double jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$ModifierData$get$amount() {
            return this.amount;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$ModifierData$set$amount(double d2) {
            this.amount = d2;
        }

        public String jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$ModifierData$get$id() {
            return this.id;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$ModifierData$set$id(String string) {
            this.id = string;
        }
    }

    @NestHost(value=AttributeModifiers1_21.class)
    public static class Display
    implements Copyable {
        public static final String[] DISPLAY_TYPES = new String[]{"default", "hidden", "override_text"};
        public static final Display DEFAULT = new Display(0);
        private final int id;

        public Display(int id) {
            this.id = id;
        }

        public int id() {
            return this.id;
        }

        public void write(ByteBuf buf) {
            Types.VAR_INT.writePrimitive(buf, this.id);
        }

        @Override
        public Display copy() {
            return this;
        }
    }

    @NestHost(value=AttributeModifiers1_21.class)
    public static final class OverrideText
    extends Display {
        public static final int ID = 2;
        private final Tag component;

        public OverrideText(Tag component) {
            super(2);
            this.component = component;
        }

        public Tag component() {
            return this.component;
        }

        @Override
        public void write(ByteBuf buf) {
            super.write(buf);
            Types.TAG.write(buf, this.component);
        }

        @Override
        public OverrideText copy() {
            return new OverrideText(this.component.copy());
        }

        public Tag jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$OverrideText$get$component() {
            return this.component;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AttributeModifiers1_21$OverrideText$set$component(Tag tag) {
            this.component = tag;
        }
    }
}

