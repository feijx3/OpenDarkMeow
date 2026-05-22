/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.renderer.GlStateManager
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.lwjgl.input.Keyboard
 */
package net.darkmeow.darkmeow.ui;

import it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.darkmeow.darkmeow.ui.component.AbstractComponent;
import net.darkmeow.darkmeow.ui.component.ComponentUtils;
import net.darkmeow.darkmeow.ui.component.base.IDarkGuiBase;
import net.darkmeow.darkmeow.ui.component.event.ComponentKeyTypedEvent;
import net.darkmeow.darkmeow.ui.component.event.ComponentMouseClickMoveEvent;
import net.darkmeow.darkmeow.ui.component.event.ComponentMouseClickedEvent;
import net.darkmeow.darkmeow.ui.component.event.ComponentMouseReleaseEvent;
import net.darkmeow.darkmeow.ui.theme.Theme;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.input.Keyboard;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\b\u0010 \u001a\u00020\u0014H\u0016J\b\u0010!\u001a\u00020\u0014H\u0016J\b\u0010\"\u001a\u00020\u0014H\u0016J \u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'H\u0016J\u0018\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0019H\u0014J\u0006\u0010,\u001a\u00020\u0014J \u0010-\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u0019H\u0014J(\u0010/\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u000202H\u0014J \u00103\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00192\u0006\u00104\u001a\u00020\u0019H\u0014J\b\u00105\u001a\u00020\u0014H\u0016J\b\u00106\u001a\u000207H\u0016R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R(\u0010\u001b\u001a\u0004\u0018\u00010\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010@VX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u00068"}, d2={"Lnet/darkmeow/darkmeow/ui/AbstractDarkGui;", "Lnet/minecraft/client/gui/GuiScreen;", "Lnet/darkmeow/darkmeow/ui/component/base/IDarkGuiBase;", "prevGui", "theme", "Lnet/darkmeow/darkmeow/ui/theme/Theme;", "<init>", "(Lnet/minecraft/client/gui/GuiScreen;Lnet/darkmeow/darkmeow/ui/theme/Theme;)V", "getPrevGui", "()Lnet/minecraft/client/gui/GuiScreen;", "getTheme", "()Lnet/darkmeow/darkmeow/ui/theme/Theme;", "setTheme", "(Lnet/darkmeow/darkmeow/ui/theme/Theme;)V", "components", "Lit/unimi/dsi/fastutil/objects/ObjectLinkedOpenHashSet;", "Lnet/darkmeow/darkmeow/ui/component/AbstractComponent;", "getComponents", "()Lit/unimi/dsi/fastutil/objects/ObjectLinkedOpenHashSet;", "addComponent", "", "component", "removeComponent", "getRealPositionOffset", "Lkotlin/Pair;", "", "value", "focus", "getFocus", "()Lnet/darkmeow/darkmeow/ui/component/AbstractComponent;", "setFocus", "(Lnet/darkmeow/darkmeow/ui/component/AbstractComponent;)V", "initGui", "init", "onGuiClosed", "drawScreen", "mouseX", "mouseY", "partialTicks", "", "keyTyped", "typedChar", "", "keyCode", "closeGui", "mouseClicked", "mouseButton", "mouseClickMove", "clickedMouseButton", "timeSinceLastClick", "", "mouseReleased", "state", "handleInput", "doesGuiPauseGame", "", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nAbstractDarkGui.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractDarkGui.kt\nnet/darkmeow/darkmeow/ui/AbstractDarkGui\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,173:1\n1869#2,2:174\n528#2,7:176\n1869#2,2:183\n295#2,2:185\n*S KotlinDebug\n*F\n+ 1 AbstractDarkGui.kt\nnet/darkmeow/darkmeow/ui/AbstractDarkGui\n*L\n65#1:174,2\n110#1:176,7\n158#1:183,2\n97#1:185,2\n*E\n"})
public abstract class AbstractDarkGui
extends GuiScreen
implements IDarkGuiBase {
    @Nullable
    private final GuiScreen prevGui;
    @NotNull
    private Theme theme;
    @NotNull
    private final ObjectLinkedOpenHashSet<AbstractComponent> components;
    @Nullable
    private AbstractComponent focus;

    public AbstractDarkGui(@Nullable GuiScreen prevGui, @NotNull Theme theme) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        this.prevGui = prevGui;
        this.theme = theme;
        this.components = new ObjectLinkedOpenHashSet();
    }

    @Nullable
    public final GuiScreen getPrevGui() {
        return this.prevGui;
    }

    @Override
    @NotNull
    public Theme getTheme() {
        return this.theme;
    }

    public void setTheme(@NotNull Theme theme) {
        Intrinsics.checkNotNullParameter(theme, "<set-?>");
        this.theme = theme;
    }

    @Override
    @NotNull
    public ObjectLinkedOpenHashSet<AbstractComponent> getComponents() {
        return this.components;
    }

    @Override
    public void addComponent(@NotNull AbstractComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        component.setBase(this);
        component.onInit();
        ((Collection)this.getComponents()).add(component);
    }

    @Override
    public void removeComponent(@NotNull AbstractComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        ((Collection)this.getComponents()).remove(component);
    }

    @Override
    @NotNull
    public Pair<Integer, Integer> getRealPositionOffset() {
        return new Pair<Integer, Integer>(0, 0);
    }

    @Override
    @Nullable
    public AbstractComponent getFocus() {
        return this.focus;
    }

    @Override
    public void setFocus(@Nullable AbstractComponent value) {
        block1: {
            AbstractComponent abstractComponent = this.focus;
            if (abstractComponent != null) {
                abstractComponent.onUnfocus();
            }
            AbstractComponent abstractComponent2 = this.focus = value;
            if (abstractComponent2 == null) break block1;
            abstractComponent2.onFocus();
        }
    }

    public void func_73866_w_() {
        Keyboard.enableRepeatEvents((boolean)true);
        this.init();
    }

    public void init() {
    }

    public void func_146281_b() {
        Keyboard.enableRepeatEvents((boolean)false);
    }

    /*
     * Unable to fully structure code
     */
    public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
        v0 = this.prevGui;
        if (v0 != null) {
            v0.func_73863_a(mouseX, mouseY, partialTicks);
        }
        $this$forEach$iv = (Iterable)this.getComponents();
        $i$f$forEach = false;
        for (T element$iv : $this$forEach$iv) {
            component = (AbstractComponent)element$iv;
            $i$a$-forEach-AbstractDarkGui$drawScreen$1 = false;
            GlStateManager.func_179094_E();
            GlStateManager.func_179109_b((float)((float)component.getPrevPosX() + (float)(component.getPosX() - component.getPrevPosX()) * partialTicks), (float)((float)component.getPrevPosY() + (float)(component.getPosY() - component.getPrevPosY()) * partialTicks), (float)0.0f);
            if (component == this.getFocus()) ** GOTO lbl-1000
            Intrinsics.checkNotNull(component);
            if (ComponentUtils.INSTANCE.isMouseInFocusedAndNotOccluded(component, mouseX, mouseY)) lbl-1000:
            // 2 sources

            {
                v1 = true;
            } else {
                v1 = false;
            }
            component.drawComponent(mouseX, mouseY, v1, partialTicks);
            GlStateManager.func_179121_F();
        }
    }

    protected void func_73869_a(char typedChar, int keyCode) {
        ComponentKeyTypedEvent event = new ComponentKeyTypedEvent(typedChar, keyCode);
        AbstractComponent abstractComponent = this.getFocus();
        if (abstractComponent != null) {
            abstractComponent.onKeyTyped(event);
        }
        if (event.isCancelledNext()) {
            return;
        }
        switch (event.getCode()) {
            case 1: {
                this.closeGui();
                break;
            }
            case 200: 
            case 203: 
            case 205: 
            case 208: {
                this.setFocus(ComponentUtils.INSTANCE.getNextComponentKeyboard(this.getComponents(), this.getFocus(), event.getCode(), false, AbstractDarkGui::keyTyped$lambda$2));
            }
        }
    }

    public final void closeGui() {
        this.field_146297_k.field_71462_r = this.prevGui;
        if (this.field_146297_k.field_71462_r == null) {
            this.field_146297_k.func_71381_h();
        }
    }

    /*
     * Unable to fully structure code
     */
    protected void func_73864_a(int mouseX, int mouseY, int mouseButton) {
        block4: {
            var5_4 = (Iterable)this.getComponents();
            $i$f$lastOrNull = false;
            last$iv = null;
            for (T element$iv : $this$lastOrNull$iv) {
                component = (AbstractComponent)element$iv;
                $i$a$-lastOrNull-AbstractDarkGui$mouseClicked$1 = false;
                if (!component.getAllowFocus()) ** GOTO lbl-1000
                var12_13 = component.getPosX();
                v0 = mouseX <= component.getPosX() + component.getWidth() ? var12_13 <= mouseX : false;
                if (!v0) ** GOTO lbl-1000
                var12_13 = component.getPosY();
                v1 = mouseY <= component.getPosY() + component.getHeight() ? var12_13 <= mouseY : false;
                if (v1) {
                    v2 = true;
                } else lbl-1000:
                // 3 sources

                {
                    v2 = false;
                }
                if (!v2) continue;
                last$iv = element$iv;
            }
            var4_14 = last$iv;
            if (var4_14 == null) break block4;
            component = var5_4 = var4_14;
            $i$a$-also-AbstractDarkGui$mouseClicked$2 = false;
            if (mouseButton != 2) {
                this.setFocus((AbstractComponent)component);
            }
            component.onMouseClick(new ComponentMouseClickedEvent(mouseX, mouseY, mouseButton, (AbstractComponent)component));
        }
    }

    protected void func_146273_a(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick) {
        block0: {
            AbstractComponent abstractComponent;
            AbstractComponent abstractComponent2 = this.getFocus();
            if (abstractComponent2 == null) break block0;
            AbstractComponent component = abstractComponent = abstractComponent2;
            boolean bl2 = false;
            component.onMouseClickMove(new ComponentMouseClickMoveEvent(mouseX, mouseY, clickedMouseButton, timeSinceLastClick, component));
        }
    }

    protected void func_146286_b(int mouseX, int mouseY, int state) {
        block0: {
            AbstractComponent abstractComponent;
            AbstractComponent abstractComponent2 = this.getFocus();
            if (abstractComponent2 == null) break block0;
            AbstractComponent component = abstractComponent = abstractComponent2;
            boolean bl2 = false;
            component.onMouseRelease(new ComponentMouseReleaseEvent(mouseX, mouseY, state, component));
        }
    }

    public void func_146269_k() {
        Iterable $this$forEach$iv = (Iterable)this.getComponents();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            AbstractComponent component = (AbstractComponent)element$iv;
            boolean bl2 = false;
            component.setPrevPosX(component.getPosX());
            component.setPrevPosY(component.getPosY());
            component.onUpdate();
        }
        super.func_146269_k();
    }

    public boolean func_73868_f() {
        return false;
    }

    private static final AbstractComponent keyTyped$lambda$2(ObjectLinkedOpenHashSet $this$getNextComponentKeyboard) {
        Object v0;
        block1: {
            Intrinsics.checkNotNullParameter($this$getNextComponentKeyboard, "$this$getNextComponentKeyboard");
            Iterable $this$firstOrNull$iv = (Iterable)$this$getNextComponentKeyboard;
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                AbstractComponent it = (AbstractComponent)element$iv;
                boolean bl2 = false;
                if (!it.getAllowFocus()) continue;
                v0 = element$iv;
                break block1;
            }
            v0 = null;
        }
        return v0;
    }
}

