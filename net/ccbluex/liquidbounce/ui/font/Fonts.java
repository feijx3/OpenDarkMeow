/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.util.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.ui.font;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.ui.font.GameFontRenderer;
import net.ccbluex.liquidbounce.utils.ClientUtils;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Deprecated(message="\u653e\u5f03\u7ef4\u62a4, \u53cd\u9988 = ban")
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0007R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0003\u00a8\u0006\u0010"}, d2={"Lnet/ccbluex/liquidbounce/ui/font/Fonts;", "Lnet/ccbluex/liquidbounce/injection/forge/MinecraftInstance;", "<init>", "()V", "minecraftFont", "Lnet/minecraft/client/gui/FontRenderer;", "getMinecraftFont$annotations", "fonts", "", "Lnet/ccbluex/liquidbounce/ui/font/GameFontRenderer;", "getFonts$annotations", "getFont", "name", "", "loadFonts", "", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nFonts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Fonts.kt\nnet/ccbluex/liquidbounce/ui/font/Fonts\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,101:1\n295#2,2:102\n*S KotlinDebug\n*F\n+ 1 Fonts.kt\nnet/ccbluex/liquidbounce/ui/font/Fonts\n*L\n24#1:102,2\n*E\n"})
public final class Fonts
extends MinecraftInstance {
    @NotNull
    public static final Fonts INSTANCE = new Fonts();
    @JvmField
    @NotNull
    public static final FontRenderer minecraftFont;
    @JvmField
    @NotNull
    public static final List<GameFontRenderer> fonts;

    private Fonts() {
    }

    @Deprecated(message="\u653e\u5f03\u7ef4\u62a4, \u53cd\u9988 = ban")
    public static /* synthetic */ void getMinecraftFont$annotations() {
    }

    @Deprecated(message="\u653e\u5f03\u7ef4\u62a4, \u53cd\u9988 = ban")
    public static /* synthetic */ void getFonts$annotations() {
    }

    @Deprecated(message="\u653e\u5f03\u7ef4\u62a4, \u53cd\u9988 = ban")
    @Nullable
    public final GameFontRenderer getFont(@NotNull String name) {
        Object v0;
        block1: {
            Intrinsics.checkNotNullParameter(name, "name");
            Iterable $this$firstOrNull$iv = fonts;
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                GameFontRenderer it = (GameFontRenderer)((Object)element$iv);
                boolean bl2 = false;
                if (!Intrinsics.areEqual(it.getName(), name)) continue;
                v0 = element$iv;
                break block1;
            }
            v0 = null;
        }
        return v0;
    }

    @Deprecated(message="\u653e\u5f03\u7ef4\u62a4, \u53cd\u9988 = ban")
    public final void loadFonts() {
        long l2 = System.currentTimeMillis();
        ClientUtils.INSTANCE.logInfo("[FontManager] Loading fonts.");
        fonts.clear();
        Fonts.loadFonts$loadStaticFonts();
        Fonts.loadFonts$loadSystemFonts();
        Fonts.loadFonts$loadConfigFonts();
        ClientUtils.INSTANCE.logInfo("[FontManager] Loaded fonts. (" + fonts.size() + " fonts, " + (System.currentTimeMillis() - l2) + "ms)");
    }

    private static final Font loadFonts$loadStaticFonts$getFontInJar(String fontName) throws Throwable {
        InputStream fontInputStream = MinecraftInstance.mc.getResourceManager().func_110536_a(new ResourceLocation("darkmeow/font/" + fontName + ".ttf")).func_110527_b();
        Font font = Font.createFont(0, fontInputStream);
        Intrinsics.checkNotNullExpressionValue(font, "createFont(...)");
        return font;
    }

    private static final void loadFonts$loadStaticFonts() {
        ClientUtils.INSTANCE.logDebug("[FontManager] Searching static fonts....");
        List<String> fontNames = CollectionsKt.listOf("sfuidisplayregular");
        for (String fontName : fontNames) {
            try {
                Font font = Fonts.loadFonts$loadStaticFonts$getFontInJar(fontName);
                String string = font.getName();
                Intrinsics.checkNotNullExpressionValue(string, "getName(...)");
                fonts.add(new GameFontRenderer(string, font));
                StringBuilder stringBuilder = new StringBuilder().append("[FontManager] Searched static font(");
                String string2 = font.getName();
                if (string2 == null) {
                    string2 = "null";
                }
                StringBuilder stringBuilder2 = stringBuilder.append(string2).append(',');
                String string3 = font.getFamily();
                if (string3 == null) {
                    string3 = "null";
                }
                ClientUtils.INSTANCE.logDebug(stringBuilder2.append(string3).append(')').toString());
            }
            catch (Throwable e2) {
                ClientUtils.INSTANCE.logError("[FontManager] Unable to search static font(name: " + fontName + ").", e2);
            }
        }
        ClientUtils.INSTANCE.logDebug("[FontManager] Search static fonts done!");
    }

    private static final boolean loadFonts$loadConfigFonts$lambda$3$lambda$1(File file) {
        Intrinsics.checkNotNull(file);
        return StringsKt.equals(FilesKt.getExtension(file), "ttf", true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static final void loadFonts$loadConfigFonts() {
        ClientUtils.INSTANCE.logDebug("[FontManager] Searching config fonts....");
        try {
            Fonts $this$loadFonts_u24loadConfigFonts_u24lambda_u243 = INSTANCE;
            boolean bl2 = false;
            File[] fileArray = DarkMeow.INSTANCE.getFileManager().getFontsDir().listFiles(Fonts::loadFonts$loadConfigFonts$lambda$3$lambda$1);
            if (fileArray != null) {
                for (File ttfFile : fileArray) {
                    try {
                        Closeable closeable = new FileInputStream(ttfFile);
                        Throwable throwable = null;
                        try {
                            FileInputStream fis = (FileInputStream)closeable;
                            boolean bl3 = false;
                            Font font = Font.createFont(0, fis);
                            String string = font.getName();
                            Intrinsics.checkNotNullExpressionValue(string, "getName(...)");
                            Intrinsics.checkNotNull(font);
                            fonts.add(new GameFontRenderer(string, font));
                            StringBuilder stringBuilder = new StringBuilder().append("[FontManager] Searched custom font(");
                            String string2 = font.getName();
                            if (string2 == null) {
                                string2 = "null";
                            }
                            StringBuilder stringBuilder2 = stringBuilder.append(string2).append(',');
                            String string3 = font.getFamily();
                            if (string3 == null) {
                                string3 = "null";
                            }
                            ClientUtils.INSTANCE.logDebug(stringBuilder2.append(string3).append(").").toString());
                            Unit unit = Unit.INSTANCE;
                        }
                        catch (Throwable throwable2) {
                            throwable = throwable2;
                            throw throwable2;
                        }
                        finally {
                            CloseableKt.closeFinally(closeable, throwable);
                        }
                    }
                    catch (Throwable e2) {
                        ClientUtils.INSTANCE.logError("[FontManager] Unable to search custom font(" + ttfFile.getName() + ").", e2);
                    }
                }
            }
            ClientUtils.INSTANCE.logDebug("[FontManager] Search config fonts done!");
        }
        catch (Throwable e3) {
            ClientUtils.INSTANCE.logError("[FontManager] Unable to search custom font.", e3);
        }
    }

    private static final void loadFonts$loadSystemFonts() {
        ClientUtils.INSTANCE.logDebug("[FontManager] Searching system fonts....");
        try {
            Font[] systemFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
            Iterator<Font> iterator2 = ArrayIteratorKt.iterator(systemFonts);
            while (iterator2.hasNext()) {
                Font font = iterator2.next();
                String string = font.getName();
                Intrinsics.checkNotNullExpressionValue(string, "getName(...)");
                Intrinsics.checkNotNull(font);
                fonts.add(new GameFontRenderer(string, font));
                StringBuilder stringBuilder = new StringBuilder().append("[FontManager] Searched system font(");
                String string2 = font.getName();
                if (string2 == null) {
                    string2 = "null";
                }
                StringBuilder stringBuilder2 = stringBuilder.append(string2).append(',');
                String string3 = font.getFamily();
                if (string3 == null) {
                    string3 = "null";
                }
                ClientUtils.INSTANCE.logDebug(stringBuilder2.append(string3).append(')').toString());
            }
            ClientUtils.INSTANCE.logDebug("[FontManager] Search system fonts done!");
        }
        catch (Throwable e2) {
            ClientUtils.INSTANCE.logError("[FontManager] Unable to search system font.", e2);
        }
    }

    static {
        FontRenderer fontRenderer = MinecraftInstance.mc_nowarp.field_71466_p;
        Intrinsics.checkNotNullExpressionValue(fontRenderer, "fontRenderer");
        minecraftFont = fontRenderer;
        fonts = new ArrayList();
    }
}

