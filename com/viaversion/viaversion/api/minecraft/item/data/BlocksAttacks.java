/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="blockDelaySeconds", type=float.class), @RecordComponents.Value(name="disableCooldownScale", type=float.class), @RecordComponents.Value(name="damageReductions", type=DamageReduction[].class), @RecordComponents.Value(name="itemDamage", type=ItemDamageFunction.class), @RecordComponents.Value(name="bypassedByTag", type=String.class), @RecordComponents.Value(name="blockSound", type=Holder.class), @RecordComponents.Value(name="disableSound", type=Holder.class)})
@NestMembers(value={ItemDamageFunction.class, ItemDamageFunction.1.class, DamageReduction.class, DamageReduction.1.class, 1.class})
public final class BlocksAttacks
extends J_L_Record
implements Rewritable {
    private final float blockDelaySeconds;
    private final float disableCooldownScale;
    private final DamageReduction[] damageReductions;
    private final ItemDamageFunction itemDamage;
    private final @Nullable String bypassedByTag;
    private final @Nullable Holder<SoundEvent> blockSound;
    private final @Nullable Holder<SoundEvent> disableSound;
    public static final Type<BlocksAttacks> TYPE = new Type<BlocksAttacks>(BlocksAttacks.class){

        @Override
        public BlocksAttacks read(ByteBuf buffer) {
            float blockDelaySeconds = buffer.readFloat();
            float disableCooldownScale = buffer.readFloat();
            DamageReduction[] damageReductions = DamageReduction.ARRAY_TYPE.read(buffer);
            ItemDamageFunction itemDamage = (ItemDamageFunction)ItemDamageFunction.TYPE.read(buffer);
            String bypassedByTag = (String)Types.OPTIONAL_STRING.read(buffer);
            Object blockSound = Types.OPTIONAL_SOUND_EVENT.read(buffer);
            Object disableSound = Types.OPTIONAL_SOUND_EVENT.read(buffer);
            return new BlocksAttacks(blockDelaySeconds, disableCooldownScale, damageReductions, itemDamage, bypassedByTag, (Holder<SoundEvent>)blockSound, (Holder<SoundEvent>)disableSound);
        }

        @Override
        public void write(ByteBuf buffer, BlocksAttacks value) {
            buffer.writeFloat(value.blockDelaySeconds());
            buffer.writeFloat(value.disableCooldownScale());
            DamageReduction.ARRAY_TYPE.write(buffer, (T[])value.damageReductions());
            ItemDamageFunction.TYPE.write(buffer, value.itemDamage());
            Types.OPTIONAL_STRING.write(buffer, value.bypassedByTag());
            Types.OPTIONAL_SOUND_EVENT.write(buffer, value.blockSound());
            Types.OPTIONAL_SOUND_EVENT.write(buffer, value.disableSound());
        }
    };

    public BlocksAttacks(float blockDelaySeconds, float disableCooldownScale, DamageReduction[] damageReductions, ItemDamageFunction itemDamage, @Nullable String bypassedByTag, @Nullable Holder<SoundEvent> blockSound, @Nullable Holder<SoundEvent> disableSound) {
        this.blockDelaySeconds = blockDelaySeconds;
        this.disableCooldownScale = disableCooldownScale;
        this.damageReductions = damageReductions;
        this.itemDamage = itemDamage;
        this.bypassedByTag = bypassedByTag;
        this.blockSound = blockSound;
        this.disableSound = disableSound;
    }

    @Override
    public BlocksAttacks rewrite(UserConnection connection, Protocol<?, ?, ?, ?> protocol, boolean clientbound) {
        Holder<SoundEvent> blockSound = SoundEvent.rewriteHolder(this.blockSound, Rewritable.soundRewriteFunction(protocol, clientbound));
        Holder<SoundEvent> disableSound = SoundEvent.rewriteHolder(this.disableSound, Rewritable.soundRewriteFunction(protocol, clientbound));
        return new BlocksAttacks(this.blockDelaySeconds, this.disableCooldownScale, this.damageReductions, this.itemDamage, this.bypassedByTag, blockSound, disableSound);
    }

    @Override
    public final String toString() {
        return BlocksAttacks.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return BlocksAttacks.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return BlocksAttacks.jvmdowngrader$equals$equals(this, o2);
    }

    public float blockDelaySeconds() {
        return this.blockDelaySeconds;
    }

    public float disableCooldownScale() {
        return this.disableCooldownScale;
    }

    public DamageReduction[] damageReductions() {
        return this.damageReductions;
    }

    public ItemDamageFunction itemDamage() {
        return this.itemDamage;
    }

    public @Nullable String bypassedByTag() {
        return this.bypassedByTag;
    }

    public @Nullable Holder<SoundEvent> blockSound() {
        return this.blockSound;
    }

    public @Nullable Holder<SoundEvent> disableSound() {
        return this.disableSound;
    }

    private static String jvmdowngrader$toString$toString(BlocksAttacks blocksAttacks) {
        BlocksAttacks blocksAttacks2 = blocksAttacks;
        return "BlocksAttacks[" + "blockDelaySeconds=" + blocksAttacks.blockDelaySeconds + ", " + "disableCooldownScale=" + blocksAttacks.disableCooldownScale + ", " + "damageReductions=" + blocksAttacks.damageReductions + ", " + "itemDamage=" + blocksAttacks.itemDamage + ", " + "bypassedByTag=" + blocksAttacks.bypassedByTag + ", " + "blockSound=" + blocksAttacks.blockSound + ", " + "disableSound=" + blocksAttacks.disableSound + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(BlocksAttacks blocksAttacks) {
        Object[] objectArray = new Object[]{Float.valueOf(blocksAttacks.blockDelaySeconds), Float.valueOf(blocksAttacks.disableCooldownScale), blocksAttacks.damageReductions, blocksAttacks.itemDamage, blocksAttacks.bypassedByTag, blocksAttacks.blockSound, blocksAttacks.disableSound};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(BlocksAttacks blocksAttacks, Object object) {
        if (blocksAttacks == object) {
            return true;
        }
        if (object != null && object instanceof BlocksAttacks) {
            BlocksAttacks blocksAttacks2 = (BlocksAttacks)object;
            if (blocksAttacks.blockDelaySeconds == blocksAttacks2.blockDelaySeconds && blocksAttacks.disableCooldownScale == blocksAttacks2.disableCooldownScale && Objects.equals(blocksAttacks.damageReductions, blocksAttacks2.damageReductions) && Objects.equals(blocksAttacks.itemDamage, blocksAttacks2.itemDamage) && Objects.equals(blocksAttacks.bypassedByTag, blocksAttacks2.bypassedByTag) && Objects.equals(blocksAttacks.blockSound, blocksAttacks2.blockSound) && Objects.equals(blocksAttacks.disableSound, blocksAttacks2.disableSound)) {
                return true;
            }
        }
        return false;
    }

    @RecordComponents(value={@RecordComponents.Value(name="horizontalBlockingAngle", type=float.class), @RecordComponents.Value(name="type", type=HolderSet.class), @RecordComponents.Value(name="base", type=float.class), @RecordComponents.Value(name="factor", type=float.class)})
    @NestHost(value=BlocksAttacks.class)
    public static final class DamageReduction
    extends J_L_Record {
        private final float horizontalBlockingAngle;
        private final @Nullable HolderSet type;
        private final float base;
        private final float factor;
        public static final Type<DamageReduction> TYPE = new Type<DamageReduction>(DamageReduction.class){

            @Override
            public DamageReduction read(ByteBuf buffer) {
                float horizontalBlockingAngle = buffer.readFloat();
                HolderSet type = (HolderSet)Types.OPTIONAL_HOLDER_SET.read(buffer);
                float base = buffer.readFloat();
                float factor = buffer.readFloat();
                return new DamageReduction(horizontalBlockingAngle, type, base, factor);
            }

            @Override
            public void write(ByteBuf buffer, DamageReduction value) {
                buffer.writeFloat(value.horizontalBlockingAngle());
                Types.OPTIONAL_HOLDER_SET.write(buffer, value.type());
                buffer.writeFloat(value.base());
                buffer.writeFloat(value.factor());
            }
        };
        public static final ArrayType<DamageReduction> ARRAY_TYPE = new ArrayType<DamageReduction>(TYPE);

        public DamageReduction(float horizontalBlockingAngle, @Nullable HolderSet type, float base, float factor) {
            this.horizontalBlockingAngle = horizontalBlockingAngle;
            this.type = type;
            this.base = base;
            this.factor = factor;
        }

        @Override
        public final String toString() {
            return DamageReduction.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return DamageReduction.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return DamageReduction.jvmdowngrader$equals$equals(this, o2);
        }

        public float horizontalBlockingAngle() {
            return this.horizontalBlockingAngle;
        }

        public @Nullable HolderSet type() {
            return this.type;
        }

        public float base() {
            return this.base;
        }

        public float factor() {
            return this.factor;
        }

        private static String jvmdowngrader$toString$toString(DamageReduction damageReduction) {
            DamageReduction damageReduction2 = damageReduction;
            return "BlocksAttacks$DamageReduction[" + "horizontalBlockingAngle=" + damageReduction.horizontalBlockingAngle + ", " + "type=" + damageReduction.type + ", " + "base=" + damageReduction.base + ", " + "factor=" + damageReduction.factor + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(DamageReduction damageReduction) {
            Object[] objectArray = new Object[]{Float.valueOf(damageReduction.horizontalBlockingAngle), damageReduction.type, Float.valueOf(damageReduction.base), Float.valueOf(damageReduction.factor)};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(DamageReduction damageReduction, Object object) {
            if (damageReduction == object) {
                return true;
            }
            if (object != null && object instanceof DamageReduction) {
                DamageReduction damageReduction2 = (DamageReduction)object;
                if (damageReduction.horizontalBlockingAngle == damageReduction2.horizontalBlockingAngle && Objects.equals(damageReduction.type, damageReduction2.type) && damageReduction.base == damageReduction2.base && damageReduction.factor == damageReduction2.factor) {
                    return true;
                }
            }
            return false;
        }
    }

    @RecordComponents(value={@RecordComponents.Value(name="threshold", type=float.class), @RecordComponents.Value(name="base", type=float.class), @RecordComponents.Value(name="factor", type=float.class)})
    @NestHost(value=BlocksAttacks.class)
    public static final class ItemDamageFunction
    extends J_L_Record {
        private final float threshold;
        private final float base;
        private final float factor;
        public static final Type<ItemDamageFunction> TYPE = new Type<ItemDamageFunction>(ItemDamageFunction.class){

            @Override
            public ItemDamageFunction read(ByteBuf buffer) {
                float threshold = buffer.readFloat();
                float base = buffer.readFloat();
                float factor = buffer.readFloat();
                return new ItemDamageFunction(threshold, base, factor);
            }

            @Override
            public void write(ByteBuf buffer, ItemDamageFunction value) {
                buffer.writeFloat(value.threshold());
                buffer.writeFloat(value.base());
                buffer.writeFloat(value.factor());
            }
        };

        public ItemDamageFunction(float threshold, float base, float factor) {
            this.threshold = threshold;
            this.base = base;
            this.factor = factor;
        }

        @Override
        public final String toString() {
            return ItemDamageFunction.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return ItemDamageFunction.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return ItemDamageFunction.jvmdowngrader$equals$equals(this, o2);
        }

        public float threshold() {
            return this.threshold;
        }

        public float base() {
            return this.base;
        }

        public float factor() {
            return this.factor;
        }

        private static String jvmdowngrader$toString$toString(ItemDamageFunction itemDamageFunction) {
            ItemDamageFunction itemDamageFunction2 = itemDamageFunction;
            return "BlocksAttacks$ItemDamageFunction[" + "threshold=" + itemDamageFunction.threshold + ", " + "base=" + itemDamageFunction.base + ", " + "factor=" + itemDamageFunction.factor + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(ItemDamageFunction itemDamageFunction) {
            Object[] objectArray = new Object[]{Float.valueOf(itemDamageFunction.threshold), Float.valueOf(itemDamageFunction.base), Float.valueOf(itemDamageFunction.factor)};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(ItemDamageFunction itemDamageFunction, Object object) {
            if (itemDamageFunction == object) {
                return true;
            }
            if (object != null && object instanceof ItemDamageFunction) {
                ItemDamageFunction itemDamageFunction2 = (ItemDamageFunction)object;
                if (itemDamageFunction.threshold == itemDamageFunction2.threshold && itemDamageFunction.base == itemDamageFunction2.base && itemDamageFunction.factor == itemDamageFunction2.factor) {
                    return true;
                }
            }
            return false;
        }
    }
}

