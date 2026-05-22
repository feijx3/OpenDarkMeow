/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.data.version;

import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.data.version.StructuredDataKeys1_21_2;
import com.viaversion.viaversion.api.minecraft.item.data.AdventureModePredicate;
import com.viaversion.viaversion.api.type.types.version.VersionedTypesHolder;

public class StructuredDataKeys1_21_5
extends StructuredDataKeys1_21_2 {
    public final StructuredDataKey<AdventureModePredicate> canPlaceOn;
    public final StructuredDataKey<AdventureModePredicate> canBreak;

    public StructuredDataKeys1_21_5(VersionedTypesHolder types) {
        super(types);
        AdventureModePredicate.AdventureModePredicateType1_21_5 adventureModePredicateType = new AdventureModePredicate.AdventureModePredicateType1_21_5(types.structuredDataArray());
        this.canPlaceOn = this.add("can_place_on", adventureModePredicateType);
        this.canBreak = this.add("can_break", adventureModePredicateType);
        this.unsupportedForOps.add(this.canPlaceOn);
        this.unsupportedForOps.add(this.canBreak);
    }
}

