/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.protocols.v1_19_1to1_19_3.storage;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.connection.StorableObject;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="nonce", type=byte[].class)})
public final class NonceStorage1_19_3
extends J_L_Record
implements StorableObject {
    private final byte @Nullable [] nonce;

    public NonceStorage1_19_3(byte @Nullable [] nonce) {
        this.nonce = nonce;
    }

    @Override
    public final String toString() {
        return NonceStorage1_19_3.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return NonceStorage1_19_3.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return NonceStorage1_19_3.jvmdowngrader$equals$equals(this, o2);
    }

    public byte @Nullable [] nonce() {
        return this.nonce;
    }

    private static String jvmdowngrader$toString$toString(NonceStorage1_19_3 nonceStorage1_19_3) {
        NonceStorage1_19_3 nonceStorage1_19_32 = nonceStorage1_19_3;
        return "NonceStorage1_19_3[" + "nonce=" + nonceStorage1_19_3.nonce + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(NonceStorage1_19_3 nonceStorage1_19_3) {
        Object[] objectArray = new Object[]{nonceStorage1_19_3.nonce};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(NonceStorage1_19_3 nonceStorage1_19_3, Object object) {
        if (nonceStorage1_19_3 == object) {
            return true;
        }
        if (object != null && object instanceof NonceStorage1_19_3) {
            NonceStorage1_19_3 nonceStorage1_19_32 = (NonceStorage1_19_3)object;
            if (Objects.equals(nonceStorage1_19_3.nonce, nonceStorage1_19_32.nonce)) {
                return true;
            }
        }
        return false;
    }
}

