/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 */
package com.viaversion.viaversion.api.minecraft.entities;

import org.checkerframework.checker.nullness.qual.Nullable;

public interface EntityType {
    public int getId();

    public @Nullable EntityType getParent();

    public String name();

    public String identifier();

    public boolean isAbstractType();

    default public boolean is(EntityType type) {
        return this == type;
    }

    default public boolean isOrHasParent(EntityType type) {
        EntityType parent = this;
        do {
            if (parent != type) continue;
            return true;
        } while ((parent = parent.getParent()) != null);
        return false;
    }
}

