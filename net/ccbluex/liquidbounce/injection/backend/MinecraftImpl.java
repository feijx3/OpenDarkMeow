/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.util.concurrent.ListenableFuture
 *  com.mojang.authlib.minecraft.MinecraftSessionService
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.audio.SoundHandler
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.GuiMainMenu
 *  net.minecraft.client.gui.GuiMultiplayer
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 *  net.minecraft.client.multiplayer.ServerData
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.client.particle.ParticleManager
 *  net.minecraft.client.renderer.EntityRenderer
 *  net.minecraft.client.renderer.ItemRenderer
 *  net.minecraft.client.renderer.RenderGlobal
 *  net.minecraft.client.renderer.RenderItem
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.client.renderer.texture.TextureManager
 *  net.minecraft.client.resources.IResourceManager
 *  net.minecraft.client.resources.LanguageManager
 *  net.minecraft.client.settings.GameSettings
 *  net.minecraft.client.shader.Framebuffer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.Session
 *  net.minecraft.util.Timer
 *  net.minecraft.util.math.RayTraceResult
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.injection.backend;

import com.google.common.util.concurrent.ListenableFuture;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import java.io.File;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.injection.access.AccessorMinecraft;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.LanguageManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.entity.Entity;
import net.minecraft.util.Session;
import net.minecraft.util.Timer;
import net.minecraft.util.math.RayTraceResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u008e\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0088\u0001\u001a\u00030\u0089\u00012\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010RJ\b\u0010\u008b\u0001\u001a\u00030\u0089\u0001J\u0011\u0010\u008c\u0001\u001a\u00030\u0089\u00012\u0007\u0010\u008d\u0001\u001a\u00020\u0011J\b\u0010\u008e\u0001\u001a\u00030\u0089\u0001J\b\u0010\u008f\u0001\u001a\u00030\u0089\u0001J\b\u0010\u0094\u0001\u001a\u00030\u0089\u0001J'\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u0003H\u0097\u00010\u0096\u0001\"\u0005\b\u0000\u0010\u0097\u00012\u000f\u0010\u0098\u0001\u001a\n\u0012\u0005\u0012\u0003H\u0097\u00010\u0099\u0001J\u0018\u0010\u0095\u0001\u001a\t\u0012\u0004\u0012\u00020\u00010\u0096\u00012\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u0004\u0018\u00010\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c8F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\b$\u0010\u001aR\u0011\u0010%\u001a\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\b&\u0010\u001aR\u0011\u0010'\u001a\u00020(8F\u00a2\u0006\u0006\u001a\u0004\b)\u0010*R$\u0010,\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b-\u0010\u001a\"\u0004\b.\u0010/R(\u00101\u001a\u0004\u0018\u0001002\b\u0010+\u001a\u0004\u0018\u0001008F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0011\u00106\u001a\u0002078F\u00a2\u0006\u0006\u001a\u0004\b8\u00109R\u0011\u0010:\u001a\u00020;8F\u00a2\u0006\u0006\u001a\u0004\b<\u0010=R\u0013\u0010>\u001a\u0004\u0018\u00010?8F\u00a2\u0006\u0006\u001a\u0004\b@\u0010AR\u0011\u0010B\u001a\u00020C8F\u00a2\u0006\u0006\u001a\u0004\bD\u0010ER\u0011\u0010F\u001a\u00020G8F\u00a2\u0006\u0006\u001a\u0004\bH\u0010IR\u0011\u0010J\u001a\u00020K8F\u00a2\u0006\u0006\u001a\u0004\bL\u0010MR\u0011\u0010N\u001a\u00020O8F\u00a2\u0006\u0006\u001a\u0004\bP\u0010QR(\u0010S\u001a\u0004\u0018\u00010R2\b\u0010+\u001a\u0004\u0018\u00010R8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR(\u0010Y\u001a\u0004\u0018\u00010X2\b\u0010+\u001a\u0004\u0018\u00010X8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u0013\u0010^\u001a\u0004\u0018\u00010_8F\u00a2\u0006\u0006\u001a\u0004\b`\u0010aR\u0013\u0010b\u001a\u0004\u0018\u00010c8F\u00a2\u0006\u0006\u001a\u0004\bd\u0010eR\u0011\u0010f\u001a\u00020g8F\u00a2\u0006\u0006\u001a\u0004\bh\u0010iR\u0011\u0010j\u001a\u00020k8F\u00a2\u0006\u0006\u001a\u0004\bl\u0010mR\u0011\u0010n\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\bn\u0010\u0012R\u0013\u0010o\u001a\u0004\u0018\u00010p8F\u00a2\u0006\u0006\u001a\u0004\bq\u0010rR\u0011\u0010s\u001a\u00020t8F\u00a2\u0006\u0006\u001a\u0004\bu\u0010vR\u0011\u0010w\u001a\u00020x8F\u00a2\u0006\u0006\u001a\u0004\by\u0010zR\u0011\u0010{\u001a\u00020|8F\u00a2\u0006\u0006\u001a\u0004\b}\u0010~R\u0016\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u00018F\u00a2\u0006\b\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0013\u0010\u0083\u0001\u001a\u00020\u00118F\u00a2\u0006\u0007\u001a\u0005\b\u0083\u0001\u0010\u0012R\u0015\u0010\u0084\u0001\u001a\u00030\u0085\u00018F\u00a2\u0006\b\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R(\u0010\u0090\u0001\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00118F@FX\u0086\u000e\u00a2\u0006\u000f\u001a\u0005\b\u0091\u0001\u0010\u0012\"\u0006\b\u0092\u0001\u0010\u0093\u0001\u00a8\u0006\u009c\u0001"}, d2={"Lnet/ccbluex/liquidbounce/injection/backend/MinecraftImpl;", "", "wrapped", "Lnet/minecraft/client/Minecraft;", "<init>", "(Lnet/minecraft/client/Minecraft;)V", "getWrapped", "()Lnet/minecraft/client/Minecraft;", "connection", "Lnet/minecraft/client/network/NetHandlerPlayClient;", "getConnection", "()Lnet/minecraft/client/network/NetHandlerPlayClient;", "framebuffer", "Lnet/minecraft/client/shader/Framebuffer;", "getFramebuffer", "()Lnet/minecraft/client/shader/Framebuffer;", "isFullScreen", "", "()Z", "gameDir", "Ljava/io/File;", "getGameDir", "()Ljava/io/File;", "debugFPS", "", "getDebugFPS", "()I", "renderGlobal", "Lnet/minecraft/client/renderer/RenderGlobal;", "getRenderGlobal", "()Lnet/minecraft/client/renderer/RenderGlobal;", "renderItem", "Lnet/minecraft/client/renderer/RenderItem;", "getRenderItem", "()Lnet/minecraft/client/renderer/RenderItem;", "displayWidth", "getDisplayWidth", "displayHeight", "getDisplayHeight", "entityRenderer", "Lnet/minecraft/client/renderer/EntityRenderer;", "getEntityRenderer", "()Lnet/minecraft/client/renderer/EntityRenderer;", "value", "rightClickDelayTimer", "getRightClickDelayTimer", "setRightClickDelayTimer", "(I)V", "Lnet/minecraft/util/Session;", "session", "getSession", "()Lnet/minecraft/util/Session;", "setSession", "(Lnet/minecraft/util/Session;)V", "sessionService", "Lcom/mojang/authlib/minecraft/MinecraftSessionService;", "getSessionService", "()Lcom/mojang/authlib/minecraft/MinecraftSessionService;", "soundHandler", "Lnet/minecraft/client/audio/SoundHandler;", "getSoundHandler", "()Lnet/minecraft/client/audio/SoundHandler;", "objectMouseOver", "Lnet/minecraft/util/math/RayTraceResult;", "getObjectMouseOver", "()Lnet/minecraft/util/math/RayTraceResult;", "timer", "Lnet/minecraft/util/Timer;", "getTimer", "()Lnet/minecraft/util/Timer;", "renderManager", "Lnet/minecraft/client/renderer/entity/RenderManager;", "getRenderManager", "()Lnet/minecraft/client/renderer/entity/RenderManager;", "effectRenderer", "Lnet/minecraft/client/particle/ParticleManager;", "getEffectRenderer", "()Lnet/minecraft/client/particle/ParticleManager;", "playerController", "Lnet/minecraft/client/multiplayer/PlayerControllerMP;", "getPlayerController", "()Lnet/minecraft/client/multiplayer/PlayerControllerMP;", "Lnet/minecraft/client/gui/GuiScreen;", "currentScreen", "getCurrentScreen", "()Lnet/minecraft/client/gui/GuiScreen;", "setCurrentScreen", "(Lnet/minecraft/client/gui/GuiScreen;)V", "Lnet/minecraft/entity/Entity;", "renderViewEntity", "getRenderViewEntity", "()Lnet/minecraft/entity/Entity;", "setRenderViewEntity", "(Lnet/minecraft/entity/Entity;)V", "world", "Lnet/minecraft/client/multiplayer/WorldClient;", "getWorld", "()Lnet/minecraft/client/multiplayer/WorldClient;", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "getPlayer", "()Lnet/minecraft/client/entity/EntityPlayerSP;", "textureManager", "Lnet/minecraft/client/renderer/texture/TextureManager;", "getTextureManager", "()Lnet/minecraft/client/renderer/texture/TextureManager;", "resourceManager", "Lnet/minecraft/client/resources/IResourceManager;", "getResourceManager", "()Lnet/minecraft/client/resources/IResourceManager;", "isIntegratedServerRunning", "currentServerData", "Lnet/minecraft/client/multiplayer/ServerData;", "getCurrentServerData", "()Lnet/minecraft/client/multiplayer/ServerData;", "gameSettings", "Lnet/minecraft/client/settings/GameSettings;", "getGameSettings", "()Lnet/minecraft/client/settings/GameSettings;", "fontRenderer", "Lnet/minecraft/client/gui/FontRenderer;", "getFontRenderer", "()Lnet/minecraft/client/gui/FontRenderer;", "itemRenderer", "Lnet/minecraft/client/renderer/ItemRenderer;", "getItemRenderer", "()Lnet/minecraft/client/renderer/ItemRenderer;", "languageManager", "Lnet/minecraft/client/resources/LanguageManager;", "getLanguageManager", "()Lnet/minecraft/client/resources/LanguageManager;", "isSingleplayer", "renderPartialTicksPaused", "", "getRenderPartialTicksPaused", "()F", "displayGuiScreen", "", "screen", "rightClickMouse", "sendClickBlockToController", "leftClick", "shutdown", "toggleFullscreen", "renderChunksMany", "getRenderChunksMany", "setRenderChunksMany", "(Z)V", "quitWorld", "addScheduledTask", "Lcom/google/common/util/concurrent/ListenableFuture;", "V", "callable", "Ljava/util/concurrent/Callable;", "runnable", "Ljava/lang/Runnable;", "DarkMeow"})
public final class MinecraftImpl {
    @NotNull
    private final Minecraft wrapped;

    public MinecraftImpl(@NotNull Minecraft wrapped) {
        Intrinsics.checkNotNullParameter(wrapped, "wrapped");
        this.wrapped = wrapped;
    }

    @NotNull
    public final Minecraft getWrapped() {
        return this.wrapped;
    }

    @Nullable
    public final NetHandlerPlayClient getConnection() {
        return this.wrapped.func_147114_u();
    }

    @NotNull
    public final Framebuffer getFramebuffer() {
        Framebuffer framebuffer = this.wrapped.func_147110_a();
        Intrinsics.checkNotNullExpressionValue(framebuffer, "getFramebuffer(...)");
        return framebuffer;
    }

    public final boolean isFullScreen() {
        return this.wrapped.func_71372_G();
    }

    @NotNull
    public final File getGameDir() {
        File file = this.wrapped.field_71412_D;
        Intrinsics.checkNotNullExpressionValue(file, "gameDir");
        return file;
    }

    public final int getDebugFPS() {
        return Minecraft.func_175610_ah();
    }

    @NotNull
    public final RenderGlobal getRenderGlobal() {
        RenderGlobal renderGlobal = this.wrapped.field_71438_f;
        Intrinsics.checkNotNullExpressionValue(renderGlobal, "renderGlobal");
        return renderGlobal;
    }

    @NotNull
    public final RenderItem getRenderItem() {
        RenderItem renderItem = this.wrapped.func_175599_af();
        Intrinsics.checkNotNullExpressionValue(renderItem, "getRenderItem(...)");
        return renderItem;
    }

    public final int getDisplayWidth() {
        return this.wrapped.field_71443_c;
    }

    public final int getDisplayHeight() {
        return this.wrapped.field_71440_d;
    }

    @NotNull
    public final EntityRenderer getEntityRenderer() {
        EntityRenderer entityRenderer = this.wrapped.field_71460_t;
        Intrinsics.checkNotNullExpressionValue(entityRenderer, "entityRenderer");
        return entityRenderer;
    }

    public final int getRightClickDelayTimer() {
        Minecraft minecraft = this.wrapped;
        Intrinsics.checkNotNull(minecraft, "null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.access.AccessorMinecraft");
        return ((AccessorMinecraft)minecraft).getRightClickDelayTimer();
    }

    public final void setRightClickDelayTimer(int value) {
        Minecraft minecraft = this.wrapped;
        Intrinsics.checkNotNull(minecraft, "null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.access.AccessorMinecraft");
        ((AccessorMinecraft)minecraft).setRightClickDelayTimer(value);
    }

    @Nullable
    public final Session getSession() {
        return this.wrapped.func_110432_I();
    }

    public final void setSession(@Nullable Session value) {
        Minecraft minecraft = this.wrapped;
        Intrinsics.checkNotNull(minecraft, "null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.access.AccessorMinecraft");
        ((AccessorMinecraft)minecraft).setSession(value);
    }

    @NotNull
    public final MinecraftSessionService getSessionService() {
        MinecraftSessionService minecraftSessionService = this.wrapped.func_152347_ac();
        Intrinsics.checkNotNullExpressionValue(minecraftSessionService, "getSessionService(...)");
        return minecraftSessionService;
    }

    @NotNull
    public final SoundHandler getSoundHandler() {
        SoundHandler soundHandler = this.wrapped.func_147118_V();
        Intrinsics.checkNotNullExpressionValue(soundHandler, "getSoundHandler(...)");
        return soundHandler;
    }

    @Nullable
    public final RayTraceResult getObjectMouseOver() {
        return this.wrapped.field_71476_x;
    }

    @NotNull
    public final Timer getTimer() {
        Minecraft minecraft = this.wrapped;
        Intrinsics.checkNotNull(minecraft, "null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.access.AccessorMinecraft");
        Timer timer = ((AccessorMinecraft)minecraft).getTimer();
        Intrinsics.checkNotNullExpressionValue(timer, "getTimer(...)");
        return timer;
    }

    @NotNull
    public final RenderManager getRenderManager() {
        RenderManager renderManager = this.wrapped.func_175598_ae();
        Intrinsics.checkNotNullExpressionValue(renderManager, "getRenderManager(...)");
        return renderManager;
    }

    @NotNull
    public final ParticleManager getEffectRenderer() {
        ParticleManager particleManager = this.wrapped.field_71452_i;
        Intrinsics.checkNotNullExpressionValue(particleManager, "effectRenderer");
        return particleManager;
    }

    @NotNull
    public final PlayerControllerMP getPlayerController() {
        PlayerControllerMP playerControllerMP = this.wrapped.field_71442_b;
        Intrinsics.checkNotNullExpressionValue(playerControllerMP, "playerController");
        return playerControllerMP;
    }

    @Nullable
    public final GuiScreen getCurrentScreen() {
        return this.wrapped.field_71462_r;
    }

    public final void setCurrentScreen(@Nullable GuiScreen value) {
        this.displayGuiScreen(value);
    }

    @Nullable
    public final Entity getRenderViewEntity() {
        return this.wrapped.func_175606_aa();
    }

    public final void setRenderViewEntity(@Nullable Entity value) {
        this.wrapped.func_175607_a(value);
    }

    @Nullable
    public final WorldClient getWorld() {
        return this.wrapped.field_71441_e;
    }

    @Nullable
    public final EntityPlayerSP getPlayer() {
        return this.wrapped.field_71439_g;
    }

    @NotNull
    public final TextureManager getTextureManager() {
        TextureManager textureManager = this.wrapped.func_110434_K();
        Intrinsics.checkNotNullExpressionValue(textureManager, "getTextureManager(...)");
        return textureManager;
    }

    @NotNull
    public final IResourceManager getResourceManager() {
        IResourceManager iResourceManager = this.wrapped.func_110442_L();
        Intrinsics.checkNotNullExpressionValue(iResourceManager, "getResourceManager(...)");
        return iResourceManager;
    }

    public final boolean isIntegratedServerRunning() {
        return this.wrapped.func_71387_A();
    }

    @Nullable
    public final ServerData getCurrentServerData() {
        return this.wrapped.func_147104_D();
    }

    @NotNull
    public final GameSettings getGameSettings() {
        GameSettings gameSettings = this.wrapped.field_71474_y;
        Intrinsics.checkNotNullExpressionValue(gameSettings, "gameSettings");
        return gameSettings;
    }

    @NotNull
    public final FontRenderer getFontRenderer() {
        FontRenderer fontRenderer = this.wrapped.field_71466_p;
        Intrinsics.checkNotNullExpressionValue(fontRenderer, "fontRenderer");
        return fontRenderer;
    }

    @NotNull
    public final ItemRenderer getItemRenderer() {
        ItemRenderer itemRenderer = this.wrapped.func_175597_ag();
        Intrinsics.checkNotNullExpressionValue(itemRenderer, "getItemRenderer(...)");
        return itemRenderer;
    }

    @Nullable
    public final LanguageManager getLanguageManager() {
        return this.wrapped.func_135016_M();
    }

    public final boolean isSingleplayer() {
        return this.wrapped.func_71356_B();
    }

    public final float getRenderPartialTicksPaused() {
        Minecraft minecraft = this.wrapped;
        Intrinsics.checkNotNull(minecraft, "null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.access.AccessorMinecraft");
        return ((AccessorMinecraft)minecraft).getRenderPartialTicksPaused();
    }

    public final void displayGuiScreen(@Nullable GuiScreen screen) {
        this.wrapped.func_147108_a(screen);
    }

    public final void rightClickMouse() {
        Minecraft minecraft = this.wrapped;
        Intrinsics.checkNotNull(minecraft, "null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.access.AccessorMinecraft");
        ((AccessorMinecraft)minecraft).invokeRightClickMouse();
    }

    public final void sendClickBlockToController(boolean leftClick) {
        Minecraft minecraft = this.wrapped;
        Intrinsics.checkNotNull(minecraft, "null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.access.AccessorMinecraft");
        ((AccessorMinecraft)minecraft).invokeSendClickBlockToController(leftClick);
    }

    public final void shutdown() {
        this.wrapped.func_71400_g();
    }

    public final void toggleFullscreen() {
        this.wrapped.func_71352_k();
    }

    public final boolean getRenderChunksMany() {
        return this.wrapped.field_175612_E;
    }

    public final void setRenderChunksMany(boolean value) {
        this.wrapped.field_175612_E = value;
    }

    public final void quitWorld() {
        boolean isSinglePlay = this.wrapped.func_71387_A();
        this.wrapped.field_71441_e.func_72882_A();
        this.wrapped.func_71403_a(null);
        if (isSinglePlay) {
            this.wrapped.func_147108_a((GuiScreen)new GuiMainMenu());
        } else {
            this.wrapped.func_147108_a((GuiScreen)new GuiMultiplayer((GuiScreen)new GuiMainMenu()));
        }
    }

    @NotNull
    public final <V> ListenableFuture<V> addScheduledTask(@NotNull Callable<V> callable) {
        Intrinsics.checkNotNullParameter(callable, "callable");
        ListenableFuture listenableFuture = this.wrapped.func_152343_a(callable);
        Intrinsics.checkNotNullExpressionValue(listenableFuture, "addScheduledTask(...)");
        return listenableFuture;
    }

    @NotNull
    public final ListenableFuture<Object> addScheduledTask(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ListenableFuture listenableFuture = this.wrapped.func_152344_a(runnable);
        Intrinsics.checkNotNullExpressionValue(listenableFuture, "addScheduledTask(...)");
        return listenableFuture;
    }
}

