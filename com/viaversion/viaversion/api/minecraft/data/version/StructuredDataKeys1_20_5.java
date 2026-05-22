/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.data.version;

import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.data.version.VersionedStructuredDataKeys;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.type.types.version.VersionedTypesHolder;

public class StructuredDataKeys1_20_5
extends VersionedStructuredDataKeys {
    public final StructuredDataKey<Item[]> container;
    public final StructuredDataKey<Item[]> chargedProjectiles;
    public final StructuredDataKey<Item[]> bundleContents;

    public StructuredDataKeys1_20_5(VersionedTypesHolder types) {
        this.container = this.add("container", types.itemArray());
        this.chargedProjectiles = this.add("charged_projectiles", types.itemArray());
        this.bundleContents = this.add("bundle_contents", types.itemArray());
    }
}

