/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.ui.client.hud.element.elements;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.modules.world.Scaffold;
import net.ccbluex.liquidbounce.ui.client.hud.element.Element;
import net.ccbluex.liquidbounce.ui.client.hud.element.ElementBorder;
import net.ccbluex.liquidbounce.ui.client.hud.element.ElementSide;
import net.ccbluex.liquidbounce.ui.client.hud.element.elements.scaffold_counter.ScaffoldCounterData;
import net.ccbluex.liquidbounce.ui.client.hud.element.elements.scaffold_counter.ScaffoldCounterMode;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementScaffoldCounter;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "<init>", "()V", "blockData", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/scaffold_counter/ScaffoldCounterData;", "modes", "", "", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/scaffold_counter/ScaffoldCounterMode;", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementBorder;", "partialTicks", "", "updateElement", "", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "updateId", "", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nElementScaffoldCounter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ElementScaffoldCounter.kt\nnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementScaffoldCounter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,53:1\n1#2:54\n1#2:60\n1563#3:55\n1634#3,3:56\n2756#3:59\n37#4:61\n36#4,3:62\n*S KotlinDebug\n*F\n+ 1 ElementScaffoldCounter.kt\nnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementScaffoldCounter\n*L\n33#1:60\n32#1:55\n32#1:56,3\n33#1:59\n40#1:61\n40#1:62,3\n*E\n"})
public final class ElementScaffoldCounter
extends Element {
    @JvmField
    @Nullable
    public ScaffoldCounterData blockData;
    @JvmField
    @NotNull
    public final Map<String, ScaffoldCounterMode> modes = new LinkedHashMap();
    @JvmField
    @NotNull
    public final ListValue modeValue;

    /*
     * WARNING - void declaration
     */
    public ElementScaffoldCounter() {
        super("ScaffoldCounter", 0.0, 30.0, 0.0f, new ElementSide(ElementSide.Horizontal.MIDDLE, ElementSide.Vertical.MIDDLE), 0, 40, null);
        List<Class<ScaffoldCounterMode>> list;
        List<Class<ScaffoldCounterMode>> list2;
        List<Class<ScaffoldCounterMode>> it = list2 = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".scaffold_counter.impl", ScaffoldCounterMode.class);
        boolean bl2 = false;
        List<Class<ScaffoldCounterMode>> list3 = list = !((Collection)it).isEmpty() ? list2 : null;
        if (list != null) {
            ScaffoldCounterMode it2;
            void $this$mapTo$iv$iv;
            Iterable $this$map$iv = list;
            boolean $i$f$map = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                Class clazz = (Class)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl3 = false;
                collection.add((ScaffoldCounterMode)((Class)((Object)it2)).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Iterable $this$onEach$iv = (List)destination$iv$iv;
            boolean $i$f$onEach = false;
            Iterable $this$onEach_u24lambda_u2418$iv = iterable = $this$onEach$iv;
            boolean bl4 = false;
            for (Object element$iv : $this$onEach_u24lambda_u2418$iv) {
                it2 = (ScaffoldCounterMode)element$iv;
                boolean bl5 = false;
                it2.setInstance(this);
                this.modes.put(it2.getName(), it2);
            }
            List cfr_ignored_0 = (List)iterable;
        }
        Collection $this$toTypedArray$iv = this.modes.keySet();
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        this.modeValue = new ListValue("Mode", thisCollection$iv.toArray(new String[0]), "Info");
    }

    @Override
    @Nullable
    public ElementBorder drawElement(float partialTicks) {
        ElementBorder elementBorder;
        ScaffoldCounterData scaffoldCounterData = this.blockData;
        if (scaffoldCounterData != null) {
            ScaffoldCounterData data = scaffoldCounterData;
            boolean bl2 = false;
            ScaffoldCounterMode scaffoldCounterMode = this.modes.get(this.modeValue.get());
            elementBorder = scaffoldCounterMode != null ? scaffoldCounterMode.render(data) : null;
        } else {
            elementBorder = null;
        }
        return elementBorder;
    }

    @Override
    public void updateElement(@NotNull EntityPlayerSP player, long updateId) {
        ScaffoldCounterData.Companion companion;
        Intrinsics.checkNotNullParameter(player, "player");
        ScaffoldCounterData.Companion companion2 = companion = ScaffoldCounterData.Companion;
        ElementScaffoldCounter elementScaffoldCounter = this;
        boolean bl2 = false;
        Scaffold scaffold = DarkMeow.INSTANCE.getModuleManager().get(Scaffold.class);
        boolean bl3 = scaffold != null ? scaffold.getState() : false;
        ScaffoldCounterData.Companion companion3 = bl3 ? companion : null;
        elementScaffoldCounter.blockData = companion3 != null ? companion3.fromPlayer(player) : null;
    }
}

