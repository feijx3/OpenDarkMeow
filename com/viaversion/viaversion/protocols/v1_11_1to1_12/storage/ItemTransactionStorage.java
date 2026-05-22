/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.protocols.v1_11_1to1_12.storage;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import java.util.Arrays;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="windowId", type=short.class), @RecordComponents.Value(name="slotId", type=short.class), @RecordComponents.Value(name="actionId", type=short.class)})
public final class ItemTransactionStorage
extends J_L_Record {
    private final short windowId;
    private final short slotId;
    private final short actionId;

    public ItemTransactionStorage(short windowId, short slotId, short actionId) {
        this.windowId = windowId;
        this.slotId = slotId;
        this.actionId = actionId;
    }

    @Override
    public final String toString() {
        return ItemTransactionStorage.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return ItemTransactionStorage.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return ItemTransactionStorage.jvmdowngrader$equals$equals(this, o2);
    }

    public short windowId() {
        return this.windowId;
    }

    public short slotId() {
        return this.slotId;
    }

    public short actionId() {
        return this.actionId;
    }

    private static String jvmdowngrader$toString$toString(ItemTransactionStorage itemTransactionStorage) {
        ItemTransactionStorage itemTransactionStorage2 = itemTransactionStorage;
        return "ItemTransactionStorage[" + "windowId=" + itemTransactionStorage.windowId + ", " + "slotId=" + itemTransactionStorage.slotId + ", " + "actionId=" + itemTransactionStorage.actionId + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(ItemTransactionStorage itemTransactionStorage) {
        Object[] objectArray = new Object[]{itemTransactionStorage.windowId, itemTransactionStorage.slotId, itemTransactionStorage.actionId};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(ItemTransactionStorage itemTransactionStorage, Object object) {
        if (itemTransactionStorage == object) {
            return true;
        }
        if (object != null && object instanceof ItemTransactionStorage) {
            ItemTransactionStorage itemTransactionStorage2 = (ItemTransactionStorage)object;
            if (itemTransactionStorage.windowId == itemTransactionStorage2.windowId && itemTransactionStorage.slotId == itemTransactionStorage2.slotId && itemTransactionStorage.actionId == itemTransactionStorage2.actionId) {
                return true;
            }
        }
        return false;
    }
}

