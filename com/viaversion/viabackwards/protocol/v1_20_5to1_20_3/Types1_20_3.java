/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_20_5to1_20_3;

import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.data.version.VersionedStructuredDataKeys;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.types.AbstractEntityDataTypes;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import com.viaversion.viaversion.api.type.types.item.StructuredDataType;
import com.viaversion.viaversion.api.type.types.misc.ParticleType;
import com.viaversion.viaversion.api.type.types.version.VersionedTypesHolder;
import java.util.List;

final class Types1_20_3
implements VersionedTypesHolder {
    Types1_20_3() {
    }

    @Override
    public Type<Item> item() {
        return Types.ITEM1_20_2;
    }

    @Override
    public Type<Item[]> itemArray() {
        return Types.ITEM1_20_2_ARRAY;
    }

    @Override
    public Type<Item> itemCost() {
        return null;
    }

    @Override
    public Type<Item> optionalItemCost() {
        return null;
    }

    @Override
    public Type<Item> lengthPrefixedItem() {
        return null;
    }

    @Override
    public StructuredDataType structuredData() {
        return null;
    }

    @Override
    public Type<StructuredData<?>[]> structuredDataArray() {
        return null;
    }

    @Override
    public VersionedStructuredDataKeys structuredDataKeys() {
        return null;
    }

    @Override
    public ParticleType particle() {
        return com.viaversion.viaversion.api.type.types.version.Types1_20_3.PARTICLE;
    }

    @Override
    public ArrayType<Particle> particles() {
        return null;
    }

    @Override
    public AbstractEntityDataTypes entityDataTypes() {
        return com.viaversion.viaversion.api.type.types.version.Types1_20_3.ENTITY_DATA_TYPES;
    }

    @Override
    public Type<List<EntityData>> entityDataList() {
        return com.viaversion.viaversion.api.type.types.version.Types1_20_3.ENTITY_DATA_LIST;
    }
}

