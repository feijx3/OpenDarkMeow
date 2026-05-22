/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.exclusive.ExtendModuleExclusive;
import net.ccbluex.liquidbounce.features.module.modules.player.stucks.StuckModule;
import net.ccbluex.liquidbounce.handler.movement.stuck.MovementStuckManagerExtend;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/Stuck;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modes", "", "", "Lnet/ccbluex/liquidbounce/features/module/modules/player/stucks/StuckModule;", "onEnable", "", "onDisable", "tag", "getTag", "()Ljava/lang/String;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nStuck.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Stuck.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/Stuck\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,76:1\n1563#2:77\n1634#2,3:78\n1056#2:81\n1869#2:82\n1869#2,2:83\n1870#2:85\n774#2:86\n865#2,2:87\n1869#2,2:89\n774#2:91\n865#2,2:92\n1869#2,2:94\n*S KotlinDebug\n*F\n+ 1 Stuck.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/Stuck\n*L\n25#1:77\n25#1:78,3\n26#1:81\n27#1:82\n44#1:83,2\n27#1:85\n63#1:86\n63#1:87,2\n64#1:89,2\n70#1:91\n70#1:92,2\n71#1:94,2\n*E\n"})
public final class Stuck
extends Module {
    @NotNull
    private final Map<String, StuckModule> modes = new LinkedHashMap();

    /*
     * WARNING - void declaration
     */
    public Stuck() {
        super("Stuck", ModuleCategory.PLAYER, null, null, 12, null);
        void $this$mapTo$iv$iv;
        ExtendModuleExclusive.INSTANCE.registerExclusive(this, "stuck");
        Iterable $this$map$iv = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".stucks", StuckModule.class);
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it2;
            Class clazz = (Class)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add((StuckModule)it2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        Iterable $this$sortedBy$iv = (List)destination$iv$iv;
        boolean $i$f$sortedBy = false;
        Iterable $this$forEach$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

            public final int compare(T a2, T b2) {
                StuckModule it = (StuckModule)a2;
                boolean bl2 = false;
                Comparable comparable = (Comparable)((Object)it.getName());
                it = (StuckModule)b2;
                Comparable comparable2 = comparable;
                bl2 = false;
                return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getName()));
            }
        });
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Object item$iv$iv;
            StuckModule it = (StuckModule)element$iv;
            boolean bl3 = false;
            item$iv$iv = it.getName();
            boolean it2 = it.getDefaultState();
            BoolValue modulesValue2 = new BoolValue(this, it, (String)item$iv$iv, it2){
                final /* synthetic */ Stuck this$0;
                final /* synthetic */ StuckModule $it;
                {
                    this.this$0 = $receiver;
                    this.$it = $it;
                    super($super_call_param$1, $super_call_param$2);
                }

                protected void onChange(boolean oldValue, boolean newValue) {
                    if (this.this$0.getState()) {
                        boolean bl2 = newValue;
                        if (bl2) {
                            this.$it.onEnable();
                        } else if (!bl2) {
                            this.$it.onDisable();
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                }
            };
            it.setInstance(this);
            it.setLinkedStatValue(modulesValue2);
            if (!it.isRoot()) {
                this.getValues().add(modulesValue2);
            }
            Iterable $this$forEach$iv2 = it.getValues();
            boolean $i$f$forEach2 = false;
            for (Object element$iv2 : $this$forEach$iv2) {
                Value value = (Value)element$iv2;
                boolean bl4 = false;
                value.setName(it.getName() + value.getName());
                if (value.getSuperValue() == null) {
                    value.setSuperValue(modulesValue2);
                }
                this.getValues().add(value);
            }
            this.modes.put(it.getName(), it);
            EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
            Intrinsics.checkNotNull(it);
            EventManager.registerListener$default(eventManager, it, false, false, 6, null);
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onEnable() {
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv = this.modes.values();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            StuckModule it = (StuckModule)element$iv$iv;
            boolean bl2 = false;
            if (!(it.isRoot() || (Boolean)it.getLinkedStatValue().get() != false)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$forEach$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            StuckModule it = (StuckModule)element$iv;
            boolean bl3 = false;
            it.onEnable();
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onDisable() {
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv = this.modes.values();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            StuckModule it = (StuckModule)element$iv$iv;
            boolean bl2 = false;
            if (!(it.isRoot() || (Boolean)it.getLinkedStatValue().get() != false)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$forEach$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            StuckModule it = (StuckModule)element$iv;
            boolean bl3 = false;
            it.onDisable();
        }
    }

    @Override
    @NotNull
    public String getTag() {
        return String.valueOf(MovementStuckManagerExtend.INSTANCE.getSafeReleaseCount(DarkMeow.INSTANCE.getMovementManager().getStuckManager()));
    }
}

