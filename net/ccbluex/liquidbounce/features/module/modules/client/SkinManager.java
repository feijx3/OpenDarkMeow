/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.client.network.NetworkPlayerInfo
 *  net.minecraft.util.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.client;

import com.mojang.authlib.GameProfile;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.event.events.render.entity.RenderEntityPlayerSkinEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.file.ResourceLocationUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ModuleInfo(name="SkinManager", category=ModuleCategory.CLIENT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0002J&\u0010\u0018\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\tH\u0007J\b\u0010\u001d\u001a\u00020\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\"H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00110\u000fj\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/SkinManager;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "skinSelfValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "skinOtherValue", "skinOtherOnlyReplaceDefaultSkinValue", "Lnet/ccbluex/liquidbounce/value/Value;", "", "skinOtherUsingRandomValue", "dirSkinRoot", "Ljava/io/File;", "dirSkinRandom", "skinCacheRandom", "Ljava/util/HashMap;", "", "Lnet/minecraft/util/ResourceLocation;", "Lkotlin/collections/HashMap;", "skinCacheStatic", "entityPlayerLinkedSkin", "Ljava/util/UUID;", "reloadSkins", "", "getSkin", "info", "Lcom/mojang/authlib/GameProfile;", "isSelf", "tryUseNormalSkin", "onEnable", "onWorld", "event", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "onRenderEntityPlayerSkin", "Lnet/ccbluex/liquidbounce/event/events/render/entity/RenderEntityPlayerSkinEvent;", "Companion", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nSkinManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SkinManager.kt\nnet/ccbluex/liquidbounce/features/module/modules/client/SkinManager\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,128:1\n3829#2:129\n4344#2,2:130\n3829#2:135\n4344#2,2:136\n1869#3:132\n1870#3:134\n1869#3,2:138\n1#4:133\n*S KotlinDebug\n*F\n+ 1 SkinManager.kt\nnet/ccbluex/liquidbounce/features/module/modules/client/SkinManager\n*L\n61#1:129\n61#1:130,2\n70#1:135\n70#1:136,2\n65#1:132\n65#1:134\n74#1:138,2\n*E\n"})
public final class SkinManager
extends Module {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final BoolValue skinSelfValue = new BoolValue("SkinSelf", true);
    @NotNull
    private final BoolValue skinOtherValue = new BoolValue("SkinOther", true);
    @NotNull
    private final Value<Boolean> skinOtherOnlyReplaceDefaultSkinValue = new BoolValue("SkinOtherOnlyReplaceDefaultSkin", true).displayable(() -> SkinManager.skinOtherOnlyReplaceDefaultSkinValue$lambda$0(this));
    @NotNull
    private final Value<Boolean> skinOtherUsingRandomValue = new BoolValue(this){
        final /* synthetic */ SkinManager this$0;
        {
            this.this$0 = $receiver;
            super("SkinOtherUsingRandom", true);
        }

        protected void onChanged(boolean oldValue, boolean newValue) {
            SkinManager.access$getEntityPlayerLinkedSkin$p(this.this$0).clear();
        }
    }.displayable(() -> SkinManager.skinOtherUsingRandomValue$lambda$1(this));
    @NotNull
    private final File dirSkinRoot = new File(DarkMeow.INSTANCE.getFileManager().getDir(), "skins");
    @NotNull
    private final File dirSkinRandom = new File(this.dirSkinRoot, "random");
    @NotNull
    private final HashMap<String, ResourceLocation> skinCacheRandom = new HashMap();
    @NotNull
    private final HashMap<String, ResourceLocation> skinCacheStatic = new HashMap();
    @NotNull
    private HashMap<UUID, ResourceLocation> entityPlayerLinkedSkin = new HashMap();
    @NotNull
    private static final String[] DEFAULT_SKINS;

    public SkinManager() {
        super(null, null, null, null, 15, null);
    }

    /*
     * Unable to fully structure code
     */
    private final void reloadSkins() {
        block11: {
            block10: {
                this.skinCacheStatic.clear();
                this.skinCacheRandom.clear();
                this.entityPlayerLinkedSkin.clear();
                if (!this.dirSkinRoot.exists()) {
                    this.dirSkinRoot.mkdirs();
                }
                if (!this.dirSkinRandom.exists()) {
                    this.dirSkinRandom.mkdirs();
                }
                if ((var1_1 = this.dirSkinRoot.listFiles()) == null) break block10;
                $this$filter$iv = var1_1;
                $i$f$filter = false;
                var4_4 = $this$filter$iv;
                destination$iv$iv = new ArrayList<E>();
                $i$f$filterTo = false;
                var8_10 = $this$filterTo$iv$iv.length;
                for (var7_9 = 0; var7_9 < var8_10; ++var7_9) {
                    file = element$iv$iv = $this$filterTo$iv$iv[var7_9];
                    $i$a$-filter-SkinManager$reloadSkins$1 = false;
                    if (!file.isFile()) ** GOTO lbl-1000
                    Intrinsics.checkNotNull(file);
                    if (StringsKt.equals(FilesKt.getExtension(file), "png", true)) {
                        v0 = true;
                    } else lbl-1000:
                    // 2 sources

                    {
                        v0 = false;
                    }
                    if (!v0) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                $this$forEach$iv = (List)destination$iv$iv;
                $i$f$forEach = false;
                for (E element$iv : $this$forEach$iv) {
                    file = (File)element$iv;
                    $i$a$-forEach-SkinManager$reloadSkins$2 = 0;
                    Intrinsics.checkNotNull(file);
                    if (ResourceLocationUtils.toResourceLocation$default(ResourceLocationUtils.INSTANCE, file, null, 1, null) == null) continue;
                    $i$a$-let-SkinManager$reloadSkins$2$1 = false;
                    ((Map)this.skinCacheStatic).put(FilesKt.getNameWithoutExtension(file), it);
                }
            }
            if ((var1_1 = this.dirSkinRandom.listFiles()) == null) break block11;
            $this$filter$iv = var1_1;
            $i$f$filter = false;
            $this$filterTo$iv$iv = $this$filter$iv;
            destination$iv$iv = new ArrayList<E>();
            $i$f$filterTo = false;
            it = $this$filterTo$iv$iv.length;
            for ($i$a$-forEach-SkinManager$reloadSkins$2 = 0; $i$a$-forEach-SkinManager$reloadSkins$2 < it; ++$i$a$-forEach-SkinManager$reloadSkins$2) {
                file = element$iv$iv = $this$filterTo$iv$iv[$i$a$-forEach-SkinManager$reloadSkins$2];
                $i$a$-filter-SkinManager$reloadSkins$3 = false;
                if (!file.isFile()) ** GOTO lbl-1000
                Intrinsics.checkNotNull(file);
                if (StringsKt.equals(FilesKt.getExtension(file), "png", true)) {
                    v1 = true;
                } else lbl-1000:
                // 2 sources

                {
                    v1 = false;
                }
                if (!v1) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            $this$forEach$iv = (List)destination$iv$iv;
            $i$f$forEach = false;
            for (E element$iv : $this$forEach$iv) {
                file = (File)element$iv;
                $i$a$-forEach-SkinManager$reloadSkins$4 = false;
                Intrinsics.checkNotNull(file);
                if (ResourceLocationUtils.toResourceLocation$default(ResourceLocationUtils.INSTANCE, file, null, 1, null) == null) continue;
                $i$a$-let-SkinManager$reloadSkins$4$1 = false;
                ((Map)this.skinCacheRandom).put(FilesKt.getNameWithoutExtension(file), it);
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @JvmOverloads
    @Nullable
    public final ResourceLocation getSkin(@NotNull GameProfile info, boolean isSelf, boolean tryUseNormalSkin) {
        NetHandlerPlayClient netHandlerPlayClient;
        Intrinsics.checkNotNullParameter(info, "info");
        ResourceLocation resourceLocation = this.entityPlayerLinkedSkin.get(info.getId());
        Object object = resourceLocation;
        if (resourceLocation != null) return object;
        SkinManager it = this;
        boolean bl2 = false;
        Boolean bl3 = isSelf;
        boolean it2 = bl3;
        boolean bl4 = false;
        object = it2 ? bl3 : null;
        if (object != null) {
            boolean it3 = (Boolean)object;
            boolean bl5 = false;
            ResourceLocation resourceLocation2 = this.skinCacheStatic.get("SELF_SKIN");
            object = resourceLocation2;
            if (resourceLocation2 != null) return object;
        }
        SkinManager it4 = this;
        boolean bl6 = false;
        ResourceLocation resourceLocation3 = this.skinCacheStatic.get(info.getName());
        object = resourceLocation3;
        if (resourceLocation3 != null) return object;
        SkinManager it5 = this;
        boolean bl7 = false;
        ResourceLocation resourceLocation4 = this.skinCacheStatic.get(info.getId().toString());
        object = resourceLocation4;
        if (resourceLocation4 != null) return object;
        SkinManager it6 = this;
        boolean bl8 = false;
        Boolean bl9 = this.skinOtherUsingRandomValue.get();
        boolean it7 = bl9;
        boolean bl10 = false;
        if (!it7) return null;
        Boolean bl11 = bl9;
        if (bl11 == null) return null;
        it7 = bl11;
        boolean bl12 = false;
        Collection<ResourceLocation> collection = this.skinCacheRandom.values();
        Intrinsics.checkNotNullExpressionValue(collection, "<get-values>(...)");
        object = CollectionsKt.randomOrNull(collection, Random.Default);
        if (object != null) {
            Object object2;
            Object skin = object2 = object;
            boolean bl13 = false;
            ((Map)this.entityPlayerLinkedSkin).put(info.getId(), skin);
            Object object = object2;
            object = object;
            if (object3 != null) return object;
        }
        SkinManager it8 = this;
        boolean bl14 = false;
        NetHandlerPlayClient netHandlerPlayClient2 = MinecraftInstance.mc.getConnection();
        if (netHandlerPlayClient2 == null) return null;
        NetHandlerPlayClient it9 = netHandlerPlayClient = netHandlerPlayClient2;
        boolean bl15 = false;
        if (!tryUseNormalSkin) return null;
        NetHandlerPlayClient netHandlerPlayClient3 = netHandlerPlayClient;
        NetHandlerPlayClient netHandlerPlayClient4 = netHandlerPlayClient3;
        if (netHandlerPlayClient4 == null) return null;
        netHandlerPlayClient = netHandlerPlayClient4.func_175102_a(info.getId());
        if (netHandlerPlayClient == null) return null;
        object = netHandlerPlayClient.func_178837_g();
        return object;
    }

    public static /* synthetic */ ResourceLocation getSkin$default(SkinManager skinManager, GameProfile gameProfile, boolean bl2, boolean bl3, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        if ((n2 & 4) != 0) {
            bl3 = false;
        }
        return skinManager.getSkin(gameProfile, bl2, bl3);
    }

    @Override
    public void onEnable() {
        this.reloadSkins();
    }

    @EventTarget
    public final void onWorld(@NotNull WorldEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.entityPlayerLinkedSkin.clear();
    }

    @EventTarget
    public final void onRenderEntityPlayerSkin(@NotNull RenderEntityPlayerSkinEvent event) {
        block5: {
            NetworkPlayerInfo networkPlayerInfo;
            Intrinsics.checkNotNullParameter(event, "event");
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null) {
                return;
            }
            EntityPlayerSP player = entityPlayerSP;
            NetworkPlayerInfo networkPlayerInfo2 = event.getInfo();
            if (networkPlayerInfo2 == null) break block5;
            NetworkPlayerInfo info = networkPlayerInfo = networkPlayerInfo2;
            boolean bl2 = false;
            boolean isSelf = Intrinsics.areEqual(info.func_178845_a(), player.func_146103_bH());
            if (!((Boolean)this.skinSelfValue.get()).booleanValue() && isSelf) {
                return;
            }
            if (!((Boolean)this.skinOtherValue.get()).booleanValue() && !isSelf) {
                return;
            }
            if (this.skinOtherOnlyReplaceDefaultSkinValue.get().booleanValue() && !Intrinsics.areEqual(info.func_178845_a(), player.func_146103_bH()) && !ArraysKt.contains(DEFAULT_SKINS, ((ResourceLocation)event.getReturnValue()).toString())) {
                return;
            }
            GameProfile gameProfile = info.func_178845_a();
            Intrinsics.checkNotNullExpressionValue(gameProfile, "getGameProfile(...)");
            ResourceLocation resourceLocation = SkinManager.getSkin$default(this, gameProfile, isSelf, false, 4, null);
            if (resourceLocation != null) {
                ResourceLocation resourceLocation2;
                ResourceLocation skin = resourceLocation2 = resourceLocation;
                boolean bl3 = false;
                event.setReturnValue(skin);
            }
        }
    }

    @JvmOverloads
    @Nullable
    public final ResourceLocation getSkin(@NotNull GameProfile info, boolean isSelf) {
        Intrinsics.checkNotNullParameter(info, "info");
        return SkinManager.getSkin$default(this, info, isSelf, false, 4, null);
    }

    @JvmOverloads
    @Nullable
    public final ResourceLocation getSkin(@NotNull GameProfile info) {
        Intrinsics.checkNotNullParameter(info, "info");
        return SkinManager.getSkin$default(this, info, false, false, 6, null);
    }

    private static final boolean skinOtherOnlyReplaceDefaultSkinValue$lambda$0(SkinManager this$0) {
        return (Boolean)this$0.skinOtherValue.get();
    }

    private static final boolean skinOtherUsingRandomValue$lambda$1(SkinManager this$0) {
        return (Boolean)this$0.skinOtherValue.get();
    }

    public static final /* synthetic */ HashMap access$getEntityPlayerLinkedSkin$p(SkinManager $this) {
        return $this.entityPlayerLinkedSkin;
    }

    static {
        String[] stringArray = new String[]{"minecraft:textures/entity/steve.png", "minecraft:textures/entity/alex.png"};
        DEFAULT_SKINS = stringArray;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/SkinManager$Companion;", "", "<init>", "()V", "DEFAULT_SKINS", "", "", "getDEFAULT_SKINS", "()[Ljava/lang/String;", "[Ljava/lang/String;", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String[] getDEFAULT_SKINS() {
            return DEFAULT_SKINS;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

