/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.features.module.modules.movement.eagles.EagleCheck;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="Eagle", description="Makes you eagle (aka. FastBridge).", category=ModuleCategory.MOVEMENT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/Eagle;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "checks", "Ljava/util/LinkedHashMap;", "", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/eagles/EagleCheck;", "Lkotlin/collections/LinkedHashMap;", "settingsModuleValues", "", "Lnet/ccbluex/liquidbounce/value/Value;", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/events/input/MovementInputEvent$PRE;", "values", "getValues", "()Ljava/util/List;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nEagle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Eagle.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/Eagle\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,58:1\n1#2:59\n1563#3:60\n1634#3,3:61\n1056#3:64\n1869#3:65\n1869#3,2:66\n1870#3:68\n774#3:69\n865#3,2:70\n1740#3,3:72\n*S KotlinDebug\n*F\n+ 1 Eagle.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/Eagle\n*L\n23#1:60\n23#1:61,3\n24#1:64\n25#1:65\n33#1:66,2\n25#1:68\n50#1:69\n50#1:70,2\n51#1:72,3\n*E\n"})
public final class Eagle
extends Module {
    @NotNull
    private final LinkedHashMap<String, EagleCheck> checks = new LinkedHashMap();
    @NotNull
    private final List<Value<?>> settingsModuleValues = new ArrayList();
    @NotNull
    private final List<Value<?>> values;

    /*
     * WARNING - void declaration
     */
    public Eagle() {
        super(null, null, null, null, 15, null);
        List<Class<EagleCheck>> list;
        List<Class<EagleCheck>> list2;
        List<Class<EagleCheck>> it = list2 = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".eagles.checks", EagleCheck.class);
        boolean bl2 = false;
        List<Class<EagleCheck>> list3 = list = !((Collection)it).isEmpty() ? list2 : null;
        if (list != null) {
            Iterable $this$sortedBy$iv;
            void $this$mapTo$iv$iv;
            Iterable $this$map$iv = list;
            boolean $i$f$map22 = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it2;
                Class clazz = (Class)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl3 = false;
                collection.add((EagleCheck)it2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Iterable $i$f$map22 = (List)destination$iv$iv;
            boolean $i$f$sortedBy = false;
            List list4 = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    EagleCheck it = (EagleCheck)a2;
                    boolean bl2 = false;
                    Comparable comparable = (Comparable)((Object)it.getName());
                    it = (EagleCheck)b2;
                    Comparable comparable2 = comparable;
                    bl2 = false;
                    return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getName()));
                }
            });
            if (list4 != null) {
                void $this$forEach$iv;
                $this$sortedBy$iv = list4;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    EagleCheck it3 = (EagleCheck)element$iv;
                    boolean bl4 = false;
                    BoolValue modulesMode2 = new BoolValue(it3.getName(), false);
                    it3.setInstance(this);
                    it3.setLinkedStatValue(modulesMode2);
                    this.settingsModuleValues.add(modulesMode2);
                    Iterable $this$forEach$iv2 = it3.getValues();
                    boolean $i$f$forEach2 = false;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        Value value = (Value)element$iv2;
                        boolean bl5 = false;
                        value.setName(it3.getName() + value.getName());
                        value.setSuperValue(modulesMode2);
                        this.settingsModuleValues.add(value);
                    }
                    ((Map)this.checks).put(it3.getName(), it3);
                }
            }
        }
        this.values = this.settingsModuleValues;
    }

    /*
     * WARNING - void declaration
     */
    @EventTarget
    public final void onUpdate(@NotNull MovementInputEvent.PRE event) {
        block7: {
            Object object;
            boolean bl2;
            Object object2;
            EntityPlayerSP player;
            block6: {
                void $this$all$iv;
                Iterator $this$filterTo$iv$iv;
                Iterable $this$filter$iv;
                Intrinsics.checkNotNullParameter(event, "event");
                EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
                if (entityPlayerSP == null) {
                    return;
                }
                player = entityPlayerSP;
                Collection<EagleCheck> collection = this.checks.values();
                Intrinsics.checkNotNullExpressionValue(collection, "<get-values>(...)");
                object2 = collection;
                boolean $i$f$filter = false;
                void var6_6 = $this$filter$iv;
                Collection destination$iv$iv = new ArrayList();
                boolean $i$f$filterTo = false;
                Iterator iterator2 = $this$filterTo$iv$iv.iterator();
                while (iterator2.hasNext()) {
                    Object element$iv$iv = iterator2.next();
                    EagleCheck it = (EagleCheck)element$iv$iv;
                    boolean bl3 = false;
                    if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                $this$filter$iv = (List)destination$iv$iv;
                boolean $i$f$all = false;
                if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                    bl2 = true;
                } else {
                    for (Object element$iv : $this$all$iv) {
                        EagleCheck it = (EagleCheck)element$iv;
                        boolean bl4 = false;
                        if (it.allowEagle(player)) continue;
                        bl2 = false;
                        break block6;
                    }
                    bl2 = true;
                }
            }
            object2 = bl2;
            boolean it = (Boolean)object2;
            boolean bl5 = false;
            Object object3 = object = it ? object2 : null;
            if (object == null) break block7;
            Object object4 = object;
            boolean it2 = (Boolean)object4;
            boolean bl6 = false;
            Object object5 = object2 = player.field_70170_p.func_180495_p(new BlockPos((Entity)player).func_177979_c(1)).func_185904_a().func_76222_j() ? object4 : null;
            if (object2 != null) {
                object4 = object2;
                it2 = (Boolean)object4;
                boolean bl7 = false;
                event.setKeyStateSneak(true);
            }
        }
    }

    @Override
    @NotNull
    public List<Value<?>> getValues() {
        return this.values;
    }
}

