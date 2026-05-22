/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockFarmland
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package net.darkmeow.darkmeow.injection.mixin.module.farmland_fix;

import net.ccbluex.liquidbounce.features.module.modules.misc.FarmlandFix;
import net.minecraft.block.BlockFarmland;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={BlockFarmland.class})
public class MixinBlockFarmland {
    @Inject(method={"turnToDirt"}, at={@At(value="HEAD")}, cancellable=true)
    private static void turnToDirt(World world, BlockPos pos, CallbackInfo ci2) {
        if (world.field_72995_K && FarmlandFix.INSTANCE.getState()) {
            ci2.cancel();
        }
    }
}

