/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.world;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.input.RightClickMouseEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="AirPlace", category=ModuleCategory.WORLD)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/AirPlace;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "rangeValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "onRightClick", "", "event", "Lnet/ccbluex/liquidbounce/event/events/input/RightClickMouseEvent;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nAirPlace.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AirPlace.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/AirPlace\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,45:1\n1#2:46\n*E\n"})
public final class AirPlace
extends Module {
    @NotNull
    private final FloatValue rangeValue = new FloatValue("Range", 2.5f, 1.0f, 10.0f);

    public AirPlace() {
        super(null, null, null, null, 15, null);
    }

    @EventTarget
    public final void onRightClick(@NotNull RightClickMouseEvent event) {
        block4: {
            Entity entity;
            Entity entity2;
            Intrinsics.checkNotNullParameter(event, "event");
            WorldClient worldClient = MinecraftInstance.mc.getWorld();
            if (worldClient == null) {
                return;
            }
            WorldClient world = worldClient;
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null) {
                return;
            }
            EntityPlayerSP player = entityPlayerSP;
            Entity entity3 = MinecraftInstance.mc.getRenderViewEntity();
            if (entity3 == null) break block4;
            Entity it = entity2 = entity3;
            boolean bl2 = false;
            RayTraceResult rayTraceResult = MinecraftInstance.mc.getObjectMouseOver();
            Object object = entity = (rayTraceResult != null ? rayTraceResult.field_72313_a : null) == RayTraceResult.Type.MISS ? entity2 : null;
            if (entity != null) {
                Vec3d vec3d;
                Vec3d vec3d2;
                Entity viewEntity = entity2 = entity;
                boolean bl3 = false;
                Vec3d it2 = vec3d2 = viewEntity.func_174824_e(1.0f).func_178787_e(viewEntity.func_70040_Z().func_186678_a((double)((Number)this.rangeValue.get()).floatValue()));
                boolean bl4 = false;
                Object object2 = vec3d = player.func_184614_ca().func_77973_b() instanceof ItemBlock ? vec3d2 : null;
                if (vec3d != null) {
                    Vec3d pos = vec3d2 = vec3d;
                    boolean bl5 = false;
                    MinecraftInstance.mc.getPlayerController().func_187099_a(player, world, new BlockPos(pos), EnumFacing.DOWN, pos, EnumHand.MAIN_HAND);
                }
            }
        }
    }
}

