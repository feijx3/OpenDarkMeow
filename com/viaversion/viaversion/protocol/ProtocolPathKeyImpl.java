/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.protocol;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.protocol.ProtocolPathKey;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="clientProtocolVersion", type=ProtocolVersion.class), @RecordComponents.Value(name="serverProtocolVersion", type=ProtocolVersion.class)})
public final class ProtocolPathKeyImpl
extends J_L_Record
implements ProtocolPathKey {
    private final ProtocolVersion clientProtocolVersion;
    private final ProtocolVersion serverProtocolVersion;

    public ProtocolPathKeyImpl(ProtocolVersion clientProtocolVersion, ProtocolVersion serverProtocolVersion) {
        this.clientProtocolVersion = clientProtocolVersion;
        this.serverProtocolVersion = serverProtocolVersion;
    }

    @Override
    public final String toString() {
        return ProtocolPathKeyImpl.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return ProtocolPathKeyImpl.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return ProtocolPathKeyImpl.jvmdowngrader$equals$equals(this, o2);
    }

    @Override
    public ProtocolVersion clientProtocolVersion() {
        return this.clientProtocolVersion;
    }

    @Override
    public ProtocolVersion serverProtocolVersion() {
        return this.serverProtocolVersion;
    }

    private static String jvmdowngrader$toString$toString(ProtocolPathKeyImpl protocolPathKeyImpl) {
        ProtocolPathKeyImpl protocolPathKeyImpl2 = protocolPathKeyImpl;
        return "ProtocolPathKeyImpl[" + "clientProtocolVersion=" + protocolPathKeyImpl.clientProtocolVersion + ", " + "serverProtocolVersion=" + protocolPathKeyImpl.serverProtocolVersion + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(ProtocolPathKeyImpl protocolPathKeyImpl) {
        Object[] objectArray = new Object[]{protocolPathKeyImpl.clientProtocolVersion, protocolPathKeyImpl.serverProtocolVersion};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(ProtocolPathKeyImpl protocolPathKeyImpl, Object object) {
        if (protocolPathKeyImpl == object) {
            return true;
        }
        if (object != null && object instanceof ProtocolPathKeyImpl) {
            ProtocolPathKeyImpl protocolPathKeyImpl2 = (ProtocolPathKeyImpl)object;
            if (Objects.equals(protocolPathKeyImpl.clientProtocolVersion, protocolPathKeyImpl2.clientProtocolVersion) && Objects.equals(protocolPathKeyImpl.serverProtocolVersion, protocolPathKeyImpl2.serverProtocolVersion)) {
                return true;
            }
        }
        return false;
    }
}

