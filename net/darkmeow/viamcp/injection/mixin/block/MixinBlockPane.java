/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockPane
 *  net.minecraft.block.properties.IProperty
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.IBlockAccess
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.viamcp.injection.mixin.block;

import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import de.florianmichael.vialoadingbase.ViaLoadingBase;
import net.minecraft.block.BlockPane;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SideOnly(value=Side.CLIENT)
@Mixin(value={BlockPane.class})
public class MixinBlockPane {
    @Unique
    public boolean viaMCP$isDefaultState(IBlockState state) {
        return (Boolean)state.func_177229_b((IProperty)BlockPane.field_176241_b) == false && (Boolean)state.func_177229_b((IProperty)BlockPane.field_176243_N) == false && (Boolean)state.func_177229_b((IProperty)BlockPane.field_176242_M) == false && (Boolean)state.func_177229_b((IProperty)BlockPane.field_176244_O) == false;
    }

    @Unique
    public IBlockState viaMCP$setDefaultState(IBlockState state) {
        return state.func_177226_a((IProperty)BlockPane.field_176241_b, (Comparable)Boolean.valueOf(true)).func_177226_a((IProperty)BlockPane.field_176243_N, (Comparable)Boolean.valueOf(true)).func_177226_a((IProperty)BlockPane.field_176242_M, (Comparable)Boolean.valueOf(true)).func_177226_a((IProperty)BlockPane.field_176244_O, (Comparable)Boolean.valueOf(true));
    }

    @Inject(method={"getActualState"}, at={@At(value="RETURN")}, cancellable=true)
    public void getActualState$RETURN(IBlockState state, IBlockAccess worldIn, BlockPos pos, CallbackInfoReturnable<IBlockState> cir) {
        if (ViaLoadingBase.getInstance().getTargetVersion().newerThanOrEqualTo(ProtocolVersion.v1_9)) {
            return;
        }
        IBlockState currentState = cir.getReturnValue();
        if (this.viaMCP$isDefaultState(currentState)) {
            cir.setReturnValue(this.viaMCP$setDefaultState(currentState));
        }
    }
}

