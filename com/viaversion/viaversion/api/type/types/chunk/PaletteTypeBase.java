/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 */
package com.viaversion.viaversion.api.type.types.chunk;

import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.api.type.Type;
import org.checkerframework.checker.nullness.qual.Nullable;

public abstract class PaletteTypeBase
extends Type<DataPalette> {
    protected PaletteTypeBase() {
        super(DataPalette.class);
    }

    public abstract int serializedSize(@Nullable DataPalette var1);
}

