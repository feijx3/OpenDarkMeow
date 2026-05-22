/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viabackwards.protocol.v1_16to1_15_2.storage;

import ViaBackwards.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viabackwards.protocol.v1_16to1_15_2.Protocol1_16To1_15_2;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_14_4to1_15.packet.ClientboundPackets1_15;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@NestMembers(value={AttributeModifier.class, Attribute.class})
public final class PlayerAttributesStorage
implements StorableObject {
    private final Map<String, Attribute> attributes = new HashMap<String, Attribute>();

    public void sendAttributes(UserConnection connection, int entityId) {
        PacketWrapper updateAttributes = PacketWrapper.create(ClientboundPackets1_15.UPDATE_ATTRIBUTES, connection);
        updateAttributes.write(Types.VAR_INT, entityId);
        updateAttributes.write(Types.INT, this.attributes.size());
        for (Map.Entry<String, Attribute> attributeEntry : this.attributes.entrySet()) {
            Attribute attribute = attributeEntry.getValue();
            updateAttributes.write(Types.STRING, attributeEntry.getKey());
            updateAttributes.write(Types.DOUBLE, attribute.value());
            updateAttributes.write(Types.VAR_INT, attribute.modifiers().length);
            for (AttributeModifier modifier : attribute.modifiers()) {
                updateAttributes.write(Types.UUID, modifier.uuid());
                updateAttributes.write(Types.DOUBLE, modifier.amount());
                updateAttributes.write(Types.BYTE, modifier.operation());
            }
        }
        updateAttributes.send(Protocol1_16To1_15_2.class);
    }

    public void clearAttributes() {
        this.attributes.clear();
    }

    public void addAttribute(String key, Attribute attribute) {
        this.attributes.put(key, attribute);
    }

    @RecordComponents(value={@RecordComponents.Value(name="value", type=double.class), @RecordComponents.Value(name="modifiers", type=AttributeModifier[].class)})
    @NestHost(value=PlayerAttributesStorage.class)
    public static final class Attribute
    extends J_L_Record {
        private final double value;
        private final AttributeModifier[] modifiers;

        public Attribute(double value, AttributeModifier[] modifiers) {
            this.value = value;
            this.modifiers = modifiers;
        }

        @Override
        public final String toString() {
            return Attribute.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return Attribute.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return Attribute.jvmdowngrader$equals$equals(this, o2);
        }

        public double value() {
            return this.value;
        }

        public AttributeModifier[] modifiers() {
            return this.modifiers;
        }

        private static String jvmdowngrader$toString$toString(Attribute attribute) {
            Attribute attribute2 = attribute;
            return "PlayerAttributesStorage$Attribute[" + "value=" + attribute.value + ", " + "modifiers=" + attribute.modifiers + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(Attribute attribute) {
            Object[] objectArray = new Object[]{attribute.value, attribute.modifiers};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(Attribute attribute, Object object) {
            if (attribute == object) {
                return true;
            }
            if (object != null && object instanceof Attribute) {
                Attribute attribute2 = (Attribute)object;
                if (attribute.value == attribute2.value && Objects.equals(attribute.modifiers, attribute2.modifiers)) {
                    return true;
                }
            }
            return false;
        }
    }

    @RecordComponents(value={@RecordComponents.Value(name="uuid", type=UUID.class), @RecordComponents.Value(name="amount", type=double.class), @RecordComponents.Value(name="operation", type=byte.class)})
    @NestHost(value=PlayerAttributesStorage.class)
    public static final class AttributeModifier
    extends J_L_Record {
        private final UUID uuid;
        private final double amount;
        private final byte operation;

        public AttributeModifier(UUID uuid, double amount, byte operation) {
            this.uuid = uuid;
            this.amount = amount;
            this.operation = operation;
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

        public UUID uuid() {
            return this.uuid;
        }

        public double amount() {
            return this.amount;
        }

        public byte operation() {
            return this.operation;
        }

        private static String jvmdowngrader$toString$toString(AttributeModifier attributeModifier) {
            AttributeModifier attributeModifier2 = attributeModifier;
            return "PlayerAttributesStorage$AttributeModifier[" + "uuid=" + attributeModifier.uuid + ", " + "amount=" + attributeModifier.amount + ", " + "operation=" + attributeModifier.operation + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(AttributeModifier attributeModifier) {
            Object[] objectArray = new Object[]{attributeModifier.uuid, attributeModifier.amount, attributeModifier.operation};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(AttributeModifier attributeModifier, Object object) {
            if (attributeModifier == object) {
                return true;
            }
            if (object != null && object instanceof AttributeModifier) {
                AttributeModifier attributeModifier2 = (AttributeModifier)object;
                if (Objects.equals(attributeModifier.uuid, attributeModifier2.uuid) && attributeModifier.amount == attributeModifier2.amount && attributeModifier.operation == attributeModifier2.operation) {
                    return true;
                }
            }
            return false;
        }
    }
}

