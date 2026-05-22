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

@RecordComponents(value={@RecordComponents.Value(name="first", type=Object.class), @RecordComponents.Value(name="second", type=Object.class), @RecordComponents.Value(name="third", type=Object.class)})
public final class Triple<A, B, C>
extends J_L_Record {
    private final @Nullable A first;
    private final @Nullable B second;
    private final @Nullable C third;

    public Triple(@Nullable A first, @Nullable B second, @Nullable C third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public final String toString() {
        return Triple.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return Triple.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return Triple.jvmdowngrader$equals$equals(this, o2);
    }

    public @Nullable A first() {
        return this.first;
    }

    public @Nullable B second() {
        return this.second;
    }

    public @Nullable C third() {
        return this.third;
    }

    private static String jvmdowngrader$toString$toString(Triple triple) {
        Triple triple2 = triple;
        return "Triple[" + "first=" + triple.first + ", " + "second=" + triple.second + ", " + "third=" + triple.third + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(Triple triple) {
        Object[] objectArray = new Object[]{triple.first, triple.second, triple.third};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(Triple triple, Object object) {
        if (triple == object) {
            return true;
        }
        if (object != null && object instanceof Triple) {
            Triple triple2 = (Triple)object;
            if (Objects.equals(triple.first, triple2.first) && Objects.equals(triple.second, triple2.second) && Objects.equals(triple.third, triple2.third)) {
                return true;
            }
        }
        return false;
    }
}

