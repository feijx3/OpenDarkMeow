/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.protocols.v1_20_5to1_21.storage;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_U_S_Stream;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.Protocol1_20_5To1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPackets1_21;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@NestMembers(value={LevelToModifier.class, EnchantAttributeModifier.class, ActiveEnchant.class, ActiveEnchants.class})
public final class EfficiencyAttributeStorage
implements StorableObject {
    private static final EnchantAttributeModifier EFFICIENCY = new EnchantAttributeModifier("minecraft:enchantment.efficiency/mainhand", 19, 0.0, level -> level * level + 1);
    private static final EnchantAttributeModifier SOUL_SPEED = new EnchantAttributeModifier("minecraft:enchantment.soul_speed", 21, 0.1, level -> 0.04 + (double)(level - 1) * 0.01);
    private static final EnchantAttributeModifier SWIFT_SNEAK = new EnchantAttributeModifier("minecraft:enchantment.swift_sneak", 25, 0.3, level -> (double)level * 0.15);
    private static final EnchantAttributeModifier AQUA_AFFINITY = new EnchantAttributeModifier("minecraft:enchantment.aqua_affinity", 28, 0.2, level -> level * 4, 2);
    private static final EnchantAttributeModifier DEPTH_STRIDER = new EnchantAttributeModifier("minecraft:enchantment.depth_strider", 30, 0.0, level -> (double)level / 3.0);
    private static final ActiveEnchants DEFAULT = new ActiveEnchants(-1, new ActiveEnchant(EFFICIENCY, 0, 0), new ActiveEnchant(SOUL_SPEED, 0, 0), new ActiveEnchant(SWIFT_SNEAK, 0, 0), new ActiveEnchant(AQUA_AFFINITY, 0, 0), new ActiveEnchant(DEPTH_STRIDER, 0, 0));
    private final Object lock = new Object();
    private volatile boolean attributesSent = true;
    private volatile boolean loginSent;
    private ActiveEnchants activeEnchants = DEFAULT;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setEnchants(int entityId, UserConnection connection, ActiveEnchants enchants) {
        if (this.activeEnchants == enchants) {
            return;
        }
        Object object = this.lock;
        synchronized (object) {
            this.activeEnchants = entityId == -1 ? enchants : enchants.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$ActiveEnchants$withEntityId(entityId);
            this.attributesSent = false;
        }
        this.sendAttributesPacket(connection, false);
    }

    public ActiveEnchants activeEnchants() {
        return this.activeEnchants;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void onLoginSent(int entityId, UserConnection connection) {
        Object object = this.lock;
        synchronized (object) {
            this.activeEnchants = this.activeEnchants.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$ActiveEnchants$withEntityId(entityId);
        }
        this.loginSent = true;
        this.sendAttributesPacket(connection, false);
    }

    public void onRespawn(UserConnection connection) {
        this.sendAttributesPacket(connection, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void sendAttributesPacket(UserConnection connection, boolean forceSendAll) {
        ActiveEnchants enchants;
        Object object = this.lock;
        synchronized (object) {
            if (!(forceSendAll || this.loginSent && !this.attributesSent)) {
                return;
            }
            enchants = this.activeEnchants;
            this.attributesSent = true;
        }
        PacketWrapper attributesPacket = PacketWrapper.create(ClientboundPackets1_21.UPDATE_ATTRIBUTES, connection);
        attributesPacket.write(Types.VAR_INT, enchants.entityId());
        List<ActiveEnchant> list = J_U_S_Stream.toList(Stream.of(enchants.efficiency(), enchants.soulSpeed(), enchants.swiftSneak(), enchants.aquaAffinity(), enchants.depthStrider()).filter(enchant -> forceSendAll || enchant.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$ActiveEnchant$get$previousLevel() != enchant.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$ActiveEnchant$get$level()));
        attributesPacket.write(Types.VAR_INT, list.size());
        for (ActiveEnchant enchant2 : list) {
            EnchantAttributeModifier modifier = enchant2.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$ActiveEnchant$get$modifier();
            attributesPacket.write(Types.VAR_INT, modifier.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$EnchantAttributeModifier$get$attributeId());
            attributesPacket.write(Types.DOUBLE, modifier.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$EnchantAttributeModifier$get$baseValue());
            if (enchant2.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$ActiveEnchant$get$level() > 0) {
                attributesPacket.write(Types.VAR_INT, 1);
                attributesPacket.write(Types.STRING, modifier.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$EnchantAttributeModifier$get$key());
                attributesPacket.write(Types.DOUBLE, enchant2.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$ActiveEnchant$get$modifier().jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$EnchantAttributeModifier$get$modifierFunction().get(enchant2.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$ActiveEnchant$get$level()));
                attributesPacket.write(Types.BYTE, modifier.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$EnchantAttributeModifier$get$operation());
                continue;
            }
            attributesPacket.write(Types.VAR_INT, 0);
        }
        attributesPacket.scheduleSend(Protocol1_20_5To1_21.class);
    }

    @RecordComponents(value={@RecordComponents.Value(name="entityId", type=int.class), @RecordComponents.Value(name="efficiency", type=ActiveEnchant.class), @RecordComponents.Value(name="soulSpeed", type=ActiveEnchant.class), @RecordComponents.Value(name="swiftSneak", type=ActiveEnchant.class), @RecordComponents.Value(name="aquaAffinity", type=ActiveEnchant.class), @RecordComponents.Value(name="depthStrider", type=ActiveEnchant.class)})
    @NestHost(value=EfficiencyAttributeStorage.class)
    public static final class ActiveEnchants
    extends J_L_Record {
        private final int entityId;
        private final ActiveEnchant efficiency;
        private final ActiveEnchant soulSpeed;
        private final ActiveEnchant swiftSneak;
        private final ActiveEnchant aquaAffinity;
        private final ActiveEnchant depthStrider;

        public ActiveEnchants(int entityId, ActiveEnchant efficiency, ActiveEnchant soulSpeed, ActiveEnchant swiftSneak, ActiveEnchant aquaAffinity, ActiveEnchant depthStrider) {
            this.entityId = entityId;
            this.efficiency = efficiency;
            this.soulSpeed = soulSpeed;
            this.swiftSneak = swiftSneak;
            this.aquaAffinity = aquaAffinity;
            this.depthStrider = depthStrider;
        }

        private ActiveEnchants withEntityId(int entityId) {
            return this.entityId == entityId ? this : new ActiveEnchants(entityId, this.efficiency, this.soulSpeed, this.swiftSneak, this.aquaAffinity, this.depthStrider);
        }

        public ActiveEnchants efficiency(int level) {
            return this.efficiency.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$ActiveEnchant$get$level() == level ? this : new ActiveEnchants(this.entityId, new ActiveEnchant(this.efficiency, level), this.soulSpeed, this.swiftSneak, this.aquaAffinity, this.depthStrider);
        }

        public ActiveEnchants soulSpeed(int level) {
            return this.soulSpeed.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$ActiveEnchant$get$level() == level ? this : new ActiveEnchants(this.entityId, this.efficiency, new ActiveEnchant(this.soulSpeed, level), this.swiftSneak, this.aquaAffinity, this.depthStrider);
        }

        public ActiveEnchants swiftSneak(int level) {
            return this.swiftSneak.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$ActiveEnchant$get$level() == level ? this : new ActiveEnchants(this.entityId, this.efficiency, this.soulSpeed, new ActiveEnchant(this.swiftSneak, level), this.aquaAffinity, this.depthStrider);
        }

        public ActiveEnchants aquaAffinity(int level) {
            return this.aquaAffinity.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$ActiveEnchant$get$level() == level ? this : new ActiveEnchants(this.entityId, this.efficiency, this.soulSpeed, this.swiftSneak, new ActiveEnchant(this.aquaAffinity, level), this.depthStrider);
        }

        public ActiveEnchants depthStrider(int level) {
            return this.depthStrider.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$ActiveEnchant$get$level() == level ? this : new ActiveEnchants(this.entityId, this.efficiency, this.soulSpeed, this.swiftSneak, this.aquaAffinity, new ActiveEnchant(this.depthStrider, level));
        }

        @Override
        public final String toString() {
            return ActiveEnchants.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return ActiveEnchants.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return ActiveEnchants.jvmdowngrader$equals$equals(this, o2);
        }

        public int entityId() {
            return this.entityId;
        }

        public ActiveEnchant efficiency() {
            return this.efficiency;
        }

        public ActiveEnchant soulSpeed() {
            return this.soulSpeed;
        }

        public ActiveEnchant swiftSneak() {
            return this.swiftSneak;
        }

        public ActiveEnchant aquaAffinity() {
            return this.aquaAffinity;
        }

        public ActiveEnchant depthStrider() {
            return this.depthStrider;
        }

        private static String jvmdowngrader$toString$toString(ActiveEnchants activeEnchants) {
            ActiveEnchants activeEnchants2 = activeEnchants;
            return "EfficiencyAttributeStorage$ActiveEnchants[" + "entityId=" + activeEnchants.entityId + ", " + "efficiency=" + activeEnchants.efficiency + ", " + "soulSpeed=" + activeEnchants.soulSpeed + ", " + "swiftSneak=" + activeEnchants.swiftSneak + ", " + "aquaAffinity=" + activeEnchants.aquaAffinity + ", " + "depthStrider=" + activeEnchants.depthStrider + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(ActiveEnchants activeEnchants) {
            Object[] objectArray = new Object[]{activeEnchants.entityId, activeEnchants.efficiency, activeEnchants.soulSpeed, activeEnchants.swiftSneak, activeEnchants.aquaAffinity, activeEnchants.depthStrider};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(ActiveEnchants activeEnchants, Object object) {
            if (activeEnchants == object) {
                return true;
            }
            if (object != null && object instanceof ActiveEnchants) {
                ActiveEnchants activeEnchants2 = (ActiveEnchants)object;
                if (activeEnchants.entityId == activeEnchants2.entityId && Objects.equals(activeEnchants.efficiency, activeEnchants2.efficiency) && Objects.equals(activeEnchants.soulSpeed, activeEnchants2.soulSpeed) && Objects.equals(activeEnchants.swiftSneak, activeEnchants2.swiftSneak) && Objects.equals(activeEnchants.aquaAffinity, activeEnchants2.aquaAffinity) && Objects.equals(activeEnchants.depthStrider, activeEnchants2.depthStrider)) {
                    return true;
                }
            }
            return false;
        }

        public ActiveEnchants jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$ActiveEnchants$withEntityId(int n2) {
            return this.withEntityId(n2);
        }
    }

    @RecordComponents(value={@RecordComponents.Value(name="modifier", type=EnchantAttributeModifier.class), @RecordComponents.Value(name="previousLevel", type=int.class), @RecordComponents.Value(name="level", type=int.class)})
    @NestHost(value=EfficiencyAttributeStorage.class)
    public static final class ActiveEnchant
    extends J_L_Record {
        private final EnchantAttributeModifier modifier;
        private final int previousLevel;
        private final int level;

        public ActiveEnchant(ActiveEnchant from, int level) {
            this(from.modifier, from.level, level);
        }

        public ActiveEnchant(EnchantAttributeModifier modifier, int previousLevel, int level) {
            this.modifier = modifier;
            this.previousLevel = previousLevel;
            this.level = level;
        }

        @Override
        public final String toString() {
            return ActiveEnchant.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return ActiveEnchant.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return ActiveEnchant.jvmdowngrader$equals$equals(this, o2);
        }

        public EnchantAttributeModifier modifier() {
            return this.modifier;
        }

        public int previousLevel() {
            return this.previousLevel;
        }

        public int level() {
            return this.level;
        }

        private static String jvmdowngrader$toString$toString(ActiveEnchant activeEnchant) {
            ActiveEnchant activeEnchant2 = activeEnchant;
            return "EfficiencyAttributeStorage$ActiveEnchant[" + "modifier=" + activeEnchant.modifier + ", " + "previousLevel=" + activeEnchant.previousLevel + ", " + "level=" + activeEnchant.level + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(ActiveEnchant activeEnchant) {
            Object[] objectArray = new Object[]{activeEnchant.modifier, activeEnchant.previousLevel, activeEnchant.level};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(ActiveEnchant activeEnchant, Object object) {
            if (activeEnchant == object) {
                return true;
            }
            if (object != null && object instanceof ActiveEnchant) {
                ActiveEnchant activeEnchant2 = (ActiveEnchant)object;
                if (Objects.equals(activeEnchant.modifier, activeEnchant2.modifier) && activeEnchant.previousLevel == activeEnchant2.previousLevel && activeEnchant.level == activeEnchant2.level) {
                    return true;
                }
            }
            return false;
        }

        public int jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$ActiveEnchant$get$previousLevel() {
            return this.previousLevel;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$ActiveEnchant$set$previousLevel(int n2) {
            this.previousLevel = n2;
        }

        public int jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$ActiveEnchant$get$level() {
            return this.level;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$ActiveEnchant$set$level(int n2) {
            this.level = n2;
        }

        public EnchantAttributeModifier jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$ActiveEnchant$get$modifier() {
            return this.modifier;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$ActiveEnchant$set$modifier(EnchantAttributeModifier enchantAttributeModifier) {
            this.modifier = enchantAttributeModifier;
        }
    }

    @RecordComponents(value={@RecordComponents.Value(name="key", type=String.class), @RecordComponents.Value(name="attributeId", type=int.class), @RecordComponents.Value(name="baseValue", type=double.class), @RecordComponents.Value(name="modifierFunction", type=LevelToModifier.class), @RecordComponents.Value(name="operation", type=byte.class)})
    @NestHost(value=EfficiencyAttributeStorage.class)
    public static final class EnchantAttributeModifier
    extends J_L_Record {
        private final String key;
        private final int attributeId;
        private final double baseValue;
        private final LevelToModifier modifierFunction;
        private final byte operation;

        EnchantAttributeModifier(String key, int attributeId, double baseValue, LevelToModifier modifierFunction) {
            this(key, attributeId, baseValue, modifierFunction, 0);
        }

        public EnchantAttributeModifier(String key, int attributeId, double baseValue, LevelToModifier modifierFunction, byte operation) {
            this.key = key;
            this.attributeId = attributeId;
            this.baseValue = baseValue;
            this.modifierFunction = modifierFunction;
            this.operation = operation;
        }

        @Override
        public final String toString() {
            return EnchantAttributeModifier.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return EnchantAttributeModifier.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return EnchantAttributeModifier.jvmdowngrader$equals$equals(this, o2);
        }

        public String key() {
            return this.key;
        }

        public int attributeId() {
            return this.attributeId;
        }

        public double baseValue() {
            return this.baseValue;
        }

        public LevelToModifier modifierFunction() {
            return this.modifierFunction;
        }

        public byte operation() {
            return this.operation;
        }

        private static String jvmdowngrader$toString$toString(EnchantAttributeModifier enchantAttributeModifier) {
            EnchantAttributeModifier enchantAttributeModifier2 = enchantAttributeModifier;
            return "EfficiencyAttributeStorage$EnchantAttributeModifier[" + "key=" + enchantAttributeModifier.key + ", " + "attributeId=" + enchantAttributeModifier.attributeId + ", " + "baseValue=" + enchantAttributeModifier.baseValue + ", " + "modifierFunction=" + enchantAttributeModifier.modifierFunction + ", " + "operation=" + enchantAttributeModifier.operation + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(EnchantAttributeModifier enchantAttributeModifier) {
            Object[] objectArray = new Object[]{enchantAttributeModifier.key, enchantAttributeModifier.attributeId, enchantAttributeModifier.baseValue, enchantAttributeModifier.modifierFunction, enchantAttributeModifier.operation};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(EnchantAttributeModifier enchantAttributeModifier, Object object) {
            if (enchantAttributeModifier == object) {
                return true;
            }
            if (object != null && object instanceof EnchantAttributeModifier) {
                EnchantAttributeModifier enchantAttributeModifier2 = (EnchantAttributeModifier)object;
                if (Objects.equals(enchantAttributeModifier.key, enchantAttributeModifier2.key) && enchantAttributeModifier.attributeId == enchantAttributeModifier2.attributeId && enchantAttributeModifier.baseValue == enchantAttributeModifier2.baseValue && Objects.equals(enchantAttributeModifier.modifierFunction, enchantAttributeModifier2.modifierFunction) && enchantAttributeModifier.operation == enchantAttributeModifier2.operation) {
                    return true;
                }
            }
            return false;
        }

        public int jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$EnchantAttributeModifier$get$attributeId() {
            return this.attributeId;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$EnchantAttributeModifier$set$attributeId(int n2) {
            this.attributeId = n2;
        }

        public double jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$EnchantAttributeModifier$get$baseValue() {
            return this.baseValue;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$EnchantAttributeModifier$set$baseValue(double d2) {
            this.baseValue = d2;
        }

        public byte jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$EnchantAttributeModifier$get$operation() {
            return this.operation;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$EnchantAttributeModifier$set$operation(byte by2) {
            this.operation = by2;
        }

        public String jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$EnchantAttributeModifier$get$key() {
            return this.key;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$EnchantAttributeModifier$set$key(String string) {
            this.key = string;
        }

        public LevelToModifier jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$EnchantAttributeModifier$get$modifierFunction() {
            return this.modifierFunction;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_5to1_21_storage_EfficiencyAttributeStorage$EnchantAttributeModifier$set$modifierFunction(LevelToModifier levelToModifier) {
            this.modifierFunction = levelToModifier;
        }
    }

    @FunctionalInterface
    @NestHost(value=EfficiencyAttributeStorage.class)
    private static interface LevelToModifier {
        public double get(int var1);
    }
}

