/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.mapcodec;

import com.viaversion.viaversion.libs.mcstructs.converter.DataConverter;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import java.util.Map;

@FunctionalInterface
public interface MapSerializer<T> {
    public <S> Result<Map<S, S>> serialize(DataConverter<S> var1, Map<S, S> var2, T var3);
}

