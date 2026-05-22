/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_8to1_9.storage;

import com.viaversion.viaversion.api.minecraft.ClientWorld;
import java.util.HashSet;
import java.util.Set;

public class ClientWorld1_9
extends ClientWorld {
    private final Set<Long> loadedChunks = new HashSet<Long>();

    public Set<Long> getLoadedChunks() {
        return this.loadedChunks;
    }
}

