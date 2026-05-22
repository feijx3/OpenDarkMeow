/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.channel.ChannelPipeline
 *  io.netty.handler.codec.ByteToMessageDecoder
 *  io.netty.handler.codec.MessageToByteEncoder
 *  io.netty.handler.codec.MessageToMessageDecoder
 *  org.checkerframework.checker.nullness.qual.Nullable
 */
package com.viaversion.viaversion.util;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class PipelineUtil {
    private static final MethodHandle DECODE_METHOD = PipelineUtil.privateHandleUnchecked(ByteToMessageDecoder.class, "decode", ChannelHandlerContext.class, ByteBuf.class, List.class);
    private static final MethodHandle ENCODE_METHOD = PipelineUtil.privateHandleUnchecked(MessageToByteEncoder.class, "encode", ChannelHandlerContext.class, Object.class, ByteBuf.class);
    private static final MethodHandle MTM_DECODE = PipelineUtil.privateHandleUnchecked(MessageToMessageDecoder.class, "decode", ChannelHandlerContext.class, Object.class, List.class);

    public static List<Object> callDecode(ByteToMessageDecoder decoder, ChannelHandlerContext ctx, Object input) throws Exception {
        ArrayList<Object> output = new ArrayList<Object>();
        try {
            DECODE_METHOD.invoke(decoder, ctx, input, output);
        }
        catch (Error | Exception e2) {
            throw e2;
        }
        catch (Throwable t2) {
            throw new InvocationTargetException(t2);
        }
        return output;
    }

    public static void callEncode(MessageToByteEncoder encoder, ChannelHandlerContext ctx, Object msg, ByteBuf output) throws Exception {
        try {
            ENCODE_METHOD.invoke(encoder, ctx, msg, output);
        }
        catch (Error | Exception e2) {
            throw e2;
        }
        catch (Throwable t2) {
            throw new InvocationTargetException(t2);
        }
    }

    public static List<Object> callDecode(MessageToMessageDecoder decoder, ChannelHandlerContext ctx, Object msg) throws Exception {
        ArrayList<Object> output = new ArrayList<Object>();
        try {
            MTM_DECODE.invoke(decoder, ctx, msg, output);
        }
        catch (Error | Exception e2) {
            throw e2;
        }
        catch (Throwable t2) {
            throw new InvocationTargetException(t2);
        }
        return output;
    }

    public static boolean containsCause(Throwable t2, Class<?> c2) {
        do {
            if (!c2.isAssignableFrom(t2.getClass())) continue;
            return true;
        } while ((t2 = t2.getCause()) != null);
        return false;
    }

    public static <T> @Nullable T getCause(Throwable t2, Class<T> c2) {
        while (t2 != null) {
            if (c2.isAssignableFrom(t2.getClass())) {
                return (T)t2;
            }
            t2 = t2.getCause();
        }
        return null;
    }

    public static @Nullable ChannelHandlerContext getContextBefore(String name, ChannelPipeline pipeline) {
        boolean mark = false;
        for (String s2 : pipeline.names()) {
            if (mark) {
                return pipeline.context(pipeline.get(s2));
            }
            if (!s2.equalsIgnoreCase(name)) continue;
            mark = true;
        }
        return null;
    }

    public static @Nullable ChannelHandlerContext getPreviousContext(String name, ChannelPipeline pipeline) {
        String previous = null;
        for (String entry : pipeline.toMap().keySet()) {
            if (entry.equals(name)) {
                return pipeline.context(previous);
            }
            previous = entry;
        }
        return null;
    }

    private static MethodHandle privateHandle(Class<?> clazz, String method, Class<?> ... parameterTypes) throws NoSuchMethodException, IllegalAccessException {
        Method decodeMethod = clazz.getDeclaredMethod(method, parameterTypes);
        decodeMethod.setAccessible(true);
        return MethodHandles.lookup().unreflect(decodeMethod);
    }

    private static MethodHandle privateHandleUnchecked(Class<?> clazz, String method, Class<?> ... args) {
        try {
            return PipelineUtil.privateHandle(clazz, method, args);
        }
        catch (IllegalAccessException | NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        }
    }
}

