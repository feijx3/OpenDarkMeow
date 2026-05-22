/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.world;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.modules.render.TrueSight;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@SideOnly(value=Side.CLIENT)
@Mixin(value={WorldClient.class})
public class MixinWorldClient {
    @ModifyVariable(method={"showBarrierParticles"}, at=@At(value="INVOKE", target="Lnet/minecraft/block/Block;randomDisplayTick(Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Ljava/util/Random;)V", shift=At.Shift.AFTER), ordinal=0)
    private boolean handleBarriers(boolean flag) {
        TrueSight trueSight = DarkMeow.moduleManager.getModule(TrueSight.class);
        return flag || trueSight.getState() && (Boolean)trueSight.getBarriersValue().get() != false;
    }
}

