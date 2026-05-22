/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.storage;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.libs.fastutil.objects.Object2ObjectArrayMap;
import com.viaversion.viaversion.libs.fastutil.objects.Object2ObjectMap;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.KeyMappings;

public final class RegistryAndTags
implements StorableObject {
    private KeyMappings dialogMappings;
    private Object2ObjectMap<String, CompoundTag> dialogs;
    private Object2ObjectMap<String, int[]> dialogTags;

    public void storeRegistry(KeyMappings dialogMappings, Object2ObjectMap<String, CompoundTag> dialogs) {
        this.dialogMappings = dialogMappings;
        this.dialogs = dialogs;
    }

    public CompoundTag fromRegistry(int id) {
        return (CompoundTag)this.dialogs.get(this.dialogMappings.idToKey(id));
    }

    public CompoundTag fromRegistry(String key) {
        return (CompoundTag)this.dialogs.get(Key.stripMinecraftNamespace(key));
    }

    public boolean tagsSent() {
        return this.dialogTags != null && !this.dialogTags.isEmpty();
    }

    public void storeTags(String key, int[] ids) {
        if (this.dialogTags == null) {
            this.dialogTags = new Object2ObjectArrayMap<String, int[]>();
        }
        this.dialogTags.put(Key.stripMinecraftNamespace(key), ids);
    }

    public int[] fromKey(String key) {
        return (int[])this.dialogTags.get(Key.stripMinecraftNamespace(key));
    }

    public CompoundTag[] fromRegistryKey(String key) {
        int[] ids = this.fromKey(key);
        if (ids == null) {
            return null;
        }
        CompoundTag[] tags = new CompoundTag[ids.length];
        for (int i2 = 0; i2 < ids.length; ++i2) {
            tags[i2] = this.fromRegistry(ids[i2]);
        }
        return tags;
    }
}

