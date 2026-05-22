/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.impl;

import com.viaversion.viaversion.libs.mcstructs.converter.DataConverter;
import com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.MapCodec;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FuzzyMapCodec<T>
implements MapCodec<T> {
    private final List<MapCodec<? extends T>> codecs;
    private final Function<T, MapCodec<? extends T>> selector;

    public FuzzyMapCodec(List<MapCodec<? extends T>> codecs, Function<T, MapCodec<? extends T>> selector) {
        this.codecs = codecs;
        this.selector = selector;
    }

    @Override
    public <S> Result<Map<S, S>> serialize(DataConverter<S> converter, Map<S, S> map, T element) {
        MapCodec<T> codec = this.selector.apply(element);
        return codec.serialize(converter, map, element);
    }

    @Override
    public <S> Result<T> deserialize(DataConverter<S> converter, Map<S, S> map) {
        for (MapCodec<T> codec : this.codecs) {
            Result result = codec.deserialize(converter, map);
            if (!result.isSuccessful()) continue;
            return Result.success(result.get());
        }
        return Result.error("No codec could deserialize the given map");
    }
}

