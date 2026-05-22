/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.annotations.Beta
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.api.data;

import com.google.common.annotations.Beta;
import com.viaversion.nbt.io.NBTIO;
import com.viaversion.nbt.io.TagReader;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.data.IdentityMappings;
import com.viaversion.viaversion.api.data.IntArrayMappings;
import com.viaversion.viaversion.api.data.Mappings;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntMap;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntOpenHashMap;
import com.viaversion.viaversion.libs.gson.JsonArray;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonIOException;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonSyntaxException;
import com.viaversion.viaversion.util.GsonUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={MappingsSupplier.class, MappingHolderSupplier.class, AddConsumer.class})
public class MappingDataLoader {
    public static final MappingDataLoader INSTANCE = new MappingDataLoader(MappingDataLoader.class, "assets/viaversion/data/");
    public static final TagReader<CompoundTag> MAPPINGS_READER = NBTIO.reader(CompoundTag.class).named();
    private static final Map<String, String[]> GLOBAL_IDENTIFIER_INDEXES = new HashMap<String, String[]>();
    private static final byte DIRECT_ID = 0;
    private static final byte SHIFTS_ID = 1;
    private static final byte CHANGES_ID = 2;
    private static final byte IDENTITY_ID = 3;
    private final Map<String, CompoundTag> mappingsCache = new HashMap<String, CompoundTag>();
    private final Class<?> dataLoaderClass;
    private final String dataPath;
    private boolean cacheValid = true;

    public MappingDataLoader(Class<?> dataLoaderClass, String dataPath) {
        this.dataLoaderClass = dataLoaderClass;
        this.dataPath = dataPath;
    }

    public static void loadGlobalIdentifiers() {
        CompoundTag globalIdentifiers = INSTANCE.loadNBT("identifier-table.nbt");
        for (Map.Entry<String, Tag> entry : globalIdentifiers.entrySet()) {
            ListTag value = (ListTag)entry.getValue();
            String[] array = new String[value.size()];
            int size = value.size();
            for (int i2 = 0; i2 < size; ++i2) {
                array[i2] = ((StringTag)value.get(i2)).getValue();
            }
            GLOBAL_IDENTIFIER_INDEXES.put(entry.getKey(), array);
        }
    }

    public @Nullable String identifierFromGlobalId(String registry, int globalId) {
        String[] array = GLOBAL_IDENTIFIER_INDEXES.get(registry);
        if (array == null) {
            throw new IllegalArgumentException(MappingDataLoader.jvmdowngrader$concat$identifierFromGlobalId$1(registry));
        }
        if (globalId < 0 || globalId >= array.length) {
            throw new IllegalArgumentException(MappingDataLoader.jvmdowngrader$concat$identifierFromGlobalId$1(globalId));
        }
        return array[globalId];
    }

    public void clearCache() {
        this.mappingsCache.clear();
        this.cacheValid = false;
    }

    public @Nullable JsonObject loadFromDataDir(String name) {
        JsonObject jsonObject;
        File file = new File(this.getDataFolder(), name);
        if (!file.exists()) {
            return this.loadData(name);
        }
        FileReader reader = new FileReader(file);
        try {
            jsonObject = GsonUtil.getGson().fromJson((Reader)reader, JsonObject.class);
        }
        catch (Throwable throwable) {
            try {
                try {
                    reader.close();
                }
                catch (Throwable throwable2) {
                    throwable.addSuppressed(throwable2);
                }
                throw throwable;
            }
            catch (JsonSyntaxException e2) {
                this.getLogger().warning(MappingDataLoader.jvmdowngrader$concat$loadFromDataDir$1(name));
                throw new RuntimeException(e2);
            }
            catch (JsonIOException | IOException e3) {
                throw new RuntimeException(e3);
            }
        }
        reader.close();
        return jsonObject;
    }

    public @Nullable JsonObject loadData(String name) {
        JsonObject jsonObject;
        InputStream stream = this.getResource(name);
        if (stream == null) {
            return null;
        }
        InputStreamReader reader = new InputStreamReader(stream);
        try {
            jsonObject = GsonUtil.getGson().fromJson((Reader)reader, JsonObject.class);
        }
        catch (Throwable throwable) {
            try {
                try {
                    reader.close();
                }
                catch (Throwable throwable2) {
                    throwable.addSuppressed(throwable2);
                }
                throw throwable;
            }
            catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
        reader.close();
        return jsonObject;
    }

    public @Nullable CompoundTag loadNBT(String name, boolean cache2) {
        if (!this.cacheValid) {
            return this.loadNBTFromFile(name);
        }
        CompoundTag data = this.mappingsCache.get(name);
        if (data != null) {
            return data;
        }
        data = this.loadNBTFromFile(name);
        if (cache2 && data != null) {
            this.mappingsCache.put(name, data);
        }
        return data;
    }

    public @Nullable CompoundTag loadNBT(String name) {
        return this.loadNBT(name, false);
    }

    public @Nullable CompoundTag loadNBTFromFile(String name) {
        CompoundTag compoundTag;
        InputStream resource = this.getResource(name);
        if (resource == null) {
            return null;
        }
        BufferedInputStream stream = new BufferedInputStream(resource);
        try {
            compoundTag = MAPPINGS_READER.read(stream);
        }
        catch (Throwable throwable) {
            try {
                try {
                    ((InputStream)stream).close();
                }
                catch (Throwable throwable2) {
                    throwable.addSuppressed(throwable2);
                }
                throw throwable;
            }
            catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
        ((InputStream)stream).close();
        return compoundTag;
    }

    public @Nullable Mappings loadMappings(CompoundTag mappingsTag, String key) {
        return this.loadMappings(mappingsTag, key, size -> {
            int[] array = new int[size];
            Arrays.fill(array, -1);
            return array;
        }, (array, id, mappedId) -> {
            array[id] = mappedId;
        }, IntArrayMappings::of);
    }

    @Beta
    public <M extends Mappings, V> @Nullable Mappings loadMappings(CompoundTag mappingsTag, String key, MappingHolderSupplier<V> holderSupplier, AddConsumer<V> addConsumer, MappingsSupplier<M, V> mappingsSupplier) {
        V mappings;
        CompoundTag tag = mappingsTag.getCompoundTag(key);
        if (tag == null) {
            return null;
        }
        int mappedSize = tag.getIntTag("mappedSize").asInt();
        byte strategy = tag.getByteTag("id").asByte();
        if (strategy == 0) {
            IntArrayTag valuesTag = tag.getIntArrayTag("val");
            return IntArrayMappings.of(valuesTag.getValue(), mappedSize);
        }
        if (strategy == 1) {
            int[] shiftsAt = tag.getIntArrayTag("at").getValue();
            int[] shiftsTo = tag.getIntArrayTag("to").getValue();
            int size = tag.getIntTag("size").asInt();
            mappings = holderSupplier.get(size);
            if (shiftsAt[0] != 0) {
                int to = shiftsAt[0];
                for (int id = 0; id < to; ++id) {
                    addConsumer.addTo(mappings, id, id);
                }
            }
            for (int i2 = 0; i2 < shiftsAt.length; ++i2) {
                boolean isLast = i2 == shiftsAt.length - 1;
                int from = shiftsAt[i2];
                int to = isLast ? size : shiftsAt[i2 + 1];
                int mappedId = shiftsTo[i2];
                for (int id = from; id < to; ++id) {
                    addConsumer.addTo(mappings, id, mappedId++);
                }
            }
        } else if (strategy == 2) {
            int[] changesAt = tag.getIntArrayTag("at").getValue();
            int[] values = tag.getIntArrayTag("val").getValue();
            int size = tag.getIntTag("size").asInt();
            boolean fillBetween = tag.get("nofill") == null;
            mappings = holderSupplier.get(size);
            int nextUnhandledId = 0;
            for (int i3 = 0; i3 < changesAt.length; ++i3) {
                int changedId = changesAt[i3];
                if (fillBetween) {
                    for (int id = nextUnhandledId; id < changedId; ++id) {
                        addConsumer.addTo(mappings, id, id);
                    }
                    nextUnhandledId = changedId + 1;
                }
                addConsumer.addTo(mappings, changedId, values[i3]);
            }
        } else {
            if (strategy == 3) {
                IntTag sizeTag = tag.getIntTag("size");
                return new IdentityMappings(sizeTag.asInt(), mappedSize);
            }
            throw new IllegalArgumentException(MappingDataLoader.jvmdowngrader$concat$loadMappings$1(strategy));
        }
        return mappingsSupplier.create(mappings, mappedSize);
    }

    public @Nullable List<String> identifiersFromGlobalIds(CompoundTag mappingsTag, String key) {
        Mappings mappings = this.loadMappings(mappingsTag, key);
        if (mappings == null) {
            return null;
        }
        ArrayList<String> identifiers = new ArrayList<String>(mappings.size());
        for (int i2 = 0; i2 < mappings.size(); ++i2) {
            identifiers.add(this.identifierFromGlobalId(key, mappings.getNewId(i2)));
        }
        return identifiers;
    }

    public Object2IntMap<String> indexedObjectToMap(JsonObject object) {
        Object2IntOpenHashMap<String> map = new Object2IntOpenHashMap<String>(object.size());
        map.defaultReturnValue(-1);
        for (Map.Entry<String, JsonElement> entry : object.entrySet()) {
            map.put(entry.getValue().getAsString(), Integer.parseInt(entry.getKey()));
        }
        return map;
    }

    public Object2IntMap<String> arrayToMap(JsonArray array) {
        Object2IntOpenHashMap<String> map = new Object2IntOpenHashMap<String>(array.size());
        map.defaultReturnValue(-1);
        for (int i2 = 0; i2 < array.size(); ++i2) {
            map.put(array.get(i2).getAsString(), i2);
        }
        return map;
    }

    public Logger getLogger() {
        return Via.getPlatform().getLogger();
    }

    public File getDataFolder() {
        return Via.getPlatform().getDataFolder();
    }

    public @Nullable InputStream getResource(String name) {
        return this.dataLoaderClass.getClassLoader().getResourceAsStream(MappingDataLoader.jvmdowngrader$concat$getResource$1(this.dataPath, name));
    }

    private static String jvmdowngrader$concat$identifierFromGlobalId$1(String string) {
        return "Unknown global identifier key: " + string;
    }

    private static String jvmdowngrader$concat$identifierFromGlobalId$1(int n2) {
        return "Unknown global identifier index: " + n2;
    }

    private static String jvmdowngrader$concat$loadFromDataDir$1(String string) {
        return string + " is badly formatted!";
    }

    private static String jvmdowngrader$concat$loadMappings$1(byte by2) {
        return "Unknown serialization strategy: " + by2;
    }

    private static String jvmdowngrader$concat$getResource$1(String string, String string2) {
        return string + string2;
    }

    @FunctionalInterface
    @NestHost(value=MappingDataLoader.class)
    public static interface MappingHolderSupplier<T> {
        public T get(int var1);
    }

    @FunctionalInterface
    @NestHost(value=MappingDataLoader.class)
    public static interface AddConsumer<T> {
        public void addTo(T var1, int var2, int var3);
    }

    @FunctionalInterface
    @NestHost(value=MappingDataLoader.class)
    public static interface MappingsSupplier<T extends Mappings, V> {
        public T create(V var1, int var2);
    }
}

