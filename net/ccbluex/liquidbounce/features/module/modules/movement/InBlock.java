/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.modules.movement.Sprint;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.KeyValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cR\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001d"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/InBlock;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "rangeValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "rangeVerticalValue", "delayValue", "keepYValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "keepYCustomKeyValue", "Lnet/ccbluex/liquidbounce/value/impl/KeyValue;", "modeValue", "cancelSprintValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "y", "", "getY", "()I", "setY", "(I)V", "onEnable", "", "onDisable", "onMovementInput", "event", "Lnet/ccbluex/liquidbounce/event/events/input/MovementInputEvent$PRE;", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nInBlock.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InBlock.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/InBlock\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,117:1\n774#2:118\n865#2,2:119\n1869#2,2:122\n1#3:121\n*S KotlinDebug\n*F\n+ 1 InBlock.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/InBlock\n*L\n87#1:118\n87#1:119,2\n91#1:122,2\n*E\n"})
public final class InBlock
extends Module {
    @JvmField
    @NotNull
    public final IntegerValue rangeValue = new IntegerValue("Range", 1, new IntRange(1, 5));
    @JvmField
    @NotNull
    public final IntegerValue rangeVerticalValue = new IntegerValue("RangeVertical", 1, new IntRange(1, 3));
    @JvmField
    @NotNull
    public final IntegerValue delayValue = new IntegerValue("Delay", 1, new IntRange(0, 20));
    @JvmField
    @NotNull
    public final ListValue keepYValue;
    @JvmField
    @NotNull
    public final KeyValue keepYCustomKeyValue;
    @JvmField
    @NotNull
    public final ListValue modeValue;
    @JvmField
    @NotNull
    public final BoolValue cancelSprintValue;
    private int y;

    public InBlock() {
        super("InBlock", ModuleCategory.MOVEMENT, null, null, 12, null);
        String[] stringArray = new String[]{"Always", "OnlyPressCustomKey", "OnlyNotPressCustomKey", "None"};
        this.keepYValue = new ListValue("KeepY", stringArray, null, 4, null);
        this.keepYCustomKeyValue = new KeyValue("KeepYCustomKey", "RETURN");
        stringArray = new String[]{"Client", "GrimAC"};
        this.modeValue = new ListValue("Mode", stringArray, "GrimAC");
        this.cancelSprintValue = new BoolValue(this){
            final /* synthetic */ InBlock this$0;
            {
                this.this$0 = $receiver;
                super("CancelSprint", true);
            }

            protected void onChanged(boolean oldValue, boolean newValue) {
                if (this.this$0.getState()) {
                    Integer n2;
                    boolean bl2 = newValue;
                    if (bl2) {
                        n2 = Sprint.lockNoSprint$default(this.getName(), null, 2, null);
                    } else if (!bl2) {
                        n2 = Sprint.unlockNoSprint(this.getName());
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
        };
    }

    public final int getY() {
        return this.y;
    }

    public final void setY(int n2) {
        this.y = n2;
    }

    @Override
    public void onEnable() {
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        this.y = MathHelper.func_76128_c((double)player.field_70163_u);
        if (((Boolean)this.cancelSprintValue.get()).booleanValue()) {
            Sprint.lockNoSprint$default(this.getName(), null, 2, null);
        }
    }

    @Override
    public void onDisable() {
        if (((Boolean)this.cancelSprintValue.get()).booleanValue()) {
            Sprint.unlockNoSprint(this.getName());
        }
    }

    /*
     * WARNING - void declaration
     */
    @EventTarget
    public final void onMovementInput(@NotNull MovementInputEvent.PRE event) {
        List list;
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv;
        int n2;
        int currentY;
        Iterable iterable;
        Intrinsics.checkNotNullParameter(event, "event");
        if (DarkMeow.INSTANCE.getUpdateManager().getUpdateId() % ((Number)this.delayValue.get()).longValue() != 0L) {
            return;
        }
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        Set $this$onMovementInput_u24lambda_u240 = iterable = (Set)new LinkedHashSet();
        boolean $i$a$-apply-InBlock$onMovementInput$22 = false;
        this.y = currentY = this.getY(player);
        BlockPos playerPos = new BlockPos(MathHelper.func_76128_c((double)player.field_70165_t), currentY, MathHelper.func_76128_c((double)player.field_70161_v));
        int x2 = -((Number)this.rangeValue.get()).intValue();
        if (x2 <= (n2 = ((Number)this.rangeValue.get()).intValue())) {
            while (true) {
                int n3;
                int y2;
                if ((y2 = event.getKeyStateSneak() ? -1 : 0) <= (n3 = ((Number)this.rangeVerticalValue.get()).intValue())) {
                    while (true) {
                        int n4;
                        int z2;
                        if ((z2 = -((Number)this.rangeValue.get()).intValue()) <= (n4 = ((Number)this.rangeValue.get()).intValue())) {
                            while (true) {
                                BlockPos blockPos = playerPos.func_177982_a(x2, y2, z2);
                                Intrinsics.checkNotNullExpressionValue(blockPos, "add(...)");
                                $this$onMovementInput_u24lambda_u240.add(blockPos);
                                if (z2 == n4) break;
                                ++z2;
                            }
                        }
                        if (y2 == n3) break;
                        ++y2;
                    }
                }
                if (x2 == n2) break;
                ++x2;
            }
        }
        iterable = iterable;
        boolean $i$f$filter = false;
        void $i$a$-apply-InBlock$onMovementInput$22 = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            BlockPos pos = (BlockPos)element$iv$iv;
            boolean bl2 = false;
            if (!(!player.field_70170_p.func_175623_d(pos))) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List it = $this$filter$iv = (List)destination$iv$iv;
        boolean bl3 = false;
        List list2 = list = !((Collection)it).isEmpty() ? $this$filter$iv : null;
        if (list != null) {
            void $this$forEach$iv;
            $this$filter$iv = list;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                BlockPos pos = (BlockPos)element$iv;
                boolean bl4 = false;
                String string = (String)this.modeValue.get();
                if (Intrinsics.areEqual(string, "Client")) {
                    player.field_70170_p.func_175698_g(pos);
                    continue;
                }
                if (!Intrinsics.areEqual(string, "GrimAC")) continue;
                player.field_71174_a.func_147297_a((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, pos, EnumFacing.DOWN));
                player.field_70170_p.func_175698_g(pos);
            }
        }
    }

    public final int getY(@NotNull EntityPlayerSP player) {
        int n2;
        Intrinsics.checkNotNullParameter(player, "player");
        switch ((String)this.keepYValue.get()) {
            case "Always": {
                n2 = this.y;
                break;
            }
            case "OnlyPressCustomKey": {
                if (this.keepYCustomKeyValue.isKeyDown()) {
                    n2 = this.y;
                    break;
                }
                n2 = MathHelper.func_76128_c((double)player.field_70163_u);
                break;
            }
            case "OnlyNotPressCustomKey": {
                if (this.keepYCustomKeyValue.isKeyDown()) {
                    n2 = MathHelper.func_76128_c((double)player.field_70163_u);
                    break;
                }
                n2 = this.y;
                break;
            }
            case "None": {
                n2 = MathHelper.func_76128_c((double)player.field_70163_u);
                break;
            }
            default: {
                n2 = this.y;
            }
        }
        return n2;
    }
}

