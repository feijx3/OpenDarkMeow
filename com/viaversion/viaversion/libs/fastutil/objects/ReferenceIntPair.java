/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.Pair;
import com.viaversion.viaversion.libs.fastutil.objects.ReferenceIntImmutablePair;

public interface ReferenceIntPair<K>
extends Pair<K, Integer> {
    public int rightInt();

    @Override
    @Deprecated
    default public Integer right() {
        return this.rightInt();
    }

    default public ReferenceIntPair<K> right(int r2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default public ReferenceIntPair<K> right(Integer l2) {
        return this.right((int)l2);
    }

    default public int secondInt() {
        return this.rightInt();
    }

    @Override
    @Deprecated
    default public Integer second() {
        return this.secondInt();
    }

    default public ReferenceIntPair<K> second(int r2) {
        return this.right(r2);
    }

    @Deprecated
    default public ReferenceIntPair<K> second(Integer l2) {
        return this.second((int)l2);
    }

    default public int valueInt() {
        return this.rightInt();
    }

    @Override
    @Deprecated
    default public Integer value() {
        return this.valueInt();
    }

    default public ReferenceIntPair<K> value(int r2) {
        return this.right(r2);
    }

    @Deprecated
    default public ReferenceIntPair<K> value(Integer l2) {
        return this.value((int)l2);
    }

    public static <K> ReferenceIntPair<K> of(K left, int right) {
        return new ReferenceIntImmutablePair<K>(left, right);
    }
}

