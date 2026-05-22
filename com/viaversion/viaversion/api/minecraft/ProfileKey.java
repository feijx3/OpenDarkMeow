/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.minecraft;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="expiresAt", type=long.class), @RecordComponents.Value(name="publicKey", type=byte[].class), @RecordComponents.Value(name="keySignature", type=byte[].class)})
public final class ProfileKey
extends J_L_Record {
    private final long expiresAt;
    private final byte[] publicKey;
    private final byte[] keySignature;

    public ProfileKey(long expiresAt, byte[] publicKey, byte[] keySignature) {
        this.expiresAt = expiresAt;
        this.publicKey = publicKey;
        this.keySignature = keySignature;
    }

    @Override
    public final String toString() {
        return ProfileKey.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return ProfileKey.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return ProfileKey.jvmdowngrader$equals$equals(this, o2);
    }

    public long expiresAt() {
        return this.expiresAt;
    }

    public byte[] publicKey() {
        return this.publicKey;
    }

    public byte[] keySignature() {
        return this.keySignature;
    }

    private static String jvmdowngrader$toString$toString(ProfileKey profileKey) {
        ProfileKey profileKey2 = profileKey;
        return "ProfileKey[" + "expiresAt=" + profileKey.expiresAt + ", " + "publicKey=" + profileKey.publicKey + ", " + "keySignature=" + profileKey.keySignature + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(ProfileKey profileKey) {
        Object[] objectArray = new Object[]{profileKey.expiresAt, profileKey.publicKey, profileKey.keySignature};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(ProfileKey profileKey, Object object) {
        if (profileKey == object) {
            return true;
        }
        if (object != null && object instanceof ProfileKey) {
            ProfileKey profileKey2 = (ProfileKey)object;
            if (profileKey.expiresAt == profileKey2.expiresAt && Objects.equals(profileKey.publicKey, profileKey2.publicKey) && Objects.equals(profileKey.keySignature, profileKey2.keySignature)) {
                return true;
            }
        }
        return false;
    }
}

