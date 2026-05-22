/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.gson.internal.bind;

import com.viaversion.viaversion.libs.gson.Gson;
import com.viaversion.viaversion.libs.gson.TypeAdapter;
import com.viaversion.viaversion.libs.gson.TypeAdapterFactory;
import com.viaversion.viaversion.libs.gson.annotations.SerializedName;
import com.viaversion.viaversion.libs.gson.reflect.TypeToken;
import com.viaversion.viaversion.libs.gson.stream.JsonReader;
import com.viaversion.viaversion.libs.gson.stream.JsonToken;
import com.viaversion.viaversion.libs.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class EnumTypeAdapter<T extends Enum<T>>
extends TypeAdapter<T> {
    static final TypeAdapterFactory FACTORY = new TypeAdapterFactory(){

        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class<T> rawType = typeToken.getRawType();
            if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                return null;
            }
            if (!rawType.isEnum()) {
                rawType = rawType.getSuperclass();
            }
            EnumTypeAdapter adapter = new EnumTypeAdapter(rawType);
            return adapter;
        }
    };
    private final Map<String, T> nameToConstant = new HashMap<String, T>();
    private final Map<String, T> stringToConstant = new HashMap<String, T>();
    private final Map<T, String> constantToName = new HashMap<T, String>();

    private EnumTypeAdapter(Class<T> classOfT) {
        try {
            AccessibleObject[] fields2 = classOfT.getDeclaredFields();
            int constantCount = 0;
            for (Field field : fields2) {
                if (!field.isEnumConstant()) continue;
                fields2[constantCount++] = field;
            }
            fields2 = Arrays.copyOf(fields2, constantCount);
            AccessibleObject.setAccessible(fields2, true);
            for (AccessibleObject accessibleObject : fields2) {
                Enum constant = (Enum)((Field)accessibleObject).get(null);
                String name = constant.name();
                String toStringVal = constant.toString();
                SerializedName annotation = ((Field)accessibleObject).getAnnotation(SerializedName.class);
                if (annotation != null) {
                    name = annotation.value();
                    for (String alternate : annotation.alternate()) {
                        this.nameToConstant.put(alternate, constant);
                    }
                }
                this.nameToConstant.put(name, constant);
                this.stringToConstant.put(toStringVal, constant);
                this.constantToName.put(constant, name);
            }
        }
        catch (IllegalAccessException e2) {
            throw new AssertionError((Object)e2);
        }
    }

    @Override
    public T read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        String key = in.nextString();
        Enum constant = (Enum)this.nameToConstant.get(key);
        return (T)(constant == null ? (Enum)this.stringToConstant.get(key) : constant);
    }

    @Override
    public void write(JsonWriter out, T value) throws IOException {
        out.value(value == null ? null : this.constantToName.get(value));
    }
}

