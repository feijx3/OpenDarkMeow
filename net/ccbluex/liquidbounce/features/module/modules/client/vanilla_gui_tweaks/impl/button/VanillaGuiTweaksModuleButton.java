/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiButton
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.client.vanilla_gui_tweaks.impl.button;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.features.module.modules.client.vanilla_gui_tweaks.VanillaGuiTweaksModule;
import net.ccbluex.liquidbounce.features.module.modules.client.vanilla_gui_tweaks.impl.button.styles.VanillaGuiTweaksModuleButtonStyle;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007R\u001e\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/vanilla_gui_tweaks/impl/button/VanillaGuiTweaksModuleButton;", "Lnet/ccbluex/liquidbounce/features/module/modules/client/vanilla_gui_tweaks/VanillaGuiTweaksModule;", "<init>", "()V", "values", "", "Lnet/ccbluex/liquidbounce/value/Value;", "getValues", "()Ljava/util/List;", "styles", "", "", "Lnet/ccbluex/liquidbounce/features/module/modules/client/vanilla_gui_tweaks/impl/button/styles/VanillaGuiTweaksModuleButtonStyle;", "getStyles", "()Ljava/util/Map;", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "handle", "", "button", "Lnet/minecraft/client/gui/GuiButton;", "mc", "Lnet/minecraft/client/Minecraft;", "state", "", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nVanillaGuiTweaksModuleButton.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VanillaGuiTweaksModuleButton.kt\nnet/ccbluex/liquidbounce/features/module/modules/client/vanilla_gui_tweaks/impl/button/VanillaGuiTweaksModuleButton\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,51:1\n1#2:52\n1563#3:53\n1634#3,3:54\n1056#3:57\n1869#3:58\n1869#3,2:59\n1870#3:61\n37#4:62\n36#4,3:63\n*S KotlinDebug\n*F\n+ 1 VanillaGuiTweaksModuleButton.kt\nnet/ccbluex/liquidbounce/features/module/modules/client/vanilla_gui_tweaks/impl/button/VanillaGuiTweaksModuleButton\n*L\n27#1:53\n27#1:54,3\n28#1:57\n29#1:58\n30#1:59,2\n29#1:61\n41#1:62\n41#1:63,3\n*E\n"})
public final class VanillaGuiTweaksModuleButton
extends VanillaGuiTweaksModule {
    @NotNull
    public static final VanillaGuiTweaksModuleButton INSTANCE;
    @NotNull
    private static final List<Value<?>> values;
    @NotNull
    private static final Map<String, VanillaGuiTweaksModuleButtonStyle> styles;
    @JvmField
    @NotNull
    public static final ListValue modeValue;

    private VanillaGuiTweaksModuleButton() {
        super("Button", true);
    }

    @Override
    @NotNull
    public List<Value<?>> getValues() {
        return values;
    }

    @NotNull
    public final Map<String, VanillaGuiTweaksModuleButtonStyle> getStyles() {
        return styles;
    }

    @JvmStatic
    public static final void handle(@NotNull GuiButton button, @NotNull Minecraft mc, int state) {
        block0: {
            Intrinsics.checkNotNullParameter(button, "button");
            Intrinsics.checkNotNullParameter(mc, "mc");
            VanillaGuiTweaksModuleButtonStyle vanillaGuiTweaksModuleButtonStyle = styles.get(modeValue.get());
            if (vanillaGuiTweaksModuleButtonStyle == null) break block0;
            VanillaGuiTweaksModuleButtonStyle $this$handle_u24lambda_u245 = vanillaGuiTweaksModuleButtonStyle;
            boolean bl2 = false;
            $this$handle_u24lambda_u245.render(button, mc, state);
        }
    }

    /*
     * WARNING - void declaration
     */
    static {
        Unit unit;
        Iterator $this$mapTo$iv$iv;
        INSTANCE = new VanillaGuiTweaksModuleButton();
        values = new ArrayList();
        styles = new LinkedHashMap();
        modeValue = new ListValue("Mode", null, null, 6, null);
        INSTANCE.getValues().add(modeValue);
        Iterable $this$map$iv = ClassUtils.INSTANCE.resolvePackage(INSTANCE.getClass().getPackage().getName() + ".styles.impl", VanillaGuiTweaksModuleButtonStyle.class);
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        Iterator iterator2 = $this$mapTo$iv$iv.iterator();
        while (iterator2.hasNext()) {
            void it;
            Object item$iv$iv = iterator2.next();
            Class clazz = (Class)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add((VanillaGuiTweaksModuleButtonStyle)it.getConstructor(new Class[0]).newInstance(new Object[0]));
        }
        Iterable $this$sortedBy$iv = (List)destination$iv$iv;
        boolean $i$f$sortedBy = false;
        Iterable $this$forEach$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

            public final int compare(T a2, T b2) {
                VanillaGuiTweaksModuleButtonStyle it = (VanillaGuiTweaksModuleButtonStyle)a2;
                boolean bl2 = false;
                String string = it.getName();
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                String string2 = string.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(string2, "toLowerCase(...)");
                it = (VanillaGuiTweaksModuleButtonStyle)b2;
                Comparable comparable = (Comparable)((Object)string2);
                bl2 = false;
                string = it.getName();
                Locale locale2 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
                String string3 = string.toLowerCase(locale2);
                Intrinsics.checkNotNullExpressionValue(string3, "toLowerCase(...)");
                return ComparisonsKt.compareValues(comparable, (Comparable)((Object)string3));
            }
        });
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            VanillaGuiTweaksModuleButtonStyle module = (VanillaGuiTweaksModuleButtonStyle)element$iv;
            boolean bl3 = false;
            Iterable $this$forEach$iv2 = module.getValues();
            boolean $i$f$forEach2 = false;
            for (Object element$iv2 : $this$forEach$iv2) {
                Value value = (Value)element$iv2;
                boolean bl4 = false;
                value.setName(module.getName() + value.getName());
                value.setSuperValue(modeValue);
                value.setSuperValueMeta(module.getName());
                INSTANCE.getValues().add(value);
            }
            styles.put(module.getName(), module);
        }
        Unit it = unit = Unit.INSTANCE;
        boolean bl5 = false;
        Collection $this$toTypedArray$iv = styles.keySet();
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        modeValue.setValues(thisCollection$iv.toArray(new String[0]));
        String string = ArraysKt.firstOrNull(modeValue.getValues());
        if (string == null) {
            string = "";
        }
        modeValue.setValue(string);
    }
}

