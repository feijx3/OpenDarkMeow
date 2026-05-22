/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.item.ItemBow
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.util.EnumHand
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.noslows.modules.bow;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import net.minecraft.item.ItemBow;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumHand;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH\u0007\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/bow/NoSlowBlockingModeMotionChangeSlot;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/NoSlowSubMode;", "<init>", "()V", "onSlowDown", "", "event", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "onMotion", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nNoSlowBlockingModeMotionChangeSlot.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoSlowBlockingModeMotionChangeSlot.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/bow/NoSlowBlockingModeMotionChangeSlot\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,42:1\n12434#2,2:43\n*S KotlinDebug\n*F\n+ 1 NoSlowBlockingModeMotionChangeSlot.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/bow/NoSlowBlockingModeMotionChangeSlot\n*L\n27#1:43,2\n*E\n"})
public final class NoSlowBlockingModeMotionChangeSlot
extends NoSlowSubMode {
    public NoSlowBlockingModeMotionChangeSlot() {
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
        block8: {
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
                break block8;
            }
            bl2 = true;
        }
        if (bl2) {
            switch (WhenMappings.$EnumSwitchMapping$0[event.getEventState().ordinal()]) {
                case 1: {
                    int curSlot = player.field_71071_by.field_70461_c;
                    int spoof = curSlot == 0 ? 1 : -1;
                    connection.func_147297_a((Packet)new CPacketHeldItemChange(curSlot + spoof));
                    connection.func_147297_a((Packet)new CPacketPlayerTryUseItem(EnumHand.OFF_HAND));
                    connection.func_147297_a((Packet)new CPacketHeldItemChange(curSlot));
                    break;
                }
                case 2: {
                    connection.func_147297_a((Packet)new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[EventState.values().length];
            try {
                nArray[EventState.PRE.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[EventState.POST.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

