/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.codec;

@FunctionalInterface
public interface ThrowingFunction<T, R> {
    public R apply(T var1) throws Throwable;
}

