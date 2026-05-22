/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.codec;

import com.viaversion.viaversion.libs.mcstructs.converter.DataConverter;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;

@FunctionalInterface
public interface DataDeserializer<T> {
    public <S> Result<T> deserialize(DataConverter<S> var1, S var2);
}

