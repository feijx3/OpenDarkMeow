/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.util.ResourceLocation
 *  org.apache.commons.codec.digest.DigestUtils
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.client.irc.plugins;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.Event;
import net.ccbluex.liquidbounce.event.events.render.entity.RenderEntityPlayerSkinEvent;
import net.ccbluex.liquidbounce.event.events.tick.TickEvent;
import net.ccbluex.liquidbounce.features.module.modules.client.irc.IRCPlugin;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.ClientUtils;
import net.ccbluex.liquidbounce.utils.file.ResourceLocationUtils;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import net.darkmeow.irc.client.interfaces.data.IRCDataOtherSessionInfo;
import net.darkmeow.irc.data.DataSkin;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.codec.digest.DigestUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0006J\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!R1\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR1\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR-\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e`\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR!\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0011j\b\u0012\u0004\u0012\u00020\u0006`\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\""}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/irc/plugins/IRCPluginSkin;", "Lnet/ccbluex/liquidbounce/features/module/modules/client/irc/IRCPlugin;", "<init>", "()V", "playerSkinMap", "Ljava/util/HashMap;", "", "Lnet/minecraft/util/ResourceLocation;", "Lkotlin/collections/HashMap;", "getPlayerSkinMap", "()Ljava/util/HashMap;", "playerCapeMap", "getPlayerCapeMap", "playerUseSlimMap", "", "getPlayerUseSlimMap", "checked", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getChecked", "()Ljava/util/HashSet;", "checkedTimestamp", "", "getCheckedTimestamp", "()J", "setCheckedTimestamp", "(J)V", "onDisable", "", "fetchCloudSkin", "name", "onUpdateOtherSkin", "info", "Lnet/darkmeow/irc/client/interfaces/data/IRCDataOtherSessionInfo;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nIRCPluginSkin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IRCPluginSkin.kt\nnet/ccbluex/liquidbounce/features/module/modules/client/irc/plugins/IRCPluginSkin\n+ 2 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,135:1\n12#2,3:136\n12#2,3:139\n12#2,3:142\n12#2,3:145\n1869#3,2:148\n1869#3,2:150\n295#3,2:152\n1#4:154\n*S KotlinDebug\n*F\n+ 1 IRCPluginSkin.kt\nnet/ccbluex/liquidbounce/features/module/modules/client/irc/plugins/IRCPluginSkin\n*L\n35#1:136,3\n44#1:139,3\n52#1:142,3\n59#1:145,3\n26#1:148,2\n28#1:150,2\n71#1:152,2\n*E\n"})
public final class IRCPluginSkin
extends IRCPlugin {
    @NotNull
    private final HashMap<String, ResourceLocation> playerSkinMap = new HashMap();
    @NotNull
    private final HashMap<String, ResourceLocation> playerCapeMap = new HashMap();
    @NotNull
    private final HashMap<String, Boolean> playerUseSlimMap = new HashMap();
    @NotNull
    private final HashSet<String> checked = new HashSet();
    private long checkedTimestamp;

    public IRCPluginSkin() {
        super("Skin");
        ListenableOwner $receiver$iv;
        ListenableOwnerExtends listenableOwnerExtends = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = this;
        Function2<ListenerBase, Event, Unit> function$iv = (arg_0, arg_1) -> IRCPluginSkin._init_$lambda$3(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookOwnerCheck<RenderEntityPlayerSkinEvent.Skin>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(RenderEntityPlayerSkinEvent.Skin.class), $receiver$iv));
        ListenableOwnerExtends $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        function$iv = (arg_0, arg_1) -> IRCPluginSkin._init_$lambda$5(this, arg_0, arg_1);
        priority$iv = 0;
        $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookOwnerCheck<RenderEntityPlayerSkinEvent.Skin>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(RenderEntityPlayerSkinEvent.Cape.class), $receiver$iv));
        $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        function$iv = (arg_0, arg_1) -> IRCPluginSkin._init_$lambda$7(this, arg_0, arg_1);
        priority$iv = 0;
        $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookOwnerCheck<RenderEntityPlayerSkinEvent.Skin>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(RenderEntityPlayerSkinEvent.SkinType.class), $receiver$iv));
        $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        function$iv = (arg_0, arg_1) -> IRCPluginSkin._init_$lambda$8(this, arg_0, arg_1);
        priority$iv = 0;
        $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookOwnerCheck<RenderEntityPlayerSkinEvent.Skin>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(TickEvent.Pre.class), $receiver$iv));
    }

    @NotNull
    public final HashMap<String, ResourceLocation> getPlayerSkinMap() {
        return this.playerSkinMap;
    }

    @NotNull
    public final HashMap<String, ResourceLocation> getPlayerCapeMap() {
        return this.playerCapeMap;
    }

    @NotNull
    public final HashMap<String, Boolean> getPlayerUseSlimMap() {
        return this.playerUseSlimMap;
    }

    @NotNull
    public final HashSet<String> getChecked() {
        return this.checked;
    }

    public final long getCheckedTimestamp() {
        return this.checkedTimestamp;
    }

    public final void setCheckedTimestamp(long l2) {
        this.checkedTimestamp = l2;
    }

    @Override
    public void onDisable() {
        ResourceLocation it;
        Collection<ResourceLocation> collection = this.playerSkinMap.values();
        Intrinsics.checkNotNullExpressionValue(collection, "<get-values>(...)");
        Iterable $this$forEach$iv = CollectionsKt.filterNotNull((Iterable)collection);
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            it = (ResourceLocation)element$iv;
            boolean bl2 = false;
            MinecraftInstance.mc.getTextureManager().func_147645_c(it);
        }
        this.playerSkinMap.clear();
        Collection<ResourceLocation> collection2 = this.playerCapeMap.values();
        Intrinsics.checkNotNullExpressionValue(collection2, "<get-values>(...)");
        $this$forEach$iv = CollectionsKt.filterNotNull((Iterable)collection2);
        $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            it = (ResourceLocation)element$iv;
            boolean bl3 = false;
            MinecraftInstance.mc.getTextureManager().func_147645_c(it);
        }
        this.playerCapeMap.clear();
        this.playerUseSlimMap.clear();
        this.checked.clear();
    }

    public final void fetchCloudSkin(@NotNull String name) {
        block3: {
            Object v1;
            block2: {
                Intrinsics.checkNotNullParameter(name, "name");
                if (this.checked.contains(name) || this.playerSkinMap.containsKey(name)) break block3;
                this.checked.add(name);
                Collection<? extends IRCDataOtherSessionInfo> collection = this.getInstance().irc.getSessionManager().getSessions().values();
                Intrinsics.checkNotNullExpressionValue(collection, "<get-values>(...)");
                Iterable $this$firstOrNull$iv = collection;
                boolean $i$f$firstOrNull = false;
                for (Object element$iv : $this$firstOrNull$iv) {
                    IRCDataOtherSessionInfo it = (IRCDataOtherSessionInfo)element$iv;
                    boolean bl2 = false;
                    if (!Intrinsics.areEqual(it.getInfo().getState().getProfile().getName(), name)) continue;
                    v1 = element$iv;
                    break block2;
                }
                v1 = null;
            }
            IRCDataOtherSessionInfo iRCDataOtherSessionInfo = v1;
            if (iRCDataOtherSessionInfo != null) {
                IRCDataOtherSessionInfo iRCDataOtherSessionInfo2;
                IRCDataOtherSessionInfo client = iRCDataOtherSessionInfo2 = iRCDataOtherSessionInfo;
                boolean bl3 = false;
                ClientUtils.INSTANCE.logInfo("[IRC] Downloading " + client.getUniqueId() + " skin...");
                this.getInstance().irc.querySkin(client.getUniqueId());
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    public final void onUpdateOtherSkin(@NotNull IRCDataOtherSessionInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        DataSkin dataSkin = info.getSkin();
        if (dataSkin != null) {
            File $this$onUpdateOtherSkin_u24lambda_u2418_u24lambda_u2413_u24lambda_u2412;
            Ref.ObjectRef objectRef;
            File file;
            byte[] byArray;
            byte[] it;
            byte[] byArray2;
            DataSkin dataSkin2;
            DataSkin skin = dataSkin2 = dataSkin;
            boolean bl2 = false;
            File cacheDir = new File(this.getInstance().fileDir, "cache");
            if (!cacheDir.exists()) {
                cacheDir.mkdirs();
            }
            Ref.ObjectRef fileSkin = new Ref.ObjectRef();
            Ref.ObjectRef fileCape = new Ref.ObjectRef();
            byte[] byArray3 = skin.getSkin();
            if (byArray3 != null) {
                it = byArray2 = byArray3;
                boolean bl3 = false;
                Object object = byArray = (Object)(!(it.length == 0) ? byArray2 : null);
                if (byArray != null) {
                    byte[] dataSkin3 = byArray2 = byArray;
                    boolean bl4 = false;
                    File file2 = file = new File(cacheDir, "skin_" + DigestUtils.md5Hex((byte[])dataSkin3) + ".png");
                    objectRef = fileSkin;
                    boolean bl5 = false;
                    FilesKt.writeBytes($this$onUpdateOtherSkin_u24lambda_u2418_u24lambda_u2413_u24lambda_u2412, dataSkin3);
                    objectRef.element = file;
                }
            }
            byArray3 = skin.getCape();
            if (byArray3 != null) {
                it = byArray2 = byArray3;
                boolean bl6 = false;
                Object object = byArray = (Object)(!(it.length == 0) ? byArray2 : null);
                if (byArray != null) {
                    void $this$onUpdateOtherSkin_u24lambda_u2418_u24lambda_u2416_u24lambda_u2415;
                    byte[] dataCape = byArray2 = byArray;
                    boolean bl7 = false;
                    $this$onUpdateOtherSkin_u24lambda_u2418_u24lambda_u2413_u24lambda_u2412 = file = new File(cacheDir, "cape_" + DigestUtils.md5Hex((byte[])dataCape) + ".png");
                    objectRef = fileCape;
                    boolean bl8 = false;
                    FilesKt.writeBytes((File)$this$onUpdateOtherSkin_u24lambda_u2418_u24lambda_u2416_u24lambda_u2415, dataCape);
                    objectRef.element = file;
                }
            }
            MinecraftInstance.mc.addScheduledTask(() -> IRCPluginSkin.onUpdateOtherSkin$lambda$18$lambda$17(this, info, fileSkin, fileCape));
            ((Map)this.playerUseSlimMap).put(info.getInfo().getState().getProfile().getName(), skin.isSlim());
            ClientUtils.INSTANCE.logInfo("[IRC] Downloaded " + info.getUniqueId() + " skin. (name=" + info.getInfo().getState().getProfile().getName() + ", skin=" + this.playerSkinMap.containsKey(info.getInfo().getState().getProfile().getName()) + ", cape=" + this.playerCapeMap.containsKey(info.getInfo().getState().getProfile().getName()) + ", slim=" + this.playerUseSlimMap.get(info.getInfo().getState().getProfile().getName()) + ')');
        } else {
            IRCPluginSkin iRCPluginSkin;
            IRCPluginSkin it = iRCPluginSkin = this;
            boolean bl9 = false;
            MinecraftInstance.mc.addScheduledTask(() -> IRCPluginSkin.onUpdateOtherSkin$lambda$22$lambda$21(this, info));
        }
    }

    private static final Unit _init_$lambda$3(IRCPluginSkin this$0, ListenerBase $this$listener, RenderEntityPlayerSkinEvent.Skin event) {
        block0: {
            ResourceLocation resourceLocation;
            Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
            Intrinsics.checkNotNullParameter(event, "event");
            String profile = event.getInfo().func_178845_a().getName();
            Intrinsics.checkNotNull(profile);
            this$0.fetchCloudSkin(profile);
            ResourceLocation resourceLocation2 = this$0.playerSkinMap.get(profile);
            if (resourceLocation2 == null) break block0;
            ResourceLocation resource = resourceLocation = resourceLocation2;
            boolean bl2 = false;
            event.setReturnValue(resource);
            event.cancelNext();
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$5(IRCPluginSkin this$0, ListenerBase $this$listener, RenderEntityPlayerSkinEvent.Cape event) {
        block0: {
            ResourceLocation resourceLocation;
            Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
            Intrinsics.checkNotNullParameter(event, "event");
            String profile = event.getInfo().func_178845_a().getName();
            ResourceLocation resourceLocation2 = this$0.playerCapeMap.get(profile);
            if (resourceLocation2 == null) break block0;
            ResourceLocation resource = resourceLocation = resourceLocation2;
            boolean bl2 = false;
            event.setReturnValue(resource);
            event.cancelNext();
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$7(IRCPluginSkin this$0, ListenerBase $this$listener, RenderEntityPlayerSkinEvent.SkinType event) {
        block0: {
            Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
            Intrinsics.checkNotNullParameter(event, "event");
            String profile = event.getInfo().func_178845_a().getName();
            Boolean bl2 = this$0.playerUseSlimMap.get(profile);
            if (bl2 == null) break block0;
            Boolean bl3 = bl2;
            boolean resource = bl3;
            boolean bl4 = false;
            event.setReturnValue(resource ? RenderEntityPlayerSkinEvent.SkinType.Type.Slim : RenderEntityPlayerSkinEvent.SkinType.Type.Default);
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$8(IRCPluginSkin this$0, ListenerBase $this$listener, TickEvent.Pre it) {
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(it, "it");
        if (this$0.checkedTimestamp + 10000L < System.currentTimeMillis()) {
            this$0.checkedTimestamp = System.currentTimeMillis();
            this$0.checked.clear();
        }
        return Unit.INSTANCE;
    }

    private static final void onUpdateOtherSkin$lambda$18$lambda$17(IRCPluginSkin this$0, IRCDataOtherSessionInfo $info, Ref.ObjectRef $fileSkin, Ref.ObjectRef $fileCape) {
        Map map = this$0.playerSkinMap;
        String string = $info.getInfo().getState().getProfile().getName();
        File file = (File)$fileSkin.element;
        ResourceLocation resourceLocation = file != null ? ResourceLocationUtils.toResourceLocation$default(ResourceLocationUtils.INSTANCE, file, null, 1, null) : null;
        map.put(string, resourceLocation);
        map = this$0.playerCapeMap;
        string = $info.getInfo().getState().getProfile().getName();
        File file2 = (File)$fileCape.element;
        resourceLocation = file2 != null ? ResourceLocationUtils.toResourceLocation$default(ResourceLocationUtils.INSTANCE, file2, null, 1, null) : null;
        map.put(string, resourceLocation);
    }

    private static final void onUpdateOtherSkin$lambda$22$lambda$21(IRCPluginSkin this$0, IRCDataOtherSessionInfo $info) {
        ResourceLocation it;
        ResourceLocation resourceLocation;
        ResourceLocation resourceLocation2 = this$0.playerSkinMap.get($info.getInfo().getState().getProfile().getName());
        if (resourceLocation2 != null) {
            it = resourceLocation = resourceLocation2;
            boolean bl2 = false;
            MinecraftInstance.mc.getTextureManager().func_147645_c(it);
            this$0.playerSkinMap.remove($info.getInfo().getState().getProfile().getName());
        }
        resourceLocation2 = this$0.playerCapeMap.get($info.getInfo().getState().getProfile().getName());
        if (resourceLocation2 != null) {
            it = resourceLocation = resourceLocation2;
            boolean bl3 = false;
            MinecraftInstance.mc.getTextureManager().func_147645_c(it);
            this$0.playerCapeMap.remove($info.getInfo().getState().getProfile().getName());
        }
        this$0.playerUseSlimMap.remove($info.getInfo().getState().getProfile().getName());
        this$0.checked.remove($info.getInfo().getState().getProfile().getName());
        ClientUtils.INSTANCE.logInfo("[IRC] Reset " + $info.getUniqueId() + " skin.");
    }
}

