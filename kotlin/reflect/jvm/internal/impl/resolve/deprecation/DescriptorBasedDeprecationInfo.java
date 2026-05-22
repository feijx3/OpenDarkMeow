/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.deprecation;

import kotlin.reflect.jvm.internal.impl.resolve.deprecation.DeprecationInfo;

public abstract class DescriptorBasedDeprecationInfo
extends DeprecationInfo {
    @Override
    public boolean getPropagatesToOverrides() {
        return this.getForcePropagationToOverrides();
    }

    public boolean getForcePropagationToOverrides() {
        return false;
    }
}

