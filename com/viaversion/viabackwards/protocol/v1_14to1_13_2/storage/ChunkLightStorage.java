/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viabackwards.protocol.v1_14to1_13_2.storage;

import ViaBackwards.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.connection.StorableObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@NestMembers(value={ChunkLight.class})
public class ChunkLightStorage
implements StorableObject {
    public static final byte[] FULL_LIGHT = new byte[2048];
    public static final byte[] EMPTY_LIGHT = new byte[2048];
    private static Constructor<?> fastUtilLongObjectHashMap;
    private final Map<Long, ChunkLight> storedLight = this.createLongObjectMap();

    public void setStoredLight(byte[][] skyLight, byte[][] blockLight, int x2, int z2) {
        this.storedLight.put(this.getChunkSectionIndex(x2, z2), new ChunkLight(skyLight, blockLight));
    }

    public ChunkLight getStoredLight(int x2, int z2) {
        return this.storedLight.get(this.getChunkSectionIndex(x2, z2));
    }

    public void clear() {
        this.storedLight.clear();
    }

    public void unloadChunk(int x2, int z2) {
        this.storedLight.remove(this.getChunkSectionIndex(x2, z2));
    }

    private long getChunkSectionIndex(int x2, int z2) {
        return ((long)x2 & 0x3FFFFFFL) << 38 | (long)z2 & 0x3FFFFFFL;
    }

    private Map<Long, ChunkLight> createLongObjectMap() {
        if (fastUtilLongObjectHashMap != null) {
            try {
                return (Map)fastUtilLongObjectHashMap.newInstance(new Object[0]);
            }
            catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
        return new HashMap<Long, ChunkLight>();
    }

    static {
        Arrays.fill(FULL_LIGHT, (byte)-1);
        Arrays.fill(EMPTY_LIGHT, (byte)0);
        try {
            fastUtilLongObjectHashMap = Class.forName("com.viaversion.viaversion.libs.fastutil.longs.Long2ObjectOpenHashMap").getConstructor(new Class[0]);
        }
        catch (ClassNotFoundException | NoSuchMethodException reflectiveOperationException) {
            // empty catch block
        }
    }

    @RecordComponents(value={@RecordComponents.Value(name="skyLight", type=byte[][].class), @RecordComponents.Value(name="blockLight", type=byte[][].class)})
    @NestHost(value=ChunkLightStorage.class)
    public static final class ChunkLight
    extends J_L_Record {
        private final byte[][] skyLight;
        private final byte[][] blockLight;

        public ChunkLight(byte[][] skyLight, byte[][] blockLight) {
            this.skyLight = skyLight;
            this.blockLight = blockLight;
        }

        @Override
        public boolean equals(Object o2) {
            if (this == o2) {
                return true;
            }
            if (o2 == null || this.getClass() != o2.getClass()) {
                return false;
            }
            ChunkLight that = (ChunkLight)o2;
            if (!Arrays.deepEquals((Object[])this.skyLight, (Object[])that.skyLight)) {
                return false;
            }
            return Arrays.deepEquals((Object[])this.blockLight, (Object[])that.blockLight);
        }

        @Override
        public int hashCode() {
            int result = Arrays.deepHashCode((Object[])this.skyLight);
            result = 31 * result + Arrays.deepHashCode((Object[])this.blockLight);
            return result;
        }

        @Override
        public final String toString() {
            return ChunkLight.jvmdowngrader$toString$toString(this);
        }

        public byte[][] skyLight() {
            return this.skyLight;
        }

        public byte[][] blockLight() {
            return this.blockLight;
        }

        private static String jvmdowngrader$toString$toString(ChunkLight chunkLight) {
            ChunkLight chunkLight2 = chunkLight;
            return "ChunkLightStorage$ChunkLight[" + "skyLight=" + chunkLight.skyLight + ", " + "blockLight=" + chunkLight.blockLight + "]";
        }
    }
}

