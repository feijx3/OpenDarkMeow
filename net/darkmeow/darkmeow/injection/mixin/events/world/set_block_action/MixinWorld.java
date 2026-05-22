/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package net.darkmeow.darkmeow.injection.mixin.events.world.set_block_action;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.events.world.WorldSetBlockActionEvent;
import net.minecraft.block.Block;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={World.class})
public class MixinWorld {
    @Inject(method={"addBlockEvent"}, at={@At(value="HEAD")}, cancellable=true)
    public void addBlockEvent$callEvent(BlockPos pos, Block blockIn, int eventID, int eventParam, CallbackInfo ci2) {
        if (this instanceof WorldClient) {
            WorldClient world = (WorldClient)this;
            WorldSetBlockActionEvent event = new WorldSetBlockActionEvent(world, pos, blockIn, eventID, eventParam);
            DarkMeow.eventManager.callEvent(event);
            if (event.isCancelled()) {
                ci2.cancel();
            }
        }
    }
}

