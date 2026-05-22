/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  gw
 *  ht
 */
package baritone.api.event.events;

import baritone.api.event.events.type.EventState;

public final class PacketEvent {
    private final gw networkManager;
    private final EventState state;
    private final ht<?> packet;

    public PacketEvent(gw gw2, EventState eventState, ht<?> ht2) {
        this.networkManager = gw2;
        this.state = eventState;
        this.packet = ht2;
    }

    public final gw getNetworkManager() {
        return this.networkManager;
    }

    public final EventState getState() {
        return this.state;
    }

    public final ht<?> getPacket() {
        return this.packet;
    }

    public final <T extends ht<?>> T cast() {
        return (T)this.packet;
    }
}

