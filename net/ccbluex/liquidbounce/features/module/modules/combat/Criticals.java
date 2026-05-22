/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.features.module.modules.combat.criticals.CriticalsMode;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="Criticals", category=ModuleCategory.COMBAT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006\u001e"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/Criticals;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modes", "Ljava/util/HashMap;", "", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/criticals/CriticalsMode;", "Lkotlin/collections/HashMap;", "settingsModuleValues", "", "Lnet/ccbluex/liquidbounce/value/Value;", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "getModeValue", "()Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "visualValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "doRenderCriticals", "", "entity", "Lnet/minecraft/entity/Entity;", "onEnable", "onDisable", "tag", "getTag", "()Ljava/lang/String;", "values", "getValues", "()Ljava/util/List;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nCriticals.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Criticals.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/Criticals\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,64:1\n1#2:65\n1563#3:66\n1634#3,3:67\n1056#3:70\n1869#3:71\n1869#3,2:72\n1870#3:74\n37#4:75\n36#4,3:76\n*S KotlinDebug\n*F\n+ 1 Criticals.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/Criticals\n*L\n24#1:66\n24#1:67,3\n25#1:70\n26#1:71\n28#1:72,2\n26#1:74\n37#1:75\n37#1:76,3\n*E\n"})
public final class Criticals
extends Module {
    @NotNull
    public static final Criticals INSTANCE;
    @NotNull
    private static final HashMap<String, CriticalsMode> modes;
    @NotNull
    private static final List<Value<?>> settingsModuleValues;
    @NotNull
    private static final ListValue modeValue;
    @NotNull
    private static final BoolValue visualValue;
    @NotNull
    private static final List<Value<?>> values;

    private Criticals() {
        super(null, null, null, null, 15, null);
    }

    @NotNull
    public final ListValue getModeValue() {
        return modeValue;
    }

    public final void doRenderCriticals(@NotNull Entity entity) {
        block1: {
            Intrinsics.checkNotNullParameter(entity, "entity");
            if (!((Boolean)visualValue.get()).booleanValue()) break block1;
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP != null) {
                entityPlayerSP.func_71009_b(entity);
            }
        }
    }

    @Override
    public void onEnable() {
        block0: {
            CriticalsMode criticalsMode = modes.get(modeValue.get());
            if (criticalsMode == null) break block0;
            criticalsMode.onEnable();
        }
    }

    @Override
    public void onDisable() {
        block0: {
            CriticalsMode criticalsMode = modes.get(modeValue.get());
            if (criticalsMode == null) break block0;
            criticalsMode.onDisable();
        }
    }

    @Override
    @NotNull
    public String getTag() {
        return (String)modeValue.get();
    }

    @Override
    @NotNull
    public List<Value<?>> getValues() {
        return values;
    }

    private static final boolean lambda$5$lambda$4$lambda$3(CriticalsMode $it) {
        return Intrinsics.areEqual(modeValue.get(), $it.getModeName());
    }

    public static final /* synthetic */ HashMap access$getModes$p() {
        return modes;
    }

    /*
     * WARNING - void declaration
     */
    static {
        Object object;
        String[] stringArray;
        INSTANCE = new Criticals();
        modes = new HashMap();
        settingsModuleValues = new ArrayList();
        String[] it = stringArray = ClassUtils.INSTANCE.resolvePackage(INSTANCE.getClass().getPackage().getName() + ".criticals", CriticalsMode.class);
        boolean bl2 = false;
        Object object2 = object = !((Collection)it).isEmpty() ? stringArray : null;
        if (object != null) {
            void $this$mapTo$iv$iv;
            List $this$map$iv = (List)object;
            boolean $i$f$map = false;
            List list = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it2;
                Class clazz = (Class)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl3 = false;
                collection.add((CriticalsMode)it2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Iterable $this$sortedBy$iv = (List)destination$iv$iv;
            boolean $i$f$sortedBy = false;
            $this$map$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    CriticalsMode it = (CriticalsMode)a2;
                    boolean bl2 = false;
                    Comparable comparable = (Comparable)((Object)it.getModeName());
                    it = (CriticalsMode)b2;
                    Comparable comparable2 = comparable;
                    bl2 = false;
                    return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getModeName()));
                }
            });
            if ($this$map$iv != null) {
                Iterable $this$forEach$iv = $this$map$iv;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    CriticalsMode it3 = (CriticalsMode)element$iv;
                    boolean bl4 = false;
                    it3.setInstance(INSTANCE);
                    Iterable $this$forEach$iv2 = it3.getValues();
                    boolean $i$f$forEach2 = false;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        Value value = (Value)element$iv2;
                        boolean bl5 = false;
                        settingsModuleValues.add(value.displayable(() -> Criticals.lambda$5$lambda$4$lambda$3(it3)));
                    }
                    ((Map)modes).put(it3.getModeName(), it3);
                    EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
                    Intrinsics.checkNotNull(it3);
                    EventManager.registerListener$default(eventManager, it3, false, false, 6, null);
                }
            }
        }
        Set<String> set = modes.keySet();
        Intrinsics.checkNotNullExpressionValue(set, "<get-keys>(...)");
        Collection $this$toTypedArray$iv = set;
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        object = thisCollection$iv.toArray(new String[0]);
        modeValue = new ListValue((String[])object){

            protected void onChanged(String oldValue, String newValue) {
                block2: {
                    Intrinsics.checkNotNullParameter(oldValue, "oldValue");
                    Intrinsics.checkNotNullParameter(newValue, "newValue");
                    if (!Criticals.INSTANCE.getState()) break block2;
                    CriticalsMode criticalsMode = (CriticalsMode)Criticals.access$getModes$p().get(oldValue);
                    if (criticalsMode != null) {
                        criticalsMode.onDisable();
                    }
                    CriticalsMode criticalsMode2 = (CriticalsMode)Criticals.access$getModes$p().get(newValue);
                    if (criticalsMode2 != null) {
                        criticalsMode2.onEnable();
                    }
                }
            }
        };
        visualValue = new BoolValue("Visual", true);
        Object it4 = object = settingsModuleValues;
        boolean bl6 = false;
        Value[] valueArray = new ListValue[1];
        valueArray[0] = modeValue;
        it4.addAll(0, (Collection)CollectionsKt.mutableListOf(valueArray));
        it4 = object;
        boolean bl7 = false;
        valueArray = new BoolValue[]{visualValue};
        it4.addAll((Collection)CollectionsKt.mutableListOf(valueArray));
        values = object;
    }
}

