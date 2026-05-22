/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.api.minecraft.chunks;

import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntOpenHashMap;
import com.viaversion.viaversion.libs.fastutil.ints.IntArrayList;
import com.viaversion.viaversion.libs.fastutil.ints.IntList;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={ShortChunkData.class, ByteChunkData.class, EmptyChunkData.class, ChunkData.class})
public final class DataPaletteImpl
implements DataPalette {
    private static final int DEFAULT_INITIAL_SIZE = 16;
    private final IntList palette;
    private final Int2IntMap inversePalette;
    private final int sizeBits;
    private ChunkData values;

    public DataPaletteImpl(int valuesLength) {
        this(valuesLength, 16);
    }

    public DataPaletteImpl(int valuesLength, int initialSize) {
        this.values = new EmptyChunkData(valuesLength);
        this.sizeBits = Integer.numberOfTrailingZeros(valuesLength) / 3;
        this.palette = new IntArrayList(initialSize);
        this.inversePalette = new Int2IntOpenHashMap((int)((float)initialSize * 0.75f));
        this.inversePalette.defaultReturnValue(-1);
    }

    @Override
    public int index(int x2, int y2, int z2) {
        return (y2 << this.sizeBits | z2) << this.sizeBits | x2;
    }

    @Override
    public int idAt(int sectionCoordinate) {
        int index = this.values.get(sectionCoordinate);
        return this.palette.getInt(index);
    }

    @Override
    public void setIdAt(int sectionCoordinate, int id) {
        int index = this.inversePalette.get(id);
        if (index == -1) {
            index = this.palette.size();
            this.palette.add(id);
            this.inversePalette.put(id, index);
        }
        this.values.set(sectionCoordinate, index);
    }

    @Override
    public int paletteIndexAt(int packedCoordinate) {
        return this.values.get(packedCoordinate);
    }

    @Override
    public void setPaletteIndexAt(int sectionCoordinate, int index) {
        this.values.set(sectionCoordinate, index);
    }

    @Override
    public int size() {
        return this.palette.size();
    }

    @Override
    public int idByIndex(int index) {
        return this.palette.getInt(index);
    }

    @Override
    public void setIdByIndex(int index, int id) {
        int oldId = this.palette.set(index, id);
        if (oldId == id) {
            return;
        }
        this.inversePalette.put(id, index);
        if (this.inversePalette.get(oldId) == index) {
            this.inversePalette.remove(oldId);
            for (int i2 = 0; i2 < this.palette.size(); ++i2) {
                if (this.palette.getInt(i2) != oldId) continue;
                this.inversePalette.put(oldId, i2);
                break;
            }
        }
    }

    @Override
    public void replaceId(int oldId, int newId) {
        int index = this.inversePalette.remove(oldId);
        if (index == -1) {
            return;
        }
        this.inversePalette.put(newId, index);
        for (int i2 = 0; i2 < this.palette.size(); ++i2) {
            if (this.palette.getInt(i2) != oldId) continue;
            this.palette.set(i2, newId);
        }
    }

    @Override
    public void addId(int id) {
        this.inversePalette.put(id, this.palette.size());
        this.palette.add(id);
    }

    @Override
    public void clear() {
        this.palette.clear();
        this.inversePalette.clear();
    }

    public ChunkData jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_chunks_DataPaletteImpl$get$values() {
        return this.values;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_chunks_DataPaletteImpl$set$values(ChunkData chunkData) {
        this.values = chunkData;
    }

    @NestHost(value=DataPaletteImpl.class)
    private class EmptyChunkData
    implements ChunkData {
        private final int size;

        public EmptyChunkData(int size) {
            this.size = size;
        }

        @Override
        public int get(int idx) {
            return 0;
        }

        @Override
        public void set(int idx, int val) {
            if (val != 0) {
                DataPaletteImpl.this.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_chunks_DataPaletteImpl$set$values(new ByteChunkData(this.size));
                DataPaletteImpl.this.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_chunks_DataPaletteImpl$get$values().set(idx, val);
            }
        }
    }

    @NestHost(value=DataPaletteImpl.class)
    static interface ChunkData {
        public int get(int var1);

        public void set(int var1, int var2);
    }

    @NestHost(value=DataPaletteImpl.class)
    private static class ShortChunkData
    implements ChunkData {
        private final short[] data;

        public ShortChunkData(byte[] data) {
            this.data = new short[data.length];
            for (int i2 = 0; i2 < data.length; ++i2) {
                this.data[i2] = (short)(data[i2] & 0xFF);
            }
        }

        @Override
        public int get(int idx) {
            return this.data[idx];
        }

        @Override
        public void set(int idx, int val) {
            this.data[idx] = (short)val;
        }
    }

    @NestHost(value=DataPaletteImpl.class)
    private class ByteChunkData
    implements ChunkData {
        private final byte[] data;

        public ByteChunkData(int size) {
            this.data = new byte[size];
        }

        @Override
        public int get(int idx) {
            return this.data[idx] & 0xFF;
        }

        @Override
        public void set(int idx, int val) {
            if (val > 255) {
                DataPaletteImpl.this.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_chunks_DataPaletteImpl$set$values(new ShortChunkData(this.data));
                DataPaletteImpl.this.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_chunks_DataPaletteImpl$get$values().set(idx, val);
                return;
            }
            this.data[idx] = (byte)val;
        }
    }
}

