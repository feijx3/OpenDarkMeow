/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  net.kyori.adventure.key.Key
 *  org.bukkit.Bukkit
 */
package com.viaversion.viaversion.bukkit.platform;

import com.viaversion.viaversion.bukkit.handlers.BukkitChannelInitializer;
import com.viaversion.viaversion.bukkit.platform.BukkitViaInjector;
import io.netty.channel.Channel;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import net.kyori.adventure.key.Key;
import org.bukkit.Bukkit;

public final class PaperViaInjector {
    public static final boolean PAPER_INJECTION_METHOD = PaperViaInjector.hasPaperInjectionMethod();
    public static final boolean PAPER_PROTOCOL_METHOD = PaperViaInjector.hasServerProtocolMethod();
    public static final boolean PAPER_PACKET_LIMITER = PaperViaInjector.hasPacketLimiter();
    public static final boolean PAPER_IS_STOPPING_METHOD = PaperViaInjector.hasIsStoppingMethod();

    private PaperViaInjector() {
    }

    public static int getServerProtocolVersion() {
        if (!PAPER_PROTOCOL_METHOD) {
            throw new UnsupportedOperationException("Paper method not available");
        }
        return Bukkit.getUnsafe().getProtocolVersion();
    }

    public static void setPaperChannelInitializeListener() throws ReflectiveOperationException {
        Class<?> listenerClass = Class.forName("io.papermc.paper.network.ChannelInitializeListener");
        Object channelInitializeListener = Proxy.newProxyInstance(BukkitViaInjector.class.getClassLoader(), new Class[]{listenerClass}, (proxy, method, args) -> {
            if (method.getName().equals("afterInitChannel")) {
                BukkitChannelInitializer.afterChannelInitialize((Channel)args[0]);
                return null;
            }
            return method.invoke(proxy, args);
        });
        Class<?> holderClass = Class.forName("io.papermc.paper.network.ChannelInitializeListenerHolder");
        Method addListenerMethod = holderClass.getDeclaredMethod("addListener", Key.class, listenerClass);
        addListenerMethod.invoke(null, Key.key((String)"viaversion", (String)"injector"), channelInitializeListener);
    }

    public static void removePaperChannelInitializeListener() throws ReflectiveOperationException {
        Class<?> holderClass = Class.forName("io.papermc.paper.network.ChannelInitializeListenerHolder");
        Method addListenerMethod = holderClass.getDeclaredMethod("removeListener", Key.class);
        addListenerMethod.invoke(null, Key.key((String)"viaversion", (String)"injector"));
    }

    private static boolean hasServerProtocolMethod() {
        return PaperViaInjector.hasMethod("org.bukkit.UnsafeValues", "getProtocolVersion");
    }

    private static boolean hasPaperInjectionMethod() {
        return PaperViaInjector.hasClass("io.papermc.paper.network.ChannelInitializeListener");
    }

    private static boolean hasIsStoppingMethod() {
        return PaperViaInjector.hasMethod(Bukkit.class, "isStopping", new Class[0]);
    }

    private static boolean hasPacketLimiter() {
        return PaperViaInjector.hasClass("com.destroystokyo.paper.PaperConfig$PacketLimit") || PaperViaInjector.hasClass("io.papermc.paper.configuration.GlobalConfiguration$PacketLimiter");
    }

    public static boolean hasClass(String className) {
        try {
            Class.forName(className);
            return true;
        }
        catch (ClassNotFoundException e2) {
            return false;
        }
    }

    public static boolean hasMethod(String className, String method) {
        try {
            Class.forName(className).getDeclaredMethod(method, new Class[0]);
            return true;
        }
        catch (ClassNotFoundException | NoSuchMethodException e2) {
            return false;
        }
    }

    public static boolean hasMethod(Class<?> clazz, String method, Class<?> ... params) {
        try {
            clazz.getDeclaredMethod(method, params);
            return true;
        }
        catch (NoSuchMethodException e2) {
            return false;
        }
    }

    public static boolean hasMethod(Class<?> clazz, Class<?> returnType, String method, Class<?> ... params) {
        try {
            return clazz.getDeclaredMethod(method, params).getReturnType().equals(returnType);
        }
        catch (NoSuchMethodException e2) {
            return false;
        }
    }
}

