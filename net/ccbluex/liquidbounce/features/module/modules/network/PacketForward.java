/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.bootstrap.ServerBootstrap
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandler
 *  io.netty.channel.ChannelInitializer
 *  io.netty.channel.ChannelOption
 *  io.netty.channel.EventLoopGroup
 *  io.netty.channel.socket.nio.NioServerSocketChannel
 *  io.netty.handler.timeout.ReadTimeoutHandler
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.network.EnumPacketDirection
 *  net.minecraft.network.NettyPacketDecoder
 *  net.minecraft.network.NettyPacketEncoder
 *  net.minecraft.network.NettyVarint21FrameDecoder
 *  net.minecraft.network.NettyVarint21FrameEncoder
 *  net.minecraft.network.NetworkSystem
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.network;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.modules.network.packet_forward.PacketForwardChannel;
import net.ccbluex.liquidbounce.features.module.modules.network.packet_forward.PacketForwardExtend;
import net.ccbluex.liquidbounce.features.module.modules.network.packet_forward.handle.PacketForwardHandleHandShake;
import net.ccbluex.liquidbounce.features.module.modules.network.packet_forward.handle.PacketForwardHandlePlayBase;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.minecraft.network.EnumPacketDirection;
import net.minecraft.network.NettyPacketDecoder;
import net.minecraft.network.NettyPacketEncoder;
import net.minecraft.network.NettyVarint21FrameDecoder;
import net.minecraft.network.NettyVarint21FrameEncoder;
import net.minecraft.network.NetworkSystem;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u00168VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/network/PacketForward;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "portValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "serverChannel", "Lio/netty/channel/Channel;", "getServerChannel", "()Lio/netty/channel/Channel;", "setServerChannel", "(Lio/netty/channel/Channel;)V", "clients", "", "Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/PacketForwardChannel;", "getClients", "()Ljava/util/Set;", "onEnable", "", "onDisable", "extends", "", "", "Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/PacketForwardExtend;", "tag", "getTag", "()Ljava/lang/String;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nPacketForward.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PacketForward.kt\nnet/ccbluex/liquidbounce/features/module/modules/network/PacketForward\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,94:1\n1#2:95\n1563#3:96\n1634#3,3:97\n1056#3:100\n1869#3:101\n1869#3,2:102\n1870#3:104\n*S KotlinDebug\n*F\n+ 1 PacketForward.kt\nnet/ccbluex/liquidbounce/features/module/modules/network/PacketForward\n*L\n71#1:96\n71#1:97,3\n72#1:100\n73#1:101\n77#1:102,2\n73#1:104\n*E\n"})
public final class PacketForward
extends Module {
    @NotNull
    public static final PacketForward INSTANCE;
    @JvmField
    @NotNull
    public static final IntegerValue portValue;
    public static Channel serverChannel;
    @NotNull
    private static final Set<PacketForwardChannel> clients;
    @NotNull
    private static final Map<String, PacketForwardExtend> extends;

    private PacketForward() {
        super("PacketForward", ModuleCategory.NETWORK, null, null, 12, null);
    }

    @NotNull
    public final Channel getServerChannel() {
        Channel channel = serverChannel;
        if (channel != null) {
            return channel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("serverChannel");
        return null;
    }

    public final void setServerChannel(@NotNull Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "<set-?>");
        serverChannel = channel;
    }

    @NotNull
    public final Set<PacketForwardChannel> getClients() {
        return clients;
    }

    @Override
    public void onEnable() {
        Channel channel = ((ServerBootstrap)new ServerBootstrap().channel(NioServerSocketChannel.class)).childHandler((ChannelHandler)new ChannelInitializer<Channel>(){

            /*
             * WARNING - void declaration
             */
            protected void initChannel(Channel channel) {
                void $this$filterTo$iv$iv;
                Intrinsics.checkNotNullParameter(channel, "channel");
                PacketForwardChannel wrapped = new PacketForwardChannel(channel);
                channel.pipeline().addLast("timeout", (ChannelHandler)new ReadTimeoutHandler(10000)).addLast("splitter", (ChannelHandler)new NettyVarint21FrameDecoder()).addLast("decoder", (ChannelHandler)new NettyPacketDecoder(EnumPacketDirection.SERVERBOUND)).addLast("prepender", (ChannelHandler)new NettyVarint21FrameEncoder()).addLast("encoder", (ChannelHandler)new NettyPacketEncoder(EnumPacketDirection.CLIENTBOUND)).addLast("handle_handshake", (ChannelHandler)new PacketForwardHandleHandShake(PacketForward.INSTANCE, wrapped)).addLast("handle_base", (ChannelHandler)new PacketForwardHandlePlayBase(PacketForward.INSTANCE, wrapped));
                Iterable $this$filter$iv = PacketForward.access$getExtends$p().values();
                boolean $i$f$filter = false;
                Iterable iterable = $this$filter$iv;
                Collection destination$iv$iv = new ArrayList<E>();
                boolean $i$f$filterTo = false;
                for (T element$iv$iv : $this$filterTo$iv$iv) {
                    PacketForwardExtend it = (PacketForwardExtend)element$iv$iv;
                    boolean bl2 = false;
                    if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                Iterable $this$forEach$iv = (List)destination$iv$iv;
                boolean $i$f$forEach = false;
                for (E element$iv : $this$forEach$iv) {
                    PacketForwardExtend it = (PacketForwardExtend)element$iv;
                    boolean bl3 = false;
                    it.onRemoteConnect(wrapped);
                }
                channel.config().setOption(ChannelOption.TCP_NODELAY, (Object)true);
            }
        }).group((EventLoopGroup)NetworkSystem.field_151276_c.func_179281_c()).bind(((Number)portValue.get()).intValue()).syncUninterruptibly().channel();
        Intrinsics.checkNotNullExpressionValue(channel, "channel(...)");
        this.setServerChannel(channel);
    }

    @Override
    public void onDisable() {
        this.getServerChannel().close();
    }

    @Override
    @NotNull
    public String getTag() {
        return String.valueOf(clients.size());
    }

    public static final /* synthetic */ Map access$getExtends$p() {
        return extends;
    }

    /*
     * WARNING - void declaration
     */
    static {
        List<Class<PacketForwardExtend>> list;
        List<Class<PacketForwardExtend>> list2;
        INSTANCE = new PacketForward();
        portValue = new IntegerValue("Port", 25577, new IntRange(1, 65535));
        clients = new LinkedHashSet();
        extends = new LinkedHashMap();
        INSTANCE.getValues().add(portValue);
        List<Class<PacketForwardExtend>> it = list2 = ClassUtils.INSTANCE.resolvePackage(INSTANCE.getClass().getPackage().getName() + ".packet_forward.extend", PacketForwardExtend.class);
        boolean bl2 = false;
        List<Class<PacketForwardExtend>> list3 = list = !((Collection)it).isEmpty() ? list2 : null;
        if (list != null) {
            BoolValue it2;
            void $this$mapTo$iv$iv;
            Iterable $this$map$iv = list;
            boolean $i$f$map = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                Class clazz = (Class)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl3 = false;
                collection.add((PacketForwardExtend)((Class)((Object)it2)).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Iterable $this$sortedBy$iv = (List)destination$iv$iv;
            boolean $i$f$sortedBy = false;
            List list4 = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    PacketForwardExtend it = (PacketForwardExtend)a2;
                    boolean bl2 = false;
                    Comparable comparable = (Comparable)((Object)it.getName());
                    it = (PacketForwardExtend)b2;
                    Comparable comparable2 = comparable;
                    bl2 = false;
                    return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getName()));
                }
            });
            if (list4 != null) {
                Iterable $this$forEach$iv = list4;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    PacketForwardExtend extend = (PacketForwardExtend)element$iv;
                    boolean bl4 = false;
                    BoolValue bl3 = it2 = new BoolValue(extend.getName(), extend.getDefaultState() || extend.getForce());
                    PacketForwardExtend packetForwardExtend = extend;
                    boolean bl5 = false;
                    if (!extend.getForce()) {
                        void it3;
                        INSTANCE.getValues().add((Value<?>)it3);
                    }
                    packetForwardExtend.setLinkedStatValue(it2);
                    extend.setInstance(INSTANCE);
                    Iterable $this$forEach$iv2 = extend.getValues();
                    boolean $i$f$forEach2 = false;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        Value value = (Value)element$iv2;
                        boolean bl6 = false;
                        value.setName(extend.getName() + value.getName());
                        if (value.getSuperValue() == null) {
                            value.setSuperValue(extend.getLinkedStatValue());
                        }
                        INSTANCE.getValues().add(value);
                    }
                    extends.put(extend.getName(), extend);
                    EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
                    Intrinsics.checkNotNull(extend);
                    EventManager.registerListener$default(eventManager, extend, false, false, 6, null);
                }
            }
        }
    }
}

