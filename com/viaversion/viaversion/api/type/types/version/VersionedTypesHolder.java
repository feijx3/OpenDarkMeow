/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.version;

import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.data.version.VersionedStructuredDataKeys;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.types.AbstractEntityDataTypes;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.types.ArrayType;
import com.viaversion.viaversion.api.type.types.item.StructuredDataType;
import com.viaversion.viaversion.api.type.types.misc.ParticleType;
import java.util.List;

public interface VersionedTypesHolder {
    public Type<Item> item();

    public Type<Item[]> itemArray();

    public Type<Item> itemCost();

    public Type<Item> optionalItemCost();

    public Type<Item> lengthPrefixedItem();

    public StructuredDataType structuredData();

    public Type<StructuredData<?>[]> structuredDataArray();

    public VersionedStructuredDataKeys structuredDataKeys();

    public ParticleType particle();

    public ArrayType<Particle> particles();

    public AbstractEntityDataTypes entityDataTypes();

    public Type<List<EntityData>> entityDataList();
}

