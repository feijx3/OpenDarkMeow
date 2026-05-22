/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.KeyType;
import com.viaversion.viaversion.util.Key;

public class TagKeyType
extends KeyType {
    @Override
    public void write(Ops ops, Key value) {
        Types.STRING.write(ops, TagKeyType.jvmdowngrader$concat$write$1(value.toString()));
    }

    private static String jvmdowngrader$concat$write$1(String string) {
        return "#" + string;
    }
}

