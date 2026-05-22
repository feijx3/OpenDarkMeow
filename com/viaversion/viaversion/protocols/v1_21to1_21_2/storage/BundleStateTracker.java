/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21to1_21_2.storage;

import com.viaversion.viaversion.api.connection.StorableObject;

public class BundleStateTracker
implements StorableObject {
    private boolean bundling;

    public boolean isBundling() {
        return this.bundling;
    }

    public void toggleBundling() {
        this.bundling = !this.bundling;
    }
}

