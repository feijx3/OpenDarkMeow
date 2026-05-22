/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.protocol;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.ProtocolPathEntry;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="outputProtocolVersion", type=ProtocolVersion.class), @RecordComponents.Value(name="protocol", type=Protocol.class)})
public final class ProtocolPathEntryImpl
extends J_L_Record
implements ProtocolPathEntry {
    private final ProtocolVersion outputProtocolVersion;
    private final Protocol<?, ?, ?, ?> protocol;

    public ProtocolPathEntryImpl(ProtocolVersion outputProtocolVersion, Protocol<?, ?, ?, ?> protocol) {
        this.outputProtocolVersion = outputProtocolVersion;
        this.protocol = protocol;
    }

    @Override
    public final String toString() {
        return ProtocolPathEntryImpl.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return ProtocolPathEntryImpl.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return ProtocolPathEntryImpl.jvmdowngrader$equals$equals(this, o2);
    }

    @Override
    public ProtocolVersion outputProtocolVersion() {
        return this.outputProtocolVersion;
    }

    @Override
    public Protocol<?, ?, ?, ?> protocol() {
        return this.protocol;
    }

    private static String jvmdowngrader$toString$toString(ProtocolPathEntryImpl protocolPathEntryImpl) {
        ProtocolPathEntryImpl protocolPathEntryImpl2 = protocolPathEntryImpl;
        return "ProtocolPathEntryImpl[" + "outputProtocolVersion=" + protocolPathEntryImpl.outputProtocolVersion + ", " + "protocol=" + protocolPathEntryImpl.protocol + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(ProtocolPathEntryImpl protocolPathEntryImpl) {
        Object[] objectArray = new Object[]{protocolPathEntryImpl.outputProtocolVersion, protocolPathEntryImpl.protocol};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(ProtocolPathEntryImpl protocolPathEntryImpl, Object object) {
        if (protocolPathEntryImpl == object) {
            return true;
        }
        if (object != null && object instanceof ProtocolPathEntryImpl) {
            ProtocolPathEntryImpl protocolPathEntryImpl2 = (ProtocolPathEntryImpl)object;
            if (Objects.equals(protocolPathEntryImpl.outputProtocolVersion, protocolPathEntryImpl2.outputProtocolVersion) && Objects.equals(protocolPathEntryImpl.protocol, protocolPathEntryImpl2.protocol)) {
                return true;
            }
        }
        return false;
    }
}

