/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 */
package com.viaversion.viabackwards.protocol.v1_21_2to1_21.storage;

import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.Key;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class ItemTagStorage
implements StorableObject {
    private Map<String, int[]> itemTags = new HashMap<String, int[]>();

    public int @Nullable [] itemTag(String key) {
        return this.itemTags.get(Key.stripMinecraftNamespace(key));
    }

    public void readItemTags(PacketWrapper wrapper) {
        int length = wrapper.passthrough(Types.VAR_INT);
        for (int i2 = 0; i2 < length; ++i2) {
            String registryKey = wrapper.passthrough(Types.STRING);
            int tagsSize = wrapper.passthrough(Types.VAR_INT);
            boolean itemRegistry = Key.stripMinecraftNamespace(registryKey).equals("item");
            if (itemRegistry) {
                this.itemTags = new HashMap<String, int[]>(tagsSize);
            }
            for (int j2 = 0; j2 < tagsSize; ++j2) {
                String key = wrapper.passthrough(Types.STRING);
                int[] ids = wrapper.passthrough(Types.VAR_INT_ARRAY_PRIMITIVE);
                if (!itemRegistry) continue;
                this.itemTags.put(Key.stripMinecraftNamespace(key), ids);
            }
        }
    }
}

