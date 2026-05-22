/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.Pair;
import com.viaversion.viaversion.libs.fastutil.ints.IntReferenceImmutablePair;

public interface IntReferencePair<V>
extends Pair<Integer, V> {
    public int leftInt();

    @Override
    @Deprecated
    default public Integer left() {
        return this.leftInt();
    }

    default public IntReferencePair<V> left(int l2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default public IntReferencePair<V> left(Integer l2) {
        return this.left((int)l2);
    }

    default public int firstInt() {
        return this.leftInt();
    }

    @Override
    @Deprecated
    default public Integer first() {
        return this.firstInt();
    }

    default public IntReferencePair<V> first(int l2) {
        return this.left(l2);
    }

    @Deprecated
    default public IntReferencePair<V> first(Integer l2) {
        return this.first((int)l2);
    }

    default public int keyInt() {
        return this.firstInt();
    }

    @Override
    @Deprecated
    default public Integer key() {
        return this.keyInt();
    }

    default public IntReferencePair<V> key(int l2) {
        return this.left(l2);
    }

    @Deprecated
    default public IntReferencePair<V> key(Integer l2) {
        return this.key((int)l2);
    }

    public static <V> IntReferencePair<V> of(int left, V right) {
        return new IntReferenceImmutablePair<V>(left, right);
    }
}

