/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_21_4;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.libs.mcstructs.core.Identifier;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.verify.TextVerifier;

public interface TextVerifier_v1_21_4
extends TextVerifier {
    default public boolean verifyRegistryItem(Identifier id) {
        return true;
    }

    default public boolean verifyRegistryEntity(Identifier id) {
        return true;
    }

    default public boolean verifyDataComponents(CompoundTag tag) {
        return true;
    }

    default public boolean verifySelector(String selector) {
        return true;
    }
}

