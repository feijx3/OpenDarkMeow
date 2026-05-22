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
import java.util.UUID;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="uuid", type=UUID.class), @RecordComponents.Value(name="signatureBytes", type=byte[].class)})
public final class PlayerMessageSignature
extends J_L_Record {
    private final UUID uuid;
    private final byte[] signatureBytes;

    public PlayerMessageSignature(UUID uuid, byte[] signatureBytes) {
        this.uuid = uuid;
        this.signatureBytes = signatureBytes;
    }

    @Override
    public final String toString() {
        return PlayerMessageSignature.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return PlayerMessageSignature.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return PlayerMessageSignature.jvmdowngrader$equals$equals(this, o2);
    }

    public UUID uuid() {
        return this.uuid;
    }

    public byte[] signatureBytes() {
        return this.signatureBytes;
    }

    private static String jvmdowngrader$toString$toString(PlayerMessageSignature playerMessageSignature) {
        PlayerMessageSignature playerMessageSignature2 = playerMessageSignature;
        return "PlayerMessageSignature[" + "uuid=" + playerMessageSignature.uuid + ", " + "signatureBytes=" + playerMessageSignature.signatureBytes + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(PlayerMessageSignature playerMessageSignature) {
        Object[] objectArray = new Object[]{playerMessageSignature.uuid, playerMessageSignature.signatureBytes};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(PlayerMessageSignature playerMessageSignature, Object object) {
        if (playerMessageSignature == object) {
            return true;
        }
        if (object != null && object instanceof PlayerMessageSignature) {
            PlayerMessageSignature playerMessageSignature2 = (PlayerMessageSignature)object;
            if (Objects.equals(playerMessageSignature.uuid, playerMessageSignature2.uuid) && Objects.equals(playerMessageSignature.signatureBytes, playerMessageSignature2.signatureBytes)) {
                return true;
            }
        }
        return false;
    }
}

