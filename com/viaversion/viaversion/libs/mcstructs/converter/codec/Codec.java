/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.codec;

import com.viaversion.viaversion.libs.mcstructs.converter.DataConverter;
import com.viaversion.viaversion.libs.mcstructs.converter.SerializedData;
import com.viaversion.viaversion.libs.mcstructs.converter.codec.DataDeserializer;
import com.viaversion.viaversion.libs.mcstructs.converter.codec.DataSerializer;
import com.viaversion.viaversion.libs.mcstructs.converter.codec.ThrowingFunction;
import com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.MapCodec;
import com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.impl.FieldMapCodec;
import com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.impl.TypedMapCodec;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Either;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import com.viaversion.viaversion.libs.mcstructs.converter.types.IdentifiedType;
import com.viaversion.viaversion.libs.mcstructs.converter.types.NamedType;
import com.viaversion.viaversion.libs.mcstructs.core.Identifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public interface Codec<T>
extends DataSerializer<T>,
DataDeserializer<T> {
    public static final Codec<Boolean> UNIT = Codec.unit(() -> true);
    public static final Codec<Boolean> BOOLEAN = new Codec<Boolean>(){

        @Override
        public <S> Result<S> serialize(DataConverter<S> converter, Boolean element) {
            return Result.success(converter.createBoolean(element));
        }

        @Override
        public <S> Result<Boolean> deserialize(DataConverter<S> converter, S data) {
            return converter.asBoolean(data);
        }
    };
    public static final Codec<Byte> BYTE = new Codec<Byte>(){

        @Override
        public <S> Result<S> serialize(DataConverter<S> converter, Byte element) {
            return Result.success(converter.createByte(element));
        }

        @Override
        public <S> Result<Byte> deserialize(DataConverter<S> converter, S data) {
            return converter.asNumber(data).map(Number::byteValue);
        }
    };
    public static final Codec<Integer> UNSIGNED_BYTE = BYTE.flatMap(i2 -> {
        if (i2 < 0) {
            return Result.error("Value is smaller than minimum: " + i2 + " < 0");
        }
        if (i2 > 255) {
            return Result.error("Value is bigger than maximum: " + i2 + " > 255");
        }
        return Result.success((byte)(i2 & 0xFF));
    }, b2 -> Result.success(b2 & 0xFF));
    public static final Codec<Short> SHORT = new Codec<Short>(){

        @Override
        public <S> Result<S> serialize(DataConverter<S> converter, Short element) {
            return Result.success(converter.createShort(element));
        }

        @Override
        public <S> Result<Short> deserialize(DataConverter<S> converter, S data) {
            return converter.asNumber(data).map(Number::shortValue);
        }
    };
    public static final Codec<Integer> INTEGER = new Codec<Integer>(){

        @Override
        public <S> Result<S> serialize(DataConverter<S> converter, Integer element) {
            return Result.success(converter.createInt(element));
        }

        @Override
        public <S> Result<Integer> deserialize(DataConverter<S> converter, S data) {
            return converter.asNumber(data).map(Number::intValue);
        }
    };
    public static final Codec<Long> LONG = new Codec<Long>(){

        @Override
        public <S> Result<S> serialize(DataConverter<S> converter, Long element) {
            return Result.success(converter.createLong(element));
        }

        @Override
        public <S> Result<Long> deserialize(DataConverter<S> converter, S data) {
            return converter.asNumber(data).map(Number::longValue);
        }
    };
    public static final Codec<Float> FLOAT = new Codec<Float>(){

        @Override
        public <S> Result<S> serialize(DataConverter<S> converter, Float element) {
            return Result.success(converter.createFloat(element.floatValue()));
        }

        @Override
        public <S> Result<Float> deserialize(DataConverter<S> converter, S data) {
            return converter.asNumber(data).map(Number::floatValue);
        }
    };
    public static final Codec<Double> DOUBLE = new Codec<Double>(){

        @Override
        public <S> Result<S> serialize(DataConverter<S> converter, Double element) {
            return Result.success(converter.createDouble(element));
        }

        @Override
        public <S> Result<Double> deserialize(DataConverter<S> converter, S data) {
            return converter.asNumber(data).map(Number::doubleValue);
        }
    };
    public static final Codec<String> STRING = new Codec<String>(){

        @Override
        public <S> Result<S> serialize(DataConverter<S> converter, String element) {
            return Result.success(converter.createString(element));
        }

        @Override
        public <S> Result<String> deserialize(DataConverter<S> converter, S data) {
            return converter.asString(data);
        }
    };
    public static final Codec<byte[]> BYTE_ARRAY = new Codec<byte[]>(){

        @Override
        public <S> Result<S> serialize(DataConverter<S> converter, byte[] element) {
            return Result.success(converter.createByteArray(element));
        }

        @Override
        public <S> Result<byte[]> deserialize(DataConverter<S> converter, S data) {
            return converter.asByteArray(data);
        }
    };
    public static final Codec<int[]> INT_ARRAY = new Codec<int[]>(){

        @Override
        public <S> Result<S> serialize(DataConverter<S> converter, int[] element) {
            return Result.success(converter.createIntArray(element));
        }

        @Override
        public <S> Result<int[]> deserialize(DataConverter<S> converter, S data) {
            return converter.asIntArray(data);
        }
    };
    public static final Codec<long[]> LONG_ARRAY = new Codec<long[]>(){

        @Override
        public <S> Result<S> serialize(DataConverter<S> converter, long[] element) {
            return Result.success(converter.createLongArray(element));
        }

        @Override
        public <S> Result<long[]> deserialize(DataConverter<S> converter, S data) {
            return converter.asLongArray(data);
        }
    };
    public static final Codec<Identifier> STRING_IDENTIFIER = STRING.mapThrowing(Identifier::get, Identifier::of);
    public static final Codec<String> STRING_IDENTIFIER_PATH = STRING.verified(s2 -> {
        if (s2.matches("[_\\-a-z0-9/.]*")) {
            return Result.error("Invalid identifier path: " + s2);
        }
        return null;
    });
    public static final Codec<UUID> INT_ARRAY_UUID = INT_ARRAY.verified(array -> {
        if (((int[])array).length != 4) {
            return Result.error("UUID array must have a length of 4");
        }
        return null;
    }).map(uuid -> {
        int[] ints = new int[]{(int)(uuid.getMostSignificantBits() >> 32), (int)uuid.getMostSignificantBits(), (int)(uuid.getLeastSignificantBits() >> 32), (int)uuid.getLeastSignificantBits()};
        return ints;
    }, ints -> {
        long mostSigBits = (long)ints[0] << 32 | (long)ints[1] & 0xFFFFFFFFL;
        long leastSigBits = (long)ints[2] << 32 | (long)ints[3] & 0xFFFFFFFFL;
        return new UUID(mostSigBits, leastSigBits);
    });
    public static final Codec<UUID> STRICT_STRING_UUID = STRING.mapThrowing(UUID::toString, UUID::fromString);
    public static final Codec<SerializedData<?>> RAW = new Codec<SerializedData<?>>(){

        @Override
        public <S> Result<S> serialize(DataConverter<S> converter, SerializedData<?> element) {
            return element.convert(converter);
        }

        @Override
        public <S> Result<SerializedData<?>> deserialize(DataConverter<S> converter, S data) {
            return Result.success(new SerializedData<S>(data, converter));
        }
    };

    public static <T> Codec<T> unit(final Supplier<T> supplier) {
        return new Codec<T>(){

            @Override
            public <S> Result<S> serialize(DataConverter<S> converter, T element) {
                return Result.success(converter.emptyMap());
            }

            @Override
            public <S> Result<T> deserialize(DataConverter<S> converter, S data) {
                return converter.asMap(data).map(arg_0 -> 13.lambda$deserialize$0((Supplier)supplier, arg_0));
            }

            private static /* synthetic */ Object lambda$deserialize$0(Supplier supplier2, Map map) {
                return supplier2.get();
            }
        };
    }

    public static <T> Codec<T> failing(final String error) {
        return new Codec<T>(){

            @Override
            public <S> Result<S> serialize(DataConverter<S> converter, T element) {
                return Result.error(error);
            }

            @Override
            public <S> Result<T> deserialize(DataConverter<S> converter, S data) {
                return Result.error(error);
            }
        };
    }

    public static <T> Codec<T> ofThrowing(final DataSerializer<T> serializer, final DataDeserializer<T> deserializer) {
        return new Codec<T>(){

            @Override
            public <S> Result<S> serialize(DataConverter<S> converter, T element) {
                try {
                    return serializer.serialize(converter, element);
                }
                catch (Throwable t2) {
                    return Result.error(t2);
                }
            }

            @Override
            public <S> Result<T> deserialize(DataConverter<S> converter, S data) {
                try {
                    return deserializer.deserialize(converter, data);
                }
                catch (Throwable t2) {
                    return Result.error(t2);
                }
            }
        };
    }

    public static <T> Codec<T> recursive(final Function<Codec<T>, Codec<T>> creator) {
        return new Codec<T>(){
            private final Codec<T> codec;
            {
                this.codec = (Codec)creator.apply(this);
            }

            @Override
            public <S> Result<S> serialize(DataConverter<S> converter, T element) {
                return this.codec.serialize(converter, element);
            }

            @Override
            public <S> Result<T> deserialize(DataConverter<S> converter, S data) {
                return this.codec.deserialize(converter, data);
            }
        };
    }

    public static Codec<Integer> minInt(int minInclusive) {
        return Codec.rangedInt(minInclusive, Integer.MAX_VALUE);
    }

    public static Codec<Integer> rangedInt(int minInclusive, int maxInclusive) {
        return INTEGER.verified(i2 -> {
            if (i2 < minInclusive) {
                return Result.error("Value is smaller than minimum: " + i2 + " < " + minInclusive);
            }
            if (i2 > maxInclusive) {
                return Result.error("Value is bigger than maximum: " + i2 + " > " + maxInclusive);
            }
            return null;
        });
    }

    public static Codec<Float> minFloat(float minInclusive) {
        return Codec.rangedFloat(minInclusive, Float.MAX_VALUE);
    }

    public static Codec<Float> minExclusiveFloat(float minExclusive) {
        return FLOAT.verified(f2 -> {
            if (f2.floatValue() <= minExclusive) {
                return Result.error("Value is smaller or equal to minimum: " + f2 + " <= " + minExclusive);
            }
            return null;
        });
    }

    public static Codec<Float> rangedFloat(float minInclusive, float maxInclusive) {
        return FLOAT.verified(f2 -> {
            if (f2.floatValue() < minInclusive) {
                return Result.error("Value is smaller than minimum: " + f2 + " < " + minInclusive);
            }
            if (f2.floatValue() > maxInclusive) {
                return Result.error("Value is bigger than maximum: " + f2 + " > " + maxInclusive);
            }
            return null;
        });
    }

    public static Codec<String> sizedString(int minInclusive, int maxInclusive) {
        return STRING.verified(s2 -> {
            if (s2.length() < minInclusive) {
                return Result.error("String is shorter than minimum: " + s2.length() + " < " + minInclusive);
            }
            if (s2.length() > maxInclusive) {
                return Result.error("String is longer than maximum: " + s2.length() + " > " + maxInclusive);
            }
            return null;
        });
    }

    @SafeVarargs
    public static <T extends NamedType> Codec<T> named(T ... values) {
        return STRING.flatMap(named -> Result.success(named.getName()), name -> {
            for (NamedType value : values) {
                if (!value.getName().equals(name)) continue;
                return Result.success(value);
            }
            String available = "";
            for (NamedType value : values) {
                available = available + value.getName() + ", ";
            }
            if (!available.isEmpty()) {
                available = available.substring(0, available.length() - 2);
            }
            return Result.error("Unknown named value: " + name + " (" + available + ")");
        });
    }

    public static <T extends IdentifiedType> Codec<T> identified(T[] values) {
        return STRING_IDENTIFIER.flatMap(identified -> Result.success(identified.getIdentifier()), identifier -> {
            for (IdentifiedType value : values) {
                if (!value.getIdentifier().equals(identifier)) continue;
                return Result.success(value);
            }
            String available = "";
            for (IdentifiedType value : values) {
                available = available + value.getIdentifier() + ", ";
            }
            if (!available.isEmpty()) {
                available = available.substring(0, available.length() - 2);
            }
            return Result.error("Unknown identified value: " + identifier + " (" + available + ")");
        });
    }

    public static <L, R> Codec<Either<L, R>> either(final Codec<L> leftCodec, final Codec<R> rightCodec) {
        return new Codec<Either<L, R>>(){

            @Override
            public <S> Result<S> serialize(DataConverter<S> converter, Either<L, R> element) {
                if (element.isLeft()) {
                    return leftCodec.serialize(converter, element.getLeft());
                }
                if (element.isRight()) {
                    return rightCodec.serialize(converter, element.getRight());
                }
                return Result.error("Either is neither left nor right");
            }

            @Override
            public <S> Result<Either<L, R>> deserialize(DataConverter<S> converter, S data) {
                Result left = leftCodec.deserialize(converter, data);
                if (!left.isError()) {
                    return Result.success(Either.left(left.get()));
                }
                Result right = rightCodec.deserialize(converter, data);
                if (!right.isError()) {
                    return Result.success(Either.right(right.get()));
                }
                return Result.mergeErrors("Failed to deserialize as either left or right", Arrays.asList(left, right));
            }
        };
    }

    public static <T> Codec<T> withAlternative(Codec<T> codec, Codec<T> alternative) {
        return Codec.either(codec, alternative).map(Either::left, Either::unwrap);
    }

    public static <T, A> Codec<T> withAlternative(Codec<T> codec, Codec<A> alternative, Function<A, T> mapper) {
        return Codec.either(codec, alternative).map(Either::left, either -> either.xmap(Function.identity(), mapper));
    }

    @SafeVarargs
    public static <T> Codec<T> oneOf(final Codec<T> ... codecs) {
        if (codecs.length == 0) {
            throw new IllegalArgumentException("At least one codec is required");
        }
        return new Codec<T>(){

            @Override
            public <S> Result<S> serialize(DataConverter<S> converter, T element) {
                ArrayList failed = null;
                for (Codec codec : codecs) {
                    Result<S> result = codec.serialize(converter, element);
                    if (!result.isError()) {
                        return result;
                    }
                    if (failed == null) {
                        failed = new ArrayList();
                    }
                    failed.add(result.mapError());
                }
                return Result.mergeErrors("Failed to serialize with " + codecs.length + " codecs", failed);
            }

            @Override
            public <S> Result<T> deserialize(DataConverter<S> converter, S data) {
                ArrayList failed = null;
                for (Codec codec : codecs) {
                    Result result = codec.deserialize(converter, data);
                    if (!result.isError()) {
                        return result;
                    }
                    if (failed == null) {
                        failed = new ArrayList();
                    }
                    failed.add(result.mapError());
                }
                return Result.mergeErrors("Failed to deserialize with " + codecs.length + " codecs", failed);
            }
        };
    }

    public static <K, V> Codec<Map<K, V>> mapOf(Codec<K> keyCodec, Codec<V> valueCodec) {
        return Codec.mapOf(keyCodec, (K key) -> valueCodec);
    }

    public static <K, V> Codec<Map<K, V>> mapOf(final Codec<K> keyCodec, final Function<K, Codec<V>> valueFunction) {
        return new Codec<Map<K, V>>(){

            @Override
            public <S> Result<S> serialize(DataConverter<S> converter, Map<K, V> element) {
                HashMap<S, S> map = new HashMap<S, S>();
                for (Map.Entry entry : element.entrySet()) {
                    Result<S> key = keyCodec.serialize(converter, entry.getKey());
                    if (key.isError()) {
                        return key.mapError();
                    }
                    Result<S> value = ((Codec)valueFunction.apply(entry.getKey())).serialize(converter, entry.getValue());
                    if (value.isError()) {
                        return value.mapError();
                    }
                    map.put(key.get(), value.get());
                }
                return converter.createMergedMap(map);
            }

            @Override
            public <S> Result<Map<K, V>> deserialize(DataConverter<S> converter, S data) {
                Result<Map<S, S>> map = converter.asMap(data);
                if (map.isError()) {
                    return map.mapError();
                }
                HashMap converted = new HashMap();
                for (Map.Entry<S, S> entry : map.get().entrySet()) {
                    Result key = keyCodec.deserialize(converter, entry.getKey());
                    if (key.isError()) {
                        return key.mapError();
                    }
                    Result value = ((Codec)valueFunction.apply(key.get())).deserialize(converter, entry.getValue());
                    if (value.isError()) {
                        return value.mapError();
                    }
                    converted.put(key.get(), value.get());
                }
                return Result.success(converted);
            }
        };
    }

    public static <T> Codec<List<T>> compactList(Codec<T> elementCodec) {
        return Codec.compactList(elementCodec, elementCodec.listOf());
    }

    public static <T> Codec<List<T>> compactList(Codec<T> elementCodec, Codec<List<T>> listCodec) {
        return Codec.either(listCodec, elementCodec).map(list -> list.size() == 1 ? Either.right(list.get(0)) : Either.left(list), either -> either.xmap(list -> list, item -> {
            ArrayList<Object> list = new ArrayList<Object>();
            list.add(item);
            return list;
        }));
    }

    public static <T> Codec<T> lazyInit(final Supplier<Codec<T>> initializer) {
        return new Codec<T>(){
            private Codec<T> codec;

            @Override
            public <S> Result<S> serialize(DataConverter<S> converter, T element) {
                if (this.codec == null) {
                    this.codec = (Codec)initializer.get();
                }
                return this.codec.serialize(converter, element);
            }

            @Override
            public <S> Result<T> deserialize(DataConverter<S> converter, S data) {
                if (this.codec == null) {
                    this.codec = (Codec)initializer.get();
                }
                return this.codec.deserialize(converter, data);
            }
        };
    }

    default public <N> Codec<N> map(final Function<N, T> serializer, final Function<T, N> deserializer) {
        return new Codec<N>(){

            @Override
            public <S> Result<S> serialize(DataConverter<S> converter, N element) {
                return Codec.this.serialize(converter, serializer.apply(element));
            }

            @Override
            public <S> Result<N> deserialize(DataConverter<S> converter, S data) {
                return Codec.this.deserialize(converter, data).map(deserializer);
            }
        };
    }

    default public <N> Codec<N> mapThrowing(ThrowingFunction<N, T> serializer, ThrowingFunction<T, N> deserializer) {
        return this.flatMap(n2 -> {
            try {
                return Result.success(serializer.apply(n2));
            }
            catch (Throwable t2) {
                return Result.error(t2);
            }
        }, t2 -> {
            try {
                return Result.success(deserializer.apply(t2));
            }
            catch (Throwable t22) {
                return Result.error(t22);
            }
        });
    }

    default public <N> Codec<N> flatMap(final Function<N, Result<T>> serializer, final Function<T, Result<N>> deserializer) {
        return new Codec<N>(){

            @Override
            public <S> Result<S> serialize(DataConverter<S> converter, N element) {
                Result result = (Result)serializer.apply(element);
                if (result.isError()) {
                    return result.mapError();
                }
                return Codec.this.serialize(converter, result.get());
            }

            @Override
            public <S> Result<N> deserialize(DataConverter<S> converter, S data) {
                Result result = Codec.this.deserialize(converter, data);
                if (result.isError()) {
                    return result.mapError();
                }
                return (Result)deserializer.apply(result.get());
            }
        };
    }

    default public <N> Codec<N> converterFlatMap(final BiFunction<DataConverter<?>, N, Result<T>> serializer, final BiFunction<DataConverter<?>, T, Result<N>> deserializer) {
        return new Codec<N>(){

            @Override
            public <S> Result<S> serialize(DataConverter<S> converter, N element) {
                Result result = (Result)serializer.apply(converter, element);
                if (result.isError()) {
                    return result.mapError();
                }
                return Codec.this.serialize(converter, result.get());
            }

            @Override
            public <S> Result<N> deserialize(DataConverter<S> converter, S data) {
                Result result = Codec.this.deserialize(converter, data);
                if (result.isError()) {
                    return result.mapError();
                }
                return (Result)deserializer.apply(converter, result.get());
            }
        };
    }

    default public <N> Codec<N> typed(Function<N, T> typeMapper, Function<T, MapCodec<? extends N>> continuation) {
        return this.typedMap(typeMapper, continuation).asCodec();
    }

    default public <N> Codec<N> typed(String typeKey, Function<N, T> typeMapper, Function<T, MapCodec<? extends N>> continuation) {
        return this.typedMap(typeKey, typeMapper, continuation).asCodec();
    }

    default public <N> MapCodec<N> typedMap(Function<N, T> typeMapper, Function<T, MapCodec<? extends N>> continuation) {
        return this.typedMap("type", typeMapper, continuation);
    }

    default public <N> MapCodec<N> typedMap(String typeKey, Function<N, T> typeMapper, Function<T, MapCodec<? extends N>> continuation) {
        return new TypedMapCodec<T, N>(typeKey, this, typeMapper, continuation);
    }

    default public Codec<List<T>> listOf() {
        return this.listOf(Integer.MAX_VALUE);
    }

    default public Codec<List<T>> listOf(int maxElements) {
        return this.listOf(0, maxElements);
    }

    default public Codec<List<T>> listOf(final int minElements, final int maxElements) {
        return new Codec<List<T>>(){

            @Override
            public <S> Result<S> serialize(DataConverter<S> converter, List<T> element) {
                if (element.size() < minElements) {
                    return Result.error("List size is smaller than minimum: " + element.size() + " < " + minElements);
                }
                if (element.size() > maxElements) {
                    return Result.error("List size is bigger than maximum: " + element.size() + " > " + maxElements);
                }
                ArrayList<S> converted = new ArrayList<S>();
                for (Object value : element) {
                    Result<S> result = Codec.this.serialize(converter, value);
                    if (result.isError()) {
                        return result.mapError();
                    }
                    converted.add(result.get());
                }
                return Result.success(converter.createList(converted));
            }

            @Override
            public <S> Result<List<T>> deserialize(DataConverter<S> converter, S data) {
                Result<List<S>> result = converter.asList(data);
                if (result.isError()) {
                    return result.mapError();
                }
                List<S> list = result.get();
                if (list.size() < minElements) {
                    return Result.error("List size is smaller than minimum: " + list.size() + " < " + minElements);
                }
                if (list.size() > maxElements) {
                    return Result.error("List size is bigger than maximum: " + list.size() + " > " + maxElements);
                }
                ArrayList converted = new ArrayList();
                for (S value : list) {
                    Result element = Codec.this.deserialize(converter, value);
                    if (element.isError()) {
                        return element.mapError();
                    }
                    converted.add(element.get());
                }
                return Result.success(converted);
            }
        };
    }

    default public Codec<List<T>> optionalListOf() {
        return this.optionalListOf(Integer.MAX_VALUE);
    }

    default public Codec<List<T>> optionalListOf(int maxElements) {
        return this.optionalListOf(0, maxElements);
    }

    default public Codec<List<T>> optionalListOf(int minElements, int maxElements) {
        final Codec<List<T>> listCodec = this.listOf(minElements, maxElements);
        return new Codec<List<T>>(){

            @Override
            public <S> Result<List<T>> deserialize(DataConverter<S> converter, S data) {
                Result single = Codec.this.deserialize(converter, data);
                if (single.isError()) {
                    return listCodec.deserialize(converter, data);
                }
                ArrayList list = new ArrayList();
                list.add(single.get());
                return Result.success(list);
            }

            @Override
            public <S> Result<S> serialize(DataConverter<S> converter, List<T> element) {
                if (element.size() == 1) {
                    return Codec.this.serialize(converter, element.get(0));
                }
                return listCodec.serialize(converter, element);
            }
        };
    }

    default public Codec<List<T>> nonEmptyList() {
        return this.listOf().verified(list -> {
            if (list.isEmpty()) {
                return Result.error("List is empty");
            }
            return null;
        });
    }

    default public Codec<List<T>> compactListOf() {
        return Codec.compactList(this, this.listOf());
    }

    default public Codec<T> verified(final Function<T, Result<Void>> verifier) {
        return new Codec<T>(){

            @Override
            public <S> Result<S> serialize(DataConverter<S> converter, T element) {
                Result verify = (Result)verifier.apply(element);
                if (verify != null && verify.isError()) {
                    return verify.mapError();
                }
                return Codec.this.serialize(converter, element);
            }

            @Override
            public <S> Result<T> deserialize(DataConverter<S> converter, S data) {
                Result result = Codec.this.deserialize(converter, data);
                if (result.isError()) {
                    return result;
                }
                Result verify = (Result)verifier.apply(result.get());
                if (verify != null && verify.isError()) {
                    return verify.mapError();
                }
                return result;
            }
        };
    }

    default public Codec<T> converterVerified(final BiFunction<DataConverter<?>, T, Result<Void>> verifier) {
        return new Codec<T>(){

            @Override
            public <S> Result<S> serialize(DataConverter<S> converter, T element) {
                Result verify = (Result)verifier.apply(converter, element);
                if (verify != null && verify.isError()) {
                    return verify.mapError();
                }
                return Codec.this.serialize(converter, element);
            }

            @Override
            public <S> Result<T> deserialize(DataConverter<S> converter, S data) {
                Result result = Codec.this.deserialize(converter, data);
                if (result.isError()) {
                    return result;
                }
                Result verify = (Result)verifier.apply(converter, result.get());
                if (verify != null && verify.isError()) {
                    return verify.mapError();
                }
                return result;
            }
        };
    }

    default public FieldMapCodec.Builder.Stage1<T> mapCodec(String key) {
        return FieldMapCodec.builder(this, key);
    }
}

