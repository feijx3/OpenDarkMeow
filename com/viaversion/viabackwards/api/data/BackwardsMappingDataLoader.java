/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 */
package com.viaversion.viabackwards.api.data;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viaversion.api.data.MappingDataLoader;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.qual.Nullable;

public class BackwardsMappingDataLoader
extends MappingDataLoader {
    public static final BackwardsMappingDataLoader INSTANCE = new BackwardsMappingDataLoader(BackwardsMappingDataLoader.class, "assets/viabackwards/data/");

    public BackwardsMappingDataLoader(Class<?> dataLoaderClass, String dataPath) {
        super(dataLoaderClass, dataPath);
    }

    public @Nullable CompoundTag loadNBTFromDir(String name) {
        CompoundTag packedData = this.loadNBT(name);
        File file = new File(this.getDataFolder(), name);
        if (!file.exists()) {
            return packedData;
        }
        this.getLogger().info(BackwardsMappingDataLoader.jvmdowngrader$concat$loadNBTFromDir$1(name));
        try {
            CompoundTag fileData = (CompoundTag)MAPPINGS_READER.read(file.toPath(), false);
            return this.mergeTags(packedData, fileData);
        }
        catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private CompoundTag mergeTags(CompoundTag original, CompoundTag extra) {
        for (Map.Entry<String, Tag> entry : extra.entrySet()) {
            CompoundTag originalEntry;
            if (entry.getValue() instanceof CompoundTag && (originalEntry = original.getCompoundTag(entry.getKey())) != null) {
                this.mergeTags(originalEntry, (CompoundTag)entry.getValue());
                continue;
            }
            original.put(entry.getKey(), entry.getValue());
        }
        return original;
    }

    @Override
    public Logger getLogger() {
        return ViaBackwards.getPlatform().getLogger();
    }

    @Override
    public File getDataFolder() {
        return ViaBackwards.getPlatform().getDataFolder();
    }

    private static String jvmdowngrader$concat$loadNBTFromDir$1(String string) {
        return "Loading " + string + " from plugin folder";
    }
}

