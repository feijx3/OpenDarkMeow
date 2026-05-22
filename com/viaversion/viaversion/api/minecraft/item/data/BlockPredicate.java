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
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.data.predicate.DataComponentMatchers;
import com.viaversion.viaversion.api.minecraft.data.predicate.DataComponentPredicate;
import com.viaversion.viaversion.api.minecraft.item.data.StatePropertyMatcher;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import com.viaversion.viaversion.util.Copyable;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="holderSet", type=HolderSet.class), @RecordComponents.Value(name="propertyMatchers", type=StatePropertyMatcher[].class), @RecordComponents.Value(name="tag", type=CompoundTag.class), @RecordComponents.Value(name="dataMatchers", type=DataComponentMatchers.class)})
@NestMembers(value={BlockPredicateType1_21_5.class, 1.class})
public final class BlockPredicate
extends J_L_Record
implements Copyable,
Rewritable {
    private final @Nullable HolderSet holderSet;
    private final StatePropertyMatcher @Nullable [] propertyMatchers;
    private final @Nullable CompoundTag tag;
    private final DataComponentMatchers dataMatchers;
    public static final Type<BlockPredicate> TYPE1_20_5 = new Type<BlockPredicate>(BlockPredicate.class){

        @Override
        public BlockPredicate read(ByteBuf buffer) {
            HolderSet holders = (HolderSet)Types.OPTIONAL_HOLDER_SET.read(buffer);
            StatePropertyMatcher[] propertyMatchers = buffer.readBoolean() ? (StatePropertyMatcher[])StatePropertyMatcher.ARRAY_TYPE.read(buffer) : null;
            CompoundTag tag = (CompoundTag)Types.OPTIONAL_COMPOUND_TAG.read(buffer);
            return new BlockPredicate(holders, propertyMatchers, tag, null);
        }

        @Override
        public void write(ByteBuf buffer, BlockPredicate value) {
            Types.OPTIONAL_HOLDER_SET.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BlockPredicate$get$holderSet());
            buffer.writeBoolean(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BlockPredicate$get$propertyMatchers() != null);
            if (value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BlockPredicate$get$propertyMatchers() != null) {
                StatePropertyMatcher.ARRAY_TYPE.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BlockPredicate$get$propertyMatchers());
            }
            Types.OPTIONAL_COMPOUND_TAG.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BlockPredicate$get$tag());
        }
    };
    public static final Type<BlockPredicate[]> ARRAY_TYPE1_20_5 = new ArrayType<BlockPredicate>(TYPE1_20_5);

    public BlockPredicate(@Nullable HolderSet holderSet, StatePropertyMatcher @Nullable [] propertyMatchers, @Nullable CompoundTag tag) {
        this(holderSet, propertyMatchers, tag, new DataComponentMatchers(new StructuredData[0], new DataComponentPredicate[0]));
    }

    public BlockPredicate(@Nullable HolderSet holderSet, StatePropertyMatcher @Nullable [] propertyMatchers, @Nullable CompoundTag tag, DataComponentMatchers dataMatchers) {
        this.holderSet = holderSet;
        this.propertyMatchers = propertyMatchers;
        this.tag = tag;
        this.dataMatchers = dataMatchers;
    }

    @Override
    public BlockPredicate rewrite(UserConnection connection, Protocol<?, ?, ?, ?> protocol, boolean clientbound) {
        if (this.holderSet == null || this.holderSet.hasTagKey()) {
            return this;
        }
        HolderSet updatedHolders = this.holderSet.rewrite(Rewritable.blockRewriteFunction(protocol, clientbound));
        return new BlockPredicate(updatedHolders, this.propertyMatchers, this.tag);
    }

    @Override
    public BlockPredicate copy() {
        return new BlockPredicate(this.holderSet, Copyable.copy(this.propertyMatchers), this.tag == null ? null : this.tag.copy());
    }

    @Override
    public final String toString() {
        return BlockPredicate.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return BlockPredicate.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return BlockPredicate.jvmdowngrader$equals$equals(this, o2);
    }

    public @Nullable HolderSet holderSet() {
        return this.holderSet;
    }

    public StatePropertyMatcher @Nullable [] propertyMatchers() {
        return this.propertyMatchers;
    }

    public @Nullable CompoundTag tag() {
        return this.tag;
    }

    public DataComponentMatchers dataMatchers() {
        return this.dataMatchers;
    }

    private static String jvmdowngrader$toString$toString(BlockPredicate blockPredicate) {
        BlockPredicate blockPredicate2 = blockPredicate;
        return "BlockPredicate[" + "holderSet=" + blockPredicate.holderSet + ", " + "propertyMatchers=" + blockPredicate.propertyMatchers + ", " + "tag=" + blockPredicate.tag + ", " + "dataMatchers=" + blockPredicate.dataMatchers + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(BlockPredicate blockPredicate) {
        Object[] objectArray = new Object[]{blockPredicate.holderSet, blockPredicate.propertyMatchers, blockPredicate.tag, blockPredicate.dataMatchers};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(BlockPredicate blockPredicate, Object object) {
        if (blockPredicate == object) {
            return true;
        }
        if (object != null && object instanceof BlockPredicate) {
            BlockPredicate blockPredicate2 = (BlockPredicate)object;
            if (Objects.equals(blockPredicate.holderSet, blockPredicate2.holderSet) && Objects.equals(blockPredicate.propertyMatchers, blockPredicate2.propertyMatchers) && Objects.equals(blockPredicate.tag, blockPredicate2.tag) && Objects.equals(blockPredicate.dataMatchers, blockPredicate2.dataMatchers)) {
                return true;
            }
        }
        return false;
    }

    public StatePropertyMatcher[] jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BlockPredicate$get$propertyMatchers() {
        return this.propertyMatchers;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BlockPredicate$set$propertyMatchers(StatePropertyMatcher[] statePropertyMatcherArray) {
        this.propertyMatchers = statePropertyMatcherArray;
    }

    public CompoundTag jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BlockPredicate$get$tag() {
        return this.tag;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BlockPredicate$set$tag(CompoundTag compoundTag) {
        this.tag = compoundTag;
    }

    public DataComponentMatchers jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BlockPredicate$get$dataMatchers() {
        return this.dataMatchers;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BlockPredicate$set$dataMatchers(DataComponentMatchers dataComponentMatchers) {
        this.dataMatchers = dataComponentMatchers;
    }

    public HolderSet jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BlockPredicate$get$holderSet() {
        return this.holderSet;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BlockPredicate$set$holderSet(HolderSet holderSet) {
        this.holderSet = holderSet;
    }

    @NestHost(value=BlockPredicate.class)
    public static final class BlockPredicateType1_21_5
    extends Type<BlockPredicate> {
        private final Type<DataComponentMatchers> matchersType;

        public BlockPredicateType1_21_5(Type<StructuredData<?>[]> dataArrayType) {
            super(BlockPredicate.class);
            this.matchersType = new DataComponentMatchers.DataComponentMatchersType(dataArrayType);
        }

        @Override
        public BlockPredicate read(ByteBuf buffer) {
            HolderSet holders = (HolderSet)Types.OPTIONAL_HOLDER_SET.read(buffer);
            StatePropertyMatcher[] propertyMatchers = buffer.readBoolean() ? (StatePropertyMatcher[])StatePropertyMatcher.ARRAY_TYPE.read(buffer) : null;
            CompoundTag tag = (CompoundTag)Types.OPTIONAL_COMPOUND_TAG.read(buffer);
            DataComponentMatchers matchers = (DataComponentMatchers)this.matchersType.read(buffer);
            return new BlockPredicate(holders, propertyMatchers, tag, matchers);
        }

        @Override
        public void write(ByteBuf buffer, BlockPredicate value) {
            Types.OPTIONAL_HOLDER_SET.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BlockPredicate$get$holderSet());
            buffer.writeBoolean(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BlockPredicate$get$propertyMatchers() != null);
            if (value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BlockPredicate$get$propertyMatchers() != null) {
                StatePropertyMatcher.ARRAY_TYPE.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BlockPredicate$get$propertyMatchers());
            }
            Types.OPTIONAL_COMPOUND_TAG.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BlockPredicate$get$tag());
            this.matchersType.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_BlockPredicate$get$dataMatchers());
        }
    }
}

