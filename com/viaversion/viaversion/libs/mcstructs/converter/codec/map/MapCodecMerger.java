/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.codec.map;

import com.viaversion.viaversion.libs.mcstructs.converter.DataConverter;
import com.viaversion.viaversion.libs.mcstructs.converter.codec.Codec;
import com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.MapCodec;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import java.util.Map;
import java.util.function.Function;

public class MapCodecMerger {
    public static <T1, O> MapCodec<O> mapCodec(final MapCodec<T1> codec1, final Function<O, T1> getter1, final I1<T1, O> constructor) {
        return new MapCodec<O>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> converter, Map<S, S> map, O element) {
                Result<Map<S, S>> result = codec1.serialize(converter, map, getter1.apply(element));
                if (result.isError()) {
                    return result.mapError();
                }
                return result;
            }

            @Override
            public <S> Result<O> deserialize(DataConverter<S> converter, Map<S, S> map) {
                Result result1 = codec1.deserialize(converter, map);
                if (result1.isError()) {
                    return result1.mapError();
                }
                return Result.success(constructor.apply(result1.get()));
            }
        };
    }

    public static <T1, O> Codec<O> codec(MapCodec<T1> codec1, Function<O, T1> getter1, I1<T1, O> constructor) {
        return MapCodecMerger.mapCodec(codec1, getter1, constructor).asCodec();
    }

    public static <T1, T2, O> MapCodec<O> mapCodec(final MapCodec<T1> codec1, final Function<O, T1> getter1, final MapCodec<T2> codec2, final Function<O, T2> getter2, final I2<T1, T2, O> constructor) {
        return new MapCodec<O>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> converter, Map<S, S> map, O element) {
                Result<Map<S, S>> result = codec1.serialize(converter, map, getter1.apply(element));
                if (result.isError()) {
                    return result.mapError();
                }
                if ((result = codec2.serialize(converter, result.get(), getter2.apply(element))).isError()) {
                    return result.mapError();
                }
                return result;
            }

            @Override
            public <S> Result<O> deserialize(DataConverter<S> converter, Map<S, S> map) {
                Result result1 = codec1.deserialize(converter, map);
                if (result1.isError()) {
                    return result1.mapError();
                }
                Result result2 = codec2.deserialize(converter, map);
                if (result2.isError()) {
                    return result2.mapError();
                }
                return Result.success(constructor.apply(result1.get(), result2.get()));
            }
        };
    }

    public static <T1, T2, O> Codec<O> codec(MapCodec<T1> codec1, Function<O, T1> getter1, MapCodec<T2> codec2, Function<O, T2> getter2, I2<T1, T2, O> constructor) {
        return MapCodecMerger.mapCodec(codec1, getter1, codec2, getter2, constructor).asCodec();
    }

    public static <T1, T2, T3, O> MapCodec<O> mapCodec(final MapCodec<T1> codec1, final Function<O, T1> getter1, final MapCodec<T2> codec2, final Function<O, T2> getter2, final MapCodec<T3> codec3, final Function<O, T3> getter3, final I3<T1, T2, T3, O> constructor) {
        return new MapCodec<O>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> converter, Map<S, S> map, O element) {
                Result<Map<S, S>> result = codec1.serialize(converter, map, getter1.apply(element));
                if (result.isError()) {
                    return result.mapError();
                }
                if ((result = codec2.serialize(converter, result.get(), getter2.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec3.serialize(converter, result.get(), getter3.apply(element))).isError()) {
                    return result.mapError();
                }
                return result;
            }

            @Override
            public <S> Result<O> deserialize(DataConverter<S> converter, Map<S, S> map) {
                Result result1 = codec1.deserialize(converter, map);
                if (result1.isError()) {
                    return result1.mapError();
                }
                Result result2 = codec2.deserialize(converter, map);
                if (result2.isError()) {
                    return result2.mapError();
                }
                Result result3 = codec3.deserialize(converter, map);
                if (result3.isError()) {
                    return result3.mapError();
                }
                return Result.success(constructor.apply(result1.get(), result2.get(), result3.get()));
            }
        };
    }

    public static <T1, T2, T3, O> Codec<O> codec(MapCodec<T1> codec1, Function<O, T1> getter1, MapCodec<T2> codec2, Function<O, T2> getter2, MapCodec<T3> codec3, Function<O, T3> getter3, I3<T1, T2, T3, O> constructor) {
        return MapCodecMerger.mapCodec(codec1, getter1, codec2, getter2, codec3, getter3, constructor).asCodec();
    }

    public static <T1, T2, T3, T4, O> MapCodec<O> mapCodec(final MapCodec<T1> codec1, final Function<O, T1> getter1, final MapCodec<T2> codec2, final Function<O, T2> getter2, final MapCodec<T3> codec3, final Function<O, T3> getter3, final MapCodec<T4> codec4, final Function<O, T4> getter4, final I4<T1, T2, T3, T4, O> constructor) {
        return new MapCodec<O>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> converter, Map<S, S> map, O element) {
                Result<Map<S, S>> result = codec1.serialize(converter, map, getter1.apply(element));
                if (result.isError()) {
                    return result.mapError();
                }
                if ((result = codec2.serialize(converter, result.get(), getter2.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec3.serialize(converter, result.get(), getter3.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec4.serialize(converter, result.get(), getter4.apply(element))).isError()) {
                    return result.mapError();
                }
                return result;
            }

            @Override
            public <S> Result<O> deserialize(DataConverter<S> converter, Map<S, S> map) {
                Result result1 = codec1.deserialize(converter, map);
                if (result1.isError()) {
                    return result1.mapError();
                }
                Result result2 = codec2.deserialize(converter, map);
                if (result2.isError()) {
                    return result2.mapError();
                }
                Result result3 = codec3.deserialize(converter, map);
                if (result3.isError()) {
                    return result3.mapError();
                }
                Result result4 = codec4.deserialize(converter, map);
                if (result4.isError()) {
                    return result4.mapError();
                }
                return Result.success(constructor.apply(result1.get(), result2.get(), result3.get(), result4.get()));
            }
        };
    }

    public static <T1, T2, T3, T4, O> Codec<O> codec(MapCodec<T1> codec1, Function<O, T1> getter1, MapCodec<T2> codec2, Function<O, T2> getter2, MapCodec<T3> codec3, Function<O, T3> getter3, MapCodec<T4> codec4, Function<O, T4> getter4, I4<T1, T2, T3, T4, O> constructor) {
        return MapCodecMerger.mapCodec(codec1, getter1, codec2, getter2, codec3, getter3, codec4, getter4, constructor).asCodec();
    }

    public static <T1, T2, T3, T4, T5, O> MapCodec<O> mapCodec(final MapCodec<T1> codec1, final Function<O, T1> getter1, final MapCodec<T2> codec2, final Function<O, T2> getter2, final MapCodec<T3> codec3, final Function<O, T3> getter3, final MapCodec<T4> codec4, final Function<O, T4> getter4, final MapCodec<T5> codec5, final Function<O, T5> getter5, final I5<T1, T2, T3, T4, T5, O> constructor) {
        return new MapCodec<O>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> converter, Map<S, S> map, O element) {
                Result<Map<S, S>> result = codec1.serialize(converter, map, getter1.apply(element));
                if (result.isError()) {
                    return result.mapError();
                }
                if ((result = codec2.serialize(converter, result.get(), getter2.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec3.serialize(converter, result.get(), getter3.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec4.serialize(converter, result.get(), getter4.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec5.serialize(converter, result.get(), getter5.apply(element))).isError()) {
                    return result.mapError();
                }
                return result;
            }

            @Override
            public <S> Result<O> deserialize(DataConverter<S> converter, Map<S, S> map) {
                Result result1 = codec1.deserialize(converter, map);
                if (result1.isError()) {
                    return result1.mapError();
                }
                Result result2 = codec2.deserialize(converter, map);
                if (result2.isError()) {
                    return result2.mapError();
                }
                Result result3 = codec3.deserialize(converter, map);
                if (result3.isError()) {
                    return result3.mapError();
                }
                Result result4 = codec4.deserialize(converter, map);
                if (result4.isError()) {
                    return result4.mapError();
                }
                Result result5 = codec5.deserialize(converter, map);
                if (result5.isError()) {
                    return result5.mapError();
                }
                return Result.success(constructor.apply(result1.get(), result2.get(), result3.get(), result4.get(), result5.get()));
            }
        };
    }

    public static <T1, T2, T3, T4, T5, O> Codec<O> codec(MapCodec<T1> codec1, Function<O, T1> getter1, MapCodec<T2> codec2, Function<O, T2> getter2, MapCodec<T3> codec3, Function<O, T3> getter3, MapCodec<T4> codec4, Function<O, T4> getter4, MapCodec<T5> codec5, Function<O, T5> getter5, I5<T1, T2, T3, T4, T5, O> constructor) {
        return MapCodecMerger.mapCodec(codec1, getter1, codec2, getter2, codec3, getter3, codec4, getter4, codec5, getter5, constructor).asCodec();
    }

    public static <T1, T2, T3, T4, T5, T6, O> MapCodec<O> mapCodec(final MapCodec<T1> codec1, final Function<O, T1> getter1, final MapCodec<T2> codec2, final Function<O, T2> getter2, final MapCodec<T3> codec3, final Function<O, T3> getter3, final MapCodec<T4> codec4, final Function<O, T4> getter4, final MapCodec<T5> codec5, final Function<O, T5> getter5, final MapCodec<T6> codec6, final Function<O, T6> getter6, final I6<T1, T2, T3, T4, T5, T6, O> constructor) {
        return new MapCodec<O>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> converter, Map<S, S> map, O element) {
                Result<Map<S, S>> result = codec1.serialize(converter, map, getter1.apply(element));
                if (result.isError()) {
                    return result.mapError();
                }
                if ((result = codec2.serialize(converter, result.get(), getter2.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec3.serialize(converter, result.get(), getter3.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec4.serialize(converter, result.get(), getter4.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec5.serialize(converter, result.get(), getter5.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec6.serialize(converter, result.get(), getter6.apply(element))).isError()) {
                    return result.mapError();
                }
                return result;
            }

            @Override
            public <S> Result<O> deserialize(DataConverter<S> converter, Map<S, S> map) {
                Result result1 = codec1.deserialize(converter, map);
                if (result1.isError()) {
                    return result1.mapError();
                }
                Result result2 = codec2.deserialize(converter, map);
                if (result2.isError()) {
                    return result2.mapError();
                }
                Result result3 = codec3.deserialize(converter, map);
                if (result3.isError()) {
                    return result3.mapError();
                }
                Result result4 = codec4.deserialize(converter, map);
                if (result4.isError()) {
                    return result4.mapError();
                }
                Result result5 = codec5.deserialize(converter, map);
                if (result5.isError()) {
                    return result5.mapError();
                }
                Result result6 = codec6.deserialize(converter, map);
                if (result6.isError()) {
                    return result6.mapError();
                }
                return Result.success(constructor.apply(result1.get(), result2.get(), result3.get(), result4.get(), result5.get(), result6.get()));
            }
        };
    }

    public static <T1, T2, T3, T4, T5, T6, O> Codec<O> codec(MapCodec<T1> codec1, Function<O, T1> getter1, MapCodec<T2> codec2, Function<O, T2> getter2, MapCodec<T3> codec3, Function<O, T3> getter3, MapCodec<T4> codec4, Function<O, T4> getter4, MapCodec<T5> codec5, Function<O, T5> getter5, MapCodec<T6> codec6, Function<O, T6> getter6, I6<T1, T2, T3, T4, T5, T6, O> constructor) {
        return MapCodecMerger.mapCodec(codec1, getter1, codec2, getter2, codec3, getter3, codec4, getter4, codec5, getter5, codec6, getter6, constructor).asCodec();
    }

    public static <T1, T2, T3, T4, T5, T6, T7, O> MapCodec<O> mapCodec(final MapCodec<T1> codec1, final Function<O, T1> getter1, final MapCodec<T2> codec2, final Function<O, T2> getter2, final MapCodec<T3> codec3, final Function<O, T3> getter3, final MapCodec<T4> codec4, final Function<O, T4> getter4, final MapCodec<T5> codec5, final Function<O, T5> getter5, final MapCodec<T6> codec6, final Function<O, T6> getter6, final MapCodec<T7> codec7, final Function<O, T7> getter7, final I7<T1, T2, T3, T4, T5, T6, T7, O> constructor) {
        return new MapCodec<O>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> converter, Map<S, S> map, O element) {
                Result<Map<S, S>> result = codec1.serialize(converter, map, getter1.apply(element));
                if (result.isError()) {
                    return result.mapError();
                }
                if ((result = codec2.serialize(converter, result.get(), getter2.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec3.serialize(converter, result.get(), getter3.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec4.serialize(converter, result.get(), getter4.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec5.serialize(converter, result.get(), getter5.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec6.serialize(converter, result.get(), getter6.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec7.serialize(converter, result.get(), getter7.apply(element))).isError()) {
                    return result.mapError();
                }
                return result;
            }

            @Override
            public <S> Result<O> deserialize(DataConverter<S> converter, Map<S, S> map) {
                Result result1 = codec1.deserialize(converter, map);
                if (result1.isError()) {
                    return result1.mapError();
                }
                Result result2 = codec2.deserialize(converter, map);
                if (result2.isError()) {
                    return result2.mapError();
                }
                Result result3 = codec3.deserialize(converter, map);
                if (result3.isError()) {
                    return result3.mapError();
                }
                Result result4 = codec4.deserialize(converter, map);
                if (result4.isError()) {
                    return result4.mapError();
                }
                Result result5 = codec5.deserialize(converter, map);
                if (result5.isError()) {
                    return result5.mapError();
                }
                Result result6 = codec6.deserialize(converter, map);
                if (result6.isError()) {
                    return result6.mapError();
                }
                Result result7 = codec7.deserialize(converter, map);
                if (result7.isError()) {
                    return result7.mapError();
                }
                return Result.success(constructor.apply(result1.get(), result2.get(), result3.get(), result4.get(), result5.get(), result6.get(), result7.get()));
            }
        };
    }

    public static <T1, T2, T3, T4, T5, T6, T7, O> Codec<O> codec(MapCodec<T1> codec1, Function<O, T1> getter1, MapCodec<T2> codec2, Function<O, T2> getter2, MapCodec<T3> codec3, Function<O, T3> getter3, MapCodec<T4> codec4, Function<O, T4> getter4, MapCodec<T5> codec5, Function<O, T5> getter5, MapCodec<T6> codec6, Function<O, T6> getter6, MapCodec<T7> codec7, Function<O, T7> getter7, I7<T1, T2, T3, T4, T5, T6, T7, O> constructor) {
        return MapCodecMerger.mapCodec(codec1, getter1, codec2, getter2, codec3, getter3, codec4, getter4, codec5, getter5, codec6, getter6, codec7, getter7, constructor).asCodec();
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, O> MapCodec<O> mapCodec(final MapCodec<T1> codec1, final Function<O, T1> getter1, final MapCodec<T2> codec2, final Function<O, T2> getter2, final MapCodec<T3> codec3, final Function<O, T3> getter3, final MapCodec<T4> codec4, final Function<O, T4> getter4, final MapCodec<T5> codec5, final Function<O, T5> getter5, final MapCodec<T6> codec6, final Function<O, T6> getter6, final MapCodec<T7> codec7, final Function<O, T7> getter7, final MapCodec<T8> codec8, final Function<O, T8> getter8, final I8<T1, T2, T3, T4, T5, T6, T7, T8, O> constructor) {
        return new MapCodec<O>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> converter, Map<S, S> map, O element) {
                Result<Map<S, S>> result = codec1.serialize(converter, map, getter1.apply(element));
                if (result.isError()) {
                    return result.mapError();
                }
                if ((result = codec2.serialize(converter, result.get(), getter2.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec3.serialize(converter, result.get(), getter3.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec4.serialize(converter, result.get(), getter4.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec5.serialize(converter, result.get(), getter5.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec6.serialize(converter, result.get(), getter6.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec7.serialize(converter, result.get(), getter7.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec8.serialize(converter, result.get(), getter8.apply(element))).isError()) {
                    return result.mapError();
                }
                return result;
            }

            @Override
            public <S> Result<O> deserialize(DataConverter<S> converter, Map<S, S> map) {
                Result result1 = codec1.deserialize(converter, map);
                if (result1.isError()) {
                    return result1.mapError();
                }
                Result result2 = codec2.deserialize(converter, map);
                if (result2.isError()) {
                    return result2.mapError();
                }
                Result result3 = codec3.deserialize(converter, map);
                if (result3.isError()) {
                    return result3.mapError();
                }
                Result result4 = codec4.deserialize(converter, map);
                if (result4.isError()) {
                    return result4.mapError();
                }
                Result result5 = codec5.deserialize(converter, map);
                if (result5.isError()) {
                    return result5.mapError();
                }
                Result result6 = codec6.deserialize(converter, map);
                if (result6.isError()) {
                    return result6.mapError();
                }
                Result result7 = codec7.deserialize(converter, map);
                if (result7.isError()) {
                    return result7.mapError();
                }
                Result result8 = codec8.deserialize(converter, map);
                if (result8.isError()) {
                    return result8.mapError();
                }
                return Result.success(constructor.apply(result1.get(), result2.get(), result3.get(), result4.get(), result5.get(), result6.get(), result7.get(), result8.get()));
            }
        };
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, O> Codec<O> codec(MapCodec<T1> codec1, Function<O, T1> getter1, MapCodec<T2> codec2, Function<O, T2> getter2, MapCodec<T3> codec3, Function<O, T3> getter3, MapCodec<T4> codec4, Function<O, T4> getter4, MapCodec<T5> codec5, Function<O, T5> getter5, MapCodec<T6> codec6, Function<O, T6> getter6, MapCodec<T7> codec7, Function<O, T7> getter7, MapCodec<T8> codec8, Function<O, T8> getter8, I8<T1, T2, T3, T4, T5, T6, T7, T8, O> constructor) {
        return MapCodecMerger.mapCodec(codec1, getter1, codec2, getter2, codec3, getter3, codec4, getter4, codec5, getter5, codec6, getter6, codec7, getter7, codec8, getter8, constructor).asCodec();
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, O> MapCodec<O> mapCodec(final MapCodec<T1> codec1, final Function<O, T1> getter1, final MapCodec<T2> codec2, final Function<O, T2> getter2, final MapCodec<T3> codec3, final Function<O, T3> getter3, final MapCodec<T4> codec4, final Function<O, T4> getter4, final MapCodec<T5> codec5, final Function<O, T5> getter5, final MapCodec<T6> codec6, final Function<O, T6> getter6, final MapCodec<T7> codec7, final Function<O, T7> getter7, final MapCodec<T8> codec8, final Function<O, T8> getter8, final MapCodec<T9> codec9, final Function<O, T9> getter9, final I9<T1, T2, T3, T4, T5, T6, T7, T8, T9, O> constructor) {
        return new MapCodec<O>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> converter, Map<S, S> map, O element) {
                Result<Map<S, S>> result = codec1.serialize(converter, map, getter1.apply(element));
                if (result.isError()) {
                    return result.mapError();
                }
                if ((result = codec2.serialize(converter, result.get(), getter2.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec3.serialize(converter, result.get(), getter3.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec4.serialize(converter, result.get(), getter4.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec5.serialize(converter, result.get(), getter5.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec6.serialize(converter, result.get(), getter6.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec7.serialize(converter, result.get(), getter7.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec8.serialize(converter, result.get(), getter8.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec9.serialize(converter, result.get(), getter9.apply(element))).isError()) {
                    return result.mapError();
                }
                return result;
            }

            @Override
            public <S> Result<O> deserialize(DataConverter<S> converter, Map<S, S> map) {
                Result result1 = codec1.deserialize(converter, map);
                if (result1.isError()) {
                    return result1.mapError();
                }
                Result result2 = codec2.deserialize(converter, map);
                if (result2.isError()) {
                    return result2.mapError();
                }
                Result result3 = codec3.deserialize(converter, map);
                if (result3.isError()) {
                    return result3.mapError();
                }
                Result result4 = codec4.deserialize(converter, map);
                if (result4.isError()) {
                    return result4.mapError();
                }
                Result result5 = codec5.deserialize(converter, map);
                if (result5.isError()) {
                    return result5.mapError();
                }
                Result result6 = codec6.deserialize(converter, map);
                if (result6.isError()) {
                    return result6.mapError();
                }
                Result result7 = codec7.deserialize(converter, map);
                if (result7.isError()) {
                    return result7.mapError();
                }
                Result result8 = codec8.deserialize(converter, map);
                if (result8.isError()) {
                    return result8.mapError();
                }
                Result result9 = codec9.deserialize(converter, map);
                if (result9.isError()) {
                    return result9.mapError();
                }
                return Result.success(constructor.apply(result1.get(), result2.get(), result3.get(), result4.get(), result5.get(), result6.get(), result7.get(), result8.get(), result9.get()));
            }
        };
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, O> Codec<O> codec(MapCodec<T1> codec1, Function<O, T1> getter1, MapCodec<T2> codec2, Function<O, T2> getter2, MapCodec<T3> codec3, Function<O, T3> getter3, MapCodec<T4> codec4, Function<O, T4> getter4, MapCodec<T5> codec5, Function<O, T5> getter5, MapCodec<T6> codec6, Function<O, T6> getter6, MapCodec<T7> codec7, Function<O, T7> getter7, MapCodec<T8> codec8, Function<O, T8> getter8, MapCodec<T9> codec9, Function<O, T9> getter9, I9<T1, T2, T3, T4, T5, T6, T7, T8, T9, O> constructor) {
        return MapCodecMerger.mapCodec(codec1, getter1, codec2, getter2, codec3, getter3, codec4, getter4, codec5, getter5, codec6, getter6, codec7, getter7, codec8, getter8, codec9, getter9, constructor).asCodec();
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, O> MapCodec<O> mapCodec(final MapCodec<T1> codec1, final Function<O, T1> getter1, final MapCodec<T2> codec2, final Function<O, T2> getter2, final MapCodec<T3> codec3, final Function<O, T3> getter3, final MapCodec<T4> codec4, final Function<O, T4> getter4, final MapCodec<T5> codec5, final Function<O, T5> getter5, final MapCodec<T6> codec6, final Function<O, T6> getter6, final MapCodec<T7> codec7, final Function<O, T7> getter7, final MapCodec<T8> codec8, final Function<O, T8> getter8, final MapCodec<T9> codec9, final Function<O, T9> getter9, final MapCodec<T10> codec10, final Function<O, T10> getter10, final I10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, O> constructor) {
        return new MapCodec<O>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> converter, Map<S, S> map, O element) {
                Result<Map<S, S>> result = codec1.serialize(converter, map, getter1.apply(element));
                if (result.isError()) {
                    return result.mapError();
                }
                if ((result = codec2.serialize(converter, result.get(), getter2.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec3.serialize(converter, result.get(), getter3.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec4.serialize(converter, result.get(), getter4.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec5.serialize(converter, result.get(), getter5.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec6.serialize(converter, result.get(), getter6.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec7.serialize(converter, result.get(), getter7.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec8.serialize(converter, result.get(), getter8.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec9.serialize(converter, result.get(), getter9.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec10.serialize(converter, result.get(), getter10.apply(element))).isError()) {
                    return result.mapError();
                }
                return result;
            }

            @Override
            public <S> Result<O> deserialize(DataConverter<S> converter, Map<S, S> map) {
                Result result1 = codec1.deserialize(converter, map);
                if (result1.isError()) {
                    return result1.mapError();
                }
                Result result2 = codec2.deserialize(converter, map);
                if (result2.isError()) {
                    return result2.mapError();
                }
                Result result3 = codec3.deserialize(converter, map);
                if (result3.isError()) {
                    return result3.mapError();
                }
                Result result4 = codec4.deserialize(converter, map);
                if (result4.isError()) {
                    return result4.mapError();
                }
                Result result5 = codec5.deserialize(converter, map);
                if (result5.isError()) {
                    return result5.mapError();
                }
                Result result6 = codec6.deserialize(converter, map);
                if (result6.isError()) {
                    return result6.mapError();
                }
                Result result7 = codec7.deserialize(converter, map);
                if (result7.isError()) {
                    return result7.mapError();
                }
                Result result8 = codec8.deserialize(converter, map);
                if (result8.isError()) {
                    return result8.mapError();
                }
                Result result9 = codec9.deserialize(converter, map);
                if (result9.isError()) {
                    return result9.mapError();
                }
                Result result10 = codec10.deserialize(converter, map);
                if (result10.isError()) {
                    return result10.mapError();
                }
                return Result.success(constructor.apply(result1.get(), result2.get(), result3.get(), result4.get(), result5.get(), result6.get(), result7.get(), result8.get(), result9.get(), result10.get()));
            }
        };
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, O> Codec<O> codec(MapCodec<T1> codec1, Function<O, T1> getter1, MapCodec<T2> codec2, Function<O, T2> getter2, MapCodec<T3> codec3, Function<O, T3> getter3, MapCodec<T4> codec4, Function<O, T4> getter4, MapCodec<T5> codec5, Function<O, T5> getter5, MapCodec<T6> codec6, Function<O, T6> getter6, MapCodec<T7> codec7, Function<O, T7> getter7, MapCodec<T8> codec8, Function<O, T8> getter8, MapCodec<T9> codec9, Function<O, T9> getter9, MapCodec<T10> codec10, Function<O, T10> getter10, I10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, O> constructor) {
        return MapCodecMerger.mapCodec(codec1, getter1, codec2, getter2, codec3, getter3, codec4, getter4, codec5, getter5, codec6, getter6, codec7, getter7, codec8, getter8, codec9, getter9, codec10, getter10, constructor).asCodec();
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, O> MapCodec<O> mapCodec(final MapCodec<T1> codec1, final Function<O, T1> getter1, final MapCodec<T2> codec2, final Function<O, T2> getter2, final MapCodec<T3> codec3, final Function<O, T3> getter3, final MapCodec<T4> codec4, final Function<O, T4> getter4, final MapCodec<T5> codec5, final Function<O, T5> getter5, final MapCodec<T6> codec6, final Function<O, T6> getter6, final MapCodec<T7> codec7, final Function<O, T7> getter7, final MapCodec<T8> codec8, final Function<O, T8> getter8, final MapCodec<T9> codec9, final Function<O, T9> getter9, final MapCodec<T10> codec10, final Function<O, T10> getter10, final MapCodec<T11> codec11, final Function<O, T11> getter11, final I11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, O> constructor) {
        return new MapCodec<O>(){

            @Override
            public <S> Result<Map<S, S>> serialize(DataConverter<S> converter, Map<S, S> map, O element) {
                Result<Map<S, S>> result = codec1.serialize(converter, map, getter1.apply(element));
                if (result.isError()) {
                    return result.mapError();
                }
                if ((result = codec2.serialize(converter, result.get(), getter2.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec3.serialize(converter, result.get(), getter3.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec4.serialize(converter, result.get(), getter4.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec5.serialize(converter, result.get(), getter5.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec6.serialize(converter, result.get(), getter6.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec7.serialize(converter, result.get(), getter7.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec8.serialize(converter, result.get(), getter8.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec9.serialize(converter, result.get(), getter9.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec10.serialize(converter, result.get(), getter10.apply(element))).isError()) {
                    return result.mapError();
                }
                if ((result = codec11.serialize(converter, result.get(), getter11.apply(element))).isError()) {
                    return result.mapError();
                }
                return result;
            }

            @Override
            public <S> Result<O> deserialize(DataConverter<S> converter, Map<S, S> map) {
                Result result1 = codec1.deserialize(converter, map);
                if (result1.isError()) {
                    return result1.mapError();
                }
                Result result2 = codec2.deserialize(converter, map);
                if (result2.isError()) {
                    return result2.mapError();
                }
                Result result3 = codec3.deserialize(converter, map);
                if (result3.isError()) {
                    return result3.mapError();
                }
                Result result4 = codec4.deserialize(converter, map);
                if (result4.isError()) {
                    return result4.mapError();
                }
                Result result5 = codec5.deserialize(converter, map);
                if (result5.isError()) {
                    return result5.mapError();
                }
                Result result6 = codec6.deserialize(converter, map);
                if (result6.isError()) {
                    return result6.mapError();
                }
                Result result7 = codec7.deserialize(converter, map);
                if (result7.isError()) {
                    return result7.mapError();
                }
                Result result8 = codec8.deserialize(converter, map);
                if (result8.isError()) {
                    return result8.mapError();
                }
                Result result9 = codec9.deserialize(converter, map);
                if (result9.isError()) {
                    return result9.mapError();
                }
                Result result10 = codec10.deserialize(converter, map);
                if (result10.isError()) {
                    return result10.mapError();
                }
                Result result11 = codec11.deserialize(converter, map);
                if (result11.isError()) {
                    return result11.mapError();
                }
                return Result.success(constructor.apply(result1.get(), result2.get(), result3.get(), result4.get(), result5.get(), result6.get(), result7.get(), result8.get(), result9.get(), result10.get(), result11.get()));
            }
        };
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, O> Codec<O> codec(MapCodec<T1> codec1, Function<O, T1> getter1, MapCodec<T2> codec2, Function<O, T2> getter2, MapCodec<T3> codec3, Function<O, T3> getter3, MapCodec<T4> codec4, Function<O, T4> getter4, MapCodec<T5> codec5, Function<O, T5> getter5, MapCodec<T6> codec6, Function<O, T6> getter6, MapCodec<T7> codec7, Function<O, T7> getter7, MapCodec<T8> codec8, Function<O, T8> getter8, MapCodec<T9> codec9, Function<O, T9> getter9, MapCodec<T10> codec10, Function<O, T10> getter10, MapCodec<T11> codec11, Function<O, T11> getter11, I11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, O> constructor) {
        return MapCodecMerger.mapCodec(codec1, getter1, codec2, getter2, codec3, getter3, codec4, getter4, codec5, getter5, codec6, getter6, codec7, getter7, codec8, getter8, codec9, getter9, codec10, getter10, codec11, getter11, constructor).asCodec();
    }

    @FunctionalInterface
    public static interface I11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, O> {
        public O apply(T1 var1, T2 var2, T3 var3, T4 var4, T5 var5, T6 var6, T7 var7, T8 var8, T9 var9, T10 var10, T11 var11);
    }

    @FunctionalInterface
    public static interface I10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, O> {
        public O apply(T1 var1, T2 var2, T3 var3, T4 var4, T5 var5, T6 var6, T7 var7, T8 var8, T9 var9, T10 var10);
    }

    @FunctionalInterface
    public static interface I9<T1, T2, T3, T4, T5, T6, T7, T8, T9, O> {
        public O apply(T1 var1, T2 var2, T3 var3, T4 var4, T5 var5, T6 var6, T7 var7, T8 var8, T9 var9);
    }

    @FunctionalInterface
    public static interface I8<T1, T2, T3, T4, T5, T6, T7, T8, O> {
        public O apply(T1 var1, T2 var2, T3 var3, T4 var4, T5 var5, T6 var6, T7 var7, T8 var8);
    }

    @FunctionalInterface
    public static interface I7<T1, T2, T3, T4, T5, T6, T7, O> {
        public O apply(T1 var1, T2 var2, T3 var3, T4 var4, T5 var5, T6 var6, T7 var7);
    }

    @FunctionalInterface
    public static interface I6<T1, T2, T3, T4, T5, T6, O> {
        public O apply(T1 var1, T2 var2, T3 var3, T4 var4, T5 var5, T6 var6);
    }

    @FunctionalInterface
    public static interface I5<T1, T2, T3, T4, T5, O> {
        public O apply(T1 var1, T2 var2, T3 var3, T4 var4, T5 var5);
    }

    @FunctionalInterface
    public static interface I4<T1, T2, T3, T4, O> {
        public O apply(T1 var1, T2 var2, T3 var3, T4 var4);
    }

    @FunctionalInterface
    public static interface I3<T1, T2, T3, O> {
        public O apply(T1 var1, T2 var2, T3 var3);
    }

    @FunctionalInterface
    public static interface I2<T1, T2, O> {
        public O apply(T1 var1, T2 var2);
    }

    @FunctionalInterface
    public static interface I1<T1, O> {
        public O apply(T1 var1);
    }
}

