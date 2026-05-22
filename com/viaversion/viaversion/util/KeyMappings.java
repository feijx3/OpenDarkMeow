/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 */
package com.viaversion.viaversion.util;

import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntMap;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntOpenHashMap;
import com.viaversion.viaversion.util.Key;
import java.util.Collection;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class KeyMappings {
    private final Object2IntMap<String> keyToId;
    private final String[] keys;

    public KeyMappings(String ... keys) {
        this.keys = keys;
        this.keyToId = new Object2IntOpenHashMap<String>(keys.length);
        this.keyToId.defaultReturnValue(-1);
        for (int i2 = 0; i2 < keys.length; ++i2) {
            this.keyToId.put(keys[i2], i2);
        }
    }

    public KeyMappings(Collection<String> keys) {
        this(keys.toArray(new String[0]));
    }

    public KeyMappings(ListTag<StringTag> keys) {
        this((String[])keys.getValue().stream().map(StringTag::getValue).toArray(String[]::new));
    }

    public @Nullable String idToKey(int id) {
        if (id < 0 || id >= this.keys.length) {
            return null;
        }
        return this.keys[id];
    }

    public int keyToId(String identifier) {
        return this.keyToId.getInt(Key.stripMinecraftNamespace(identifier));
    }

    public String[] keys() {
        return this.keys;
    }

    public int size() {
        return this.keys.length;
    }
}

