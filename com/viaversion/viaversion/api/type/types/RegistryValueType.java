/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.VarIntType;
import com.viaversion.viaversion.util.Key;

public final class RegistryValueType
extends VarIntType {
    private final String[] names;

    public RegistryValueType(String ... names) {
        this.names = names;
        for (int i2 = 0; i2 < names.length; ++i2) {
            names[i2] = Key.namespaced(names[i2]);
        }
    }

    @Override
    public void write(Ops ops, Integer value) {
        Types.STRING.write(ops, this.names[value]);
    }

    public String[] names() {
        return this.names;
    }
}

