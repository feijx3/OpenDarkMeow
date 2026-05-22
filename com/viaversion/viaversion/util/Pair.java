/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.util;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="key", type=Object.class), @RecordComponents.Value(name="value", type=Object.class)})
public final class Pair<X, Y>
extends J_L_Record {
    private final @Nullable X key;
    private final @Nullable Y value;

    public Pair(@Nullable X key, @Nullable Y value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public final String toString() {
        return Pair.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return Pair.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return Pair.jvmdowngrader$equals$equals(this, o2);
    }

    public @Nullable X key() {
        return this.key;
    }

    public @Nullable Y value() {
        return this.value;
    }

    private static String jvmdowngrader$toString$toString(Pair pair) {
        Pair pair2 = pair;
        return "Pair[" + "key=" + pair.key + ", " + "value=" + pair.value + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(Pair pair) {
        Object[] objectArray = new Object[]{pair.key, pair.value};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(Pair pair, Object object) {
        if (pair == object) {
            return true;
        }
        if (object != null && object instanceof Pair) {
            Pair pair2 = (Pair)object;
            if (Objects.equals(pair.key, pair2.key) && Objects.equals(pair.value, pair2.value)) {
                return true;
            }
        }
        return false;
    }
}

