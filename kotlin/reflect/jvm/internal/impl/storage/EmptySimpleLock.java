/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.reflect.jvm.internal.impl.storage.SimpleLock;
import org.jetbrains.annotations.NotNull;

public final class EmptySimpleLock
implements SimpleLock {
    @NotNull
    public static final EmptySimpleLock INSTANCE = new EmptySimpleLock();

    private EmptySimpleLock() {
    }

    @Override
    public void lock() {
    }

    @Override
    public void unlock() {
    }
}

