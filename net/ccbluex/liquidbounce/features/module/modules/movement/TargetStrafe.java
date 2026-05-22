/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.features.module.modules.combat.KillAura;
import net.ccbluex.liquidbounce.features.module.modules.movement.ElytraFly;
import net.ccbluex.liquidbounce.features.module.modules.movement.Fly;
import net.ccbluex.liquidbounce.features.module.modules.player.GApple;
import net.ccbluex.liquidbounce.features.module.modules.player.Stuck;
import net.ccbluex.liquidbounce.features.module.modules.world.Scaffold;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="TargetStrafe", description="", category=ModuleCategory.MOVEMENT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/TargetStrafe;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "movementInputStrafeModeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "switchViewValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "originalView", "", "onMovementInputPre", "", "event", "Lnet/ccbluex/liquidbounce/event/events/input/MovementInputEvent$PRE;", "onDisable", "DarkMeow"})
public final class TargetStrafe
extends Module {
    @NotNull
    private final ListValue movementInputStrafeModeValue;
    @NotNull
    private final BoolValue switchViewValue;
    private int originalView;

    public TargetStrafe() {
        super(null, null, null, null, 15, null);
        String[] stringArray = new String[]{"None", "Left", "Right"};
        this.movementInputStrafeModeValue = new ListValue("MovementInputStrafeMode", stringArray, "None");
        this.switchViewValue = new BoolValue("SwitchThirdViewOnTarget", true);
        this.originalView = -1;
    }

    @EventTarget(priority=0)
    public final void onMovementInputPre(@NotNull MovementInputEvent.PRE event) {
        block17: {
            block16: {
                Intrinsics.checkNotNullParameter(event, "event");
                Scaffold scaffold = DarkMeow.INSTANCE.getModuleManager().getModule(Scaffold.class);
                Boolean bl2 = scaffold != null ? Boolean.valueOf(scaffold.getState()) : null;
                Intrinsics.checkNotNull(bl2);
                if (bl2.booleanValue()) break block16;
                GApple gApple = DarkMeow.INSTANCE.getModuleManager().getModule(GApple.class);
                Boolean bl3 = gApple != null ? Boolean.valueOf(gApple.getState()) : null;
                Intrinsics.checkNotNull(bl3);
                if (bl3.booleanValue()) break block16;
                Stuck stuck = DarkMeow.INSTANCE.getModuleManager().getModule(Stuck.class);
                Boolean bl4 = stuck != null ? Boolean.valueOf(stuck.getState()) : null;
                Intrinsics.checkNotNull(bl4);
                if (bl4.booleanValue()) break block16;
                Fly fly = DarkMeow.INSTANCE.getModuleManager().getModule(Fly.class);
                Boolean bl5 = fly != null ? Boolean.valueOf(fly.getState()) : null;
                Intrinsics.checkNotNull(bl5);
                if (bl5.booleanValue()) break block16;
                ElytraFly elytraFly = DarkMeow.INSTANCE.getModuleManager().getModule(ElytraFly.class);
                Boolean bl6 = elytraFly != null ? Boolean.valueOf(elytraFly.getState()) : null;
                Intrinsics.checkNotNull(bl6);
                if (!bl6.booleanValue()) break block17;
            }
            return;
        }
        KillAura killAura = DarkMeow.INSTANCE.getModuleManager().get(KillAura.class);
        if (killAura == null) {
            return;
        }
        KillAura killAura2 = killAura;
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        if (killAura2.getState() && !((Collection)killAura2.getTargetManager().getTargets()).isEmpty()) {
            if (((Boolean)this.switchViewValue.get()).booleanValue()) {
                if (this.originalView == -1) {
                    this.originalView = MinecraftInstance.mc.getGameSettings().field_74320_O;
                }
                MinecraftInstance.mc.getGameSettings().field_74320_O = 1;
            }
            EntityLivingBase entityLivingBase = killAura2.getTargetManager().getPrevTarget();
            Intrinsics.checkNotNull(entityLivingBase);
            if ((double)player.func_70032_d((Entity)entityLivingBase) < 1.5) {
                if (!MinecraftInstance.mc.getGameSettings().field_74368_y.func_151468_f()) {
                    event.setKeyStateForward(true);
                }
                event.setKeyStateJump(true);
                String string = (String)this.movementInputStrafeModeValue.get();
                if (Intrinsics.areEqual(string, "Left")) {
                    event.setKeyStateLeft(true);
                } else if (Intrinsics.areEqual(string, "Right")) {
                    event.setKeyStateRight(true);
                }
            }
        } else if (this.originalView != -1) {
            MinecraftInstance.mc.getGameSettings().field_74320_O = this.originalView;
            this.originalView = -1;
        }
    }

    @Override
    public void onDisable() {
        if (this.originalView != -1) {
            MinecraftInstance.mc.getGameSettings().field_74320_O = this.originalView;
            this.originalView = -1;
        }
    }
}

