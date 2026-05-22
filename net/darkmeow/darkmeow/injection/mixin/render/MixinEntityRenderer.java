/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.EntityRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.math.Vec3d
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.render;

import java.util.List;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.Render3DEvent;
import net.ccbluex.liquidbounce.event.events.player.control.UpdateMouseOverEvent;
import net.ccbluex.liquidbounce.event.events.render.RenderCameraEvent;
import net.ccbluex.liquidbounce.features.module.modules.render.NoHurtCam;
import net.ccbluex.liquidbounce.handler.rotation.RotationManagerStatic;
import net.darkmeow.darkmeow.utils.movement.RayCastUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={EntityRenderer.class}, priority=100)
public abstract class MixinEntityRenderer {
    @Final
    @Shadow
    private Minecraft field_78531_r;
    @Unique
    private boolean darkMeow$camera$noClip = false;
    @Unique
    public UpdateMouseOverEvent.PRE darkMeow$updateMouseOverEvent;

    @Inject(method={"renderWorldPass"}, at={@At(value="FIELD", target="Lnet/minecraft/client/renderer/EntityRenderer;renderHand:Z", shift=At.Shift.BEFORE)})
    private void renderWorldPass(int pass, float partialTicks, long finishTimeNano, CallbackInfo callbackInfo) {
        DarkMeow.eventManager.callEvent(new Render3DEvent(partialTicks));
        GlStateManager.func_179098_w();
    }

    @Inject(method={"hurtCameraEffect"}, at={@At(value="HEAD")}, cancellable=true)
    private void injectHurtCameraEffect(CallbackInfo callbackInfo) {
        if (DarkMeow.moduleManager.getModule(NoHurtCam.class).getState()) {
            callbackInfo.cancel();
        }
    }

    @Redirect(method={"orientCamera"}, at=@At(value="FIELD", target="Lnet/minecraft/client/renderer/EntityRenderer;thirdPersonDistancePrev:F", ordinal=0))
    private float orientCamera$FILED$cameraTweaks(EntityRenderer instance, float partialTicks) {
        RenderCameraEvent event = new RenderCameraEvent(partialTicks, 4.0f, false, this.field_78531_r.field_71474_y.field_74320_O);
        DarkMeow.eventManager.callEvent(event);
        this.darkMeow$camera$noClip = event.getNoClip();
        return event.getDistance();
    }

    @Redirect(method={"orientCamera"}, at=@At(value="INVOKE", target="Lnet/minecraft/util/math/Vec3d;distanceTo(Lnet/minecraft/util/math/Vec3d;)D", ordinal=0))
    private double orientCamera$INVOKE$cameraTweaks(Vec3d instance, Vec3d vec) {
        return this.darkMeow$camera$noClip ? 999.9 : instance.func_72438_d(vec);
    }

    @Inject(method={"getMouseOver(F)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void getMouseOver$callEvent(float partialTicks, CallbackInfo ci2) {
        Entity currentEntity = this.field_78531_r.func_175606_aa();
        if (currentEntity != null) {
            UpdateMouseOverEvent.PRE event = new UpdateMouseOverEvent.PRE(partialTicks, currentEntity, this.field_78531_r.field_71442_b);
            DarkMeow.eventManager.callEvent(event);
            this.darkMeow$updateMouseOverEvent = event;
            if (event.hasChanged()) {
                List<RayTraceResult> results = RayCastUtils.rayCastEntities(event.getCurrentEntity(), event.getEntityRange(), 1.0f, event.getEntityThroughWall(), event.getEntityNoRiding(), event.getLookVec());
                this.field_78531_r.field_71476_x = results.isEmpty() ? RayCastUtils.rayTraceBlock(event.getCurrentEntity(), event.getBlockRange(), partialTicks) : results.get(0);
                this.getMouseOver$callEventPost(partialTicks, ci2);
                ci2.cancel();
            }
        } else {
            ci2.cancel();
        }
    }

    @Inject(method={"getMouseOver(F)V"}, at={@At(value="INVOKE", target="Lnet/minecraft/profiler/Profiler;endSection()V")})
    private void getMouseOver$callEventPost(float partialTicks, CallbackInfo ci2) {
        boolean shouldOverrideToMiss = false;
        if (this.field_78531_r.field_71476_x != null) {
            if (this.darkMeow$updateMouseOverEvent.getNoEntityInteract() && this.field_78531_r.field_71476_x.field_72313_a == RayTraceResult.Type.ENTITY) {
                shouldOverrideToMiss = true;
            }
            if (this.darkMeow$updateMouseOverEvent.getNoBlockInteract() && this.field_78531_r.field_71476_x.field_72313_a == RayTraceResult.Type.BLOCK) {
                shouldOverrideToMiss = true;
            }
        } else {
            shouldOverrideToMiss = true;
        }
        if (shouldOverrideToMiss) {
            this.field_78531_r.field_71476_x = RotationManagerStatic.RAT_TRACE_MISS;
        }
        UpdateMouseOverEvent.POST event = new UpdateMouseOverEvent.POST(this.field_78531_r.field_71476_x, this.darkMeow$updateMouseOverEvent.getCurrentEntity(), partialTicks, this.darkMeow$updateMouseOverEvent.getLookVec());
        DarkMeow.eventManager.callEvent(event);
        if (event.isChanged()) {
            this.field_78531_r.field_71476_x = (RayTraceResult)event.getReturnValue();
        }
    }
}

