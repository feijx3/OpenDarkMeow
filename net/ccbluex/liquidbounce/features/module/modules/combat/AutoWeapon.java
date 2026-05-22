/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.ai.attributes.AttributeModifier
 *  net.minecraft.init.Enchantments
 *  net.minecraft.inventory.EntityEquipmentSlot
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.network.play.client.CPacketUseEntity$Action
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.event.events.controller.ControllerUseEntityAttackEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.features.module.modules.combat.AutoWeapon;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketUseEntity;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="AutoWeapon", description="\u81ea\u52a8\u6362\u53d6\u66f4\u52a0\u6709\u80fd\u7684\u624b\u6301\u7269.", category=ModuleCategory.COMBAT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/AutoWeapon;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "silentValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "ticks", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "attackEnemy", "", "spoofedSlot", "", "onAttack", "", "event", "Lnet/ccbluex/liquidbounce/event/events/controller/ControllerUseEntityAttackEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "update", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "WeaponScore", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nAutoWeapon.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutoWeapon.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/AutoWeapon\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,86:1\n1617#2,9:87\n1869#2:96\n1870#2:98\n1626#2:99\n1#3:97\n*S KotlinDebug\n*F\n+ 1 AutoWeapon.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/AutoWeapon\n*L\n46#1:87,9\n46#1:96\n46#1:98\n46#1:99\n46#1:97\n*E\n"})
public final class AutoWeapon
extends Module {
    @NotNull
    private final BoolValue silentValue = new BoolValue("Silent", true);
    @NotNull
    private final IntegerValue ticks = new IntegerValue("Ticks", 10, 1, 20);
    private boolean attackEnemy;
    private int spoofedSlot;

    public AutoWeapon() {
        super(null, null, null, null, 15, null);
    }

    @EventTarget
    public final void onAttack(@NotNull ControllerUseEntityAttackEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.attackEnemy = true;
    }

    /*
     * WARNING - void declaration
     */
    @EventTarget
    public final void onPacket(@NotNull PacketEvent event) {
        void $this$mapNotNullTo$iv$iv;
        void $this$mapNotNull$iv;
        Intrinsics.checkNotNullParameter(event, "event");
        if (!(event.getPacket() instanceof CPacketUseEntity) || ((CPacketUseEntity)event.getPacket()).func_149565_c() != CPacketUseEntity.Action.ATTACK || !this.attackEnemy) {
            return;
        }
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        this.attackEnemy = false;
        Iterable iterable = new IntRange(0, 8);
        boolean $i$f$mapNotNull = false;
        void var6_5 = $this$mapNotNull$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
        while (iterator2.hasNext()) {
            int element$iv$iv$iv;
            int element$iv$iv = element$iv$iv$iv = ((IntIterator)iterator2).nextInt();
            boolean bl2 = false;
            int it = element$iv$iv;
            boolean bl3 = false;
            Pair<Integer, ItemStack> it$iv$iv = new Pair<Integer, ItemStack>(it, player.field_71071_by.func_70301_a(it));
            boolean bl4 = false;
            destination$iv$iv.add(it$iv$iv);
        }
        Pair pair = (Pair)CollectionsKt.maxWithOrNull((List)destination$iv$iv, new Comparator(){

            public final int compare(T a2, T b2) {
                Pair it = (Pair)a2;
                boolean bl2 = false;
                int knockbackLevel = EnchantmentHelper.func_77506_a((Enchantment)Enchantments.field_180313_o, (ItemStack)((ItemStack)it.getSecond()));
                Collection collection = ((ItemStack)it.getSecond()).func_111283_C(EntityEquipmentSlot.MAINHAND).get((Object)"generic.attackDamage");
                Intrinsics.checkNotNullExpressionValue(collection, "get(...)");
                AttributeModifier attributeModifier = (AttributeModifier)CollectionsKt.firstOrNull(collection);
                double damage = attributeModifier != null ? attributeModifier.func_111164_d() : 0.0;
                it = (Pair)b2;
                Comparable comparable = new WeaponScore(knockbackLevel, damage);
                bl2 = false;
                knockbackLevel = EnchantmentHelper.func_77506_a((Enchantment)Enchantments.field_180313_o, (ItemStack)((ItemStack)it.getSecond()));
                Collection collection2 = ((ItemStack)it.getSecond()).func_111283_C(EntityEquipmentSlot.MAINHAND).get((Object)"generic.attackDamage");
                Intrinsics.checkNotNullExpressionValue(collection2, "get(...)");
                AttributeModifier attributeModifier2 = (AttributeModifier)CollectionsKt.firstOrNull(collection2);
                damage = attributeModifier2 != null ? attributeModifier2.func_111164_d() : 0.0;
                return ComparisonsKt.compareValues(comparable, (Comparable)new WeaponScore(knockbackLevel, damage));
            }
        });
        if (pair == null) {
            return;
        }
        Pair bestItem = pair;
        if (((Number)bestItem.getFirst()).intValue() == player.field_71071_by.field_70461_c) {
            return;
        }
        if (((Boolean)this.silentValue.get()).booleanValue()) {
            NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc.getConnection();
            Intrinsics.checkNotNull(netHandlerPlayClient);
            netHandlerPlayClient.func_147297_a((Packet)new CPacketHeldItemChange(((Number)bestItem.getFirst()).intValue()));
            this.spoofedSlot = ((Number)this.ticks.get()).intValue();
        } else {
            player.field_71071_by.field_70461_c = ((Number)bestItem.getFirst()).intValue();
            MinecraftInstance.mc.getPlayerController().func_78765_e();
        }
        NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc.getConnection();
        Intrinsics.checkNotNull(netHandlerPlayClient);
        netHandlerPlayClient.func_147297_a(event.getPacket());
        event.cancelEvent();
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent update) {
        Intrinsics.checkNotNullParameter(update, "update");
        if (this.spoofedSlot > 0) {
            if (this.spoofedSlot == 1) {
                NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc.getConnection();
                Intrinsics.checkNotNull(netHandlerPlayClient);
                EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
                Intrinsics.checkNotNull(entityPlayerSP);
                netHandlerPlayClient.func_147297_a((Packet)new CPacketHeldItemChange(entityPlayerSP.field_71071_by.field_70461_c));
            }
            int n2 = this.spoofedSlot;
            this.spoofedSlot = n2 + -1;
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0000H\u0096\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/AutoWeapon$WeaponScore;", "", "knockbackLevel", "", "damage", "", "<init>", "(ID)V", "getKnockbackLevel", "()I", "getDamage", "()D", "compareTo", "other", "DarkMeow"})
    private static final class WeaponScore
    implements Comparable<WeaponScore> {
        private final int knockbackLevel;
        private final double damage;

        public WeaponScore(int knockbackLevel, double damage) {
            this.knockbackLevel = knockbackLevel;
            this.damage = damage;
        }

        public final int getKnockbackLevel() {
            return this.knockbackLevel;
        }

        public final double getDamage() {
            return this.damage;
        }

        @Override
        public int compareTo(@NotNull WeaponScore other) {
            Intrinsics.checkNotNullParameter(other, "other");
            Function1[] function1Array = new Function1[]{compareTo.1.INSTANCE, compareTo.2.INSTANCE};
            return ComparisonsKt.compareValuesBy(this, other, function1Array);
        }
    }
}

