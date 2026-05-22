/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.base;

import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.protocols.base.packet.BaseClientboundPacket;

public enum ClientboundLoginPackets implements BaseClientboundPacket
{
    LOGIN_DISCONNECT,
    HELLO,
    LOGIN_FINISHED,
    LOGIN_COMPRESSION,
    CUSTOM_QUERY,
    COOKIE_REQUEST;

    @Deprecated(forRemoval=true)
    public static final ClientboundLoginPackets GAME_PROFILE;

    @Override
    public final int getId() {
        return this.ordinal();
    }

    @Override
    public final String getName() {
        return this.name();
    }

    @Override
    public final State state() {
        return State.LOGIN;
    }

    static {
        GAME_PROFILE = LOGIN_FINISHED;
    }
}

