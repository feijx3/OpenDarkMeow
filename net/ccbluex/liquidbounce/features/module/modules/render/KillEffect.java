/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.event.events.controller.ControllerUseEntityAttackEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.modules.render.kill_effects.KillEffectMode;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0013H\u0007J$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/KillEffect;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modes", "", "", "Lnet/ccbluex/liquidbounce/features/module/modules/render/kill_effects/KillEffectMode;", "attacks", "", "Lnet/minecraft/entity/EntityLivingBase;", "onDisable", "", "onControllerUseEntityAttack", "event", "Lnet/ccbluex/liquidbounce/event/events/controller/ControllerUseEntityAttackEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "onWorld", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "onEntityDeath", "", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "world", "Lnet/minecraft/client/multiplayer/WorldClient;", "entity", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nKillEffect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KillEffect.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/KillEffect\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,90:1\n1#2:91\n1#2:105\n1563#3:92\n1634#3,3:93\n1056#3:96\n1869#3:97\n1869#3,2:98\n1870#3:100\n774#3:101\n865#3,2:102\n2756#3:104\n*S KotlinDebug\n*F\n+ 1 KillEffect.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/KillEffect\n*L\n89#1:105\n26#1:92\n26#1:93,3\n27#1:96\n28#1:97\n36#1:98,2\n28#1:100\n88#1:101\n88#1:102,2\n89#1:104\n*E\n"})
public final class KillEffect
extends Module {
    @NotNull
    private final Map<String, KillEffectMode> modes = new LinkedHashMap();
    @NotNull
    private Set<EntityLivingBase> attacks;

    /*
     * WARNING - void declaration
     */
    public KillEffect() {
        super("KillEffect", ModuleCategory.RENDER, null, null, 12, null);
        List<Class<KillEffectMode>> list;
        List<Class<KillEffectMode>> list2;
        List<Class<KillEffectMode>> it = list2 = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".kill_effects.impl", KillEffectMode.class);
        boolean bl2 = false;
        List<Class<KillEffectMode>> list3 = list = !((Collection)it).isEmpty() ? list2 : null;
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
                collection.add((KillEffectMode)it2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Iterable $i$f$map22 = (List)destination$iv$iv;
            boolean $i$f$sortedBy = false;
            List list4 = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    KillEffectMode it = (KillEffectMode)a2;
                    boolean bl2 = false;
                    Comparable comparable = (Comparable)((Object)it.getName());
                    it = (KillEffectMode)b2;
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
                    KillEffectMode it3 = (KillEffectMode)element$iv;
                    boolean bl4 = false;
                    BoolValue modulesMode2 = new BoolValue(it3.getName(), false);
                    it3.setInstance(this);
                    it3.setLinkedStatValue(modulesMode2);
                    this.getValues().add(modulesMode2);
                    Iterable $this$forEach$iv2 = it3.getValues();
                    boolean $i$f$forEach2 = false;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        Value value = (Value)element$iv2;
                        boolean bl5 = false;
                        value.setName(it3.getName() + value.getName());
                        if (value.getSuperValue() == null) {
                            value.setSuperValue(modulesMode2);
                        }
                        this.getValues().add(value);
                    }
                    this.modes.put(it3.getName(), it3);
                }
            }
        }
        this.attacks = new LinkedHashSet();
    }

    @Override
    public void onDisable() {
        this.attacks.clear();
    }

    @EventTarget
    public final void onControllerUseEntityAttack(@NotNull ControllerUseEntityAttackEvent event) {
        block1: {
            EntityLivingBase entityLivingBase;
            EntityLivingBase entityLivingBase2;
            Intrinsics.checkNotNullParameter(event, "event");
            Entity entity = event.getTarget();
            EntityLivingBase entityLivingBase3 = entityLivingBase2 = entity instanceof EntityLivingBase ? (EntityLivingBase)entity : null;
            if (entityLivingBase2 == null) break block1;
            EntityLivingBase it = entityLivingBase = entityLivingBase2;
            boolean bl2 = false;
            Object object = entity = it.func_70089_S() ? entityLivingBase : null;
            if (entity != null) {
                it = entityLivingBase = entity;
                boolean bl3 = false;
                this.attacks.add(it);
            }
        }
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        WorldClient worldClient = MinecraftInstance.mc.getWorld();
        if (worldClient == null) {
            return;
        }
        WorldClient world = worldClient;
        this.attacks.removeIf(arg_0 -> KillEffect.onUpdate$lambda$8(arg_0 -> KillEffect.onUpdate$lambda$7(this, event, world, arg_0), arg_0));
    }

    @EventTarget
    public final void onWorld(@NotNull WorldEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.attacks.clear();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final List<KillEffectMode> onEntityDeath(@NotNull EntityPlayerSP player, @NotNull WorldClient world, @NotNull EntityLivingBase entity) {
        void $this$onEach$iv;
        KillEffectMode it;
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv;
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(world, "world");
        Intrinsics.checkNotNullParameter(entity, "entity");
        Iterable iterable = this.modes.values();
        boolean $i$f$filter = false;
        void var6_6 = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            it = (KillEffectMode)element$iv$iv;
            boolean bl2 = false;
            if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $this$filter$iv = (List)destination$iv$iv;
        boolean $i$f$onEach = false;
        void $this$onEach_u24lambda_u2418$iv = var6_6 = $this$onEach$iv;
        boolean bl3 = false;
        for (Object element$iv : $this$onEach_u24lambda_u2418$iv) {
            it = (KillEffectMode)element$iv;
            boolean bl4 = false;
            it.render(player, world, entity);
        }
        return (List)var6_6;
    }

    private static final boolean onUpdate$lambda$7(KillEffect this$0, UpdateEvent $event, WorldClient $world, EntityLivingBase other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (!other.func_70089_S()) {
            this$0.onEntityDeath($event.getPlayer(), $world, other);
            return true;
        }
        return false;
    }

    private static final boolean onUpdate$lambda$8(Function1 $tmp0, Object p0) {
        return (Boolean)$tmp0.invoke(p0);
    }
}

