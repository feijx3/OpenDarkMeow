/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.client;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.features.module.modules.client.HUD;
import net.ccbluex.liquidbounce.features.module.modules.combat.KillAura;
import net.ccbluex.liquidbounce.features.module.modules.exploit.KeepContainer;
import net.ccbluex.liquidbounce.features.module.modules.exploit.Kick;
import net.ccbluex.liquidbounce.features.module.modules.exploit.ServerCrasher;
import net.ccbluex.liquidbounce.features.module.modules.exploit.TimeBalancer;
import net.ccbluex.liquidbounce.features.module.modules.movement.Fly;
import net.ccbluex.liquidbounce.features.module.modules.movement.InBlock;
import net.ccbluex.liquidbounce.features.module.modules.movement.Speed;
import net.ccbluex.liquidbounce.features.module.modules.movement.Step;
import net.ccbluex.liquidbounce.features.module.modules.network.PingSpoof;
import net.ccbluex.liquidbounce.features.module.modules.player.InvManager;
import net.ccbluex.liquidbounce.features.module.modules.player.Reach;
import net.ccbluex.liquidbounce.features.module.modules.player.Stuck;
import net.ccbluex.liquidbounce.features.module.modules.render.FreeCam;
import net.ccbluex.liquidbounce.features.module.modules.world.ContainerAura;
import net.ccbluex.liquidbounce.features.module.modules.world.ContainerStealer;
import net.ccbluex.liquidbounce.features.module.modules.world.Scaffold;
import net.ccbluex.liquidbounce.features.module.modules.world.Timer;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="JoinToggleOff", description="\u8fdb\u5165\u670d\u52a1\u5668\u81ea\u52a8\u5173\u95ed\u67d0\u4e9b\u529f\u80fd \u907f\u514d\u5361\u4f4f", category=ModuleCategory.CLIENT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/JoinToggleOff;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "killAuraValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "invManagerValue", "containerStealerValue", "containerAuraValue", "keepContainerValue", "flyValue", "speedValue", "stepValue", "pingSpoofValue", "serverCrasherValue", "scaffoldValue", "timerValue", "timeBalancerValue", "freeCamValue", "stuckValue", "reachValue", "inBlockValue", "hudValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "bindKickNoneValue", "onWorld", "", "worldEvent", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "DarkMeow"})
public final class JoinToggleOff
extends Module {
    @NotNull
    private final BoolValue killAuraValue = new BoolValue("KillAura", false);
    @NotNull
    private final BoolValue invManagerValue = new BoolValue("InvManager", false);
    @NotNull
    private final BoolValue containerStealerValue = new BoolValue("ContainerStealer", false);
    @NotNull
    private final BoolValue containerAuraValue = new BoolValue("ContainerAura", false);
    @NotNull
    private final BoolValue keepContainerValue = new BoolValue("KeepContainer", false);
    @NotNull
    private final BoolValue flyValue = new BoolValue("Fly", false);
    @NotNull
    private final BoolValue speedValue = new BoolValue("Speed", false);
    @NotNull
    private final BoolValue stepValue = new BoolValue("Step", false);
    @NotNull
    private final BoolValue pingSpoofValue = new BoolValue("PingSpoof", false);
    @NotNull
    private final BoolValue serverCrasherValue = new BoolValue("ServerCrasher", false);
    @NotNull
    private final BoolValue scaffoldValue = new BoolValue("Scaffold", false);
    @NotNull
    private final BoolValue timerValue = new BoolValue("Timer", false);
    @NotNull
    private final BoolValue timeBalancerValue = new BoolValue("TimeBalancer", false);
    @NotNull
    private final BoolValue freeCamValue = new BoolValue("FreeCam", false);
    @NotNull
    private final BoolValue stuckValue = new BoolValue("Stuck", false);
    @NotNull
    private final BoolValue reachValue = new BoolValue("Reach", false);
    @NotNull
    private final BoolValue inBlockValue = new BoolValue("InBlock", false);
    @NotNull
    private final ListValue hudValue;
    @NotNull
    private final BoolValue bindKickNoneValue;

    public JoinToggleOff() {
        super(null, null, null, null, 15, null);
        String[] stringArray = new String[]{"None", "Hidden", "Display"};
        this.hudValue = new ListValue("Hud", stringArray, "None");
        this.bindKickNoneValue = new BoolValue("BindKickNone", false);
    }

    @EventTarget
    public final void onWorld(@NotNull WorldEvent worldEvent) {
        Intrinsics.checkNotNullParameter(worldEvent, "worldEvent");
        if (((Boolean)this.killAuraValue.get()).booleanValue()) {
            KillAura killAura = DarkMeow.INSTANCE.getModuleManager().get(KillAura.class);
            Intrinsics.checkNotNull(killAura);
            killAura.setState(false);
        }
        if (((Boolean)this.invManagerValue.get()).booleanValue()) {
            InvManager invManager = DarkMeow.INSTANCE.getModuleManager().get(InvManager.class);
            Intrinsics.checkNotNull(invManager);
            invManager.setState(false);
        }
        if (((Boolean)this.containerStealerValue.get()).booleanValue()) {
            ContainerStealer containerStealer = DarkMeow.INSTANCE.getModuleManager().get(ContainerStealer.class);
            Intrinsics.checkNotNull(containerStealer);
            containerStealer.setState(false);
        }
        if (((Boolean)this.containerAuraValue.get()).booleanValue()) {
            ContainerAura containerAura = DarkMeow.INSTANCE.getModuleManager().get(ContainerAura.class);
            Intrinsics.checkNotNull(containerAura);
            containerAura.setState(false);
        }
        if (((Boolean)this.flyValue.get()).booleanValue()) {
            Fly fly = DarkMeow.INSTANCE.getModuleManager().get(Fly.class);
            Intrinsics.checkNotNull(fly);
            fly.setState(false);
        }
        if (((Boolean)this.speedValue.get()).booleanValue()) {
            Speed speed = DarkMeow.INSTANCE.getModuleManager().get(Speed.class);
            Intrinsics.checkNotNull(speed);
            speed.setState(false);
        }
        if (((Boolean)this.stepValue.get()).booleanValue()) {
            Step step = DarkMeow.INSTANCE.getModuleManager().get(Step.class);
            Intrinsics.checkNotNull(step);
            step.setState(false);
        }
        if (((Boolean)this.pingSpoofValue.get()).booleanValue()) {
            PingSpoof pingSpoof = DarkMeow.INSTANCE.getModuleManager().get(PingSpoof.class);
            Intrinsics.checkNotNull(pingSpoof);
            pingSpoof.setState(false);
        }
        if (((Boolean)this.serverCrasherValue.get()).booleanValue()) {
            ServerCrasher serverCrasher = DarkMeow.INSTANCE.getModuleManager().get(ServerCrasher.class);
            Intrinsics.checkNotNull(serverCrasher);
            serverCrasher.setState(false);
        }
        if (((Boolean)this.scaffoldValue.get()).booleanValue()) {
            Scaffold scaffold = DarkMeow.INSTANCE.getModuleManager().get(Scaffold.class);
            Intrinsics.checkNotNull(scaffold);
            scaffold.setState(false);
        }
        if (((Boolean)this.timerValue.get()).booleanValue()) {
            Timer timer = DarkMeow.INSTANCE.getModuleManager().get(Timer.class);
            Intrinsics.checkNotNull(timer);
            timer.setState(false);
        }
        if (((Boolean)this.timeBalancerValue.get()).booleanValue()) {
            TimeBalancer timeBalancer = DarkMeow.INSTANCE.getModuleManager().get(TimeBalancer.class);
            Intrinsics.checkNotNull(timeBalancer);
            timeBalancer.setState(false);
        }
        if (((Boolean)this.freeCamValue.get()).booleanValue()) {
            FreeCam freeCam = DarkMeow.INSTANCE.getModuleManager().get(FreeCam.class);
            Intrinsics.checkNotNull(freeCam);
            freeCam.setState(false);
        }
        if (((Boolean)this.stuckValue.get()).booleanValue()) {
            Stuck stuck = DarkMeow.INSTANCE.getModuleManager().get(Stuck.class);
            Intrinsics.checkNotNull(stuck);
            stuck.setState(false);
        }
        if (((Boolean)this.reachValue.get()).booleanValue()) {
            Reach reach = DarkMeow.INSTANCE.getModuleManager().get(Reach.class);
            Intrinsics.checkNotNull(reach);
            reach.setState(false);
        }
        if (((Boolean)this.keepContainerValue.get()).booleanValue()) {
            KeepContainer keepContainer = DarkMeow.INSTANCE.getModuleManager().get(KeepContainer.class);
            Intrinsics.checkNotNull(keepContainer);
            keepContainer.setState(false);
        }
        if (((Boolean)this.inBlockValue.get()).booleanValue()) {
            InBlock inBlock = DarkMeow.INSTANCE.getModuleManager().get(InBlock.class);
            Intrinsics.checkNotNull(inBlock);
            inBlock.setState(false);
        }
        if (!Intrinsics.areEqual(this.hudValue.get(), "None")) {
            HUD hUD = DarkMeow.INSTANCE.getModuleManager().get(HUD.class);
            Intrinsics.checkNotNull(hUD);
            hUD.setState(Intrinsics.areEqual(this.hudValue.get(), "Display"));
        }
        if (((Boolean)this.bindKickNoneValue.get()).booleanValue()) {
            Kick kick = DarkMeow.INSTANCE.getModuleManager().get(Kick.class);
            Intrinsics.checkNotNull(kick);
            if (kick.getKeyBind() != 0) {
                Kick kick2 = DarkMeow.INSTANCE.getModuleManager().get(Kick.class);
                Intrinsics.checkNotNull(kick2);
                kick2.setKeyBind(0);
            }
        }
    }
}

