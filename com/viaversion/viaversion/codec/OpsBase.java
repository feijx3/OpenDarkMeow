/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.codec;

import com.viaversion.viaversion.api.minecraft.codec.CodecContext;
import com.viaversion.viaversion.api.minecraft.codec.Ops;

public abstract class OpsBase
implements Ops {
    private final CodecContext context;

    protected OpsBase(CodecContext context) {
        this.context = context;
    }

    @Override
    public CodecContext context() {
        return this.context;
    }
}

