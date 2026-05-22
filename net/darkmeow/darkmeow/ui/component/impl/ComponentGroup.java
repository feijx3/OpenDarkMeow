/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.renderer.GlStateManager
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.darkmeow.ui.component.impl;

import it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.darkmeow.darkmeow.ui.component.AbstractComponent;
import net.darkmeow.darkmeow.ui.component.ComponentUtils;
import net.darkmeow.darkmeow.ui.component.base.IDarkGuiBase;
import net.darkmeow.darkmeow.ui.component.event.ComponentKeyTypedEvent;
import net.darkmeow.darkmeow.ui.component.event.ComponentMouseClickMoveEvent;
import net.darkmeow.darkmeow.ui.component.event.ComponentMouseClickedEvent;
import net.darkmeow.darkmeow.ui.component.event.ComponentMouseReleaseEvent;
import net.darkmeow.darkmeow.ui.component.impl.ComponentDragMoveBase;
import net.darkmeow.darkmeow.ui.theme.Theme;
import net.minecraft.client.renderer.GlStateManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u0014\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040 H\u0016J(\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\u001cH\u0016J\b\u00101\u001a\u00020\u001cH\u0016R(\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r@VX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u0018X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u00062"}, d2={"Lnet/darkmeow/darkmeow/ui/component/impl/ComponentGroup;", "Lnet/darkmeow/darkmeow/ui/component/impl/ComponentDragMoveBase;", "Lnet/darkmeow/darkmeow/ui/component/base/IDarkGuiBase;", "posX", "", "posY", "width", "height", "disableDragMove", "", "<init>", "(IIIIZ)V", "value", "Lnet/darkmeow/darkmeow/ui/component/AbstractComponent;", "focus", "getFocus", "()Lnet/darkmeow/darkmeow/ui/component/AbstractComponent;", "setFocus", "(Lnet/darkmeow/darkmeow/ui/component/AbstractComponent;)V", "theme", "Lnet/darkmeow/darkmeow/ui/theme/Theme;", "getTheme", "()Lnet/darkmeow/darkmeow/ui/theme/Theme;", "components", "Lit/unimi/dsi/fastutil/objects/ObjectLinkedOpenHashSet;", "getComponents", "()Lit/unimi/dsi/fastutil/objects/ObjectLinkedOpenHashSet;", "addComponent", "", "component", "removeComponent", "getRealPositionOffset", "Lkotlin/Pair;", "drawComponent", "mouseX", "mouseY", "isFocused", "partialTicks", "", "onKeyTyped", "event", "Lnet/darkmeow/darkmeow/ui/component/event/ComponentKeyTypedEvent;", "onMouseClick", "Lnet/darkmeow/darkmeow/ui/component/event/ComponentMouseClickedEvent;", "onMouseClickMove", "Lnet/darkmeow/darkmeow/ui/component/event/ComponentMouseClickMoveEvent;", "onMouseRelease", "Lnet/darkmeow/darkmeow/ui/component/event/ComponentMouseReleaseEvent;", "onUpdate", "onFocus", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nComponentGroup.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ComponentGroup.kt\nnet/darkmeow/darkmeow/ui/component/impl/ComponentGroup\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,165:1\n1869#2,2:166\n528#2,7:168\n1869#2,2:175\n295#2,2:177\n*S KotlinDebug\n*F\n+ 1 ComponentGroup.kt\nnet/darkmeow/darkmeow/ui/component/impl/ComponentGroup\n*L\n68#1:166,2\n108#1:168,7\n159#1:175,2\n163#1:177,2\n*E\n"})
public final class ComponentGroup
extends ComponentDragMoveBase
implements IDarkGuiBase {
    @Nullable
    private AbstractComponent focus;
    @NotNull
    private final ObjectLinkedOpenHashSet<AbstractComponent> components;

    public ComponentGroup(int posX, int posY, int width, int height, boolean disableDragMove) {
        super(posX, posY, width, height, disableDragMove);
        this.components = new ObjectLinkedOpenHashSet();
    }

    public /* synthetic */ ComponentGroup(int n2, int n3, int n4, int n5, boolean bl2, int n6, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n6 & 0x10) != 0) {
            bl2 = false;
        }
        this(n2, n3, n4, n5, bl2);
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

    @Override
    @NotNull
    public Theme getTheme() {
        return this.getBase().getTheme();
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
        Pair<Integer, Integer> position = this.getBase().getRealPositionOffset();
        return new Pair<Integer, Integer>(((Number)position.getFirst()).intValue() + this.getPosX(), ((Number)position.getSecond()).intValue() + this.getPosY());
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void drawComponent(int mouseX, int mouseY, boolean isFocused, float partialTicks) {
        super.drawComponent(mouseX, mouseY, isFocused, partialTicks);
        offset = this.getRealPositionOffset();
        $this$forEach$iv = (Iterable)this.getComponents();
        $i$f$forEach = false;
        for (T element$iv : $this$forEach$iv) {
            component = (AbstractComponent)element$iv;
            $i$a$-forEach-ComponentGroup$drawComponent$1 = false;
            GlStateManager.func_179094_E();
            GlStateManager.func_179109_b((float)((float)component.getPrevPosX() + (float)(component.getPosX() - component.getPrevPosX()) * partialTicks), (float)((float)component.getPrevPosY() + (float)(component.getPosY() - component.getPrevPosY()) * partialTicks), (float)0.0f);
            if (component == this.getFocus()) ** GOTO lbl-1000
            Intrinsics.checkNotNull(component);
            if (ComponentUtils.INSTANCE.isMouseInFocusedAndNotOccluded(component, mouseX - ((Number)offset.getFirst()).intValue(), mouseY - ((Number)offset.getSecond()).intValue())) lbl-1000:
            // 2 sources

            {
                v0 = true;
            } else {
                v0 = false;
            }
            component.drawComponent(mouseX, mouseY, v0, partialTicks);
            GlStateManager.func_179121_F();
        }
    }

    @Override
    public void onKeyTyped(@NotNull ComponentKeyTypedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        AbstractComponent abstractComponent = this.getFocus();
        if (abstractComponent != null) {
            abstractComponent.onKeyTyped(event);
        }
        if (event.isCancelledNext()) {
            return;
        }
        switch (event.getCode()) {
            case 200: 
            case 203: 
            case 205: 
            case 208: {
                AbstractComponent abstractComponent2;
                ComponentGroup componentGroup = this;
                AbstractComponent abstractComponent3 = ComponentUtils.getNextComponentKeyboard$default(ComponentUtils.INSTANCE, this.getComponents(), this.getFocus(), event.getCode(), true, null, 8, null);
                if (abstractComponent3 != null) {
                    AbstractComponent abstractComponent4;
                    AbstractComponent abstractComponent5 = abstractComponent4 = abstractComponent3;
                    ComponentGroup componentGroup2 = componentGroup;
                    boolean bl2 = false;
                    event.cancelNext();
                    componentGroup = componentGroup2;
                    abstractComponent2 = abstractComponent4;
                } else {
                    abstractComponent2 = null;
                }
                componentGroup.setFocus(abstractComponent2);
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void onMouseClick(@NotNull ComponentMouseClickedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        $this$lastOrNull$iv = (Iterable)this.getComponents();
        $i$f$lastOrNull = false;
        last$iv = null;
        for (T element$iv : $this$lastOrNull$iv) {
            component = (AbstractComponent)element$iv;
            $i$a$-lastOrNull-ComponentGroup$onMouseClick$1 = false;
            if (!component.getAllowFocus()) ** GOTO lbl-1000
            var10_12 = component.getPosX();
            var11_13 = component.getPosX() + component.getWidth();
            var12_14 = event.getClickX();
            v0 = var10_12 <= var12_14 ? var12_14 <= var11_13 : false;
            if (!v0) ** GOTO lbl-1000
            var10_12 = component.getPosY();
            var11_13 = component.getPosY() + component.getHeight();
            var12_14 = event.getClickY();
            v1 = var10_12 <= var12_14 ? var12_14 <= var11_13 : false;
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
        var2_15 = last$iv;
        if (var2_15 != null) {
            component = var4_4 = var2_15;
            $i$a$-also-ComponentGroup$onMouseClick$2 = false;
            if (event.getButton() != 2) {
                this.setFocus(component);
            }
            component.onMouseClick(new ComponentMouseClickedEvent(event, component));
        } else {
            $this$onMouseClick_u24lambda_u244 = this;
            $i$a$-run-ComponentGroup$onMouseClick$3 = false;
            $this$onMouseClick_u24lambda_u244.setFocus(null);
            super.onMouseClick(event);
        }
    }

    @Override
    public void onMouseClickMove(@NotNull ComponentMouseClickMoveEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        AbstractComponent abstractComponent = this.getFocus();
        if (abstractComponent != null) {
            AbstractComponent abstractComponent2;
            AbstractComponent component = abstractComponent2 = abstractComponent;
            boolean bl2 = false;
            component.onMouseClickMove(new ComponentMouseClickMoveEvent(event, component));
        } else {
            ComponentGroup $this$onMouseClickMove_u24lambda_u246 = this;
            boolean bl3 = false;
            super.onMouseClickMove(event);
        }
    }

    @Override
    public void onMouseRelease(@NotNull ComponentMouseReleaseEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        AbstractComponent abstractComponent = this.getFocus();
        if (abstractComponent != null) {
            AbstractComponent abstractComponent2;
            AbstractComponent component = abstractComponent2 = abstractComponent;
            boolean bl2 = false;
            component.onMouseRelease(new ComponentMouseReleaseEvent(event, component));
        } else {
            ComponentGroup $this$onMouseRelease_u24lambda_u248 = this;
            boolean bl3 = false;
            super.onMouseRelease(event);
            $this$onMouseRelease_u24lambda_u248.onFocus();
        }
    }

    @Override
    public void onUpdate() {
        Iterable $this$forEach$iv = (Iterable)this.getComponents();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            AbstractComponent it = (AbstractComponent)element$iv;
            boolean bl2 = false;
            it.onUpdate();
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onFocus() {
        Object v0;
        ComponentGroup componentGroup;
        block1: {
            void $this$firstOrNull$iv;
            Iterable iterable = (Iterable)this.getComponents();
            componentGroup = this;
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
        componentGroup.setFocus(v0);
    }
}

