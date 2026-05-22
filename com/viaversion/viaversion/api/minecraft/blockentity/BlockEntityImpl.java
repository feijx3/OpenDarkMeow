/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.minecraft.blockentity;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.minecraft.blockentity.BlockEntity;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="packedXZ", type=byte.class), @RecordComponents.Value(name="y", type=short.class), @RecordComponents.Value(name="typeId", type=int.class), @RecordComponents.Value(name="tag", type=CompoundTag.class)})
public final class BlockEntityImpl
extends J_L_Record
implements BlockEntity {
    private final byte packedXZ;
    private final short y;
    private final int typeId;
    private final CompoundTag tag;

    public BlockEntityImpl(byte packedXZ, short y2, int typeId, CompoundTag tag) {
        this.packedXZ = packedXZ;
        this.y = y2;
        this.typeId = typeId;
        this.tag = tag;
    }

    @Override
    public BlockEntity withTypeId(int typeId) {
        return new BlockEntityImpl(this.packedXZ, this.y, typeId, this.tag);
    }

    @Override
    public final String toString() {
        return BlockEntityImpl.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return BlockEntityImpl.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return BlockEntityImpl.jvmdowngrader$equals$equals(this, o2);
    }

    @Override
    public byte packedXZ() {
        return this.packedXZ;
    }

    @Override
    public short y() {
        return this.y;
    }

    @Override
    public int typeId() {
        return this.typeId;
    }

    @Override
    public CompoundTag tag() {
        return this.tag;
    }

    private static String jvmdowngrader$toString$toString(BlockEntityImpl blockEntityImpl) {
        BlockEntityImpl blockEntityImpl2 = blockEntityImpl;
        return "BlockEntityImpl[" + "packedXZ=" + blockEntityImpl.packedXZ + ", " + "y=" + blockEntityImpl.y + ", " + "typeId=" + blockEntityImpl.typeId + ", " + "tag=" + blockEntityImpl.tag + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(BlockEntityImpl blockEntityImpl) {
        Object[] objectArray = new Object[]{blockEntityImpl.packedXZ, blockEntityImpl.y, blockEntityImpl.typeId, blockEntityImpl.tag};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(BlockEntityImpl blockEntityImpl, Object object) {
        if (blockEntityImpl == object) {
            return true;
        }
        if (object != null && object instanceof BlockEntityImpl) {
            BlockEntityImpl blockEntityImpl2 = (BlockEntityImpl)object;
            if (blockEntityImpl.packedXZ == blockEntityImpl2.packedXZ && blockEntityImpl.y == blockEntityImpl2.y && blockEntityImpl.typeId == blockEntityImpl2.typeId && Objects.equals(blockEntityImpl.tag, blockEntityImpl2.tag)) {
                return true;
            }
        }
        return false;
    }
}

