/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.block;

import java.util.Objects;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.modules.combat.Criticals;
import net.ccbluex.liquidbounce.features.module.modules.exploit.GhostHand;
import net.ccbluex.liquidbounce.features.module.modules.player.NoFall;
import net.ccbluex.liquidbounce.features.module.modules.render.XRay;
import net.ccbluex.liquidbounce.features.module.modules.world.NoSlowBreak;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SideOnly(value=Side.CLIENT)
@Mixin(value={Block.class})
public abstract class MixinBlock {
    @Inject(method={"shouldSideBeRendered"}, at={@At(value="HEAD")}, cancellable=true)
    private void shouldSideBeRendered(CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        XRay xray = DarkMeow.moduleManager.getModule(XRay.class);
        if (Objects.requireNonNull(xray).getState()) {
            callbackInfoReturnable.setReturnValue(xray.getXrayBlocks().contains((Block)this));
        }
    }

    @Inject(method={"isCollidable"}, at={@At(value="HEAD")}, cancellable=true)
    private void isCollidable(CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        GhostHand ghostHand = DarkMeow.moduleManager.getModule(GhostHand.class);
        if (Objects.requireNonNull(ghostHand).getState() && (Integer)ghostHand.getBlockValue().get() != Block.func_149682_b((Block)((Block)this))) {
            callbackInfoReturnable.setReturnValue(false);
        }
    }

    @Inject(method={"getAmbientOcclusionLightValue"}, at={@At(value="HEAD")}, cancellable=true)
    private void getAmbientOcclusionLightValue(CallbackInfoReturnable<Float> floatCallbackInfoReturnable) {
        if (Objects.requireNonNull(DarkMeow.moduleManager.getModule(XRay.class)).getState()) {
            floatCallbackInfoReturnable.setReturnValue(Float.valueOf(1.0f));
        }
    }

    @Inject(method={"getPlayerRelativeBlockHardness"}, at={@At(value="RETURN")}, cancellable=true)
    public void modifyBreakSpeed(IBlockState state, EntityPlayer playerIn, World worldIn, BlockPos pos, CallbackInfoReturnable<Float> callbackInfo) {
        float f2 = callbackInfo.getReturnValue().floatValue();
        NoSlowBreak noSlowBreak = DarkMeow.moduleManager.getModule(NoSlowBreak.class);
        if (Objects.requireNonNull(noSlowBreak).getState()) {
            if (((Boolean)noSlowBreak.getWaterValue().get()).booleanValue() && playerIn.func_70055_a(Material.field_151586_h) && !EnchantmentHelper.func_185287_i((EntityLivingBase)playerIn)) {
                f2 *= 5.0f;
            }
            if (((Boolean)noSlowBreak.getAirValue().get()).booleanValue() && !playerIn.field_70122_E && !playerIn.func_70055_a(Material.field_151586_h)) {
                f2 *= 5.0f;
            }
        } else if (playerIn.field_70122_E) {
            NoFall noFall = DarkMeow.moduleManager.getModule(NoFall.class);
            Criticals criticals = DarkMeow.moduleManager.getModule(Criticals.class);
            if (Objects.requireNonNull(noFall).getState() && ((String)noFall.modeValue.get()).equalsIgnoreCase("NoGround") || Objects.requireNonNull(criticals).getState() && ((String)criticals.getModeValue().get()).equalsIgnoreCase("NoGround")) {
                f2 /= 5.0f;
            }
        }
        callbackInfo.setReturnValue(Float.valueOf(f2));
    }
}

