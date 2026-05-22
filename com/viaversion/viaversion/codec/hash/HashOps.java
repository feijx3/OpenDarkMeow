/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.codec.hash;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.minecraft.codec.CodecContext;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.minecraft.codec.ThrowingOps;
import com.viaversion.viaversion.api.minecraft.codec.hash.Hasher;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.codec.OpsBase;
import com.viaversion.viaversion.codec.hash.HashBuilder;
import com.viaversion.viaversion.codec.hash.HashFunction;
import com.viaversion.viaversion.libs.fastutil.ints.IntArrayList;
import com.viaversion.viaversion.libs.fastutil.ints.IntList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@NestMembers(value={ListHashBuilder.class, MapHashBuilder.class, MapHashBuilder.Entry.class, MapHashBuilder.1.class, CollectionHashBuilder.class})
public class HashOps
extends OpsBase
implements Hasher {
    private static final byte TAG_MAP_START = 2;
    private static final byte TAG_MAP_END = 3;
    private static final byte TAG_LIST_START = 4;
    private static final byte TAG_LIST_END = 5;
    private static final byte TAG_BYTE = 6;
    private static final byte TAG_SHORT = 7;
    private static final byte TAG_INT = 8;
    private static final byte TAG_LONG = 9;
    private static final byte TAG_FLOAT = 10;
    private static final byte TAG_DOUBLE = 11;
    private static final byte TAG_STRING = 12;
    private static final byte TAG_BOOLEAN = 13;
    private static final byte TAG_BYTE_ARRAY_START = 14;
    private static final byte TAG_BYTE_ARRAY_END = 15;
    private static final byte TAG_INT_ARRAY_START = 16;
    private static final byte TAG_INT_ARRAY_END = 17;
    private static final byte TAG_LONG_ARRAY_START = 18;
    private static final byte TAG_LONG_ARRAY_END = 19;
    static final byte[] FALSE = new byte[]{13, 0};
    static final byte[] TRUE = new byte[]{13, 1};
    static final byte[] EMPTY_LIST = new byte[]{4, 5};
    static final byte[] EMPTY_MAP = new byte[]{2, 3};
    private final HashBuilder hashBuilder;

    public HashOps(CodecContext context, HashFunction hashFunction) {
        super(context);
        this.hashBuilder = new HashBuilder(hashFunction);
    }

    @Override
    public void writeByte(byte b2) {
        this.hashBuilder.preSize(2).writeByte((byte)6).writeByte(b2);
    }

    @Override
    public void writeBytes(byte[] array) {
        this.hashBuilder.preSize(array.length + 2).writeByte((byte)14).writeBytes(array).writeByte((byte)15);
    }

    @Override
    public void writeBoolean(boolean b2) {
        this.hashBuilder.writeBytesDirect(b2 ? TRUE : FALSE);
    }

    @Override
    public void writeShort(short s2) {
        this.hashBuilder.preSize(3).writeByte((byte)7).writeShort(s2);
    }

    @Override
    public void writeString(CharSequence sequence) {
        this.hashBuilder.preSize(sequence.length() + 1 + 4).writeByte((byte)12).writeInt(sequence.length()).writeString(sequence);
    }

    @Override
    public void writeInt(int i2) {
        this.hashBuilder.preSize(5).writeByte((byte)8).writeInt(i2);
    }

    @Override
    public void writeLong(long l2) {
        this.hashBuilder.preSize(9).writeByte((byte)9).writeLong(l2);
    }

    @Override
    public void writeFloat(float f2) {
        this.hashBuilder.preSize(5).writeByte((byte)10).writeFloat(f2);
    }

    @Override
    public void writeDouble(double d2) {
        this.hashBuilder.preSize(9).writeByte((byte)11).writeDouble(d2);
    }

    @Override
    public void writeInts(int[] array) {
        this.hashBuilder.preSize(array.length * 4 + 2);
        this.hashBuilder.writeByte((byte)16);
        for (int i2 : array) {
            this.hashBuilder.writeInt(i2);
        }
        this.hashBuilder.writeByte((byte)17);
    }

    @Override
    public void writeLongs(long[] array) {
        this.hashBuilder.preSize(array.length * 8 + 2);
        this.hashBuilder.writeByte((byte)18);
        for (long l2 : array) {
            this.hashBuilder.writeLong(l2);
        }
        this.hashBuilder.writeByte((byte)19);
    }

    @Override
    public void writeList(Consumer<Ops.ListSerializer> consumer) {
        ListHashBuilder listHasher = new ListHashBuilder();
        consumer.accept(listHasher);
        listHasher.applyHashToParent();
    }

    @Override
    public void writeMap(Consumer<Ops.MapSerializer> consumer) {
        MapHashBuilder mapHasher = new MapHashBuilder();
        consumer.accept(mapHasher);
        mapHasher.applyHashToParent();
    }

    @Override
    public <V> void write(Type<V> type, V value) {
        type.write(this, value);
    }

    @Override
    public int hash() {
        return this.hashBuilder.hash();
    }

    @Override
    public void reset() {
        this.hashBuilder.reset();
    }

    public HashBuilder jvmdowngrader$nest$com_viaversion_viaversion_codec_hash_HashOps$get$hashBuilder() {
        return this.hashBuilder;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_codec_hash_HashOps$set$hashBuilder(HashBuilder hashBuilder) {
        this.hashBuilder = hashBuilder;
    }

    @NestHost(value=HashOps.class)
    private final class ListHashBuilder
    extends CollectionHashBuilder
    implements Ops.ListSerializer {
        private final IntList entries;

        ListHashBuilder() {
            this.entries = new IntArrayList();
        }

        public <T> Ops.ListSerializer write(Type<T> valueType, T value) {
            this.entries.add(this.hash(valueType, value));
            return this;
        }

        @Override
        public Ops.ListSerializer writeList(Consumer<Ops.ListSerializer> consumer) {
            this.entries.add(this.listHash(consumer));
            return this;
        }

        @Override
        public Ops.ListSerializer writeMap(Consumer<Ops.MapSerializer> consumer) {
            this.entries.add(this.mapHash(consumer));
            return this;
        }

        public void applyHashToParent() {
            if (this.entries.isEmpty()) {
                HashOps.this.jvmdowngrader$nest$com_viaversion_viaversion_codec_hash_HashOps$get$hashBuilder().writeBytesDirect(EMPTY_LIST);
                return;
            }
            int size = this.entries.size();
            HashOps.this.jvmdowngrader$nest$com_viaversion_viaversion_codec_hash_HashOps$get$hashBuilder().preSize(size * 4 + 2);
            HashOps.this.jvmdowngrader$nest$com_viaversion_viaversion_codec_hash_HashOps$get$hashBuilder().writeByte((byte)4);
            for (int i2 = 0; i2 < size; ++i2) {
                HashOps.this.jvmdowngrader$nest$com_viaversion_viaversion_codec_hash_HashOps$get$hashBuilder().writeInt(this.entries.getInt(i2));
            }
            HashOps.this.jvmdowngrader$nest$com_viaversion_viaversion_codec_hash_HashOps$get$hashBuilder().writeByte((byte)5);
        }
    }

    @NestHost(value=HashOps.class)
    private final class MapHashBuilder
    extends CollectionHashBuilder
    implements Ops.MapSerializer {
        private final List<Entry> entries;

        MapHashBuilder() {
            this.entries = new ArrayList<Entry>();
        }

        public <K, T> Ops.MapSerializer write(Type<K> keyType, K key, Type<T> valueType, T value) {
            this.entries.add(new Entry(this.hash(keyType, key), this.hash(valueType, value)));
            return this;
        }

        @Override
        public Ops.MapSerializer writeList(String key, Consumer<Ops.ListSerializer> consumer) {
            this.entries.add(new Entry(this.hash(Types.STRING, key), this.listHash(consumer)));
            return this;
        }

        @Override
        public Ops.MapSerializer writeMap(String key, Consumer<Ops.MapSerializer> consumer) {
            this.entries.add(new Entry(this.hash(Types.STRING, key), this.mapHash(consumer)));
            return this;
        }

        @Override
        public <T> Ops.MapSerializer writeInlinedMap(Type<T> valueType, T value) {
            valueType.write(new ThrowingOps(){

                @Override
                public void writeMap(Consumer<Ops.MapSerializer> consumer) {
                    consumer.accept(MapHashBuilder.this);
                }
            }, value);
            return this;
        }

        public void applyHashToParent() {
            if (this.entries.isEmpty()) {
                HashOps.this.jvmdowngrader$nest$com_viaversion_viaversion_codec_hash_HashOps$get$hashBuilder().writeBytesDirect(EMPTY_MAP);
                return;
            }
            int size = this.entries.size();
            HashOps.this.jvmdowngrader$nest$com_viaversion_viaversion_codec_hash_HashOps$get$hashBuilder().preSize(size * 4 * 2 + 2);
            HashOps.this.jvmdowngrader$nest$com_viaversion_viaversion_codec_hash_HashOps$get$hashBuilder().writeByte((byte)2);
            this.entries.sort(Comparator.naturalOrder());
            for (int i2 = 0; i2 < size; ++i2) {
                Entry entry = this.entries.get(i2);
                HashOps.this.jvmdowngrader$nest$com_viaversion_viaversion_codec_hash_HashOps$get$hashBuilder().writeInt(entry.jvmdowngrader$nest$com_viaversion_viaversion_codec_hash_HashOps$MapHashBuilder$Entry$get$key());
                HashOps.this.jvmdowngrader$nest$com_viaversion_viaversion_codec_hash_HashOps$get$hashBuilder().writeInt(entry.jvmdowngrader$nest$com_viaversion_viaversion_codec_hash_HashOps$MapHashBuilder$Entry$get$value());
            }
            HashOps.this.jvmdowngrader$nest$com_viaversion_viaversion_codec_hash_HashOps$get$hashBuilder().writeByte((byte)3);
        }

        @RecordComponents(value={@RecordComponents.Value(name="key", type=int.class), @RecordComponents.Value(name="value", type=int.class)})
        @NestHost(value=HashOps.class)
        private static final class Entry
        extends J_L_Record
        implements Comparable<Entry> {
            private final int key;
            private final int value;

            Entry(int key, int value) {
                this.key = key;
                this.value = value;
            }

            @Override
            public int compareTo(Entry o2) {
                if (this.key != o2.key) {
                    return Long.compare(Entry.padToLong(this.key), Entry.padToLong(o2.key));
                }
                return Long.compare(Entry.padToLong(this.value), Entry.padToLong(o2.value));
            }

            private static long padToLong(int value) {
                return (long)value & 0xFFFFFFFFL;
            }

            @Override
            public final String toString() {
                return Entry.jvmdowngrader$toString$toString(this);
            }

            @Override
            public final int hashCode() {
                return Entry.jvmdowngrader$hashCode$hashCode(this);
            }

            @Override
            public final boolean equals(Object o2) {
                return Entry.jvmdowngrader$equals$equals(this, o2);
            }

            public int key() {
                return this.key;
            }

            public int value() {
                return this.value;
            }

            private static String jvmdowngrader$toString$toString(Entry entry) {
                Entry entry2 = entry;
                return "HashOps$MapHashBuilder$Entry[" + "key=" + entry.key + ", " + "value=" + entry.value + "]";
            }

            private static int jvmdowngrader$hashCode$hashCode(Entry entry) {
                Object[] objectArray = new Object[]{entry.key, entry.value};
                return Arrays.hashCode(objectArray);
            }

            private static boolean jvmdowngrader$equals$equals(Entry entry, Object object) {
                if (entry == object) {
                    return true;
                }
                if (object != null && object instanceof Entry) {
                    Entry entry2 = (Entry)object;
                    if (entry.key == entry2.key && entry.value == entry2.value) {
                        return true;
                    }
                }
                return false;
            }

            public int jvmdowngrader$nest$com_viaversion_viaversion_codec_hash_HashOps$MapHashBuilder$Entry$get$value() {
                return this.value;
            }

            public void jvmdowngrader$nest$com_viaversion_viaversion_codec_hash_HashOps$MapHashBuilder$Entry$set$value(int n2) {
                this.value = n2;
            }

            public int jvmdowngrader$nest$com_viaversion_viaversion_codec_hash_HashOps$MapHashBuilder$Entry$get$key() {
                return this.key;
            }

            public void jvmdowngrader$nest$com_viaversion_viaversion_codec_hash_HashOps$MapHashBuilder$Entry$set$key(int n2) {
                this.key = n2;
            }
        }
    }

    @NestHost(value=HashOps.class)
    private abstract class CollectionHashBuilder {
        protected final HashOps hasher;

        CollectionHashBuilder() {
            this.hasher = new HashOps(HashOps.this.context(), HashOps.this.jvmdowngrader$nest$com_viaversion_viaversion_codec_hash_HashOps$get$hashBuilder().function());
        }

        protected int listHash(Consumer<Ops.ListSerializer> consumer) {
            this.hasher.reset();
            ListHashBuilder listHasher = this.hasher.new ListHashBuilder();
            consumer.accept(listHasher);
            listHasher.applyHashToParent();
            return HashOps.this.hash();
        }

        protected int mapHash(Consumer<Ops.MapSerializer> consumer) {
            this.hasher.reset();
            MapHashBuilder mapHasher = this.hasher.new MapHashBuilder();
            consumer.accept(mapHasher);
            mapHasher.applyHashToParent();
            return HashOps.this.hash();
        }

        protected <V> int hash(Type<V> type, V value) {
            this.hasher.reset();
            type.write(this.hasher, value);
            return this.hasher.hash();
        }
    }
}

