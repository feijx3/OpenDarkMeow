/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viabackwards.api.entities.storage;

import ViaBackwards.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="entityDataList", type=List.class)})
public final class WrappedEntityData
extends J_L_Record {
    private final List<EntityData> entityDataList;

    public WrappedEntityData(List<EntityData> entityDataList) {
        this.entityDataList = entityDataList;
    }

    public boolean has(EntityData data) {
        return this.entityDataList.contains(data);
    }

    public void remove(EntityData data) {
        this.entityDataList.remove(data);
    }

    public void remove(int index) {
        this.entityDataList.removeIf(data -> data.id() == index);
    }

    public void add(EntityData data) {
        this.entityDataList.add(data);
    }

    public @Nullable EntityData get(int index) {
        for (EntityData data : this.entityDataList) {
            if (index != data.id()) continue;
            return data;
        }
        return null;
    }

    @Override
    public final String toString() {
        return WrappedEntityData.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return WrappedEntityData.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return WrappedEntityData.jvmdowngrader$equals$equals(this, o2);
    }

    public List<EntityData> entityDataList() {
        return this.entityDataList;
    }

    private static String jvmdowngrader$toString$toString(WrappedEntityData wrappedEntityData) {
        WrappedEntityData wrappedEntityData2 = wrappedEntityData;
        return "WrappedEntityData[" + "entityDataList=" + wrappedEntityData.entityDataList + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(WrappedEntityData wrappedEntityData) {
        Object[] objectArray = new Object[]{wrappedEntityData.entityDataList};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(WrappedEntityData wrappedEntityData, Object object) {
        if (wrappedEntityData == object) {
            return true;
        }
        if (object != null && object instanceof WrappedEntityData) {
            WrappedEntityData wrappedEntityData2 = (WrappedEntityData)object;
            if (Objects.equals(wrappedEntityData.entityDataList, wrappedEntityData2.entityDataList)) {
                return true;
            }
        }
        return false;
    }
}

