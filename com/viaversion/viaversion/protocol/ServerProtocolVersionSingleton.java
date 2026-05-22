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
import com.viaversion.viaversion.libs.fastutil.objects.ObjectLinkedOpenHashSet;
import java.util.Arrays;
import java.util.Objects;
import java.util.SortedSet;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="protocolVersion", type=ProtocolVersion.class)})
public final class ServerProtocolVersionSingleton
extends J_L_Record
implements ServerProtocolVersion {
    private final ProtocolVersion protocolVersion;

    public ServerProtocolVersionSingleton(ProtocolVersion protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    @Override
    public ProtocolVersion lowestSupportedProtocolVersion() {
        return this.protocolVersion;
    }

    @Override
    public ProtocolVersion highestSupportedProtocolVersion() {
        return this.protocolVersion;
    }

    @Override
    public SortedSet<ProtocolVersion> supportedProtocolVersions() {
        ObjectLinkedOpenHashSet<ProtocolVersion> set = new ObjectLinkedOpenHashSet<ProtocolVersion>();
        set.add(this.protocolVersion);
        return set;
    }

    @Override
    public final String toString() {
        return ServerProtocolVersionSingleton.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return ServerProtocolVersionSingleton.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return ServerProtocolVersionSingleton.jvmdowngrader$equals$equals(this, o2);
    }

    public ProtocolVersion protocolVersion() {
        return this.protocolVersion;
    }

    private static String jvmdowngrader$toString$toString(ServerProtocolVersionSingleton serverProtocolVersionSingleton) {
        ServerProtocolVersionSingleton serverProtocolVersionSingleton2 = serverProtocolVersionSingleton;
        return "ServerProtocolVersionSingleton[" + "protocolVersion=" + serverProtocolVersionSingleton.protocolVersion + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(ServerProtocolVersionSingleton serverProtocolVersionSingleton) {
        Object[] objectArray = new Object[]{serverProtocolVersionSingleton.protocolVersion};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(ServerProtocolVersionSingleton serverProtocolVersionSingleton, Object object) {
        if (serverProtocolVersionSingleton == object) {
            return true;
        }
        if (object != null && object instanceof ServerProtocolVersionSingleton) {
            ServerProtocolVersionSingleton serverProtocolVersionSingleton2 = (ServerProtocolVersionSingleton)object;
            if (Objects.equals(serverProtocolVersionSingleton.protocolVersion, serverProtocolVersionSingleton2.protocolVersion)) {
                return true;
            }
        }
        return false;
    }
}

