/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.protocols.v1_18_2to1_19.storage;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.connection.StorableObject;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="nonce", type=byte[].class)})
public final class NonceStorage1_19
extends J_L_Record
implements StorableObject {
    private final byte[] nonce;

    public NonceStorage1_19(byte[] nonce) {
        this.nonce = nonce;
    }

    @Override
    public final String toString() {
        return NonceStorage1_19.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return NonceStorage1_19.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return NonceStorage1_19.jvmdowngrader$equals$equals(this, o2);
    }

    public byte[] nonce() {
        return this.nonce;
    }

    private static String jvmdowngrader$toString$toString(NonceStorage1_19 nonceStorage1_19) {
        NonceStorage1_19 nonceStorage1_192 = nonceStorage1_19;
        return "NonceStorage1_19[" + "nonce=" + nonceStorage1_19.nonce + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(NonceStorage1_19 nonceStorage1_19) {
        Object[] objectArray = new Object[]{nonceStorage1_19.nonce};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(NonceStorage1_19 nonceStorage1_19, Object object) {
        if (nonceStorage1_19 == object) {
            return true;
        }
        if (object != null && object instanceof NonceStorage1_19) {
            NonceStorage1_19 nonceStorage1_192 = (NonceStorage1_19)object;
            if (Objects.equals(nonceStorage1_19.nonce, nonceStorage1_192.nonce)) {
                return true;
            }
        }
        return false;
    }
}

