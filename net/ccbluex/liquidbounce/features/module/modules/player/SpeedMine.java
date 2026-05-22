/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.player;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.extend.ExtendPlayerControllerMP;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ModuleInfo(name="SpeedMine", description="", category=ModuleCategory.PLAYER)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/SpeedMine;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "buff", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "buffLevel", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "blockPos", "Lnet/minecraft/util/math/BlockPos;", "getBlockPos", "()Lnet/minecraft/util/math/BlockPos;", "setBlockPos", "(Lnet/minecraft/util/math/BlockPos;)V", "breakDamage", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "delay", "seconds", "", "minutes", "time", "onDisable", "", "onUpdate", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nSpeedMine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpeedMine.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/SpeedMine\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,43:1\n1#2:44\n*E\n"})
public final class SpeedMine
extends Module {
    @NotNull
    private final BoolValue buff = new BoolValue("Buff", false);
    @NotNull
    private final IntegerValue buffLevel = new IntegerValue("BuffLevel", 3, 1, 10);
    @Nullable
    private BlockPos blockPos;
    @NotNull
    private final FloatValue breakDamage = new FloatValue("DamageSpeed", 0.8f, 0.1f, 1.0f);
    @NotNull
    private final BoolValue delay = new BoolValue("RemoveBreakDelay", false);
    private final int seconds;
    private final int minutes;
    private final int time = (this.minutes * 60 + this.seconds) * 20;

    public SpeedMine() {
        super(null, null, null, null, 15, null);
        this.seconds = 520;
        this.minutes = 1314;
    }

    @Nullable
    public final BlockPos getBlockPos() {
        return this.blockPos;
    }

    public final void setBlockPos(@Nullable BlockPos blockPos) {
        this.blockPos = blockPos;
    }

    @Override
    public void onDisable() {
        block1: {
            Potion potion = Potion.func_188412_a((int)3);
            if (potion == null) break block1;
            Potion it = potion;
            boolean bl2 = false;
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP != null) {
                entityPlayerSP.func_184589_d(it);
            }
        }
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        block4: {
            EntityPlayerSP player;
            block3: {
                Intrinsics.checkNotNullParameter(event, "event");
                EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
                if (entityPlayerSP == null) {
                    return;
                }
                player = entityPlayerSP;
                if (((Boolean)this.delay.get()).booleanValue()) {
                    ExtendPlayerControllerMP.INSTANCE.setBlockHitDelay(MinecraftInstance.mc.getPlayerController(), 0);
                }
                if (ExtendPlayerControllerMP.INSTANCE.getCurBlockDamageMP(MinecraftInstance.mc.getPlayerController()) > ((Number)this.breakDamage.get()).floatValue()) {
                    ExtendPlayerControllerMP.INSTANCE.setCurBlockDamageMP(MinecraftInstance.mc.getPlayerController(), 1.0f);
                }
                if (!((Boolean)this.buff.get()).booleanValue()) break block3;
                Potion potion = Potion.func_188412_a((int)3);
                if (potion == null) break block4;
                Potion it = potion;
                boolean bl2 = false;
                it = new PotionEffect(it, this.time, ((Number)this.buffLevel.get()).intValue() - 1, false, false);
                boolean bl3 = false;
                player.func_70690_d((PotionEffect)it);
                break block4;
            }
            Potion potion = Potion.func_188412_a((int)3);
            if (potion == null) break block4;
            Potion it = potion;
            boolean bl4 = false;
            player.func_184589_d(it);
        }
    }
}

