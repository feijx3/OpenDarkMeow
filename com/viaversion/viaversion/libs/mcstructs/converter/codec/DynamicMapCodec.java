/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.codec;

import com.viaversion.viaversion.libs.mcstructs.converter.DataConverter;
import com.viaversion.viaversion.libs.mcstructs.converter.codec.Codec;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class DynamicMapCodec<K, V>
implements Codec<Map<K, V>> {
    private final Codec<K> keyCodec;
    private final Function<K, Codec<? extends V>> keyToValueCodec;

    public DynamicMapCodec(Codec<K> keyCodec, Function<K, Codec<? extends V>> keyToValueCodec) {
        this.keyCodec = keyCodec;
        this.keyToValueCodec = keyToValueCodec;
    }

    @Override
    public <S> Result<S> serialize(DataConverter<S> converter, Map<K, V> element) {
        HashMap<S, S> out = new HashMap<S, S>();
        for (Map.Entry<K, V> entry : element.entrySet()) {
            Result<S> key = this.keyCodec.serialize(converter, entry.getKey());
            if (key.isError()) {
                return key.mapError();
            }
            Codec<V> valueCodec = this.keyToValueCodec.apply(entry.getKey());
            Result<S> value = valueCodec.serialize(converter, entry.getValue());
            if (value.isError()) {
                return value.mapError();
            }
            out.put(key.get(), value.get());
        }
        return converter.createMergedMap(out);
    }

    @Override
    public <S> Result<Map<K, V>> deserialize(DataConverter<S> converter, S data) {
        Result<Map<S, S>> mapResult = converter.asMap(data);
        return mapResult.mapResult(map -> {
            HashMap out = new HashMap();
            for (Map.Entry entry : map.entrySet()) {
                Result key = this.keyCodec.deserialize(converter, entry.getKey());
                if (key.isError()) {
                    return key.mapError();
                }
                Codec<V> valueCodec = this.keyToValueCodec.apply(key.get());
                if (valueCodec == null) {
                    return Result.error("No codec found for key: " + key.get());
                }
                Result value = valueCodec.deserialize(converter, entry.getValue());
                if (value.isError()) {
                    return value.mapError();
                }
                out.put(key.get(), value.get());
            }
            return Result.success(out);
        });
    }
}

