/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 *  net.minecraft.world.GameType
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.misc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.world.GameType;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="AntiAdventure", category=ModuleCategory.MISC)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/AntiAdventure;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "onUpdateAllowTargets", "", "event", "Lnet/ccbluex/liquidbounce/event/events/input/MovementInputEvent$PRE;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nAntiAdventure.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AntiAdventure.kt\nnet/ccbluex/liquidbounce/features/module/modules/misc/AntiAdventure\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,21:1\n1#2:22\n*E\n"})
public final class AntiAdventure
extends Module {
    public AntiAdventure() {
        super(null, null, null, null, 15, null);
    }

    @EventTarget
    public final void onUpdateAllowTargets(@NotNull MovementInputEvent.PRE event) {
        PlayerControllerMP playerControllerMP;
        PlayerControllerMP playerControllerMP2;
        Intrinsics.checkNotNullParameter(event, "event");
        PlayerControllerMP it = playerControllerMP2 = MinecraftInstance.mc.getPlayerController();
        boolean bl2 = false;
        Object object = playerControllerMP = it.func_178889_l() == GameType.ADVENTURE ? playerControllerMP2 : null;
        if (playerControllerMP != null) {
            playerControllerMP.func_78746_a(GameType.SURVIVAL);
        }
    }
}

