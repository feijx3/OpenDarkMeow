/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel.socket.nio;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ProtocolFamily;
import java.net.StandardProtocolFamily;
import java.nio.channels.Channel;
import java.nio.channels.spi.SelectorProvider;
import net.darkmeow.irc.lib.io.netty.channel.socket.SocketProtocolFamily;
import net.darkmeow.irc.lib.io.netty.util.internal.PlatformDependent;
import net.darkmeow.irc.lib.io.netty.util.internal.logging.InternalLogger;
import net.darkmeow.irc.lib.io.netty.util.internal.logging.InternalLoggerFactory;

final class SelectorProviderUtil {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(SelectorProviderUtil.class);

    static Method findOpenMethod(String methodName) {
        if (PlatformDependent.javaVersion() >= 15) {
            try {
                return SelectorProvider.class.getMethod(methodName, ProtocolFamily.class);
            }
            catch (Throwable e2) {
                logger.debug("SelectorProvider.{}(ProtocolFamily) not available, will use default", (Object)methodName, (Object)e2);
            }
        }
        return null;
    }

    private static <C extends Channel> C newChannel(Method method, SelectorProvider provider, Object family) throws IOException {
        if (family != null && method != null) {
            try {
                Channel channel = (Channel)method.invoke(provider, family);
                return (C)channel;
            }
            catch (InvocationTargetException e2) {
                throw new IOException(e2);
            }
            catch (IllegalAccessException e3) {
                throw new IOException(e3);
            }
        }
        return null;
    }

    static <C extends Channel> C newChannel(Method method, SelectorProvider provider, SocketProtocolFamily family) throws IOException {
        if (family != null) {
            return SelectorProviderUtil.newChannel(method, provider, family.toJdkFamily());
        }
        return null;
    }

    static <C extends Channel> C newDomainSocketChannel(Method method, SelectorProvider provider) throws IOException {
        return SelectorProviderUtil.newChannel(method, provider, StandardProtocolFamily.valueOf("UNIX"));
    }

    private SelectorProviderUtil() {
    }
}

