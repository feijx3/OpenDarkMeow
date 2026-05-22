/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.flys.default;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.modules.movement.flys.FlyMode;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/flys/default/CreativeFly;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/flys/FlyMode;", "<init>", "()V", "onEnable", "", "onUpdate", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "onDisable", "DarkMeow"})
public final class CreativeFly
extends FlyMode {
    public CreativeFly() {
        super("Creative");
    }

    @Override
    public void onEnable() {
        block0: {
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null || (entityPlayerSP = entityPlayerSP.field_71075_bZ) == null) break block0;
            entityPlayerSP.field_75100_b = true;
        }
    }

    @Override
    public void onUpdate(@NotNull UpdateEvent event) {
        block0: {
            Intrinsics.checkNotNullParameter(event, "event");
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null || (entityPlayerSP = entityPlayerSP.field_71075_bZ) == null) break block0;
            entityPlayerSP.field_75100_b = true;
        }
    }

    @Override
    public void onDisable() {
        block0: {
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null || (entityPlayerSP = entityPlayerSP.field_71075_bZ) == null) break block0;
            entityPlayerSP.field_75100_b = false;
        }
    }
}

