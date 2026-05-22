/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.modules.client.vanilla_gui_tweaks.VanillaGuiTweaksModule;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/VanillaGuiTweaks;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modules", "", "", "Lnet/ccbluex/liquidbounce/features/module/modules/client/vanilla_gui_tweaks/VanillaGuiTweaksModule;", "getModules", "()Ljava/util/Map;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nVanillaGuiTweaks.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VanillaGuiTweaks.kt\nnet/ccbluex/liquidbounce/features/module/modules/client/VanillaGuiTweaks\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,40:1\n1563#2:41\n1634#2,3:42\n1056#2:45\n1869#2:46\n1869#2,2:47\n1870#2:49\n*S KotlinDebug\n*F\n+ 1 VanillaGuiTweaks.kt\nnet/ccbluex/liquidbounce/features/module/modules/client/VanillaGuiTweaks\n*L\n19#1:41\n19#1:42,3\n20#1:45\n21#1:46\n28#1:47,2\n21#1:49\n*E\n"})
public final class VanillaGuiTweaks
extends Module {
    @NotNull
    public static final VanillaGuiTweaks INSTANCE;
    @NotNull
    private static final Map<String, VanillaGuiTweaksModule> modules;

    private VanillaGuiTweaks() {
        super("VanillaGuiTweaks", ModuleCategory.CLIENT, null, null, 12, null);
    }

    @NotNull
    public final Map<String, VanillaGuiTweaksModule> getModules() {
        return modules;
    }

    /*
     * WARNING - void declaration
     */
    static {
        void $this$mapTo$iv$iv;
        INSTANCE = new VanillaGuiTweaks();
        modules = new LinkedHashMap();
        Iterable $this$map$iv = ClassUtils.INSTANCE.resolvePackage(INSTANCE.getClass().getPackage().getName() + ".vanilla_gui_tweaks.impl", VanillaGuiTweaksModule.class);
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            Class clazz = (Class)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add((VanillaGuiTweaksModule)ClassUtils.INSTANCE.getObjectInstance(it));
        }
        Iterable $this$sortedBy$iv = (List)destination$iv$iv;
        boolean $i$f$sortedBy = false;
        Iterable $this$forEach$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

            public final int compare(T a2, T b2) {
                VanillaGuiTweaksModule it = (VanillaGuiTweaksModule)a2;
                boolean bl2 = false;
                String string = it.getName();
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                String string2 = string.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(string2, "toLowerCase(...)");
                it = (VanillaGuiTweaksModule)b2;
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
            VanillaGuiTweaksModule module = (VanillaGuiTweaksModule)element$iv;
            boolean bl3 = false;
            BoolValue moduleValue = new BoolValue(module.getName(), module.getDefault());
            INSTANCE.getValues().add(moduleValue);
            module.setInstance(INSTANCE);
            module.setLinkedStatValue(moduleValue);
            Iterable $this$forEach$iv2 = module.getValues();
            boolean $i$f$forEach2 = false;
            for (Object element$iv2 : $this$forEach$iv2) {
                Value value = (Value)element$iv2;
                boolean bl4 = false;
                value.setName(module.getName() + value.getName());
                value.setSuperValue(moduleValue);
                value.setSuperValueMeta(module.getName());
                INSTANCE.getValues().add(value);
            }
            modules.put(module.getName(), module);
        }
    }
}

