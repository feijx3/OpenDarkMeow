/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel;

import java.lang.reflect.Constructor;
import net.darkmeow.irc.lib.io.netty.channel.Channel;
import net.darkmeow.irc.lib.io.netty.channel.ChannelException;
import net.darkmeow.irc.lib.io.netty.channel.ChannelFactory;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.StringUtil;

public class ReflectiveChannelFactory<T extends Channel>
implements ChannelFactory<T> {
    private final Constructor<? extends T> constructor;

    public ReflectiveChannelFactory(Class<? extends T> clazz) {
        ObjectUtil.checkNotNull(clazz, "clazz");
        try {
            this.constructor = clazz.getConstructor(new Class[0]);
        }
        catch (NoSuchMethodException e2) {
            throw new IllegalArgumentException("Class " + StringUtil.simpleClassName(clazz) + " does not have a public non-arg constructor", e2);
        }
    }

    @Override
    public T newChannel() {
        try {
            return (T)((Channel)this.constructor.newInstance(new Object[0]));
        }
        catch (Throwable t2) {
            throw new ChannelException("Unable to create Channel from class " + this.constructor.getDeclaringClass(), t2);
        }
    }

    public String toString() {
        return StringUtil.simpleClassName(ReflectiveChannelFactory.class) + '(' + StringUtil.simpleClassName(this.constructor.getDeclaringClass()) + ".class)";
    }
}

