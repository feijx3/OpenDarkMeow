/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.features.module.modules.combat.autoblocks.AutoBlockCheck;
import net.ccbluex.liquidbounce.features.module.modules.combat.autoblocks.AutoBlockMode;
import net.ccbluex.liquidbounce.features.module.modules.combat.autoblocks.AutoBlockScript;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="AutoBlock", category=ModuleCategory.COMBAT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0014\u001a\u00020\rJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/AutoBlock;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "checks", "Ljava/util/LinkedHashMap;", "", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/autoblocks/AutoBlockCheck;", "modes", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/autoblocks/AutoBlockMode;", "scripts", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/autoblocks/AutoBlockScript;", "blocking", "", "getBlocking", "()Z", "setBlocking", "(Z)V", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "canBlock", "onEnable", "", "onDisable", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nAutoBlock.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutoBlock.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/AutoBlock\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,119:1\n774#2:120\n865#2,2:121\n1740#2,3:123\n1563#2:127\n1634#2,3:128\n1056#2:131\n1869#2:132\n1869#2,2:133\n1870#2:135\n1563#2:136\n1634#2,3:137\n1056#2:140\n1869#2:141\n1869#2,2:142\n1870#2:144\n1563#2:149\n1634#2,3:150\n1056#2:153\n1869#2:154\n1869#2,2:155\n1870#2:157\n1#3:126\n37#4:145\n36#4,3:146\n*S KotlinDebug\n*F\n+ 1 AutoBlock.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/AutoBlock\n*L\n104#1:120\n104#1:121,2\n105#1:123,3\n30#1:127\n30#1:128,3\n31#1:131\n32#1:132\n40#1:133,2\n32#1:135\n52#1:136\n52#1:137,3\n53#1:140\n54#1:141\n56#1:142,2\n54#1:144\n77#1:149\n77#1:150,3\n78#1:153\n79#1:154\n86#1:155,2\n79#1:157\n71#1:145\n71#1:146,3\n*E\n"})
public final class AutoBlock
extends Module {
    @NotNull
    public static final AutoBlock INSTANCE;
    @NotNull
    private static final LinkedHashMap<String, AutoBlockCheck> checks;
    @NotNull
    private static final LinkedHashMap<String, AutoBlockMode> modes;
    @NotNull
    private static final LinkedHashMap<String, AutoBlockScript> scripts;
    private static boolean blocking;
    @JvmField
    @NotNull
    public static final ListValue modeValue;

    private AutoBlock() {
        super(null, null, null, null, 15, null);
    }

    public final boolean getBlocking() {
        return blocking;
    }

    public final void setBlocking(boolean bl2) {
        blocking = bl2;
    }

    /*
     * WARNING - void declaration
     */
    public final boolean canBlock() {
        boolean bl2;
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP != null) {
            boolean bl3;
            boolean bl4;
            block6: {
                void $this$all$iv;
                void $this$filterTo$iv$iv;
                Iterable $this$filter$iv;
                EntityPlayerSP player = entityPlayerSP;
                boolean bl5 = false;
                Collection<AutoBlockCheck> collection = checks.values();
                Intrinsics.checkNotNullExpressionValue(collection, "<get-values>(...)");
                Iterable iterable = collection;
                boolean $i$f$filter = false;
                Iterator iterator2 = $this$filter$iv;
                Collection destination$iv$iv = new ArrayList();
                boolean $i$f$filterTo = false;
                for (Object element$iv$iv : $this$filterTo$iv$iv) {
                    AutoBlockCheck it = (AutoBlockCheck)element$iv$iv;
                    boolean bl6 = false;
                    if (!((Boolean)it.getLinkedStatValue().get() != false || it.isForce())) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                $this$filter$iv = (List)destination$iv$iv;
                boolean $i$f$all = false;
                if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                    bl4 = true;
                } else {
                    for (Object element$iv : $this$all$iv) {
                        AutoBlockCheck it = (AutoBlockCheck)element$iv;
                        boolean bl7 = false;
                        if (it.canBlock(player)) continue;
                        bl4 = false;
                        break block6;
                    }
                    bl4 = true;
                }
            }
            boolean it = bl3 = bl4;
            boolean bl8 = false;
            blocking = it;
            bl2 = bl3;
        } else {
            bl2 = false;
        }
        return bl2;
    }

    @Override
    public void onEnable() {
        block0: {
            AutoBlockMode autoBlockMode = modes.get(modeValue.get());
            if (autoBlockMode == null) break block0;
            autoBlockMode.onEnable();
        }
    }

    @Override
    public void onDisable() {
        block0: {
            blocking = false;
            AutoBlockMode autoBlockMode = modes.get(modeValue.get());
            if (autoBlockMode == null) break block0;
            autoBlockMode.onDisable();
        }
    }

    private static final boolean lambda$5$lambda$4$lambda$3(BoolValue $modulesValue, AutoBlockCheck $it) {
        return (Boolean)$modulesValue.get() != false || $it.isForce();
    }

    /*
     * WARNING - void declaration
     */
    static {
        Object thisCollection$iv;
        Value value;
        boolean $i$f$forEach;
        Object modulesValue2;
        Object it;
        boolean $i$f$sortedBy;
        void it2;
        Object object;
        boolean $i$f$mapTo;
        Object destination$iv$iv;
        Iterable<Object> $this$map$iv;
        List<Class<AutoBlockCheck>> list;
        List<Class<MinecraftInstance>> list2;
        INSTANCE = new AutoBlock();
        checks = new LinkedHashMap();
        modes = new LinkedHashMap();
        scripts = new LinkedHashMap();
        modeValue = new ListValue("Mode", null, "Normal", 2, null);
        List<Class<AutoBlockCheck>> it3 = list2 = ClassUtils.INSTANCE.resolvePackage(INSTANCE.getClass().getPackage().getName() + ".autoblocks.checks", AutoBlockCheck.class);
        boolean bl2 = false;
        List<Class<AutoBlockCheck>> list3 = list = !((Collection)it3).isEmpty() ? list2 : null;
        if (list != null) {
            void $this$mapTo$iv$iv;
            $this$map$iv = list;
            boolean $i$f$map = false;
            List list4 = $this$map$iv;
            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                Class clazz = (Class)item$iv$iv;
                object = destination$iv$iv;
                boolean bl3 = false;
                object.add((AutoBlockCheck)it2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Iterable $this$sortedBy$iv = (List)destination$iv$iv;
            $i$f$sortedBy = false;
            $this$map$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    AutoBlockCheck it = (AutoBlockCheck)a2;
                    boolean bl2 = false;
                    Comparable comparable = (Comparable)((Object)it.getModeName());
                    it = (AutoBlockCheck)b2;
                    Comparable comparable2 = comparable;
                    bl2 = false;
                    return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getModeName()));
                }
            });
            if ($this$map$iv != null) {
                Iterable $this$forEach$iv = $this$map$iv;
                boolean $i$f$forEach2 = false;
                for (Object element$iv : $this$forEach$iv) {
                    it = (AutoBlockCheck)element$iv;
                    boolean bl4 = false;
                    modulesValue2 = new BoolValue(((AutoBlockCheck)it).getModeName(), false);
                    ((AutoBlockCheck)it).setInstance(INSTANCE);
                    ((AutoBlockCheck)it).setLinkedStatValue((BoolValue)modulesValue2);
                    if (!((AutoBlockCheck)it).isForce()) {
                        INSTANCE.getValues().add((Value<?>)modulesValue2);
                    }
                    Iterable $this$forEach$iv2 = ((AutoBlockCheck)it).getValues();
                    $i$f$forEach = false;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        value = (Value)element$iv2;
                        boolean bl5 = false;
                        INSTANCE.getValues().add(value.displayable(() -> AutoBlock.lambda$5$lambda$4$lambda$3((BoolValue)modulesValue2, (AutoBlockCheck)it)));
                    }
                    ((Map)checks).put(((AutoBlockCheck)it).getModeName(), it);
                    EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
                    Intrinsics.checkNotNull(it);
                    EventManager.registerListener$default(eventManager, (ListenableOwner)it, false, false, 6, null);
                }
            }
        }
        it3 = list2 = ClassUtils.INSTANCE.resolvePackage(INSTANCE.getClass().getPackage().getName() + ".autoblocks.modes", AutoBlockMode.class);
        boolean bl6 = false;
        INSTANCE.getValues().add(modeValue);
        it3 = list2;
        boolean bl7 = false;
        List<Class<MinecraftInstance>> list5 = list = !((Collection)it3).isEmpty() ? list2 : null;
        if (list != null) {
            void $this$mapTo$iv$iv;
            $this$map$iv = list;
            boolean $i$f$map = false;
            Iterable<Object> $i$f$forEach2 = $this$map$iv;
            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                modulesValue2 = (Class)item$iv$iv;
                object = destination$iv$iv;
                boolean bl8 = false;
                object.add((AutoBlockMode)it2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Iterable $this$sortedBy$iv = (List)destination$iv$iv;
            $i$f$sortedBy = false;
            $this$map$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    AutoBlockMode it = (AutoBlockMode)a2;
                    boolean bl2 = false;
                    String string = it.getName();
                    Locale locale = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                    String string2 = string.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(string2, "toLowerCase(...)");
                    it = (AutoBlockMode)b2;
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
            if ($this$map$iv != null) {
                Unit $this$forEach$iv;
                Iterable $i$f$sortedBy2 = $this$map$iv;
                boolean $i$f$forEach3 = false;
                Iterator $i$f$mapTo2 = $this$forEach$iv.iterator();
                while ($i$f$mapTo2.hasNext()) {
                    Object element$iv = $i$f$mapTo2.next();
                    AutoBlockMode it4 = (AutoBlockMode)element$iv;
                    boolean bl9 = false;
                    it4.setInstance(INSTANCE);
                    Iterable $this$forEach$iv3 = it4.getValues();
                    $i$f$forEach = false;
                    for (Object element$iv2 : $this$forEach$iv3) {
                        value = (Value)element$iv2;
                        boolean bl10 = false;
                        value.setName(INSTANCE.getName() + value.getName());
                        if (value.getSuperValue() == null) {
                            value.setSuperValue(modeValue);
                            value.setSuperValueMeta(it4.getName());
                        }
                        INSTANCE.getValues().add(value);
                    }
                    ((Map)modes).put(it4.getName(), it4);
                    EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
                    Intrinsics.checkNotNull(it4);
                    EventManager.registerListener$default(eventManager, it4, false, false, 6, null);
                }
                Unit it5 = $this$forEach$iv = Unit.INSTANCE;
                boolean bl11 = false;
                Set<String> set = modes.keySet();
                Intrinsics.checkNotNullExpressionValue(set, "<get-keys>(...)");
                Collection $this$toTypedArray$iv = set;
                boolean $i$f$toTypedArray = false;
                thisCollection$iv = $this$toTypedArray$iv;
                modeValue.setValues(thisCollection$iv.toArray(new String[0]));
            }
        }
        it3 = list2 = ClassUtils.INSTANCE.resolvePackage(INSTANCE.getClass().getPackage().getName() + ".autoblocks.scripts", AutoBlockScript.class);
        boolean bl12 = false;
        List<Class<MinecraftInstance>> list6 = list = !((Collection)it3).isEmpty() ? list2 : null;
        if (list != null) {
            void $this$mapTo$iv$iv;
            $this$map$iv = list;
            boolean $i$f$map = false;
            Iterable<Object> $this$forEach$iv = $this$map$iv;
            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                thisCollection$iv = (Class)item$iv$iv;
                object = destination$iv$iv;
                boolean bl13 = false;
                object.add((AutoBlockScript)it2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Iterable $this$sortedBy$iv = (List)destination$iv$iv;
            boolean $i$f$sortedBy3 = false;
            List list7 = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    AutoBlockScript it = (AutoBlockScript)a2;
                    boolean bl2 = false;
                    String string = it.getName();
                    Locale locale = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                    String string2 = string.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(string2, "toLowerCase(...)");
                    it = (AutoBlockScript)b2;
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
            if (list7 != null) {
                Iterable $this$forEach$iv4 = list7;
                boolean $i$f$forEach4 = false;
                for (Object element$iv : $this$forEach$iv4) {
                    it = (AutoBlockScript)element$iv;
                    boolean bl14 = false;
                    modulesValue2 = new BoolValue(((AutoBlockScript)it).getName(), false);
                    ((AutoBlockScript)it).setInstance(INSTANCE);
                    ((AutoBlockScript)it).setLinkedStatValue((BoolValue)modulesValue2);
                    if (!((AutoBlockScript)it).isForce()) {
                        INSTANCE.getValues().add((Value<?>)modulesValue2);
                    }
                    Iterable $this$forEach$iv5 = ((AutoBlockScript)it).getValues();
                    $i$f$forEach = false;
                    for (Object element$iv2 : $this$forEach$iv5) {
                        value = (Value)element$iv2;
                        boolean bl15 = false;
                        value.setName(((AutoBlockScript)it).getName() + value.getName());
                        value.setSuperValue((Value)modulesValue2);
                        value.setSuperValueMeta(((AutoBlockScript)it).getName());
                        INSTANCE.getValues().add(value);
                    }
                    ((Map)scripts).put(((AutoBlockScript)it).getName(), it);
                    EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
                    Intrinsics.checkNotNull(it);
                    EventManager.registerListener$default(eventManager, (ListenableOwner)it, false, false, 6, null);
                }
            }
        }
    }
}

