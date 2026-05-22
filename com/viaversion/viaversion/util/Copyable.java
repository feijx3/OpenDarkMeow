/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

import com.viaversion.nbt.tag.Tag;
import java.lang.reflect.Array;

public interface Copyable {
    public static <T> T copy(T object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Tag) {
            Tag tag = (Tag)object;
            return (T)tag.copy();
        }
        if (object instanceof Copyable) {
            Copyable copyable = (Copyable)object;
            return (T)copyable.copy();
        }
        if (object.getClass().isArray()) {
            Class<?> componentType = object.getClass().getComponentType();
            int length = Array.getLength(object);
            Object copy = Array.newInstance(componentType, length);
            if (componentType.isPrimitive()) {
                for (int i2 = 0; i2 < length; ++i2) {
                    Array.set(copy, i2, Array.get(object, i2));
                }
            } else {
                for (int i3 = 0; i3 < length; ++i3) {
                    Array.set(copy, i3, Copyable.copy(Array.get(object, i3)));
                }
            }
            return (T)copy;
        }
        return object;
    }

    public Object copy();
}

