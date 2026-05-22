/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.gson;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

public interface FieldNamingStrategy {
    public String translateName(Field var1);

    default public List<String> alternateNames(Field f2) {
        return Collections.emptyList();
    }
}

