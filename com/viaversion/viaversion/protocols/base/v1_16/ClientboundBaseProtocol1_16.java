/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.base.v1_16;

import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.base.v1_7.ClientboundBaseProtocol1_7;
import java.util.UUID;

public class ClientboundBaseProtocol1_16
extends ClientboundBaseProtocol1_7 {
    @Override
    public UUID passthroughUUID(PacketWrapper wrapper) {
        return wrapper.passthrough(Types.UUID);
    }
}

