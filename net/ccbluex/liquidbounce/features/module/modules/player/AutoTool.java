/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.player;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.controller.ControllerDestroyBlockEvent;
import net.ccbluex.liquidbounce.event.events.player.control.UpdateMouseOverEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ModuleInfo(name="AutoTool", category=ModuleCategory.PLAYER)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rH\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/AutoTool;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "silentValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "lastBlockPos", "Lnet/minecraft/util/math/BlockPos;", "onControllerDestroyBlock", "", "event", "Lnet/ccbluex/liquidbounce/event/events/controller/ControllerDestroyBlockEvent;", "onUpdateMouseOverPost", "Lnet/ccbluex/liquidbounce/event/events/player/control/UpdateMouseOverEvent$POST;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nAutoTool.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutoTool.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/AutoTool\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,70:1\n1#2:71\n*E\n"})
public final class AutoTool
extends Module {
    @JvmField
    @NotNull
    public final BoolValue silentValue = new BoolValue("Silent", false);
    @Nullable
    private BlockPos lastBlockPos;

    public AutoTool() {
        super(null, null, null, null, 15, null);
    }

    @EventTarget
    public final void onControllerDestroyBlock(@NotNull ControllerDestroyBlockEvent event) {
        block5: {
            Integer n2;
            Intrinsics.checkNotNullParameter(event, "event");
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null) {
                return;
            }
            EntityPlayerSP player = entityPlayerSP;
            WorldClient worldClient = MinecraftInstance.mc.getWorld();
            if (worldClient == null) {
                return;
            }
            WorldClient world = worldClient;
            IBlockState state = world.func_180495_p(event.getPos());
            boolean bl2 = false;
            float bestSpeed = 1.0f;
            Integer bestSlot = null;
            for (int i2 = 0; i2 < 9; ++i2) {
                ItemStack item = player.field_71071_by.func_70301_a(i2);
                float speed = item.func_150997_a(state);
                if (!(speed > bestSpeed)) continue;
                bestSpeed = speed;
                bestSlot = i2;
            }
            Integer n3 = bestSlot;
            if (n3 == null) break block5;
            Integer n4 = n3;
            int it = ((Number)n4).intValue();
            boolean bl3 = false;
            Integer n5 = n2 = it != player.field_71071_by.field_70461_c ? n4 : null;
            if (n2 != null) {
                n4 = n2;
                int slot = ((Number)n4).intValue();
                boolean bl4 = false;
                if (((Boolean)this.silentValue.get()).booleanValue()) {
                    DarkMeow.INSTANCE.getInventoryManager().currentSpoofSlot = player.field_71071_by.field_70461_c;
                }
                this.lastBlockPos = event.getPos();
                player.field_71071_by.field_70461_c = slot;
            }
        }
    }

    @EventTarget
    public final void onUpdateMouseOverPost(@NotNull UpdateMouseOverEvent.POST event) {
        block4: {
            Object object;
            Intrinsics.checkNotNullParameter(event, "event");
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null) {
                return;
            }
            EntityPlayerSP player = entityPlayerSP;
            Object object2 = event.getReturnValue();
            RayTraceResult it = (RayTraceResult)object2;
            boolean bl2 = false;
            RayTraceResult rayTraceResult = (RayTraceResult)((Boolean)this.silentValue.get() != false ? object2 : null);
            if (rayTraceResult == null) break block4;
            RayTraceResult it2 = object = rayTraceResult;
            boolean bl3 = false;
            Object object3 = object2 = this.lastBlockPos != null ? object : null;
            if (object2 != null) {
                Object object4;
                Object it3 = object4 = object2;
                boolean bl4 = false;
                Object object5 = object = !Intrinsics.areEqual(it3.func_178782_a(), this.lastBlockPos) ? object4 : null;
                if (object != null) {
                    Object it4 = object;
                    boolean bl5 = false;
                    object4 = DarkMeow.INSTANCE.getInventoryManager().currentSpoofSlot;
                    if (object4 != null) {
                        Object object6 = object4;
                        int slot = ((Number)object6).intValue();
                        boolean bl6 = false;
                        player.field_71071_by.field_70461_c = slot;
                        DarkMeow.INSTANCE.getInventoryManager().currentSpoofSlot = null;
                        this.lastBlockPos = null;
                    }
                }
            }
        }
    }
}

