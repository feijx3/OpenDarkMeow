/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.mapcodec;

import com.viaversion.viaversion.libs.mcstructs.converter.DataConverter;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import java.util.Map;

@FunctionalInterface
public interface MapDeserializer<T> {
    public <S> Result<T> deserialize(DataConverter<S> var1, Map<S, S> var2);
}

