/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.GuiMultiplayer
 *  net.minecraft.client.gui.GuiOptions
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.GuiWorldSelection
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.fml.client.GuiModList
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.lwjgl.opengl.GL11
 */
package net.ccbluex.liquidbounce.ui.client;

import java.awt.Color;
import java.io.File;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.ui.client.altmanager.GuiAltManager;
import net.ccbluex.liquidbounce.ui.font.Fonts;
import net.ccbluex.liquidbounce.utils.extensions.RendererExtensionKt;
import net.ccbluex.liquidbounce.utils.file.ClientInfoUtils;
import net.ccbluex.liquidbounce.utils.file.FileUtils;
import net.ccbluex.liquidbounce.utils.file.ResourceLocationUtils;
import net.ccbluex.liquidbounce.utils.render.AnimationUtils;
import net.ccbluex.liquidbounce.utils.render.RenderUtils;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiWorldSelection;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.GuiModList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL11;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\f\n\u0002\b\u0004\u0018\u0000 -2\u00020\u0001:\u0002-.B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J \u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001aH\u0014J\u001e\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u0005J\u0006\u0010!\u001a\u00020\u0017J\u0006\u0010\"\u001a\u00020\u0017J\u001e\u0010#\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0005J6\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aJ\u0018\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001aH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/GuiMainMenu;", "Lnet/minecraft/client/gui/GuiScreen;", "<init>", "()V", "slideX", "", "fade", "getFade", "()F", "setFade", "(F)V", "sliderX", "sliderDarkX", "lastAnimTick", "", "alrUpdate", "", "lastXPos", "currentX", "currentY", "font", "Lnet/minecraft/client/gui/FontRenderer;", "initGui", "", "drawScreen", "mouseX", "", "mouseY", "partialTicks", "mouseClicked", "mouseButton", "moveMouseEffect", "strength", "renderSwitchButton", "renderDarkModeButton", "renderBar", "isMouseHover", "x", "y", "x2", "y2", "keyTyped", "typedChar", "", "keyCode", "Companion", "ImageButton", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nGuiMainMenu.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GuiMainMenu.kt\nnet/ccbluex/liquidbounce/ui/client/GuiMainMenu\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,242:1\n37#2:243\n36#2,3:244\n*S KotlinDebug\n*F\n+ 1 GuiMainMenu.kt\nnet/ccbluex/liquidbounce/ui/client/GuiMainMenu\n*L\n125#1:243\n125#1:244,3\n*E\n"})
public final class GuiMainMenu
extends GuiScreen {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private float slideX;
    private float fade;
    private float sliderX;
    private float sliderDarkX;
    private long lastAnimTick;
    private boolean alrUpdate;
    private float lastXPos;
    private float currentX;
    private float currentY;
    @NotNull
    private final FontRenderer font = Fonts.minecraftFont;
    private static boolean mainMenuPrep;
    private static boolean darkMode;
    private static boolean useParallax;
    @Nullable
    private static ResourceLocation background;

    public final float getFade() {
        return this.fade;
    }

    public final void setFade(float f2) {
        this.fade = f2;
    }

    public void func_73866_w_() {
        if (background == null) {
            File file;
            File file2 = file = new File(DarkMeow.INSTANCE.getFileManager().getDir(), "wallpaper.png");
            boolean bl2 = false;
            if (!file2.exists()) {
                FileUtils.INSTANCE.unpackResourceFileWebpToPng("assets/minecraft/darkmeow/wallpaper.webp", file2);
            }
            ResourceLocation resourceLocation = ResourceLocationUtils.toResourceLocation$default(ResourceLocationUtils.INSTANCE, file2, null, 1, null);
            if (resourceLocation == null) {
                return;
            }
            background = resourceLocation;
        }
        this.slideX = 0.0f;
        this.fade = 0.0f;
        this.sliderX = 0.0f;
        this.sliderDarkX = 0.0f;
        super.func_73866_w_();
    }

    public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
        if (!this.alrUpdate) {
            this.lastAnimTick = System.currentTimeMillis();
            this.alrUpdate = true;
        }
        String creditInfo = "";
        int h2 = this.field_146295_m;
        int w2 = this.field_146294_l;
        ScaledResolution res = new ScaledResolution(MinecraftInstance.mc_nowarp);
        float xDiff = ((float)(mouseX - h2 / 2) - this.currentX) / (float)res.func_78325_e();
        float yDiff = ((float)(mouseY - w2 / 2) - this.currentY) / (float)res.func_78325_e();
        this.currentX += xDiff * 0.3f;
        this.currentY += yDiff * 0.3f;
        GlStateManager.func_179109_b((float)(this.currentX / 30.0f), (float)(this.currentY / 15.0f), (float)0.0f);
        ResourceLocation resourceLocation = background;
        if (resourceLocation != null) {
            ResourceLocation resourceLocation2;
            ResourceLocation it = resourceLocation2 = resourceLocation;
            boolean bl2 = false;
            RenderUtils.drawImage(it, -30, -30, res.func_78326_a() + 60, res.func_78328_b() + 60);
        }
        GlStateManager.func_179109_b((float)(-this.currentX / 30.0f), (float)(-this.currentY / 15.0f), (float)0.0f);
        GL11.glPushMatrix();
        this.renderSwitchButton();
        this.renderDarkModeButton();
        this.font.func_175063_a(' ' + DarkMeow.INSTANCE.getCLIENT_NAME() + ' ' + DarkMeow.INSTANCE.getCLIENT_VERSION(), 2.0f, (float)h2 - 12.0f, -1);
        this.font.func_175063_a(creditInfo, (float)w2 - 3.0f - (float)this.font.func_78256_a(creditInfo), (float)h2 - 12.0f, -1);
        if (useParallax) {
            this.moveMouseEffect(mouseX, mouseY, 10.0f);
        }
        GlStateManager.func_179118_c();
        GlStateManager.func_179141_d();
        this.renderBar(mouseX, mouseY, partialTicks);
        GL11.glPopMatrix();
        super.func_73863_a(mouseX, mouseY, partialTicks);
        if (!mainMenuPrep) {
            float animProgress = RangesKt.coerceIn((float)(System.currentTimeMillis() - this.lastAnimTick) / 1500.0f, 0.0f, 1.0f);
            RenderUtils.drawRect(0.0f, 0.0f, (float)w2, (float)h2, new Color(0.0f, 0.0f, 0.0f, 1.0f - animProgress));
            if (animProgress >= 1.0f) {
                mainMenuPrep = true;
            }
        }
        if (darkMode) {
            RenderUtils.drawRect(0.0f, 0.0f, (float)w2, (float)h2, new Color(0.0f, 0.0f, 0.0f, 0.3f));
        }
    }

    protected void func_73864_a(int mouseX, int mouseY, int mouseButton) {
        if (!mainMenuPrep || mouseButton != 0) {
            return;
        }
        if (this.isMouseHover(2.0f, (float)this.field_146295_m - 26.0f, 28.0f, (float)this.field_146295_m - 16.0f, mouseX, mouseY)) {
            boolean bl2 = useParallax = !useParallax;
        }
        if (this.isMouseHover(2.0f, (float)this.field_146295_m - 38.0f, 28.0f, (float)this.field_146295_m - 28.0f, mouseX, mouseY)) {
            darkMode = !darkMode;
        }
        float staticX = (float)this.field_146294_l / 2.0f - 120.0f;
        float staticY = (float)this.field_146295_m / 2.0f + 20.0f;
        Collection $this$toTypedArray$iv = ImageButton.getEntries();
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        ImageButton[] imageButtonArray = thisCollection$iv.toArray(new ImageButton[0]);
        int n2 = imageButtonArray.length;
        block8: for (int i2 = 0; i2 < n2; ++i2) {
            int index = i2;
            ImageButton icon = imageButtonArray[i2];
            if (!this.isMouseHover(staticX + 40.0f * (float)index, staticY, staticX + 40.0f * (float)(index + 1), staticY + 20.0f, mouseX, mouseY)) continue;
            switch (index) {
                case 0: {
                    this.field_146297_k.func_147108_a((GuiScreen)new GuiWorldSelection((GuiScreen)this));
                    continue block8;
                }
                case 1: {
                    this.field_146297_k.func_147108_a((GuiScreen)new GuiMultiplayer((GuiScreen)this));
                    continue block8;
                }
                case 2: {
                    this.field_146297_k.func_147108_a((GuiScreen)new GuiAltManager(this));
                    continue block8;
                }
                case 3: {
                    this.field_146297_k.func_147108_a((GuiScreen)new GuiOptions((GuiScreen)this, this.field_146297_k.field_71474_y));
                    continue block8;
                }
                case 4: {
                    this.field_146297_k.func_147108_a((GuiScreen)new GuiModList((GuiScreen)this));
                    continue block8;
                }
                case 5: {
                    this.field_146297_k.func_71400_g();
                }
            }
        }
        super.func_73864_a(mouseX, mouseY, mouseButton);
    }

    public final void moveMouseEffect(int mouseX, int mouseY, float strength) {
        int mX = mouseX - this.field_146294_l / 2;
        int mY = mouseY - this.field_146295_m / 2;
        float xDelta = (float)mX / (float)(this.field_146294_l / 2);
        float yDelta = (float)mY / (float)(this.field_146295_m / 2);
        GL11.glTranslatef((float)(xDelta * strength), (float)(yDelta * strength), (float)0.0f);
    }

    public final void renderSwitchButton() {
        this.sliderX = RangesKt.coerceIn(this.sliderX + (useParallax ? 2.0f : -2.0f), 0.0f, 12.0f);
        this.font.func_175065_a("Parallax", 28.0f, (float)((double)((float)this.field_146295_m - 25.0f)), -1, true);
        RenderUtils.drawRoundedRect(4.0f, (float)this.field_146295_m - 24.0f, 22.0f, (float)this.field_146295_m - 18.0f, 3, useParallax ? new Color(0, 111, 255, 255).getRGB() : (darkMode ? new Color(70, 70, 70, 255) : new Color(140, 140, 140, 255)).getRGB());
        RenderUtils.drawRoundedRect(2.0f + this.sliderX, (float)this.field_146295_m - 26.0f, 12.0f + this.sliderX, (float)this.field_146295_m - 16.0f, 5, Color.white.getRGB());
    }

    public final void renderDarkModeButton() {
        this.sliderDarkX = RangesKt.coerceIn(this.sliderDarkX + (darkMode ? 2.0f : -2.0f), 0.0f, 12.0f);
        GlStateManager.func_179118_c();
        this.font.func_175065_a("Dark Mode", 28.0f, (float)this.field_146295_m - 38.0f, -1, true);
        GlStateManager.func_179141_d();
        RenderUtils.drawRoundedRect(4.0f, (float)this.field_146295_m - 36.0f, 22.0f, (float)this.field_146295_m - 30.0f, 3, (darkMode ? new Color(70, 70, 70, 255) : new Color(140, 140, 140, 255)).getRGB());
        RenderUtils.drawRoundedRect(2.0f + this.sliderDarkX, (float)this.field_146295_m - 38.0f, 12.0f + this.sliderDarkX, (float)this.field_146295_m - 28.0f, 5, Color.white.getRGB());
    }

    public final void renderBar(int mouseX, int mouseY, float partialTicks) {
        float staticX = (float)this.field_146294_l / 2.0f - 120.0f;
        float staticY = (float)this.field_146295_m / 2.0f + 20.0f;
        RenderUtils.drawRoundedRect(staticX, staticY, staticX + 240.0f, staticY + 20.0f, 10, (darkMode ? new Color(0, 0, 0, 100) : new Color(255, 255, 255, 100)).getRGB());
        int index = 0;
        boolean shouldAnimate = false;
        String displayString = null;
        float moveX = 0.0f;
        for (ImageButton icon : ImageButton.getEntries()) {
            if (this.isMouseHover(staticX + 40.0f * (float)index, staticY, staticX + 40.0f * (float)(index + 1), staticY + 20.0f, mouseX, mouseY)) {
                shouldAnimate = true;
                displayString = icon.getButtonName();
                moveX = staticX + 40.0f * (float)index;
            }
            ++index;
        }
        int n2 = displayString != null ? RendererExtensionKt.drawCenteredString(this.font, displayString, (float)this.field_146294_l / 2.0f, staticY + 30.0f, -1) : RendererExtensionKt.drawCenteredString(this.font, "\u7231\u6765\u81ea " + ClientInfoUtils.INSTANCE.getName(), (float)this.field_146294_l / 2.0f, staticY + 30.0f, -1);
        if (shouldAnimate) {
            this.slideX = this.fade == 0.0f ? moveX : AnimationUtils.animate(moveX, this.slideX, 0.5f * (1.0f - partialTicks));
            this.lastXPos = moveX;
            this.fade += 10.0f;
            if (this.fade >= 100.0f) {
                this.fade = 100.0f;
            }
        } else {
            this.fade -= 10.0f;
            if (this.fade <= 0.0f) {
                this.fade = 0.0f;
            }
            this.slideX = AnimationUtils.animate(this.lastXPos, this.slideX, 0.5f * (1.0f - partialTicks));
        }
        if (!(this.fade == 0.0f)) {
            RenderUtils.drawRoundedRect(this.slideX, staticY, this.slideX + 40.0f, staticY + 20.0f, 10, (darkMode ? new Color(0.0f, 0.0f, 0.0f, this.fade / 100.0f * 0.6f) : new Color(1.0f, 1.0f, 1.0f, this.fade / 100.0f * 0.6f)).getRGB());
        }
        index = 0;
        GlStateManager.func_179118_c();
        for (ImageButton i2 : ImageButton.getEntries()) {
            if (darkMode) {
                RenderUtils.drawImage(i2.getTexture(), (int)(staticX + 40.0f * (float)index + 11.0f), (int)(staticY + 1.0f), 18, 18);
            } else {
                RenderUtils.drawImage(i2.getTexture(), staticX + 40.0f * (float)index + 11.0f, staticY + 1.0f, 18, 18, 0.0f, 0.0f, 0.0f, 1.0f);
            }
            ++index;
        }
        GlStateManager.func_179141_d();
    }

    public final boolean isMouseHover(float x2, float y2, float x22, float y22, int mouseX, int mouseY) {
        return (float)mouseX >= x2 && (float)mouseX < x22 && (float)mouseY >= y2 && (float)mouseY < y22;
    }

    protected void func_73869_a(char typedChar, int keyCode) {
    }

    static {
        useParallax = true;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/GuiMainMenu$Companion;", "", "<init>", "()V", "mainMenuPrep", "", "getMainMenuPrep", "()Z", "setMainMenuPrep", "(Z)V", "darkMode", "getDarkMode", "setDarkMode", "useParallax", "getUseParallax", "setUseParallax", "background", "Lnet/minecraft/util/ResourceLocation;", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        public final boolean getMainMenuPrep() {
            return mainMenuPrep;
        }

        public final void setMainMenuPrep(boolean bl2) {
            mainMenuPrep = bl2;
        }

        public final boolean getDarkMode() {
            return darkMode;
        }

        public final void setDarkMode(boolean bl2) {
            darkMode = bl2;
        }

        public final boolean getUseParallax() {
            return useParallax;
        }

        public final void setUseParallax(boolean bl2) {
            useParallax = bl2;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011\u00a8\u0006\u0012"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/GuiMainMenu$ImageButton;", "", "buttonName", "", "texture", "Lnet/minecraft/util/ResourceLocation;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lnet/minecraft/util/ResourceLocation;)V", "getButtonName", "()Ljava/lang/String;", "getTexture", "()Lnet/minecraft/util/ResourceLocation;", "Single", "Multi", "Alts", "Settings", "Mods", "Exit", "DarkMeow"})
    public static final class ImageButton
    extends Enum<ImageButton> {
        @NotNull
        private final String buttonName;
        @NotNull
        private final ResourceLocation texture;
        public static final /* enum */ ImageButton Single = new ImageButton("Singleplayer", new ResourceLocation("darknya/menu/singleplayer.png"));
        public static final /* enum */ ImageButton Multi = new ImageButton("Multiplayer", new ResourceLocation("darknya/menu/multiplayer.png"));
        public static final /* enum */ ImageButton Alts = new ImageButton("Alts", new ResourceLocation("darknya/menu/alt.png"));
        public static final /* enum */ ImageButton Settings = new ImageButton("Settings", new ResourceLocation("darknya/menu/settings.png"));
        public static final /* enum */ ImageButton Mods = new ImageButton("Mods", new ResourceLocation("darknya/menu/mods.png"));
        public static final /* enum */ ImageButton Exit = new ImageButton("Exit", new ResourceLocation("darknya/menu/exit.png"));
        private static final /* synthetic */ ImageButton[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        private ImageButton(String buttonName, ResourceLocation texture) {
            this.buttonName = buttonName;
            this.texture = texture;
        }

        @NotNull
        public final String getButtonName() {
            return this.buttonName;
        }

        @NotNull
        public final ResourceLocation getTexture() {
            return this.texture;
        }

        public static ImageButton[] values() {
            return (ImageButton[])$VALUES.clone();
        }

        public static ImageButton valueOf(String value) {
            return Enum.valueOf(ImageButton.class, value);
        }

        @NotNull
        public static EnumEntries<ImageButton> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = imageButtonArray = new ImageButton[]{ImageButton.Single, ImageButton.Multi, ImageButton.Alts, ImageButton.Settings, ImageButton.Mods, ImageButton.Exit};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

