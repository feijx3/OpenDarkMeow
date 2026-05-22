/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.internal;

import java.util.concurrent.atomic.LongAdder;
import net.darkmeow.irc.lib.io.netty.util.internal.LongCounter;

final class LongAdderCounter
extends LongAdder
implements LongCounter {
    LongAdderCounter() {
    }

    @Override
    public long value() {
        return this.longValue();
    }
}

