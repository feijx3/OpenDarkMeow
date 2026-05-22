/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.viaversion.viaversion.libs.mcstructs.converter;

import com.viaversion.viaversion.libs.mcstructs.converter.codec.Codec;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

public interface DataConverter<T> {
    public <N> N convertTo(DataConverter<N> var1, @Nullable T var2);

    default public <N> T convertFrom(DataConverter<N> converter, @Nullable N element) {
        return (T)converter.convertTo(this, element);
    }

    default public <N> N convertList(DataConverter<N> to, T list) {
        List in = this.asList(list).orElse(new ArrayList());
        ArrayList<N> out = new ArrayList<N>();
        for (Object element : in) {
            out.add(this.convertTo(to, element));
        }
        return to.createList(out);
    }

    default public <N> N convertMap(DataConverter<N> to, T map) {
        Map in = this.asMap(map).orElse(new HashMap());
        HashMap<N, N> out = new HashMap<N, N>();
        for (Map.Entry entry : in.entrySet()) {
            out.put(this.convertTo(to, entry.getKey()), this.convertTo(to, entry.getValue()));
        }
        return to.createUnsafeMap(out);
    }

    default public T empty() {
        return null;
    }

    public T createBoolean(boolean var1);

    public Result<Boolean> asBoolean(T var1);

    public T createNumber(Number var1);

    public Result<Number> asNumber(T var1);

    default public T createByte(byte value) {
        return this.createNumber(value);
    }

    default public T createShort(short value) {
        return this.createNumber(value);
    }

    default public T createInt(int value) {
        return this.createNumber(value);
    }

    default public T createLong(long value) {
        return this.createNumber(value);
    }

    default public T createFloat(float value) {
        return this.createNumber(Float.valueOf(value));
    }

    default public T createDouble(double value) {
        return this.createNumber(value);
    }

    public T createString(String var1);

    public Result<String> asString(T var1);

    default public T createList(List<T> values) {
        return this.mergeList((T)null, values).get();
    }

    default public T emptyList() {
        return this.createList(Collections.emptyList());
    }

    public Result<T> mergeList(@Nullable T var1, List<T> var2);

    default public Result<T> mergeList(@Nullable T list, T ... values) {
        return this.mergeList(list, Arrays.asList(values));
    }

    public Result<List<T>> asList(T var1);

    public T createUnsafeMap(Map<T, T> var1);

    default public T emptyMap() {
        return (T)this.createUnsafeMap(Collections.emptyMap());
    }

    default public Result<T> createMergedMap(Map<T, T> values) {
        T map = this.emptyMap();
        for (Map.Entry<T, T> entry : values.entrySet()) {
            Result<T> mergedMap = this.mergeMap(map, entry.getKey(), entry.getValue());
            if (mergedMap.isError()) {
                return mergedMap;
            }
            map = mergedMap.get();
        }
        return Result.success(map);
    }

    public Result<T> mergeMap(@Nullable T var1, Map<T, T> var2);

    default public Result<T> mergeMap(@Nullable T map, T key, T value) {
        return this.mergeMap(map, Collections.singletonMap(key, value));
    }

    default public Result<T> mergeMap(@Nullable T map, T ... keyValue) {
        if (keyValue.length % 2 != 0) {
            return Result.error("Key-Value pairs must be even");
        }
        HashMap<T, T> mapValues = new HashMap<T, T>();
        for (int i2 = 0; i2 < keyValue.length; i2 += 2) {
            mapValues.put(keyValue[i2], keyValue[i2 + 1]);
        }
        return this.mergeMap(map, (Map<T, T>)mapValues);
    }

    public Result<Map<T, T>> asMap(T var1);

    public Result<Map<String, T>> asStringTypeMap(T var1);

    public T createByteArray(byte[] var1);

    public Result<byte[]> asByteArray(T var1);

    public T createIntArray(int[] var1);

    public Result<int[]> asIntArray(T var1);

    public T createLongArray(long[] var1);

    public Result<long[]> asLongArray(T var1);

    default public Codec<T> toCodec() {
        return new Codec<T>(){

            @Override
            public <S> Result<T> deserialize(DataConverter<S> converter, S data) {
                try {
                    return Result.success(DataConverter.this.fork(converter).convertTo(DataConverter.this, data));
                }
                catch (Throwable t2) {
                    return Result.error(t2);
                }
            }

            @Override
            public <S> Result<S> serialize(DataConverter<S> converter, T element) {
                try {
                    return Result.success(converter.fork(converter).convertFrom(DataConverter.this, element));
                }
                catch (Throwable t2) {
                    return Result.error(t2);
                }
            }
        };
    }

    default public <O> DataConverter<O> fork(DataConverter<O> other) {
        return other;
    }
}

