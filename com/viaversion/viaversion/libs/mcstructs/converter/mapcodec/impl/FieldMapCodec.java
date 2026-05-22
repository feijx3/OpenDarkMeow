/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.impl;

import com.viaversion.viaversion.libs.mcstructs.converter.DataConverter;
import com.viaversion.viaversion.libs.mcstructs.converter.codec.Codec;
import com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.MapCodec;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;
import lombok.Generated;

public class FieldMapCodec<T>
implements MapCodec<T> {
    private final Codec<T> codec;
    private final String fieldName;
    private final boolean optional;
    private final boolean lenient;

    public static <T> Builder.Stage1<T> builder(Codec<T> codec, String fieldName) {
        return new Builder.Stage1<T>(codec, fieldName);
    }

    public FieldMapCodec(Codec<T> codec, String fieldName, boolean optional, boolean lenient) {
        if (lenient && !optional) {
            throw new IllegalArgumentException("Lenient can only be true if optional is true");
        }
        this.codec = codec;
        this.fieldName = fieldName;
        this.optional = optional;
        this.lenient = lenient;
    }

    @Override
    public <S> Result<Map<S, S>> serialize(DataConverter<S> converter, Map<S, S> map, T element) {
        if (element == null) {
            return Result.success(map);
        }
        Result<S> result = this.codec.serialize(converter, element);
        if (result.isError()) {
            return result.mapError();
        }
        map.put(converter.createString(this.fieldName), result.get());
        return Result.success(map);
    }

    @Override
    public <S> Result<T> deserialize(DataConverter<S> converter, Map<S, S> map) {
        S value = map.get(converter.createString(this.fieldName));
        if (value == null) {
            if (this.optional) {
                return Result.success(null);
            }
            return Result.error("Key not found in map: " + this.fieldName);
        }
        Result deserialized = this.codec.deserialize(converter, value);
        if (deserialized.isError() && this.lenient) {
            return Result.success(null);
        }
        return deserialized;
    }

    public static abstract class Builder<T> {
        protected final Codec<T> codec;
        protected final String fieldName;

        protected abstract MapCodec<T> build();

        @Generated
        public Builder(Codec<T> codec, String fieldName) {
            this.codec = codec;
            this.fieldName = fieldName;
        }

        public static class Stage3<T>
        extends OptionalStage<T> {
            public Stage3(Codec<T> codec, String fieldName) {
                super(codec, fieldName);
            }

            @Override
            protected MapCodec<T> build() {
                return new FieldMapCodec(this.codec, this.fieldName, true, true);
            }
        }

        public static class Stage2<T>
        extends OptionalStage<T> {
            public Stage2(Codec<T> codec, String fieldName) {
                super(codec, fieldName);
            }

            public Stage3<T> lenient() {
                return new Stage3(this.codec, this.fieldName);
            }

            @Override
            protected MapCodec<T> build() {
                return new FieldMapCodec(this.codec, this.fieldName, true, false);
            }
        }

        public static abstract class OptionalStage<T>
        extends Builder<T> {
            public OptionalStage(Codec<T> codec, String fieldName) {
                super(codec, fieldName);
            }

            public MapCodec<T> defaulted(T defaultValue) {
                return this.build().defaulted(defaultValue);
            }

            public MapCodec<T> defaulted(Predicate<T> isDefault, Supplier<T> defaultSupplier) {
                return this.build().defaulted(isDefault, defaultSupplier);
            }

            public MapCodec<T> elseGet(Supplier<T> defaultSupplier) {
                return this.build().elseGet(defaultSupplier);
            }
        }

        public static class Stage1<T>
        extends Builder<T> {
            public Stage1(Codec<T> codec, String fieldName) {
                super(codec, fieldName);
            }

            public Stage2<T> optional() {
                return new Stage2(this.codec, this.fieldName);
            }

            public MapCodec<T> required() {
                return this.build();
            }

            @Override
            protected MapCodec<T> build() {
                return new FieldMapCodec(this.codec, this.fieldName, false, false);
            }
        }
    }
}

