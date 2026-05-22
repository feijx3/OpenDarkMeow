/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.protocol;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.protocol.version.ServerProtocolVersion;
import java.util.Arrays;
import java.util.Objects;
import java.util.SortedSet;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="lowestSupportedProtocolVersion", type=ProtocolVersion.class), @RecordComponents.Value(name="highestSupportedProtocolVersion", type=ProtocolVersion.class), @RecordComponents.Value(name="supportedProtocolVersions", type=SortedSet.class)})
public final class ServerProtocolVersionRange
extends J_L_Record
implements ServerProtocolVersion {
    private final ProtocolVersion lowestSupportedProtocolVersion;
    private final ProtocolVersion highestSupportedProtocolVersion;
    private final SortedSet<ProtocolVersion> supportedProtocolVersions;

    public ServerProtocolVersionRange(ProtocolVersion lowestSupportedProtocolVersion, ProtocolVersion highestSupportedProtocolVersion, SortedSet<ProtocolVersion> supportedProtocolVersions) {
        this.lowestSupportedProtocolVersion = lowestSupportedProtocolVersion;
        this.highestSupportedProtocolVersion = highestSupportedProtocolVersion;
        this.supportedProtocolVersions = supportedProtocolVersions;
    }

    @Override
    public final String toString() {
        return ServerProtocolVersionRange.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return ServerProtocolVersionRange.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return ServerProtocolVersionRange.jvmdowngrader$equals$equals(this, o2);
    }

    @Override
    public ProtocolVersion lowestSupportedProtocolVersion() {
        return this.lowestSupportedProtocolVersion;
    }

    @Override
    public ProtocolVersion highestSupportedProtocolVersion() {
        return this.highestSupportedProtocolVersion;
    }

    @Override
    public SortedSet<ProtocolVersion> supportedProtocolVersions() {
        return this.supportedProtocolVersions;
    }

    private static String jvmdowngrader$toString$toString(ServerProtocolVersionRange serverProtocolVersionRange) {
        ServerProtocolVersionRange serverProtocolVersionRange2 = serverProtocolVersionRange;
        return "ServerProtocolVersionRange[" + "lowestSupportedProtocolVersion=" + serverProtocolVersionRange.lowestSupportedProtocolVersion + ", " + "highestSupportedProtocolVersion=" + serverProtocolVersionRange.highestSupportedProtocolVersion + ", " + "supportedProtocolVersions=" + serverProtocolVersionRange.supportedProtocolVersions + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(ServerProtocolVersionRange serverProtocolVersionRange) {
        Object[] objectArray = new Object[]{serverProtocolVersionRange.lowestSupportedProtocolVersion, serverProtocolVersionRange.highestSupportedProtocolVersion, serverProtocolVersionRange.supportedProtocolVersions};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(ServerProtocolVersionRange serverProtocolVersionRange, Object object) {
        if (serverProtocolVersionRange == object) {
            return true;
        }
        if (object != null && object instanceof ServerProtocolVersionRange) {
            ServerProtocolVersionRange serverProtocolVersionRange2 = (ServerProtocolVersionRange)object;
            if (Objects.equals(serverProtocolVersionRange.lowestSupportedProtocolVersion, serverProtocolVersionRange2.lowestSupportedProtocolVersion) && Objects.equals(serverProtocolVersionRange.highestSupportedProtocolVersion, serverProtocolVersionRange2.highestSupportedProtocolVersion) && Objects.equals(serverProtocolVersionRange.supportedProtocolVersions, serverProtocolVersionRange2.supportedProtocolVersions)) {
                return true;
            }
        }
        return false;
    }
}

