/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.api.type;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viarewind.api.type.IntArrayType;
import com.viaversion.viarewind.api.type.PositionVarYType;
import com.viaversion.viarewind.api.type.entitydata.EntityDataListType;
import com.viaversion.viarewind.api.type.entitydata.EntityDataType;
import com.viaversion.viarewind.api.type.item.ItemArrayType;
import com.viaversion.viarewind.api.type.item.ItemType;
import com.viaversion.viarewind.api.type.item.NBTType;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import java.util.List;

public class RewindTypes {
    public static final Type<int[]> INT_ARRAY = new IntArrayType();
    public static final Type<BlockPosition> SHORT_POSITION = new PositionVarYType<Short>(Types.SHORT, value -> (short)value);
    public static final Type<BlockPosition> INT_POSITION = new PositionVarYType<Integer>(Types.INT, value -> value);
    public static final Type<BlockPosition> BYTE_POSITION = new PositionVarYType<Byte>(Types.BYTE, value -> (byte)value);
    public static final Type<BlockPosition> U_BYTE_POSITION = new PositionVarYType<Short>(Types.UNSIGNED_BYTE, value -> (short)value);
    public static final Type<CompoundTag> COMPRESSED_NBT = new NBTType();
    public static final Type<Item> COMPRESSED_NBT_ITEM = new ItemType();
    public static final Type<Item[]> COMPRESSED_NBT_ITEM_ARRAY = new ItemArrayType();
    public static final Type<EntityData> ENTITY_DATA1_7 = new EntityDataType();
    public static final Type<List<EntityData>> ENTITY_DATA_LIST1_7 = new EntityDataListType(ENTITY_DATA1_7);
}

