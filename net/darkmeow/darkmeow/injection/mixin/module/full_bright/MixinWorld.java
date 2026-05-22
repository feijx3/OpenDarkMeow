/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.EnumSkyBlock
 *  net.minecraft.world.World
 */
package net.darkmeow.darkmeow.injection.mixin.module.full_bright;

import net.ccbluex.liquidbounce.features.module.modules.render.FullBright;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={World.class})
public class MixinWorld {
    @Inject(method={"checkLightFor"}, at={@At(value="HEAD")}, cancellable=true)
    public void checkLightFor(EnumSkyBlock lightType, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (FullBright.INSTANCE.getState() && this.darkMeow$isClientWorld()) {
            cir.setReturnValue(false);
        }
    }

    @Unique
    public boolean darkMeow$isClientWorld() {
        return Minecraft.func_71410_x().field_71441_e == this;
    }
}

