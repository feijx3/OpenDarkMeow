/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.mapcodec;

import com.viaversion.viaversion.libs.mcstructs.converter.DataConverter;
import com.viaversion.viaversion.libs.mcstructs.converter.codec.Codec;
import com.viaversion.viaversion.libs.mcstructs.converter.codec.ThrowingFunction;
import com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.MapDeserializer;
import com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.MapSerializer;
import com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.impl.FieldMapCodec;
import com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.impl.RecursiveMapCodec;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public interface MapCodec<T>
extends MapSerializer<T>,
MapDeserializer<T> {
    public static final MapCodec<Boolean> UNIT = MapCodec.unit(() -> true);

    public static <N> MapCodec<N> unit(final Supplier<N> supplier) {
        return new MapCodec<N>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> converter, Map<S, S> map, N element) {
                return Result.success(map);
            }

            @Override
            public <S> Result<N> deserialize(DataConverter<S> converter, Map<S, S> map) {
                return Result.success(supplier.get());
            }
        };
    }

    public static <N> MapCodec<N> failing(final String error) {
        return new MapCodec<N>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> converter, Map<S, S> map, N element) {
                return Result.error(error);
            }

            @Override
            public <S> Result<N> deserialize(DataConverter<S> converter, Map<S, S> map) {
                return Result.error(error);
            }
        };
    }

    public static <N> MapCodec<N> requiredKey(Codec<N> codec, String fieldName) {
        return new FieldMapCodec<N>(codec, fieldName, false, false);
    }

    public static <N> MapCodec<N> optionalKey(Codec<N> codec, String fieldName) {
        return new FieldMapCodec<N>(codec, fieldName, true, false);
    }

    public static <N> MapCodec<N> optionalLenientKey(Codec<N> codec, String fieldName) {
        return new FieldMapCodec<N>(codec, fieldName, true, true);
    }

    public static <T> MapCodec<T> recursive(Function<Codec<T>, MapCodec<T>> creator) {
        return new RecursiveMapCodec<T>(creator);
    }

    public static <T> MapCodec<T> lazyInit(final Supplier<MapCodec<T>> supplier) {
        return new MapCodec<T>(){
            private MapCodec<T> codec;

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> converter, Map<S, S> map, T element) {
                if (this.codec == null) {
                    this.codec = (MapCodec)supplier.get();
                }
                return this.codec.serialize(converter, map, element);
            }

            @Override
            public <S> Result<T> deserialize(DataConverter<S> converter, Map<S, S> map) {
                if (this.codec == null) {
                    this.codec = (MapCodec)supplier.get();
                }
                return this.codec.deserialize(converter, map);
            }
        };
    }

    default public FieldMapCodec.Builder.Stage1<T> field(String fieldName) {
        return this.asCodec().mapCodec(fieldName);
    }

    default public <N> MapCodec<N> map(final Function<N, T> serializer, final Function<T, N> deserializer) {
        return new MapCodec<N>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> converter, Map<S, S> map, N element) {
                return MapCodec.this.serialize(converter, map, serializer.apply(element));
            }

            @Override
            public <S> Result<N> deserialize(DataConverter<S> converter, Map<S, S> map) {
                return MapCodec.this.deserialize(converter, map).map(deserializer);
            }
        };
    }

    default public <N> MapCodec<N> mapThrowing(final ThrowingFunction<N, T> serializer, final ThrowingFunction<T, N> deserializer) {
        return new MapCodec<N>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> converter, Map<S, S> map, N element) {
                try {
                    return MapCodec.this.serialize(converter, map, serializer.apply(element));
                }
                catch (Throwable t2) {
                    return Result.error(t2);
                }
            }

            @Override
            public <S> Result<N> deserialize(DataConverter<S> converter, Map<S, S> map) {
                return MapCodec.this.deserialize(converter, map).mapResult(t2 -> {
                    try {
                        return Result.success(deserializer.apply(t2));
                    }
                    catch (Throwable t22) {
                        return Result.error(t22);
                    }
                });
            }
        };
    }

    default public MapCodec<T> defaulted(T defaultValue) {
        return this.map(value -> Objects.equals(value, defaultValue) ? null : value, value -> value == null ? defaultValue : value);
    }

    default public MapCodec<T> defaulted(Predicate<T> isDefault, Supplier<T> defaultValue) {
        return this.map(value -> isDefault.test(value) ? null : value, value -> value == null ? defaultValue.get() : value);
    }

    default public MapCodec<T> elseGet(Supplier<T> defaultSupplier) {
        return this.map(value -> value, value -> value == null ? defaultSupplier.get() : value);
    }

    default public Codec<T> asCodec() {
        return new Codec<T>(){

            @Override
            public <S> Result<S> serialize(DataConverter<S> converter, T element) {
                HashMap map = new HashMap();
                Result<Map<S, S>> result = MapCodec.this.serialize(converter, map, element);
                return result.mapResult(converter::createMergedMap);
            }

            @Override
            public <S> Result<T> deserialize(DataConverter<S> converter, S data) {
                Result<Map<S, S>> map = converter.asMap(data);
                if (map.isError()) {
                    return map.mapError();
                }
                return MapCodec.this.deserialize(converter, map.get());
            }
        };
    }
}

