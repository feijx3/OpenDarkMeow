/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.kill_aura.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.features.module.modules.combat.kill_aura.manager.KillAuraManagerBase;
import net.ccbluex.liquidbounce.utils.timer.delay.MSDelay;
import net.ccbluex.liquidbounce.value.impl.IntegerRangeValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.darkmeow.darkmeow.utils.world.WorldUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0019\u001a\u00020\u001a*\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001aR\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/kill_aura/manager/KillAuraTargetManager;", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/kill_aura/manager/KillAuraManagerBase;", "<init>", "()V", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "priorityValue", "switchDelayValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerRangeValue;", "switchDelay", "Lnet/ccbluex/liquidbounce/utils/timer/delay/MSDelay;", "getSwitchDelay", "()Lnet/ccbluex/liquidbounce/utils/timer/delay/MSDelay;", "targets", "", "Lnet/minecraft/entity/EntityLivingBase;", "getTargets", "()Ljava/util/Set;", "setTargets", "(Ljava/util/Set;)V", "prevTarget", "getPrevTarget", "()Lnet/minecraft/entity/EntityLivingBase;", "setPrevTarget", "(Lnet/minecraft/entity/EntityLivingBase;)V", "update", "", "Lnet/darkmeow/darkmeow/event/listenable/SafeListenerBase;", "reset", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nKillAuraTargetManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KillAuraTargetManager.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/kill_aura/manager/KillAuraTargetManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,99:1\n1#2:100\n808#3,11:101\n774#3:112\n865#3,2:113\n1056#3:115\n774#3:116\n865#3,2:117\n*S KotlinDebug\n*F\n+ 1 KillAuraTargetManager.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/kill_aura/manager/KillAuraTargetManager\n*L\n44#1:101,11\n46#1:112\n46#1:113,2\n47#1:115\n62#1:116\n62#1:117,2\n*E\n"})
public final class KillAuraTargetManager
extends KillAuraManagerBase {
    @JvmField
    @NotNull
    public final ListValue modeValue;
    @JvmField
    @NotNull
    public final ListValue priorityValue;
    @JvmField
    @NotNull
    public final IntegerRangeValue switchDelayValue;
    @NotNull
    private final MSDelay switchDelay;
    @NotNull
    private Set<EntityLivingBase> targets;
    @Nullable
    private EntityLivingBase prevTarget;

    public KillAuraTargetManager() {
        String[] stringArray = new String[]{"First", "Last", "Sequential", "Reverse", "Random"};
        this.modeValue = new ListValue("Mode", stringArray, "Sequential");
        stringArray = new String[]{"Distance", "Health", "LivingTime", "HurtResistantTime"};
        this.priorityValue = new ListValue("Priority", stringArray, "Distance");
        this.switchDelayValue = new IntegerRangeValue("SwitchDelay", new IntRange(200, 200), new IntRange(0, 2000));
        this.switchDelay = new MSDelay();
        this.targets = new LinkedHashSet();
    }

    @NotNull
    public final MSDelay getSwitchDelay() {
        return this.switchDelay;
    }

    @NotNull
    public final Set<EntityLivingBase> getTargets() {
        return this.targets;
    }

    public final void setTargets(@NotNull Set<EntityLivingBase> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.targets = set;
    }

    @Nullable
    public final EntityLivingBase getPrevTarget() {
        return this.prevTarget;
    }

    public final void setPrevTarget(@Nullable EntityLivingBase entityLivingBase) {
        this.prevTarget = entityLivingBase;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void update(@NotNull SafeListenerBase $this$update) {
        List<EntityLivingBase> list;
        List<EntityLivingBase> list2;
        List<EntityLivingBase> list3;
        void $this$filterTo$iv$iv;
        void $this$sortedBy$iv;
        void $this$filterTo$iv$iv2;
        List list4;
        Set<Entity> set;
        Intrinsics.checkNotNullParameter($this$update, "<this>");
        boolean canSelectNext = false;
        List prevTargets = new ArrayList();
        Set<Entity> set2 = set = WorldUtils.quickGetNearEntities((World)$this$update.getWorld(), $this$update.getPlayer(), ((Number)this.getModule().getRotationRangeValue().get()).floatValue(), arg_0 -> KillAuraTargetManager.update$lambda$0(this, arg_0));
        boolean bl2 = false;
        if (!MSDelay.hasPassed$default(this.switchDelay, 0L, 1, null)) {
            EntityLivingBase entityLivingBase = this.prevTarget;
            if (entityLivingBase == null) return;
            EntityLivingBase entityLivingBase2 = entityLivingBase;
            boolean bl3 = false;
            if (set2.contains(entityLivingBase2)) return;
            boolean bl4 = true;
            if (!bl4) return;
        }
        boolean bl5 = true;
        if (!bl5) return;
        Set<Entity> set3 = set;
        Set<Entity> set4 = set3;
        if (set4 == null) return;
        Iterable iterable = set4;
        boolean $i$f$filterIsInstance = false;
        Iterable iterable2 = iterable;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterIsInstanceTo22 = false;
        for (Object element$iv$iv : iterable2) {
            if (!(element$iv$iv instanceof EntityLivingBase)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List list5 = list4 = (List)destination$iv$iv;
        boolean bl6 = false;
        this.switchDelay.reset(this.switchDelayValue);
        Iterable iterable3 = list4;
        boolean $i$f$filter22 = false;
        Iterable $i$f$filterIsInstanceTo22 = iterable3;
        Collection collection = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv2) {
            EntityLivingBase it = (EntityLivingBase)element$iv$iv;
            boolean bl7 = false;
            if (!($this$update.getPlayer().func_70032_d((Entity)it) <= ((Number)this.getModule().getRotationRangeValue().get()).floatValue())) continue;
            collection.add(element$iv$iv);
        }
        Iterable $i$f$filter22 = (List)collection;
        boolean $i$f$sortedBy = false;
        List list6 = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(this, $this$update){
            final /* synthetic */ KillAuraTargetManager this$0;
            final /* synthetic */ SafeListenerBase $this_update$inlined;
            {
                this.this$0 = killAuraTargetManager;
                this.$this_update$inlined = safeListenerBase;
            }

            /*
             * Unable to fully structure code
             */
            public final int compare(T a, T b) {
                block21: {
                    block20: {
                        block19: {
                            block18: {
                                block17: {
                                    block16: {
                                        it = (EntityLivingBase)a;
                                        $i$a$-sortedBy-KillAuraTargetManager$update$5 = false;
                                        var5_5 = (String)this.this$0.priorityValue.get();
                                        switch (var5_5.hashCode()) {
                                            case -2137395588: {
                                                if (var5_5.equals("Health")) break;
                                                ** break;
                                            }
                                            case -1415550666: {
                                                if (!var5_5.equals("LivingTime")) {
                                                    ** break;
                                                }
                                                break block16;
                                            }
                                            case 567390779: {
                                                if (!var5_5.equals("HurtResistantTime")) {
                                                    ** break;
                                                }
                                                break block17;
                                            }
                                            case 353103893: {
                                                if (!var5_5.equals("Distance")) ** break;
                                                v0 = this.$this_update$inlined.getPlayer().func_70032_d((Entity)it);
                                                break block18;
                                            }
                                        }
                                        v0 = it.func_110143_aJ();
                                        break block18;
                                    }
                                    v0 = -((float)it.field_70173_aa);
                                    break block18;
                                }
                                v0 = it.field_70172_ad;
                                break block18;
lbl28:
                                // 5 sources

                                v0 = 0.0f;
                            }
                            it = (EntityLivingBase)b;
                            var6_6 = Float.valueOf(v0);
                            $i$a$-sortedBy-KillAuraTargetManager$update$5 = false;
                            var5_5 = (String)this.this$0.priorityValue.get();
                            switch (var5_5.hashCode()) {
                                case -2137395588: {
                                    if (var5_5.equals("Health")) break;
                                    ** break;
                                }
                                case -1415550666: {
                                    if (!var5_5.equals("LivingTime")) {
                                        ** break;
                                    }
                                    break block19;
                                }
                                case 567390779: {
                                    if (!var5_5.equals("HurtResistantTime")) {
                                        ** break;
                                    }
                                    break block20;
                                }
                                case 353103893: {
                                    if (!var5_5.equals("Distance")) ** break;
                                    v1 = this.$this_update$inlined.getPlayer().func_70032_d((Entity)it);
                                    break block21;
                                }
                            }
                            v1 = it.func_110143_aJ();
                            break block21;
                        }
                        v1 = -((float)it.field_70173_aa);
                        break block21;
                    }
                    v1 = it.field_70172_ad;
                    break block21;
lbl59:
                    // 5 sources

                    v1 = 0.0f;
                }
                return ComparisonsKt.compareValues(var6_6, (Comparable)Float.valueOf(v1));
            }
        });
        if (list6 == null) return;
        List list7 = list6;
        boolean bl8 = false;
        Object object = (String)this.modeValue.get();
        List list8 = Intrinsics.areEqual(object, "Last") || Intrinsics.areEqual(object, "Reverse") ? CollectionsKt.reversed(list7) : list7;
        if (list8 == null) return;
        Iterable iterable4 = list8;
        boolean $i$f$filter = false;
        object = iterable4;
        Collection destination$iv$iv2 = new ArrayList();
        boolean $i$f$filterTo2 = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            boolean bl9;
            EntityLivingBase it = (EntityLivingBase)element$iv$iv;
            boolean bl10 = false;
            String string = (String)this.modeValue.get();
            if (Intrinsics.areEqual(string, "Sequential") || Intrinsics.areEqual(string, "Reverse")) {
                Object object2 = this.prevTarget;
                if (object2 == null || (object2 = object2.func_110124_au()) == null) {
                    object2 = it.func_110124_au();
                }
                if (Intrinsics.areEqual(object2, it.func_110124_au())) {
                    canSelectNext = true;
                    prevTargets.add(it);
                    bl9 = false;
                } else if (canSelectNext) {
                    bl9 = true;
                } else {
                    prevTargets.add(it);
                    bl9 = false;
                }
            } else {
                bl9 = true;
            }
            if (!bl9) continue;
            destination$iv$iv2.add(element$iv$iv);
        }
        List<EntityLivingBase> it = (List<EntityLivingBase>)destination$iv$iv2;
        boolean bl11 = false;
        if (Intrinsics.areEqual((String)this.modeValue.get(), "Random")) {
            EntityLivingBase[] entityLivingBaseArray = new EntityLivingBase[]{CollectionsKt.random((Collection)it, Random.Default)};
            list3 = CollectionsKt.mutableListOf(entityLivingBaseArray);
        } else {
            list3 = it;
        }
        if ((list2 = list3) == null) return;
        it = list = list2;
        boolean bl12 = false;
        this.targets.clear();
        this.targets.addAll((Collection<EntityLivingBase>)it);
        this.targets.addAll(prevTargets);
    }

    public final void reset() {
        this.targets.clear();
        this.prevTarget = null;
    }

    private static final boolean update$lambda$0(KillAuraTargetManager this$0, Entity it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.getModule().isEnemy(it);
    }
}

