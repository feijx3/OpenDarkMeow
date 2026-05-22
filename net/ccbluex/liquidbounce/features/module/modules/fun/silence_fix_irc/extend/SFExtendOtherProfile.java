/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.network.NetworkPlayerInfo
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.extend;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.Event;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.event.events.render.entity.RenderEntityNameEvent;
import net.ccbluex.liquidbounce.event.events.render.entity.RenderEntityPlayerSkinEvent;
import net.ccbluex.liquidbounce.event.events.render.in_game_2d.Render2DPlayerTabOverlayEvent;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.SFExtend;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.data.SFUser;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.SFConnection;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.c2s.SFC2SPacketQueryGameProfile;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.s2c.SFS2CPacketQueryGameProfileResponse;
import net.ccbluex.liquidbounce.utils.file.ResourceLocationUtils;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.TextValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookOwnerCheck;
import net.darkmeow.darkmeow.event.hook.EventHookSafeOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.channel.SimpleChannelInboundHandler;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0010R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0014j\b\u0012\u0004\u0012\u00020\u000f`\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\""}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendOtherProfile;", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/SFExtend;", "<init>", "()V", "formatValue", "Lnet/ccbluex/liquidbounce/value/impl/TextValue;", "randomSkinValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "skins", "", "Lnet/minecraft/util/ResourceLocation;", "getSkins", "()Ljava/util/List;", "users", "", "Ljava/util/UUID;", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/data/SFUser;", "getUsers", "()Ljava/util/Map;", "queries", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getQueries", "()Ljava/util/HashSet;", "onEnable", "", "onConnected", "channel", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/SFConnection;", "formated", "", "name", "user", "Handle", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nSFExtendOtherProfile.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SFExtendOtherProfile.kt\nnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendOtherProfile\n+ 2 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,129:1\n12#2,3:130\n20#2,3:133\n13#2,2:136\n13#2,2:138\n13#2,2:140\n1#3:142\n1#3:156\n3829#4:143\n4344#4,2:144\n1617#5,9:146\n1869#5:155\n1870#5:157\n1626#5:158\n808#5,11:159\n774#5:170\n865#5,2:171\n1869#5,2:173\n1869#5,2:175\n*S KotlinDebug\n*F\n+ 1 SFExtendOtherProfile.kt\nnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendOtherProfile\n*L\n74#1:130,3\n78#1:133,3\n98#1:136,2\n107#1:138,2\n113#1:140,2\n54#1:156\n51#1:143\n51#1:144,2\n54#1:146,9\n54#1:155\n54#1:157\n54#1:158\n82#1:159,11\n83#1:170\n83#1:171,2\n85#1:173,2\n100#1:175,2\n*E\n"})
public final class SFExtendOtherProfile
extends SFExtend {
    @JvmField
    @NotNull
    public final TextValue formatValue = new TextValue("Format", "%name \u00a7a(%irc_name)");
    @JvmField
    @NotNull
    public final BoolValue randomSkinValue = new BoolValue("RandomSkin", false);
    @NotNull
    private final List<ResourceLocation> skins = new ArrayList();
    @NotNull
    private final Map<UUID, SFUser> users = new LinkedHashMap();
    @NotNull
    private final HashSet<UUID> queries = new HashSet();

    public SFExtendOtherProfile() {
        super("OtherProfile", true, false, 4, null);
        ListenableOwner $this$listener$iv;
        ListenableOwner $receiver$iv;
        ListenableOwnerExtends listenableOwnerExtends = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = this;
        Function2<ListenerBase, Event, Unit> function$iv = (arg_0, arg_1) -> SFExtendOtherProfile._init_$lambda$5(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookOwnerCheck<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(WorldEvent.class), $receiver$iv));
        ListenableOwnerExtends $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        function$iv = (arg_0, arg_1) -> SFExtendOtherProfile._init_$lambda$8(this, arg_0, arg_1);
        priority$iv = 0;
        boolean $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookSafeOwnerCheck<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(UpdateEvent.class), $receiver$iv));
        $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        priority$iv = 90;
        function$iv = (arg_0, arg_1) -> SFExtendOtherProfile._init_$lambda$11(this, arg_0, arg_1);
        $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($this$listener$iv).add(new EventHookOwnerCheck<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(Render2DPlayerTabOverlayEvent.PRE.class), $this$listener$iv));
        ListenableOwnerExtends this_$iv = ListenableOwnerExtends.INSTANCE;
        $this$listener$iv = this;
        priority$iv = 90;
        function$iv = (arg_0, arg_1) -> SFExtendOtherProfile._init_$lambda$13(this, arg_0, arg_1);
        $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($this$listener$iv).add(new EventHookOwnerCheck<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(RenderEntityNameEvent.class), $this$listener$iv));
        this_$iv = ListenableOwnerExtends.INSTANCE;
        $this$listener$iv = this;
        priority$iv = 90;
        function$iv = (arg_0, arg_1) -> SFExtendOtherProfile._init_$lambda$15(this, arg_0, arg_1);
        $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($this$listener$iv).add(new EventHookOwnerCheck<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(RenderEntityPlayerSkinEvent.Skin.class), $this$listener$iv));
    }

    @NotNull
    public final List<ResourceLocation> getSkins() {
        return this.skins;
    }

    @NotNull
    public final Map<UUID, SFUser> getUsers() {
        return this.users;
    }

    @NotNull
    public final HashSet<UUID> getQueries() {
        return this.queries;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void onEnable() {
        block5: {
            it = var2_1 = new File(new File(DarkMeow.INSTANCE.getFileManager().getDir(), "skins"), "silence-fix-users");
            $i$a$-takeIf-SFExtendOtherProfile$onEnable$1 = false;
            v0 = var1_4 = (Boolean)this.randomSkinValue.get() != false ? var2_1 : null;
            if (var1_4 == null) break block5;
            $this$onEnable_u24lambda_u244 = var2_1 = var1_4;
            $i$a$-apply-SFExtendOtherProfile$onEnable$2 = false;
            if (!$this$onEnable_u24lambda_u244.exists()) {
                $this$onEnable_u24lambda_u244.mkdirs();
            }
            if ((var5_5 = $this$onEnable_u24lambda_u244.listFiles()) == null) break block5;
            var6_6 = var5_5;
            $i$f$filter = false;
            var8_9 = $this$filter$iv;
            destination$iv$iv = new ArrayList<E>();
            $i$f$filterTo = false;
            var12_17 = ((void)$this$filterTo$iv$iv).length;
            for (var11_16 = 0; var11_16 < var12_17; ++var11_16) {
                file = element$iv$iv = $this$filterTo$iv$iv[var11_16];
                $i$a$-filter-SFExtendOtherProfile$onEnable$2$1 = false;
                if (!file.isFile()) ** GOTO lbl-1000
                Intrinsics.checkNotNull(file);
                if (StringsKt.equals(FilesKt.getExtension((File)file), "png", true)) {
                    v1 = true;
                } else lbl-1000:
                // 2 sources

                {
                    v1 = false;
                }
                if (!v1) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            $i$f$filter = (List)destination$iv$iv;
            $i$f$mapNotNull = false;
            destination$iv$iv = $this$mapNotNull$iv;
            destination$iv$iv = new ArrayList<E>();
            $i$f$mapNotNullTo = false;
            $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
            $i$f$forEach = false;
            var14_21 = $this$forEach$iv$iv$iv.iterator();
            while (var14_21.hasNext()) {
                element$iv$iv = element$iv$iv$iv = var14_21.next();
                $i$a$-forEach-CollectionsKt___CollectionsKt$mapNotNullTo$1$iv$iv = false;
                file = (File)element$iv$iv;
                $i$a$-mapNotNull-SFExtendOtherProfile$onEnable$2$2 = false;
                Intrinsics.checkNotNull(file);
                if (ResourceLocationUtils.toResourceLocation$default(ResourceLocationUtils.INSTANCE, file, null, 1, null) == null) continue;
                $i$a$-let-CollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv = false;
                destination$iv$iv.add(it$iv$iv);
            }
            it = var7_8 = (List)destination$iv$iv;
            $i$a$-also-SFExtendOtherProfile$onEnable$2$3 = false;
            this.skins.addAll(it);
        }
    }

    @Override
    public void onConnected(@NotNull SFConnection channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        channel.addPipeLineToLast("plugin_" + this.getName(), new Handle(this));
    }

    @NotNull
    public final String formated(@NotNull String name, @NotNull SFUser user) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(user, "user");
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default((String)this.formatValue.get(), "%name", name, false, 4, null), "%irc_name", user.getName(), false, 4, null), "%irc_rank", user.getRank(), false, 4, null);
    }

    private static final Unit _init_$lambda$5(SFExtendOtherProfile this$0, ListenerBase $this$listener, WorldEvent it) {
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.users.clear();
        this$0.queries.clear();
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit _init_$lambda$8(SFExtendOtherProfile this$0, SafeListenerBase $this$safeListener, UpdateEvent event) {
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getUpdateId() % 20L == 0L) {
            void $this$filterTo$iv$iv;
            Iterable $this$filterIsInstanceTo$iv$iv;
            List list = $this$safeListener.getWorld().field_72996_f;
            Intrinsics.checkNotNullExpressionValue(list, "loadedEntityList");
            Iterable $this$filterIsInstance$iv = list;
            boolean $i$f$filterIsInstance = false;
            Iterable iterable = $this$filterIsInstance$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterIsInstanceTo = false;
            for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
                if (!(element$iv$iv instanceof EntityPlayer)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            Iterable $this$filter$iv = (List)destination$iv$iv;
            boolean $i$f$filter = false;
            $this$filterIsInstanceTo$iv$iv = $this$filter$iv;
            destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                EntityPlayer it = (EntityPlayer)element$iv$iv;
                boolean bl2 = false;
                if (!(!this$0.queries.contains(it.func_146103_bH().getId()))) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            Iterable $this$forEach$iv = CollectionsKt.take((List)destination$iv$iv, 10);
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                EntityPlayer it = (EntityPlayer)element$iv;
                boolean bl3 = false;
                SFConnection sFConnection = this$0.getInstance().getClient();
                UUID uUID = it.func_146103_bH().getId();
                Intrinsics.checkNotNullExpressionValue(uUID, "getId(...)");
                sFConnection.sendPacket(new SFC2SPacketQueryGameProfile(SFC2SPacketQueryGameProfile.Type.TAB, uUID));
            }
        }
        if (event.getUpdateId() % 100L == 0L) {
            this$0.queries.clear();
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$11(SFExtendOtherProfile this$0, ListenerBase $this$listener, Render2DPlayerTabOverlayEvent.PRE event) {
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(event, "event");
        Iterable $this$forEach$iv = event.getList();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            SFUser sFUser;
            NetworkPlayerInfo entity = (NetworkPlayerInfo)element$iv;
            boolean bl2 = false;
            SFUser sFUser2 = this$0.users.get(entity.func_178845_a().getId());
            if (sFUser2 == null) continue;
            SFUser user = sFUser = sFUser2;
            boolean bl3 = false;
            ((Map)event.getOverwriteNames()).put(entity, this$0.formated(Render2DPlayerTabOverlayEvent.PRE.getPlayerName$default(event, entity, false, 2, null), user));
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$13(SFExtendOtherProfile this$0, ListenerBase $this$listener, RenderEntityNameEvent event) {
        block0: {
            SFUser sFUser;
            Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
            Intrinsics.checkNotNullParameter(event, "event");
            SFUser sFUser2 = this$0.users.get(event.getEntity().func_110124_au());
            if (sFUser2 == null) break block0;
            SFUser user = sFUser = sFUser2;
            boolean bl2 = false;
            event.setDisplayName(this$0.formated(event.getDisplayName(), user));
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$15(SFExtendOtherProfile this$0, ListenerBase $this$listener, RenderEntityPlayerSkinEvent.Skin event) {
        block2: {
            SFUser sFUser;
            Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
            Intrinsics.checkNotNullParameter(event, "event");
            if (!((Boolean)this$0.randomSkinValue.get()).booleanValue() || this$0.skins.isEmpty()) {
                return Unit.INSTANCE;
            }
            if (event.isChanged()) {
                return Unit.INSTANCE;
            }
            SFUser sFUser2 = this$0.users.get(event.getInfo().func_178845_a().getId());
            if (sFUser2 == null) break block2;
            SFUser user = sFUser = sFUser2;
            boolean bl2 = false;
            int n2 = user.getName().hashCode();
            int n3 = this$0.skins.size();
            int n4 = n2 % n3;
            event.setReturnValue(this$0.skins.get(n4 + (n3 & ((n4 ^ n3) & (n4 | -n4)) >> 31)));
        }
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0014R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendOtherProfile$Handle;", "Lnet/darkmeow/irc/lib/io/netty/channel/SimpleChannelInboundHandler;", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/s2c/SFS2CPacketQueryGameProfileResponse;", "module", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendOtherProfile;", "<init>", "(Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendOtherProfile;)V", "getModule", "()Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendOtherProfile;", "channelRead0", "", "ctx", "Lnet/darkmeow/irc/lib/io/netty/channel/ChannelHandlerContext;", "packet", "DarkMeow"})
    public static final class Handle
    extends SimpleChannelInboundHandler<SFS2CPacketQueryGameProfileResponse> {
        @NotNull
        private final SFExtendOtherProfile module;

        public Handle(@NotNull SFExtendOtherProfile module) {
            Intrinsics.checkNotNullParameter(module, "module");
            this.module = module;
        }

        @NotNull
        public final SFExtendOtherProfile getModule() {
            return this.module;
        }

        @Override
        protected void channelRead0(@NotNull ChannelHandlerContext ctx, @NotNull SFS2CPacketQueryGameProfileResponse packet) {
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            Intrinsics.checkNotNullParameter(packet, "packet");
            this.module.getUsers().put(packet.getUniqueId(), packet.getUser());
        }
    }
}

