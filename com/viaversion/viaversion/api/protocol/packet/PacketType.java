/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j17.PermittedSubClasses
 */
package com.viaversion.viaversion.api.protocol.packet;

import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.Direction;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.State;
import xyz.wagyourtail.jvmdg.j17.PermittedSubClasses;

@PermittedSubClasses(value={ClientboundPacketType.class, ServerboundPacketType.class})
public interface PacketType {
    public int getId();

    public String getName();

    public Direction direction();

    default public State state() {
        return State.PLAY;
    }
}

