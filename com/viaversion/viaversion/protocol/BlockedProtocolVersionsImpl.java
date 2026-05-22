/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.protocol;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.protocol.version.BlockedProtocolVersions;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="singleBlockedVersions", type=Set.class), @RecordComponents.Value(name="blocksBelow", type=ProtocolVersion.class), @RecordComponents.Value(name="blocksAbove", type=ProtocolVersion.class)})
public final class BlockedProtocolVersionsImpl
extends J_L_Record
implements BlockedProtocolVersions {
    private final Set<ProtocolVersion> singleBlockedVersions;
    private final ProtocolVersion blocksBelow;
    private final ProtocolVersion blocksAbove;

    public BlockedProtocolVersionsImpl(Set<ProtocolVersion> singleBlockedVersions, ProtocolVersion blocksBelow, ProtocolVersion blocksAbove) {
        this.singleBlockedVersions = singleBlockedVersions;
        this.blocksBelow = blocksBelow;
        this.blocksAbove = blocksAbove;
    }

    @Override
    public boolean contains(ProtocolVersion protocolVersion) {
        return this.blocksBelow.isKnown() && protocolVersion.olderThan(this.blocksBelow) || this.blocksAbove.isKnown() && protocolVersion.newerThan(this.blocksAbove) || this.singleBlockedVersions.contains(protocolVersion);
    }

    @Override
    public final String toString() {
        return BlockedProtocolVersionsImpl.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return BlockedProtocolVersionsImpl.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return BlockedProtocolVersionsImpl.jvmdowngrader$equals$equals(this, o2);
    }

    @Override
    public Set<ProtocolVersion> singleBlockedVersions() {
        return this.singleBlockedVersions;
    }

    @Override
    public ProtocolVersion blocksBelow() {
        return this.blocksBelow;
    }

    @Override
    public ProtocolVersion blocksAbove() {
        return this.blocksAbove;
    }

    private static String jvmdowngrader$toString$toString(BlockedProtocolVersionsImpl blockedProtocolVersionsImpl) {
        BlockedProtocolVersionsImpl blockedProtocolVersionsImpl2 = blockedProtocolVersionsImpl;
        return "BlockedProtocolVersionsImpl[" + "singleBlockedVersions=" + blockedProtocolVersionsImpl.singleBlockedVersions + ", " + "blocksBelow=" + blockedProtocolVersionsImpl.blocksBelow + ", " + "blocksAbove=" + blockedProtocolVersionsImpl.blocksAbove + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(BlockedProtocolVersionsImpl blockedProtocolVersionsImpl) {
        Object[] objectArray = new Object[]{blockedProtocolVersionsImpl.singleBlockedVersions, blockedProtocolVersionsImpl.blocksBelow, blockedProtocolVersionsImpl.blocksAbove};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(BlockedProtocolVersionsImpl blockedProtocolVersionsImpl, Object object) {
        if (blockedProtocolVersionsImpl == object) {
            return true;
        }
        if (object != null && object instanceof BlockedProtocolVersionsImpl) {
            BlockedProtocolVersionsImpl blockedProtocolVersionsImpl2 = (BlockedProtocolVersionsImpl)object;
            if (Objects.equals(blockedProtocolVersionsImpl.singleBlockedVersions, blockedProtocolVersionsImpl2.singleBlockedVersions) && Objects.equals(blockedProtocolVersionsImpl.blocksBelow, blockedProtocolVersionsImpl2.blocksBelow) && Objects.equals(blockedProtocolVersionsImpl.blocksAbove, blockedProtocolVersionsImpl2.blocksAbove)) {
                return true;
            }
        }
        return false;
    }
}

