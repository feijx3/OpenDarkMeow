/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.network.play.client.CPacketUseEntity$Action
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.misc;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.features.module.modules.combat.KillAura;
import net.ccbluex.liquidbounce.handler.combat.targets.TargetsManager;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.kotlin.HashMapExtensions;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="ReallyHurt", category=ModuleCategory.MISC)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0018H\u0007J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u001aH\u0007J\b\u0010\u001b\u001a\u00020\u0014H\u0016J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R,\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011`\u00128\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020 8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006#"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/ReallyHurt;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "checkTickValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "checkOnlyAllowTargetValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "displayValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "killAuraToggleOffValue", "clearAllowTargetsValue", "count", "", "hitEntities", "Ljava/util/HashMap;", "Lnet/minecraft/entity/EntityLivingBase;", "", "Lkotlin/collections/HashMap;", "onPacket", "", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "onWorld", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "onDisable", "onChecked", "entity", "Lnet/minecraft/entity/Entity;", "tag", "", "getTag", "()Ljava/lang/String;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nReallyHurt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReallyHurt.kt\nnet/ccbluex/liquidbounce/features/module/modules/misc/ReallyHurt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,132:1\n1#2:133\n12637#3,2:134\n12637#3,2:136\n*S KotlinDebug\n*F\n+ 1 ReallyHurt.kt\nnet/ccbluex/liquidbounce/features/module/modules/misc/ReallyHurt\n*L\n72#1:134,2\n87#1:136,2\n*E\n"})
public final class ReallyHurt
extends Module {
    @NotNull
    private final IntegerValue checkTickValue = new IntegerValue("CheckTick", 5, 1, 40);
    @NotNull
    private final BoolValue checkOnlyAllowTargetValue = new BoolValue("CheckOnlyAllowTarget", true);
    @NotNull
    private final ListValue displayValue;
    @NotNull
    private final BoolValue killAuraToggleOffValue;
    @NotNull
    private final BoolValue clearAllowTargetsValue;
    @JvmField
    public int count;
    @JvmField
    @NotNull
    public final HashMap<EntityLivingBase, Long> hitEntities;

    public ReallyHurt() {
        super(null, null, null, null, 15, null);
        String[] stringArray = new String[]{"None", "Flag", "FlagCount", "FlagCountEntityId"};
        this.displayValue = new ListValue("Display", stringArray, "FlagCount");
        this.killAuraToggleOffValue = new BoolValue("KillAuraToggleOff", false);
        this.clearAllowTargetsValue = new BoolValue("ClearAllowTargets", true);
        this.hitEntities = new HashMap();
    }

    /*
     * WARNING - void declaration
     */
    @EventTarget(ignoreCanceled=true, priority=0)
    public final void onPacket(@NotNull PacketEvent event) {
        block7: {
            Intrinsics.checkNotNullParameter(event, "event");
            WorldClient worldClient = MinecraftInstance.mc.getWorld();
            if (worldClient == null) {
                return;
            }
            WorldClient world = worldClient;
            Entity packet = event.getPacket();
            if (!(packet instanceof CPacketUseEntity)) break block7;
            Entity entity = packet;
            CPacketUseEntity it = (CPacketUseEntity)entity;
            boolean bl2 = false;
            CPacketUseEntity cPacketUseEntity = (CPacketUseEntity)(it.func_149565_c() == CPacketUseEntity.Action.ATTACK ? entity : null);
            if (cPacketUseEntity != null && (entity = cPacketUseEntity.func_149564_a((World)world)) != null) {
                Entity it2 = entity;
                boolean bl3 = false;
                EntityLivingBase entityLivingBase = it2 instanceof EntityLivingBase ? (EntityLivingBase)it2 : null;
                if (entityLivingBase != null) {
                    EntityLivingBase entityLivingBase2;
                    EntityLivingBase entityLivingBase3;
                    EntityLivingBase it3 = entityLivingBase3 = entityLivingBase;
                    boolean bl4 = false;
                    Object object = entityLivingBase2 = !this.hitEntities.containsKey(it3) ? entityLivingBase3 : null;
                    if (entityLivingBase2 != null) {
                        boolean bl5;
                        EntityLivingBase it4;
                        EntityLivingBase entityLivingBase4;
                        block6: {
                            void $this$any$iv;
                            it4 = entityLivingBase4 = entityLivingBase2;
                            boolean bl6 = false;
                            Boolean[] booleanArray = new Boolean[]{(Boolean)this.checkOnlyAllowTargetValue.get() == false, TargetsManager.isSelected$default(DarkMeow.INSTANCE.getCombatManager().getTargetsManager(), it4, true, false, 4, null)};
                            boolean $i$f$any = false;
                            for (void element$iv : $this$any$iv) {
                                boolean check = element$iv.booleanValue();
                                boolean bl7 = false;
                                if (!check) continue;
                                bl5 = true;
                                break block6;
                            }
                            bl5 = false;
                        }
                        Object object2 = entityLivingBase3 = bl5 ? entityLivingBase4 : null;
                        if (entityLivingBase3 != null) {
                            it4 = entityLivingBase4 = entityLivingBase3;
                            boolean bl8 = false;
                            ((Map)this.hitEntities).put(it4, DarkMeow.INSTANCE.getUpdateManager().getUpdateId());
                        }
                    }
                }
            }
        }
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        HashMap<EntityLivingBase, Long> hashMap;
        Intrinsics.checkNotNullParameter(event, "event");
        HashMap<EntityLivingBase, Long> $this$onUpdate_u24lambda_u2411 = hashMap = this.hitEntities;
        boolean bl2 = false;
        HashMapExtensions.INSTANCE.removeIf($this$onUpdate_u24lambda_u2411, ReallyHurt::onUpdate$lambda$11$lambda$7);
        HashMapExtensions.INSTANCE.removeIf($this$onUpdate_u24lambda_u2411, arg_0 -> ReallyHurt.onUpdate$lambda$11$lambda$10(this, event, arg_0));
    }

    @EventTarget
    public final void onWorld(@NotNull WorldEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.count = 0;
        this.onDisable();
    }

    @Override
    public void onDisable() {
        this.hitEntities.clear();
    }

    private final void onChecked(Entity entity) {
        int n2 = this.count;
        this.count = n2 + 1;
        if (!Intrinsics.areEqual(this.displayValue.get(), "None")) {
            Object[] objectArray = new String[]{"HurtFailed", Intrinsics.areEqual(this.displayValue.get(), "FlagCount") ? "" + 'x' + this.count : "", Intrinsics.areEqual(this.displayValue.get(), "FlagCountEntityId") ? "(entityId:" + entity.func_145782_y() + ')' : ""};
            DarkMeow.INSTANCE.getMessageManager().display.displayInfo(ArraysKt.joinToString$default(objectArray, (CharSequence)" ", null, null, 0, null, null, 62, null));
        }
        if (((Boolean)this.killAuraToggleOffValue.get()).booleanValue()) {
            KillAura killAura = DarkMeow.INSTANCE.getModuleManager().get(KillAura.class);
            if (killAura != null) {
                killAura.setState(false);
            }
        }
        if (((Boolean)this.clearAllowTargetsValue.get()).booleanValue()) {
            DarkMeow.INSTANCE.getCombatManager().getAllowAttackManager().allows.clear();
        }
    }

    @Override
    @NotNull
    public String getTag() {
        return String.valueOf(this.count);
    }

    private static final boolean onUpdate$lambda$11$lambda$7(Map.Entry entry) {
        boolean bl2;
        block1: {
            Intrinsics.checkNotNullParameter(entry, "<destruct>");
            EntityLivingBase entity = (EntityLivingBase)entry.getKey();
            Boolean[] booleanArray = new Boolean[]{!entity.func_70089_S(), entity.func_110143_aJ() <= 0.0f, entity.field_70737_aN != 0};
            Boolean[] $this$any$iv = booleanArray;
            boolean $i$f$any = false;
            for (Boolean element$iv : $this$any$iv) {
                boolean it = element$iv;
                boolean bl3 = false;
                if (!it) continue;
                bl2 = true;
                break block1;
            }
            bl2 = false;
        }
        return bl2;
    }

    private static final boolean onUpdate$lambda$11$lambda$10(ReallyHurt this$0, UpdateEvent $event, Map.Entry entry) {
        boolean bl2;
        Boolean bl3;
        Intrinsics.checkNotNullParameter(entry, "<destruct>");
        EntityLivingBase entity = (EntityLivingBase)entry.getKey();
        long updateId = ((Number)entry.getValue()).longValue();
        Boolean bl4 = updateId + ((Number)this$0.checkTickValue.get()).longValue() < $event.getUpdateId();
        boolean it = bl4;
        boolean bl5 = false;
        Boolean bl6 = bl3 = it ? bl4 : null;
        if (bl3 != null) {
            Boolean bl7 = bl3;
            boolean it2 = bl7;
            boolean bl8 = false;
            this$0.onChecked((Entity)entity);
            bl2 = bl7;
        } else {
            bl2 = false;
        }
        return bl2;
    }
}

