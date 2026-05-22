/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 */
package com.viaversion.viaversion.api.minecraft;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.minecraft.EitherHolder;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.util.EitherImpl;

final class EitherHolderImpl<T>
extends EitherImpl<Holder<T>, String>
implements EitherHolder<T> {
    EitherHolderImpl(Holder<T> left, String value) {
        super(left, value);
    }

    @Override
    public boolean hasHolder() {
        return this.isLeft();
    }

    @Override
    public boolean hasKey() {
        return this.isRight();
    }

    @Override
    public Holder<T> holder() {
        Preconditions.checkArgument((boolean)this.hasHolder(), (Object)"Either does not have a holder");
        return (Holder)this.left();
    }

    @Override
    public String key() {
        Preconditions.checkArgument((boolean)this.hasKey(), (Object)"Either does not have a key");
        return (String)this.right();
    }
}

