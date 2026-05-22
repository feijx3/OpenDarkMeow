/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockSlime
 *  net.minecraft.entity.Entity
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.block;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.events.player.move.BlockSlimeBounceEvent;
import net.minecraft.block.BlockSlime;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={BlockSlime.class})
public class MixinBlockSlime {
    @Inject(method={"onLanded"}, at={@At(value="HEAD")}, cancellable=true)
    private void onLanded$HEAD(World world, Entity entity, CallbackInfo ci2) {
        BlockSlimeBounceEvent event = new BlockSlimeBounceEvent();
        DarkMeow.eventManager.callEvent(event);
        if (event.isCancelled()) {
            ci2.cancel();
        }
    }
}

