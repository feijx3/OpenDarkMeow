/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.Unpooled
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.inventory.Container
 *  net.minecraft.item.ItemBow
 *  net.minecraft.item.ItemEgg
 *  net.minecraft.item.ItemEndCrystal
 *  net.minecraft.item.ItemEnderPearl
 *  net.minecraft.item.ItemExpBottle
 *  net.minecraft.item.ItemFishingRod
 *  net.minecraft.item.ItemFood
 *  net.minecraft.item.ItemPotion
 *  net.minecraft.item.ItemSnowball
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.network.Packet
 *  net.minecraft.network.PacketBuffer
 *  net.minecraft.network.play.client.CPacketCustomPayload
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.util.NonNullList
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.noslows.modules.bow;

import io.netty.buffer.Unpooled;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.ccbluex.liquidbounce.event.EventState;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.MotionEvent;
import net.ccbluex.liquidbounce.features.module.modules.movement.noslows.NoSlowSubMode;
import net.ccbluex.liquidbounce.injection.extend.ExtendKeyBinding;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemEndCrystal;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.item.ItemExpBottle;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.CPacketCustomPayload;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.util.NonNullList;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH\u0007J\u000f\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002\u00a2\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u00a8\u0006\u0011"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/bow/NoSlowBowModeMotionChangeSlot;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/NoSlowSubMode;", "<init>", "()V", "onSlowDown", "", "event", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "onMotion", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "findNonInteractiveSlot", "", "()Ljava/lang/Integer;", "isValidSlot", "", "stack", "Lnet/minecraft/item/ItemStack;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nNoSlowBowModeMotionChangeSlot.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoSlowBowModeMotionChangeSlot.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/bow/NoSlowBowModeMotionChangeSlot\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,73:1\n12434#2,2:74\n785#3:76\n796#3:77\n1878#3,2:78\n797#3,2:80\n1880#3:82\n799#3:83\n1573#3:84\n1604#3,4:85\n295#3,2:89\n*S KotlinDebug\n*F\n+ 1 NoSlowBowModeMotionChangeSlot.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/bow/NoSlowBowModeMotionChangeSlot\n*L\n29#1:74,2\n46#1:76\n46#1:77\n46#1:78,2\n46#1:80,2\n46#1:82\n46#1:83\n49#1:84\n49#1:85,4\n52#1:89,2\n*E\n"})
public final class NoSlowBowModeMotionChangeSlot
extends NoSlowSubMode {
    public NoSlowBowModeMotionChangeSlot() {
        super("MotionChangeSlot");
    }

    @Override
    public void onSlowDown(@NotNull CancellableEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        event.cancelEvent();
    }

    /*
     * WARNING - void declaration
     */
    @EventTarget(ignoreCanceled=true, priority=0)
    public final void onMotion(@NotNull MotionEvent event) {
        boolean bl2;
        EntityPlayerSP player;
        NetHandlerPlayClient connection;
        block6: {
            void $this$all$iv;
            Intrinsics.checkNotNullParameter(event, "event");
            NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc.getConnection();
            if (netHandlerPlayClient == null) {
                return;
            }
            connection = netHandlerPlayClient;
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null) {
                return;
            }
            player = entityPlayerSP;
            Boolean[] booleanArray = new Boolean[2];
            booleanArray[0] = DarkMeow.INSTANCE.getInventoryManager().getHeldItemMainHand().func_77973_b() instanceof ItemBow;
            KeyBinding keyBinding = MinecraftInstance.mc.getGameSettings().field_74313_G;
            Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindUseItem");
            booleanArray[1] = ExtendKeyBinding.INSTANCE.getPressed(keyBinding);
            boolean $i$f$all = false;
            for (void element$iv : $this$all$iv) {
                boolean it = element$iv.booleanValue();
                boolean bl3 = false;
                if (it) continue;
                bl2 = false;
                break block6;
            }
            bl2 = true;
        }
        if (bl2 && event.getEventState() == EventState.PRE) {
            int curSlot = player.field_71071_by.field_70461_c;
            Integer validSlot = this.findNonInteractiveSlot();
            if (validSlot != null) {
                int n2 = curSlot;
                if (validSlot != n2) {
                    connection.func_147297_a((Packet)new CPacketHeldItemChange(validSlot.intValue()));
                    connection.func_147297_a((Packet)new CPacketCustomPayload("=w=", new PacketBuffer(Unpooled.buffer())));
                    connection.func_147297_a((Packet)new CPacketHeldItemChange(curSlot));
                }
            }
        }
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final Integer findNonInteractiveSlot() {
        Object v1;
        block5: {
            void $this$firstOrNull$iv;
            void $this$mapIndexedTo$iv$iv;
            void $this$mapIndexed$iv;
            void $this$filterIndexedTo$iv$iv;
            void $this$filterIndexed$iv;
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null) return null;
            Container container = entityPlayerSP.field_71069_bz;
            if (container == null) return null;
            NonNullList nonNullList = container.func_75138_a();
            if (nonNullList == null) return null;
            Iterable iterable = (Iterable)nonNullList;
            boolean $i$f$filterIndexed22 = false;
            void var6_7 = $this$filterIndexed$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterIndexedTo = false;
            void $this$forEachIndexed$iv$iv$iv = $this$filterIndexedTo$iv$iv;
            boolean $i$f$forEachIndexed = false;
            int index$iv$iv$iv = 0;
            for (Object item$iv$iv$iv : $this$forEachIndexed$iv$iv$iv) {
                void element$iv$iv;
                int n2;
                if ((n2 = index$iv$iv$iv++) < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Object t2 = item$iv$iv$iv;
                int index$iv$iv = n2;
                boolean bl2 = false;
                ItemStack cfr_ignored_0 = (ItemStack)element$iv$iv;
                int index = index$iv$iv;
                boolean bl3 = false;
                boolean bl4 = 36 <= index ? index < 45 : false;
                if (!bl4) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            Iterable $i$f$filterIndexed22 = (List)destination$iv$iv;
            boolean $i$f$mapIndexed22 = false;
            destination$iv$iv = $this$mapIndexed$iv;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
            boolean $i$f$mapIndexedTo = false;
            int index$iv$iv = 0;
            for (Object item$iv$iv : $this$mapIndexedTo$iv$iv) {
                void stack;
                void index;
                int n3;
                if ((n3 = index$iv$iv++) < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ItemStack itemStack = (ItemStack)item$iv$iv;
                int element$iv$iv = n3;
                Collection collection = destination$iv$iv2;
                boolean bl5 = false;
                collection.add(TuplesKt.to((int)index, stack));
            }
            Iterable $i$f$mapIndexed22 = (List)destination$iv$iv2;
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                Pair pair = (Pair)element$iv;
                boolean bl6 = false;
                ItemStack stack = (ItemStack)pair.component2();
                Intrinsics.checkNotNull(stack);
                if (!this.isValidSlot(stack)) continue;
                v1 = element$iv;
                break block5;
            }
            v1 = null;
        }
        Pair pair = v1;
        if (pair == null) return null;
        Integer n4 = (Integer)pair.getFirst();
        return n4;
    }

    private final boolean isValidSlot(ItemStack stack) {
        return !(stack.func_77973_b() instanceof ItemSword) && !(stack.func_77973_b() instanceof ItemBow) && !(stack.func_77973_b() instanceof ItemEgg) && !(stack.func_77973_b() instanceof ItemEndCrystal) && !(stack.func_77973_b() instanceof ItemEnderPearl) && !(stack.func_77973_b() instanceof ItemExpBottle) && !(stack.func_77973_b() instanceof ItemFishingRod) && !(stack.func_77973_b() instanceof ItemFood) && !(stack.func_77973_b() instanceof ItemPotion) && !(stack.func_77973_b() instanceof ItemSnowball);
    }
}

