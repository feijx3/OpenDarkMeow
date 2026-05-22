/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 */
package com.viaversion.viaversion.api.platform;

import org.checkerframework.checker.nullness.qual.Nullable;

public interface UnsupportedSoftware {
    public String getName();

    public String getReason();

    public @Nullable String match();

    default public boolean findMatch() {
        return this.match() != null;
    }
}

