/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.concurrent;

import java.util.EventListener;
import net.darkmeow.irc.lib.io.netty.util.concurrent.Future;

public interface GenericFutureListener<F extends Future<?>>
extends EventListener {
    public void operationComplete(F var1) throws Exception;
}

