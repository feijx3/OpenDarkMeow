/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityBoat
 *  net.minecraft.entity.item.EntityExpBottle
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityItemFrame
 *  net.minecraft.entity.item.EntityMinecart
 *  net.minecraft.entity.item.EntityTNTPrimed
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.projectile.EntityEgg
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.entity.projectile.EntityFishHook
 *  net.minecraft.entity.projectile.EntitySnowball
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.noslows.modules.bow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.modules.exploit.Disabler;
import net.ccbluex.liquidbounce.features.module.modules.movement.noslows.NoSlowSubMode;
import net.ccbluex.liquidbounce.handler.combat.CombatManager;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.minecraft.enums.EnumAnimationMode;
import net.ccbluex.liquidbounce.utils.minecraft.enums.EnumAttackEntityMode;
import net.ccbluex.liquidbounce.value.Value;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.projectile.EntitySnowball;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u000eH\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/bow/NoSlowBowModeGrimAttack;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/NoSlowSubMode;", "<init>", "()V", "canNoSlow", "", "doatk", "onEnable", "", "canEnable", "onSlowDown", "event", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "findEntity", "Lnet/minecraft/entity/Entity;", "world", "Lnet/minecraft/client/multiplayer/WorldClient;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nNoSlowBowModeGrimAttack.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoSlowBowModeGrimAttack.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/bow/NoSlowBowModeGrimAttack\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,89:1\n1#2:90\n774#3:91\n865#3,2:92\n295#3:94\n296#3:97\n12637#4,2:95\n*S KotlinDebug\n*F\n+ 1 NoSlowBowModeGrimAttack.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/bow/NoSlowBowModeGrimAttack\n*L\n72#1:91\n72#1:92,2\n73#1:94\n73#1:97\n86#1:95,2\n*E\n"})
public final class NoSlowBowModeGrimAttack
extends NoSlowSubMode {
    private boolean canNoSlow;
    private boolean doatk;

    public NoSlowBowModeGrimAttack() {
        super("GrimAttack");
    }

    @Override
    public void onEnable() {
        if (!this.canEnable()) {
            DarkMeow.INSTANCE.getMessageManager().display.displayError("NoSlow\\Bow\\GrimAttack \u9700\u8981\u914d\u5408 Disabler\\GrimPost \u624d\u80fd\u4f7f\u7528 \u8bf7\u5148\u542f\u7528");
        }
        this.canNoSlow = false;
        this.doatk = false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean canEnable() {
        Disabler disabler = DarkMeow.INSTANCE.getModuleManager().get(Disabler.class);
        if (disabler == null) return false;
        Disabler it = disabler;
        boolean bl2 = false;
        if (!it.getState()) return false;
        Value<?> value = it.getValue("GrimPost");
        if (value == null) return false;
        boolean bl3 = Intrinsics.areEqual(value.getValue(), true);
        if (!bl3) return false;
        return true;
    }

    @Override
    public void onSlowDown(@NotNull CancellableEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.doatk = true;
        if (this.canNoSlow) {
            event.cancelEvent();
            this.canNoSlow = false;
        }
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.doatk) {
            WorldClient worldClient = MinecraftInstance.mc.getWorld();
            if (worldClient != null) {
                WorldClient it = worldClient;
                boolean bl2 = false;
                Entity entity = this.findEntity(it);
                if (entity != null) {
                    Entity entity2;
                    Entity entity3 = entity2 = entity;
                    boolean bl3 = false;
                    int n2 = 2;
                    int n3 = 0;
                    while (n3 < n2) {
                        int it2 = n3++;
                        boolean bl4 = false;
                        CombatManager.attackEntity$default(DarkMeow.INSTANCE.getCombatManager(), entity3, EnumAnimationMode.PACKET, null, EnumAttackEntityMode.PACKET, false, 20, null);
                    }
                    this.canNoSlow = true;
                }
            }
            this.doatk = false;
        }
    }

    /*
     * WARNING - void declaration
     */
    private final Entity findEntity(WorldClient world) {
        Object v2;
        block4: {
            void $this$filterTo$iv$iv;
            List list = world.field_72996_f;
            Intrinsics.checkNotNullExpressionValue(list, "loadedEntityList");
            Iterable $this$filter$iv = list;
            boolean $i$f$filter = false;
            Iterable iterable = $this$filter$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                Entity entity = (Entity)element$iv$iv;
                boolean bl2 = false;
                if (!(!entity.field_70128_L)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            Iterable $this$firstOrNull$iv = (List)destination$iv$iv;
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                boolean bl3;
                block3: {
                    void $this$any$iv;
                    Object element$iv$iv;
                    Entity entity = (Entity)element$iv;
                    boolean bl4 = false;
                    element$iv$iv = new Boolean[]{entity instanceof EntityItem, entity instanceof EntityXPOrb, entity instanceof EntityItemFrame, entity instanceof EntityMinecart, entity instanceof EntityBoat, entity instanceof EntityTNTPrimed, entity instanceof EntitySnowball, entity instanceof EntityEgg, entity instanceof EntityExpBottle, entity instanceof EntityFishHook, entity instanceof EntityFireball};
                    boolean $i$f$any = false;
                    for (void element$iv2 : $this$any$iv) {
                        boolean it = element$iv2.booleanValue();
                        boolean bl5 = false;
                        if (!it) continue;
                        bl3 = true;
                        break block3;
                    }
                    bl3 = false;
                }
                if (!bl3) continue;
                v2 = element$iv;
                break block4;
            }
            v2 = null;
        }
        return v2;
    }
}

