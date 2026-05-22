/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.ui.client.hud;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.ui.client.hud.designer.GuiHudDesigner;
import net.ccbluex.liquidbounce.ui.client.hud.element.Element;
import net.ccbluex.liquidbounce.ui.client.hud.element.ElementBorder;
import net.ccbluex.liquidbounce.ui.client.hud.element.elements.ElementArmor;
import net.ccbluex.liquidbounce.ui.client.hud.element.elements.ElementModuleList;
import net.ccbluex.liquidbounce.ui.client.hud.element.elements.ElementNotifications;
import net.ccbluex.liquidbounce.ui.client.hud.element.elements.ElementScoreboard;
import net.ccbluex.liquidbounce.ui.client.hud.element.elements.ElementTargets;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.utils.ClientUtils;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\f\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\u0000J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eJ\u0006\u0010!\u001a\u00020\u0012J\u0016\u0010\"\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eJ\u0016\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001eJ\u000e\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\bJ\u000e\u0010)\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\bJ\u0006\u0010*\u001a\u00020\u0016R=\u0010\u0004\u001a.\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u0005j\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007`\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006+"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/hud/HUDManager;", "Lnet/ccbluex/liquidbounce/injection/forge/MinecraftInstance;", "<init>", "()V", "elementsBase", "Ljava/util/LinkedHashMap;", "", "Ljava/lang/Class;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "Lkotlin/collections/LinkedHashMap;", "getElementsBase", "()Ljava/util/LinkedHashMap;", "elements", "", "getElements", "()Ljava/util/List;", "createDefault", "render", "", "partialTicks", "", "designer", "", "update", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "updateId", "", "handleMouseClick", "mouseX", "", "mouseY", "button", "handleMouseReleased", "handleMouseMove", "handleKey", "c", "", "keyCode", "addElement", "element", "removeElement", "clearElements", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nHUDManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HUDManager.kt\nnet/ccbluex/liquidbounce/ui/client/hud/HUDManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,187:1\n1563#2:188\n1634#2,3:189\n1056#2:192\n1869#2,2:193\n1068#2:195\n1869#2:196\n1870#2:198\n2756#2:199\n1#3:197\n1#3:200\n*S KotlinDebug\n*F\n+ 1 HUDManager.kt\nnet/ccbluex/liquidbounce/ui/client/hud/HUDManager\n*L\n23#1:188\n23#1:189,3\n24#1:192\n25#1:193,2\n44#1:195\n45#1:196\n45#1:198\n183#1:199\n183#1:200\n*E\n"})
public class HUDManager
extends MinecraftInstance {
    @NotNull
    private final LinkedHashMap<String, Class<? extends Element>> elementsBase = new LinkedHashMap();
    @NotNull
    private final List<Element> elements = new ArrayList();

    /*
     * WARNING - void declaration
     */
    public HUDManager() {
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".element.elements", Element.class);
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            Class clazz = (Class)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add((Element)it.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        Iterable $this$sortedBy$iv = (List)destination$iv$iv;
        boolean $i$f$sortedBy = false;
        Iterable $this$forEach$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

            public final int compare(T a2, T b2) {
                Element it = (Element)a2;
                boolean bl2 = false;
                Comparable comparable = (Comparable)((Object)it.getBaseName());
                it = (Element)b2;
                Comparable comparable2 = comparable;
                bl2 = false;
                return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getBaseName()));
            }
        });
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Element it = (Element)element$iv;
            boolean bl3 = false;
            ((Map)this.elementsBase).put(it.getBaseName(), it.getClass());
        }
    }

    @NotNull
    public final LinkedHashMap<String, Class<? extends Element>> getElementsBase() {
        return this.elementsBase;
    }

    @NotNull
    public final List<Element> getElements() {
        return this.elements;
    }

    @NotNull
    public final HUDManager createDefault() {
        HUDManager hUDManager;
        HUDManager $this$createDefault_u24lambda_u243 = hUDManager = this;
        boolean bl2 = false;
        $this$createDefault_u24lambda_u243.clearElements();
        $this$createDefault_u24lambda_u243.addElement(new ElementModuleList());
        $this$createDefault_u24lambda_u243.addElement(new ElementTargets());
        $this$createDefault_u24lambda_u243.addElement(new ElementScoreboard());
        $this$createDefault_u24lambda_u243.addElement(new ElementNotifications());
        $this$createDefault_u24lambda_u243.addElement(new ElementArmor());
        return hUDManager;
    }

    /*
     * Unable to fully structure code
     */
    public final void render(float partialTicks, boolean designer) {
        $this$sortedByDescending$iv = this.elements;
        $i$f$sortedByDescending = false;
        $this$forEach$iv = CollectionsKt.sortedWith($this$sortedByDescending$iv, new Comparator(){

            public final int compare(T a2, T b2) {
                Element it = (Element)b2;
                boolean bl2 = false;
                Comparable comparable = Integer.valueOf(it.getPriority());
                it = (Element)a2;
                Comparable comparable2 = comparable;
                bl2 = false;
                return ComparisonsKt.compareValues(comparable2, it.getPriority());
            }
        });
        $i$f$forEach = false;
        for (T element$iv : $this$forEach$iv) {
            it = (Element)element$iv;
            $i$a$-forEach-HUDManager$render$2 = false;
            GlStateManager.func_179094_E();
            GlStateManager.func_179152_a((float)it.getScale(), (float)it.getScale(), (float)it.getScale());
            GlStateManager.func_179137_b((double)it.getRenderX(), (double)it.getRenderY(), (double)0.0);
            var9_9 = it;
            try {
                $this$render_u24lambda_u249_u24lambda_u247 = var9_9;
                $i$a$-runCatching-HUDManager$render$2$1 = false;
                border = var12_14 = $this$render_u24lambda_u249_u24lambda_u247.drawElement(partialTicks);
                $i$a$-also-HUDManager$render$2$1$1 = false;
                it.setBorder(border);
                var15_19 = var12_14;
                if (var15_19 == null) ** GOTO lbl-1000
                it = var13_16 = var15_19;
                $i$a$-takeIf-HUDManager$render$2$1$2 = false;
                v0 = var12_14 = designer != false ? var13_16 : null;
                if (var12_14 != null) {
                    var12_14.draw();
                    v1 = Unit.INSTANCE;
                } else lbl-1000:
                // 2 sources

                {
                    v1 = null;
                }
                var10_10 = Result.constructor-impl(v1);
            }
            catch (Throwable $i$a$-runCatching-HUDManager$render$2$1) {
                var10_10 = Result.constructor-impl(ResultKt.createFailure($i$a$-runCatching-HUDManager$render$2$1));
            }
            var9_9 = var10_10;
            v2 = Result.exceptionOrNull-impl(var9_9);
            if (v2 != null) {
                e = var10_10 = v2;
                $i$a$-onFailure-HUDManager$render$2$2 = false;
                ClientUtils.INSTANCE.logError("Something went wrong while drawing " + it.getName() + " element in HUD.", (Throwable)e);
            }
            GlStateManager.func_179121_F();
        }
    }

    public final void update(@NotNull EntityPlayerSP player, long updateId) {
        Intrinsics.checkNotNullParameter(player, "player");
        for (Element element : this.elements) {
            element.updateElement();
            element.updateElement(player, updateId);
        }
    }

    public final void handleMouseClick(int mouseX, int mouseY, int button) {
        for (Element element : this.elements) {
            element.handleMouseClick((double)((float)mouseX / element.getScale()) - element.getRenderX(), (double)((float)mouseY / element.getScale()) - element.getRenderY(), button);
        }
        if (button == 0) {
            for (Element element : CollectionsKt.reversed((Iterable)this.elements)) {
                if (!element.isInBorder((double)((float)mouseX / element.getScale()) - element.getRenderX(), (double)((float)mouseY / element.getScale()) - element.getRenderY())) continue;
                element.setDrag(true);
                this.elements.remove(element);
                this.elements.add(element);
                break;
            }
        }
    }

    public final void handleMouseReleased() {
        for (Element element : this.elements) {
            element.setDrag(false);
        }
    }

    public final void handleMouseMove(int mouseX, int mouseY) {
        if (!(MinecraftInstance.mc.getCurrentScreen() instanceof GuiHudDesigner)) {
            return;
        }
        ScaledResolution scaledResolution = new ScaledResolution(MinecraftInstance.mc_nowarp);
        for (Element element : this.elements) {
            ElementBorder border;
            float scaledX = (float)mouseX / element.getScale();
            float scaledY = (float)mouseY / element.getScale();
            float prevMouseX = element.getPrevMouseX();
            float prevMouseY = element.getPrevMouseY();
            element.setPrevMouseX(scaledX);
            element.setPrevMouseY(scaledY);
            if (!element.getDrag()) continue;
            float moveX = scaledX - prevMouseX;
            float moveY = scaledY - prevMouseY;
            if (moveX == 0.0f && moveY == 0.0f || element.getBorder() == null) continue;
            float minX = Math.min(border.getX(), border.getX2()) + 1.0f;
            float minY = Math.min(border.getY(), border.getY2()) + 1.0f;
            float maxX = Math.max(border.getX(), border.getX2()) - 1.0f;
            float maxY = Math.max(border.getY(), border.getY2()) - 1.0f;
            float width = (float)scaledResolution.func_78326_a() / element.getScale();
            float height = (float)scaledResolution.func_78328_b() / element.getScale();
            if ((element.getRenderX() + (double)minX + (double)moveX >= 0.0 || moveX > 0.0f) && (element.getRenderX() + (double)maxX + (double)moveX <= (double)width || moveX < 0.0f)) {
                element.setRenderX(moveX);
            }
            if (!(element.getRenderY() + (double)minY + (double)moveY >= 0.0) && !(moveY > 0.0f) || !(element.getRenderY() + (double)maxY + (double)moveY <= (double)height) && !(moveY < 0.0f)) continue;
            element.setRenderY(moveY);
        }
    }

    public final void handleKey(char c2, int keyCode) {
        for (Element element : this.elements) {
            element.handleKey(c2, keyCode);
        }
    }

    @NotNull
    public final HUDManager addElement(@NotNull Element element) {
        Intrinsics.checkNotNullParameter(element, "element");
        this.elements.add(element);
        element.updateElement();
        return this;
    }

    @NotNull
    public final HUDManager removeElement(@NotNull Element element) {
        Intrinsics.checkNotNullParameter(element, "element");
        element.destroyElement();
        this.elements.remove(element);
        return this;
    }

    public final boolean clearElements() {
        Iterable iterable;
        Iterable $this$onEach$iv = this.elements;
        boolean $i$f$onEach = false;
        Iterable $this$onEach_u24lambda_u2418$iv = iterable = $this$onEach$iv;
        boolean bl2 = false;
        for (Object element$iv : $this$onEach_u24lambda_u2418$iv) {
            Element it = (Element)element$iv;
            boolean bl3 = false;
            it.destroyElement();
        }
        Iterable iterable2 = iterable;
        List it = (List)iterable2;
        boolean bl4 = false;
        it.clear();
        it = (List)iterable2;
        boolean bl5 = false;
        return true;
    }
}

