/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.util.ChatAllowedCharacters
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.input.Keyboard
 */
package net.ccbluex.liquidbounce.ui.client.keybind;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.ui.client.keybind.KeyInfo;
import net.ccbluex.liquidbounce.ui.client.keybind.PopUI;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ChatAllowedCharacters;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.input.Keyboard;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0013H\u0016J\u0018\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015H\u0016J \u0010\u0014\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0015H\u0016J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0010H\u0002J\b\u0010$\u001a\u00020\u0019H\u0016J\b\u0010%\u001a\u00020\u0019H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R.\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fj\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u0010`\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/keybind/KeySelectUI;", "Lnet/ccbluex/liquidbounce/ui/client/keybind/PopUI;", "font", "Lnet/minecraft/client/gui/FontRenderer;", "info", "Lnet/ccbluex/liquidbounce/ui/client/keybind/KeyInfo;", "<init>", "(Lnet/minecraft/client/gui/FontRenderer;Lnet/ccbluex/liquidbounce/ui/client/keybind/KeyInfo;)V", "getFont", "()Lnet/minecraft/client/gui/FontRenderer;", "getInfo", "()Lnet/ccbluex/liquidbounce/ui/client/keybind/KeyInfo;", "str", "", "modules", "Ljava/util/LinkedHashMap;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "Lkotlin/collections/LinkedHashMap;", "singleHeight", "", "stroll", "", "maxStroll", "height", "render", "", "click", "mouseX", "mouseY", "key", "typedChar", "", "keyCode", "wheel", "apply", "module", "close", "update", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nKeySelectUI.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KeySelectUI.kt\nnet/ccbluex/liquidbounce/ui/client/keybind/KeySelectUI\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,107:1\n216#2,2:108\n216#2:110\n217#2:112\n1#3:111\n774#4:113\n865#4,2:114\n1236#4,4:116\n*S KotlinDebug\n*F\n+ 1 KeySelectUI.kt\nnet/ccbluex/liquidbounce/ui/client/keybind/KeySelectUI\n*L\n28#1:108,2\n49#1:110\n49#1:112\n99#1:113\n99#1:114,2\n100#1:116,4\n*E\n"})
public final class KeySelectUI
extends PopUI {
    @NotNull
    private final FontRenderer font;
    @NotNull
    private final KeyInfo info;
    @NotNull
    private String str;
    @NotNull
    private LinkedHashMap<String, Module> modules;
    private final float singleHeight;
    private int stroll;
    private float maxStroll;
    private final float height;

    public KeySelectUI(@NotNull FontRenderer font, @NotNull KeyInfo info) {
        Intrinsics.checkNotNullParameter(font, "font");
        Intrinsics.checkNotNullParameter(info, "info");
        super(font, "Select a module to bind");
        this.font = font;
        this.info = info;
        this.str = "";
        this.modules = new LinkedHashMap();
        this.singleHeight = 4.0f + (float)this.getFont().field_78288_b;
        this.maxStroll = (float)this.modules.size() * this.singleHeight;
        this.height = 8.0f + (float)this.getFont().field_78288_b;
        this.update();
        Keyboard.enableRepeatEvents((boolean)true);
    }

    @Override
    @NotNull
    public FontRenderer getFont() {
        return this.font;
    }

    @NotNull
    public final KeyInfo getInfo() {
        return this.info;
    }

    @Override
    public void render() {
        float yOffset = 0.0f;
        yOffset = this.height - (float)this.stroll;
        Map $this$forEach$iv = this.modules;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry element$iv;
            Map.Entry entry = element$iv = iterator2.next();
            boolean bl2 = false;
            String name = (String)entry.getKey();
            if (yOffset > this.height - this.singleHeight && yOffset - this.singleHeight < 190.0f) {
                GlStateManager.func_179094_E();
                GlStateManager.func_179109_b((float)0.0f, (float)yOffset, (float)0.0f);
                this.getFont().func_175065_a(name, 8.0f, this.singleHeight * 0.5f, Color.WHITE.getRGB(), false);
                GlStateManager.func_179121_F();
            }
            yOffset += this.singleHeight;
        }
    }

    @Override
    public void click(float mouseX, float mouseY) {
        if (mouseX < 8.0f || mouseX > (float)(this.getBaseWidth() - 8) || mouseY < this.height || mouseY > (float)this.getBaseHeight() - this.singleHeight) {
            return;
        }
        float yOffset = 0.0f;
        yOffset = this.height - (float)this.stroll;
        Map $this$forEach$iv = this.modules;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry element$iv;
            Map.Entry entry = element$iv = iterator2.next();
            boolean bl2 = false;
            Module module = (Module)entry.getValue();
            if (mouseY > yOffset && mouseY < yOffset + this.singleHeight) {
                Module module2 = module;
                if (module2 != null) {
                    Module module3;
                    Module it = module3 = module2;
                    boolean bl3 = false;
                    this.apply(it);
                }
                return;
            }
            yOffset += this.singleHeight;
        }
    }

    @Override
    public void key(char typedChar, int keyCode) {
        switch (keyCode) {
            case 14: {
                if (((CharSequence)this.str).length() > 0) {
                    String string = this.str.substring(0, this.str.length() - 1);
                    Intrinsics.checkNotNullExpressionValue(string, "substring(...)");
                    this.str = string;
                    this.update();
                }
                return;
            }
            case 28: {
                Set<Map.Entry<String, Module>> set = this.modules.entrySet();
                Intrinsics.checkNotNullExpressionValue(set, "<get-entries>(...)");
                Object object = (Map.Entry)CollectionsKt.firstOrNull((Iterable)set);
                if (object != null && (object = (Module)object.getValue()) != null) {
                    Object object2;
                    Object it = object2 = object;
                    boolean bl2 = false;
                    this.apply((Module)it);
                }
                return;
            }
        }
        if (ChatAllowedCharacters.func_71566_a((char)typedChar)) {
            this.str = this.str + typedChar;
            this.update();
        }
    }

    @Override
    public void stroll(float mouseX, float mouseY, int wheel) {
        int afterStroll = this.stroll - wheel / 10;
        if (afterStroll > 0 && (float)afterStroll < this.maxStroll - (float)100) {
            this.stroll = afterStroll;
        }
    }

    private final void apply(Module module) {
        module.setKeyBind(this.info.getKey());
        DarkMeow.INSTANCE.getKeyBindManager().updateAllKeys();
        this.close();
    }

    @Override
    public void close() {
        Keyboard.enableRepeatEvents((boolean)false);
        DarkMeow.INSTANCE.getKeyBindManager().setPopUI(null);
    }

    /*
     * WARNING - void declaration
     */
    private final void update() {
        void var2_4;
        void $this$associateByTo$iv;
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv;
        Iterable iterable = DarkMeow.INSTANCE.getModuleManager().getModules();
        KeySelectUI keySelectUI = this;
        boolean $i$f$filter22 = false;
        void var3_5 = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            Module it = (Module)element$iv$iv;
            boolean bl2 = false;
            if (!StringsKt.startsWith(it.getName(), this.str, true)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $this$filter$iv = (List)destination$iv$iv;
        Map $i$f$filter22 = new LinkedHashMap();
        boolean $i$f$associateByTo = false;
        for (Object element$iv : $this$associateByTo$iv) {
            void it;
            void destination$iv;
            Module module = (Module)element$iv;
            void var11_15 = destination$iv;
            boolean bl3 = false;
            var11_15.put("\u00a7b" + StringsKt.take(it.getName(), this.str.length()) + "\u00a7f" + StringsKt.drop(it.getName(), this.str.length()), element$iv);
        }
        keySelectUI.modules = (LinkedHashMap)var2_4;
        this.maxStroll = (float)this.modules.size() * this.singleHeight;
        this.stroll = 0;
    }
}

