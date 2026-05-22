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

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.item.data.BlockPredicate;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.types.ArrayType;
import com.viaversion.viaversion.util.Copyable;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="predicates", type=BlockPredicate[].class), @RecordComponents.Value(name="showInTooltip", type=boolean.class)})
@NestMembers(value={AdventureModePredicateType1_21_5.class, 1.class})
public final class AdventureModePredicate
extends J_L_Record
implements Copyable,
Rewritable {
    private final BlockPredicate[] predicates;
    private final boolean showInTooltip;
    public static final Type<AdventureModePredicate> TYPE1_20_5 = new Type<AdventureModePredicate>(AdventureModePredicate.class){

        @Override
        public AdventureModePredicate read(ByteBuf buffer) {
            BlockPredicate[] predicates = (BlockPredicate[])BlockPredicate.ARRAY_TYPE1_20_5.read(buffer);
            boolean showInTooltip = buffer.readBoolean();
            return new AdventureModePredicate(predicates, showInTooltip);
        }

        @Override
        public void write(ByteBuf buffer, AdventureModePredicate value) {
            BlockPredicate.ARRAY_TYPE1_20_5.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AdventureModePredicate$get$predicates());
            buffer.writeBoolean(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AdventureModePredicate$get$showInTooltip());
        }
    };

    public AdventureModePredicate(BlockPredicate[] predicates) {
        this(predicates, true);
    }

    public AdventureModePredicate(BlockPredicate[] predicates, boolean showInTooltip) {
        this.predicates = predicates;
        this.showInTooltip = showInTooltip;
    }

    @Override
    public AdventureModePredicate rewrite(UserConnection connection, Protocol<?, ?, ?, ?> protocol, boolean clientbound) {
        BlockPredicate[] predicates = new BlockPredicate[this.predicates.length];
        for (int i2 = 0; i2 < predicates.length; ++i2) {
            predicates[i2] = this.predicates[i2].rewrite(connection, (Protocol)protocol, clientbound);
        }
        return new AdventureModePredicate(predicates, this.showInTooltip);
    }

    @Override
    public AdventureModePredicate copy() {
        return new AdventureModePredicate(Copyable.copy(this.predicates), this.showInTooltip);
    }

    @Override
    public final String toString() {
        return AdventureModePredicate.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return AdventureModePredicate.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return AdventureModePredicate.jvmdowngrader$equals$equals(this, o2);
    }

    public BlockPredicate[] predicates() {
        return this.predicates;
    }

    public boolean showInTooltip() {
        return this.showInTooltip;
    }

    private static String jvmdowngrader$toString$toString(AdventureModePredicate adventureModePredicate) {
        AdventureModePredicate adventureModePredicate2 = adventureModePredicate;
        return "AdventureModePredicate[" + "predicates=" + adventureModePredicate.predicates + ", " + "showInTooltip=" + adventureModePredicate.showInTooltip + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(AdventureModePredicate adventureModePredicate) {
        Object[] objectArray = new Object[]{adventureModePredicate.predicates, adventureModePredicate.showInTooltip};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(AdventureModePredicate adventureModePredicate, Object object) {
        if (adventureModePredicate == object) {
            return true;
        }
        if (object != null && object instanceof AdventureModePredicate) {
            AdventureModePredicate adventureModePredicate2 = (AdventureModePredicate)object;
            if (Objects.equals(adventureModePredicate.predicates, adventureModePredicate2.predicates) && adventureModePredicate.showInTooltip == adventureModePredicate2.showInTooltip) {
                return true;
            }
        }
        return false;
    }

    public boolean jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AdventureModePredicate$get$showInTooltip() {
        return this.showInTooltip;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AdventureModePredicate$set$showInTooltip(boolean bl2) {
        this.showInTooltip = bl2;
    }

    public BlockPredicate[] jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AdventureModePredicate$get$predicates() {
        return this.predicates;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AdventureModePredicate$set$predicates(BlockPredicate[] blockPredicateArray) {
        this.predicates = blockPredicateArray;
    }

    @NestHost(value=AdventureModePredicate.class)
    public static final class AdventureModePredicateType1_21_5
    extends Type<AdventureModePredicate> {
        private final Type<BlockPredicate[]> blockPredicateType;

        public AdventureModePredicateType1_21_5(Type<StructuredData<?>[]> dataArrayType) {
            super(AdventureModePredicate.class);
            this.blockPredicateType = new ArrayType<BlockPredicate>(new BlockPredicate.BlockPredicateType1_21_5(dataArrayType));
        }

        @Override
        public AdventureModePredicate read(ByteBuf buffer) {
            BlockPredicate[] predicates = (BlockPredicate[])this.blockPredicateType.read(buffer);
            return new AdventureModePredicate(predicates);
        }

        @Override
        public void write(ByteBuf buffer, AdventureModePredicate value) {
            this.blockPredicateType.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_AdventureModePredicate$get$predicates());
        }
    }
}

