/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.Unpooled
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.network.Packet
 *  net.minecraft.network.PacketBuffer
 *  net.minecraft.network.play.client.CPacketCustomPayload
 *  net.minecraft.network.play.server.SPacketCustomPayload
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.utils.network;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.darkmeow.darkmeow.utils.network.PacketSide;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.CPacketCustomPayload;
import net.minecraft.network.play.server.SPacketCustomPayload;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2={"Lnet/darkmeow/darkmeow/utils/network/PacketUtils;", "", "<init>", "()V", "keepFMLProxyPacketAway", "Lnet/minecraft/network/Packet;", "packet", "side", "Lnet/darkmeow/darkmeow/utils/network/PacketSide;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nPacketUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PacketUtils.kt\nnet/darkmeow/darkmeow/utils/network/PacketUtils\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,45:1\n13472#2,2:46\n*S KotlinDebug\n*F\n+ 1 PacketUtils.kt\nnet/darkmeow/darkmeow/utils/network/PacketUtils\n*L\n28#1:46,2\n*E\n"})
public final class PacketUtils {
    @NotNull
    public static final PacketUtils INSTANCE = new PacketUtils();

    private PacketUtils() {
    }

    @JvmStatic
    @NotNull
    public static final Packet<?> keepFMLProxyPacketAway(@NotNull Packet<?> packet, @NotNull PacketSide side) {
        Packet packet2;
        Intrinsics.checkNotNullParameter(packet, "packet");
        Intrinsics.checkNotNullParameter((Object)side, "side");
        if (Intrinsics.areEqual(packet.getClass().getName(), "net.minecraftforge.fml.common.network.internal.FMLProxyPacket")) {
            Class<?> clazz = packet.getClass();
            if (clazz.isMemberClass()) {
                Class<?> clazz2 = clazz.getDeclaringClass();
                Intrinsics.checkNotNullExpressionValue(clazz2, "getDeclaringClass(...)");
                clazz = clazz2;
            }
            String channel = null;
            ByteBuf data = null;
            Field[] fieldArray = clazz.getDeclaredFields();
            Intrinsics.checkNotNullExpressionValue(fieldArray, "getDeclaredFields(...)");
            Object[] $this$forEach$iv = fieldArray;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Object object;
                Field it = (Field)element$iv;
                boolean bl2 = false;
                it.setAccessible(true);
                String string = it.getName();
                if (Intrinsics.areEqual(string, "channel")) {
                    object = it.get(packet);
                    channel = object instanceof String ? (String)object : null;
                    continue;
                }
                if (!Intrinsics.areEqual(string, "payload")) continue;
                object = it.get(packet);
                data = object instanceof PacketBuffer ? (PacketBuffer)object : null;
            }
            switch (WhenMappings.$EnumSwitchMapping$0[side.ordinal()]) {
                case 1: {
                    ByteBuf byteBuf;
                    String string = channel;
                    if (string == null) {
                        string = "";
                    }
                    if ((byteBuf = data) == null || (byteBuf = byteBuf.copy()) == null) {
                        byteBuf = Unpooled.buffer();
                    }
                    packet2 = (Packet)new CPacketCustomPayload(string, new PacketBuffer(byteBuf));
                    break;
                }
                case 2: {
                    ByteBuf byteBuf;
                    String string = channel;
                    if (string == null) {
                        string = "";
                    }
                    if ((byteBuf = data) == null || (byteBuf = byteBuf.copy()) == null) {
                        byteBuf = Unpooled.buffer();
                    }
                    packet2 = (Packet)new SPacketCustomPayload(string, new PacketBuffer(byteBuf));
                    break;
                }
                default: {
                    packet2 = packet;
                    break;
                }
            }
        } else {
            packet2 = packet;
        }
        return packet2;
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[PacketSide.values().length];
            try {
                nArray[PacketSide.CLIENT.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[PacketSide.SERVER.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

