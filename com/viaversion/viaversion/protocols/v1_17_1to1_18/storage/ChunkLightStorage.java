/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.protocols.v1_17_1to1_18.storage;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.minecraft.ChunkPosition;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@NestMembers(value={ChunkLight.class})
public final class ChunkLightStorage
implements StorableObject {
    private final Map<Long, ChunkLight> lightPackets = new HashMap<Long, ChunkLight>();
    private final Set<Long> loadedChunks = new HashSet<Long>();

    public void storeLight(int x2, int z2, ChunkLight chunkLight) {
        this.lightPackets.put(ChunkPosition.chunkKey(x2, z2), chunkLight);
    }

    public @Nullable ChunkLight removeLight(int x2, int z2) {
        return this.lightPackets.remove(ChunkPosition.chunkKey(x2, z2));
    }

    public @Nullable ChunkLight getLight(int x2, int z2) {
        return this.lightPackets.get(ChunkPosition.chunkKey(x2, z2));
    }

    public boolean addLoadedChunk(int x2, int z2) {
        return this.loadedChunks.add(ChunkPosition.chunkKey(x2, z2));
    }

    public boolean isLoaded(int x2, int z2) {
        return this.loadedChunks.contains(ChunkPosition.chunkKey(x2, z2));
    }

    public void clear(int x2, int z2) {
        long index = ChunkPosition.chunkKey(x2, z2);
        this.lightPackets.remove(index);
        this.loadedChunks.remove(index);
    }

    public void clear() {
        this.loadedChunks.clear();
        this.lightPackets.clear();
    }

    @RecordComponents(value={@RecordComponents.Value(name="trustEdges", type=boolean.class), @RecordComponents.Value(name="skyLightMask", type=long[].class), @RecordComponents.Value(name="blockLightMask", type=long[].class), @RecordComponents.Value(name="emptySkyLightMask", type=long[].class), @RecordComponents.Value(name="emptyBlockLightMask", type=long[].class), @RecordComponents.Value(name="skyLight", type=byte[][].class), @RecordComponents.Value(name="blockLight", type=byte[][].class)})
    @NestHost(value=ChunkLightStorage.class)
    public static final class ChunkLight
    extends J_L_Record {
        private final boolean trustEdges;
        private final long[] skyLightMask;
        private final long[] blockLightMask;
        private final long[] emptySkyLightMask;
        private final long[] emptyBlockLightMask;
        private final byte[][] skyLight;
        private final byte[][] blockLight;

        public ChunkLight(boolean trustEdges, long[] skyLightMask, long[] blockLightMask, long[] emptySkyLightMask, long[] emptyBlockLightMask, byte[][] skyLight, byte[][] blockLight) {
            this.trustEdges = trustEdges;
            this.skyLightMask = skyLightMask;
            this.blockLightMask = blockLightMask;
            this.emptySkyLightMask = emptySkyLightMask;
            this.emptyBlockLightMask = emptyBlockLightMask;
            this.skyLight = skyLight;
            this.blockLight = blockLight;
        }

        @Override
        public final String toString() {
            return ChunkLight.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return ChunkLight.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return ChunkLight.jvmdowngrader$equals$equals(this, o2);
        }

        public boolean trustEdges() {
            return this.trustEdges;
        }

        public long[] skyLightMask() {
            return this.skyLightMask;
        }

        public long[] blockLightMask() {
            return this.blockLightMask;
        }

        public long[] emptySkyLightMask() {
            return this.emptySkyLightMask;
        }

        public long[] emptyBlockLightMask() {
            return this.emptyBlockLightMask;
        }

        public byte[][] skyLight() {
            return this.skyLight;
        }

        public byte[][] blockLight() {
            return this.blockLight;
        }

        private static String jvmdowngrader$toString$toString(ChunkLight chunkLight) {
            ChunkLight chunkLight2 = chunkLight;
            return "ChunkLightStorage$ChunkLight[" + "trustEdges=" + chunkLight.trustEdges + ", " + "skyLightMask=" + chunkLight.skyLightMask + ", " + "blockLightMask=" + chunkLight.blockLightMask + ", " + "emptySkyLightMask=" + chunkLight.emptySkyLightMask + ", " + "emptyBlockLightMask=" + chunkLight.emptyBlockLightMask + ", " + "skyLight=" + chunkLight.skyLight + ", " + "blockLight=" + chunkLight.blockLight + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(ChunkLight chunkLight) {
            Object[] objectArray = new Object[]{chunkLight.trustEdges, chunkLight.skyLightMask, chunkLight.blockLightMask, chunkLight.emptySkyLightMask, chunkLight.emptyBlockLightMask, chunkLight.skyLight, chunkLight.blockLight};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(ChunkLight chunkLight, Object object) {
            if (chunkLight == object) {
                return true;
            }
            if (object != null && object instanceof ChunkLight) {
                ChunkLight chunkLight2 = (ChunkLight)object;
                if (chunkLight.trustEdges == chunkLight2.trustEdges && Objects.equals(chunkLight.skyLightMask, chunkLight2.skyLightMask) && Objects.equals(chunkLight.blockLightMask, chunkLight2.blockLightMask) && Objects.equals(chunkLight.emptySkyLightMask, chunkLight2.emptySkyLightMask) && Objects.equals(chunkLight.emptyBlockLightMask, chunkLight2.emptyBlockLightMask) && Objects.equals(chunkLight.skyLight, chunkLight2.skyLight) && Objects.equals(chunkLight.blockLight, chunkLight2.blockLight)) {
                    return true;
                }
            }
            return false;
        }
    }
}

