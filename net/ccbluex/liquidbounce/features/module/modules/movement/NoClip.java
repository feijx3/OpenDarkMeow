/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.AxisAlignedBB
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="NoClip", description="Freely move in block~.", category=ModuleCategory.MOVEMENT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/NoClip;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "resetFallDistanceValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "speedValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "onlyInBlock", "onDisable", "", "onUpdate", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nNoClip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoClip.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/NoClip\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,56:1\n1761#2,3:57\n*S KotlinDebug\n*F\n+ 1 NoClip.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/NoClip\n*L\n28#1:57,3\n*E\n"})
public final class NoClip
extends Module {
    @NotNull
    private final BoolValue resetFallDistanceValue = new BoolValue("ResetFallDistance", true);
    @NotNull
    private final FloatValue speedValue = new FloatValue("Speed", 0.1f, 0.0f, 5.0f);
    @NotNull
    private final BoolValue onlyInBlock = new BoolValue("OnlyInBlock", true);

    public NoClip() {
        super(null, null, null, null, 15, null);
    }

    @Override
    public void onDisable() {
        Intrinsics.checkNotNull(MinecraftInstance.mc.getPlayer());
        MinecraftInstance.mc.getPlayer().field_70145_X = false;
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        float speed;
        boolean bl2;
        block8: {
            Intrinsics.checkNotNullParameter(event, "event");
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null) {
                return;
            }
            EntityPlayerSP player = entityPlayerSP;
            WorldClient worldClient = MinecraftInstance.mc.getWorld();
            Intrinsics.checkNotNull(worldClient);
            WorldClient world = worldClient;
            boolean bl3 = false;
            AxisAlignedBB playerBoundingBox = player.func_174813_aQ();
            List list = world.func_184144_a((Entity)player, playerBoundingBox);
            Intrinsics.checkNotNullExpressionValue(list, "getCollisionBoxes(...)");
            Iterable $this$any$iv = list;
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl2 = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    AxisAlignedBB it = (AxisAlignedBB)element$iv;
                    boolean bl4 = false;
                    if (!it.func_72326_a(playerBoundingBox)) continue;
                    bl2 = true;
                    break block8;
                }
                bl2 = false;
            }
        }
        boolean isInBlock = bl2;
        if (((Boolean)this.onlyInBlock.get()).booleanValue() && !isInBlock) {
            player.field_70145_X = false;
            return;
        }
        player.field_70145_X = true;
        if (((Boolean)this.resetFallDistanceValue.get()).booleanValue()) {
            player.field_70143_R = 0.0f;
        }
        player.field_70122_E = false;
        player.field_71075_bZ.field_75100_b = false;
        player.field_70159_w = 0.0;
        player.field_70181_x = 0.0;
        player.field_70179_y = 0.0;
        player.field_70747_aH = speed = ((Number)this.speedValue.get()).floatValue();
        if (MinecraftInstance.mc.getGameSettings().field_74314_A.func_151470_d()) {
            player.field_70181_x += (double)speed;
        }
        if (MinecraftInstance.mc.getGameSettings().field_74311_E.func_151470_d()) {
            player.field_70181_x -= (double)speed;
        }
    }
}

