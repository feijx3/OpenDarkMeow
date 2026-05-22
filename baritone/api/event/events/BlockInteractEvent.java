/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  et
 */
package baritone.api.event.events;

public final class BlockInteractEvent {
    private final et pos;
    private final Type type;

    public BlockInteractEvent(et et2, Type type) {
        this.pos = et2;
        this.type = type;
    }

    public final et getPos() {
        return this.pos;
    }

    public final Type getType() {
        return this.type;
    }

    public static enum Type {
        START_BREAK,
        USE;

    }
}

