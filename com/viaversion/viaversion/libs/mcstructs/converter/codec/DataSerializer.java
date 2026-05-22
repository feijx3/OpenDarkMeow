/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.codec;

import com.viaversion.viaversion.libs.mcstructs.converter.DataConverter;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;

@FunctionalInterface
public interface DataSerializer<T> {
    public <S> Result<S> serialize(DataConverter<S> var1, T var2);
}

