/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.darkmeow.ui.component;

import it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.darkmeow.darkmeow.ui.component.AbstractComponent;
import net.darkmeow.darkmeow.ui.component.ComponentUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u001a\u0010\n\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u001a\u0010\u000b\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u001a\u0010\f\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bJ\u0016\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0010*\u00020\u0006JO\u0010\u001b\u001a\u0004\u0018\u00010\u0006*\b\u0012\u0004\u0012\u00020\u00060\u001c2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00052!\b\u0002\u0010\u001f\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u00060 \u00a2\u0006\u0002\b!R\u008d\u0001\u0010\u0011\u001a~\u0012\u0004\u0012\u00020\b\u00124\u00122\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00050\u00130\u0012j>\u0012\u0004\u0012\u00020\b\u00124\u00122\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00050\u0013`\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\""}, d2={"Lnet/darkmeow/darkmeow/ui/component/ComponentUtils;", "", "<init>", "()V", "isMouseInFocusedAndNotOccluded", "", "Lnet/darkmeow/darkmeow/ui/component/AbstractComponent;", "clickX", "", "clickY", "isOccluded", "isMouseInFocused", "isMouseInFocusedReal", "mouseX", "mouseY", "getRealPosition", "Lkotlin/Pair;", "keyCodeFacingMap", "Ljava/util/HashMap;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "prevFocus", "component", "Lkotlin/collections/HashMap;", "getKeyCodeFacingMap", "()Ljava/util/HashMap;", "getNextComponentKeyboard", "Lit/unimi/dsi/fastutil/objects/ObjectLinkedOpenHashSet;", "keyCode", "outboundNull", "default", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nComponentUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ComponentUtils.kt\nnet/darkmeow/darkmeow/ui/component/ComponentUtils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,100:1\n756#2,10:101\n1761#2,3:111\n774#2:114\n865#2,2:115\n2423#2,14:117\n1#3:131\n*S KotlinDebug\n*F\n+ 1 ComponentUtils.kt\nnet/darkmeow/darkmeow/ui/component/ComponentUtils\n*L\n28#1:101,10\n30#1:111,3\n90#1:114\n90#1:115,2\n91#1:117,14\n*E\n"})
public final class ComponentUtils {
    @NotNull
    public static final ComponentUtils INSTANCE = new ComponentUtils();
    @NotNull
    private static final HashMap<Integer, Function2<AbstractComponent, AbstractComponent, Boolean>> keyCodeFacingMap;

    private ComponentUtils() {
    }

    public final boolean isMouseInFocusedAndNotOccluded(@NotNull AbstractComponent $this$isMouseInFocusedAndNotOccluded, int clickX, int clickY) {
        Intrinsics.checkNotNullParameter($this$isMouseInFocusedAndNotOccluded, "<this>");
        return this.isMouseInFocused($this$isMouseInFocusedAndNotOccluded, clickX, clickY) && !this.isOccluded($this$isMouseInFocusedAndNotOccluded, clickX, clickY);
    }

    /*
     * WARNING - void declaration
     */
    public final boolean isOccluded(@NotNull AbstractComponent $this$isOccluded, int clickX, int clickY) {
        boolean bl2;
        block5: {
            void $this$any$iv;
            Iterable $this$dropWhile$iv;
            Intrinsics.checkNotNullParameter($this$isOccluded, "<this>");
            Iterable iterable = (Iterable)$this$isOccluded.getBase().getComponents();
            boolean $i$f$dropWhile = false;
            boolean yielding$iv = false;
            ArrayList list$iv = new ArrayList();
            for (Object item$iv : $this$dropWhile$iv) {
                if (yielding$iv) {
                    list$iv.add(item$iv);
                    continue;
                }
                AbstractComponent it = (AbstractComponent)item$iv;
                boolean bl3 = false;
                if (!Intrinsics.areEqual(it, $this$isOccluded)) continue;
                list$iv.add(item$iv);
                yielding$iv = true;
            }
            $this$dropWhile$iv = CollectionsKt.drop(list$iv, 1);
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl2 = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    AbstractComponent it = (AbstractComponent)element$iv;
                    boolean bl4 = false;
                    Intrinsics.checkNotNull(it);
                    if (!INSTANCE.isMouseInFocused(it, clickX, clickY)) continue;
                    bl2 = true;
                    break block5;
                }
                bl2 = false;
            }
        }
        return bl2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean isMouseInFocused(@NotNull AbstractComponent $this$isMouseInFocused, int clickX, int clickY) {
        Intrinsics.checkNotNullParameter($this$isMouseInFocused, "<this>");
        int n2 = $this$isMouseInFocused.getPosX();
        if (clickX > $this$isMouseInFocused.getPosX() + $this$isMouseInFocused.getWidth()) return false;
        if (n2 > clickX) return false;
        boolean bl2 = true;
        if (!bl2) return false;
        n2 = $this$isMouseInFocused.getPosY();
        if (clickY > $this$isMouseInFocused.getPosY() + $this$isMouseInFocused.getHeight()) return false;
        if (n2 > clickY) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean isMouseInFocusedReal(@NotNull AbstractComponent $this$isMouseInFocusedReal, int mouseX, int mouseY) {
        Intrinsics.checkNotNullParameter($this$isMouseInFocusedReal, "<this>");
        Pair<Integer, Integer> position = this.getRealPosition($this$isMouseInFocusedReal);
        int n2 = ((Number)position.getFirst()).intValue();
        if (mouseX > ((Number)position.getFirst()).intValue() + $this$isMouseInFocusedReal.getWidth()) return false;
        if (n2 > mouseX) return false;
        boolean bl2 = true;
        if (!bl2) return false;
        n2 = ((Number)position.getSecond()).intValue();
        if (mouseY > ((Number)position.getSecond()).intValue() + $this$isMouseInFocusedReal.getHeight()) return false;
        if (n2 > mouseY) return false;
        return true;
    }

    @NotNull
    public final Pair<Integer, Integer> getRealPosition(@NotNull AbstractComponent $this$getRealPosition) {
        Intrinsics.checkNotNullParameter($this$getRealPosition, "<this>");
        Pair<Integer, Integer> offset = $this$getRealPosition.getBase().getRealPositionOffset();
        return new Pair<Integer, Integer>(((Number)offset.getFirst()).intValue() + $this$getRealPosition.getPosX(), ((Number)offset.getSecond()).intValue() + $this$getRealPosition.getPosY());
    }

    @NotNull
    public final HashMap<Integer, Function2<AbstractComponent, AbstractComponent, Boolean>> getKeyCodeFacingMap() {
        return keyCodeFacingMap;
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final AbstractComponent getNextComponentKeyboard(@NotNull ObjectLinkedOpenHashSet<AbstractComponent> $this$getNextComponentKeyboard, @Nullable AbstractComponent prevFocus, int keyCode, boolean outboundNull, @NotNull Function1<? super ObjectLinkedOpenHashSet<AbstractComponent>, ? extends AbstractComponent> default) {
        block11: {
            Intrinsics.checkNotNullParameter($this$getNextComponentKeyboard, "<this>");
            Intrinsics.checkNotNullParameter(default, "default");
            if (prevFocus == null) break block11;
            prev = prevFocus;
            $i$a$-also-ComponentUtils$getNextComponentKeyboard$2 = false;
            var8_8 = (Iterable)$this$getNextComponentKeyboard;
            $i$f$filter = false;
            var10_11 = $this$filter$iv;
            destination$iv$iv = new ArrayList<E>();
            $i$f$filterTo = false;
            for (T element$iv$iv : $this$filterTo$iv$iv) {
                it = (AbstractComponent)element$iv$iv;
                $i$a$-filter-ComponentUtils$getNextComponentKeyboard$2$1 = false;
                if (it == prev || !it.getAllowFocus()) ** GOTO lbl-1000
                v0 = ComponentUtils.keyCodeFacingMap.get(keyCode);
                if (v0 != null) {
                    Intrinsics.checkNotNull(it);
                    v1 = v0.invoke(prev, it).booleanValue();
                } else {
                    v1 = false;
                }
                if (v1) {
                    v2 = true;
                } else lbl-1000:
                // 2 sources

                {
                    v2 = false;
                }
                if (!v2) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            $this$filter$iv = (List)destination$iv$iv;
            $i$f$minByOrNull = false;
            iterator$iv = $this$minByOrNull$iv.iterator();
            if (!iterator$iv.hasNext()) {
                v3 = null;
            } else {
                minElem$iv = iterator$iv.next();
                if (!iterator$iv.hasNext()) {
                    v3 = minElem$iv;
                } else {
                    component = (AbstractComponent)minElem$iv;
                    $i$a$-minByOrNull-ComponentUtils$getNextComponentKeyboard$2$2 = false;
                    minValue$iv = Math.abs(component.getPosY() - prev.getPosY()) + Math.abs(component.getPosX() - prev.getPosX());
                    do {
                        e$iv = iterator$iv.next();
                        component = (AbstractComponent)e$iv;
                        $i$a$-minByOrNull-ComponentUtils$getNextComponentKeyboard$2$2 = false;
                        v$iv = Math.abs(component.getPosY() - prev.getPosY()) + Math.abs(component.getPosX() - prev.getPosX());
                        if (minValue$iv <= v$iv) continue;
                        minElem$iv = e$iv;
                        minValue$iv = v$iv;
                    } while (iterator$iv.hasNext());
                    v3 = minElem$iv;
                }
            }
            if ((v4 = (AbstractComponent)v3) == null) {
                it = var8_8 = prev;
                $i$a$-takeUnless-ComponentUtils$getNextComponentKeyboard$2$3 = false;
                v4 = outboundNull == false ? var8_8 : null;
            }
            return v4;
        }
        return default.invoke((ObjectLinkedOpenHashSet<AbstractComponent>)$this$getNextComponentKeyboard);
    }

    public static /* synthetic */ AbstractComponent getNextComponentKeyboard$default(ComponentUtils componentUtils, ObjectLinkedOpenHashSet objectLinkedOpenHashSet, AbstractComponent abstractComponent, int n2, boolean bl2, Function1 function1, int n3, Object object) {
        if ((n3 & 8) != 0) {
            function1 = getNextComponentKeyboard.1.INSTANCE;
        }
        return componentUtils.getNextComponentKeyboard((ObjectLinkedOpenHashSet<AbstractComponent>)objectLinkedOpenHashSet, abstractComponent, n2, bl2, function1);
    }

    private static final boolean keyCodeFacingMap$lambda$2(AbstractComponent prevFocus, AbstractComponent component) {
        Intrinsics.checkNotNullParameter(prevFocus, "prevFocus");
        Intrinsics.checkNotNullParameter(component, "component");
        return prevFocus.getPosY() > component.getPosY();
    }

    private static final boolean keyCodeFacingMap$lambda$3(AbstractComponent prevFocus, AbstractComponent component) {
        Intrinsics.checkNotNullParameter(prevFocus, "prevFocus");
        Intrinsics.checkNotNullParameter(component, "component");
        return prevFocus.getPosY() < component.getPosY();
    }

    private static final boolean keyCodeFacingMap$lambda$4(AbstractComponent prevFocus, AbstractComponent component) {
        Intrinsics.checkNotNullParameter(prevFocus, "prevFocus");
        Intrinsics.checkNotNullParameter(component, "component");
        return prevFocus.getPosX() > component.getPosX();
    }

    private static final boolean keyCodeFacingMap$lambda$5(AbstractComponent prevFocus, AbstractComponent component) {
        Intrinsics.checkNotNullParameter(prevFocus, "prevFocus");
        Intrinsics.checkNotNullParameter(component, "component");
        return prevFocus.getPosX() < component.getPosX();
    }

    static {
        Pair[] pairArray = new Pair[]{TuplesKt.to(200, ComponentUtils::keyCodeFacingMap$lambda$2), TuplesKt.to(208, ComponentUtils::keyCodeFacingMap$lambda$3), TuplesKt.to(203, ComponentUtils::keyCodeFacingMap$lambda$4), TuplesKt.to(205, ComponentUtils::keyCodeFacingMap$lambda$5)};
        keyCodeFacingMap = MapsKt.hashMapOf(pairArray);
    }
}

