/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.GuiScreen
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.lwjgl.input.Keyboard
 */
package net.ccbluex.liquidbounce.features.manager;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.features.module.modules.client.ClickGUI;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.ui.client.clickgui.ClickGui;
import net.ccbluex.liquidbounce.ui.client.clickgui.style.Style;
import net.ccbluex.liquidbounce.ui.font.Fonts;
import net.ccbluex.liquidbounce.ui.font.GameFontRenderer;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.impl.FontValue;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.input.Keyboard;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020$J\u0006\u0010&\u001a\u00020$J\u0010\u0010&\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010\u0018J\u000e\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020,J\u0006\u00103\u001a\u000204R-\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010.\u001a\u00020*2\u0006\u0010-\u001a\u00020*8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u00102\u00a8\u00065"}, d2={"Lnet/ccbluex/liquidbounce/features/manager/ClickGuiManager;", "", "<init>", "()V", "styles", "Ljava/util/LinkedHashMap;", "", "Lnet/ccbluex/liquidbounce/ui/client/clickgui/style/Style;", "Lkotlin/collections/LinkedHashMap;", "getStyles", "()Ljava/util/LinkedHashMap;", "cui", "Lnet/ccbluex/liquidbounce/ui/client/clickgui/ClickGui;", "getCui", "()Lnet/ccbluex/liquidbounce/ui/client/clickgui/ClickGui;", "setCui", "(Lnet/ccbluex/liquidbounce/ui/client/clickgui/ClickGui;)V", "config", "Lnet/ccbluex/liquidbounce/features/module/modules/client/ClickGUI;", "getConfig", "()Lnet/ccbluex/liquidbounce/features/module/modules/client/ClickGUI;", "setConfig", "(Lnet/ccbluex/liquidbounce/features/module/modules/client/ClickGUI;)V", "lastGui", "Lnet/minecraft/client/gui/GuiScreen;", "getLastGui", "()Lnet/minecraft/client/gui/GuiScreen;", "setLastGui", "(Lnet/minecraft/client/gui/GuiScreen;)V", "cacheFont", "Lnet/ccbluex/liquidbounce/ui/font/GameFontRenderer;", "getCacheFont", "()Lnet/ccbluex/liquidbounce/ui/font/GameFontRenderer;", "setCacheFont", "(Lnet/ccbluex/liquidbounce/ui/font/GameFontRenderer;)V", "setup", "", "load", "display", "gui", "onGuiKeyTyped", "keyCode", "", "getClickGuiFont", "Lnet/minecraft/client/gui/FontRenderer;", "value", "keyBind", "getKeyBind", "()I", "setKeyBind", "(I)V", "isKeyBindPressed", "", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nClickGuiManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClickGuiManager.kt\nnet/ccbluex/liquidbounce/features/manager/ClickGuiManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,73:1\n1#2:74\n1#2:81\n1563#3:75\n1634#3,3:76\n1056#3:79\n2756#3:80\n*S KotlinDebug\n*F\n+ 1 ClickGuiManager.kt\nnet/ccbluex/liquidbounce/features/manager/ClickGuiManager\n*L\n35#1:81\n33#1:75\n33#1:76,3\n34#1:79\n35#1:80\n*E\n"})
public final class ClickGuiManager {
    @NotNull
    private final LinkedHashMap<String, Style> styles = new LinkedHashMap();
    public ClickGui cui;
    public ClickGUI config;
    @Nullable
    private GuiScreen lastGui;
    @Nullable
    private GameFontRenderer cacheFont;

    @NotNull
    public final LinkedHashMap<String, Style> getStyles() {
        return this.styles;
    }

    @NotNull
    public final ClickGui getCui() {
        ClickGui clickGui = this.cui;
        if (clickGui != null) {
            return clickGui;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cui");
        return null;
    }

    public final void setCui(@NotNull ClickGui clickGui) {
        Intrinsics.checkNotNullParameter((Object)clickGui, "<set-?>");
        this.cui = clickGui;
    }

    @NotNull
    public final ClickGUI getConfig() {
        ClickGUI clickGUI = this.config;
        if (clickGUI != null) {
            return clickGUI;
        }
        Intrinsics.throwUninitializedPropertyAccessException("config");
        return null;
    }

    public final void setConfig(@NotNull ClickGUI clickGUI) {
        Intrinsics.checkNotNullParameter(clickGUI, "<set-?>");
        this.config = clickGUI;
    }

    @Nullable
    public final GuiScreen getLastGui() {
        return this.lastGui;
    }

    public final void setLastGui(@Nullable GuiScreen guiScreen) {
        this.lastGui = guiScreen;
    }

    @Nullable
    public final GameFontRenderer getCacheFont() {
        return this.cacheFont;
    }

    public final void setCacheFont(@Nullable GameFontRenderer gameFontRenderer) {
        this.cacheFont = gameFontRenderer;
    }

    /*
     * WARNING - void declaration
     */
    public final void setup() {
        List<Class<Style>> list;
        List<Class<Style>> list2;
        List<Class<Style>> it = list2 = ClassUtils.INSTANCE.resolvePackage(ClassUtils.INSTANCE.getPackageName() + ".ui.client.clickgui.style.impl", Style.class);
        boolean bl2 = false;
        List<Class<Style>> list3 = list = !((Collection)it).isEmpty() ? list2 : null;
        if (list != null) {
            Iterable $this$sortedBy$iv;
            void $this$mapTo$iv$iv;
            Iterable $this$map$iv = list;
            boolean $i$f$map22 = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it2;
                Class clazz = (Class)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl3 = false;
                Object[] objectArray = new Class[]{ClickGuiManager.class};
                Constructor constructor = it2.getDeclaredConstructor((Class<?>[])objectArray);
                objectArray = new Object[]{this};
                Object t2 = constructor.newInstance(objectArray);
                Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type net.ccbluex.liquidbounce.ui.client.clickgui.style.Style");
                collection.add((Style)t2);
            }
            Iterable $i$f$map22 = (List)destination$iv$iv;
            boolean $i$f$sortedBy = false;
            List list4 = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    Style it = (Style)a2;
                    boolean bl2 = false;
                    Comparable comparable = (Comparable)((Object)it.getName());
                    it = (Style)b2;
                    Comparable comparable2 = comparable;
                    bl2 = false;
                    return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getName()));
                }
            });
            if (list4 != null) {
                void $this$onEach$iv;
                void var6_8;
                $this$sortedBy$iv = list4;
                boolean $i$f$onEach = false;
                void $this$onEach_u24lambda_u2418$iv = var6_8 = $this$onEach$iv;
                boolean bl4 = false;
                for (Object element$iv : $this$onEach_u24lambda_u2418$iv) {
                    Style it3 = (Style)element$iv;
                    boolean bl5 = false;
                    ((Map)this.styles).put(it3.getName(), it3);
                }
                List cfr_ignored_0 = (List)var6_8;
            }
        }
        this.setCui(new ClickGui(this));
    }

    public final void load() {
        this.setup();
        this.getCui().setup();
    }

    public final void display() {
        MinecraftInstance.mc.displayGuiScreen(this.getCui());
    }

    public final void display(@Nullable GuiScreen gui) {
        this.lastGui = gui;
        this.display();
    }

    public final void onGuiKeyTyped(int keyCode) {
        try {
            if (this.getKeyBind() == keyCode) {
                this.display(MinecraftInstance.mc.getCurrentScreen());
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @NotNull
    public final FontRenderer getClickGuiFont() {
        block5: {
            block4: {
                Object object = this.cacheFont;
                if (object == null || (object = object.getName()) == null) {
                    object = "null";
                }
                if (!Intrinsics.areEqual(object, ((FontValue.FontInfo)this.getConfig().getFontValue().getValue()).getName())) break block4;
                GameFontRenderer gameFontRenderer = this.cacheFont;
                if (Intrinsics.areEqual(gameFontRenderer != null ? Integer.valueOf(gameFontRenderer.getSize()) : "null", (Object)((FontValue.FontInfo)this.getConfig().getFontValue().getValue()).getSize())) break block5;
            }
            this.cacheFont = FontValue.Companion.getFont((FontValue.FontInfo)this.getConfig().getFontValue().get());
        }
        GameFontRenderer gameFontRenderer = this.cacheFont;
        return gameFontRenderer != null ? (FontRenderer)gameFontRenderer : Fonts.minecraftFont;
    }

    public final int getKeyBind() {
        return this.getConfig().getKeyBind();
    }

    public final void setKeyBind(int value) {
        this.getConfig().setKeyBind(value);
    }

    public final boolean isKeyBindPressed() {
        return Keyboard.isKeyDown((int)this.getKeyBind());
    }
}

