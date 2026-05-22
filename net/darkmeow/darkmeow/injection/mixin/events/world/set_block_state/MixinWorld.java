/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package net.darkmeow.darkmeow.injection.mixin.events.world.set_block_state;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.events.world.WorldSetBlockStateEvent;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={World.class})
public class MixinWorld {
    @Inject(method={"setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/state/IBlockState;I)Z"}, at={@At(value="HEAD")}, cancellable=true)
    public void setBlockState$callEvent(BlockPos pos, IBlockState newState, int flags, CallbackInfoReturnable<Boolean> cir) {
        if (this instanceof WorldClient) {
            WorldClient world = (WorldClient)this;
            WorldSetBlockStateEvent event = new WorldSetBlockStateEvent(world, pos, newState, flags);
            DarkMeow.eventManager.callEvent(event);
            if (event.isCancelled()) {
                cir.setReturnValue(false);
                cir.cancel();
            }
        }
    }
}

