/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bsb
 */
package baritone.api.event.events;

import baritone.api.event.events.type.EventState;

public final class WorldEvent {
    private final bsb world;
    private final EventState state;

    public WorldEvent(bsb bsb2, EventState eventState) {
        this.world = bsb2;
        this.state = eventState;
    }

    public final bsb getWorld() {
        return this.world;
    }

    public final EventState getState() {
        return this.state;
    }
}

