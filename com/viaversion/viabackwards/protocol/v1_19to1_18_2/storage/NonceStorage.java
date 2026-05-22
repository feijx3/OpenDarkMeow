/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viabackwards.protocol.v1_19to1_18_2.storage;

import ViaBackwards.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.connection.StorableObject;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="nonce", type=byte[].class)})
public final class NonceStorage
extends J_L_Record
implements StorableObject {
    private final byte @Nullable [] nonce;

    public NonceStorage(byte @Nullable [] nonce) {
        this.nonce = nonce;
    }

    @Override
    public final String toString() {
        return NonceStorage.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return NonceStorage.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return NonceStorage.jvmdowngrader$equals$equals(this, o2);
    }

    public byte @Nullable [] nonce() {
        return this.nonce;
    }

    private static String jvmdowngrader$toString$toString(NonceStorage nonceStorage) {
        NonceStorage nonceStorage2 = nonceStorage;
        return "NonceStorage[" + "nonce=" + nonceStorage.nonce + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(NonceStorage nonceStorage) {
        Object[] objectArray = new Object[]{nonceStorage.nonce};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(NonceStorage nonceStorage, Object object) {
        if (nonceStorage == object) {
            return true;
        }
        if (object != null && object instanceof NonceStorage) {
            NonceStorage nonceStorage2 = (NonceStorage)object;
            if (Objects.equals(nonceStorage.nonce, nonceStorage2.nonce)) {
                return true;
            }
        }
        return false;
    }
}

