/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.util;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.protocol.Protocol;
import java.util.ArrayList;
import java.util.Comparator;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={EntityIdSetter.class})
public final class EntityTypeUtil {
    private static final EntityType[] EMPTY_ARRAY = new EntityType[0];

    public static EntityType[] toOrderedArray(EntityType[] values) {
        ArrayList<EntityType> types = new ArrayList<EntityType>();
        for (EntityType type : values) {
            if (type.getId() == -1) continue;
            types.add(type);
        }
        types.sort(Comparator.comparingInt(EntityType::getId));
        return types.toArray(EMPTY_ARRAY);
    }

    public static <T extends EntityType> void initialize(T[] values, EntityType[] typesToFill, Protocol<?, ?, ?, ?> protocol, EntityIdSetter<T> idSetter) {
        FullMappings mappings = protocol.getMappingData().getEntityMappings();
        for (T type : values) {
            if (type.isAbstractType()) continue;
            int id = mappings.mappedId(type.identifier());
            Preconditions.checkArgument((id != -1 ? 1 : 0) != 0, (String)"Entity type %s has no id", (Object[])new Object[]{type.identifier()});
            idSetter.setId(type, id);
            typesToFill[id] = type;
        }
        if (typesToFill.length != mappings.mappedSize()) {
            throw new IllegalArgumentException(EntityTypeUtil.jvmdowngrader$concat$initialize$1(typesToFill.length, mappings.size()));
        }
    }

    public static EntityType[] createSizedArray(EntityType[] values) {
        int count = 0;
        for (EntityType type : values) {
            if (type.isAbstractType()) continue;
            ++count;
        }
        return new EntityType[count];
    }

    public static EntityType getTypeFromId(EntityType[] values, int typeId, EntityType fallback) {
        EntityType type;
        if (typeId < 0 || typeId >= values.length || (type = values[typeId]) == null) {
            Via.getPlatform().getLogger().severe(EntityTypeUtil.jvmdowngrader$concat$getTypeFromId$1(fallback.getClass().getSimpleName(), typeId));
            return fallback;
        }
        return type;
    }

    private static String jvmdowngrader$concat$initialize$1(int n2, int n3) {
        return "typesToFill length doesn't match the amount of entity types: " + n2 + " != " + n3;
    }

    private static String jvmdowngrader$concat$getTypeFromId$1(String string, int n2) {
        return "Could not find " + string + " type id " + n2;
    }

    @FunctionalInterface
    @NestHost(value=EntityTypeUtil.class)
    public static interface EntityIdSetter<T extends EntityType> {
        public void setId(T var1, int var2);
    }
}

