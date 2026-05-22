/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.MoverType
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.entity;

import java.util.Objects;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.events.player.control.UpdateRotationStateEvent;
import net.ccbluex.liquidbounce.features.module.modules.exploit.NoPitchLimit;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={Entity.class})
public abstract class MixinEntity {
    @Shadow
    public double field_70165_t;
    @Shadow
    public double field_70163_u;
    @Shadow
    public double field_70161_v;
    @Shadow
    public float field_70125_A;
    @Shadow
    public float field_70177_z;
    @Shadow
    public double field_70159_w;
    @Shadow
    public double field_70181_x;
    @Shadow
    public double field_70179_y;
    @Shadow
    public boolean field_70122_E;
    @Shadow
    public boolean field_70145_X;
    @Shadow
    public World field_70170_p;
    @Shadow
    protected boolean field_70134_J;
    @Shadow
    public float field_70130_N;
    @Shadow
    public float field_70127_C;
    @Shadow
    public float field_70126_B;
    @Shadow
    public float field_70143_R;

    @Shadow
    public abstract boolean func_70051_ag();

    @Shadow
    public abstract AxisAlignedBB func_174813_aQ();

    @Shadow
    public abstract void func_174826_a(AxisAlignedBB var1);

    @Shadow
    public void func_70091_d(MoverType p_move_1_, double p_move_2_, double p_move_4_, double p_move_4_2) {
    }

    @Shadow
    public abstract boolean func_70090_H();

    @Shadow
    protected abstract Vec3d func_174806_f(float var1, float var2);

    @Shadow
    public abstract boolean func_70093_af();

    @Inject(method={"turn"}, at={@At(value="HEAD")}, cancellable=true)
    private void setAngles(float yaw, float pitch, CallbackInfo ci2) {
        Entity entity = (Entity)this;
        if (entity == MinecraftInstance.mc_nowarp.field_71439_g) {
            UpdateRotationStateEvent event = new UpdateRotationStateEvent((EntityPlayerSP)entity, yaw, pitch);
            DarkMeow.eventManager.callEvent(event);
            if (event.isCancelled()) {
                ci2.cancel();
            }
        }
        if (Objects.requireNonNull(DarkMeow.moduleManager.getModule(NoPitchLimit.class)).getState()) {
            ci2.cancel();
            float f2 = this.field_70125_A;
            float f1 = this.field_70177_z;
            this.field_70177_z = (float)((double)this.field_70177_z + (double)yaw * 0.15);
            this.field_70125_A = (float)((double)this.field_70125_A - (double)pitch * 0.15);
            this.field_70127_C += this.field_70125_A - f2;
            this.field_70126_B += this.field_70177_z - f1;
        }
    }

    @Redirect(method={"move"}, at=@At(value="INVOKE", target="Lnet/minecraft/entity/Entity;isSneaking()Z"))
    private boolean redirectIsSneaking(Entity entity) {
        if (entity instanceof EntityPlayerSP && entity.field_70122_E) {
            return DarkMeow.movementManager.isSafeWalk() || entity.func_70093_af();
        }
        return entity.func_70093_af();
    }
}

