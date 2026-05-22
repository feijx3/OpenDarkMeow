/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.viaversion.viaversion.libs.mcstructs.converter;

import com.viaversion.viaversion.libs.mcstructs.converter.DataConverter;
import com.viaversion.viaversion.libs.mcstructs.converter.codec.Codec;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import java.util.Objects;
import lombok.Generated;

public class SerializedData<T> {
    private final T data;
    private final DataConverter<T> converter;

    public <S> Result<S> convert(DataConverter<S> converter) {
        if (this.converter == converter) {
            return Result.success(this.data);
        }
        return Result.success(this.converter.convertTo(converter, this.data));
    }

    public <O> Result<O> deserialize(Codec<O> codec) {
        return codec.deserialize(this.converter, this.data);
    }

    public String toString() {
        return "SerializedData{" + this.data + "}";
    }

    public boolean equals(Object o2) {
        if (o2 == null || this.getClass() != o2.getClass()) {
            return false;
        }
        SerializedData that = (SerializedData)o2;
        return Objects.equals(this.data, that.data);
    }

    public int hashCode() {
        return Objects.hash(this.data);
    }

    @Generated
    public T getData() {
        return this.data;
    }

    @Generated
    public DataConverter<T> getConverter() {
        return this.converter;
    }

    @Generated
    public SerializedData(T data, DataConverter<T> converter) {
        this.data = data;
        this.converter = converter;
    }
}

