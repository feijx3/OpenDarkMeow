/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.Logger
 */
package net.darkmeow.irc.lib.io.netty.util.internal.logging;

import net.darkmeow.irc.lib.io.netty.util.internal.logging.InternalLogger;
import net.darkmeow.irc.lib.io.netty.util.internal.logging.InternalLoggerFactory;
import net.darkmeow.irc.lib.io.netty.util.internal.logging.Log4JLogger;
import org.apache.log4j.Logger;

public class Log4JLoggerFactory
extends InternalLoggerFactory {
    public static final InternalLoggerFactory INSTANCE = new Log4JLoggerFactory();

    @Deprecated
    public Log4JLoggerFactory() {
    }

    @Override
    public InternalLogger newInstance(String name) {
        return new Log4JLogger(Logger.getLogger((String)name));
    }
}

